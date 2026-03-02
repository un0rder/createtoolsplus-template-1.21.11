package com.un0rder.createtoolsplus.block;


import com.un0rder.createtoolsplus.CreateToolsPlus;
import com.un0rder.createtoolsplus.item.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.Block;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS=
            DeferredRegister.createBlocks(CreateToolsPlus.MODID);
    public static final DeferredBlock<Block> CUP_BLOCK=registerBlock("cup_block",Block::new,
            ()->BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS),true);
    public static final DeferredBlock<Block> CARDBOARD_BLOCK=registerBlock("cardboard_block",
            properties -> new Block(properties.strength(1.0f,3.0f).requiresCorrectToolForDrops()),true);
    private static <T extends Block>DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func, Supplier<BlockBehaviour.Properties> properties,boolean shouldRegisterItem ) {
        DeferredBlock<T> block=BLOCKS.registerBlock(name,func,properties);
        if(shouldRegisterItem) ModItems.ITEMS.registerSimpleBlockItem(block);
        return block;
    }
    private static <T extends Block>DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func,boolean shouldRegisterItem ) {
        DeferredBlock<T> block=BLOCKS.registerBlock(name,func);
        if(shouldRegisterItem) ModItems.ITEMS.registerSimpleBlockItem(block);
        return block;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
