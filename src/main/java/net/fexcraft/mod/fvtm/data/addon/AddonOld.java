package net.fexcraft.mod.fvtm.data.addon;

import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATIONS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATION_CATEGORIES;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.TextureSupply;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.sys.condition.Condition;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.impl.ClothMaterialWrapper;
import net.fexcraft.mod.uni.item.ClothMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Deprecated
public class AddonOld extends TypeCore<AddonOld> {
	
	protected ArrayList<String> authors = new ArrayList<>();
	protected String version, url, license, update_id;
	protected boolean enabled = true, generatelang, generatejson, generateicon;
	protected File file, lang;
	protected ContainerType contype;
	protected HashMap<String, ArmorMaterial> armats = new HashMap<>();
	protected LinkedHashMap<String, TextureSupply> supp_tex = new LinkedHashMap<>();
	protected AddonLocation loc;
	//
	@SideOnly(Side.CLIENT)
	protected HashMap<String, CreativeTabs> creativetabs;
	
	public AddonOld(ContainerType type, File file){
		this(type, file, AddonLocation.MODJAR);
	}
	
	public AddonOld(ContainerType type, File file, AddonLocation loc){
		this.contype = type;
		this.file = file;
		this.loc = loc;
	}

	@Override
	public AddonOld parse(JsonObject obj){
		registryname = DataUtil.getRegistryName((Addon)null, obj);
		if(registryname == null) return null;
		//pack = this;
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
		generatelang = JsonUtil.getIfExists(obj, "GenerateLang", false);
		generatejson = JsonUtil.getIfExists(obj, "GenerateItemJson", false);
		generateicon = JsonUtil.getIfExists(obj, "GenerateItemIcon", false);
		//
		if(Static.side().isClient()){
			creativetabs = new HashMap<>();
			if(!obj.has("CreativeTabs") /*|| obj.get("CreativeTabs").getAsJsonArray().size() == 0*/){
				//this.creativetabs.put(AddonTab.DEFAULT, new AddonTab(this, AddonTab.DEFAULT));
			}
			else{
				obj.get("CreativeTabs").getAsJsonArray().forEach(elm -> {
					//this.creativetabs.put(elm.getAsString(), new AddonTab(this, elm.getAsString()));
				});
			}
		}
		if(obj.has("ClothMaterials")){
			obj.get("ClothMaterials").getAsJsonObject().entrySet().forEach(entry -> {
				armats.put(entry.getKey(), ((ClothMaterialWrapper) ClothMaterial.create(IDLManager.getIDLCached(registryname.getPath() + ":" + entry.getKey()), JsonHandler.parse(entry.getValue().toString(), true).asMap())).material);
			});
		}
		if(obj.has("SupplyTextures")){
			JsonObject supp = obj.get("SupplyTextures").getAsJsonObject();
			supp.entrySet().forEach(entry -> {
				supp_tex.put(entry.getKey(), new TextureSupply(entry.getKey(), JsonHandler.parse(entry.getValue().toString(), true).asMap()));
			});
		}
		if(obj.has("Particles") && Static.isClient()){
			JsonObject par = obj.get("Particles").getAsJsonObject();
			for(Entry<String, JsonElement> entry : par.entrySet()){
				new net.fexcraft.mod.fvtm.sys.particle.Particle(registryname.getPath() + ":" + entry.getKey(), JsonHandler.parse(entry.getValue().toString(), true).asMap());
			}
		}
		if(obj.has("Conditions")){
			JsonObject par = obj.get("Conditions").getAsJsonObject();
			for(Entry<String, JsonElement> entry : par.entrySet()){
				JsonValue<?> jsn = JsonHandler.parse(entry.getValue().toString(), true);
				Condition cond = null;
				if(jsn.isArray()){
					cond = new Condition(registryname.getPath() + ":" + entry.getKey(), jsn.asArray());
				}
				else{
					cond = new Condition(registryname.getPath() + ":" + entry.getKey(), jsn.asMap());
				}
				ConditionRegistry.register(cond);
			}
		}
		if(obj.has("TrafficSigns")){
			JsonObject tsn = obj.get("TrafficSigns").getAsJsonObject();
			TrafficSignLibrary.AddonLib lib = new TrafficSignLibrary.AddonLib(registryname.getPath());
			if(tsn.has("backgrounds")){
				for(Entry<String, JsonElement> elm : tsn.get("backgrounds").getAsJsonObject().entrySet()){
					lib.backgrounds.put(elm.getKey(), elm.getValue().getAsString());
				}
			}
			if(tsn.has("components")){
				for(Entry<String, JsonElement> elm : tsn.get("components").getAsJsonObject().entrySet()){
					lib.components.put(elm.getKey(), elm.getValue().getAsString());
				}
			}
			if(tsn.has("fonts")){
				for(Entry<String, JsonElement> elm : tsn.get("fonts").getAsJsonObject().entrySet()){
					lib.fonts.put(elm.getKey(), elm.getValue().getAsString());
				}
			}
			if(tsn.has("presets")){
				for(Entry<String, JsonElement> elm : tsn.get("presets").getAsJsonObject().entrySet()){
					//lib.presets.put(elm.getKey(), elm.getValue().getAsJsonObject());
				}
			}
			TrafficSignLibrary.LIBRARIES.put(lib.id, lib);
			lib.load();
		}
		if(obj.has("Decorations")){
			JsonObject cats = obj.get("Decorations").getAsJsonObject();
			for(Entry<String, JsonElement> entry : cats.entrySet()){
				String category = entry.getKey();
				JsonObject decos = entry.getValue().getAsJsonObject();
				for(Entry<String, JsonElement> entr : decos.entrySet()){
					String key = getRegistryName().getPath() + ":" + entr.getKey();
					DECORATIONS.put(key, new DecorationData(key, category, JsonHandler.parse(entr.getValue().toString(), true)));
				}
				if(decos.size() > 0 && !DECORATION_CATEGORIES.contains(category)){
					DECORATION_CATEGORIES.add(category);
				}
			}
		}
		return this;
	}

