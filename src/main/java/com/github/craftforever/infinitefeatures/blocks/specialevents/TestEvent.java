package com.github.craftforever.infinitefeatures.blocks.specialevents;

import java.util.EnumSet;

import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IFloatValuePicker;

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

public class TestEvent extends CallbackDecorator {

	private static final EnumSet<CallbackDependencies> dependencies = EnumSet.of(CallbackDependencies.BLOCK);

	protected IFloatValuePicker lightLevel;

	public TestEvent(ICallbackEvent child, IFloatValuePicker lightLevel)
	{
		super(child, dependencies);
		this.lightLevel = lightLevel;
	}

	@Override
	public void Execute(OreWithSpecialEvents block, Entity relatedEntity, EntityLivingBase relatedLivingEntity,
			World world, BlockPos blockPos, boolean bool, Explosion explosion, IBlockState blockState,
			EntityPlayer player, EnumHand hand, EnumFacing facing, ItemStack stack, float unkFloat,
			IBlockAccess blockAccess) {
		
		if (block != null){
			block.setLightLevel(lightLevel.getFloat());
		}

		super.child.Execute(block, relatedEntity, relatedLivingEntity, world, blockPos, bool, explosion, blockState, player, hand, facing, stack, unkFloat, blockAccess);
	}
}