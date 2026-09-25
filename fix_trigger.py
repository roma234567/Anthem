import re
from pathlib import Path

p = Path("wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/combat/TriggerBot.java")
c = p.read_text(encoding="utf-8")
c = c.replace("wtf.wyvern.utility.game.player.AttackUtil", "wtf.wyvern.base.player.AttackUtil")
c = c.replace("mc.world.raycastBlock(", "// mc.world.raycastBlock(")
c = c.replace("return mc.world.raycastBlock", "return true; // placeholder")
p.write_text(c, encoding="utf-8")
