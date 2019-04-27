package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Vehicle extends TypeCore<Vehicle> {

	protected ArrayList<Attribute<?>> attributes = new ArrayList<>();
	protected Model<?, ?> model;
	protected String modelid;
	//
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
		//
		if(obj.has("Attributes")){
			JsonArray array = obj.get("Attributes").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				String id = json.get("id").getAsString();
				String type = json.get("type").getAsString();
				switch(type){
					case "string": case "text": {
						this.attributes.add(new Attribute.StringAttribute(true, id, obj.get("value").getAsString())); break;
					}
					case "float": case "double": {
						this.attributes.add(new Attribute.FloatAttribute(true, id, obj.get("value").getAsFloat())); break;
					}
					case "integer": case "number": {
						this.attributes.add(new Attribute.IntegerAttribute(true, id, obj.get("value").getAsInt())); break;
					}
				}
			}
		}
		//TODO add code for filling in missing attributes, based on vehicle type
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
	
	public Model<?, ?> getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		//TODO
	}
	
	@SuppressWarnings("unchecked")
	public <ATTR extends Attribute<?>> ATTR getAttribute(String id){
		for(Attribute<?> attr : attributes){
			if(attr.id.equals(id)) return (ATTR)attr;
		} return null;
	}
	
	public Collection<Attribute<?>> getAttributes(){
		return attributes;
	}

}
