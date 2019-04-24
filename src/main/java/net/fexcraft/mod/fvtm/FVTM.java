package net.fexcraft.mod.fvtm;

import net.fexcraft.lib.mc.registry.FCLRegistry.AutoRegisterer;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.util.CrashCallable;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;

/**
 * Fex's Vehicle and Transportation Mod - A Modification adding a custom (json based) add-on system to create customizable vehicles and, by far, more.
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
		//Capabilities
		//
		MinecraftForge.EVENT_BUS.register(RESOURCES = new Resources(event));
		REGISTERER = new AutoRegisterer(MODID);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		//
	}

	@Mod.EventHandler
	public void initPost(FMLPostInitializationEvent event){
		//
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
