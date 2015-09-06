package net.axelandre42.technologies.client.renderer;

import org.lwjgl.opengl.GL11;

import net.axelandre42.technologies.Axelandre42Technologies;
import net.axelandre42.technologies.common.tileentity.TileEntityCopperCable;
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
		GL11.glTranslated(translationX, translationY, translationZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(texture);
		{
			drawCore();
			
			TileEntityCopperCable coppercable = (TileEntityCopperCable) tileentity;
			for (int i = 0; i < coppercable.connectors.length; i++) {
				if (coppercable.connectors[i] != null)
					drawConnector(coppercable.connectors[i]);
			}
		}
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-translationX, -translationY, -translationZ);
	}
	
	private void drawConnector(ForgeDirection direction) {
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if (direction.equals(ForgeDirection.NORTH)) {
			GL11.glRotatef(270, 1, 0, 0);
		} else if (direction.equals(ForgeDirection.SOUTH)) {
			GL11.glRotatef(90, 1, 0, 0);
		} else if (direction.equals(ForgeDirection.EAST)) {
			GL11.glRotatef(270, 0, 0, 1);
		} else if (direction.equals(ForgeDirection.WEST)) {
			GL11.glRotatef(90, 0, 0, 1);
		} else if (direction.equals(ForgeDirection.DOWN)) {
			GL11.glRotatef(180, 1, 0, 0);
		} else if (direction.equals(ForgeDirection.UP)) {
			
		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 12 * texturePixel, 5 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1, 1 - 10 * pixel / 2, 12 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1, 1 - 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 6 * texturePixel, 5 * texturePixel);
			
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 12 * texturePixel, 5 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1, 10 * pixel / 2, 12 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1, 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 6 * texturePixel, 5 * texturePixel);
			
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 12 * texturePixel, 5 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1, 10 * pixel / 2, 12 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1, 1 - 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 6 * texturePixel, 5 * texturePixel);
			
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 1 - 10 * pixel / 2, 12 * texturePixel, 5 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1, 1 - 10 * pixel / 2, 12 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1, 10 * pixel / 2, 6 * texturePixel, 0 * texturePixel);
			tessellator.addVertexWithUV(10 * pixel / 2, 1 - 10 * pixel / 2, 10 * pixel / 2, 6 * texturePixel, 5 * texturePixel);
		}
		tessellator.draw();
		
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if (direction.equals(ForgeDirection.NORTH)) {
			GL11.glRotatef(-270, 1, 0, 0);
		} else if (direction.equals(ForgeDirection.SOUTH)) {
			GL11.glRotatef(-90, 1, 0, 0);
		} else if (direction.equals(ForgeDirection.EAST)) {
			GL11.glRotatef(-270, 0, 0, 1);
		} else if (direction.equals(ForgeDirection.WEST)) {
			GL11.glRotatef(-90, 0, 0, 1);
		} else if (direction.equals(ForgeDirection.DOWN)) {
			GL11.glRotatef(-180, 1, 0, 0);
		} else if (direction.equals(ForgeDirection.UP)) {
			
		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	}
	
	private void drawCore() {
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
