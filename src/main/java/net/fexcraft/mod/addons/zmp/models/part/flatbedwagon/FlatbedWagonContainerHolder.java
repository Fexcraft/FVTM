//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.zmp.models.part.flatbedwagon;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;//TODO replace this one if needed

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.5-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "zmp:models/part/flatbedwagon_containerholder")
public class FlatbedWagonContainerHolder extends PartModel {

	public FlatbedWagonContainerHolder(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("zackyboy19");
		//
		TurboList container_holder = new TurboList("container_holder");
		container_holder.add(new ModelRendererTurbo(container_holder, 389, 148, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 50, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0)
			.setRotationPoint(112, -33, -25).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 332, 120, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 50, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(-115, -33, -25).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		this.groups.add(container_holder);
		this.translate(0, 8, 0);
	}

    @Override
    public void render(VehicleData data, String us){
    	super.render(data, us);
        super.def_renderContainer(data, us);
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
    	super.render(data, us, vehicle, meta);
        super.def_renderContainer(data, us, vehicle);
    }

}
