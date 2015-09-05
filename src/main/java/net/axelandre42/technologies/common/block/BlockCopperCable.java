package net.axelandre42.technologies.common.block;

import net.axelandre42.technologies.A42T_CreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCopperCable extends Block {

	// ----------------------------------------
	// Block's Constructor
	
	public BlockCopperCable() {
		super(Material.rock);
		
		this.setCreativeTab(A42T_CreativeTabs.INSTANCE);
		this.setResistance(70F);
		this.setHardness(0.9F);
		this.setStepSound(soundTypeSnow);
	}

	// ----------------------------------------
	
	
}
