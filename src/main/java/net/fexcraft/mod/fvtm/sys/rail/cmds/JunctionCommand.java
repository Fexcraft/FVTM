package net.fexcraft.mod.fvtm.sys.rail.cmds;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.Track.TrackKey;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

/**
 * First Prototype of Junction Commands.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class JunctionCommand {
	
	protected JCType type;
	protected EntryDirection diron;
	protected ArrayList<String> targets = new ArrayList<>();
	protected String label;
	//
	/** For in-vehicle instances, how many ticks passed since last call. */
	protected int interval;
	
	public JunctionCommand(String label, JCType type, EntryDirection dir, String... targets){
		this.type = type; for(String str : targets) this.targets.add(str); this.diron = dir; this.label = label;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Type", type.name());
		NBTTagList list = new NBTTagList();
		for(String str : targets){
			list.appendTag(new NBTTagString(str));
		} compound.setTag("Targets", list);
		compound.setTag("Data", writeData());
		compound.setByte("EntryDir", (byte)diron.ordinal());
		compound.setString("Label", label);
		return compound;
	}
	
	public JunctionCommand(NBTTagCompound compound){
		type = JCType.valueOf(compound.getString("Type"));
		NBTTagList list = (NBTTagList)compound.getTag("Targets");
		for(NBTBase base : list){ targets.add(((NBTTagString)base).getString()); }
		readData(compound.getTag("Data"));
		diron = EntryDirection.values()[compound.getByte("EntryDir")];
		label = compound.getString("Label");
	}
	
	public abstract JunctionCommand copy();
	
	public abstract NBTBase writeData();
	
	public abstract void readData(NBTBase base);
	
	/** Called from RailEntities in their update method. */
	public abstract void processEntity(RailEntity entity);

	/** Called from Junctions when something asks for the next Track. */
	public abstract void processSwitch(RailEntity entity, Junction junction, TrackKey track, int index, boolean applystate);

	public boolean isTarget(RailEntity entity){
		if(targets.isEmpty()) return true; String id = "id:" + entity.uid;
		for(String str : targets){
			if(entity.lines.contains(str) || id.equals(id)){// || entity.vehdata.getType().getRegistryName().toString().equals(id))
				return true;
			}
		} return false;
	}

	public boolean isDone(){
		return interval <= -1;
	}

}
