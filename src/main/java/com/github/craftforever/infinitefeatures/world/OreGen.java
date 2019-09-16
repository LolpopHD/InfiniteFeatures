package com.github.craftforever.infinitefeatures.world;

import java.util.Random;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.BlockBase;
import com.github.craftforever.infinitefeatures.init.ModBlocks;
import com.github.craftforever.infinitefeatures.util.Mineral;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator 
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) 
	{
		if(world.provider.getDimension() == 0) 
		{
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		
	}
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) 
	{
		for(int i = 0; i < InfiniteFeatures.ORE_QTY; i++) 
		{
			Mineral blockmineral = ((BlockBase)ModBlocks.blockArray[i]).mineral;
			generateOre(ModBlocks.blockArray[i].getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, blockmineral.genmaxy, random.nextInt(blockmineral.gensize+1) + blockmineral.gensize+1, blockmineral.genrarity+1);
			//System.out.print(ModBlocks.blockArray[i].getRegistryName()+"\n");
		}
	}
	
	private void generateOre(IBlockState ore,World world,Random random,int x,int z,int minY,int maxY, int size,int chances) 
	{
		int deltaY = maxY-minY;
		
		for(int i = 0;i < chances ;i++) 
		{
			BlockPos pos = new BlockPos(x + random.nextInt(16),minY + random.nextInt(deltaY),z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore,size);
			generator.generate(world, random, pos);
		}
	}

}
