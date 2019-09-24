package com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes;

import java.util.ArrayList;
import java.util.List;

import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.BernoulliBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.ConstantBoolValuePicker;

public class BoolValuePickerFactory {
    INumberValuePicker probabilityDistribution;

    public BoolValuePickerFactory(INumberValuePicker probabilityDistribution){
        this.probabilityDistribution = probabilityDistribution;
    }

    public IBoolValuePicker getBoolValuePicker(){

        List<IBoolValuePicker> AllBoolPickers = new ArrayList<IBoolValuePicker>();
        AllBoolPickers.add(
            new BernoulliBoolValuePicker(
                probabilityDistribution
                )
        );
        AllBoolPickers.add(
            new ConstantBoolValuePicker(
                true
            )
        );
        AllBoolPickers.add(
            new ConstantBoolValuePicker(
                false
            )
        );
        return RandomHelper.getRandomItem(AllBoolPickers);
    }
}