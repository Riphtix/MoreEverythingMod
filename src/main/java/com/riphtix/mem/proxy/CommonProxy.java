package com.riphtix.mem.proxy;

import com.riphtix.mem.MoreEverythingMod;
import com.riphtix.mem.server.cmd.CommandDragon;
import com.riphtix.mem.server.entity.EntityTameableDragon;
import com.riphtix.mem.server.handler.DragonEggBlockHandler;
import com.riphtix.mem.server.network.DragonControlMessage;
import com.riphtix.mem.server.network.DragonControlMessageHandler;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {
	public void registerRenders(){

	}
	private SimpleNetworkWrapper network;
	public final byte DCM_DISCRIMINATOR_ID = 35;  // arbitrary non-zero ID (non-zero makes troubleshooting easier)

	public SimpleNetworkWrapper getNetwork() {
		return network;
	}

	public void onInit(FMLInitializationEvent evt) {
		registerEntities();

		if (MoreEverythingMod.instance.getConfig().isEggsInChests()) {
			registerChestItems();
		}

		MinecraftForge.EVENT_BUS.register(new DragonEggBlockHandler());
		network = NetworkRegistry.INSTANCE.newSimpleChannel("DragonControls");
		network.registerMessage(DragonControlMessageHandler.class, DragonControlMessage.class, DCM_DISCRIMINATOR_ID, Side.SERVER);
	}

	public void onPostInit(FMLPostInitializationEvent event)
	{

	}

	public void onServerStarted(FMLServerStartedEvent evt) {
		MinecraftServer server = MinecraftServer.getServer();
		ServerCommandManager cmdman = (ServerCommandManager) server.getCommandManager();
		cmdman.registerCommand(new CommandDragon());
	}

	public void onServerStopped(FMLServerStoppedEvent evt) {
	}

	private void registerEntities() {
//        int dragonEntityID = MoreEverythingMod.instance.getConfig().getDragonEntityID();
//        if (dragonEntityID == -1) {
//            dragonEntityID = EntityRegistry.findGlobalUniqueEntityId();
//        }
//
//        EntityRegistry.registerGlobalEntityID(EntityTameableDragon.class, "DragonMount",
//                dragonEntityID, 0, 0xcc00ff);

		final int TRACKING_RANGE = 80;
		final int UPDATE_FREQUENCY = 3;
		final int DRAGON_ENTITY_ID = 26;
		EntityRegistry.registerModEntity(EntityTameableDragon.class, "mem", DRAGON_ENTITY_ID,
				MoreEverythingMod.instance, TRACKING_RANGE, UPDATE_FREQUENCY, true);
	}

	public void registerChestItems() {
		ChestGenHooks chestGenHooksDungeon = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		chestGenHooksDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.dragon_egg), 1, 1, 70));
		// chance < saddle (1/16, ca. 6%, in max 8 slots -> 40% at least 1 egg, 0.48 eggs per chest): I think that's okay

		ChestGenHooks chestGenHooksMineshaft = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		chestGenHooksMineshaft.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.dragon_egg), 1, 1, 5));
		// chance == gold ingot (1/18, ca. 6%, in 3-6 slots -> 23% at least 1 egg, 0.27 eggs per chest):
		// exploring a random mine shaft in creative mode yielded 2 eggs out of about 10 chests in 1 hour

		ChestGenHooks chestGenHooksJungleChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		chestGenHooksJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.dragon_egg), 1, 1, 15));
		// chance == gold ingot (15/81, ca. 18%, in 2-5 slots -> 51% at least 1 egg, 0.65 eggs per chest, 1.3 eggs per temple):
		// jungle temples are so rare, it should be rewarded

		ChestGenHooks chestGenHooksDesertChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		chestGenHooksDesertChest.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.dragon_egg), 1, 1, 10));
		// chance == iron ingot (10/76, ca. 13%, in 2-5 slots -> 39% at least 1 egg, 0.46 eggs per chest, 1.8 eggs per temple):
		// desert temples are so rare, it should be rewarded
	}
}
