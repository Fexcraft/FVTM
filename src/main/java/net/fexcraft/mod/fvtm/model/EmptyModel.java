package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.Collection;

import net.fexcraft.mod.fvtm.api.Model;
import net.minecraft.entity.Entity;

public class EmptyModel implements Model<Object, Object>{
	
	public static final EmptyModel INSTANCE = new EmptyModel();

	@Override
	public void render(){
		//
	}

	@Override
	public void render(Object data, Object key){
		//
	}

	@Override
	public void render(Object data, Object key, Entity ent, int meta){
		//
	}
	
	private static final ArrayList<String> list = new ArrayList<>();
	//static{ list.add("No Model"); }

	@Override
	public Collection<String> getCreators(){
		return list;
	}
	
}