package net.axelandre42.technologies.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class ItemWhitelist {
	private List<ItemStack> whitelist = new ArrayList<ItemStack>();
	
	/**
	 * Adds an ItemStack to the white-list.
	 * @param stack The item to add.
	 */
	public void addItemStack(ItemStack stack) {
		whitelist.add(stack);
	}
	
	/**
	 * Removes an ItemStack to the white-list.
	 * @param stack The item to remove.
	 */
	public void removeItemStack(ItemStack stack) {
		whitelist.remove(stack);
	}
	
	/**
	 * Checks if the ItemStack is in the white-list.
	 * @param stack the item to check.
	 * @return <strong>true</strong> if the item is there, <strong>false</strong> if not.
	 */
	public boolean checkItemStack(ItemStack stack) {
		boolean isThere = false;
		
		for (ItemStack aStack : whitelist) {
			isThere = ItemStack.areItemStacksEqual(stack, aStack);
		}
		
		return isThere;
	}
	
}
