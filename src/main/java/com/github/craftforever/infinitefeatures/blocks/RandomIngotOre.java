package com.github.craftforever.infinitefeatures.blocks;

import java.util.HashMap;

import java.util.List;

import com.github.craftforever.infinitefeatures.blocks.specialevents.ICallbackEvent;
import com.github.craftforever.infinitefeatures.util.Mineral;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RandomIngotOre extends OreWithSpecialEvents{
	public RandomIngotOre(Mineral imineral, Material imaterial, float ilightLevel, String itoolType, int iharvestLevel,
			float ihardness, float iresistance, SoundType isound,
			HashMap<BlockCallbacks, List<ICallbackEvent>> randomUniqueActions) 
	{
		super(imineral, imaterial, ilightLevel, itoolType, iharvestLevel, ihardness, iresistance, isound, randomUniqueActions);
	}
}