package net.fexcraft.mod.fvtm;

import net.fexcraft.mod.fvtm.blocks.ConstructorCenter;
import net.fexcraft.mod.fvtm.blocks.ConstructorController;
import net.fexcraft.mod.fvtm.entities.*;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.impl.ContainerStatusListener;
import net.fexcraft.mod.fvtm.render.entity.*;
import net.fexcraft.mod.fvtm.util.*;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.packets.*;
import net.fexcraft.mod.lib.capabilities.sign.SignCapabilityUtil;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.registry.RegistryUtil;
import net.fexcraft.mod.lib.util.registry.RegistryUtil.AutoRegisterer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
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
@Mod(modid = FVTM.MODID, name = "Fex's Vehicle and Transportation Mod", version = FVTM.VERSION, acceptableRemoteVersions = "*", acceptedMinecraftVersions = "*", dependencies = "required-after:fcl",
        guiFactory = "net.fexcraft.mod.fvtm.util.config.GuiFactory")

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
        Config.initalize(event, event.getSuggestedConfigurationFile());
        //
        MinecraftForge.EVENT_BUS.register(RESOURCES = new Resources());
        REGISTERER = new AutoRegisterer(MODID);
        try{
            new ConstructorController();
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
        //EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railvehicle"), RailVehicleEntity.class, "fvtm:railvehicle", 1996, this, 256, 1, true);
        //EntityRegistry.registerModEntity(new ResourceLocation("fvtm:railwagon"), RailWagonEntity.class, "fvtm:railwagon", 1997, this, 256, 1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("fvtm:watervehicle"), WaterVehicleEntity.class, "fvtm:watervehicle", 1998, this, 256, 1, false);
        //EntityRegistry.registerModEntity(new ResourceLocation("fvtm:airvehicle"), AirVehicleEntity.class, "fvtm:airvehicle", 1999, this, 256, 1, false);
        EntityRegistry.registerModEntity(new ResourceLocation("fvtm:containerholder"), GenericContainerEntity.class, "fvtm:containerholder", 2000, this, 256, 1, false);
        if(event.getSide().isClient()){
            net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(UnboundVehicleEntity.class, RenderGenericVehicle::new);
            //net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(LandVehicleTrailer.class, RenderLandVehicleTrailer::new);
            net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WheelEntity.class, RenderEmpty::new);
            net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(SeatEntity.class, RenderEmpty::new);
            //net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(WaterVehicleEntity.class, RenderWaterVehicle::new);
            net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(GenericContainerEntity.class, RenderEmpty::new);
            net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(StreetSignEntity.class, RenderStreetSign::new);
            //
            MinecraftForge.EVENT_BUS.register(new net.fexcraft.mod.fvtm.util.KeyHandler());
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new GuiHandler.EventHandler());
        PacketHandler.registerListener(PacketHandlerType.NBT, Side.SERVER, new GuiHandler.SReceiver());
        PacketHandler.registerListener(PacketHandlerType.NBT, Side.CLIENT, new GuiHandler.CReceiver());
        //
        RecipeObject.registerRecipes();
        RecipeRegistry.addBluePrintRecipe("FVTM (B)", new ItemStack(RegistryUtil.getBlock("fvtm:constructor_controller"), 1, 0), new ItemStack(Blocks.IRON_BLOCK, 2), new ItemStack(Items.REDSTONE, 8), new ItemStack(Items.GOLD_INGOT, 3));
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
        SignCapabilityUtil.addListener(ContainerStatusListener.class);
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

}
