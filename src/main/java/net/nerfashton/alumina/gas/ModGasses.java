package net.nerfashton.alumina.gas;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.block.ModBlocks;
import net.nerfashton.alumina.item.ModItems;

public class ModGasses {
    public static final DeferredRegister<Fluid> GASSES =
            DeferredRegister.create(Registries.FLUID, Alumina.MOD_ID);

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SOURCE_RADON = GASSES.register("source_radon",
            () -> new BaseFlowingFluid.Source(ModGasses.RADON_PROPERTIES));
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_RADON = GASSES.register("flowing_radon",
            () -> new BaseFlowingFluid.Flowing(ModGasses.RADON_PROPERTIES));

    public static final BaseFlowingFluid.Properties RADON_PROPERTIES = new BaseFlowingFluid.Properties(
            ModGasTypes.RADON_GAS_TYPE, SOURCE_RADON, FLOWING_RADON)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.RADON_GAS_BLOCK);

    public static void register(IEventBus eventBus) {
        GASSES.register(eventBus);
    }
}
