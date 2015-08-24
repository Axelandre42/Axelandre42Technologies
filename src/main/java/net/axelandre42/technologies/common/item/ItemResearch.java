package net.axelandre42.technologies.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.axelandre42.technologies.Axelandre42Technologies;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemResearch extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon icon;
	
	public ItemResearch() {
		this.setCreativeTab(Axelandre42Technologies.tab);
		this.setUnlocalizedName("research");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		icon = reg.registerIcon(Axelandre42Technologies.MODID + ":research");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass) {
		return icon;
	}
	
	public IIcon getIconIndex(ItemStack stack) {
		return icon;
	}
	
}
