package net.fexcraft.mod.fvtm.sys.rail.cmds;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

/**
 * First Prototype of Junction Commands.
 * Edit: "Junction and Entity Command"
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
//@Deprecated
public abstract class JEC {
	
	protected JECType type;
	protected EntryDirection diron;
	protected ArrayList<String> targets = new ArrayList<>();
	protected String label;
	//
	/** For in-vehicle instances, how many ticks passed since last call. */
	protected int interval;
	
	public JEC(String label, JECType type, EntryDirection dir, String... targets){
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
		compound.setInteger("Interval", interval);
		compound.setString("Label", label);
		return compound;
	}
	
	public JEC(NBTTagCompound compound){
		type = JECType.valueOf(compound.getString("Type"));
		NBTTagList list = (NBTTagList)compound.getTag("Targets");
		for(NBTBase base : list){ targets.add(((NBTTagString)base).getString()); }
		readData(compound.getTag("Data"));
		diron = EntryDirection.values()[compound.getByte("EntryDir")];
		interval = compound.getInteger("Interval");
		label = compound.getString("Label");
	}
	
	public static JEC read(NBTTagCompound compound){
		if(compound == null || !compound.hasKey("Type")) return null;
		JECType type = JECType.valueOf(compound.getString("Type"));
		if(type == null) return null;
		try{
			return type.getJCClass().getConstructor(NBTTagCompound.class).newInstance(compound);
		} catch(Exception e){ e.printStackTrace(); return null; }
	}
	
	public abstract JEC copy();
	
	public abstract NBTBase writeData();
	
	public abstract void readData(NBTBase base);
	
	/** Called from RailEntities in their update method. @returns true if the command is done and should be removed, false otherwise */
	public abstract void processEntity(RailEntity entity);

	/** Called from Junctions when something asks for the next Track. */
	public abstract void processSwitch(RailEntity entity, Junction junction, PathKey track, int index, boolean applystate);

	public boolean isTarget(RailEntity entity){
		if(targets.isEmpty()) return true; String id = "id:" + entity.uid;
		for(String str : targets){
			if(entity.lines.contains(str) || id.equals(str)){// || entity.vehdata.getType().getRegistryName().toString().equals(id))
				return true;
			}
		} return false;
	}
	
	//@Deprecated
	public boolean isDone(){
		return interval <= -1;
	}

}
