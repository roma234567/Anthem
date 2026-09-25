import re
from pathlib import Path

p = Path("wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/AutoTotem.java")
c = p.read_text(encoding="utf-8")

# Fix bug: AutoTotem doesn't consider already held totem in main hand
c = c.replace(
    "if (needTotem && mc.player.getOffHandStack().getItem() != Items.TOTEM_OF_UNDYING) {",
    "if (needTotem && mc.player.getOffHandStack().getItem() != Items.TOTEM_OF_UNDYING && mc.player.getMainHandStack().getItem() != Items.TOTEM_OF_UNDYING) {"
)
# Fix checkLethalCrystals: mc.world.getEntitiesByClass syntax
c = c.replace(
    "mc.world.getEntitiesByClass(EndCrystalEntity.class, mc.player.getBoundingBox().expand(12.0), c -> true)",
    "mc.world.getEntitiesByClass(EndCrystalEntity.class, mc.player.getBoundingBox().expand(12.0), entity -> true)"
)

p.write_text(c, encoding="utf-8")
