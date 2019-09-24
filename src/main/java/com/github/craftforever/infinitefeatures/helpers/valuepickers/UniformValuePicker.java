package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.INumberValuePicker;

public class UniformValuePicker implements INumberValuePicker {

    public INumberValuePicker min;
    public INumberValuePicker max;
    public UniformValuePicker(INumberValuePicker min, INumberValuePicker max)
    {
        this.min = min;
        this.max = max;
    }

    @Override
    public Number getNumber() {
        return RandomHelper.getRandomFloatInRange(min.getNumber().floatValue(), max.getNumber().floatValue());
    }
}