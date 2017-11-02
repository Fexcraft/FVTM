package net.fexcraft.mod.fvtm;

import net.fexcraft.mod.fvtm.blocks.ConstructorCenter;
import net.fexcraft.mod.fvtm.blocks.ConstructorController;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.FvtmUpdateHandler;
import net.fexcraft.mod.fvtm.util.RecipeObject;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.SpawnCmd;
import net.fexcraft.mod.lib.crafting.RecipeRegistry;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.SimpleUpdateHandler;
import net.fexcraft.mod.lib.network.PacketHandler.PacketHandlerType;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.registry.RegistryUtil.AutoRegisterer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
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
	}
	
	@Mod.EventHandler
	public void initPost(FMLPostInitializationEvent event){
		SimpleUpdateHandler.register("fvtm", 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage("fvtm", PREFIX + "Update avaible! &3(" + SimpleUpdateHandler.getLatestVersionOf("fvtm") + ")&7");
		FvtmUpdateHandler.load();
		FvtmUpdateHandler.register();
		//check if addons have updates
		RESOURCES.checkForUpdates();
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