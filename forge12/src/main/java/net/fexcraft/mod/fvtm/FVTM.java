package net.fexcraft.mod.fvtm;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.frl.GLO;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.PacketHandler.PacketHandlerType;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.*;
import net.fexcraft.mod.fvtm.block.generated.*;
import net.fexcraft.mod.fvtm.data.AddonSteeringOverlay;
import net.fexcraft.mod.fvtm.data.PassCap;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.block.MultiBlockCache;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.impl.InvHandlerFluidImpl;
import net.fexcraft.mod.fvtm.data.impl.InvHandlerItemImpl;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerFluid;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerItem;
import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.entity.*;
import net.fexcraft.mod.fvtm.event.EventHandler;
import net.fexcraft.mod.fvtm.event.Registerer12;
import net.fexcraft.mod.fvtm.event.RenderViewHandler;
import net.fexcraft.mod.fvtm.event.ResizeHandler;
import net.fexcraft.mod.fvtm.gui.ClientReceiver;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.gui.ServerReceiver;
import net.fexcraft.mod.fvtm.item.JunctionToolItem;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.render.*;
import net.fexcraft.mod.fvtm.render.block.BakedModelLoader;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.impl.CondBuilder;
import net.fexcraft.mod.fvtm.sys.pro.NLandVehicle;
import net.fexcraft.mod.fvtm.sys.pro.NRailVehicle;
import net.fexcraft.mod.fvtm.sys.pro.NWheelEntity;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignCapHandler;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.pro.ULandVehicle;
import net.fexcraft.mod.fvtm.ui.*;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.fvtm.util.cap.pass.PassengerCallable;
import net.fexcraft.mod.fvtm.util.cap.pass.PassengerStorage;
import net.fexcraft.mod.fvtm.util.caps.*;
import net.fexcraft.mod.fvtm.util.ess.BasicSpawnSystem;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.UniReg;
import net.fexcraft.mod.uni.impl.*;
import net.fexcraft.mod.uni.item.ClothMaterial;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.ISound;
import net.minecraft.command.CommandBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import static net.fexcraft.mod.fvtm.FvtmRegistry.CONFIG;

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
	public static final String VERSION = "4.12.xx";

	@Mod.Instance(FVTM.MODID)
	private static FVTM INSTANCE;

	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		Logger logger = event.getModLog();
		FvtmLogger.LOGGER = new FvtmLogger(){
			@Override
			public void log0(Object obj){
				logger.info(obj);
			}
		};
		StackWrapper.SUPPLIER = obj -> {
			if(obj instanceof ItemWrapper) return new SWIE((ItemWrapper)obj);
			if(obj instanceof ItemStack) return new SWIE((ItemStack)obj);
			return null;
		};
		ItemWrapper.SUPPLIER = item -> new IWIE((Item)item);
		AABB.SUPPLIER = () -> new AABBI();
		InvHandlerItem.IMPL = InvHandlerItemImpl.class;
		InvHandlerFluid.IMPL = InvHandlerFluidImpl.class;
		BlockType.BLOCK_IMPL = BlockTypeImpl::get;
		StateWrapper.DEFAULT = new StateWrapperI(Blocks.AIR.getDefaultState());
		StateWrapper.STATE_WRAPPER = state -> new StateWrapperI((IBlockState)state);
		StateWrapper.COMMAND_WRAPPER = (block, arg) -> {
			try{
				if(block == null){
					String split[] = arg.split(" ");
					arg = split[1];
					block = Block.REGISTRY.getObject(new ResourceLocation(split[0]));
				}
				return new StateWrapperI(CommandBase.convertArgToBlockState((Block)block, arg));
			}
			catch(Exception e){
				e.printStackTrace();
				return StateWrapper.DEFAULT;
			}
		};
		StateWrapper.STACK_WRAPPER = (stack, ctx) ->{
			Item item = stack.getItem().local();
			if(item instanceof ItemBlock){
				net.minecraft.block.Block block = ((ItemBlock)item).getBlock();
				net.minecraft.util.math.BlockPos pos = new net.minecraft.util.math.BlockPos(ctx.pos.x, ctx.pos.y, ctx.pos.z);
				return StateWrapper.of(block.getStateForPlacement(ctx.world.local(), pos, ctx.side == null ? null : ctx.side.local(), (float)ctx.off.x, (float)ctx.off.y, (float)ctx.off.z, stack.damage(), ctx.placer.local()));
			}
			else return StateWrapper.DEFAULT;
		};
		LoopedSound.ACTIVATE = sound -> {
			sound.localsound = new LoopSound(SoundCategory.NEUTRAL, sound);
			net.minecraft.client.Minecraft.getMinecraft().getSoundHandler().playSound((ISound)sound.localsound);
		};
		if(EnvInfo.CLIENT){
			GLO.SUPPLIER = () -> new GLObject();
		}
		FvtmRegistry.init("1.12", event.getModConfigurationDirectory());
		FvtmResources.INSTANCE = new ResourcesImpl(event.getAsmData());
		MinecraftForge.EVENT_BUS.register(FvtmResources.INSTANCE);
		CONFIG.addListener(() -> {
			TrafficSignLibrary.load(true);
			ContainerBlock.INSTANCE.setHardness(net.fexcraft.mod.fvtm.Config.UNBREAKABLE_CONTAINERS ? -1f : 8f);
		});
		ClothMaterial.MANAGER[0] = new ClothMaterialManager();
		FvtmRegistry.NONE_CLOTH_MAT = IDLManager.getIDLCached("fvtm:none");
		ArmorMaterial NONE_MAT = EnumHelper.addArmorMaterial("fvtm:none", FvtmRegistry.NULL_TEXTURE.toString(), 1024, new int[]{ 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
		ClothMaterial.MATERIALS.put(FvtmRegistry.NONE_CLOTH_MAT, new ClothMaterialWrapper(FvtmRegistry.NONE_CLOTH_MAT, NONE_MAT));
		if(EnvInfo.CLIENT){
			CONFIG.addListener(DefaultPrograms::setupBlinkerTimer);
			CTab.IMPL[0] = net.fexcraft.mod.fvtm.data.impl.AddonTab.class;
			ConditionRegistry.BUILDER = CondBuilder.run();
		}
		//
		FMLCommonHandler.instance().registerCrashCallable(new CrashCallablePacks());
		FMLCommonHandler.instance().registerCrashCallable(new CrashCallableModels());
		//
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
		CapabilityManager.INSTANCE.register(PassCap.class, new PassengerStorage(), new PassengerCallable());
		CapabilityManager.INSTANCE.register(TrafficSigns.class, new TrafficSignCapHandler.Storage(), new TrafficSignCapHandler.Callable());
		//
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:simple_vehicle"), NLandVehicle.class, "fvtm.simple_vehicle", 0, this, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:wheel"), NWheelEntity.class, "fvtm.wheel", 100, this, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:rail_vehicle"), NRailVehicle.class, "fvtm.rail_vehicle", 1, this, 256, 1, true);
		//
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:streetsign"), StreetSign.class, "fvtm.streetsign", 7000, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:trafficsign"), TrafficSignEntity.class, "fvtm.trafficsign", 7001, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:decoration"), DecorationEntity.class, "fvtm.decoration", 7002, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railmarker"), RailMarker.class, "fvtm.railmarker", 7003, this, 256, 5, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:roadmarker"), RoadMarker.class, "fvtm.roadmarker", 7004, this, 256, 5, false);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:junctionswitch"), JunctionSwitchEntity.class, "fvtm.junctionswitch", 7002, this, 256, 600, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:basic_landvehicle"), ULandVehicle.class, "fvtm.landvehicle", 9002, this, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:render_view"), RenderViewEntity.class, "fvtm.render_view", 6000, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:block_seat"), BlockSeat.class, "fvtm.block_seat", 6001, this, 256, 60, false);
		if(event.getSide().isClient()){
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(NLandVehicle.class, RenderRV::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(NWheelEntity.class, RenderWheel::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(NRailVehicle.class, RenderRV::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(ULandVehicle.class, RenderRV::new);
			//
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(StreetSign.class, RenderStreetSign::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(TrafficSignEntity.class, RenderTrafficSign::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(DecorationEntity.class, RenderDecoration::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RailMarker.class, RenderRailMarker::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RoadMarker.class, RenderRoadMarker::new);
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
		if(event.getSide().isClient()) Registerer12.regPacks();
		FvtmResources.INSTANCE.registerFvtmBlocks();
		FvtmResources.INSTANCE.registerFvtmItems();
		FvtmResources.INSTANCE.registerAttributes();
		FvtmResources.INSTANCE.registerFunctions();
		FvtmResources.INSTANCE.registerHandlers();
		FvtmResources.INSTANCE.searchContent();
		FvtmResources.INSTANCE.createContentBlocks();
		FvtmResources.INSTANCE.createContentItems();
		MinecraftForge.EVENT_BUS.register(new Registerer12());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		MinecraftForge.EVENT_BUS.register(new RenderViewHandler());
		MinecraftForge.EVENT_BUS.register(new ResizeHandler());
		if(event.getSide().isClient()){//moved from init into here cause of item models
			FvtmResources.initModelSystem();
			AddonSteeringOverlay.OVERLAYS.put("default", net.fexcraft.mod.fvtm.gui.DefaultSteeringOverlay.class);
		}
		//
		UniReg.registerMod(MODID, INSTANCE);
		UniReg.registerUI(UIKeys.TOOLBOX_COLORS, ToolboxPainter.class);
		UniReg.registerMenu(UIKeys.TOOLBOX_COLORS, "fvtm:uis/toolbox_colors", ToolboxPaintContainer.class);
		UniReg.registerUI(UIKeys.TOOLBOX_TEXTURE, ToolboxTexture.class);
		UniReg.registerMenu(UIKeys.TOOLBOX_TEXTURE, "fvtm:uis/toolbox_texture", ToolboxTextureContainer.class);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		UniEntity.ENTITY_GETTER = ent -> new EntityWIE((Entity)ent);
		WrapperHolder.LEVEL_PROVIDER = lvl -> new WorldWIE((World)lvl);
		EventHandler.linkTextureSuppliers();
		Perms.register();
		if(event.getSide().isClient()){
			net.minecraft.creativetab.CreativeTabs tab = (CreativeTabs)FvtmResources.INSTANCE.getCreativeTab("fvtm:default");
			ConstructorBlock.INSTANCE.setCreativeTab(tab);
			VehicleLiftBlock.INSTANCE.setCreativeTab(tab);
			/*DisplayBlock.INSTANCE.setCreativeTab(tab);
			FCLRegistry.getBlock("fvtm:streetpost").setCreativeTab(tab);
			StreetSignItem.INSTANCE.setCreativeTab(tab);
			TrafficSignItem.INSTANCE.setCreativeTab(tab);
			SignalItem0.INSTANCE.setCreativeTab(tab);
			TrainAdjuster.INSTANCE.setCreativeTab(tab);*/
			JunctionToolItem.INSTANCE.setCreativeTab(tab);
			RoadToolItem.INSTANCE.setCreativeTab(tab);
			ToolboxItem.INSTANCE.setCreativeTab(tab);
			Asphalt.INSTANCE.setCreativeTab(tab);
			//VPInfo.INSTANCE.setCreativeTab(tab);
			//
			if(DefaultPrograms.BLINKER_TIMER == null){
				DefaultPrograms.setupBlinkerTimer();
			}
			try{
				EventHandler.loadLitePackLang();
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
		FvtmResources.INSTANCE.registerRecipes();
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new ServerReceiver());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new ListenerServer());
		if(event.getSide().isClient()){
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new ClientReceiver());
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
		SystemManager.onServerStarting();
	}

	@Mod.EventHandler
	public void onStop(FMLServerStoppingEvent event){
		SystemManager.onServerStopping();
	}

	public static FVTM getInstance(){
		return INSTANCE;
	}

}
