package com.github.craftforever.infinitefeatures.blocks.tree;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.init.IHasModel;
import com.github.craftforever.infinitefeatures.init.ModBlocks;
import com.github.craftforever.infinitefeatures.init.ModItems;
import com.github.craftforever.infinitefeatures.util.Wood;

import net.minecraft.block.SoundType;
import net.minecraft.block.BlockLog;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class LogBase extends BlockLog implements IHasModel
{
public Wood wood;
	
	public LogBase(String name, Wood iwood) 
	{
		wood = iwood;
		setSoundType(SoundType.WOOD);
		setTranslationKey(name);
		setRegistryName(name);
		setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		InfiniteFeatures.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
