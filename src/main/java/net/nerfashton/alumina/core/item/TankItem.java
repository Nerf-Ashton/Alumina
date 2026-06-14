package net.nerfashton.alumina.core.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.nerfashton.alumina.item.ModItems;

import javax.annotation.Nullable;

public class TankItem extends SolidBucketItem {
    public final Fluid content;

    public TankItem(Block block, Properties properties, Fluid content) {
        super(block, SoundEvents.BREEZE_INHALE, properties);
        this.content = content;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult interactionresult = super.useOn(context);
        Player player = context.getPlayer();
        if (interactionresult.consumesAction() && player != null && this.content != Fluids.EMPTY) {
            player.setItemInHand(context.getHand(), TankItem.getEmptySuccessItem(context.getItemInHand(), player));
        }

        return interactionresult;
    }

    //Places air block
    @Override
    public boolean emptyContents(@javax.annotation.Nullable Player player, Level level, BlockPos pos, @Nullable BlockHitResult result) {
        if (level.isInWorldBounds(pos) && level.isEmptyBlock(pos)) {
            if (!level.isClientSide) {
                level.setBlock(pos, this.getBlock().defaultBlockState(), 3);
            }

            level.gameEvent(player, GameEvent.FLUID_PLACE, pos);
            level.playSound(player, pos, SoundEvents.BREEZE_INHALE, SoundSource.HOSTILE, 1.0F, 1.0F);
            return true;
        } else {
            return false;
        }
    }

    public static ItemStack getEmptySuccessItem(ItemStack bucketStack, Player player) {
        return !player.hasInfiniteMaterials() ? new ItemStack(ModItems.GAS_TANK.get()) : bucketStack;
    }
}
