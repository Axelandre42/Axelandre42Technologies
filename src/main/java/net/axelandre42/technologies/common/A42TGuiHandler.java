package net.axelandre42.technologies.common;

import net.axelandre42.technologies.client.gui.GuiMaterialStudyLab;
import net.axelandre42.technologies.common.container.ContainerMaterialStudyLab;
import net.axelandre42.technologies.common.tileentity.alpha.TileEntityMaterialStudyLab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class A42TGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		switch (ID) {
		case 0:
			TileEntity tileentity = world.getTileEntity(x, y, z);
			if (tileentity instanceof TileEntityMaterialStudyLab)
				return new ContainerMaterialStudyLab(player.inventory, (TileEntityMaterialStudyLab) tileentity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		switch (ID) {
		case 0:
			TileEntity tileentity = world.getTileEntity(x, y, z);
			if (tileentity instanceof TileEntityMaterialStudyLab)
				return new GuiMaterialStudyLab(player.inventory, (TileEntityMaterialStudyLab) tileentity);
		}
			
		return null;
	}

}
