package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.helpers.RandomHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GasCloud implements ISpecialEvent {

	protected PotionType potType;
	protected ItemStack potItem;

	protected float radius;

	protected int duration;
	protected float expansion_modifier;

	protected int potionID;
	
	protected float effect_duration_min;
    protected float effect_duration_max;
    protected float effect_duration_mean;
    protected float effect_duration_std;
    protected int   effect_level_min;
    protected int   effect_level_max;
    protected float effect_level_mean;
    protected float effect_level_std;

	@Override
	public void Execute(OreWithSpecialEvents block, Entity relatedEntity, EntityLivingBase relatedLivingEntity, World world, BlockPos blockPos) 
		{
			if (world != null)
			{
				if (blockPos != null)
				{
					int potDuration = (int)Math.round(RandomHelper.getRandomGaussianInRange((double)effect_duration_mean, (double)effect_duration_std, (double)effect_duration_min, (double)effect_duration_max));
					int potLevel = (int)Math.round(RandomHelper.getRandomGaussianInRange((double)effect_level_mean, (double)effect_level_std, (double)effect_level_min, (double)effect_level_max));


					EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(world, blockPos.getX(), blockPos.getY(), blockPos.getZ());
					entityareaeffectcloud.setOwner(null);
					entityareaeffectcloud.setRadius(radius);
					entityareaeffectcloud.setDuration(duration);
					entityareaeffectcloud.setRadiusPerTick((expansion_modifier - entityareaeffectcloud.getRadius()) / (float)entityareaeffectcloud.getDuration());
					entityareaeffectcloud.addEffect(new PotionEffect(Potion.getPotionById(potionID), potDuration, potLevel));

					for (PotionEffect potioneffect : PotionUtils.getFullEffectsFromItem(potItem))
					{
						entityareaeffectcloud.addEffect(new PotionEffect(potioneffect));
					}

					NBTTagCompound nbttagcompound = potItem.getTagCompound();

					if (nbttagcompound != null && nbttagcompound.hasKey("CustomPotionColor", 99))
					{
						entityareaeffectcloud.setColor(nbttagcompound.getInteger("CustomPotionColor"));
					}

					world.spawnEntity(entityareaeffectcloud);
				}
			}
	}
}