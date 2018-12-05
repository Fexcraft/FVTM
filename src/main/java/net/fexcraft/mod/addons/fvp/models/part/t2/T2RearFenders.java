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
@fModel(registryname = "fvp:models/part/t2_rear_fenders")
public class T2RearFenders extends PartModel {
	
	private TurboList fender_left, fender_right;

	public T2RearFenders(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		fender_left = new TurboList("fender_left");
		fender_left.add(new ModelRendererTurbo(fender_left, 185, 49, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-35, -6, 12).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		fender_left.add(new ModelRendererTurbo(fender_left, 233, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-35, -14, 12).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		fender_left.add(new ModelRendererTurbo(fender_left, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-62, -14, 12).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		fender_left.add(new ModelRendererTurbo(fender_left, 65, 73, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-62, -6, 12).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		fender_left.add(new ModelRendererTurbo(fender_left, 481, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, -1, 0, 0, 4, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-57, -15, 14).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		fender_left.add(new ModelRendererTurbo(fender_left, 313, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 4, 0, 0, -1, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-40, -15, 14).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		fender_left.add(new ModelRendererTurbo(fender_left, 321, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 12, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -16, 14).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		fender_left.add(new ModelRendererTurbo(fender_left, 281, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 19, 1, 2, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-57, -15, 12).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		fender_left.add(new ModelRendererTurbo(fender_left, 417, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 2, 0, -2, 0, -1, -2, 0, -1, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -16, 12).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		this.groups.add(fender_left);
		//
		fender_right = new TurboList("fender_right");
		fender_right.add(new ModelRendererTurbo(fender_right, 129, 73, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-62, -6, -26).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		fender_right.add(new ModelRendererTurbo(fender_right, 385, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-62, -14, -26).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		fender_right.add(new ModelRendererTurbo(fender_right, 385, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, -1, 0, 0, 4, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-57, -15, -26).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		fender_right.add(new ModelRendererTurbo(fender_right, 1, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 12, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -16, -26).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		fender_right.add(new ModelRendererTurbo(fender_right, 473, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 4, 0, 0, -1, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-40, -15, -26).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		fender_right.add(new ModelRendererTurbo(fender_right, 257, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-35, -14, -26).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		fender_right.add(new ModelRendererTurbo(fender_right, 1, 97, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-35, -6, -26).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		fender_right.add(new ModelRendererTurbo(fender_right, 233, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 19, 1, 2, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-57, -15, -14).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		fender_right.add(new ModelRendererTurbo(fender_right, 369, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 2, 0, -2, 0, 0, -2, 0, 0, -2, 0, -1, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56, -16, -14).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		this.groups.add(fender_right);
	}
    @Override
    public void render(VehicleData data, String us){
        switch(us){
            case "rear_fender_left":{ fender_left.render(null, data, us); return; }
            case "rear_fender_right":{ fender_right.render(null, data, us); return; }
            default:{ fender_left.render(null, data, us);  fender_right.render(null, data, us); return; }
        }
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
        this.render(data, us);
    }

}
