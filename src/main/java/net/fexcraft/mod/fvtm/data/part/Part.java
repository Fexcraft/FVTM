package net.fexcraft.mod.fvtm.data.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Modifier;
import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.root.Soundable.SoundHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.handler.BogieInstallationHandler;
import net.fexcraft.mod.fvtm.util.handler.ConnectorInstallationHandler;
import net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.fvtm.util.handler.TireInstallationHandler;
import net.fexcraft.mod.fvtm.util.handler.WheelInstallationHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Part extends TypeCore<Part> implements Textureable.TextureHolder, SoundHolder {
	
	protected ArrayList<Attribute<?>> attributes = new ArrayList<>();
	protected ArrayList<Modifier<?>> modifiers = new ArrayList<>();
	protected List<NamedResourceLocation> textures;
	protected List<String> categories;
	protected PartItem item;
	protected String modelid;
	protected Model<VehicleData, String> model;
	protected PartInstallationHandler installhandler;
	protected Object installhandler_data;
	protected ArrayList<Function> functions = new ArrayList<>();
	protected ArrayList<Class<? extends VehicleScript>> scripts = new ArrayList<>();
	protected TreeMap<String, Sound> sounds = new TreeMap<>();
	protected TreeMap<String, SwivelPoint> rotpoints = new TreeMap<>();
	
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
				Attribute<?> attr = null; boolean isbool = false;
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
						attr = new Attribute.BooleanAttribute(true, id, json.get("value").getAsBoolean()).setTarget(target); isbool = true; break;
					}
					case "tristate": case "threestate": case "ternary": {
						Boolean bool = !json.has("value") || json.get("value").toString().equals("null") ? null : json.get("value").getAsBoolean();
						attr = new Attribute.TriStateAttribute(true, id, bool); isbool = true; break;
					}
					default: continue;
				}
				if((json.has("max") || json.has("min")) && !isbool){
					float min = JsonUtil.getIfExists(json, "min", Integer.MIN_VALUE).floatValue();
					float max = JsonUtil.getIfExists(json, "max", Integer.MAX_VALUE).floatValue();
					attr.setMinMax(min, max);
				}
				if(json.has("editable")) attr.setEditable(json.get("editable").getAsBoolean());
				if(json.has("external")) attr.setExternal(json.get("external").getAsBoolean());
				if(json.has("hitbox")){
					if(json.get("hitbox").isJsonArray()){
						JsonArray erray = json.get("hitbox").getAsJsonArray();
						int expected = attr.type().isFloat() || attr.type().isInteger() ? 7 : 4;
						float[] arr = new float[expected];
						for(int i = 0; i < expected; i++){
							arr[i] = erray.get(i).getAsFloat();
						}
						attr.addAABB("default", arr, erray.size() > expected ? erray.get(expected).getAsString() : null);
					}
					else if(json.get("hitbox").isJsonObject()){
						for(Map.Entry<String, JsonElement> entry : json.get("hitbox").getAsJsonObject().entrySet()){
							JsonArray erray = entry.getValue().getAsJsonArray();
							int expected = attr.type().isFloat() || attr.type().isInteger() ? 7 : 4;
							float[] arr = new float[expected];
							for(int i = 0; i < expected; i++){
								arr[i] = erray.get(i).getAsFloat();
							}
							attr.addAABB(entry.getKey(), arr, erray.size() > expected ? erray.get(expected).getAsString() : null);
						}
					}
				}
				attr.setSeat(json.has("seat") ? json.get("seat").getAsString() : null);
				this.attributes.add(attr);
			}
		}
		if(obj.has("Modifiers")){
			JsonArray array = obj.get("Modifiers").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				Modifier.Priority priority = Modifier.Priority.valueOf(json.get("priority").getAsString().toUpperCase());
				Modifier.ModifierType type = Modifier.ModifierType.valueOf(json.get("type").getAsString().toUpperCase());
				Attribute.Update interval = json.has("update") ? Attribute.Update.valueOf(json.get("update").getAsString().toUpperCase()) : null;
				if(priority == null || type == null){ Print.debug(json); Static.stop(); continue;  }
				if(interval == null) interval = Attribute.Update.INITIAL;
				String id = json.get("id").getAsString(), target = json.get("target").getAsString();
				String val = json.has("val") ? json.get("val").getAsString() : null;
				float value = json.has("value") ? json.get("value").getAsFloat() : 0f;
				if(val == null){
					this.modifiers.add(new Modifier.FloatModifier(id, value, type, interval, priority).setTarget(target));
				}
				else{
					this.modifiers.add(new Modifier.StringModifier(id, val, type, interval, priority).setTarget(target));
				}
			}
		} 
		if(obj.has("Function") || obj.has("Functions")){
			JsonArray array = obj.has("Functions") ? obj.get("Functions").getAsJsonArray() : new JsonArray();
			if(obj.has("Function")) array.add(obj.get("Function"));
			//
			for(JsonElement elm : array){
				JsonObject elmobj = elm.isJsonPrimitive() ? null : elm.getAsJsonObject();
				String id = elmobj == null ? elm.getAsString() : elmobj.get("id").getAsString();
				Class<? extends Function> func = Resources.getFunction(id);
				if(func != null){
					try {
						this.functions.add(func.getConstructor(Part.class, JsonObject.class).newInstance(this, elmobj));
					} catch(Exception e){ e.printStackTrace(); }
				}
				else{
					Print.log("Function with ID '" + id + "' for PART '" + registryname.toString() + "' not found!"); Static.stop();
				}
			}
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
			else if(handler.equals("tire") || handler.equals("tyre")|| handler.equals("tire_handler") || handler.equals("tire_installer")){
				this.installhandler = TireInstallationHandler.INSTANCE;
				this.installhandler_data = new TireInstallationHandler.TireData(inst);
			}
			else if(handler.equals("connector")){
				this.installhandler = ConnectorInstallationHandler.INSTANCE;
				this.installhandler_data = new ConnectorInstallationHandler.ConnectorData(inst);
			}
			else if(handler.equals("bogie")){
				this.installhandler = BogieInstallationHandler.INSTANCE;
				this.installhandler_data = new BogieInstallationHandler.BogieData(inst);
			}
			else{
				//try to load the class
				try{
					Class<?> clazz = Class.forName(handler.replace(".class", ""));
					this.installhandler = (PartInstallationHandler)clazz.newInstance();
					if(inst != null) this.installhandler.parse(inst);
				}
				catch(Exception e){
					Print.log("Failed to load InstallationHandler for `" + this.getRegistryName().toString() + "`!"); e.printStackTrace();
					Static.stop();
				}
			}
		} else{ this.installhandler = DefaultPartInstallHandler.INSTANCE; }
		//
		if(obj.has("Script")){
            try{ scripts.add((Class<? extends VehicleScript>)Class.forName(obj.get("Script").getAsString().replace(".class", ""))); }
            catch(Exception e){ e.printStackTrace(); }
		}
		if(obj.has("Scripts")){
			JsonArray array = obj.get("Scripts").getAsJsonArray();
			for(JsonElement elm : array){
	            try{ scripts.add((Class<? extends VehicleScript>)Class.forName(elm.getAsString().replace(".class", ""))); }
	            catch(Exception e){ e.printStackTrace(); }
			}
		}
		if(obj.has("SwivelPoints") && obj.get("SwivelPoints").isJsonArray()){
			obj.get("SwivelPoints").getAsJsonArray().forEach(elm -> {
				try{
					SwivelPoint point = new SwivelPoint(elm.getAsJsonObject());
					rotpoints.put(point.id, point);
				}
				catch(Exception e){
					e.printStackTrace();
					Static.stop();
				}
			});
		}
		if(obj.has("Sounds")){
            for(JsonElement elm : obj.get("Sounds").getAsJsonArray()){
                JsonObject json = elm.getAsJsonObject();
                this.sounds.put(json.get("event").getAsString(),
                	new Sound(new ResourceLocation(json.get("sound").getAsString()),
                		JsonUtil.getIfExists(obj, "volume", 1f).floatValue(),
                		JsonUtil.getIfExists(obj, "pitch", 1f).floatValue()));
            }
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
	
	public PartItem getPartItem(){
		return item;
	}
	
	@Override
	public Item getItem(){
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
	public Collection<Attribute<?>> getBaseAttributes(){
		return attributes;
	}
	
	public Collection<Modifier<?>> getBaseModifiers(){
		return modifiers;
	}

	@Override
	public List<NamedResourceLocation> getDefaultTextures(){
		return textures;
	}
	
	public PartInstallationHandler getInstallationHandler(){
		return installhandler;
	}
	
	/** Not every handler may have additional data. */
	public <U> U getInstallationHandlerData(){
		return (U)installhandler_data;
	}
	
	public List<Function> getDefaultFunctions(){
		return functions;
	}
	
	public List<Class<? extends VehicleScript>> getVehicleScripts(){
		return scripts;
	}

	@Override
	public Map<String, Sound> getSounds(){
		return sounds;
	}

	public TreeMap<String, SwivelPoint> getDefaultSwivelPoints(){
		return rotpoints;
	}

}
