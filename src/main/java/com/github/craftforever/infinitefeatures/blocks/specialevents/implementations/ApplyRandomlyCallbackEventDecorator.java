package com.github.craftforever.infinitefeatures.blocks.specialevents.implementations;

import java.util.EnumSet;

import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDependencies;
import com.github.craftforever.infinitefeatures.blocks.specialevents.ICallbackEvent;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;
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

public class ApplyRandomlyCallbackEventDecorator extends CallbackDecorator {

    public IBoolValuePicker applyRandomlyPicker;

    private static final EnumSet<CallbackDependencies> dependencies = CallbackDependencies.NO_OPTS;

    public ApplyRandomlyCallbackEventDecorator(IBoolValuePicker applyRandomlyPicker, ICallbackEvent child) {
        super(child, dependencies);
        this.applyRandomlyPicker = applyRandomlyPicker;
    }

    @Override
    public void Execute(OreWithSpecialEvents block, Entity relatedEntity, EntityLivingBase relatedLivingEntity,
            World world, BlockPos blockPos, boolean bool, Explosion explosion, IBlockState blockState,
            EntityPlayer player, EnumHand hand, EnumFacing facing, ItemStack stack, float unkFloat,
            IBlockAccess blockAccess) {

        if (applyRandomlyPicker.getBoolean()) {
            super.child.Execute(block, relatedEntity, relatedLivingEntity, world, blockPos, bool, explosion, blockState, player, hand, facing, stack, unkFloat, blockAccess);
        }

    }

}