package net.axelandre42.technologies.common.init;

import net.axelandre42.technologies.util.ItemWhitelist;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Lists {
	public static ItemWhitelist researchable;
	
	public static void construct() {
		researchable = new ItemWhitelist();
		researchable.addItemStack(new ItemStack(Blocks.stone));
		researchable.addItemStack(new ItemStack(Blocks.planks));
	}

}
