package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.entity.JunctionSwitchEntity;
import net.fexcraft.mod.fvtm.render.RailRenderer;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

public class RailGaugeModel extends GenericModel<Track, Integer> {

	public static final RailGaugeModel EMPTY = new RailGaugeModel();
	public ArrayList<Vec3f[]> rail_model = new ArrayList<>();
	/*public Vec3f[][] rails = new Vec3f[][]{
		{ new Vec3f(-1.0625, 0.25, 0), new Vec3f(-0.9375, 0.25, 0) },
		{ new Vec3f( 0.9375, 0.25, 0), new Vec3f( 1.0625, 0.25, 0) },
		//
		{ new Vec3f(-1.0625, 0.125, 0), new Vec3f(-1.0625, 0.25, 0) },
		{ new Vec3f(-0.9375, 0.25, 0), new Vec3f(-0.9375, 0.125, 0) },
		//
		{ new Vec3f(0.9375, 0.125, 0), new Vec3f(0.9375, 0.25, 0) },
		{ new Vec3f(1.0625, 0.25, 0), new Vec3f(1.0625, 0.125, 0) },
		//
		{ new Vec3f(-1.0625, 0.125, 0), new Vec3f(-0.9375, 0.125, 0) },
		{ new Vec3f(0.9375, 0.125, 0), new Vec3f(1.0625, 0.125, 0) }
	};*/
	public boolean rail_tempcull = false;
	public float ties_distance = 0.5f;
	public float signal_offset = 0.5f;
	public float buffer_length = 2f;
	//
	public TurboList fork2_base, fork2_lever;
	public TurboList fork3_base, fork3_lever;
	public TurboList double_base, double_lever0, double_lever1;
	public TurboList simple_signal_base, simple_signal_stop, simple_signal_clear;
	//
	public Track buffer_track;
	//
	//signals
	
	////-///---/---///-////
	
	public RailGaugeModel(){ super(); }
	
	public RailGaugeModel(JsonObject obj){ super(obj); }
	
	public RailGaugeModel(ResourceLocation loc, ObjModel data){ super(loc, data); }

	@Override
	public void render(Track data, Integer index){
		for(TurboList list : groups){ list.renderPlain(); }
	}

	@Override
	public void render(Track data, Integer index, Entity ent, RenderCache cache){
		for(TurboList list : groups){ list.renderPlain(); }
	}
	
	public void addRailRect(float scale, float start_x, float start_y, float width, float height, boolean mirror){
		rail_model.add(new Vec3f[]{ new Vec3f(start_x, start_y, 0).scale(scale), new Vec3f(start_x + width, start_y, 0).scale(scale) });
		if(height > 0){
			rail_model.add(new Vec3f[]{ new Vec3f(start_x, start_y - height, 0).scale(scale), new Vec3f(start_x, start_y, 0).scale(scale) });
			rail_model.add(new Vec3f[]{ new Vec3f(start_x + width, start_y, 0).scale(scale), new Vec3f(start_x + width, start_y - height, 0).scale(scale) });
			rail_model.add(new Vec3f[]{ new Vec3f(start_x, start_y - height, 0).scale(scale), new Vec3f(start_x + width, start_y - height, 0).scale(scale) });
		}
		else{
			float h = 0.01f / scale;
			rail_model.add(new Vec3f[]{ new Vec3f(start_x, start_y - h, 0).scale(scale), new Vec3f(start_x + width, start_y - h, 0).scale(scale) });
		}
		if(mirror) addRailRect(scale, -start_x - width, start_y, width, height, false);
	}
	
	public void addRailRectShape(float scale, float start_x, float start_y, float width, float height, Vec3f tl, Vec3f tr, Vec3f bl, Vec3f br, boolean mirror){
		if(tl == null) tl = new Vec3f();
		if(tr == null) tr = new Vec3f();
		if(bl == null) bl = new Vec3f();
		if(br == null) br = new Vec3f();
		rail_model.add(new Vec3f[]{ new Vec3f(start_x + bl.x, start_y + tl.y, 0).scale(scale), new Vec3f(start_x + width + br.x, start_y + tr.y, 0).scale(scale) });
		if(height > 0){
			rail_model.add(new Vec3f[]{ new Vec3f(start_x + tl.x, start_y - height + bl.y, 0).scale(scale), new Vec3f(start_x + bl.x, start_y + tl.y, 0).scale(scale) });
			rail_model.add(new Vec3f[]{ new Vec3f(start_x + width + br.x, start_y + tr.y, 0).scale(scale), new Vec3f(start_x + width + tr.x, start_y - height + br.y, 0).scale(scale) });
			rail_model.add(new Vec3f[]{ new Vec3f(start_x + tl.x, start_y - height + bl.y, 0).scale(scale), new Vec3f(start_x + width + tr.x, start_y - height + br.y, 0).scale(scale) });
		}
		else{
			float h = 0.01f / scale;
			rail_model.add(new Vec3f[]{ new Vec3f(start_x + tl.x, start_y - h + bl.y, 0).scale(scale), new Vec3f(start_x + width + tr.x, start_y - h + br.y, 0).scale(scale) });
		}
		if(mirror) addRailRectShape(scale, -start_x - width, start_y, width, height, tl, tr, bl, br, false);
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

	public void renderBuffer(Junction junc){
		if(!groups.contains("buffer")) return;
		if(buffer_track == null){
			buffer_track = new Track(null, new Vec316f[]{ new Vec316f(new Vec3d(0, 0, 0)) },
				new Vec316f(new Vec3d(buffer_length, 0, 0)), junc.tracks.get(0).gauge);
		}
		if(buffer_track.railmodel == null){ RailRenderer.generateTrackModel(buffer_track, this); }
		ModelBase.bindTexture(buffer_track.gauge.getModelTexture());
		GL11.glRotatef(180, 0, 0, 1); GL11.glRotatef(180, 0, 1, 0);
		groups.get("buffer").renderPlain();
		GL11.glRotatef(180, 0, 0, 1); GL11.glRotatef(-90, 0, 1, 0);
		ModelBase.bindTexture(buffer_track.gauge.getTiesTexture());
		buffer_track.restmodel.renderPlain();
		ModelBase.bindTexture(buffer_track.gauge.getRailTexture());
		buffer_track.railmodel.renderPlain();
	}
	
}