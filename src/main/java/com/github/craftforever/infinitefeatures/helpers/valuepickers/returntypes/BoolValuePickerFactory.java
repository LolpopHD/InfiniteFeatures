package com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes;

import java.util.ArrayList;
import java.util.List;

import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.BernoulliBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.ConstantBoolValuePicker;

public class BoolValuePickerFactory {
    IFloatValuePicker bernoulliProb;

    public IBoolValuePicker getBoolValuePicker(){

        List<IBoolValuePicker> AllBoolPickers = new ArrayList<IBoolValuePicker>();
        AllBoolPickers.add(
            new BernoulliBoolValuePicker(bernoulliProb.getFloat())
        );
        AllBoolPickers.add(
            new ConstantBoolValuePicker(
                new BernoulliBoolValuePicker(0.5f).getBoolean()
            )
        );

        return RandomHelper.getRandomItem(AllBoolPickers);
    }
}