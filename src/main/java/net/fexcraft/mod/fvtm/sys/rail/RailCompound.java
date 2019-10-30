package net.fexcraft.mod.fvtm.sys.rail;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track.TrackKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

/**
 * "Rail System Data"
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class RailCompound implements RailSystem {
	
	private long gc_entities, gc_sections, gc_compounds;
	private int dimension;
	private World world;
	//
	private RegionMap regions = new RegionMap(this);
	private TrackMap trackunits = new TrackMap(this);
	private SectionMap sections = new SectionMap(this);
	private TreeMap<Long, XZK> entities = new TreeMap<>();

	@Override
	public void setWorld(World world, int dimension){
		this.world = world; this.dimension = dimension;
	}

	@Override
	public World getWorld(){
		return world;
	}

	@Override
	public int getDimension(){
		return dimension;
	}

	@Override
	public NBTBase write(EnumFacing side){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("GlobalCounterEntities", gc_entities);
		compound.setLong("GlobalCounterSections", gc_sections);
		compound.setLong("GlobalCounterCompounds", gc_compounds);
		if(!entities.isEmpty()){
			NBTTagCompound enty = new NBTTagCompound();
			entities.forEach((key, value) -> { enty.setLong(Long.toHexString(key), value.toLong()); });
			compound.setTag("Entities", enty);
		} return compound;
	}

	@Override
	public void read(EnumFacing side, NBTTagCompound compound){
		if(compound == null || compound.hasNoTags()) return;
		gc_entities = compound.getLong("GlobalCounterEntities");
		gc_sections = compound.getLong("GlobalCounterSections");
		gc_compounds = compound.getLong("GlobalCounterCompounds");
		if(compound.hasKey("Entities")){
			NBTTagCompound enty = compound.getCompoundTag("Entities");
			for(String str : enty.getKeySet()){
				try{ entities.put(Long.parseLong(str, 16), new XZK(enty.getLong(str))); }
				catch(Exception e){ e.printStackTrace(); }
			}
		}
	}
	
	public static class TrackMap extends TreeMap<String, TrackUnit> {
		
		private RailCompound data;
		
		public TrackMap(RailCompound raildata){
			super(); data = raildata;
		}
		
		public TrackUnit get(String str, Long knownid, boolean create){
			if(!create) return super.get(str); TrackUnit trk = super.get(str);
			if(trk == null) this.put(str, trk = new TrackUnit(data, str, knownid)); return trk;
		}
		
	}
	
	public static class SectionMap extends TreeMap<Long, Section> {
		
		private RailCompound data;
		
		public SectionMap(RailCompound raildata){
			super(); data = raildata;
		}
		
		public Section get(Long sid, boolean create){
			if(create && sid == null){ Section sec = new Section(data, null); this.put(sec.getUID(), sec); return sec; }
			if(sid == null) return null; if(!create) return super.get(sid); Section sec = super.get(sid);
			if(sec == null) this.put(sid, sec = new Section(data, sid)); return sec;
		}
		
	}
	
	public static class RegionMap extends HashMap<XZK, RailRegion> {
		
		private RailCompound root;
		public RegionMap(RailCompound data){ this.root = data; }
		
		public RailRegion get(int x, int z){
			for(XZK key : keySet()){
				if(x == key.x && z == key.z) return get(key);
			} return null;
		}
		
		public RailRegion get(int[] xz){
			for(XZK key : keySet()){
				if(xz[0] == key.x && xz[1] == key.z) return get(key);
			} return null;
		}
		
		public RailRegion get(Vec316f vec, boolean load){
			RailRegion region = get(getRegionXZ(vec)); if(region != null || !load) return region;
			put(new XZK(vec), region = new RailRegion(vec, root)); return region;
		}

		public RailRegion get(int[] xz, boolean load){
			RailRegion region = get(xz); if(region != null || !load) return region;
			put(new XZK(xz), region = new RailRegion(xz[0], xz[1], root)); return region;
		}

		public RailRegion get(XZK xz, boolean load){
			RailRegion region = get(xz); if(region != null || !load) return region;
			put(new XZK(xz.x, xz.z), region = new RailRegion(xz.x, xz.z, root)); return region;
		}
		
	}
	
	public static class XZK implements Comparable<XZK> {
		
		public final int x, z;
		
		public XZK(int x, int z){
			this.x = x; this.z = z;
		}
		
		public XZK(int[] arr){
			this.x = arr[0]; this.z = arr[1];
		}
		
		public XZK(Vec316f vec){
			this(getRegionXZ(vec));
		}

		public XZK(long leng){//TODO replace this someday
			ByteBuffer buffer = ByteBuffer.allocate(8).putLong(leng);
			x = buffer.getInt(0); z = buffer.getInt(4);
		}
		
		public long toLong(){
			return ByteBuffer.allocate(8).putInt(x).putInt(z).getLong(0);
		}

		@Override
		public boolean equals(Object obj){
			if(obj instanceof XZK == false) return false;
			return ((XZK)obj).x == x && ((XZK)obj).z == z;
		}
		
		@Override
		public int compareTo(XZK key){
			if(key.x > x) return 1; else if(key.x < x) return -1;
			if(key.z > z) return 1; else if(key.z < z) return -1;
			return 0;
		}
		
		@Override
		public String toString(){
			return x + ", "+ z;
		}

		public int[] toArray(){
			return new int[]{ x, z };
		}
		
	}
	
	public static int[] getRegionXZ(int cx, int cz){
		return new int[]{(int)Math.floor(cx / 32.0), (int)Math.floor(cz / 32.0)};
	}
	
	public static int[] getRegionXZ(Vec316f vec){
		return getRegionXZ((int)vec.pos.getX() >> 4, (int)vec.pos.getZ() >> 4);
	}

	public static int[] getRegionXZ(Vec3f pos){
		return getRegionXZ((int)pos.xCoord >> 4, (int)pos.zCoord >> 4);
	}

	private int[] getRegionXZ(Vec3d vec){
		return getRegionXZ((int)vec.x >> 4, (int)vec.z >> 4);
	}

	private int[] getRegionXZ(TrackKey key){
		return getRegionXZ(key.pos[0] >> 4, key.pos[2] >> 4);
	}
	
	public RegionMap getRegions(){
		return regions;
	}

	@Override
	public Junction getJunction(Vec316f vec){
		RailRegion region = regions.get(vec, false); return region == null ? null : region.getJunction(vec);
	}

	@Override
	public Junction getJunction(Vec316f vec, boolean load){
		RailRegion region = regions.get(vec, load); return region.getJunction(vec);
	}

	@Override
	public boolean delJunction(Vec316f vector){
		RailRegion region = regions.get(vector, false);
		if(region == null || region.getJunction(vector) == null) return false;
		Junction junc = region.getJunctions().remove(vector);
		if(junc != null){ for(Track track : junc.tracks){ delTrack(track, true); } if(junc.entity != null) junc.entity.setDead(); }
		region.setAccessed().updateClient(vector); return true;
	}

	@Override
	public boolean delTrack(Track track, boolean remjunk){
		if(track == null) return false; Junction junction = getJunction(track.start);
		if(junction != null){
			junction.remove(track.getId(), false, remjunk);
			junction.checkTrackSectionConsistency();
		} return true;
	}

	@Override
	public void addJunction(Vec316f vector){
		RailRegion region = regions.get(vector, true); if(region == null) /** this rather an error*/ return;
		Junction junction = new Junction(region, vector); region.getJunctions().put(vector, junction);
		junction.updateClient(); region.setAccessed(); return;
	}

	@Override
	public void updateJuncton(Vec316f vector){
		RailRegion region = regions.get(vector, true); if(region == null) /** This is rather bad. */ return;
		region.setAccessed().updateClient("junction", vector);
	}
	
	public static class TimedTask extends TimerTask {

		@Override
		public void run(){
			for(World world : Static.getServer().worlds){
				if(world.isRemote) return; world.getCapability(Capabilities.RAILSYSTEM, null).scheduledCheck();
			}
		}

	}

	@Override
	public void scheduledCheck(){
		ArrayList<RailRegion> regs = new ArrayList<>();
		for(RailRegion region : regions.values()){
			if(region.lastaccess < Time.getDate() - 60000 && region.chucks.isEmpty()) regs.add(region);
		}
		for(RailRegion region : regs){
			region.save(); regions.remove(region.getKey());
		}
	}

	@Override
	public void updateTick(){
		for(RailRegion region : regions.values()){ region.updateTick(); }
	}

	@Override
	public File getRootFile(){
		if(dimension != 0){ return new File(world.getSaveHandler().getWorldDirectory(), world.provider.getSaveFolder() + "/fvtm"); }
		return new File(world.getSaveHandler().getWorldDirectory(), "/fvtm");
	}

	@Override
	public void unload(){
		if(!world.isRemote) regions.values().forEach(reg -> reg.save()); regions.clear();
	}

	public void updateRegion(boolean isRemote, int[] xz, NBTTagCompound compound, @Nullable EntityPlayerMP player){
		if(isRemote){
			RailRegion region = regions.get(xz); if(region == null) regions.put(new XZK(xz), region = new RailRegion(xz[0], xz[1], this)); region.read(compound);
		}
		else{
			RailRegion region = regions.get(xz, true); region.updateClient(player);
		}
	}

	@Override
	public void onChunkLoad(Chunk chunk){
		regions.get(getRegionXZ(chunk.x, chunk.z), true).chucks.add(new XZK(chunk.x, chunk.z));
	}

	@Override
	public void onChunkUnload(Chunk chunk){
		regions.get(getRegionXZ(chunk.x, chunk.z), true).chucks.removeIf(pre -> pre.x == chunk.x && pre.z == chunk.z);
	}

	@Override
	public void registerEntity(RailEntity entity){
		entities.put(entity.getUID(), entity.getRegion().getKey());
	}

	@Override
	public RailEntity getEntity(long uid, boolean load){
		for(RailRegion region : regions.values()){
			if(region.getEntities().containsKey(uid)){
				return region.getEntities().get(uid);
			}
		}
		if(load && entities.containsKey(uid)){
			RailRegion region = regions.get(entities.get(uid), true);
			if(region != null) return region.getEntities().get(uid);
		} return null;
	}

	@Override
	public void updateEntityEntry(long uid, int x, int z){
		entities.put(uid, new XZK(x, z));
	}

	@Override
	public void updateEntityEntry(long uid, XZK key){
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

	@Override
	public Track getTrack(TrackKey key){
		RailRegion region = regions.get(getRegionXZ(key), true);
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
		RailRegion region = regions.get(getRegionXZ(sender.getPositionVector()));
		if(region != null) region.updateClient(string, new Vec316f(sender.getPositionVector()));
	}

}
