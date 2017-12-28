package net.fexcraft.mod.fvtm.api;

import java.util.TreeMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public abstract class ConstructorScreen {
	
	private static final TreeMap<String, ConstructorScreen> MAP = new TreeMap<String, ConstructorScreen>();
	
	public static final void addScreen(String id, ConstructorScreen screen) throws Exception {
		if(!MAP.containsKey(id)){
			MAP.put(id, screen);
		}
		else{
			throw new Exception("A Screen with the ID `" + id + "` already exists!");
		}
	}

	public static final void addScreens(String[] strs, ConstructorScreen screen) throws Exception {
		for(String str : strs){
			addScreen(str, screen);
		}
	}
	
	public static final void addScreens(Object... objs){
		for(int i = 0; i < objs.length; i += 2){
			if(i + 1 >= objs.length){
				break;
			}
			try{
				addScreen((String)objs[i], (ConstructorScreen)objs[i + 1]);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static final void replaceScreen(String id, ConstructorScreen screen) throws Exception {
		if(!MAP.containsKey(id)){
			throw new Exception("No Screen to replace! (`" + id + "`);");
		}
		else{
			MAP.put(id, screen);
		}
	}

	public static final ConstructorScreen getScreen(String window){
		return MAP.containsKey(window) ? MAP.get(window) : null;
	}

	public abstract void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args);

	public abstract void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound);
	
	protected static final void fill(ConstructorEntity ent, int j, NBTTagCompound compound){
		for(int i = j; i < ent.getRows(); i++){
			compound.setString("Text" + i, "");
		}
	}

	public String getColorBar(byte f, String c){
		String str = "&7-=|";
		int i = 0;
		while((f -= 1) > -128){
			i++;
		}
		int j = (i + 1) / 16;
		boolean b = (i + 1) % 16 != 0;
		for(int k = 0; k < j; k++){
			str += "&" + c + "#";
		}
		if(b){
			str += "&e#";
		}
		for(int l = 0; l < ((16 - j) - (b ? 1 : 0)); l++){
			str += "&8#";
		}
		return str + "&7|=-";
	}

}