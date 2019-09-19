package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomOre;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public interface ISpecialEvent 
{
	public void Execute(RandomOre block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity);
}
