package net.fexcraft.mod.fvtm.model;

import java.util.Collection;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Resources;

public class ObjModelWrapper<D, K> implements Model<D, K>{
	
	private ModelRendererTurbo objmodel;
	
	public ObjModelWrapper(String objloc){
		objmodel = new ModelRendererTurbo(null, 0, 0, 256, 256);
		objmodel.addObj(objloc, Resources.getModelInputStream(objloc));
	}

	@Override
	public void render(D data, K key){
		objmodel.render();
	}

	@Override
	public void render(D data, K key, VehicleEntity ent, int meta){
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