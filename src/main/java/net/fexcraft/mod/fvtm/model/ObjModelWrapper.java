package net.fexcraft.mod.fvtm.model;

import java.util.Collection;

import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ObjModelWrapper<D, K> implements Model<D, K>{
	
	private ModelRendererTurbo objmodel;
	
	public ObjModelWrapper(String objloc){
		objmodel = new ModelRendererTurbo(null, 0, 0, 256, 256);
		objmodel.addObj(objloc);
	}

	@Override
	public void render(){
		objmodel.render();
	}

	@Override
	public void render(D data, K key){
		objmodel.render();
	}

	@Override
	public void render(D data, K key, Entity ent, int meta){
		objmodel.render();
	}

	@Override
	public Collection<String> getCreators(){
		return EmptyModel.INSTANCE.getCreators();
	}

	@Override
	public boolean addToCreators(String str){
		return false;
	}
	
}