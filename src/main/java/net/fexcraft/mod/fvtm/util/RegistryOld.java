package net.fexcraft.mod.fvtm.util;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.minecraft.util.ResourceLocation;

public class RegistryOld<Type extends TypeCore<Type>> extends ArrayList<Type> {

	public void register(Type type){
		add(type);
	}

	public Type get(ResourceLocation resloc){
		for(Type type : this) if(type.getRegistryName().equals(resloc)) return type;
		return null;
	}

	public Type get(String regname){
		for(Type type : this) if(type.getRegistryName().toString().equals(regname)) return type;
		return null;
	}

}
