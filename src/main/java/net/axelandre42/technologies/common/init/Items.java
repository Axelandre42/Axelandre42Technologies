package net.axelandre42.technologies.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.axelandre42.technologies.Axelandre42Technologies;
import net.axelandre42.technologies.common.item.ItemProperty;
import net.axelandre42.technologies.common.item.ItemResearch;
import net.minecraft.item.Item;

public class Items {
	public static Item itemResearch;
	public static Item itemProperty;
	
	private static void simpleRegister(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}
	
	public static void construct() {
		itemResearch = new ItemResearch();
		itemProperty = new ItemProperty();
	}
	
	public static void register() {
		simpleRegister(itemResearch);
		simpleRegister(itemProperty);
	}
}
