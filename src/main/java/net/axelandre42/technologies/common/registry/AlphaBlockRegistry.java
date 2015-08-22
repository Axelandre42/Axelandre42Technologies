package net.axelandre42.technologies.common.registry;

import java.util.List;

import net.axelandre42.technologies.api.registry.IBlockRegistry;
import net.axelandre42.technologies.api.util.BlockDataContainer;
import net.minecraft.tileentity.TileEntity;

public class AlphaBlockRegistry implements IBlockRegistry {
	
	public List<BlockDataContainer> registry;

	@Override
	public void register(Class<? extends TileEntity> tileentity, String modName, String[] textureNames) {
		registry.add(new BlockDataContainer(tileentity, modName, textureNames));
	}

	@Override
	public void register(BlockDataContainer container) {
		// TODO Auto-generated method stub
		registry.add(container);
	}

}
