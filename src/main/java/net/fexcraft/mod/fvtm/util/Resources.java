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
import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.block.generated.BlockBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Consumable;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.RoadSign;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonClass;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHoldingEntity;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.RoadSignItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.model.RoadSignModel;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.RailDataSerializer;
import net.fexcraft.mod.fvtm.util.caps.RenderCacheHandler;
import net.fexcraft.mod.fvtm.util.caps.RoadDataSerializer;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.BogieFunction;
import net.fexcraft.mod.fvtm.util.function.ContainerFunction;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.fvtm.util.function.SeatsFunction;
import net.fexcraft.mod.fvtm.util.function.WheelFunction;
import net.fexcraft.mod.fvtm.util.function.WheelPositionsFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.ChunkEvent;
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
	public static TreeMap<String, TreeMap<String, ArrayList<Fuel>>> FUELS = new TreeMap<>();
	private static TreeMap<String, Class<? extends Function>> FUNCTIONS = new TreeMap<>();
	public static final HashMap<String, Model<?, ?>> MODELS = new HashMap<>();
	public static final ResourceLocation NULL_TEXTURE = new ResourceLocation("fvtm:textures/entity/null.png");
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
					if(stream == null) continue; JsonObject obj = JsonUtil.getObjectFromInputStream(stream);
					ADDONS.register(new Addon(type, file).parse(obj));
				}
				else{
					ADDONS.register((Addon)clazz.getConstructor(ContainerType.class, File.class).newInstance(type, file));
					//TODO find out how to get the actual instance of the mod.
				}
				Print.log("Registered FVTM Addon with ID '" + addon.registryname() + "'!");
			} catch(Exception e){ e.printStackTrace(); }
		}
		//
		//TODO check addon on/off state
		//
		registerFunctions();
		//
		searchInAddonsFor(DataType.FUEL);
		searchInAddonsFor(DataType.MATERIAL);
		searchInAddonsFor(DataType.CONSUMABLE);
		searchInAddonsFor(DataType.RAILGAUGE);
		searchInAddonsFor(DataType.CONTAINER);
		searchInAddonsFor(DataType.BLOCK);
		searchInAddonsFor(DataType.PART);
		searchInAddonsFor(DataType.VEHICLE);
		//
		searchInAddonsFor(DataType.ROADSIGN);
	}

	public static final void loadPresets(){
		for(Addon addon : ADDONS.getValuesCollection()){ addon.loadPresets(); }
		File file = new File("./config/fvtm/presets/");
		if(!file.exists()) file.mkdirs();
		File[] files = file.listFiles();
		for(File fl : files){
			try{
				JsonObject obj = JsonUtil.get(fl); if(obj.entrySet().isEmpty()) continue;
				Vehicle vehicle = Resources.VEHICLES.getValue(new ResourceLocation(obj.get("Vehicle").getAsString()));
				VehicleData data = (VehicleData)vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle);
				data.read(JsonToNBT.getTagFromJson(obj.toString())); data.setPreset(JsonUtil.getIfExists(obj, "Preset", "Nameless"));
				PresetTab.INSTANCE.add(data.newItemStack());
			} catch(Exception e){ e.printStackTrace(); Static.stop(); }
		}
	}

	private void registerFunctions(){
		registerFunction("fvtm:wheel", WheelFunction.class, true);
		registerFunction("fvtm:wheel_positions", WheelPositionsFunction.class, true);
		registerFunction("fvtm:seats", SeatsFunction.class, true);
		registerFunction("fvtm:engine", EngineFunction.class, true);
		registerFunction("fvtm:inventory", InventoryFunction.class, true);
		registerFunction("fvtm:container", ContainerFunction.class, true);
		registerFunction("fvtm:bogie", BogieFunction.class, true);
	}

	private void searchInAddonsFor(DataType datatype){
		for(Addon addon : ADDONS.getValuesCollection()){
			try{ addon.searchFor(datatype); } catch (Throwable thr){ thr.printStackTrace(); Static.stop(); }
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
	
	@SuppressWarnings("unchecked")
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
					model = clazz.getConstructor(String.class, ResourceLocation.class).newInstance("obj", new ResourceLocation(name));
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
	
	/** Registers a Functon class into FVTM Resources.*/
	public static void registerFunction(ResourceLocation regname, Class<? extends Function> clazz, boolean override){
		registerFunction(regname.toString(), clazz, override);
	}
	
	/** Registers a Functon class into FVTM Resources.*/
	public static void registerFunction(String regname, Class<? extends Function> clazz, boolean override){
		if(FUNCTIONS.containsKey(regname) && !override) return; FUNCTIONS.put(regname, clazz);
	}
	
	public static Class<? extends Function> getFunction(ResourceLocation regname){
		return getFunction(regname.toString());
	}
	
	public static Class<? extends Function> getFunction(String id){
		return FUNCTIONS.get(id);
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
		event.addCapability(new ResourceLocation("fvtm:raildata"), new RailDataSerializer(event.getObject(), event.getObject().provider.getDimension()));
		event.addCapability(new ResourceLocation("fvtm:roaddata"), new RoadDataSerializer(event.getObject(), event.getObject().provider.getDimension()));
	}
	
	@SubscribeEvent
	public void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event){
		if(event.getObject() instanceof ContainerHoldingEntity){
			event.addCapability(new ResourceLocation("fvtm:container"), new ContainerHolderUtil(event.getObject()));
		}
		if(Static.side().isClient() && event.getObject() instanceof VehicleEntity){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
	}
	
	@SubscribeEvent
	public void onAttachTileEntityCapabilities(AttachCapabilitiesEvent<TileEntity> event){
		if(Static.side().isClient() && (event.getObject() instanceof DisplayEntity ||
			event.getObject() instanceof BlockBase.TileEntity || event.getObject() instanceof ContainerEntity)){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
	}
	
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event){
		if(event.phase != Phase.START) return;
		for(World world : Static.getServer().worlds){
			world.getCapability(Capabilities.RAILSYSTEM, null).updateTick();
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
		event.getWorld().getCapability(Capabilities.RAILSYSTEM, null).onChunkLoad(event.getChunk());
	}
	
	@SubscribeEvent
	public void onChunkUnload(ChunkEvent.Unload event){
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
		if(!Static.getServer().isSinglePlayer()) return; RailSys.PLAYERON = true;
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
		if(event.getEntity().isRiding() && event.getEntity().getRidingEntity() instanceof SeatEntity){// && !event.getSource().isProjectile()){
			event.setCanceled(true);
		}
	}

}
