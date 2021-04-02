package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;

public class IntegerAttribute extends Attribute<Integer> {

	public IntegerAttribute(String id, Integer initvalue){
		super(id, Type.INTEGER, initvalue);
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagInt(initial ? init() : value());
	}

	@Override
	protected Integer readValue(NBTBase basetag){
		try{
			return ((NBTPrimitive)basetag).getInt();
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Attribute<Integer> copy(String origin){
		return new IntegerAttribute(id(), init()).setMinMax(min(), max()).setValue(value())// .setSeat(seat())
			.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
	}

	@Override
	public int getIntegerValue(){
		return value();
	}

	@Override
	public float getFloatValue(){
		return value();
	}

	@Override
	public String getStringValue(){
		return value() + "";
	}

	@Override
	public boolean getBooleanValue(){
		return value() > 0;
	}

	@Override
	public Boolean getTriStateValue(){
		return value() == 0 ? null : value() > 0;
	}

	@Override
	public void increase(float amount){
		this.increase((int)amount);
	}

	@Override
	public void increase(int amount){
		this.setValue(value() + amount);
	}

	@Override
	public void decrease(float amount){
		this.decrease((int)amount);
	}

	@Override
	public void decrease(int amount){
		this.setValue(value() - amount);
	}

	@Override
	public void validate(){
		if((Object)value() instanceof Float) setValue(((Float)(Object)value()).intValue());
		if(value() > max()){
			setValue(((Float)max()).intValue());
		}
		if(value() < min()){
			setValue(((Float)min()).intValue());
		}
	}

	@Override
	public Vec3f getVectorValue(){
		return new Vec3f(value());
	}

}