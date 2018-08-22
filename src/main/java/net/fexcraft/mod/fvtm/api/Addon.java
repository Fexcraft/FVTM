package net.fexcraft.mod.fvtm.api;

import java.io.File;
import java.util.List;
import java.util.UUID;

import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Addon extends IForgeRegistryEntry<Addon> {
	
    public static final String DEFPACKCFGFILENAME = "addonpack.fvtm";

    /**
     * Internal use, can return null
     */
    public default File getFile(){
        return null;
    }

    public String getName();

    public String getVersion();

    public String getURL();

    public String getLicense();

    public String getUpdateId();

    /**
     * Internal use.
     */
    public default String getFileAddress(){
        return null;
    }

    public List<ResourceLocation> getDependencies();

    public List<UUID> getAuthors();

    public boolean isEnabled();

    public void setEnabled(boolean bool);

    public List<ResourceLocation> getMissingDependencies();

    public NBTTagCompound toNBT();

    public Addon fromNBT(NBTTagCompound nbt);

    @Override
    public default Class<Addon> getRegistryType(){
        return Addon.class;
    }

    /** Internal use. **/
    public static boolean isAddonContainer(File file){
        if(file.isDirectory()){
            File fl = new File(file, DEFPACKCFGFILENAME);
            try{
                return fl.exists();
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
        else if(file.getName().endsWith(".zip") || file.getName().endsWith(".jar")){
            return ZipUtil.contains(file, DEFPACKCFGFILENAME);
        }
        else return false;
    }

}
