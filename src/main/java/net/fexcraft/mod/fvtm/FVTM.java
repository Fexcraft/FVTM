package net.fexcraft.mod.fvtm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Timer;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.PacketHandler.PacketHandlerType;
import net.fexcraft.lib.mc.network.SimpleUpdateHandler;
import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.lib.mc.registry.FCLRegistry.AutoRegisterer;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.DisplayBlock;
import net.fexcraft.mod.fvtm.block.RailEntity;
import net.fexcraft.mod.fvtm.block.generated.BlockBase;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Passenger;
import net.fexcraft.mod.fvtm.data.PlayerData;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.data.RoadSystem;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.block.MultiBlockCache;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.entity.JunctionSwitchEntity;
import net.fexcraft.mod.fvtm.entity.RailTestEntity;
import net.fexcraft.mod.fvtm.entity.RoadSignEntity;
import net.fexcraft.mod.fvtm.entity.StreetSign;
import net.fexcraft.mod.fvtm.gui.ClientReceiver;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.gui.ServerReceiver;
import net.fexcraft.mod.fvtm.item.JunctionToolItem;
import net.fexcraft.mod.fvtm.item.RailItemTest;
import net.fexcraft.mod.fvtm.item.RoadSysItem;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.SignalItem0;
import net.fexcraft.mod.fvtm.model.RoadSignModel;
import net.fexcraft.mod.fvtm.render.*;
import net.fexcraft.mod.fvtm.sys.legacy.AirVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
import net.fexcraft.mod.fvtm.sys.road.RoadSys;
import net.fexcraft.mod.fvtm.util.CrashCallable;
import net.fexcraft.mod.fvtm.util.LegacySpawnSystem;
import net.fexcraft.mod.fvtm.util.ListenerClient;
import net.fexcraft.mod.fvtm.util.ListenerServer;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.MultiBlockCacheSerializer;
import net.fexcraft.mod.fvtm.util.caps.PassengerCapHandler;
import net.fexcraft.mod.fvtm.util.caps.PlayerDataHandler;
import net.fexcraft.mod.fvtm.util.caps.RailDataSerializer;
import net.fexcraft.mod.fvtm.util.caps.RenderCacheHandler;
import net.fexcraft.mod.fvtm.util.caps.RoadDataSerializer;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Fex's Vehicle and Transportation Mod - A Modification adding a custom (mainly json based) add-on system to create customizable vehicles and, by far, more.
 * <br>
 * License:
 * <a href="http://fexcraft.net/license?id=mods">http://fexcraft.net/license?id=mods</a>
 *
 * @author Ferdinand Calo'
 *
 */
@Mod(modid = FVTM.MODID, name = "Fex's Vehicle and Transportation Mod", version = FVTM.VERSION,
	acceptableRemoteVersions = "*", acceptedMinecraftVersions = "*", dependencies = "required-after:fcl;after:trackapi",
	guiFactory = "net.fexcraft.mod.fvtm.util.config.GuiFactory")
public class FVTM {

	public static final String MODID = "fvtm";
	public static final String PREFIX = Formatter.format("&0[&9FVTM&0]&7 ");
	public static final String VERSION = "@VERSION@";

	@Mod.Instance(FVTM.MODID)
	private static FVTM INSTANCE;
	private static AutoRegisterer REGISTERER;
	private static Resources RESOURCES;
	
