package net.fexcraft.mod.fvtm;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.PacketHandler.PacketHandlerType;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ContainerBlock;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SignalTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SwitchTileEntity;
import net.fexcraft.mod.fvtm.data.PassCap;
import net.fexcraft.mod.fvtm.data.PlayerData;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.block.MultiBlockCache;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.entity.BlockSeat;
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
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.util.PacketsImpl;
import net.fexcraft.mod.fvtm.render.*;
import net.fexcraft.mod.fvtm.render.block.BakedModelLoader;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.impl.CondBuilder;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.sys.pro.NLandVehicle;
import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignCapHandler;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.fvtm.util.cap.pass.PassengerCallable;
import net.fexcraft.mod.fvtm.util.cap.pass.PassengerStorage;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.MultiBlockCacheSerializer;
import net.fexcraft.mod.fvtm.util.caps.PlayerDataHandler;
import net.fexcraft.mod.fvtm.util.caps.RenderCacheHandler;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.handler.RVStore;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.fvtm.util.CTab;
import net.fexcraft.mod.uni.impl.*;
import net.fexcraft.mod.uni.item.ClothMaterial;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UIField;
import net.fexcraft.mod.uni.ui.UITab;
import net.fexcraft.mod.uni.ui.UIText;
import net.fexcraft.mod.uni.ui.UUIButton;
import net.fexcraft.mod.uni.ui.UUIField;
import net.fexcraft.mod.uni.ui.UUITab;
import net.fexcraft.mod.uni.ui.UUIText;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.fexcraft.mod.uni.world.WrapperHolderImpl;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

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
	acceptableRemoteVersions = "*", acceptedMinecraftVersions = "*", dependencies = "required-after:fcl")
public class FVTM {

	public static final String MODID = "fvtm";
	public static final String PREFIX = Formatter.format("&0[&9FVTM&0]&7 ");
	public static final String VERSION = "4.12.75";

