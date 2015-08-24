package net.axelandre42.technologies.common;

import net.axelandre42.technologies.common.init.Blocks;
import net.axelandre42.technologies.common.init.Registries;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class A42TCommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		Registries.construct();
		Registries.addToAPI();
		
		Blocks.construct();
		Blocks.register();
	}
	
	public void init(FMLInitializationEvent e) {
		
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
