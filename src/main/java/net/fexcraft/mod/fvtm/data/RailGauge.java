package net.fexcraft.mod.fvtm.data;

import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGauge extends TypeCore<RailGauge> {
	
	/** In "micro blocks" (1 = 1/16th of a block). */
	protected int width;
	/** In "micro blocks" (1 = 1/16th of a block).
	 * Height between the placed track point and the actual position of the wheels on the rail. */
	protected float height; protected float height16;
	protected RailGaugeItem item;
	protected List<String> compatible;
	protected ResourceLocation texture;
	//
	protected String modelid;
	protected RailGaugeModel model;
	
	public RailGauge(){}

	@Override
	public RailGauge setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Class<RailGauge> getRegistryType(){
		return RailGauge.class;
	}

	@Override
	public RailGauge parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Rail Gauge");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.width = JsonUtil.getIfExists(obj, "Width", 30).intValue();
		this.height = JsonUtil.getIfExists(obj, "Height", 4).floatValue();
		this.height16 = height * Static.sixteenth;
		this.texture = DataUtil.getTextures(obj).get(0);
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
		this.modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
		//
		this.item = new RailGaugeItem(this); return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.RAILGAUGE;
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
		this.model = (RailGaugeModel)Resources.getModel(modelid, RailGaugeModel.class);
	}
	
	public ResourceLocation getTexture(){
		return texture;
	}

}
