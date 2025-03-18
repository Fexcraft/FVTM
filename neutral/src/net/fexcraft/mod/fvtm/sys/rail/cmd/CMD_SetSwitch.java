package net.fexcraft.mod.fvtm.sys.rail.cmd;

import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.JuncType;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;

public class CMD_SetSwitch extends JEC {
	
	private QV3D junction;
	private byte entry, state;

	public CMD_SetSwitch(String label, EntryDirection dir, byte entry, byte state, String junction, String[] targets){
		super(label, JECType.SET_STATE, dir, targets); this.entry = entry; this.state = state;
		this.junction = junction == null || junction.length() == 0 || junction.equals("this") ? null : QV3D.fromIDString(junction);
	}

	public CMD_SetSwitch(TagCW compound){
		super(compound);
	}

	@Override
	public JEC copy(){
		return new CMD_SetSwitch(write(null));
	}

	@Override
	public TagCW writeData(){
		/*if(junction == null){
			return new NBTTagByteArray(new byte[]{ entry, state });
		}
		NBTTagCompound compound = new NBTTagCompound();
		compound.setByteArray("State", new byte[]{ entry, state });
		compound.setString("Junction", junction.asIDString());
		return compound;*///TODO
		return TagCW.create();
	}

	@Override
	public void readData(TagCW base){
		/*byte[] arr = null;
		if(base instanceof NBTTagCompound){
			NBTTagCompound compound = (NBTTagCompound)base;
			junction = QV3D.fromIDString(compound.getString("Junction"));
			arr = compound.getByteArray("State");
		}
		else{
			try{ arr = ((NBTTagByteArray)base).getByteArray(); } catch(Exception e){ e.printStackTrace(); }
		}
		//
		entry = arr[0]; state = arr[1];*///TODO
	}

	@Override
	public void processEntity(RailEntity entity){
		return;//this is not an entity command.
	}

	@Override
	public void processSwitch(RailEntity entity, Junction junction, PathKey track, int index, boolean applystate){
		if(index != entry) return;
		if(this.junction != null){
			junction = junction.root.getJunction(this.junction.pos);
			if(junction == null) return;
		}
		if(!junction.type.isStraight() && index == entry){
			if(junction.type.isSwitch()){
				if(junction.type == JuncType.FORK_2){
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
