package com.riphtix.mem.init;

import com.riphtix.mem.Reference;
import com.riphtix.mem.blocks.BasicBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreBlocks {

	public static Block silver_ore;

	public static void init() {
		silver_ore = new BasicBlock(Material.rock).setUnlocalizedName("silver_ore");
	}

	public static void register() {
		GameRegistry.registerBlock(silver_ore, silver_ore.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(silver_ore);
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
