package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.minecraftforge.fml.common.Loader;

public class APIs {

    public static boolean TOUGHASNAILS;
    private static boolean loaded = false;

    public static void load(){
    	if(loaded){
    		Print.log("[FVTM-API] Already loaded!");
    		Static.halt();
    	}
        TOUGHASNAILS = Loader.isModLoaded("toughasnails");
    }

	public static boolean getBooleanValue(String string){
		return Detached.getBooleanValue(string);
	}
	
	public static class Detached {
		
		public static boolean getBooleanValue(String string){
			try{
				if(string.equals("thoughasnails.enable_thirst")){
					return toughasnails.api.config.SyncedConfig.getBooleanValue(toughasnails.api.config.GameplayOption.ENABLE_THIRST);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}
		
	}

}
