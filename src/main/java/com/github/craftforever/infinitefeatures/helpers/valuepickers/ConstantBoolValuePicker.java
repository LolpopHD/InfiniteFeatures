package com.github.craftforever.infinitefeatures.helpers.valuepickers;

import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;

public class ConstantBoolValuePicker implements IBoolValuePicker {

    public boolean value;
    public ConstantBoolValuePicker(boolean value)
    {
        this.value = value;
    }

    @Override
    public boolean getBoolean() {
        return value;
    }

    
}