package net.axelandre42.technologies.api.util;

import net.minecraft.tileentity.TileEntity;

/**
 * This class serves to handle block data used in sub-blocks (Alpha, Beta, Gamma...).
 * 
 * @author Axelandre42
 *
 */
public class BlockDataContainer {
	private Class<? extends TileEntity> tileentity;
	private String modName;
	private String[] textureNames;
	
	/**
	 * Create an instance.
	 * 
	 * @param tileentity is the {@link java.lang.Class} instance of {@link net.minecraft.tileentity.TileEntity}.
	 * @param modName is the name of the mod's asset directory used for textures.
	 * @param textureNames is the names array of the textures asset to display on the block.
	 */
	public BlockDataContainer(Class<? extends TileEntity> tileentity, String modName, String[] textureNames) {
		this.tileentity = tileentity;
		this.modName = modName;
		this.textureNames = textureNames;
	}
	
	public Class<? extends TileEntity> getTileEntity() {
		return tileentity;
	}
	
	public String getModName() {
		return modName;
	}
	
	public String[] getTextureNames() {
		return textureNames;
	}
}