	private static Timer RAILSYSTEM, ROADSYSTEM;

	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		REGISTERER = new AutoRegisterer(MODID);
		Config.initalize(event, event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().registerCrashCallable(new CrashCallable());
		//
		EntitySystem.REGISTRY.put("legacy", new LegacySpawnSystem());
		EntitySystem.REGISTRY.put("duplicate", new LegacySpawnSystem());
		GameRegistry.registerTileEntity(BlockBase.TileEntity.class, new ResourceLocation("fvtm:blockbase"));
		GameRegistry.registerTileEntity(M_4ROT_TE.TileEntity.class, new ResourceLocation("fvtm:multiblock"));
		GameRegistry.registerTileEntity(M_4ROT_TE.TickableTE.class, new ResourceLocation("fvtm:multiblock_tickable"));
		GameRegistry.registerTileEntity(RailEntity.class, new ResourceLocation("fvtm:rail"));
		CapabilityManager.INSTANCE.register(VehicleAndPartDataCache.class, new VAPDataCache.Storage(), new VAPDataCache.Callable());
		CapabilityManager.INSTANCE.register(ContainerHolder.class, new ContainerHolderUtil.Storage(), new ContainerHolderUtil.Callable());
		CapabilityManager.INSTANCE.register(RailSystem.class, new RailDataSerializer.Storage(), new RailDataSerializer.Callable());
		CapabilityManager.INSTANCE.register(RenderCache.class, new RenderCacheHandler.Storage(), new RenderCacheHandler.Callable());
		CapabilityManager.INSTANCE.register(RoadSystem.class, new RoadDataSerializer.Storage(), new RoadDataSerializer.Callable());
		CapabilityManager.INSTANCE.register(MultiBlockCache.class, new MultiBlockCacheSerializer.Storage(), new MultiBlockCacheSerializer.Callable());
		CapabilityManager.INSTANCE.register(PlayerData.class, new PlayerDataHandler.Storage(), new PlayerDataHandler.Callable());
		CapabilityManager.INSTANCE.register(Passenger.class, new PassengerCapHandler.Storage(), new PassengerCapHandler.Callable());
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:legacy_landvehicle"), LandVehicle.class, "fvtm.landvehicle", 9000, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:legacy_airvehicle"), AirVehicle.class, "fvtm.airvehicle", 8997, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:legacy_wheel"), WheelEntity.class, "fvtm.wheel", 8999, this, 256, 1, false);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:legacy_seat"), SeatEntity.class, "fvtm.seat", 8998, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:streetsign"), StreetSign.class, "fvtm.streetsign", 7000, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:roadsign"), RoadSignEntity.class, "fvtm.roadsign", 7001, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railvehicle"), RailVehicle.class, "fvtm.railvehicle", 9001, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:junctionswitch"), JunctionSwitchEntity.class, "fvtm.junctionswitch", 7002, this, 256, 600, false);
		if(event.getSide().isClient()){
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(LandVehicle.class, RenderLandVehicle::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(AirVehicle.class, RenderAirVehicle::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WheelEntity.class, RenderEmpty::new);
			//net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(SeatEntity.class, RenderEmpty::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(StreetSign.class, RenderStreetSign::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RoadSignEntity.class, RenderRoadSign::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RailVehicle.class, RenderRailVehicle::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(JunctionSwitchEntity.class, RenderJunctionSwitch::new);
			MinecraftForge.EVENT_BUS.register(new net.fexcraft.mod.fvtm.util.handler.KeyHandler());
		}
		if(Static.dev()){
			EntityRegistry.registerModEntity(new ResourceLocation("fvtm:test_rail_ent"), RailTestEntity.class, "fvtm.test_rail_ent", 6000, this, 256, 1, true);
			REGISTERER.addItem("railtestent", RailItemTest.INSTANCE, 0, null);
			if(event.getSide().isClient()){
				net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RailTestEntity.class, RenderRailTestEnt::new);
			}
		}
		//
		MinecraftForge.EVENT_BUS.register(RESOURCES = new Resources(event));
		if(event.getSide().isClient()){//moved from init into here cause of item models
			Resources.PARTS.getValuesCollection().forEach(part -> part.loadModel());
			Resources.VEHICLES.getValuesCollection().forEach(veh -> veh.loadModel());
			Resources.CONTAINERS.getValuesCollection().forEach(con -> con.loadModel());
			Resources.ROADSIGNS.getValuesCollection().forEach(sign -> sign.loadModel());
			Resources.BLOCKS.getValuesCollection().forEach(block -> block.loadModel());
			Resources.RAILGAUGES.getValuesCollection().forEach(gauge -> gauge.loadModel());
			net.fexcraft.lib.mc.render.FCLItemModelLoader.addItemModel(new ResourceLocation("fvtm:roadsign"), RoadSignModel.EMPTY);
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		if(event.getSide().isClient()){
			ConstructorBlock.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			ConstCenterBlock.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			DisplayBlock.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			FCLRegistry.getBlock("fvtm:streetpost").setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			FCLRegistry.getItem("fvtm:streetsign").setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			//RailItemTemp.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			Resources.BLOCKS.getValuesCollection().forEach(block -> block.linkItem());
			JunctionToolItem.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			SignalItem0.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			RoadToolItem.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			Asphalt.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			RoadSysItem.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			//
			if(net.fexcraft.mod.fvtm.model.DefaultPrograms.BLINKER_TIMER == null){
				net.fexcraft.mod.fvtm.model.DefaultPrograms.setupBlinkerTimer();
			}
		}
		Resources.MATERIALS.getValuesCollection().forEach(mat -> mat.linkContainerItem());
		Resources.MATERIALS.getValuesCollection().forEach(mat -> mat.registerIntoOreDictionary());
		Resources.CONSUMABLES.getValuesCollection().forEach(con -> con.linkContainerItem());
		Resources.CONSUMABLES.getValuesCollection().forEach(con -> con.registerIntoOreDictionary());
		Resources.BLOCKS.getValuesCollection().forEach(con -> con.registerIntoOreDictionary());
		Resources.loadPresets();
		//
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}

	@Mod.EventHandler
	public void initPost(FMLPostInitializationEvent event){
		Packets.init();
		Resources.loadRecipes();
		SimpleUpdateHandler.register(MODID, 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage(MODID, PREFIX + " &7New Version available! &0(&8" + SimpleUpdateHandler.getLatestVersionOf(MODID) + "&0)");
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new ServerReceiver());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new net.fexcraft.mod.fvtm.sys.rail.RecServer());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new net.fexcraft.mod.fvtm.sys.road.RecServer());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new ListenerServer());
		if(event.getSide().isClient()){
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new ClientReceiver());
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new net.fexcraft.mod.fvtm.sys.rail.RecClient());
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new net.fexcraft.mod.fvtm.sys.road.RecClient());
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new ListenerClient());
			MinecraftForge.EVENT_BUS.register(new RailRenderer());
			MinecraftForge.EVENT_BUS.register(new RoadRenderer());
			MinecraftForge.EVENT_BUS.register(new EffectRenderer());
		}
	}

	@Mod.EventHandler
	public void onStart(FMLServerAboutToStartEvent event){
		//
	}

	@Mod.EventHandler
	public void onStart(FMLServerStartingEvent event){
		LocalDateTime midnight = LocalDateTime.of(LocalDate.now(ZoneOffset.systemDefault()), LocalTime.MIDNIGHT);
		long mid = midnight.toInstant(ZoneOffset.UTC).toEpochMilli(); long date = Time.getDate();
		while((mid += Config.UNLOAD_INTERVAL) < date);
		if(RAILSYSTEM == null){
			(RAILSYSTEM = new Timer()).schedule(new RailSys.TimedTask(), new Date(mid), Config.UNLOAD_INTERVAL);
		}
		if(ROADSYSTEM == null){
			(ROADSYSTEM = new Timer()).schedule(new RoadSys.TimedTask(), new Date(mid), Config.UNLOAD_INTERVAL);
		}
	}

	@Mod.EventHandler
	public void onStop(FMLServerStoppingEvent event){
		if(RAILSYSTEM != null) RAILSYSTEM.cancel(); if(ROADSYSTEM != null) ROADSYSTEM.cancel();
		for(World world : Static.getServer().worlds){
			world.getCapability(Capabilities.RAILSYSTEM, null).unload();
			world.getCapability(Capabilities.ROADSYSTEM, null).unload();
		}
	}

	public static FVTM getInstance(){
		return INSTANCE;
	}

	public static AutoRegisterer getRegisterer(){
		return REGISTERER;
	}
	
	public static Resources getResources(){
		return RESOURCES;
	}

}
