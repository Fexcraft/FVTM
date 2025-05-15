package net.fexcraft.mod.fvtm.sys.rail;

import static net.fexcraft.mod.fvtm.Config.UNLOAD_INTERVAL;
import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;
import static net.fexcraft.mod.fvtm.sys.uni.SystemManager.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.rail.Compound.Singular;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.*;

/**
 * "Rail System Data"
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RailSystem extends DetachedSystem<RailSystem, Junction> {

	private long gc_entities, gc_sections, gc_compounds;
	public final ConcurrentHashMap<Long, TagCW> fillqueue = new ConcurrentHashMap<>();
	//
	private TrackMap trackunits = new TrackMap(this);
	private SectionMap sections = new SectionMap(this);
	private TreeMap<Long, RegionKey> entities = new TreeMap<>();
	
	public RailSystem(WorldW world){
		super(world);
		if(!world.isClient()) load();
	}

	@Override
	public RailRegion newRegion(RegionKey key){
		return new RailRegion(this, key);
	}

	@Override
	public SystemManager.Systems getType(){
		return SystemManager.Systems.RAIL;
	}

	public void load(){
		File file = new File(getSaveRoot(), "/railsystem.dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		TagCW compound = WrapperHolder.read(file);
		if(compound == null || compound.empty()) return;
		gc_entities = compound.getLong("GlobalCounterEntities");
		gc_sections = compound.getLong("GlobalCounterSections");
		gc_compounds = compound.getLong("GlobalCounterCompounds");
		if(compound.has("Entities")){
			TagCW enty = compound.getCompound("Entities");
			for(String str : enty.keys()){
				try{
					entities.put(Long.parseLong(str, 16), new RegionKey(enty.getLong(str)));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	public void save(){
		TagCW compound = TagCW.create();
		compound.set("GlobalCounterEntities", gc_entities);
		compound.set("GlobalCounterSections", gc_sections);
		compound.set("GlobalCounterCompounds", gc_compounds);
		if(!entities.isEmpty()){
			TagCW enty = TagCW.create();
			entities.forEach((key, value) -> { enty.set(Long.toHexString(key), value.toLong()); });
			compound.set("Entities", enty);
		}
		File file = new File(getSaveRoot(), "/railsystem.dat");
		if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
		WrapperHolder.write(compound, file);
	}
	
	public static class TrackMap extends TreeMap<String, TrackUnit> {
		
		private RailSystem data;
		
		public TrackMap(RailSystem raildata){
			super();
			data = raildata;
		}
		
		public TrackUnit get(String str, Long knownid, boolean create){
			if(!create) return super.get(str);
			TrackUnit trk = super.get(str);
			if(trk == null) this.put(str, trk = new TrackUnit(data, str, knownid));
			return trk;
		}
		
	}
	
	public static class SectionMap extends TreeMap<Long, Section> {
		
		private RailSystem data;
		
		public SectionMap(RailSystem raildata){
			super();
			data = raildata;
		}
		
		public Section get(Long sid, boolean create){
			if(create && sid == null){
				Section sec = new Section(data, null);
				this.put(sec.getUID(), sec);
				return sec;
			}
			if(sid == null) return null;
			if(!create) return super.get(sid);
			Section sec = super.get(sid);
			if(sec == null) this.put(sid, sec = new Section(data, sid));
			return sec;
		}
		
	}

	@Override
	public Junction create(SystemRegion<RailSystem, Junction> region, V3I pos){
		return new Junction(region);
	}

	@Override
	public void writeRegion(SystemRegion<RailSystem, Junction> region, TagCW compound, boolean sync){
		if(!region.getObjects().isEmpty()){
			TagLW list = TagLW.create();
			for(Junction junc : region.getObjects().values()){
				list.add(junc.write());
			}
			compound.set("Junctions", list);
		}
		if(sync) return;
		RailRegion reg = (RailRegion)region;
		if(!reg.entities.isEmpty()){
			TagLW list = TagLW.create();
			for(RailEntity entity : reg.entities.values()){
				if(entity.com.isSingular()){
					list.add(entity.write(null));
				}
				else if(entity.com.isMultiple() && entity.com.isHead(entity)){
					TagCW com = TagCW.create();
					com.set("Compound", entity.com.uid);
					com.set("Forward", entity.com.forward);
					com.set("Singular", false);
					TagLW ents = TagLW.create();
					for(RailEntity ent : entity.com.entities){
						ents.add(ent.write(null));
					}
					com.set("Entities", ents);
					list.add(com);
				}
			}
			compound.set("Entities", list);
		}
	}

	@Override
	public void readRegion(SystemRegion<RailSystem, Junction> region, TagCW com){
		RailRegion reg = (RailRegion)region;
		if(com.has("Junctions")){
			region.getObjects().clear();
			TagLW list = com.getList("Junctions");
			list.forEach(tag -> {
				Junction junc = new Junction(region);
				junc.read(tag);
				region.getObjects().put(junc.getV3I(), junc);
			});
		}
		if(com.has("Entities")){
			reg.entities.clear();
			com.getList("Entities").forEach(tag -> {
				fillqueue.put(tag.getLong("Compound"), tag);
			});
		}
	}

	public Junction getJunction(V3I vec){
		RailRegion region = regions.getC(vec, false);
		return region == null ? null : region.get(vec);
	}

	public Junction getJunction(V3I vec, boolean load){
		RailRegion region = regions.getC(vec, load);
		return region.get(vec);
	}

	public ArrayList<Junction> getJunctionsInChunk(int cx, int cz){
		ArrayList<Junction> arr = new ArrayList<>();
		SystemRegion<?, Junction> region = regions.get(RegionKey.getRegionXZ(cx, cz), false);
		if(region == null) return arr;
		for(Entry<V3I, Junction> entry : region.getObjects().entrySet()){
			if(entry.getKey().x >> 4 == cx && entry.getKey().z >> 4 == cz){
				arr.add(entry.getValue());
			}
		}
		return arr;
	}

	public ArrayList<Junction> getJunctionsAt(int x, int y, int z){
		return getJunctionsAt(WrapperHolder.mutPos(x, y, z));
	}

	public ArrayList<Junction> getJunctionsAt(V3I pos){
		ArrayList<Junction> arr = new ArrayList<>();
		SystemRegion<?, Junction> region = regions.get(RegionKey.getRegionXZ(pos));
		if(region == null) return arr;
		for(Entry<V3I, Junction> entry : region.getObjects().entrySet()){
			if(entry.getKey().equals(pos)){
				arr.add(entry.getValue());
			}
		}
		return arr;
	}

	public boolean delJunction(V3I vector){
		SystemRegion<?, Junction> region = regions.get(vector, false);
		if(region == null || region.get(vector) == null) return false;
		Junction junc = region.getObjects().remove(vector);
		if(world.isClient()){
			return junc != null;
		}
		else{
			if(junc != null){
				if(!junc.tracks.isEmpty()) return false;
				junc.unlinkLinkedTileEntities();
				//MinecraftForge.EVENT_BUS.post(new RailEvents.JunctionEvent.JunctionRemoved(this, junc));
			}
			region.setAccessed();
			updateClient("no_junction", vector);
			return true;
		}
	}

	/** Used when a junction is being deleted. */
	/*protected boolean delTrack(Track track, boolean isOpposite, boolean remjunk){
		if(track == null) return false; Junction junction;
		junction = getJunction(isOpposite ? track.end : track.start);
		if(junction != null){
			junction.remove(track.getId(isOpposite), false, remjunk);
			junction.checkTrackSectionConsistency();
		} return true;
	}*/

	public void addJunction(QV3D vector){
		SystemRegion<RailSystem, Junction> region = regions.get(vector.pos, true);
		if(region == null) /** this rather an error */ return;
		Junction junction = new Junction(region, vector);
		region.getObjects().put(vector.pos, junction);
		region.setAccessed();
		updateClient("junction", vector.pos);
		return;
	}

	public void updateJuncton(V3I vector){
		SystemRegion<?, Junction> region = regions.get(vector, true);
		if(region == null) /** This is rather bad. */
			return;
		region.setAccessed();
		updateClient("junction", vector);
		return;
	}

	@Override
	public void onServerTick(){
		if(world.isClient()) return;
		if(SINGLEPLAYER && !CLIENTLOADED){
			String key = world.dimkey();
			key = key.substring(0, key.length() - 1) + "c";
			CLIENTLOADED = SystemManager.get(Systems.RAIL, key) != null;
			if(!CLIENTLOADED) return;
		}
		if(!fillqueue.isEmpty() && (!SINGLEPLAYER || CLIENTLOADED)){
			FvtmLogger.debug("Processing RailEntities in Queue " + fillqueue.size());
			ArrayList<Long> torem = new ArrayList<>();
			RailRegion region;
			for(Long uid : fillqueue.keySet()){
				TagCW com = fillqueue.get(uid);
				boolean single = com.getBoolean("Singular");
				if(single){
					region = getRegions().getC(com.getIntArray("region"), true);
					if(region == null || !region.loaded) continue;
					if(FvtmRegistry.VEHICLES.get(com.getString("Vehicle")) == null){
						FvtmLogger.log("SINGULAR Rail Vehicle Type with id '" + com.getString("Vehicle") + "' not found, removing.");
						FvtmLogger.log("NBT:" + com);
						torem.add(uid);
						continue;
					}
					Singular singular = new Singular(region, com.getLong("Compound"), com);
					if(singular.getEntitites().isEmpty()) continue;
					singular.forward = com.getBoolean("forward");
					region.spawnEntity(singular.getEntitites().get(0).start());
					torem.add(uid);
				}
				else{
					boolean allregionsloaded = true;
					for(TagCW tag : com.getList("Entities")){
						if(tag == null || !tag.has("region")) continue;
						region = getRegions().getC(tag.getIntArray("region"), true);
						if(region == null || !region.loaded){
							allregionsloaded = false;
							break;
						}
					}
					if(allregionsloaded){
						Compound.Multiple multiple = new Compound.Multiple(this, null, uid, com.getList("Entities"));
						if(multiple.getEntitites().size() == 0) continue;
						multiple.forward = com.getBoolean("Forward");
						for(RailEntity ent : multiple.entities) ent.region.spawnEntity(ent.start());
						torem.add(uid);
					}
				}
			}
			torem.forEach(fillqueue::remove);
			torem.clear();
		}
		for(SystemRegion<RailSystem, Junction> region : regions.values()){
			RailRegion reg = (RailRegion)region;
			if(!reg.entities.isEmpty()) reg.setAccessed();
			for(RailEntity ent : reg.entities.values()) ent.onUpdate();
			if(reg.timer > 20){
				reg.timer = -1;
				for(Junction junction : reg.getObjects().values()) junction.onUpdate();
			}
			reg.timer++;
		}
	}

	@Override
	public void onClientTick(){
		if(!world.isClient() || fillqueue.isEmpty()) return;
		FvtmLogger.debug("Processing RailEntities in Queue " + fillqueue.size());
		ArrayList<Long> torem = new ArrayList<>();
		for(Long uid : fillqueue.keySet()){
			TagCW compound = fillqueue.get(uid);
			FvtmLogger.debug("Checking " + uid);
			if(!compound.has("region")){
				FvtmLogger.log("Invalid spawn data for RailEntity " + uid);
				FvtmLogger.log(compound);
				torem.add(uid);
				continue;
			}
			RailRegion region = getRegions().getC(compound.getIntArray("region"), false);
			if(region == null || !region.loaded) continue;
			FvtmLogger.debug("Processing " + uid + " - " + region.key.x + "/" + region.key.z);
			region.spawnEntity(new RailEntity(region, compound.getLong("uid")).read(compound));
			torem.add(uid);
		}
		torem.forEach(fillqueue::remove);
		torem.clear();
	}

	@Override
	public void unload(){
		if(!world.isClient()){
			regions.values().forEach(reg -> reg.save());
			save();
		}
		regions.clear();
	}

	public void updateClient(String kind, V3I vector){
		if(world.isClient()) return;
		TagCW compound = null;
		String task = null;
		switch(kind){
			case "junction":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				task = "rail_upd_junc";
				compound = junction.write();
				compound.set("pos", vector);
				break;
			}
			case "no_junction":{
				compound = TagCW.create();
				task = "rail_rem_junc";
				compound.set("pos", vector);
				break;
			}
			case "junction_state":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				task = "rail_upd_junc_state";
				compound = TagCW.create();
				compound.set("pos", vector);
				compound.set("switch0", junction.switch0);
				compound.set("switch1", junction.switch1);
				break;
			}
			case "junction_signal":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				task = "rail_upd_junc_signal";
				compound = TagCW.create();
				compound.set("pos", vector);
				if(junction.signal == null){
					compound.set("nosignal", true);
				}
				else{
					compound.set("signal", junction.signal.ordinal());
					compound.set("signal_dir", junction.signal_dir.ordinal());
				}
				break;
			}
			case "junction_signal_state":{
				Junction junction = getJunction(vector);
				if(junction == null) return;
				task = "rail_upd_junc_signal_state";
				compound = TagCW.create();
				compound.set("pos", vector);
				compound.set("signal0", junction.signal0);
				compound.set("signal1", junction.signal1);
				break;
			}
			case "sections":{
				task = "rail_upd_sections";
				compound = TagCW.create();
				TagLW list = TagLW.create();
				for(TrackUnit unit : trackunits.values()){
					TagCW com = TagCW.create();
					com.set("unit", unit.getUID());
					com.set("section", unit.getSectionId());
					list.add(com);
				}
				compound.set("units", list);
				break;
			}
		}
		if(compound == null) return;
		Packets.sendToAllTrackingPos(PKT_TAG, world, vector, task, compound);
	}

	public void updateClient(String kind, RailEntity entity){
		if(world.isClient()) return;
		TagCW compound = null;
		String task = null;
		switch(kind){
			case "removed":{
				task = "rail_rem_ent";
				compound = TagCW.create();
				compound.set("uid", entity.uid);
			}
		}
		if(compound == null) return;
		Packets.sendToAll(PKT_TAG, task, compound);
	}

	@Override
	public void onChunkLoad(ChunkW chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x(), chunk.z()), true).chucks.put(new RegionKey(chunk.x(), chunk.z()), chunk);
	}

	@Override
	public void onChunkUnload(ChunkW chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x(), chunk.z()), true).chucks.values().removeIf(pre -> pre.x() == chunk.x() && pre.z() == chunk.z());
	}

	public void registerEntity(RailEntity entity){
		entities.put(entity.getUID(), entity.getRegion().key);
	}

	public RailEntity getEntity(long uid, boolean load){
		RailRegion reg;
		for(RegionKey key : regions.keySet()){
			reg = regions.getC(key, false);
			if(reg.getEntities().containsKey(uid)){
				return reg.getEntities().get(uid);
			}
		}
		if(load && entities.containsKey(uid)){
			RailRegion region = regions.getC(entities.get(uid), true);
			if(region != null) return region.getEntities().get(uid);
		}
		return null;
	}

	//@Deprecated
	public void updateEntityEntry(long uid, int x, int z){
		entities.put(uid, new RegionKey(x, z));
	}

	//@Deprecated
	public void updateEntityEntry(long uid, RegionKey key){
		entities.put(uid, key);
	}

	public long getNewEntityId(){
		return gc_entities++;
	}

	public long getNewSectionId(){
		return gc_sections++;
	}

	public long getNewCompoundId(){
		return gc_compounds++;
	}

	public void delEntity(RailEntity entity){
		entity.region.getEntities().remove(entity.getUID());
		entities.remove(entity.getUID());
		updateClient("removed", entity);
	}

	public Track getTrack(PathKey key){
		RailRegion region = regions.getC(RegionKey.getRegionXZ(key), true);
		return region == null ? null : region.getTrack(key);
	}
	
	public TrackMap getTrackUnits(){
		return trackunits;
	}
	
	public SectionMap getSections(){
		return sections;
	}

	public Section getSection(Long sid){
		return sections.get(sid, true);
	}

	public void sendReload(String string, EntityW sender){
		SystemRegion region = regions.get(RegionKey.getRegionXZ(sender.getPos()));
		if(region != null){
			updateClient(string, sender.getV3I());
		}
	}

	public boolean isRemote(){
		return world.isClient();
	}

	public TreeMap<Long, RegionKey> getEntityIndex(){
		return entities;
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
		return "railregions";
	}

	public static class TimedTask extends TimerTask {

		private RailSystem railsys;

		public TimedTask(RailSystem railsys){
			this.railsys = railsys;
		}

		@Override
		public void run(){
			ArrayList<SystemRegion> regs = new ArrayList<>();
			for(SystemRegion region : railsys.regions.values()){
				if(region.chucks.isEmpty() && region.lastaccess < Time.getDate() - 60000) regs.add(region);
			}
			for(SystemRegion region : regs){
				region.save(); railsys.regions.remove(region.key);
			}
		}

	}

}
