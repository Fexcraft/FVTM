package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.uni.IDL;
import net.minecraft.util.ResourceLocation;

public class ResLoc extends ResourceLocation implements IDL {

    public ResLoc(String name){
        super(name);
    }

    public ResLoc(String space, String path){
        super(space, path);
    }

    @Override
    public String space(){
        return getNamespace();
    }

    @Override
    public String id(){
        return getPath();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof IDL){
            return colon().equals(((IDL)obj).colon());
        }
        else return colon().equals(obj.toString());
    }

}
