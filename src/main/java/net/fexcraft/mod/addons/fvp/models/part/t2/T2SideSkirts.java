//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t2;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t2_side_skirts")
public class T2SideSkirts extends PartModel {

	public TurboList side_skirt_left;
	public TurboList side_skirt_right;

	public T2SideSkirts(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand");
		//
		side_skirt_left = new TurboList("side_skirt_left");
		side_skirt_left.add(new ModelRendererTurbo(side_skirt_left, 361, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0)
			.setRotationPoint(-32, -14, 14).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 150")
		);
		side_skirt_left.add(new ModelRendererTurbo(side_skirt_left, 225, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 13, 12, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -12, 14).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 153")
		);
		this.groups.add(side_skirt_left);
		//
		side_skirt_right = new TurboList("side_skirt_right");
		side_skirt_right.add(new ModelRendererTurbo(side_skirt_right, 225, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 1, 12, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -14, -26).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 151")
		);
		side_skirt_right.add(new ModelRendererTurbo(side_skirt_right, 353, 273, textureX, textureY)
			.addShapeBox(0, 0, 0, 50, 13, 12, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -12, -26).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 154")
		);
		this.groups.add(side_skirt_right);
	}
    @Override
    public void render(VehicleData data, String us){
        switch(us){
            case "side_left":{ side_skirt_left.render(null, data, us); return; }
            case "side_right":{ side_skirt_right.render(null, data, us); return; }
            case "sides": default:{ side_skirt_left.render(null, data, us); side_skirt_right.render(null, data, us); return; }
        }
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
        super.render(data, us);
    }

}
