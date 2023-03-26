package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.model.ModelGroup.Program;
import net.fexcraft.mod.fvtm.model.WirePrograms.DownwardAngled;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;

public class WireModel extends GenericModel {
	
	public static final HashMap<String, WireModel> DECOS = new HashMap<>();
	public static final WireModel EMPTY = new WireModel();
	public HashMap<Integer, ArrayList<V3D[]>> wire_model = new HashMap<>();
	//public HashMap<Integer, Object[]> wire_data = new HashMap<>();
	public boolean wire_nocull = false;
	protected ResourceLocation texture = Resources.NULL_TEXTURE;
	protected ArrayList<String> accepts = new ArrayList<>();
	protected String key, decotype = "relay";
	
	@Override
	public WireModel parse(ModelData data){
		wire_nocull = data.get("NoWireCulling", false);
		List<String> wires = data.getList("Wire");
		if(wires.isEmpty()) return this;
		for(int i = 0; i < wires.size(); i++){
			String[] args = wires.get(i).trim().split(" ");
			boolean rect = args[0].equals("rect") || args[0].equals("flat");
			float scale = Float.parseFloat(args[1]);
			float sx = Float.parseFloat(args[2]);
			float sy = Float.parseFloat(args[3]);
			float w = Float.parseFloat(args[4]);
			float h = Float.parseFloat(args[5]);
			boolean m = Boolean.parseBoolean(args[6]);
			if(rect){
				this.addWireRect(i, scale, sx, sy, w, h, m);
			}
			else{
				V3D tl = new V3D(args, 7), tr = new V3D(args, 10), bl = new V3D(args, 13), br = new V3D(args, 16);
				this.addWireRectShape(i, scale, sx, sy, w, h, tl, tr, bl, br, m);
			}
		}
		return this;
	}
	
	public void addWireRect(int idx, float scale, float start_x, float start_y, float width, float height, boolean mirror){
		if(!wire_model.containsKey(idx)) wire_model.put(idx, new ArrayList<>());
		wire_model.get(idx).add(new V3D[]{ new V3D(start_x, start_y, 0).scale(scale), new V3D(start_x + width, start_y, 0).scale(scale) });
		if(height > 0){
			wire_model.get(idx).add(new V3D[]{ new V3D(start_x, start_y - height, 0).scale(scale), new V3D(start_x, start_y, 0).scale(scale) });
			wire_model.get(idx).add(new V3D[]{ new V3D(start_x + width, start_y, 0).scale(scale), new V3D(start_x + width, start_y - height, 0).scale(scale) });
			wire_model.get(idx).add(new V3D[]{ new V3D(start_x + width, start_y - height, 0).scale(scale), new V3D(start_x, start_y - height, 0).scale(scale) });
		}
		else{
			float h = 0.01f / scale;
			wire_model.get(idx).add(new V3D[]{ new V3D(start_x, start_y - h, 0).scale(scale), new V3D(start_x + width, start_y - h, 0).scale(scale) });
		}
		if(mirror) addWireRect(idx, scale, -start_x - width, start_y, width, height, false);
	}
	
	public void addWireRectShape(int idx, float scale, float start_x, float start_y, float width, float height, V3D tl, V3D tr, V3D bl, V3D br, boolean mirror){
		if(tl == null) tl = new V3D();
		if(tr == null) tr = new V3D();
		if(bl == null) bl = new V3D();
		if(br == null) br = new V3D();
		if(!wire_model.containsKey(idx)) wire_model.put(idx, new ArrayList<>());
		wire_model.get(idx).add(new V3D[]{ new V3D(start_x + bl.x, start_y + tl.y, 0).scale(scale), new V3D(start_x + width + br.x, start_y + tr.y, 0).scale(scale) });
		if(height > 0){
			wire_model.get(idx).add(new V3D[]{ new V3D(start_x + tl.x, start_y - height + bl.y, 0).scale(scale), new V3D(start_x + bl.x, start_y + tl.y, 0).scale(scale) });
			wire_model.get(idx).add(new V3D[]{ new V3D(start_x + width + br.x, start_y + tr.y, 0).scale(scale), new V3D(start_x + width + tr.x, start_y - height + br.y, 0).scale(scale) });
			wire_model.get(idx).add(new V3D[]{ new V3D(start_x + tl.x, start_y - height + bl.y, 0).scale(scale), new V3D(start_x + width + tr.x, start_y - height + br.y, 0).scale(scale) });
		}
		else{
			float h = 0.01f / scale;
			wire_model.get(idx).add(new V3D[]{ new V3D(start_x + tl.x, start_y - h + bl.y, 0).scale(scale), new V3D(start_x + width + tr.x, start_y - h + br.y, 0).scale(scale) });
		}
		if(mirror) addWireRectShape(idx, scale, -start_x - width, start_y, width, height, tl, tr, bl, br, false);
	}

	public void texture(ResourceLocation resloc){
		texture = resloc;
	}

	public void texture(String texloc){
		texture = new ResourceLocation(texloc);
	}
	
	public ResourceLocation texture(){
		return texture;
	}

	public void accepts(ArrayList<String> array){
		accepts = array;
	}

	public boolean accepts(String wire_type){
		return accepts.size() == 0 || accepts.contains(wire_type);
	}

	public void decotype(String type){
		decotype = type;
	}

	public String decotype(){
		return decotype;
	}

	public WireModel key(String key){
		this.key = key;
		return this;
	}
	
	public String key(){
		return key;
	}

	public float getLongestDownward(){
		float l = 0.01f;
		for(ModelGroup list : groups){
			for(Program program : list.getAllPrograms()){
				if(program instanceof DownwardAngled){
					DownwardAngled prog = (DownwardAngled)program;
					if(prog.length() > l) l = prog.length();
				}
			}
		}
		return l;
	}
	
}