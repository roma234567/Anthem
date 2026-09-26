# ANTITHESIS KNOWLEDGE BASE
*Detailed Technical Compendium for Agents modifying Wyvern (Minecraft 1.21.4).*

## 1. Project Specifications & Environment
- **Minecraft Version:** `1.21.4`
- **Mappings / Environment:** Yarn `1.21.4+build.8` (Named mappings).
- **Toolchain:** Fabric Loader `0.16.10`, Fabric API `0.119.3+1.21.4`, Java 21, Gradle 8.14.1.
- **Client Base:** Fold Craft Launcher (FCL) / PojavLauncher compatible (Android execution environment constraints apply).

### 1.1 Mobile Compatibility (FCL/Pojav) Constraints
Agents modifying this project MUST adhere to mobile environment restrictions:
- **No Native Desktop Libraries:** Discord IPC (RPC) and JNA libraries must be completely bypassed or disabled (`DiscordManager.java`).
- **No Process Execution:** Commands invoking `explorer.exe` or desktop shell commands will crash the JVM on Android.
- **Rendering Limitations:** Framebuffer Objects (FBOs) and complex GLSL shaders (e.g., Kawase Blur, Drop Shadows) cause severe lag or `GL_FRAMEBUFFER_INCOMPLETE` crashes on VirGL/GL4ES renderers. AWT `BufferedImage` manipulation is extremely slow. UI rendering must fall back to basic primitives (`DrawContext.fill()`, `Render2DUtil.drawRect()`).
- **Keybinds:** Mobile clients use virtual on-screen controllers. Code relying strictly on `GLFW` integer keycodes without GUI abstractions might be unreachable unless a user binds it. 

---

## 2. Core Architecture

### 2.1 Module System (`wtf.wyvern.base.modules.ModuleManager`)
- Modules inherit from `wtf.wyvern.client.modules.api.Module`.
- **Registration:** Modules are manually added in `ModuleManager` constructor via `registerModule(MyModule.INSTANCE);`.
- **Annotations:** Every module requires `@ModuleAnnotation(name = "...", category = Category.COMBAT, description = "...")`.
- **Lifecycle:** Override `onEnable()` and `onDisable()`. **CRITICAL:** You must call `super.onEnable()` and `super.onDisable()`, otherwise EventBus subscriptions and setting persistence will break.
- **Categories:** `COMBAT`, `MOVEMENT`, `RENDER`, `PLAYER`, `MISC`, `THEMES`.

### 2.2 Event System (`com.darkmagician6.eventapi`)
- Uses `@EventTarget` method annotations.
- Synchronous exact-class dispatch. Handlers do not receive events of subclasses.
- **Common Events:**
  - `EventTick`: Fired every client tick. Best for logic.
  - `EventUpdate`: Local player update tick.
  - `EventMoveInput`: Used for manipulating WASD/Jump states before movement vectors are calculated.
  - `EventPacket`: Cancellable. Use `event.isSent()` for C2S (outgoing) and `event.isReceive()` for S2C (incoming).

### 2.3 Settings System (`wtf.wyvern.client.modules.api.setting.impl.*`)
Settings are dynamically bound via Java Reflection in the `Module` constructor. If you declare a setting as a field, it automatically appears in the ClickGUI.
- `BooleanSetting(String name, boolean default)`
- `NumberSetting(String name, float default, float min, float max, float step)`
- `ModeSetting(String name, String... modes)` (Accessed via `mode.is("ModeName")`)
- All settings support an optional `Supplier<Boolean> visibility` lambda as the last argument to hide/show them dynamically.

---

## 3. Network Protocol & Packet Manipulation (Yarn 1.21.4)

### 3.1 Movement Packets (`PlayerMoveC2SPacket`)
In 1.21.4, movement packets have strict structural requirements:
- **5 Arguments Required:** Constructors for movement packets now require the `horizontalCollision` flag as the final argument. 
  - *Example:* `new PlayerMoveC2SPacket.PositionAndOnGround(x, y, z, onGround, mc.player.horizontalCollision)`
  - *Example:* `new PlayerMoveC2SPacket.Full(x, y, z, yaw, pitch, onGround, mc.player.horizontalCollision)`
- Sending invalid or incomplete movement packets will instantly kick the player (Invalid Packet data).

### 3.2 Interaction Packets
- **Attacking:** `PlayerInteractEntityC2SPacket` (Requires entity network ID, interaction type ATTACK, and sneaking state).
- **Swinging:** `HandSwingC2SPacket(Hand.MAIN_HAND)`.
- **Using Items/Blocks:** `PlayerInteractItemC2SPacket`, `PlayerInteractBlockC2SPacket`.

### 3.3 Status & Damage Packets
- Avoid `EntityDamageS2CPacket`. It is prone to mapping conflicts and obfuscation errors in 1.21.4.
- Use `EntityStatusS2CPacket`:
  - `status == 2` -> Entity Hurt (Damage animation).
  - `status == 3` -> Entity Dead.
  - `status == 35` -> Totem Pop.

