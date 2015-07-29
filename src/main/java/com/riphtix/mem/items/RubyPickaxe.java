package com.riphtix.mem.items;

import com.riphtix.mem.MEMCreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class RubyPickaxe extends ItemPickaxe {

	public RubyPickaxe(ToolMaterial material) {
		super(material);
		this.setCreativeTab(MEMCreativeTabs.tabMoreTools);
	}
}
