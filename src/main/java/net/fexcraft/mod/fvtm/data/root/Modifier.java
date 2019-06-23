package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.data.root.Attribute.UpdateCall;
import net.fexcraft.mod.fvtm.data.root.Attribute.ValueType;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Third prototype.
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Modifier {
	
	protected String id, target, origin;
	protected UpdateCall calltype;
	protected Priority priority;
	protected ValueType valuetype;
	protected boolean basemod;
	protected Type type;
	
	public Modifier(String id, ValueType valtype, boolean basemodifier, Type type, UpdateCall call, Priority priority){
		this.id = id; this.basemod = basemodifier; this.type = type;
		this.calltype = call; this.priority = priority;
		this.valuetype = valtype;
	}

	public abstract Modifier copy(String origin);
	public String getTarget(){ return target; }
	public String getOrigin(){ return origin; }
	public Modifier setTarget(String string){ this.target = string; return this; }
	public Modifier setOrigin(String string){ this.origin = string; return this; }
	public String getId(){ return id; }
	public Type getType(){ return type; }
	public Priority getPriority(){ return priority; }
	public ValueType getValueType(){ return valuetype; }
	public UpdateCall getUpdateType(){ return calltype; }

	public abstract int getIntegerValue();
	public abstract float getFloatValue();
	public abstract String getStringValue();

	public NBTTagCompound write(NBTTagCompound com){
		com.setString("id", id); com.setBoolean("basemod", basemod);
		com.setString("valuetype", valuetype.name());
		if(target != null) com.setString("target", target);
		if(origin != null) com.setString("origin", origin);
		com.setString("calltype", calltype.name());
		com.setString("priority", priority.name());
		com.setString("type", type.name());
		switch(valuetype){
			case BOOLEAN: com.setBoolean("value", this.getIntegerValue() != 0); break;
			case FLOAT: com.setFloat("value", getFloatValue()); break;
			case INTEGER: com.setInteger("value", getIntegerValue()); break;
			case STRING: com.setString("value", getStringValue()); break;
			default: return null;
		} return com;
	}

	public Modifier read(NBTTagCompound com){
		id = com.getString("id"); basemod = com.getBoolean("basemod");
		valuetype = ValueType.valueOf(com.getString("valuetype"));
		if(com.hasKey("target")) this.target = com.getString("target");
		if(com.hasKey("origin")) this.origin = com.getString("origin");
		calltype = UpdateCall.valueOf(com.getString("calltype"));
		priority = Priority.valueOf(com.getString("priority"));
		type = Type.valueOf(com.getString("type"));
		switch(valuetype){
			case BOOLEAN: ((IntegerModifier)this).value = com.getBoolean("value") ? 1 : 0; break;
			case FLOAT: ((FloatModifier)this).value = com.getFloat("value"); break;
			case INTEGER: ((IntegerModifier)this).value = com.getInteger("value"); break;
			case STRING: ((StringModifier)this).value = com.getString("value"); break;
			default: return null;
		} return this;
	}

	public static Modifier parse(NBTTagCompound com){
		Modifier mod = null; ValueType type = ValueType.valueOf(com.getString("valuetype"));
		switch(type){
			case BOOLEAN: mod = new IntegerModifier(null, 0, false, null, null, null); break;
			case FLOAT: mod = new FloatModifier(null, 0, false, null, null, null); break;
			case INTEGER: mod = new IntegerModifier(null, 0, false, null, null, null); break;
			case STRING: mod = new StringModifier(null, null, false, null, null, null); break;
			default: return null;
		} mod.read(com); return mod;
	}

	public boolean validCall(UpdateCall call, boolean base){
		return calltype == call && base == basemod;
	}

	@SuppressWarnings("unchecked")
	public <T> T modify(Attribute attr, boolean base, UpdateCall calltype){
		switch(valuetype){
			case FLOAT: case INTEGER: case BOOLEAN: {
				float result = base ? attr.getBaseFloat() : attr.getCurrentFloat();
				float value = valuetype.isFloat() ? this.getFloatValue() : this.getIntegerValue();
				switch(type){
					case ADDITIVE: result += value; break;
					case OPPOSITE: result = -result; break;
					case OVERRIDE: result = value; break;
					case PROCENT_ADD: result += result * 0.01f * value; break;
					case PROCENT_DEC: result -= result * 0.01f * value; break;
					case PROCENT_SET: result  = result * 0.01f * value; break;
				}
				return (T)(Object)(valuetype.isInteger() ? (int)result : result);
			}
			case STRING:{
				String val = base ? attr.getBaseString() : attr.getCurrentString();
				String value = this.getStringValue();
				switch(type){
					case ADDITIVE: return (T)(val + value);
					case OPPOSITE: return (T)reverseText(val);
					case OVERRIDE: return (T)value;
					default: return (T)val;
				}
			}
		} return null;
	}
	
	private String reverseText(String val){
		char[] arr = val.toCharArray(); String result = "";
		for(int i = arr.length - 1; i > 0; i--){ result += arr[i]; }
		return result;
	}

	public static enum Type {
		OVERRIDE, ADDITIVE, PROCENT_ADD, PROCENT_DEC, PROCENT_SET, OPPOSITE
	}
	
	public static enum Priority {
		VERYHIGH, HIGH, NORMAL, LOW, VERYLOW
	}
	
	public static class StringModifier extends Modifier {
		
		protected String value;

		public StringModifier(String id, String value, boolean basemodifier, Type type, UpdateCall call, Priority priority){
			super(id, ValueType.STRING, basemodifier, type, call, priority); this.value = value;
		}

		@Override
		public Modifier copy(String origin){
			return new StringModifier(id, value, basemod, type, calltype, priority).setTarget(target).setOrigin(origin);
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
		
	}
	
	public static class IntegerModifier extends Modifier {

		protected int value;
		
		public IntegerModifier(String id, int value, boolean basemodifier, Type type, UpdateCall call, Priority priority){
			super(id, ValueType.INTEGER, basemodifier, type, call, priority); this.value = value;
		}

		@Override
		public Modifier copy(String origin){
			return new IntegerModifier(id, value, basemod, type, calltype, priority).setTarget(target).setOrigin(origin);
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
		
	}
	
	public static class FloatModifier extends Modifier {

		protected float value;
		
		public FloatModifier(String id, float value, boolean basemodifier, Type type, UpdateCall call, Priority priority){
			super(id, ValueType.FLOAT, basemodifier, type, call, priority); this.value = value;
		}

		@Override
		public Modifier copy(String origin){
			return new FloatModifier(id, value, basemod, type, calltype, priority).setTarget(target).setOrigin(origin);
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
			return (int)value;
		}
		
	}
	
}
