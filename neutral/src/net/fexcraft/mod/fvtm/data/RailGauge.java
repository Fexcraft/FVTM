package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGauge extends Content<RailGauge> implements WithItem, ItemTextureable {

	public static final ArrayList<Preset> PRESETS = new ArrayList<>();
	public static final float DEFWIDTH = 1.875f;
	//
	protected float width;
	protected float height;
	//protected float blockwidth;
	//protected float blockheight;
	protected List<String> compatible;
	protected List<UseMat> materials = new ArrayList<>();
	protected IDL rail_texture;
	protected IDL ties_texture;
	protected IDL model_texture;
	//
	protected String modelid, ctab;
	protected RailGaugeModel model;
	protected ModelData modeldata;
	//protected ArrayList<Preset> presets;
	protected IDL itemtexloc;
	
	public RailGauge(){}

	@Override
	public RailGauge parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Material");
		description = ContentConfigUtil.getStringList(map, "Description");
		width = map.getFloat("Width", DEFWIDTH);
		height = map.getFloat("Height", 0.25f);
		//blockwidth = map.getFloat("BlockSpace", 2);
		//blockheight = map.getFloat("BlockHeight", 0);
		String blks = EnvInfo.is112() ? "blocks" : "block";
		rail_texture = IDLManager.getIDLNamed(map.getString("RailTexture", "minecraft:textures/" + blks + "/iron_block.png"));
		ties_texture = IDLManager.getIDLNamed(map.getString("TiesTexture", "minecraft:textures/" + blks + "/anvil_base.png"));
		model_texture = IDLManager.getIDLNamed(map.getString("ModelTexture", "fvtm:textures/" + blks + "/null.png"));
		compatible = ContentConfigUtil.getStringList(map, "Compatible");
		if(map.has("UseMaterials")){
			for(Map.Entry<String, JsonValue<?>> entry : map.getMap("UseMaterials").entries()){
				if(UseMat.invalid(entry.getKey())) continue;
				materials.add(UseMat.parse(entry.getKey(), entry.getValue().float_value()));
			}
		}
		else{
			materials.add(UseMat.parse(EnvInfo.is112() ? "#ingotIron" : "#c:ingots/iron", 0.25f));
			materials.add(UseMat.parse(EnvInfo.is112() ? "#plankWood" : "#minecraft:planks", 0.2f));
		}
		if(EnvInfo.CLIENT || EnvInfo.is121()){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
		//
        this.ctab = map.getString("CreativeTab", "default");
        this.itemtexloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		return this;
	}

	public static class Preset {

		public RailGauge gauge;
		public QV3D[] path;
		public String name;
		public int rot = 4;

		public JsonMap save(boolean withname){
			JsonMap set = new JsonMap();
			JsonArray path = new JsonArray();
			for(QV3D vec : this.path){
				path.add(new JsonArray.Flat(vec.vec.x, vec.vec.y, vec.vec.z));
			}
			set.add("gauge", gauge.getIDS());
			if(withname) set.add("name", name);
			set.add("path", path);
			set.add("rot", rot);
			return set;
		}

		public Preset load(String key, JsonMap map){
			JsonArray arr = map.getArray("path");
			JsonArray temp;
			path = new QV3D[arr.size()];
			for(int i = 0; i < path.length; i++){
				temp = arr.get(i).asArray();
				double x = temp.get(0).float_value();
				double y = temp.get(1).float_value();
				double z = temp.get(2).float_value();
				path[i] = new QV3D(x, y, z);
			}
			gauge = FvtmRegistry.RAILGAUGES.get(map.get("gauge").string_value());
			if(gauge == null) gauge = FvtmRegistry.RAILGAUGES.get(FvtmRegistry.STANDARD_GAUGE);
			name = key;
			rot = map.getInteger("rot", rot);
			return this;
		}
	}

	public static class UseMat {

		public String id;
		public boolean tag;
		public float amount;

		public static UseMat parse(String key, float v){
			UseMat mat = new UseMat();
			if(key.startsWith("#")){
				mat.tag = true;
				key = key.substring(1);
				if(EnvInfo.is120() && key.startsWith("c:")) key = key.replace("c:", "forge:");
				else if(!EnvInfo.is120() && key.startsWith("forge:")) key = key.replace("forge:", "c:");
			}
			mat.id = key;
			mat.amount = v;
			return mat;
		}

		public static boolean invalid(String key){
			return key.startsWith("#") && key.contains(":") == EnvInfo.is112();
		}

	}

	@Override
	public ContentType getContentType(){
		return ContentType.RAILGAUGE;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	public float getWidth(){
		return width;
	}
	
	public float getHeight(){
		return height;
	}

	public List<String> getCompatible(){
		return compatible;
	}

	public List<UseMat> getMaterials(){
		return materials;
	}

	public RailGaugeModel getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		this.model = (RailGaugeModel)FvtmResources.getModel(modelid, modeldata, RailGaugeModel.class);
	}
	
	public IDL getRailTexture(){
		return rail_texture;
	}
	
	public IDL getTiesTexture(){
		return ties_texture;
	}
	
	public IDL getModelTexture(){
		return model_texture;
	}
	
	/*public float getBlockWidth(){
		return blockwidth;
	}
	
	public float getBlockHeight(){
		return blockheight;
	}*/

	@Override
	public IDL getItemTexture(){
		return itemtexloc;
	}

	@Override
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	/*public ArrayList<Preset> getPresets(){
		return presets;
	}*/

	public static void loadPresets(){
		File file = new File(FvtmRegistry.CONFIG_DIR, "fvtm-rail-presets.json");
		if(!file.exists()) return;
		JsonMap map = JsonHandler.parse(file);
		if(!map.has("presets")) return;
		for(Map.Entry<String, JsonValue<?>> entry : map.getMap("presets").value.entrySet()){
			try{
				PRESETS.add(new Preset().load(entry.getKey(), entry.getValue().asMap()));
			}
			catch(Exception e){
				FvtmLogger.log("Failed to load a RailGauge Preset '" + entry.getKey() + "'!");
				FvtmLogger.log("JSON: " + JsonHandler.toString(entry.getValue(), JsonHandler.PrintOption.FLAT));
				e.printStackTrace();
			}
		}
	}

	public static void savePresets(){
		JsonMap presets = new JsonMap();
		for(Preset preset : PRESETS){
			presets.add(preset.name, preset.save(false));
		}
		JsonMap map = new JsonMap();
		map.add("presets", presets);
		map.add("saved", Time.getAsString(Time.getDate()));
		JsonHandler.print(new File(FvtmRegistry.CONFIG_DIR, "fvtm-rail-presets.json"), map);
	}

	public static Preset getPreset(String string){
		for(Preset preset : PRESETS){
			if(preset.name.equals(string)) return preset;
		}
		return null;
	}

}
