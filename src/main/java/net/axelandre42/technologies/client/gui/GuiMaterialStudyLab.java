package net.axelandre42.technologies.client.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.axelandre42.technologies.Axelandre42Technologies;
import net.axelandre42.technologies.common.container.ContainerMaterialStudyLab;
import net.axelandre42.technologies.common.tileentity.alpha.TileEntityMaterialStudyLab;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiMaterialStudyLab extends GuiContainer {

	public GuiMaterialStudyLab(InventoryPlayer player, TileEntityMaterialStudyLab tileentity) {
		super(new ContainerMaterialStudyLab(player, tileentity));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int wait, int what) {
		super.drawGuiContainerForegroundLayer(wait, what);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new ResourceLocation(Axelandre42Technologies.MODID.toLowerCase(), "/textures/gui/container/material_study_lab.png"));
		
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		this.drawTexturedModalRect(59, 33, xSize, 0, 25, 10);
		
		this.mc.fontRenderer.drawString(LanguageRegistry.instance().getStringLocalization("container.studyLab.material"), 8, 6, 0x404040);
		this.mc.fontRenderer.drawString(LanguageRegistry.instance().getStringLocalization("container.inventory"), 8, ySize - 96 + 2, 0x404040);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float what,
			int is, int that) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new ResourceLocation(Axelandre42Technologies.MODID.toLowerCase(), "/textures/gui/container/material_study_lab.png"));
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
