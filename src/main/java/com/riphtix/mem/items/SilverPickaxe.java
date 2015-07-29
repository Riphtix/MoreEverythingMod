package com.riphtix.mem.items;

import com.riphtix.mem.MEMCreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class SilverPickaxe extends ItemPickaxe {

	public SilverPickaxe(ToolMaterial material) {
		super(material);
		this.setCreativeTab(MEMCreativeTabs.tabMoreTools);
	}
}
