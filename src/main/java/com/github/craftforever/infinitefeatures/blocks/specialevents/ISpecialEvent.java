package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomIngotOre;
import com.github.craftforever.infinitefeatures.blocks.RandomGemOre;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public interface ISpecialEvent 
{
	public void Execute(RandomIngotOre block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity);
	public void ExecuteGem(RandomGemOre block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity);
}
