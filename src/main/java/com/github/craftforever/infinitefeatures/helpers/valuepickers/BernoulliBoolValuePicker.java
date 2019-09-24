package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.INumberValuePicker;

public class BernoulliBoolValuePicker implements IBoolValuePicker {

    public INumberValuePicker probability;
    public BernoulliBoolValuePicker(INumberValuePicker probability)
    {
        this.probability = probability;
    }

    @Override
    public boolean getBoolean() {
        float randomValue = InfiniteFeatures.seededRandom.nextFloat();
        return randomValue <= probability.getNumber().floatValue();
    }

    
}