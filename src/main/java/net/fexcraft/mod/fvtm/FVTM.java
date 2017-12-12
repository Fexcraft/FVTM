package net.fexcraft.mod.fvtm;

import net.fexcraft.mod.fvtm.blocks.ConstructorCenter;
import net.fexcraft.mod.fvtm.blocks.ConstructorController;
import net.fexcraft.mod.fvtm.entities.LandVehicleEntity;
import net.fexcraft.mod.fvtm.entities.LandVehicleTrailer;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.entities.WaterVehicleEntity;
import net.fexcraft.mod.fvtm.entities.WheelEntity;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.render.entity.RenderEmpty;
import net.fexcraft.mod.fvtm.render.entity.RenderLandVehicle;
import net.fexcraft.mod.fvtm.render.entity.RenderLandVehicleTrailer;
import net.fexcraft.mod.fvtm.render.entity.RenderWaterVehicle;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.FvtmPermissions;
import net.fexcraft.mod.fvtm.util.FvtmUpdateHandler;
import net.fexcraft.mod.fvtm.util.RecipeObject;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.SpawnCmd;
import net.fexcraft.mod.fvtm.util.packets.PacketSeatDismount;
import net.fexcraft.mod.fvtm.util.packets.PacketSeatUpdate;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleControl;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleKeyPress;
import net.fexcraft.mod.fvtm.util.packets.SeatDismountPacketHandler;
import net.fexcraft.mod.fvtm.util.packets.SeatUpdatePacketHandler;
import net.fexcraft.mod.fvtm.util.packets.VehicleControlPacketHandler;
import net.fexcraft.mod.fvtm.util.packets.VehicleKeyPressPacketHandler;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.registry.RegistryUtil.AutoRegisterer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

/**
 * Fex's Vehicle and Transportation Mod
 * A Modification adding a custom add-on part system to create customizable vehicles
 * and, <i>more</i>.
 * <br>
 * License: <a href="http://fexcraft.net/license?id=mods">http://fexcraft.net/license?id=mods</a>
 * @author Ferdinand
 *
 */
@Mod(modid = FVTM.MODID, name = "Fex's Vehicle and Transportation Mod", version = FVTM.VERSION, acceptableRemoteVersions = "*", acceptedMinecraftVersions = "*", dependencies = "required-after:fcl")
public class FVTM {
	
	public static final String MODID = "fvtm";
	public static final String PREFIX = Formatter.format("&0[&9FVTM&0]&7 ");
	public static final String VERSION = "@VERSION@";
	
	@Mod.Instance(FVTM.MODID)
	private static FVTM INSTANCE;
	private static Resources RESOURCES;
	private static AutoRegisterer REGISTERER;
	
	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(RESOURCES = new Resources());
		REGISTERER = new AutoRegisterer(MODID);
		new ConstructorController();
		//
		PermManager.setEnabled(MODID);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:wheel"), WheelEntity.class, "fvtm:wheel", 1992, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:seat"), SeatEntity.class, "fvtm:seat", 1993, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:landvehicle"), LandVehicleEntity.class, "fvtm:landvehicle", 1994, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:landvehicletrailer"), LandVehicleTrailer.class, "fvtm:landvehicletrailer", 1995, this, 256, 1, false);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railvehicle"), RailVehicleEntity.class, "fvtm:railvehicle", 1996, this, 256, 1, true);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railwagon"), RailWagonEntity.class, "fvtm:railwagon", 1997, this, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:watervehicle"), WaterVehicleEntity.class, "fvtm:watervehicle", 1998, this, 256, 1, false);
		if(event.getSide().isClient()){
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(LandVehicleEntity.class, RenderLandVehicle::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(LandVehicleTrailer.class, RenderLandVehicleTrailer::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WheelEntity.class, RenderEmpty::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(SeatEntity.class, RenderEmpty::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WaterVehicleEntity.class, RenderWaterVehicle::new);
		}
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new GuiHandler.SReceiver());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new GuiHandler.CReceiver());
		//
		RecipeObject.registerRecipes();
		RecipeRegistry.addBluePrintRecipe("FVTM:Blocks", new ItemStack(ConstructorController.INSTANCE, 1, 0), new ItemStack(Blocks.IRON_BLOCK, 2), new ItemStack(Items.REDSTONE, 8), new ItemStack(Items.GOLD_INGOT, 3));
		RecipeRegistry.addBluePrintRecipe("FVTM:Blocks", new ItemStack(ConstructorCenter.INSTANCE, 1, 0), new ItemStack(Blocks.IRON_BLOCK, 1), new ItemStack(Items.REDSTONE, 4), new ItemStack(Items.GOLD_INGOT, 2), new ItemStack(Blocks.PLANKS, 4), new ItemStack(Items.STICK, 4), new ItemStack(Blocks.LOG, 2));
		//
		PacketHandler.getInstance().registerMessage(VehicleControlPacketHandler.Client.class, PacketVehicleControl.class, PacketHandler.nextpacketid++, Side.CLIENT);
		PacketHandler.getInstance().registerMessage(VehicleControlPacketHandler.Server.class, PacketVehicleControl.class, PacketHandler.nextpacketid++, Side.SERVER);
		PacketHandler.getInstance().registerMessage(VehicleKeyPressPacketHandler.class, PacketVehicleKeyPress.class, PacketHandler.nextpacketid++, Side.SERVER);
		PacketHandler.getInstance().registerMessage(SeatUpdatePacketHandler.Client.class, PacketSeatUpdate.class, PacketHandler.nextpacketid++, Side.CLIENT);
		PacketHandler.getInstance().registerMessage(SeatUpdatePacketHandler.Server.class, PacketSeatUpdate.class, PacketHandler.nextpacketid++, Side.SERVER);
		PacketHandler.getInstance().registerMessage(SeatDismountPacketHandler.Client.class, PacketSeatDismount.class, PacketHandler.nextpacketid++, Side.CLIENT);
	}
	
	@Mod.EventHandler
	public void initPost(FMLPostInitializationEvent event){
		SimpleUpdateHandler.register(MODID, 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage(MODID, PREFIX + "Update avaible! &3(" + SimpleUpdateHandler.getLatestVersionOf("fvtm") + ")&7");
		FvtmUpdateHandler.load();
		FvtmUpdateHandler.register();
		//check if addons have updates
		RESOURCES.checkForUpdates();
		FvtmPermissions.register();
		if(event.getSide().isClient()){
			MinecraftForge.EVENT_BUS.register(new net.fexcraft.mod.fvtm.util.KeyHandler());
		}
	}
	
	@Mod.EventHandler
	public void onStart(FMLServerAboutToStartEvent event){
		//THREADMANAGER.launch();
	}
	
	@Mod.EventHandler
	public void onStart(FMLServerStartingEvent event){
		event.registerServerCommand(new Command());
		event.registerServerCommand(new SpawnCmd());
	}
	
	@Mod.EventHandler
	public void onStop(FMLServerStoppingEvent event){
		//THREADMANAGER.clear();
	}
	
	public static final Resources getResources(){
		return RESOURCES;
	}
	
	public static final FVTM getInstance(){
		return INSTANCE;
	}
	
	public static final AutoRegisterer getRegisterer(){
		return REGISTERER;
	}
	
}