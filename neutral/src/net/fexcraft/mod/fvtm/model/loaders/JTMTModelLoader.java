package net.fexcraft.mod.fvtm.model.loaders;

import java.util.Map.Entry;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.tmt.JsonToTMT;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelLoader;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JTMTModelLoader implements ModelLoader {

	@Override
	public boolean accepts(String name, String suffix){
		return suffix.equals("jtmt") || suffix.equals("frlj");
	}

	@Override
	public boolean load(String loc, ModelData confdata, DefaultModel model) throws Exception {
		JsonMap map = JsonHandler.parse(FvtmResources.INSTANCE.getAssetInputStream(loc, true), true).asMap();
		if(map.has("creators")){
			map.getArray("creators").value.forEach(elm -> {
				model.addToCreators(elm.string_value());
			});
		}
		model.tex_width = confdata.gsI(Model.TEXTURE_WIDTH, () -> map.getInteger("texture_size_x", 256));
		model.tex_height = confdata.gsI(Model.TEXTURE_HEIGHT, () -> map.getInteger("texture_size_y", 256));
		confdata.gsB(Model.SMOOTHSHADING, () -> map.getBoolean("smooth_shading", false));
        try{
			if(map.getInteger("format", 2) == 1){
				JsonMap modelmap = map.getMap("model");
				for(Entry<String, JsonValue<?>> entry : modelmap.entries()){
					ModelRendererTurbo[] mrts = JsonToTMT.parse(null, entry.getValue().asArray(), model.tex_width, model.tex_height);
					ModelGroup group = new ModelGroup(entry.getKey());
					for(ModelRendererTurbo mrt : mrts) group.add(new Polyhedron().importMRT(mrt, false, 0.0625f));
					model.groups.add(group);
				}
			}
            else{
				JsonMap modelmap = map.getMap("groups");
                for(Entry<String, JsonValue<?>> entry : modelmap.entries()){
                	JsonMap group = entry.getValue().asMap();
					//
					ModelRendererTurbo[] mrts = JsonToTMT.parse(null, group.get("polygons").asArray(), model.tex_width, model.tex_height);
					ModelGroup mgroup = new ModelGroup(entry.getKey());
					for(ModelRendererTurbo mrt : mrts) mgroup.add(new Polyhedron().importMRT(mrt, false, 0.0625f));
					model.groups.add(mgroup);
					//
                	if(group.has("fvtm:programs")){
                		JsonArray arr = confdata.getArray(Model.PROGRAMS, 0);
                		JsonArray array = group.get("fvtm:programs").asArray();
                		for(JsonValue<?> elm : array.value){
							arr.add(entry.getKey() + " " + elm.string_value());
                		}
                	}
                }
            }
        }
        catch(Throwable thr){
        	thr.printStackTrace();
			return false;
        }
		return true;
	}

}
