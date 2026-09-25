import re
from pathlib import Path

p = Path("wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/TriggerBot.java")
c = p.read_text(encoding="utf-8")
c = re.sub(
    r'private boolean isStrictlyVisible.*?\}',
    '''private boolean isStrictlyVisible(Entity entity) {
        if (mc.player == null || mc.world == null) return false;
        Vec3d eyePos = mc.player.getEyePos();
        Vec3d targetPos = entity.getBoundingBox().getCenter();
        net.minecraft.world.RaycastContext context = new net.minecraft.world.RaycastContext(
                eyePos, targetPos, 
                net.minecraft.world.RaycastContext.ShapeType.COLLIDER, 
                net.minecraft.world.RaycastContext.FluidHandling.NONE, 
                mc.player
        );
        net.minecraft.util.hit.BlockHitResult result = mc.world.raycast(context);
        return result.getType() == net.minecraft.util.hit.HitResult.Type.MISS;
    }''',
    c,
    flags=re.DOTALL
)
p.write_text(c, encoding="utf-8")
