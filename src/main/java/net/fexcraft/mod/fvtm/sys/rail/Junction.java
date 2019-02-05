package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.mod.fvtm.prototype.WorldRailDataSerializer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Junction {
	
	public Track[] tracks;
	private BlockPos core;
	public boolean switch0, switch1;
	private World world;
	
	public Junction(World world, BlockPos core){
		this.core = core; tracks = new Track[0];
		this.switch0 = this.switch1 = false; this.world = world;
	}
	
	public Junction read(NBTTagCompound compound){
		this.core = BlockPos.fromLong(compound.getLong("Core"));
		this.switch0 = compound.getBoolean("Switch0");
		this.switch1 = compound.getBoolean("Switch1");
		tracks = new Track[compound.getInteger("Tracks")];
		if(tracks.length > 0){
			for(int i = 0; i < tracks.length; i++){
				tracks[i] = new Track().read(compound.getCompoundTag("Track_" + i));
			}
		}
		return this;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(int i = 0; i < tracks.length; i++){
			compound.setTag("Track_" + i, tracks[i].write(null));
		}
		compound.setInteger("Tracks", tracks.length);
		compound.setBoolean("Switch0", switch0);
		compound.setBoolean("Switch1", switch1);
		compound.setLong("Core", core.toLong());
		return compound;
	}
	
	public BlockPos getCore(){
		return core;
	}

	public void addnew(Track track){
		if(tracks.length == 0){
			tracks = new Track[]{ track };
		}
		else{
			Track[] newarr = new Track[tracks.length + 1];
			for(int i = 0; i < tracks.length; i++){
				newarr[i] = tracks[i];
			} newarr[newarr.length - 1] = track; tracks = newarr;
		}
	}
	
	public void remove(Track track, boolean firstcall){
		if(tracks.length <= 1){
			if(tracks.length == 0 || tracks[0].getId().equals(track.getId())){
				tracks = new Track[0];
			}
		}
		else{
			int index = -1, j = 0;
			for(int i = 0; i < tracks.length; i++){
				if(tracks[i] != null && tracks[i].getId().equals(track.getId())){ index = i; break; }
			}
			if(index == -1) return;
			Track[] trecks = new Track[tracks.length - 1];
			for(int i = 0; i < tracks.length; i++){
				if(i != index) trecks[j++] = tracks[i];
			}
		}
		if(firstcall){
			Junction junk = world.getCapability(WorldRailDataSerializer.CAPABILITY, null)
				.getJunctionAt(track.start.equals(core) ? track.end : track.start);
			if(junk != null) junk.remove(track, false);
		}
	}
	
}