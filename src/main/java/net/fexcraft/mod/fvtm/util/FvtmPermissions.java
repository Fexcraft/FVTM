package net.fexcraft.mod.fvtm.util;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

public class FvtmPermissions {

    public static final String SPAWN_CMD = "fvtm.command.spawn-vehicle";
    public static final String VEHICLE_BREAK = "fvtm.entity.vehicle.any.break";
    public static final String VEHICLE_PLACE = "fvtm.entity.vehicle.any.place";
    public static final TreeMap<ResourceLocation, String> SPECIFIC_VEHICLE_BREAK = new TreeMap<ResourceLocation, String>();
    public static final TreeMap<ResourceLocation, String> SPECIFIC_VEHICLE_PLACE = new TreeMap<ResourceLocation, String>();

    public static final void register(){
    	PermissionAPI.registerNode(SPAWN_CMD, DefaultPermissionLevel.OP, "Command for spawning FVTM Stuff.");
    	PermissionAPI.registerNode(VEHICLE_BREAK, DefaultPermissionLevel.ALL, "Permission for Vehicle Breaking/Removing.");
    	PermissionAPI.registerNode(VEHICLE_PLACE, DefaultPermissionLevel.ALL, "Permission for Vehicle Placing/Spawning.");
    }

    public static String permBreak(ItemStack stack){
        if(stack.getItem() instanceof VehicleItem){
            ResourceLocation rs = ((VehicleItem) stack.getItem()).getVehicle(stack).getVehicle().getRegistryName();
            if(SPECIFIC_VEHICLE_BREAK.containsKey(rs)){
                return SPECIFIC_VEHICLE_BREAK.get(rs);
            }
            else{
                String str = "fvtm.entity.vehicle." + rs.toString() + ".break";
                SPECIFIC_VEHICLE_BREAK.put(rs, str);
                PermissionAPI.registerNode(str, DefaultPermissionLevel.ALL, "BREAK PERM " + rs.toString());
                return str;
            }
        }
        return VEHICLE_BREAK;
    }

    public static String permPlace(ItemStack stack){
        if(stack.getItem() instanceof VehicleItem){
            ResourceLocation rs = ((VehicleItem) stack.getItem()).getVehicle(stack).getVehicle().getRegistryName();
            if(SPECIFIC_VEHICLE_PLACE.containsKey(rs)){
                return SPECIFIC_VEHICLE_PLACE.get(rs);
            }
            else{
                String str = "fvtm.entity.vehicle." + rs.toString() + ".place";
                SPECIFIC_VEHICLE_PLACE.put(rs, str);
                PermissionAPI.registerNode(str, DefaultPermissionLevel.ALL, "PLACE PERM " + rs.toString());
                return str;
            }
        }
        return VEHICLE_PLACE;
    }

}
