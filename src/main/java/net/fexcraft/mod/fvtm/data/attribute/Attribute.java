package net.fexcraft.mod.fvtm.data.attribute;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.script.ScrBlock;
import net.fexcraft.lib.script.ScrElm;
import net.fexcraft.lib.script.ScrElmType;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.script.VehicleScriptContext;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

/**
 * 5th prototype.
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Attribute<VT> implements ScrElm {
	
	public static final Comparator<Modifier<?>> MODIFIER_COMPARATOR = new Comparator<Modifier<?>>() {
		@Override public int compare(Modifier<?> m0, Modifier<?> m1){ return m0.priority.compareTo(m1.priority); }
	};
	private static final ResourceLocation DEF_ICON = new ResourceLocation("fvtm:textures/gui/icons/attr_other.png");
	private TreeSet<Modifier<?>> modifiers = new TreeSet<>(MODIFIER_COMPARATOR);
	private ArrayList<String> seats = new ArrayList<>();
	private TreeMap<String, AttributeBB> abbs = null;
	private HashMap<String, ResourceLocation> icons;
	private String target, origin, group, perm;
	private boolean editable;
	private boolean external;
	protected boolean sync;
	private VT value, initial;
	private float min, max;
	public final String id;
	
	public Attribute(String id, VT initial_value){
		this.id = id;
		initial = initial_value;
		value = initial;
	}
	
	public String id(){
		return id;
	}

	public String target(){
		return target;
	}

	public String origin(){
		return origin;
	}

	public String group(){
		return group;
	}
	
	public boolean editable(){
		return editable;
	}

	public boolean external(){
		return external;
	}
	
	public boolean sync(){
		return sync;
	}

	public float min(){
		return min;
	}

	public float max(){
		return max;
	}

	public VT value(){
		return value;
	}

	public VT initial(){
		return initial;
	}
	
	public String perm(){
		return perm;
	}

	//
	public <VAL> VAL value_c(){
		return (VAL)value;
	}

	public <VAL> VAL initial_c(){
		return (VAL)initial;
	};

	public <VAL> Attribute<VT> value(VAL value){
		this.value = (VT)value;
		validate();
		return this;
	};

	public <VAL> Attribute<VT> initial(VAL value){
		this.initial = (VT)value;
		validate();
		return this;
	};

	public void increase(int amount){};

	public void decrease(int amount){};

	public void increase(float amount){};

	public void decrease(float amount){};

	public Attribute<VT> reset(){
		return value(initial);
	};
	
	protected void validate(){};
	
	public Attribute<VT> target(String string){
		this.target = string;
		return this;
	}

	public Attribute<VT> origin(String string){
		this.origin = string;
		return this;
	}

	public Attribute<VT> group(String string){
		this.group = string;
		return this;
	}

	public Attribute<VT> minmax(float min, float max){
		this.min = min;
		this.max = max;
		return this;
	}

	public Attribute<VT> editable(boolean bool){
		this.editable = bool;
		return this;
	}

	public Attribute<VT> external(boolean bool){
		this.external = bool;
		return this;
	}
	
	public Attribute<VT> sync(boolean bool){
		this.sync = bool;
		return this;
	}
	
	public Attribute<VT> perm(String perm){
		this.perm = perm;
		return this;
	}
	
	public HashMap<String, ResourceLocation> icons(){
		return icons;
	}
	
	public Attribute<VT> icons(HashMap<String, ResourceLocation> icons, boolean override){
		if(this.icons == null) this.icons = new HashMap<>();
		if(icons == null) return this;
		if(override){
			this.icons.putAll(icons);
			return this;
		}
		for(String key : icons.keySet()){
			if(!this.icons.containsKey(key)) this.icons.put(key, icons.get(key));
		}
		return this;
	}
	
	public Attribute<VT> icons(String... icons){
		if(this.icons == null) this.icons = new HashMap<>();
		for(int i = 0; i < icons.length; i += 2){
			if(i >= icons.length ) break;
			this.icons().put(icons[i], new ResourceLocation(icons[i + 1]));
		}
		return this;
	}
	
	//
	
	public int integer_value(){
		return (int)float_value();
	}
	
	public long long_value(){
		return integer_value();
	}

	public abstract float float_value();

	public String string_value(){
		return value + "";
	}

	public boolean boolean_value(){
		if(valuetype().isBoolean()){
			return value_c();
		}
		else if(valuetype().isNumber()){
			return float_value() > 0;
		}
		else if(valuetype().isTristate()){
			return value() != null || (Boolean)value();
		}
		else if(valuetype().isString()){
			return Boolean.parseBoolean(string_value());
		}
		else if(valuetype().isVector()){
			return vector_value().x > 0;
		}
		else return value != null;
	}

	public Boolean tristate_value(){
		if(valuetype().isNumber()){
			return float_value() == 0f ? null : float_value() > 0;
		}
		else return boolean_value();
	}

	public Vec3f vector_value(){
		return new Vec3f(float_value());
	}
	
	//
	
	public <VAL> VAL conditional_tristate(VAL n, VAL t, VAL f){
		return tristate_value() == null ? n : tristate_value() ? t : f;
	}
	
	public <VAL> VAL conditional_boolean(VAL t, VAL f){
		return boolean_value() ? t : f;
	}
	
	/** Only works with booleans. */
	public boolean toggle_value(){
		if(valuetype().isBoolean()){
			value(!boolean_value());
			return boolean_value();
		}
		return false;
	}
	
	//
	
	public ArrayList<String> seats(){ return seats; }
	
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

	private <U> Attribute<U> copySeats(Attribute<?> original){
		for(String seat : original.seats) addSeat(seat);
		return (Attribute<U>)this;
	}
	
	//
	
	/** Must be same as Registry Entry. */
	public abstract String type();
	
	public abstract ValueType valuetype();

	public abstract VT parseValue(String string);
	
	//
	
	public Attribute<VT> addModifier(Modifier<?> mod){
		if(mod.valid_valuetype(valuetype())) modifiers.add(mod);
		return this;
	}
	
	public TreeSet<Modifier<?>> getModifiers(){ return modifiers; }
	
	public Attribute<?> updateValue(VehicleData data, @Nullable VehicleEntity ent, AttrUpdate call){
		for(Modifier<?> mod : modifiers){
			if(mod.update() != call) continue;
			value(mod.modify(data, ent, this, call));
		}
		return this;
	}
	
	//
	
	public boolean hasBBs(){
		return abbs != null && abbs.size() > 0;
	}
	
	public AttributeBB getBB(String id){
		if(!hasBBs()) return null;
		if(!abbs.containsKey(id)){
			if(id.startsWith("external-")) return getBB("external");
			if(!abbs.containsKey("default")) return null;
			return abbs.get("default");
		}
		return abbs.get(id);
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
	
	//
	
	public NBTTagCompound write(NBTTagCompound compound){
		compound.setString("id", id);
		compound.setString("type", type());
		compound.setFloat("min", min);
		compound.setFloat("max", max);
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
		compound.setBoolean("sync", sync);
		compound.setTag("initial", this.writeValue(true));
		compound.setTag("value", this.writeValue(false));
		if(!modifiers.isEmpty()){
			NBTTagList list = new NBTTagList();
			for(Modifier<?> mod : modifiers){
				list.appendTag(mod.write(new NBTTagCompound()));
			}
			compound.setTag("modifiers", list);
		}
		return compound;
	}
	
	protected abstract NBTBase writeValue(boolean initial);

	public Attribute<?> read(NBTTagCompound compound){
		min = compound.getFloat("min");
		max = compound.getFloat("max");
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
		sync = compound.hasKey("sync") ? compound.getBoolean("sync") : false;
		initial = this.readValue(compound.getTag("initial"));
		value = compound.hasKey("value") ? this.readValue(compound.getTag("value")) : initial;
		modifiers.clear();
		if(compound.hasKey("modifiers")){
			NBTTagList list = (NBTTagList)compound.getTag("modifiers");
			for(NBTBase base : list){
				Modifier<?> mod = Modifier.parse((NBTTagCompound)base);
				if(mod != null) modifiers.add(mod);
			}
		}
		return this;
	}
	
	protected abstract VT readValue(NBTBase basetag);
	
	//
	
	public Attribute<VT> copy(String origin){
		Attribute<VT> attr = copyNewInstance();
		return attr.minmax(min(), max()).value(value())//.setSeat(seat())
			.target(target()).group(group()).origin(origin)
			.editable(editable()).external(external()).sync(sync()).icons(icons, true)
			.perm(perm()).copyAABBs(this).copySeats(this);
	}

	protected abstract Attribute<VT> copyNewInstance();
	
	//

	public static Attribute<?> parse(NBTTagCompound compound){
		Class<? extends Attribute<?>> clazz = Resources.getAttributeType(compound.getString("type").toLowerCase());
		if(clazz == null){
			Print.log("Attribute class of type '" + compound.getString("type") + "' not found! (NBT LOAD)");
			Static.stop();
			return null;
		}
		Attribute<?> attr = null;
		try{
			attr = clazz.getConstructor(String.class, JsonObject.class).newInstance(compound.getString("id"), null);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return attr.read(compound);
	}
	
	public static Attribute<?> parse(JsonObject obj){
		if(/*obj.has("mod-dependency") ||*/ obj.has("mod-dep")){
			JsonElement dep = /*obj.has("mod-dependency") ? obj.get("mod-dependency") :*/ obj.get("mod-dep");
			if(dep.isJsonArray()){
				for(JsonElement elm : dep.getAsJsonArray()){
					if(!Resources.isModLoaded(elm.getAsString())) return null;
				}
			}
			else if(!Resources.isModLoaded(dep.getAsString())) return null;
		}
		String id = obj.get("id").getAsString();
		String type = obj.get("type").getAsString();
		Class<? extends Attribute<?>> clazz = Resources.getAttributeType(type);
		if(clazz == null){
			Print.log("Attribute class of type '" + type + "' not found! (JSON LOAD)");
			return null;
		}
		Attribute<?> attr = null;
		try{
			attr = clazz.getConstructor(String.class, JsonObject.class).newInstance(id, obj);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		boolean isbool = attr.valuetype().isTristate();
		attr.target(obj.has("target") ? obj.get("target").getAsString() : "vehicle");
		if((obj.has("max") || obj.has("min") && !isbool)){
			float min = JsonUtil.getIfExists(obj, "min", Integer.MIN_VALUE).floatValue();
			float max = JsonUtil.getIfExists(obj, "max", Integer.MAX_VALUE).floatValue();
			attr.minmax(min, max);
		}
		if(obj.has("editable")) attr.editable(obj.get("editable").getAsBoolean());
		if(obj.has("external")) attr.external(obj.get("external").getAsBoolean());
		if(obj.has("hitbox")){
			if(obj.get("hitbox").isJsonArray()){
				JsonArray erray = obj.get("hitbox").getAsJsonArray();
				int expected = attr.valuetype().isFloat() || attr.valuetype().isInteger() ? 7 : 4;
				float[] arr = new float[expected];
				for(int i = 0; i < expected; i++){
					arr[i] = erray.get(i).getAsFloat();
				}
				attr.addBB("default", arr, erray.size() > expected ? erray.get(expected).getAsString() : null);
			}
			else if(obj.get("hitbox").isJsonObject()){
				for(Map.Entry<String, JsonElement> entry : obj.get("hitbox").getAsJsonObject().entrySet()){
					JsonArray erray = entry.getValue().getAsJsonArray();
					int expected = attr.valuetype().isFloat() || attr.valuetype().isInteger() ? 7 : 4;
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
		if(obj.has("group")) attr.group(obj.get("group").getAsString());
		if(obj.has("sync")) attr.sync(obj.get("sync").getAsBoolean());
		if(obj.has("perm")) attr.perm(obj.get("perm").getAsString());
		if(obj.has("icons")){
			ArrayList<String> arr = new ArrayList<>();
			for(Entry<String, JsonElement> entry : obj.get("icons").getAsJsonObject().entrySet()){
				arr.add(entry.getKey());
				arr.add(entry.getValue().getAsString());
			}
			attr.icons(arr.toArray(new String[0]));
		}
		return attr;
	}

	public void if_bool_differs(boolean compare, boolean apply, Consumer<Boolean> consumer){
		if(boolean_value() != compare){
			if(apply) value(compare);
			consumer.accept(boolean_value());
		}
	}

	public boolean hasPerm(){
		return perm != null;
	}
	
	public boolean hasIcons(){
		return icons != null;
	}

	public ResourceLocation getCurrentIcon(){
		if(!hasIcons()) return DEF_ICON;
		return icons.containsKey(string_value()) ? icons.get(string_value()) : icons.containsKey("default") ? icons.get("default") : DEF_ICON;
	}

	public void genDefaultIcons(){
		if(this instanceof BooleanAttribute){
			icons(null, false);
			if(!icons.containsKey("true")) icons.put("true", new ResourceLocation("fvtm:textures/gui/icons/attr_bool_true.png"));
			if(!icons.containsKey("false")) icons.put("false", new ResourceLocation("fvtm:textures/gui/icons/attr_bool_false.png"));
		}
		if(this instanceof TriStateAttribute){
			icons(null, false);
			if(!icons.containsKey("true")) icons.put("true", new ResourceLocation("fvtm:textures/gui/icons/attr_tristate_true.png"));
			if(!icons.containsKey("false")) icons.put("false", new ResourceLocation("fvtm:textures/gui/icons/attr_tristate_false.png"));
			if(!icons.containsKey("null")) icons.put("null", new ResourceLocation("fvtm:textures/gui/icons/attr_tristate_null.png"));
		}
	}

	//

	@Override
	public String scr_str(){
		return string_value();
	}

	@Override
	public int scr_int(){
		return integer_value();
	}

	@Override
	public float scr_flt(){
		return float_value();
	}

	@Override
	public boolean scr_bln(){
		return boolean_value();
	}

	@Override
	public ScrElmType scr_type(){
		return ScrElmType.OBJ;
	}

	@Override
	public void scr_set(ScrElm elm){
		if(elm.scr_type().primitive()){
			if(elm.scr_type().integer()) scr_set(elm.scr_int());
			else if(elm.scr_type().decimal()) scr_set(elm.scr_flt());
			else if(elm.scr_type().bool()) scr_set(elm.scr_bln());
			else if(elm.scr_type().string()) scr_set(elm.scr_str());
			else if(elm.scr_type() == ScrElmType.NULL && valuetype() == ValueType.TRISTATE) value(null);
			sync = true;
		}
		else return;
	}

	@Override
	public ScrElm scr_exec(ScrBlock block, String act, ArrayList<ScrElm> args){
		ScrElm val = NULL;
		switch(act){
			case "toggle":{
				val = ScrElm.asBool(toggle_value());
				((VehicleScriptContext)block.action().getElm("context", null)).vehicle().sendAttributeUpdate(this);
				return val;
			}
			case "sync":{
				if(sync) ((VehicleScriptContext)block.action().getElm("context", null)).vehicle().sendAttributeUpdate(this);
				sync = false;
				return TRUE;
			}
			case "value":{
				return this;
			}
			default: break;
		}
		return val;
	}

}
