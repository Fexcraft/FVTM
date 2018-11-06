package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;

public class AdjustableBogieModel extends PartBaseModel {
	
	public static final String[] defval = new String[]{ "chassis", "axle0", "axle1", "axle2", "axle3" };

    @Override
    public void render(VehicleData data, String us){
        Pos pos = data.getVehicle().getWheelPositions().get(us);
        pos = pos == null ? new Pos(0, 0, 0) : pos;
        pos.translate();
        render(data, "chassis"); render(data, "axle0"); render(data, "axle1"); render(data, "axle2"); render(data, "axle3");
        pos.translateR();
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity veh, int meta){
    	VehicleEntity ent = (VehicleEntity)veh;
        Pos pos = data.getVehicle().getWheelPositions().get(us);
        pos = pos == null ? new Pos(0, 0, 0) : pos;
        pos.translate();
        GL11.glRotatef( ent.getBogieYaw()[us.contains("front") ? 0 : 1], 0, 1, 0);
        render(data, "chassis"); render(data, "axle0"); render(data, "axle1"); render(data, "axle2"); render(data, "axle3");
        GL11.glRotatef(-ent.getBogieYaw()[us.contains("front") ? 0 : 1], 0, 1, 0);
        pos.translateR();
    }

}
