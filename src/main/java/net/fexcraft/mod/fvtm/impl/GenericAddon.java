package net.fexcraft.mod.fvtm.impl;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.lang.ArrayList;
import net.fexcraft.lib.common.utils.ZipUtil;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class GenericAddon implements Addon {

    public static final String NONE = "###EXIT###";

    private ResourceLocation registryname;
    private File file;
    private String name, version, website, license, fileaddr, updateid;
    private List<ResourceLocation> dependencies;
    private List<UUID> authors;
    private boolean enabled;
    protected boolean hybrid = false;

    /**
     * INTERNAL USE ONLY
     */
    public GenericAddon(){}

    /**
     * MAIN CONSTRUCTOR
     */
    public GenericAddon(File file){
        this.enabled = true;
        this.file = file;
        JsonObject obj = file.isDirectory() ? JsonUtil.get(new File(file, DEFPACKCFGFILENAME)) : ZipUtil.getJsonObject(file, DEFPACKCFGFILENAME);
        try{
            this.registryname = new ResourceLocation(obj.get("id").getAsString());
        }
        catch(Exception e){
            e.printStackTrace();
            Static.halt();
        }
        this.dependencies = obj.has("dependencies") ? JsonUtil.jsonArrayToResourceLocationArray(obj.get("dependencies").getAsJsonArray()) : Collections.<ResourceLocation>emptyList();
        this.authors = obj.has("authors") ? JsonUtil.jsonArrayToUUIDArray(obj.get("authors").getAsJsonArray()) : Collections.<UUID>emptyList();
        this.name = JsonUtil.getIfExists(obj, "name", "Name Missing.");
        this.website = JsonUtil.getIfExists(obj, "url", "no url provided by pack author");
        this.license = JsonUtil.getIfExists(obj, "license", "no license url provided by pack author");
        this.version = JsonUtil.getIfExists(obj, "version", "1.0");
        this.updateid = JsonUtil.getIfExists(obj, "updateid", NONE);
    }

    @Override
    public Addon setRegistryName(ResourceLocation name){
        registryname = name;
        return this;
    }

    @Override
    public ResourceLocation getRegistryName(){
        return registryname;
    }

    @Override
    public File getFile(){
        return file;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getVersion(){
        return version;
    }

    @Override
    public String getURL(){
        return website;
    }

    @Override
    public String getLicense(){
        return license;
    }

    @Override
    public String getFileAddress(){
        return fileaddr;
    }

    @Override
    public List<ResourceLocation> getDependencies(){
        return dependencies;
    }

    @Override
    public List<UUID> getAuthors(){
        return authors;
    }

    @Override
    public boolean isEnabled(){
        return enabled;
    }

    @Override
    public void setEnabled(boolean bool){
        this.enabled = bool;
    }

    /**
     * To load temporary addon copies for GUI's *
     */
    public Addon fromNBT(NBTTagCompound nbt){
        GenericAddon addon = new GenericAddon();
        addon.registryname = new ResourceLocation(nbt.getString("id"));
        addon.name = nbt.getString("name");
        addon.dependencies = JsonUtil.jsonArrayToResourceLocationArray(JsonUtil.getFromString(nbt.getString("dependencies")).getAsJsonArray());
        addon.authors = new ArrayList<UUID>();
        JsonArray authors = JsonUtil.getFromString(nbt.getString("authors")).getAsJsonArray();
        for(JsonElement elm : authors){
            addon.authors.add(UUID.fromString(elm.getAsString()));
        }
        addon.website = nbt.getString("url");
        addon.license = nbt.getString("license");
        addon.enabled = nbt.getBoolean("enabled");
        //addon.missingdeps = nbt.getBoolean("missing_dependencies");
        addon.fileaddr = nbt.getString("file");
        addon.version = nbt.getString("version");
        addon.updateid = nbt.getString("updateid");
        return addon;
    }

    public NBTTagCompound toNBT(){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("id", registryname.toString());
        nbt.setString("name", name);
        nbt.setString("dependencies", JsonUtil.getArrayFromResourceLocationList(dependencies instanceof ArrayList ? (ArrayList<ResourceLocation>) dependencies : new ArrayList<ResourceLocation>(dependencies)).toString());
        nbt.setString("authors", JsonUtil.getArrayFromUUIDList(authors instanceof ArrayList ? (ArrayList<UUID>) authors : new ArrayList<UUID>(authors)).toString());
        nbt.setString("url", website);
        nbt.setString("license", license);
        nbt.setBoolean("enabled", enabled);
        //nbt.setBoolean("missing_depencencies", missingdeps);
        nbt.setString("file", fileaddr == null ? file.toString() : fileaddr);
        nbt.setString("version", version);
        nbt.setString("updateid", updateid);
        return nbt;
    }

    public static boolean isHybrid(File file){
        JsonObject obj = file.isDirectory() ? JsonUtil.get(new File(file, DEFPACKCFGFILENAME)) : ZipUtil.getJsonObject(file, DEFPACKCFGFILENAME);
        return obj.has("class");
    }

    /**
     * internal use mostly
     */
    public final boolean isHybrid(){
        return this.hybrid;
    }

    @SuppressWarnings("unchecked")
    public static Class<Addon> getClass(File file) throws ClassNotFoundException{
        JsonObject obj = file.isDirectory() ? JsonUtil.get(new File(file, DEFPACKCFGFILENAME)) : ZipUtil.getJsonObject(file, DEFPACKCFGFILENAME);
        return (Class<Addon>) Class.forName(obj.get("class").getAsString());
    }

    @Override
    public String getUpdateId(){
        return this.updateid;
    }
    
    private List<ResourceLocation> missingdeps;

	@Override
	public List<ResourceLocation> getMissingDependencies(){
		if(missingdeps == null){
			missingdeps = new ArrayList<>();
			for(ResourceLocation dep : this.dependencies){
				if(!Resources.ADDONS.containsKey(dep)){
					missingdeps.add(dep);
				}
			}
		}
		return missingdeps;
	}

}
