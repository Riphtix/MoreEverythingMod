package com.riphtix.mem.init;

import com.riphtix.mem.Reference;
import com.riphtix.mem.items.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreItems {

	public static Item ruby;
	public static Item silver_ingot;

	public static Item ruby_pickaxe;
	public static Item ruby_axe;
	public static Item ruby_shovel;
	public static Item ruby_hoe;
	public static Item ruby_sword;
	public static Item silver_pickaxe;
	public static Item silver_axe;
	public static Item silver_shovel;
	public static Item silver_hoe;
	public static Item silver_sword;

	public static final Item.ToolMaterial SILVER = EnumHelper.addToolMaterial("SILVER", 2, 1225, 7.0F, 2.5F, 12);
	public static final Item.ToolMaterial RUBY = EnumHelper.addToolMaterial("RUBY", 3, 1775, 7.0F, 3.0F, 12);

	public static void init(){
		ruby = new EvenMoreItems().setUnlocalizedName("ruby");
		silver_ingot = new EvenMoreItems().setUnlocalizedName("silver_ingot");

		ruby_axe = new RubyAxe(RUBY).setUnlocalizedName("ruby_axe");
		ruby_hoe = new RubyHoe(RUBY).setUnlocalizedName("ruby_hoe");
		ruby_pickaxe = new RubyPickaxe(RUBY).setUnlocalizedName("ruby_pickaxe");
		ruby_shovel = new RubyShovel(RUBY).setUnlocalizedName("ruby_shovel");
		ruby_sword = new RubySword(RUBY).setUnlocalizedName("ruby_sword");
		silver_axe = new SilverAxe(SILVER).setUnlocalizedName("silver_axe");
		silver_hoe = new SilverHoe(SILVER).setUnlocalizedName("silver_hoe");
		silver_pickaxe = new SilverPickaxe(SILVER).setUnlocalizedName("silver_pickaxe");
		silver_shovel = new SilverShovel(SILVER).setUnlocalizedName("silver_shovel");
		silver_sword = new SilverSword(SILVER).setUnlocalizedName("silver_sword");
	}

	public static void register(){
		GameRegistry.registerItem(ruby, ruby.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silver_ingot, silver_ingot.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(ruby_axe, ruby_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_hoe, ruby_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_pickaxe, ruby_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_shovel, ruby_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ruby_sword, ruby_sword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silver_axe, silver_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silver_hoe, silver_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silver_pickaxe, silver_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silver_shovel, silver_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silver_sword, silver_sword.getUnlocalizedName().substring(5));
	}

	public static void registerRenders(){
		registerRender(ruby);
		registerRender(silver_ingot);

		registerRender(ruby_axe);
		registerRender(ruby_hoe);
		registerRender(ruby_pickaxe);
		registerRender(ruby_shovel);
		registerRender(ruby_sword);
		registerRender(silver_axe);
		registerRender(silver_hoe);
		registerRender(silver_pickaxe);
		registerRender(silver_shovel);
		registerRender(silver_sword);
	}

	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
