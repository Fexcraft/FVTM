package net.fexcraft.mod.fvtm.data.root;

import java.util.Comparator;
import java.util.TreeSet;

public class Attribute<T> {

	public static final Comparator<Modifier<?>> MODIFIER_COMPARATOR = new Comparator<Modifier<?>>() {
        @Override public int compare(Modifier<?> m0, Modifier<?> m1){ return m0.priority.compareTo(m1.priority); }
    };
    //
	protected TreeSet<Modifier<T>> modifiers = new TreeSet<>(MODIFIER_COMPARATOR);
	protected T initial, base, current;
	protected float max, min;
	protected boolean original;
	protected String id, target;
	protected ValueType valuetype;
	
	public Attribute(boolean notcopy, String id, T value){
		this.original = notcopy; this.id = id; this.initial = this.base = this.current = value;
		this.valuetype = ValueType.findOut(value);
	}
	
	public Attribute<T> setMinMax(float min, float max){
		this.min = min; this.max = max; return this;
	}
	
	public Attribute<T> setTarget(String string){
		this.target = string; return this;
	}

	@SuppressWarnings("unchecked")
	public <U> U getCastedBaseValue(){ return (U)base; }
	@SuppressWarnings("unchecked")
	public <U> U getCastedCurrentValue(){ return (U)current; }
	@SuppressWarnings("unchecked")
	public <U> U getCastedInitialValue(){ return (U)initial; }
	@SuppressWarnings("unchecked")
	public <U> U getCastedValue(boolean baseval){ return (U)(baseval ? base : current); }
	
	public T getBaseValue(){ return base; }
	public T getCurrentValue(){ return current; }
	public T getInitialValue(){ return initial; }
	public T getValue(boolean baseval){ return baseval ? base : current; }
	public float getMin(){ return min; }
	public float getMax(){ return max; }
	public String getId(){ return id; }
	public String getTarget(){ return target; }
	public TreeSet<Modifier<T>> getModifiers(){ return modifiers; }
	public ValueType getValueType(){ return valuetype; }
	//
	public Attribute<T> setBaseValue(T value){
		this.base = value; return this;
	}
	public Attribute<T> setCurrentValue(T value){
		this.current = value; return this;
	}
	public Attribute<T> resetCurrentValue(){
		this.current = this.base; return this;
	}
	public Attribute<T> resetBaseValue(){
		this.base = this.initial; return this;
	}
	
	public Attribute<T> copy(){
		Attribute<T> attr = new Attribute<T>(false, id, initial).setBaseValue(base).setCurrentValue(current).setTarget(target).setMinMax(min, max);
		for(Modifier<T> mod : modifiers){ attr.getModifiers().add(mod.copy()); } return attr;
	}
	
	@SuppressWarnings("unchecked")
	/** @param bool null if both, true if base, false if current */
	public Attribute<T> updateValue(UpdateCall calltype, Boolean bool){
		if(bool == null || bool){
			for(Modifier<T> mod : modifiers){
				if(!mod.validCall(calltype, true)) continue;
				this.base = mod.modify(this, true, calltype);
				if(this.valuetype != ValueType.STRING){
					float base = this.getCastedBaseValue();
					if(base > max) this.setBaseValue((T)(Object)max);
					if(base < min) this.setBaseValue((T)(Object)min);
				}
			}
		}
		if(bool == null || !bool){
			for(Modifier<T> mod : modifiers){
				if(!mod.validCall(calltype, false)) continue;
				this.current = mod.modify(this, false, calltype);
				if(this.valuetype != ValueType.STRING){
					float curr = this.getCastedCurrentValue();
					if(curr > max) this.setCurrentValue((T)(Object)max);
					if(curr < min) this.setCurrentValue((T)(Object)min);
				}
			}
		}
		return this;
	}
	
	public static enum UpdateCall {
		INSTALL, /*UNINSTALL,*/ LOGICLOOP, MANUAL
	}
	
	public static enum ValueType {
		STRING, INTEGER, FLOAT;//, BOOLEAN;

		public static ValueType findOut(Object value){
			if(value instanceof String) return STRING;
			if(value instanceof Float) return FLOAT;
			if(value instanceof Integer) return INTEGER;
			//if(value instanceof Boolean) return BOOLEAN;
			return FLOAT;
		}
	}

	@SuppressWarnings("unchecked")
	public void addModifier(Modifier<?> copy){
		if(copy.getValueType() != this.valuetype) return; this.modifiers.add((Modifier<T>)copy);
	}

}
