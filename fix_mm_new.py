import re
from pathlib import Path

p = Path("wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java")
c = p.read_text(encoding="utf-8")

if "AutoTotem.INSTANCE" not in c:
    c = c.replace(
        "this.add(TriggerBot.INSTANCE);", 
        "this.add(TriggerBot.INSTANCE);\n        this.add(wtf.wyvern.client.modules.impl.combat.AutoTotem.INSTANCE);"
    )
if "TargetStrafe.INSTANCE" not in c:
    c = c.replace(
        "this.add(GrimGlide.INSTANCE);", 
        "this.add(GrimGlide.INSTANCE);\n        this.add(wtf.wyvern.client.modules.impl.movement.TargetStrafe.INSTANCE);"
    )
p.write_text(c, encoding="utf-8")
