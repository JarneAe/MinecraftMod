package com.jarne.starwarsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MovingWalkway extends Block {

    public MovingWalkway(Properties p_49795_) {
        super(p_49795_);


    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity){
        if(!pLevel.isClientSide()){
            if(pEntity instanceof LivingEntity){
                LivingEntity livingEntity = ((LivingEntity)pEntity);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300));


            }
        }

        super.stepOn(pLevel,pPos,pState,pEntity);
    }

}
