package com.github.craftforever.infinitefeatures.init;

import java.util.Arrays;
import java.util.List;

import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.DoNothingCallbackEvent;
import com.github.craftforever.infinitefeatures.blocks.specialevents.ICallbackEvent;
import com.github.craftforever.infinitefeatures.blocks.specialevents.implementations.ApplyPotionEffectCallbackEventDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.implementations.ApplyRandomlyCallbackEventDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.implementations.CreateExplosionCallbackEventDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.implementations.CreateGasCloudCallbackEventDecorator;
import com.github.craftforever.infinitefeatures.helpers.RandomHelper;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.BernoulliBoolValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.ConstantValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.UniformValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.BoolValuePickerFactory;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.NumberValuePickerFactory;

public class CallbackEventFactory {


    private static float explosionStrengthMin = 1;
    private static float explosionStrengthMax = 20;
    private static float explosionStrengthMean = 3;
    private static float explosionStrengthSTD = 2;

    private static float explosionProcChanceMin = 0.1f;
    private static float explosionProcChanceMax = 0.9f;
    private static float explosionProcChanceMean = 0.5f;
    private static float explosionProcChanceSTD = 0.2f;

    private static int potionIdMin = 1;
    private static int potionIdMax = 32;

    private static float potionLengthMin = 0;
    private static float potionLengthMax = 1200;
    private static float potionLengthSTD = 300;
    private static float potionLengthMean = 300;

    private static int potionLevelMin = 1;
    private static int potionLevelMax = 3;
    private static int potionLevelSTD = 1;
    private static int potionLevelMean = 1;

    private static float potionAmbientProcChanceMin = 0;
    private static float potionAmbientProcChanceMax = 1;
    private static float potionAmbientProcChanceMean = 0.2f;
    private static float potionAmbientProcChanceSTD = 0.4f;
    
    private static float potionParticlesVisibleProcChanceMin = 0.5f;
    private static float potionParticlesVisibleProcChanceMax = 1;
    private static float potionParticlesVisibleProcChanceMean = 0.9f;
    private static float potionParticlesVisibleProcChanceSTD = 0.1f;

    private static float randomProcProcChanceMin = 0.1f;
    private static float randomProcProcChanceMax = 0.9f;
    private static float randomProcProcChanceMean = 0.5f;
    private static float randomProcProcChanceSTD = 0.1f;

    private static float gasCloudRadiusMin = 1;
    private static float gasCloudRadiusMax = 10;
    private static float gasCloudRadiusMean = 3;
    private static float gasCloudRadiusSTD = 2;

    private static float gasCloudDurationMin = 30;
    private static float gasCloudDurationMax = 300;
    private static float gasCloudDurationMean = 150;
    private static float gasCloudDurationSTD = 90;

    private static float gasCloudExpansionModifierMin = 0;
    private static float gasCloudExpansionModifierMax = 10;
    private static float gasCloudExpansionModifierMean = 3;
    private static float gasCloudExpansionModifierSTD = 4;

    private static float gasCloudPotionDurationMin = 0;
    private static float gasCloudPotionDurationMax = 120;
    private static float gasCloudPotionDurationMean = 30;
    private static float gasCloudPotionDurationSTD = 30;

    private static float gasCloudPotionLevelMin = 1;
    private static float gasCloudPotionLevelMax = 2;
    private static float gasCloudPotionLevelMean = 1;
    private static float gasCloudPotionLevelSTD = 0.5f;

