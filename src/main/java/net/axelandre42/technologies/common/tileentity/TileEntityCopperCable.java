package net.axelandre42.technologies.common.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCopperCable extends TileEntity {
	
	/**
	 * UP, DOWN, NORTH, EAST, SOUTH, WEST.
	 */
	public ForgeDirection[] connectors = new ForgeDirection[6];
	
	public TileEntityCopperCable() {
		
	}
	
	@Override
	public void updateEntity() {
		this.updateConnectors();
		
	}
	
	private void updateConnectors() {
		if (this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityCopperCable)
			this.connectors[0] = ForgeDirection.UP;
		else
			this.connectors[0] = null;
		if (this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityCopperCable)
			this.connectors[1] = ForgeDirection.DOWN;
		else
			this.connectors[1] = null;
		if (this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityCopperCable)
			this.connectors[2] = ForgeDirection.NORTH;
		else
			this.connectors[2] = null;
		if (this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityCopperCable)
			this.connectors[3] = ForgeDirection.EAST;
		else
			this.connectors[3] = null;
		if (this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityCopperCable)
			this.connectors[4] = ForgeDirection.SOUTH;
		else
			this.connectors[4] = null;
		if (this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityCopperCable)
			this.connectors[5] = ForgeDirection.WEST;
		else
			this.connectors[5] = null;
		
	}
	
}
