package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;

public class FloatAttribute extends Attribute<Float> {

	public FloatAttribute(String id, Float initvalue){
		super(id, Type.FLOAT, initvalue);
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagFloat(initial ? init() : value());
	}

	@Override
	protected Float readValue(NBTBase basetag){
		try{
			return ((NBTPrimitive)basetag).getFloat();
		}
		catch(Exception e){
			e.printStackTrace();
			return 0f;
		}
	}

	@Override
	public Attribute<Float> copy(String origin){
		return new FloatAttribute(id(), init()).setMinMax(min(), max()).setValue(value())// .setSeat(seat())
			.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
	}

	@Override
	public int getIntegerValue(){
		return (int)+value();
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
		return value() == 0f ? null : value() > 0;
	}

	@Override
	public void increase(int amount){
		this.increase(amount + 0f);
	}

	@Override
	public void increase(float amount){
		this.setValue(value() + amount);
	}

	@Override
	public void decrease(int amount){
		this.decrease(amount + 0f);
	}

	@Override
	public void decrease(float amount){
		this.setValue(value() - amount);
	}

	@Override
	public void validate(){
		if(value() > max()) setValue(max());
		if(value() < min()) setValue(min());
	}

	@Override
	public Vec3f getVectorValue(){
		return new Vec3f(value());
	}

}
