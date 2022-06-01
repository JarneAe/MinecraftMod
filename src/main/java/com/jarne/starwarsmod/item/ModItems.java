package com.jarne.starwarsmod.item;

import com.jarne.starwarsmod.item.custom.DowsingRodItem;
import com.jarne.starwarsmod.starwarsmod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, starwarsmod.MOD_ID);

    public static final RegistryObject<Item> BESKAR = ITEMS.register("beskar",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.MOD_TAB).durability(16)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

}
