package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.Config.U12_SYNC_RATE;
import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATIONS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.WIRE_DECO_CACHE;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.utils.ZipUtil;
import net.fexcraft.lib.mc.crafting.RecipeRegistry;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.render.FCLBlockModel;
import net.fexcraft.lib.mc.render.FCLBlockModelLoader;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.block.VPInfo;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.TextureSupply;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.addon.AddonSteeringOverlay;
import net.fexcraft.mod.fvtm.data.attribute.*;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.data.block.MultiBlock;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHolderWrapper;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Model.ModelLoader;
import net.fexcraft.mod.fvtm.data.root.Tabbed;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.event.OverlayEvent;
import net.fexcraft.mod.fvtm.event.ResourceEvents;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.model.loaders.ClassModelLoader;
import net.fexcraft.mod.fvtm.model.loaders.FMFModelLoader;
import net.fexcraft.mod.fvtm.model.loaders.JTMTModelLoader;
import net.fexcraft.mod.fvtm.model.loaders.ObjModelLoader;
import net.fexcraft.mod.fvtm.model.loaders.SMPTBJavaModelLoader;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignCapHandler;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.MultiBlockCacheSerializer;
import net.fexcraft.mod.fvtm.util.caps.PassengerCapHandler;
import net.fexcraft.mod.fvtm.util.caps.PlayerDataHandler;
import net.fexcraft.mod.fvtm.util.caps.RenderCacheHandler;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.function.*;
import net.fexcraft.mod.uni.IDL;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.LanguageMap;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.discovery.ASMDataTable.ASMData;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.FilenameUtils;

public class Resources {
	
	public static Registry<Addon> ADDONS = new Registry<>();
	public static Registry<Part> PARTS = new Registry<>();
	public static Registry<Vehicle> VEHICLES = new Registry<>();
	public static Registry<Material> MATERIALS = new Registry<>();
	public static Registry<Fuel> ALLFUELS = new Registry<>();
	public static Registry<Consumable> CONSUMABLES = new Registry<>();
	public static Registry<Container> CONTAINERS = new Registry<>();
	public static Registry<Block> BLOCKS = new Registry<>();
	public static Registry<MultiBlock> MULTIBLOCKS = new Registry<>();
	public static Registry<RailGauge> RAILGAUGES = new Registry<>();
	public static Registry<Cloth> CLOTHES = new Registry<>();
	public static Registry<WireType> WIRES = new Registry<>();
	public static TreeMap<String, TreeMap<String, ArrayList<Fuel>>> FUELS = new TreeMap<>();
	private static TreeMap<String, Class<? extends Function>> FUNCTIONS = new TreeMap<>();
	private static TreeMap<String, Class<? extends BlockFunction>> BLOCK_FUNCTIONS = new TreeMap<>();
	private static TreeMap<String, Class<? extends Attribute<?>>> ATTRIBUTE_TYPES = new TreeMap<>();
	private static TreeMap<String, Class<? extends Modifier<?>>> MODIFIER_IMPLS = new TreeMap<>();
	private static TreeMap<String, Boolean> LOADED_MODS = new TreeMap<>();
	public static TreeMap<String, Class<? extends AddonSteeringOverlay>> OVERLAYS = new TreeMap<>();
	public static final HashMap<String, Model> MODELS = new HashMap<>();
	public static final NamedResourceLocation NULL_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/null.png");
	public static final NamedResourceLocation WHITE_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/white.png");
	public static final String UTIL_LISTENER = "fvtm:utils";
	public static final ArrayList<String> WIRE_DECOS = new ArrayList<>();
	public static final ArrayList<Model.ModelLoader> MODEL_LOADERS = new ArrayList<>();
	//
	private static Field respackfile = null;
	private File configroot; 
	
