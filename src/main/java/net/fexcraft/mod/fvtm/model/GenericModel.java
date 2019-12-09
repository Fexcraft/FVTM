package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonToTMT;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.utils.WavefrontObjUtil;
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
                	groups.add(new TurboList(entry.getKey(), JsonToTMT.parse(null, entry.getValue().getAsJsonObject().get("polygons").getAsJsonArray(), textureX, textureY)));
                	if(entry.getValue().isJsonObject() && entry.getValue().getAsJsonObject().has("fvtm:programs")){
                		for(JsonElement elm : entry.getValue().getAsJsonObject().get("fvtm:programs").getAsJsonArray()){
                			groups.get(entry.getKey()).addProgram(elm.getAsString());
                		}
                	}
                }
            }
        }
        catch(Throwable thr){
        	thr.printStackTrace(); net.fexcraft.lib.mc.utils.Static.stop();
        }
	}
	
	public GenericModel(String type, ResourceLocation loc){
		if(!type.equals("obj")) return;
		String[][] authors = WavefrontObjUtil.findValues(Resources.getModelInputStream(loc), new String[]{ "# Creators:", "# Creator:", "# Editors:", "# Editor:", "# Model Creator:" });
		for(String[] str : authors) for(String auth : str) this.creators.add(auth);
		try{
			this.textureX = Integer.parseInt(WavefrontObjUtil.findValues(Resources.getModelInputStream(loc), "# TextureSizeX:")[0][0]);
			this.textureY = Integer.parseInt(WavefrontObjUtil.findValues(Resources.getModelInputStream(loc), "# TextureSizeY:")[0][0]);
		}
		catch(Exception e){ e.printStackTrace(); }
		String str[][] = WavefrontObjUtil.findValues(Resources.getModelInputStream(loc), "# FlipAxes:");
		boolean bool = str.length == 0 ? false : Boolean.parseBoolean(str[0][0]);
		String[] ogroups = WavefrontObjUtil.getGroups(Resources.getModelInputStream(loc));
		for(String group : ogroups){
			try{
				groups.add(new TurboList(group, new ModelRendererTurbo[]{
					new ModelRendererTurbo(null, 0, 0, textureX, textureY).setFlipped(bool).addObj(Resources.getModelInputStream(loc), group, bool)
				}));
			} catch(Exception e){ e.printStackTrace(); }
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
	
	public static final class GroupMap extends TreeMap<String, TurboList> {
		
		public void add(TurboList group){ this.put(group.name, group); }
		
		@Override
		public TurboList get(Object key){
			return super.get(key) == null ? TurboList.EMPTY : super.get(key);
		}
		
	}
	
	public static final class GroupList extends ArrayList<TurboList> {

		public TurboList get(String key){
			for(TurboList list : this) if(list.name.equals(key)) return list; return null;
		}
		
		public boolean contains(String key){
			return get(key) != null;
		}
		
	}
	
}