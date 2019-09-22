package com.github.craftforever.infinitefeatures.init;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.BlockCallbacks;
import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.blocks.RandomGemOre;
import com.github.craftforever.infinitefeatures.blocks.RandomIngotOre;
import com.github.craftforever.infinitefeatures.blocks.specialevents.*;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.BernoulliBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.GaussianValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.UniformValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IFloatValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IIntValuePicker;
import com.github.craftforever.infinitefeatures.util.Mineral;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.*;

import static com.github.craftforever.infinitefeatures.helpers.RandomHelper.*;
import static com.github.craftforever.infinitefeatures.helpers.RandomHelper.getRandomIntInRange;

public class RandomFactory 
{

    private static final int RGB_MAX = 255;
    
    
    //QUALITY_LEVEL_AMMOUNT is better if it can divide InfiniteFeatures.ORE_QTY 
    private static final int QUALITY_LEVEL_AMMOUNT = 5;

    // TODO: allow users to customise min/max values via config file

    private static IIntValuePicker LightLevel;
    private static IBoolValuePicker LightLevelProbability;
    private static IFloatValuePicker Hardness;
    private static IFloatValuePicker BlastResistance;
    private static IIntValuePicker HarvestLevel;
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

    // ALL_POSSIBLE_EVENT_PARAMETERS (THIS SHOULD ABSOLUTLY BE MOVED SOMEWHERE ELSE)
    // private static final int POT_ID_MIN = 1;
    // private static final int POT_ID_MAX = 32;
    // private static final int POT_DURATION_MIN = 0;
    // private static final int POT_DURATION_MAX = 600;
    // private static final int POT_LEVEL_MIN = 1;
    // private static final int POT_LEVEL_MAX = 2;
    // private static final float POT_AMBIENT_PROBABILITY = 0.2f;
    // private static final float POT_PARTICLES_PROBABILITY = 0.9f;
    // private static final float POT_TRIGGER_PROBABILITY_MAX = 1f;
    // private static final float POT_TRIGGER_PROBABILITY_MIN = 0f;

    // private static final float EXPLODE_POWER_MIN = 1;
    // private static final float EXPLODE_POWER_MAX = 20;
    // private static final float EXPLODE_DESTROY_BLOCKS_PROB = 0.8f;

    // private static final int GAS_CLOUD_SIZE_MIN = 1;
    // private static final int GAS_CLOUD_SIZE_MAX = 10;
    // private static final int GAS_CLOUD_DURATION_MIN = 0;
    // private static final int GAS_CLOUD_DURATION_MAX = 200;

    public static OreWithSpecialEvents randomOreFactory(Mineral imineral, boolean gem, Item gemItem) {
        // TODO: randomly pick a material
        Material randomMaterial = Material.ROCK;
        // ...

        float randomLightLevel = 0F;
        LightLevelProbability = new BernoulliBoolValuePicker(LIGHTLEVEL_GLOW_PROBABILITY);
        if (LightLevelProbability.getBoolean()) {
            // The ore will glow
            LightLevel = new UniformValuePicker(LIGHTLEVEL_MIN, LIGHTLEVEL_MAX);
            randomLightLevel = LightLevel.getInt() / 15;
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

        HarvestLevel = new UniformValuePicker(HARVEST_LEVEL_MIN, HARVEST_LEVEL_MAX);
        int randomHarvestLevel = HarvestLevel.getInt();

        // How long it takes to mine
        Hardness = new UniformValuePicker(HARDNESS_MIN, HARDNESS_MAX);
        float randomHardness = Hardness.getFloat();

        // Blast resistance
        BlastResistance = new GaussianValuePicker(BLAST_RESISTANCE_MEAN, BLAST_RESISTANCE_STD);
        float randomBlastResistance = (float)Math.min(Math.max(BlastResistance.getFloat(), BLAST_RESISTANCE_MIN), BLAST_RESISTANCE_MAX);

        // TODO: pick a sound type randomly or based on something
        SoundType randomSoundType = SoundType.STONE;
        // ...

        // Initialize the mappings between event triggers and events
        HashMap<BlockCallbacks, List<ICallbackEvent>> randomUniqueActions = new HashMap<BlockCallbacks, List<ICallbackEvent>>();

        for (BlockCallbacks trigger : BlockCallbacks.values())
        {
            List<ICallbackEvent> events = new ArrayList<ICallbackEvent>();
            randomUniqueActions.put(trigger, events);
        }

        // Assign the TestEvent to a random trigger
        BlockCallbacks randomTrigger = randomEnum(BlockCallbacks.class);

        //List<ICallbackEvent> allPossibleEvents = GenerateAllPossibleEvents();

        ICallbackEvent selectedEvent = CallbackEventFactory.CreateRandomCallbackEvent();

        randomUniqueActions.get(randomTrigger).add(selectedEvent);
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
