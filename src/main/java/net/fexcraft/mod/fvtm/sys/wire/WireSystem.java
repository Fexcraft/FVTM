package net.fexcraft.mod.fvtm.sys.wire;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TimerTask;
import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.sys.uni.DetachedSystem;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

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
	
	public WireSystem(World world){
		super(world);
		if(!world.isRemote) load();
	}

	public void load(){
		try{
			File file = new File(getSaveRoot(), "/wiresystem.dat");
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			NBTTagCompound compound = CompressedStreamTools.read(file);
			if(compound == null || compound.isEmpty()) return;
			gc_sections = compound.getLong("GlobalCounterSections");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void save(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("GlobalCounterSections", gc_sections);
		try{
			File file = new File(getSaveRoot(), "/wiresystem.dat");
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			CompressedStreamTools.write(compound, file);
		}
		catch(IOException e){
			e.printStackTrace();
		}
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
	
	public static class RegionMap extends HashMap<RegionKey, WireRegion> {
		
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
		
		public WireRegion get(Vec316f vec, boolean load){
			WireRegion region = get(RegionKey.getRegionXZ(vec));
			if(region != null || !load) return region;
			put(new RegionKey(vec), region = new WireRegion(vec, root, false));
			region.load().updateClient(vec);
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

		public WireRegion get(BlockPos pos, boolean load){
			return get(RegionKey.getRegionXZ(pos), load);
		}
		
	}
	
	public RegionMap getRegions(){
		return regions;
	}

	public WireRelay getRelay(Vec316f vec){
		WireRegion region = regions.get(vec, false);
		return region == null ? null : region.getRelay(vec);
	}

	public WireRelay getRelay(Vec316f vec, boolean load){
		WireRegion region = regions.get(vec, load);
		return region.getRelay(vec);
	}

	public ArrayList<WireRelay> getRelayssInChunk(int cx, int cz){
		ArrayList<WireRelay> arr = new ArrayList<>();
		WireRegion region = regions.get(RegionKey.getRegionXZ(cx, cz));
		if(region == null) return arr;
		for(Entry<Vec316f, WireRelay> entry : region.getRelays().entrySet()){
			if(entry.getKey().pos.getX() >> 4 == cx && entry.getKey().pos.getZ() >> 4 == cz){
				arr.add(entry.getValue());
			}
		}
		return arr;
	}

	public boolean delRelay(Vec316f vector){
		WireRelay relay = this.getRelay(vector);
		return relay.holder.remove(relay.getVec316f()) != null;
	}

	public WireRelay regRelay(WireRelay relay){
		WireRegion region = regions.get(relay.getVec316f(), true);
		if(region == null) return null;
		region.getRelays().put(relay.getVec316f(), relay);
		region.setAccessed().updateClient("holder", relay.getVec316f(), null);
		return relay;
	}

	@Override
	public void onServerTick(){
		for(WireRegion region : regions.values()) region.updateTick();
	}

	@Override
	public void unload(){
		if(!world.isRemote){
			regions.values().forEach(reg -> reg.save());
			save();
		}
		regions.clear();
	}

	public void updateRegion(NBTTagCompound compound, @Nullable EntityPlayerMP player){
		int[] xz = compound.getIntArray("XZ");
		if(world.isRemote){
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
	public void onChunkLoad(Chunk chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x, chunk.z), true).chucks.put(new RegionKey(chunk.x, chunk.z), chunk);
	}

	@Override
	public void onChunkUnload(Chunk chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x, chunk.z), true).chucks.values().removeIf(pre -> pre.x == chunk.x && pre.z == chunk.z);
	}

	public long getNewSectionId(){
		return gc_sections++;
	}

	public Wire getWire(PathKey key){
		WireRegion region = regions.get(RegionKey.getRegionXZ(key), true);
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

	public void sendReload(String string, ICommandSender sender){
		WireRegion region = regions.get(RegionKey.getRegionXZ(sender.getPositionVector()));
		if(region != null) region.updateClient(string, new Vec316f(sender.getPositionVector()), null);
	}

	public boolean isRemote(){
		return world.isRemote;
	}
	
	//

	@Override
	public boolean hasTimer(){
		return true;
	}

	@Override
	public void addTimerTask(long time){
		timer.schedule(new TimedTask(this), new Date(time), Config.UNLOAD_INTERVAL);
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
	public void register(BlockTileEntity tile){
		RelayHolder holder = getHolder(tile.getPos());
		if(holder == null) holder = addHolder(tile.getPos());
		HashMap<String, Vec316f> vectors = tile.getBlockData().getRelayData().getVectors(tile);
		for(Entry<String, Vec316f> vec : vectors.entrySet()){
			holder.add(vec.getKey(), vec.getValue(), false);
		}
		holder.setTile(tile);
	}

	/** Unlinking TE */
	public void unregister(BlockTileEntity tile){
		RelayHolder holder = getHolder(tile.getPos());
		if(holder != null) holder.setTile(null);
	}
	
	/** Removing when present. */
	public void deregister(TileEntity tileentity){
		if(tileentity == null || tileentity instanceof BlockTileEntity == false) return;
		BlockTileEntity tile = (BlockTileEntity)tileentity;
		delHolder(tile.getPos());
	}

	public RelayHolder getHolder(BlockPos pos){
		WireRegion region = regions.get(pos, false);
		return region == null ? null : region.getHolder(pos);
	}

	public RelayHolder getHolder(BlockPos pos, boolean load){
		WireRegion region = regions.get(pos, load);
		return region.getHolder(pos);
	}

	private RelayHolder addHolder(BlockPos pos){
		WireRegion region = regions.get(pos, true);
		return region.addHolder(pos);
	}

	protected void delHolder(BlockPos pos){
		WireRegion region = regions.get(pos, true);
		if(region != null) region.delHolder(pos);
	}

}
