package net.fexcraft.mod.fvtm.data.attribute;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;

public class TriStateAttribute extends Attribute<Boolean> {

	public TriStateAttribute(String id, Boolean initial_value){
		super(id, Type.TRISTATE, initial_value);
	}
	
	public TriStateAttribute(String id, JsonObject obj){
		super(id, Type.TRISTATE, !obj.has("value") || obj.get("value").getAsString().equals("null") ? null : obj.get("value").getAsBoolean());
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		Boolean bool = initial ? init() : value();
		return new NBTTagByte(bool == null ? -1 : bool ? (byte)1 : (byte)0);
	}

	@Override
	protected Boolean readValue(NBTBase basetag){
		byte val = ((NBTPrimitive)basetag).getByte();
		return val < 0 ? null : val > 0;
	}

	@Override
	public Attribute<Boolean> copy(String origin){
		return new TriStateAttribute(id(), init()).setMinMax(min(), max()).setValue(value())// .setSeat(seat())
			.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
	}

	@Override
	public int getIntegerValue(){
		return value() == null ? -1 : value() ? 1 : 0;
	}

	@Override
	public float getFloatValue(){
		return value() == null ? -1 : value() ? 1 : 0;
	}

	@Override
	public String getStringValue(){
		return value() + "";
	}

	@Override
	public boolean getBooleanValue(){
		return value() == null ? false : value();
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