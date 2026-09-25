import re
from pathlib import Path

p = Path("wyvern-dlc/src/main/java/wtf/wyvern/base/modules/ModuleManager.java")
c = p.read_text(encoding="utf-8")

c = c.replace(
    "this.add(Velocity.INSTANCE);", 
    "this.add(Velocity.INSTANCE);\n        this.add(TriggerBot.INSTANCE);"
)
p.write_text(c, encoding="utf-8")
