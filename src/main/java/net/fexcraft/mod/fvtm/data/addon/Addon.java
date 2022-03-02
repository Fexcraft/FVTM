package net.fexcraft.mod.fvtm.data.addon;

import java.awt.image.BufferedImage;
import java.io.File;
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

import javax.imageio.ImageIO;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.utils.ZipUtil;
import net.fexcraft.lib.mc.registry.FCLRegistry.AutoRegisterer;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.TextureSupply;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.fvtm.sys.condition.Condition;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.PresetTab;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Addon extends TypeCore<Addon> {
	
	protected ArrayList<String> authors = new ArrayList<>();
	protected String version, url, license, update_id;
	protected boolean enabled = true, lite, generatelang, generatejson, generateicon;
	protected File file, lang;
	protected ContainerType contype;
	protected HashMap<String, ArmorMaterial> armats = new HashMap<>();
	protected LinkedHashMap<String, TextureSupply> supp_tex = new LinkedHashMap<>();
	//
	@SideOnly(Side.CLIENT)
	protected HashMap<String, CreativeTabs> creativetabs;
	protected AutoRegisterer registerer;
	
	public Addon(ContainerType type, File file){
		this(type, file, false);
	}
	
	public Addon(ContainerType type, File file, boolean lite){
		this.contype = type;
		this.file = file;
		this.lite = lite;
	}

	@Override
	public Addon parse(JsonObject obj){
		registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = this;
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
				this.creativetabs.put(AddonTab.DEFAULT, new AddonTab(this, AddonTab.DEFAULT));
			}
			else{
				obj.get("CreativeTabs").getAsJsonArray().forEach(elm ->{
					this.creativetabs.put(elm.getAsString(), new AddonTab(this, elm.getAsString()));
				});
			}
		}
		this.registerer = new AutoRegisterer(this.getRegistryName().getPath());
		if(obj.has("ClothMaterials")){
			obj.get("ClothMaterials").getAsJsonObject().entrySet().forEach(entry -> {
				JsonObject data = entry.getValue().getAsJsonObject();
				int durr = JsonUtil.getIfExists(data, "durability", 1f).intValue();
				int[] ams = data.has("damage_reduction") ? JsonUtil.getIntegerArray(data.get("damage_reduction").getAsJsonArray()) : new int[]{ 0, 0, 0, 0 };
				float tgh = JsonUtil.getIfExists(obj, "toughness", 0f).floatValue();
				armats.put(entry.getKey(), EnumHelper.addArmorMaterial(entry.getKey(), Resources.NULL_TEXTURE.toString(), durr, ams, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, tgh));
			});
		}
		if(obj.has("SupplyTextures")){
			JsonObject supp = obj.get("SupplyTextures").getAsJsonObject();
			supp.entrySet().forEach(entry -> {
				supp_tex.put(entry.getKey(), new TextureSupply(entry.getKey(), entry.getValue().getAsJsonObject()));
			});
		}
		if(obj.has("WireDecos")){
			Resources.WIRE_DECO_CACHE.put(this.getRegistryName().getPath(), obj.get("WireDecos").getAsJsonObject());
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
				net.fexcraft.app.json.JsonObject<?> jsn = JsonHandler.parse(entry.getValue().toString(), true);
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
					lib.presets.put(elm.getKey(), elm.getValue().getAsJsonObject());
				}
			}
			TrafficSignLibrary.LIBRARIES.put(lib.id, lib);
			lib.load();
		}
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
			File folder = new File(file, "assets/" + registryname.getPath() + "/config/" + data.cfg_folder + "/");
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
				if(Static.side().isClient() && data.has3DItemModel()){
					if(data == DataType.VEHICLE && Config.RENDER_VEHILE_MODELS_AS_ITEMS){
						net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(core.getRegistryName(), VehicleModel.EMPTY);
					}
					else if(data == DataType.CONTAINER){
						net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(core.getRegistryName(), ContainerModel.EMPTY);
					}
					else if(data == DataType.PART){
						Part part = (Part)core;
						if(part.getDefaultFunctions().stream().filter(pre -> pre.getId().equals("fvtm:wheel")).count() > 0){
							net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(core.getRegistryName(), PartModel.EMPTY);
						}
					}
					else if(data == DataType.BLOCK){
						Block block = (Block)core;
						if(!block.hasPlainModel() && Config.RENDER_BLOCK_MODELS_AS_ITEMS){
							net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(core.getRegistryName(), BlockModel.EMPTY);
						}
					}
				}
				if(Static.dev()){
					if(generatelang) checkLangFile(core);
					if(generatejson) checkItemJson(core, data);
					if(generateicon) checkItemIcon(core, data);
				}
			}
		}
		else{ //assume it's a jar.
			JsonArray array = ZipUtil.getJsonObjectsAt(file, "assets/" + registryname.getPath() + "/config/" + data.cfg_folder + "/", data.suffix);
			for(JsonElement elm : array){ JsonObject obj = elm.getAsJsonObject();
				TypeCore<?> core = (TypeCore<?>)data.core.newInstance().parse(obj);
				if(core == null){
					if(obj.has("RegistryName")) Print.log("Skipping " + data.name() + " '" + obj.get("RegistryName").getAsString() + "' due to errors.");
					continue;
				}
				data.register(core); Print.log("Registered " + data.name() + " with ID '" + core.getRegistryName() + "' into FVTM.");
				if(Static.side().isClient() && data.has3DItemModel()){
					if(data == DataType.VEHICLE && Config.RENDER_VEHILE_MODELS_AS_ITEMS){
						net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(core.getRegistryName(), VehicleModel.EMPTY);
					}
					else if(data == DataType.CONTAINER){
						net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(core.getRegistryName(), ContainerModel.EMPTY);
					}
					else if(data == DataType.PART){
						Part part = (Part)core;
						if(part.getDefaultFunctions().stream().filter(pre -> pre.getId().equals("fvtm:wheel")).count() > 0){
							net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(core.getRegistryName(), PartModel.EMPTY);
						}
					}
					else if(data == DataType.BLOCK){
						Block block = (Block)core;
						if(!block.hasPlainModel() && Config.RENDER_BLOCK_MODELS_AS_ITEMS){
							net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(core.getRegistryName(), BlockModel.EMPTY);
						}
					}
				}
			}
		}
	}

	private void checkLangFile(TypeCore<?> core){
		if(lang == null) lang = new File((isLitePack() ? file : file.getParentFile()), (isLitePack() ? "" : "/src/main/resources") + "/assets/" + registryname.getPath() + "/lang/en_us.lang");
		String regname = (core instanceof Block ? "tile." : "item.") + core.getRegistryName().toString() + ".name=";
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

	private void checkItemJson(TypeCore<?> core, DataType data){
		File json = new File((isLitePack() ? file : file.getParentFile()), (isLitePack() ? "" : "/src/main/resources") + "/assets/" + core.getRegistryName().getNamespace() + "/models/item/" + core.getRegistryName().getPath() + ".json");
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

	private void checkItemIcon(TypeCore<?> core, DataType data){
		File icon = new File((isLitePack() ? file : file.getParentFile()), (isLitePack() ? "" : "/src/main/resources") + "/assets/" + core.getRegistryName().getNamespace() + "/textures/items/" + core.getRegistryName().getPath() + ".png");;
		if(!icon.exists()){
			if(!icon.getParentFile().exists()) icon.getParentFile().mkdirs();
			BufferedImage image = null;
			if(data == DataType.VEHICLE){
				if(img_veh == null){
					img_veh = DataUtil.tryDownload(String.format(gitph, "vehicle"));
				}
				image = img_veh;
			}
			else if(data == DataType.PART){
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

	private ArrayList<File> findFiles(File file, String suffix){
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

	public AutoRegisterer getFCLRegisterer(){
		return registerer;
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

	public void loadPresets(){
		if(!this.isEnabled()){
			Print.log("Skipping PRESET search for Addon '" + registryname.toString() + "' since it's marked as not enabled!");
			return;
		}
		if(contype == ContainerType.DIR){
			if(!file.isDirectory()) return;
			//
			File folder = new File(file, "assets/" + registryname.getPath() + "/config/presets/");
			if(!folder.exists()){
				folder.mkdirs();
			}
			ArrayList<File> candidates = findFiles(folder, ".json");
			for(File file : candidates){
				try{
					JsonObject obj = JsonUtil.get(file);
					if(obj.entrySet().isEmpty()) continue;
					Vehicle vehicle = Resources.VEHICLES.getValue(new ResourceLocation(obj.get("Vehicle").getAsString()));
					VehicleData data = (VehicleData)vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle);
					data.read(JsonToNBT.getTagFromJson(obj.toString()));
					data.setPreset(JsonUtil.getIfExists(obj, "Preset", "Nameless"));
					PresetTab.INSTANCE.add(data.newItemStack());
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		else{ // assume it's a jar.
			JsonArray array = ZipUtil.getJsonObjectsAt(file, "assets/" + registryname.getPath() + "/config/presets/", ".json");
			for(JsonElement elm : array){
				try{
					JsonObject obj = elm.getAsJsonObject();
					if(obj.entrySet().isEmpty()) continue;
					Vehicle vehicle = Resources.VEHICLES.getValue(new ResourceLocation(obj.get("Vehicle").getAsString()));
					VehicleData data = (VehicleData)vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle);
					data.read(JsonToNBT.getTagFromJson(obj.toString()));
					data.setPreset(JsonUtil.getIfExists(obj, "Preset", "Nameless"));
					PresetTab.INSTANCE.add(data.newItemStack());
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
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
			ArrayList<File> candidates = findFiles(folder, ".json");
			for(File file : candidates){
				try{
					JsonObject obj = JsonUtil.get(file);
					if(obj.entrySet().isEmpty()) continue;
					boolean override = JsonUtil.getIfExists(obj, "OverrideExisting", false);
					if(obj.has("Recipes")){
						CraftBlockScript.parseRecipes(this, file.getName(), override, obj.get("Recipes").getAsJsonArray());
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		else{ // assume it's a jar.
			JsonArray array = ZipUtil.getJsonObjectsAt(file, "assets/" + registryname.getPath() + "/config/presets/", ".json");
			for(JsonElement elm : array){
				try{
					JsonObject obj = elm.getAsJsonObject();
					if(obj.entrySet().isEmpty()) continue;
					boolean override = JsonUtil.getIfExists(obj, "OverrideExisting", false);
					if(obj.has("Recipes")){
						CraftBlockScript.parseRecipes(this, "ZIPENTRY", override, obj.get("Recipes").getAsJsonArray());
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public HashMap<String, ArmorMaterial> getClothMaterials(){
		return armats;
	}
	
	public boolean isLitePack(){
		return lite;
	}

	public LinkedHashMap<String, TextureSupply> getTextureSuppliers(){
		return supp_tex;
	}

}
