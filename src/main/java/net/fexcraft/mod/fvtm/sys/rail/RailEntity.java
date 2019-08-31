package net.fexcraft.mod.fvtm.sys.rail;

import java.util.UUID;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

/**
 * First prototype of RailEntity system.
 * 
 * 30/August/2019
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RailEntity {
	
	public Track current;
	public Entity entity;
	public UUID uuid;
	public RailRegion region;
	public boolean active;
	public float throttle;
	public Vec3f pos = new Vec3f();
	public VehicleData vehdata;
	
	public RailEntity(RailData data, VehicleData vdata, Track track){
		current = track; region = data.getRegions().get(track.start, true);
		uuid = UUID.randomUUID(); data.registerEntity(this); vehdata = vdata;
		pos = current.getFirstVector(); region.spawnEntity(this);
	}

	/** only to use with read() afterwards */
	public RailEntity(){}

	public UUID getUUID(){
		return uuid;
	}

	public RailRegion getRegion(){
		return region;
	}
	
	public void onUpdate(){
		//
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("uuid", uuid.toString());
		compound.setTag("track", current.write(null));
		compound.setTag("pos", DataUtil.writeVec3f(pos));
		return vehdata.write(compound);
	}
	
	public RailEntity read(NBTTagCompound compound){
		uuid = UUID.fromString(compound.getString("uuid"));
		current = new Track().read(compound.getCompoundTag("track"));
		pos = DataUtil.readVec3f(compound.getTag("pos"));
		if(vehdata == null) vehdata = Resources.getVehicleData(compound);
		else vehdata.read(compound); return this;
	}

}
