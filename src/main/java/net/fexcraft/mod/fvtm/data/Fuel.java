package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Fuel extends TypeCore<Fuel> {
	
	public String primary, secondary;
	public float quality;
	
	public Fuel(){}

	@Override
	public ResourceLocation getRegistryName(){
		return this.registryname;
	}

	@Override
	public Fuel parse(JsonObject obj){
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		this.registryname = DataUtil.getRegistryName(pack, obj);
		if(registryname == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Material");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.primary = JsonUtil.getIfExists(obj, "PrimaryGroup", "petrol");
		this.secondary = JsonUtil.getIfExists(obj, "SecondaryGroup", "super95");
		this.quality = JsonUtil.getIfExists(obj, "Quality", 0.95f).floatValue();
		//
		return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.FUEL;
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

}
