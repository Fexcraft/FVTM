package net.fexcraft.mod.fvtm.data.root;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

import net.fexcraft.lib.common.math.Vec3f;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

/**
 * 5th prototype.
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Attribute<VT> {
	
	public static final Comparator<Modifier<?>> MODIFIER_COMPARATOR = new Comparator<Modifier<?>>() {
		@Override public int compare(Modifier<?> m0, Modifier<?> m1){ return m0.priority.compareTo(m1.priority); }
	};
	private TreeSet<Modifier<VT>> modifiers = new TreeSet<>(MODIFIER_COMPARATOR);
	private ArrayList<String> seats = new ArrayList<>();
	private TreeMap<String, AttributeBB> abbs = null;
	private String id, target, origin, group;
	private boolean editable, external;
	private float min, max;
	private Type type;
	private VT value, init;
	
	public Attribute(String id, Type type, VT initial_value){
		this.id = id; this.type = type; init = initial_value; value = init;
	}
	
	public boolean editable(){ return editable; }
	public boolean external(){ return external; }
	//
	public String id(){ return id; }
	public String target(){ return target; }
	public String origin(){ return origin; }
	public String group(){ return group; }
	public Type type(){ return type; }
	public float min(){ return min; }
	public float max(){ return max; }
	public VT value(){ return value; }
	public VT init(){ return init; }
	//
	public <VAL> VAL getValue(){ return (VAL)value; }
	public <VAL> VAL getInitValue(){ return (VAL)init; };
	public <VAL> Attribute<VT> setValue(VAL value){ this.value = (VT)value; validate(); return this; };
	public <VAL> Attribute<VT> setInitValue(VAL value){ this.init = (VT)value; validate(); return this; };
	public void increase(int amount){}; public void decrease(int amount){};
	public void increase(float amount){}; public void decrease(float amount){};
	public Attribute<VT> reset(){ return setValue(init); };
	protected void validate(){};
	//
	public Attribute<VT> setTarget(String string){ this.target = string; return this; }
	public Attribute<VT> setOrigin(String string){ this.origin = string; return this; }
	public Attribute<VT> setGroup(String string){ this.group = string; return this; }
	public Attribute<VT> setMinMax(float min, float max){ this.min = min; this.max = max; return this; }
	public Attribute<VT> setEditable(boolean bool){ this.editable = bool; return this; }
	public Attribute<VT> setExternal(boolean bool){ this.external = bool; return this; }
	//
	
	public ArrayList<String> seats(){return seats; }
	
	public Attribute<VT> addSeat(String string){
		if(!seats.contains(string)) seats.add(string);
		return this;
	}
	
	public Attribute<VT> remSeat(String string){
		if(seats != null && seats.contains(string)){
			seats.remove(string);
		}
		return this;
	}
	
	//
	public Attribute<VT> addModifier(Modifier<?> mod){
		if(mod.type() == type() || mod.type().isNumber() == type().isNumber()) modifiers.add((Modifier<VT>)mod); return this;
	}
	public TreeSet<Modifier<VT>> getModifiers(){ return modifiers; }
	//
	public abstract int getIntegerValue();
	public abstract float getFloatValue();
	public abstract String getStringValue();
	public abstract boolean getBooleanValue();
	public abstract Boolean getTriStateValue();
	public abstract Vec3f getVectorValue();
	
	public Attribute<?> updateValue(Update call){
		for(Modifier<?> mod : modifiers){
			if(mod.update() != call) continue;
			setValue(mod.modify(this, call));
		} return this;
	}
	
	public boolean hasBBs(){
		return abbs != null && abbs.size() > 0;
	}
	
	public AttributeBB getBB(String id){
		if(!hasBBs()) return null;
		if(!abbs.containsKey(id)){
			if(id.startsWith("external-")) return getBB("external");
			if(!abbs.containsKey("default")) return null;
			return abbs.get("default");
		} return abbs.get(id);
	}
	
	public <T> Attribute<T> addBB(String id, float[] data, String point){
		if(abbs == null) abbs = new TreeMap<>();
		abbs.put(id, new AttributeBB(id, data, point));
		return (Attribute<T>)this;
	}

	public <U> Attribute<U> copyAABBs(Attribute<?> original){
		if(original.hasBBs()){
			this.abbs = new TreeMap<>();
			original.abbs.forEach((key, value) -> {
				if(abbs.containsKey(key)) abbs.get(key).copy(value);
				else abbs.put(key, value.copy());
			});
		}
		return (Attribute<U>)this;
	}
	
	public TreeMap<String, AttributeBB> getBBs(){
		return abbs;
	}
	
	public static enum Type {
		
		STRING, INTEGER, FLOAT, BOOLEAN, TRISTATE, VEC3, STRING_ARRAY, INT_ARRAY, FLOAT_ARRAY, BOOL_ARRAY, OBJECT;
		
		public boolean isString(){ return this == STRING; }
		public boolean isInteger(){ return this == INTEGER; }
		public boolean isFloat(){ return this == FLOAT; }
		public boolean isBoolean(){ return this == BOOLEAN; }
		public boolean isTristate(){ return this == TRISTATE || this == BOOLEAN; }
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
				case TRISTATE:{
					if(string == null || string.equals("null")) return null;
					else return Boolean.parseBoolean(string);
				}
				default: return null;
			} return null;
		}
		
	}
	
	public static enum Update {
		INITIAL, ENTITY, MANUAL
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		compound.setString("id", id);
		compound.setString("type", type.name());
		compound.setFloat("min", min); compound.setFloat("max", max);
		if(target != null) compound.setString("target", target);
		if(origin != null) compound.setString("origin", origin);
		if(group != null) compound.setString("group", group);
		if(!seats.isEmpty()){
			if(seats.size() == 1) compound.setString("seat", seats.get(0));
			else{
				String sts = seats.get(0);
				for(int i = 1; i < seats.size(); i++){
					sts += ";" + seats.get(i);
				}
				compound.setString("seats", sts);
			}
		}
		compound.setBoolean("editable", editable);
		compound.setBoolean("external", external);
		compound.setTag("initial", this.writeValue(true));
		compound.setTag("value", this.writeValue(false));
		if(!modifiers.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(Modifier<VT> mod : modifiers){
				list.appendTag(mod.write(new NBTTagCompound()));
			}
			compound.setTag("modifiers", list);
		}
		return compound;
	}
	
	protected abstract NBTBase writeValue(boolean initial);

	public Attribute<?> read(NBTTagCompound compound){
		id = compound.getString("id");
		min = compound.getFloat("min"); max = compound.getFloat("max");
		if(compound.hasKey("target")) this.target = compound.getString("target");
		if(compound.hasKey("origin")) this.origin = compound.getString("origin");
		if(compound.hasKey("group")) this.group = compound.getString("group");
		if(compound.hasKey("seat")){
			seats.clear();
			seats.add(compound.getString("seat"));
		}
		if(compound.hasKey("seats")){
			seats.clear();
			String[] sts = compound.getString("seats").split(";");
			for(String str : sts) seats.add(str);
		}
		editable = compound.hasKey("editable") ? compound.getBoolean("editable") : true;
		external = compound.hasKey("external") ? compound.getBoolean("external") : false;
		init = this.readValue(compound.getTag("initial"));
		value = compound.hasKey("value") ? this.readValue(compound.getTag("value")) : init;
		modifiers.clear();
		if(compound.hasKey("modifiers")){
			NBTTagList list = (NBTTagList)compound.getTag("modifiers");
			for(NBTBase base : list){
				modifiers.add((Modifier<VT>)Modifier.parse((NBTTagCompound)base));
			}
		}
		return this;
	}
	
	protected abstract VT readValue(NBTBase basetag);

	public static Attribute<?> parse(NBTTagCompound compound){
		Attribute<?> attr = null; Type type = Type.valueOf(compound.getString("type"));
		switch(type){
			case BOOLEAN: attr = new BooleanAttribute(null, null);
			case BOOL_ARRAY: break;
			case FLOAT: attr = new FloatAttribute(null, null);
			case FLOAT_ARRAY: break;
			case INTEGER: attr = new IntegerAttribute(null, null); break;
			case INT_ARRAY: break;
			case OBJECT: break;//TODO
			case STRING: attr = new StringAttribute(null,  null); break;
			case STRING_ARRAY: break;
			case TRISTATE: attr = new TriStateAttribute(null, null); break;
			default: return null;
		}
		return attr.read(compound);
	}
	
	public abstract Attribute<VT> copy(String origin);
	
	public static class StringAttribute extends Attribute<String> {

		public StringAttribute(String id, String initvalue){
			super(id, Type.STRING, initvalue); 
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
			return new StringAttribute(id(), init()).setMinMax(min(), max()).setValue(value())//.setSeat(seat())
				.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
		}
		
		@Override public int getIntegerValue(){ return 0; }
		@Override public float getFloatValue(){ return 0; }
		@Override public String getStringValue(){ return value(); }
		@Override public boolean getBooleanValue(){ return Boolean.parseBoolean(value()); }
		@Override public Boolean getTriStateValue(){ return value().equalsIgnoreCase("null") ? null : Boolean.parseBoolean(value()); }

		@Override
		public Vec3f getVectorValue(){
			return new Vec3f();
		}
		
	}
	
	public static class FloatAttribute extends Attribute<Float> {

		public FloatAttribute(String id, Float initvalue){
			super(id, Type.FLOAT, initvalue);
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
			return new FloatAttribute(id(), init()).setMinMax(min(), max()).setValue(value())//.setSeat(seat())
				.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
		}
		
		@Override public int getIntegerValue(){ return (int) + value(); }
		@Override public float getFloatValue(){ return value(); }
		@Override public String getStringValue(){ return value() + ""; }
		@Override public boolean getBooleanValue(){ return value() > 0; }
		@Override public Boolean getTriStateValue(){ return value() == 0f ? null : value() > 0; }
		
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

		@Override
		public Vec3f getVectorValue(){
			return new Vec3f(value());
		}
		
	}
	
	public static class IntegerAttribute extends Attribute<Integer> {

		public IntegerAttribute(String id, Integer initvalue){
			super(id, Type.INTEGER, initvalue);
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
			return new IntegerAttribute(id(), init()).setMinMax(min(), max()).setValue(value())//.setSeat(seat())
				.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
		}
		
		@Override public int getIntegerValue(){ return value(); }
		@Override public float getFloatValue(){ return value(); }
		@Override public String getStringValue(){ return value() + ""; }
		@Override public boolean getBooleanValue(){ return value() > 0; }
		@Override public Boolean getTriStateValue(){ return value() == 0 ? null : value() > 0; }
		
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

		@Override
		public Vec3f getVectorValue(){
			return new Vec3f(value());
		}
		
	}
	
	public static class BooleanAttribute extends Attribute<Boolean> {

		public BooleanAttribute(String id, Boolean initvalue){
			super(id, Type.BOOLEAN, initvalue);
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
			return new BooleanAttribute(id(), init()).setMinMax(min(), max()).setValue(value())//.setSeat(seat())
				.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
		}
		
		@Override public int getIntegerValue(){ return value() ? 1 : 0; }
		@Override public float getFloatValue(){ return value() ? 1 : 0; }
		@Override public String getStringValue(){ return value() + ""; }
		@Override public boolean getBooleanValue(){ return value(); }
		@Override public Boolean getTriStateValue(){ return value(); }

		@Override
		public Vec3f getVectorValue(){
			return new Vec3f(getIntegerValue());
		}
		
	}
	
	public static class TriStateAttribute extends Attribute<Boolean> {

		public TriStateAttribute(String id, Boolean initvalue){
			super(id, Type.TRISTATE, initvalue);
		}

		@Override
		protected NBTBase writeValue(boolean initial){
			Boolean bool = initial ? init() : value();
			return new NBTTagByte(bool == null ? -1 : bool ? (byte)1 : (byte)0);
		}

		@Override
		protected Boolean readValue(NBTBase basetag){
			byte val = ((NBTPrimitive)basetag).getByte();
			return val < 0 ? null : val > 0;
		}

		@Override
		public Attribute<Boolean> copy(String origin){
			return new TriStateAttribute(id(), init()).setMinMax(min(), max()).setValue(value())//.setSeat(seat())
				.setTarget(target()).setGroup(group()).setOrigin(origin).setEditable(editable()).setExternal(external()).copyAABBs(this);
		}
		
		@Override public int getIntegerValue(){ return value() == null ? -1 : value() ? 1 : 0; }
		@Override public float getFloatValue(){ return value() == null ? -1 : value() ? 1 : 0; }
		@Override public String getStringValue(){ return value() + ""; }
		@Override public boolean getBooleanValue(){ return value() == null ? false : value(); }
		@Override public Boolean getTriStateValue(){ return value(); }

		@Override
		public Vec3f getVectorValue(){
			return new Vec3f(getIntegerValue());
		}
		
	}

}
