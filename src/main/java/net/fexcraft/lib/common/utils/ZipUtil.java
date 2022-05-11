package net.fexcraft.lib.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;

public class ZipUtil {

	public static JsonObject getJsonObject(File file, String target){
		try{
			JsonObject obj = null;
			ZipFile zip = new ZipFile(file);
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null){
					break;
				}
				if(entry.getName().equals(target)){
					obj = JsonUtil.getObjectFromInputStream(zip.getInputStream(entry));
					break;
				}
			}
			reader.close();
			zip.close();
			stream.close();
			return obj;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static boolean contains(File file, String target){
		try{
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null){
					break;
				}
				if(entry.getName().equals(target)){
					stream.close();
					return true;
				}
			}
			stream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public static final JsonArray getJsonObjectsAt(File file, String path, String extension){
		JsonArray array = new JsonArray();
		try{
			ZipFile zip = new ZipFile(file);
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null){
					break;
				}
				if(entry.getName().startsWith(path) && entry.getName().endsWith(extension)){
					array.add(JsonUtil.getObjectFromInputStream(zip.getInputStream(entry)));
				}
			}
			zip.close();
			stream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return array;
	}

	public static final Map<String, JsonObject> getJsonObjectsAt(File file, String path, String extension, boolean sorted){
		Map<String, JsonObject> map = sorted ? new TreeMap<String, JsonObject>() : new HashMap<String, JsonObject>();
		try{
			ZipFile zip = new ZipFile(file);
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null){
					break;
				}
				if(entry.getName().startsWith(path) && entry.getName().endsWith(extension)){
					map.put(entry.getName().replace(path, "").replace(extension, ""), JsonUtil.getObjectFromInputStream(zip.getInputStream(entry)));
				}
			}
			zip.close();
			stream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

	//

	public static final JsonArray getJsonElementsAt(File file, String path, String extension){
		return getJsonElementsAt(file, path, extension, 0);
	}

	public static final JsonArray getJsonElementsAt(File file, String path, String extension, int limit){
		JsonArray array = new JsonArray();
		try{
			ZipFile zip = new ZipFile(file);
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			while(true){
				if(limit > 0 && array.size() >= limit) break;
				ZipEntry entry = stream.getNextEntry();
				if(entry == null){
					break;
				}
				if(entry.getName().startsWith(path) && entry.getName().endsWith(extension)){
					array.add(JsonUtil.getElementFromInputStream(zip.getInputStream(entry)));
				}
			}
			zip.close();
			stream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return array;
	}

	public static final Map<String, JsonElement> getJsonElementsAt(File file, String path, String extension, boolean sorted){
		Map<String, JsonElement> map = sorted ? new TreeMap<String, JsonElement>() : new HashMap<String, JsonElement>();
		try{
			ZipFile zip = new ZipFile(file);
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null){
					break;
				}
				if(entry.getName().startsWith(path) && entry.getName().endsWith(extension)){
					map.put(entry.getName().replace(path, "").replace(extension, ""), JsonUtil.getElementFromInputStream(zip.getInputStream(entry)));
				}
			}
			zip.close();
			stream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

}