	@Override
	public ContentType getDataType(){
		return ContentType.ADDON;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}
	
	public List<String> getAuthors(){
		return ImmutableList.copyOf(authors);
	}
	
	public File getFile(){ return file; }
	public ContainerType getContainerType(){ return contype; }
	@Override
	public String getName(){ return name; }
	public String getVersion(){ return version; }
	public String getURL(){ return url; }
	public String getLicense(){ return license; }
	public String getUpdateId(){ return update_id; }
	
	public AddonOld setEnabled(boolean bool){
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
		return obj;
	}

	private boolean isItemModelMissing(TypeCore<?> type){
		try{
			net.minecraft.client.resources.IResource res = net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(type.getRegistryName().getNamespace(), "textures/items/" + type.getRegistryName().getPath() + ".png"));
			return res == null;
		}
		catch(IOException e){
			//e.printStackTrace();
			return true;
		}
	}

	private void checkLangFile(TypeCore<?> core){
		if(lang == null) lang = new File((loc.isNotAMod() ? file : file.getParentFile()), (loc.isNotAMod() ? "" : "/src/main/resources") + "/assets/" + registryname.getPath() + "/lang/en_us.lang");
		String regname = /*(core instanceof Block ? "tile." :*/"item."/*)*/ + core.getRegistryName().toString() + ".name=";
		if(!containsLangEntry(regname)){
			try{
				Files.write(lang.toPath(), ("\n" + regname).getBytes(), StandardOpenOption.APPEND);
			}
			catch(IOException e){
				e.printStackTrace();
			}
			Print.log("Added lang entry '" + regname.replace("=", "") + "'!");
		}
	}

	private void checkItemJson(TypeCore<?> core, ContentType data){
		File json = new File((loc.isNotAMod() ? file : file.getParentFile()), (loc.isNotAMod() ? "" : "/src/main/resources") + "/assets/" + core.getRegistryName().getNamespace() + "/models/item/" + core.getRegistryName().getPath() + ".json");
		if(!json.exists()){
			if(!json.getParentFile().exists()) json.getParentFile().mkdirs();
			JsonObject obj = new JsonObject();
			obj.addProperty("parent", "item/generated");
			JsonObject textures = new JsonObject();
			textures.addProperty("layer0", core.getRegistryName().getNamespace() + ":items/" + core.getRegistryName().getPath());
			obj.add("textures", textures);
			obj.addProperty("__comment", "Autogenerated Item JSON via FVTM.");
			JsonUtil.write(json, obj);
			Print.log("Generated item json for '" + core.getRegistryName().toString() + "'!");
		}
		//TODO eventually an alternative model for blocks?
	}
	
	private static final String gitph = "https://raw.githubusercontent.com/Fexcraft/FVTM/1.12.2/placeholders/ph_%s.png";
	private static BufferedImage img, img_veh, img_part;

	private void checkItemIcon(TypeCore<?> core, ContentType data){
		File icon = new File((loc.isNotAMod() ? file : file.getParentFile()), (loc.isNotAMod() ? "" : "/src/main/resources") + "/assets/" + core.getRegistryName().getNamespace() + "/textures/items/" + core.getRegistryName().getPath() + ".png");;
		if(!icon.exists()){
			if(!icon.getParentFile().exists()) icon.getParentFile().mkdirs();
			BufferedImage image = null;
			if(data == ContentType.VEHICLE){
				if(img_veh == null){
					img_veh = DataUtil.tryDownload(String.format(gitph, "vehicle"));
				}
				image = img_veh;
			}
			else if(data == ContentType.PART){
				if(img_part == null){
					img_part = DataUtil.tryDownload(String.format(gitph, "part"));
				}
				image = img_part;
			}
			else{
				if(img == null){
					img = DataUtil.tryDownload(String.format(gitph, "general"));
				}
				image = img;
			}
			try{
				ImageIO.write(image, "png", icon);
			}
			catch(IOException e){
				e.printStackTrace();
			}
			Print.log("Generated item icon for '" + core.getRegistryName().toString() + "'!");
		}
	}

	private boolean containsLangEntry(String regname){
		try{
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(lang);
			while(scanner.hasNext()){
				if(scanner.nextLine().startsWith(regname)) return true;
			} scanner.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<File> findFiles(File file, String suffix){
		ArrayList<File> result = new ArrayList<>();
		if(file.isDirectory()){
			for(File sub : file.listFiles()){
				ArrayList<File> search = findFiles(sub, suffix);
				if(!search.isEmpty()) result.addAll(search);
			}
		}
		else if(file.getName().endsWith(suffix)) result.add(file);
		return result;
	}

	@SideOnly(Side.CLIENT)
	public CreativeTabs getDefaultCreativeTab(){
		if(creativetabs.size() == 0) return null;
		if(creativetabs.containsKey("default"))
			return creativetabs.get("default");
		else return creativetabs.values().toArray(new CreativeTabs[0])[0];
	}

	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab(String id){
		if(creativetabs.containsKey(id))
			return creativetabs.get(id);
		else return getDefaultCreativeTab();
	}

	public void loadRecipes(){
		if(!this.isEnabled()){
			Print.log("Skipping RECIPE search for Addon '" + registryname.toString() + "' since it's marked as not enabled!");
			return;
		}
		if(contype == ContainerType.DIR){
			if(!file.isDirectory()) return;
			//
			File folder = new File(file, "assets/" + registryname.getPath() + "/config/recipes/");
			if(!folder.exists()){
				folder.mkdirs();
			}
			ArrayList<File> candidates = findFiles(folder, ".recipe");
			for(File file : candidates){
				try{
					CraftBlockScript.parseRecipes(this, file.getName(), new FileInputStream(file));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		else{ // assume it's a jar.
			try{
				String path = "assets/" + registryname.getPath() + "/config/recipes/", ext = ".recipe";
				ZipFile zip = new ZipFile(file);
				ZipInputStream stream = new ZipInputStream(new FileInputStream(file));
				while(true){
					ZipEntry entry = stream.getNextEntry();
					if(entry == null){
						break;
					}
					if(entry.getName().startsWith(path) && entry.getName().endsWith(ext)){
						CraftBlockScript.parseRecipes(this, "ZIPENTRY", zip.getInputStream(entry));
					}
				}
				zip.close();
				stream.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public HashMap<String, ArmorMaterial> getClothMaterials(){
		return armats;
	}
	
	public AddonLocation getLoc(){
		return loc;
	}

	public LinkedHashMap<String, TextureSupply> getTextureSuppliers(){
		return supp_tex;
	}

}
