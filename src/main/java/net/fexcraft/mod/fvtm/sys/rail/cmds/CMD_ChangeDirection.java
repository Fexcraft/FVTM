package net.fexcraft.mod.fvtm.sys.rail.cmds;

import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.Track.TrackKey;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class CMD_ChangeDirection extends JEC {

	public CMD_ChangeDirection(String label, JECType type, EntryDirection dir, String[] targets){
		super(label, JECType.SET_SIGNAL, dir, targets);
	}

	public CMD_ChangeDirection(NBTTagCompound compound){
		super(compound);
	}

	@Override
	public JEC copy(){
		return new CMD_ChangeDirection(write(null));
	}

	@Override
	public NBTBase writeData(){
		return new NBTTagCompound();
	}

	@Override
	public void readData(NBTBase base){
		//
	}

	@Override
	public boolean processEntity(RailEntity entity){
		entity.setForward(null, !entity.isHeadingForward()); return true;
	}

	@Override
	public void processSwitch(RailEntity entity, Junction junction, TrackKey track, int index, boolean applystate){
		//this is not a junction command.
	}
	
}
