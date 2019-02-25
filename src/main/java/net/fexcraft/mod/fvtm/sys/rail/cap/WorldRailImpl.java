package net.fexcraft.mod.fvtm.sys.rail.cap;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Gauge;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.rail.JunctionTileEntity;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.LineSection;
import net.fexcraft.mod.fvtm.sys.rail.MoveUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailRegion;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;

/** @author Ferdinand Calo' (FEX___96) */
public class WorldRailImpl implements WorldRailData {

	private DynamicRegionMap map = new DynamicRegionMap(this);
	private World world;
	private int dim;
	private boolean LOADING;
	//
	public ArrayList<LineSection> sections = new ArrayList<>();

	@Override
	public void setWorld(World world, int dimension){
		this.world = world; this.dim = dimension;
	}

	@Override
	public World getWorld(){
		return world;
	}

	@Override
	public int getDimension(){
		return dim;
	}

	@Override
	public NBTBase write(EnumFacing side){
		//File root = this.getRootFile();
		//if(!root.exists()){ root.mkdirs(); }
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("LastSave", Time.getDate());
		return compound;
	}

	@Override
	public void read(EnumFacing side, NBTBase nbt){
		if(!getRootFile().exists()) return;
		if(nbt == null) return;
	}
	
	public static int[] getRegion(int cx, int cz){
		return new int[]{(int)Math.floor(cx / 32.0), (int)Math.floor(cz / 32.0)};
	}
	
	public static int[] getRegion(BlockPos pos){
		return getRegion(pos.getX() >> 4, pos.getZ() >> 4);
	}
	
	public File getRootFile(){
		if(dim != 0){
			return new File(world.getSaveHandler().getWorldDirectory(), world.provider.getSaveFolder() + "/fvtm");
		}
		return new File(world.getSaveHandler().getWorldDirectory(), "/fvtm");
	}
	
	public static class DynamicRegionMap extends TreeMap<XZKey, RailRegion> {
		
		private WorldRailImpl util;

		public DynamicRegionMap(WorldRailImpl util){
			this.util = util;
		}

		public RailRegion getRegion(int[] reg){
			RailRegion region = this.get(new XZKey(reg));
			if(region != null) return region;
			else{
				//TODO check if qualifies for load
				util.LOADING = true;
				region = new RailRegion(util, reg[0], reg[1], null);
				MoveUtil.attach(region);
				this.putIfAbsent(new XZKey(reg), region);
				util.LOADING = false;
				return region;
			}
		}

		public RailRegion getRegion(int x, int z){
			return this.getRegion(new int[]{ x, z });
		}

		public RailRegion getRegion(BlockPos pos){
			return getRegion(pos.getX() >> 4, pos.getZ() >> 4);
		}

		public boolean contains(int x, int z){
			return this.get(new XZKey(x, z)) != null;
		}

		public boolean contains(int[] region){
			return contains(region[0], region[1]);
		}
		
		@Override
		public Collection<RailRegion> values(){
			return super.values();
		}
		
	}
	
	public static class XZKey implements Comparable<XZKey> {
		
		private int x, z;
		
		public XZKey(int[] arr){ x = arr[0]; z = arr[1]; }

		public XZKey(int x, int z){ this.x = x; this.z = z; }

		@Override
		public int compareTo(XZKey key){
			if(key.x > x) return 1; else if(key.x < x) return -1;
			if(key.z > z) return 1; else if(key.z < z) return -1;
			return 0;
		}
		
		@Override
		public boolean equals(Object o){
			if(o instanceof XZKey == false) return false;
			return ((XZKey)o).x == x && ((XZKey)o).z == z;
		}
		
	}

	@Override
	public void checkForInactive(){
		LOADING = true;
		final long date = Time.getDate(); RailRegion reg = null;
		ChunkProviderServer server = (ChunkProviderServer)world.getChunkProvider();
		for(Chunk pos : server.getLoadedChunks()){
			reg = this.map.getRegion(getRegion(pos.x, pos.z)); if(reg != null) reg.updateAccess(date);
		}
		ArrayList<XZKey> keys = new ArrayList<>();
		for(Entry<XZKey, RailRegion> entry : map.entrySet()){
			if(entry.getValue().lastaccessed + Time.MIN_MS < date){
				keys.add(entry.getKey());
			}
		} for(XZKey key : keys) unloadRegion(key);
		LOADING = false;
	}

