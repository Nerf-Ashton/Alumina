package net.nerfashton.alumina.fluid;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.core.fluid.BaseFluidType;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_flow");

    public static final ResourceLocation MERCURY_STILL_RL = ResourceLocation.fromNamespaceAndPath(Alumina.MOD_ID, "block/mercury_still");
    public static final ResourceLocation MERCURY_FLOWING_RL = ResourceLocation.fromNamespaceAndPath(Alumina.MOD_ID, "block/mercury_flowing");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Alumina.MOD_ID);

    public static final DeferredHolder<FluidType, BaseFluidType> BROMINE_FLUID_TYPE =
            FLUID_TYPES.register("bromine_fluid", () -> new BaseFluidType(
                    FluidType.Properties.create().density(3000).viscosity(6000).canSwim(false).canDrown(true).canExtinguish(false).canConvertToSource(false).supportsBoating(false),
                    WATER_STILL_RL, WATER_FLOWING_RL, 0xD8744701, new Vector3f(116f / 255f, 71f / 255f, 1f / 255f)));
    public static final DeferredHolder<FluidType, BaseFluidType> MERCURY_FLUID_TYPE =
            FLUID_TYPES.register("mercury_fluid", () -> new BaseFluidType(
                    FluidType.Properties.create().density(3000).viscosity(6000).canSwim(false).canDrown(true).canExtinguish(false).canConvertToSource(false).supportsBoating(false),
                    MERCURY_STILL_RL, MERCURY_FLOWING_RL, 0xD8C7C1B9, new Vector3f(199f / 255f, 193f / 255f, 185f / 255f)));

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
