package net.fexcraft.mod.fvtm.util;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class FvtmPermissions {

    public static final String SPAWN_CMD = "fvtm.command.spawn-vehicle";
    public static final String LAND_VEHICLE_BREAK = "fvtm.entity.landvehicle.break";
    public static final String LAND_VEHICLE_PLACE = "fvtm.entity.landvehicle.place";
    public static final TreeMap<ResourceLocation, String> SPECIFIC_VEHICLE_BREAK = new TreeMap<ResourceLocation, String>();
    public static final TreeMap<ResourceLocation, String> SPECIFIC_VEHICLE_PLACE = new TreeMap<ResourceLocation, String>();

    public static final void register(){
        PermManager.add(SPAWN_CMD, PermissionNode.Type.BOOLEAN, false, true);
        PermManager.add(LAND_VEHICLE_BREAK, PermissionNode.Type.BOOLEAN, true, true);
        PermManager.add(LAND_VEHICLE_PLACE, PermissionNode.Type.BOOLEAN, true, true);
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
                PermManager.add(str, PermissionNode.Type.BOOLEAN, true, true);
                return str;
            }
        }
        return LAND_VEHICLE_BREAK;
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
                PermManager.add(str, PermissionNode.Type.BOOLEAN, true, true);
                return str;
            }
        }
        return LAND_VEHICLE_PLACE;
    }

}
