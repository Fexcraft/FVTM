package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.item.RailPresetItem;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGauge extends TypeCore<RailGauge> implements ItemTextureable {
	
	/** In "micro blocks" (1 = 1/16th of a block). */
	protected int width;
	/** In "micro blocks" (1 = 1/16th of a block).
	 * Height between the placed track point and the actual position of the wheels on the rail. */
	protected float height, height16;
	protected float blockwidth, blockheight;
	protected RailGaugeItem item;
	protected List<String> compatible;
	protected ResourceLocation rail_texture, ties_texture, model_texture;
	//
	protected String modelid, ctab;
	protected RailGaugeModel model;
	protected ModelData modeldata;
	protected ArrayList<RailPresetItem> presets;
	protected IDL itemloc;
	
	public RailGauge(){}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public RailGauge parse(JsonObject obj){
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		this.registryname = DataUtil.getRegistryName(pack, obj);
		if(registryname == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Rail Gauge");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.width = JsonUtil.getIfExists(obj, "Width", 30).intValue();
		this.height = JsonUtil.getIfExists(obj, "Height", 4).floatValue();
		this.height16 = this.blockheight = height * Static.sixteenth;
		if(obj.has("BlockHeight")){
			this.blockheight = obj.get("BlockHeight").getAsFloat() * Static.sixteenth;
		}
		this.blockwidth = JsonUtil.getIfExists(obj, "BlockSpace", 2).floatValue();
		this.rail_texture = new ResourceLocation(JsonUtil.getIfExists(obj, "RailTexture", "minecraft:textures/blocks/iron_block.png"));
		this.ties_texture = new ResourceLocation(JsonUtil.getIfExists(obj, "TiesTexture", "minecraft:textures/blocks/anvil_base.png"));
		this.model_texture = new ResourceLocation(JsonUtil.getIfExists(obj, "ModelTexture", "fvtm:textures/entity/null.png"));
		/*if(obj.has("RailWidth") && !obj.get("RailWidth").isJsonPrimitive()){
			JsonArray array = obj.get("RailWidth").getAsJsonArray();
			rail_widths = new float[rails = array.size() / 2];
			for(int i = 0; i < array.size(); i++){
				rail_widths[i * 2] = array.get(i * 2).getAsFloat();
				rail_offsets[i * 2 + 1] = array.get(i * 2 + 1).getAsFloat();
			}
		}
		else{
			float fl = JsonUtil.getIfExists(obj, "RailWidth", 2f).floatValue();
			rail_widths = new float[]{ -fl, fl }; rails = 2;
			rail_offsets = new float[]{ -(inner_width / 2), inner_width / 2 }; 
		}*/
		this.compatible = DataUtil.getStringArray(obj, "Compatible", false, true);
		if(Static.isClient()){
			modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
			modeldata = new ModelData();//TODO
		}
		//
        this.ctab = JsonUtil.getIfExists(obj, "CreativeTab", "default");
		this.itemloc = IDLManager.getIDLCached(DataUtil.getItemTexture(registryname, getDataType(), obj).toString());
		this.item = new RailGaugeItem(this);
		//
		if(obj.has("PreSets")){
			presets = new ArrayList<>();
			for(JsonElement element : obj.get("PreSets").getAsJsonArray()){
				try{
					JsonObject jsn = element.getAsJsonObject();
					JsonArray array = jsn.get("path").getAsJsonArray(), temp;
					GridV3D[] vecs = new GridV3D[array.size()];
					for(int i = 0; i < vecs.length; i++){
						temp = array.get(i).getAsJsonArray();
						double x = temp.get(0).getAsDouble();
						double y = temp.get(1).getAsDouble();
						double z = temp.get(2).getAsDouble();
						vecs[i] = new GridV3D(new V3D(x, y, z));
					}
					RailPresetItem item = new RailPresetItem(this, jsn.get("name").getAsString().toLowerCase(), vecs);
					item.setSegmentation(JsonUtil.getIfExists(jsn, "segmentation", 4).intValue());
					presets.add(item); continue;
				}
				catch(Exception e){
					Print.log("Failed to load a RailGauge Preset for '" + registryname.toString() + "'!");
					Print.log("JSON: " + element); e.printStackTrace(); Static.halt();
				}
			}
		}
		return this;
	}

	@Override
	public ContentType getDataType(){
		return ContentType.RAILGAUGE;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}
	
	public RailGaugeItem getRailGaugeItem(){
		return item;
	}
	
	@Override
	public Item getItem(){
		return item;
	}

	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
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
	
	public ResourceLocation getRailTexture(){
		return rail_texture;
	}
	
	public ResourceLocation getTiesTexture(){
		return ties_texture;
	}
	
	public ResourceLocation getModelTexture(){
		return model_texture;
	}
	
	@Nullable
	public ArrayList<RailPresetItem> getPresets(){
		return presets;
	}
	
	public float getBlockWidth(){
		return blockwidth;
	}
	
	public float getBlockHeight(){
		return blockheight;
	}

	//@Override
	public String getCreativeTab(){
		return ctab;
	}

	@Override
	public IDL getItemTexture(){
		return itemloc;
	}

}
