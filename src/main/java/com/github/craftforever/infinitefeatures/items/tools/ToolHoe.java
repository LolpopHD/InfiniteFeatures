package com.github.craftforever.infinitefeatures.items.tools;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.init.IHasModel;
import com.github.craftforever.infinitefeatures.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel{

	public ToolHoe(String name, ToolMaterial material)
	{
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(InfiniteFeatures.InfiniTab);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		InfiniteFeatures.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
