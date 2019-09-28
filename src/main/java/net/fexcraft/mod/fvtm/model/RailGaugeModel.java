package net.fexcraft.mod.fvtm.model;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.entity.JunctionSwitchEntity;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.rail.cmds.EntryDirection;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RailGaugeModel extends GenericModel<Track, Integer> {

	public static final RailGaugeModel EMPTY = new RailGaugeModel();
	public Vec3f[][] rails = new Vec3f[][]{
		{ new Vec3f(-1.0625, 0.375, 0), new Vec3f(-0.9375, 0.375, 0) },
		{ new Vec3f( 0.9375, 0.375, 0), new Vec3f( 1.0625, 0.375, 0) },
		//
		{ new Vec3f(-1.0625, 0.25, 0), new Vec3f(-1.0625, 0.375, 0) },
		{ new Vec3f(-0.9375, 0.375, 0), new Vec3f(-0.9375, 0.25, 0) },
		//
		{ new Vec3f(0.9375, 0.25, 0), new Vec3f(0.9375, 0.375, 0) },
		{ new Vec3f(1.0625, 0.375, 0), new Vec3f(1.0625, 0.25, 0) },
		//
		{ new Vec3f(-1.0625, 0.25, 0), new Vec3f(-0.9375, 0.25, 0) },
		{ new Vec3f(0.9375, 0.25, 0), new Vec3f(1.0625, 0.25, 0) }
	};
	public float ties_distance = 0.5f;
	public float signal_offset = 0.5f;
	//
	public TurboList fork2_base, fork2_lever;
	public TurboList fork3_base, fork3_lever;
	public TurboList double_base, double_lever0, double_lever1;
	public TurboList simple_signal_base, simple_signal_stop, simple_signal_clear;
	//
	//signals
	
	////-///---/---///-////
	
	public RailGaugeModel(){ super(); }
	
	public RailGaugeModel(JsonObject obj){ super(obj); }
	
	public RailGaugeModel(String type, ResourceLocation loc){ super(type, loc); }

	@Override
	public void render(Track data, Integer index){
		for(TurboList list : groups){ list.renderPlain(); }
	}

	@Override
	public void render(Track data, Integer index, Entity ent, RenderCache cache, int meta){
		for(TurboList list : groups){ list.renderPlain(); }
	}

	//TODO rotation programs for levers
	public void renderSwitch(JunctionSwitchEntity entity, Junction junction){
		switch(junction.type){
			case DOUBLE:{
				double_base.renderPlain();
				double_lever0.renderPlain();
				double_lever1.renderPlain();
				break;
			}
			case FORK_2:{
				fork2_base.renderPlain();
				fork2_lever.renderPlain();
				break;
			}
			case FORK_3:{
				fork3_base.renderPlain();
				fork3_lever.renderPlain();
				break;
			}
			case CROSSING: case STRAIGHT: default: return;
		}
	}
	
	//TODO
	public void renderSignal(Junction junction, EntryDirection dir, boolean state){
		if(junction.signal == null) return;
		switch(junction.signal.type){
			case BLOCK:
				simple_signal_base.renderPlain();
				if(!state) simple_signal_stop.renderPlain();
				if(state) simple_signal_clear.renderPlain();
				break;
			case CUSTOM:
				break;
			case PATH:
				break;
			default:
				break;
		}
	}
	
}