package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IDoubleValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IFloatValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IIntValuePicker;

public class ConstantValuePicker implements IIntValuePicker, IFloatValuePicker, IDoubleValuePicker {

    public float value;
    public ConstantValuePicker(float value)
    {
        this.value = value;
    }

    @Override
    public double getDouble() {
        return value;
    }

    @Override
    public float getFloat() {
        return value;
    }

    @Override
    public int getInt() {
        return Math.round(value);
    }

    
    
}