package net.axelandre42.technologies.common.container;

import net.axelandre42.technologies.common.init.Items;
import net.axelandre42.technologies.common.init.Registries;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotResearch extends Slot {

	public SlotResearch(IInventory inv, int ID, int x,
			int y) {
		super(inv, ID, x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return Registries.researchRegistry.isValidResearch(stack);
	}

}
