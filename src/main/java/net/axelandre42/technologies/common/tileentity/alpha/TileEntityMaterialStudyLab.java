package net.axelandre42.technologies.common.tileentity.alpha;

import net.axelandre42.technologies.common.init.Items;
import net.axelandre42.technologies.common.init.Lists;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMaterialStudyLab extends TileEntity implements
		IInventory {

	private ItemStack[] inv = new ItemStack[6];
	
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int quantity) {
		if (inv[slot] == null)
			return null;
		
		ItemStack stack = inv[slot].copy();
		if (quantity >= stack.stackSize) {
			inv[slot] = null;
		} else {
			stack.stackSize = quantity;
			inv[slot].stackSize -= quantity;
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return this.getStackInSlot(slot);
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "inv.studylab.material";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		// TODO Auto-generated method stub
		switch (slot) {
		case 0:
		case 1:
		case 2:
			return Lists.researchable.checkItemStack(stack);
		case 3:
		case 4:
			return ItemStack.areItemStacksEqual(stack, new ItemStack(Items.itemResearch));
		case 5:
		default:
			return false;
		}
	}
}
