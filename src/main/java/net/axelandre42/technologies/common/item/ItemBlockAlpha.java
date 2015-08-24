package net.axelandre42.technologies.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockAlpha extends ItemBlock {
	private String[] names = new String[]{
			"studyLab.material", "studyLab.physics",
			"researchTable.hobbyists", "researchTable.technicians", "researchTable.engineers", "researchTable.genius",
			"blueprintCreator.little", "blueprintCreator.medium", "blueprintCreator.big"
	};

	public ItemBlockAlpha(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return names[stack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}

}
