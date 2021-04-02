package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;

public class BooleanAttribute extends Attribute<Boolean> {

	public BooleanAttribute(String id, Boolean initvalue){
		super(id, Type.BOOLEAN, initvalue);
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		return new NBTTagByte((initial ? init() : value()) ? (byte)1 : (byte)0);
	}

	@Override
	protected Boolean readValue(NBTBase basetag){
		return ((NBTPrimitive)basetag).getByte() > 0;
	}

	@Override
	public Attribute<Boolean> copy(String origin){
		return new BooleanAttribute(id(), init()).setMinMax(min(), max()).setValue(value())// .setSeat(seat())
			.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
	}

	@Override
	public int getIntegerValue(){
		return value() ? 1 : 0;
	}

	@Override
	public float getFloatValue(){
		return value() ? 1 : 0;
	}

	@Override
	public String getStringValue(){
		return value() + "";
	}

	@Override
	public boolean getBooleanValue(){
		return value();
	}

	@Override
	public Boolean getTriStateValue(){
		return value();
	}

	@Override
	public Vec3f getVectorValue(){
		return new Vec3f(getIntegerValue());
	}

}