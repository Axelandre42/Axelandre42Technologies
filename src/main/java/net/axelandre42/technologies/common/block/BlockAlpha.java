package net.axelandre42.technologies.common.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.axelandre42.technologies.Axelandre42Technologies;
import net.axelandre42.technologies.common.init.Registries;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAlpha extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[][] icons = new IIcon[16][6];
	
	public BlockAlpha() {
		super(Material.rock);
		this.setCreativeTab(Axelandre42Technologies.tab);
	}
	
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return icons[metadata][side];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		
	}
	
	@Override
	public String getUnlocalizedName() {
		return "tile.blockAlpha";
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return null;
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

}
