package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

import com.flansmod.common.util.Util;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.VehicleType;
import net.fexcraft.mod.fvtm.impl.GenericAddon;
import net.fexcraft.mod.fvtm.impl.GenericVehicle;
import net.fexcraft.mod.fvtm.impl.GenericVehicleItem;
import net.fexcraft.mod.fvtm.impl.GenericMaterial;
import net.fexcraft.mod.fvtm.impl.GenericMaterialItem;
import net.fexcraft.mod.fvtm.impl.GenericPart;
import net.fexcraft.mod.fvtm.impl.GenericPartItem;
import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class Resources {
	
	public static final String DEFPACKCFGFILENAME = "addonpack.fvtm";
	public static IForgeRegistry<Addon> ADDONS;// = (IForgeRegistry<Addon>)new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
	public static IForgeRegistry<Fuel> FUELS;// = (IForgeRegistry<Fuel>)new RegistryBuilder<Fuel>().setName(new ResourceLocation("fvtm:fuels")).setType(Fuel.class).create();
	public static IForgeRegistry<Material> MATERIALS;// = (IForgeRegistry<Material>)new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
	public static IForgeRegistry<Part> PARTS;// = (IForgeRegistry<Part>)new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
	public static IForgeRegistry<Vehicle> VEHICLES;// = (IForgeRegistry<LandVehicle>)new RegistryBuilder<LandVehicle>().setName(new ResourceLocation("fvtm:landvehicles")).setType(LandVehicle.class).create();
	public static TreeMap<String, Object> MODELS = new TreeMap<String, Object>();
	public static TreeMap<ResourceLocation, SoundEvent> SOUNDS = new TreeMap<ResourceLocation, SoundEvent>();
	public static IForgeRegistry<Attribute> PARTATTRIBUTES;// = (IForgeRegistry<Attribute>)new RegistryBuilder<Attribute>().setName(new ResourceLocation("fvtm:attributes")).setType(Attribute.class).create();
	public static ResourceLocation NULL_TEXTURE = new ResourceLocation("fvtm:textures/entities/null_texture.png");
	private final File configpath, addonconfig;
	private Method method;
	
	public Resources(){
		configpath = new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fvtm/");
		if(!configpath.exists()){
			configpath.mkdirs();
		}
		addonconfig = new File(configpath, "/addonpacks.fex");
		//
		ADDONS = (IForgeRegistry<Addon>)new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
		FUELS = (IForgeRegistry<Fuel>)new RegistryBuilder<Fuel>().setName(new ResourceLocation("fvtm:fuels")).setType(Fuel.class).create();
		MATERIALS = (IForgeRegistry<Material>)new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
		PARTS = (IForgeRegistry<Part>)new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
		VEHICLES = (IForgeRegistry<Vehicle>)new RegistryBuilder<Vehicle>().setName(new ResourceLocation("fvtm:vehicles")).setType(Vehicle.class).create();
		PARTATTRIBUTES = (IForgeRegistry<Attribute>)new RegistryBuilder<Attribute>().setName(new ResourceLocation("fvtm:attributes")).setType(Attribute.class).create();
	}

	public void updateAddonConfig() {
		JsonArray array = new JsonArray();
		for(Addon addon : ADDONS.getValues()){
			JsonObject obj = new JsonObject();
			obj.addProperty("id", addon.getRegistryName().toString());
			obj.addProperty("state", addon.isEnabled());
			array.add(obj);
		}
		JsonUtil.write(addonconfig, array);
	}

	private void queryAddons(){
		try{
			JsonArray array = JsonUtil.read(addonconfig, true, new JsonArray()).getAsJsonArray();
			for(JsonElement elm : array){
				try{
					Addon addon = ADDONS.getValue(new ResourceLocation(elm.getAsJsonObject().get("id").getAsString()));
					if(addon != null){
						addon.setEnabled(elm.getAsJsonObject().get("state").getAsBoolean());
					}
				}
				catch(Exception e){
					//
				}
			}
			this.updateAddonConfig();
			for(Addon pack : ADDONS.getValues()){
				for(ResourceLocation id : pack.getDependencies()){
					if(ADDONS.getValue(id) == null){
						pack.setMissingDependencies(true);
						continue;
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SubscribeEvent
	public void regItems(RegistryEvent.Register<Item> event){
		event.getRegistry().register(GenericMaterialItem.INSTANCE);
		event.getRegistry().register(GenericPartItem.INSTANCE);
		event.getRegistry().register(GenericVehicleItem.INSTANCE);
		
		//
	}
	
	@SubscribeEvent @SideOnly(Side.CLIENT)
	public void regModels(net.minecraftforge.client.event.ModelRegistryEvent event){
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericMaterialItem.INSTANCE, new GenericMaterialItem.ItemMeshDef());
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericPartItem.INSTANCE, new GenericPartItem.ItemMeshDef());
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericVehicleItem.INSTANCE, new GenericVehicleItem.ItemMeshDef());
	}
	
	@SubscribeEvent
	public void regAddons(RegistryEvent.Register<Addon> event){
		ClassLoader cl = net.minecraft.server.MinecraftServer.class.getClassLoader();
		try{
			method = (java.net.URLClassLoader.class).getDeclaredMethod("addURL", java.net.URL.class);
			method.setAccessible(true);
		}
		catch (Exception e){
			Util.log("Failed to get class loader. All content loading will now fail.");
			e.printStackTrace();
		}
		
		File addonfolder = new File(FCL.getInstance().getConfigDirectory().getParentFile().getParentFile(), "/addons/");
		if(!addonfolder.exists()){
			addonfolder.mkdirs();
		}
		for(File file : addonfolder.listFiles()){
			if(Addon.isAddonContainer(file)){
				try{
					method.invoke(cl, file.toURI().toURL());
					Addon addon = GenericAddon.isHybrid(file) ? HybridAddon.getClass(file).getConstructor(File.class).newInstance(file) : new GenericAddon(file);
					event.getRegistry().register(addon);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		for(Addon addon : ADDONS.getValues()){
			if(Static.side().isClient()){
				Print.log("Registering Addonpack into Forge/Minecraft resources...");
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("modid", addon.getRegistryName().getResourcePath());
				map.put("name", "[FVTM]: " + addon.getFile().getName());
				map.put("version", addon.getVersion());
				FMLModContainer container = new FMLModContainer("net.fexcraft.mod.fvtm.FVTM", new ModCandidate(addon.getFile(), addon.getFile(), addon.getFile().isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
				container.bindMetadata(MetadataCollection.from(null, ""));
				net.minecraftforge.fml.client.FMLClientHandler.instance().addModAsResource(container);
			}
		}
		if(Static.side().isClient() && ADDONS.getEntries().size() > 0){
			net.minecraft.client.Minecraft.getMinecraft().refreshResources();
		}
	}
	
	@SubscribeEvent
	public void regMaterials(RegistryEvent.Register<Material> event){
		this.queryAddons();
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regMaterials(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File matfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/materials/");
					Print.debug(matfol.getPath());
					if(!matfol.exists()){ matfol.mkdirs();}
					for(File file : matfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".material")){
							GenericMaterial mat = new GenericMaterial(JsonUtil.get(file));
							event.getRegistry().register(mat);
							if(Static.side().isClient()){
								net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericMaterialItem.INSTANCE, mat.getRegistryName());
							}
							Print.debug(mat.getRegistryName());
						}
						else if(file.isDirectory()){
							for(File fl : file.listFiles()){
								if(fl.getName().endsWith(".material")){
									GenericMaterial mat = new GenericMaterial(JsonUtil.get(fl));
									event.getRegistry().register(mat);
									if(Static.side().isClient()){
										net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericMaterialItem.INSTANCE, mat.getRegistryName());
									}
									Print.debug(mat.getRegistryName());
								}
							}
						}
						Print.debug(file.getPath());
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/materials/", ".material");
					for(JsonElement elm : array){
						GenericMaterial mat = new GenericMaterial(elm.getAsJsonObject());
						event.getRegistry().register(mat);
						if(Static.side().isClient()){
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericMaterialItem.INSTANCE, mat.getRegistryName());
						}
						Print.debug(mat.getRegistryName());
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void regParts(RegistryEvent.Register<Part> event){
		this.queryAddons();
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regParts(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File partfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/parts/");
					Print.debug(partfol.getPath());
					if(!partfol.exists()){ partfol.mkdirs();}
					for(File file : partfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".part")){
							GenericPart part = new GenericPart(JsonUtil.get(file));
							event.getRegistry().register(part);
							if(Static.side().isClient()){
								net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, part.getRegistryName());
							}
							Print.debug(part.getRegistryName());
						}
						else if(file.isDirectory()){
							for(File fl : file.listFiles()){
								if(fl.getName().endsWith(".part")){
									GenericPart part = new GenericPart(JsonUtil.get(fl));
									event.getRegistry().register(part);
									if(Static.side().isClient()){
										net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, part.getRegistryName());
									}
									Print.debug(part.getRegistryName());
								}
							}
						}
						Print.debug(file.getPath());
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/parts/", ".part");
					for(JsonElement elm : array){
						GenericPart part = new GenericPart(elm.getAsJsonObject());
						event.getRegistry().register(part);
						if(Static.side().isClient()){
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, part.getRegistryName());
						}
						Print.debug(part.getRegistryName());
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void regVehicles(RegistryEvent.Register<Vehicle> event){
		this.queryAddons();
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regVehicles(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File vehfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/vehicles/");
					Print.debug(vehfol.getPath());
					if(!vehfol.exists()){ vehfol.mkdirs();}
					for(File file : vehfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".vehicle")){
							GenericVehicle veh = new GenericVehicle(JsonUtil.get(file));
							event.getRegistry().register(veh);
							if(Static.side().isClient()){
								net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericVehicleItem.INSTANCE, veh.getRegistryName());
							}
							Print.debug(veh.getRegistryName());
						}
						else if(file.isDirectory()){
							for(File fl : file.listFiles()){
								if(fl.getName().endsWith(".vehicle")){
									GenericVehicle veh = new GenericVehicle(JsonUtil.get(fl));
									event.getRegistry().register(veh);
									if(Static.side().isClient()){
										net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericVehicleItem.INSTANCE, veh.getRegistryName());
									}
								}
							}
						}
						Print.debug(file.getPath());
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/vehicles/", ".vehicle");
					for(JsonElement elm : array){
						GenericVehicle veh = new GenericVehicle(elm.getAsJsonObject());
						event.getRegistry().register(veh);
						if(Static.side().isClient()){
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericVehicleItem.INSTANCE, veh.getRegistryName());
						}
						Print.debug(veh.getRegistryName());
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void regPartAttributes(RegistryEvent.Register<Attribute> event){
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regAttributes(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
		}
	}
	
	@SubscribeEvent
	public void regFuels(RegistryEvent.Register<Fuel> event){
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regFuels(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
		}
	}
	
	@SubscribeEvent
	public void regSounds(RegistryEvent.Register<SoundEvent> event){
		for(Addon addon : ADDONS.getValues()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid()){
					((HybridAddon)addon).regSounds(event);
					if(((HybridAddon)addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
		}
		this.VEHICLES.getValues().forEach((vehicle) -> {
			vehicle.getSounds().forEach((soundloc) -> {
				if(SOUNDS.containsKey(soundloc)){
					vehicle.setSound(soundloc, SOUNDS.get(soundloc));
				}
				else{
					SoundEvent soundevent = new SoundEvent(soundloc).setRegistryName(soundloc);
					event.getRegistry().register(soundevent);
					vehicle.setSound(soundloc, soundevent);
					SOUNDS.put(soundloc, soundevent);
				}
			});
		});
		this.PARTS.getValues().forEach((part) -> {
			part.getSounds().forEach((soundloc) -> {
				if(SOUNDS.containsKey(soundloc)){
					part.setSound(soundloc, SOUNDS.get(soundloc));
				}
				else{
					SoundEvent soundevent = new SoundEvent(soundloc).setRegistryName(soundloc);
					event.getRegistry().register(soundevent);
					part.setSound(soundloc, soundevent);
					SOUNDS.put(soundloc, soundevent);
				}
			});
			//Print.debug(part.getSounds());
		});
		//Print.debug(" - - - - - - ");
		//Print.debug(SOUNDS.values());
		//Static.halt();
	}

	@SideOnly(Side.CLIENT)
	public static <T> T getModel(String name, Class<T> clazz, T def){
		if(name == null || name.equals("") || name.equals("null")){
			return def;
		}
		if(MODELS.containsKey(name)){
			return (T)MODELS.get(name);
		}
		ModelType type = getModelType(name);
		T model = null;
		try{
			switch(type){
				case JAVA:
				case TMT:
					Class clasz = Class.forName(name.replace(".class", ""));
					model = (T)clasz.newInstance();
					break;
				case JTMT:
					JsonObject obj = JsonUtil.getObjectFromInputStream(net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(name)).getInputStream());
					model = (T)clazz.getConstructor(JsonObject.class).newInstance(obj);
					break;
				case JSON:
					//TODO
					break;
				case NONE:
				case OBJ:
				default:
					break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		MODELS.put(name, model);
		return model;
	}
	
	public static ModelType getModelType(String modelname){
		String str = FilenameUtils.getExtension(modelname);
		switch(str){
			case "class": return ModelType.TMT;
			case "json": return ModelType.JSON;
			case "jtmt": return ModelType.JTMT;
			case "obj": return ModelType.OBJ;
		}
		return ModelType.NONE;
	}
	
	public static final VehicleData getVehicleData(NBTTagCompound compound, boolean remote){
		if(compound.hasKey(VehicleItem.NBTKEY) || compound.hasKey(VehicleItem.OLDNBTKEY)){
			Vehicle vehicle = VEHICLES.getValue(new ResourceLocation(compound.hasKey(VehicleItem.NBTKEY) ? compound.getString(VehicleItem.NBTKEY) : compound.getString(VehicleItem.OLDNBTKEY)));
			if(vehicle != null){
				try{
					return vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle).readFromNBT(compound, remote);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else{
				Print.log("NBTTagCompound supposed to hold vehicle data, but Vehicle could not be found. Thus will be deleted, here though the data so you can possibly respawn it: ");
				Print.log(compound.toString());
			}
		}
		return null;
	}
	
	public static final PartData getPartData(NBTTagCompound compound){
		if(compound.hasKey(PartItem.NBTKEY)){
			Part part = PARTS.getValue(new ResourceLocation(compound.getString(PartItem.NBTKEY)));
			if(part != null){
				try{
					return part.getDataClass().getConstructor(Part.class).newInstance(part).readFromNBT(compound);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static final PartData getPartData(ResourceLocation rs){
		Part part = PARTS.getValue(rs);
		if(part != null){
			try{
				return part.getDataClass().getConstructor(Part.class).newInstance(part).readFromNBT(new NBTTagCompound());
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// UPDATE CHECKS //
	
	private TreeMap<ResourceLocation, String> updatelist = new TreeMap<ResourceLocation, String>();

	public void checkForUpdates(){
		ADDONS.forEach((addon) -> {
			String str = addon.getUpdateId();
			if(str != null && !str.equals("") && !str.equals(GenericAddon.NONE)){
				JsonObject obj = Network.request("http://fexcraft.net/minecraft/fcl/request", "mode=exists&modid=" + str);
				if(obj != null && obj.has("exists") && obj.get("exists").getAsBoolean()){
					obj = Network.getModData(str);
					if(obj != null && obj.has("versions")){
						JsonArray array = obj.get("versions").getAsJsonArray();
						array.forEach((elm) -> {
							JsonObject jsn = elm.getAsJsonObject();
							if(jsn.get("version").getAsString().equals(FCL.mcv)){
								String lv = jsn.get("latest_version").getAsString();
								if(!lv.equals(addon.getVersion())){
									//updatelist.add(addon.getRegistryName().toString() + ":" + lv);
									//actually, let's also check the FVTM version
									//might get removed tho ^ :thinking:
									boolean proceed = true;
									if(jsn.has("fvtm_version")){
										proceed = jsn.get("fvtm_version").getAsString().equals(FVTM.VERSION);
									}
									if(proceed){
										updatelist.put(addon.getRegistryName(), lv);
									}
								}
							}
						});
					}
				}
				else{
					Print.debug("NEGATIVE RESPONSE FOR '" + str + "' >>:>> " + (obj == null ? "null" : obj));
				}
			}
		});
	}
	
	@SubscribeEvent
	public void onJoin(PlayerEvent.PlayerLoggedInEvent event){
		if(event.player.world.isRemote){
			return;
		}
		for(Entry<ResourceLocation, String> entry : updatelist.entrySet()){
			Addon addon = ADDONS.getValue(entry.getKey());
			Print.chat(event.player, "&0[&9FVTM&0]&7 === === &5=&6=&5=&7 === ===");
			Print.chat(event.player, "&0[&9FVTM&0]&7 Update for Addon &8'&3" + addon.getName() + "&8'&7 found!");
			Print.chat(event.player, "&0[&9FVTM&0]&7 Installed Version: &3" + addon.getVersion());
			Print.chat(event.player, "&0[&9FVTM&0]&7 Latest Version: &3" + entry.getValue());
			Print.link(event.player, "&0[&9FVTM&0]&7 Download ?: &3&o&lCLICK", addon.getURL());
		}
	}
	
	public static final List<Vehicle> getVehiclesByType(VehicleType type){
		return Resources.VEHICLES.getValues().stream().filter(p -> p.getType() == type).collect(Collectors.toList());
	}
	
}