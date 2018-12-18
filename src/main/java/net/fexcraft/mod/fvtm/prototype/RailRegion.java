package net.fexcraft.mod.fvtm.prototype;

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
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class RailRegion {
	
	//private ArrayList<Connection> connections = new ArrayList<>();
	private TreeMap<BlockPos, Connection[]> connections = new TreeMap<BlockPos, Connection[]>();
	private static final Connection[] NONE = new Connection[0];
	private WorldRailUtil util;
	public long lastaccessed;
	private boolean wasempty;
	private int x, z;
	
	public RailRegion(WorldRailUtil data, int x, int z, @Nullable NBTTagCompound compound){
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
		NBTTagList list = new NBTTagList();
		for(Entry<BlockPos, Connection[]> entry : connections.entrySet()){
			NBTTagList clist = new NBTTagList();
			NBTTagCompound com = new NBTTagCompound();
			com.setLong("Position", entry.getKey().toLong());
			for(Connection conn : entry.getValue()){
				clist.appendTag(conn.write(new NBTTagCompound()));
			}
			com.setTag("Connections", clist);
			list.appendTag(com);
		}
		compound.setTag("Positions", list);
		compound.setInteger("RegionX", x);
		compound.setInteger("RegionZ", z);
		return compound;
	}
	
	public void read(NBTTagCompound compound){
		if(compound.hasKey("Positions")){
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
					connections.put(pos, conns);
				} 
			}
		} else wasempty = true;
		this.lastaccessed = compound.hasKey("LastUse") ? compound.getLong("LastUse") : Time.getDate();
	}

	private File getFile(int x, int z){
		return new File(util.getRootFile(), "/railregions/" + x + "_" + z + ".nbt");
	}

	public void save(){
		if(util.getWorld().isRemote) return;
		if(wasempty && connections.isEmpty()) return;
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

	public Connection[] getConnectionsAt(BlockPos pos){ this.updateAccess(null);
		return connections.containsKey(pos) ? connections.get(pos) : NONE;
		//return connections.stream().filter(pre -> pre.getBeginning().equals(pos) || pre.getDestination().equals(pos)).toArray(Connection[]::new);
	}

	public TreeMap<BlockPos, Connection[]> getConnections(){
		this.updateAccess(null); return connections;
	}

	public void resetConnectionsAt(BlockPos pos){
		if(!connections.containsKey(pos)) return;
		ArrayList<Connection> torem = new ArrayList<>();
		for(Connection conn : connections.get(pos)){
			torem.add(conn);
		} // we don't want concurrent exceptions.
		for(Connection conn : torem) util.delConnection(conn.getBeginning(), conn.getDestination());
		this.updateAccess(null); this.sendUpdatePacket(false); return;
	}

	public void delConnection(BlockPos start, BlockPos end){
		Connection[] conns = connections.get(start);
		if(conns != null){
			int j = -1;
			for(int i = 0; i < conns.length; i++){
				if(conns[i].getBeginning().equals(start) && conns[i].getDestination().equals(end)){
					i = j; break;
				}
				if(conns[i].getDestination().equals(start) && conns[i].getBeginning().equals(end)){
					i = j; break;
				}
			}
			if(j != -1){
				connections.put(start, remove(conns, j));
			}
		}
		conns = connections.get(end);
		if(conns != null){
			int j = -1;
			for(int i = 0; i < conns.length; i++){
				if(conns[i].getBeginning().equals(start) && conns[i].getDestination().equals(end)){
					i = j; break;
				}
				if(conns[i].getDestination().equals(start) && conns[i].getBeginning().equals(end)){
					i = j; break;
				}
			}
			if(j != -1){
				connections.put(end, remove(conns, j));
			}
		}
		this.updateAccess(null); this.sendUpdatePacket(false);
	}

	private Connection[] remove(Connection[] conns, int j){
		if(conns.length <= 1) return new Connection[0];
		Connection[] newconns = new Connection[conns.length - 1];
		int c = 0; for(int i = 0; i < conns.length; i++){
			if(i == j) continue; newconns[c++] = conns[i];
		}
		return newconns;
	}

	private Connection[] addnew(Connection[] conns, Connection conn){
		if(conns == null || conns.length <= 0) return new Connection[]{ conn };
		Connection[] newconns = new Connection[conns.length + 1];
		for(int i = 0; i < conns.length; i++){
			newconns[i] = conns[i];
		} newconns[newconns.length - 1] = conn;
		return newconns;
	}

	public void addConnection(Connection conn){
		connections.put(conn.getBeginning(), addnew(connections.get(conn.getBeginning()), conn));
		this.updateAccess(null); this.sendUpdatePacket(false); return;
	}

	public void updateAccess(Long date){
		this.lastaccessed = date == null ? Time.getDate() : date;
	}

	public boolean isSameRegion(RailRegion reg){
		if(x == reg.x && z == reg.z) return true;
		return this.equals(reg);
	}

	public Entry<BlockPos, Connection[]> getEntry(BlockPos pos){
		for(Entry<BlockPos, Connection[]> entry : connections.entrySet()){
			if(entry.getKey().equals(pos)) return entry;
		} return null;
	}
	
}