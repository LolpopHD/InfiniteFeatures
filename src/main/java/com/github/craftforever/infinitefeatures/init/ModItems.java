package com.github.craftforever.infinitefeatures.init;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.items.ItemIngotBase;
import com.github.craftforever.infinitefeatures.items.tools.ToolAxe;
import com.github.craftforever.infinitefeatures.items.tools.ToolHoe;
import com.github.craftforever.infinitefeatures.items.tools.ToolPickaxe;
import com.github.craftforever.infinitefeatures.items.tools.ToolShovel;
import com.github.craftforever.infinitefeatures.items.tools.ToolSword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static Item[] ingotArray = generateingotarray();
	public static Item[] gemArray = generategemarray();
	public static Item[] itemArray = ArrayUtils.addAll(ingotArray, gemArray);
	
	public static int ToolOres = tooloreamount();
	public static ToolMaterial[] materialArray = generatetoolmaterials();
	public static Item[] axeArray = generateaxearray();
	public static Item[] pickaxeArray = generatepickaxearray();
	public static Item[] hoeArray = generatehoearray();
	public static Item[] shovelArray = generateshovelarray();
	public static Item[] swordArray = generateswordarray(); 
	
	//public static Item RANDOM_INGOT1 = new ItemIngotBase(ModBlocks.minerals[0].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static Item RANDOM_INGOT2 = new ItemIngotBase(ModBlocks.minerals[1].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static Item RANDOM_INGOT3 = new ItemIngotBase(ModBlocks.minerals[2].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);

	private static ToolMaterial[] generatetoolmaterials() 
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			ToolMaterial[] materialarray = new ToolMaterial[InfiniteFeatures.ORE_QTY];
			for(int i = 0; i < InfiniteFeatures.ORE_QTY; i++) 
			{
				String name = "material_"+ModBlocks.minerals[i].name;
				int harvestlevel = RandomHelper.getRandomIntInRange(0, 3);
				int maxUses = RandomHelper.getRandomIntInRange(32, 1561);
				float efficiency = RandomHelper.getRandomFloatInRange(2.0F, 12.0F);
				float damage = RandomHelper.getRandomFloatInRange(0.0F, 5.0F);
				int enchantability = RandomHelper.getRandomIntInRange(5, 22);
				materialarray[i] = EnumHelper.addToolMaterial(name, harvestlevel, maxUses, efficiency, damage, enchantability);
			}
			return materialarray;
		}
		else 
		{
			ToolMaterial[] materialarray = null;
			return materialarray;		
		}
	}

	private static int tooloreamount() 
	{
		int count = 0;
		boolean[] hasTools = new boolean[InfiniteFeatures.ORE_QTY];
		for(int i = 0; i < InfiniteFeatures.ORE_QTY; i++) 
		{
			hasTools[i] = RandomHelper.getRandomBoolean(0.5F);
			if(hasTools[i]) 
			{
				count++;
			}
		}
		return count;
	}
	
	//generating tools
	private static Item[] generatepickaxearray() 
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] pickaxearray = new Item[ToolOres];
			for(int i = 0; i < ToolOres; i++) 
			{
				pickaxearray[i] = new ToolPickaxe(ModBlocks.minerals[i].name+"_pickaxe", materialArray[i]);
			}
			return pickaxearray;
		}
		else 
		{
			Item[] pickaxearray = null;
			return pickaxearray;
		}
	}
	
	private static Item[] generateshovelarray() 
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] shovelarray = new Item[ToolOres];
			for(int i = 0; i < ToolOres; i++) 
			{
				shovelarray[i] = new ToolShovel(ModBlocks.minerals[i].name+"_shovel", materialArray[i]);
			}
			return shovelarray;
		}
		else 
		{
			Item[] shovelarray = null;
			return shovelarray;
		}
	}
	
	private static Item[] generatehoearray() 
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] hoearray = new Item[ToolOres];
			for(int i = 0; i < ToolOres; i++) 
			{
				hoearray[i] = new ToolHoe(ModBlocks.minerals[i].name+"_hoe", materialArray[i]);
			}
			return hoearray;
		}
		else 
		{
			Item[] hoearray = null;
			return hoearray;
		}
	}
	
	private static Item[] generateswordarray() 
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] swordarray = new Item[ToolOres];
			for(int i = 0; i < ToolOres; i++) 
			{
				swordarray[i] = new ToolSword(ModBlocks.minerals[i].name+"_sword", materialArray[i]);
			}
			return swordarray;
		}
		else 
		{
			Item[] swordarray = null;
			return swordarray;
		}
	}
	
	private static Item[] generateaxearray() 
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] axearray = new Item[ToolOres];
			for(int i = 0; i < ToolOres; i++) 
			{
				float damage = RandomHelper.getRandomFloatInRange(6.0F, 8.0F);
				float speed = RandomHelper.getRandomFloatInRange(-3.2F, -3.0F);
				axearray[i] = new ToolAxe(ModBlocks.minerals[i].name+"_axe", materialArray[i],damage,speed);
			}
			return axearray;
		}
		else 
		{
			Item[] axearray = null;
			return axearray;
		}
	}
	
	private static Item[] generateingotarray()
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] itemarray = new Item[ModBlocks.ingotorecount];
			for (int i = 0; i < ModBlocks.ingotorecount; i++)
			{
				itemarray[i] = new ItemIngotBase(ModBlocks.minerals[i].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
			}
			return itemarray;
		}
		else 
		{
			Item[] itemarray = null;
			return itemarray;
		}
		
	}	
	
	private static Item[] generategemarray()
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] itemarray = new Item[ModBlocks.gemorecount];
			for (int i = 0; i < ModBlocks.gemorecount; i++)
			{
				itemarray[i] = new ItemIngotBase(ModBlocks.minerals[i+ModBlocks.ingotorecount].name+"_gem").setCreativeTab(InfiniteFeatures.InfiniTab);
			}
			return itemarray;
		}
		else 
		{
			Item[] itemarray = null;
			return itemarray;
		}
		
	}
}