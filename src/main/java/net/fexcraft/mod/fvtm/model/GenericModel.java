package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.model.ConditionalPrograms.ConditionBased;
import net.fexcraft.mod.fvtm.model.ModelGroup.ConditionalProgram;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.Transforms;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 */
public class GenericModel implements Model {

	public static final GenericModel EMPTY = new GenericModel();
	public static final ModelRenderData RENDERDATA = new ModelRenderData();
	public static final ArrayList<String> DEF_NO_CREATORS = new ArrayList<>();
	private ArrayList<String> creators = new ArrayList<>();
	public Transforms transforms = new Transforms();
	public GroupList groups = new GroupList();
	public int textureX, textureY;
	public boolean smooth_shading;
	private boolean locked;
	protected String name;
	
	public GenericModel(){
		if(!DefaultPrograms.DIDLOAD){
			DefaultPrograms.init();
			ConditionalPrograms.init();
			WirePrograms.init();
			TrafficSignPrograms.init();
		}
	}

	@Override
	public void render(ModelRenderData data){
		transforms.apply();
        GL11.glShadeModel(smooth_shading ? GL11.GL_FLAT : GL11.GL_SMOOTH);
		for(ModelGroup list : groups) list.render(data);
		transforms.deapply();
	}
	
	@Override
	public GenericModel parse(ModelData data){
		smooth_shading = data.get(SMOOTHSHADING, false);
		if(data.contains(PROGRAMS)){
			ArrayList<Object> programs = data.get(PROGRAMS);
			for(Object obj : programs){
				if(obj instanceof String){
					String[] split = obj.toString().trim().split(" ");
					if(!groups.contains(split[0])) continue;
					try{
						groups.get(split[0]).addProgram(parseProgram(split));
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				else{ // most likely JsonElement from JTMT / FRL Json
					Object[] objs = (Object[])obj;
					if(!groups.contains(objs[0].toString())) continue;
					try{
						groups.get(objs[0].toString()).addProgram(parseProgram((JsonElement)objs[1]));
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		if(data.contains(CONDPROGRAMS)){
			ArrayList<Object> programs = data.get(CONDPROGRAMS);
			for(Object obj : programs){
				if(obj instanceof JsonObject){
					JsonObject json = (JsonObject)obj;
					if(!json.has("id") || !json.has("group")) continue;
					try{
						String group = json.get("group").getAsString();
						String progid = json.get("id").getAsString();
						ConditionalProgram prog = null;
						if(ModelGroup.COND_PROGRAMS.containsKey(progid)){
							prog = ModelGroup.COND_PROGRAMS.get(progid).getConstructor().newInstance();
						}
						else prog = new ConditionBased(progid);
						if(json.has("ifmet")){
							JsonArray array = json.get("ifmet").getAsJsonArray();
							for(JsonElement elm : array){
								if(elm.isJsonPrimitive()) prog.add(parseProgram(elm.getAsString().trim().split(" ")));
								else prog.add(parseProgram(elm));
							}
						}
						if(json.has("else")){
							JsonArray array = json.get("else").getAsJsonArray();
							for(JsonElement elm : array){
								if(elm.isJsonPrimitive()) prog.addElse(parseProgram(elm.getAsString().trim().split(" ")));
								else prog.addElse(parseProgram(elm));
							}
						}
						if(json.has("args")){
							prog = (ConditionBased)prog.parse(json.get("args").getAsString().trim().split(" "));
						}
						groups.get(group).addProgram(prog);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					continue;
				}
				String string = obj.toString();
				String[] args = string.trim().split("||");
				if(!groups.contains(args[0])) continue;
				try{
					ConditionalProgram prog = null;
					if(ModelGroup.COND_PROGRAMS.containsKey(args[1])){
						prog = ModelGroup.COND_PROGRAMS.get(args[1]).getConstructor().newInstance();
					}
					else prog = new ConditionBased(args[1]);
					String[] sub = args[2].split("|");
					for(String s : sub){
						prog.add(parseProgram(s.trim().split(" ")));
					}
					if(args.length > 3){
						sub = args[3].split("|");
						for(String s : sub){
							prog.addElse(parseProgram(s.trim().split(" ")));
						}
					}
					if(args.length > 4){
						prog = (ConditionBased)prog.parse(args[4].trim().split(" "));
					}
					groups.get(args[0]).addProgram(prog);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.contains(TRANSFORMS)){
			for(String string : ((List<String>)data.get(TRANSFORMS))){
				transforms.parse(string.trim().split(" "));
			}
		}
		if(data.contains(PIVOTS)){
			for(String string : ((List<String>)data.get(PIVOTS))){
				String[] args = string.trim().split(" ");
				if(!groups.contains(args[0])) continue;
				try{
					ModelGroup group = groups.get(args[0]);
					Vec3f vector = new Vec3f(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
					Vec3f rotation = new Vec3f(
						args.length > 4 ? Float.parseFloat(args[4]) : 0,
						args.length > 5 ? Float.parseFloat(args[5]) : 0,
						args.length > 6 ? Float.parseFloat(args[6]) : 0
					);
					for(ModelRendererTurbo turbo : group){
						for(TexturedPolygon poly : turbo.getFaces()){
							for(TexturedVertex vert : poly.getVertices()){
								vert.vector = vert.vector.sub(vector);
							}
						}
						turbo.rotationPointX = vector.x;
						turbo.rotationPointY = vector.y;
						turbo.rotationPointZ = vector.z;
						turbo.rotationAngleX = rotation.x;
						turbo.rotationAngleY = rotation.y;
						turbo.rotationAngleZ = rotation.z;
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.contains(OFFSET)){
			for(String string : ((List<String>)data.get(OFFSET))){
				String[] args = string.trim().split(" ");
				if(!groups.contains(args[0])) continue;
				try{
					ModelGroup group = groups.get(args[0]);
					Vec3f vector = new Vec3f(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
					for(ModelRendererTurbo turbo : group){
						for(TexturedPolygon poly : turbo.getFaces()){
							for(TexturedVertex vert : poly.getVertices()){
								vert.vector = vert.vector.sub(vector);
							}
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return this;
	}
	
	@Override
	public void lock(){
		if(locked) return;
		for(ModelGroup list : groups) list.initPrograms();
		this.locked = true;
	}
	
	public static ModelGroup.Program parseProgram(JsonElement elm) throws Exception {
		String id = (elm.isJsonArray() ? elm.getAsJsonArray().remove(0) : elm.getAsJsonObject().get("id")).getAsString();
		ModelGroup.Program prog = ModelGroup.PROGRAMS.get(id);
		if(prog == null){
			throw new Exception("TL-PROGRAM WITH ID '" + id + "' NOT FOUND!");
		}
		return prog.parse(elm);
	}
	
	private static ModelGroup.Program parseProgram(String[] args) throws Exception {
		if(args[1].startsWith("[") || args[1].startsWith("{")){
			return parseProgram(JsonUtil.getFromString(args[1]));
		}
		else{
			ModelGroup.Program prog = ModelGroup.PROGRAMS.get(args[1]);
			if(prog == null){
				throw new Exception("TL-PROGRAM WITH ID '" + args[1] + "' NOT FOUND!");
			}
			return prog.parse(Arrays.copyOfRange(args, 2, args.length));
		}
	}

	@Override
	public final java.util.Collection<String> getCreators(){
		return ImmutableList.copyOf(creators);
	}
	
	public boolean addToCreators(String str){
		if(locked) return false;
		return creators.add(str);
	}

	public void translate(float x, float y, float z){
		groups.forEach(group -> group.translate(x, y, z));
	}
	public void rotate(float x, float y, float z, boolean apply){
		groups.forEach(group -> group.rotate(x, y, z, apply));
	}
	
	public void fixRotations(){
		groups.forEach(group -> fixRotations(group));
	}

	public void bindTexture(ResourceLocation texture){
		TexUtil.bindTexture(texture);
	}
	
	public static void fixRotations(ModelGroup group){
        for(ModelRendererTurbo model : group){
            if(model.isShape3D){
                model.rotationAngleY = -model.rotationAngleY;
                model.rotationAngleX = -model.rotationAngleX;
                model.rotationAngleZ = -model.rotationAngleZ + 180f;
            }
            else{
                model.rotationAngleZ = -model.rotationAngleZ;
            }
        }
    }
	
	public void add(String key, ModelRendererTurbo[] mrts){
		this.groups.add(new ModelGroup(key, mrts));
	}
	
	public ModelGroup get(String key){
		return groups.get(key);
	}

	public ModelGroup get(String string, boolean allownull){
		ModelGroup list = get(string); return list == null ? allownull ? list : ModelGroup.EMPTY : list;
	}
	
	public void render(ModelRendererTurbo[] mrts){
		for(ModelRendererTurbo mrt : mrts) mrt.render();
	}
	
	public static final class GroupList extends ArrayList<ModelGroup> {
		
		@Override
		public boolean add(ModelGroup list){
			//list.initPrograms();
			return super.add(list);
		}

		public ModelGroup get(String key){
			for(ModelGroup list : this) if(list.name.equals(key)) return list; return null;
		}
		
		public boolean contains(String key){
			return get(key) != null;
		}
		
	}

	public void clearDisplayLists(ModelGroup list){
		for(ModelRendererTurbo turbo : list)
			if(turbo != null && turbo.displaylist() != null)
				GL11.glDeleteLists(turbo.displaylist(), 1);
	}

	public void clearDisplayLists(){
		for(ModelGroup list : groups) clearDisplayLists(list);
	}
	
	public void setName(String string){
		name = string;
	}
	
}