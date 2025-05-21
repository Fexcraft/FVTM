package net.fexcraft.mod.fvtm.sys.rail.cmd;

import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.SignalType;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;

public class CMD_SetSignal extends JEC {
	
	private QV3D signal;
	private byte state;
	private int timed;

	public CMD_SetSignal(String label, EntryDirection dir, QV3D optional, byte state, int timed, String[] targets){
		super(label, JECType.SET_SIGNAL, dir, targets); signal = optional; this.state = state; this.timed = timed;
	}

	public CMD_SetSignal(TagCW compound){
		super(compound);
	}

	@Override
	public JEC copy(){
		return new CMD_SetSignal(write(null));
	}

	@Override
	public TagCW writeData(){
		TagCW compound = signal == null ? TagCW.create() : signal.write(null, null);
		compound.set("state", state); if(timed > 0) compound.set("timed", timed);
		return compound;
	}

	@Override
	public void readData(TagCW com){
		if(com.has("vec_pos")) signal = new QV3D(com, "vec_pos");
		state = com.getByte("state");
		timed = com.has("timed") ? com.getInteger("timed") : 0;
	}

	@Override
	public void processEntity(RailEntity entity){
		return;//this is not an entity command.
	}

	@Override
	public void processSwitch(RailEntity entity, Junction junction, PathKey track, int index, boolean applystate){
		if(junction.type.isStraight() && type == JECType.SET_SIGNAL){
			if(signal == null){
				//if(!junction.signal.is(SignalType.Kind.CUSTOM)) return;
				//TODO set signal state
			}
			else{
				//TODO set remote signal state
			}
		}
	}
	
}
