//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.trailer;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/vehicle/tr1")
public class TR1Model extends VehicleModel {
	
	private TurboList body, feet;

	public TR1Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		body = new TurboList("body");
		body.add(new ModelRendererTurbo(body, 1, 1, textureX, textureY).addBox(-2, 0, -2, 4, 8, 4)
			.setRotationPoint(0, -19, 0).setRotationAngle(0, 0.7853982f, 0).setName("Box 221")
		);
		body.add(new ModelRendererTurbo(body, 1, 1, textureX, textureY).addBox(0, 0, 0, 128, 3, 52)
			.setRotationPoint(-236, -24, -26).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		body.add(new ModelRendererTurbo(body, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 64, 4, 52, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, -2, -2, 0, -2, -2, 0, -2, 0, 0, -2)
			.setRotationPoint(-44, -21, -26).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		body.add(new ModelRendererTurbo(body, 313, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 12, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-201, -9, 8).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		body.add(new ModelRendererTurbo(body, 313, 25, textureX, textureY)
			.addShapeBox(0, 0, -4, 90, 12, 4, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-201, -9, -8).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		body.add(new ModelRendererTurbo(body, 329, 49, textureX, textureY).addBox(-2, -2, 0, 4, 4, 36)
			.setRotationPoint(-184.5f, -2, -18).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		body.add(new ModelRendererTurbo(body, 417, 49, textureX, textureY).addBox(-2, -2, 0, 4, 4, 36)
			.setRotationPoint(-155.5f, -2, -18).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		body.add(new ModelRendererTurbo(body, 185, 57, textureX, textureY).addBox(-2, -2, 0, 4, 4, 36)
			.setRotationPoint(-126.5f, -2, -18).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		body.add(new ModelRendererTurbo(body, 265, 97, textureX, textureY).addBox(0, 0, 0, 110, 12, 4)
			.setRotationPoint(-210, -21, 10).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		body.add(new ModelRendererTurbo(body, 1, 121, textureX, textureY).addBox(0, 0, -4, 110, 12, 4)
			.setRotationPoint(-210, -21, -10).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		body.add(new ModelRendererTurbo(body, 217, 121, textureX, textureY).addBox(0, 0, 0, 84, 12, 20)
			.setRotationPoint(-199, -11, -10).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		body.add(new ModelRendererTurbo(body, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, -4, 12, 12, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -11, 0, 0, 0, 0, 0, 0, 0, 0, -11, 0, 0)
			.setRotationPoint(-222, -21, -10).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		body.add(new ModelRendererTurbo(body, 377, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 12, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -11, 0, 0, 0, 0, 0, 0, 0, 0, -11, 0, 0)
			.setRotationPoint(-222, -21, 10).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		body.add(new ModelRendererTurbo(body, 233, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 12, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -56, 0, 0, -56, 0, 0, 0, 0, 0)
			.setRotationPoint(-100, -21, 10).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		body.add(new ModelRendererTurbo(body, 1, 145, textureX, textureY)
			.addShapeBox(0, 0, -4, 58, 12, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -56, 0, 0, -56, 0, 0, 0, 0, 0)
			.setRotationPoint(-100, -21, -10).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		body.add(new ModelRendererTurbo(body, 25, 1, textureX, textureY).addBox(0, 0, 0, 2, 12, 2)
			.setRotationPoint(-234, -21, -20).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		body.add(new ModelRendererTurbo(body, 41, 1, textureX, textureY).addBox(0, 0, 0, 2, 12, 2)
			.setRotationPoint(-234, -21, 18).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		body.add(new ModelRendererTurbo(body, 377, 121, textureX, textureY).addBox(0, 0, 0, 2, 6, 51)
			.setRotationPoint(-235.5f, -21, -25.5f).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		body.add(new ModelRendererTurbo(body, 41, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, -8, 0, 0, -8, 0, 0, 8, 0, 0)
			.setRotationPoint(-226, -21, -20).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		body.add(new ModelRendererTurbo(body, 33, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, -8, 0, 0, -8, 0, 0, 8, 0, 0)
			.setRotationPoint(-226, -21, 18).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		body.add(new ModelRendererTurbo(body, 81, 145, textureX, textureY).addBox(0, 0, 0, 4, 4, 48)
			.setRotationPoint(-235, -9, -24).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		body.add(new ModelRendererTurbo(body, 1, 201, textureX, textureY).addBox(0, 0, 0, 190, 3, 1)
			.setRotationPoint(-235, -21, -25).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		body.add(new ModelRendererTurbo(body, 1, 209, textureX, textureY).addBox(0, 0, 0, 190, 3, 1)
			.setRotationPoint(-235, -21, 24).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		body.add(new ModelRendererTurbo(body, 417, 49, textureX, textureY).addBox(0, 0, 0, 2, 12, 2)
			.setRotationPoint(-234, -21, -1).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		body.add(new ModelRendererTurbo(body, 433, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 12, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, -8, 0, 0, -8, 0, 0, 8, 0, 0)
			.setRotationPoint(-226, -21, -1).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		body.add(new ModelRendererTurbo(body, 1, 41, textureX, textureY).addBox(0, 0, 0, 6, 4, 6)
			.setRotationPoint(-50, -21, -22).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		body.add(new ModelRendererTurbo(body, 185, 57, textureX, textureY).addBox(0, 0, 0, 6, 4, 6)
			.setRotationPoint(-50, -21, 16).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		body.add(new ModelRendererTurbo(body, 409, 121, textureX, textureY).addBox(0, 0, 0, 1, 2, 7)
			.setRotationPoint(-236, -18.5f, -22).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		body.add(new ModelRendererTurbo(body, 385, 161, textureX, textureY).addBox(0, 0, 0, 1, 2, 7)
			.setRotationPoint(-236, -18.5f, 15).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		body.add(new ModelRendererTurbo(body, 105, 233, textureX, textureY).addBox(0, 0, 0, 128, 3, 52)
			.setRotationPoint(-108, -24, -26).setRotationAngle(0, 0, 0).setName("Box 370")
		);
		this.groups.add(body);
		//
		feet = new TurboList("feet");
		feet.add(new ModelRendererTurbo(feet, 465, 49, textureX, textureY).addBox(-2, 0, -2, 4, 24, 4)
			.setRotationPoint(-47, -17, -19).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		feet.add(new ModelRendererTurbo(feet, 1, 57, textureX, textureY).addBox(-3, 24, -3, 6, 3, 6)
			.setRotationPoint(-47, -17, -19).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		feet.add(new ModelRendererTurbo(feet, 489, 49, textureX, textureY).addBox(-2, 0, -2, 4, 24, 4)
			.setRotationPoint(-47, -17, 19).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		feet.add(new ModelRendererTurbo(feet, 25, 65, textureX, textureY).addBox(-3, 24, -3, 6, 3, 6)
			.setRotationPoint(-47, -17, 19).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		this.groups.add(feet);
	}
	
    @Override
    public void render(VehicleData data, Object obj, @Nullable VehicleEntity entity, int meta){
    	body.render(entity,  data);
        for(ModelRendererTurbo turbo : feet){
            turbo.rotateAngleZ = entity == null || ((VehicleEntity)entity).getEntityAtFront() == null ? 0 : Static.rad90;
        } feet.render(entity, data);
        
    }

}