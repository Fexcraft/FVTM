package net.fexcraft.mod.fvtm.sys.rail.cmds;

import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class CMD_SignalWait extends JEC {
	
	private Junction junction;

	public CMD_SignalWait(String label, Junction junction, EntryDirection dir){
		super(label, JECType.SIGNAL_WAIT, dir, new String[0]); this.junction = junction;
	}

	public CMD_SignalWait(TagCW compound){
		super(compound);
	}

	@Override
	public JEC copy(){
		return new CMD_SignalWait(write(null));
	}

	@Override
	public TagCW writeData(){
		return junction.getVec316f().write(null, null);
	}

	@Override
	public void readData(TagCW base){
		//TODO
	}

	@Override
	public void processEntity(RailEntity entity){
		if(junction == null || !entity.isPaused()){ entity.setPaused(false); interval = -1; return; }
		junction.pollSignal(entity); interval++;
		if(junction.getSignalState(this.diron)){ entity.setPaused(false); interval = -1; return; }
	}

	@Override
	public void processSwitch(RailEntity entity, Junction junction, PathKey track, int index, boolean applystate){
		//this is not a junction command.
	}
	
}
