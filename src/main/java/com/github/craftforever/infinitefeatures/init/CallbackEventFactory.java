package com.github.craftforever.infinitefeatures.init;

import com.github.craftforever.infinitefeatures.blocks.specialevents.DoNothingCallbackEvent;
import com.github.craftforever.infinitefeatures.blocks.specialevents.ICallbackEvent;
import com.github.craftforever.infinitefeatures.blocks.specialevents.implementations.ApplyPotionEffectCallbackEventDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.implementations.ApplyRandomlyCallbackEventDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.implementations.CreateExplosionCallbackEventDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.implementations.CreateGasCloudCallbackEventDecorator;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.BernoulliBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.GaussianValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.UniformValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IFloatValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IIntValuePicker;

public class CallbackEventFactory {
    
    public static ICallbackEvent CreateRandomCallbackEvent()
    {
        
        ICallbackEvent callbackEvent =  new DoNothingCallbackEvent();

        IFloatValuePicker range = new GaussianValuePicker(0, 1);
        IIntValuePicker duration = new GaussianValuePicker(0, 1);
        IFloatValuePicker expansion_modifier = new GaussianValuePicker(0, 1);
        IIntValuePicker potionID = new UniformValuePicker(0, 1);
        IIntValuePicker effect_duration = new GaussianValuePicker(0, 1);
        IIntValuePicker effect_level = new GaussianValuePicker(0, 1);
        callbackEvent = new CreateGasCloudCallbackEventDecorator(
            range, 
            duration, 
            expansion_modifier, 
            potionID,
            effect_duration, 
            effect_level, 
            callbackEvent);

        IFloatValuePicker strength = new GaussianValuePicker(0, 1);
        IBoolValuePicker damagesTerrain = new BernoulliBoolValuePicker(0.5f);
        callbackEvent = new CreateExplosionCallbackEventDecorator(
            strength, 
            damagesTerrain, 
            callbackEvent);
        
        IBoolValuePicker ambient = new BernoulliBoolValuePicker(0.5f);
        IBoolValuePicker particles = new BernoulliBoolValuePicker(0.5f);
        callbackEvent = new ApplyPotionEffectCallbackEventDecorator(
            potionID, 
            effect_duration, 
            effect_level, 
            ambient, 
            particles, 
            callbackEvent);

        IBoolValuePicker applyRandomlyPicker = new BernoulliBoolValuePicker(0.5f);
        callbackEvent = new ApplyRandomlyCallbackEventDecorator(
            applyRandomlyPicker, 
            callbackEvent);

        return callbackEvent;
    }

}