package net.fexcraft.mod.fvtm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.fexcraft.lib.mc.capabilities.sign.SignCapabilitySerializer;
import net.fexcraft.lib.mc.crafting.RecipeRegistry;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.PacketHandler.PacketHandlerType;
import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.lib.mc.registry.FCLRegistry.AutoRegisterer;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.EntityType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.blocks.ConstructorCenter;
import net.fexcraft.mod.fvtm.blocks.ConstructorController;
import net.fexcraft.mod.fvtm.blocks.Pallet;
import net.fexcraft.mod.fvtm.entities.*;
import net.fexcraft.mod.fvtm.entities.railold.GenericLocomotiveEntity;
import net.fexcraft.mod.fvtm.entities.railold.GenericWagonEntity;
import net.fexcraft.mod.fvtm.entities.railold.RailboundVehicleEntity;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.impl.GenericEntityType;
import net.fexcraft.mod.fvtm.impl.PrototypeEntityType;
import net.fexcraft.mod.fvtm.impl.caps.ChunkRailDataUtil;
import net.fexcraft.mod.fvtm.impl.caps.VAPDataCache;
import net.fexcraft.mod.fvtm.impl.caps.WorldResourcesUtil;
import net.fexcraft.mod.fvtm.impl.container.ContainerStatusListener;
import net.fexcraft.mod.fvtm.render.entity.*;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.packets.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Fex's Vehicle and Transportation Mod - A Modification adding a custom add-on
 * part system to create customizable vehicles and, <i>more</i>.
 * <br>
 * License:
 * <a href="http://fexcraft.net/license?id=mods">http://fexcraft.net/license?id=mods</a>
 *
 * @author Ferdinand Calo'
 *
 */
@Mod(modid = FVTM.MODID, name = "Fex's Vehicle and Transportation Mod", version = FVTM.VERSION, acceptableRemoteVersions = "*", acceptedMinecraftVersions = "*",
		dependencies = "required-after:fcl;after:trackapi", guiFactory = "net.fexcraft.mod.fvtm.util.config.GuiFactory")
public class FVTM {

	public static final String MODID = "fvtm";
	public static final String PREFIX = Formatter.format("&0[&9FVTM&0]&7 ");
	public static final String VERSION = "@VERSION@";
	public static final Addon INTERNAL_ADDON = new InternalAddon();

	@Mod.Instance(FVTM.MODID)
	private static FVTM INSTANCE;
	private static Resources RESOURCES;
	private static AutoRegisterer REGISTERER;

