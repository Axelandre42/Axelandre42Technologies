package net.axelandre42.technologies.client.renderer;

import org.lwjgl.opengl.GL11;

import net.axelandre42.technologies.Axelandre42Technologies;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityRendererCopperCable extends TileEntitySpecialRenderer {
	
	private ResourceLocation texture = new ResourceLocation(Axelandre42Technologies.MODID, "textures/models/copper_cable.png");
	private float pixel = 1F/16F;
	private float texturePixel = 1F/64F;

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double translationX,
			double translationY, double translationZ, float f) {
		// TODO Auto-generated method stub
		GL11.glTranslated(translationX, translationY, translationZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(texture);
		drawCore(tileentity);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-translationX, -translationY, -translationZ);
	}
	
	private void drawConnector(ForgeDirection direction) {
		
	}
	
	private void drawCore(TileEntity tileentity) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 10 * pixel / 2, 1 - 10 * pixel / 2, 6 * texturePixel, 6 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 10 * pixel / 2, 1 - 10 * pixel / 2, 0 * texturePixel, 6 * texturePixel);
			
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2, 6 * texturePixel, 6 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 10 * pixel / 2, 1 - 10 * pixel / 2, 0 * texturePixel, 6 * texturePixel);

			tessellator.addVertexWithUV(10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2, 6 * texturePixel, 6 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2, 0 * texturePixel, 6 * texturePixel);
			
			tessellator.addVertexWithUV(10 * pixel / 2, 10 * pixel / 2, 1 - 10 * pixel / 2, 6 * texturePixel, 6 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2, 0 * texturePixel, 6 * texturePixel);
			
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 6 * texturePixel, 6 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 0 * texturePixel, 6 * texturePixel);

			tessellator.addVertexWithUV(10 * pixel / 2, 10 * pixel / 2, 1 - 10 * pixel / 2, 6 * texturePixel, 6 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2, 0 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 10 * pixel / 2, 1 - 10 * pixel / 2, 0 * texturePixel, 6 * texturePixel);
		}
		tessellator.draw();
	}

}
