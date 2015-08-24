package net.axelandre42.technologies.common.container;

import net.axelandre42.technologies.common.tileentity.alpha.TileEntityMaterialStudyLab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMaterialStudyLab extends Container {
	
	private TileEntityMaterialStudyLab tileentity;
	
	public ContainerMaterialStudyLab(InventoryPlayer player, TileEntityMaterialStudyLab tileentity) {
		this.tileentity = tileentity;
		
		addSlotToContainer(new Slot(tileentity, 0, 33, 12));
		addSlotToContainer(new Slot(tileentity, 1, 33, 30));
		addSlotToContainer(new Slot(tileentity, 2, 33, 48));
		
		addSlotToContainer(new SlotResearch(tileentity, 3, 66, 12));
		addSlotToContainer(new SlotResearch(tileentity, 4, 84, 12));
		
		addSlotToContainer(new Slot(tileentity, 5, 121, 30));
		
		bindPlayerInventory(player);
	}
	
	private void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
						8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileentity.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);

		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			if (slot < tileentity.getSizeInventory()) {
				if (!this.mergeItemStack(stackInSlot, tileentity.getSizeInventory(), 36+tileentity.getSizeInventory(), true)) {
					return null;
				}
			}
			else if (!this.mergeItemStack(stackInSlot, 0, tileentity.getSizeInventory(), false)) {
				return null;
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}

}
