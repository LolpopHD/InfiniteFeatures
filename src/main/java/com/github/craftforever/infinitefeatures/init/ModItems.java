package com.github.craftforever.infinitefeatures.init;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.items.ArmorBase;
import com.github.craftforever.infinitefeatures.items.ItemIngotBase;
import com.github.craftforever.infinitefeatures.items.tools.ToolAxe;
import com.github.craftforever.infinitefeatures.items.tools.ToolHoe;
import com.github.craftforever.infinitefeatures.items.tools.ToolPickaxe;
import com.github.craftforever.infinitefeatures.items.tools.ToolShovel;
import com.github.craftforever.infinitefeatures.items.tools.ToolSword;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
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
	public static Item[] toolArray = ArrayUtils.addAll(ArrayUtils.addAll(ArrayUtils.addAll(pickaxeArray, axeArray), ArrayUtils.addAll(hoeArray, shovelArray)),swordArray);
	
	public static int ArmorCount = armoramount();
	public static ArmorMaterial[] armormatArray = generatearmormaterials();
	public static Item[] helmetArray = generatehelmet();
	public static Item[] chestplateArray = generatechestplate();
	public static Item[] leggingsArray = generateleggings();
	public static Item[] bootsArray = generateboots();
	public static Item[] armorArray = ArrayUtils.addAll(ArrayUtils.addAll(leggingsArray, bootsArray), ArrayUtils.addAll(helmetArray, chestplateArray));
	
	
	//public static Item RANDOM_INGOT1 = new ItemIngotBase(ModBlocks.minerals[0].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static Item RANDOM_INGOT2 = new ItemIngotBase(ModBlocks.minerals[1].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static Item RANDOM_INGOT3 = new ItemIngotBase(ModBlocks.minerals[2].name+"_ingot").setCreativeTab(InfiniteFeatures.InfiniTab);

	//genereating materials
	
	private static ToolMaterial[] generatetoolmaterials() 
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			ToolMaterial[] materialarray = new ToolMaterial[InfiniteFeatures.ORE_QTY];
			for(int i = 0; i < ToolOres; i++) 
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
	
	private static ArmorMaterial[] generatearmormaterials() 
	{
		if (InfiniteFeatures.continueRandomGeneration) 
		{
			ArmorMaterial[] materialarray = new ArmorMaterial[InfiniteFeatures.ORE_QTY];
			for(int i = 0; i < ArmorCount; i++) 
			{
				String name = "armor_"+ModBlocks.minerals[i].name;
				String texturename = InfiniteFeatures.modID+":"+ModBlocks.minerals[i].name;
				int durability = RandomHelper.getRandomIntInRange(5, 33);
				int enchantability = RandomHelper.getRandomIntInRange(9, 25);
				
				materialarray[i] = EnumHelper.addArmorMaterial(name, texturename, durability,
						new int[] {RandomHelper.getRandomIntInRange(1, 3), RandomHelper.getRandomIntInRange(2, 6), 
						RandomHelper.getRandomIntInRange(3, 8), RandomHelper.getRandomIntInRange(1, 3)}, enchantability, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
						RandomHelper.getRandomFloatInRange(0.0F, 2.0F));
			}
			return materialarray;
		}
		else 
		{
			ArmorMaterial[] materialarray = null;
			return materialarray;		
		}
	}

	//generating toolset and armor amount
	
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
	
	private static int armoramount() 
	{
		int count = 0;
		boolean[] hasArmor = new boolean[InfiniteFeatures.ORE_QTY];
		for(int i = 0; i < InfiniteFeatures.ORE_QTY; i++) 
		{
			hasArmor[i] = RandomHelper.getRandomBoolean(0.5F);
			if(hasArmor[i]) 
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
	
	//generating armor
	
	private static Item[] generatehelmet() 
	{
		if(InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] armorarray = new Item[ArmorCount];
			for (int i = 0; i < ArmorCount; i++) 
			{
				armorarray[i] = new ArmorBase(ModBlocks.minerals[i].name+"_helmet", armormatArray[i], 1, EntityEquipmentSlot.HEAD);
			}
			return armorarray;
		}
		else 
		{
			Item[] armorarray = null;
			return armorarray;
		}
	}
	
	private static Item[] generatechestplate() 
	{
		if(InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] armorarray = new Item[ArmorCount];
			for (int i = 0; i < ArmorCount; i++) 
			{
				armorarray[i] = new ArmorBase(ModBlocks.minerals[i].name+"_chestplate", armormatArray[i], 1, EntityEquipmentSlot.CHEST);
			}
			return armorarray;
		}
		else 
		{
			Item[] armorarray = null;
			return armorarray;
		}
	}
	
	private static Item[] generateleggings() 
	{
		if(InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] armorarray = new Item[ArmorCount];
			for (int i = 0; i < ArmorCount; i++) 
			{
				armorarray[i] = new ArmorBase(ModBlocks.minerals[i].name+"_leggings", armormatArray[i], 1, EntityEquipmentSlot.LEGS);
			}
			return armorarray;
		}
		else 
		{
			Item[] armorarray = null;
			return armorarray;
		}
	}
	
	private static Item[] generateboots() 
	{
		if(InfiniteFeatures.continueRandomGeneration) 
		{
			Item[] armorarray = new Item[ArmorCount];
			for (int i = 0; i < ArmorCount; i++) 
			{
				armorarray[i] = new ArmorBase(ModBlocks.minerals[i].name+"_boots", armormatArray[i], 1, EntityEquipmentSlot.FEET);
			}
			return armorarray;
		}
		else 
		{
			Item[] armorarray = null;
			return armorarray;
		}
	}
	
	//generating ingots and gems
	
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