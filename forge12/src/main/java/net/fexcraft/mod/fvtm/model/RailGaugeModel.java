package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.render.TurboArrayPositioned;
import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.render.RailRenderer;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.QV3D;

public class RailGaugeModel extends DefaultModel {

	public static final RailGaugeModel EMPTY = new RailGaugeModel();
	public ArrayList<V3D[]> rail_model = new ArrayList<>();
	public boolean rail_tempcull = false;
	public float ties_distance = 0.5f;
	public float signal_offset = 0.25f;
	public float buffer_length = 2f;
	//
	public Track buffer_track;
	//
	//signals
	
	////-///---/---///-////
	
	@Override
	public RailGaugeModel parse(ModelData data){
		rail_tempcull = data.getBoolean("RailCulling", false);
		ties_distance = data.getFloat("TiesDistance", ties_distance);
		signal_offset = data.getFloat("SignalOffset", signal_offset);
		buffer_length = data.getFloat("BufferLength", buffer_length);
		List<String> rails = data.getArray("Rail").toStringList();
		if(rails.isEmpty()) return this;
		for(String rail : rails){
			String[] args = rail.trim().split(" ");
			boolean rect = args[0].equals("rect") || args[0].equals("flat");
			float scale = Float.parseFloat(args[1]);
			float sx = Float.parseFloat(args[2]);
			float sy = Float.parseFloat(args[3]);
			float w = Float.parseFloat(args[4]);
			float h = Float.parseFloat(args[5]);
			boolean m = Boolean.parseBoolean(args[6]);
			if(rect){
				this.addRailRect(scale, sx, sy, w, h, m);
			}
			else{
				V3D tl = new V3D(args, 7), tr = new V3D(args, 10), bl = new V3D(args, 13), br = new V3D(args, 16);
				this.addRailRectShape(scale, sx, sy, w, h, tl, tr, bl, br, m);
			}
		}
		return this;
	}

	@Override
	public void render(ModelRenderData data){
		for(ModelGroup list : groups) list.render();
	}
	
	public void addRailRect(float scale, float start_x, float start_y, float width, float height, boolean mirror){
		rail_model.add(new V3D[]{ new V3D(start_x, start_y, 0).scale(scale), new V3D(start_x + width, start_y, 0).scale(scale) });
		if(height > 0){
			rail_model.add(new V3D[]{ new V3D(start_x, start_y - height, 0).scale(scale), new V3D(start_x, start_y, 0).scale(scale) });
			rail_model.add(new V3D[]{ new V3D(start_x + width, start_y, 0).scale(scale), new V3D(start_x + width, start_y - height, 0).scale(scale) });
			rail_model.add(new V3D[]{ new V3D(start_x, start_y - height, 0).scale(scale), new V3D(start_x + width, start_y - height, 0).scale(scale) });
		}
		else{
			float h = 0.01f / scale;
			rail_model.add(new V3D[]{ new V3D(start_x, start_y - h, 0).scale(scale), new V3D(start_x + width, start_y - h, 0).scale(scale) });
		}
		if(mirror) addRailRect(scale, -start_x - width, start_y, width, height, false);
	}
	
	public void addRailRectShape(float scale, float start_x, float start_y, float width, float height, V3D tl, V3D tr, V3D bl, V3D br, boolean mirror){
		if(tl == null) tl = new V3D();
		if(tr == null) tr = new V3D();
		if(bl == null) bl = new V3D();
		if(br == null) br = new V3D();
		rail_model.add(new V3D[]{ new V3D(start_x + bl.x, start_y + tl.y, 0).scale(scale), new V3D(start_x + width + br.x, start_y + tr.y, 0).scale(scale) });
		if(height > 0){
			rail_model.add(new V3D[]{ new V3D(start_x + tl.x, start_y - height + bl.y, 0).scale(scale), new V3D(start_x + bl.x, start_y + tl.y, 0).scale(scale) });
			rail_model.add(new V3D[]{ new V3D(start_x + width + br.x, start_y + tr.y, 0).scale(scale), new V3D(start_x + width + tr.x, start_y - height + br.y, 0).scale(scale) });
			rail_model.add(new V3D[]{ new V3D(start_x + tl.x, start_y - height + bl.y, 0).scale(scale), new V3D(start_x + width + tr.x, start_y - height + br.y, 0).scale(scale) });
		}
		else{
			float h = 0.01f / scale;
			rail_model.add(new V3D[]{ new V3D(start_x + tl.x, start_y - h + bl.y, 0).scale(scale), new V3D(start_x + width + tr.x, start_y - h + br.y, 0).scale(scale) });
		}
		if(mirror) addRailRectShape(scale, -start_x - width, start_y, width, height, tl, tr, bl, br, false);
	}

	public void renderSignal(Junction junction, EntryDirection dir, boolean state){
		RailRenderer.junction_signal.render();
	}

	public void renderBuffer(Junction junc){
		if(!groups.contains("buffer")) return;
		if(buffer_track == null){
			buffer_track = new Track(null, new QV3D[]{ new QV3D() }, new QV3D(buffer_length, 0, 0, 0), junc.tracks.get(0).gauge);
		}
		if(buffer_track.railmodel == null){ RailRenderer.generateTrackModel(buffer_track, this); }
		TexUtil.bindTexture(buffer_track.gauge.getModelTexture());
		GL11.glRotatef(180, 0, 0, 1); GL11.glRotatef(180, 0, 1, 0);
		groups.get("buffer").render();
		GL11.glRotatef(180, 0, 0, 1); GL11.glRotatef(-90, 0, 1, 0);
		TexUtil.bindTexture(buffer_track.gauge.getTiesTexture());
		((TurboArrayPositioned)buffer_track.restmodel).renderPlain();
		TexUtil.bindTexture(buffer_track.gauge.getRailTexture());
		((TurboArrayPositioned)buffer_track.railmodel).renderPlain();
	}
	
}