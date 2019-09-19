package com.github.craftforever.infinitefeatures.blocks.specialevents;

import com.github.craftforever.infinitefeatures.blocks.RandomOre;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class TestEvent implements ISpecialEvent {

    @Override
    public void Execute(RandomOre block, boolean livingEntity, Entity relatedEntity, EntityLivingBase relatedLivingEntity)
    {
    	block.setLightLevel(1f);
        
    }
}