package net.axelandre42.technologies.api.registry;

import net.axelandre42.technologies.api.util.BlockDataContainer;
import net.minecraft.tileentity.TileEntity;

public interface IBlockRegistry {
	void register(Class<? extends TileEntity> tileentity, String modName, String[] textureNames);
	
	void register(BlockDataContainer container);
}
