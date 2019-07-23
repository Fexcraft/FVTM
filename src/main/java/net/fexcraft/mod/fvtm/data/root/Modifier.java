package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.data.root.Attribute.Type;
import net.fexcraft.mod.fvtm.data.root.Attribute.Update;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;

/**
 * 4th prototype.
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Modifier<V> {

	protected String id, target, origin;
	protected Update calltype;
	protected Priority priority;
	protected ModifierType mtype;
	protected Type type;
	protected V value;
	
	public Modifier(String id, Type type, ModifierType mtype, Update call, Priority priority){
		this.id = id; this.type = type; this.mtype = mtype; this.calltype = call; this.priority = priority;
	}

	public String id(){ return id; }
	public String target(){ return target; }
	public String origin(){ return origin; }
	public Update update(){ return calltype; }
	public Priority priority(){ return priority; }
	public ModifierType modifertype(){ return mtype; }
	public Type type(){ return type; }
	//
	public Modifier<V> setTarget(String string){ target = string; return this; }
	public Modifier<V> setOrigin(String string){ origin = string; return this; }
	public Modifier<V> setValue(V newval){ value = newval; return this; }
	//
	public abstract int getIntegerValue();
	public abstract float getFloatValue();
	public abstract String getStringValue();
	
	public static enum ModifierType {
		OVERRIDE, ADDITIVE, PROCENT_ADD, PROCENT_DEC, PROCENT_SET, OPPOSITE, OTHER
	}
	
	public static enum Priority {
		VERYHIGH, HIGH, NORMAL, LOW, VERYLOW
	}

	public NBTTagCompound write(NBTTagCompound compound){
		compound.setString("id", id);
		compound.setString("valuetype", type.name());
		if(target != null) compound.setString("target", target);
		if(origin != null) compound.setString("origin", origin);
		compound.setString("calltype", calltype.name());
		compound.setString("priority", priority.name());
		compound.setString("type", mtype.name());
		compound.setTag("value", this.writeValue());
		return compound;
	}
	
	protected abstract NBTBase writeValue();
	
	public Modifier<?> read(NBTTagCompound compound){
		id = compound.getString("id");
		type = Type.valueOf(compound.getString("valuetype"));
		if(compound.hasKey("target")) this.target = compound.getString("target");
		if(compound.hasKey("origin")) this.origin = compound.getString("origin");
		calltype = Update.valueOf(compound.getString("calltype"));
		priority = Priority.valueOf(compound.getString("priority"));
		mtype = ModifierType.valueOf(compound.getString("type"));
		if(compound.hasKey("value")) value = this.readValue(compound.getTag("value"));
		return this;
	}
	
	protected abstract V readValue(NBTBase basetag);

	public static Modifier<?> parse(NBTTagCompound compound){
		Modifier<?> mod = null; Type type = Type.valueOf(compound.getString("valuetype"));
		switch(type){
			case BOOLEAN: break;
			case BOOL_ARRAY: break;
			case FLOAT: mod = new FloatModifier(null, 0, null, null, null); break;
			case FLOAT_ARRAY: break;
			case INTEGER: mod = new IntegerModifier(null, 0, null, null, null); break;
			case INT_ARRAY: break;
			case OBJECT: break;
			case STRING: mod = new StringModifier(null, "", null, null, null); break;
			case STRING_ARRAY: break;
			default: break;
		} mod.read(compound); return mod;
	}

	@SuppressWarnings("unchecked")
	public <VL> VL modify(Attribute<VL> attribute, Update call){
		switch(type){
			case FLOAT: case INTEGER: case BOOLEAN: {
				float result = attribute.getFloatValue();
				float value = type.isFloat() ? this.getFloatValue() : this.getIntegerValue();
				switch(mtype){
					case ADDITIVE: result += value; break;
					case OPPOSITE: result = -result; break;
					case OVERRIDE: result = value; break;
					case PROCENT_ADD: result += result * 0.01f * value; break;
					case PROCENT_DEC: result -= result * 0.01f * value; break;
					case PROCENT_SET: result  = result * 0.01f * value; break;
					default: return null;
				}
				return (VL)(Object)(type.isInteger() ? (int)result : result);
			}
			case STRING:{
				String val = attribute.getStringValue();
				String value = this.getStringValue();
				switch(mtype){
					case ADDITIVE: return (VL)(val + value);
					case OPPOSITE: return (VL)reverseText(val);
					case OVERRIDE: return (VL)value;
					default: return (VL)val;
				}
			}
			case BOOL_ARRAY: break;
			case FLOAT_ARRAY: break;
			case INT_ARRAY: break;
			case OBJECT: break;
			case STRING_ARRAY: break;
			default: break;
		} return null;
	}
	
	private String reverseText(String val){
		char[] arr = val.toCharArray(); String result = "";
		for(int i = arr.length - 1; i > 0; i--){ result += arr[i]; }
		return result;
	}

	public abstract Modifier<?> copy(String origin);
	
	//
	
	public static class StringModifier extends Modifier<String> {

		public StringModifier(String id, String value, ModifierType type, Update call, Priority priority){
			super(id, Type.STRING, type, call, priority); this.value = value;
		}

		@Override
		public Modifier<String> copy(String origin){
			return new StringModifier(id, value, mtype, calltype, priority).setTarget(target).setOrigin(origin);
		}

		@Override
		public float getFloatValue(){
			return 0f;
		}

		@Override
		public String getStringValue(){
			return value;
		}

		@Override
		public int getIntegerValue(){
			return 0;
		}

		@Override
		protected NBTBase writeValue(){
			return new NBTTagString(value);
		}

		@Override
		protected String readValue(NBTBase basetag){
			return ((NBTTagString)basetag).getString();
		}
		
	}
	
	public static class IntegerModifier extends Modifier<Integer> {
		
		public IntegerModifier(String id, int value, ModifierType type, Update call, Priority priority){
			super(id, Type.INTEGER, type, call, priority); this.value = value;
		}

		@Override
		public Modifier<Integer> copy(String origin){
			return new IntegerModifier(id, value, mtype, calltype, priority).setTarget(target).setOrigin(origin);
		}

		@Override
		public float getFloatValue(){
			return value;
		}

		@Override
		public String getStringValue(){
			return value + "";
		}

		@Override
		public int getIntegerValue(){
			return value;
		}

		@Override
		protected NBTBase writeValue(){
			return new NBTTagInt(value);
		}

		@Override
		protected Integer readValue(NBTBase basetag){
			return ((NBTTagInt)basetag).getInt();
		}
		
	}
	
	public static class FloatModifier extends Modifier<Float> {
		
		public FloatModifier(String id, float value, ModifierType type, Update call, Priority priority){
			super(id, Type.FLOAT, type, call, priority); this.value = value;
		}

		@Override
		public Modifier<Float> copy(String origin){
			return new FloatModifier(id, value, mtype, calltype, priority).setTarget(target).setOrigin(origin);
		}

		@Override
		public float getFloatValue(){
			return value;
		}

		@Override
		public String getStringValue(){
			return value + "";
		}

		@Override
		public int getIntegerValue(){
			return (int) + value;
		}

		@Override
		protected NBTBase writeValue(){
			return new NBTTagFloat(value);
		}

		@Override
		protected Float readValue(NBTBase basetag){
			return ((NBTTagFloat)basetag).getFloat();
		}
		
	}

}
