package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IDoubleValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IFloatValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IIntValuePicker;

public class GaussianValuePicker implements IFloatValuePicker, IIntValuePicker, IDoubleValuePicker {

    public double mean;
    public double std;

    public GaussianValuePicker(double mean, double std)
    {
        this.mean = mean;
        this.std = std;
    }

    @Override
    public double getDouble() {
        double randomValue = mean + InfiniteFeatures.seededRandom.nextGaussian() * std;
        return randomValue;
    }

    @Override
    public int getInt() {
        int randomValue = (int)Math.round( mean + InfiniteFeatures.seededRandom.nextGaussian() * std );
        return randomValue;
    }

    @Override
    public float getFloat() {
        double randomValue = mean + InfiniteFeatures.seededRandom.nextGaussian() * std;
        return (float)randomValue;
    }

    
}