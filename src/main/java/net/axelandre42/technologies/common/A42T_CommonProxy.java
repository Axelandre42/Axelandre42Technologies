package net.axelandre42.technologies.common;

import net.axelandre42.technologies.A42T_CreativeTabs;
import net.axelandre42.technologies.A42T_Logger;
import net.axelandre42.technologies.common.tileentity.TileEntityCopperCable;
import net.axelandre42.technologies.init.A42T_Blocks;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class A42T_CommonProxy {
	
	// ----------------------------------------
	// Event handlers' callback
	
	public void preInit(FMLPreInitializationEvent e) {
		A42T_Logger.load(e.getModLog());
		
		A42T_Logger.INSTANCE.logPreInitMessage("--- Phase Start ---");
		
		A42T_Logger.INSTANCE.logPreInitMessage("Loading CreativeTabs");
		A42T_CreativeTabs.load();
		A42T_Blocks.load();
		
		A42T_Logger.INSTANCE.logPreInitMessage("--- Phase End ---");
	}
	
	public void load(FMLInitializationEvent e) {
		A42T_Logger.INSTANCE.logTileEntityLoad("copper_cable");
		GameRegistry.registerTileEntity(TileEntityCopperCable.class, "copper_cable");
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	public void serverStarting(FMLServerStartingEvent e) {
		
	}
	
	public void serverStarted(FMLServerStartedEvent e) {
		
	}
	
	public void serverStopping(FMLServerStoppingEvent e) {
		
	}
	
	public void serverStopped(FMLServerStoppedEvent e) {
		
	}
}
