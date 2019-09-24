package com.github.craftforever.infinitefeatures.init;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.BlockCallbacks;
import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.blocks.RandomGemOre;
import com.github.craftforever.infinitefeatures.blocks.RandomIngotOre;
import com.github.craftforever.infinitefeatures.blocks.specialevents.*;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.BernoulliBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.ConstantValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.GaussianValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.UniformValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.INumberValuePicker;
import com.github.craftforever.infinitefeatures.util.Mineral;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.awt.*;

import static com.github.craftforever.infinitefeatures.helpers.RandomHelper.*;
import static com.github.craftforever.infinitefeatures.helpers.RandomHelper.getRandomIntInRange;

public class RandomFactory 
{

    private static final int RGB_MAX = 255;
    
    
    //QUALITY_LEVEL_AMMOUNT is better if it can divide InfiniteFeatures.ORE_QTY 
    private static final int QUALITY_LEVEL_AMMOUNT = 5;

    // TODO: allow users to customise min/max values via config file

    private static INumberValuePicker LightLevel;
    private static IBoolValuePicker LightLevelProbability;
    private static INumberValuePicker Hardness;
    private static INumberValuePicker BlastResistance;
    private static INumberValuePicker HarvestLevel;
    private static final int LIGHTLEVEL_MAX = 15;
    private static final int LIGHTLEVEL_MIN = 1;
    private static final float LIGHTLEVEL_GLOW_PROBABILITY = 0.1f;
    private static final int HARDNESS_MIN = 1;
    private static final int HARDNESS_MAX = 10;
    private static final double BLAST_RESISTANCE_MEAN = 15.0D;
    private static final double BLAST_RESISTANCE_STD = 5.0D;
    private static final double BLAST_RESISTANCE_MIN = 0.0D;
    private static final double BLAST_RESISTANCE_MAX = 6000.0D;

    private static final int HARVEST_LEVEL_MIN = 0;
    private static final int HARVEST_LEVEL_MAX = 3;


    public static OreWithSpecialEvents randomOreFactory(Mineral imineral, boolean gem, Item gemItem) {
        // TODO: randomly pick a material
        Material randomMaterial = Material.ROCK;
        // ...

        float randomLightLevel = 0F;
        LightLevelProbability = new BernoulliBoolValuePicker(
           new ConstantValuePicker(LIGHTLEVEL_GLOW_PROBABILITY));
        if (LightLevelProbability.getBoolean()) {
            // The ore will glow
            LightLevel = new UniformValuePicker(
                new ConstantValuePicker(LIGHTLEVEL_MIN), 
                new ConstantValuePicker(LIGHTLEVEL_MAX));
            randomLightLevel = LightLevel.getNumber().intValue() / 15;
        }
        else 
        {
            // The ore won't glow
            randomLightLevel = 0F;
        }

        // TODO: pick tool type based off the base texture, (sand/dirt base textures
        // probably makes sense to use a shovel)
        // Depending on the direction/extent you want to take the randomisation this
        // could be generated randomly although that would make for poor experiences
        String randomToolType = "pickaxe";
        // ...

        HarvestLevel = new UniformValuePicker(
            new ConstantValuePicker(HARVEST_LEVEL_MIN), 
            new ConstantValuePicker(HARVEST_LEVEL_MAX));
        int randomHarvestLevel = HarvestLevel.getNumber().intValue();

        // How long it takes to mine
        Hardness = new UniformValuePicker(
            new ConstantValuePicker(HARDNESS_MIN), 
            new ConstantValuePicker(HARDNESS_MAX));
        float randomHardness = Hardness.getNumber().floatValue();

        // Blast resistance
        BlastResistance = new GaussianValuePicker(
            new ConstantValuePicker(BLAST_RESISTANCE_MEAN), 
            new ConstantValuePicker(BLAST_RESISTANCE_STD),
            new ConstantValuePicker(BLAST_RESISTANCE_MIN),
            new ConstantValuePicker(BLAST_RESISTANCE_MAX));
        
        float randomBlastResistance = BlastResistance.getNumber().floatValue();

        // TODO: pick a sound type randomly or based on something
        SoundType randomSoundType = SoundType.STONE;
        // ...

        // Initialize the mappings between event triggers and events
        HashMap<BlockCallbacks, ICallbackEvent> randomUniqueActions = new HashMap<BlockCallbacks, ICallbackEvent>();

        for (BlockCallbacks trigger : BlockCallbacks.values())
        {
            randomUniqueActions.put(trigger, null);
        }

        // Assign the TestEvent to a random trigger
        BlockCallbacks randomTrigger = randomEnum(BlockCallbacks.class);

        //List<ICallbackEvent> allPossibleEvents = GenerateAllPossibleEvents();

        ICallbackEvent selectedEvent = CallbackEventFactory.CreateRandomCallbackEvent();

        randomUniqueActions.put(randomTrigger, selectedEvent);
        OreWithSpecialEvents randomBlock;
        if (!gem){
            randomBlock = new RandomIngotOre(imineral, randomMaterial, randomLightLevel, randomToolType,
            randomHarvestLevel, randomHardness, randomBlastResistance, randomSoundType, randomUniqueActions);
        }
        else{
            randomBlock = new RandomGemOre(imineral, 
            randomMaterial, randomLightLevel, randomToolType, randomHarvestLevel, randomHardness, randomBlastResistance, randomSoundType, 
            randomUniqueActions, gemItem);
        }
        
        return randomBlock;
    }

    public static Mineral randomMineralFactory(String[] textpartarray,int quality) {
        String randomName = textpartarray[getRandomIntInRange(0, textpartarray.length - 1)]
                + textpartarray[getRandomIntInRange(0, textpartarray.length - 1)]
                + textpartarray[getRandomIntInRange(0, textpartarray.length - 1)]
                + textpartarray[getRandomIntInRange(0, textpartarray.length - 1)];

        Color randomColor = new Color(InfiniteFeatures.seededRandom.nextInt(RGB_MAX),
                InfiniteFeatures.seededRandom.nextInt(RGB_MAX), InfiniteFeatures.seededRandom.nextInt(RGB_MAX));
        Mineral randomMineral = new Mineral(randomName, randomColor,quality/(InfiniteFeatures.ORE_QTY/QUALITY_LEVEL_AMMOUNT)+1);

        return randomMineral;
    }

}
