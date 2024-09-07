package net.fexcraft.mod.fvtm.data.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * 6th prototype.
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Attribute<V> {

	public static final IDL DEF_ICON = IDLManager.getIDLCached("fvtm:textures/gui/icons/attr_other.png");
	public ArrayList<String> access = new ArrayList<>();
	public LinkedHashMap<String, AttrBox> actboxes;
	public HashMap<String, IDL> icons = new HashMap<>();
	public HashMap<KeyPress, Float> keys;
	public final AttrValueType valuetype;
	public boolean editable;
	public boolean external;
	public boolean sync;
	public String origin;
	public String target;
	public String group;
	public String perm;
	public float min = Integer.MIN_VALUE;
	public float max = Integer.MAX_VALUE;
	public V initial;
	public V value;
	public final String id;

	public Attribute(String aid, AttrValueType type, V val){
		initial = value = val;
		valuetype = type;
		id = aid;
	}

	public <T> T initial(){
		return (T)initial;
	}

	public <T> T value(){
		return (T)value;
	}

	public void setI(Object val){
		initial = validate(val);
	}

	public void set(Object val){
		value = validate(val);
	}

	/** Should return a valid value. */
	public abstract V validate(Object val);

	/** @return may be null if invalid */
	public abstract V parse(String val);

	public void reset(){
		value = initial;
	}

	public abstract void increase(float by);

	public abstract void decrease(float by);

	public Attribute<?> limit(float min, float max){
		this.min = min;
		this.max = max;
		return this;
	}

	public Attribute<?> editable(boolean bool){
		editable = bool;
		return this;
	}

	public Attribute<?> group(String string){
		group = string;
		return this;
	}

	public Attribute<?> perm(String string){
		perm = string;
		return this;
	}

	public Attribute<?> sync(boolean bool){
		sync = bool;
		return this;
	}

	public abstract String type();

	public boolean hasPerm(){
		return perm != null;
	}

	// Returns //

	public abstract int asInteger();

	public abstract long asLong();

	public abstract float asFloat();

	public abstract String asString();

	public abstract boolean asBoolean();

	public Boolean asTristate(){
		if(valuetype.isNumber()){
			return asFloat() == 0f ? null : asFloat() > 0;
		}
		else return asBoolean();
	}

	public Vec3f asVector(){
		return new Vec3f(asFloat(), 0, 0);
	}

	public <R> R tristate(R n, R t, R f){
		return asTristate() == null ? n : asTristate() ? t : f;
	}

	public <R> R bool(R t, R f){
		return asBoolean() ? t : f;
	}

	public boolean toggle(){
		if(valuetype.isBoolean()){
			set(!asBoolean());
			return asBoolean();
		}
		return false;
	}

	// Access //

	public Attribute<?> addAccess(String str){
		if(!access.contains(str)) access.add(str);
		external = false;
		for(String acc : access){
			if(acc.contains("external")) external = true;
		}
		return this;
	}

	public void remAccess(String str){
		if(access.contains(str)) access.remove(str);
	}

	public void copyAccessFrom(Attribute<?> other){
		for(String acc : other.access) addAccess(acc);
	}

	// AttrBox //

	public boolean hasBoxes(){
		return actboxes != null && actboxes.size() > 0;
	}

	public AttrBox getBox(String id){
		if(!hasBoxes()) return null;
		if(!actboxes.containsKey(id)){
			if(id.startsWith("external-")) return getBox("external");
			return actboxes.get("default");
		}
		return actboxes.get(id);
	}

	public void addBox(String id, String point, float... data){
		if(actboxes == null) actboxes = new LinkedHashMap<>();
		actboxes.put(id, new AttrBox(id, point, data));
	}

	public void copyBoxesFrom(Attribute<?> other){
		if(!other.hasBoxes()) return;
		if(actboxes == null) actboxes = new LinkedHashMap<>();
		for(Entry<String, AttrBox> box : other.actboxes.entrySet()){
			if(actboxes.containsKey(box.getKey())) actboxes.get(box.getKey()).copy(box.getValue());
			else actboxes.put(box.getKey(), box.getValue().copy());
		}
	}

	// KeyPress //

	public boolean hasKeyPress(){
		return keys != null && keys.size() > 0;
	}

	public void copyKeysFrom(Attribute<?> other){
		if(!other.hasKeyPress()) return;
		if(keys == null) keys = new HashMap<>();
		keys.putAll(other.keys);
	}

	public Float getKeyValue(KeyPress key){
		return keys == null ? null : keys.get(key);
	}

	// Icons //

	public boolean hasIcons(){
		return icons.size() > 0;
	}

	public void copyIconsFrom(Attribute<?> other, boolean override){
		if(override){
			icons.putAll(other.icons);
			return;
		}
		for(String key : other.icons.keySet()){
			if(!icons.containsKey(key)) icons.put(key, other.icons.get(key));
		}
	}

	public Attribute<?> addIcons(String... strings){
		for(int i = 0; i < strings.length; i += 2){
			icons.put(strings[i], IDLManager.getIDLCached(strings[i + 1]));
		}
		return this;
	}

	public IDL getCurrentIcon(){
		if(icons.size() == 0) return DEF_ICON;
		if(icons.containsKey(asString())) return icons.get(asString());
		return icons.containsKey("default") ? icons.get("default") : DEF_ICON;
	}

	public void genDefaultIcons(){
		if(valuetype.isBoolean()){
			if(!icons.containsKey("true")) icons.put("true", IDLManager.getIDLCached("fvtm:textures/gui/icons/attr_bool_true.png"));
			if(!icons.containsKey("false")) icons.put("false", IDLManager.getIDLCached("fvtm:textures/gui/icons/attr_bool_false.png"));
		}
		if(valuetype == AttrValueType.TRISTATE){
			if(!icons.containsKey("true")) icons.put("true", IDLManager.getIDLCached("fvtm:textures/gui/icons/attr_tristate_true.png"));
			if(!icons.containsKey("false")) icons.put("false", IDLManager.getIDLCached("fvtm:textures/gui/icons/attr_tristate_false.png"));
			if(!icons.containsKey("null")) icons.put("null", IDLManager.getIDLCached("fvtm:textures/gui/icons/attr_tristate_null.png"));
		}
	}

	// Saving/Loading //

	public TagCW save(TagCW com){
		//com.set("id", id);
		com.set("type", type());
		if(origin != null) com.set("origin", origin);
		saveValue(com);
		return com;
	}

	public abstract void saveValue(TagCW com);

	public Attribute<V> load(TagCW com){
		if(com.has("origin")) origin = com.getString("origin");
		loadValue(com);
		return this;
	}

	public abstract void loadValue(TagCW com);

	// new Instaces //

	public abstract Attribute<V> newInstance();

	public Attribute<V> createCopy(String origin){
		Attribute<V> attr = newInstance();
		attr.limit(min, max);
		attr.initial = initial;
		attr.value = value;
		attr.group = group;
		attr.origin = origin;
		attr.target = target;
		attr.editable = editable;
		attr.external = external;
		attr.perm = perm;
		attr.sync = sync;
		attr.copyIconsFrom(this, true);
		attr.copyAccessFrom(this);
		attr.copyBoxesFrom(this);
		attr.copyKeysFrom(this);
		return attr;
	}

	// Parsing //

	public static Attribute<?> parse(String id, TagCW com){
		Class<? extends Attribute<?>> clazz = FvtmRegistry.ATTRIBUTES.get(com.getString("type"));
		if(clazz == null){
			FvtmLogger.LOGGER.log("Attribute of type '" + com.getString("type") + "' not found.");
			FvtmLogger.LOGGER.log("AttrInfo: " + id + " " + com.toString());
			return null;
		}
		Attribute attr = null;
		try{
			attr = clazz.getConstructor(String.class, JsonMap.class).newInstance(id, new JsonMap());
		}
		catch(Throwable e){
			e.printStackTrace();
			return null;
		}
		return attr.load(com);
	}

	public static Attribute<?> parse(String id, JsonMap map){
		if(map.has("mod-dep")){
			JsonValue<?> value =  map.get("mod-dep");
			if(value.isArray()){
				for(JsonValue<?> val : value.asArray().value){
					if(!FvtmResources.INSTANCE.isModPresent(val.string_value())) return null;
				}
			}
			else if(!FvtmResources.INSTANCE.isModPresent(value.string_value())) return null;
		}
		String type = map.getString("type", "float");
		Class<? extends Attribute<?>> clazz = FvtmRegistry.ATTRIBUTES.get(type);
		if(type == null){
			FvtmLogger.LOGGER.log("Attribute of type '" + type + "' not found.");
			FvtmLogger.LOGGER.log("AttrInfo: " + id + " " + map.toString());
			return null;
		}
		Attribute attr = null;
		try{
			attr = clazz.getConstructor(String.class, JsonMap.class).newInstance(id, map);
		}
		catch(Throwable e){
			e.printStackTrace();
			return null;
		}
		if(map.has("min") || map.has("max")){
			attr.limit(map.getFloat("min", attr.min), map.getFloat("max", attr.max));
		}
		attr.editable = map.getBoolean("editable", true);
		if(map.has("interact")){
			JsonMap ine = map.getMap("interact");
			for(Entry<String, JsonValue<?>> entry : ine.entries()){
				JsonArray array = entry.getValue().asArray();
				float[] arr = new float[attr.valuetype.isNumber() && !attr.valuetype.isTristate() ? 7 : 4];
				String point = array.size() > arr.length ? array.get(arr.length).string_value() : null;
				for(int i = 0; i < arr.length; i++) arr[i] = array.get(i).float_value();
				attr.addBox(entry.getKey(), point, arr);
			}
		}
		if(map.has("access")){
			if(map.get("access").isArray()){
				for(JsonValue<?> val : map.get("access").asArray().value){
					attr.addAccess(val.string_value());
				}
			}
			else attr.addAccess(map.get("access").string_value());
		}
		attr.target = map.getString("target", "vehicle");
		attr.group = map.getString("group", null);
		attr.perm = map.getString("perm", null);
		attr.sync = map.getBoolean("sync", false);
		if(map.has("icons")){
			for(Entry<String, JsonValue<?>> entry : map.getMap("icons").entries()){
				attr.addIcons(entry.getKey(), entry.getValue().string_value());
			}
		}
		if(map.has("keys")){
			if(attr.keys == null) attr.keys = new HashMap<>();
			for(Entry<String, JsonValue<?>> entry : map.getMap("keys").entries()){
				try{
					KeyPress press = KeyPress.valueOf(entry.getKey().toUpperCase());
					float val = entry.getValue().string_value().equals("toggle") ? 0 : entry.getValue().float_value();
					attr.keys.put(press, val);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return attr;
	}

	@Override
	public String toString(){
		return String.format("Attr{ %s, %s }", id, value);
	}

}
