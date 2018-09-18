package net.fexcraft.mod.fvtm.util;

import java.io.File;

import net.minecraftforge.fml.common.ICrashCallable;

public class CrashCallable implements ICrashCallable {

	@SuppressWarnings("deprecation") @Override
	public String call() throws Exception {
		String[] lines = new String[Resources.ADDONS.getValues().size()];
		int size = 0;
		for(int i = 0; i < lines.length; i++){
			if(Resources.ADDONS.getValues().get(i).getRegistryName().getResourcePath().length() > size){
				size = Resources.ADDONS.getValues().get(i).getRegistryName().getResourcePath().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] = "| " + String.format("%-" + (size + 1) + "s", Resources.ADDONS.getValues().get(i).getRegistryName().getResourcePath());
		}
		//
		size = 0;
		for(int i = 0; i < lines.length; i++){
			if(Resources.ADDONS.getValues().get(i).getName().length() > size){
				size = Resources.ADDONS.getValues().get(i).getName().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] += "| " + String.format("%-" + (size + 1) + "s", Resources.ADDONS.getValues().get(i).getName());
		}
		//
		size = 0;
		for(int i = 0; i < lines.length; i++){
			if(Resources.ADDONS.getValues().get(i).getVersion().length() > size){
				size = Resources.ADDONS.getValues().get(i).getVersion().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] += "| " + String.format("%-" + (size + 1) + "s", Resources.ADDONS.getValues().get(i).getVersion());
		}
		//
		size = 4;
		File file;
		for(int i = 0; i < lines.length; i++){
			file = Resources.ADDONS.getValues().get(i).getFile();
			String filename = file == null ? "null" : file.toString();
			lines[i] += "| " + String.format("%-64s", "..." + (filename.length() > 64 ? filename.substring(filename.length() - 64) : filename));
		}
		String string = new String();
		/*for(Addon addon : Resources.ADDONS){
			string +="\n\t| " + addon.getRegistryName().getResourcePath() + "\t| " + addon.getName() + "\t| " + addon.getVersion() + "\t| " + addon.getFileAddress();
		}*/
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