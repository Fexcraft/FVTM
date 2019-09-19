package net.fexcraft.mod.fvtm.model;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RailGaugeModel extends GenericModel<Track, Integer> {

	public static final RailGaugeModel EMPTY = new RailGaugeModel();
	//public float[][] rails = new float[][]{ { -17, -15 }, { 15, 17 } };
	public Vec3f[][] rails = new Vec3f[][]{
		{ new Vec3f(-1.0625, 0.375, 0), new Vec3f(-0.9375, 0.375, 0) },
		{ new Vec3f( 0.9375, 0.375, 0), new Vec3f( 1.0625, 0.375, 0) }
	};
	public float ties_distance = 0.5f;
	
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