package com.github.craftforever.infinitefeatures.init;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.BlockBase;
import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.util.Mineral;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks
{
	
	public static String[] textpartarray =
		{	"pa","pe","pi","po","pu","ta","te","ti","to","tu","ga","ge","gi","go","gu","fa","fe",
			"fi","fo","fu","ka","ke","ki","ko","ku","ha","he","hi",
			"ho","hu","la","le","li","lo","lu","na","ne","ni","no","nu","ra","re","ri","ro","ru"};
	public static void initarray()
	{

	}
//	public static String name1 = textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]
//			+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)]+textpartarray[InfiniteFeatures.getSeededRandom(1).nextInt(44)];
	public static Mineral[] minerals = generatemineralarray();
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static int ingotorecount = RandomHelper.getRandomIntInRange(0,InfiniteFeatures.ORE_QTY-1);
	public static int gemorecount = InfiniteFeatures.ORE_QTY - ingotorecount;
	
	public static final Block[] ingotOreArray = generateingotorearray();
	public static final Block[] gemOreArray = generategemorearray();
	public static final Block[] blockArray = ArrayUtils.addAll(ingotOreArray, gemOreArray);
	
	public static final Block[] ingotblockArray = generateingotblockarray();
	//public static final Block RANDOM_BLOCK = new RandomBlock(minerals[0]).setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static final Block RANDOM_BLOCK2 = new RandomBlock(minerals[1]).setCreativeTab(InfiniteFeatures.InfiniTab);
	//public static final Block RANDOM_BLOCK3 = new RandomBlock(minerals[2]).setCreativeTab(InfiniteFeatures.InfiniTab);

  public static Mineral getRandomMineral(int i) 
  {
		return RandomFactory.randomMineralFactory(textpartarray,i);
	}
	
	private static Mineral[] generatemineralarray()
	{
		if(InfiniteFeatures.continueRandomGeneration) {
			Mineral[] mineralarray = new Mineral[InfiniteFeatures.ORE_QTY];
			for (int i = 0; i < InfiniteFeatures.ORE_QTY; i++)
			{
				mineralarray[i] = getRandomMineral(i);
			}
			return mineralarray;
		}
		
		else 
		{
			Mineral[] mineralarray = null;
			return mineralarray;
		}	
	}
	
	public static Block[] generateingotblockarray()
	{
		if(InfiniteFeatures.continueRandomGeneration) 
		{
			Block[] ingotblockarray = new Block[InfiniteFeatures.ORE_QTY];
			for (int i = 0; i < InfiniteFeatures.ORE_QTY; i++) 
			{
					ingotblockarray[i] = new BlockBase(minerals[i].name+"_block", Material.IRON,minerals[i]).setCreativeTab(InfiniteFeatures.InfiniTab).setHardness(5).setResistance(30);
			}
			return ingotblockarray;
		}
		else 
		{
			Block[] ingotblockarray = null;
			return ingotblockarray;
		}
	}
	
	public static Block[] generateingotorearray()
	{
		if(InfiniteFeatures.continueRandomGeneration) 
		{
			Block[] blockarray = new Block[ingotorecount];
			for (int i = 0; i < ingotorecount; i++) 
			{
				blockarray[i] = RandomFactory.randomOreFactory(minerals[i], false, null).setCreativeTab(InfiniteFeatures.InfiniTab);
			}
			return blockarray;
		}
		else 
		{
			Block[] blockarray = null;
			return blockarray;
		}
		
	}
	
	public static Block[] generategemorearray()
	{
		if(InfiniteFeatures.continueRandomGeneration) 
		{
			Block[] blockarray = new Block[gemorecount];
			for (int i = 0; i < gemorecount; i++) 
			{
				blockarray[i] = RandomFactory.randomOreFactory(minerals[i+ingotorecount], true, ModItems.gemArray[i]).setCreativeTab(InfiniteFeatures.InfiniTab);
			}
			return blockarray;
		}
		else 
		{
			Block[] blockarray = null;
			return blockarray;
		}
		
	}
}
