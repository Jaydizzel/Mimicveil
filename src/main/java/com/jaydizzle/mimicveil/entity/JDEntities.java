package com.jaydizzle.mimicveil.entity;

import com.jaydizzle.mimicveil.MimicVeil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JDEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MimicVeil.MOD_ID);

    public static final RegistryObject<EntityType<MimicEntity>> MIMIC = ENTITY_TYPES.register("mimic",
            () -> EntityType.Builder.of(MimicEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f)
                    .build(new ResourceLocation(MimicVeil.MOD_ID, "mimic").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}