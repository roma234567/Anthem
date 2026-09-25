import re
from pathlib import Path

path = Path("wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/Render2DUtil.java")
content = path.read_text(encoding="utf-8")

start = content.find("public static void drawGradientBlurredShadow(")
end = content.find("public static void drawRoundGradient(", start)
if start != -1 and end != -1:
    new_method = '''public static void drawGradientBlurredShadow(MatrixStack matrices, float x, float y, float width, float height, int blurRadius, Gradient gradient) {
      // Disabled for FCL: AWT BufferedImage causes massive lag or crashes on Android
   }

   '''
    content = content[:start] + new_method + content[end:]
    path.write_text(content, encoding="utf-8")
    print("Render2DUtil drawGradientBlurredShadow patched!")
else:
    print("Indices not found")
