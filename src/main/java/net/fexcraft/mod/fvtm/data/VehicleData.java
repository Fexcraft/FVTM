package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class VehicleData extends DataCore<Vehicle, VehicleData> {

	public VehicleData(Vehicle type){
		super(type);
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Vehicle", type.getRegistryName().toString());
		//
		return compound;
	}

	@Override
	public VehicleData read(NBTTagCompound compound){
		if(!compound.hasKey("Vehicle")) return null;
		type = Resources.getVehicle(compound.getString("Vehicle"));
		if(type == null) return null;//TODO add "placeholder" for "missing" items
		//
		return this;
	}

	@Override
	public VehicleData parse(JsonObject obj){
		ResourceLocation regname = DataUtil.getRegistryName("Vehicle", obj);
		if(regname == null || Resources.getPart(regname) == null) return null;
		this.type = Resources.getVehicle(regname);
		//
		return this;
	}

	@Override
	public JsonObject toJson(){
		JsonObject obj = new JsonObject();
		obj.addProperty("Vehicle", type.getRegistryName().toString());
		//
		return obj;
	}

}
