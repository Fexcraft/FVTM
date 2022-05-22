package net.fexcraft.mod.fvtm.model.loaders;

import java.util.ArrayList;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonToTMT;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Model.ModelLoader;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;

public class JTMTModelLoader implements ModelLoader {

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals(".jtmt");
	}

	@Override
	public Object[] load(String name, ModelData confdata) throws Exception {
		GenericModel model = new GenericModel();
		JsonObject obj = JsonUtil.getObjectFromInputStream(Resources.getModelInputStream(new ResourceLocation(name), true));
		if(obj.has("creators")){
			obj.get("creators").getAsJsonArray().forEach(elm -> {
				confdata.creators().add(elm.getAsString());
			});
		}
		model.textureX = confdata.set(Model.TEXTURE_WIDTH, obj.get("texture_size_x").getAsInt());
		model.textureY = confdata.set(Model.TEXTURE_HEIGHT, obj.get("texture_size_y").getAsInt());
		confdata.set(Model.SMOOTHSHADING, () -> obj.has("smooth_shading") && obj.get("smooth_shading").getAsBoolean());
        try{
            if(JsonUtil.getIfExists(obj, "format", 2).intValue() == 1){
                JsonObject modelobj = obj.get("model").getAsJsonObject();
                for(Entry<String, JsonElement> entry : modelobj.entrySet()){
                	model.groups.add(new TurboList(entry.getKey(), JsonToTMT.parse(null, entry.getValue().getAsJsonArray(), model.textureX, model.textureY)));
                }
            }
            else{
            	JsonObject modelobj = obj.get("groups").getAsJsonObject();
                for(Entry<String, JsonElement> entry : modelobj.entrySet()){
                	JsonObject group = entry.getValue().getAsJsonObject();
                	model.groups.add(new TurboList(entry.getKey(), JsonToTMT.parse(null, group.get("polygons").getAsJsonArray(), model.textureX, model.textureY)));
                	if(group.has("fvtm:programs")){
                		ArrayList<Object> arr = confdata.get(Model.PROGRAMS, () -> new ArrayList<>());
                		JsonArray array = group.get("fvtm:programs").getAsJsonArray();
                		for(JsonElement elm : array){
                			if(elm.isJsonPrimitive()) arr.add(entry.getKey() + " " + elm.getAsString());
                			else arr.add(new Object[]{ entry.getKey(), elm });
                		}
                	}
                }
            }
        }
        catch(Throwable thr){
        	thr.printStackTrace();
        	Static.stop();
        }
		return new Object[]{ model, confdata };
	}

}
