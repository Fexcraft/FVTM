package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.fexcraft.mod.fvtm.util.config.Config;
import org.apache.commons.io.FilenameUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.utils.HttpUtil;
import net.fexcraft.lib.common.utils.ZipUtil;
import net.fexcraft.lib.mc.FCL;
import net.fexcraft.lib.mc.network.Network;
import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockItem;
import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Pallet;
import net.fexcraft.mod.fvtm.api.Pallet.PalletData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.blocks.Pallet.PalletItem;
import net.fexcraft.mod.fvtm.blocks.UniversalBlock;
import net.fexcraft.mod.fvtm.impl.GenericAddon;
import net.fexcraft.mod.fvtm.impl.GenericConsumable;
import net.fexcraft.mod.fvtm.impl.GenericConsumableItem;
import net.fexcraft.mod.fvtm.impl.GenericCreativeTab;
import net.fexcraft.mod.fvtm.impl.GenericMaterial;
import net.fexcraft.mod.fvtm.impl.GenericMaterialItem;
import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.fexcraft.mod.fvtm.impl.block.CrafterBlockScriptBase;
import net.fexcraft.mod.fvtm.impl.block.GenericBlock;
import net.fexcraft.mod.fvtm.impl.block.GenericBlockItem;
import net.fexcraft.mod.fvtm.impl.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.impl.caps.WorldResourcesUtil;
import net.fexcraft.mod.fvtm.impl.container.GenericContainer;
import net.fexcraft.mod.fvtm.impl.container.GenericContainerItem;
import net.fexcraft.mod.fvtm.impl.part.GenericPart;
import net.fexcraft.mod.fvtm.impl.part.GenericPartItem;
import net.fexcraft.mod.fvtm.impl.vehicle.GenericVehicle;
import net.fexcraft.mod.fvtm.impl.vehicle.GenericVehicleItem;
import net.fexcraft.mod.fvtm.model.ObjModelWrapper;
import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.fvtm.model.container.ContainerModel;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class Resources {

	public static IForgeRegistry<Addon> ADDONS;
	public static IForgeRegistry<Fuel> FUELS;
	public static IForgeRegistry<Material> MATERIALS;
	public static IForgeRegistry<Part> PARTS;
	public static IForgeRegistry<Vehicle> VEHICLES;
	public static IForgeRegistry<Container> CONTAINERS;
	public static IForgeRegistry<Block> BLOCKS;
	public static IForgeRegistry<Consumable> CONSUMABLES;
	public static IForgeRegistry<Pallet> PALLETS;
	public static TreeMap<String, Model<?, ?>> MODELS = new TreeMap<String, Model<?, ?>>();
	public static TreeMap<ResourceLocation, SoundEvent> SOUNDS = new TreeMap<ResourceLocation, SoundEvent>();
	public static TreeMap<String, JsonObject> PRESETS = new TreeMap<String, JsonObject>();
	public static IForgeRegistry<Attribute> PARTATTRIBUTES;
	public static ResourceLocation NULL_TEXTURE = new ResourceLocation("fvtm:textures/entities/null_texture.png");
	public static ResourceLocation TRANSPARENT_TEXTURE = new ResourceLocation("fvtm:textures/entities/transparent_texture.png");
	private final File configpath/*, addonconfig*/;
	private Method method;

	public Resources(FMLPreInitializationEvent event){
		configpath = new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fvtm/");
		if(!configpath.exists()){
			configpath.mkdirs();
		}
		//addonconfig = new File(configpath, "/addonpacks.fex");
		//
		ADDONS = new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
		FUELS = new RegistryBuilder<Fuel>().setName(new ResourceLocation("fvtm:fuels")).setType(Fuel.class).create();
		MATERIALS = new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
		PARTS = new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
		VEHICLES = new RegistryBuilder<Vehicle>().setName(new ResourceLocation("fvtm:vehicles")).setType(Vehicle.class).create();
		PARTATTRIBUTES = new RegistryBuilder<Attribute>().setName(new ResourceLocation("fvtm:attributes")).setType(Attribute.class).create();
		CONTAINERS = new RegistryBuilder<Container>().setName(new ResourceLocation("fvtm:containers")).setType(Container.class).create();
		CONSUMABLES = new RegistryBuilder<Consumable>().setName(new ResourceLocation("fvtm:consumables")).setType(Consumable.class).create();
		BLOCKS = new RegistryBuilder<Block>().setName(new ResourceLocation("fvtm:blocks")).setType(Block.class).create();
		PALLETS = new RegistryBuilder<Pallet>().setName(new ResourceLocation("fvtm:pallets")).setType(Pallet.class).create();
		//
		try{
			method = (java.net.URLClassLoader.class).getDeclaredMethod("addURL", java.net.URL.class);
			method.setAccessible(true);
		}
		catch(Exception e){
			Print.log("Failed to get class loader. All content loading may fail badly.");
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public void regMinecraftBlocks(RegistryEvent.Register<net.minecraft.block.Block> event){
		event.getRegistry().register(UniversalBlock.INSTANCE);
		//
	}

	@SubscribeEvent
	public void regItems(RegistryEvent.Register<Item> event){
		event.getRegistry().register(GenericMaterialItem.INSTANCE);
		event.getRegistry().register(GenericPartItem.INSTANCE);
		event.getRegistry().register(GenericVehicleItem.INSTANCE);
		event.getRegistry().register(GenericContainerItem.INSTANCE);
		event.getRegistry().register(GenericConsumableItem.INSTANCE);
		event.getRegistry().register(GenericBlockItem.INSTANCE);
		//
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void regModels(net.minecraftforge.client.event.ModelRegistryEvent event){
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericMaterialItem.INSTANCE, new GenericMaterialItem.ItemMeshDef());
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericPartItem.INSTANCE, new GenericPartItem.ItemMeshDef());
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericVehicleItem.INSTANCE, new GenericVehicleItem.ItemMeshDef());
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericContainerItem.INSTANCE, new GenericContainerItem.ItemMeshDef());
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericConsumableItem.INSTANCE, new GenericConsumableItem.ItemMeshDef());
		net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericBlockItem.INSTANCE, new GenericBlockItem.ItemMeshDef());
	}		

	@SubscribeEvent
	public void regAddons(RegistryEvent.Register<Addon> event){
		event.getRegistry().register(FVTM.INTERNAL_ADDON);
		boolean defload = !(Config.ADDONS_FOLDER.equals("mods") || Config.ADDONS_FOLDER.equals("/mods") || Config.ADDONS_FOLDER.equals("/mods/"));
		File[] folders = new File[defload ? 3 : 2];
		if(defload){ folders[2] = new File("./" + Config.ADDONS_FOLDER + "/"); }
		folders[1] = new File("./mods/" + FCL.getMinecraftVersion() + "/");
		folders[0] = new File("./mods/");
		ClassLoader cl = net.minecraft.server.MinecraftServer.class.getClassLoader();
		ArrayList<ResourceLocation> defloaded = new ArrayList<>();
		for(int folder = 0; folder < folders.length; folder++){
			String parent = folder == 0 ? "/mods/" : folder == 1 ? "/mods/" + FCL.getMinecraftVersion() + "/" : "/" + Config.ADDONS_FOLDER + "/";
			AddonList.checkFolder(folders[folder], parent); if(!folders[folder].exists() || !folders[folder].isDirectory()) continue;
			for(File file : folders[folder].listFiles()){
				if(AddonList.isAddonContainer(parent, file)){
					try{
						/*if(folder == 2)*/ method.invoke(cl, file.toURI().toURL());
						Addon addon = GenericAddon.isHybrid(file) ? HybridAddon.getClass(file).getConstructor(File.class).newInstance(file) : new GenericAddon(file);
						ADDONS.register(addon); /*if(folder == 2)*/ defloaded.add(addon.getRegistryName());
					}
					catch(Exception e){
						e.printStackTrace();
					
					}
				}
			}
		} AddonList.save();
		for(ResourceLocation loc : defloaded){
			Addon addon = ADDONS.getValue(loc); if(addon == null) continue;
			Print.log("Registering Addonpack Manually into Forge/Minecraft resources... (" + addon.getName() + ")");
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("modid", addon.getRegistryName().getResourcePath());
			map.put("name", "[FVTM]: " + addon.getName());
			map.put("version", addon.getVersion());
			String clazz = addon instanceof HybridAddon ? "net.fexcraft.mod.fvtm.impl.HybridAddon" : "net.fexcraft.mod.fvtm.impl.GenericAddon";
			FMLModContainer container = new FMLModContainer(clazz, new ModCandidate(addon.getFile(), addon.getFile(), addon.getFile().isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
			container.bindMetadata(new MetadataCollection());
			FMLCommonHandler.instance().addModToResourcePack(container);
		}
		ADDONS.getValuesCollection().forEach(addon ->  new GenericCreativeTab(addon));
		if(Static.side().isClient() && defloaded.size() > 0){
			//net.minecraft.client.Minecraft.getMinecraft().refreshResources();
			net.minecraftforge.fml.client.FMLClientHandler.instance().refreshResources();
		}
	}

	@SubscribeEvent
	public void regMaterials(RegistryEvent.Register<Material> event){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled() && addon.getFile() != null /* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File matfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/materials/");
					Print.debug(matfol.getPath());
					if(!matfol.exists()){
						matfol.mkdirs();
					}
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
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled() && addon.getFile() != null /* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File partfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/parts/");
					Print.debug(partfol.getPath());
					if(!partfol.exists()){
						partfol.mkdirs();
					}
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
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled() && addon.getFile() != null /* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File vehfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/vehicles/");
					Print.debug(vehfol.getPath());
					if(!vehfol.exists()){
						vehfol.mkdirs();
					}
					for(File file : vehfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".vehicle")){
							GenericVehicle veh = new GenericVehicle(JsonUtil.get(file));
							event.getRegistry().register(veh);
							if(Static.side().isClient()){
								if(Config.RENDER_IN_GUI){
									net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(veh.getRegistryName(), (VehicleModel)veh.getModel());
								}
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
										if(Config.RENDER_IN_GUI){
											net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(veh.getRegistryName(), (VehicleModel)veh.getModel());
										}
										net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericVehicleItem.INSTANCE, veh.getRegistryName());
									}
								}
							}
						}
						Print.debug(file.getPath());
						//else skip;
					}
					//check for presets
					File presetfolder = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/presets/");
					Print.debug(presetfolder.getPath());
					if(!presetfolder.exists()){
						presetfolder.mkdirs();
					}
					for(File file : presetfolder.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".preset")){
							JsonElement elm = JsonUtil.read(file, false);
							if(elm != null){
								PRESETS.put(addon.getRegistryName().toString() + "/" + file.getName().replace(".preset", ""), elm.getAsJsonObject());
							}
							Print.debug(file.getName());
						}
						else if(file.isDirectory()){
							for(File fl : file.listFiles()){
								if(fl.getName().endsWith(".preset")){
									JsonElement elm = JsonUtil.read(file, false);
									if(elm != null){
										PRESETS.put(addon.getRegistryName().toString() + "/" + file.getName() + "/" + fl.getName().replace(".preset", ""), elm.getAsJsonObject());
									}
									Print.debug(file.getName());
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
							if(Config.RENDER_IN_GUI){
								net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(veh.getRegistryName(), (VehicleModel)veh.getModel());
							}
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericVehicleItem.INSTANCE, veh.getRegistryName());
						}
						Print.debug(veh.getRegistryName());
					}
					//check for presets
					Map<String, JsonObject> arr = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/presets/", ".preset", true);
					for(Entry<String, JsonObject> entry : arr.entrySet()){
						PRESETS.put(addon.getRegistryName().toString() + "/" + entry.getKey(), entry.getValue());
						Print.debug(entry.getKey());
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void regPartAttributes(RegistryEvent.Register<Attribute> event){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
		}
	}

	@SubscribeEvent
	public void regFuels(RegistryEvent.Register<Fuel> event){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
		}
	}

	@SubscribeEvent
	public void regSounds(RegistryEvent.Register<SoundEvent> event){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
		}
		VEHICLES.getValuesCollection().forEach((vehicle) -> {
			vehicle.getSounds().forEach((soundloc) -> {
				if(event.getRegistry().containsKey(soundloc)){
					SOUNDS.put(soundloc, event.getRegistry().getValue(soundloc));
				}
				if(SOUNDS.containsKey(soundloc)){
					vehicle.setSoundEvent(SOUNDS.get(soundloc));
				}
				else{
					SoundEvent soundevent = new SoundEvent(soundloc).setRegistryName(soundloc);
					event.getRegistry().register(soundevent);
					vehicle.setSoundEvent(soundevent);
					SOUNDS.put(soundloc, soundevent);
				}
			});
		});
		PARTS.getValuesCollection().forEach((part) -> {
			part.getSounds().forEach((soundloc) -> {
				if(event.getRegistry().containsKey(soundloc)){
					SOUNDS.put(soundloc, event.getRegistry().getValue(soundloc));
				}
				if(SOUNDS.containsKey(soundloc)){
					part.setSoundEvent(SOUNDS.get(soundloc));
				}
				else{
					SoundEvent soundevent = new SoundEvent(soundloc).setRegistryName(soundloc);
					event.getRegistry().register(soundevent);
					part.setSoundEvent(soundevent);
					SOUNDS.put(soundloc, soundevent);
				}
			});
			//Print.debug(part.getSounds());
		});
		//Print.debug(" - - - - - - ");
		//Print.debug(SOUNDS.values());
		//Static.halt();
	}

	@SubscribeEvent
	public void regContainers(RegistryEvent.Register<Container> event){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled() && addon.getFile() != null /* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File confol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/containers/");
					Print.debug(confol.getPath());
					if(!confol.exists()){
						confol.mkdirs();
					}
					for(File file : confol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".container")){
							GenericContainer con = new GenericContainer(JsonUtil.get(file));
							event.getRegistry().register(con);
							if(Static.side().isClient()){
								if(Config.RENDER_IN_GUI){
									net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(con.getRegistryName(), (ContainerModel)con.getModel());
								}
								net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericContainerItem.INSTANCE, con.getRegistryName());
							}
							Print.debug(con.getRegistryName());
						}
						else if(file.isDirectory()){
							for(File fl : file.listFiles()){
								if(fl.getName().endsWith(".container")){
									GenericContainer con = new GenericContainer(JsonUtil.get(fl));
									event.getRegistry().register(con);
									if(Static.side().isClient()){
										if(Config.RENDER_IN_GUI){
											net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(con.getRegistryName(), (ContainerModel)con.getModel());
										}
										net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericContainerItem.INSTANCE, con.getRegistryName());
									}
									Print.debug(con.getRegistryName());
								}
							}
						}
						Print.debug(file.getPath());
						//else skip;
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/containers/", ".container");
					for(JsonElement elm : array){
						GenericContainer con = new GenericContainer(elm.getAsJsonObject());
						event.getRegistry().register(con);
						if(Static.side().isClient()){
							if(Config.RENDER_IN_GUI){
								net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(con.getRegistryName(), (ContainerModel)con.getModel());
							}
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericContainerItem.INSTANCE, con.getRegistryName());
						}
						Print.debug(con.getRegistryName());
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void regConsumables(RegistryEvent.Register<Consumable> event){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled() && addon.getFile() != null /* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File matfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/consumables/");
					Print.debug(matfol.getPath());
					if(!matfol.exists()){
						matfol.mkdirs();
					}
					for(File file : matfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".consumable")){
							GenericConsumable con = new GenericConsumable(JsonUtil.get(file));
							event.getRegistry().register(con);
							if(Static.side().isClient()){
								net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericConsumableItem.INSTANCE, con.getRegistryName());
							}
							Print.debug(con.getRegistryName());
						}
						else if(file.isDirectory()){
							for(File fl : file.listFiles()){
								if(fl.getName().endsWith(".consumable")){
									GenericConsumable con = new GenericConsumable(JsonUtil.get(fl));
									event.getRegistry().register(con);
									if(Static.side().isClient()){
										net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericConsumableItem.INSTANCE, con.getRegistryName());
									}
									Print.debug(con.getRegistryName());
								}
							}
						}
						Print.debug(file.getPath());
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/consumables/", ".consumable");
					for(JsonElement elm : array){
						GenericConsumable con = new GenericConsumable(elm.getAsJsonObject());
						event.getRegistry().register(con);
						if(Static.side().isClient()){
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericConsumableItem.INSTANCE, con.getRegistryName());
						}
						Print.debug(con.getRegistryName());
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void regBlocks(RegistryEvent.Register<Block> event){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon)addon).isHybrid() && ((HybridAddon)addon).skipDefaultRegistryMethods()){
					continue;
				}
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled() && addon.getFile() != null /* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File matfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/blocks/");
					Print.debug(matfol.getPath());
					if(!matfol.exists()){
						matfol.mkdirs();
					}
					for(File file : matfol.listFiles()){
						if(!file.isDirectory() && file.getName().endsWith(".block")){
							GenericBlock block = new GenericBlock(JsonUtil.get(file));
							event.getRegistry().register(block);
							if(Static.side().isClient()){
								net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericBlockItem.INSTANCE, block.getRegistryName());
								net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(block.getRegistryName(), (BlockModel)block.getModel());
							}
							Print.debug(block.getRegistryName());
						}
						else if(file.isDirectory()){
							for(File fl : file.listFiles()){
								if(fl.getName().endsWith(".block")){
									GenericBlock block = new GenericBlock(JsonUtil.get(fl));
									event.getRegistry().register(block);
									if(Static.side().isClient()){
										net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericConsumableItem.INSTANCE, block.getRegistryName());
										net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(block.getRegistryName(), (BlockModel)block.getModel());
									}
									Print.debug(block.getRegistryName());
								}
							}
						}
						Print.debug(file.getPath());
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/blocks/", ".block");
					for(JsonElement elm : array){
						GenericBlock block = new GenericBlock(elm.getAsJsonObject());
						event.getRegistry().register(block);
						if(Static.side().isClient()){
							net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericConsumableItem.INSTANCE, block.getRegistryName());
							net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(block.getRegistryName(), (BlockModel)block.getModel());
						}
						Print.debug(block.getRegistryName());
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void regRecipes(RegistryEvent.Register<IRecipe> event){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon instanceof GenericAddon){
				if(((GenericAddon) addon).isHybrid()){
					if(((HybridAddon) addon).skipDefaultRegistryMethods()){
						continue;
					}
				}
			}
			else{
				continue;
			}
			Print.debug(addon.getRegistryName());
			if(addon.isEnabled() && addon.getFile() != null /* && !addon.hasMissingDependencies()*/){
				if(addon.getFile().isDirectory()){
					File matfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/recipes/");
					Print.debug(matfol.getPath());
					if(!matfol.exists()){
						matfol.mkdirs();
					}
					for(File file : matfol.listFiles()){
						if(!file.isDirectory() && (file.getName().endsWith(".recipe") || file.getName().endsWith(".recipes"))){
							CrafterBlockScriptBase.registerRecipes(JsonUtil.read(file, false), null, null);
						}
						else if(file.isDirectory()){
							for(File fl : file.listFiles()){
								if(fl.getName().endsWith(".recipe") || fl.getName().endsWith(".recipes")){
									CrafterBlockScriptBase.registerRecipes(JsonUtil.read(file, false), null, null);
								}
							}
						}
						Print.debug(file.getPath());
					}
				}
				else{
					JsonArray array = ZipUtil.getJsonElementsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/recipes/", ".recipe");
					for(JsonElement elm : array){
						CrafterBlockScriptBase.registerRecipes(elm, null, null);
					}
					array = ZipUtil.getJsonElementsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/recipes/", ".recipes");
					for(JsonElement elm : array){
						CrafterBlockScriptBase.registerRecipes(elm, null, null);
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public static <T, K> Model<T, K> getModel(String name, Class<T> dataclazz, Class<K> keyclazz, Class<? extends Model<T, K>> clazz){
		if(name == null || name.equals("") || name.equals("null")){
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		if(MODELS.containsKey(name)){
			return (Model<T, K>)MODELS.get(name);
		}
		if(FCLRegistry.getModel(name) != null){
			MODELS.put(name, FCLRegistry.getModel(name));
			return FCLRegistry.getModel(name);
		}
		String ext = FilenameUtils.getExtension(name);
		Model<T, K> model = null;
		try{
			switch(ext){
				case "class":
					Class<?> clasz = Class.forName(name.replace(".class", ""));
					model = (Model<T, K>)clasz.newInstance();
					break;
				case "jtmt":
					JsonObject obj = JsonUtil.getObjectFromInputStream(net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(name)).getInputStream());
					model = clazz.getConstructor(JsonObject.class).newInstance(obj);
					break;
				case "json":
					//TODO create a wrapper.
					break;
				case "obj":
					model = new ObjModelWrapper<T, K>(name);
					break;
				case "": default: return (Model<T, K>)getEmptyModelFromClass(clazz);
			}
		}
		catch(Throwable thr){
			Print.log("Failed to find/parse model with adress '" + name + "'!");
			thr.printStackTrace(); //TODO re-active after model converting Static.stop();
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		MODELS.put(name, model);
		return model;
	}

	private static Model<?, ?> getEmptyModelFromClass(Class<? extends Model<?, ?>> clazz){
		if(clazz == BlockModel.class) return BlockModel.EMPTY;
		if(clazz == ContainerModel.class) return ContainerModel.EMPTY;
		if(clazz == PartModel.class) return PartModel.EMPTY;
		if(clazz == VehicleModel.class) return VehicleModel.EMPTY;
		return null;
	}

	public static final VehicleData getVehicleData(NBTTagCompound compound){
		if(compound == null){
			return null;
		}
		if(compound.hasKey(VehicleItem.NBTKEY) || compound.hasKey(VehicleItem.OLDNBTKEY)){
			Vehicle vehicle = VEHICLES.getValue(new ResourceLocation(compound.hasKey(VehicleItem.NBTKEY) ? compound.getString(VehicleItem.NBTKEY) : compound.getString(VehicleItem.OLDNBTKEY)));
			if(vehicle != null){
				try{
					return vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle).readFromNBT(compound);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else{
				System.out.println("NBTTagCompound supposed to hold vehicle data, but Vehicle could not be found. Thus will be deleted, here though the data so you can possibly respawn it: ");
				System.out.println(compound.toString());
			}
		}
		return null;
	}

	public static final PartData getPartData(NBTTagCompound compound){
		if(compound == null){
			return null;
		}
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

	public static ContainerData getContainerData(NBTTagCompound compound){
		if(compound.hasKey(ContainerItem.NBTKEY)){
			Container con = CONTAINERS.getValue(new ResourceLocation(compound.getString(ContainerItem.NBTKEY)));
			if(con != null){
				try{
					return con.getDataClass().getConstructor(Container.class).newInstance(con).readFromNBT(compound);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static BlockData getBlockData(NBTTagCompound compound){
		if(compound.hasKey(BlockItem.NBTKEY)){
			Block block = BLOCKS.getValue(new ResourceLocation(compound.getString(BlockItem.NBTKEY)));
			if(block != null){
				try{
					return block.getDataClass().getConstructor(Block.class).newInstance(block).readFromNBT(compound);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static PalletData getPalletData(NBTTagCompound compound){
		if(compound.hasKey(PalletItem.NBTKEY)){
			Pallet pallet = PALLETS.getValue(new ResourceLocation(compound.getString(PalletItem.NBTKEY)));
			if(pallet != null){
				try{
					return pallet.getDataClass().getConstructor(Pallet.class).newInstance(pallet).readFromNBT(compound);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// UPDATE CHECKS //
	private TreeMap<ResourceLocation, String> updatelist = new TreeMap<ResourceLocation, String>();

	public void checkForUpdates(){
		ADDONS.forEach((addon) -> {
			String str = addon.getUpdateId();
			if(str != null && !str.equals("") && !str.equals(GenericAddon.NONE) && !str.equals(FVTM.MODID)){
				JsonObject obj = HttpUtil.request("http://fexcraft.net/minecraft/fcl/request", "mode=exists&modid=" + str);
				if(obj != null && obj.has("exists") && obj.get("exists").getAsBoolean()){
					obj = Network.getModData(str);
					if(obj != null && obj.has("versions")){
						JsonArray array = obj.get("versions").getAsJsonArray();
						for(JsonElement elm : array){
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
									break;
								}
							}
						}
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
		return Resources.VEHICLES.getValuesCollection().stream().filter(p -> p.getType() == type).collect(Collectors.toList());
	}

	public static final List<Vehicle> getVehiclesByAddon(Addon addon){
		return Resources.VEHICLES.getValuesCollection().stream().filter(p -> p.getAddon().getRegistryName().equals(addon.getRegistryName())).collect(Collectors.toList());
	}

	public final File getConfigPath(){
		return configpath;
	}

	public static NetworkRegistry.TargetPoint getTargetPoint(Entity ent){
		return new NetworkRegistry.TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, Config.VEHICLE_UPDATE_RANGE);
	}
	
	/*@SubscribeEvent
	public void onAttachPartCapabilities(AttachCapabilitiesEvent<PartData> event){
		for(Addon addon : ADDONS){
			if(addon.isEnabled() && addon instanceof HybridAddon){
				((HybridAddon)addon).onAttachCapabilities(event);
			}
		}
	}*/
	
	@SubscribeEvent
	public void onAttachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event){
		if(event.getObject().getItem() instanceof VehicleItem || event.getObject().getItem() instanceof PartItem || event.getObject().getItem() instanceof BlockItem){
			event.addCapability(new ResourceLocation("fvtm:vapdatacache"), new VAPDataCache(event.getObject()));
		}
	}
	
	@SubscribeEvent
	public void onAttachWorldCapabilities(AttachCapabilitiesEvent<World> event){
		event.addCapability(new ResourceLocation("fvtm:resources"), new WorldResourcesUtil(event.getObject()));
	}
	
	private static Field flightdata;
	private static boolean flightdata_failed = false;
	/** completely not seen something similar somewhere **/
	public static void resetFlight(EntityPlayerMP passenger){
		if(flightdata == null && !flightdata_failed){
			try{
				flightdata = ReflectionHelper.findField(NetHandlerPlayServer.class,  "floatingTickCount", "field_147365_f");
			}
			catch(Exception e){
				Print.log("Failed to get field. [FLIGHTDATA:ERR:0]");
			}
		}
		if(flightdata != null && !flightdata_failed){
			try{
				flightdata.setInt(passenger.connection, 0);
			}
			catch(IllegalArgumentException | IllegalAccessException e){
				if(Static.dev()){
					e.printStackTrace();
				}
				flightdata_failed = true;
			}
		}
		/*passenger.lastTickPosX = passenger.prevPosX;
		passenger.lastTickPosY = passenger.prevPosY;
		passenger.lastTickPosZ = passenger.prevPosZ;*/
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(String string){
		return getModelInputStream(new ResourceLocation(string));
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(ResourceLocation resloc){
		try{
			return net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(resloc).getInputStream();
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
}
