package com.github.craftforever.infinitefeatures.blocks.specialevents.implementations;

import java.util.EnumSet;

import com.github.craftforever.infinitefeatures.blocks.OreWithSpecialEvents;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDecorator;
import com.github.craftforever.infinitefeatures.blocks.specialevents.CallbackDependencies;
import com.github.craftforever.infinitefeatures.blocks.specialevents.ICallbackEvent;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IIntValuePicker;
import com.github.craftforever.infinitefeatures.helpers.valuepickers.returntypes.IBoolValuePicker;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ApplyPotionEffectCallbackEventDecorator extends CallbackDecorator {

    protected IIntValuePicker potionID;
    protected IIntValuePicker duration;
    protected IIntValuePicker potionLevel;
    protected IBoolValuePicker ambient;
    protected IBoolValuePicker particles;

    private static final EnumSet<CallbackDependencies> dependencies = EnumSet.of(CallbackDependencies.ENTITYLIVINGBASE);

    public ApplyPotionEffectCallbackEventDecorator(IIntValuePicker potionID, IIntValuePicker duration,
    IIntValuePicker potionLevel, IBoolValuePicker ambient, IBoolValuePicker particles, ICallbackEvent child) {
        super(child, dependencies);
        this.potionID = potionID;
        this.duration = duration;
        this.potionLevel = potionLevel;
        this.ambient = ambient;
        this.particles = particles;

    }

    @Override
    public void Execute(OreWithSpecialEvents block, Entity relatedEntity, EntityLivingBase relatedLivingEntity,
            World world, BlockPos blockPos, Boolean bool, Explosion explosion, IBlockState blockState,
            EntityPlayer player, EnumHand hand, EnumFacing facing, ItemStack stack, Float unkFloat,
            IBlockAccess blockAccess) {

        if (relatedLivingEntity != null) {

            relatedLivingEntity.addPotionEffect(
                new PotionEffect(
                    Potion.getPotionById(potionID.getInt()),
                    duration.getInt(), 
                    potionLevel.getInt() - 1,
                    ambient.getBoolean(), 
                    particles.getBoolean()
                )
            );
        }
        super.child.Execute(block, relatedEntity, relatedLivingEntity, world, blockPos, bool, explosion, blockState, player, hand, facing, stack, unkFloat, blockAccess);
    }

    @Override
	public String getDescription() {
		return "PotionEffect" + " : " + child.getDescription();
	}
}