package com.jaydizzle.mimicveil.events;

import com.jaydizzle.mimicveil.MimicVeil;
import com.jaydizzle.mimicveil.entity.client.JDModelLayers;
import com.jaydizzle.mimicveil.entity.client.MimicModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MimicVeil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JDEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(JDModelLayers.MIMIC_LAYER, MimicModel::createBodyLayer);

    }

}
