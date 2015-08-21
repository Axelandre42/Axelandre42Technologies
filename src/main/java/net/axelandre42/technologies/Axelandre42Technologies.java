package net.axelandre42.technologies;

import net.axelandre42.technologies.common.A42TCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "Axelandre42Technologies", version = "A0.001")
public class Axelandre42Technologies {
	
	@SidedProxy(clientSide = "net.axelandre42.technologies.client.A42TClientProxy", serverSide = "net.axelandre42.technologies.server.A42TServerProxy")
	public static A42TCommonProxy proxy;
	
	@Instance(value = "Axelandre42Technologies")
	public static Axelandre42Technologies instance;
	
	public Axelandre42Technologies() {
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
