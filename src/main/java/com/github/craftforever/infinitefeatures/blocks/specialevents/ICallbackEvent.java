package com.github.craftforever.infinitefeatures.blocks.specialevents;

import java.util.EnumSet;

import javax.annotation.Nullable;

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

public interface ICallbackEvent 
{
	// which callbacks this specialevent is compatable with
	public EnumSet<CallbackDependencies> getCallbackDependencies();

	public String getDescription();

	/**
	 * Interface to implement when adding a random functionaility to a block.
	 * <p>
	 * You will regret not checking for nulls
	 * </p>
	 *
	 * @param  block instance of the block that called Execute.
	 * @param  nullable_relatedEntity if the event fired has reference to an Entity it will pass this, else null.
	 * @param  nullable_relatedLivingEntity if the event fired has reference to an LivingEntity it will pass this, else null.
	 * @param  nullable_world if the event fired has reference to the world it will pass this, else null.
	 */
	public void Execute(OreWithSpecialEvents block, @Nullable Entity relatedEntity, 
	@Nullable EntityLivingBase relatedLivingEntity, @Nullable World world, 
	@Nullable BlockPos blockPos, @Nullable Boolean bool, @Nullable Explosion explosion,
	@Nullable IBlockState blockState, @Nullable EntityPlayer player, @Nullable EnumHand hand, 
	@Nullable EnumFacing facing, @Nullable ItemStack stack, @Nullable Float unkFloat, 
	@Nullable IBlockAccess blockAccess);
}
