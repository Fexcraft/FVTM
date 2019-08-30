package net.fexcraft.mod.fvtm.sys.rail;

import java.util.UUID;

import net.minecraft.entity.Entity;

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
	public final UUID uuid;
	public RailRegion region;
	public boolean active;
	public float throttle;
	
	public RailEntity(RailData data, Track track){
		current = track; region = data.getRegions().get(track.start, true);
		uuid = UUID.randomUUID(); data.registerEntity(this);
	}

	public UUID getUUID(){
		return uuid;
	}

	public RailRegion getRegion(){
		return region;
	}
	
	public void onUpdate(){
		//
	}

}
