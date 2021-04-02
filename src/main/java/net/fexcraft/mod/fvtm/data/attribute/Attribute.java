package net.fexcraft.mod.fvtm.data.attribute;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

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
	
	public Attribute<VT> copy(String origin){
		Attribute<VT> attr = copyNewInstance();
		return attr.setMinMax(min(), max()).setValue(value())// .setSeat(seat())
			.setTarget(target()).setGroup(group()).setOrigin(origin)
			.setEditable(editable()).setExternal(external()).copyAABBs(this);
	}

	protected abstract Attribute<VT> copyNewInstance();

	public static Attribute<?> parse(NBTTagCompound compound){
		Attribute<?> attr = null; Type type = Type.valueOf(compound.getString("type"));
		switch(type){
			case BOOLEAN: attr = new BooleanAttribute(null, (Boolean)null);
			case BOOL_ARRAY: break;
			case FLOAT: attr = new FloatAttribute(null, (Float)null);
			case FLOAT_ARRAY: break;
			case INTEGER: attr = new IntegerAttribute(null, (Integer)null); break;
			case INT_ARRAY: break;
			case OBJECT: break;//TODO
			case STRING: attr = new StringAttribute(null, (String)null); break;
			case STRING_ARRAY: break;
			case TRISTATE: attr = new TriStateAttribute(null, (Boolean)null); break;
			default: return null;
		}
		return attr.read(compound);
	}
	
	public static Attribute<?> parse(JsonObject obj){
		String id = obj.get("id").getAsString();
		String type = obj.get("type").getAsString();
		Class<? extends Attribute<?>> clazz = Resources.getAttributeType(id);
		if(clazz == null){
			Print.debug("Attribute class of type '" + type + "' not found!");
			return null;
		}
		Attribute<?> attr = null;
		try{
			attr = clazz.getConstructor(String.class, JsonObject.class).newInstance();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		boolean isbool = attr.type.isTristate();
		attr.setTarget(obj.has("target") ? obj.get("target").getAsString() : "vehicle");
		if((obj.has("max") || obj.has("min") && !isbool)){
			float min = JsonUtil.getIfExists(obj, "min", Integer.MIN_VALUE).floatValue();
			float max = JsonUtil.getIfExists(obj, "max", Integer.MAX_VALUE).floatValue();
			attr.setMinMax(min, max);
		}
		if(obj.has("editable")) attr.setEditable(obj.get("editable").getAsBoolean());
		if(obj.has("external")) attr.setExternal(obj.get("external").getAsBoolean());
		if(obj.has("hitbox")){
			if(obj.get("hitbox").isJsonArray()){
				JsonArray erray = obj.get("hitbox").getAsJsonArray();
				int expected = attr.type().isFloat() || attr.type().isInteger() ? 7 : 4;
				float[] arr = new float[expected];
				for(int i = 0; i < expected; i++){
					arr[i] = erray.get(i).getAsFloat();
				}
				attr.addBB("default", arr, erray.size() > expected ? erray.get(expected).getAsString() : null);
			}
			else if(obj.get("hitbox").isJsonObject()){
				for(Map.Entry<String, JsonElement> entry : obj.get("hitbox").getAsJsonObject().entrySet()){
					JsonArray erray = entry.getValue().getAsJsonArray();
					int expected = attr.type().isFloat() || attr.type().isInteger() ? 7 : 4;
					float[] arr = new float[expected];
					for(int i = 0; i < expected; i++){
						arr[i] = erray.get(i).getAsFloat();
					}
					attr.addBB(entry.getKey(), arr, erray.size() > expected ? erray.get(expected).getAsString() : null);
				}
			}
		}
		if(obj.has("seat")){
			if(obj.get("seat").isJsonArray()){
				for(JsonElement str : obj.get("seat").getAsJsonArray()){
					attr.addSeat(str.getAsString());
				}
			}
			else attr.addSeat(obj.get("seat").getAsString());
		}
		return attr;
	}

}
