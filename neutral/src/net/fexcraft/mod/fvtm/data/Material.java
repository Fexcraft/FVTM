package net.fexcraft.mod.fvtm.data;

import static net.fexcraft.mod.fvtm.FvtmRegistry.getFuel;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.IDL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Material extends Content<Material> implements WithItem, ItemTextureable {
	
	protected byte max_stack;
	protected short max_health;
	protected String ore_dict;
	protected String container;
	protected String fuelgroup;
	protected String ctab;
	protected boolean vehicle_key;
	protected boolean fuel_container;
	protected int fuel_capacity;
	protected int burntime;
	protected int impact;
	protected IDL itemtexloc;
	protected Fuel fuel;
	
	public Material(){}

	@Override
	public Material parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Material");
		description = ContentConfigUtil.getStringList(map, "Description");
		max_stack = (byte)map.getInteger("MaxItemStackSize", 64);
		max_health = (short)map.getInteger("MaxItemDamage", 0);
		ore_dict = map.getString("OreDictionary", null);
		container = map.getString("ContainerItem", null);
		burntime = map.getInteger("ItemBurnTime", 0);
		vehicle_key = map.getBoolean("VehicleKey", false);
		fuel_container = map.getBoolean("FuelContainer", false);
		fuel_capacity = map.getInteger("FuelCapacity", fuel_container ? 5000 : 0);
		fuel = map.has("FuelType") ? getFuel(map.getString("FuelType", null)) : null;
		fuelgroup = map.getString("FuelGroup", null);
		impact = map.getInteger("ImpactWrench", -1);
		if(impact > 8) impact = 8;
		if(impact > -1) max_stack = 1;
		//
		ctab = map.getString("CreativeTab", "default");
		itemtexloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.MATERIAL;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	public int getMaxStack(){
		return max_stack;
	}

	public int getMaxHealth(){
		return max_health;
	}
	
	public String getOreDictId(){
		return ore_dict;
	}

	public int getItemBurnTime(){
		return burntime;
	}
	
	public boolean isVehicleKey(){
		return vehicle_key;
	}
	
	public boolean isFuelContainer(){
		return fuel_container;
	}
	
	public int getFuelCapacity(){
		return fuel_capacity;
	}
	
	public Fuel getFuelType(){
		return fuel;
	}
	
	/** May be a primary or primary:secondary string. */
	public String getFuelGroup(){
		return fuelgroup;
	}
	
	public boolean isUniversalFuelContainer(){
		return fuel == null && fuelgroup == null;
	}
	
	public boolean isValidFuel(Fuel fuel){
		if(isUniversalFuelContainer()) return true;
		if(fuelgroup.contains(":")){
			String[] split = fuelgroup.split(":");
			return split[0].equals(fuel.getPrimaryGroup()) && split[1].equals(fuel.getSecondaryGroup());
		}
		else return fuelgroup.equals(fuel.getPrimaryGroup());
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	@Override
	public IDL getItemTexture(){
		return itemtexloc;
	}

	@Override
	public String getItemContainer(){
		return container;
	}

	public int getImpactLevel(){
		return impact;
	}

}
