package net.nerfashton.alumina.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.block.ModBlocks;
import net.nerfashton.alumina.item.ModItems;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, Alumina.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (var item : ModItems.REGISTERED_ELEMENTS) {
            add(item.get(), makeHumanReadable(item.getRegisteredName()));
        }
        add(ModItems.RADON_GAS_TANK.get(), makeHumanReadable(ModItems.RADON_GAS_TANK.getRegisteredName()));

        //add(ModBlocks.HASTELLOY_CASING.get(), makeHumanReadable(ModBlocks.HASTELLOY_CASING.getRegisteredName()));

        add("creativetab.alumina.items_tab", "Alumina Items");
        add("creativetab.alumina.blocks_tab", "Alumina Blocks");
    }

    public static String makeHumanReadable(String inputString) {
        String simplifiedInput = inputString.replace("_", " ").replace("alumina:", "");
        String[] words = simplifiedInput.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(Character.toTitleCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }
 }
