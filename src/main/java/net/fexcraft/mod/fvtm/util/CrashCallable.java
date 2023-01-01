package net.fexcraft.mod.fvtm.util;

import java.io.File;

import net.minecraftforge.fml.common.ICrashCallable;

public class CrashCallable implements ICrashCallable {

	@Override
	public String call() throws Exception {
		String[] lines = new String[Resources.ADDONS.size()];
		int size = 0;
		for(int i = 0; i < lines.length; i++){
			if(Resources.ADDONS.get(i).getRegistryName().getPath().length() > size){
				size = Resources.ADDONS.get(i).getRegistryName().getPath().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] = "| " + String.format("%-" + (size + 1) + "s", Resources.ADDONS.get(i).getRegistryName().getPath());
		}
		//
		size = 0;
		for(int i = 0; i < lines.length; i++){
			if(Resources.ADDONS.get(i).getName().length() > size){
				size = Resources.ADDONS.get(i).getName().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] += "| " + String.format("%-" + (size + 1) + "s", Resources.ADDONS.get(i).getName());
		}
		//
		size = 0;
		for(int i = 0; i < lines.length; i++){
			if(Resources.ADDONS.get(i).getVersion().length() > size){
				size = Resources.ADDONS.get(i).getVersion().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] += "| " + String.format("%-" + (size + 1) + "s", Resources.ADDONS.get(i).getVersion());
		}
		//
		size = 4;
		File file;
		for(int i = 0; i < lines.length; i++){
			file = Resources.ADDONS.get(i).getFile();
			String filename = file == null ? "null" : file.toString();
			lines[i] += "| " + String.format("%-64s", "..." + (filename.length() > 64 ? filename.substring(filename.length() - 64) : filename));
		}
		String string = new String();
		for(int i = 0; i < lines.length; i++){
			string += "\n\t" + lines[i] + "|";
		}
		return string + "\n";
	}

	@Override
	public String getLabel(){
		return "\n\tFVTM Addons";
	}
	
}