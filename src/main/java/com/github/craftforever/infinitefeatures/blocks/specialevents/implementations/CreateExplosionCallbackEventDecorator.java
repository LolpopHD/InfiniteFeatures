package com.github.craftforever.infinitefeatures.blocks.specialevents.implementations;

import java.util.EnumSet;

import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDependencies;
import com.github.craftforever.infinitefeatures.blocks.specialevents.ICallbackEvent;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.INumberValuePicker;

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

public class CreateExplosionCallbackEventDecorator extends CallbackDecorator {

	protected INumberValuePicker strength;
	protected IBoolValuePicker damagesTerrain;

	private static final EnumSet<CallbackDependencies> dependencies = EnumSet.of(CallbackDependencies.WORLD,
			CallbackDependencies.BLOCKPOS);

	public CreateExplosionCallbackEventDecorator(INumberValuePicker strength, IBoolValuePicker damagesTerrain, ICallbackEvent child) {
		super(child, dependencies);
		this.strength = strength;
		this.damagesTerrain = damagesTerrain;
	}

	@Override
	public void Execute(OreWithSpecialEvents block, Entity relatedEntity, EntityLivingBase relatedLivingEntity,
			World world, BlockPos blockPos, Boolean bool, Explosion explosion, IBlockState blockState,
			EntityPlayer player, EnumHand hand, EnumFacing facing, ItemStack stack, Float unkFloat,
			IBlockAccess blockAccess) {

		if (world != null && blockPos != null&&!world.isRemote) {
				world.setBlockToAir(blockPos);
				world.createExplosion(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), strength.getNumber().floatValue(), damagesTerrain.getBoolean());
		}
		
		super.child.Execute(block, relatedEntity, relatedLivingEntity, world, blockPos, bool, explosion, blockState, player, hand, facing, stack, unkFloat, blockAccess);
	}

	@Override
	public String getDescription() {
		return "CreateExplosion" + " : " + child.getDescription();
	}
}