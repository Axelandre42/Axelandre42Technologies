package net.axelandre42.technologies.api.research;

import net.minecraft.item.ItemStack;

public interface IResearchRegistry {
	/**
	 * Registers research.
	 * @param research a research
	 */
	void registerResearch(IResearch research);
	
	/**
	 * Registers property.
	 * @param property a property
	 */
	void registerProperty(IProperty property);
	
	/**
	 * Registers blueprint.
	 * @param blueprint a blueprint
	 */
	void registerBlueprint(IBlueprint blueprint);
	
	/**
	 * Checks if there is a research with these ItemStack.
	 * @param first an ItemStack that can be null
	 * @param second an ItemStack that can be null
	 * @param third an ItemStack that can be null
	 * @return the property if there is, <strong>null</strong> if not.
	 */
	IProperty checkPropertyByItemStacks(ItemStack first, ItemStack second, ItemStack third);
	
	/**
	 * Used to get the research binded with the name.
	 * @param name the name of the research
	 * @return a research
	 */
	IResearch getResearch(String name);
	
	/**
	 * Used to get the property binded with the name.
	 * @param name the name of the property
	 * @return a property
	 */
	IProperty getProperty(String name);
	
	/**
	 * Used to get the blueprint binded with the name.
	 * @param name the name of the blueprint
	 * @return a blueprint
	 */
	IBlueprint getBlueprint(String name);
	
	/**
	 * Used to know if an ItemStack is a valid research. 
	 * @param stack the ItemStack
	 * @return if its a valid research
	 */
	boolean isValidResearch(ItemStack stack);
	
	/**
	 * Used to know if an ItemStack is a valid property. 
	 * @param stack the ItemStack
	 * @return if its a valid property
	 */
	boolean isValidProperty(ItemStack stack);
	
	/**
	 * Used to create an ItemStack that represents a property.
	 * @param name the name of the property
	 * @return an ItemStack
	 */
	ItemStack createPropertyItemStack(String name);
}
