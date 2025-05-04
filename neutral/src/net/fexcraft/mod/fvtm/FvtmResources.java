package net.fexcraft.mod.fvtm;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fcl.UniFCL;
import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.attribute.*;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.MultiBlock;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.block.BarrelBlockFunction;
import net.fexcraft.mod.fvtm.function.block.BoolBlockFunction;
import net.fexcraft.mod.fvtm.function.block.SeatBlockFunction;
import net.fexcraft.mod.fvtm.function.block.SetStateFunction;
import net.fexcraft.mod.fvtm.function.part.*;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.model.content.*;
import net.fexcraft.mod.fvtm.model.loaders.*;
import net.fexcraft.mod.fvtm.util.CTab;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.fvtm.util.ZipUtils;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.fexcraft.mod.fvtm.handler.BogieInstallationHandler;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.FclRecipe;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.inv.ItemWrapper;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static net.fexcraft.mod.fvtm.FvtmLogger.LOGGER;
import static net.fexcraft.mod.fvtm.FvtmRegistry.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class FvtmResources {

	public static FvtmResources INSTANCE;
	public static File FVTM_CONFIG_DIR;
	public static final IDL NULL_TEXTURE = IDLManager.getIDLNamed("No Texture;fvtm:textures/entity/null.png");
	public static final IDL WHITE_TEXTURE = IDLManager.getIDLNamed("No Texture;fvtm:textures/entity/white.png");

	public void init(){
		FVTM_CONFIG_DIR = new File(FvtmRegistry.CONFIG_DIR, "/fvtm/");
		if(!FVTM_CONFIG_DIR.exists()) FVTM_CONFIG_DIR.mkdirs();
		//
		JsonMap map = new JsonMap();
		map.add("ID", INTERNAL_ADDON_ID.colon());
		map.add("Name", "FVTM Internal Addon");
		JsonMap ctabs = new JsonMap();
		ctabs.add("default", "fvtm:toolbox" + (EnvInfo.is120() ? "_0" : ""));
		map.add("CreativeTabs", ctabs);
		ADDONS.register(new Addon(null, AddonLocation.INTERNAL).parse(map));
		//
		INSTANCE.searchASMPacks();
		boolean failed = searchPacksInResourcePacks();
		if(!EnvInfo.CLIENT || failed){
			searchPacksInFolder(new File(FvtmRegistry.CONFIG_DIR.getParentFile(), "/resourcepacks/"), AddonLocation.RESOURCEPACK, false);
		}
		searchPacksInFolder(new File(FVTM_CONFIG_DIR, "packs/"), AddonLocation.CONFIGPACK, true);
		searchPacksInFolder(new File(FvtmRegistry.CONFIG_DIR.getParentFile(), "/mods/"), AddonLocation.CONFIGPACK, false);
		for(File file : Config.PACK_FOLDERS){
			searchPacksInFolder(file, AddonLocation.CONFIGPACK, true);
		}
		searchPacksInFolder(new File(FVTM_CONFIG_DIR, "packs/"), AddonLocation.CONFIGPACK, true);
		if(EnvInfo.CLIENT) loadPackTextures();
	}

	public abstract void searchASMPacks();

	public abstract boolean searchPacksInResourcePacks();

	public void searchPacksInFolder(File folder, AddonLocation loc, boolean create){
		if(!folder.exists()){
			if(!create) return;
			folder.mkdir();
		}
		for(File file : folder.listFiles()){
			if(file.isHidden()) continue;
			if(file.isDirectory()){
				File assets = new File(file, "assets/");
				if(assets.exists()){
					for(File fl : assets.listFiles()){
						if(!fl.isDirectory()) continue;
						File dec = new File(fl, "addonpack.fvtm");
						if(dec.exists()){
							JsonMap map = JsonHandler.parse(dec);
							if(isDuplicateOrInvalidPack(map)) continue;
							ADDONS.register(new Addon(file, loc).parse(map));
						}
					}
				}
			}
			else if(file.getName().endsWith(".zip") || file.getName().endsWith(".jar")){
				JsonArray array = ZipUtils.getValuesAt(file, "assets", "addonpack.fvtm");
				for(JsonValue<?> value : array.value){
					if(!value.isMap()) continue;
					JsonMap map = value.asMap();
					if(isDuplicateOrInvalidPack(map)) continue;
					ADDONS.register(new Addon(file, loc).parse(map));
				}
			}
		}
	}

	public static boolean isDuplicateOrInvalidPack(JsonMap map){
		if(!map.has("RegistryName") && !map.has("ID")) return true;
		IDL id = ContentConfigUtil.getID(map);
		for(Addon addon : ADDONS){
			if(addon.getID().equals(id)) return true;
		}
		return false;
	}

	public abstract void loadPackTextures();

	public void registerAttributes(){
		ATTRIBUTES.put("boolean", AttrBoolean.class);
		ATTRIBUTES.put("bool", AttrBoolean.class);
		ATTRIBUTES.put("bln", AttrBoolean.class);
		ATTRIBUTES.put("float", AttrFloat.class);
		ATTRIBUTES.put("flt", AttrFloat.class);
		ATTRIBUTES.put("integer", AttrInteger.class);
		ATTRIBUTES.put("int", AttrInteger.class);
		ATTRIBUTES.put("tristate", AttrTristate.class);
		ATTRIBUTES.put("tri", AttrTristate.class);
		ATTRIBUTES.put("string", AttrString.class);
		ATTRIBUTES.put("str", AttrString.class);
		ATTRIBUTES.put("vector3", AttrVector.class);
		ATTRIBUTES.put("vector", AttrVector.class);
		ATTRIBUTES.put("vec", AttrVector.class);
	}

	public void registerFunctions(){
		PART_FUNCTIONS.put("fvtm:wheel", WheelFunction.class);
		PART_FUNCTIONS.put("fvtm:wheel_positions", WheelPositionsFunction.class);
		PART_FUNCTIONS.put("fvtm:seats", SeatsFunction.class);
		PART_FUNCTIONS.put("fvtm:engine", EngineFunction.class);
		PART_FUNCTIONS.put("fvtm:inventory", InventoryFunction.class);
		PART_FUNCTIONS.put("fvtm:container", ContainerFunction.class);
		PART_FUNCTIONS.put("fvtm:bogie", BogieFunction.class);
		PART_FUNCTIONS.put("fvtm:part_slots", PartSlotsFunction.class);
		PART_FUNCTIONS.put("fvtm:connector", ConnectorFunction.class);
		PART_FUNCTIONS.put("fvtm:color", ColorFunction.class);
		PART_FUNCTIONS.put("fvtm:tire", TireFunction.class);
		PART_FUNCTIONS.put("fvtm:transmission", TransmissionFunction.class);
		PART_FUNCTIONS.put("fvtm:particle_emitter", ParticleEmitterFunction.class);
		PART_FUNCTIONS.put("fvtm:interact_zone", InteractZoneFunction.class);
		//
		BLOCK_FUNCTIONS.put("fvtm:seat", SeatBlockFunction.class);
		BLOCK_FUNCTIONS.put("fvtm:set_state", SetStateFunction.class);
		BLOCK_FUNCTIONS.put("fvtm:boolean", BoolBlockFunction.class);
		//BLOCK_FUNCTIONS.put("fvtm:inventory", InventoryBlockFunction.class);
		BLOCK_FUNCTIONS.put("fvtm:barrel", BarrelBlockFunction.class);
	}

	public void registerHandlers(){
		PartInstallHandler.HANDLERS.put("default", new DefaultPartInstallHandler());
		PartInstallHandler.HANDLERS.put("wheel", new WheelInstallationHandler());
		PartInstallHandler.HANDLERS.put("bogie", new BogieInstallationHandler());
		PartInstallHandler.HANDLERS.put("tire", new TireInstallationHandler());
	}

	public void searchContent(){
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.FUEL);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.MATERIAL);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.CONSUMABLE);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.CLOTH);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.RAILGAUGE);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.WIRE);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.WIREDECO);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.SIGN);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.DECORATION);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.CONTAINER);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.BLOCK);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.MULTIBLOCK);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.PART);
		FvtmResources.INSTANCE.searchInPacksFor(ContentType.VEHICLE);
	}

	public void searchInPacksFor(ContentType contype){
		if(contype == ContentType.ADDON) return;
		for(Addon addon : ADDONS){
			if(addon.getFile() == null) continue;
			if(addon.getFile().isDirectory()){
				File folder = new File(addon.getFile(), "assets/" + addon.getID().id() + "/config/" + contype.folder + "/");
				if(!folder.exists()) continue;
				ArrayList<File> files = findFiles(folder, contype.suffix);
				for(File file : files){
					try{
						JsonMap map = JsonHandler.parse(file);
						IDL idl = ContentConfigUtil.getID(addon, map);
						if(idl == null) map.add("ID", addon.getID().id() + ":" + file.getName().substring(0, file.getName().indexOf(".")).toLowerCase());
						Content<?> content = (Content<?>)contype.impl.newInstance().parse(map);
						if(content == null){
							idl = ContentConfigUtil.getID(map);
							LOGGER.log("Errors while loading config file: " + file + " for " + idl.colon());
							continue;
						}
						contype.register(content);
					}
					catch(Exception e){
						FvtmLogger.log(e, "while loading config file: " + file);
					}
				}
			}
			else{
				String lastentry = null;
				try{
					String path = "assets/" + addon.getID().id() + "/config/" + contype.folder + "/";
					ZipFile zip = new ZipFile(addon.getFile());
					ZipInputStream stream = new ZipInputStream(new FileInputStream(addon.getFile()));
					ZipEntry entry = null;
					while(true){
						entry = stream.getNextEntry();
						if(entry == null) break;
						lastentry = entry.getName();
						if(entry.getName().startsWith(path) && entry.getName().endsWith(contype.suffix)){
							try{
								JsonMap map = JsonHandler.parse(zip.getInputStream(entry));
								IDL idl = ContentConfigUtil.getID(addon, map);
								if(idl == null) map.add("ID", addon.getID().id() + ":" + entry.getName().substring(0, entry.getName().indexOf(".")).toLowerCase());
								Content<?> content = (Content<?>)contype.impl.newInstance().parse(map);
								if(content == null){
									idl = ContentConfigUtil.getID(map);
									LOGGER.log("Errors while loading config from zip: " + addon.getFile() + " for " + idl.colon());
									continue;
								}
								contype.register(content);
							}
							catch(Exception e){
								FvtmLogger.log(e, "config parsing of " + entry.getName());
							}
						}
					}
				}
				catch(Exception e){
					FvtmLogger.log(e, "while loading config from zip " + addon.getFile() + " / " + lastentry);
				}
			}
		}
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

	public abstract void createContentBlocks();

	public abstract void createContentItems();

	public void registerRecipes(){
		registerFvtmRecipes();
		INSTANCE.searchInPacksFor(ContentType.RECIPE);
		for(Recipe recipe : RECIPES){
			if(recipe.fcl){
				FclRecipe.register(recipe.category, new FclRecipe(recipe.output, recipe.fclcomps.toArray(new FclRecipe.Component[0])));
			}
		}
	}

	public abstract void registerFvtmRecipes();

	public abstract ItemWrapper getItemWrapper(String id);

	public CTab getCreativeTab(WithItem type){
		String tab = type.getCreativeTab();
		Addon addon = null;
		if(tab.contains(":")){
			String[] split = tab.split(":");
			addon = getAddon(split[0]);
			if(addon == null) return null;
			return addon.getCreativeTab(split[1]);
		}
		addon = ((Content<?>)type).getAddon();
		return addon.getCreativeTab(tab);
	}

	public CTab getCreativeTab(String tabid){
		if(tabid.contains(":")){
			String[] split = tabid.split(":");
			Addon addon = getAddon(split[0]);
			if(addon != null) return addon.getCreativeTab(split[1]);
		}
		return ADDONS.get(INTERNAL_ADDON_ID).getCreativeTab(tabid);
	}

	public abstract StackWrapper newStack0(ItemWrapper item);

	public static StackWrapper newStack(IDL id){
		return INSTANCE.newStack0(FvtmRegistry.getItem(id.colon()));
	}

	public static StackWrapper newStack(ItemWrapper item){
		return INSTANCE.newStack0(item);
	}

	//-V-// Model Loading //-V-//

	private static boolean initialmodelload;

	public void initModelLoaders(){
		MODEL_LOADERS.add(new ClassModelLoader());
		MODEL_LOADERS.add(new BlankModelLoader());
		MODEL_LOADERS.add(new JTMTModelLoader());
		MODEL_LOADERS.add(new FMFModelLoader());
		MODEL_LOADERS.add(new ObjModelLoader());
		MODEL_LOADERS.add(new SMPTBJavaModelLoader());
		MODEL_LOADERS.add(new BEOModelLoader());
	}

	public abstract void initModelPrograms();

	public void initModels(){
		PARTS.forEach(part -> part.loadModel());
		VEHICLES.forEach(vehicle -> vehicle.loadModel());
		BLOCKS.forEach(block -> block.loadModel());
		CLOTHES.forEach(cloth -> cloth.loadModel());
		WIRES.forEach(wire -> wire.loadModel());
		WIREDECOS.forEach(deco -> deco.loadModel());
		CONTAINERS.forEach(con -> con.loadModel());
		RAILGAUGES.forEach(rail -> rail.loadModel());
		DECORATIONS.forEach(deco -> deco.loadModel());
		SIGNS.forEach(sign -> sign.loadModel());
	}

	public void initModelsClear(){
		ObjModelLoader.clearCache();
	}

	public static void initModelSystem(){
		FvtmResources.INSTANCE.initModelLoaders();
		FvtmResources.INSTANCE.initModelPrograms();
		initialmodelload = true;
		reloadModels();
		initialmodelload = false;
	}

	public static void reloadModels(){
		if(!initialmodelload) return;
		MODELS.clear();
		FvtmResources.INSTANCE.initModels();
		FvtmResources.INSTANCE.initModelsClear();
	}

	public static Model getModel(String location, ModelData data, Class<? extends Model> clazz){
		if(location == null || location.equals("") || location.equals("null")) return getEmptyModelForClass(clazz);
		boolean bake = location.startsWith("baked|");
		if(bake){
			location = location.substring(6);
			data.add("Baked", true);
		}
		Model model = null;
		if(MODELS.containsKey(location)){
			try{
				model = clazz.getConstructor().newInstance();
				model.setGroups(MODELS.get(location).copyWithoutPrograms());
				model.parse(data).lock();
				return model;
			}
			catch(Throwable e){
				FvtmLogger.log(e, "new model instance of " + clazz);
				Static.stop();
				return getEmptyModelForClass(clazz);
			}
		}
		ModelLoader loader = getModelLoader(location, FilenameUtils.getExtension(location));
		if(loader == null) return getEmptyModelForClass(clazz);
		try{
			Object[] ret = loader.load(location, data, () -> {
				try{
					return clazz.getConstructor().newInstance();
				}
				catch(Throwable e){
					FvtmLogger.log(e, "new model instance of " + clazz);
					Static.stop();
					return null;
				}
			});
			if(ret.length == 0 || ret[0] == null) return getEmptyModelForClass(clazz);
			model = (Model)ret[0];
			if(ret.length > 1) data = (ModelData)ret[1];
			MODELS.put(location, model.getGroups().copyWithoutPrograms());
			data.location = location;
			model.parse(data).lock();
		}
		catch(Throwable e){
			FvtmLogger.log(e, "model load of " + location);
		}
		return model;
	}

	public static Model getEmptyModelForClass(Class<? extends Model> clazz){
		//if(clazz == ContainerModel.class) return ContainerModel.EMPTY;
		//if(clazz == PartModel.class) return PartModel.EMPTY;
		if(clazz == VehicleModel.class) return VehicleModel.EMPTY;
		//if(clazz == TrafficSignModel.class) return TrafficSignModel.EMPTY;
		if(clazz == BlockModel.class) return BlockModel.EMPTY;
		if(clazz == RailGaugeModel.class) return RailGaugeModel.EMPTY;
		if(clazz == ClothModel.class) return ClothModel.EMPTY;
		if(clazz == WireModel.class) return WireModel.EMPTY;
		return DefaultModel.EMPTY;
	}

	public static ModelLoader getModelLoader(String name, String extension){
		for(ModelLoader loader : MODEL_LOADERS){
			if(loader.accepts(name, extension)) return loader;
		}
		return null;
	}

	public InputStream getAssetInputStream(String loc, boolean log){
		return getAssetInputStream(IDLManager.getIDLCached(loc), log);
	}

	public abstract InputStream getAssetInputStream(IDL loc, boolean log);

	public static Object[] getAssetInputStreamWithFallback(String loc){
		return getAssetInputStreamWithFallback(IDLManager.getIDLCached(loc));
	}

	public static Object[] getAssetInputStreamWithFallback(IDL loc){
		Closeable[] close = null;
		InputStream stream = INSTANCE.getAssetInputStream(loc, false);
		if(stream != null) return new Object[]{ stream };
		try{
			Addon addon = getAddon(loc.space());
			if(addon != null && addon.getLocation().isConfigPack()){
				if(addon.getFile().isDirectory()){
					File file = new File(addon.getFile(), "assets/" + loc.space() + "/" + loc.path());
					if(file.exists()) stream = new FileInputStream(file);
				}
				else{
					String filename = "assets/" + loc.space() + "/" + loc.path();
					ZipFile zip = new ZipFile(addon.getFile());
					ZipInputStream zipstream = new ZipInputStream(new FileInputStream(addon.getFile()));
					close = new Closeable[]{ zip, zipstream };
					while(true){
						ZipEntry entry = zipstream.getNextEntry();
						if(entry == null) break;
						if(entry.getName().equals(filename)){
							stream = zip.getInputStream(entry);
							ByteArrayOutputStream out = new ByteArrayOutputStream();
							byte[] buffer = new byte[1024];
							int read;
							while((read = stream.read(buffer)) != -1) out.write(buffer, 0, read);
							stream = new ByteArrayInputStream(out.toByteArray());
							break;
						}
					}
				}
			}
		}
		catch(Throwable e){
			FvtmLogger.log(e, "asset input steam of " + loc);
		}
		return close == null ? new Object[]{ stream } : new Object[]{ stream, close };
	}

	public abstract boolean isModPresent(String s);

	public IDL getExternalTexture(String custom){
		if(custom.startsWith("server:")){
			return UniFCL.requestServerFile(null, custom);
		}
		return getExternalTexture0(custom);
	}

	public abstract IDL getExternalTexture0(String custom);

	public static PartFunction getFunction(String key){
		try{
			return PART_FUNCTIONS.get(key).newInstance();
		}
		catch(Exception e){
			if(EnvInfo.DEV) e.printStackTrace();
			return null;
		}
	}

	public static PartData getPartData(TagCW com){
		Part part = PARTS.get(com.getString("Part"));
		if(part == null) return null;
		return new PartData(part).read(com);
	}

	public static PartData getPartData(Object com){
		return getPartData(TagCW.wrap(com));
	}

	public static VehicleData getVehicleData(TagCW com){
		Vehicle vehicle = VEHICLES.get(com.getString("Vehicle"));
		if(vehicle == null) return null;
		return new VehicleData(vehicle).read(com);
	}

	public static VehicleData getVehicleData(Object com){
		return getVehicleData(TagCW.wrap(com));
	}

	public static DecorationData getDecorationData(TagCW com){
		Decoration deco = DECORATIONS.get(com.getString("Decoration"));
		if(deco == null && com.has("key")) deco = DECORATIONS.get(com.getString("key"));
		if(deco == null) return null;
		return new DecorationData(deco).read(com);
	}

	public static DecorationData getDecorationData(Object com){
		return getDecorationData(TagCW.wrap(com));
	}

	public static SignData getSignData(TagCW com){
		Sign sign = SIGNS.get(com.getString("Sign"));
		if(sign == null && com.has("key")) sign = SIGNS.get(com.getString("key"));
		if(sign == null) return null;
		return new SignData(sign).read(com);
	}

	public static BlockData getBlockData(TagCW com){
		Block block = BLOCKS.get(com.getString("Block"));
		if(block == null) return null;
		return new BlockData(block).read(com);
	}

	public static MultiBlockData getMultiBlockData(Object com){
		return getMultiBlockData(TagCW.wrap(com));
	}

	public static MultiBlockData getMultiBlockData(TagCW com){
		MultiBlock block = MULTIBLOCKS.get(com.getString("Block"));
		if(block == null) return null;
		return new MultiBlockData(block).read(com);
	}

	public static BlockData getBlockData(Object com){
		return getBlockData(TagCW.wrap(com));
	}

	public static ContainerData getContainerData(Object tag){
		return getContainerData(TagCW.wrap(tag));
	}

	public static ContainerData getContainerData(TagCW com){
		if(!com.has("Container")) return null;
		Container con = CONTAINERS.get(com.getString("Container"));
		if(con == null) return null;
		try{
			return new ContainerData(con).read(com);
		}
		catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}

	public abstract void registerFvtmBlocks();

	public abstract void registerFvtmItems();

	public abstract double getMouseSensitivity();

	public abstract Object getBlockMaterial(String key, boolean allownull);

	public abstract void spawnRoadMarker(WorldW world, QV3D vector, UUID nid);

	public abstract void spawnRailMarker(WorldW world, QV3D vector, UUID nid);

	public abstract void linkItemContainer(ItemWrapper item);

}
