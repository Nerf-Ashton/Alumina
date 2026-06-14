package net.nerfashton.alumina.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Alumina.MOD_ID);

    public static final Supplier<CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TAB.register("items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.REGISTERED_ELEMENTS.getFirst().get()))
                    .title(Component.translatable("creativetab.alumina.items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for (var item : ModItems.REGISTERED_ELEMENTS) {
                            output.accept(item.get());
                            }
                        output.accept(ModItems.RADON_GAS_TANK);
                        output.accept(ModItems.GAS_TANK);
                    }).build());

    public static final Supplier<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TAB.register("blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.HASTELLOY_CASING))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Alumina.MOD_ID, "items_tab"))
                    .title(Component.translatable("creativetab.alumina.blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.HASTELLOY_CASING);
                        output.accept(ModBlocks.STAINLESS_STEEL_CASING);
                        output.accept(ModBlocks.GAS_BURNER);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
