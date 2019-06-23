package net.fexcraft.mod.fvtm.data.root;

import java.util.Comparator;
import java.util.TreeSet;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

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
	protected String id, target, origin, seat;
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
	
	/** Part this originates (is copied) from. */
	public Attribute setOrigin(String string){
		this.origin = string; return this;
	}
	
	public Attribute setSeat(String string){
		this.seat = string; return this;
	}

	public NBTTagCompound write(NBTTagCompound com){
		com.setBoolean("org", original);
		com.setString("id", id);
		com.setString("type", valuetype.name());
		com.setFloat("min", min); com.setFloat("max", max);
		if(target != null) com.setString("target", target);
		if(origin != null) com.setString("origin", origin);
		if(seat != null) com.setString("seat", seat);
		switch(valuetype){
			case BOOLEAN:
				com.setBoolean("initial", getInitialBoolean());
				com.setBoolean("base", getBaseBoolean());
				com.setBoolean("current", getCurrentBoolean());
				break;
			case FLOAT:
				com.setFloat("initial", getInitialFloat());
				com.setFloat("base", getBaseFloat());
				com.setFloat("current", getCurrentFloat());
				break;
			case INTEGER:
				com.setInteger("initial", getInitialInteger());
				com.setInteger("base", getBaseInteger());
				com.setInteger("current", getCurrentInteger());
				break;
			case STRING:
				com.setString("initial", getInitialString());
				com.setString("base", getBaseString());
				com.setString("current", getCurrentString());
				break;
			default: return null;
		}
		if(!modifiers.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(Modifier mod : modifiers) list.appendTag(mod.write(new NBTTagCompound()));
			com.setTag("modifiers", list);
		} return com;
	}

	public Attribute read(NBTTagCompound com){
		original = com.getBoolean("org"); id = com.getString("id");
		min = com.getFloat("min"); max = com.getFloat("max");
		if(com.hasKey("target")) this.target = com.getString("target");
		if(com.hasKey("origin")) this.origin = com.getString("origin");
		if(com.hasKey("seat")) this.seat = com.getString("seat");
		switch(valuetype){
			case BOOLEAN:{
				IntegerAttribute attr = (IntegerAttribute)this;
				attr.initial = com.getBoolean("initial") ? 1 : 0;
				attr.base = com.getBoolean("base") ? 1 : 0;
				attr.current = com.getBoolean("current") ? 1 : 0;
				break;
			}
			case FLOAT:{
				FloatAttribute attr = (FloatAttribute)this;
				attr.initial = com.getFloat("initial");
				attr.base = com.getFloat("base");
				attr.current = com.getFloat("current");
				break;
			}
			case INTEGER:{
				IntegerAttribute attr = (IntegerAttribute)this;
				attr.initial = com.getInteger("initial");
				attr.base = com.getInteger("base");
				attr.current = com.getInteger("current");
				break;
			}
			case STRING:{
				StringAttribute attr = (StringAttribute)this;
				attr.initial = com.getString("initial");
				attr.base = com.getString("base");
				attr.current = com.getString("current");
				break;
			}
			default: return null;
		} modifiers.clear();
		if(com.hasKey("modifiers")){
			NBTTagList list = (NBTTagList)com.getTag("modifiers");
			for(NBTBase base : list) modifiers.add(Modifier.parse((NBTTagCompound)base));
		}
		return this;
	}

	public static Attribute parse(NBTTagCompound com){
		Attribute attr = null; ValueType type = ValueType.valueOf(com.getString("type"));
		switch(type){
			case BOOLEAN: attr = new IntegerAttribute(false, null, 0, true); break;
			case FLOAT: attr = new FloatAttribute(false, null, 0); break;
			case INTEGER: attr = new IntegerAttribute(false, null, 0); break;
			case STRING: attr = new StringAttribute(false, null, null); break;
			default: return null;
		} attr.read(com); return attr;
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
	public String getOrigin(){ return origin; }
	public String getSeat(){ return seat; }
	public TreeSet<Modifier> getModifiers(){ return modifiers; }
	public ValueType getValueType(){ return valuetype; }
	//
	public abstract <T> Attribute setBaseValue(T value);
	public abstract <T> Attribute setCurrentValue(T value);
	public abstract Attribute resetCurrentValue();
	public abstract Attribute resetBaseValue();
	
	public abstract Attribute copy(String origin);
	
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
		INITIAL, LOGICLOOP, MANUAL
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
		public Attribute copy(String origin){
			return new StringAttribute(false, id, initial).setBaseValue(base).setCurrentValue(current)
				.setTarget(target).setOrigin(origin).setSeat(seat);
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
		public Attribute copy(String origin){
			return new IntegerAttribute(false, id, initial, isbool).setBaseValue(base).setCurrentValue(current)
				.setMinMax(min, max).setTarget(target).setOrigin(origin).setSeat(seat);
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
		public Attribute copy(String origin){
			return new FloatAttribute(false, id, initial).setBaseValue(base).setCurrentValue(current)
				.setMinMax(min, max).setTarget(target).setOrigin(origin).setSeat(seat);
		}
		
	}

}
