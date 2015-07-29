package com.riphtix.mem.items;

import com.riphtix.mem.MEMCreativeTabs;
import net.minecraft.item.ItemSpade;

public class SilverShovel extends ItemSpade {

	public SilverShovel(ToolMaterial material) {
		super(material);
		this.setCreativeTab(MEMCreativeTabs.tabMoreTools);
	}
}
