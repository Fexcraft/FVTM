package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGauge extends Content<RailGauge> implements WithItem, ItemTextureable {

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
	protected ArrayList<Preset> presets;
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
		//
		if(map.has("Presets")){
			presets = new ArrayList<>();
			map.get("Presets").asArray().value.forEach(val -> {
				try{
					JsonMap mep = val.asMap();
					JsonArray path = mep.getArray("path");
					JsonArray temp;
					Preset pre = new Preset();
					pre.path = new QV3D[path.size()];
					for(int i = 0; i < pre.path.length; i++){
						temp = path.get(i).asArray();
						double x = temp.get(0).float_value();
						double y = temp.get(1).float_value();
						double z = temp.get(2).float_value();
						pre.path[i] = new QV3D(x, y, z);
					}
					pre.name = mep.get("name").string_value().toLowerCase();
					pre.segmentation = mep.getInteger("segmentation", pre.segmentation);
					presets.add(pre);
				}
				catch(Exception e){
					FvtmLogger.log("Failed to load a RailGauge Preset for '" + id.colon() + "'!");
					FvtmLogger.log("JSON: " + JsonHandler.toString(val, JsonHandler.PrintOption.FLAT));
					e.printStackTrace();
					Static.halt();
				}
			});
		}
		return this;
	}

	public static class Preset {

		public QV3D[] path;
		public String name;
		public int segmentation = 4;

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
			}
			mat.id = key;
			mat.amount = v;
			return mat;
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

	public ArrayList<Preset> getPresets(){
		return presets;
	}

}
