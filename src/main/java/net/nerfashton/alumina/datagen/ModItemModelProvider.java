package net.nerfashton.alumina.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.nerfashton.alumina.Alumina;
import net.nerfashton.alumina.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Alumina.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (var item : ModItems.REGISTERED_ELEMENTS) {
            try {
                basicItem(item.get());
            } catch(Exception e) {
                System.out.println(item.get() + " failed");
            }
        }
        basicItem(ModItems.BROMINE_BUCKET.get());
        basicItem(ModItems.MERCURY_BUCKET.get());
    }
}
