import os
import re
from pathlib import Path

# 1. Disable Framebuffers / Blur in DrawUtil.java
draw_util_path = Path("wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/DrawUtil.java")
content = draw_util_path.read_text(encoding="utf-8")

# Replace drawBlur body with a simple return
content = re.sub(
    r'public static void drawBlur\(MatrixStack matrices, float x, float y, float width, float height, float blurRadius, BorderRadius borderRadius, ColorRGBA color\) \{.*?(?=public static void drawRectangle)',
    '''public static void drawBlur(MatrixStack matrices, float x, float y, float width, float height, float blurRadius, BorderRadius borderRadius, ColorRGBA color) {
        // Disabled for FCL (VirGL framebuffer crashes)
    }

    ''',
    content,
    flags=re.DOTALL
)

# Also disable KawaseBlurProgram entirely just in case
kawase_path = Path("wyvern-dlc/src/main/java/wtf/wyvern/utility/render/display/shader/impl/KawaseBlurProgram.java")
k_content = kawase_path.read_text(encoding="utf-8")
k_content = re.sub(
    r'public void updateUniforms\(float offset\) \{.*?(?=protected void setup)',
    '''public void updateUniforms(float offset) {
      if (this.offsetUniform != null) this.offsetUniform.set(offset);
      if (this.resolutionUniform != null) this.resolutionUniform.set(1.0F / (float)mw.getWidth(), 1.0F / (float)mw.getHeight());
      if (this.saturationUniform != null) this.saturationUniform.set(1.0F);
      if (this.tintIntensityUniform != null) this.tintIntensityUniform.set(0.0F);
      if (this.tintColorUniform != null) this.tintColorUniform.set(1.0F, 1.0F, 1.0F);
   }

   ''',
    k_content,
    flags=re.DOTALL
)
kawase_path.write_text(k_content, encoding="utf-8")

# 2. Fix Blink lifecycle
blink_path = Path("wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/player/Blink.java")
if blink_path.exists():
    b_content = blink_path.read_text(encoding="utf-8")
    b_content = re.sub(
        r'public void onEnable\(\) \{',
        'public void onEnable() {\n        super.onEnable();',
        b_content
    )
    b_content = re.sub(
        r'public void onDisable\(\) \{',
        'public void onDisable() {\n        super.onDisable();',
        b_content
    )
    blink_path.write_text(b_content, encoding="utf-8")

# 3. Fix FakePlayer lifecycle
fake_path = Path("wyvern-dlc/src/main/java/wtf/wyvern/client/modules/impl/misc/FakePlayer.java")
if fake_path.exists():
    f_content = fake_path.read_text(encoding="utf-8")
    f_content = re.sub(
        r'public void onEnable\(\) \{',
        'public void onEnable() {\n        super.onEnable();',
        f_content
    )
    f_content = re.sub(
        r'public void onDisable\(\) \{',
        'public void onDisable() {\n        super.onDisable();',
        f_content
    )
    fake_path.write_text(f_content, encoding="utf-8")

# 4. Fix NotifyManager multiple instances
wyvern_path = Path("wyvern-dlc/src/main/java/wtf/wyvern/Wyvern.java")
notify_path = Path("wyvern-dlc/src/main/java/wtf/wyvern/base/notify/NotifyManager.java")

nm_content = notify_path.read_text(encoding="utf-8")
if "new NotifyManager()" in nm_content:
    nm_content = nm_content.replace(
        "private static final NotifyManager INSTANCE = new NotifyManager();",
        "private static NotifyManager INSTANCE = null;\n    public static NotifyManager getInstance() {\n        if (INSTANCE == null) INSTANCE = new NotifyManager();\n        return INSTANCE;\n    }\n"
    )
    # Remove the old getInstance if it existed
    nm_content = re.sub(r'public static NotifyManager getInstance\(\) \{\s*return INSTANCE;\s*\}', '', nm_content, count=1)
    notify_path.write_text(nm_content, encoding="utf-8")

# 5. Fix WaypointManager player tracking activeWaypoint branch
wp_path = Path("wyvern-dlc/src/main/java/wtf/wyvern/base/waypoint/WaypointManager.java")
if wp_path.exists():
    wp_content = wp_path.read_text(encoding="utf-8")
    wp_content = wp_content.replace("return this.activeWaypoint != null;", "return this.activePlayerWaypoint != null;")
    wp_content = wp_content.replace("return this.activeWaypoint;", "return this.activePlayerWaypoint;")
    wp_path.write_text(wp_content, encoding="utf-8")

draw_util_path.write_text(content, encoding="utf-8")
print("Applied shader, lifecycle, and bugs fixes.")
