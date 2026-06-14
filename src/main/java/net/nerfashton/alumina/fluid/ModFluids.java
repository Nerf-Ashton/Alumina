package net.nerfashton.alumina.fluid;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.block.ModBlocks;
import net.nerfashton.alumina.item.ModItems;


public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, Alumina.MOD_ID);

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SOURCE_BROMINE = FLUIDS.register("source_bromine",
            () -> new BaseFlowingFluid.Source(ModFluids.BROMINE_PROPERTIES));
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_BROMINE = FLUIDS.register("flowing_bromine",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BROMINE_PROPERTIES));

    public static final BaseFlowingFluid.Properties BROMINE_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.BROMINE_FLUID_TYPE, SOURCE_BROMINE, FLOWING_BROMINE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.BROMINE_FLUID_BLOCK).bucket(ModItems.BROMINE_BUCKET);

    public static final DeferredHolder<Fluid, BaseFlowingFluid.Source> SOURCE_MERCURY = FLUIDS.register("source_mercury",
            () -> new BaseFlowingFluid.Source(ModFluids.MERCURY_PROPERTIES));
    public static final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING_MERCURY = FLUIDS.register("flowing_mercury",
            () -> new BaseFlowingFluid.Flowing(ModFluids.MERCURY_PROPERTIES));

    public static final BaseFlowingFluid.Properties MERCURY_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.MERCURY_FLUID_TYPE, SOURCE_MERCURY, FLOWING_MERCURY)
            .slopeFindDistance(2).levelDecreasePerBlock(4).block(ModBlocks.MERCURY_FLUID_BLOCK).bucket(ModItems.MERCURY_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
