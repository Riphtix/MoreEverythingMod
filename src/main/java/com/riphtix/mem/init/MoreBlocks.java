package com.riphtix.mem.init;

import com.riphtix.mem.Reference;
import com.riphtix.mem.blocks.MoreOres;
import com.riphtix.mem.blocks.RubyOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreBlocks {

	public static Block silver_ore;
	public static Block ruby_ore;

	public static void init() {
		silver_ore = new MoreOres(Material.rock, 1).setUnlocalizedName("silver_ore");
		ruby_ore = new RubyOre(Material.rock).setUnlocalizedName("ruby_ore");
	}

	public static void register() {
		GameRegistry.registerBlock(silver_ore, silver_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ruby_ore, ruby_ore.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(silver_ore);
		registerRender(ruby_ore);
	}

	public static void registerRender(net.minecraft.block.Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
