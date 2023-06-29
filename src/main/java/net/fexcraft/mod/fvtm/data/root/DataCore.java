package net.fexcraft.mod.fvtm.data.root;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.ContentType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public abstract class DataCore<TYPE extends TypeCore<TYPE>, SELF> {
	
	protected TYPE type;
	
	public DataCore(TYPE type){
		this.type = type;
	}
	
	//General Wellbeing
	
	public abstract NBTTagCompound write(NBTTagCompound compound);
	
	public abstract SELF read(NBTTagCompound compound);
	
	public abstract SELF parse(JsonObject obj);
	
	public abstract JsonObject toJson();
	
	//
	
	public TYPE getType(){ return type; }
	
	public ContentType getDataType(){
		return type.getDataType();
	}
	
	public static interface DataCoreItem<SELF> {
		
		public SELF getData(ItemStack stack);
		
		public SELF getData(NBTTagCompound compound);
		
	}
	
}