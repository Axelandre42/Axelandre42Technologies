package net.axelandre42.technologies.common.tileentity.alpha;

import net.axelandre42.technologies.api.research.IProperty;
import net.axelandre42.technologies.common.init.Items;
import net.axelandre42.technologies.common.init.Lists;
import net.axelandre42.technologies.common.init.Registries;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMaterialStudyLab extends TileEntity implements
		IInventory {
	private float progress = 0;

	private ItemStack[] inv = new ItemStack[6];
	
	private void incrDescoveryProgress(ItemStack stack) {
		if (Registries.researchRegistry.isValidProperty(stack)) {
			IProperty property = Registries.researchRegistry.getProperty(stack.stackTagCompound.getString("PropertyName"));
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (property.getItemNeeded(j) != null && inv[i].getItem() == property.getItemNeeded(j).getItem()) {
						int progress = stack.stackTagCompound.getInteger("ProgressItem"+j);
						ItemStack little = decrStackSize(i, property.getQuantityNeeded(j) - progress);
						stack.stackTagCompound.setInteger("ProgressItem"+j, little.stackSize);
						
						this.progress = progress / property.getQuantityNeeded(j);
					}
				}
			}
		}
	}
	
	public float getProgress() {
		return this.progress;
	}
	
	@Override
	public void updateEntity() {
		if (inv[5] == null) {
			IProperty property;
			if ((property = Registries.researchRegistry.checkPropertyByItemStacks(inv[0], inv[1], inv[2])) != null) {
				inv[5] = Registries.researchRegistry.createPropertyItemStack(property.getUnlocalizedName());
			}
		} else {
			
		}
	}
	
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
		return "inv.studylab.material";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
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
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		
		NBTTagList tagInventory = tagCompound.getTagList("Inventory", 10);
		for (int i = 0; i < tagInventory.tagCount(); i++) {
			NBTTagCompound tagItem = tagInventory.getCompoundTagAt(i);
			byte slot = tagItem.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tagItem);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		
		NBTTagList tagInventory = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tagItem = new NBTTagCompound();
				tagItem.setByte("Slot", (byte) i);
				stack.writeToNBT(tagItem);
				tagInventory.appendTag(tagItem);
			}
		}
		
		tagCompound.setTag("Inventory", tagInventory);
	}
}
