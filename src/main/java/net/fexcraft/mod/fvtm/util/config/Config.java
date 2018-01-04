package net.fexcraft.mod.fvtm.util.config;

import net.fexcraft.mod.fvtm.FVTM;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.List;

public class Config {

	public static boolean TEST, DROP_ITEMS_ON_BREAK, ALTERNATIVE_SEAT_UPDATE;
	public static int MAX_SPAWNED_VEHICLE_KEYS;
	//
	private static Configuration config;
	//
	private static final String GENERAL = "General", PROTOTYPING = "Prototyping";
	private static final String TEST_ = "Test Boolean";
	private static final String MAX_SPAWNED_VEHICLE_KEYS_ = "Max Spawned Vehicle Keys";
	private static final String DROP_ITEMS_ON_BREAK_ = "Drop Items On Break";
	private static final String ALTERNATIVE_SEAT_UPDATE_ = "Alternative Seat Update";

	public static final void initalize(FMLPreInitializationEvent event, File file){
		config = new Configuration(file, FVTM.VERSION, true);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		config.load();
		//
		config.setCategoryRequiresWorldRestart(GENERAL, false);
		config.setCategoryRequiresMcRestart(GENERAL, false);
		config.setCategoryComment(GENERAL, "General FVTM Settings.");
		config.setCategoryRequiresWorldRestart(PROTOTYPING, true);
		config.setCategoryRequiresMcRestart(PROTOTYPING, true);
		config.setCategoryComment(PROTOTYPING, "Various Experimental Settings.");
		//
		refresh();
		config.save();
	}

	public static final Configuration getConfig(){
		return config;
	}
	
	private static final void refresh(){
		TEST = config.getBoolean(TEST_, GENERAL, false, "Ignore this.");
		MAX_SPAWNED_VEHICLE_KEYS = config.getInt(MAX_SPAWNED_VEHICLE_KEYS_, GENERAL, 5, 1, 64, "Maximal amount of keys that can be spawned per vehicle. Does not include universal/admin keys.\n");
		DROP_ITEMS_ON_BREAK = config.getBoolean(DROP_ITEMS_ON_BREAK_, GENERAL, false, "Should the contends of Vehicle Inventories be dropped when breaking the vehicle?");
		ALTERNATIVE_SEAT_UPDATE = config.getBoolean(ALTERNATIVE_SEAT_UPDATE_, PROTOTYPING, false, "Should seats be updated in their own `onUpdate` method instead of being updated directly from the Vehicle?");
	}

	public static void add(List<IConfigElement> list){
		list.add(new ConfigElement(config.getCategory(GENERAL)));
		list.add(new ConfigElement(config.getCategory(PROTOTYPING)));
	}

	public static class EventHandler {
		@SubscribeEvent
		public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
			if(event.getModID().equals("fvtm")){ refresh(); if(config.hasChanged()){ config.save(); }}
		}
	}
	
}