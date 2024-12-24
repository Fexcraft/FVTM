package net.fexcraft.mod.fvtm.model.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireModel extends DefaultModel {

	public static final WireModel EMPTY = new WireModel();
	public ArrayList<V3D[]> wire_model = new ArrayList<>();
	public ArrayList<float[]> wire_vv = new ArrayList<>();
	public ArrayList<Float> wire_ang = new ArrayList<>();

	@Override
	public WireModel parse(ModelData data){
		super.parse(data);
		if(data.has("Wire")){
			List<String> wires = data.getArray("Wire").toStringList();
			if(wires.isEmpty()) return this;
			for(String wire : wires){
				String[] args = wire.trim().split(" ");
				boolean rect = args[0].equals("rect") || args[0].equals("flat");
				float scale = Float.parseFloat(args[1]);
				float sx = Float.parseFloat(args[2]);
				float sy = Float.parseFloat(args[3]);
				float w = Float.parseFloat(args[4]);
				float h = Float.parseFloat(args[5]);
				boolean m = Boolean.parseBoolean(args[6]);
				float io = args.length > 7 ? Float.parseFloat(args[7]) : 0;
				float iw = args.length > 8 ? Float.parseFloat(args[8]) : 1;
				float ih = args.length > 9 ? Float.parseFloat(args[9]) : 1;
				float an = args.length > 10 ? Float.parseFloat(args[10]) : 0;
				if(rect){
					this.addWireRect(scale, sx, sy, w, h, m, new float[]{ io, iw, ih }, an);
				}
				else{
					//V3D tl = new V3D(args, 7), tr = new V3D(args, 10), bl = new V3D(args, 13), br = new V3D(args, 16);
					//this.addWireRectShape(i, scale, sx, sy, w, h, tl, tr, bl, br, m);
				}
			}
		}
		if(data.has("Wires")){
			JsonMap wires = data.getMap("Wires");
			JsonMap map = null;
			for(Map.Entry<String, JsonValue<?>> entry : wires.entries()){
				map = entry.getValue().asMap();
				float scl = map.getFloat("scale", 0.0625f);
				float[] pos = map.has("pos") ? map.getArray("pos").toFloatArray() : new float[]{ -.5f, -.5f };
				float[] siz = map.has("size") ? map.getArray("size").toFloatArray() : new float[]{ 1, 1 };
				float[] vv = map.has("v") ? map.getArray("v").toFloatArray() : new float[]{ 0, 0.125f, 0.125f };
				float ang = map.getFloat("angle", 0);
				boolean mir = map.getBoolean("mirror", false);
				addWireRect(scl, pos[0], pos[1], siz[0], siz[1], mir, vv, ang);
			}
		}
		return this;
	}

	public void addWireRect(float scale, float start_x, float start_y, float width, float height, boolean mirror, float[] vv, float ang){
		wire_model.add(new V3D[]{ new V3D(start_x, start_y, 0).scale(scale), new V3D(start_x + width, start_y, 0).scale(scale) });
		float buff = 0;
		wire_vv.add(new float[]{ vv[0], vv[0] + (buff += vv[1])});
		wire_ang.add(ang);
		if(height > 0){
			wire_model.add(new V3D[]{ new V3D(start_x, start_y + height, 0).scale(scale), new V3D(start_x, start_y, 0).scale(scale) });
			wire_vv.add(new float[]{ vv[0] + buff, vv[0] + (buff += vv[2]) });
			wire_model.add(new V3D[]{ new V3D(start_x + width, start_y, 0).scale(scale), new V3D(start_x + width, start_y + height, 0).scale(scale) });
			wire_vv.add(new float[]{ vv[0] + buff, vv[0] + (buff += vv[2]) });
			wire_model.add(new V3D[]{ new V3D(start_x + width, start_y + height, 0).scale(scale), new V3D(start_x, start_y + height, 0).scale(scale) });
			wire_vv.add(new float[]{  vv[0] + buff, vv[0] + (buff + vv[1])  });
			wire_ang.add(ang);
			wire_ang.add(ang);
			wire_ang.add(ang);
		}
		else{
			float h = 0.01f / scale;
			wire_model.add(new V3D[]{ new V3D(start_x + width, start_y + h, 0).scale(scale), new V3D(start_x, start_y + h, 0).scale(scale) });
			wire_vv.add(new float[]{  vv[0] + buff, vv[0] + (buff + vv[1])  });
			wire_ang.add(ang);
		}
		if(mirror) addWireRect(scale, -start_x - width, start_y, width, height, false, vv, ang);
	}

}