package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraftforge.fml.common.Loader;

public class APIs {

    public final boolean TOUGHASNAILS;

    public static APIs INSTANCE;

    public APIs(){
        if(INSTANCE != null){
            Print.log("[FVTM] APIs INSTANCE ALREADY LOADED!");
            Static.halt();
        }
        INSTANCE = this;
        //
        TOUGHASNAILS = Loader.isModLoaded("toughasnails");
    }

}
