import re
from pathlib import Path

path = Path("wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/DrawUtil.java")
content = path.read_text(encoding="utf-8")
content = content.replace("Render2DUtil.drawRect(matrices, x, y, width, height, color); // Fallback to simple rectangle", "// Draw rect removed, we just don't draw anything to keep background translucent.")
path.write_text(content, encoding="utf-8")
print("DrawUtil drawBlur fallback fixed!")
