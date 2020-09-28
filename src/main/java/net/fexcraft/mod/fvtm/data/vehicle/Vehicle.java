package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.root.Soundable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Vehicle extends TypeCore<Vehicle> implements Textureable.TextureHolder, Colorable.ColorHolder, Soundable.SoundHolder {

	protected TreeMap<String, Attribute<?>> attributes = new TreeMap<>();
	protected TreeMap<String, WheelSlot> defwheelpos = new TreeMap<>();
	protected Model<VehicleData, Object> model;
	protected List<NamedResourceLocation> textures;
	protected ArrayList<String> required;
	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected String modelid;
	protected LegacyData legacy_data;
	protected boolean trailer;
	protected Vec3d def_front_conn, def_rear_conn;
	protected LinkedHashMap<String, ResourceLocation> preinstalled;
	protected TreeMap<String, Sound> sounds = new TreeMap<>();
	protected TreeMap<String, SwivelPoint> rotpoints = new TreeMap<>();
	protected float coupler_range = 0.25f;
	protected HashMap<String, LiftingPoint> liftingpoints = new HashMap<>();
	//
	protected VehicleType type;
	protected VehicleItem item;

	@Override
	public Vehicle setRegistryName(ResourceLocation name){
		this.registryname = name;
		return this;
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
		channels.put("primary", DataUtil.getColor(obj, "Primary", false));
		channels.put("secondary", DataUtil.getColor(obj, "Secondary", false));
		if(obj.has("Colors")){
			for(Entry<String, JsonElement> entry : obj.get("Colors").getAsJsonObject().entrySet()){
				channels.put(entry.getKey(), new RGB(entry.getValue().getAsString()));
			}
		}
		this.required = (ArrayList<String>)DataUtil.getStringArray(obj, "RequiredParts", true, false);
		//
		if(obj.has("Attributes")){
			JsonArray array = obj.get("Attributes").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				String id = json.get("id").getAsString();
				String type = json.get("type").getAsString();
				Attribute<?> attr = null;
				boolean isbool = false;
				switch(type){
					case "string":
					case "text":{
						attr = new Attribute.StringAttribute(true, id, json.get("value").getAsString());
						break;
					}
					case "float":
					case "double":{
						attr = new Attribute.FloatAttribute(true, id, json.get("value").getAsFloat());
						break;
					}
					case "integer":
					case "number":{
						attr = new Attribute.IntegerAttribute(true, id, json.get("value").getAsInt());
						break;
					}
					case "boolean":
					case "bool":{
						attr = new Attribute.BooleanAttribute(true, id, json.get("value").getAsBoolean());
						isbool = true;
						break;
					}
					case "tristate":
					case "threestate":
					case "ternary":{
						Boolean bool = !json.has("value") || json.get("value").toString().equals("null") ? null : json.get("value").getAsBoolean();
						attr = new Attribute.TriStateAttribute(true, id, bool);
						isbool = true;
						break;
					}
					default:
						continue;
				}
				if((json.has("max") || json.has("min") && !isbool)){
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
				this.attributes.put(attr.id(), attr);
			}
		}
		// Check for missing attributes / fill in default values;
		List<Attribute<?>> attrs = type.getDefaultAttributesForType();
		for(Attribute<?> attr : attrs){
			if(!attributes.containsKey(attr.id())){
				Attribute<?> copy = attr.copy(null);
				attributes.put(copy.id(), copy);
			}
			else{
				attributes.get(attr.id()).setMinMax(attr.min(), attr.max());
			}
		}
		if(obj.has("WheelPositions")){
			JsonArray array = obj.get("WheelPositions").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				String id = json.get("id").getAsString();
				this.defwheelpos.put(id, new WheelSlot(json));
			}
		}
		//
		if(obj.has("LegacyData")){
			this.legacy_data = new LegacyData(obj.get("LegacyData").getAsJsonObject());
		}
		this.trailer = obj.has("Trailer") ? obj.get("Trailer").getAsBoolean() : obj.has("Wagon") ? obj.get("Wagon").getAsBoolean() : false;
		if(obj.has("FrontConnector")){
			this.def_front_conn = Pos.fromJson(obj.get("FrontConnector"), obj.get("FrontConnector").isJsonArray()).to16Double();
		}
		if(obj.has("RearConnector")){
			this.def_rear_conn = Pos.fromJson(obj.get("RearConnector"), obj.get("RearConnector").isJsonArray()).to16Double();
		}
		if(obj.has("CouplerRange")){
			this.coupler_range = obj.get("CouplerRange").getAsFloat();
		}
		if(obj.has("PreInstalled")){
			preinstalled = new LinkedHashMap<>();
			JsonObject pre = obj.get("PreInstalled").getAsJsonObject();
			for(java.util.Map.Entry<String, JsonElement> entry : pre.entrySet()){
				preinstalled.put(entry.getKey(), new ResourceLocation(entry.getValue().getAsString()));
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
				this.sounds.put(json.get("event").getAsString(), new Sound(new ResourceLocation(json.get("sound").getAsString()), JsonUtil.getIfExists(obj, "volume", 1f).floatValue(), JsonUtil.getIfExists(obj, "pitch", 1f).floatValue()));
			}
		}
		if(obj.has("LiftingPoints")){
			JsonObject lifts = obj.get("LiftingPoints").getAsJsonObject();
			for(Entry<String, JsonElement> entry : lifts.entrySet()){
				liftingpoints.put(entry.getKey(), new LiftingPoint(entry.getKey(), entry.getValue().getAsJsonArray()));
			}
		}
		else{
			liftingpoints.put("placeholer0", new LiftingPoint("placeholer0", new Pos(0, 0, -20), null, 0));
			liftingpoints.put("placeholer1", new LiftingPoint("placeholer1", new Pos(0, 0, 20), null, 0));
		}
		//
		this.modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
		this.item = new VehicleItem(this);
		return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.VEHICLE;
	}

	@Override
	public Class<?> getDataClass(){
		return VehicleData.class;
	}

	public VehicleItem getVehicleItem(){
		return item;
	}

	@Override
	public Item getItem(){
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
	public <ATTR extends Attribute<?>> ATTR getBaseAttribute(String id){
		return (ATTR)attributes.get(id);
	}

	@SuppressWarnings("unchecked")
	public <T, ATTR extends Attribute<T>> ATTR getBaseAttributeCasted(String id){
		return (ATTR)attributes.get(id);
	}

	public TreeMap<String, Attribute<?>> getBaseAttributes(){
		return attributes;
	}

	public VehicleType getVehicleType(){
		return type;
	}

	@Override
	public List<NamedResourceLocation> getDefaultTextures(){
		return textures;
	}

	public TreeMap<String, WheelSlot> getDefaultWheelPositions(){
		return defwheelpos;
	}

	public LegacyData getLegacyData(){
		return legacy_data;
	}

	public boolean isTrailerOrWagon(){
		return trailer;
	}

	public Vec3d getDefaultFrontConnector(){
		return def_front_conn;
	}

	public Vec3d getDefaultRearConnector(){
		return def_rear_conn;
	}

	@Nullable
	public HashMap<String, ResourceLocation> getPreInstalledParts(){
		return preinstalled;
	}

	@Override
	public Map<String, Sound> getSounds(){
		return sounds;
	}

	public float getCouplerRange(){
		return coupler_range;
	}

	public ArrayList<String> getRequiredParts(){
		return required;
	}

	public TreeMap<String, SwivelPoint> getDefaultSwivelPoints(){
		return rotpoints;
	}
	
	public HashMap<String, LiftingPoint> getLiftingPoints(){
		return liftingpoints;
	}

	@Override
	public RGB getDefaultColorChannel(String channel){
		return channels.get(channel);
	}

	@Override
	public TreeMap<String, RGB> getDefaultColorChannels(){
		return channels;
	}

}
