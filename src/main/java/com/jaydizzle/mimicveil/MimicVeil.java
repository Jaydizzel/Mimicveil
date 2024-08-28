package com.jaydizzle.mimicveil;

import com.jaydizzle.mimicveil.block.JDBlocks;
import com.jaydizzle.mimicveil.entity.JDEntities;
import com.jaydizzle.mimicveil.entity.client.MimicRenderer;
import com.jaydizzle.mimicveil.item.JDCreativeModeTab;
import com.jaydizzle.mimicveil.item.JDItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MimicVeil.MOD_ID)
public class MimicVeil
{
    public static final String MOD_ID = "mimicveil";
    private static final Logger LOGGER = LogManager.getLogger();


    public MimicVeil() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        JDItems.register(eventBus);
        JDBlocks.register(eventBus);
        JDEntities.register(eventBus);
        JDCreativeModeTab.register(eventBus);

        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(JDEntities.MIMIC.get(), MimicRenderer::new);

        }
    }
}