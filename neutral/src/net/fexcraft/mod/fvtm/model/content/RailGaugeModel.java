package net.fexcraft.mod.fvtm.model.content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;

import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGaugeModel extends DefaultModel {

	public static final RailGaugeModel EMPTY = new RailGaugeModel();
	public ArrayList<V3D[]> rail_model = new ArrayList<>();
	public ArrayList<float[]> rail_vv = new ArrayList<>();
	public ArrayList<Float> rail_u = new ArrayList<>();
	public boolean rail_tempcull = false;
	public float ties_distance = 0.5f;
	public float signal_offset = 0.25f;
	//public float buffer_length = 2f;
	
	@Override
	public RailGaugeModel parse(ModelData data){
		super.parse(data);
		rail_tempcull = data.getBoolean("RailCulling", false);
		ties_distance = data.getFloat("TiesDistance", ties_distance);
		signal_offset = data.getFloat("SignalOffset", signal_offset);
		//buffer_length = data.getFloat("BufferLength", buffer_length);
		if(data.has("Rail")){
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
				float io = args.length > 7 ? Float.parseFloat(args[7]) / tex_height : 0;
				float iw = args.length > 8 ? Float.parseFloat(args[8]) / tex_height : 0.125f  / tex_height;
				float ih = args.length > 9 ? Float.parseFloat(args[9]) / tex_height : 0.125f  / tex_height;
				if(rect){
					this.addRailRect(scale, sx, sy, w, h, m, 1f, new float[]{ io, iw, ih });
				}
				else{
					V3D tl = new V3D(args, 7), tr = new V3D(args, 10), bl = new V3D(args, 13), br = new V3D(args, 16);
					this.addRailRectShape(scale, sx, sy, w, h, tl, tr, bl, br, m);
				}
			}
		}
		if(data.has("Rails")){
			JsonMap rails = data.getMap("Rails");
			JsonMap map = null;
			for(Map.Entry<String, JsonValue<?>> entry : rails.entries()){
				map = entry.getValue().asMap();
				float scl = map.getFloat("scale", 1f);
				float[] pos = map.has("pos") ? map.getArray("pos").toFloatArray() : new float[]{ 0.9375f, 0 };
				float[] siz = map.has("size") ? map.getArray("size").toFloatArray() : new float[]{ 0.125f, 0.125f };
				float[] vv;
				if(map.has("v")){
					vv = map.getArray("v").toFloatArray();
					for(int i = 0; i < vv.length; i++){
						vv[i] /= tex_height;
					}
				}
				else{
					vv = new float[]{ 0, 0.125f * tex_height, 0.125f * tex_height };
				}
				float u = map.getFloat("u", 16f) / tex_width;
				boolean mir = map.getBoolean("mirror", true);
				addRailRect(scl, pos[0], pos[1], siz[0], siz[1], mir, u, vv);
			}
		}
		return this;
	}

	@Override
	public void render(ModelRenderData data){
		for(ModelGroup list : groups) list.render();
	}
	
	public void addRailRect(float scale, float start_x, float start_y, float width, float height, boolean mirror, float u, float[] vv){
		rail_model.add(new V3D[]{ new V3D(start_x, start_y, 0).scale(scale), new V3D(start_x + width, start_y, 0).scale(scale) });
		float buff = 0;
		rail_vv.add(new float[]{ vv[0], vv[0] + (buff += vv[1])});
		rail_u.add(u);
		if(height > 0){
			rail_model.add(new V3D[]{ new V3D(start_x, start_y + height, 0).scale(scale), new V3D(start_x, start_y, 0).scale(scale) });
			rail_vv.add(new float[]{ vv[0] + buff, vv[0] + (buff += vv[2]) });
			rail_model.add(new V3D[]{ new V3D(start_x + width, start_y, 0).scale(scale), new V3D(start_x + width, start_y + height, 0).scale(scale) });
			rail_vv.add(new float[]{ vv[0] + buff, vv[0] + (buff += vv[2]) });
			rail_model.add(new V3D[]{ new V3D(start_x + width, start_y + height, 0).scale(scale), new V3D(start_x, start_y + height, 0).scale(scale) });
			rail_vv.add(new float[]{  vv[0] + buff, vv[0] + (buff + vv[1]) });
			for(int i = 0; i < 3; i++){
				rail_u.add(u);
			}
		}
		else{
			float h = 0.01f / scale;
			rail_model.add(new V3D[]{ new V3D(start_x + width, start_y + h, 0).scale(scale), new V3D(start_x, start_y + h, 0).scale(scale) });
			rail_vv.add(new float[]{  vv[0] + buff, vv[0] + (buff + vv[1])  });
			rail_u.add(u);
		}
		if(mirror) addRailRect(scale, -start_x - width, start_y, width, height, false, u, vv);
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
		//TODO
	}

	@Override
	public int getDefTexWidth(){
		return 16;
	}

	@Override
	public int getDefTexHeight(){
		return 16;
	}
	
}