package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.mc.crafting.RecipeRegistry;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.RoadSign;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
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
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.event.OverlayEvent;
import net.fexcraft.mod.fvtm.event.ResourceEvents;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.RoadSignItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.ClothModel;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.model.RoadSignModel;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.MultiBlockCacheSerializer;
import net.fexcraft.mod.fvtm.util.caps.PassengerCapHandler;
import net.fexcraft.mod.fvtm.util.caps.PlayerDataHandler;
import net.fexcraft.mod.fvtm.util.caps.RailDataSerializer;
import net.fexcraft.mod.fvtm.util.caps.RenderCacheHandler;
import net.fexcraft.mod.fvtm.util.caps.RoadDataSerializer;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.*;
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
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.Loader;
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
	public static IForgeRegistry<RoadSign> ROADSIGNS;
	public static IForgeRegistry<Consumable> CONSUMABLES;
	public static IForgeRegistry<Container> CONTAINERS;
	public static IForgeRegistry<Block> BLOCKS;
	public static IForgeRegistry<RailGauge> RAILGAUGES;
	public static IForgeRegistry<Cloth> CLOTHES;
	public static TreeMap<String, TreeMap<String, ArrayList<Fuel>>> FUELS = new TreeMap<>();
	private static TreeMap<String, Class<? extends Function>> FUNCTIONS = new TreeMap<>();
	private static TreeMap<String, Class<? extends Attribute<?>>> ATTRIBUTE_TYPES = new TreeMap<>();
	private static TreeMap<String, Class<? extends Modifier<?>>> MODIFIER_IMPLS = new TreeMap<>();
	private static TreeMap<String, Boolean> LOADED_MODS = new TreeMap<>();
	private static TreeMap<String, ObjModel> OBJ_MODEL_INFO_CACHE = new TreeMap<>();
	private static TreeMap<ResourceLocation, ObjModel> OBJ_MODEL_DATA_CACHE = new TreeMap<>();
	public static TreeMap<String, Class<? extends AddonSteeringOverlay>> OVERLAYS = new TreeMap<>();
	public static final HashMap<String, Model<?, ?>> MODELS = new HashMap<>();
	public static final ResourceLocation NULL_TEXTURE = new ResourceLocation("fvtm:textures/entity/null.png");
	public static final String UTIL_LISTENER = "fvtm:utils";
	//
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
		ROADSIGNS = new RegistryBuilder<RoadSign>().setName(new ResourceLocation("fvtm:roadsigns")).setType(RoadSign.class).create();
		CONSUMABLES = new RegistryBuilder<Consumable>().setName(new ResourceLocation("fvtm:consumables")).setType(Consumable.class).create();
		CONTAINERS = new RegistryBuilder<Container>().setName(new ResourceLocation("fvtm:containers")).setType(Container.class).create();
		BLOCKS = new RegistryBuilder<Block>().setName(new ResourceLocation("fvtm:blocks")).setType(Block.class).create();
		RAILGAUGES = new RegistryBuilder<RailGauge>().setName(new ResourceLocation("fvtm:railgauges")).setType(RailGauge.class).create();
		CLOTHES = new RegistryBuilder<Cloth>().setName(new ResourceLocation("fvtm:clothes")).setType(Cloth.class).create();
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
		//
		//TODO check addon on/off state
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
		searchInAddonsFor(DataType.CONTAINER);
		searchInAddonsFor(DataType.BLOCK);
		searchInAddonsFor(DataType.PART);
		searchInAddonsFor(DataType.VEHICLE);
		//
		searchInAddonsFor(DataType.ROADSIGN);
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
		MinecraftForge.EVENT_BUS.post(new ResourceEvents.RegisterAttributeTypes(this));
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
	
	@SideOnly(Side.CLIENT)
	public static <T, K> Model<T, K> getModel(String name, Class<? extends Model<T, K>> clazz){
		if(name == null || name.equals("") || name.equals("null")){
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		if(MODELS.containsKey(name)){
			return (Model<T, K>)MODELS.get(name);
		}
		if(FCLRegistry.getModel(name) != null){
			MODELS.put(name, FCLRegistry.getModel(name));
			//Model<T, K> model = FCLRegistry.getModel(name);
			/*if(model instanceof FCLBlockModel && model.getClass().getAnnotation(fModel.class) != null){
				String resloc = model.getClass().getAnnotation(fModel.class).registryname();
				FCLBlockModelLoader.addBlockModel(new ResourceLocation(resloc), (FCLBlockModel)model);
				FCLBlockModelLoader.addBlockModel(new ResourceLocation(resloc.replace("/block/", "/item/")), (FCLBlockModel)model);
			}*/
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
					String[] filter = name.split(";");
					String id = filter.length > 1 ? filter[filter.length - 1] : name;
					ResourceLocation loc = new ResourceLocation(id);
					ObjModel objdata = null;
					if(OBJ_MODEL_INFO_CACHE.containsKey(id)){
						objdata = OBJ_MODEL_INFO_CACHE.get(id);
					}
					else{
						objdata = new ObjParser(Resources.getModelInputStream(loc)).readComments(true).readModel(false).parse();
						OBJ_MODEL_INFO_CACHE.put(id, objdata);
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
				case "": default: return (Model<T, K>)getEmptyModelFromClass(clazz);
			}
		}
		catch(Throwable thr){
			Print.log("Failed to find/parse model with adress '" + name + "'!");
			thr.printStackTrace(); Static.stop();
			return (Model<T, K>)getEmptyModelFromClass(clazz);
		}
		MODELS.put(name, model);
		return model;
	}

	private static Model<?, ?> getEmptyModelFromClass(Class<? extends Model<?, ?>> clazz){
		//if(clazz == BlockModel.class) return BlockModel.EMPTY;
		if(clazz == ContainerModel.class) return ContainerModel.EMPTY;
		if(clazz == PartModel.class) return PartModel.EMPTY;
		if(clazz == VehicleModel.class) return VehicleModel.EMPTY;
		if(clazz == RoadSignModel.class) return RoadSignModel.EMPTY;
		if(clazz == BlockModel.class) return BlockModel.EMPTY;
		if(clazz == RailGaugeModel.class) return RailGaugeModel.EMPTY;
		if(clazz == ClothModel.class) return ClothModel.EMPTY;
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
				flightdata = ReflectionHelper.findField(NetHandlerPlayServer.class, "floatingTickCount", "field_147365_f");
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

	public static RoadSign getRoadSign(String string){
		return getRoadSign(new ResourceLocation(string));
	}

	private static RoadSign getRoadSign(ResourceLocation resloc){
		return ROADSIGNS.getValue(resloc);
	}	
	
	@SubscribeEvent
	public void onAttachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event){
		if(event.getObject().getItem() instanceof VehicleItem || event.getObject().getItem() instanceof PartItem || event.getObject().getItem() instanceof RoadSignItem
			|| event.getObject().getItem() instanceof ContainerItem || event.getObject().getItem() instanceof BlockItem){
			event.addCapability(new ResourceLocation("fvtm:vapdatacache"), new VAPDataCache(event.getObject()));
		}
	}
	
	@SubscribeEvent
	public void onAttachWorldCapabilities(AttachCapabilitiesEvent<World> event){
		//event.addCapability(new ResourceLocation("fvtm:resources"), new WorldResourcesUtil(event.getObject()));
		if(!Config.DISABLE_RAILS) event.addCapability(new ResourceLocation("fvtm:raildata"), new RailDataSerializer(event.getObject(), event.getObject().provider.getDimension()));
		if(!Config.DISABLE_ROADS) event.addCapability(new ResourceLocation("fvtm:roaddata"), new RoadDataSerializer(event.getObject(), event.getObject().provider.getDimension()));
		event.addCapability(new ResourceLocation("fvtm:multiblocks"), new MultiBlockCacheSerializer(event.getObject()));
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
			if(!Config.DISABLE_RAILS) world.getCapability(Capabilities.RAILSYSTEM, null).updateTick();
		}
	}
	
	/*@SideOnly(Side.CLIENT) @SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event){
		if(event.phase != Phase.START) return;
		if(net.minecraft.client.Minecraft.getMinecraft().world == null) return;
		if(net.minecraft.client.Minecraft.getMinecraft().world.getCapability(Capabilities.RAILSYSTEM, null) == null) return;
		net.minecraft.client.Minecraft.getMinecraft().world.getCapability(Capabilities.RAILSYSTEM, null).updateTick(true);
	}*/
	
	@SubscribeEvent
	public void onChunkLoad(ChunkEvent.Load event){
		if(Config.DISABLE_RAILS) return;
		event.getWorld().getCapability(Capabilities.RAILSYSTEM, null).onChunkLoad(event.getChunk());
		event.getChunk().getTileEntityMap().values().forEach(tile -> {
			if(tile instanceof MultiblockTileEntity){
				((MultiblockTileEntity)tile).setup();
			}
		});
	}
	
	@SubscribeEvent
	public void onChunkUnload(ChunkEvent.Unload event){
		if(Config.DISABLE_RAILS) return;
		event.getWorld().getCapability(Capabilities.RAILSYSTEM, null).onChunkUnload(event.getChunk());
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
		RailSys.PLAYERON = true;
	}
	
	@SubscribeEvent
	public void onPlayerOut(PlayerEvent.PlayerLoggedOutEvent event){
		if(!Static.getServer().isSinglePlayer()) return; RailSys.PLAYERON = false;
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
		ObjModel objmod = new ObjParser(Resources.getModelInputStream(loc)).flipAxes(flip_x).flipFaces(flip_f).flipUV(flip_u, flip_v).readComments(false).noNormals(norm).parse();
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

}
