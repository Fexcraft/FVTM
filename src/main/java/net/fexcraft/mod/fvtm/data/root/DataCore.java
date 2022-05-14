package net.fexcraft.mod.fvtm.data.root;

import com.google.gson.JsonObject;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public abstract class DataCore<TYPE extends TypeCore<TYPE>, SELF> {
	
	protected TYPE type;
	
	public DataCore(TYPE type){
		this.type = type;
	}
	
	//General Wellbeing
	
	public abstract CompoundTag write(CompoundTag compound);
	
	public abstract SELF read(CompoundTag compound);
	
	public abstract SELF parse(JsonObject obj);
	
	public abstract JsonObject toJson();
	
	//
	
	public TYPE getType(){ return type; }
	
	public DataType getDataType(){
		return type.getDataType();
	}
	
	public static interface DataCoreItem<SELF> {
		
		public SELF getData(ItemStack stack);
		
		public SELF getData(CompoundTag compound);
		
	}
	
}