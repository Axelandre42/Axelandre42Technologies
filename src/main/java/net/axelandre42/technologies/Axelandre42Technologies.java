package net.axelandre42.technologies;

import net.axelandre42.technologies.init.A42T_Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Axelandre42Technologies.MODID,
	version = Axelandre42Technologies.VERSION,
	dependencies = Axelandre42Technologies.DEPENDENCIES)
public class Axelandre42Technologies {
	
	// ----------------------------------------
	// Constants
	
	public static final String MODID = "axelandre42technologies";
	public static final String NAME = "Axelandre42 Technologies";
	public static final String VERSION = "A0.01.001";
	public static final String DEPENDENCIES = "after: NotEnoughItems";
	
	// ----------------------------------------
	// THE MOD'S INSTANCE !
	
	@Mod.Instance(value = MODID)
	public static Axelandre42Technologies INSTANCE;
	
	// ----------------------------------------
	// Event Handlers
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent e) {
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
