package com.github.craftforever.infinitefeatures.blocks.specialevents;

import java.util.EnumSet;


public abstract class CallbackDecorator implements ICallbackEvent {

    public ICallbackEvent child; 
    public EnumSet<CallbackDependencies> callbackDependencies;

    public CallbackDecorator(ICallbackEvent child, EnumSet<CallbackDependencies> callbackDependencies)
    {
        this.child = child;
        this.callbackDependencies = callbackDependencies;
    }

    public EnumSet<CallbackDependencies> getCallbackDependencies(){
        EnumSet<CallbackDependencies> allDependencies = EnumSet.copyOf(child.getCallbackDependencies());
        allDependencies.addAll(callbackDependencies);
        return allDependencies;
    }
}