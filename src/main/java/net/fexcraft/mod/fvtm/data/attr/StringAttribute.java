package net.fexcraft.mod.fvtm.data.attr;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.minecraft.nbt.NBTBase;

public class StringAttribute extends Attribute<String> {

	public StringAttribute(String id, String initial_value){
		super(id, Attribute.Type.STRING, initial_value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getIntegerValue(){
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFloatValue(){
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getStringValue(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getBooleanValue(){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean getTriStateValue(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vec3f getVectorValue(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected NBTBase writeValue(boolean initial){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String readValue(NBTBase basetag){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attribute<String> copy(String origin){
		// TODO Auto-generated method stub
		return null;
	}

}
