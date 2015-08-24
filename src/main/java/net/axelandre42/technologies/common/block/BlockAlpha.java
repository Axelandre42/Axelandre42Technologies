package net.axelandre42.technologies.common.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.axelandre42.technologies.Axelandre42Technologies;
import net.axelandre42.technologies.common.init.Registries;
import net.axelandre42.technologies.common.tileentity.alpha.TileEntityMaterialStudyLab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAlpha extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[][] icons = new IIcon[16][6];
	
	public BlockAlpha() {
		super(Material.rock);
		this.setCreativeTab(Axelandre42Technologies.tab);
	}
	
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		icons[0][0] = reg.registerIcon(Axelandre42Technologies.MODID + ":material_study_lab_bottom");
		icons[0][1] = reg.registerIcon(Axelandre42Technologies.MODID + ":material_study_lab_top");
		icons[0][2] = icons[0][3] = icons[0][4] = icons[0][5] = reg.registerIcon(Axelandre42Technologies.MODID + ":material_study_lab_side");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return icons[metadata][side];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(this, 1, 0));
	}
	
	@Override
	public String getUnlocalizedName() {
		return "tile.blockAlpha";
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		switch (metadata) {
		case 0:
			return new TileEntityMaterialStudyLab();
		}
		return null;
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
		if (metadata == 0) {
			dropItems(world, x, y, z);
		}
		super.breakBlock(world, x, y, z, block, metadata);
	}
	
	private void dropItems(World world, int x, int y, int z){
		Random rand = new Random();

		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (!(tileEntity instanceof IInventory)) {
			return;
		}
		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world,
						x + rx, y + ry, z + rz,
						item.copy());

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float is, float that) {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if (!(player.isSneaking() | tileentity == null)) {
			player.openGui(Axelandre42Technologies.instance, 0, world, x, y, z);
			return true;
		}
		return false;
	}

}
