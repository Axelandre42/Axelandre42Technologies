package net.axelandre42.technologies.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.axelandre42.technologies.client.renderer.TileEntityRendererCopperCable;
import net.axelandre42.technologies.common.A42T_CommonProxy;
import net.axelandre42.technologies.common.tileentity.TileEntityCopperCable;

public class A42T_ClientProxy extends A42T_CommonProxy {
	
	// ----------------------------------------
	// Client Side's Load Phase
	
	@Override
	public void load(FMLInitializationEvent e) {
		super.load(e);
		
		this.registerRenderer();
	}
	
	// ----------------------------------------
	// Register Renderer
	
	private void registerRenderer() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCopperCable.class, new TileEntityRendererCopperCable());
	}
}
