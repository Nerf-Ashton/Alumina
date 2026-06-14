package net.nerfashton.alumina.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.block.custom.GasBurnerBlock;
import net.nerfashton.alumina.fluid.ModFluids;
import net.nerfashton.alumina.gas.ModGasses;
import net.nerfashton.alumina.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Alumina.MOD_ID);

    public static final DeferredBlock<Block> STAINLESS_STEEL_CASING = registerBlock("stainless_steel_casing",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.METAL)
                    .strength(2f)
            ));
    public static final DeferredBlock<Block> HASTELLOY_CASING = registerBlock("hastelloy_casing",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.METAL)
                    .strength(2f)
            ));

    public static final DeferredBlock<GasBurnerBlock> GAS_BURNER = registerBlock("gas_burner",
            () -> new GasBurnerBlock(BlockBehaviour.Properties.of().noOcclusion().noLootTable()));


    public static final DeferredBlock<LiquidBlock> RADON_GAS_BLOCK = BLOCKS.register("radon_gas",
            () -> new LiquidBlock(ModGasses.SOURCE_RADON.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    public static final DeferredBlock<LiquidBlock> BROMINE_FLUID_BLOCK = BLOCKS.register("bromine_fluid",
            () -> new LiquidBlock(ModFluids.SOURCE_BROMINE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final DeferredBlock<LiquidBlock> MERCURY_FLUID_BLOCK = BLOCKS.register("mercury_fluid",
            () -> new LiquidBlock(ModFluids.SOURCE_MERCURY.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
