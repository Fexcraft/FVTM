package net.fexcraft.mod.fvtm.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.utils.ZipUtil;
import net.fexcraft.lib.mc.registry.FCLRegistry.AutoRegisterer;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Addon extends TypeCore<Addon> {
	
	protected ArrayList<String> authors = new ArrayList<>(), dependencies = new ArrayList<>();
	protected String version, url, license, update_id;
	protected boolean enabled = true;
	protected File file;
	protected ContainerType contype;
	//
	@SideOnly(Side.CLIENT)
	protected CreativeTabs creativetab;
	protected AutoRegisterer registerer;
	
	public Addon(ContainerType type, File file){ this.contype = type; this.file = file; }

	@Override
	public Addon parse(JsonObject obj){
		registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		name = JsonUtil.getIfExists(obj, "Name", "Unnamed Addon");
		version = JsonUtil.getIfExists(obj, "Version", "0.o");
		if(obj.has("Authors") && obj.get("Authors").isJsonArray()){
			obj.get("Authors").getAsJsonArray().forEach(elm -> { this.authors.add(elm.getAsString()); });
		}
		if(obj.has("Author") && obj.get("Author").isJsonPrimitive()){
			this.authors.add(obj.get("Author").getAsString());
		}
		url = JsonUtil.getIfExists(obj, "URL", "http://fexcraft.net/not_found");
		license = JsonUtil.getIfExists(obj, "License", "http://fexcraft.net/not_found");
		update_id = JsonUtil.getIfExists(obj, "UpdateID", "null");
		if(obj.has("Dependencies") && obj.get("Dependencies").isJsonArray()){
			obj.get("Dependencies").getAsJsonArray().forEach(elm -> { this.dependencies.add(elm.getAsString()); });
		}
		if(obj.has("Dependency") && obj.get("Dependency").isJsonPrimitive()){
			this.dependencies.add(obj.get("Author").getAsString());
		}
		//
		if(Static.side().isClient()){ this.creativetab = new AddonTab(this); }
		this.registerer = new AutoRegisterer(this.getRegistryName().getResourcePath());
		return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.ADDON;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	@Override
	public Addon setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public Class<Addon> getRegistryType(){
		return Addon.class;
	}
	
	public List<String> getAuthors(){
		return ImmutableList.copyOf(authors);
	}
	
	public File getFile(){ return file; }
	public ContainerType getContainerType(){ return contype; }
	public String getName(){ return name; }
	public String getVersion(){ return version; }
	public String getURL(){ return url; }
	public String getLicense(){ return license; }
	public String getUpdateId(){ return update_id; }
	
	public List<String> getDependencies(){
		return dependencies;
	}
	
	public Addon setEnabled(boolean bool){
		this.enabled = bool; return this;
	}
	
	public boolean isEnabled(){ return enabled; }
	
	/** For sending over network. */
	public JsonObject toJson(){
		final JsonObject obj = new JsonObject();
		obj.addProperty("RegistryName", registryname.toString());
		obj.addProperty("Name", name);
		obj.addProperty("Version", version);
		obj.addProperty("URL", url);
		obj.addProperty("License", license);
		obj.addProperty("UpdateID", update_id);
		final JsonArray array1 = new JsonArray();
		authors.forEach(elm -> array1.add(elm));
		obj.add("Authors", array1);
		final JsonArray array0 = new JsonArray();
		dependencies.forEach(elm -> array0.add(elm));
		obj.add("Dependencies", array0);
		return obj;
	}

	public void searchFor(DataType data) throws InstantiationException, IllegalAccessException {
		if(data == DataType.ADDON) return;
		if(!this.isEnabled()){
			Print.log("Skipping " + data.name() + " search for Addon '" + registryname.toString() + "' since it's marked as not enabled!");
			return;
		}
		if(contype == ContainerType.DIR){
			if(!file.isDirectory()) return;
			//
			File folder = new File(file, "assets/" + registryname.getResourcePath() + "/config/" + data.cfg_folder + "/");
			if(!folder.exists()){ folder.mkdirs(); }
			ArrayList<File> candidates = findFiles(folder, data.suffix);
			for(File file : candidates){
				JsonObject obj = JsonUtil.get(file);
				TypeCore<?> core = (TypeCore<?>)data.core.newInstance().parse(obj);
				if(core == null){
					if(obj.has("RegistryName")) Print.log("Skipping " + data.name() + " '" + obj.get("RegistryName").getAsString() + "' due to errors.");
					continue;
				}
				data.register(core); Print.log("Registered "+ data.name() +  " with ID '" + core.getRegistryName() + "' into FVTM.");
				//TODO item/model registration
			}
		}
		else{ //assume it's a jar.
			JsonArray array = ZipUtil.getJsonObjectsAt(file, "assets/" + registryname.getResourcePath() + "/config/" + data.cfg_folder + "/", data.suffix);
			for(JsonElement elm : array){ JsonObject obj = elm.getAsJsonObject();
				TypeCore<?> core = (TypeCore<?>)data.core.newInstance().parse(obj);
				if(core == null){
					if(obj.has("RegistryName")) Print.log("Skipping PART '" + obj.get("RegistryName").getAsString() + "' due to errors.");
					continue;
				}
				data.register(core); Print.log("Registered " + data.name() + " with ID '" + core.getRegistryName() + "' into FVTM.");
				//TODO item/model registration
			}
		}
	}

	private ArrayList<File> findFiles(File file, String suffix){
		ArrayList<File> result = new ArrayList<>();
		if(file.isDirectory()){
			for(File sub : file.listFiles()){
				ArrayList<File> search = findFiles(sub, suffix);
				if(!search.isEmpty()) result.add(sub);
			}
		}
		else if(file.getName().endsWith(suffix)) result.add(file);
		return result;
	}

	public AutoRegisterer getFCLRegisterer(){
		return registerer;
	}

	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab(){
		return this.creativetab;
	}

}