	@Mod.Instance(FVTM.MODID)
	private static FVTM INSTANCE;
	private static Resources RESOURCES;

	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		EnvInfo.CLIENT = event.getSide().isClient();
		EnvInfo.DEV = (Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment");
		Logger logger = event.getModLog();
		FvtmLogger.LOGGER = new FvtmLogger(){
			@Override
			public void log0(Object obj){
				logger.info(obj);
			}
		};
		IDLManager.INSTANCE[0] = new IDLM();
		TagCW.SUPPLIER[0] = () -> new TagCWI();
		TagCW.WRAPPER[0] = obj -> new TagCWI(obj);
		TagLW.SUPPLIER[0] = () -> new TagLWI();
		AABB.SUPPLIER = () -> new AABBI();
		WrapperHolder.INSTANCE = new WrapperHolderImpl();
		BlockType.BLOCK_IMPL = BlockTypeImpl::get;
		StateWrapper.GETTER = state -> new StateWrapperI((IBlockState)state);
		if(EnvInfo.CLIENT){
			UITab.IMPLEMENTATION = UUITab.class;
			UIButton.IMPLEMENTATION = UUIButton.class;
			UIText.IMPLEMENTATION = UUIText.class;
			UIField.IMPLEMENTATION = UUIField.class;
			GLO.SUPPLIER = () -> new GLObject();
		}
		FvtmRegistry.init("1.12", event.getModConfigurationDirectory());
		FvtmResources.INSTANCE = new ResourcesImpl(event.getAsmData());
		MinecraftForge.EVENT_BUS.register(FvtmResources.INSTANCE);
		Config.addListener(() -> {
			TrafficSignLibrary.load(true);
			ContainerBlock.INSTANCE.setHardness(net.fexcraft.mod.fvtm.Config.UNBREAKABLE_CONTAINERS ? -1f : 8f);
		});
		ClothMaterial.MANAGER[0] = new ClothMaterialManager();
		FvtmRegistry.NONE_CLOTH_MAT = IDLManager.getIDLCached("fvtm:none");
		ArmorMaterial NONE_MAT = EnumHelper.addArmorMaterial("fvtm:none", Resources.NULL_TEXTURE.toString(), 1024, new int[]{ 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
		ClothMaterial.MATERIALS.put(FvtmRegistry.NONE_CLOTH_MAT, new ClothMaterialWrapper(FvtmRegistry.NONE_CLOTH_MAT, NONE_MAT));
		if(EnvInfo.CLIENT){
			Config.addListener(DefaultPrograms::setupBlinkerTimer);
			CTab.IMPL[0] = net.fexcraft.mod.fvtm.data.impl.AddonTab.class;
			ConditionRegistry.BUILDER = CondBuilder.run();
		}
		//
		FMLCommonHandler.instance().registerCrashCallable(new CrashCallable());
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
		//GameRegistry.registerTileEntity(RailEntity.class, new ResourceLocation("fvtm:rail"));
		CapabilityManager.INSTANCE.register(VehicleAndPartDataCache.class, new VAPDataCache.Storage(), new VAPDataCache.Callable());
		CapabilityManager.INSTANCE.register(ContainerHolder.class, new ContainerHolderUtil.Storage(), new ContainerHolderUtil.Callable());
		CapabilityManager.INSTANCE.register(MultiBlockCache.class, new MultiBlockCacheSerializer.Storage(), new MultiBlockCacheSerializer.Callable());
		CapabilityManager.INSTANCE.register(PlayerData.class, new PlayerDataHandler.Storage(), new PlayerDataHandler.Callable());
		CapabilityManager.INSTANCE.register(PassCap.class, new PassengerStorage(), new PassengerCallable());
		CapabilityManager.INSTANCE.register(TrafficSigns.class, new TrafficSignCapHandler.Storage(), new TrafficSignCapHandler.Callable());
		//
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:vehicle"), NLandVehicle.class, "fvtm.vehicle", 0, this, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:wheel"), NWheelEntity.class, "fvtm.wheel", 100, this, 256, 1, true);
		//
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
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:block_seat"), BlockSeat.class, "fvtm.block_seat", 6001, this, 256, 60, false);
		if(event.getSide().isClient()){
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(NLandVehicle.class, RenderRV::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(NWheelEntity.class, RenderWheel::new);
			//
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
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(BlockSeat.class, RenderEmpty::new);
			//
			CapabilityManager.INSTANCE.register(RenderCache.class, new RenderCacheHandler.Storage(), new RenderCacheHandler.Callable());
			MinecraftForge.EVENT_BUS.register(new net.fexcraft.mod.fvtm.util.handler.KeyHandler());
			BakedModelLoader.register();
		}
		/*if(Static.dev()){
			EntityRegistry.registerModEntity(new ResourceLocation("fvtm:test_rail_ent"), RailTestEntity.class, "fvtm.test_rail_ent", 6000, this, 256, 1, true);
			REGISTERER.addItem("railtestent", RailItemTest.INSTANCE, 0, null);
			if(event.getSide().isClient()){
				net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RailTestEntity.class, RenderRailTestEnt::new);
			}
		}*/
		//
		FvtmResources.INSTANCE.init();
		FvtmResources.INSTANCE.registerFvtmBlocks();
		FvtmResources.INSTANCE.registerFvtmItems();
		FvtmResources.INSTANCE.registerAttributes();
		FvtmResources.INSTANCE.registerFunctions();
		FvtmResources.INSTANCE.registerHandlers();
		FvtmResources.INSTANCE.searchContent();
		FvtmResources.INSTANCE.createContentBlocks();
		FvtmResources.INSTANCE.createContentItems();
		MinecraftForge.EVENT_BUS.register(new Registerer());
		MinecraftForge.EVENT_BUS.register(RESOURCES = new Resources(event));
		MinecraftForge.EVENT_BUS.register(new RVStore());
		if(event.getSide().isClient()){//moved from init into here cause of item models
			FvtmResources.initModelSystem();
			Resources.OVERLAYS.put("default", net.fexcraft.mod.fvtm.gui.DefaultSteeringOverlay.class);
		}
		MinecraftForge.EVENT_BUS.register(new ResizeUtil());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		Resources.linkTextureSuppliers();
		Perms.register();
		if(event.getSide().isClient()){
			net.minecraft.creativetab.CreativeTabs tab = (CreativeTabs)FvtmResources.INSTANCE.getCreativeTab("fvtm:default");
			ConstructorBlock.INSTANCE.setCreativeTab(tab);
			ConstCenterBlock.INSTANCE.setCreativeTab(tab);
			/*DisplayBlock.INSTANCE.setCreativeTab(tab);
			FCLRegistry.getBlock("fvtm:streetpost").setCreativeTab(tab);
			StreetSignItem.INSTANCE.setCreativeTab(tab);
			TrafficSignItem.INSTANCE.setCreativeTab(tab);
			JunctionToolItem.INSTANCE.setCreativeTab(tab);
			SignalItem0.INSTANCE.setCreativeTab(tab);
			TrainAdjuster.INSTANCE.setCreativeTab(tab);*/
			RoadToolItem.INSTANCE.setCreativeTab(tab);
			ToolboxItem.INSTANCE.setCreativeTab(tab);
			Asphalt.INSTANCE.setCreativeTab(tab);
			DecorationItem.INSTANCE.setCreativeTab(tab);
			//VPInfo.INSTANCE.setCreativeTab(tab);
			//
			if(DefaultPrograms.BLINKER_TIMER == null){
				DefaultPrograms.setupBlinkerTimer();
			}
			try{
				Resources.loadLitePackLang();
			}
			catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | FileNotFoundException e){
				e.printStackTrace();
				Static.stop();
			}
		}
		FvtmRegistry.MATERIALS.forEach(mat -> {
			mat.getItemWrapper().linkContainer();
			mat.getItemWrapper().regToDict();
		});
		FvtmRegistry.CONSUMABLES.forEach(con -> {
			con.getItemWrapper().linkContainer();
			con.getItemWrapper().regToDict();
		});
		FvtmRegistry.BLOCKS.forEach(blk -> {
			blk.getItemWrapper().linkContainer();
			blk.getItemWrapper().regToDict();
		});
		//
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}

