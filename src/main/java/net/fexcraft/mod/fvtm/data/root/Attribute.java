package net.fexcraft.mod.fvtm.data.root;

import java.util.Comparator;
import java.util.TreeSet;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

/**
 * 4th prototype.
 * @author Ferdinand Calo' (FEX___96)
 */ @SuppressWarnings("unchecked")
public abstract class Attribute<V> {
	 
	public static final Comparator<Modifier<?>> MODIFIER_COMPARATOR = new Comparator<Modifier<?>>() {
		@Override public int compare(Modifier<?> m0, Modifier<?> m1){ return m0.priority.compareTo(m1.priority); }
	};
	private TreeSet<Modifier<V>> modifiers = new TreeSet<>(MODIFIER_COMPARATOR);
	private String id, target, origin, seat;
	private boolean iscopy, editable;
	private float min, max;
	private Type type;
	private V value, init;
	
	public Attribute(boolean original, String id, Type type, V initvalue){
		this.iscopy = !original; this.id = id; this.type = type; init = initvalue; value = init;
	}
	
	public boolean isCopy(){ return iscopy; }
	public boolean editable(){ return editable; }
	//
	public String id(){ return id; }
	public String target(){ return target; }
	public String origin(){ return origin; }
	public String seat(){ return seat; }
	public Type type(){ return type; }
	public float min(){ return min; }
	public float max(){ return max; }
	public V value(){ return value; }
	public V init(){ return init; }
	//
	public <VAL> VAL getValue(){ return (VAL)value; }
	public <VAL> VAL getInitValue(){ return (VAL)init; };
	public <VAL> Attribute<V> setValue(VAL value){ this.value = (V)value; validate(); return this; };
	public <VAL> Attribute<V> setInitValue(VAL value){ this.init = (V)value; validate(); return this; };
	public void increase(int amount){}; public void decrease(int amount){};
	public void increase(float amount){}; public void decrease(float amount){};
	public Attribute<V> reset(){ return setValue(init); };
	protected void validate(){};
	//
	public Attribute<V> setTarget(String string){ this.target = string; return this; }
	public Attribute<V> setOrigin(String string){ this.origin = string; return this; }
	public Attribute<V> setSeat(String string){ this.seat = string; return this; }
	public Attribute<V> setMinMax(float min, float max){ this.min = min; this.max = max; return this; }
	public Attribute<V> setEditable(boolean bool){ this.editable = bool; return this; }
	//
	public Attribute<V> addModifier(Modifier<?> mod){
		if(mod.type() == type() || mod.type().isNumber() == type().isNumber()) modifiers.add((Modifier<V>)mod); return this;
	}
	public TreeSet<Modifier<V>> getModifiers(){ return modifiers; }
	//
	public abstract int getIntegerValue();
	public abstract float getFloatValue();
	public abstract String getStringValue();
	public abstract boolean getBooleanValue();
	
	public Attribute<?> updateValue(Update call){
		for(Modifier<?> mod : modifiers){
			if(mod.update() != call) continue;
			setValue(mod.modify(this, call));
		} return this;
	}
	
	public static enum Type {
		
		STRING, INTEGER, FLOAT, BOOLEAN, STRING_ARRAY, INT_ARRAY, FLOAT_ARRAY, BOOL_ARRAY, OBJECT;
		
		public boolean isString(){ return this == STRING; }
		public boolean isInteger(){ return this == INTEGER; }
		public boolean isFloat(){ return this == FLOAT; }
		public boolean isBoolean(){ return this == BOOLEAN; }
		//
		public boolean isObject(){ return this == OBJECT; }
		public boolean isNumber(){ return this == INTEGER || this == FLOAT || this == BOOLEAN; }
		public boolean isArray(){ return this == STRING_ARRAY || this == INT_ARRAY || this == FLOAT_ARRAY || this == BOOL_ARRAY; }
		//
		public boolean isStringArray(){ return this == STRING_ARRAY; }
		public boolean isIntegerArray(){ return this == INT_ARRAY; }
		public boolean isFloatArray(){ return this == FLOAT_ARRAY; }
		public boolean isBooleanArray(){ return this == BOOL_ARRAY; }
		
