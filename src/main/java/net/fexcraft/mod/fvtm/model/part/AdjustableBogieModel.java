package net.fexcraft.mod.fvtm.model.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.math.Pos;
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
        this.render(data, us);
    }

}
