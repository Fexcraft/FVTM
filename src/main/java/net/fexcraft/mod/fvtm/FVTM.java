package net.fexcraft.mod.fvtm;

import net.fexcraft.lib.mc.FCL;
import net.fexcraft.lib.mc.gui.GuiHandler;
import net.fexcraft.lib.mc.network.SimpleUpdateHandler;
import net.fexcraft.lib.mc.registry.FCLRegistry.AutoRegisterer;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ConstructorCenterBlock;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.gui.ConstructorContainer;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorMain;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorPartCacheInfo;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorPartInstaller;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorPartManager;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorStatus;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorVP;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorVTM;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorVehicleInfo;
import net.fexcraft.mod.fvtm.render.RenderEmpty;
import net.fexcraft.mod.fvtm.render.RenderLandVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.sys.legacy.WheelEntity;
import net.fexcraft.mod.fvtm.util.CrashCallable;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.handler.LegacySpawnSystem;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

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
	acceptableRemoteVersions = "*", acceptedMinecraftVersions = "*", dependencies = "required-after:fcl"
	/*, guiFactory = "net.fexcraft.mod.fvtm.util.config.GuiFactory"*/)
public class FVTM {

	public static final String MODID = "fvtm";
	public static final String PREFIX = Formatter.format("&0[&9FVTM&0]&7 ");
	public static final String VERSION = "@VERSION@";

	@Mod.Instance(FVTM.MODID)
	private static FVTM INSTANCE;
	private static AutoRegisterer REGISTERER;
	private static Resources RESOURCES;

	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		REGISTERER = new AutoRegisterer(MODID);
		Config.initalize(event, event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().registerCrashCallable(new CrashCallable());
		//
		EntitySystem.REGISTRY.put("legacy", new LegacySpawnSystem());
		CapabilityManager.INSTANCE.register(VehicleAndPartDataCache.class, new VAPDataCache.Storage(), new VAPDataCache.Callable());
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:old_landvehicle"), LandVehicle.class, "fvtm.landvehicle", 9000, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:old_wheel"), WheelEntity.class, "fvtm.wheel", 8999, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:old_seat"), SeatEntity.class, "fvtm.seat", 8998, this, 256, 1, false);
		if(event.getSide().isClient()){
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(LandVehicle.class, RenderLandVehicle::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WheelEntity.class, RenderEmpty::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(SeatEntity.class, RenderEmpty::new);
			MinecraftForge.EVENT_BUS.register(new net.fexcraft.mod.fvtm.util.handler.KeyHandler());
		}
		//
		MinecraftForge.EVENT_BUS.register(RESOURCES = new Resources(event));
		if(event.getSide().isClient()){//moved from init into here cause of item models
			Resources.PARTS.getValuesCollection().forEach(part -> part.loadModel());
			Resources.VEHICLES.getValuesCollection().forEach(veh -> veh.loadModel());
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		if(event.getSide().isClient()){
			ConstructorBlock.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
			ConstructorCenterBlock.INSTANCE.setCreativeTab(InternalAddon.INSTANCE.getCreativeTab());
		}
		Resources.MATERIALS.getValuesCollection().forEach(mat -> mat.linkContainerItem());
		Resources.MATERIALS.getValuesCollection().forEach(mat -> mat.registerIntoOreDictionary());
		//
		GuiHandler.register(MODID, this);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, FCL.getGuiHandler());
		//900 - main
		//910 - part cache
		//920 - installed part
		//930 - vehicle
		if(event.getSide().isClient()){
			GuiHandler.insert(900, ConstructorMain.class, ConstructorContainer.class);
			GuiHandler.insert(901, ConstructorStatus.class, ConstructorContainer.class);
			GuiHandler.insert(902, ConstructorVehicleInfo.class, ConstructorContainer.class);
			GuiHandler.insert(904, ConstructorPartCacheInfo.class, ConstructorContainer.class);
			GuiHandler.insert(905, ConstructorPartManager.class, ConstructorContainer.class);
			GuiHandler.insert(906, ConstructorPartInstaller.class, ConstructorContainer.class);
			GuiHandler.insert(908, ConstructorVTM.class, ConstructorContainer.class);
			GuiHandler.insert(909, ConstructorVP.class, ConstructorContainer.class);
		}
		else{
			GuiHandler.insert(900, ConstructorContainer.class);
			GuiHandler.insert(901, ConstructorContainer.class);
			GuiHandler.insert(902, ConstructorContainer.class);
			GuiHandler.insert(904, ConstructorContainer.class);
			GuiHandler.insert(905, ConstructorContainer.class);
			GuiHandler.insert(906, ConstructorContainer.class);
			GuiHandler.insert(908, ConstructorContainer.class);
			GuiHandler.insert(909, ConstructorContainer.class);
		}
	}

	@Mod.EventHandler
	public void initPost(FMLPostInitializationEvent event){
		Packets.init(); SimpleUpdateHandler.register(MODID, 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage(MODID, PREFIX + " &7New Version available! &0(&8" + SimpleUpdateHandler.getLatestVersionOf(MODID) + "&0)");
	}

	@Mod.EventHandler
	public void onStart(FMLServerAboutToStartEvent event){
		//
	}

	@Mod.EventHandler
	public void onStart(FMLServerStartingEvent event){
		//
	}

	@Mod.EventHandler
	public void onStop(FMLServerStoppingEvent event){
		//
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
