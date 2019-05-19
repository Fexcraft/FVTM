package net.fexcraft.mod.fvtm.data.root;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Third prototype.
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Attribute {

	public static final Comparator<Modifier> MODIFIER_COMPARATOR = new Comparator<Modifier>() {
        @Override public int compare(Modifier m0, Modifier m1){ return m0.priority.compareTo(m1.priority); }
    };
    //
	protected TreeSet<Modifier> modifiers = new TreeSet<>(MODIFIER_COMPARATOR);
	protected float max, min;
	protected boolean original;
	protected String id, target;
	protected ValueType valuetype;
	
	public Attribute(boolean notcopy, String id, ValueType type){
		this.original = notcopy; this.id = id; this.valuetype = type;
		this.min = Integer.MIN_VALUE; this.max = Integer.MAX_VALUE;
	}
	
	public Attribute setMinMax(float min, float max){
		this.min = min; this.max = max; return this;
	}
	
	public Attribute setTarget(String string){
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
	//
	public abstract boolean getInitialBoolean();
	public abstract boolean getBaseBoolean();
	public abstract boolean getCurrentBoolean();
	
	public float getMin(){ return min; }
	public float getMax(){ return max; }
	public String getId(){ return id; }
	public String getTarget(){ return target; }
	public TreeSet<Modifier> getModifiers(){ return modifiers; }
	public ValueType getValueType(){ return valuetype; }
	//
	public abstract <T> Attribute setBaseValue(T value);
	public abstract <T> Attribute setCurrentValue(T value);
	public abstract Attribute resetCurrentValue();
	public abstract Attribute resetBaseValue();
	
	public abstract Attribute copy();
	
	public boolean isNumberBased(){
		return !this.valuetype.isString();
	}
	
	/** @param bool null if both, true if base, false if current */
	public Attribute updateValue(UpdateCall calltype, Boolean bool){
		if(bool == null || bool){
			for(Modifier mod : modifiers){
				if(!mod.validCall(calltype, true)) continue;
				this.setBaseValue(mod.modify(this, true, calltype));
			}
		}
		if(bool == null || !bool){
			for(Modifier mod : modifiers){
				if(!mod.validCall(calltype, false)) continue;
				this.setCurrentValue(mod.modify(this, false, calltype));
			}
		}
		return this;
	}
	
	public static enum UpdateCall {
		INSTALL, UNINSTALL, LOGICLOOP, MANUAL
	}
	
	public static enum ValueType {
		STRING, INTEGER, FLOAT, BOOLEAN;

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
		public boolean isBoolean(){ return this == BOOLEAN; }
		public boolean isNumber(){ return this.isInteger() || this.isFloat() || this.isBoolean(); }
		
	}
	
	public static class Value<T> {
		
		public final ValueType type;
		public T value;
		
		public Value(T value){
			this.type = ValueType.findOut(value); this.value = value;
		}
		
		public Value<T> set(T newval){ this.value = newval; return this;}
		
	}

	public void addModifier(Modifier copy){
		if(copy.getValueType() != this.valuetype) return; this.modifiers.add((Modifier)copy);
	}
	
	public static class StringAttribute extends Attribute {
		
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

		@Override public boolean getInitialBoolean(){ return Boolean.parseBoolean(initial); }
		@Override public boolean getBaseBoolean(){ return Boolean.parseBoolean(base); }
		@Override public boolean getCurrentBoolean(){ return Boolean.parseBoolean(current); }

		@Override
		public <T> Attribute setBaseValue(T value){
			if(value instanceof String) base = (String) value; return this;
		}

		@Override
		public <T> Attribute setCurrentValue(T value){
			if(value instanceof String) current = (String) value; return this;
		}

		@Override
		public Attribute resetCurrentValue(){
			this.current = base; return this;
		}

		@Override
		public Attribute resetBaseValue(){
			this.base = initial; return this;
		}

		@Override
		public Attribute copy(){
			return new StringAttribute(false, id, initial).setBaseValue(base).setCurrentValue(current).setTarget(target);
		}
		
	}
	
	public static class IntegerAttribute extends Attribute {
		
		private int initial, base, current;
		protected boolean isbool;

		public IntegerAttribute(boolean notcopy, String id, int value){
			super(notcopy, id, ValueType.INTEGER); this.initial = base = current = value;
		}

		/** Will be a BOOLEAN type if setting @param isbool as true. */
		public IntegerAttribute(boolean notcopy, String id, int value, boolean isbool){
			super(notcopy, id, isbool ? ValueType.BOOLEAN : ValueType.INTEGER);
			this.initial = base = current = isbool ? (value < 0 ? 0 : value > 1 ? 1 : value) : value;
			if(this.isbool = isbool) this.setMinMax(0, 1);
		}
		
		private String stateString(int i){
			if(i == 0) return initial == 1 ? "true" : "false";
			if(i == 1) return base == 1 ? "true" : "false";
			if(i == 2) return current == 1 ? "true" : "false";
			return "error";
		}

		@Override public String getInitialString(){ return isbool ? stateString(0) : initial + ""; }
		@Override public String getBaseString(){ return isbool ? stateString(1) : base + ""; }
		@Override public String getCurrentString(){ return isbool ? stateString(2) : current + ""; }

		@Override public float getInitialFloat(){ return initial; }
		@Override public float getBaseFloat(){ return base; }
		@Override public float getCurrentFloat(){ return current; }

		@Override public int getInitialInteger(){ return initial; }
		@Override public int getBaseInteger(){ return base; }
		@Override public int getCurrentInteger(){ return current; }

		@Override public boolean getInitialBoolean(){ return initial == 1; }
		@Override public boolean getBaseBoolean(){ return base == 1; }
		@Override public boolean getCurrentBoolean(){ return current == 1; }

		@Override
		public <T> Attribute setBaseValue(T value){
			Integer val = value instanceof Number ? (int)value : null; if(val == null) return this;
			if(val > max) base = (int)max; else if(val < min) base = (int)min; else base = val; return this;
		}

		@Override
		public <T> Attribute setCurrentValue(T value){
			Integer val = value instanceof Number ? (int)value : null; if(val == null) return this;
			if(val > max) current = (int)max; else if(val < min) current = (int)min; else current = val; return this;
		}

		@Override
		public Attribute resetCurrentValue(){
			this.current = base; return this;
		}

		@Override
		public Attribute resetBaseValue(){
			this.base = initial; return this;
		}

		@Override
		public Attribute copy(){
			return new IntegerAttribute(false, id, initial, isbool).setBaseValue(base).setCurrentValue(current).setMinMax(min, max).setTarget(target);
		}
		
	}
	
	public static class FloatAttribute extends Attribute {
		
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

		@Override public boolean getInitialBoolean(){ return initial > 0.5f; }
		@Override public boolean getBaseBoolean(){ return base > 0.5f; }
		@Override public boolean getCurrentBoolean(){ return current > 0.5f; }

		@Override
		public <T> Attribute setBaseValue(T value){
			Float val = value instanceof Float ? (float)value : null; if(val == null) return this;
			if(val > max) base = (int)max; else if(val < min) base = (int)min; else base = val; return this;
		}

		@Override
		public <T> Attribute setCurrentValue(T value){
			Float val = value instanceof Float ? (float)value : null; if(val == null) return this;
			if(val > max) current = (int)max; else if(val < min) current = (int)min; else current = val; return this;
		}

		@Override
		public Attribute resetCurrentValue(){
			this.current = base; return this;
		}

		@Override
		public Attribute resetBaseValue(){
			this.base = initial; return this;
		}

		@Override
		public Attribute copy(){
			return new FloatAttribute(false, id, initial).setBaseValue(base).setCurrentValue(current).setMinMax(min, max).setTarget(target);
		}
		
	}

}