### 3.4 Inventory Manipulation (`InventoryUtil`)
- Client-side slots (`mc.player.getInventory().selectedSlot`) differ from Network Sync slots (`mc.player.playerScreenHandler.syncId`).
- Use `InventoryUtil.indexToSlot(int index)` to convert hotbar/inventory indices to network protocol slots.
- For 1-tick swaps, use `SlotActionType.SWAP` targeting button `40` (the offhand slot). Do not use manual Pickup/Place cycles if speed is required.

---

## 4. Specific Module Implementations & Bypasses

### 4.1 TriggerBot (`wtf.wyvern.client.modules.impl.combat.TriggerBot`)
- **Cooldown Jitter:** Varies attack timing between 95% and 100% cooldown completion to bypass constant timing checks (Vulcan, Matrix).
- **Fake Misses:** 10% chance to send `HandSwingC2SPacket` without hitting an entity to bypass 100% Accuracy checks.
- **Strict Raycast:** Simulates server-side line-of-sight using `mc.world.raycast(RaycastContext)`. Cancels the attack if the ray hits a block (fixes GrimAC reach/hitbox flags during ping desync).

### 4.2 AutoTotem (`wtf.wyvern.client.modules.impl.combat.AutoTotem`)
- **Predictive Mode:** Scans for `EndCrystalEntity` within 12 blocks. Calculates explosion damage mathematically. If `currentHealth - predictedDamage <= 2.0`, it swaps the totem *before* the explosion packet is processed.
- **No Fake Slots:** Uses strictly legitimate `ClickSlotC2SPacket` sequences.

### 4.3 TargetStrafe (`wtf.wyvern.client.modules.impl.movement.TargetStrafe`)
- **Vector Fix:** Manipulates `EventMoveInput` (WASD simulation) rather than velocity vectors.
- **Camera Independence:** Uses `MovingUtil.fixMovementFocus(event, targetYaw)` to map virtual inputs (W/A/S/D) correctly to the world space based on the target's position, regardless of where the client camera is pointing.
- **Void Check:** Reads blocks 3 meters below the player to reverse strafe direction and avoid falling off ledges.

### 4.4 PearlPhase (`wtf.wyvern.client.modules.impl.movement.PearlPhase`)
- **Rage Mode (Chain Pearling):** Detects if the player's bounding box intersects solid blocks. If inside a block:
  - Enables `mc.player.noClip = true` locally to prevent screen jitter.
  - Cancels normal movement packets.
  - Sends `PositionAndOnGround` with a Y-offset of `+0.0001` (1E-4). This forces the server to recalculate gravity rather than pushing the player out (Anti-Suffocation Bypass).
  - Automatically throws another ender pearl on cooldown expiration to burrow through thick walls.

### 4.5 HitboxDesync (`wtf.wyvern.client.modules.impl.player.HitboxDesync`)
- **Micro Mode:** Modifies outgoing movement packets by adding an alternating ±0.03 offset to X and Z coordinates. The server registers the player as rapidly shifting back and forth, breaking enemy strict-raycast AimBots.
- **MagicPitch Mode:** Overrides outgoing packet pitch to `180.0F` (Upside down). Breaks rendering and raycast logic of primitive client-side Auras without affecting local movement.

### 4.6 FakeLag (`wtf.wyvern.client.modules.impl.movement.FakeLag`)
- **TickShift / Packet Choking:** Cancels outgoing `PlayerMoveC2SPacket` and stores them in a queue.
- **Jittering:** Applies an 8% randomized delay to the duration mode, appearing as authentic network lag spikes.
- **Safety Valve:** Hard limit of 40 packets in the queue. If reached, the queue is flushed immediately to prevent the server from issuing a `Too Many Packets` disconnect.
- **Condition Triggers:** Flushes the queue instantly upon attacking, jumping, or taking damage (`EntityStatusS2CPacket` status 2).
- **Memory Leak Fix:** Flushes and clears the packet queue upon disabling the module or when `mc.world == null` (disconnect).

---

## 5. Development Guidelines & Pitfalls
1. **Never use Python via Bash:** Modifying files via regex in python scripts is unstable and error-prone. Use native API tools (`write_file`, `edit_file`).
2. **Yarn Mapping Nightmares:** Obfuscated intermediary names (`field_1234`, `method_5678`) exist in older mixins (`intermediary.json`). These mixins must be migrated to Named mappings before they can be considered stable.
3. **Compile Before Commit:** Any structural change to packet arguments or mixins must be verified against the 1.21.4 Yarn mappings.
4. **Android Rendering:** Do not implement features requiring heavy UI processing, blurring, complex shadows, or JNA (Java Native Access). The client must remain lightweight for FCL.
5. **Legitimacy First:** For combat/movement modules, prefer simulating user input (`EventMoveInput`, `KeyBinding.setPressed`) or utilizing vanilla mechanics over brute-force packet injection unless explicitly designing a Rage module.
