package net.fexcraft.mod.fvtm.prototype;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class RailRegion {
	
	private ArrayList<Connection> connections = new ArrayList<>();
	public long lastaccessed;
	private boolean wasempty;
	private int x, z;
	
	public RailRegion(WorldRailUtil data, int x, int z){
		File file = this.getFile(data, x, z);
		NBTTagCompound compound = null; this.x = x; this.z = z;
		if(!file.exists()){ file.getParentFile().mkdirs(); }
		else{
			try{ compound = CompressedStreamTools.read(file); }
			catch(IOException e){ e.printStackTrace(); }
		}
		if(compound == null) compound = new NBTTagCompound();
		if(compound.hasKey("Connections")){
			NBTTagList list = (NBTTagList)compound.getTag("Connections");
			for(int i = 0; i < list.tagCount(); i++){
				try{
					connections.add(new Connection().read((NBTTagCompound)list.get(i)));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		} else wasempty = true;
		this.lastaccessed = compound.hasKey("LastUse") ? compound.getLong("LastUse") : Time.getDate();
	}

	private File getFile(WorldRailUtil data, int x, int z){
		return new File(data.getRootFile(), "/railregions/" + x + "_" + z + ".nbt");
	}

	public void save(WorldRailUtil data){
		if(wasempty && connections.isEmpty()) return;
		NBTTagCompound compound = new NBTTagCompound();
		compound.setLong("LastUse", this.lastaccessed);
		NBTTagList list = new NBTTagList();
		for(Connection conn : connections){
			list.appendTag(conn.write(new NBTTagCompound()));
		}
		compound.setTag("Connections", list);
		compound.setInteger("RegionX", x);
		compound.setInteger("RegionZ", z);
		try{
			CompressedStreamTools.write(compound, this.getFile(data, x, z));
		}
		catch(IOException e){
			Print.log("FAILED TO WRITE RAIL REGION, THIS IS SEVERE.");
			Print.log(compound); e.printStackTrace();
		}
	}

	public Connection[] getConnectionsAt(BlockPos pos){
		return (Connection[])connections.stream().filter(pre -> pre.getBeginning().equals(pos) || pre.getDestination().equals(pos)).toArray();
	}
	
}