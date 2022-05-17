package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.utils.Print;
import net.fexcraft.lib.common.utils.ZipUtil;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.Addon.ContainerType;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Tabbed;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.util.Config.PackFolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.loading.FMLPaths;

public class Resources {
	
	public static RegistryMap<Addon> ADDONS = new RegistryMap<>();
	public static RegistryMap<Fuel> ALLFUELS = new RegistryMap<>();
	public static RegistryMap<Material> MATERIALS = new RegistryMap<>();
	public static TreeMap<String, TreeMap<String, ArrayList<Fuel>>> FUELS = new TreeMap<>();
	//
	public static final NamedResourceLocation NULL_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/null.png");
	public static final NamedResourceLocation WHITE_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/white.png");
	
	
	public static class RegistryMap<T extends TypeCore<T>> extends HashMap<ResourceLocation, T> {
		
		public void register(T obj){
			this.put(obj.getRegistryName(), obj);
		}
		
	}


	public static Addon getAddon(String string){
		for(Addon addon : ADDONS.values()){
			if(addon.getRegistryName().getPath().equals(string)) return addon;
		}
		return null;
	}


	public static void findAndLoadAddons(){
		File root = FMLPaths.GAMEDIR.get().toFile();
		ADDONS.put(InternalAddon.REGNAME, new InternalAddon());
		searchAddonsInFolder(new File(root, "/resourcepacks/"), AddonLocation.RESOURCEPACK, false);
		searchAddonsInFolder(new File(root, "/config/fvtm/packs/"), AddonLocation.LITEPACK, true);
		if(Config.LOAD_LITE_FROM_MODS) searchAddonsInFolder(new File(root, "/mods/"), AddonLocation.MODJAR, false);
		for(PackFolder pf : Config.packfolders){
			searchAddonsInFolder(pf.mdk() ? new File(pf.file(), "/src/main/") : pf.file(), pf.addonloc(), false);
		}
	}

	public static void loadAddonContent(){
		//registerAttributeTypes();
		//registerModifierImpls();
		//registerFunctions();
		//
		searchInAddonsFor(DataType.FUEL);
		searchInAddonsFor(DataType.MATERIAL);
		/*searchInAddonsFor(DataType.CONSUMABLE);
		searchInAddonsFor(DataType.CLOTH);
		searchInAddonsFor(DataType.RAILGAUGE);
		searchInAddonsFor(DataType.WIRE);
		searchInAddonsFor(DataType.CONTAINER);
		searchInAddonsFor(DataType.BLOCK);
		searchInAddonsFor(DataType.PART);
		searchInAddonsFor(DataType.VEHICLE);*/
		//TODO load addon content
	}

	private static void searchInAddonsFor(DataType datatype){
		for(Addon addon : ADDONS.values()){
			try{
				addon.searchFor(datatype);
			}
			catch(Throwable thr){
				thr.printStackTrace();
				Static.stop();
			}
		}
	}


	private static void searchAddonsInFolder(File packfolder, AddonLocation loc, boolean create){
		Print.log(packfolder);
		if(!packfolder.exists()){
			if(!create) return;
			packfolder.mkdirs();
		}
		for(File file : packfolder.listFiles()){
			if(file.isHidden()) continue;
			if(file.isDirectory()){
				File assets = new File(file, "assets/");
				if(assets.exists()){
					for(File fl : assets.listFiles()){
						if(!fl.isDirectory()) continue;
						File dec = new File(fl, "addonpack.fvtm");
						if(dec.exists()){
							JsonObject obj = JsonUtil.get(dec);
							if(isDuplicate(obj)) continue;
							ADDONS.register(new Addon(ContainerType.DIR, file, loc).parse(obj));
						}
					}
				}
			}
			else if(file.getName().endsWith(".zip") || file.getName().endsWith(".jar")){
				JsonArray array = ZipUtil.getJsonElementsAt(file, "assets", "addonpack.fvtm", 1);
				if(array.size() > 0){
					JsonObject obj = array.get(0).getAsJsonObject();
					if(isDuplicate(obj)) continue;
					Addon addon = new Addon(ContainerType.ZIP, file, loc).parse(obj);
					ADDONS.register(addon);
				}
			}
		}
	}

	private static boolean isDuplicate(JsonObject obj){
		if(!obj.has("RegistryName")) return false;
		String regname = obj.get("RegistryName").getAsString();
		for(Addon addon : ADDONS.values()){
			if(addon.getRegistryName().toString().equals(regname)) return true;
		}
		return false;
	}

	public static Fuel getFuel(String id){
		return getFuel(new ResourceLocation(id));
	}

	public static Fuel getFuel(ResourceLocation resloc){
		return ALLFUELS.get(resloc);
	}

	public static String getFuelName(String id){
		return getFuelName(new ResourceLocation(id));
	}

	public static String getFuelName(ResourceLocation resloc){
		Fuel fuel = getFuel(resloc); return fuel == null ? "not-found" : fuel.getName();
	}

	public static CreativeModeTab getCreativeTab(Tabbed type){
		String tab = type.getCreativeTab();
		Addon addon = null;
		if(tab.contains(":")){
			String[] split = tab.split(":");
			addon = getAddon(split[0]);
			if(addon == null) return null;
			return addon.getCreativeTab(split[1]);
		}
		addon = ((TypeCore<?>)type).getAddon();
		return addon.getDefaultCreativeTab();
	}

}
