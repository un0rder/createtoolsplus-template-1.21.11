package com.un0rder.createtoolsplus.item;

import com.un0rder.createtoolsplus.CreateToolsPlus;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS=
            DeferredRegister.createItems(CreateToolsPlus.MODID);
    public static final DeferredItem<Item> CUP =
            ITEMS.registerSimpleItem("cup");
    public static final DeferredItem<Item> CARDBOARD=
            ITEMS.registerSimpleItem("material/cardboard");
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

