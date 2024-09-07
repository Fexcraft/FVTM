package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonValue;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ZipUtils {

	public static JsonArray getValuesAt(File file, String path, String extension){
		return getValuesAt(file, path, extension, 0);
	}

	public static JsonArray getValuesAt(File file, String path, String extension, int limit){
		JsonArray array = new JsonArray();
		try{
			ZipFile zip = new ZipFile(file);
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			while(true){
				if(limit > 0 && array.size() >= limit) break;
				ZipEntry entry = stream.getNextEntry();
				if(entry == null) break;
				if(entry.getName().startsWith(path) && entry.getName().endsWith(extension)){
					array.add(JsonHandler.parse(stream, true));
				}
			}
			stream.close();
			zip.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return array;
	}

	public static JsonValue<?> getValueAt(File file, String path, String extension){
		JsonValue<?> value = null;
		try{
			ZipFile zip = new ZipFile(file);
			ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null) break;
				if(entry.getName().startsWith(path) && entry.getName().endsWith(extension)){
					value = JsonHandler.parse(stream, true);
				}
			}
			stream.close();
			zip.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}

}
