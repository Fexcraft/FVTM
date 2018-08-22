package net.fexcraft.mod.fvtm.impl;

import java.io.File;

public abstract class HybridAddon extends GenericAddon {

    public HybridAddon(File file){
        super(file);
        hybrid = true;
    }

    /**
     * Set `true` if you want to skip default JSON config search and parsing for this addon.
     */
    public boolean skipDefaultRegistryMethods(){ return false; }
    
}
