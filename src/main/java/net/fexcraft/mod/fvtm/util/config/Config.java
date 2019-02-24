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

    public static boolean TEST, DROP_ITEMS_ON_BREAK, ALTERNATIVE_SEAT_UPDATE, VEHICLE_NEEDS_FUEL, RENDER_IN_GUI, RENDER_VEHICLE_PREVIEW, RENDER_BLOCK_PREVIEW, RENDER_OUT_OF_VIEW;//, ROUND_RAIL_TRACKS;//, COLLSYS;
    public static int MAX_SPAWNED_VEHICLE_KEYS, VEHICLE_UPDATE_RANGE;
	public static String ADDONS_FOLDER = "addons";
    //
    private static Configuration config;
    //
    private static final String GENERAL = "General", PROTOTYPING = "Prototyping";
    private static final String TEST_ = "Test Boolean";
    private static final String MAX_SPAWNED_VEHICLE_KEYS_ = "Max Spawned Vehicle Keys";
    private static final String DROP_ITEMS_ON_BREAK_ = "Drop Items On Break";
    private static final String ALTERNATIVE_SEAT_UPDATE_ = "Alternative Seat Update";
    private static final String VEHICLE_NEEDS_FUEL_ = "Vehicle Needs Fuel";
    private static final String VEHICLE_UPDATE_RANGE_ = "Vehicle Update Range";
    private static final String RENDER_IN_GUI_ = "Render Vehicles As Icons";
    private static final String RENDER_OUT_OF_VIEW_ = "Render Vehicles out of default View range.";
	private static final String ADDONS_FOLDER_ = "addons_folder";
    private static final String RENDER_VEHICLE_PREVIEW_ = "render_vehicle_preview";
    private static final String RENDER_BLOCK_PREVIEW_ = "render_block_preview";
    //private static final String ROUND_RAIL_TRACKS_ = "round_rail_tracks";
    //private static final String COLLISION_SYSTEM_ = "collision_system";

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
        VEHICLE_NEEDS_FUEL = config.getBoolean(VEHICLE_NEEDS_FUEL_, GENERAL, true, "Do vehicles need Fuel to run?");
        VEHICLE_UPDATE_RANGE = config.getInt(VEHICLE_UPDATE_RANGE_, GENERAL, 256, 16, 4096, "Range in which Update Packets are sent.");
        RENDER_IN_GUI = config.getBoolean(RENDER_IN_GUI_, GENERAL, true, "Should Vehicles be rendered in GUI instead of their default plain Texture Icons?");
        RENDER_OUT_OF_VIEW = config.getBoolean(RENDER_OUT_OF_VIEW_, GENERAL, true, "Turn off if vehicles out of view range cause issues.");
        ADDONS_FOLDER = config.getString(ADDONS_FOLDER_, GENERAL, "addons", "The folder in which there should be searched for Addons.");
        RENDER_VEHICLE_PREVIEW = config.getBoolean(RENDER_VEHICLE_PREVIEW_, GENERAL, false, "3D full size preview of to be placed vehicle, if the item is in hand.");
        RENDER_BLOCK_PREVIEW = config.getBoolean(RENDER_BLOCK_PREVIEW_, GENERAL, true, "3D full size preview of to be placed block, if the item is in hand.");
        //ROUND_RAIL_TRACKS = config.getBoolean(ROUND_RAIL_TRACKS_, PROTOTYPING, false, "If rail tracks should get rounded.");
        //COLLSYS = config.getBoolean(COLLISION_SYSTEM_, PROTOTYPING, true, "If the advanced (prototype) collision system should be enabled.");
    }

    public static void add(List<IConfigElement> list){
        list.add(new ConfigElement(config.getCategory(GENERAL)));
        list.add(new ConfigElement(config.getCategory(PROTOTYPING)));
    }

    public static class EventHandler {

        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
            if(event.getModID().equals("fvtm")){
                refresh();
                if(config.hasChanged()){
                    config.save();
                }
            }
        }
    }

}
