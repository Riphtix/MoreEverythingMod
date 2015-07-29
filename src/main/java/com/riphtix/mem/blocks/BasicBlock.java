package com.riphtix.mem.blocks;

import com.riphtix.mem.MEMCreativeTabs;
import com.riphtix.mem.MoreEverythingMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {

	public BasicBlock(Material material) {
		super(material);
		this.setCreativeTab(MEMCreativeTabs.tabMoreBlocks);
	}
}
