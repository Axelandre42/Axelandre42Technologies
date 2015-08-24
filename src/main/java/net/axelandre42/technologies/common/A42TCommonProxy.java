package net.axelandre42.technologies.common;

import net.axelandre42.technologies.Axelandre42Technologies;
import net.axelandre42.technologies.common.init.Blocks;
import net.axelandre42.technologies.common.init.Items;
import net.axelandre42.technologies.common.init.Lists;
import net.axelandre42.technologies.common.init.Registries;
import net.axelandre42.technologies.common.test.TestProperty;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class A42TCommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		Registries.construct();
		Registries.addToAPI();
		
		Lists.construct();
		
		Items.construct();
		Items.register();
		
		Blocks.construct();
		Blocks.register();
	}
	
	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Axelandre42Technologies.instance, new A42TGuiHandler());
		TestProperty.init();
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
