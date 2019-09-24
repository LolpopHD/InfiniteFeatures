package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.InfiniteFeatures;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.INumberValuePicker;

public class GaussianValuePicker implements INumberValuePicker {

    private INumberValuePicker mean;
    private INumberValuePicker std;
    private INumberValuePicker min;
    private INumberValuePicker max;

    public GaussianValuePicker(INumberValuePicker mean, INumberValuePicker std, INumberValuePicker min, INumberValuePicker max)
    {
        this.mean = mean;
        this.std = std;
        this.min = min;
        this.max = max;
    }

    @Override
    public Number getNumber() {
        Number gaussian = InfiniteFeatures.seededRandom.nextGaussian();
        Number randomValue = mean.getNumber().doubleValue() + gaussian.doubleValue() * std.getNumber().doubleValue();
        return Math.min(Math.max(randomValue.doubleValue(), min.getNumber().doubleValue()), max.getNumber().doubleValue());
    }    
}