package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IDoubleValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IFloatValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IIntValuePicker;

public class UniformValuePicker implements IFloatValuePicker, IDoubleValuePicker, IIntValuePicker {

    public float min;
    public float max;
    public UniformValuePicker(float min, float max)
    {
        this.min = min;
        this.max = max;
    }

    @Override
    public double getDouble() {
        return RandomHelper.getRandomFloatInRange(min, max);
    }

    @Override
    public float getFloat() {
        return RandomHelper.getRandomFloatInRange(min, max);
    }

    @Override
    public int getInt() {
        return Math.round(RandomHelper.getRandomFloatInRange(min, max));
    }
}