		public Object tryParse(String string){
			switch(this){
				case BOOLEAN: return Boolean.parseBoolean(string);
				case BOOL_ARRAY: break;
				case FLOAT: return Float.parseFloat(string);
				case FLOAT_ARRAY: break;
				case INTEGER: return Float.parseFloat(string);
				case INT_ARRAY: break;
				case OBJECT: return null;//TODO
				case STRING: return string;
				case STRING_ARRAY: break;
				default: return null;
			} return null;
		}
		
	}
	
	public static enum Update {
		INITIAL, ENTITY, MANUAL
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		compound.setBoolean("org", !iscopy);
		compound.setString("id", id);
		compound.setString("type", type.name());
		compound.setFloat("min", min); compound.setFloat("max", max);
		if(target != null) compound.setString("target", target);
		if(origin != null) compound.setString("origin", origin);
		if(seat != null) compound.setString("seat", seat);
		compound.setBoolean("editable", editable);
		compound.setTag("initial", this.writeValue(true));
		compound.setTag("value", this.writeValue(false));
		if(!modifiers.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(Modifier<V> mod : modifiers) list.appendTag(mod.write(new NBTTagCompound()));
			compound.setTag("modifiers", list);
		} return compound;
	}
	
	protected abstract NBTBase writeValue(boolean initial);

	public Attribute<?> read(NBTTagCompound compound){
		iscopy = !compound.getBoolean("org"); id = compound.getString("id");
		min = compound.getFloat("min"); max = compound.getFloat("max");
		if(compound.hasKey("target")) this.target = compound.getString("target");
		if(compound.hasKey("origin")) this.origin = compound.getString("origin");
		if(compound.hasKey("seat")) this.seat = compound.getString("seat");
		editable = compound.hasKey("editable") ? compound.getBoolean("editable") : true;
		init = this.readValue(compound.getTag("initial"));
		value = compound.hasKey("value") ? this.readValue(compound.getTag("value")) : init;
		modifiers.clear(); if(compound.hasKey("modifiers")){
			NBTTagList list = (NBTTagList)compound.getTag("modifiers");
			for(NBTBase base : list) modifiers.add((Modifier<V>)Modifier.parse((NBTTagCompound)base));
		} return this;
	}
	
	protected abstract V readValue(NBTBase basetag);

	public static Attribute<?> parse(NBTTagCompound compound){
		Attribute<?> attr = null; Type type = Type.valueOf(compound.getString("type"));
		switch(type){
			case BOOLEAN: attr = new BooleanAttribute(false, null, null);
			case BOOL_ARRAY: break;
			case FLOAT: attr = new FloatAttribute(false, null, null);
			case FLOAT_ARRAY: break;
			case INTEGER: attr = new IntegerAttribute(false, null, null); break;
			case INT_ARRAY: break;
			case OBJECT: break;//TODO
			case STRING: attr = new StringAttribute(false, null,  null); break;
			case STRING_ARRAY: break;
			default: return null;
		} attr.read(compound); return attr;
	}
	
	public abstract Attribute<V> copy(String origin);
	
	public static class StringAttribute extends Attribute<String> {

		public StringAttribute(boolean original, String id, String initvalue){
			super(original, id, Type.STRING, initvalue);
		}

		@Override
		protected NBTBase writeValue(boolean initial){
			return new NBTTagString(initial ? init() : value());
		}

		@Override
		protected String readValue(NBTBase basetag){
			return ((NBTTagString)basetag).getString();
		}

		@Override
		public Attribute<String> copy(String origin){
			return new StringAttribute(false, id(), init()).setMinMax(min(), max()).setValue(value()).setSeat(seat()).setTarget(target()).setOrigin(origin).setEditable(editable());
		}
		
		@Override public int getIntegerValue(){ return 0; }
		@Override public float getFloatValue(){ return 0; }
		@Override public String getStringValue(){ return value(); }
		@Override public boolean getBooleanValue(){ return Boolean.parseBoolean(value()); }
		
	}
	
	public static class FloatAttribute extends Attribute<Float> {

