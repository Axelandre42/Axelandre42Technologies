package net.axelandre42.technologies;

import net.axelandre42.technologies.common.A42TCommonProxy;
import net.axelandre42.technologies.common.init.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Axelandre42Technologies.MODID, version = "A0.001")
public class Axelandre42Technologies {
	
	public static final String MODID = "Axelandre42Technologies";
	
	@SidedProxy(clientSide = "net.axelandre42.technologies.client.A42TClientProxy", serverSide = "net.axelandre42.technologies.server.A42TServerProxy")
	public static A42TCommonProxy proxy;
	
	@Instance(value = "Axelandre42Technologies")
	public static Axelandre42Technologies instance;
	
	public static CreativeTabs tab = new CreativeTabs("axelandre42Technologies") {
		
		@Override
		public Item getTabIconItem() {
			// TODO Auto-generated method stub
			return Items.itemResearch;
		}
	};
	
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
