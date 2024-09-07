package net.fexcraft.mod.fvtm.sys.rail;

import static net.fexcraft.mod.fvtm.Config.UNLOAD_INTERVAL;
import static net.fexcraft.mod.fvtm.sys.uni.SystemManager.PLAYERON;
import static net.fexcraft.mod.fvtm.sys.uni.SystemManager.SINGLEPLAYER;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.sys.rail.Compound.Singular;
import net.fexcraft.mod.fvtm.sys.uni.DetachedSystem;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

/**
 * "Rail System Data"
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RailSystem extends DetachedSystem {

	private long gc_entities, gc_sections, gc_compounds;
	//
	private RegionMap regions = new RegionMap(this);
	private TrackMap trackunits = new TrackMap(this);
	private SectionMap sections = new SectionMap(this);
	private TreeMap<Long, RegionKey> entities = new TreeMap<>();
	
	public RailSystem(World world){
		super(world);
		if(!world.isRemote) load();
	}

	public void load(){
		try{
			File file = new File(getSaveRoot(), "/railsystem.dat");
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			TagCW compound = TagCW.wrap(CompressedStreamTools.read(file));
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
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void save(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("GlobalCounterEntities", gc_entities);
		compound.setLong("GlobalCounterSections", gc_sections);
		compound.setLong("GlobalCounterCompounds", gc_compounds);
		if(!entities.isEmpty()){
			NBTTagCompound enty = new NBTTagCompound();
			entities.forEach((key, value) -> { enty.setLong(Long.toHexString(key), value.toLong()); });
			compound.setTag("Entities", enty);
		}
		try{
			File file = new File(getSaveRoot(), "/railsystem.dat");
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			CompressedStreamTools.write(compound, file);
		}
		catch(IOException e){
			e.printStackTrace();
		}
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
	
	public static class RegionMap extends ConcurrentHashMap<RegionKey, Region> {
		
		private RailSystem root;
		public RegionMap(RailSystem data){ this.root = data; }
		
		public Region get(int x, int z){
			for(RegionKey key : keySet()){
				if(x == key.x && z == key.z) return get(key);
			}
			return null;
		}
		
		public Region get(int[] xz){
			for(RegionKey key : keySet()){
				if(xz[0] == key.x && xz[1] == key.z) return get(key);
			}
			return null;
		}
		
		public Region get(QV3D vec, boolean load){
			Region region = get(RegionKey.getRegionXZ(vec));
			if(region != null || !load) return region;
			put(new RegionKey(vec), region = new Region(vec, root, false));
			region.load().updateClient(vec);
			return region;
		}

		public Region get(int[] xz, boolean load){
			Region region = get(xz);
			if(region != null || !load) return region;
			put(new RegionKey(xz), region = new Region(xz[0], xz[1], root, false));
			region.load();
			return region;
		}

		public Region get(RegionKey xz, boolean load){
			Region region = get(xz);
			if(region != null || !load) return region;
			put(new RegionKey(xz.x, xz.z), region = new Region(xz.x, xz.z, root, false));
			region.load();
			return region;
		}
		
	}
	
	public RegionMap getRegions(){
		return regions;
	}

	public Junction getJunction(QV3D vec){
		Region region = regions.get(vec, false); return region == null ? null : region.getJunction(vec);
	}

	public Junction getJunction(QV3D vec, boolean load){
		Region region = regions.get(vec, load); return region.getJunction(vec);
	}

	public ArrayList<Junction> getJunctionsInChunk(int cx, int cz){
		ArrayList<Junction> arr = new ArrayList<>();
		Region region = regions.get(RegionKey.getRegionXZ(cx, cz));
		if(region == null) return arr;
		for(Entry<QV3D, Junction> entry : region.getJunctions().entrySet()){
			if(entry.getKey().pos.x >> 4 == cx && entry.getKey().pos.z >> 4 == cz){
				arr.add(entry.getValue());
			}
		}
		return arr;
	}

	public ArrayList<Junction> getJunctionsAt(BlockPos pos){
		ArrayList<Junction> arr = new ArrayList<>();
		Region region = regions.get(RegionKey.getRegionXZ(pos));
		if(region == null) return arr;
		for(Entry<QV3D, Junction> entry : region.getJunctions().entrySet()){
			if(entry.getKey().pos.equals(pos)){
				arr.add(entry.getValue());
			}
		}
		return arr;
	}

	public boolean delJunction(QV3D vector){
		Region region = regions.get(vector, false);
		if(region == null || region.getJunction(vector) == null) return false;
		Junction junc = region.getJunctions().remove(vector);
		if(world.isRemote){
			return junc != null;
		}
		else{
			if(junc != null){
				if(!junc.tracks.isEmpty()) return false;
				junc.unlinkLinkedTileEntities();
				//MinecraftForge.EVENT_BUS.post(new RailEvents.JunctionEvent.JunctionRemoved(this, junc));
			}
			region.setAccessed().updateClient("no_junction", vector);
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
		Region region = regions.get(vector, true);
		if(region == null) /** this rather an error */ return;
		Junction junction = new Junction(region, vector);
		region.getJunctions().put(vector, junction);
		region.setAccessed().updateClient("junction", vector);
		//MinecraftForge.EVENT_BUS.post(new RailEvents.JunctionEvent.JunctionAdded(this, junction));
		return;
	}

	public void updateJuncton(QV3D vector){
		Region region = regions.get(vector, true);
		if(region == null) /** This is rather bad. */
			return;
		region.setAccessed().updateClient("junction", vector);
		return;
	}

	@Override
	public void onServerTick(World world){
		/*if(remote && !Region.clientqueue.isEmpty()){
			Print.debug("Processing <NBT> Entities in Queue " + Region.clientqueue.size());
			ArrayList<Long> torem = new ArrayList<>();
			for(Long uid : Region.clientqueue.keySet()){
				NBTTagCompound compound = Region.clientqueue.get(uid);
				Print.debug("Checking " + compound.getLong("uid"));
				Region region = getRegions().get(compound.getIntArray("XZ"));
				if(region == null || !region.loaded) continue;
				Print.debug("Processing " + compound.getLong("uid") + " - " + region.getKey().x + "/" + region.getKey().z);
				region.spawnEntity(new RailEntity(region, compound.getLong("uid")).read(compound));
				torem.add(uid);
			} torem.forEach(rem -> Region.clientqueue.remove(rem)); torem.clear();
		}*/
		if(!Region.fillqueue.isEmpty() && (SINGLEPLAYER ? PLAYERON : true)){
			Print.debug("Processing Entities in Queue " + Region.fillqueue.size());
			ArrayList<Long> torem = new ArrayList<>(); Region region;
			for(Long uid : Region.fillqueue.keySet()){
				TagCW com = Region.fillqueue.get(uid);
				boolean single = com.has("Singular") ? com.getBoolean("Singular") : true;
				if(single){
					region = getRegions().get(com.getIntArray("region"), true);
					if(region == null || !region.loaded) continue;
					if(FvtmRegistry.VEHICLES.get(com.getString("Vehicle")) == null){
						Print.log("SINGULAR Rail Vehicle with id '" + com.getString("Vehicle") + "' not found, removing.");
						Print.log("NBT:" + com);
						torem.add(uid);
						continue;
					}
					Singular singular = new Singular(region, com.getLong("Compound"), com);
					if(singular.getEntitites().size() == 0) continue;
					singular.forward = com.getBoolean("forward");
					region.spawnEntity(singular.getEntitites().get(0).start());
					torem.add(uid);
				}
				else{
					boolean allregionsloaded = true;
					for(TagCW tag : com.getList("Entities")){
						if(tag == null || !tag.has("region")) continue;
						region = getRegions().get(tag.getIntArray("region"), true);
						if(region == null || !region.loaded){ allregionsloaded = false; break; }
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
			torem.forEach(rem -> Region.fillqueue.remove(rem));
			torem.clear();
		}
		for(Region region : regions.values()) region.updateTick();
	}

	@Override
	public void unload(){
		if(!world.isRemote){
			regions.values().forEach(reg -> reg.save());
			save();
		}
		regions.clear();
	}

	public void updateRegion(TagCW compound, @Nullable EntityPlayerMP player){
		int[] xz = compound.getIntArray("XZ");
		if(world.isRemote){
			Region region = regions.get(xz); if(region == null) regions.put(new RegionKey(xz), region = new Region(xz[0], xz[1], this, false));
			region.read(compound);
		}
		else{
			Region region = regions.get(xz, true); region.updateClient(player);
		}
	}

	@Override
	public void onChunkLoad(Chunk chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x, chunk.z), true).chucks.put(new RegionKey(chunk.x, chunk.z), chunk);
	}

	@Override
	public void onChunkUnload(Chunk chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x, chunk.z), true).chucks.values().removeIf(pre -> pre.x == chunk.x && pre.z == chunk.z);
	}

	//@Deprecated
	public void registerEntity(RailEntity entity){
		entities.put(entity.getUID(), entity.getRegion().getKey());
	}

	//@Deprecated
	public RailEntity getEntity(long uid, boolean load){
		for(Region region : regions.values()){
			if(region.getEntities().containsKey(uid)){
				return region.getEntities().get(uid);
			}
		}
		if(load && entities.containsKey(uid)){
			Region region = regions.get(entities.get(uid), true);
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
		entities.remove(entity.getUID()); entity.region.updateClient("removed", entity);
	}

	public Track getTrack(PathKey key){
		Region region = regions.get(RegionKey.getRegionXZ(key), true);
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

	public void sendReload(String string, ICommandSender sender){
		Region region = regions.get(RegionKey.getRegionXZ(sender.getPositionVector()));
		if(region != null){
			region.updateClient(string, new QV3D(sender.getPositionVector().x, sender.getPositionVector().y, sender.getPositionVector().z, 0));
		}
	}

	public boolean isRemote(){
		return world.isRemote;
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
	
	public static class TimedTask extends TimerTask {

		private RailSystem railsys;

		public TimedTask(RailSystem railsys){
			this.railsys = railsys;
		}

		@Override
		public void run(){
			ArrayList<Region> regs = new ArrayList<>();
			for(Region region : railsys.regions.values()){
				if(region.chucks.isEmpty() && region.lastaccess < Time.getDate() - 60000) regs.add(region);
			}
			for(Region region : regs){
				region.save(); railsys.regions.remove(region.getKey());
			}
		}

	}

	@Override
	public void onClientTick(World world){
		//unused
	}

}
