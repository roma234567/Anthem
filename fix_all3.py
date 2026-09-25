import re
from pathlib import Path

path = Path("wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/DrawUtil.java")
content = path.read_text(encoding="utf-8")

start = content.find("public static void drawBlur(MatrixStack matrices")
end = content.find("public static void drawImage(MatrixStack", start)
if start != -1 and end != -1:
    new_method = '''public static void drawBlur(MatrixStack matrices, float x, float y, float width, float height, float blurRadius, BorderRadius borderRadius, ColorRGBA color) {
      // Disabled for FCL to prevent VirGL framebuffers crash
      Render2DUtil.drawRect(matrices, x, y, width, height, color); // Fallback to simple rectangle
   }

   '''
    content = content[:start] + new_method + content[end:]
    path.write_text(content, encoding="utf-8")
    print("DrawUtil drawBlur patched!")
else:
    print("Indices not found")
