package com.github.craftforever.infinitefeatures.blocks.specialevents;

import java.util.EnumSet;

import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DoNothingCallbackEvent implements ICallbackEvent {

    @Override
    public EnumSet<CallbackDependencies> getCallbackDependencies() {
        return CallbackDependencies.NO_OPTS;
    }

    @Override
    public void Execute(OreWithSpecialEvents block, Entity relatedEntity, EntityLivingBase relatedLivingEntity,
            World world, BlockPos blockPos, boolean bool, Explosion explosion, IBlockState blockState,
            EntityPlayer player, EnumHand hand, EnumFacing facing, ItemStack stack, float unkFloat,
            IBlockAccess blockAccess) {
        

    }
    
}