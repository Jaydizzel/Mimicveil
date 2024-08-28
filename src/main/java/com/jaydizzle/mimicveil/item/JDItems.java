package com.jaydizzle.mimicveil.item;

import com.jaydizzle.mimicveil.MimicVeil;
import com.jaydizzle.mimicveil.entity.JDEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MimicVeil.MOD_ID);
    public static final RegistryObject<Item> MIMIC_SPAWN_EGG = ITEMS.register("mimic_spawn_egg",
            () -> new ForgeSpawnEggItem(JDEntities.MIMIC, 0x9B662C, 0xAB1111,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

}
