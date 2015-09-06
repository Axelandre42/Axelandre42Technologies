package net.axelandre42.technologies.common.block;

import net.axelandre42.technologies.A42T_CreativeTabs;
import net.axelandre42.technologies.common.tileentity.TileEntityCopperCable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCopperCable extends BlockContainer {

	// ----------------------------------------
	// Block's Constructor
	
	public BlockCopperCable() {
		super(Material.rock);
		
		this.setCreativeTab(A42T_CreativeTabs.INSTANCE);
		this.setResistance(70F);
		this.setHardness(0.9F);
		this.setStepSound(soundTypeSnow);
		this.setBlockName("a42t_copper_cable");
		
		float pixel = 1F / 16F;
		this.setBlockBounds(10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2, 10 * pixel / 2 + 6 * pixel, 10 * pixel / 2 + 6 * pixel, 10 * pixel / 2 + 6 * pixel);
		
		this.useNeighborBrightness = true;
	}
	
	// ----------------------------------------
	// Render Informations
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	// ----------------------------------------
	// TileEntity !
	
	@Override
	public TileEntity createNewTileEntity(World w, int m) {
		// TODO Auto-generated method stub
		return new TileEntityCopperCable();
	}

}
