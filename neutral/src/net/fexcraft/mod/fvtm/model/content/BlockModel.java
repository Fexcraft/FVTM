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
	public boolean defrot;
	public boolean rootrender;
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
						Model model = FvtmResources.getModel(e.getKey(), mergeModelData(data, e.getValue().asMap()), BlockModel.class);
						if(model != null) list.add((BlockModel)model);
					}
					if(list.size() > 0) state_models.put(entry.getKey(), list);
				}
				else if(entry.getValue().isArray()){
					for(JsonValue<?> val : entry.getValue().asArray().value){
						ModelData md = mergeModelData(data, val.asMap());
						BlockModel model = null;
						if(val.asMap().has("Model")){
							model = (BlockModel)FvtmResources.getModel(val.asMap().get("Model").string_value(), md, BlockModel.class);
						}
						else{
							model = copy();
							model.parse(md).lock();
						}
						if(!state_models.containsKey(entry.getKey())) state_models.put(entry.getKey(), new ArrayList<>());
						state_models.get(entry.getKey()).add(model);
					}
				}
				else{
					Model model = FvtmResources.getModel(entry.getValue().string_value(), mergeModelData(data, new JsonMap()), BlockModel.class);
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
		defrot = data.getBoolean("DefaultRotation", true);
		rootrender = data.getBoolean("RootRender", true);
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

	private ModelData mergeModelData(ModelData data, JsonMap map){
		if(!map.getBoolean("Merge", true)) return new ModelData(new JsonMap("ModelData", map));
		ModelData md = new ModelData(new JsonMap("ModelData", data.copy()));
		md.rem("States");
		merge(md, map);
		return md;
	}

	private void merge(JsonMap root, JsonMap map){
		for(Map.Entry<String, JsonValue<?>> entry : map.entries()){
			if(root.has(entry.getKey())){
				if(entry.getValue().isMap()){
					merge(root.getMap(entry.getKey()), entry.getValue().asMap());
					continue;
				}
				else if(entry.getValue().isArray() && !entry.getKey().equals("Translate")){
					for(JsonValue<?> val : entry.getValue().asArray().value){
						root.getArray(entry.getKey()).add(val);
					}
					continue;
				}
			}
			root.add(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * @author Ferdinand Calo' (FEX___96)
	 */
	public static class BakedTransformData {

		public AxisRotator rot_poly;
		public AxisRotator rot_meta;
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