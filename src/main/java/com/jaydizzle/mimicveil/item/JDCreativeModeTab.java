package com.jaydizzle.mimicveil.item;

import com.jaydizzle.mimicveil.MimicVeil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class JDCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MimicVeil.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MIMIC_TAB = CREATIVE_MODE_TABS.register("mimic_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(JDItems.MIMIC_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.mimic_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(JDItems.MIMIC_SPAWN_EGG.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}