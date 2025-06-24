package net.fexcraft.mod.fvtm.sys.wire;

import static net.fexcraft.mod.fvtm.Config.MAX_WIRE_LENGTH;
import static net.fexcraft.mod.fvtm.Config.UNLOAD_INTERVAL;
import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.WireDeco;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;

/**
 * "Wire System"
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WireSystem extends DetachedSystem<WireSystem, RelayHolder> {

	private long gc_sections;
	//
	private WireMap wireunits = new WireMap(this);
	private SectionMap sections = new SectionMap(this);
	
	public WireSystem(WorldW world){
		super(world);
		if(!world.isClient()) load();
	}

	@Override
	public SystemManager.Systems getType(){
		return SystemManager.Systems.WIRE;
	}

	public void load(){
		try{
			File file = new File(getSaveRoot(), "/wiresystem.dat");
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			TagCW compound = WrapperHolder.read(file);
			if(compound == null || compound.empty()) return;
			gc_sections = compound.getLong("GlobalCounterSections");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void save(){
		TagCW compound = TagCW.create();
		compound.set("GlobalCounterSections", gc_sections);
		try{
			File file = new File(getSaveRoot(), "/wiresystem.dat");
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			WrapperHolder.write(compound, file);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void onRelayInteract(TagCW com, EntityW player){
		RelayHolder holder = getHolder(com.getV3I("holder"));
		if(holder == null){
			player.send("error.holder.null");
			return;
		}
		if(!holder.hasRef()){
			player.send("error.holder.ref-null");
			return;
		}
		WireRelay relay = holder.get(com.getString("relay"));
		if(relay == null){
			player.send("error.relay.null");
			return;
		}
		StackWrapper stack = player.getHeldItem(true);
		WireType type = stack.getContent(ContentType.WIRE.item_type);
		if(type == null){
			player.send("error.wire-type.null");
			return;
		}
		ArrayList<String> list = holder.ref().types.get(relay.getKey());
		if(!list.isEmpty() && !list.contains(type.getType())){
			player.send("interact.fvtm.relay.wire_not_compatible");
			return;
		}
		int l = holder.ref().limits.get(relay.getKey());
		if(l > 0 && relay.size() > l){
			player.send("interact.fvtm.relay.full");
			return;
		}
		TagCW tag = stack.copyTag();
		if(tag.has("fvtm:wirepoint")){
			WireRelay relay0 = getRelay(new WireKey(tag.getV3I("fvtm:wirepoint"), tag.getString("fvtm:wirepoint_key")));
			if(relay0.pos.dis(relay.pos) > MAX_WIRE_LENGTH){
				player.send("interact.fvtm.relay.wire_too_long");
				return;
			}
			Wire wire = new Wire(relay0, relay, type, relay0.pos, relay.pos);
			if(relay0.isDuplicate(wire) || relay.isDuplicate(wire)){
				player.send("interact.fvtm.relay.wire_duplicate");
				return;
			}
			relay0.addnew(wire);
			relay.addnew(wire.createOppositeCopy());
			relay0.checkWireSectionConsistency();
			tag.rem("fvtm:wirepoint");
			tag.rem("fvtm:wirepoint_key");
			stack.updateTag(tag);
			player.bar("interact.fvtm.relay.wire_created");
		}
		else{
			tag.set("fvtm:wirepoint", holder.pos, false);
			tag.set("fvtm:wirepoint_key", relay.key);
			stack.updateTag(tag);
			player.bar("interact.fvtm.relay.cached");
		}
	}

	public void onRelayRemove(TagCW com, EntityW player){
		RelayHolder holder = getHolder(com.getV3I("holder"));
		if(holder == null){
			player.send("error.holder.null");
			return;
		}
		WireRelay relay = holder.get(com.getString("relay"));
		if(relay == null){
			player.send("error.relay.null");
			return;
		}
		if(player.isShiftDown()){
			while(relay.size() > 0) relay.remove(0, true);
		}
		else relay.remove(relay.size() - 1, true);
	}

	public void onRelayWireSlack(TagCW com, EntityW player){
		Wire wire0 = getWire(new WireKey(com));
		Wire wire1 = getWire(wire0.okey);
		wire0.slack += com.getBoolean("up") ? -Config.WIRE_SLACK_ADJUSTMENT : Config.WIRE_SLACK_ADJUSTMENT;
		if(wire0.slack > 8) wire0.slack = 8;
		if(wire0.slack < -8) wire0.slack = -8;
		wire1.slack = wire0.slack;
		wire0.reslack();
		wire1.reslack();
		wire0.getRelay().updateClient();
		wire1.getRelay().updateClient();
		player.bar("interact.fvtm.relay.wire_slack", wire0.slack);
	}

	public void onRelayWireDeco(TagCW com, EntityW player){
		WireDeco deco = player.getHeldItem(true).getContent(ContentType.WIREDECO.item_type);
		if(deco == null){
			player.bar("deco null on server");
			return;
		}
		Wire wire = getWire(new WireKey(com));
		if(!deco.accepts(wire.type.getType())){
			player.bar("interact.fvtm.relay.wire_deco_not_compatible");
			return;
		}
		String type = com.has("as") ? com.getString("as") : deco.getType();
		if(wire.decos == null) wire.decos = new LinkedHashMap<>();
		wire.decos.put(type, deco);
		//
		wire.getRelay().updateClient();
		player.bar("interact.fvtm.relay.wire_deco_added", deco.getType());
	}

	public static class WireMap extends TreeMap<String, WireUnit> {
		
		private WireSystem data;
		
		public WireMap(WireSystem wiredata){
			super();
			data = wiredata;
		}
		
		public WireUnit get(String str, Long knownid, boolean create){
			if(!create) return super.get(str);
			WireUnit trk = super.get(str);
			if(trk == null) this.put(str, trk = new WireUnit(data, str, knownid));
			return trk;
		}
		
	}
	
	public static class SectionMap extends TreeMap<Long, WireSection> {
		
		private WireSystem data;
		
		public SectionMap(WireSystem wiredata){
			super();
			data = wiredata;
		}
		
		public WireSection get(Long sid, boolean create){
			if(create && sid == null){
				WireSection sec = new WireSection(data, null);
				this.put(sec.getUID(), sec);
				return sec;
			}
			if(sid == null) return null;
			if(!create) return super.get(sid);
			WireSection sec = super.get(sid);
			if(sec == null) this.put(sid, sec = new WireSection(data, sid));
			return sec;
		}
		
	}

	@Override
	public RelayHolder create(SystemRegion<WireSystem, RelayHolder> region, V3I pos){
		return new RelayHolder(region, pos);
	}

	@Override
	public void writeRegion(SystemRegion<WireSystem, RelayHolder> region, TagCW com){
		if(region.getObjects().isEmpty()) return;
		TagLW list = TagLW.create();
		for(RelayHolder holder : region.getObjects().values()){
			list.add(holder.write());
		}
		com.set("RelayHolders", list);
	}

	@Override
	public void readRegion(SystemRegion<WireSystem, RelayHolder> region, TagCW com){
		if(!com.has("RelayHolders")) return;
		region.getObjects().clear();
		TagLW list = com.getList("RelayHolders");
		for(TagCW tag : list){
			RelayHolder holder = new RelayHolder(region);
			holder.read(tag);
			region.getObjects().put(holder.pos, holder);
		}
	}

	public void updateClient(String kind, String key, V3I pos, WireRelay relay){
		if(world.isClient()) return;
		TagCW compound = null;
		String task = null;
		switch(kind){
			case "relay":{
				task = "wire_upd_relay";
				compound = TagCW.create();
				compound.set("pos", relay.holder.pos, false);
				relay.write(compound);
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
				for(WireUnit unit : getWireUnits().values()){
					TagCW com = TagCW.create();
					com.set("unit", unit.getUID());
					com.set("section", unit.getSectionId());
					list.add(com);
				}
				compound.set("units", list);
				break;
			}
			default:{
				FvtmLogger.log("Invalid WIRE update: " + kind);
				break;
			}
		}
		if(compound == null) return;
		Packets.sendToAllTrackingPos(PKT_TAG, world, pos, task, compound);
	}

	public WireRelay getRelay(WireKey key){
		SystemRegion<?, RelayHolder> region = regions.get(key.start_pos, false);
		if(region == null) return null;
		RelayHolder holder = region.get(key.start_pos);
		return holder == null ? null : holder.get(key.start_relay);
	}

	public WireRelay getRelay(WireKey key, boolean load){
		SystemRegion<?, RelayHolder> region = regions.get(key.start_pos, load);
		RelayHolder holder = region.get(key.start_pos);
		return holder == null ? null : holder.get(key.start_relay);
	}

	public ArrayList<WireRelay> getRelaysInChunk(int cx, int cz){
		ArrayList<WireRelay> arr = new ArrayList<>();
		SystemRegion<?, RelayHolder> region = regions.get(RegionKey.getRegionXZ(cx, cz));
		if(region == null) return arr;
		for(Entry<V3I, RelayHolder> entry : region.getObjects().entrySet()){
			if(entry.getKey().x >> 4 == cx && entry.getKey().z >> 4 == cz){
				arr.addAll(entry.getValue().relays.values());
			}
		}
		return arr;
	}

	public boolean delRelay(WireKey key){
		RelayHolder holder = getHolder(key.start_pos);
		return holder.remove(key.start_relay) != null;
	}

	@Override
	public void onServerTick(){
		for(SystemRegion<?, RelayHolder> region : regions.values()){
			if(region.timer > 20){
				region.timer = -1;
				for(RelayHolder holder : region.getObjects().values()){
					for(WireRelay relay : holder.relays.values()) relay.onUpdate();
				}
			}
			region.timer++;
		}
	}

	@Override
	public void unload(){
		if(!world.isClient()){
			regions.values().forEach(reg -> reg.save());
			save();
		}
		regions.clear();
	}

	@Override
	public void onChunkLoad(ChunkW chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x(), chunk.z()), true).chucks.put(new RegionKey(chunk.x(), chunk.z()), chunk);
	}

	@Override
	public void onChunkUnload(ChunkW chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x(), chunk.z()), true).chucks.values().removeIf(pre -> pre.x() == chunk.x() && pre.z() == chunk.z());
	}

	public long getNewSectionId(){
		return gc_sections++;
	}

	public Wire getWire(WireKey key){
		SystemRegion<?, RelayHolder> region = regions.get(RegionKey.getRegionXZ(key.start_pos), true);
		RelayHolder holder = region.get(key.start_pos);
		if(holder == null) return null;
		WireRelay relay = holder.get(key.start_relay);
		return relay == null ? null : relay.getWire(key);
	}
	
	public WireMap getWireUnits(){
		return wireunits;
	}
	
	public SectionMap getSections(){
		return sections;
	}

	public WireSection getSection(Long sid){
		return sections.get(sid, true);
	}

	public void sendReload(String string, EntityW sender){
		SystemRegion<?, RelayHolder> region = regions.get(RegionKey.getRegionXZ(sender.getPos()));
		if(region != null) region.sendSync(sender);
	}

	public boolean isRemote(){
		return world.isClient();
	}
	
	//

	@Override
	public boolean hasTimer(){
		return true;
	}

	@Override
	public void addTimerTask(long time){
		timer.schedule(new TimedTask(this), new Date(time), UNLOAD_INTERVAL);
	}

	@Override
	public String getRegFolderName(){
		return "wireregions";
	}

	public static class TimedTask extends TimerTask {

		private WireSystem wiresys;

		public TimedTask(WireSystem wiresys){
			this.wiresys = wiresys;
		}

		@Override
		public void run(){
			ArrayList<SystemRegion<?, RelayHolder>> regs = new ArrayList<>();
			for(SystemRegion<?, RelayHolder> region : wiresys.regions.values()){
				if(region.chucks.isEmpty() && region.lastaccess < Time.getDate() - 60000) regs.add(region);
			}
			for(SystemRegion<?, RelayHolder> region : regs){
				region.save();
				wiresys.regions.remove(region.key);
			}
		}

	}

	/** Adding when missing. */
	public void register(FvtmBlockEntity tile){
		RelayHolder holder = getHolder(tile.getV3I());
		if(holder == null) holder = addHolder(tile.getV3I());
		holder.integrate(tile);
		holder.setTile(tile);
	}

	/** Unlinking TE */
	public void unregister(FvtmBlockEntity tile){
		RelayHolder holder = getHolder(tile.getV3I());
		if(holder != null) holder.setTile(null);
	}
	
	/** Removing when present. */
	public void deregister(Object tileentity){
		if(tileentity instanceof FvtmBlockEntity == false) return;
		FvtmBlockEntity tile = (FvtmBlockEntity)tileentity;
		delHolder(tile.getV3I());
	}

	public RelayHolder getHolder(V3I pos){
		SystemRegion<?, RelayHolder> region = regions.get(pos, false);
		return region == null ? null : region.get(pos);
	}

	public RelayHolder getHolder(V3I pos, boolean load){
		SystemRegion<?, RelayHolder> region = regions.get(pos, load);
		return region.get(pos);
	}

	private RelayHolder addHolder(V3I pos){
		SystemRegion<?, RelayHolder> region = regions.get(pos, true);
		return region.add(pos);
	}

	public void delHolder(V3I pos){
		SystemRegion<?, RelayHolder> region = regions.get(pos, true);
		if(region != null){
			if(region.del(pos) && !world.isClient()){
				updateClient("no_holder", null, pos, null);
			}
		}
	}

	@Override
	public void onClientTick(){
		//unused
	}

}
