package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.minecraft.block.Block;
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
    public String getStateString(){
        String str = "";
        for(IProperty<?> key : state.getPropertyKeys()){
            str += key.getName() + "=" + state.getValue(key) + ",";
        }
        return str.length() > 0 ? str.substring(0, str.length() - 1) : str;
    }

    @Override
    public Object getBlock(){
        return state.getBlock();
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
    public Object getProperty(String key){
        for(IProperty<?> prop : state.getPropertyKeys()){
            if(prop.getName().equals(key)) return prop;
        }
        return null;
    }

    @Override
    public <V> V getValue(Object prop){
        return (V)state.getValue((IProperty<?>)prop);
    }

    @Override
    public <V> V getValue(String fvtm_key){
        if(!PROP_REGISTRY.containsKey(fvtm_key)) return null;
        return (V)state.getValue((IProperty<?>)PROP_REGISTRY.get(fvtm_key));
    }

    @Override
    public <V> V getValue(String fvtm_key, Class<V> type){
        if(!PROP_REGISTRY.containsKey(fvtm_key)) return null;
        return (V)state.getValue((IProperty<?>)PROP_REGISTRY.get(fvtm_key));
    }

    @Override
    public IDL getIDL(){
        return IDLManager.getIDL(state.getBlock().getRegistryName().toString());
    }

    @Override
    public int get12Meta(){
        return state.getBlock().getMetaFromState(state);
    }

}
