package net.axelandre42.technologies.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.axelandre42.technologies.Axelandre42Technologies;
import net.axelandre42.technologies.common.block.BlockAlpha;
import net.axelandre42.technologies.common.item.ItemBlockAlpha;
import net.axelandre42.technologies.common.tileentity.alpha.TileEntityMaterialStudyLab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;

public class Blocks {
	public static Block blockAlpha;
	
	private static void simpleRegister(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().replace("tile.", ""));
	}
	
	private static void tileEntityRegister(Class<? extends TileEntity> tileentity, Block block, String suffix) {
		GameRegistry.registerTileEntity(tileentity, block.getUnlocalizedName().replace("tile.", "") + suffix);
	}
	
	private static void subBlockRegister(Block block, Class<? extends ItemBlock> item) {
		GameRegistry.registerBlock(block, item, block.getUnlocalizedName().replace("tile.", ""));
	}
	
	public static void construct() {
		blockAlpha = new BlockAlpha();
	}
	
	public static void register() {
		subBlockRegister(blockAlpha, ItemBlockAlpha.class);
		tileEntityRegister(TileEntityMaterialStudyLab.class, blockAlpha, "materialStudyLab");
	}
}
