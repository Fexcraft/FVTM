package net.fexcraft.mod.fvtm.model.vehicle;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.minecraft.entity.Entity;

public class EmptyVehicleModel extends VehicleModel {

    public static EmptyVehicleModel INSTANCE = new EmptyVehicleModel();

    public void render(VehicleData data){
        return;
    }

    public void render(VehicleData data, @Nullable Entity entity, int meta){
        return;
    }

}
