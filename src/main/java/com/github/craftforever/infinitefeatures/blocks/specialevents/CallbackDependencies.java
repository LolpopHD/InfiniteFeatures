package com.github.craftforever.infinitefeatures.blocks.specialevents;

import java.util.EnumSet;

import com.github.craftforever.infinitefeatures.blocks.BlockCallbacks;

public enum CallbackDependencies {
    WORLD, BLOCK, BLOCKPOS, IBLOCKSTATE, ENTITYPLAYER, BOOLEAN, EXPLOSION, ENUMHAND, ENUMFACING, ITEMSTACK, FLOAT,
    IBLOCKACCESS, ENTITYLIVINGBASE, ENTITY;

    public static final EnumSet<CallbackDependencies> ALL_OPTS = EnumSet.allOf(CallbackDependencies.class);
    public static final EnumSet<CallbackDependencies> NO_OPTS = EnumSet.noneOf(CallbackDependencies.class);

    public static EnumSet<CallbackDependencies> fromBlockCallback(BlockCallbacks callback) throws Exception {
        EnumSet<CallbackDependencies> requiredDependencies = CallbackDependencies.NO_OPTS;
        switch (callback) {
        case ONDESTROY:

            break;
        case ONREMOVEDBYPLAYER:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.IBLOCKSTATE);
            break;
        case ONEXPLODEDESTROY:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.EXPLOSION, CallbackDependencies.ENTITY, CallbackDependencies.ENTITYLIVINGBASE);
            break;
        case ONACTIVATED:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.IBLOCKSTATE, CallbackDependencies.ENTITYPLAYER,
                    CallbackDependencies.ENTITYLIVINGBASE, CallbackDependencies.ENTITY, CallbackDependencies.ENUMHAND,
                    CallbackDependencies.ENUMFACING, CallbackDependencies.FLOAT);
            break;
        case ONWALKEDON:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.ENTITY);
            break;
        case ONCLICKED:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.ENTITY, CallbackDependencies.ENTITYLIVINGBASE,
                    CallbackDependencies.ENTITYPLAYER);
            break;
        case ONCOLLIDED:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.IBLOCKSTATE, CallbackDependencies.ENTITY);
            break;
        case ONPLACED:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.IBLOCKSTATE, CallbackDependencies.ENTITY,
                    CallbackDependencies.ENTITYLIVINGBASE, CallbackDependencies.ITEMSTACK);
            break;
        case ONFALLENON:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.ENTITY, CallbackDependencies.FLOAT);
            break;
        case ONLANDED:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.ENTITY);
            break;
        case ONHARVESTED:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.IBLOCKSTATE, CallbackDependencies.ENTITY,
                    CallbackDependencies.ENTITYLIVINGBASE, CallbackDependencies.ENTITYPLAYER);
            break;
        case ONEXPLODED:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.EXPLOSION, CallbackDependencies.ENTITY, CallbackDependencies.ENTITYLIVINGBASE);
            break;
        case ONPLANTGROW:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.IBLOCKSTATE, CallbackDependencies.BLOCKPOS);
            break;
        case ONNEIGHBOURCHANGE:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.IBLOCKACCESS,
                    CallbackDependencies.BLOCKPOS);
            break;
        case ONBLOCKADDED:
            requiredDependencies = EnumSet.of(CallbackDependencies.BLOCK, CallbackDependencies.WORLD,
                    CallbackDependencies.BLOCKPOS, CallbackDependencies.IBLOCKSTATE);
            break;

        default:
            throw new Exception("Invalid Argument");
        }
        return requiredDependencies;
    }
}
