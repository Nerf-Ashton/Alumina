package net.nerfashton.alumina.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.nerfashton.alumina.block.ModBlocks;
import net.nerfashton.alumina.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);

    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        //List<ItemLike> = SMELTABLE
        /*ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.HASTELLOY_CASING.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.REGISTERED_METALS.get(3))
                .save(recipeOutput);*/
    }
}
