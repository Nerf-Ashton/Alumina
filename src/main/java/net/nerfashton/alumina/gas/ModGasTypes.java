package net.nerfashton.alumina.gas;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.core.fluid.BaseFluidType;
import org.joml.Vector3f;

public class ModGasTypes {
    public static ResourceLocation GAS_STILL = ResourceLocation.fromNamespaceAndPath(Alumina.MOD_ID, "block/gas_still");

    public static final DeferredRegister<FluidType> GAS_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Alumina.MOD_ID);

    public static final DeferredHolder<FluidType, BaseFluidType> RADON_GAS_TYPE =
            GAS_TYPES.register("radon_gas", () -> new BaseFluidType(
                    FluidType.Properties.create().density(300).viscosity(300).canSwim(false).canDrown(true).canExtinguish(false).canConvertToSource(false).supportsBoating(false),
                    GAS_STILL, GAS_STILL, 0xA100FF00, new Vector3f(0f / 255f, 254f / 255f, 1f / 255f)));


    public static void register(IEventBus eventBus) {
        GAS_TYPES.register(eventBus);
    }
}
