package net.axelandre42.technologies;

import net.axelandre42.technologies.common.A42T_CommonProxy;
import net.axelandre42.technologies.init.A42T_Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;

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
	// Mod's Proxy
	
	@SidedProxy(clientSide = "net.axelandre42.technologies.client.A42T_ClientProxy",
			serverSide = "net.axelandre42.technologies.server.A42T_ServerProxy")
	public static A42T_CommonProxy proxy;
	
	// ----------------------------------------
	// Event Handlers
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent e) {
		proxy.load(e);
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
	
	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		proxy.serverStarting(e);
	}
	
	@Mod.EventHandler
	public void serverStarted(FMLServerStartedEvent e) {
		proxy.serverStarted(e);
	}
	
	@Mod.EventHandler
	public void serverStopping(FMLServerStoppingEvent e) {
		proxy.serverStopping(e);
	}
	
	@Mod.EventHandler
	public void serverStopped(FMLServerStoppedEvent e) {
		proxy.serverStopped(e);
	}
	
}