	private void unloadRegion(XZKey key){
		LOADING = true;
		RailRegion reg = map.remove(key); if(reg == null) return;
		reg.save(); reg.sendUpdatePacket(true); MoveUtil.detach(reg);
		LOADING = false;
	}

	@Override
	public void onUnload(){
		LOADING = true;
		ArrayList<XZKey> keys = new ArrayList<>();
		for(Entry<XZKey, RailRegion> entry : map.entrySet()){
			keys.add(entry.getKey());
		} for(XZKey key : keys) unloadRegion(key);
		LOADING = false;
	}

	@Override
	public void updateRegion(int x, int z, NBTTagCompound nbt){
		LOADING = true;
		if(map.contains(x, z)){
			this.map.getRegion(x, z).read(nbt); //return;
			Print.debug("Updating RailRegion " + x + ", " + z);
		}
		else{
			this.map.putIfAbsent(new XZKey(x, z), new RailRegion(this, x, z, nbt));
			Print.debug("Loading RailRegion " + x + ", " + z);
		}
		Print.debug(map.size() + " railregions loaded");
		//
		for(TileEntity tile : world.loadedTileEntityList){
			if(tile instanceof JunctionTileEntity == false) continue;
			//this.setTileData((JunctionTileEntity)tile, false);
			//TODO
		}
		LOADING = false;
	}

	@Override
	public void unloadRegion(int x, int z){
		LOADING = true;
		this.unloadRegion(new XZKey(new int[]{ x, z }));
		Print.debug("Unloading RailRegion " + x + ", " + z);
		LOADING = false;
	}

	@Override
	public void doTask(String string, int[] reg, NBTTagCompound packet){
		switch(string){
			case "sync_region":{
				this.map.getRegion(reg).sendUpdatePacket(false);
				break;
			}
		} return;
	}

	@Override
	public void toggleSwitch(BlockPos pos, boolean type){
		RailRegion region = map.getRegion(getRegion(pos));
		if(region == null) return; region.toggleSwitch(pos, type);
	}

	@Override
	public void updateTick(){
		if(LOADING) return;
		for(RailRegion region : map.values()){
			region.updateTick();
		}
	}

	@Override
	public void addJunction(Gauge gauge, BlockPos start, BlockPos end, BlockPos[] arr){
		LOADING = true;
		Track track = new Track(start, end, gauge, arr);
		RailRegion reg = map.getRegion(getRegion(start));
		if(reg != null) reg.addTrack(track);
		reg = map.getRegion(getRegion(end));
		if(reg != null) reg.addTrack(track.oppositeCopy());
		LOADING = false;
	}

	@Override
	public void delJunction(BlockPos pos){
		LOADING = true;
		RailRegion reg = map.getRegion(getRegion(pos));
		if(reg == null) return; reg.resetJunctionAt(pos);
		LOADING = false;
	}

	@Override
	public Junction getJunction(BlockPos pos){
		RailRegion reg = map.getRegion(getRegion(pos));
		if(reg == null) return null;
		return reg.getJunctionAt(pos);
	}

	@Override
	public void setTileData(JunctionTileEntity junction, boolean fromtile){
		if(!map.contains(getRegion(junction.getPos())) && fromtile){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", WorldRailDataSerializer.REGNAM);
			compound.setString("task", "sync_region");
			compound.setIntArray("region", getRegion(junction.getPos()));
			compound.setInteger("dimension", this.getDimension());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
			return;
		}
		/*Junction junk = this.getJunction(junction.getPos());
		if(junk != null && junk.tracks.size() > 0){
			junction.region = map.getRegion(getRegion(junction.getPos())); junction.entry = junction.region.getEntry(junction.getPos());
		}
		else{
			junction.region = null; junction.entry = null;
		}*/
	}

	@Override
	public boolean isLoading(){
		return LOADING;
	}

	@Override
	public void spawnEntity(VehicleData data, Junction junk){
		Track[] tracks = junk.getTracksForSpawn();
		new RailEntity(tracks[0], tracks[1], map.getRegion(getRegion(junk.getCore())), data);
	}

	public DynamicRegionMap getRegionMap(){
		return map;
	}

	@Override
	public Map<XZKey, RailRegion> getRegions(){
		return map;
	}

}