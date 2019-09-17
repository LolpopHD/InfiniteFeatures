package com.github.craftforever.infinitefeatures.items.tools;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.init.IHasModel;
import com.github.craftforever.infinitefeatures.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel{

	public ToolAxe(String name, ToolMaterial material,float damage,float speed)
	{
		super(material,damage,speed);
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
