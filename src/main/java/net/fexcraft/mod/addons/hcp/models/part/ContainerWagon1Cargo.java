//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/part/containerwagon1")
public class ContainerWagon1Cargo extends PartModel {

	public ContainerWagon1Cargo(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
	}

    @Override
    public void render(VehicleData data, String us){
        super.def_renderContainer(data, us);
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
        super.def_renderContainer(data, us, vehicle);
    }

}
