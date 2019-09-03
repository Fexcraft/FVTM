package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.fvtm.util.CollisionGrid;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Vehicle extends TypeCore<Vehicle> implements Textureable.TextureHolder, Colorable.ColorHolder {

	protected TreeMap<String, Attribute<?>> attributes = new TreeMap<>();
	protected TreeMap<String, WheelSlot> defwheelpos = new TreeMap<>();
	protected Model<VehicleData, Object> model;
	protected List<NamedResourceLocation> textures;
	protected ArrayList<String> required;
	protected RGB primary, secondary;
	protected String modelid;
	protected LegacyData legacy_data;
	protected boolean trailer;
	protected Vec3d def_front_conn, def_rear_conn;
	protected HashMap<String, ResourceLocation> preinstalled;
	protected CollisionGrid defaultgrid = new CollisionGrid();
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
		this.required = (ArrayList<String>)DataUtil.getStringArray(obj, "RequiredParts", true, false);
		//
		if(obj.has("Attributes")){
			JsonArray array = obj.get("Attributes").getAsJsonArray();
			for(JsonElement elm : array){
				JsonObject json = elm.getAsJsonObject();
				String id = json.get("id").getAsString();
				String type = json.get("type").getAsString();
				Attribute<?> attr = null; boolean isbool = false;
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
					case "boolean": case "bool": {
						attr = new Attribute.BooleanAttribute(true, id, json.get("value").getAsBoolean()); isbool = true; break;
					}
					default: continue;
				}
				if((json.has("max") || json.has("min") && !isbool)){
					float min = JsonUtil.getIfExists(json, "min", Integer.MIN_VALUE).floatValue();
					float max = JsonUtil.getIfExists(json, "max", Integer.MAX_VALUE).floatValue();
					attr.setMinMax(min, max);
				}
				if(json.has("editable")) attr.setEditable(json.get("editable").getAsBoolean());
				attr.setSeat(json.has("seat") ? json.get("seat").getAsString() : null);
				this.attributes.put(attr.id(), attr);
			}
		}
		//Check for missing attributes / fill in default values;
		List<Attribute<?>> attrs = type.getDefaultAttributesForType();
		for(Attribute<?> attr : attrs){
			if(!attributes.containsKey(attr.id())) attributes.put(attr.id(), attr.copy(null));
			else{ attributes.get(attr.id()).setMinMax(attr.min(), attr.max()); }
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
		if(obj.has("PreInstalled")){
			preinstalled = new HashMap<>(); JsonObject pre = obj.get("PreInstalled").getAsJsonObject();
			for(java.util.Map.Entry<String, JsonElement> entry : pre.entrySet()){
				preinstalled.put(entry.getKey(), new ResourceLocation(entry.getValue().getAsString()));
			}
		}
		if(obj.has("CollisionGrid")){
			JsonArray grids = obj.get("CollisionGrid").isJsonArray() ? obj.get("CollisionGrid").getAsJsonArray() : new JsonArray();
			if(!obj.get("CollisionGrid").isJsonArray()) grids.add(obj.get("CollisionGrid").getAsJsonObject());
			for(JsonElement elm : grids){
				JsonObject grid = elm.getAsJsonObject();
				Pos from = grid.has("from") ? Pos.fromJson(grid.get("from"), grid.get("from").isJsonArray()) : new Pos(0, 0, 0);
				Pos size = grid.has("size") ? Pos.fromJson(grid.get("size"), grid.get("size").isJsonArray()) : new Pos(1, 1, 1);
				from = new Pos(from.x, -from.y, -from.z);
				defaultgrid.addGrid(from, size, grid.has("unit") ? grid.get("unit").getAsFloat() : 1f, null);
			}
		}
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

	@Override
	public RGB getDefaultPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getDefaultSecondaryColor(){
		return secondary;
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
	
	/** Only use this one for cloning! */
	public CollisionGrid getDefaultGrid(){
		return defaultgrid;
	}

}
