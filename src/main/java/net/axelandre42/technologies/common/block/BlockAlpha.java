package net.axelandre42.technologies.common.block;

import java.util.List;

import net.axelandre42.technologies.Axelandre42Technologies;
import net.axelandre42.technologies.common.init.Registries;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockAlpha extends Block {

	private IIcon[][] icons = new IIcon[256][6];
	
	public BlockAlpha() {
		super(Material.rock);
		this.setBlockName("blockAlpha");
		this.setCreativeTab(Axelandre42Technologies.tabAxelandre42Technologies);
	}
	
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	public void registerBlockIcons(IIconRegister reg) {
		
	}
	
	public IIcon getIcon(int side, int metadata) {
		return icons[metadata][side];
	}
	
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		
	}
	

}
