package net.fexcraft.mod.fvtm;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

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
import net.fexcraft.mod.fvtm.block.PipeBlock;
import net.fexcraft.mod.fvtm.block.RailEntity;
import net.fexcraft.mod.fvtm.block.VPInfo;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SignalTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SwitchTileEntity;
import net.fexcraft.mod.fvtm.data.Passenger;
import net.fexcraft.mod.fvtm.data.PlayerData;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.block.MultiBlockCache;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.entity.RenderViewEntity;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.entity.StreetSign;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.gui.ClientReceiver;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.gui.ServerReceiver;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.item.JunctionToolItem;
import net.fexcraft.mod.fvtm.item.PipeItem;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.SignalItem0;
import net.fexcraft.mod.fvtm.item.StreetSignItem;
import net.fexcraft.mod.fvtm.item.TrafficSignItem;
import net.fexcraft.mod.fvtm.item.TrainAdjuster;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.ConditionalPrograms;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TrafficSignPrograms;
import net.fexcraft.mod.fvtm.model.WirePrograms;
import net.fexcraft.mod.fvtm.model.loaders.ObjModelLoader;
import net.fexcraft.mod.fvtm.render.*;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignCapHandler;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.MultiBlockCacheSerializer;
import net.fexcraft.mod.fvtm.util.caps.PassengerCapHandler;
import net.fexcraft.mod.fvtm.util.caps.PlayerDataHandler;
import net.fexcraft.mod.fvtm.util.caps.RenderCacheHandler;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.handler.RVStore;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.minecraft.util.ResourceLocation;
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
	public static final String VERSION = "3.8.70";

	@Mod.Instance(FVTM.MODID)
	private static FVTM INSTANCE;
	private static AutoRegisterer REGISTERER;
	private static Resources RESOURCES;

	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		REGISTERER = new AutoRegisterer(MODID);
		Config.initalize(event, event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().registerCrashCallable(new CrashCallable());
		SimpleUpdateHandler.register(MODID, 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage(MODID, PREFIX + " &7New Version available! &0(&8" + SimpleUpdateHandler.getLatestVersionOf(MODID) + "&0)");
		//
		EntitySystem.add(new LegacySpawnSystem());
		EntitySystem.add(new RailSpawnSystem());
		EntitySystem.add(new BasicSpawnSystem());
		TrafficSignLibrary.initialize(event.getSide(), event.getSuggestedConfigurationFile().getParentFile());
		GameRegistry.registerTileEntity(BlockTileEntity.class, new ResourceLocation("fvtm:blockbase"));
		GameRegistry.registerTileEntity(SignalTileEntity.class, new ResourceLocation("fvtm:rail_signal"));
		GameRegistry.registerTileEntity(SwitchTileEntity.class, new ResourceLocation("fvtm:rail_switch"));
		GameRegistry.registerTileEntity(MultiblockTileEntity.class, new ResourceLocation("fvtm:multiblock"));
		GameRegistry.registerTileEntity(MultiblockTickableTE.class, new ResourceLocation("fvtm:multiblock_tickable"));
		GameRegistry.registerTileEntity(RailEntity.class, new ResourceLocation("fvtm:rail"));
		CapabilityManager.INSTANCE.register(VehicleAndPartDataCache.class, new VAPDataCache.Storage(), new VAPDataCache.Callable());
		CapabilityManager.INSTANCE.register(ContainerHolder.class, new ContainerHolderUtil.Storage(), new ContainerHolderUtil.Callable());
		CapabilityManager.INSTANCE.register(MultiBlockCache.class, new MultiBlockCacheSerializer.Storage(), new MultiBlockCacheSerializer.Callable());
		CapabilityManager.INSTANCE.register(PlayerData.class, new PlayerDataHandler.Storage(), new PlayerDataHandler.Callable());
		CapabilityManager.INSTANCE.register(Passenger.class, new PassengerCapHandler.Storage(), new PassengerCapHandler.Callable());
		CapabilityManager.INSTANCE.register(TrafficSigns.class, new TrafficSignCapHandler.Storage(), new TrafficSignCapHandler.Callable());
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:legacy_landvehicle"), LandVehicle.class, "fvtm.landvehicle", 9000, this, 256, 1, true);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:legacy_airvehicle"), AirVehicle.class, "fvtm.airvehicle", 8997, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:legacy_wheel"), WheelEntity.class, "fvtm.wheel", 8999, this, 256, 1, false);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:legacy_seat"), SeatEntity.class, "fvtm.seat", 8998, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:streetsign"), StreetSign.class, "fvtm.streetsign", 7000, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:trafficsign"), TrafficSignEntity.class, "fvtm.trafficsign", 7001, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:decoration"), Decoration.class, "fvtm.decoration", 7002, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railmarker"), RailMarker.class, "fvtm.railmarker", 7003, this, 256, 5, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:roadmarker"), RoadMarker.class, "fvtm.roadmarker", 7004, this, 256, 5, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railvehicle"), RailVehicle.class, "fvtm.railvehicle", 9001, this, 256, 1, true);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:junctionswitch"), JunctionSwitchEntity.class, "fvtm.junctionswitch", 7002, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:basic_landvehicle"), net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle.class, "fvtm.landvehicle", 9002, this, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:render_view"), RenderViewEntity.class, "fvtm.render_view", 6000, this, 256, 1, false);
		if(event.getSide().isClient()){
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(LandVehicle.class, RenderLandVehicle::new);
			//net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(AirVehicle.class, RenderAirVehicle::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WheelEntity.class, RenderWheel::new);
			//net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(SeatEntity.class, RenderEmpty::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(StreetSign.class, RenderStreetSign::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(TrafficSignEntity.class, RenderTrafficSign::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(Decoration.class, RenderDecoration::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RailMarker.class, RenderRailMarker::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RoadMarker.class, RenderRoadMarker::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RailVehicle.class, RenderRailVehicle::new);
			//net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(JunctionSwitchEntity.class, RenderJunctionSwitch::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(ULandVehicle.class, RenderULV::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RenderViewEntity.class, RenderView::new);
			CapabilityManager.INSTANCE.register(RenderCache.class, new RenderCacheHandler.Storage(), new RenderCacheHandler.Callable());
			MinecraftForge.EVENT_BUS.register(new net.fexcraft.mod.fvtm.util.handler.KeyHandler());
		}
		/*if(Static.dev()){
			EntityRegistry.registerModEntity(new ResourceLocation("fvtm:test_rail_ent"), RailTestEntity.class, "fvtm.test_rail_ent", 6000, this, 256, 1, true);
			REGISTERER.addItem("railtestent", RailItemTest.INSTANCE, 0, null);
			if(event.getSide().isClient()){
				net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RailTestEntity.class, RenderRailTestEnt::new);
			}
		}*/
		//
		MinecraftForge.EVENT_BUS.register(RESOURCES = new Resources(event));
		MinecraftForge.EVENT_BUS.register(new RVStore());
		if(event.getSide().isClient()){//moved from init into here cause of item models
			DefaultPrograms.init();
			ConditionalPrograms.init();
			WirePrograms.init();
			TrafficSignPrograms.init();
	        Resources.getModel("baked|fvtm:models/block/vpinfo.fmf", new ModelData(), BlockModel.class);
			Resources.PARTS.getValuesCollection().forEach(part -> part.loadModel());
			Resources.VEHICLES.getValuesCollection().forEach(veh -> veh.loadModel());
			Resources.CONTAINERS.getValuesCollection().forEach(con -> con.loadModel());
			Resources.BLOCKS.getValuesCollection().forEach(block -> block.loadModel());
			Resources.RAILGAUGES.getValuesCollection().forEach(gauge -> gauge.loadModel());
			Resources.CLOTHES.getValuesCollection().forEach(cloth -> cloth.loadModel());
			Resources.WIRES.getValuesCollection().forEach(cloth -> cloth.loadModel());
			TrafficSignLibrary.loadModels();
			Resources.loadDecoModels();
			ObjModelLoader.clearCache();
			Resources.OVERLAYS.put("default", net.fexcraft.mod.fvtm.gui.DefaultSteeringOverlay.class);
		}
		Resources.loadWireDecorations(event.getSide().isClient());
		MinecraftForge.EVENT_BUS.register(new ResizeUtil());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		Resources.linkTextureSuppliers();
		Perms.register();
		if(event.getSide().isClient()){
			net.minecraft.creativetab.CreativeTabs deftab = InternalAddon.INSTANCE.getDefaultCreativeTab();
			ConstructorBlock.INSTANCE.setCreativeTab(deftab);
			ConstCenterBlock.INSTANCE.setCreativeTab(deftab);
			DisplayBlock.INSTANCE.setCreativeTab(deftab);
			FCLRegistry.getBlock("fvtm:streetpost").setCreativeTab(deftab);
			StreetSignItem.INSTANCE.setCreativeTab(deftab);
			TrafficSignItem.INSTANCE.setCreativeTab(deftab);
			//RailItemTemp.INSTANCE.setCreativeTab(deftab);
			Resources.BLOCKS.getValuesCollection().forEach(block -> block.linkItem());
			JunctionToolItem.INSTANCE.setCreativeTab(deftab);
			SignalItem0.INSTANCE.setCreativeTab(deftab);
			TrainAdjuster.INSTANCE.setCreativeTab(deftab);
			RoadToolItem.INSTANCE.setCreativeTab(deftab);
			Asphalt.INSTANCE.setCreativeTab(deftab);
			DecorationItem.INSTANCE.setCreativeTab(deftab);
			VPInfo.INSTANCE.setCreativeTab(deftab);
			PipeBlock.INSTANCE.setCreativeTab(deftab);
			PipeItem.INSTANCE.setCreativeTab(deftab);
			//
			if(net.fexcraft.mod.fvtm.model.DefaultPrograms.BLINKER_TIMER == null){
				net.fexcraft.mod.fvtm.model.DefaultPrograms.setupBlinkerTimer();
			}
			try{
				Resources.loadLitePackLang();
			}
			catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | FileNotFoundException e){
				e.printStackTrace();
				Static.stop();
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
		Resources.registerDefaultRecipes();
		Resources.loadRecipes();
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new ServerReceiver());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new net.fexcraft.mod.fvtm.sys.rail.RecServer());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new net.fexcraft.mod.fvtm.sys.wire.RecServer());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new ListenerServer());
		if(event.getSide().isClient()){
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new ClientReceiver());
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new net.fexcraft.mod.fvtm.sys.rail.RecClient());
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new net.fexcraft.mod.fvtm.sys.wire.RecClient());
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new ListenerClient());
			MinecraftForge.EVENT_BUS.register(new RailRenderer());
			MinecraftForge.EVENT_BUS.register(new EffectRenderer());
		}
	}

	@Mod.EventHandler
	public void onStart(FMLServerAboutToStartEvent event){
		//
	}

	@Mod.EventHandler
	public void onStart(FMLServerStartingEvent event){
		SystemManager.onServerStarting(event);
	}

	@Mod.EventHandler
	public void onStop(FMLServerStoppingEvent event){
		SystemManager.onServerStopping(event);
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
