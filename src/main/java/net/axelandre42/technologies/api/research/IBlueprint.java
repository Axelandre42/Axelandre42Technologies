package net.axelandre42.technologies.api.research;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public interface IBlueprint {
	/**
	 * Same as IResearch.
	 * @return an unlocalized name.
	 */
	String getUnlocalizedName();
	
	/**
	 * The crafting system use blueprints to define its recipes, this method is called when the blueprint is in the table<br>
	 * and the inventory was modified. It's used for checking if the valid recipe.<br>
	 * <br>
	 * The Grid is 0-9 slot in the inventory.<br>
	 * The Casing slot is the 10.
	 * @param bluprintsWorkbench the inventory to check the recipe.
	 * @return if the checked inventory is correct.
	 */
	boolean isValidRecipe(IInventory bluprintsWorkbench);
	
	/**
	 * The result of the recipe is defined here !
	 * @return The result of recipe.
	 */
	ItemStack getResult();
}
