package net.fexcraft.mod.fvtm.util.config;

import java.io.File;
import java.util.List;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.sys.uni12.ULandVehicle;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config {
	
    private static Configuration config;
    private static final String GENERAL = "General", LEGACYSYS = "Legacy", U12BASE = "U12/Basic", PROTOTYPING = "Prototyping";
    public static boolean VEHICLES_NEED_FUEL, VEHICLE_DROP_CONTENTS, RENDER_OUT_OF_VIEW, RENDER_VEHILE_MODELS_AS_ITEMS;
    public static double VEHICLE_UPDATE_RANGE, U12_MOTION_SCALE;
    public static int RAIL_PLACING_GRID, RAIL_SEGMENTATOR, MAX_RAIL_TRACK_LENGTH, ROAD_PLACING_GRID, MAX_ROAD_LENGTH, BLINKER_INTERVAL, U12_SYNC_RATE;
	public static long UNLOAD_INTERVAL;

    public static final void initalize(FMLPreInitializationEvent event, File file){
        config = new Configuration(file, "3.0", true);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        config.load();
        //
        config.setCategoryRequiresWorldRestart(GENERAL, false);
        config.setCategoryRequiresMcRestart(GENERAL, false);
        config.setCategoryComment(GENERAL, "General FVTM Settings.");
        config.setCategoryRequiresWorldRestart(LEGACYSYS, false);
        config.setCategoryRequiresMcRestart(LEGACYSYS, false);
        config.setCategoryComment(LEGACYSYS, "Legacy Entity System.");
        config.setCategoryRequiresWorldRestart(U12BASE, false);
        config.setCategoryRequiresMcRestart(U12BASE, false);
        config.setCategoryComment(U12BASE, "U12/Basic Entity System.");
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
        VEHICLES_NEED_FUEL = config.getBoolean("vehicles_need_fuel", LEGACYSYS, false, "If vehicles need Fuel (in survival mode) to function.");
        VEHICLE_UPDATE_RANGE = config.getFloat("vehicle_update_range", LEGACYSYS, 256, 8, 4096, "Range to which Update Packets will be sent.");
        U12_MOTION_SCALE = config.getFloat("u12_motion_scale", U12BASE, 0.2f, 0.001f, 2, "Physics Motion Scale Multiplier.");
        U12_SYNC_RATE = config.getInt("u12_sync_rate", U12BASE, 5, 1, 10, "Entity sync rate in ticks. Lesser value means higher sync AND higher bandwidth. Higher value means slower sync and less bandwidth.");
        ULandVehicle.SYNC_RATE = U12_SYNC_RATE;
        VEHICLE_DROP_CONTENTS = config.getBoolean("vehicle_drop_contents", LEGACYSYS, false, "If vehicles should drop their inventory contents upon being 'broken' or removed by hand.");
        RENDER_OUT_OF_VIEW = config.getBoolean("render_out_of_view", GENERAL, false, "If vehicles should be rendered out of default view.");
        RENDER_VEHILE_MODELS_AS_ITEMS = config.getBoolean("render_vehicle_models_as_items", GENERAL, true, "If the Vehicle's model should be rendered as Item. May cause laggs.");
        UNLOAD_INTERVAL = config.getInt("unload_interval", GENERAL, 300000, 60000, 86400000, "Interval in which it is checked for trains/rails to be unloaded.");
        {
        	RAIL_PLACING_GRID = config.getInt("rail_placing_grid", GENERAL, 4, 1, 16, "Grid size for when using the rail/junction creation tool, valid are 16 ('per-pixel accuracy'), 8, 4, 2 or 1 (full block)");
            if(RAIL_PLACING_GRID > 16) RAIL_PLACING_GRID = 16;
            if(RAIL_PLACING_GRID > 8 && RAIL_PLACING_GRID < 16) RAIL_PLACING_GRID = 8;
            if(RAIL_PLACING_GRID > 4 && RAIL_PLACING_GRID < 8) RAIL_PLACING_GRID = 4;
            if(RAIL_PLACING_GRID > 2 && RAIL_PLACING_GRID < 4) RAIL_PLACING_GRID = 2;
            if(RAIL_PLACING_GRID < 1) RAIL_PLACING_GRID = 1;
        }
        {
        	RAIL_SEGMENTATOR = config.getInt("rail_generation_segmentator", GENERAL, 4, 1, 16, "Segmentator divider for rail generator, valid are 16, 8, 4, 2 or 1.");
            if(RAIL_SEGMENTATOR > 16) RAIL_SEGMENTATOR = 16;
            if(RAIL_SEGMENTATOR > 8 && RAIL_SEGMENTATOR < 16) RAIL_SEGMENTATOR = 8;
            if(RAIL_SEGMENTATOR > 4 && RAIL_SEGMENTATOR < 8) RAIL_SEGMENTATOR = 4;
            if(RAIL_SEGMENTATOR > 2 && RAIL_SEGMENTATOR < 4) RAIL_SEGMENTATOR = 2;
            if(RAIL_SEGMENTATOR < 1) RAIL_SEGMENTATOR = 1;
        }
        MAX_RAIL_TRACK_LENGTH = config.getInt("rail_track_max_length", GENERAL, 32, 1, 128, "Max vector (total) length of new placed (rail) Tracks.");
        {
        	ROAD_PLACING_GRID = config.getInt("road_placing_grid", GENERAL, 4, 1, 16, "Grid size for when using the road placing tool, valid are 16 ('per-pixel accuracy'), 8, 4, 2 or 1 (full block)");
            if(ROAD_PLACING_GRID > 16) ROAD_PLACING_GRID = 16;
            if(ROAD_PLACING_GRID > 8 && ROAD_PLACING_GRID < 16) ROAD_PLACING_GRID = 8;
            if(ROAD_PLACING_GRID > 4 && ROAD_PLACING_GRID < 8) ROAD_PLACING_GRID = 4;
            if(ROAD_PLACING_GRID > 2 && ROAD_PLACING_GRID < 4) ROAD_PLACING_GRID = 2;
            if(ROAD_PLACING_GRID < 1) ROAD_PLACING_GRID = 1;
        }
        MAX_ROAD_LENGTH = config.getInt("road_max_length", GENERAL, 256, 1, 4096, "Max vector (total) length of new placed roads (with the placing tool).");
        BLINKER_INTERVAL = config.getInt("blinker_interval", GENERAL, 750, 100, 2000, "Blinker/Turn Signal toggle interval, in milliseconds.");
        if(Static.side().isClient()){
        	net.fexcraft.mod.fvtm.model.DefaultPrograms.setupBlinkerTimer();
        }
    }

    public static void add(List<IConfigElement> list){
        list.add(new ConfigElement(config.getCategory(GENERAL)));
        list.add(new ConfigElement(config.getCategory(LEGACYSYS)));
        list.add(new ConfigElement(config.getCategory(PROTOTYPING)));
    }

    public static class EventHandler {

        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
            if(event.getModID().equals("fvtm")){
                refresh(); if(config.hasChanged()) config.save();
            }
        }
        
    }

}
