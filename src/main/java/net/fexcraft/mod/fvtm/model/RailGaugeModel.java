package net.fexcraft.mod.fvtm.model;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RailGaugeModel extends GenericModel<Track, Integer> {

	public static final RailGaugeModel EMPTY = new RailGaugeModel();
	
	////-///---/---///-////
	
	public RailGaugeModel(){ super(); }
	
	public RailGaugeModel(JsonObject obj){ super(obj); }
	
	public RailGaugeModel(String type, ResourceLocation loc){ super(type, loc); }

	@Override
	public void render(Track data, Integer index){
		for(TurboList list : groups){ list.renderPlain(); }
		//TODO custom rendering
	}

	@Override
	public void render(Track data, Integer index, Entity ent, RenderCache cache, int meta){
		for(TurboList list : groups){ list.renderPlain(); }
		//TODO custom rendering
	}
	
}