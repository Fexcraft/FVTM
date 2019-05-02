package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Modifier;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Part extends TypeCore<Part> implements Textureable.TextureHolder {
	
	protected ArrayList<Attribute<?>> attributes;
	protected ArrayList<Modifier<?>> modifiers;
	protected ArrayList<ResourceLocation> textures;
	protected List<String> categories;
	protected PartItem item;
	protected String modelid;
	protected Model<VehicleData, String> model;
	
	public Part(){}

	@Override
	public Part setRegistryName(ResourceLocation name){
		registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public Class<Part> getRegistryType(){
		return Part.class;
	}

	@Override
	public Part parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Part");
		this.categories = DataUtil.getStringArray(obj, "Category", true, true);
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.textures = DataUtil.getTextures(obj);
		//
		if(obj.has("Attributes")){
			this.attributes = new ArrayList<>();
			JsonArray array = obj.get("Attributes").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				String id = json.get("id").getAsString();
				String type = json.get("type").getAsString();
				String target = json.has("target") ? json.get("target").getAsString() : "vehicle";
				Attribute<?> attr = null;
				switch(type){
					case "string": case "text": {
						attr = new Attribute<String>(true, id, json.get("value").getAsString()).setTarget(target); break;
					}
					case "float": case "double": {
						attr = new Attribute<Float>(true, id, json.get("value").getAsFloat()).setTarget(target); break;
					}
					case "integer": case "number": {
						attr = new Attribute<Integer>(true, id, json.get("value").getAsInt()).setTarget(target); break;
					}
					default: continue;
				}
				if(json.has("max") || json.has("min")){
					float min = JsonUtil.getIfExists(json, "min", Integer.MIN_VALUE).floatValue();
					float max = JsonUtil.getIfExists(json, "max", Integer.MAX_VALUE).floatValue();
					attr.setMinMax(min, max);
				}
				this.attributes.add(attr);
			}
		}
		if(obj.has("Modifiers")){
			this.modifiers = new ArrayList<>();
			JsonArray array = obj.get("Modifiers").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				Modifier.Priority priority = Modifier.Priority.valueOf(json.get("priority").getAsString().toUpperCase());
				Modifier.Type type = Modifier.Type.valueOf(json.get("type").getAsString().toUpperCase());
				Attribute.UpdateCall interval = json.has("update") ? Attribute.UpdateCall.valueOf(json.get("update").getAsString().toUpperCase()) : null;
				if(priority == null || type == null) continue; if(interval == null) interval = Attribute.UpdateCall.INSTALL;
				String id = json.get("id").getAsString(), target = json.get("target").getAsString();
				String val = json.has("val") ? json.get("val").getAsString() : null;
				float value = json.has("value") ? json.get("value").getAsFloat() : 0f;
				boolean bool = json.has("base") ? json.get("base").getAsBoolean() : false;
				if(val == null){
					this.modifiers.add(new Modifier<Float>(id, value, bool, type, interval, priority).setTarget(target));
				}
				else{
					this.modifiers.add(new Modifier<String>(id, val, bool, type, interval, priority).setTarget(target));
				}
			}
		} 
		if(obj.has("Functions")){
			//TODO
		}
		//
		this.modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
		this.item = new PartItem(this); return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.PART;
	}

	@Override
	public Class<?> getDataClass(){
		return PartData.class;
	}

	public String getCategory(){
		return categories.isEmpty() ? null : categories.get(0);
	}
	
	public List<String> getCategories(){
		return categories;
	}
	
	public PartItem getItem(){
		return item;
	}
	
	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}
	
	public Model<VehicleData, String> getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		this.model = Resources.getModel(modelid, PartModel.class);
	}
	
	@Nullable
	public Collection<Attribute<?>> getAttributes(){
		return attributes;
	}
	
	public Collection<Modifier<?>> getAttributeModifiers(){
		return modifiers;
	}

	@Override
	public java.util.List<ResourceLocation> getDefaultTextures(){
		return textures;
	}

}
