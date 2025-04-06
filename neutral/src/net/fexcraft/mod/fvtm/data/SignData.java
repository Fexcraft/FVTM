package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.UIField;

import java.text.ParseException;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignData extends ContentData<Sign, SignData> implements TextureUser, Colorable {

	private TreeMap<String, RGB> channels = new TreeMap<>();
	protected Textureable texture;
	public V3D offset = new V3D(0, 0, 0);
	public float rotx, roty, rotz;
	public float sclx = 1, scly = 1, sclz = 1;
	//
	public String text, form;
	public boolean centered;
	public boolean[] sides;
	public float width, height;

	public SignData(Sign sign){
		super(sign);
		texture = new Textureable(sign);
		for(Entry<String, RGB> entry : type.getDefaultColorChannels().entrySet()){
			channels.put(entry.getKey(), entry.getValue().copy());
		}
		if(sign.isText()) text = form = sign.text;
		if(sign.isBase()){
			sides = new boolean[4];
		}
		width = height = 1f;
	}

	@Override
	public RGB getColorChannel(String channel){
		return channels.get(channel);
	}
	
	@Override
	public void setColorChannel(String channel, RGB color){
		channels.put(channel, color);
	}
	
	@Override
	public TreeMap<String, RGB> getColorChannels(){
		return channels;
	}

	@Override
	public TagCW write(TagCW compound){
		if(compound == null) compound = TagCW.create();
		compound.set("Sign", type.getID().toString());
		compound.set("offx", offset.x);
		compound.set("offy", offset.y);
		compound.set("offz", offset.z);
		if(rotx != 0f) compound.set("rotx", rotx);
		if(roty != 0f) compound.set("roty", roty);
		if(rotz != 0f) compound.set("rotz", rotz);
		if(sclx != 1f) compound.set("sclx", sclx);
		if(scly != 1f) compound.set("scly", scly);
		if(sclz != 1f) compound.set("sclz", sclz);
		texture.save(compound);
		for(String str : channels.keySet()){
			compound.set("rgb_" + str, channels.get(str).packed);
		}
		if(type.isText()){
			compound.set("text", text);
			compound.set("form", form);
			if(centered) compound.set("centered", true);
		}
		if(type.isBase()){
			for(int i = 0; i < sides.length; i++){
				if(sides[i]) compound.set("side" + i, sides[i]);
			}
			if(width != 1f) compound.set("width", width);
			if(height != 1f) compound.set("height", height);
		}
		return compound;
	}

	@Override
	public SignData read(TagCW compound){
		offset.x = compound.getDouble("offx");
		offset.y = compound.getDouble("offy");
		offset.z = compound.getDouble("offz");
		if(compound.has("rotx")) rotx = compound.getFloat("rotx");
		if(compound.has("roty")) roty = compound.getFloat("roty");
		if(compound.has("rotz")) rotz = compound.getFloat("rotz");
		if(compound.has("sclx")) sclx = compound.getFloat("sclx");
		if(compound.has("scly")) scly = compound.getFloat("scly");
		if(compound.has("sclz")) sclz = compound.getFloat("sclz");
		texture.load(compound);
		for(String str : channels.keySet()){
			if(compound.has("rgb_" + str)){
				channels.get(str).packed = compound.getInteger("rgb_" + str);
			}
		}
		if(type.isText()){
			text = compound.getString("text");
			form = compound.getString("form");
			centered = compound.getBoolean("centered");
		}
		if(type.isBase()){
			if(sides == null) sides = new boolean[4];
			for(int i = 0; i < sides.length; i++){
				if(compound.has("side" + i)) sides[i] = compound.getBoolean("side" + i);
			}
			width = compound.has("width") ? compound.getFloat("width") : 1;
			height = compound.has("height") ? compound.getFloat("height") : 1;
		}
		return this;
	}

	@Override
	public SignData parse(JsonMap map){
		JsonArray arr = null;
		if(map.has("off")){
			arr = map.getArray("off");
			offset.x = arr.get(0).float_value();
			offset.y = arr.get(1).float_value();
			offset.z = arr.get(2).float_value();
		}
		if(map.has("rot")){
			arr = map.getArray("rot");
			rotx = arr.get(0).float_value();
			roty = arr.get(1).float_value();
			rotz = arr.get(2).float_value();
		}
		if(map.has("scl")){
			arr = map.getArray("scl");
			sclx = arr.get(0).float_value();
			scly = arr.get(1).float_value();
			sclz = arr.get(2).float_value();
		}
		texture.load(map);
		if(map.has("rgb")){
			JsonMap rgb = map.getMap("rgb");
			for(Entry<String, JsonValue<?>> entry : rgb.entries()){
				int col = Integer.parseInt(entry.getValue().string_value(), 16);
				if(channels.containsKey(entry.getKey())){
					channels.get(entry.getKey()).packed = col;
				}
				else channels.put(entry.getKey(), new RGB(col));
			}
		}
		if(type.isText()){
			form = map.getString("form", form);
			text = map.getString("text", form);
			centered = map.getBoolean("center", false);
		}
		if(type.isBase()){
			String sd = map.getString("sides", "0000");
			for(int i = 0; i < (sd.length() > 4 ? 4 : sd.length()); i++){
				sides[i] = sd.charAt(i) == '1';
			}
			width = map.getFloat("width", 1f);
			height = map.getFloat("height", 1f);
		}
		return this;
	}

	@Override
	public JsonMap toJson(){
		JsonMap map = new JsonMap();
		map.add("type", type.getIDS());
		if(!offset.isNull()) map.add("off", new JsonArray.Flat(f(offset.x), f(offset.y), f(offset.z)));
		if(rotx != 0f || roty != 0f || rotz != 0f) map.add("rot", new JsonArray.Flat(f(rotx), f(roty), f(rotz)));
		if(sclx != 1f || scly != 1f || sclz != 1f) map.add("scl", new JsonArray.Flat(f(sclx), f(scly), f(sclz)));
		JsonMap sub = texture.save();
		if(!sub.empty()) map.add("tex", sub);
		sub = new JsonMap();
		for(String str : channels.keySet()){
			if(channels.get(str).packed == type.getDefaultColorChannels().get(str).packed) continue;
			sub.add(str, Integer.toHexString(channels.get(str).packed));
		}
		if(!sub.empty()) map.add("rgb", sub);
		if(type.isText()){
			if(!text.equals(form)) map.add("text", text);
			map.add("form", form);
			if(centered) map.add("center", true);
		}
		if(type.isBase()){
			boolean any = false;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < sides.length; i++){
				sb.append(sides[i] ? "1" : "0");
				if(sides[i]) any = true;
			}
			if(any) map.add("sides", sb.toString());
			if(width != 1f) map.add("width", width);
			if(height != 1f) map.add("height", height);
		}
		return map;
	}

	private float f(Number v){
		try{
			return UIField.nf.parse(UIField.df.format(v)).floatValue();
		}
		catch(ParseException e){
			return v.floatValue();
		}
	}

	@Override
	public Textureable getTexture(){
		return texture;
	}

	@Override
	public Textureable.TextureHolder getTexHolder(){
		return type;
	}

}
