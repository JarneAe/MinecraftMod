package com.jarne.starwarsmod.block;

import com.jarne.starwarsmod.block.custom.MovingWalkway;
import com.jarne.starwarsmod.item.ModCreativeModeTab;
import com.jarne.starwarsmod.item.ModItems;
import com.jarne.starwarsmod.starwarsmod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, starwarsmod.MOD_ID);

    public static final RegistryObject<Block> SPICE_BLOCK = registerBlock("spice_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.MOD_TAB);

    public static final RegistryObject<Block> BESKAR_BLOCK = registerBlock("beskar_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.MOD_TAB);

    public static final RegistryObject<Block> WALKWAY_BLOCK = registerBlock("walkway_block",
            ()-> new MovingWalkway(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.MOD_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,CreativeModeTab tab){
        RegistryObject toReturn = BLOCKS.register(name,block);
        RegisterBlockItem(name, toReturn,tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
