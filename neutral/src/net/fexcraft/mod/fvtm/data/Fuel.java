package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.inv.StackWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.fexcraft.mod.fvtm.FvtmRegistry.getFuel;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Fuel extends Content<Fuel> {

	public HashMap<String, Float> conversion = new HashMap<>();
	public String primary, secondary;
	public float quality;
	
	public Fuel(){}

	@Override
	public Fuel parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		this.name = map.getString("Name", "Unnamed Material");
		this.description = ContentConfigUtil.getStringList(map, "Description");
		this.primary = map.getString("PrimaryGroup", "petrol");
		this.secondary = map.getString("SecondaryGroup", "super95");
		this.quality = map.getFloat("Quality", 0.95f);
		if(map.has("Conversion")){
			for(Map.Entry<String, JsonValue<?>> entry : map.getMap("Conversion").entries()){
				conversion.put(entry.getKey(), entry.getValue().float_value());
			}
		}
		//
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.FUEL;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}
	
	public String getPrimaryGroup(){
		return primary;
	}
	
	public String getSecondaryGroup(){
		return secondary;
	}

	public boolean isSourceFluid(String fluid_id){
		return conversion.containsKey(fluid_id);
	}

	public float getConversionRate(String flid){
		if(!conversion.containsKey(flid)) return 1f;
		return conversion.get(flid);
	}

	public static boolean isFuelItem(StackWrapper stack){
		Material mat = stack.getContent(ContentType.MATERIAL.item_type);
		return mat != null && mat.isFuelContainer();
	}

	public static Fuel getStoredType(StackWrapper stack){
		Material mat = stack.getContent(ContentType.MATERIAL.item_type);
		if(mat == null || !mat.isFuelContainer()) return null;
		if(mat.getFuelType() != null) return mat.getFuelType();
		if(stack.hasTag()) return getFuel(stack.directTag().getString("StoredFuelType"));
		else return null;
	}

	public static void setStoredType(StackWrapper stack, Fuel fuel){
		stack.updateTag(tag -> {
			tag.set("StoredFuelType", fuel.getIDS());
		});
	}

	public static int getStoredAmount(StackWrapper stack){
		Material mat = stack.getContent(ContentType.MATERIAL.item_type);
		if(mat == null || !mat.isFuelContainer() || !stack.hasTag()) return 0;
		return stack.directTag().getInteger("StoredFuelAmount");
	}

	public static String getStoredName(StackWrapper stack){
		Material mat = stack.getContent(ContentType.MATERIAL.item_type);
		if(mat == null || !mat.isFuelContainer()) return "Nothing.";
		if(mat.getFuelType() != null) return mat.getFuelType().getName();
		if(stack.hasTag()) return FvtmRegistry.getFuelName(stack.directTag().getString("StoredFuelType"));
		else return "none";
	}

	public static void extract(StackWrapper stack, int amount){
		stack.updateTag(tag -> {
			tag.set("StoredFuelAmount", tag.getInteger("StoredFuelAmount") - amount);
			if(tag.getInteger("StoredFuelAmount") < 0) tag.set("StoredFuelAmount", 0);
		});
	}

	public static void insert(StackWrapper stack, int amount){
		Material mat = stack.getContent(ContentType.MATERIAL.item_type);
		stack.updateTag(tag -> {
			tag.set("StoredFuelAmount", tag.getInteger("StoredFuelAmount") + amount);
			if(tag.getInteger("StoredFuelAmount") > mat.getFuelCapacity()) tag.set("StoredFuelAmount", mat.getFuelCapacity());
		});
	}

}
