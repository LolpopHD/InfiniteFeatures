package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.INumberValuePicker;

public class ConstantValuePicker implements INumberValuePicker {

    public Number value;
    public ConstantValuePicker(Number value)
    {
        this.value = value;
    }

    @Override
    public Number getNumber() {
        return value;
    }

    
    
}