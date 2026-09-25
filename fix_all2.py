import re
from pathlib import Path

path = Path("wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/DrawUtil.java")
content = path.read_text(encoding="utf-8")

# Find public static void drawBlur(
start = content.find("public static void drawBlur(")
if start != -1:
    end = content.find("public static void drawRectangle(", start)
    if end != -1:
        new_method = '''public static void drawBlur(MatrixStack matrices, float x, float y, float width, float height, float blurRadius, BorderRadius borderRadius, ColorRGBA color) {
      // Disabled for FCL to prevent VirGL framebuffers crash
   }
   
   '''
        content = content[:start] + new_method + content[end:]
        path.write_text(content, encoding="utf-8")
        print("DrawUtil drawBlur patched!")
    else:
        print("end not found")
else:
    print("start not found")
