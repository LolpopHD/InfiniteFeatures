package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomGemOre;
import com.github.craftforever.infinitefeatures.blocks.RandomIngotOre;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class TestEvent implements ISpecialEvent {

    @Override
    public void Execute(RandomIngotOre block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity)
    {
    	block.setLightLevel(1f);
        
    }

	@Override
	public void ExecuteGem(RandomGemOre block, boolean livingEntity, Entity relatedEntity,
			EntityLivingBase relatedLivingEntity) 
	{
		block.setLightLevel(1f);
		
	}
}