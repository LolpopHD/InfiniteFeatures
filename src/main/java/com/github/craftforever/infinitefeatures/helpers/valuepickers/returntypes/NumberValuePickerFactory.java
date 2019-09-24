package com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes;

import java.util.ArrayList;
import java.util.List;

import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.ConstantValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.GaussianValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.UniformValuePicker;

public class NumberValuePickerFactory {
    INumberValuePicker min;
    INumberValuePicker max;
    INumberValuePicker mean;
    INumberValuePicker std;

    public NumberValuePickerFactory(INumberValuePicker min, INumberValuePicker max, INumberValuePicker mean, INumberValuePicker std){
        this.min = min;
        this.max = max;
        this.mean = mean;
        this.std = std;
    }

    public INumberValuePicker getRandomNumberValuePicker(){
        
        List<INumberValuePicker> AllNumberPickers = new ArrayList<INumberValuePicker>();
        AllNumberPickers.add(
            new GaussianValuePicker(
                mean,
                std,
                min,
                max
            )
        );
        AllNumberPickers.add(
            new UniformValuePicker(
                min,
                max
            )
        );
        AllNumberPickers.add(
            new ConstantValuePicker(
                new UniformValuePicker(min, max).getNumber()
            )
        );
        AllNumberPickers.add(
            new ConstantValuePicker(
                new GaussianValuePicker(mean, std, min, max).getNumber()
            )
        );

        return RandomHelper.getRandomItem(AllNumberPickers);
    }
}