package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.data.root.Attribute.UpdateCall;
import net.fexcraft.mod.fvtm.data.root.Attribute.ValueType;

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