    private static CallbackDecorator addRandomCallbackEvent(ICallbackEvent event){
        List<CallbackDecorator> allSpecialEvents = Arrays.asList(
            new CreateGasCloudCallbackEventDecorator(
                new NumberValuePickerFactory(
                    new ConstantValuePicker(gasCloudRadiusMin), 
                    new ConstantValuePicker(gasCloudRadiusMax), 
                    new ConstantValuePicker(gasCloudRadiusMean), 
                    new ConstantValuePicker(gasCloudRadiusSTD)).getRandomNumberValuePicker(),
                new NumberValuePickerFactory(
                    new ConstantValuePicker(gasCloudDurationMin), 
                    new ConstantValuePicker(gasCloudDurationMax), 
                    new ConstantValuePicker(gasCloudDurationMean), 
                    new ConstantValuePicker(gasCloudDurationSTD)).getRandomNumberValuePicker(),
                new NumberValuePickerFactory(
                    new ConstantValuePicker(gasCloudExpansionModifierMin), 
                    new ConstantValuePicker(gasCloudExpansionModifierMax), 
                    new ConstantValuePicker(gasCloudExpansionModifierMean), 
                    new ConstantValuePicker(gasCloudExpansionModifierSTD)).getRandomNumberValuePicker(),
                new ConstantValuePicker(
                    new UniformValuePicker(
                        new ConstantValuePicker(potionIdMin), 
                        new ConstantValuePicker(potionIdMax)).getNumber()
                        ),
                new NumberValuePickerFactory(
                    new ConstantValuePicker(gasCloudPotionDurationMin), 
                    new ConstantValuePicker(gasCloudPotionDurationMax), 
                    new ConstantValuePicker(gasCloudPotionDurationMean), 
                    new ConstantValuePicker(gasCloudPotionDurationSTD)).getRandomNumberValuePicker(),
                new NumberValuePickerFactory(
                    new ConstantValuePicker(gasCloudPotionLevelMin), 
                    new ConstantValuePicker(gasCloudPotionLevelMax), 
                    new ConstantValuePicker(gasCloudPotionLevelMean), 
                    new ConstantValuePicker(gasCloudPotionLevelSTD)).getRandomNumberValuePicker(),
                    event
            ),
            new CreateExplosionCallbackEventDecorator(
                new NumberValuePickerFactory(
                    new ConstantValuePicker(explosionStrengthMin), 
                    new ConstantValuePicker(explosionStrengthMax), 
                    new ConstantValuePicker(explosionStrengthMean),
                    new ConstantValuePicker(explosionStrengthSTD)).getRandomNumberValuePicker(),
                new BoolValuePickerFactory(
                    new NumberValuePickerFactory(
                        new ConstantValuePicker(explosionProcChanceMin), 
                        new ConstantValuePicker(explosionProcChanceMax), 
                        new ConstantValuePicker(explosionProcChanceMean), 
                        new ConstantValuePicker(explosionProcChanceSTD)).getRandomNumberValuePicker()
                ).getBoolValuePicker(), 
                event
            ),
            new ApplyPotionEffectCallbackEventDecorator(
                new ConstantValuePicker(
                    new UniformValuePicker(
                        new ConstantValuePicker(potionIdMin), 
                        new ConstantValuePicker(potionIdMax)).getNumber()
                        ),
                new NumberValuePickerFactory(
                    new ConstantValuePicker(potionLengthMin), 
                    new ConstantValuePicker(potionLengthMax), 
                    new ConstantValuePicker(potionLengthMean), 
                    new ConstantValuePicker(potionLengthSTD)).getRandomNumberValuePicker(),
                new NumberValuePickerFactory(
                    new ConstantValuePicker(potionLevelMin),
                    new ConstantValuePicker(potionLevelMax),
                    new ConstantValuePicker(potionLevelMean),
                    new ConstantValuePicker(potionLevelSTD)).getRandomNumberValuePicker(),
                new BoolValuePickerFactory(
                    new NumberValuePickerFactory(
                        new ConstantValuePicker(potionAmbientProcChanceMin), 
                        new ConstantValuePicker(potionAmbientProcChanceMax), 
                        new ConstantValuePicker(potionAmbientProcChanceMean), 
                        new ConstantValuePicker(potionAmbientProcChanceSTD)).getRandomNumberValuePicker()
                ).getBoolValuePicker(),
                new BoolValuePickerFactory(
                    new NumberValuePickerFactory(
                        new ConstantValuePicker(potionParticlesVisibleProcChanceMin), 
                        new ConstantValuePicker(potionParticlesVisibleProcChanceMax), 
                        new ConstantValuePicker(potionParticlesVisibleProcChanceMean), 
                        new ConstantValuePicker(potionParticlesVisibleProcChanceSTD)).getRandomNumberValuePicker()
                ).getBoolValuePicker(),
                event
            ),
            new ApplyRandomlyCallbackEventDecorator(
                new BernoulliBoolValuePicker(
                    new NumberValuePickerFactory(
                        new ConstantValuePicker(randomProcProcChanceMin), 
                        new ConstantValuePicker(randomProcProcChanceMax), 
                        new ConstantValuePicker(randomProcProcChanceMean), 
                        new ConstantValuePicker(randomProcProcChanceSTD)).getRandomNumberValuePicker()
                ),
                event
            )
        );

        return RandomHelper.getRandomItem(allSpecialEvents);
    }

    public static ICallbackEvent CreateRandomCallbackEvent() {
        // base event, all others are added to this.
        ICallbackEvent callbackEvent = new DoNothingCallbackEvent();
        callbackEvent = addRandomCallbackEvent(callbackEvent);
        

        // int numberOfSpecialEvents = 1;
        // for (int i = 0; i < numberOfSpecialEvents; i++) {
        //     callbackEvent = addRandomCallbackEvent(callbackEvent);
        // }

        return callbackEvent;
    }

}