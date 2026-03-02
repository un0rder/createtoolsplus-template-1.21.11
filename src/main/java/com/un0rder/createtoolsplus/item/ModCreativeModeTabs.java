package com.un0rder.createtoolsplus.item;

import com.un0rder.createtoolsplus.CreateToolsPlus;
import com.un0rder.createtoolsplus.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.network.chat.Component; // 物品组标题的文本组件
import net.minecraft.world.item.ItemStack; // 物品栈，用于设置创造模式标签的图标
import net.neoforged.bus.api.IEventBus; // NeoForge 正确的事件总线包


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateToolsPlus.MODID);
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> CREATETOOLSPLUS_TAB =
            CREATIVE_MODE_TABS.register("createtoolsplus_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CUP.get()))
                    .title(Component.translatable("itemGroup.createtoolsplus_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.CUP);
                        output.accept(ModItems.CARDBOARD);
                        output.accept(ModBlocks.CUP_BLOCK);
                        output.accept(ModBlocks.CARDBOARD_BLOCK);
                    }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
