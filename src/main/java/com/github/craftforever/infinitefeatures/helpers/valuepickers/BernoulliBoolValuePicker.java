package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;

public class BernoulliBoolValuePicker implements IBoolValuePicker {

    public float probability;
    public BernoulliBoolValuePicker(float probability)
    {
        this.probability = probability;
    }

    @Override
    public boolean getBoolean() {
        float randomValue = InfiniteFeatures.seededRandom.nextFloat();
        return randomValue <= probability;
    }

    
}