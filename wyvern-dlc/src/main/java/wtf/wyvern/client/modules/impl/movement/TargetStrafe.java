package wtf.wyvern.client.modules.impl.movement;

import com.darkmagician6.eventapi.EventTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import wtf.wyvern.base.events.impl.player.EventMoveInput;
import wtf.wyvern.client.modules.api.Category;
import wtf.wyvern.client.modules.api.Module;
import wtf.wyvern.client.modules.api.ModuleAnnotation;
import wtf.wyvern.client.modules.api.setting.impl.BooleanSetting;
import wtf.wyvern.client.modules.api.setting.impl.NumberSetting;
import wtf.wyvern.client.modules.impl.combat.Aura;
import wtf.wyvern.utility.game.player.rotation.RotationUtil;

@ModuleAnnotation(name = "TargetStrafe", category = Category.MOVEMENT, description = "Легитно кружит вокруг цели Ауры (кайтинг) без Speed/Reach")
public class TargetStrafe extends Module {
    public static final TargetStrafe INSTANCE = new TargetStrafe();

    private final NumberSetting distance = new NumberSetting("Distance", 2.8f, 1.0f, 6.0f, 0.1f);
    private final BooleanSetting avoidEdges = new BooleanSetting("Avoid Edges", true);
    
    private float direction = 1.0f;
    
    public TargetStrafe() {}

    @EventTarget
    public void onMoveInput(EventMoveInput event) {
        if (mc.player == null || mc.world == null) return;
        
        Entity target = Aura.INSTANCE.isEnabled() ? Aura.INSTANCE.target : null;
        if (!(target instanceof LivingEntity)) return;
        
        if (mc.player.horizontalCollision) {
            direction = -direction; // Смена направления при столкновении
        }

        if (avoidEdges.isEnabled() && isOverVoid()) {
            direction = -direction;
        }

        double distToTarget = mc.player.distanceTo(target);
        
        // Симулируем нажатия клавиш WASD для античитов (легитный ввод)
        float forward = 0;
        float strafe = direction;

        if (distToTarget > distance.getCurrent() + 0.2) {
            forward = 1.0f; // Идем вперед (W)
        } else if (distToTarget < distance.getCurrent() - 0.2) {
            forward = -1.0f; // Отходим назад (S)
        } else {
            forward = 0.0f; // Стоим на идеальной дистанции, только кружим
        }

        // Поворачиваемся к цели, чтобы стрейф работал корректно относительно камеры
        float yaw = RotationUtil.getAngles(target.getPos())[0];
        
        // Применяем инпуты без модификации базовой скорости бега
        event.setForward(forward);
        event.setStrafe(strafe);
        wtf.wyvern.utility.game.player.MovingUtil.fixMovementFocus(event, yaw);
    }
    
    private boolean isOverVoid() {
        Vec3d pos = mc.player.getPos();
        for (int i = 0; i < 3; i++) { // Проверяем 3 блока вниз
            if (!mc.world.getBlockState(net.minecraft.util.math.BlockPos.ofFloored(pos.x, pos.y - i, pos.z)).isAir()) {
                return false;
            }
        }
        return true;
    }
}
