import re
from pathlib import Path

p = Path("wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java")
c = p.read_text(encoding="utf-8")

if "PearlPhase.INSTANCE" not in c:
    c = c.replace(
        "this.add(TargetStrafe.INSTANCE);", 
        "this.add(TargetStrafe.INSTANCE);\n        this.add(wtf.wyvern.client.modules.impl.movement.PearlPhase.INSTANCE);"
    )
p.write_text(c, encoding="utf-8")
