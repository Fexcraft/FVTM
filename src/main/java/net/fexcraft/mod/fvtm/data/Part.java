package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.Attribute.Modifier;
import net.fexcraft.mod.fvtm.data.Attribute.ModifierPriority;
import net.fexcraft.mod.fvtm.data.Attribute.ModifierType;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Part extends TypeCore<Part> {
	
	protected ArrayList<Attribute<?>> attributes;
	protected ArrayList<Modifier> modifiers;
	protected List<String> categories;
	protected PartItem item;
	protected String modelid;
	protected Model<?, ?> model;
	
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
		//
		if(obj.has("Attributes")){
			this.attributes = new ArrayList<>();
			JsonArray array = obj.get("Attributes").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				String id = json.get("id").getAsString();
				String type = json.get("type").getAsString();
				String target = json.has("target") ? json.get("target").getAsString() : "vehicle";
				switch(type){
					case "string": case "text": {
						this.attributes.add(new Attribute.StringAttribute(true, id, json.get("value").getAsString()).setTarget(target)); break;
					}
					case "float": case "double": {
						this.attributes.add(new Attribute.FloatAttribute(true, id, json.get("value").getAsFloat()).setTarget(target)); break;
					}
					case "integer": case "number": {
						this.attributes.add(new Attribute.IntegerAttribute(true, id, json.get("value").getAsInt()).setTarget(target)); break;
					}
					default: continue;
				}
			}
		}
		if(obj.has("AttributeModifiers")){
			this.modifiers = new ArrayList<>();
			JsonArray array = obj.get("AttributeModifiers").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				ModifierPriority priority = ModifierPriority.valueOf(json.get("priority").getAsString().toUpperCase());
				ModifierType type = ModifierType.valueOf(json.get("type").getAsString().toUpperCase());
				if(priority == null || type == null) continue;
				String id = json.get("id").getAsString(), target = json.get("target").getAsString();
				String val = json.has("val") ? json.get("val").getAsString() : null;
				float value = json.has("value") ? json.get("value").getAsFloat() : 0f;
				if(val == null){
					this.modifiers.add(new Modifier(id, value, type, priority).setTarget(target));
				}
				else{
					this.modifiers.add(new Modifier(id, val, type, priority));
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
	
	public Model<?, ?> getModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		//TODO
	}
	
	@Nullable
	public Collection<Attribute<?>> getAttributes(){
		return attributes;
	}
	
	public Collection<Modifier> getAttributeModifiers(){
		return modifiers;
	}

}
