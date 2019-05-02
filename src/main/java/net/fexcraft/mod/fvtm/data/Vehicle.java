package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Vehicle extends TypeCore<Vehicle> implements Textureable.TextureHolder, Colorable.ColorHolder {

	protected TreeMap<String, Attribute> attributes = new TreeMap<>();
	protected Model<VehicleData, Object> model;
	protected ArrayList<ResourceLocation> textures;
	protected RGB primary, secondary;
	protected String modelid;
	//
	protected VehicleType type;
	protected VehicleItem item;

	@Override
	public Vehicle setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Class<Vehicle> getRegistryType(){
		return Vehicle.class;
	}

	@Override
	public Vehicle parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Vehicle");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.type = VehicleType.valueOf(JsonUtil.getIfExists(obj, "VehicleType", "LAND").toUpperCase());
		this.textures = DataUtil.getTextures(obj);
		this.primary = DataUtil.getColor(obj, "Primary");
		this.secondary = DataUtil.getColor(obj, "Secondary");
		//
		if(obj.has("Attributes")){
			JsonArray array = obj.get("Attributes").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				String id = json.get("id").getAsString();
				String type = json.get("type").getAsString();
				Attribute attr = null;
				switch(type){
					case "string": case "text": {
						attr = new Attribute.StringAttribute(true, id, json.get("value").getAsString()); break;
					}
					case "float": case "double": {
						attr = new Attribute.FloatAttribute(true, id, json.get("value").getAsFloat()); break;
					}
					case "integer": case "number": {
						attr = new Attribute.IntegerAttribute(true, id, json.get("value").getAsInt()); break;
					}
					default: continue;
				}
				if(json.has("max") || json.has("min")){
					float min = JsonUtil.getIfExists(json, "min", Integer.MIN_VALUE).floatValue();
					float max = JsonUtil.getIfExists(json, "max", Integer.MAX_VALUE).floatValue();
					attr.setMinMax(min, max);
				}
				this.attributes.put(attr.getId(), attr);
			}
		}
		//TODO add code for filling in missing attributes, based on vehicle type
		if(!attributes.containsKey("weight")) attributes.put("weight", new Attribute.FloatAttribute(true, "weight", 1000f).setMinMax(0, Integer.MAX_VALUE));
		//
		this.modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
		this.item = new VehicleItem(this); return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.VEHICLE;
	}

	@Override
	public Class<?> getDataClass(){
		return VehicleData.class;
	}
	
	public VehicleItem getItem(){
		return item;
	}
	
	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}
	
	public Model<VehicleData, Object> getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		this.model = Resources.getModel(modelid, VehicleModel.class);
	}
	
	@SuppressWarnings("unchecked")
	public <ATTR extends Attribute> ATTR getAttribute(String id){
		return (ATTR)attributes.get(id);
	}
	
	public TreeMap<String, Attribute> getAttributes(){
		return attributes;
	}
	
	public VehicleType getVehicleType(){
		return type;
	}

	@Override
	public java.util.List<ResourceLocation> getDefaultTextures(){
		return textures;
	}

	@Override
	public RGB getDefaultPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getDefaultSecondaryColor(){
		return secondary;
	}

}
