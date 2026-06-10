package net.nerfashton.alumina.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.nerfashton.alumina.Alumina;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Alumina.MOD_ID, name));
        }
    }

    public static class Items {
        //public static final TagKey<Item> TAG_NAME = createTag("tag_name");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Alumina.MOD_ID, name));
        }
    }
}
