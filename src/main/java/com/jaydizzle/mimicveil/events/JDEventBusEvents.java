package com.jaydizzle.mimicveil.events;

import com.jaydizzle.mimicveil.MimicVeil;
import com.jaydizzle.mimicveil.entity.JDEntities;
import com.jaydizzle.mimicveil.entity.MimicEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MimicVeil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JDEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(JDEntities.MIMIC.get(), MimicEntity.createAttributes().build());

    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(JDEntities.MIMIC.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MimicEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);

    }
}
