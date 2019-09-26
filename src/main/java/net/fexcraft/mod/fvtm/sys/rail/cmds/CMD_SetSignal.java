package net.fexcraft.mod.fvtm.sys.rail.cmds;

import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.SignalType;
import net.fexcraft.mod.fvtm.sys.rail.Track.TrackKey;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class CMD_SetSignal extends JEC {
	
	private Vec316f signal;
	private byte state;
	private int timed;

	public CMD_SetSignal(String label, JECType type, EntryDirection dir, Vec316f optional, byte state, int timed, String[] targets){
		super(label, JECType.SET_SIGNAL, dir, targets); signal = optional; this.state = state; this.timed = timed;
	}

	public CMD_SetSignal(NBTTagCompound compound){
		super(compound);
	}

	@Override
	public JEC copy(){
		return new CMD_SetSignal(write(null));
	}

	@Override
	public NBTBase writeData(){
		NBTTagCompound compound = signal == null ? new NBTTagCompound() : signal.write();
		compound.setByte("state", state); if(timed > 0) compound.setInteger("timed", timed);
		return compound;
	}

	@Override
	public void readData(NBTBase base){
		NBTTagCompound compound = (NBTTagCompound)base;
		if(compound.hasKey("vec_pos")) signal = new Vec316f(compound);
		state = compound.getByte("state"); timed = compound.hasKey("timed") ? compound.getInteger("timed") : 0;
	}

	@Override
	public boolean processEntity(RailEntity entity){
		return false;//this is not an entity command.
	}

	@Override
	public void processSwitch(RailEntity entity, Junction junction, TrackKey track, int index, boolean applystate){
		if(junction.type.isStraight() && type == JECType.SET_SIGNAL){
			if(signal == null){
				if(!junction.signal.is(SignalType.Kind.CUSTOM)) return;
				//TODO set signal state
			}
			else{
				//TODO set remote signal state
			}
		}
	}
	
}
