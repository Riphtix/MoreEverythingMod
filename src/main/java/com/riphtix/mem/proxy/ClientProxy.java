package com.riphtix.mem.proxy;

import com.riphtix.mem.MoreEverythingMod;
import com.riphtix.mem.client.gui.GuiDragonDebug;
import com.riphtix.mem.client.handler.DragonControl;
import com.riphtix.mem.client.render.DragonRenderer;
import com.riphtix.mem.init.MoreBlocks;
import com.riphtix.mem.init.MoreItems;
import com.riphtix.mem.server.entity.EntityTameableDragon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders(){
		MoreBlocks.registerRenders();
		MoreItems.registerRenders();
	}

	@Override
	public void onInit(FMLInitializationEvent evt) {
		super.onInit(evt);
	}

	@Override
	public void onPostInit(FMLPostInitializationEvent event)
	{
		if (MoreEverythingMod.instance.getConfig().isDebug()) {
			MinecraftForge.EVENT_BUS.register(new GuiDragonDebug());
		}

		RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
		RenderingRegistry.registerEntityRenderingHandler(EntityTameableDragon.class, new DragonRenderer(renderManager));

		FMLCommonHandler.instance().bus().register(new DragonControl(getNetwork()));
	}
}