	public Resources(FMLPreInitializationEvent event){
		configroot = new File(event.getModConfigurationDirectory(), "/fvtm/");
		if(!configroot.exists()) configroot.mkdirs(); //addonconfig = new File(configpath, "/addonpacks.fex");
		//
		String addonclass = AddonClass.class.getCanonicalName();
		Set<ASMData> addons = event.getAsmData().getAll(addonclass);
		for(ASMData entry : addons){
			try{
				Class<?> clazz = Class.forName(entry.getClassName());
				AddonClass addon = clazz.getAnnotation(AddonClass.class);
				String id = addon.registryname().contains(":") ? addon.registryname().split(":")[1] : addon.registryname();
				ContainerType type = entry.getCandidate().getSourceType();
				File file = entry.getCandidate().getModContainer();
				if(addon.hasJson()){
					InputStream stream = Resources.class.getClassLoader().getResourceAsStream("assets/" + id + "/addonpack.fvtm");
					if(stream == null) continue;
					JsonObject obj = JsonUtil.getObjectFromInputStream(stream);
					ADDONS.register(new Addon(type, file).parse(obj));
				}
				else{
					ADDONS.register((Addon)clazz.getConstructor(ContainerType.class, File.class).newInstance(type, file));
					// TODO find out how to get the actual instance of the mod.
				}
				Print.log("Registered FVTM Addon with ID '" + addon.registryname() + "'!");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		if(event.getSide().isClient()){
			try{
				respackfile = ReflectionHelper.findField(net.minecraft.client.resources.AbstractResourcePack.class, "resourcePackFile", "field_110597_b");
			}
			catch(Exception e){
				Print.log("Failed to get field. [RESPACKLOADER:ERR:0]");
				Print.log("LiteAddon loading from ResourcePacks will be skipped.");
			}
			catch(Error e){
				Print.log("Failed to get field. [RESPACKLOADER:ERR:00]");
				Print.log("LiteAddon loading from ResourcePacks will be skipped.");
			}
			if(respackfile != null){
				for(net.minecraft.client.resources.ResourcePackRepository.Entry entry : net.minecraft.client.Minecraft.getMinecraft().getResourcePackRepository().getRepositoryEntriesAll()){
					try{
						checkEntry(entry.getResourcePack());
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		else{
			searchAddonsInFolder(new File(event.getModConfigurationDirectory().getParent(), "/resourcepacks/"), AddonLocation.RESOURCEPACK, false);
		}
		searchAddonsInFolder(new File(configroot, "packs/"), AddonLocation.CONFIGPACK, true);
		if(Config.LOAD_PACKS_FROM_MODS) searchAddonsInFolder(new File(event.getModConfigurationDirectory().getParent(), "/mods/"), AddonLocation.CONFIGPACK, false);
		//
		//TODO check addon on/off state
		if(event.getSide().isClient()){
			loadLitePackTextureLocations();
		}
		//
		registerAttributeTypes();
		registerModifierImpls();
		registerFunctions();
		//
		searchInAddonsFor(DataType.FUEL);
		searchInAddonsFor(DataType.MATERIAL);
		searchInAddonsFor(DataType.CONSUMABLE);
		searchInAddonsFor(DataType.CLOTH);
		searchInAddonsFor(DataType.RAILGAUGE);
		searchInAddonsFor(DataType.WIRE);
		searchInAddonsFor(DataType.CONTAINER);
		searchInAddonsFor(DataType.BLOCK);
		searchInAddonsFor(DataType.MULTIBLOCK);
		searchInAddonsFor(DataType.PART);
		searchInAddonsFor(DataType.VEHICLE);
		//
		if(event.getSide().isClient()){
			MODEL_LOADERS.add(new ClassModelLoader());
			MODEL_LOADERS.add(new JTMTModelLoader());
			MODEL_LOADERS.add(new FMFModelLoader());
			MODEL_LOADERS.add(new ObjModelLoader());
			MODEL_LOADERS.add(new SMPTBJavaModelLoader());
		}
	}
	
	public static void searchAddonsInFolder(File packfolder, AddonLocation loc, boolean create){
		if(!packfolder.exists()){
			if(!create) return;
			packfolder.mkdir();
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
					Addon addon = new Addon(ContainerType.JAR, file, loc).parse(obj);
					ADDONS.register(addon);
					if(file.getName().endsWith(".jar") || (obj.has("JavaModels") && obj.get("JavaModels").getAsBoolean())){
						addToClassPath(addon, file);
					}
				}
			}
		}
	}

	private static boolean isDuplicate(JsonObject obj){
		if(!obj.has("RegistryName")) return false;
		String regname = obj.get("RegistryName").getAsString();
		for(Addon addon : ADDONS){
			if(addon.getRegistryName().toString().equals(regname)) return true;
		}
		return false;
	}

	private static Method cl_method;

	private static void addToClassPath(Addon addon, File file){
		if(file.isDirectory()) return;
		try{
			cl_method = (java.net.URLClassLoader.class).getDeclaredMethod("addURL", java.net.URL.class);
			cl_method.setAccessible(true);
		}
		catch(Exception e){
			Print.log("Failed to get method. [RESPACKLOADER:ERR:1]");
			Print.log("LiteAddon JavaModel loading will be skipped.");
		}
		try {
			ClassLoader loader = Resources.class.getClassLoader();
			cl_method.invoke(loader, file.toURI().toURL());
			FCLRegistry.scanForModels(file, loader);
		}
		catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | MalformedURLException e){
			e.printStackTrace();
		}
	}

	@SideOnly(Side.CLIENT)
	private void checkEntry(net.minecraft.client.resources.IResourcePack pack) {
		for(String str : pack.getResourceDomains()){
			if(Static.dev()){
				try {
					Print.log("Checking " + respackfile.get(pack) + " " + str);
					Print.log("Result: " + pack.resourceExists(new ResourceLocation(str + ":addonpack.fvtm")));
				}
				catch(IllegalArgumentException | IllegalAccessException e){
					e.printStackTrace();
				}
			}
			ResourceLocation resloc = new ResourceLocation(str + ":addonpack.fvtm");
			if(pack.resourceExists(resloc)){
				try {
					Addon addon = new Addon(pack instanceof net.minecraft.client.resources.FolderResourcePack ? ContainerType.DIR : ContainerType.JAR, (File)respackfile.get(pack), AddonLocation.RESOURCEPACK);
					JsonObject obj = JsonUtil.getObjectFromInputStream(pack.getInputStream(resloc));
					if(obj.has("JavaModels") && obj.get("JavaModels").getAsBoolean() && !addon.getFile().isDirectory()){
						addToClassPath(addon, addon.getFile());
					}
					ADDONS.register(addon.parse(obj));
				}
				catch(IllegalArgumentException | IllegalAccessException | IOException e){
					e.printStackTrace();
				}
			}
		}
	}

	public static final void loadPresets(){
		for(Addon addon : ADDONS){
			addon.loadPresets();
		}
		File file = new File("./config/fvtm/presets/");
		if(!file.exists()) file.mkdirs();
		File[] files = file.listFiles();
		for(File fl : files){
			try{
				JsonObject obj = JsonUtil.get(fl);
				if(obj.entrySet().isEmpty()) continue;
				Vehicle vehicle = Resources.VEHICLES.get(obj.get("Vehicle").getAsString());
				VehicleData data = (VehicleData)vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle);
				data.read(JsonToNBT.getTagFromJson(obj.toString()));
				data.setPreset(JsonUtil.getIfExists(obj, "Preset", "Nameless"));
				PresetTab.INSTANCE.add(data.newItemStack());
			}
			catch(Exception e){
				e.printStackTrace();
				Static.stop();
			}
		}
	}

	public static void loadRecipes(){
		for(Addon addon : ADDONS){
			addon.loadRecipes();
		}
	}

	private void registerAttributeTypes(){
		registerAttributeType("string", StringAttribute.class, true);
		registerAttributeType("text", StringAttribute.class, true);
		registerAttributeType("float", FloatAttribute.class, true);
		registerAttributeType("double", FloatAttribute.class, true);
		registerAttributeType("integer", IntegerAttribute.class, true);
		registerAttributeType("number", IntegerAttribute.class, true);
		registerAttributeType("long", LongAttribute.class, true);
		registerAttributeType("boolean", BooleanAttribute.class, true);
		registerAttributeType("bool", BooleanAttribute.class, true);
		registerAttributeType("tristate", TriStateAttribute.class, true);
		registerAttributeType("threestate", TriStateAttribute.class, true);
		registerAttributeType("ternary", TriStateAttribute.class, true);
		registerAttributeType("vec3", Vector3fAttribute.class, true);
		registerAttributeType("vec3f", Vector3fAttribute.class, true);
		registerAttributeType("vector", Vector3fAttribute.class, true);
		registerAttributeType("vector3", Vector3fAttribute.class, true);
		registerAttributeType("vector3f", Vector3fAttribute.class, true);
		MinecraftForge.EVENT_BUS.post(new ResourceEvents.RegisterAttributeTypes(this));
	}

	private void registerModifierImpls(){
		registerModifierImpl("string", StringModifier.class, true);
		registerModifierImpl("float", FloatModifier.class, true);
		registerModifierImpl("integer", IntegerModifier.class, true);
		MinecraftForge.EVENT_BUS.post(new ResourceEvents.RegisterModifierImpls(this));
	}

	private void registerFunctions(){
		registerFunction("fvtm:wheel", WheelFunction.class, true);
		registerFunction("fvtm:wheel_positions", WheelPositionsFunction.class, true);
		registerFunction("fvtm:seats", SeatsFunction.class, true);
		registerFunction("fvtm:engine", EngineFunction.class, true);
		registerFunction("fvtm:inventory", InventoryFunction.class, true);
		registerFunction("fvtm:container", ContainerFunction.class, true);
		registerFunction("fvtm:bogie", BogieFunction.class, true);
		registerFunction("fvtm:part_slots", PartSlotsFunction.class, true);
		registerFunction("fvtm:color", ColorFunction.class, true);
		registerFunction("fvtm:tire", TireFunction.class, true);
		registerFunction("fvtm:transmission", TransmissionFunction.class, true);
		registerFunction("fvtm:particle_emitter", ParticleEmitterFunction.class, true);
		registerBlockFunction("fvtm:seat", SeatBlockFunction.class, true);
		registerBlockFunction("fvtm:set_block", SetBlockFunction.class, true);
		registerBlockFunction("fvtm:bool_value", BoolBlockFunction.class, true);
		registerBlockFunction("fvtm:inventory", InventoryBlockFunction.class, true);
		registerBlockFunction("fvtm:barrel", BarrelBlockFunction.class, true);
		MinecraftForge.EVENT_BUS.post(new ResourceEvents.RegisterFunctions(this));
	}

	private void searchInAddonsFor(DataType datatype){
		for(Addon addon : ADDONS){
			try{
				addon.searchFor(datatype);
			}
			catch(Throwable thr){
				thr.printStackTrace();
				Static.stop();
			}
		}
	}

	public static Part getPart(String string){
		return PARTS.get(string);
	}

	public static Part getPart(ResourceLocation resloc){
		return PARTS.get(resloc);
	}

	public static Vehicle getVehicle(String string){
		return VEHICLES.get(string);
	}

	public static Vehicle getVehicle(ResourceLocation resloc){
		return VEHICLES.get(resloc);
	}

	public static Container getContainer(String string){
		return CONTAINERS.get(string);
	}

	public static Container getContainer(ResourceLocation resloc){
		return CONTAINERS.get(resloc);
	}

	public static Block getBlock(String string){
		return BLOCKS.get(string);
	}

	public static Block getBlock(ResourceLocation resloc){
		return BLOCKS.get(resloc);
	}

	public static MultiBlock getMultiBlock(String string){
		return MULTIBLOCKS.get(string);
	}

	public static MultiBlock getMultiBlock(ResourceLocation resloc){
		return MULTIBLOCKS.get(resloc);
	}

	@Deprecated
	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(String string){
		return getModelInputStream(new ResourceLocation(string), true);
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(String string, boolean log){
		return getModelInputStream(new ResourceLocation(string), log);
	}

	@Deprecated
	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(ResourceLocation resloc){
		return getModelInputStream(resloc, true);
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(ResourceLocation resloc, boolean log){
		try{
			return net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(resloc).getInputStream();
		}
		catch(IOException e){
			if(log) e.printStackTrace();
			return null;
		}
	}

	@SideOnly(Side.CLIENT)
	public static Object[] getModelInputStreamWithFallback(ResourceLocation resloc){
		Closeable[] close = null;
		InputStream stream = getModelInputStream(resloc, false);
		if(stream != null) return new Object[]{ stream };
		try{
			Addon addon = getAddon(resloc.getNamespace());
			if(addon != null && addon.getLoc().isConfigPack()){
				if(addon.getContainerType() == ContainerType.DIR){
					File file = new File(addon.getFile(), "assets/" + resloc.getNamespace() + "/" + resloc.getPath());
					if(file.exists()) stream = new FileInputStream(file);
				}
				else{
					String filename = "assets/" + resloc.getNamespace() + "/" + resloc.getPath();
					ZipFile zip = new ZipFile(addon.getFile());
					ZipInputStream zipstream = new ZipInputStream(new FileInputStream(addon.getFile()));
					close = new Closeable[]{ zip, zipstream };
					while(true){
						ZipEntry entry = zipstream.getNextEntry();
						if(entry == null) break;
						if(entry.getName().equals(filename)){
							stream = zip.getInputStream(entry);
							break;
						}
					}
				}
			}
		}
		catch(Throwable e){
			//e.printStackTrace();
		}
		return close == null ? new Object[]{ stream } : new Object[]{ stream, close };
	}
	
	@SideOnly(Side.CLIENT)
	public static Model getModel(String name, ModelData data, Class<? extends Model> clazz){
		if(name == null || name.equals("") || name.equals("null")){
			return getEmptyModelFromClass(clazz);
		}
		boolean bake = name.startsWith("baked|");
		if(bake) name = name.substring(6);
		Model model = null;
		if(MODELS.containsKey(name)){
			if(bake && getEmptyModelFromClass(clazz) instanceof BlockModel){
				return getEmptyModelFromClass(clazz);
			}
			return MODELS.get(name);
		}
		if(FCLRegistry.getModel(name) != null){
			try{
				model = (Model)((Class<?>)FCLRegistry.getModel(name)).newInstance();
				model.parse(data).lock();
			}
			catch(Exception e){
				e.printStackTrace();
				return getEmptyModelFromClass(clazz);
			}
			catch(NoClassDefFoundError e){
				e.printStackTrace();
				return getEmptyModelFromClass(clazz);
			}
			MODELS.put(name, model);
			return model;
		}
		ModelLoader loader = getModelLoader(name, FilenameUtils.getExtension(name));
		if(loader == null) return getEmptyModelFromClass(clazz);
		try{
			Object[] ret = loader.load(name, data, () -> {
				try{
					return clazz.getConstructor().newInstance();
				}
				catch(Exception e){
					e.printStackTrace();
					return getEmptyModelFromClass(clazz);
				}
				catch(NoClassDefFoundError e){
					e.printStackTrace();
					return getEmptyModelFromClass(clazz);
				}
			});
			if(ret.length == 0 || ret[0] == null) return getEmptyModelFromClass(clazz);
			model = (Model)ret[0];
			if(ret.length > 1) data = (ModelData)ret[1];
			data.convert();
			model.parse(data).lock();
		}
		catch(Exception e){
			e.printStackTrace(); Static.stop();
		}
		MODELS.put(name, model);
		if(bake && model instanceof BlockModel){
			FCLBlockModelLoader.addBlockModel(new ResourceLocation(name), (FCLBlockModel)model);
			return getEmptyModelFromClass(clazz);
		}
		return model;
	}

	private static ModelLoader getModelLoader(String name, String extension){
		for(ModelLoader loader : MODEL_LOADERS){
			if(loader.accepts(name, extension)) return loader;
		}
		return null;
	}

	private static Model getEmptyModelFromClass(Class<? extends Model> clazz){
		//if(clazz == BlockModel.class) return BlockModel.EMPTY;
		if(clazz == ContainerModel.class) return ContainerModel.EMPTY;
		if(clazz == PartModel.class) return PartModel.EMPTY;
		if(clazz == VehicleModel.class) return VehicleModel.EMPTY;
		if(clazz == TrafficSignModel.class) return TrafficSignModel.EMPTY;
		if(clazz == BlockModel.class) return BlockModel.EMPTY;
		if(clazz == RailGaugeModel.class) return RailGaugeModel.EMPTY;
		if(clazz == ClothModel.class) return ClothModel.EMPTY;
		if(clazz == WireModel.class) return WireModel.EMPTY;
		if(clazz == GenericModel.class) return GenericModel.EMPTY;
		return null;
	}

	public static PartData getPartData(NBTTagCompound compound){
		if(!compound.hasKey("Part")) return null;
		Part part = getPart(compound.getString("Part")); if(part == null) return null;
		try{ return ((PartData)part.getDataClass().getConstructor(Part.class).newInstance(part)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}

	public static VehicleData getVehicleData(NBTTagCompound compound){
		if(!compound.hasKey("Vehicle")) return null;
		Vehicle veh = getVehicle(compound.getString("Vehicle")); if(veh == null) return null;
		try{ return ((VehicleData)veh.getDataClass().getConstructor(Vehicle.class).newInstance(veh)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}

	public static VehicleData readVehicleData(NBTTagCompound compound, VehicleData data){
		if(data != null) return data.read(compound);
		if(!compound.hasKey("Vehicle")) return null;
		Vehicle veh = getVehicle(compound.getString("Vehicle")); if(veh == null) return null;
		try{ return ((VehicleData)veh.getDataClass().getConstructor(Vehicle.class).newInstance(veh)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}

	public static ContainerData getContainerData(NBTTagCompound compound){
		if(!compound.hasKey("Container")) return null;
		Container con = getContainer(compound.getString("Container")); if(con == null) return null;
		try{ return ((ContainerData)con.getDataClass().getConstructor(Container.class).newInstance(con)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}

	public static BlockData getBlockData(NBTTagCompound compound){
		if(!compound.hasKey("Block")) return null;
		Block block = getBlock(compound.getString("Block")); if(block == null) return null;
		try{ return ((BlockData)block.getDataClass().getConstructor(Block.class).newInstance(block)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}

	public static MultiBlockData getMultiBlockData(NBTTagCompound compound){
		if(!compound.hasKey("type")) return null;
		MultiBlock block = getMultiBlock(compound.getString("type"));
		if(block == null) return null;
		try{ return ((MultiBlockData)block.getDataClass().getConstructor(MultiBlock.class).newInstance(block)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}
	
	/** Registers a Attribute class into FVTM Resources.*/
	public static void registerAttributeType(ResourceLocation regname, Class<? extends Attribute<?>> clazz, boolean override){
		registerAttributeType(regname.toString(), clazz, override);
	}
	
	/** Registers a Attribute class into FVTM Resources.*/
	public static void registerAttributeType(String regname, Class<? extends Attribute<?>> clazz, boolean override){
		if(ATTRIBUTE_TYPES.containsKey(regname) && !override) return;
		ATTRIBUTE_TYPES.put(regname, clazz);
	}
	
	public static Class<? extends Attribute<?>> getAttributeType(ResourceLocation regname){
		return getAttributeType(regname.toString());
	}
	
	public static Class<? extends Attribute<?>> getAttributeType(String id){
		return ATTRIBUTE_TYPES.get(id);
	}

	public static TreeMap<String, Class<? extends Attribute<?>>> getAttributeTypes(){
		return ATTRIBUTE_TYPES;
	}

	/** Registers a Attribute class into FVTM Resources.*/
	public static void registerModifierImpl(ResourceLocation regname, Class<? extends Modifier<?>> clazz, boolean override){
		registerModifierImpl(regname.toString(), clazz, override);
	}
	
	/** Registers a Attribute class into FVTM Resources.*/
	public static void registerModifierImpl(String regname, Class<? extends Modifier<?>> clazz, boolean override){
		if(MODIFIER_IMPLS.containsKey(regname) && !override) return;
		MODIFIER_IMPLS.put(regname, clazz);
	}
	
	public static Class<? extends Modifier<?>> getModifierImpl(ResourceLocation regname){
		return getModifierImpl(regname.toString());
	}
	
	public static Class<? extends Modifier<?>> getModifierImpl(String id){
		return MODIFIER_IMPLS.get(id);
	}

	public static TreeMap<String, Class<? extends Modifier<?>>> getModifierImpl(){
		return MODIFIER_IMPLS;
	}
	
	/** Registers a Functon class into FVTM Resources.*/
	public static void registerFunction(ResourceLocation regname, Class<? extends Function> clazz, boolean override){
		registerFunction(regname.toString(), clazz, override);
	}
	
	/** Registers a Functon class into FVTM Resources.*/
	public static void registerFunction(String regname, Class<? extends Function> clazz, boolean override){
		if(FUNCTIONS.containsKey(regname) && !override) return;
		FUNCTIONS.put(regname, clazz);
	}
	
	public static Class<? extends Function> getFunction(ResourceLocation regname){
		return getFunction(regname.toString());
	}
	
	public static Class<? extends Function> getFunction(String id){
		return FUNCTIONS.get(id);
	}

	public static TreeMap<String, Class<? extends Function>> getFunctions(){
		return FUNCTIONS;
	}

	/** Registers a Block Functon class into FVTM Resources.*/
	public static void registerBlockFunction(ResourceLocation regname, Class<? extends BlockFunction> clazz, boolean override){
		registerBlockFunction(regname.toString(), clazz, override);
	}

	/** Registers a Block Functon class into FVTM Resources.*/
	public static void registerBlockFunction(String regname, Class<? extends BlockFunction> clazz, boolean override){
		if(BLOCK_FUNCTIONS.containsKey(regname) && !override) return;
		BLOCK_FUNCTIONS.put(regname, clazz);
	}

	public static Class<? extends BlockFunction> getBlockFunction(String id){
		return BLOCK_FUNCTIONS.get(id);
	}

	public static TreeMap<String, Class<? extends BlockFunction>> getBlockFunctions(){
		return BLOCK_FUNCTIONS;
	}

	private static Field flightdata;
	private static boolean flightdata_failed = false;
	/** do not remember on what this is based **/
	public static void resetFlight(EntityPlayerMP passenger){
		if(flightdata == null && !flightdata_failed){
			try{
				flightdata = ObfuscationReflectionHelper.findField(NetHandlerPlayServer.class, "field_147365_f");
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

	public static NetworkRegistry.TargetPoint getTargetPoint(Entity ent){
		return new NetworkRegistry.TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, Config.VEHICLE_UPDATE_RANGE);
	}

	public static TargetPoint getTargetPoint(int dim, BlockPos pos){
		return new NetworkRegistry.TargetPoint(dim, pos.getX(), pos.getY(), pos.getZ(), Config.VEHICLE_UPDATE_RANGE);
	}

	public static Fuel getFuel(String id){
		return ALLFUELS.get(id);
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
	
	@SubscribeEvent
	public void onAttachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event){
		if(event.getObject().getItem() instanceof VehicleItem || event.getObject().getItem() instanceof PartItem
			|| event.getObject().getItem() instanceof ContainerItem || event.getObject().getItem() instanceof BlockItem){
			event.addCapability(new ResourceLocation("fvtm:vapdatacache"), new VAPDataCache(event.getObject()));
		}
	}
	
	@SubscribeEvent
	public void onAttachWorldCapabilities(AttachCapabilitiesEvent<World> event){
		SystemManager.onAttachWorldCapabilities(event.getObject());
		event.addCapability(new ResourceLocation("fvtm:multiblocks"), new MultiBlockCacheSerializer(event.getObject()));
	}
	
	@SubscribeEvent
	public void onAttachChunkCapabilities(AttachCapabilitiesEvent<Chunk> event){
		event.addCapability(new ResourceLocation("fvtm:trafficsigns"), new TrafficSignCapHandler(event.getObject()));
	}
	
	@SubscribeEvent
	public void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event){
		if(event.getObject().world == null) return;
		if(event.getObject() instanceof ContainerHolderWrapper){
			event.addCapability(new ResourceLocation("fvtm:container"), new ContainerHolderUtil(event.getObject()));
		}
		if(event.getObject().world.isRemote && event.getObject() instanceof VehicleEntity){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
		if(event.getObject() instanceof EntityPlayer){
			event.addCapability(new ResourceLocation("fvtm:playerdata"), new PlayerDataHandler(event.getObject()));
			if(event.getObject().world.isRemote){
				event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
			}
		}
		if(event.getObject() instanceof EntityLivingBase){
			event.addCapability(new ResourceLocation("fvtm:passenger"), new PassengerCapHandler(event.getObject()));
		}
		if(event.getObject().world.isRemote && event.getObject() instanceof Decoration){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
	}
	
	@SubscribeEvent
	public void onAttachTileEntityCapabilities(AttachCapabilitiesEvent<TileEntity> event){
		if(Static.side().isClient() && (event.getObject() instanceof DisplayEntity ||
			event.getObject() instanceof BlockTileEntity || event.getObject() instanceof ContainerEntity)){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
	}
	
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event){
		if(event.phase != Phase.START) return;
		for(World world : Static.getServer().worlds){
			SystemManager.onServerTick(world);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event){
		if(event.phase != Phase.START) return;
		SystemManager.onClientTick(net.minecraft.client.Minecraft.getMinecraft().world);
	}
	
	@SubscribeEvent
	public void onChunkLoad(ChunkEvent.Load event){
		SystemManager.onChunkLoad(event.getWorld(), event.getChunk());
		event.getChunk().getTileEntityMap().values().forEach(tile -> {
			if(tile instanceof MultiblockTileEntity){
				((MultiblockTileEntity)tile).setup();
			}
		});
	}
	
	@SubscribeEvent
	public void onChunkUnload(ChunkEvent.Unload event){
		SystemManager.onChunkUnload(event.getWorld(), event.getChunk());
	}
	
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event){
		if(!event.getWorld().isRemote) return;
		SystemManager.onWorldLoad(event.getWorld());
	}
	
	@SubscribeEvent
	public void onWorldUnload(WorldEvent.Unload event){
		if(!event.getWorld().isRemote) return;
		SystemManager.onWorldUnload(event.getWorld());
	}

	@SubscribeEvent
	public void regSounds(RegistryEvent.Register<SoundEvent> event){
		VEHICLES.forEach(vehicle -> {
			vehicle.getSounds().values().forEach(sound -> {
				if(event.getRegistry().containsKey(sound.soundid)){
					sound.event = event.getRegistry().getValue(sound.soundid);
				}
				else{
					SoundEvent soundevent = new SoundEvent(sound.soundid).setRegistryName(sound.soundid);
					event.getRegistry().register(sound.event = soundevent);
				}
			});
		});
		PARTS.forEach(part -> {
			part.getSounds().values().forEach(sound -> {
				if(event.getRegistry().containsKey(sound.soundid)){
					sound.event = event.getRegistry().getValue(sound.soundid);
				}
				else{
					SoundEvent soundevent = new SoundEvent(sound.soundid).setRegistryName(sound.soundid);
					event.getRegistry().register(sound.event = soundevent);
				}
			});
		});
	}
	
	@SubscribeEvent
	public void onPlayerIn(PlayerEvent.PlayerLoggedInEvent event){
		if(event.player.world.isRemote){
			RailPlacingUtil.CL_CURRENT = null;
			RoadPlacingUtil.CL_CURRENT = null;
		}
		if(event.player.world != null && !event.player.world.isRemote){
			NBTTagCompound cfgsync = new NBTTagCompound();
			cfgsync.setInteger("u12_sync_rate", U12_SYNC_RATE);
			cfgsync.setString("task", "config_sync");
			cfgsync.setString("target_listener", Resources.UTIL_LISTENER);
			PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(cfgsync), (EntityPlayerMP)event.player);
		}
		if(!event.player.world.isRemote) RoadPlacingCache.onLogIn(event.player);
		if(!Static.getServer().isSinglePlayer()) return;
		SystemManager.PLAYERON = true;
	}
	
	@SubscribeEvent
	public void onPlayerOut(PlayerEvent.PlayerLoggedOutEvent event){
		if(!event.player.world.isRemote){
			RailPlacingUtil.CURRENT.remove(event.player.getGameProfile().getId());
			RoadPlacingCache.onLogOut(event.player);
		}
		if(Config.DISMOUNT_ON_LOGOUT && event.player.getRidingEntity() instanceof GenericVehicle){
			event.player.dismountRidingEntity();
		}
		if(!Static.getServer().isSinglePlayer()) return;
		SystemManager.PLAYERON = false;
	}
	
	/*@SubscribeEvent
	public void onEntityDamage(LivingDamageEvent event){
		if(event.getEntity().isRiding() && event.getEntity().getRidingEntity() instanceof SeatEntity){
			event.setCanceled(true);
		}
	}*/
	
	@SubscribeEvent
	public void onEntityAttack(LivingAttackEvent event){
		if(event.getEntity().isRiding() && event.getEntity().getRidingEntity() instanceof GenericVehicle){// && !event.getSource().isProjectile()){
			event.setCanceled(true);
		}
	}
	
	/*@SubscribeEvent
	public void onSpawn(EntityJoinWorldEvent event){
		Print.debug(event.getEntity());
	}*/
	
	public static final boolean isModLoaded(String modid){
		if(LOADED_MODS.containsKey(modid)) return LOADED_MODS.get(modid);
		boolean bool = Loader.isModLoaded(modid);
		LOADED_MODS.put(modid, bool);
		return bool;
	}
	
	/*private static final BiConsumer<ArrayList<TileEntity>, Junction> LINK_TO_JUNC = (tiles, junction) -> {
		for(TileEntity tile_entity : tiles){
			if(tile_entity instanceof JunctionTrackingTileEntity == false) continue;
			JunctionTrackingTileEntity tile = (JunctionTrackingTileEntity)tile_entity;
			if(tile.getJuncPos().equals(junction.getVec316f())){
				tile.setJunction(junction.getVec316f());
			}
		}
	};
	
	@SubscribeEvent
	public void onJuncAdded(RailEvents.JunctionEvent.JunctionAdded event){
		ArrayList<TileEntity> tiles = new ArrayList<>();
		tiles.addAll(event.getWorld().loadedTileEntityList);
		Static.getServer().addScheduledTask(() -> LINK_TO_JUNC.accept(tiles, event.getJunction()));
	}
	
	@SubscribeEvent
	public void onJuncAdded(RailEvents.JunctionEvent.JunctionLoaded event){
		ArrayList<TileEntity> tiles = new ArrayList<>();
		tiles.addAll(event.getWorld().loadedTileEntityList);
		Static.getServer().addScheduledTask(() -> LINK_TO_JUNC.accept(tiles, event.getJunction()));
	}*/

	public static void registerDefaultRecipes(){
		String blockcat = "fvtm.recipes.blocks";
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(ConstructorBlock.INSTANCE),
			new ItemStack(Blocks.IRON_BLOCK),
			new ItemStack(Items.COMPARATOR, 4),
			new ItemStack(Items.REPEATER, 8),
			new ItemStack(Items.REDSTONE, 16),
			new ItemStack(Items.BOOK, 2),
			new ItemStack(Blocks.LEVER, 8)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(ConstCenterBlock.INSTANCE),
			new ItemStack(Blocks.IRON_BLOCK, 2),
			new ItemStack(Items.IRON_INGOT, 8),
			new ItemStack(Items.COMPARATOR, 2),
			new ItemStack(Items.REPEATER, 4),
			new ItemStack(Items.REDSTONE, 4),
			new ItemStack(Items.BOOK, 1),
			new ItemStack(Blocks.LEVER, 2),
			new ItemStack(Blocks.PISTON, 2)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(VPInfo.INSTANCE),
			new ItemStack(Blocks.IRON_BLOCK),
			new ItemStack(Items.BOOK, 16),
			new ItemStack(Items.REDSTONE, 4),
			new ItemStack(Blocks.LEVER, 4),
			new ItemStack(Items.GLASS_BOTTLE, 2)
		);
		String gauge = InternalAddon.STANDARD_GAUGE.toString();
		Item gaugeitem = Item.getByNameOrId(gauge);
		Item gaugeitem16 = Item.getByNameOrId(gauge + ".16_straight");
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(gaugeitem),
			new ItemStack(Items.IRON_INGOT, 4),
			new ItemStack(Blocks.PLANKS, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".4_straight")),
			new ItemStack(gaugeitem, 4),
			new ItemStack(Items.IRON_INGOT, 2)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".8_straight")),
			new ItemStack(gaugeitem, 8),
			new ItemStack(Items.IRON_INGOT, 3)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight")),
			new ItemStack(gaugeitem, 16),
			new ItemStack(Items.IRON_INGOT, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".32_straight")),
			new ItemStack(gaugeitem, 32),
			new ItemStack(Items.IRON_INGOT, 8)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_up")),
			new ItemStack(gaugeitem, 16),
			new ItemStack(Items.IRON_INGOT, 4),
			new ItemStack(Blocks.PLANKS, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_down")),
			new ItemStack(gaugeitem, 16),
			new ItemStack(Items.IRON_INGOT, 4),
			new ItemStack(Blocks.PLANKS, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_up")),
			new ItemStack(gaugeitem16),
			new ItemStack(Blocks.PLANKS, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_down")),
			new ItemStack(gaugeitem16),
			new ItemStack(Blocks.PLANKS, 4)
		);
	}

	@SideOnly(Side.CLIENT)
	public static Class<? extends AddonSteeringOverlay> getOverlayOf(GenericVehicle vehicle){
		OverlayEvent event = new OverlayEvent(vehicle, vehicle.getVehicleData());
		MinecraftForge.EVENT_BUS.post(event);
		return OVERLAYS.containsKey(event.getOverlay()) ? OVERLAYS.get(event.getOverlay()) : OVERLAYS.get("default");
	}

	public static void linkTextureSuppliers(){
		for(Addon addon : ADDONS){
			if(addon.getTextureSuppliers().isEmpty()) continue;
			for(TextureSupply texsupp : addon.getTextureSuppliers().values()){
				for(String tar : texsupp.targets()){
					String[] split = tar.split(";");
					Textureable.TextureHolder holder = null;
					switch(split[0]){
						case "vehicle":{
							holder =  VEHICLES.get(split[1]);
							break;
						}
						case "part":{
							holder = PARTS.get(split[1]);
							break;
						}
						case "container":{
							holder = CONTAINERS.get(split[1]);
							break;
						}
					}
					if(holder == null) continue;
					for(IDL tex : texsupp.textures()){
						holder.getDefaultTextures().add((NamedResourceLocation)tex);
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static CreativeTabs getCreativeTab(Tabbed type){
		String tab = type.getCreativeTab();
		Addon addon = null;
		if(tab.contains(":")){
			String[] split = tab.split(":");
			addon = getAddon(split[0]);
			if(addon == null) return null;
			return addon.getCreativeTab(split[1]);
		}
		addon = ((TypeCore<?>)type).getAddon();
		return addon.getCreativeTab(tab);
	}

	public static Addon getAddon(String string){
		for(Addon addon : ADDONS){
			if(addon.getRegistryName().getPath().equals(string)) return addon;
		}
		return null;
	}

	public static void loadWireDecorations(boolean client){
		for(Entry<String, JsonMap> cache : WIRE_DECO_CACHE.entrySet()){
			for(Entry<String, JsonValue<?>> entry : cache.getValue().entries()){
				if(client){
					parseWireDecoModel(cache.getKey() + ":" + entry.getKey(), entry.getValue());
				}
				WIRE_DECOS.add(cache.getKey() + ":" + entry.getKey());
			}
		}
		WIRE_DECO_CACHE.clear();
	}

	@SideOnly(Side.CLIENT)
	private static void parseWireDecoModel(String key, JsonValue value){
		String name = null;
		List<JsonValue<?>> array = null;
		if(value.isArray()){
			array = value.asArray().value;
			name = array.get(0).string_value();
		}
		else{
			name = value.string_value();
		}
		WireModel model = (WireModel)getModel(name, new ModelData(), WireModel.class);
		if(array != null){
			if(array.size() > 1) model.texture(new ResourceLocation(array.get(1).string_value()));
			if(array.size() > 2) model.accepts(array.get(2).asArray().toStringList());
			if(array.size() > 3) model.decotype(array.get(3).string_value());
		}
		WireModel.DECOS.put(key, model.key(key));
	}
	
	private static Field i18n_locale;
	private static Method locale_load_is, locale_check_uni;

	@SideOnly(Side.CLIENT)
	public static void loadLitePackLang() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, FileNotFoundException {
		ArrayList<Addon> lites = new ArrayList<>();
		for(Addon addon : ADDONS){
			if(addon.getLoc() == AddonLocation.CONFIGPACK) lites.add(addon);
		}
		if(lites.size() == 0) return;
		i18n_locale = ObfuscationReflectionHelper.findField(net.minecraft.client.resources.I18n.class, "field_135054_a");
		i18n_locale.setAccessible(true);
		locale_load_is = ObfuscationReflectionHelper.findMethod(net.minecraft.client.resources.Locale.class, "func_135021_a", Void.TYPE, InputStream.class);
		locale_load_is.setAccessible(true);
		locale_check_uni = ObfuscationReflectionHelper.findMethod(net.minecraft.client.resources.Locale.class, "func_135024_b", Void.TYPE);
		locale_check_uni.setAccessible(true);
		String code = net.minecraft.client.Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().toLowerCase();
		boolean nonus = !code.equals("en_us");
		//
		for(Addon addon : lites){
			if(addon.getContainerType() == ContainerType.DIR){
				if(!addon.getFile().isDirectory()) return;
				//
				File folder = new File(addon.getFile(), "assets/" + addon.getRegistryName().getPath() + "/lang/");
				if(!folder.exists()) folder.mkdirs();
				for(File file : folder.listFiles()){
					if(file.getName().toLowerCase().equals("en_us.lang")){
						locale_load_is.invoke(i18n_locale.get(null), new FileInputStream(file));
						LanguageMap.inject(new FileInputStream(file));
					}
					else if(nonus && file.getName().toLowerCase().equals(code + ".lang")){
						locale_load_is.invoke(i18n_locale.get(null), new FileInputStream(file));
						LanguageMap.inject(new FileInputStream(file));
					}
				}
			}
			else{
				String path = "assets/" + addon.getRegistryName().getPath() + "/lang/", extension = ".lang";
				try{
					ZipFile zip = new ZipFile(addon.getFile());
					ZipInputStream stream = new ZipInputStream(new FileInputStream(addon.getFile()));
					while(true){
						ZipEntry entry = stream.getNextEntry();
						if(entry == null) break;
						if(entry.getName().equals(path + "en_us" + extension)){
							locale_load_is.invoke(i18n_locale.get(null), zip.getInputStream(entry));
							LanguageMap.inject(zip.getInputStream(entry));
						}
						if(nonus && entry.getName().equals(path + code + extension)){
							locale_load_is.invoke(i18n_locale.get(null), zip.getInputStream(entry));
							LanguageMap.inject(zip.getInputStream(entry));
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
		locale_check_uni.invoke(i18n_locale.get(null));
	}

	@SideOnly(Side.CLIENT)
	public static void loadLitePackTextureLocations(){
		ArrayList<Addon> lites = new ArrayList<>();
		for(Addon addon : ADDONS){
			if(addon.getLoc() == AddonLocation.CONFIGPACK) lites.add(addon);
		}
		if(lites.size() == 0) return;
		for(Addon addon : lites){
			if(addon.getContainerType() == ContainerType.DIR){
				if(!addon.getFile().isDirectory()) return;
				TexUtil.searchIn(addon, new File(addon.getFile(), "assets/" + addon.getRegistryName().getPath() + "/textures/"), null);
			}
			else{
				TexUtil.searchInZip(addon);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static void loadDecoModels(){
		for(DecorationData deco : DECORATIONS.values()){
			Model model = Resources.getModel(deco.modelid, deco.modeldata, GenericModel.class);
			if(model != null && model != GenericModel.EMPTY) MODELS.put(deco.modelid, deco.model = model);
		}
	}

	public static Object[] getInputStream(ResourceLocation resloc){
		Closeable[] close = null;
		InputStream stream = getModelInputStream(resloc, false);
		if(stream != null) return new Object[]{ stream };
		try{
			Addon addon = getAddon(resloc.getNamespace());
			if(addon != null){
				if(addon.getContainerType() == ContainerType.DIR){
					File file = new File(addon.getFile(), "assets/" + resloc.getNamespace() + "/" + resloc.getPath());
					if(file.exists()) stream = new FileInputStream(file);
				}
				else{
					String filename = "assets/" + resloc.getNamespace() + "/" + resloc.getPath();
					ZipFile zip = new ZipFile(addon.getFile());
					ZipInputStream zipstream = new ZipInputStream(new FileInputStream(addon.getFile()));
					close = new Closeable[]{ zip, zipstream };
					while(true){
						ZipEntry entry = zipstream.getNextEntry();
						if(entry == null) break;
						if(entry.getName().equals(filename)){
							stream = zip.getInputStream(entry);
							break;
						}
					}
				}
			}
		}
		catch(Throwable e){
			//e.printStackTrace();
		}
		return close == null ? new Object[]{ stream } : new Object[]{ stream, close };
	}

}
