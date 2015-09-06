package net.axelandre42.technologies.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.axelandre42.technologies.A42T_Logger;
import net.axelandre42.technologies.common.block.BlockCopperCable;
import net.minecraft.block.Block;

public class A42T_Blocks {
	
	public static Block copperCable;
	
	public static void load() {
		copperCable = new BlockCopperCable();
		
		A42T_Logger.INSTANCE.logBlockLoad("copper_cable");
		GameRegistry.registerBlock(copperCable, "copper_cable");
	}
}
