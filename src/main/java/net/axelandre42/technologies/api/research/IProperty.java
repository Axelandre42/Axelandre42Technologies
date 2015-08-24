package net.axelandre42.technologies.api.research;

import net.minecraft.item.ItemStack;

public interface IProperty {
	/**
	 * Same as IResearch.
	 * @return an unlocalized name.
	 */
	String getUnlocalizedName();
	
	/**
	 * To create properties, we need some materials. Here, we define what materials we need.
	 * @param index The index of the item. (From 0 to 2)
	 * @return an ItemStack this property needs, can be null when no one is needed (For the index).
	 */
	ItemStack getItemNeeded(int index);
	
	/**
	 * With getItemNeeded, we need a quantity. Here you can define that.
	 * @param index The index of the item. (From 0 to 2)
	 * @return a quantity needed for this property, can be null when no one is needed (For the index).
	 */
	int getQuantityNeeded(int index);
	
	/**
	 * Sometimes, some properties need one or two researches to be reached.
	 * @param index The index of needed research (From 0 to 1)
	 * @return the IResearch that the property needs, can be null when no one is needed (For the index).
	 */
	IResearch getNeededResearches(int index);
}
