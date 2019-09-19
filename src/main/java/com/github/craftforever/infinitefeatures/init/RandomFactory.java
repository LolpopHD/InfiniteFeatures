package com.github.craftforever.infinitefeatures.init;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.blocks.RandomOre;
import com.github.craftforever.infinitefeatures.blocks.RandomOre.SpecialEventTrigger;
import com.github.craftforever.infinitefeatures.blocks.specialevents.*;
import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
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
    private static final int LIGHTLEVEL_MAX = 15;
    private static final int LIGHTLEVEL_MIN = 1;
    private static final double LIGHTLEVEL_GLOW_PROBABILITY = 0.1D;
    private static final int HARDNESS_MIN = 1;
    private static final int HARDNESS_MAX = 10;
    private static final double BLAST_RESISTANCE_MEAN = 15.0D;
    private static final double BLAST_RESISTANCE_STD = 5.0D;
    private static final double BLAST_RESISTANCE_MIN = 0.0D;
    private static final double BLAST_RESISTANCE_MAX = 6000.0D;

    private static final int HARVEST_LEVEL_MIN = 0;
    private static final int HARVEST_LEVEL_MAX = 3;

    // ALL_POSSIBLE_EVENT_PARAMETERS (THIS SHOULD ABSOLUTLY BE MOVED SOMEWHERE ELSE)
    private static final int POT_ID_MIN = 1;
    private static final int POT_ID_MAX = 32;
    private static final int POT_DURATION_MIN = 0;
    private static final int POT_DURATION_MAX = 600;
    private static final int POT_LEVEL_MIN = 1;
    private static final int POT_LEVEL_MAX = 2;
    private static final float POT_AMBIENT_PROBABILITY = 0.2f;
    private static final float POT_PARTICLES_PROBABILITY = 0.9f;
    private static final float POT_TRIGGER_PROBABILITY_MAX = 1f;
    private static final float POT_TRIGGER_PROBABILITY_MIN = 0f;

    private static List<ISpecialEvent> GenerateAllPossibleEvents()
    {
        List<ISpecialEvent> allEvents = new ArrayList<ISpecialEvent>();

        // the block will exhibit a potion effect with all of its stats fixed and the effect will proc every time
        allEvents.add(new ApplyPotionEffectRange(getRandomIntInRange(POT_ID_MIN, POT_ID_MAX),
                getRandomIntInRange(POT_DURATION_MIN, POT_DURATION_MAX),
                getRandomIntInRange(POT_LEVEL_MIN, POT_LEVEL_MAX), 
                getRandomBoolean(POT_AMBIENT_PROBABILITY),
                getRandomBoolean(POT_PARTICLES_PROBABILITY)));
        // the block will exhibit a potion effect with all of its stats fixed and the effect will proc some of the time 
        allEvents.add(new ApplyPotionEffectRangeRandomly(getRandomIntInRange(POT_ID_MIN, POT_ID_MAX),
                getRandomIntInRange(POT_DURATION_MIN, POT_DURATION_MAX),
                getRandomIntInRange(POT_LEVEL_MIN, POT_LEVEL_MAX),
                getRandomBoolean(POT_AMBIENT_PROBABILITY),
                getRandomBoolean(POT_PARTICLES_PROBABILITY),
                getRandomFloatInRange(POT_TRIGGER_PROBABILITY_MIN, POT_TRIGGER_PROBABILITY_MAX)));
        // the block will exhibit a potion effect with all of its stats randomised (different lengths, etc) and the effect will proc every time
        allEvents.add(new ApplyPotionEffectRange(
                getRandomIntInRange(POT_ID_MIN, POT_ID_MAX), 
                POT_DURATION_MIN, 
                POT_DURATION_MAX, 
                getRandomFloatInRange(POT_DURATION_MIN, POT_DURATION_MAX), 
                getRandomFloatInRange(0, POT_DURATION_MAX), 
                POT_LEVEL_MIN, 
                POT_LEVEL_MAX, 
                getRandomFloatInRange(POT_LEVEL_MIN, POT_LEVEL_MAX), 
                getRandomFloatInRange(0, POT_DURATION_MAX), 
                getRandomBoolean(POT_AMBIENT_PROBABILITY),
                getRandomBoolean(POT_PARTICLES_PROBABILITY)));
        // the block will exhibit a potion effect with all of its stats randomised (different lengths, etc) and the effect will proc some of the time
        allEvents.add(new ApplyPotionEffectRangeRandomly(
            getRandomIntInRange(POT_ID_MIN, POT_ID_MAX), 
            POT_DURATION_MIN, 
            POT_DURATION_MAX, 
            getRandomFloatInRange(POT_DURATION_MIN, POT_DURATION_MAX), 
            getRandomFloatInRange(0, POT_DURATION_MAX), 
            POT_LEVEL_MIN, 
            POT_LEVEL_MAX, 
            getRandomFloatInRange(POT_LEVEL_MIN, POT_LEVEL_MAX), 
            getRandomFloatInRange(0, POT_DURATION_MAX), 
            getRandomBoolean(POT_AMBIENT_PROBABILITY),
            getRandomBoolean(POT_PARTICLES_PROBABILITY),
            getRandomFloatInRange(POT_TRIGGER_PROBABILITY_MIN, POT_TRIGGER_PROBABILITY_MAX)));

        return allEvents;
    }

    public static RandomOre randomOreFactory(Mineral imineral, Material imaterial, Item itemdrop) {
        // TODO: randomly pick a material
        // ...

        float randomLightLevel = 0F;
        if (getRandomBoolean((float) LIGHTLEVEL_GLOW_PROBABILITY)) {
            // The ore will glow
            randomLightLevel = (float)getRandomIntInRange(LIGHTLEVEL_MIN,LIGHTLEVEL_MAX) / 15;
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
        String randomToolType;
        if(imineral.material.equals(Material.ROCK)) 
        {
        	randomToolType = "pickaxe";
        }
        else 
        {
        	randomToolType = "shovel";
        }
        // ...

        int randomHarvestLevel = getRandomIntInRange(HARVEST_LEVEL_MIN, HARVEST_LEVEL_MAX);

        // How long it takes to mine
        float randomHardness = (float) getRandomIntInRange(HARDNESS_MIN, HARDNESS_MAX);

        // Blast resistance
        float randomBlastResistance = (float) getRandomGaussianInRange(BLAST_RESISTANCE_MEAN, BLAST_RESISTANCE_STD,
                BLAST_RESISTANCE_MIN, BLAST_RESISTANCE_MAX);

        // TODO: pick a sound type randomly or based on something
        SoundType randomSoundType = SoundType.STONE;
        // ...

        // Initialize the mappings between event triggers and events
        HashMap<SpecialEventTrigger, List<ISpecialEvent>> randomUniqueActions = new HashMap<SpecialEventTrigger, List<ISpecialEvent>>();

        for (SpecialEventTrigger trigger : SpecialEventTrigger.values())
        {
            List<ISpecialEvent> events = new ArrayList<ISpecialEvent>();
            randomUniqueActions.put(trigger, events);
        }

        // Assign the TestEvent to a random trigger
        SpecialEventTrigger randomTrigger = randomEnum(SpecialEventTrigger.class);

        List<ISpecialEvent> allPossibleEvents = GenerateAllPossibleEvents();

        ISpecialEvent selectedEvent = RandomHelper.getRandomItem(allPossibleEvents);

        randomUniqueActions.get(randomTrigger).add(selectedEvent);
        
        RandomOre randomBlock = new RandomOre(imineral, imaterial, randomLightLevel, randomToolType,
                randomHarvestLevel, randomHardness, randomBlastResistance, randomSoundType, randomUniqueActions, itemdrop);

        return randomBlock;
    }

    public static Mineral randomMineralFactory(String[] textpartarray,int i) {
        String randomName = textpartarray[getRandomIntInRange(0, textpartarray.length - 1)]
                + textpartarray[getRandomIntInRange(0, textpartarray.length - 1)]
                + textpartarray[getRandomIntInRange(0, textpartarray.length - 1)]
                + textpartarray[getRandomIntInRange(0, textpartarray.length - 1)];

        Color randomColor = new Color(InfiniteFeatures.seededRandom.nextInt(RGB_MAX),
                InfiniteFeatures.seededRandom.nextInt(RGB_MAX), InfiniteFeatures.seededRandom.nextInt(RGB_MAX));
        Mineral randomMineral = new Mineral(randomName, randomColor,i/(InfiniteFeatures.ORE_QTY/QUALITY_LEVEL_AMMOUNT)+1);

        return randomMineral;
    }

}
