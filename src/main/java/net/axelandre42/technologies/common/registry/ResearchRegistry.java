package net.axelandre42.technologies.common.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.axelandre42.technologies.api.research.IBlueprint;
import net.axelandre42.technologies.api.research.IProperty;
import net.axelandre42.technologies.api.research.IResearch;
import net.axelandre42.technologies.api.research.IResearchRegistry;
import net.axelandre42.technologies.common.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ResearchRegistry implements IResearchRegistry {

	private Map<String, IResearch> researches = new HashMap<String, IResearch>();
	private Map<String, IProperty> properties = new HashMap<String, IProperty>();
	private Map<String, IBlueprint> blueprints = new HashMap<String, IBlueprint>();
	
	@Override
	public void registerResearch(IResearch research) {
		researches.put(research.getUnlocalizedName(), research);
	}

	@Override
	public void registerProperty(IProperty property) {
		properties.put(property.getUnlocalizedName(), property);
	}

	@Override
	public void registerBlueprint(IBlueprint blueprint) {
		blueprints.put(blueprint.getUnlocalizedName(), blueprint);
	}
	
	public IProperty checkPropertyByItemStacks(ItemStack first, ItemStack second, ItemStack third) {
		ItemStack copyFirst = null, copySecond = null, copyThird = null;
		if (first != null) {
			copyFirst = first.copy();
			copyFirst.stackSize = 1;
		}
		if (second != null) {
			copySecond = second.copy();
			copySecond.stackSize = 1;
		}
		if (third != null) {
			copyThird = third.copy();
			copyThird.stackSize = 1;
		}
		
		Set<String> keys = properties.keySet();
		Iterator<String> keyIterator = keys.iterator();
		for (int i = 0; i < keys.size(); i++) {
			IProperty property = properties.get(keyIterator.next());
			
			boolean firstIsGood = false;
			for (int j = 0; j < 3; j++) {
				if (firstIsGood = ItemStack.areItemStacksEqual(property.getItemNeeded(j), copyFirst))
					break;
			}
			
			boolean secondIsGood = false;
			for (int j = 0; j < 3; j++) {
				if (secondIsGood = ItemStack.areItemStacksEqual(property.getItemNeeded(j), copySecond))
					break;
			}
			
			boolean thirdIsGood = false;
			for (int j = 0; j < 3; j++) {
				if (thirdIsGood = ItemStack.areItemStacksEqual(property.getItemNeeded(j), copyThird))
					break;
			}
			
			if (firstIsGood && secondIsGood && thirdIsGood) {
				return property;
			}
		}
		
		return null;
	}

	@Override
	public IResearch getResearch(String name) {
		return researches.get(name);
	}

	@Override
	public IProperty getProperty(String name) {
		return properties.get(name);
	}

	@Override
	public IBlueprint getBlueprint(String name) {
		return blueprints.get(name);
	}

	@Override
	public boolean isValidResearch(ItemStack stack) {
		if (stack.getItem() == Items.itemResearch) {
			NBTTagCompound tagItem = stack.getTagCompound();
			if (tagItem.hasKey("ResearchName")) {
				String researchName = tagItem.getString("ResearchName");
				if (this.getResearch(researchName) != null)
					return true;
			}
		}
		return false;
	}

	@Override
	public ItemStack createPropertyItemStack(String name) {
		ItemStack stack = new ItemStack(Items.itemProperty, 1);
		if (getProperty(name) != null) {
			stack.stackTagCompound = new NBTTagCompound();
			stack.stackTagCompound.setString("PropertyName", name);
			stack.stackTagCompound.setInteger("ProgressItem0", (byte) 0);
			stack.stackTagCompound.setInteger("ProgressItem1", (byte) 0);
			stack.stackTagCompound.setInteger("ProgressItem2", (byte) 0);
		}
		return null;
	}

	@Override
	public boolean isValidProperty(ItemStack stack) {
		if (stack.getItem() == Items.itemProperty) {
			NBTTagCompound tagItem = stack.getTagCompound();
			if (tagItem.hasKey("PropertyName")) {
				String propertyName = tagItem.getString("PropertyName");
				if (this.getResearch(propertyName) != null)
					return true;
			}
		}
		return false;
	}
}
