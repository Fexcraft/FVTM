package net.fexcraft.mod.fvtm.sys.rail;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.uni.tag.TagCW;

import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailRegion extends SystemRegion<RailSystem, Junction> {

	protected ConcurrentHashMap<Long, RailEntity> entities = new ConcurrentHashMap<>();

	public RailRegion(RailSystem root, RegionKey rk){
		super(root, rk);
	}

	public ConcurrentHashMap<Long, RailEntity> getEntities(){
		return entities;
	}

	public void spawnEntity(RailEntity ent){
		try{
			FvtmLogger.debug("Spawning Entity " + ent.uid + "!");
			entities.put(ent.getUID(), ent);
			if(system.isRemote()) return;
			Packets.sendToAllTrackingPos(PKT_TAG, system.getWorld(), ent.pos, "rail_spawn_ent", ent.write(null));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public RailSystem getSystem(){
		return system;
	}

	public Track getTrack(PathKey key){
		Junction junction = get(key.toPos(0));
		return junction == null ? null : junction.getTrack(key);
	}

}
