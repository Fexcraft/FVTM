package net.fexcraft.mod.fvtm.sys.rail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.fexcraft.mod.fvtm.prototype.ConnContainer;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailDataSerializer;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailImpl;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class RailRegion {
	
	//private ArrayList<Connection> connections = new ArrayList<>();
	private TreeMap<BlockPos, ConnContainer> connections = new TreeMap<BlockPos, ConnContainer>();
	//private static final Connection[] NONE = new Connection[0];
	public static final ConnContainer EMPTY = new ConnContainer();
	private WorldRailImpl util;
	public long lastaccessed;
	private boolean wasempty;
	private int x, z;
	//
	private TreeMap<BlockPos, Junction> junctions = new TreeMap<>();
	public boolean READING;
	
	public RailRegion(WorldRailImpl data, int x, int z, @Nullable NBTTagCompound compound){
		this.util = data; File file = this.getFile(x, z);
		this.x = x; this.z = z;
		if(compound == null){
			if(!file.exists()){ file.getParentFile().mkdirs(); }
			else{
				try{ compound = CompressedStreamTools.read(file); }
				catch(IOException e){ e.printStackTrace(); }
			}
			if(compound == null) compound = new NBTTagCompound();
		}
		this.read(compound);
		Print.debug("x" + x + ", z" + z + " |L| " + connections);
		if(!util.getWorld().isRemote) this.sendUpdatePacket(false);
	}

	public final void sendUpdatePacket(boolean unload){
		NBTTagCompound compound = unload ? new NBTTagCompound() : this.write();
		compound.setString("target_listener", WorldRailDataSerializer.REGNAM);
		compound.setString("task", unload ? "unload" : "update");
		compound.setInteger("dimension", util.getDimension());
		PacketHandler.getInstance().sendToAll(new PacketNBTTagCompound(compound));
		//TODO make the packet more place-specific
	}

	public NBTTagCompound write(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("LastUse", this.lastaccessed);
		/*NBTTagList list = new NBTTagList();
		for(Entry<BlockPos, ConnContainer> entry : connections.entrySet()){
			NBTTagList clist = new NBTTagList();
			NBTTagCompound com = new NBTTagCompound();
			com.setLong("Position", entry.getKey().toLong());
			for(Connection conn : entry.getValue().connections){
				clist.appendTag(conn.write(new NBTTagCompound()));
			}
			com.setBoolean("Switch0", entry.getValue().switch0);
			com.setTag("Connections", clist);
			list.appendTag(com);
		}
		compound.setTag("Positions", list);*/
		compound.setInteger("RegionX", x);
		compound.setInteger("RegionZ", z);
		//
		NBTTagList jlist = new NBTTagList();
		for(Junction junk : junctions.values()){
			jlist.appendTag(junk.write(null));
		}
		compound.setTag("Junctions", jlist);
		return compound;
	}
	
	public void read(NBTTagCompound compound){
		READING = true;
		/*if(compound.hasKey("Positions")){
			NBTTagList list = (NBTTagList)compound.getTag("Positions");
			for(NBTBase base : list){
				NBTTagCompound com = (NBTTagCompound)base;
				BlockPos pos = BlockPos.fromLong(com.getLong("Position"));
				if(com.hasKey("Connections")){
					NBTTagList clist = (NBTTagList)com.getTag("Connections");
					Connection[] conns = new Connection[clist.tagCount()];
					for(int i = 0; i < conns.length; i++){
						conns[i] = new Connection().read((NBTTagCompound)clist.get(i));
					}
					boolean bool = com.getBoolean("Switch0");
					connections.put(pos, new ConnContainer(conns, bool));
				} 
			}
		}
		else wasempty = true;*/
		if(compound.hasKey("Junctions")){
			junctions.clear();
			NBTTagList list = (NBTTagList)compound.getTag("Junctions");
			for(NBTBase base : list){
				try{
					NBTTagCompound com = (NBTTagCompound)base;
					BlockPos core = BlockPos.fromLong(com.getLong("Core"));
					Junction junk = new Junction(this.util.getWorld(), core).read(com);
					junctions.put(core, junk);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		else wasempty = true;
		this.lastaccessed = compound.hasKey("LastUse") ? compound.getLong("LastUse") : Time.getDate();
		READING = false;
	}

	private File getFile(int x, int z){
		return new File(util.getRootFile(), "/railregions/" + x + "_" + z + ".dat");
	}

	public void save(){
		if(util.getWorld().isRemote) return;
		if(wasempty && junctions.isEmpty()) return;
		NBTTagCompound compound = this.write();
		try{
			CompressedStreamTools.write(compound, this.getFile(x, z));
		}
		catch(IOException e){
			Print.log("FAILED TO WRITE RAIL REGION, THIS IS SEVERE.");
			Print.log(compound); e.printStackTrace();
		}
		Print.debug("x" + x + ", z" + z + " |S| " + connections);
	}

	public ConnContainer getConnectionsAt(BlockPos pos){ this.updateAccess(null);
		return connections.containsKey(pos) ? connections.get(pos) : EMPTY;
		//return connections.stream().filter(pre -> pre.getBeginning().equals(pos) || pre.getDestination().equals(pos)).toArray(Connection[]::new);
	}

	public TreeMap<BlockPos, ConnContainer> getConnections(){
		this.updateAccess(null); return connections;
	}

	public void resetConnectionsAt(BlockPos pos){
		if(!connections.containsKey(pos)) return;
		ArrayList<Connection> torem = new ArrayList<>();
		for(Connection conn : connections.get(pos).connections){
			torem.add(conn);
		} // we don't want concurrent exceptions.
		for(Connection conn : torem) util.delConnection(conn.getBeginning(), conn.getDestination());
		this.updateAccess(null); //this.sendUpdatePacket(false); return;
	}

	public void delConnection(BlockPos start, BlockPos end){
		ConnContainer conns = connections.get(start);
		if(conns != null){
			int j = -1;
			for(int i = 0; i < conns.connections.length; i++){
				if((conns.connections[i].getBeginning().equals(start) && conns.connections[i].getDestination().equals(end))
					|| (conns.connections[i].getDestination().equals(start) && conns.connections[i].getBeginning().equals(end))){
					j = i; break; }
			}
			if(j != -1){ conns.remove(j); }
		}
		conns = connections.get(end);
		if(conns != null){
			int j = -1;
			for(int i = 0; i < conns.connections.length; i++){
				if((conns.connections[i].getBeginning().equals(start) && conns.connections[i].getDestination().equals(end))
					|| (conns.connections[i].getDestination().equals(start) && conns.connections[i].getBeginning().equals(end))){
					j = i; break; }
			}
			if(j != -1){ conns.remove(j); }
		}
		this.updateAccess(null); this.sendUpdatePacket(false);
	}

	public void addConnection(Connection conn){
		if(connections.containsKey(conn.getBeginning())){
			connections.get(conn.getBeginning()).addnew(conn);
		}
		else{
			connections.put(conn.getBeginning(), new ConnContainer(conn));
		}
		this.updateAccess(null); this.sendUpdatePacket(false); return;
	}

	public void updateAccess(Long date){
		this.lastaccessed = date == null ? Time.getDate() : date;
	}

	public boolean isSameRegion(RailRegion reg){
		if(x == reg.x && z == reg.z) return true;
		return this.equals(reg);
	}

	public Entry<BlockPos, ConnContainer> getEntry(BlockPos pos){
		for(Entry<BlockPos, ConnContainer> entry : connections.entrySet()){
			if(entry.getKey().equals(pos)) return entry;
		} return null;
	}

	public void toggleSwitch(BlockPos pos){
		ConnContainer conns = this.connections.get(pos); if(conns == null) return;
		conns.switch0 = !conns.switch0; this.sendUpdatePacket(false);//TODO specialized packet
	}

	public void addTrack(Track track){
		if(junctions.containsKey(track.start)){
			junctions.get(track.start).addnew(track);
		}
		else{
			Junction junk = new Junction(this.util.getWorld(), track.start);
			junk.addnew(track); junctions.put(junk.getCore(), junk);
		}
		this.updateAccess(null); this.sendUpdatePacket(false); return;
	}

	public TreeMap<BlockPos, Junction> getJunctions(){
		return junctions;
	}

	public void resetJunctionAt(BlockPos pos){
		if(!junctions.containsKey(pos)) return;
		Junction junk = junctions.remove(pos);
		if(junk != null) junk.clear();
		this.updateAccess(null); //this.sendUpdatePacket(false); return;
	}

	public Junction getJunctionAt(BlockPos pos){
		return junctions.containsKey(pos) ? junctions.get(pos) : null;
	}
	
}