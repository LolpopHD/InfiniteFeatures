package com.github.craftforever.infinitefeatures.items.tools;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.init.IHasModel;
import com.github.craftforever.infinitefeatures.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {

	public ToolPickaxe(String name, ToolMaterial material)
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
