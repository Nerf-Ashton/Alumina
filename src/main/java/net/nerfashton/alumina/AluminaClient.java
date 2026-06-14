package net.nerfashton.alumina;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.nerfashton.alumina.core.fluid.BaseFluidType;
import net.nerfashton.alumina.fluid.ModFluidTypes;
import net.nerfashton.alumina.gas.ModGasTypes;
import org.joml.Vector3f;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = Alumina.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = Alumina.MOD_ID, value = Dist.CLIENT)
public class AluminaClient {
    public AluminaClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerFluidExtensions(RegisterClientExtensionsEvent event) {

        BaseFluidType bromine = ModFluidTypes.BROMINE_FLUID_TYPE.get();
        BaseFluidType mercury = ModFluidTypes.MERCURY_FLUID_TYPE.get();
        BaseFluidType radon = ModGasTypes.RADON_GAS_TYPE.get();

        registerNewFluidEvent(bromine, event);
        registerNewFluidEvent(mercury, event);
        registerNewFluidEvent(radon, event);

        /*event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return bromine.getStillTexture();
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return bromine.getFlowingTexture();
            }

            @Override
            public int getTintColor() {
                return bromine.getTintColor();
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return bromine.getFogColor();
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(1f);
                RenderSystem.setShaderFogEnd(6f);
            }
        }, bromine);*/
    }
    public static void registerNewFluidEvent(BaseFluidType fluidtype, RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return fluidtype.getStillTexture();
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return fluidtype.getFlowingTexture();
            }

            @Override
            public int getTintColor() {
                return fluidtype.getTintColor();
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return fluidtype.getFogColor();
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(1f);
                RenderSystem.setShaderFogEnd(6f);
            }
        }, fluidtype);
    }
}
