package wtf.wyvern.utility.render.display.shader.impl;

import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import wtf.wyvern.utility.interfaces.IWindow;
import wtf.wyvern.utility.render.display.shader.GlProgram;

public class KawaseBlurProgram extends GlProgram implements IWindow {
   private GlUniform resolutionUniform;
   private GlUniform offsetUniform;
   private GlUniform saturationUniform;
   private GlUniform tintIntensityUniform;
   private GlUniform tintColorUniform;

   public KawaseBlurProgram(Identifier identifier) {
      super(identifier, VertexFormats.POSITION_TEXTURE_COLOR);
   }

   public void updateUniforms(float offset) {
      if (this.offsetUniform != null) this.offsetUniform.set(offset);
      if (this.resolutionUniform != null) this.resolutionUniform.set(1.0F / (float)mw.getWidth(), 1.0F / (float)mw.getHeight());
      if (this.saturationUniform != null) this.saturationUniform.set(1.0F);
      if (this.tintIntensityUniform != null) this.tintIntensityUniform.set(0.0F);
      if (this.tintColorUniform != null) this.tintColorUniform.set(1.0F, 1.0F, 1.0F);
   }

   protected void setup() {
      this.resolutionUniform = this.findUniform("Resolution");
      this.offsetUniform = this.findUniform("Offset");
      this.saturationUniform = this.findUniform("Saturation");
      this.tintIntensityUniform = this.findUniform("TintIntensity");
      this.tintColorUniform = this.findUniform("TintColor");
      super.setup();
   }
}