	@Mod.EventHandler
	public void initPre(FMLPreInitializationEvent event){
		Config.initalize(event, event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().registerCrashCallable(new CrashCallable());
		CapabilityManager.INSTANCE.register(VAPDataCache.VehicleAndPartDataCache.class, new VAPDataCache.Storage(), new VAPDataCache.Callable());
		CapabilityManager.INSTANCE.register(net.fexcraft.mod.fvtm.api.Resources.class, new WorldResourcesUtil.Storage(), new WorldResourcesUtil.Callable());
		CapabilityManager.INSTANCE.register(ChunkRailDataUtil.ChunkRailData.class, new ChunkRailDataUtil.Storage(), new ChunkRailDataUtil.Callable());
		//
		MinecraftForge.EVENT_BUS.register(RESOURCES = new Resources(event));
		REGISTERER = new AutoRegisterer(MODID);
		String[] wood_types = new String[]{ "oak", "spruce", "birch", "jungle", "dark_oak", "acacia"};
		try{
			new ConstructorController();
			for(String string : wood_types) new Pallet(string);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:streetsign"), StreetSignEntity.class, "fvtm:streetsign", 1991, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:wheel"), WheelEntity.class, "fvtm:wheel", 1992, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:seat"), SeatEntity.class, "fvtm:seat", 1993, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:landvehicle"), GenericVehicleEntity.class, "fvtm:landvehicle", 1994, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:landvehicletrailer"), GenericTrailerEntity.class, "fvtm:landvehicletrailer", 1995, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railvehicle"), GenericLocomotiveEntity.class, "fvtm:railvehicle", 1996, this, 256, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railwagon"), GenericWagonEntity.class, "fvtm:railwagon", 1997, this, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fvtm:watervehicle"), WaterVehicleEntity.class, "fvtm:watervehicle", 1998, this, 256, 1, false);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:airvehicle"), AirVehicleEntity.class, "fvtm:airvehicle", 1999, this, 256, 1, false);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:containerholder"), GenericContainerEntity.class, "fvtm:containerholder", 2000, this, 256, 1, false);
		//EntityRegistry.registerModEntity(new ResourceLocation("fvtm:bogie"), BogieEntity.class, "fvtm:bogie", 2001, this, 256, 1, false);
		if(event.getSide().isClient()){
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(UnboundVehicleEntity.class, RenderGenericVehicle::new);
			//net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(LandVehicleTrailer.class, RenderLandVehicleTrailer::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WheelEntity.class, RenderEmpty::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(SeatEntity.class, RenderEmpty::new);
			//net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WaterVehicleEntity.class, RenderWaterVehicle::new);
			//net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(GenericContainerEntity.class, RenderEmpty::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(StreetSignEntity.class, RenderStreetSign::new);
			net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(RailboundVehicleEntity.class, RenderGenericRailed::new);
			//
			MinecraftForge.EVENT_BUS.register(new net.fexcraft.mod.fvtm.util.KeyHandler());
			MinecraftForge.EVENT_BUS.register(new net.fexcraft.mod.fvtm.render.Renderer());
		}
		//
		EntityType.NONE = new EntityType(new ResourceLocation("minecraft:none"), "NONE", VehicleType.NULL){
			@Override
			public boolean spawnEntity(World world, EntityPlayer player, ItemStack stack, VehicleData data, VehicleType type){
				Print.console("It was tried to spawn an entity with the ENTITYTYPE.NONE, here more data: ");
				Print.console(world, player, stack, data, type); return false;
			}
		};
		EntityType.INTERNAL = new GenericEntityType(); EntityType.PROTOTYPE = new PrototypeEntityType();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new GuiHandler.EventHandler());
		PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new GuiHandler.SReceiver());
		if(event.getSide().isClient()){
			PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new net.fexcraft.mod.fvtm.gui.GuiHandler.CReceiver());
		}
		//
		RecipeObject.registerRecipes();
		RecipeRegistry.addBluePrintRecipe("FVTM (B)", new ItemStack(FCLRegistry.getBlock("fvtm:constructor_controller"), 1, 0), new ItemStack(Blocks.IRON_BLOCK, 2), new ItemStack(Items.REDSTONE, 8), new ItemStack(Items.GOLD_INGOT, 3));
		RecipeRegistry.addBluePrintRecipe("FVTM (B)", new ItemStack(ConstructorCenter.INSTANCE, 1, 0), new ItemStack(Blocks.IRON_BLOCK, 1), new ItemStack(Items.REDSTONE, 4), new ItemStack(Items.GOLD_INGOT, 2), new ItemStack(Blocks.PLANKS, 4), new ItemStack(Items.STICK, 4), new ItemStack(Blocks.LOG, 2));
		//
		PacketHandler.getInstance().registerMessage(VehicleControlPacketHandler.Client.class, PacketVehicleControl.class, 9910, Side.CLIENT);
		PacketHandler.getInstance().registerMessage(VehicleControlPacketHandler.Server.class, PacketVehicleControl.class, 9911, Side.SERVER);
		PacketHandler.getInstance().registerMessage(VehicleKeyPressPacketHandler.class, PacketVehicleKeyPress.class, 9912, Side.SERVER);
		PacketHandler.getInstance().registerMessage(SeatUpdatePacketHandler.Client.class, PacketSeatUpdate.class, 9913, Side.CLIENT);
		PacketHandler.getInstance().registerMessage(SeatUpdatePacketHandler.Server.class, PacketSeatUpdate.class, 9914, Side.SERVER);
		PacketHandler.getInstance().registerMessage(SeatDismountPacketHandler.Client.class, PacketSeatDismount.class, 9915, Side.CLIENT);
		if(event.getSide().isClient()){
			net.fexcraft.mod.fvtm.render.Renderer.initFontRenderer();
		}
	}

	@Mod.EventHandler
	public void initPost(FMLPostInitializationEvent event){
		FvtmUpdateHandler.load();
		FvtmUpdateHandler.register();
		//check if addons have updates
		RESOURCES.checkForUpdates();
		FvtmPermissions.register();
		//
		SignCapabilitySerializer.addListener(ContainerStatusListener.class);
		//CapabilityManager.INSTANCE.register(BlockChunk.class, new BlockChunkUtil.Storage(), new BlockChunkUtil.Callable());
		//
		APIs.load();
	}

	@Mod.EventHandler
	public void onStart(FMLServerAboutToStartEvent event){
		//
	}

	@Mod.EventHandler
	public void onStart(FMLServerStartingEvent event){
		event.registerServerCommand(new Command());
		event.registerServerCommand(new SpawnCmd());
	}

	@Mod.EventHandler
	public void onStop(FMLServerStoppingEvent event){
		//Print.debug("Clearing BLOCKDATA Cache.");
		//BlockChunkImplementation.ALLBLOCKS.clear();
	}

	public static Resources getResources(){
		return RESOURCES;
	}

	public static FVTM getInstance(){
		return INSTANCE;
	}

	public static AutoRegisterer getRegisterer(){
		return REGISTERER;
	}
	
	public static class InternalAddon implements Addon {
		
		private static final ResourceLocation regname = new ResourceLocation(MODID, "fvtm");
		private static final List<ResourceLocation> empty = new ArrayList<ResourceLocation>();
		private static final List<UUID> authors = new ArrayList<>();
		static { authors.add(UUID.fromString("01e4af9b-2a30-471e-addf-f6338ffce04b")); }

		@Override
		public Addon setRegistryName(ResourceLocation name){
			/*regname = name;*/ return this;
		}

		@Override
		public ResourceLocation getRegistryName(){
			return regname;
		}

		@Override
		public String getName(){
			return "Internal Addon";
		}

		@Override
		public String getVersion(){
			return "1.0-Universal";
		}

		@Override
		public String getURL(){
			return "http://fexcraft.net/downloads?modid=fvtm";
		}

		@Override
		public String getLicense(){
			return "http://fexcraft.net/license?id=mods";
		}

		@Override
		public String getUpdateId(){
			return "fvtm";
		}

		@Override
		public List<ResourceLocation> getDependencies(){
			return (List<ResourceLocation>)empty;
		}

		@Override
		public List<UUID> getAuthors(){
			return authors;
		}

		@Override
		public boolean isEnabled(){
			return true;
		}

		@Override
		public void setEnabled(boolean bool){
			//
		}

		@Override
		public List<ResourceLocation> getMissingDependencies(){
			return empty;
		}

		@Override
		public NBTTagCompound toNBT(){
			return new NBTTagCompound();
		}

		@Override
		public Addon fromNBT(NBTTagCompound nbt){
			return this;
		}
		
	}

}
