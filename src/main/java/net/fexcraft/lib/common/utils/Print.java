package net.fexcraft.lib.common.utils;

import net.fexcraft.lib.common.Static;

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
	
}