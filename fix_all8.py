import re
from pathlib import Path

path = Path("wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/DrawUtil.java")
content = path.read_text(encoding="utf-8")

# drawBlurHud
start = content.find("public static void drawBlurHud(MatrixStack matrices, float x, float y, float width, float height, float blurRadius, BorderRadius borderRadius, ColorRGBA color) {")
if start != -1:
    end = content.find("}", start) + 1
    content = content[:start] + "public static void drawBlurHud(MatrixStack matrices, float x, float y, float width, float height, float blurRadius, BorderRadius borderRadius, ColorRGBA color) {}\n" + content[end:]

# drawBlurHudBooleanCheck
start = content.find("public static void drawBlurHudBooleanCheck(MatrixStack matrices, float x, float y, float width, float height, float blurRadius, BorderRadius borderRadius, ColorRGBA color, boolean d, boolean f) {")
if start != -1:
    end = content.find("}", start) + 1
    content = content[:start] + "public static void drawBlurHudBooleanCheck(MatrixStack matrices, float x, float y, float width, float height, float blurRadius, BorderRadius borderRadius, ColorRGBA color, boolean d, boolean f) {}\n" + content[end:]

path.write_text(content, encoding="utf-8")
print("DrawUtil drawBlurHud patched!")
