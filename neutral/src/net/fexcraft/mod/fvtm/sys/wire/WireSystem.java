package net.fexcraft.mod.fvtm.sys.wire;

import static net.fexcraft.mod.fvtm.Config.MAX_WIRE_LENGTH;
import static net.fexcraft.mod.fvtm.Config.UNLOAD_INTERVAL;
import static net.fexcraft.mod.uni.world.WrapperHolder.getPos;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.sys.uni.DetachedSystem;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
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
public class WireSystem extends DetachedSystem {

	private long gc_sections;
	//
	private RegionMap regions = new RegionMap(this);
	private WireMap wireunits = new WireMap(this);
	private SectionMap sections = new SectionMap(this);
	
	public WireSystem(WorldW world){
		super(world);
		if(!world.isClient()) load();
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

	public void onRelayInteract(TagCW com, Passenger player){
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
		WireType type = stack.getContent(ContentType.WIRE);
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
		stack.createTagIfMissing();
		if(stack.getTag().has("fvtm:wirepoint")){
			WireRelay relay0 = getRelay(new WireKey(stack.getTag().getV3I("fvtm:wirepoint"), stack.getTag().getString("fvtm:wirepoint_key")));
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
			stack.getTag().rem("fvtm:wirepoint");
			stack.getTag().rem("fvtm:wirepoint_key");
			player.bar("interact.fvtm.relay.wire_created");
		}
		else{
			stack.getTag().set("fvtm:wirepoint", holder.pos, false);
			stack.getTag().set("fvtm:wirepoint_key", relay.key);
			player.bar("interact.fvtm.relay.cached");
		}
	}

	public void onRelayRemove(TagCW com, Passenger player){
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

	public void onRelayWireSlack(TagCW com, Passenger player){
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
	
	public static class RegionMap extends ConcurrentHashMap<RegionKey, WireRegion> {
		
		private WireSystem root;
		public RegionMap(WireSystem data){ this.root = data; }
		
		public WireRegion get(int x, int z){
			for(RegionKey key : keySet()){
				if(x == key.x && z == key.z) return get(key);
			}
			return null;
		}
		
		public WireRegion get(int[] xz){
			for(RegionKey key : keySet()){
				if(xz[0] == key.x && xz[1] == key.z) return get(key);
			}
			return null;
		}
		
		public WireRegion get(V3I pos, boolean load){
			WireRegion region = get(RegionKey.getRegionXZ(pos));
			if(region != null || !load) return region;
			put(new RegionKey(RegionKey.getRegionXZ(pos)), region = new WireRegion(pos, root, false));
			region.load().updateClient(pos);
			return region;
		}

		public WireRegion get(int[] xz, boolean load){
			WireRegion region = get(xz);
			if(region != null || !load) return region;
			put(new RegionKey(xz), region = new WireRegion(xz[0], xz[1], root, false));
			region.load();
			return region;
		}

		public WireRegion get(RegionKey xz, boolean load){
			WireRegion region = get(xz);
			if(region != null || !load) return region;
			put(new RegionKey(xz.x, xz.z), region = new WireRegion(xz.x, xz.z, root, false));
			region.load();
			return region;
		}
		
	}
	
	public RegionMap getRegions(){
		return regions;
	}

	public WireRelay getRelay(WireKey key){
		WireRegion region = regions.get(key.start_pos, false);
		return region == null ? null : region.getRelay(key);
	}

	public WireRelay getRelay(WireKey key, boolean load){
		WireRegion region = regions.get(key.start_pos, load);
		return region.getRelay(key);
	}

	public ArrayList<WireRelay> getRelayssInChunk(int cx, int cz){
		ArrayList<WireRelay> arr = new ArrayList<>();
		WireRegion region = regions.get(RegionKey.getRegionXZ(cx, cz));
		if(region == null) return arr;
		for(Entry<V3I, RelayHolder> entry : region.getHolders().entrySet()){
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
		for(WireRegion region : regions.values()) region.updateTick();
	}

	@Override
	public void unload(){
		if(!world.isClient()){
			regions.values().forEach(reg -> reg.save());
			save();
		}
		regions.clear();
	}

	public void updateRegion(TagCW compound, Passenger player){
		int[] xz = compound.getIntArray("XZ");
		if(world.isClient()){
			WireRegion region = regions.get(xz);
			if(region == null) regions.put(new RegionKey(xz), region = new WireRegion(xz[0], xz[1], this, false));
			region.read(compound);
		}
		else{
			WireRegion region = regions.get(xz, true);
			region.updateClient(player);
		}
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
		WireRegion region = regions.get(RegionKey.getRegionXZ(key.start_pos), true);
		return region == null ? null : region.getWire(key);
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
		WireRegion region = regions.get(RegionKey.getRegionXZ(sender.getPos()));
		if(region != null) region.updateClient(string, null, new V3I(sender.getPos()), null);
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
	
	public static class TimedTask extends TimerTask {

		private WireSystem wiresys;

		public TimedTask(WireSystem wiresys){
			this.wiresys = wiresys;
		}

		@Override
		public void run(){
			ArrayList<WireRegion> regs = new ArrayList<>();
			for(WireRegion region : wiresys.regions.values()){
				if(region.chucks.isEmpty() && region.lastaccess < Time.getDate() - 60000) regs.add(region);
			}
			for(WireRegion region : regs){
				region.save();
				wiresys.regions.remove(region.getKey());
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
		WireRegion region = regions.get(pos, false);
		return region == null ? null : region.getHolder(pos);
	}

	public RelayHolder getHolder(V3I pos, boolean load){
		WireRegion region = regions.get(pos, load);
		return region.getHolder(pos);
	}

	private RelayHolder addHolder(V3I pos){
		WireRegion region = regions.get(pos, true);
		return region.addHolder(pos);
	}

	public void delHolder(V3I pos){
		WireRegion region = regions.get(pos, true);
		if(region != null) region.delHolder(pos);
	}

	@Override
	public void onClientTick(){
		//unused
	}

}
