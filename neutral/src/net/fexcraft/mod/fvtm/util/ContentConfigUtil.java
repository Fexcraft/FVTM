package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.FvtmRegistry.ADDONS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ContentConfigUtil {

	public static IDL getID(JsonMap map){
		if(map.has("ID")) return IDLManager.getIDLCached(map.get("ID").string_value());
		else if(map.has("RegistryName")) return IDLManager.getIDLCached(map.get("RegistryName").string_value());
		else return null;
	}

	public static IDL getID(Addon pack, JsonMap map){
		String id = map.getString("ID", null);
		if(id == null) id = map.get("RegistryName", null);
		if(id == null) return null;
		if(id.contains(":")) return IDLManager.getIDLCached(id);
		else return IDLManager.getIDLCached((pack == null ? "fvtm" : pack.getID().id()) + ":" + id);
	}

	public static Addon getAddon(JsonMap map){
		if(map.has("Addon")){
			String id = map.get("Addon").string_value();
			if(id.contains(":")) id = id.split(":")[1];
			for(Addon addon : ADDONS){
				if(addon.getID().id().equals(id)) return addon;
			}
		}
		return ADDONS.get(FvtmRegistry.INTERNAL_ADDON_ID);
	}

	public static List<String> getStringList(JsonMap map, String key){
		if(!map.has(key)) return new ArrayList<>();
		if(map.get(key).isArray()){
			return map.getArray(key).toStringList();
		}
		else{
			ArrayList list = new ArrayList();
			list.add(map.get(key).string_value());
			return list;
		}
	}

	public static final IDL ITL_GENERAL = IDLManager.getIDLCached("fvtm:textures/item/ph_general.png");
	public static final IDL ITL_VEHICLE = IDLManager.getIDLCached("fvtm:textures/item/ph_vehicle.png");
	public static final IDL ITL_MBLOCK = IDLManager.getIDLCached("fvtm:textures/item/ph_multiblock.png");
	public static final IDL ITL_PART = IDLManager.getIDLCached("fvtm:textures/item/ph_part.png");

	public static IDL getItemTexture(IDL id, ContentType contype, JsonMap map){
		if(map.has("ItemTexture")){
			return IDLManager.getIDLCached(map.get("ItemTexture").string_value());
		}
		else{
			IDL idl = IDLManager.getIDLCached(id.space() + ":textures/item/" + id.path() + ".png");
			try{
				if(EnvInfo.CLIENT && FvtmResources.INSTANCE.getAssetInputStream(idl, EnvInfo.DEV) == null){
					switch(contype){
						case VEHICLE: return ITL_VEHICLE;
						case PART: return ITL_PART;
						case MULTIBLOCK: return ITL_MBLOCK;
						default: return ITL_GENERAL;
					}
				}
			}
			catch(Throwable e){
				FvtmLogger.log(e, "checking icon presence of " + contype + "/" + id );
			}
			return idl;
		}
	}

	public static List<IDL> getTextures(JsonMap map){
		ArrayList<IDL> list = new ArrayList<>();
		if(map.has("Texture")){
			list.add(IDLManager.getIDLNamed(map.get("Texture", "No Texture;fvtm:textures/entity/null.png")));
		}
		if(map.has("Textures") && map.get("Textures").isArray()){
			for(JsonValue<?> tex : map.get("Textures").asArray().value){
				list.add(IDLManager.getIDLNamed(tex.string_value()));
			}
		}
		if(list.isEmpty()){
			list.add(IDLManager.getIDLNamed("No Texture;fvtm:textures/entity/null.png"));
		}
		return list;
	}

	public static V3D getVector(JsonArray array){
		V3D vec = new V3D();
		if(array.size() > 0) vec.x = array.get(0).float_value();
		if(array.size() > 1) vec.y = array.get(1).float_value();
		if(array.size() > 2) vec.z = array.get(2).float_value();
		return vec;
	}

	public static V3D getVector(JsonArray array, int offset){
		V3D vec = new V3D();
		if(array.size() > offset + 0) vec.x = array.get(offset + 0).float_value();
		if(array.size() > offset + 1) vec.y = array.get(offset + 1).float_value();
		if(array.size() > offset + 2) vec.z = array.get(offset + 2).float_value();
		return vec;
	}

	public static V3D getVector(JsonMap map){
		V3D vec = new V3D();
		vec.x = map.getFloat("x", 0f);
		vec.y = map.getFloat("y", 0f);
		vec.z = map.getFloat("z", 0f);
		return vec;
	}

	public static V3D getVector(JsonMap map, float x, float y, float z){
		V3D vec = new V3D();
		vec.x = map.getFloat("x", x);
		vec.y = map.getFloat("y", y);
		vec.z = map.getFloat("z", z);
		return vec;
	}

	public static V3D getVector(JsonMap map, String prefix){
		V3D vec = new V3D();
		vec.x = map.getFloat(prefix + "x", 0f);
		vec.y = map.getFloat(prefix + "y", 0f);
		vec.z = map.getFloat(prefix + "z", 0f);
		return vec;
	}

}
