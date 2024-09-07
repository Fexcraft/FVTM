package net.fexcraft.mod.fvtm.sys.rail.cmds;

import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class CMD_ChangeDirection extends JEC {

	public CMD_ChangeDirection(String label, EntryDirection dir, String[] targets){
		super(label, JECType.REVERSE, dir, targets);
	}
	
	/*public CMD_ChangeDirection(String label, EntryDirection dir){
		super(label, JECType.REVERSE, dir, new String[]{});
	}*/

	public CMD_ChangeDirection(TagCW compound){
		super(compound);
	}

	@Override
	public JEC copy(){
		return new CMD_ChangeDirection(write(null));
	}

	@Override
	public TagCW writeData(){
		return TagCW.create();
	}

	@Override
	public void readData(TagCW base){
		//
	}

	@Override
	public void processEntity(RailEntity entity){
		entity.setForward(null, !entity.isHeadingForward()); interval = -1; return;
	}

	@Override
	public void processSwitch(RailEntity entity, Junction junction, PathKey track, int index, boolean applystate){
		//this is not a junction command.
	}
	
}
