package com.riphtix.mem.items;

import com.riphtix.mem.MEMCreativeTabs;
import net.minecraft.item.ItemAxe;

public class SilverAxe extends ItemAxe {

	public SilverAxe(ToolMaterial material) {
		super(material);
		this.setCreativeTab(MEMCreativeTabs.tabMoreTools);
	}
}
