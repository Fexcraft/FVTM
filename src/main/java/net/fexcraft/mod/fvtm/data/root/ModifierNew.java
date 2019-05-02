package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.data.root.AttributeNew.UpdateCall;
import net.fexcraft.mod.fvtm.data.root.AttributeNew.ValueType;

/**
 * Third prototype.
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class ModifierNew {
	
	protected String id, target;
	protected UpdateCall calltype;
	protected Priority priority;
	protected ValueType valuetype;
	protected boolean basemod;
	protected Type type;
	
	public ModifierNew(String id, ValueType valtype, boolean basemodifier, Type type, UpdateCall call, Priority priority){
		this.id = id; this.basemod = basemodifier; this.type = type;
		this.calltype = call; this.priority = priority;
		this.valuetype = valtype;
	}

	public abstract ModifierNew copy();
	public String getTarget(){ return target; }
	public ModifierNew setTarget(String string){ this.target = string; return this; }
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
	public <T> T modify(AttributeNew attr, boolean base, UpdateCall calltype){
		switch(valuetype){
			case FLOAT: case INTEGER:{
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
	
	public static class StringModifier extends ModifierNew {
		
		protected String value;

		public StringModifier(String id, String value, boolean basemodifier, Type type, UpdateCall call, Priority priority){
			super(id, ValueType.STRING, basemodifier, type, call, priority); this.value = value;
		}

		@Override
		public ModifierNew copy(){
			return new StringModifier(id, value, basemod, type, calltype, priority).setTarget(target);
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
	
	public static class IntegerModifier extends ModifierNew {

		protected int value;
		
		public IntegerModifier(String id, int value, boolean basemodifier, Type type, UpdateCall call, Priority priority){
			super(id, ValueType.INTEGER, basemodifier, type, call, priority); this.value = value;
		}

		@Override
		public ModifierNew copy(){
			return new IntegerModifier(id, value, basemod, type, calltype, priority).setTarget(target);
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
	
	public static class FloatModifier extends ModifierNew {

		protected float value;
		
		public FloatModifier(String id, float value, boolean basemodifier, Type type, UpdateCall call, Priority priority){
			super(id, ValueType.FLOAT, basemodifier, type, call, priority); this.value = value;
		}

		@Override
		public ModifierNew copy(){
			return new FloatModifier(id, value, basemod, type, calltype, priority).setTarget(target);
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
