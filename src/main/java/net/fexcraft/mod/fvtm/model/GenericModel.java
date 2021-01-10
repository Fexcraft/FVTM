package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonToTMT;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 *
 * @param <T>
 * @param <K>
 */
public abstract class GenericModel<T, K> implements Model<T, K> {
	
	public static final ArrayList<String> defcreemptlist = new ArrayList<>();
	//
	//protected GroupMap groups = new GroupMap();
	public GroupList groups = new GroupList();
	private ArrayList<String> creators = new ArrayList<>();
	protected int textureX, textureY;
	public boolean smooth_shading;
	public Float scale;
	
	public GenericModel(){
		if(!DefaultPrograms.DIDLOAD) DefaultPrograms.init();
	}

	public GenericModel(JsonObject obj){
		this(); if(obj == null){ return; }
        creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
        textureX = obj.get("texture_size_x").getAsInt();
        textureY = obj.get("texture_size_y").getAsInt();
        try{
            if(JsonUtil.getIfExists(obj, "format", 2).intValue() == 1){
                JsonObject modelobj = obj.get("model").getAsJsonObject();
                for(Entry<String, JsonElement> entry : modelobj.entrySet()){
                	groups.add(new TurboList(entry.getKey(), JsonToTMT.parse(null, entry.getValue().getAsJsonArray(), textureX, textureY)));
                }
            }
            else{
            	JsonObject modelobj = obj.get("groups").getAsJsonObject();
                for(Entry<String, JsonElement> entry : modelobj.entrySet()){
                	JsonObject group = entry.getValue().getAsJsonObject();
                	groups.add(new TurboList(entry.getKey(), JsonToTMT.parse(null, group.get("polygons").getAsJsonArray(), textureX, textureY)));
                	if(group.has("fvtm:programs")){
                		JsonArray array = group.get("fvtm:programs").getAsJsonArray();
                		for(JsonElement elm : array){
                			try{
                    			if(elm.isJsonPrimitive()){
                        			groups.get(entry.getKey()).addProgram(elm.getAsString());
                    			}
                    			else groups.get(entry.getKey()).addProgram(parseProgram(elm));
                			}
                			catch(Exception e){
                				e.printStackTrace();
                			}
                		}
                	}
                }
            }
        }
        catch(Throwable thr){
        	thr.printStackTrace();
        	Static.stop();
        }
	}
	
	public TurboList.Program parseProgram(JsonElement elm) throws Exception {
		String id = (elm.isJsonArray() ? elm.getAsJsonArray().remove(0) : elm.getAsJsonObject().get("id")).getAsString();
		TurboList.Program prog = TurboList.PROGRAMS.get(id);
		if(prog == null){
			throw new Exception("TL-PROGRAM WITH ID '" + id + "' NOT FOUND!");
		}
		return prog.parse(elm);
	}
	
	private TurboList.Program parseProgram(String[] args) throws Exception {
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

	public GenericModel(ResourceLocation loc, ObjModel objdata){
		List<String> authors = ObjParser.getCommentValues(objdata, new String[]{ "Creators:", "Creator:", "Editors:", "Editor:", "Model Creator:" }, null);
		for(String auth : authors) this.creators.add(auth);
		try{
			this.textureX = Integer.parseInt(ObjParser.getCommentValue(objdata, "TextureSizeX:"));
			this.textureY = Integer.parseInt(ObjParser.getCommentValue(objdata, "TextureSizeY:"));
		}
		catch(Exception e){
			this.textureX = 256;
			this.textureY = 256;
			e.printStackTrace();
		}
		boolean flip = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "FlipAxes:"));
		this.smooth_shading = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "SmoothShading:"));
		boolean norm = Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "SkipNormals:"));//TODO read other settings
		ObjModel objmod = new ObjParser(Resources.getModelInputStream(loc)).flipAxes(flip).readComments(false).noNormals(norm).parse();
		for(String str : objmod.polygons.keySet()){
			groups.add(new TurboList(str, new ModelRendererTurbo(null, 0, 0, textureX, textureY).copyTo(objmod.polygons.get(str))));
		}
		//
		List<String[]> programs = ObjParser.getCommentValues(objdata, new String[]{ "Program:" }, null, null);
		if(!programs.isEmpty()){
			for(String[] args : programs){
				try{
					groups.get(args[0]).addProgram(parseProgram(args));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		List<String[]> pivots = ObjParser.getCommentValues(objdata, new String[]{ "Pivot:" }, null, null);
		if(!pivots.isEmpty()){
			for(String[] args : pivots){
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
								vert.vector = vert.vector.subtract(vector);
							}
						}
						turbo.rotationPointX = vector.xCoord;
						turbo.rotationPointY = vector.yCoord;
						turbo.rotationPointZ = vector.zCoord;
						turbo.rotationAngleX = rotation.xCoord;
						turbo.rotationAngleY = rotation.yCoord;
						turbo.rotationAngleZ = rotation.zCoord;
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public final java.util.Collection<String> getCreators(){
		return ImmutableList.copyOf(creators);
	}
	
	public boolean addToCreators(String str){
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
		ModelBase.bindTexture(texture);
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
	
	public static abstract class ScaledGenericModel<T, K> extends GenericModel<T, K>{

		@Override
		public void render(ModelRendererTurbo[] mrts){
			GL11.glPushMatrix();
			GL11.glScalef(scale, scale, scale);
			super.render(mrts);
			GL11.glPopMatrix();
		}
		
	}

	@Override
	public Class<?> getScaledVariant(){
		return ScaledGenericModel.class;
	}
	
}