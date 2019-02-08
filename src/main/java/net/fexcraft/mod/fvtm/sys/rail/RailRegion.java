package net.fexcraft.mod.fvtm.sys.rail;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailDataSerializer;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailImpl;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

/** @author Ferdinand Calo' (FEX___96) **/
public class RailRegion {
	
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
		Print.debug("x" + x + ", z" + z + " |L| " + junctions);
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
		Print.debug("x" + x + ", z" + z + " |S| " + junctions);
	}

	public void updateAccess(Long date){
		this.lastaccessed = date == null ? Time.getDate() : date;
	}

	public boolean isSameRegion(RailRegion reg){
		if(x == reg.x && z == reg.z) return true;
		return this.equals(reg);
	}

	public void toggleSwitch(BlockPos pos, boolean type){
		Junction junk = this.junctions.get(pos); if(junk == null) return;
		if(type) junk.switch1 = !junk.switch1;
			else junk.switch0 = !junk.switch0;
		this.sendUpdatePacket(false);//TODO specialized packet
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