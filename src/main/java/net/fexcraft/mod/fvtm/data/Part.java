package net.fexcraft.mod.fvtm.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Print;
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
import net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Part extends TypeCore<Part> implements Textureable.TextureHolder {
	
	protected ArrayList<Attribute> attributes = new ArrayList<>();
	protected ArrayList<Modifier> modifiers = new ArrayList<>();
	protected List<NamedResourceLocation> textures;
	protected List<String> categories;
	protected PartItem item;
	protected String modelid;
	protected Model<VehicleData, String> model;
	protected PartInstallationHandler installhandler;
	protected Object installhandler_data;
	
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
			JsonArray array = obj.get("Attributes").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				String id = json.get("id").getAsString();
				String type = json.get("type").getAsString();
				String target = json.has("target") ? json.get("target").getAsString() : "vehicle";
				Attribute attr = null; boolean isbool = false;
				switch(type){
					case "string": case "text": {
						attr = new Attribute.StringAttribute(true, id, json.get("value").getAsString()).setTarget(target); break;
					}
					case "float": case "double": {
						attr = new Attribute.FloatAttribute(true, id, json.get("value").getAsFloat()).setTarget(target); break;
					}
					case "integer": case "number": {
						attr = new Attribute.IntegerAttribute(true, id, json.get("value").getAsInt()).setTarget(target); break;
					}
					case "boolean": case "bool": {
						attr = new Attribute.IntegerAttribute(true, id, json.get("value").getAsBoolean() ? 1 : 0, true); isbool = true; break;
					}
					default: continue;
				}
				if((json.has("max") || json.has("min")) && !isbool){
					float min = JsonUtil.getIfExists(json, "min", Integer.MIN_VALUE).floatValue();
					float max = JsonUtil.getIfExists(json, "max", Integer.MAX_VALUE).floatValue();
					attr.setMinMax(min, max);
				}
				this.attributes.add(attr);
			}
		}
		if(obj.has("Modifiers")){
			JsonArray array = obj.get("Modifiers").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				Modifier.Priority priority = Modifier.Priority.valueOf(json.get("priority").getAsString().toUpperCase());
				Modifier.Type type = Modifier.Type.valueOf(json.get("type").getAsString().toUpperCase());
				Attribute.UpdateCall interval = json.has("update") ? Attribute.UpdateCall.valueOf(json.get("update").getAsString().toUpperCase()) : null;
				if(priority == null || type == null) continue; if(interval == null) interval = Attribute.UpdateCall.INITIAL;
				String id = json.get("id").getAsString(), target = json.get("target").getAsString();
				String val = json.has("val") ? json.get("val").getAsString() : null;
				float value = json.has("value") ? json.get("value").getAsFloat() : 0f;
				boolean bool = json.has("base") ? json.get("base").getAsBoolean() : false;
				if(val == null){
					this.modifiers.add(new Modifier.FloatModifier(id, value, bool, type, interval, priority).setTarget(target));
				}
				else{
					this.modifiers.add(new Modifier.StringModifier(id, val, bool, type, interval, priority).setTarget(target));
				}
			}
		} 
		if(obj.has("Functions")){
			//TODO
		}
		//
		if(obj.has("Installation")){
			JsonObject inst = obj.get("Installation").isJsonPrimitive() ? null : obj.get("Installation").getAsJsonObject();
			String handler = inst == null ? obj.get("Installation").getAsString() : inst.has("Handler") ? inst.get("Handler").getAsString() : "default";
			if(handler.equals("default") || handler.equals("def")){
				this.installhandler = DefaultPartInstallHandler.INSTANCE;
				this.installhandler_data = new DefaultPartInstallHandler.DPIHData(inst);
			}
			else if(handler.equals("advanced") || handler.equals("adv")){
				this.installhandler = null;//TODO make the advanced one
			}
			else if(handler.equals("wheel") || handler.equals("wheel_handler") || handler.equals("wheel_installer")){
				this.installhandler = WheelInstallationHandler.INSTANCE;
				this.installhandler_data = new WheelInstallationHandler.WheelData(inst);
			}
			else{
				//try to load the class
				try{
					Class<?> clazz = Class.forName(handler.replace(".class", ""));
					this.installhandler = (PartInstallationHandler)clazz.newInstance();
					if(inst != null) this.installhandler.parse(inst);
				}
				catch(Exception e){ Print.log("Failed to load InstallationHandler for `" + this.getRegistryName().toString() + "`!"); e.printStackTrace(); }
			}
		} else{ this.installhandler = DefaultPartInstallHandler.INSTANCE; }
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
	public Collection<Attribute> getBaseAttributes(){
		return attributes;
	}
	
	public Collection<Modifier> getBaseModifiers(){
		return modifiers;
	}

	@Override
	public List<NamedResourceLocation> getDefaultTextures(){
		return textures;
	}
	
	public PartInstallationHandler getInstallationHandler(){
		return installhandler;
	}
	
	/** Only for the internal `default` and `advanced` installation handlers, otherwise null. */
	@SuppressWarnings("unchecked")
	public <U> U getInstallationHandlerData(){
		return (U)installhandler_data;
	}

}
