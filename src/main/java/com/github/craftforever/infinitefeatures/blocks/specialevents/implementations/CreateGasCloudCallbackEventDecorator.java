package com.github.craftforever.infinitefeatures.blocks.specialevents.implementations;

import java.util.EnumSet;

import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDependencies;
import com.github.craftforever.infinitefeatures.blocks.specialevents.ICallbackEvent;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IIntValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IFloatValuePicker;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CreateGasCloudCallbackEventDecorator extends CallbackDecorator {

	protected IFloatValuePicker radius;
	protected IIntValuePicker duration;
	protected IFloatValuePicker expansion_modifier;
	protected IIntValuePicker potionID;
	protected IIntValuePicker effect_duration;
	protected IIntValuePicker effect_level;

	private static final EnumSet<CallbackDependencies> dependencies = EnumSet.of(CallbackDependencies.WORLD,
			CallbackDependencies.BLOCKPOS);

	public CreateGasCloudCallbackEventDecorator(IFloatValuePicker radius, IIntValuePicker duration,
			IFloatValuePicker expansion_modifier, IIntValuePicker potionID, IIntValuePicker effect_duration,
			IIntValuePicker effect_level, ICallbackEvent child) {

		super(child, dependencies);
		this.radius = radius;
		this.duration = duration;
		this.expansion_modifier = expansion_modifier;
		this.potionID = potionID;
		this.effect_duration = effect_duration;
		this.effect_level = effect_level;
	}

	@Override
	public void Execute(OreWithSpecialEvents block, Entity relatedEntity, EntityLivingBase relatedLivingEntity,
			World world, BlockPos blockPos, boolean bool, Explosion explosion, IBlockState blockState,
			EntityPlayer player, EnumHand hand, EnumFacing facing, ItemStack stack, float unkFloat,
			IBlockAccess blockAccess) {
		if (world != null && blockPos != null) {

			EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, blockPos.getX(),
					blockPos.getY(), blockPos.getZ());
			entityareaeffectcloud.setOwner(null);
			entityareaeffectcloud.setRadius(radius.getFloat());
			entityareaeffectcloud.setDuration(duration.getInt());
			entityareaeffectcloud.setRadiusPerTick((expansion_modifier.getFloat() - entityareaeffectcloud.getRadius())
					/ (float) entityareaeffectcloud.getDuration());

			entityareaeffectcloud.addEffect(
				new PotionEffect(
					Potion.getPotionById(potionID.getInt()), 
					duration.getInt(), 
					effect_level.getInt()
				)
			);

			world.spawnEntity(entityareaeffectcloud);

		}
		super.child.Execute(block, relatedEntity, relatedLivingEntity, world, blockPos, bool, explosion, blockState, player, hand, facing, stack, unkFloat, blockAccess);
		
	}
}