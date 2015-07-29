package com.riphtix.mem.blocks;

import com.riphtix.mem.MEMCreativeTabs;
import com.riphtix.mem.init.MoreItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class RubyOre extends Block {

	public RubyOre(Material material) {
		super(material);
		this.setCreativeTab(MEMCreativeTabs.tabMoreBlocks);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
	}

	@Override
	public Item getItemDropped(IBlockState blockState, Random rand, int fortune) {
		return MoreItems.ruby;
	}
}
