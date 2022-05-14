package net.fexcraft.lib.common.utils;

import java.util.Iterator;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.FVTM;

public class Print {

	public static final void devcon(String url){
		if(!Static.devmode) return; console(url);
	}

	public static final void console(String url){
		System.out.println(url);
	}
	
	public static final void console(Object... objects){
		console(true, objects);
	}
	
	public static final void console(boolean newlines, Object... objects){
		StringBuffer buff = new StringBuffer();
		buff.append("[ " + (newlines && objects.length > 1 ? "\n" : ""));
		for(int i = 0; i < objects.length; i++){
			buff.append(objects[i] == null ? "%=NULL=%" : objects[i].toString());
			if(i < objects.length - 1) buff.append(newlines ? ",\n" : ", ");
		}
		buff.append((newlines && objects.length > 1 ? "\n" : " ") + "]");
		System.out.println(buff.toString());
	}

	public static boolean bool(boolean bool, String string){
		console(string); return bool;
	}

	public static void log(Object... objs){
		logSpaced(0, objs);
	}

	public static void logSpaced(int offset, Object... objs){
		String spacing = getSpacing(offset);
		if(objs.length == 0) log(spacing + "[ no objects to print ]");
		else if(objs.length == 1){
			if(objs[0] instanceof Iterable<?>){
				Iterator<?> it = ((Iterable<?>)objs[0]).iterator();
				log(spacing + "[");
				while(it.hasNext()) logSpaced(offset + 1, it.next());
				log(spacing + "]");
			}
			else log(spacing + (objs[0] == null ? "[ obj is null]" : objs[0].toString()));
		}
		else {
			log(spacing + "{");
			for(Object obj : objs){
				if(obj instanceof Iterable<?>){
					Iterator<?> it = ((Iterable<?>)obj).iterator();
					log(spacing + "[");
					while(it.hasNext()) logSpaced(offset + 1, it.next());
					log(spacing + "]");
				}
				else log(spacing + (objs == null ? "[ obj is null]" : obj.toString()));
			}
			log(spacing + "}");
		}
	}
	
	private static String getSpacing(int offset){
		String str = "";
		for(int i = 0; i < offset; i++){
			str += "    ";
		}
		return str;
	}

	public static void log(String str){
		FVTM.getLogger().info(str);
	}
	
}