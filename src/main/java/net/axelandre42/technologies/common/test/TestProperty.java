package net.axelandre42.technologies.common.test;

import java.util.List;

import net.axelandre42.technologies.api.research.IBlueprint;
import net.axelandre42.technologies.api.research.IProperty;
import net.axelandre42.technologies.api.research.IResearch;
import net.axelandre42.technologies.common.init.Registries;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TestProperty implements IProperty {
	
	public static void init() {
		Registries.researchRegistry.registerProperty(new TestProperty());
	}

	@Override
	public String getUnlocalizedName() {
		// TODO Auto-generated method stub
		return "property.test";
	}

	@Override
	public ItemStack getItemNeeded(int index) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			return new ItemStack(Items.apple);
		case 1:
			return new ItemStack(Blocks.acacia_stairs);
		case 2:
			break;
		}
		return null;
	}

	@Override
	public int getQuantityNeeded(int index) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			return 64;
		case 1:
			return 16;
		case 2:
			break;
		}
		return 0;
	}

	@Override
	public IResearch getNeededResearches(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
