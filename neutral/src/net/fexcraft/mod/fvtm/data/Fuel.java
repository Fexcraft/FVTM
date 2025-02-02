package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.inv.StackWrapper;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Fuel extends Content<Fuel> {
	
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
		return false;
	}

	public static interface FuelItem {

		public Fuel getStoredFuelType(StackWrapper stack);

		public int getStoredFuelAmount(StackWrapper stack);

		public String getStoredFuelName(StackWrapper stack);

		public void extractFuel(StackWrapper stack, int stored);

		public void insertFuel(StackWrapper stack, int stored);

	}

}
