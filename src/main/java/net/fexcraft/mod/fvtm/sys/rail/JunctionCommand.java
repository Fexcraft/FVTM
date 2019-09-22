package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

/**
 * First Prototype of Junction Commands.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class JunctionCommand {
	
	public static enum JCType {
		
		SIGNAL_WAIT(20),//check if signal changed once per second
		GOTO(-1),//path finding, only search if in need
		REVERSE(0),//apply instantly, remove command afterwards
		STOP(0),//apply instantly (decrease throttle to 0), remove command afterwards
		WAIT(20),//check every second if time passed
		ADJUST_SPEED(1),//apply instantly, remove command afterwards
		CHANGE_ATTRIBUTE(20),//check once per second (?), remove command afterwards
		;
		
		public final int interval;
		
		JCType(int interval){ this.interval = interval; }
		
	}
	
	private JCType type;
	private ArrayList<String> targets = new ArrayList<>();
	private NBTTagCompound compound;
	private NBTPrimitive primitive;
	private NBTTagString string;
	private NBTBase data;
	//
	/** For in-vehicle instances, how many ticks passed since last call. */
	private int interval;
	
	public JunctionCommand(JCType type, NBTBase data, String... targets){
		this.type = type; for(String str : targets) this.targets.add(str); this.data = data;
		if(data instanceof NBTTagCompound) compound = (NBTTagCompound)data;
		if(data instanceof NBTPrimitive) primitive = (NBTPrimitive)data;
		if(data instanceof NBTTagString) string = (NBTTagString)data;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Type", type.name());
		NBTTagList list = new NBTTagList();
		for(String str : targets){
			list.appendTag(new NBTTagString(str));
		} compound.setTag("Targets", list);
		compound.setTag("Data", compound);
		return compound;
	}
	
	public JunctionCommand(NBTTagCompound compound){
		type = JCType.valueOf(compound.getString("Type"));
		NBTTagList list = (NBTTagList)compound.getTag("Targets");
		for(NBTBase base : list){ targets.add(((NBTTagString)base).getString()); }
		data = compound.getTag("Data");
		if(data instanceof NBTTagCompound) compound = (NBTTagCompound)data;
		if(data instanceof NBTPrimitive) primitive = (NBTPrimitive)data;
		if(data instanceof NBTTagString) string = (NBTTagString)data;
	}
	
	public NBTBase getNBTData(){
		return data;
	}
	
	public NBTPrimitive getNBTPrimitive(){
		return primitive;
	}
	
	public NBTTagString getNBTString(){
		return string;
	}
	
	public NBTTagCompound getNBTCompound(){
		return compound;
	}
	
	public void process(RailEntity entity){
		
	}

}
