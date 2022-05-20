package net.fexcraft.mod.fvtm.model;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.model.ConditionalPrograms.ConditionBased;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.Transforms;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 * 
 */
public class GenericModel implements Model {
	
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
			WirePrograms.init();
			TrafficSignPrograms.init();
		}
	}

	@Override
	public void render(ModelRenderData data){
		// TODO Auto-generated method stub
	}
	
	@Override
	public GenericModel parse(ModelData data){
		List<String> list = data.values.get("Creators");
		for(String str : list) this.addToCreators(str);
		
		return this;
	}
	
	@Override
	public void lock(){
		this.locked = true;
	}
	
	public static TurboList.Program parseProgram(JsonElement elm) throws Exception {
		String id = (elm.isJsonArray() ? elm.getAsJsonArray().remove(0) : elm.getAsJsonObject().get("id")).getAsString();
		TurboList.Program prog = TurboList.PROGRAMS.get(id);
		if(prog == null){
			throw new Exception("TL-PROGRAM WITH ID '" + id + "' NOT FOUND!");
		}
		return prog.parse(elm);
	}
	
	private static TurboList.Program parseProgram(String[] args) throws Exception {
		if(args[1].startsWith("[") || args[1].startsWith("{")){
			return parseProgram(JsonUtil.getFromString(args[1]));
		}
		else{
			TurboList.Program prog = TurboList.PROGRAMS.get(args[1]);
			if(prog == null){
				throw new Exception("TL-PROGRAM WITH ID '" + args[1] + "' NOT FOUND!");
			}
			return prog.parse(Arrays.copyOfRange(args, 2, args.length));
		}
	}
	
	public <M extends GenericModel> M parse(Object[] stream, String type){
		if(!type.equals("fmf")) return (M)this;
		try{
			HashMap<String, Object> data = stream[0] instanceof InputStream ? FMFParser.parse(this, (InputStream)stream[0]) : (HashMap<String, Object>)stream[0];
			smooth_shading = data.containsKey("SmoothShading") && Boolean.parseBoolean(data.get("SmoothShading").toString());
			if(data.containsKey("Programs")){
				for(String string : ((List<String>)data.get("Programs"))){
					String[] args = string.trim().split(" ");
					if(!groups.contains(args[0])) continue;
					try{
						groups.get(args[0]).addProgram(parseProgram(args));
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				for(TurboList list : groups){
					if(list.hasPrograms()) list.initPrograms();
				}
			}
			if(data.containsKey("CondPrograms")){
				for(String string : ((List<String>)data.get("CondPrograms"))){
					String[] args = string.trim().split("||");
					if(!groups.contains(args[0])) continue;
					try{
						ConditionBased prog = new ConditionBased(args[1]);
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
						groups.get(args[0]).addProgram(prog);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				for(TurboList list : groups){
					if(list.hasPrograms()) list.initPrograms();
				}
			}
			if(data.containsKey("Transforms")){
				for(String string : ((List<String>)data.get("Transforms"))){
					transforms.parse(string.trim().split(" "));
				}
			}
			if(data.containsKey("Pivots")){
				for(String string : ((List<String>)data.get("Pivots"))){
					String[] args = string.trim().split(" ");
					if(!groups.contains(args[0])) continue;
					try{
						TurboList group = groups.get(args[0]);
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
			if(data.containsKey("Offset")){
				for(String string : ((List<String>)data.get("Offset"))){
					String[] args = string.trim().split(" ");
					if(!groups.contains(args[0])) continue;
					try{
						TurboList group = groups.get(args[0]);
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
			if(stream.length > 1) for(Closeable c : (Closeable[])stream[1]) c.close();
		}
		catch(IOException e){
			e.printStackTrace();
			Static.stop();
		}
		return (M)this;
	}

	/**
	 * @param groups Empty when no filter been specified, every group is loaded then.
	 */
	public GenericModel(ResourceLocation loc, ObjModel objdata, ArrayList<String> objgroups, boolean excludeobjs){
		List<String> authors = ObjParser.getCommentValues(objdata, new String[]{ "Creators:", "Creator:", "Editors:", "Editor:", "Model Creator:" }, null);
		for(String auth : authors) this.creators.add(auth);
		try{
			String tex = ObjParser.getCommentValue(objdata, "TextureSizeX:");
			String tey = ObjParser.getCommentValue(objdata, "TextureSizeY:");
			this.textureX = tex == null ? 256 : Integer.parseInt(tex);
			this.textureY = tey == null ? 256 : Integer.parseInt(tey);
		}
		catch(Exception e){
			this.textureX = 256;
			this.textureY = 256;
			e.printStackTrace();
		}
		boolean flip_x = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipAxes:"));
		boolean flip_f = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipFaces:"));
		boolean flip_u = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipU:"));
		boolean flip_v = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipV:"));
		this.smooth_shading = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "SmoothShading:"));
		boolean norm = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "SkipNormals:"));//TODO read other settings
		ObjModel objmod = Resources.getObjModelFromCache(loc, flip_x, flip_f, flip_u, flip_v, norm);
		if(objgroups.isEmpty()){
			for(String str : objmod.polygons.keySet()) addGroup(str, objmod);
		}
		else{
			if(excludeobjs){
				for(String str : objmod.polygons.keySet()){
					if(objgroups.contains(str) && excludeobjs) continue;
					addGroup(str, objmod);
				}
			}
			else{
				for(String str : objgroups){
					if(!objmod.polygons.containsKey(str)) continue;
					addGroup(str, objmod);
				}
			}
		}
		//
		List<String[]> programs = ObjParser.getCommentValues(objdata, new String[]{ "Program:" }, null, null);
		if(!programs.isEmpty()){
			for(String[] args : programs){
				if(!groups.contains(args[0])) continue;
				try{
					groups.get(args[0]).addProgram(parseProgram(args));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		List<String[]> condprograms = ObjParser.getCommentValues(objdata, new String[]{ "CondPrograms:" }, "||", null);
		if(!condprograms.isEmpty()){
			for(String[] args : condprograms){
				if(!groups.contains(args[0])) continue;
				try{
					ConditionBased prog = new ConditionBased(args[1]);
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
					groups.get(args[0]).addProgram(prog);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		//
		for(TurboList list : groups){
			if(list.hasPrograms()) list.initPrograms();
		}
		//
		List<String[]> pivots = ObjParser.getCommentValues(objdata, new String[]{ "Pivot:" }, null, null);
		if(!pivots.isEmpty()){
			for(String[] args : pivots){
				if(!groups.contains(args[0])) continue;
				try{
					TurboList group = groups.get(args[0]);
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
		List<String[]> offsets = ObjParser.getCommentValues(objdata, new String[]{ "Offset:" }, null, null);
		if(!offsets.isEmpty()){
			for(String[] args : offsets){
				if(!groups.contains(args[0])) continue;
				try{
					TurboList group = groups.get(args[0]);
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
		List<String[]> transforms = ObjParser.getCommentValues(objdata, new String[]{ "Transform:" }, null, null);
		if(!transforms.isEmpty()){
			for(String[] args : transforms){
				try{
					this.transforms.parse(args);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	public void addGroup(String str, ObjModel objmod){
		groups.add(new TurboList(str, new ModelRendererTurbo(null, 0, 0, textureX, textureY).copyTo(objmod.polygons.get(str))));
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
	
	public static void fixRotations(TurboList group){
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
		this.groups.add(new TurboList(key, mrts));
	}
	
	public TurboList get(String key){
		return groups.get(key);
	}

	public TurboList get(String string, boolean allownull){
		TurboList list = get(string); return list == null ? allownull ? list : TurboList.EMPTY : list;
	}
	
	public void render(ModelRendererTurbo[] mrts){
		for(ModelRendererTurbo mrt : mrts) mrt.render();
	}
	
	public static final class GroupList extends ArrayList<TurboList> {
		
		@Override
		public boolean add(TurboList list){
			list.initPrograms();
			return super.add(list);
		}

		public TurboList get(String key){
			for(TurboList list : this) if(list.name.equals(key)) return list; return null;
		}
		
		public boolean contains(String key){
			return get(key) != null;
		}
		
	}

	public void clearDisplayLists(TurboList list){
		for(ModelRendererTurbo turbo : list)
			if(turbo != null && turbo.displaylist() != null)
				GL11.glDeleteLists(turbo.displaylist(), 1);
	}

	public void clearDisplayLists(){
		for(TurboList list : groups) clearDisplayLists(list);
	}
	
}