package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.minecraft.entity.Entity;

public class AdjustableBogieModel extends PartBaseModel {
	
	public ModelRendererTurbo[] chassis = new ModelRendererTurbo[0];
	public ModelRendererTurbo[] axle0 = new ModelRendererTurbo[0];
	public ModelRendererTurbo[] axle1 = new ModelRendererTurbo[0];
	public ModelRendererTurbo[] axle2 = new ModelRendererTurbo[0];
	public ModelRendererTurbo[] axle3 = new ModelRendererTurbo[0];
	/*private boolean rotatedboxes;
	
	public AdjustableBogieModel(boolean rotations){
		this.rotatedboxes = rotations;
	}*/

    @Override
    public void render(VehicleData data, String us){
        Pos pos = data.getVehicle().getWheelPositions().get(us);
        pos = pos == null ? new Pos(0, 0, 0) : pos;
        pos.translate();
        render(chassis); render(axle0); render(axle1); render(axle2); render(axle3);
        pos.translateR();
    }

    @Override
    public void render(VehicleData data, String us, Entity veh, int meta){
    	VehicleEntity ent = (VehicleEntity)veh;
        Pos pos = data.getVehicle().getWheelPositions().get(us);
        pos = pos == null ? new Pos(0, 0, 0) : pos;
        pos.translate();
        GL11.glRotatef( ent.getBogieYaw()[us.contains("front") ? 0 : 1], 0, 1, 0);
        render(chassis); render(axle0); render(axle1); render(axle2); render(axle3);
        GL11.glRotatef(-ent.getBogieYaw()[us.contains("front") ? 0 : 1], 0, 1, 0);
        pos.translateR();
    }

}
