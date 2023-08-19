package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.Config.U12_SYNC_RATE;
import static net.fexcraft.mod.fvtm.FvtmRegistry.ADDONS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.WIRE_DECO_CACHE;
import static net.fexcraft.mod.fvtm.FvtmRegistry.getAddon;
import static net.fexcraft.mod.fvtm.FvtmRegistry.getFuel;
import static net.fexcraft.mod.fvtm.FvtmResources.getModel;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.mc.crafting.RecipeRegistry;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.block.VPInfo;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.TextureSupply;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
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
import net.fexcraft.mod.fvtm.data.root.Textureable;
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
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.WireModel;
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
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Resources {

	public static RegistryOld<Part> PARTS = new RegistryOld<>();
	public static RegistryOld<Vehicle> VEHICLES = new RegistryOld<>();
	public static RegistryOld<Container> CONTAINERS = new RegistryOld<>();
	public static RegistryOld<Block> BLOCKS = new RegistryOld<>();
	public static RegistryOld<MultiBlock> MULTIBLOCKS = new RegistryOld<>();
	public static RegistryOld<RailGauge> RAILGAUGES = new RegistryOld<>();
	public static RegistryOld<Cloth> CLOTHES = new RegistryOld<>();
	public static RegistryOld<WireType> WIRES = new RegistryOld<>();
	private static TreeMap<String, Class<? extends Function>> FUNCTIONS = new TreeMap<>();
	private static TreeMap<String, Class<? extends BlockFunction>> BLOCK_FUNCTIONS = new TreeMap<>();
	private static TreeMap<String, Class<? extends Attribute<?>>> ATTRIBUTE_TYPES = new TreeMap<>();
	private static TreeMap<String, Boolean> LOADED_MODS = new TreeMap<>();
	public static TreeMap<String, Class<? extends AddonSteeringOverlay>> OVERLAYS = new TreeMap<>();
	public static final NamedResourceLocation NULL_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/null.png");
	public static final NamedResourceLocation WHITE_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/white.png");
	public static final String UTIL_LISTENER = "fvtm:utils";
	public static final ArrayList<String> WIRE_DECOS = new ArrayList<>();
	//
	private static Field respackfile = null;
	
	public Resources(FMLPreInitializationEvent event){
		//registerAttributeTypes();
		//registerModifierImpls();
		registerFunctions();
		//
		// search in packs for //
		//
		// init model loaders //
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

	public static String getFuelName(ResourceLocation id){
		return getFuelName(id.toString());
	}

	public static String getFuelName(String id){
		Fuel fuel = getFuel(id); return fuel == null ? "not-found" : fuel.getName();
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
			if(addon.getLocation() == AddonLocation.CONFIGPACK) lites.add(addon);
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
			if(addon.getFile().isDirectory()){
				if(!addon.getFile().isDirectory()) return;
				//
				File folder = new File(addon.getFile(), "assets/" + addon.getID().id() + "/lang/");
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
				String path = "assets/" + addon.getID().id() + "/lang/", extension = ".lang";
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

	public static Object[] getInputStream(ResourceLocation resloc){
		Closeable[] close = null;
		InputStream stream = FvtmResources.INSTANCE.getModelInputStream(IDLManager.getIDL(resloc.toString()), false);
		if(stream != null) return new Object[]{ stream };
		try{
			Addon addon = getAddon(resloc.getNamespace());
			if(addon != null){
				if(addon.getFile().isDirectory()){
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
