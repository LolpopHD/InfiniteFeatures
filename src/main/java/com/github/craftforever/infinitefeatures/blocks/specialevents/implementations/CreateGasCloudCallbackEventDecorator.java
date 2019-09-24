package com.github.craftforever.infinitefeatures.blocks.specialevents.implementations;

import java.util.EnumSet;

import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDependencies;
import com.github.craftforever.infinitefeatures.blocks.specialevents.ICallbackEvent;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.INumberValuePicker;
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

	protected INumberValuePicker radius;
	protected INumberValuePicker duration;
	protected INumberValuePicker expansion_modifier;
	protected INumberValuePicker potionID;
	protected INumberValuePicker effect_duration;
	protected INumberValuePicker effect_level;

	private static final EnumSet<CallbackDependencies> dependencies = EnumSet.of(CallbackDependencies.WORLD,
			CallbackDependencies.BLOCKPOS);

	public CreateGasCloudCallbackEventDecorator(INumberValuePicker radius, INumberValuePicker duration,
	INumberValuePicker expansion_modifier, INumberValuePicker potionID, INumberValuePicker effect_duration,
	INumberValuePicker effect_level, ICallbackEvent child) {

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
			World world, BlockPos blockPos, Boolean bool, Explosion explosion, IBlockState blockState,
			EntityPlayer player, EnumHand hand, EnumFacing facing, ItemStack stack, Float unkFloat,
			IBlockAccess blockAccess) {
		if (world != null && blockPos != null) {

			EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, blockPos.getX(),
					blockPos.getY(), blockPos.getZ());
			entityareaeffectcloud.setOwner(null);
			entityareaeffectcloud.setRadius(radius.getNumber().floatValue());
			entityareaeffectcloud.setDuration(duration.getNumber().intValue());
			entityareaeffectcloud.setRadiusPerTick((expansion_modifier.getNumber().floatValue() - entityareaeffectcloud.getRadius())
					/ (float) entityareaeffectcloud.getDuration());
					
			entityareaeffectcloud.addEffect(
				new PotionEffect(
					Potion.getPotionById(potionID.getNumber().intValue() - 1), 
					duration.getNumber().intValue(), 
					effect_level.getNumber().intValue()
				)
			);

			world.spawnEntity(entityareaeffectcloud);

		}
		super.child.Execute(block, relatedEntity, relatedLivingEntity, world, blockPos, bool, explosion, blockState, player, hand, facing, stack, unkFloat, blockAccess);
		
	}

	@Override
	public String getDescription() {
		return "CreateGasCloud" + " : " + child.getDescription();
	}
}