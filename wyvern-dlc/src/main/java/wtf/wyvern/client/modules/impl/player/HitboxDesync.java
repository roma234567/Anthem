package wtf.wyvern.client.modules.impl.player;

import com.darkmagician6.eventapi.EventTarget;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import wtf.wyvern.base.events.impl.server.EventPacket;
import wtf.wyvern.client.modules.api.Category;
import wtf.wyvern.client.modules.api.Module;
import wtf.wyvern.client.modules.api.ModuleAnnotation;
import wtf.wyvern.client.modules.api.setting.impl.ModeSetting;
import wtf.wyvern.utility.interfaces.IMinecraft;

@ModuleAnnotation(name = "HitboxDesync", category = Category.PLAYER, description = "Синхронизирует позицию для обхода хитбоксов и срыва аимов")
public class HitboxDesync extends Module implements IMinecraft {
    public static final HitboxDesync INSTANCE = new HitboxDesync();

    private final ModeSetting mode = new ModeSetting("Mode", "Micro", "MagicPitch");
    
    private boolean toggleFlip = false;

    public HitboxDesync() {}

    @EventTarget
    public void onPacket(EventPacket event) {
        if (mc.player == null || !event.isSent()) return;

        if (event.getPacket() instanceof PlayerMoveC2SPacket packet) {
            
            if (mode.is("Micro")) {
                // Микро-смещение по X и Z. Клиент стоит на месте, 
                // серверная позиция постоянно "вибрирует" на 0.03 блока.
                // Вражеские триггерботы с жестким Raycast будут промахиваться.
                if (packet.changesPosition()) {
                    toggleFlip = !toggleFlip;
                    double offset = toggleFlip ? 0.03 : -0.03;
                    
                    event.setCancelled(true);
                    
                    if (packet instanceof PlayerMoveC2SPacket.PositionAndOnGround) {
                        mc.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(
                                packet.getX(mc.player.getX()) + offset,
                                packet.getY(mc.player.getY()),
                                packet.getZ(mc.player.getZ()) + offset,
                                packet.isOnGround(), mc.player.horizontalCollision
                        ));
                    } else if (packet instanceof PlayerMoveC2SPacket.Full) {
                        mc.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.Full(
                                packet.getX(mc.player.getX()) + offset,
                                packet.getY(mc.player.getY()),
                                packet.getZ(mc.player.getZ()) + offset,
                                packet.getYaw(mc.player.getYaw()),
                                packet.getPitch(mc.player.getPitch()),
                                packet.isOnGround(), mc.player.horizontalCollision
                        ));
                    }
                }
            } else if (mode.is("MagicPitch")) {
                // Отправка невозможного питча (например 180). 
                // Многие ауры и ESP будут ломаться или рисовать вашу модельку вверх ногами,
                // из-за чего их Raycast улетит в небеса.
                if (packet.changesLook()) {
                    event.setCancelled(true);
                    
                    if (packet instanceof PlayerMoveC2SPacket.LookAndOnGround) {
                        mc.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(
                                packet.getYaw(mc.player.getYaw()),
                                180.0F, // Magic pitch
                                packet.isOnGround(), mc.player.horizontalCollision
                        ));
                    } else if (packet instanceof PlayerMoveC2SPacket.Full) {
                        mc.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.Full(
                                packet.getX(mc.player.getX()),
                                packet.getY(mc.player.getY()),
                                packet.getZ(mc.player.getZ()),
                                packet.getYaw(mc.player.getYaw()),
                                180.0F, // Magic pitch
                                packet.isOnGround(), mc.player.horizontalCollision
                        ));
                    }
                }
            }
        }
    }
}
