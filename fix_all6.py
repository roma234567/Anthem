import re
from pathlib import Path

path = Path("wyvern-dlc/src/main/java/wtf/wyvern/Wyvern.java")
content = path.read_text(encoding="utf-8")
content = content.replace("this.notifyManager = new NotifyManager();", "this.notifyManager = NotifyManager.getInstance();")
path.write_text(content, encoding="utf-8")
print("Wyvern notifyManager patched!")
