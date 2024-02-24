package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGauge extends Content<RailGauge> implements WithItem, ItemTextureable {
	
	/** In "micro blocks" (1 = 1/16th of a block). */
	protected int width;
	/** In "micro blocks" (1 = 1/16th of a block).
	 * Height between the placed track point and the actual position of the wheels on the rail. */
	protected float height, height16;
	protected float blockwidth, blockheight;
	protected List<String> compatible;
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
		width = map.getInteger("Width", 30);
		height = map.getFloat("Height", 4);
		height16 = blockheight = height * Static.sixteenth;
		if(map.has("BlockHeight")){
			blockheight = map.get("BlockHeight").float_value() * Static.sixteenth;
		}
		blockwidth = map.getFloat("BlockSpace", 2);
		rail_texture = IDLManager.getIDLNamed(map.getString("RailTexture", "minecraft:textures/blocks/iron_block.png"));
		ties_texture = IDLManager.getIDLNamed(map.getString("TiesTexture", "minecraft:textures/blocks/anvil_base.png"));
		model_texture = IDLManager.getIDLNamed(map.getString("ModelTexture", "fvtm:textures/entity/null.png"));
		compatible = ContentConfigUtil.getStringList(map, "Compatible");
		if(EnvInfo.CLIENT){
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
					pre.path = new GridV3D[path.size()];
					for(int i = 0; i < pre.path.length; i++){
						temp = path.get(i).asArray();
						double x = temp.get(0).float_value();
						double y = temp.get(1).float_value();
						double z = temp.get(2).float_value();
						pre.path[i] = new GridV3D(new V3D(x, y, z));
					}
					pre.name = mep.get("name").string_value().toLowerCase();
					pre.segmentation = mep.getInteger("segmentation", pre.segmentation);
					presets.add(pre);
				}
				catch(Exception e){
					Print.log("Failed to load a RailGauge Preset for '" + id.colon() + "'!");
					Print.log("JSON: " + JsonHandler.toString(val, JsonHandler.PrintOption.FLAT));
					e.printStackTrace();
					Static.halt();
				}
			});
		}
		return this;
	}

	public static class Preset {

		public GridV3D[] path;
		public String name;
		public int segmentation = 4;

	}

	@Override
	public ContentType getContentType(){
		return ContentType.RAILGAUGE;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	public int width(){
		return width;
	}
	
	public float height(){
		return height;
	}
	
	public float height16(){
		return height16;
	}

	public List<String> getCompatible(){
		return compatible;
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
	
	public float getBlockWidth(){
		return blockwidth;
	}
	
	public float getBlockHeight(){
		return blockheight;
	}

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
