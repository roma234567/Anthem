package wtf.wyvern.client.modules.impl.movement;

import com.darkmagician6.eventapi.EventTarget;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import wtf.wyvern.base.events.impl.other.EventTick;
import wtf.wyvern.base.events.impl.server.EventPacket;
import wtf.wyvern.client.modules.api.Category;
import wtf.wyvern.client.modules.api.Module;
import wtf.wyvern.client.modules.api.ModuleAnnotation;
import wtf.wyvern.client.modules.api.setting.impl.BooleanSetting;
import wtf.wyvern.client.modules.api.setting.impl.ModeSetting;
import wtf.wyvern.client.modules.api.setting.impl.NumberSetting;
import wtf.wyvern.utility.math.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ModuleAnnotation(name = "FakeLag", category = Category.MOVEMENT, description = "Накапливает пакеты движения и отправляет рывками. Создает эффект жестких лагов.")
public class FakeLag extends Module {
    public static final FakeLag INSTANCE = new FakeLag();

    private final ModeSetting mode = new ModeSetting("Mode", "Duration", "Condition");

    // --- Duration Settings ---
    private final NumberSetting durationMs = new NumberSetting("Duration (ms)", 100f, 10f, 1000f, 10f, () -> mode.is("Duration"));

    // --- Condition Settings ---
    private final BooleanSetting conditionAttack = new BooleanSetting("On Attack", true, () -> mode.is("Condition"));
    private final BooleanSetting conditionDamage = new BooleanSetting("On Damage", true, () -> mode.is("Condition"));
    private final BooleanSetting conditionJump = new BooleanSetting("On Jump", true, () -> mode.is("Condition"));
    
    private final BooleanSetting sumPackets = new BooleanSetting("Sum Packets", false, () -> mode.is("Condition"));
    private final NumberSetting maxPackets = new NumberSetting("Max Packets", 15f, 1f, 100f, 1f, () -> mode.is("Condition") && sumPackets.isEnabled());

    private final List<Packet<?>> packetQueue = new ArrayList<>();
    private final Timer timer = new Timer();
    
    private boolean shouldRelease = false;

    public FakeLag() {}

    @Override
    public void onDisable() {
        super.onDisable();
        releasePackets();
    }

    @EventTarget
    public void onTick(EventTick event) {
        if (mc.player == null) return;

        if (mode.is("Duration")) {
            long targetMs = (long) durationMs.getCurrent();
            // Добавляем рандомизацию +- 8%
            long jitter = (long) (targetMs * 0.08);
            long randomizedMs = targetMs + ThreadLocalRandom.current().nextLong(-jitter, jitter + 1);

            if (timer.finished(randomizedMs)) {
                releasePackets();
                timer.reset();
            }
        } else if (mode.is("Condition")) {
            if (sumPackets.isEnabled()) {
                if (packetQueue.size() >= maxPackets.getCurrent()) {
                    releasePackets();
                }
            } else {
                if (conditionJump.isEnabled() && !mc.player.isOnGround() && mc.player.fallDistance == 0.0f) {
                    shouldRelease = true; // Только что подпрыгнул
                }
                
                if (shouldRelease) {
                    releasePackets();
                    shouldRelease = false;
                }
            }
        }
    }

    @EventTarget
    public void onPacket(EventPacket event) {
        if (mc.player == null) return;

        // Перехват отправляемых пакетов (мы задерживаем только PlayerMove, чтобы не сломать чат, инвентарь и т.д.)
        if (event.isSent()) {
            Packet<?> p = event.getPacket();
            
            if (mode.is("Condition") && !sumPackets.isEnabled()) {
                if (conditionAttack.isEnabled() && (p instanceof PlayerInteractEntityC2SPacket || p instanceof HandSwingC2SPacket)) {
                    shouldRelease = true;
                }
            }

            if (p instanceof PlayerMoveC2SPacket) {
                packetQueue.add(p);
                event.setCancelled(true);
            }
        }

        // Перехват входящих пакетов для реакций
        if (event.isReceive() && mode.is("Condition") && !sumPackets.isEnabled() && conditionDamage.isEnabled()) {
            Packet<?> p = event.getPacket();
            if (p instanceof EntityDamageS2CPacket damagePacket) {
                if (damagePacket.entityId() == mc.player.getId()) {
                    shouldRelease = true;
                }
            } else if (p instanceof EntityStatusS2CPacket statusPacket) {
                // Статус 2 = Entity Hurt
                if (statusPacket.getEntity(mc.world) == mc.player && statusPacket.getStatus() == 2) {
                    shouldRelease = true;
                }
            }
        }
    }

    private void releasePackets() {
        if (packetQueue.isEmpty() || mc.getNetworkHandler() == null) return;
        
        for (Packet<?> p : packetQueue) {
            mc.getNetworkHandler().sendPacket(p);
        }
        packetQueue.clear();
    }
}
