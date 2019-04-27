package net.fexcraft.mod.fvtm.data.root;

import net.fexcraft.mod.fvtm.data.root.Attribute.UpdateCall;
import net.fexcraft.mod.fvtm.data.root.Attribute.ValueType;

public class Modifier<T> {
	
	protected String id, target;
	protected UpdateCall calltype;
	protected Priority priority;
	protected ValueType valuetype;
	//protected boolean original;
	protected boolean basemod;
	protected Type type;
	protected T value;
	
	public Modifier(String id, T value, boolean basemodifier, Type type, UpdateCall call, Priority priority){
		this.id = id; this.value = value; this.basemod = basemodifier;
		this.valuetype = ValueType.findOut(value); this.type = type;
		this.calltype = call; this.priority = priority;
	}

	public Modifier<T> copy(){
		return new Modifier<T>(id, value, basemod, type, calltype, priority).setTarget(target);
	}

	public String getTarget(){ return target; }
	public Modifier<T> setTarget(String string){
		this.target = string; return this;
	}
	
	public String getId(){ return id; }
	public T getValue(){ return value; }
	public Type getType(){ return type; }
	public Priority getPriority(){ return priority; }
	public ValueType getValueType(){ return valuetype; }
	public UpdateCall getUpdateType(){ return calltype; }

	public boolean validCall(UpdateCall call, boolean base){
		return calltype == call && base == basemod;
	}
	
	@SuppressWarnings("unchecked")
	public <U> U getCastedValue(){ return (U)value; }

	@SuppressWarnings("unchecked")
	public T modify(Attribute<T> attr, boolean base, UpdateCall calltype){
		switch(valuetype){
			case FLOAT: case INTEGER:{
				float result = attr.getCastedValue(base);
				float value = getCastedValue();
				switch(type){
					case ADDITIVE: result += value; break;
					case OPPOSITE: result = -result; break;
					case OVERRIDE: result = value; break;
					case PROCENT_ADD: result += result * 0.01f * value; break;
					case PROCENT_DEC: result -= result * 0.01f * value; break;
					case PROCENT_SET: result  = result * 0.01f * value; break;
				}
				return (T)(Object)(valuetype == ValueType.INTEGER ? (int)result : result);
			}
			case STRING:{
				String val = attr.getCastedValue(base);
				String value = getCastedValue();
				switch(type){
					case ADDITIVE: return (T)(val + value);
					case OPPOSITE: return reverseText(val);
					case OVERRIDE: return (T)value;
					default: return attr.getValue(base);
				}
			}
		} return value;
	}
	
	@SuppressWarnings("unchecked")
	private T reverseText(String val){
		char[] arr = val.toCharArray(); String result = "";
		for(int i = arr.length - 1; i > 0; i--){ result += arr[i]; }
		return (T)result;
	}

	public static enum Type {
		OVERRIDE, ADDITIVE, PROCENT_ADD, PROCENT_DEC, PROCENT_SET, OPPOSITE
	}
	
	public static enum Priority {
		VERYHIGH, HIGH, NORMAL, LOW, VERYLOW
	}

}
