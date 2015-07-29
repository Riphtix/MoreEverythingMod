package com.riphtix.mem;

import com.riphtix.mem.init.MoreBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class MoreOresGeneration implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId()){
			case -1:
				generateNether(world, random, chunkX, chunkZ);
				break;
			case 0:
				generateOverworld(world, random, chunkX, chunkZ);
				break;
			case 1:
				generateEnd(world, random, chunkX, chunkZ);
				break;
		}
	}

	public void generateNether(World world, Random rand, int x, int z){
		generateOre(MoreBlocks.silver_ore, world, rand, x, z, 3, 10, 5, 12, 100, Blocks.end_stone);
		generateOre(MoreBlocks.ruby_ore, world, rand, x, z, 3, 10, 3, 12, 50, Blocks.end_stone);

	}

	public void generateOverworld(World world, Random rand, int x, int z){
		generateOre(MoreBlocks.silver_ore, world, rand, x, z, 3, 10, 5, 12, 100, Blocks.stone);
		generateOre(MoreBlocks.ruby_ore, world, rand, x, z, 3, 10, 3, 12, 50, Blocks.stone);
	}

	public void generateEnd(World world, Random rand, int x, int z){
		generateOre(MoreBlocks.silver_ore, world, rand, x, z, 3, 10, 5, 12, 100, Blocks.netherrack);
		generateOre(MoreBlocks.ruby_ore, world, rand, x, z, 3, 10, 3, 12, 50, Blocks.netherrack);

	}

	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn){
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), veinSize);
		for(int i = 0; i < chance; i++){
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			BlockPos blockPos = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, random, blockPos);
		}
	}
}
