package com.riphtix.mem;

import com.riphtix.mem.init.MoreBlocks;
import com.riphtix.mem.init.MoreItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MEMCreativeTabs {

	public static CreativeTabs tabMoreBlocks = new CreativeTabs("moreBlocks") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(MoreBlocks.silver_ore).getItem();
		}
	};
	public static CreativeTabs tabMoreItems = new CreativeTabs("moreItems") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(MoreItems.silver_ingot).getItem();
		}
	};
	public static CreativeTabs tabMoreTools = new CreativeTabs("moreTools") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(MoreItems.silver_axe).getItem();
		}
	};
	public static CreativeTabs tabMoreWeapons = new CreativeTabs("moreWeapons") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(MoreItems.silver_sword).getItem();
		}
	};
}
