package net.fexcraft.mod.fvtm.data;

import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATIONS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.WHITE_TEXTURE;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecorationData extends ContentData<Decoration, DecorationData> implements TextureUser, Colorable {

	private TreeMap<String, RGB> channels = new TreeMap<>();
	protected Textureable texture;
	public Pos offset = new Pos(0, 0, 0);
	public float rotx, roty, rotz;
	public float sclx = 1, scly = 1, sclz = 1;
	public int size = 8;
	
	public DecorationData(Decoration deco){
		super(deco);
		texture = new Textureable(deco);
		for(Entry<String, RGB> entry : type.getDefaultColorChannels().entrySet()){
			channels.put(entry.getKey(), entry.getValue().copy());
		}
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
		compound.set("Decoration", type.getID().toString());
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
		return compound;
	}

	@Override
	public DecorationData read(TagCW compound){
		if(compound == null) return this;
		offset = new Pos(compound.getFloat("offx"), compound.getFloat("offy"), compound.getFloat("offz"));
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
		return this;
	}

	@Override
	public DecorationData parse(JsonMap map){
		//
		return this;
	}

	@Override
	public JsonMap toJson(){
		return new JsonMap();
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
