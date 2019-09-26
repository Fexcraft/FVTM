package net.fexcraft.mod.fvtm.sys.rail.cmds;

import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.JunctionType;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.Track.TrackKey;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagCompound;

public class CMD_SetSwitch extends JEC {
	
	private byte entry, state;

	public CMD_SetSwitch(String label, EntryDirection dir, byte entry, byte state, String[] targets){
		super(label, JECType.SET_STATE, dir, targets); this.entry = entry; this.state = state;
	}

	public CMD_SetSwitch(NBTTagCompound compound){
		super(compound);
	}

	@Override
	public JEC copy(){
		return new CMD_SetSwitch(write(null));
	}

	@Override
	public NBTBase writeData(){
		return new NBTTagByteArray(new byte[]{ entry, state });
	}

	@Override
	public void readData(NBTBase base){
		try{
			byte[] arr = ((NBTTagByteArray)base).getByteArray();
			entry = arr[0]; state = arr[1];
		} catch(Exception e){ e.printStackTrace(); }
	}

	@Override
	public boolean processEntity(RailEntity entity){
		return false;//this is not an entity command.
	}

	@Override
	public void processSwitch(RailEntity entity, Junction junction, TrackKey track, int index, boolean applystate){
		if(!junction.type.isStraight() && type == JECType.SET_STATE && index == entry){
			if(junction.type.isSwitch()){
				if(junction.type == JunctionType.FORK_2){
					junction.switch0 = state == 1;
				}
				else{
					junction.switch0 = state == 0;
					junction.switch1 = state == 2;
				}
			}
			if(junction.type.isDouble()){
				if(index == 0 || index == 3){
					junction.switch1 = state == 1;
				}
				else{
					junction.switch1 = state == 1;
				}
			}
		}
	}

}
