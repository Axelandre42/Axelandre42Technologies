package net.axelandre42.technologies;

import net.axelandre42.technologies.init.A42T_Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class A42T_CreativeTabs extends CreativeTabs {
	
	public static A42T_CreativeTabs INSTANCE;
	
	public static void load() {
		INSTANCE = new A42T_CreativeTabs();
	}

	public A42T_CreativeTabs() {
		super("axelandre42technologies");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(A42T_Blocks.copperCable);
	}

}
