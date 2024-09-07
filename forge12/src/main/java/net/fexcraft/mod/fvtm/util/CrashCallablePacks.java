package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.FvtmRegistry.ADDONS;

import java.io.File;

import net.minecraftforge.fml.common.ICrashCallable;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CrashCallablePacks implements ICrashCallable {

	@Override
	public String call() throws Exception {
		String[] lines = new String[ADDONS.size()];
		int size = 0;
		for(int i = 0; i < lines.length; i++){
			if(ADDONS.get(i).getID().id().length() > size){
				size = ADDONS.get(i).getID().id().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] = "| " + String.format("%-" + (size + 1) + "s", ADDONS.get(i).getID().id());
		}
		//
		size = 0;
		for(int i = 0; i < lines.length; i++){
			if(ADDONS.get(i).getName().length() > size){
				size = ADDONS.get(i).getName().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] += "| " + String.format("%-" + (size + 1) + "s", ADDONS.get(i).getName());
		}
		//
		size = 0;
		for(int i = 0; i < lines.length; i++){
			if(ADDONS.get(i).getVersion().length() > size){
				size = ADDONS.get(i).getVersion().length();
			}
		}
		for(int i = 0; i < lines.length; i++){
			lines[i] += "| " + String.format("%-" + (size + 1) + "s", ADDONS.get(i).getVersion());
		}
		//
		size = 4;
		File file;
		for(int i = 0; i < lines.length; i++){
			file = ADDONS.get(i).getFile();
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