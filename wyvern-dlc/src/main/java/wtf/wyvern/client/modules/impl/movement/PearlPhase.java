package wtf.wyvern.client.modules.impl.movement;

import com.darkmagician6.eventapi.EventTarget;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.util.Hand;
import wtf.wyvern.base.events.impl.other.EventTick;
import wtf.wyvern.base.events.impl.player.EventMove;
import wtf.wyvern.base.events.impl.player.EventMoveInput;
import wtf.wyvern.base.events.impl.server.EventPacket;
import wtf.wyvern.client.modules.api.Category;
import wtf.wyvern.client.modules.api.Module;
import wtf.wyvern.client.modules.api.ModuleAnnotation;
import wtf.wyvern.client.modules.api.setting.impl.ModeSetting;
import wtf.wyvern.utility.game.other.InventoryUtil;
import wtf.wyvern.utility.game.player.PlayerIntersectionUtil;

@ModuleAnnotation(name = "PearlPhase", category = Category.MOVEMENT, description = "Легитно или в Rage режиме телепортирует сквозь стены")
public class PearlPhase extends Module {
    public static final PearlPhase INSTANCE = new PearlPhase();

    private final ModeSetting mode = new ModeSetting("Mode", "Legit", "Rage");

    private boolean isInsideBlock = false;
    private int oldSlot = -1;
    private int throwDelay = 0;

    public PearlPhase() {}

    @Override
    public void onEnable() {
        super.onEnable();
        isInsideBlock = false;
        throwDelay = 0;
        oldSlot = mc.player != null ? mc.player.getInventory().selectedSlot : -1;

        if (mode.is("Legit") && mc.player != null) {
            doLegitPhase();
            this.setToggled(false); // Выключаем сразу после легит броска
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        if (mc.player != null) {
            mc.player.noClip = false;
        }
    }

    @EventTarget
    public void onTick(EventTick event) {
        if (mc.player == null || mc.world == null) return;

        if (mode.is("Rage")) {
            // Проверка, находимся ли мы внутри блока (застряли)
            isInsideBlock = !mc.world.getBlockCollisions(mc.player, mc.player.getBoundingBox().contract(0.0625)).isEmpty();

            if (isInsideBlock) {
                // Локальный ноуклип, чтобы клиент не дёргало экраном
                mc.player.noClip = true;
                
                // Цепная реакция (Chain Pearl)
                if (throwDelay > 0) throwDelay--;

                if (!mc.player.getItemCooldownManager().isCoolingDown(Items.ENDER_PEARL) && throwDelay <= 0) {
                    doRageChainPearl();
                    throwDelay = 5; // Небольшая задержка, чтобы не спамить в один тик
                }
            } else {
                mc.player.noClip = false;
                // Если мы снаружи и включили Rage - кидаем первый перл в стену
                if (!mc.player.getItemCooldownManager().isCoolingDown(Items.ENDER_PEARL) && throwDelay <= 0) {
                    doRageChainPearl();
                    throwDelay = 5;
                }
            }
        }
    }

    @EventTarget
    public void onMove(EventMove event) {
        if (mode.is("Rage") && isInsideBlock) {
            // Глушим движения (чтобы не кикало за флай/спид в блоке)
            event.setX(0);
            event.setZ(0);
        }
    }

    @EventTarget
    public void onMoveInput(EventMoveInput event) {
        if (mode.is("Rage") && isInsideBlock) {
            // Отключаем ввод пользователя, пока мы "буримся"
            event.setForward(0);
            event.setStrafe(0);
            event.setJumping(false);
            event.setSneaking(false);
        }
    }

    @EventTarget
    public void onPacket(EventPacket event) {
        if (mc.player == null || !mode.is("Rage")) return;

        // Anti-Suffocation Bypass: отправляем микросдвиги серверу, чтобы сбить вектор выталкивания
        if (event.isSent() && isInsideBlock && event.getPacket() instanceof PlayerMoveC2SPacket packet) {
            // Отменяем обычные пакеты движения
            event.setCancelled(true);
            
            // Отправляем фейковый пакет сдвига, чтобы сервер обнулил OutOfBlock Velocity
            double x = mc.player.getX();
            double y = mc.player.getY() + 1E-4; // +0.0001
            double z = mc.player.getZ();
            mc.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(x, y, z, false, mc.player.horizontalCollision));
        }
    }

    private void doLegitPhase() {
        int pearlSlot = InventoryUtil.findItem(Items.ENDER_PEARL);
        if (pearlSlot < 0 || pearlSlot > 8) return; // Только из хотбара

        int currentSlot = mc.player.getInventory().selectedSlot;

        // Идеальный угол для микро-доводки в край (часто используется 89.9 или 0.0)
        // Для легита мы просто уменьшаем хитбокс
        mc.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.PRESS_SHIFT_KEY));
        
        if (pearlSlot != currentSlot) mc.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(pearlSlot));
        mc.getNetworkHandler().sendPacket(new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, mc.player.getYaw(), mc.player.getPitch()));
        if (pearlSlot != currentSlot) mc.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(currentSlot));

        mc.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.RELEASE_SHIFT_KEY));
    }

    private void doRageChainPearl() {
        int pearlSlot = InventoryUtil.findItem(Items.ENDER_PEARL);
        if (pearlSlot < 0 || pearlSlot > 8) return;

        int currentSlot = mc.player.getInventory().selectedSlot;

        // Уменьшаем хитбокс
        mc.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.PRESS_SHIFT_KEY));
        
        // Свапаем и кидаем
        if (pearlSlot != currentSlot) mc.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(pearlSlot));
        mc.getNetworkHandler().sendPacket(new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, mc.player.getYaw(), mc.player.getPitch()));
        if (pearlSlot != currentSlot) mc.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(currentSlot));
        
        // Оставляем шифт зажатым, пока не выйдем из блока (или релизнем тут, зависит от АЧ, но чаще лучше релизнуть)
        mc.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.RELEASE_SHIFT_KEY));
    }
}
