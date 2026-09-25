package wtf.wyvern.utility.game.combat;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CrystalDamageCalculator {
    public static float calculateDamage(Vec3d explosionPos, Entity target, World world) {
        // Упрощенный плейсхолдер калькулятора (базовая база для анархии)
        // В полноценном клиенте здесь рейкасты и учет брони, но для теста/FCL хватит базы.
        double distance = target.getPos().distanceTo(explosionPos);
        if (distance > 12.0) return 0.0f;
        
        double exposure = 1.0 - (distance / 12.0); // Линейная интерполяция
        float damage = (float) (exposure * exposure * 85.0);
        return damage;
    }
}
