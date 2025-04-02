package net.fexcraft.mod.fvtm.sys.wire;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.WrapperHolder;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireRegion {
	
	private ConcurrentHashMap<V3I, RelayHolder> holders = new ConcurrentHashMap<>();
	public ConcurrentHashMap<RegionKey, ChunkW> chucks = new ConcurrentHashMap<>();
	public long lastaccess;
	private int timer = 0;
	public boolean loaded;
	protected final WireSystem system;
	protected final RegionKey key;

	public WireRegion(int i, int j, WireSystem root, boolean load){
		key = new RegionKey(i, j);
		system = root;
	}

	public WireRegion(V3I pos, WireSystem root, boolean load){
		key = new RegionKey(RegionKey.getRegionXZ(pos));
		system = root;
	}

	public WireRelay getRelay(WireKey wkey){
		if(!key.isInRegion(wkey.start_pos)) return system.getRelay(wkey);
		RelayHolder holder = getHolder(wkey.start_pos);
		return holder == null ? null : holder.get(wkey.start_relay);
	}

	public void updateTick(){
		if(timer > 20){
			timer = -1;
			for(RelayHolder holder : holders.values()){
				for(WireRelay relay : holder.relays.values()) relay.onUpdate();
			}
		}
		timer++;
	}
	
	public WireRegion setAccessed(){
		lastaccess = Time.getDate();
		return this;
	}

	public RegionKey getKey(){
		return key;
	}
	
	public void updateClient(V3I pos){
		updateClient("all", null, pos, null);
	}
	
	public void updateClient(String kind, String key, V3I pos, Object obj){
		if(system.getWorld().isClient()) return;
		TagCW compound = null;
		String task = null;
		switch(kind){
			case "all":{
				task = "wire_upd_region";
				compound = write(true);
				compound.set("pos", pos, false);
				compound.set("XZ", RegionKey.getRegionXZ(pos));
				break;
			}
			case "relay":{
				task = "wire_upd_relay";
				compound = TagCW.create();
				compound.set("pos", ((WireRelay)obj).holder.pos, false);
				((WireRelay)obj).write(compound);
				break;
			}
			case "no_relay":{
				task = "wire_rem_relay";
				compound = TagCW.create();
				compound.set("pos", pos, false);
				compound.set("key", key);
				break;
			}
			case "holder":{
				RelayHolder holder = getHolder(pos);
				if(holder == null) return;
				compound = holder.write();
				task = "wire_upd_holder";
				break;
			}
			case "no_holder":{
				task = "wire_rem_holder";
				compound = TagCW.create();
				compound.set("pos", pos, false);
				break;
			}
			case "sections":{
				task = "wire_udp_sections";
				compound = TagCW.create();
				TagLW list = TagLW.create();
				for(WireUnit unit : system.getWireUnits().values()){
					TagCW com = TagCW.create();
					com.set("unit", unit.getUID());
					com.set("section", unit.getSectionId());
					list.add(com);
				}
				compound.set("units", list);
				break;
			}
			default:{
				Static.stop();
				break;
			}
		}
		if(compound == null) return;
		Packets.sendInRange(Packet_TagListener.class, system.getWorld(), pos, task, compound);
	}

	public void updateClient(Passenger player){
		if(system.getWorld().isClient() || player == null) return;
		TagCW compound = this.write(true);
		compound.set("XZ", key.toArray());
		Packets.sendTo(Packet_TagListener.class, player, "wire_upd_region", compound);
	}
	
	public WireSystem getSystem(){
		return system;
	}

	public Wire getWire(WireKey key){
		WireRelay relay = getRelay(key);
		return relay == null ? null : relay.getWire(key);
	}

	public RelayHolder getHolder(V3I pos){
		return holders.get(pos);
	}

	public RelayHolder addHolder(V3I pos){
		if(!holders.containsKey(pos)){
			RelayHolder holder = new RelayHolder(this, pos);
			holders.put(pos, holder);
			return holder;
		}
		else return holders.get(pos);
	}

	public void delHolder(V3I pos){
		RelayHolder holder = getHolder(pos);
		if(holder == null) return;
		holder.delete();
		holders.remove(pos);
	}
	
	public ConcurrentHashMap<V3I, RelayHolder> getHolders(){
		return holders;
	}

}