	@Mod.EventHandler
	public void initPost(FMLPostInitializationEvent event){
		(Packets.INSTANCE = new PacketsImpl()).init();
		Resources.registerDefaultRecipes();
		FvtmResources.loadRecipes();
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
	
	public static Resources getResources(){
		return RESOURCES;
	}

	public static class Registerer {

		@SubscribeEvent
		public void registerBlocks(RegistryEvent.Register<net.minecraft.block.Block> event){
			event.getRegistry().register(ConstructorBlock.INSTANCE);
			event.getRegistry().register(ConstCenterBlock.INSTANCE);
			event.getRegistry().register(Asphalt.INSTANCE);
			event.getRegistry().register(ContainerBlock.INSTANCE);
		}

		@SubscribeEvent
		public void registerItems(RegistryEvent.Register<net.minecraft.item.Item> event){
			event.getRegistry().register(ConstructorBlock.ITEM);
			event.getRegistry().register(ConstCenterBlock.ITEM);
			event.getRegistry().register(Asphalt.ITEM);
			//
			event.getRegistry().register(RoadToolItem.INSTANCE = new RoadToolItem());
			event.getRegistry().register(ToolboxItem.INSTANCE = new ToolboxItem());
			event.getRegistry().register(DecorationItem.INSTANCE);
			if(EnvInfo.CLIENT){
				regModel(ConstructorBlock.ITEM);
				regModel(ConstCenterBlock.ITEM);
				regModel(Asphalt.ITEM, 16);
				//
				regModel(DecorationItem.INSTANCE);
				regModel(RoadToolItem.INSTANCE);
				regModel(ToolboxItem.INSTANCE, 3);
			}
		}

		private void regModel(Item item){
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

		private void regModel(Item item, int vars){
			for(int v = 0; v < vars; v++){
				net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, v, new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(item.getRegistryName().toString() + "_" + v), "inventory"));
			}
		}

	}

}
