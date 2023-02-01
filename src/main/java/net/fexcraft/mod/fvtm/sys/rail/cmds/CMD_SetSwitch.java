package net.fexcraft.mod.fvtm.sys.rail.cmds;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.uni.PathJuncType;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagCompound;

public class CMD_SetSwitch extends JEC {
	
	private GridV3D junction;
	private byte entry, state;

	public CMD_SetSwitch(String label, EntryDirection dir, byte entry, byte state, @Nullable String junction, String[] targets){
		super(label, JECType.SET_STATE, dir, targets); this.entry = entry; this.state = state;
		this.junction = junction == null || junction.length() == 0 || junction.equals("this") ? null : GridV3D.fromIDString(junction, true);
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
		if(junction == null){
			return new NBTTagByteArray(new byte[]{ entry, state });
		}
		NBTTagCompound compound = new NBTTagCompound();
		compound.setByteArray("State", new byte[]{ entry, state });
		compound.setString("Junction", junction.asIDString());
		return compound;
	}

	@Override
	public void readData(NBTBase base){
		byte[] arr = null;
		if(base instanceof NBTTagCompound){
			NBTTagCompound compound = (NBTTagCompound)base;
			junction = GridV3D.fromIDString(compound.getString("Junction"));
			arr = compound.getByteArray("State");
		}
		else{
			try{ arr = ((NBTTagByteArray)base).getByteArray(); } catch(Exception e){ e.printStackTrace(); }
		}
		//
		entry = arr[0]; state = arr[1];
	}

	@Override
	public void processEntity(RailEntity entity){
		return;//this is not an entity command.
	}

	@Override
	public void processSwitch(RailEntity entity, Junction junction, PathKey track, int index, boolean applystate){
		if(index != entry) return;
		if(this.junction != null){
			junction = junction.root.getJunction(this.junction);
			if(junction == null) return;
		}
		if(!junction.type.isStraight() && index == entry){
			if(junction.type.isSwitch()){
				if(junction.type == PathJuncType.FORK_2){
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
