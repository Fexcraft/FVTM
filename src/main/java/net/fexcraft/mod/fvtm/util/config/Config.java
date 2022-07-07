package net.fexcraft.mod.fvtm.util.config;

import java.io.File;
import java.util.List;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.ContainerBlock;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
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
    private static final String
		CLIENT = "Client/Rendering",
    	GENERAL = "General",
    	//LEGACYSYS = "Legacy",
    	U12BASE = "U12/Basic",
    	RAILSYS = "FVTM Rail/Trains",
    	ROADSYS = "FVTM Road System",
    	WIRESYS = "FVTM Wire System";//,
    	//PROTOTYPING = "Prototyping";
    public static boolean VEHICLES_NEED_FUEL, VEHICLE_DROP_CONTENTS, ROADTOOL_FOR_ALL, OVERLAY_ON_BOTTOM;
    public static boolean RENDER_OUT_OF_VIEW, RENDER_VEHILE_MODELS_AS_ITEMS, RENDER_BLOCK_MODELS_AS_ITEMS, DISABLE_LIGHT_BEAMS;
    public static boolean DISABLE_RAIL_BLOCKS, DISABLE_RAILS, DISABLE_ROADS, UNBREAKABLE_CONTAINERS, DISMOUNT_ON_LOGOUT;
    public static boolean LOAD_ALL_RESOURCEPACKS, LOAD_LITE_FROM_MODS, DISABLE_WIRES, RENDER_VEHICLES_SEPARATELY, DISABLE_PARTICLES;
    public static double VEHICLE_UPDATE_RANGE, U12_MOTION_SCALE;
    public static int RAIL_PLACING_GRID, RAIL_SEGMENTATOR, MAX_RAIL_TRACK_LENGTH, ROAD_PLACING_GRID, MAX_ROAD_LENGTH, BLINKER_INTERVAL, U12_SYNC_RATE;
    public static int WIRE_SEGMENTATOR, MAX_WIRE_LENGTH;
	public static long UNLOAD_INTERVAL;
	public static String[] DEFAULT_TRAFFIC_SIGN_LIBRARIES;

    public static final void initalize(FMLPreInitializationEvent event, File file){
        config = new Configuration(file, "4.0", true);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        config.load();
        //
        config.setCategoryRequiresWorldRestart(CLIENT, false);
        config.setCategoryRequiresMcRestart(CLIENT, false);
        config.setCategoryComment(CLIENT, "Local Client/Rendering Settings.");
        config.setCategoryRequiresWorldRestart(GENERAL, false);
        config.setCategoryRequiresMcRestart(GENERAL, false);
        config.setCategoryComment(GENERAL, "General FVTM Settings.");
        /*config.setCategoryRequiresWorldRestart(LEGACYSYS, false);
        config.setCategoryRequiresMcRestart(LEGACYSYS, false);
        config.setCategoryComment(LEGACYSYS, "Legacy Entity System.");*/
        config.setCategoryRequiresWorldRestart(U12BASE, false);
        config.setCategoryRequiresMcRestart(U12BASE, false);
        config.setCategoryComment(U12BASE, "U12/Basic Entity System.");
        config.setCategoryRequiresWorldRestart(RAILSYS, true);
        config.setCategoryRequiresMcRestart(RAILSYS, false);
        config.setCategoryComment(RAILSYS, "FVTM Rail System");
        config.setCategoryRequiresWorldRestart(ROADSYS, true);
        config.setCategoryRequiresMcRestart(ROADSYS, false);
        config.setCategoryComment(ROADSYS, "FVTM Road System");
        config.setCategoryRequiresWorldRestart(WIRESYS, true);
        config.setCategoryRequiresMcRestart(WIRESYS, false);
        config.setCategoryComment(WIRESYS, "FVTM Wire System");
        /*config.setCategoryRequiresWorldRestart(PROTOTYPING, true);
        config.setCategoryRequiresMcRestart(PROTOTYPING, true);
        config.setCategoryComment(PROTOTYPING, "Various Experimental Settings.");*/
        //
        refresh();
        config.save();
    }

    public static final Configuration getConfig(){
        return config;
    }

    private static final void refresh(){
    	{//CLIENT
            RENDER_OUT_OF_VIEW = config.getBoolean("render_out_of_view", CLIENT, false, "If vehicles should be rendered out of default view.");
            RENDER_VEHILE_MODELS_AS_ITEMS = config.getBoolean("render_vehicle_models_as_items", CLIENT, true, "If the Vehicle's model should be rendered as Item. Could cause laggs.");
            RENDER_BLOCK_MODELS_AS_ITEMS = config.getBoolean("render_block_models_as_items", CLIENT, true, "If the (non-vanilla) Block models should be rendered as Item.");
            BLINKER_INTERVAL = config.getInt("blinker_interval", CLIENT, 750, 100, 2000, "Blinker/Turn Signal toggle interval, in milliseconds.");
            if(Static.side().isClient()){
            	net.fexcraft.mod.fvtm.model.DefaultPrograms.setupBlinkerTimer();
            }
            DISABLE_LIGHT_BEAMS = config.getBoolean("disable_light_beams", CLIENT, false, "If light beam rendering should be disabled.");
            OVERLAY_ON_BOTTOM = config.getBoolean("default_overlay_on_bottom", CLIENT, true, "If the default steering overlay should be on bottom rather than on top of screen.");
            RENDER_VEHICLES_SEPARATELY = config.getBoolean("render_vehicles_separately", CLIENT, true, "If vehicles should be rendered separately new a new render pass. Allows for higher view distance.");
            DISABLE_PARTICLES = config.getBoolean("disable_particles", CLIENT, false, "If FVTM particles (particle system) should be disabled.");
    	}
    	{//GENERAL
            VEHICLES_NEED_FUEL = config.getBoolean("vehicle_consume_fuel", GENERAL, true, "If vehicles need Fuel (in survival mode) to function.");
            VEHICLE_UPDATE_RANGE = config.getFloat("vehicle_update_range", GENERAL, 256, 8, 4096, "Range in which Vehicle Update Packets will be sent.");
            VEHICLE_DROP_CONTENTS = config.getBoolean("vehicle_drop_contents", GENERAL, false, "If vehicles should drop their inventory contents upon being 'broken' or removed by hand.");
            UNBREAKABLE_CONTAINERS = config.getBoolean("unbreakable_containers", GENERAL, false, "If containers should be unbreakable (via tools/hand).");
            ROADTOOL_FOR_ALL = config.getBoolean("road_tool_for_all", GENERAL, false, "When not using a Forge PermissionsAPI compatible permission manager, to allow any player to use the Road Placing Tool.");
            LOAD_ALL_RESOURCEPACKS = config.getBoolean("load_all_resourcepacks", GENERAL, true, "If true all lite packs in /resoucepacks/ will be loaded, otherwhise when false, only the active ones.");
            LOAD_LITE_FROM_MODS = config.getBoolean("load_litepacks_from_mods", GENERAL, true, "If true, FVTM will search for litepacks in the /mods/ folder.");
            DEFAULT_TRAFFIC_SIGN_LIBRARIES = config.getStringList("traffic_sign_libraries", GENERAL, new String[]{ "default_fexcraft;http://fexcraft.net/files/mod_data/fvtm/default_traffic_sign_library.json" }, "List of External Traffic Sign Libraries. Separate ID from URL using a semicolon.");
            DISMOUNT_ON_LOGOUT = config.getBoolean("dismount_on_logout", GENERAL, true, "If players should automatically dismount vehicles on log out (leaving server).");
            TrafficSignLibrary.load(true);
    	}
    	{//LEGACY
    		
    	}
    	{//U12/BASIC
    		U12_MOTION_SCALE = config.getFloat("u12_motion_scale", U12BASE, 0.2f, 0.001f, 2, "Physics Motion Scale Multiplier.");
            U12_SYNC_RATE = config.getInt("u12_sync_rate", U12BASE, 5, 1, 10, "Entity sync rate in ticks. Lesser value means higher sync AND higher bandwidth. Higher value means slower sync and less bandwidth.");
            ULandVehicle.SYNC_RATE = U12_SYNC_RATE;
            
    	}
    	{//RAIL
    		DISABLE_RAIL_BLOCKS = config.getBoolean("disable_rail_blocks", RAILSYS, false, "If FVTM RailBlocks shouldn't be placed along FVTM rail tracks.");
    		UNLOAD_INTERVAL = config.getInt("unload_interval", RAILSYS, 300000, 60000, 86400000, "Interval in which it is checked for trains/rails to be unloaded.");
            {
            	RAIL_PLACING_GRID = config.getInt("rail_placing_grid", RAILSYS, 4, 1, 16, "Grid size for when using the rail/junction creation tool, valid are 16 ('per-pixel accuracy'), 8, 4, 2 or 1 (full block)");
                if(RAIL_PLACING_GRID > 16) RAIL_PLACING_GRID = 16;
                if(RAIL_PLACING_GRID > 8 && RAIL_PLACING_GRID < 16) RAIL_PLACING_GRID = 8;
                if(RAIL_PLACING_GRID > 4 && RAIL_PLACING_GRID < 8) RAIL_PLACING_GRID = 4;
                if(RAIL_PLACING_GRID > 2 && RAIL_PLACING_GRID < 4) RAIL_PLACING_GRID = 2;
                if(RAIL_PLACING_GRID < 1) RAIL_PLACING_GRID = 1;
            }
            {
            	RAIL_SEGMENTATOR = config.getInt("rail_generation_segmentator", RAILSYS, 4, 1, 16, "Segmentator divider for rail generator, valid are 16, 8, 4, 2 or 1.");
                if(RAIL_SEGMENTATOR > 16) RAIL_SEGMENTATOR = 16;
                if(RAIL_SEGMENTATOR > 8 && RAIL_SEGMENTATOR < 16) RAIL_SEGMENTATOR = 8;
                if(RAIL_SEGMENTATOR > 4 && RAIL_SEGMENTATOR < 8) RAIL_SEGMENTATOR = 4;
                if(RAIL_SEGMENTATOR > 2 && RAIL_SEGMENTATOR < 4) RAIL_SEGMENTATOR = 2;
                if(RAIL_SEGMENTATOR < 1) RAIL_SEGMENTATOR = 1;
            }
            MAX_RAIL_TRACK_LENGTH = config.getInt("rail_track_max_length", RAILSYS, 32, 1, 128, "Max vector (total) length of new placed (rail) Tracks.");
            DISABLE_RAILS = config.getBoolean("disable_rails", RAILSYS, false, "If FVTM rail system should be disabled.");
            
    	}
    	{//ROAD
            {
            	ROAD_PLACING_GRID = config.getInt("road_placing_grid", ROADSYS, 4, 1, 16, "Grid size for when using the road placing tool, valid are 16 ('per-pixel accuracy'), 8, 4, 2 or 1 (full block)");
                if(ROAD_PLACING_GRID > 16) ROAD_PLACING_GRID = 16;
                if(ROAD_PLACING_GRID > 8 && ROAD_PLACING_GRID < 16) ROAD_PLACING_GRID = 8;
                if(ROAD_PLACING_GRID > 4 && ROAD_PLACING_GRID < 8) ROAD_PLACING_GRID = 4;
                if(ROAD_PLACING_GRID > 2 && ROAD_PLACING_GRID < 4) ROAD_PLACING_GRID = 2;
                if(ROAD_PLACING_GRID < 1) ROAD_PLACING_GRID = 1;
            }
            MAX_ROAD_LENGTH = config.getInt("road_max_length", ROADSYS, 256, 1, 4096, "Max vector (total) length of new placed roads (with the placing tool).");
            DISABLE_ROADS = config.getBoolean("disable_roads", ROADSYS, false, "If FVTM road system should be disabled.");
            
    	}
    	{//WIRE
            {
            	WIRE_SEGMENTATOR = config.getInt("wire_generation_segmentator", RAILSYS, 4, 1, 16, "Segmentator divider for wire generator, valid are 16, 8, 4, 2 or 1.");
                if(WIRE_SEGMENTATOR > 16) WIRE_SEGMENTATOR = 16;
                if(WIRE_SEGMENTATOR > 8 && WIRE_SEGMENTATOR < 16) WIRE_SEGMENTATOR = 8;
                if(WIRE_SEGMENTATOR > 4 && WIRE_SEGMENTATOR < 8) WIRE_SEGMENTATOR = 4;
                if(WIRE_SEGMENTATOR > 2 && WIRE_SEGMENTATOR < 4) WIRE_SEGMENTATOR = 2;
                if(WIRE_SEGMENTATOR < 1) WIRE_SEGMENTATOR = 1;
            }
            MAX_WIRE_LENGTH = config.getInt("wire_max_length", WIRESYS, 64, 1, 1024, "Max vector (total) length of new placed Wires.");
            DISABLE_WIRES = config.getBoolean("disable_wires", WIRESYS, false, "If FVTM wire system should be disabled.");
            
    	}
    	ContainerBlock.INSTANCE.setHardness(UNBREAKABLE_CONTAINERS ? -1f : 8f);
    }

    public static void add(List<IConfigElement> list){
        list.add(new ConfigElement(config.getCategory(GENERAL)));
        list.add(new ConfigElement(config.getCategory(U12BASE)));
        list.add(new ConfigElement(config.getCategory(RAILSYS)));
        list.add(new ConfigElement(config.getCategory(ROADSYS)));
        list.add(new ConfigElement(config.getCategory(WIRESYS)));
        //list.add(new ConfigElement(config.getCategory(LEGACYSYS)));
        list.add(new ConfigElement(config.getCategory(CLIENT)));
        //list.add(new ConfigElement(config.getCategory(PROTOTYPING)));
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
