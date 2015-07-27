package com.riphtix.mem.init;

import com.riphtix.mem.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreItems {

	public static Item silver_ingot;

	public static void init(){
		silver_ingot = new Item().setUnlocalizedName("silver_ingot");
	}

	public static void register(){
		GameRegistry.registerItem(silver_ingot, silver_ingot.getUnlocalizedName().substring(5));
	}

	public static void registerRenders(){
		registerRender(silver_ingot);
	}

	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
