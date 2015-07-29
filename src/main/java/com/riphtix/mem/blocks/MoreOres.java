package com.riphtix.mem.blocks;

import net.minecraft.block.material.Material;

public class MoreOres extends BasicBlock {


	public MoreOres(Material material, int harvestLevel){
		super(material);
		this.setHardness(3.0F);
		if(harvestLevel == 0){
			this.setHarvestLevel("pickaxe", 0);
		} else if(harvestLevel == 1){
			this.setHarvestLevel("pickaxe", 1);
		} else if(harvestLevel == 2){
			this.setHarvestLevel("pickaxe", 2);
		} else if(harvestLevel == 3){
			this.setHarvestLevel("pickaxe", 3);
		}
		this.setStepSound(soundTypeStone);
	}
}
