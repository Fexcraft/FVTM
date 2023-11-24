package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.uni.world.StateWrapper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class StateWrapperI extends StateWrapper {

    private IBlockState state;

    public StateWrapperI(IBlockState state){
        this.state = state;
    }

    @Override
    public Object getBlock(){
        return null;
    }

    @Override
    public <S> S local(){
        return (S)state;
    }

    @Override
    public Object direct(){
        return state;
    }

    @Override
    public <V> V getValue(Object prop){
        return (V)state.getValue((IProperty<?>)prop);
    }

}
