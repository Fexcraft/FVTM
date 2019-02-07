package net.fexcraft.mod.fvtm.sys.rail.cap;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Gauge;
import net.fexcraft.mod.fvtm.blocks.rail.JunctionTileEntity;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.LineSection;
import net.fexcraft.mod.fvtm.sys.rail.MoveUtil;
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
		private XZKey tempkey;

		public DynamicRegionMap(WorldRailImpl util){
			this.util = util;
		}

		public RailRegion getRegion(int[] reg){
			RailRegion region = this.get(tempkey = new XZKey(reg));
			if(region != null) return region;
			else{
				//TODO check if qualifies for load
				region = new RailRegion(util, reg[0], reg[1], null);
				MoveUtil.attach(region);
				this.put(new XZKey(reg), region);
				return this.get(tempkey);
			}
		}

		public RailRegion getRegion(int x, int z){
			return this.getRegion(new int[]{ x, z });
		}

		public RailRegion getRegion(BlockPos pos){
			return getRegion(pos.getX() >> 4, pos.getZ() >> 4);
		}

		public boolean contains(int x, int z){
			return this.get(tempkey = new XZKey(x, z)) != null;
		}

		public boolean contains(int[] region){
			return contains(region[0], region[1]);
		}
		
	}
	
	private static class XZKey implements Comparable<XZKey> {
		
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
	}

	private void unloadRegion(XZKey key){
		RailRegion reg = map.remove(key); if(reg == null) return;
		reg.save(); reg.sendUpdatePacket(true); MoveUtil.detach(reg);
	}

	@Override
	public void onUnload(){
		ArrayList<XZKey> keys = new ArrayList<>();
		for(Entry<XZKey, RailRegion> entry : map.entrySet()){
			keys.add(entry.getKey());
		} for(XZKey key : keys) unloadRegion(key);
	}

	@Override
	public BlockPos getNext(BlockPos current, BlockPos previous, boolean test){
		/*ConnContainer conns = this.getConnectionsAt(current);
		Connection[] connections = conns.connections;//this.getConnectionsAt(current);
		if(current == null){
			return connections.length == 0 ? new BlockPos(0, 0, 0) : connections[0].getDestination();
		}
		switch(connections.length){
			case 0: { return current; }
			case 1: {
				return connections[0].equalsDestOrFirst(previous) ? current : connections[0].getFirstTowardsDest();
			}
			case 2: {
				return connections[0].equalsDestOrFirst(previous) ? connections[1].getFirstTowardsDest() : connections[0].getFirstTowardsDest();
			}
			case 3: {
				if(connections[0].equalsDestOrFirst(previous)){
					return conns.switch0 ? connections[2].getFirstTowardsDest() : connections[1].getFirstTowardsDest();
				}
				else{
					if(!test){
						boolean bool = connections[2].equalsDestOrFirst(previous);
						if(bool != conns.switch0){
							conns.switch0 = bool; map.getRegion(current).sendUpdatePacket(false);
						}
					}
					return connections[0].getFirstTowardsDest();
				}
			}
			case 4: {
				if(connections[1].equalsDestOrFirst(previous)){
					return connections[0].getFirstTowardsDest();
				}
				if(connections[0].equalsDestOrFirst(previous)){
					return connections[1].getFirstTowardsDest();
				}
				if(connections[3].equalsDestOrFirst(previous)){
					return connections[2].getFirstTowardsDest();
				}
				if(connections[2].equalsDestOrFirst(previous)){
					return connections[3].getFirstTowardsDest();
				}
				break;
			}
			default: return current;
		}*/ return current;
	}

	@Override
	public void updateRegion(int x, int z, NBTTagCompound nbt){
		if(map.contains(x, z)){
			this.map.getRegion(x, z).read(nbt); //return;
			Print.debug("Updating RailRegion " + x + ", " + z);
		}
		else{
			this.map.put(new XZKey(x, z), new RailRegion(this, x, z, nbt));
			Print.debug("Loading RailRegion " + x + ", " + z);
		}
		Print.debug(this.getLoadedRegions().size() + " railregions loaded");
		//
		for(TileEntity tile : world.loadedTileEntityList){
			if(tile instanceof JunctionTileEntity == false) continue;
			this.setTileData((JunctionTileEntity)tile, false);
		}
	}

	@Override
	public void unloadRegion(int x, int z){
		this.unloadRegion(new XZKey(new int[]{ x, z }));
		Print.debug("Unloading RailRegion " + x + ", " + z);
	}

	@Override
	public Collection<RailRegion> getLoadedRegions(){
		return map.values();
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
	public void toggleSwitch(BlockPos pos){
		RailRegion region = map.getRegion(getRegion(pos));
		if(region == null) return; region.toggleSwitch(pos);
	}

	@Override
	public void updateTick(){
		//
	}

	@Override
	public void addJunction(Gauge gauge, BlockPos start, BlockPos end, BlockPos[] arr){
		Track track = new Track(start, end, gauge, arr);
		RailRegion reg = map.getRegion(getRegion(start));
		if(reg != null) reg.addTrack(track);
		reg = map.getRegion(getRegion(end));
		if(reg != null) reg.addTrack(track.oppositeCopy());
	}

	@Override
	public void delJunction(BlockPos pos){
		RailRegion reg = map.getRegion(getRegion(pos));
		if(reg == null) return; reg.resetJunctionAt(pos);
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
		if(this.getJunction(junction.getPos()).tracks.size() > 0){
			junction.region = map.getRegion(getRegion(junction.getPos())); junction.entry = junction.region.getEntry(junction.getPos());
		}
		else{
			junction.region = null; junction.entry = null;
		}
	}

}