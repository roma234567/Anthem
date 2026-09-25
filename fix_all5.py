import re
from pathlib import Path

path = Path("wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/Render2DUtil.java")
content = path.read_text(encoding="utf-8")

# drawBlurredShadow
start = content.find("public static void drawBlurredShadow(")
end = content.find("public static void onRender(", start)
if start != -1 and end != -1:
    content = content[:start] + "public static void drawBlurredShadow(MatrixStack matrices, float x, float y, float width, float height, int blurRadius, Color color) {}\n\n   " + content[end:]

# drawGradientBlurredShadow
start = content.find("public static void drawGradientBlurredShadow(")
end = content.find("public static void registerBufferedImageTexture(", start)
if start != -1 and end != -1:
    content = content[:start] + "public static void drawGradientBlurredShadow(MatrixStack matrices, float x, float y, float width, float height, int blurRadius, Gradient gradient) {}\n\n   " + content[end:]

path.write_text(content, encoding="utf-8")
print("Render2DUtil shadows patched!")
