package net.axelandre42.technologies.common.item;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.axelandre42.technologies.Axelandre42Technologies;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemProperty extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon icon;
	
	public ItemProperty() {
		this.setCreativeTab(Axelandre42Technologies.tab);
		this.setUnlocalizedName("property");
		this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		icon = reg.registerIcon(Axelandre42Technologies.MODID + ":property");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass) {
		return icon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		return icon;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean aBool) {
		list.add(LanguageRegistry.instance().getStringLocalization(stack.stackTagCompound.getString("PropertyName")));
	}
}
