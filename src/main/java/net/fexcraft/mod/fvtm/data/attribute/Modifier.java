package net.fexcraft.mod.fvtm.data.attribute;

import javax.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 5th prototype.
 * 
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Modifier<VT> {

	protected String id, target, origin;
	protected AttrUpdate calltype;
	protected ModifierPriority priority;
	protected ModifierType mtype;
	protected Attribute<?> attr;
	protected VT value;

	public Modifier(String id, ModifierType mtype, AttrUpdate call, ModifierPriority priority){
		this.id = id;
		this.mtype = mtype;
		this.calltype = call;
		this.priority = priority;
	}

	public String id(){
		return id;
	}

	public String target(){
		return target;
	}

	public String origin(){
		return origin;
	}

	public AttrUpdate update(){
		return calltype;
	}

	public ModifierPriority priority(){
		return priority;
	}

	public ModifierType type(){
		return mtype;
	}
	
	public Modifier<VT> taget(String string){
		target = string;
		return this;
	}

	public Modifier<VT> origin(String string){
		origin = string;
		return this;
	}

	public <VAL> Modifier<VT> value(VAL object){
		value = (VT)object;
		return this;
	}

	protected abstract String impl();
	
	//
	
	public abstract int integer_value();

	public abstract float float_value();

	public abstract String string_value();
	
	public abstract boolean valid_valuetype(ValueType type);
	
	public VT value(){
		return value;
	}
	
	public <VAL> VAL value_c(){
		return (VAL)value();
	}

	public abstract VT parseValue(JsonElement elm);
	
	public abstract VT parseValue(String str);
	
	//

	public NBTTagCompound write(NBTTagCompound compound){
		compound.setString("id", id);
		if(target != null) compound.setString("target", target);
		if(origin != null) compound.setString("origin", origin);
		compound.setString("calltype", calltype.name());
		compound.setString("priority", priority.name());
		compound.setString("type", mtype.name());
		compound.setString("impl", impl());
		compound.setTag("value", this.writeValue());
		return compound;
	}

	protected abstract NBTBase writeValue();

	public Modifier<?> read(NBTTagCompound compound){
		id = compound.getString("id");
		if(compound.hasKey("target")) this.target = compound.getString("target");
		if(compound.hasKey("origin")) this.origin = compound.getString("origin");
		calltype = AttrUpdate.valueOf(compound.getString("calltype"));
		priority = ModifierPriority.valueOf(compound.getString("priority"));
		mtype = ModifierType.valueOf(compound.getString("type"));
		if(compound.hasKey("value")) value = this.readValue(compound.getTag("value"));
		return this;
	}

	protected abstract VT readValue(NBTBase basetag);

	public static Modifier<?> parse(NBTTagCompound compound){
		Class<? extends Modifier<?>> clazz = Resources.getModifierImpl(compound.hasKey("impl") ? compound.getString("impl") : "float");
		if(clazz == null) return null;
		Modifier<?> mod;
		try{
			mod = clazz.getConstructor(String.class, ModifierType.class, AttrUpdate.class, ModifierPriority.class).newInstance(null, null, null, null);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		mod.read(compound);
		return mod;
	}

	public abstract <VL> VL modify(VehicleData data, @Nullable VehicleEntity ent, Attribute<VL> attribute, AttrUpdate call);

	public Modifier<VT> copy(String origin){
		Modifier<VT> copy = copyNewInstance();
		return copy.taget(target).origin(origin).value(value());
	}

	protected abstract Modifier<VT> copyNewInstance();

	//

	public static Modifier<?> parse(JsonObject obj){
		String impl = obj.has("impl") ? obj.get("impl").getAsString() : "float";
		Class<? extends Modifier<?>> clazz = Resources.getModifierImpl(impl);
		if(clazz == null) return null;
		Modifier<?> mod;
		try{
			String id = obj.get("id").getAsString();
			ModifierType type = ModifierType.valueOf(obj.get("type").getAsString().toUpperCase());
			AttrUpdate update = obj.has("update") ? AttrUpdate.valueOf(obj.get("update").getAsString().toUpperCase()) : AttrUpdate.INITIAL;
			ModifierPriority priority = ModifierPriority.valueOf(obj.get("priority").getAsString().toUpperCase());
			mod = clazz.getConstructor(String.class, ModifierType.class, AttrUpdate.class, ModifierPriority.class).newInstance(id, type, update, priority);
			if(obj.has("target")) mod.taget(obj.get("target").getAsString());
			if(obj.has("value")) mod.value(mod.parseValue(obj.get("value")));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return mod;
	}

}
