package com.riphtix.mem.client.render;

import com.riphtix.mem.client.model.DragonModel;
import com.riphtix.mem.server.entity.EntityTameableDragon;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

/**
 * Created by EveryoneElse on 14/06/2015.
 */
public class LayerRendererDragonGlow implements LayerRenderer {
  private final DragonRenderer dragonRenderer;

  public LayerRendererDragonGlow(DragonRenderer i_dragonRenderer)
  {
    dragonRenderer = i_dragonRenderer;
  }

  public void doRenderLayer(EntityTameableDragon entityDragon, float moveTime, float moveSpeed, float partialTicks,
                            float ticksExisted, float lookYaw, float lookPitch, float scale)
  {
    DragonModel dragonModel = dragonRenderer.getModel();
    dragonModel.renderPass = DragonModel.RenderPass.GLOW;
    dragonRenderer.bindTexture(dragonModel.glowTexture);

    try {
      GL11.glPushAttrib(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_LIGHTING_BIT);

      GL11.glEnable(GL11.GL_BLEND);
      GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
      GL11.glDisable(GL11.GL_LIGHTING);      // use full lighting
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 65536, 0);

      dragonModel.render(entityDragon, moveTime, moveSpeed, ticksExisted, lookYaw, lookPitch, scale);
    } finally {
      GL11.glPopAttrib();
    }

  }

  public boolean shouldCombineTextures()
  {
    return false;
  }

  public void doRenderLayer(EntityLivingBase entityLivingBase, float moveTime, float moveSpeed, float partialTicks,
                            float ticksExisted, float lookYaw, float lookPitch, float scale)
  {
    this.doRenderLayer((EntityTameableDragon)entityLivingBase, moveTime, moveSpeed, partialTicks,
                       ticksExisted, lookYaw, lookPitch, scale);
  }
}
