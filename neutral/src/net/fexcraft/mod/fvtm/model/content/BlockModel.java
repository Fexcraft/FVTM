package net.fexcraft.mod.fvtm.model.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.AxisRotator;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.model.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockModel extends DefaultModel {

	public static final BlockModel EMPTY = new BlockModel();
	public HashMap<String, ArrayList<BlockModel>> state_models = new HashMap<>();

	public float gui_translate_x = 0;
	public float gui_translate_y = -.25f;
	public float gui_translate_z = 0;
	public float gui_scale_x = 0.75f;
	public float gui_scale_y = 0.75f;
	public float gui_scale_z = 0.75f;
	public boolean bindtex = true;
	public boolean nodefrot;
	public BakedTransformData bk;
	public HashMap<String, String> tg;
	public boolean grouptexname;

	public BlockModel(){
		super();
	}

	@Override
	public BlockModel parse(ModelData data){
		super.parse(data);
		if(data.has("ItemScale")){
			float scale = data.getFloat("ItemScale", gui_scale_x);
			gui_scale_x = scale;
			gui_scale_y = scale;
			gui_scale_z = scale;
		}
		if(data.has("ItemTranslate")){
			JsonValue<?> trs = data.get("ItemTranslate");
			if(trs.isValue()){
				float translate = data.getFloat("ItemTranslate", 0);
				gui_translate_x = translate;
				gui_translate_y = translate;
				gui_translate_z = translate;
			}
			else if(trs.isArray()){
				gui_translate_x = trs.asArray().get(0).float_value();
				gui_translate_y = trs.asArray().get(1).float_value();
				gui_translate_z = trs.asArray().get(2).float_value();
			}
		}
		bindtex = data.getBoolean("DefaultTextureBinding", true);
		if(data.has("States")){
			JsonMap states = data.getMap("States");
			for(Map.Entry<String, JsonValue<?>> entry : states.entries()){
				if(entry.getValue().isMap()){
					ArrayList<BlockModel> list = new ArrayList();
					for(Map.Entry<String, JsonValue<?>> e : entry.getValue().asMap().entries()){
						Model model = FvtmResources.getModel(e.getKey(), new ModelData(e.getValue().asMap()), BlockModel.class);
						if(model != null) list.add((BlockModel)model);
					}
					if(list.size() > 0) state_models.put(entry.getKey(), list);
				}
				else if(entry.getValue().isArray()){
					for(JsonValue<?> val : entry.getValue().asArray().value){
						JsonMap mep = val.asMap();
						Model model = null;
						if(mep.has("model")){
							model = FvtmResources.getModel(mep.get("model").string_value(), new ModelData(mep), BlockModel.class);
						}
						else model = copy();
						if(model != null){
							if(!state_models.containsKey(entry.getKey())) state_models.put(entry.getKey(), new ArrayList<>());
							state_models.get(entry.getKey()).add((BlockModel)model);
						}
					}
				}
				else{
					Model model = FvtmResources.getModel(entry.getValue().string_value(), new ModelData(), BlockModel.class);
					if(model != null){
						if(!state_models.containsKey(entry.getKey())) state_models.put(entry.getKey(), new ArrayList<>());
						state_models.get(entry.getKey()).add((BlockModel)model);
					}
				}
			}
		}
		if(data.has("RotateY")){
			transforms.add(new Transforms.TF_Rotate(0, 1, 0, data.getFloat("RotateY", 0)));
		}
		if(data.has("RotateZ")){
			transforms.add(new Transforms.TF_Rotate(0, 0, 1, data.getFloat("RotateZ", 0)));
		}
		if(data.has("RotateX")){
			transforms.add(new Transforms.TF_Rotate(1, 0, 0, data.getFloat("RotateX", 0)));
		}
		if(data.has("Translate")){
			JsonArray array = data.getArray("Translate");
			transforms.add(new Transforms.TF_Translate(array.get(0).float_value(), array.get(1).float_value(), array.get(2).float_value()));
		}
		nodefrot = data.getBoolean("NoDefaultRotation", false);
		if(data.has("GroupTextures")){
			tg = new HashMap<>();
			JsonMap grtex = data.getMap("GroupTextures");
			grtex.entries().forEach(entry -> {
				String[] k = entry.getKey().contains(",") ? entry.getKey().split(",") : new String[]{ entry.getKey() };
				String key = k.length > 1 ? k[0] + "," : "";
				String tex = k.length > 1 ? k[1] : k[0];
				if(entry.getValue().isArray()){
					for(JsonValue<?> val : entry.getValue().asArray().value){
						tg.put(key + val.string_value(), tex);
					}
				}
				else tg.put(key + entry.getValue().string_value(), tex);
			});
		}
		grouptexname = data.getBoolean("GroupEqualsTexture", false);
		return this;
	}

	/**
	 * @author Ferdinand Calo' (FEX___96)
	 */
	public static class BakedTransformData {

		public AxisRotator rot_poly, rot_meta;
		public AxisRotator[] rot_tf;
		public Vec3f translate;
		public Vec3f scale;

	}

	protected BlockModel copy(){
		BlockModel model = new BlockModel();
		for(ModelGroup group : groups){
			model.groups.add(group.copyWithoutPrograms());
		}
		return model;
	}

}