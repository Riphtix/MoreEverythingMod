package com.riphtix.mem.items;

import com.riphtix.mem.MEMCreativeTabs;
import net.minecraft.item.ItemSword;

public class SilverSword extends ItemSword {

	public SilverSword(ToolMaterial material) {
		super(material);
		this.setCreativeTab(MEMCreativeTabs.tabMoreWeapons);
	}
}
