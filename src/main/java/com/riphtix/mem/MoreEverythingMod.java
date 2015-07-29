package com.riphtix.mem;

import com.riphtix.mem.init.MoreBlocks;
import com.riphtix.mem.init.MoreItems;
import com.riphtix.mem.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.WorldGeneratorBonusChest;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod (modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MoreEverythingMod {

	@SidedProxy (clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.Instance (Reference.MOD_ID)
	public static MoreEverythingMod instance;

	private ModMetadata metadata;
	private DragonMountsConfig config;

	public DragonMountsConfig getConfig() {
		return config;
	}

	public ModMetadata getMetadata() {
		return metadata;
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MoreBlocks.init();
		MoreBlocks.register();
		MoreItems.init();
		MoreItems.register();

		GameRegistry.registerWorldGenerator(new MoreOresGeneration(), 0);

		config = new DragonMountsConfig(new Configuration(event.getSuggestedConfigurationFile()));
		metadata = event.getModMetadata();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();

		GameRegistry.addRecipe(new ItemStack(MoreItems.silver_axe), new Object[]{"SS", "Ss", " s", 'S', MoreItems.silver_ingot, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.silver_hoe), new Object[]{"SS", " s", " s", 'S', MoreItems.silver_ingot, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.silver_pickaxe), new Object[]{"SSS", " s ", " s ", 'S', MoreItems.silver_ingot, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.silver_shovel), new Object[]{"S", "s", "s", 'S', MoreItems.silver_ingot, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.silver_sword), new Object[]{"S", "S", "s", 'S', MoreItems.silver_ingot, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.ruby_axe), new Object[]{"RR", "Rs", " s", 'R', MoreItems.ruby, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.ruby_hoe), new Object[]{"RR", " s", " s", 'R', MoreItems.ruby, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.ruby_pickaxe), new Object[]{"RRR", " s ", " s ", 'R', MoreItems.ruby, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.ruby_shovel), new Object[]{"R", "s", "s", 'R', MoreItems.ruby, 's', Items.stick});
		GameRegistry.addRecipe(new ItemStack(MoreItems.ruby_sword), new Object[]{"R", "R", "s", 'R', MoreItems.ruby, 's', Items.stick});

		GameRegistry.addSmelting(MoreBlocks.silver_ore, new ItemStack(MoreItems.silver_ingot), 0.7F);
		GameRegistry.addSmelting(MoreBlocks.ruby_ore, new ItemStack(MoreItems.ruby), 0.7F);

		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.onPostInit(event);
	}

	@Mod.EventHandler
	public void onServerStarted(FMLServerStartedEvent event) {
		proxy.onServerStarted(event);
	}

	@Mod.EventHandler
	public void onServerStopped(FMLServerStoppedEvent event) {
		proxy.onServerStopped(event);
	}

	public void onWorldGen(EntityJoinWorldEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;

		}
	}
}