		public FloatAttribute(boolean original, String id, Float initvalue){
			super(original, id, Type.FLOAT, initvalue);
		}

		@Override
		protected NBTBase writeValue(boolean initial){
			return new NBTTagFloat(initial ? init() : value());
		}

		@Override
		protected Float readValue(NBTBase basetag){
			try{ return ((NBTPrimitive)basetag).getFloat(); } catch (Exception e){ e.printStackTrace(); return 0f; }
		}

		@Override
		public Attribute<Float> copy(String origin){
			return new FloatAttribute(false, id(), init()).setMinMax(min(), max()).setValue(value()).setSeat(seat()).setTarget(target()).setOrigin(origin).setEditable(editable());
		}
		
		@Override public int getIntegerValue(){ return (int) + value(); }
		@Override public float getFloatValue(){ return value(); }
		@Override public String getStringValue(){ return value() + ""; }
		@Override public boolean getBooleanValue(){ return value() > 0; }
		
		@Override
		public void increase(int amount){
			this.increase(amount + 0f);
		}
		
		@Override
		public void increase(float amount){
			this.setValue(value() + amount);
		}
		
		@Override
		public void decrease(int amount){
			this.decrease(amount + 0f);
		}
		
		@Override
		public void decrease(float amount){
			this.setValue(value() - amount);
		}
		
		@Override
		public void validate(){
			if(value() > max()) setValue(max()); if(value() < min()) setValue(min());
		}
		
	}
	
	public static class IntegerAttribute extends Attribute<Integer> {

		public IntegerAttribute(boolean original, String id, Integer initvalue){
			super(original, id, Type.INTEGER, initvalue);
		}

		@Override
		protected NBTBase writeValue(boolean initial){
			return new NBTTagInt(initial ? init() : value());
		}

		@Override
		protected Integer readValue(NBTBase basetag){
			try{ return ((NBTPrimitive)basetag).getInt(); } catch (Exception e){ e.printStackTrace(); return 0; }
		}

		@Override
		public Attribute<Integer> copy(String origin){
			return new IntegerAttribute(false, id(), init()).setMinMax(min(), max()).setValue(value()).setSeat(seat()).setTarget(target()).setOrigin(origin).setEditable(editable());
		}
		
		@Override public int getIntegerValue(){ return value(); }
		@Override public float getFloatValue(){ return value(); }
		@Override public String getStringValue(){ return value() + ""; }
		@Override public boolean getBooleanValue(){ return value() > 0; }
		
		@Override
		public void increase(float amount){
			this.increase((int)amount);
		}
		
		@Override
		public void increase(int amount){
			this.setValue(value() + amount);
		}
		
		@Override
		public void decrease(float amount){
			this.decrease((int)amount);
		}
		
		@Override
		public void decrease(int amount){
			this.setValue(value() - amount);
		}
		
		@Override
		public void validate(){
			if((Object)value() instanceof Float) setValue(((Float)(Object)value()).intValue());
			if(value() > max()){ setValue(((Float)max()).intValue()); }
			if(value() < min()){ setValue(((Float)min()).intValue()); }
		}
		
	}
	
	public static class BooleanAttribute extends Attribute<Boolean> {

		public BooleanAttribute(boolean original, String id, Boolean initvalue){
			super(original, id, Type.BOOLEAN, initvalue);
		}

		@Override
		protected NBTBase writeValue(boolean initial){
			return new NBTTagByte((initial ? init() : value()) ? (byte)1 : (byte)0);
		}

		@Override
		protected Boolean readValue(NBTBase basetag){
			return ((NBTPrimitive)basetag).getByte() > 0;
		}

		@Override
		public Attribute<Boolean> copy(String origin){
			return new BooleanAttribute(false, id(), init()).setMinMax(min(), max()).setValue(value()).setSeat(seat()).setTarget(target()).setOrigin(origin).setEditable(editable());
		}
		
		@Override public int getIntegerValue(){ return value() ? 1 : 0; }
		@Override public float getFloatValue(){ return value() ? 1 : 0; }
		@Override public String getStringValue(){ return value() + ""; }
		@Override public boolean getBooleanValue(){ return value(); }
		
	}

}
