package net.fexcraft.mod.fvtm.data.root;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Third prototype.
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class AttributeNew {

	public static final Comparator<ModifierNew> MODIFIER_COMPARATOR = new Comparator<ModifierNew>() {
        @Override public int compare(ModifierNew m0, ModifierNew m1){ return m0.priority.compareTo(m1.priority); }
    };
    //
	protected TreeSet<ModifierNew> modifiers = new TreeSet<>(MODIFIER_COMPARATOR);
	protected float max, min;
	protected boolean original;
	protected String id, target;
	protected ValueType valuetype;
	
	public AttributeNew(boolean notcopy, String id, ValueType type){
		this.original = notcopy; this.id = id; this.valuetype = type;
	}
	
	public AttributeNew setMinMax(float min, float max){
		this.min = min; this.max = max; return this;
	}
	
	public AttributeNew setTarget(String string){
		this.target = string; return this;
	}

	public abstract String getInitialString();
	public abstract String getBaseString();
	public abstract String getCurrentString();
	//
	public abstract float getInitialFloat();
	public abstract float getBaseFloat();
	public abstract float getCurrentFloat();
	//
	public abstract int getInitialInteger();
	public abstract int getBaseInteger();
	public abstract int getCurrentInteger();
	
	public float getMin(){ return min; }
	public float getMax(){ return max; }
	public String getId(){ return id; }
	public String getTarget(){ return target; }
	public TreeSet<ModifierNew> getModifiers(){ return modifiers; }
	public ValueType getValueType(){ return valuetype; }
	//
	public abstract <T> AttributeNew setBaseValue(T value);
	public abstract <T> AttributeNew setCurrentValue(T value);
	public abstract AttributeNew resetCurrentValue();
	public abstract AttributeNew resetBaseValue();
	
	public abstract AttributeNew copy();
	
	public boolean isNumberBased(){
		return !this.valuetype.isString();
	}
	
	/** @param bool null if both, true if base, false if current */
	public AttributeNew updateValue(UpdateCall calltype, Boolean bool){
		if(bool == null || bool){
			for(ModifierNew mod : modifiers){
				if(!mod.validCall(calltype, true)) continue;
				this.setBaseValue(mod.modify(this, true, calltype));
			}
		}
		if(bool == null || !bool){
			for(ModifierNew mod : modifiers){
				if(!mod.validCall(calltype, false)) continue;
				this.setCurrentValue(mod.modify(this, false, calltype));
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

		public boolean isFloat(){ return this == FLOAT; }
		public boolean isString(){ return this == STRING; }
		public boolean isInteger(){ return this == INTEGER; }
	}
	
	public static class Value<T> {
		
		public final ValueType type;
		public T value;
		
		public Value(T value){
			this.type = ValueType.findOut(value); this.value = value;
		}
		
		public Value<T> set(T newval){ this.value = newval; return this;}
		
	}

	public void addModifier(ModifierNew copy){
		if(copy.getValueType() != this.valuetype) return; this.modifiers.add((ModifierNew)copy);
	}
	
	public static class StringAttribute extends AttributeNew {
		
		private String initial, base, current;

		public StringAttribute(boolean notcopy, String id, String value){
			super(notcopy, id, ValueType.STRING); this.initial = base = current = value;
		}

		@Override public String getInitialString(){ return initial; }
		@Override public String getBaseString(){ return base; }
		@Override public String getCurrentString(){ return current; }

		@Override public float getInitialFloat(){ return 0; }
		@Override public float getBaseFloat(){ return 0; }
		@Override public float getCurrentFloat(){ return 0; }

		@Override public int getInitialInteger(){ return 0; }
		@Override public int getBaseInteger(){ return 0; }
		@Override public int getCurrentInteger(){ return 0; }

		@Override
		public <T> AttributeNew setBaseValue(T value){
			if(value instanceof String) base = (String) value; return this;
		}

		@Override
		public <T> AttributeNew setCurrentValue(T value){
			if(value instanceof String) current = (String) value; return this;
		}

		@Override
		public AttributeNew resetCurrentValue(){
			this.current = base; return this;
		}

		@Override
		public AttributeNew resetBaseValue(){
			this.base = initial; return this;
		}

		@Override
		public AttributeNew copy(){
			return new StringAttribute(original, id, initial).setBaseValue(base).setCurrentValue(current).setTarget(target);
		}
		
	}
	
	public static class IntegerAttribute extends AttributeNew {
		
		private int initial, base, current;

		public IntegerAttribute(boolean notcopy, String id, int value){
			super(notcopy, id, ValueType.INTEGER); this.initial = base = current = value;
		}

		@Override public String getInitialString(){ return initial + ""; }
		@Override public String getBaseString(){ return base + ""; }
		@Override public String getCurrentString(){ return current + ""; }

		@Override public float getInitialFloat(){ return initial; }
		@Override public float getBaseFloat(){ return base; }
		@Override public float getCurrentFloat(){ return current; }

		@Override public int getInitialInteger(){ return initial; }
		@Override public int getBaseInteger(){ return base; }
		@Override public int getCurrentInteger(){ return current; }

		@Override
		public <T> AttributeNew setBaseValue(T value){
			Integer val = value instanceof Number ? (int)value : null; if(val == null) return this;
			if(val > max) base = (int)max; else if(val < min) base = (int)min; else base = val; return this;
		}

		@Override
		public <T> AttributeNew setCurrentValue(T value){
			Integer val = value instanceof Number ? (int)value : null; if(val == null) return this;
			if(val > max) current = (int)max; else if(val < min) current = (int)min; else current = val; return this;
		}

		@Override
		public AttributeNew resetCurrentValue(){
			this.current = base; return this;
		}

		@Override
		public AttributeNew resetBaseValue(){
			this.base = initial; return this;
		}

		@Override
		public AttributeNew copy(){
			return new IntegerAttribute(original, id, initial).setBaseValue(base).setCurrentValue(current).setMinMax(min, max).setTarget(target);
		}
		
	}
	
	public static class FloatAttribute extends AttributeNew {
		
		private float initial, base, current;

		public FloatAttribute(boolean notcopy, String id, float value){
			super(notcopy, id, ValueType.FLOAT); this.initial = base = current = value;
		}

		@Override public String getInitialString(){ return initial + ""; }
		@Override public String getBaseString(){ return base + ""; }
		@Override public String getCurrentString(){ return current + ""; }

		@Override public float getInitialFloat(){ return initial; }
		@Override public float getBaseFloat(){ return base; }
		@Override public float getCurrentFloat(){ return current; }

		@Override public int getInitialInteger(){ return (int)initial; }
		@Override public int getBaseInteger(){ return (int)base; }
		@Override public int getCurrentInteger(){ return (int)current; }

		@Override
		public <T> AttributeNew setBaseValue(T value){
			Float val = value instanceof Number ? (float)value : null; if(val == null) return this;
			if(val > max) base = (int)max; else if(val < min) base = (int)min; else base = val; return this;
		}

		@Override
		public <T> AttributeNew setCurrentValue(T value){
			Float val = value instanceof Number ? (float)value : null; if(val == null) return this;
			if(val > max) current = (int)max; else if(val < min) current = (int)min; else current = val; return this;
		}

		@Override
		public AttributeNew resetCurrentValue(){
			this.current = base; return this;
		}

		@Override
		public AttributeNew resetBaseValue(){
			this.base = initial; return this;
		}

		@Override
		public AttributeNew copy(){
			return new FloatAttribute(original, id, initial).setBaseValue(base).setCurrentValue(current).setMinMax(min, max).setTarget(target);
		}
		
	}

}
