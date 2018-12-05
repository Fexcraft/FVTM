//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.part;

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
@fModel(registryname = "hcp:models/part/tr_fenders")
public class TR1Fenders extends PartModel {
	
	private TurboList fenders_left, fenders_right;

	public TR1Fenders(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		fenders_left = new TurboList("fenders_left");
		fenders_left.add(new ModelRendererTurbo(fenders_left, 145, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 12, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-135, -16, 14).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 457, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 4, 0, 0, -1, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-119, -15, 14).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 473, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-114, -14, 12).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 193, 177, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-114, -6, 12).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 281, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, -1, 0, 0, 4, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-136, -15, 14).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 233, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-141, -14, 12).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 385, 185, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-141, -6, 12).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 425, 185, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-143, -6, 12).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 465, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-143, -14, 12).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 321, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 4, 0, 0, -1, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-148, -15, 14).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 1, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 12, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-164, -16, 14).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 73, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, -1, 0, 0, 4, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-165, -15, 14).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 377, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-170, -14, 12).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 417, 209, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-170, -6, 12).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 1, 217, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-172, -6, 12).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 41, 217, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-199, -6, 12).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 81, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-199, -14, 12).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 217, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, -1, 0, 0, 4, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-194, -15, 14).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 273, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 12, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-193, -16, 14).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 337, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 4, 0, 0, -1, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-177, -15, 14).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		fenders_left.add(new ModelRendererTurbo(fenders_left, 121, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-172, -14, 12).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		this.groups.add(fenders_left);
		//
		fenders_right = new TurboList("fenders_right");
		fenders_right.add(new ModelRendererTurbo(fenders_right, 273, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 12, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-135, -16, -26).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 401, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, -1, 0, 0, 4, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-136, -15, -26).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 4, 0, 0, -1, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-119, -15, -26).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 17, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-141, -14, -26).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 433, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-114, -14, -26).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 473, 121, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-141, -6, -26).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 145, 145, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-114, -6, -26).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 185, 145, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-143, -6, -26).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 433, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-143, -14, -26).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 185, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 4, 0, 0, -1, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-148, -15, -26).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 209, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 12, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-164, -16, -26).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 225, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, -1, 0, 0, 4, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-165, -15, -26).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 473, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-170, -14, -26).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 257, 161, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-170, -6, -26).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 297, 161, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-172, -6, -26).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 337, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-172, -14, -26).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 457, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 4, 0, 0, -1, 0, 0, -1, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-177, -15, -26).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 1, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 1, 12, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-193, -16, -26).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 169, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, -1, 0, 0, 4, 0, 0, 4, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-194, -15, -26).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 49, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 14, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-199, -14, -26).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		fenders_right.add(new ModelRendererTurbo(fenders_right, 89, 169, textureX, textureY).addBox(0, 0, 0, 2, 8, 14)
			.setRotationPoint(-199, -6, -26).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		this.groups.add(fenders_right);
	}
    
    @Override
    public void render(VehicleData data, String us){
        switch(us){
            case "fender_left": fenders_left.render(null, data, null); return;
            case "fender_right": fenders_right.render(null, data, null); return;
            default: return;
        }
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity vehicle, int meta){
        super.render(data, us);
    }

}