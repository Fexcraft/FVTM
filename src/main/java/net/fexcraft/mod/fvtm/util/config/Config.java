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
	
    private static Configuration config;
    private static final String GENERAL = "General", LEGACYSYS = "Legacy", PROTOTYPING = "Prototyping";
    public static boolean VEHICLES_NEED_FUEL, VEHICLE_DROP_CONTENTS, RENDER_OUT_OF_VIEW;
    public static double VEHICLE_UPDATE_RANGE;

    public static final void initalize(FMLPreInitializationEvent event, File file){
        config = new Configuration(file, FVTM.VERSION, true);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        config.load();
        //
        config.setCategoryRequiresWorldRestart(GENERAL, false);
        config.setCategoryRequiresMcRestart(GENERAL, false);
        config.setCategoryComment(GENERAL, "General FVTM Settings.");
        config.setCategoryRequiresWorldRestart(LEGACYSYS, false);
        config.setCategoryRequiresMcRestart(LEGACYSYS, false);
        config.setCategoryComment(LEGACYSYS, "Legacy Entity System.");
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
        VEHICLE_UPDATE_RANGE = config.getFloat("vehicle_update_range", LEGACYSYS, 256, 8, 1024, "Range to which Update Packets will be sent.");
        VEHICLE_DROP_CONTENTS = config.getBoolean("vehicle_drop_contents", LEGACYSYS, false, "If vehicles should drop their inventory contents upon being 'broken' or removed by hand.");
        RENDER_OUT_OF_VIEW = config.getBoolean("render_out_of_view", LEGACYSYS, false, "If vehicles should be rendered out of default view.");
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
