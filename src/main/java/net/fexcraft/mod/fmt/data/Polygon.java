package net.fexcraft.mod.fmt.data;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.tmt.util.JsonToTMT;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Polygon {
	
	private ModelCompound model;
	
	//BOX/BASE
	private String boxname;
	private Pos offset = new Pos(0, 0, 0), rotationangle = new Pos(0, 0, 0), rotationpoint = new Pos(0, 0, 0);
	private float height, width, depth, expansion;
	private int texturex, texturey;
	private PolygonType type = PolygonType.BOX;
	//
	private boolean oldrot, mirror, flip;
	
	//SHAPEBOX
	private float scale;
	private Pos[] corners = new Pos[]{
		new Pos(0, 0, 0), new Pos(0, 0, 0), new Pos(0, 0, 0), new Pos(0, 0, 0),
		new Pos(0, 0, 0), new Pos(0, 0, 0), new Pos(0, 0, 0), new Pos(0, 0, 0),
	};
	
	//CYLINDER/CONE
	private float radius, length, basescale, topscale;
	private int segments, direction;
	
	public Polygon(ModelCompound model, JsonObject obj){
		this.model = model;
		type = PolygonType.fromString(obj.get("type").getAsString());
		texturex = JsonToTMT.get(JsonToTMT.texturex, obj, JsonToTMT.idef);
		texturey = JsonToTMT.get(JsonToTMT.texturey, obj, JsonToTMT.idef);
		//
		offset.x = JsonToTMT.get(JsonToTMT.offx, obj, JsonToTMT.def);
		offset.y = JsonToTMT.get(JsonToTMT.offy, obj, JsonToTMT.def);
		offset.z = JsonToTMT.get(JsonToTMT.offz, obj, JsonToTMT.def);
		width  = JsonToTMT.get(JsonToTMT.width,  obj, JsonToTMT.idef);
		height = JsonToTMT.get(JsonToTMT.height, obj, JsonToTMT.idef);
		depth  = JsonToTMT.get(JsonToTMT.depth,  obj, JsonToTMT.idef);
		//
		switch(type){
			case BOX:{
				expansion = JsonToTMT.get(JsonToTMT.expansion, obj, JsonToTMT.def);
				break;
			}
			case SHAPEBOX:{
				for(int i = 0; i < 8; i++){
					corners[i].x = JsonToTMT.get("x" + i, obj, JsonToTMT.def);
					corners[i].y = JsonToTMT.get("y" + i, obj, JsonToTMT.def);
					corners[i].z = JsonToTMT.get("z" + i, obj, JsonToTMT.def);
				}
				break;
			}
			case CYLINDER:{
				radius = JsonToTMT.get(JsonToTMT.radius, obj, JsonToTMT.def);
				length = JsonToTMT.get(JsonToTMT.length, obj, JsonToTMT.def);
				segments = JsonToTMT.get(JsonToTMT.segments, obj, JsonToTMT.idef);
				basescale = JsonToTMT.get(JsonToTMT.basescale, obj, JsonToTMT.def);
				topscale = JsonToTMT.get(JsonToTMT.topscale, obj, JsonToTMT.def);
				direction = JsonToTMT.get(JsonToTMT.direction, obj, JsonToTMT.idef);
				break;
			}
		}
		//
		oldrot = JsonUtil.getIfExists(obj, JsonToTMT.oldrot, false);
		mirror = JsonUtil.getIfExists(obj, JsonToTMT.mirror, false);
		flip = JsonUtil.getIfExists(obj, JsonToTMT.flip, false);
		//
		rotationangle.x = JsonToTMT.get(JsonToTMT.rotx, obj, JsonToTMT.def);
		rotationangle.y = JsonToTMT.get(JsonToTMT.roty, obj, JsonToTMT.def);
		rotationangle.z = JsonToTMT.get(JsonToTMT.rotz, obj, JsonToTMT.def);
		//
		boxname = obj.has("name") ? obj.get("name").getAsString() : null;
		rotationpoint.x = JsonToTMT.get(JsonToTMT.posx, obj, JsonToTMT.def);
		rotationpoint.y = JsonToTMT.get(JsonToTMT.posy, obj, JsonToTMT.def);
		rotationpoint.z = JsonToTMT.get(JsonToTMT.posz, obj, JsonToTMT.def);
	}
	
	public JsonObject toJTMT(){
		JsonObject obj = new JsonObject();
		if(boxname != null){
			obj.addProperty("name", boxname);
		}
		obj.addProperty("tx", texturex);
		obj.addProperty("ty", texturey);
		obj.addProperty("ox", offset.x);
		obj.addProperty("oy", offset.y);
		obj.addProperty("oz", offset.z);
		obj.addProperty("width", width);
		obj.addProperty("height", height);
		obj.addProperty("depth", depth);
		obj.addProperty("type", type.getTypeString());
		switch(type){
			case BOX:{
				if(expansion != 0f){
					obj.addProperty("e", expansion);
				}
				break;
			}
			case SHAPEBOX:{
				if(scale != 0f){
					obj.addProperty("scale", scale);
				}
				for(int i = 0; i < 8; i++){
					if(corners[i].x != 0f){
						obj.addProperty("x" + i, corners[i].x);
					}
					if(corners[i].y != 0f){
						obj.addProperty("y" + i, corners[i].y);
					}
					if(corners[i].z != 0f){
						obj.addProperty("z" + i, corners[i].z);
					}
				}
				break;
			}
			case CYLINDER:{
				obj.addProperty("radius", radius);
				obj.addProperty("length", length);
				obj.addProperty("segments", segments);
				obj.addProperty("base_scale", basescale);
				obj.addProperty("top_scale", topscale);
				obj.addProperty("direction", direction);
				break;
			}
			default:{
				Static.stop();
				break;
			}
		}
		if(oldrot){
			obj.addProperty("oro", oldrot);
		}
		if(mirror){
			obj.addProperty("mirror", mirror);
		}
		if(flip){
			obj.addProperty("flip", flip);
		}
		obj.addProperty("rx", rotationangle.x);
		obj.addProperty("ry", rotationangle.y);
		obj.addProperty("rz", rotationangle.z);
		obj.addProperty("x", rotationpoint.x);
		obj.addProperty("y", rotationpoint.y);
		obj.addProperty("z", rotationpoint.z);
		return obj;
	}
	
	@Override
	public String toString(){
		return toJTMT().toString();
	}
	
	public static enum PolygonType {
		
		BOX("box"), SHAPEBOX("shapebox"), CYLINDER("cylinder");
		private String string;
		
		private PolygonType(String string){
			this.string = string;
		}

		public static PolygonType fromString(String string){
			switch(string){
				case "box": case "cube": case "b": return BOX;
				case "shapebox": case "sbox": case "sb": return SHAPEBOX;
				case "cylinder": case "cyl": case "c": return CYLINDER;
				case "cone": case "cn": return CYLINDER;
			}
			return BOX;
		}

		public String getTypeString(){
			return string;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public net.fexcraft.mod.lib.tmt.ModelRendererTurbo toTMT(){
		return JsonToTMT.parse(null, toJTMT(), model.texture_size_x, model.texture_size_y);
	}
	
}