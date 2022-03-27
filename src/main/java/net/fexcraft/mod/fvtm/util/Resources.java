package net.fexcraft.mod.fvtm.util;

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
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
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
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.Consumable;
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
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHolderWrapper;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Tabbed;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.event.OverlayEvent;
import net.fexcraft.mod.fvtm.event.ResourceEvents;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignCapHandler;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.MultiBlockCacheSerializer;
import net.fexcraft.mod.fvtm.util.caps.PassengerCapHandler;
import net.fexcraft.mod.fvtm.util.caps.PlayerDataHandler;
import net.fexcraft.mod.fvtm.util.caps.RenderCacheHandler;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
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
import net.minecraftforge.common.util.EnumHelper;
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
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class Resources {
	
	public static IForgeRegistry<Addon> ADDONS;
	public static IForgeRegistry<Part> PARTS;
	public static IForgeRegistry<Vehicle> VEHICLES;
	public static IForgeRegistry<Material> MATERIALS;
	public static IForgeRegistry<Fuel> ALLFUELS;
	public static IForgeRegistry<Consumable> CONSUMABLES;
	public static IForgeRegistry<Container> CONTAINERS;
	public static IForgeRegistry<Block> BLOCKS;
	public static IForgeRegistry<RailGauge> RAILGAUGES;
	public static IForgeRegistry<Cloth> CLOTHES;
	public static IForgeRegistry<WireType> WIRES;
	public static TreeMap<String, TreeMap<String, ArrayList<Fuel>>> FUELS = new TreeMap<>();
	private static TreeMap<String, Class<? extends Function>> FUNCTIONS = new TreeMap<>();
	private static TreeMap<String, Class<? extends Attribute<?>>> ATTRIBUTE_TYPES = new TreeMap<>();
	private static TreeMap<String, Class<? extends Modifier<?>>> MODIFIER_IMPLS = new TreeMap<>();
	public static HashMap<String, Particle> PARTICLES = new HashMap<>();
	private static TreeMap<String, Boolean> LOADED_MODS = new TreeMap<>();
	private static TreeMap<String, ObjModel> OBJ_MODEL_INFO_CACHE = new TreeMap<>();
	private static TreeMap<ResourceLocation, ObjModel> OBJ_MODEL_DATA_CACHE = new TreeMap<>();
	public static TreeMap<String, Class<? extends AddonSteeringOverlay>> OVERLAYS = new TreeMap<>();
	public static final HashMap<String, Model<?, ?>> MODELS = new HashMap<>();
	public static final NamedResourceLocation NULL_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/null.png");
	public static final NamedResourceLocation WHITE_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/white.png");
	public static final String UTIL_LISTENER = "fvtm:utils";
	public static final ArmorMaterial NONE_MAT = EnumHelper.addArmorMaterial("fvtm:none", Resources.NULL_TEXTURE.toString(), 1024, new int[]{ 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
	public static final ArrayList<String> WIRE_DECOS = new ArrayList<>();
	public static final HashMap<String, JsonObject> WIRE_DECO_CACHE = new HashMap<>();
	//
	private static Field respackfile = null;
	private File configroot; 
	
	public Resources(FMLPreInitializationEvent event){
		configroot = new File(event.getModConfigurationDirectory(), "/fvtm/");
		if(!configroot.exists()) configroot.mkdirs(); //addonconfig = new File(configpath, "/addonpacks.fex");
		//
		ADDONS = new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
		PARTS = new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
		VEHICLES = new RegistryBuilder<Vehicle>().setName(new ResourceLocation("fvtm:vehicles")).setType(Vehicle.class).create();
		MATERIALS = new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
		ALLFUELS = new RegistryBuilder<Fuel>().setName(new ResourceLocation("fvtm:fuels")).setType(Fuel.class).create();
		CONSUMABLES = new RegistryBuilder<Consumable>().setName(new ResourceLocation("fvtm:consumables")).setType(Consumable.class).create();
		CONTAINERS = new RegistryBuilder<Container>().setName(new ResourceLocation("fvtm:containers")).setType(Container.class).create();
		BLOCKS = new RegistryBuilder<Block>().setName(new ResourceLocation("fvtm:blocks")).setType(Block.class).create();
		RAILGAUGES = new RegistryBuilder<RailGauge>().setName(new ResourceLocation("fvtm:railgauges")).setType(RailGauge.class).create();
		CLOTHES = new RegistryBuilder<Cloth>().setName(new ResourceLocation("fvtm:clothes")).setType(Cloth.class).create();
		WIRES = new RegistryBuilder<WireType>().setName(new ResourceLocation("fvtm:wires")).setType(WireType.class).create();
		/*PALLETS = new RegistryBuilder<Pallet>().setName(new ResourceLocation("fvtm:pallets")).setType(Pallet.class).create();*/
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
				Print.log("LiteAddon loading will be skipped.");
			}
			if(respackfile != null){
				if(Config.LOAD_ALL_RESOURCEPACKS){
					for(net.minecraft.client.resources.ResourcePackRepository.Entry entry : net.minecraft.client.Minecraft.getMinecraft().getResourcePackRepository().getRepositoryEntriesAll()){
						checkEntry(entry.getResourcePack());
					}
				}
				else{
					for(net.minecraft.client.resources.ResourcePackRepository.Entry entry : net.minecraft.client.Minecraft.getMinecraft().getResourcePackRepository().getRepositoryEntries()){
						checkEntry(entry.getResourcePack());
					}
				}
			}
		}
		else{
			searchAddonsInForlder(new File(event.getModConfigurationDirectory().getParent(), "/resourcepacks/"), AddonLocation.RESOURCEPACK, false);
		}
		searchAddonsInForlder(new File(configroot, "packs/"), AddonLocation.LITEPACK, true);
		if(Config.LOAD_LITE_FROM_MODS) searchAddonsInForlder(new File(event.getModConfigurationDirectory().getParent(), "/mods/"), AddonLocation.LITEPACK, false);
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
		searchInAddonsFor(DataType.PART);
		searchInAddonsFor(DataType.VEHICLE);
	}
	
	public static void searchAddonsInForlder(File packfolder, AddonLocation loc, boolean create){
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
							ADDONS.register(new Addon(ContainerType.DIR, file, loc).parse(JsonUtil.get(dec)));
						}
					}
				}
			}
			else if(file.getName().endsWith(".zip") || file.getName().endsWith(".jar")){
				JsonArray array = ZipUtil.getJsonElementsAt(file, "assets", "addonpack.fvtm", 1);
				if(array.size() > 0){
					JsonObject obj = array.get(0).getAsJsonObject();
					Addon addon = new Addon(ContainerType.JAR, file, loc).parse(obj);
					ADDONS.register(addon);
					if(file.getName().endsWith(".jar") || (obj.has("JavaModels") && obj.get("JavaModels").getAsBoolean())){
						addToClassPath(addon, file);
					}
				}
			}
		}
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
		for(Addon addon : ADDONS.getValuesCollection()){
			addon.loadPresets();
		}
		File file = new File("./config/fvtm/presets/");
		if(!file.exists()) file.mkdirs();
		File[] files = file.listFiles();
		for(File fl : files){
			try{
				JsonObject obj = JsonUtil.get(fl);
				if(obj.entrySet().isEmpty()) continue;
				Vehicle vehicle = Resources.VEHICLES.getValue(new ResourceLocation(obj.get("Vehicle").getAsString()));
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
		for(Addon addon : ADDONS.getValuesCollection()){
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
		MinecraftForge.EVENT_BUS.post(new ResourceEvents.RegisterFunctions(this));
	}

	private void searchInAddonsFor(DataType datatype){
		for(Addon addon : ADDONS.getValuesCollection()){
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
		return getPart(new ResourceLocation(string));
	}

	public static Part getPart(ResourceLocation resloc){
		return PARTS.getValue(resloc);
	}

	public static Vehicle getVehicle(String string){
		return getVehicle(new ResourceLocation(string));
	}

	public static Vehicle getVehicle(ResourceLocation resloc){
		return VEHICLES.getValue(resloc);
	}

	public static Container getContainer(String string){
		return getContainer(new ResourceLocation(string));
	}

	public static Container getContainer(ResourceLocation resloc){
		return CONTAINERS.getValue(resloc);
	}

	public static Block getBlock(String string){
		return getBlock(new ResourceLocation(string));
	}

	public static Block getBlock(ResourceLocation resloc){
		return BLOCKS.getValue(resloc);
	}

	@SideOnly(Side.CLIENT)
	public static InputStream getModelInputStream(String string, boolean log){
		return getModelInputStream(new ResourceLocation(string), log);
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
			if(addon != null && addon.getLoc().isLitePack()){
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
		return close == null ? new Object[]{ stream } : new Object[]{ stream, close};
	}
	
	@SideOnly(Side.CLIENT)
	public static <T, K> Model<T, K> getModel(String name, Class<? extends Model<T, K>> clazz){
		if(name == null || name.equals("") || name.equals("null")){
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		boolean bake = name.startsWith("baked|");
		if(bake) name = name.substring(6);
		Model<T, K> model = null;
		if(MODELS.containsKey(name)){
			if(bake && getEmptyModelFromClass(clazz) instanceof BlockModel){
				return (Model<T, K>)getEmptyModelFromClass(clazz);
			}
			return (Model<T, K>)MODELS.get(name);
		}
		if(FCLRegistry.getModel(name) != null){
			try{
				model = (Model<T, K>)((Class<?>)FCLRegistry.getModel(name)).newInstance();
			}
			catch(InstantiationException | IllegalAccessException e){
				e.printStackTrace();
				return (Model<T, K>)getEmptyModelFromClass(clazz);
			}
			MODELS.put(name, model);
			return model;
		}
		String ext = FilenameUtils.getExtension(name);
		try{
			switch(ext){
				case "class":
					Class<?> clasz = Class.forName(name.replace(".class", ""));
					model = (Model<T, K>)clasz.newInstance();
					break;
				case "jtmt":
					JsonObject obj = JsonUtil.getObjectFromInputStream(getModelInputStream(new ResourceLocation(name), true));
					model = clazz.getConstructor(JsonObject.class).newInstance(obj);
					break;
				case "json":
					//TODO create a wrapper.
					break;
				case "obj":{
					String[] filter = name.split(";");
					String id = filter.length > 1 ? filter[filter.length - 1] : name;
					ResourceLocation loc = new ResourceLocation(id);
					ObjModel objdata = null;
					if(OBJ_MODEL_INFO_CACHE.containsKey(id)){
						objdata = OBJ_MODEL_INFO_CACHE.get(id);
					}
					else{
						Object[] stream = getModelInputStreamWithFallback(loc);
						objdata = new ObjParser((InputStream)stream[0]).readComments(true).readModel(false).parse();
						OBJ_MODEL_INFO_CACHE.put(id, objdata);
						if(stream.length > 1) for(Closeable c : (Closeable[])stream[1]) c.close();
					}
					ArrayList<String> groups = new ArrayList<>();
					boolean exclude = false;
					if(filter.length > 1){
						if(filter[0].equals("!") || filter[0].equals("exclude")) exclude = true;
						if(!exclude || filter.length > 2){
							for(int i = exclude ? 1 : 0; i < filter.length - 1; i++) groups.add(filter[i]);
						}
					}
					model = clazz.getConstructor(ResourceLocation.class, ObjModel.class, ArrayList.class, boolean.class).newInstance(loc, objdata, groups, exclude);
					break;
				}
				case "fmf":{
					Object[] stream = getModelInputStreamWithFallback(new ResourceLocation(name));
					model = ((GenericModel<T, K>)clazz.getConstructor().newInstance()).parse(stream, ext);
					break;
				}
				case "": default: return (Model<T, K>)getEmptyModelFromClass(clazz);
			}
		}
		catch(Throwable thr){
			Print.log("Failed to find/parse model with adress '" + name + "'!");
			thr.printStackTrace(); //Static.stop();
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		MODELS.put(name, model);
		if(bake && model instanceof BlockModel){
			FCLBlockModelLoader.addBlockModel(new ResourceLocation(name), (FCLBlockModel)model);
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		return model;
	}

	private static Model<?, ?> getEmptyModelFromClass(Class<? extends Model<?, ?>> clazz){
		//if(clazz == BlockModel.class) return BlockModel.EMPTY;
		if(clazz == ContainerModel.class) return ContainerModel.EMPTY;
		if(clazz == PartModel.class) return PartModel.EMPTY;
		if(clazz == VehicleModel.class) return VehicleModel.EMPTY;
		if(clazz == TrafficSignModel.class) return TrafficSignModel.EMPTY;
		if(clazz == BlockModel.class) return BlockModel.EMPTY;
		if(clazz == RailGaugeModel.class) return RailGaugeModel.EMPTY;
		if(clazz == ClothModel.class) return ClothModel.EMPTY;
		if(clazz == WireModel.class) return WireModel.EMPTY;
		if(clazz == TrafficSignModel.class) return TrafficSignModel.EMPTY;
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
		return getFuel(new ResourceLocation(id));
	}

	public static Fuel getFuel(ResourceLocation resloc){
		return ALLFUELS.getValue(resloc);
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
		VEHICLES.getValuesCollection().forEach(vehicle -> {
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
		PARTS.getValuesCollection().forEach(part -> {
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
		if(event.player.world != null && !event.player.world.isRemote){
			NBTTagCompound cfgsync = new NBTTagCompound();
			cfgsync.setInteger("u12_sync_rate", Config.U12_SYNC_RATE);
			cfgsync.setString("task", "config_sync");
			cfgsync.setString("target_listener", Resources.UTIL_LISTENER);
			PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(cfgsync), (EntityPlayerMP)event.player);
		}
		if(!Static.getServer().isSinglePlayer()) return;
		SystemManager.PLAYERON = true;
	}
	
	@SubscribeEvent
	public void onPlayerOut(PlayerEvent.PlayerLoggedOutEvent event){
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
	
	public static ObjModel getObjModelFromCache(ResourceLocation loc, boolean flip_x, boolean flip_f, boolean flip_u, boolean flip_v, boolean norm){
		if(OBJ_MODEL_DATA_CACHE.containsKey(loc)){
			return OBJ_MODEL_DATA_CACHE.get(loc);
		}
		Object[] stream = getModelInputStreamWithFallback(loc);
		ObjModel objmod = new ObjParser((InputStream)stream[0]).flipAxes(flip_x).flipFaces(flip_f).flipUV(flip_u, flip_v).readComments(false).noNormals(norm).parse();
		if(stream.length > 1) for(Closeable c : (Closeable[])stream[1]) try{ c.close(); } catch(IOException e){ e.printStackTrace();}
		OBJ_MODEL_DATA_CACHE.put(loc, objmod);
		return objmod;
	}

	public static void clearObjModelCache(){
		OBJ_MODEL_INFO_CACHE.clear();
		OBJ_MODEL_DATA_CACHE.clear();
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
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(ConstructorBlock.INSTANCE),
			new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Items.COMPARATOR, 4), new ItemStack(Items.REPEATER, 8),
			new ItemStack(Items.REDSTONE, 16), new ItemStack(Items.BOOK, 2), new ItemStack(Blocks.LEVER, 8));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(ConstCenterBlock.INSTANCE),
			new ItemStack(Blocks.IRON_BLOCK, 2), new ItemStack(Items.IRON_INGOT, 8), new ItemStack(Items.COMPARATOR, 2), new ItemStack(Items.REPEATER, 4),
			new ItemStack(Items.REDSTONE, 4), new ItemStack(Items.BOOK, 1), new ItemStack(Blocks.LEVER, 2), new ItemStack(Blocks.PISTON, 2));
		String gauge = InternalAddon.STANDARD_GAUGE.toString();
		Item gaugeitem = Item.getByNameOrId(gauge);
		Item gaugeitem16 = Item.getByNameOrId(gauge + ".16_straight");
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(gaugeitem),
			new ItemStack(Items.IRON_INGOT, 4), new ItemStack(Blocks.PLANKS, 4));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(Item.getByNameOrId(gauge + ".4_straight")), new ItemStack(gaugeitem, 4), new ItemStack(Items.IRON_INGOT, 2));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(Item.getByNameOrId(gauge + ".8_straight")), new ItemStack(gaugeitem, 8), new ItemStack(Items.IRON_INGOT, 3));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(Item.getByNameOrId(gauge + ".16_straight")), new ItemStack(gaugeitem, 16), new ItemStack(Items.IRON_INGOT, 4));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(Item.getByNameOrId(gauge + ".32_straight")), new ItemStack(gaugeitem, 32), new ItemStack(Items.IRON_INGOT, 8));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_up")), new ItemStack(gaugeitem, 16), new ItemStack(Items.IRON_INGOT, 4), new ItemStack(Blocks.PLANKS, 4));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_down")), new ItemStack(gaugeitem, 16), new ItemStack(Items.IRON_INGOT, 4), new ItemStack(Blocks.PLANKS, 4));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_up")), new ItemStack(gaugeitem16), new ItemStack(Blocks.PLANKS, 4));
		RecipeRegistry.addBluePrintRecipe(blockcat, new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_down")), new ItemStack(gaugeitem16), new ItemStack(Blocks.PLANKS, 4));
	}

	@SideOnly(Side.CLIENT)
	public static Class<? extends AddonSteeringOverlay> getOverlayOf(GenericVehicle vehicle){
		OverlayEvent event = new OverlayEvent(vehicle, vehicle.getVehicleData());
		MinecraftForge.EVENT_BUS.post(event);
		return OVERLAYS.containsKey(event.getOverlay()) ? OVERLAYS.get(event.getOverlay()) : OVERLAYS.get("default");
	}

	public static ArmorMaterial getClothMaterial(String matid){
		String[] split = matid.split(":");
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon.getRegistryName().getPath().equals(split[0])){
				ArmorMaterial mat = addon.getClothMaterials().get(split[1]);
				if(mat != null) return mat;
				else break;
			}
		}
		return NONE_MAT;
	}

	public static void linkTextureSuppliers(){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon.getTextureSuppliers().isEmpty()) continue;
			for(TextureSupply texsupp : addon.getTextureSuppliers().values()){
				for(String tar : texsupp.targets()){
					String[] split = tar.split(";");
					ResourceLocation rl = new ResourceLocation(split[1]);
					Textureable.TextureHolder holder = null;
					switch(split[0]){
						case "vehicle":{
							holder =  VEHICLES.getValue(rl);
							break;
						}
						case "part":{
							holder = PARTS.getValue(rl);
							break;
						}
						case "container":{
							holder = CONTAINERS.getValue(rl);
							break;
						}
					}
					if(holder != null){
						holder.getDefaultTextures().addAll(texsupp.textures());
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
		return addon.getDefaultCreativeTab();
	}

	public static Addon getAddon(String string){
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon.getRegistryName().getPath().equals(string)) return addon;
		}
		return null;
	}

	public static void loadWireDecorations(boolean client){
		for(Entry<String, JsonObject> cache : WIRE_DECO_CACHE.entrySet()){
			for(Entry<String, JsonElement> entry : cache.getValue().entrySet()){
				if(client){
					parseWireModel(cache.getKey() + ":" + entry.getKey(), entry.getValue());
				}
				WIRE_DECOS.add(cache.getKey() + ":" + entry.getKey());
			}
		}
		WIRE_DECO_CACHE.clear();
	}

	@SideOnly(Side.CLIENT)
	private static void parseWireModel(String key, JsonElement value){
		String name = null;
		JsonArray array = null;
		if(value.isJsonArray()){
			array = value.getAsJsonArray();
			name = array.get(0).getAsString();
		}
		else{
			name = value.getAsString();
		}
		WireModel model = (WireModel)getModel(name, WireModel.class);
		if(array.size() > 1) model.texture(new ResourceLocation(array.get(1).getAsString()));
		if(array.size() > 2) model.accepts(JsonUtil.jsonArrayToStringArray(array.get(2).getAsJsonArray()));
		if(array.size() > 3) model.decotype(array.get(3).getAsString());
		WireModel.DECOS.put(key, model.key(key));
	}
	
	private static Field i18n_locale;
	private static Method locale_load_is, locale_check_uni;

	@SideOnly(Side.CLIENT)
	public static void loadLitePackLang() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, FileNotFoundException {
		ArrayList<Addon> lites = new ArrayList<>();
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon.getLoc() == AddonLocation.LITEPACK) lites.add(addon);
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
		for(Addon addon : ADDONS.getValuesCollection()){
			if(addon.getLoc() == AddonLocation.LITEPACK) lites.add(addon);
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

}
