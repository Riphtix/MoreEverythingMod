package com.riphtix.mem;

import com.riphtix.mem.init.MoreBlocks;
import com.riphtix.mem.init.MoreItems;
import com.riphtix.mem.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod (modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MoreEverythingMod {

	@SidedProxy (clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		MoreBlocks.init();
		MoreBlocks.register();
		MoreItems.init();
		MoreItems.register();

		GameRegistry.registerWorldGenerator(new MoreOresGeneration(), 0);
	}

	@Mod.EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}

}
