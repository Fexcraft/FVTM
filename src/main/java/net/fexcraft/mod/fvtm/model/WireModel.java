package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.fexcraft.mod.fvtm.model.WirePrograms.DownwardAngled;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class WireModel extends GenericModel {
	
	public static final HashMap<String, WireModel> DECOS = new HashMap<>();
	public static final WireModel EMPTY = new WireModel();
	public HashMap<Integer, ArrayList<Vec3f[]>> wire_model = new HashMap<>();
	//public HashMap<Integer, Object[]> wire_data = new HashMap<>();
	public boolean wire_tempcull = false;
	protected ResourceLocation texture = Resources.NULL_TEXTURE;
	protected ArrayList<String> accepts = new ArrayList<>();
	protected String key, decotype = "relay";
	
	public WireModel(){ super(); }
	
	public WireModel(JsonObject obj){ super(obj); }
	
	@Override
	public WireModel parse(Object[] stream, String type){
		return super.parse(stream, type);
	}
	
	public WireModel(ResourceLocation loc, ObjModel data, ArrayList<String> objgroups, boolean exclude){
		super(loc, data, objgroups, exclude);
		wire_tempcull = Boolean.parseBoolean(ObjParser.getCommentValue(data, "WireCulling:"));
		List<String[]> wires = ObjParser.getCommentValues(data, new String[]{ "Wire:" }, null, null);
		if(wires.isEmpty()) return;
		for(int i = 0; i < wires.size(); i++){
			String[] args = wires.get(i);
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
				Vec3f tl = new Vec3f(args, 7), tr = new Vec3f(args, 10), bl = new Vec3f(args, 13), br = new Vec3f(args, 16);
				this.addWireRectShape(i, scale, sx, sy, w, h, tl, tr, bl, br, m);
			}
		}
		/*wires = ObjParser.getCommentValues(data, new String[]{ "WireData:" }, null, null);
		for(String[] args : wires){
			int idx = Integer.parseInt(args[0]);
			if(args.length < 2) continue;
			Object[] odata = new Object[1];
			for(int i = 1; i < args.length; i++){
				String[] split = args[i].split(":");
				switch(split[0]){
					case "noslack":{
						odata[0] = true;
						break;
					}
				}
			}
			wire_data.put(idx, odata);
		}*/
	}

	@Override
	public void render(BlockData data, TileEntity tile){
		transforms.apply();
		for(TurboList list : groups) list.renderBlock(tile, data, null);
		transforms.deapply();
	}

	@Override
	public void render(BlockData data, TileEntity tile, Entity ent, RenderCache cache){
		transforms.apply();
		GL11.glShadeModel(smooth_shading ? GL11.GL_FLAT : GL11.GL_SMOOTH);
		for(TurboList list : groups) list.renderBlock(tile, data, cache);
		transforms.deapply();
	}
	
	public void addWireRect(int idx, float scale, float start_x, float start_y, float width, float height, boolean mirror){
		if(!wire_model.containsKey(idx)) wire_model.put(idx, new ArrayList<>());
		wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x, start_y, 0).scale(scale), new Vec3f(start_x + width, start_y, 0).scale(scale) });
		if(height > 0){
			wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x, start_y - height, 0).scale(scale), new Vec3f(start_x, start_y, 0).scale(scale) });
			wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x + width, start_y, 0).scale(scale), new Vec3f(start_x + width, start_y - height, 0).scale(scale) });
			wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x, start_y - height, 0).scale(scale), new Vec3f(start_x + width, start_y - height, 0).scale(scale) });
		}
		else{
			float h = 0.01f / scale;
			wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x, start_y - h, 0).scale(scale), new Vec3f(start_x + width, start_y - h, 0).scale(scale) });
		}
		if(mirror) addWireRect(idx, scale, -start_x - width, start_y, width, height, false);
	}
	
	public void addWireRectShape(int idx, float scale, float start_x, float start_y, float width, float height, Vec3f tl, Vec3f tr, Vec3f bl, Vec3f br, boolean mirror){
		if(tl == null) tl = new Vec3f();
		if(tr == null) tr = new Vec3f();
		if(bl == null) bl = new Vec3f();
		if(br == null) br = new Vec3f();
		if(!wire_model.containsKey(idx)) wire_model.put(idx, new ArrayList<>());
		wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x + bl.x, start_y + tl.y, 0).scale(scale), new Vec3f(start_x + width + br.x, start_y + tr.y, 0).scale(scale) });
		if(height > 0){
			wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x + tl.x, start_y - height + bl.y, 0).scale(scale), new Vec3f(start_x + bl.x, start_y + tl.y, 0).scale(scale) });
			wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x + width + br.x, start_y + tr.y, 0).scale(scale), new Vec3f(start_x + width + tr.x, start_y - height + br.y, 0).scale(scale) });
			wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x + tl.x, start_y - height + bl.y, 0).scale(scale), new Vec3f(start_x + width + tr.x, start_y - height + br.y, 0).scale(scale) });
		}
		else{
			float h = 0.01f / scale;
			wire_model.get(idx).add(new Vec3f[]{ new Vec3f(start_x + tl.x, start_y - h + bl.y, 0).scale(scale), new Vec3f(start_x + width + tr.x, start_y - h + br.y, 0).scale(scale) });
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
		for(TurboList list : groups){
			for(Program program : list.programs){
				if(program instanceof DownwardAngled){
					DownwardAngled prog = (DownwardAngled)program;
					if(prog.length() > l) l = prog.length();
				}
			}
		}
		return l;
	}
	
}