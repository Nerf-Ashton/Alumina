package net.nerfashton.alumina.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.item.material.MetallicEnum;

import java.util.ArrayList;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Alumina.MOD_ID);
    public static final ArrayList<DeferredItem<Item>> REGISTERED_METALS = new ArrayList<>();

    public static void createIngots() {
        ArrayList<String> metals = MetallicEnum.getMetals();
        for (String name : metals) {
            ModItems.registerItem(name + "_ingot");
        }
    }

    //public static final DeferredItem<Item> GALLIUM_INGOT = registerItem("gallium_blingort");

    private static void registerItem(String name) {
        DeferredItem<Item> NEW_ITEM = ITEMS.register(name, () -> new Item(new Item.Properties()));
        REGISTERED_METALS.add(NEW_ITEM);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
