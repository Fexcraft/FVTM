//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.fvtm.util.RenderCache;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/part/tr1_type1")
public class TR1Type1 extends PartModel {
	
	private TurboList chassis_body, door_left, lights_door_left, door_right, lights_door_right, lights;

	public TR1Type1(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		chassis_body = new TurboList("chassis_body");
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 1, textureX, textureY).addBox(0, 0, 0, 128, 48, 1)
			.setRotationPoint(-236, -72, -26).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 57, textureX, textureY).addBox(0, 0, 0, 128, 48, 1)
			.setRotationPoint(-108, -72, -26).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 113, textureX, textureY).addBox(0, 0, 0, 128, 48, 1)
			.setRotationPoint(-236, -72, 25).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 169, textureX, textureY).addBox(0, 0, 0, 128, 48, 1)
			.setRotationPoint(-108, -72, 25).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 265, 1, textureX, textureY).addBox(0, 0, 0, 2, 48, 2)
			.setRotationPoint(17, -72, -25).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 281, 1, textureX, textureY).addBox(0, 0, 0, 2, 48, 2)
			.setRotationPoint(-109, -72, -25).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 297, 1, textureX, textureY).addBox(0, 0, 0, 2, 48, 2)
			.setRotationPoint(-235, -72, -25).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 313, 1, textureX, textureY).addBox(0, 0, 0, 2, 48, 2)
			.setRotationPoint(-235, -72, 23).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 329, 1, textureX, textureY).addBox(0, 0, 0, 2, 48, 2)
			.setRotationPoint(-109, -72, 23).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 345, 1, textureX, textureY).addBox(0, 0, 0, 2, 48, 2)
			.setRotationPoint(17, -72, 23).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 361, 1, textureX, textureY).addBox(0, 0, 0, 1, 48, 50)
			.setRotationPoint(19, -72, -25).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 225, textureX, textureY).addBox(0, 0, 0, 128, 2, 52)
			.setRotationPoint(-108, -74, -26).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 281, textureX, textureY).addBox(0, 0, 0, 128, 2, 52)
			.setRotationPoint(-236, -74, -26).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		this.groups.add(chassis_body);
		//
		door_left = new TurboList("door_left");
		door_left.add(new ModelRendererTurbo(door_left, 321, 81, textureX, textureY).addBox(-0.5f, 0, -25, 1, 48, 25)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		door_left.add(new ModelRendererTurbo(door_left, 361, 1, textureX, textureY).addBox(-0.7f, 43, -9, 1, 4, 8)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		door_left.add(new ModelRendererTurbo(door_left, 361, 1, textureX, textureY).addBox(-0.7f, 3, -24, 1, 1, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		door_left.add(new ModelRendererTurbo(door_left, 385, 1, textureX, textureY).addBox(-0.7f, 11, -24, 1, 1, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		door_left.add(new ModelRendererTurbo(door_left, 425, 1, textureX, textureY).addBox(-0.7f, 19, -24, 1, 1, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		door_left.add(new ModelRendererTurbo(door_left, 441, 1, textureX, textureY).addBox(-0.7f, 27, -24, 1, 1, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		door_left.add(new ModelRendererTurbo(door_left, 457, 1, textureX, textureY).addBox(-0.7f, 36, -24, 1, 1, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		door_left.add(new ModelRendererTurbo(door_left, 473, 1, textureX, textureY).addBox(-0.7f, 44, -24, 1, 1, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		this.groups.add(door_left);
		//
		door_right = new TurboList("door_right");
		door_right.add(new ModelRendererTurbo(door_right, 265, 33, textureX, textureY).addBox(-0.5f, 0, 0, 1, 48, 25)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		door_right.add(new ModelRendererTurbo(door_right, 385, 1, textureX, textureY).addBox(-0.7f, 43, 1, 1, 4, 8)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		door_right.add(new ModelRendererTurbo(door_right, 377, 1, textureX, textureY).addBox(-0.7f, 3, 23, 1, 1, 3)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		door_right.add(new ModelRendererTurbo(door_right, 401, 1, textureX, textureY).addBox(-0.7f, 11, 23, 1, 1, 3)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		door_right.add(new ModelRendererTurbo(door_right, 417, 1, textureX, textureY).addBox(-0.7f, 19, 23, 1, 1, 3)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		door_right.add(new ModelRendererTurbo(door_right, 433, 1, textureX, textureY).addBox(-0.7f, 27, 23, 1, 1, 3)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		door_right.add(new ModelRendererTurbo(door_right, 449, 1, textureX, textureY).addBox(-0.7f, 36, 23, 1, 1, 3)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		door_right.add(new ModelRendererTurbo(door_right, 465, 1, textureX, textureY).addBox(-0.7f, 44, 23, 1, 1, 3)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		this.groups.add(door_right);
		//
		lights = new TurboList("lights");
		lights.add(new ModelRendererTurbo(lights, 497, 9, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-234, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		lights.add(new ModelRendererTurbo(lights, 361, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-222, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		lights.add(new ModelRendererTurbo(lights, 377, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-206, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		lights.add(new ModelRendererTurbo(lights, 393, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-190, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		lights.add(new ModelRendererTurbo(lights, 441, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-174, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		lights.add(new ModelRendererTurbo(lights, 457, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-158, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		lights.add(new ModelRendererTurbo(lights, 473, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-142, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		lights.add(new ModelRendererTurbo(lights, 489, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-126, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		lights.add(new ModelRendererTurbo(lights, 361, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-110, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		lights.add(new ModelRendererTurbo(lights, 377, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-94, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		lights.add(new ModelRendererTurbo(lights, 393, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-78, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		lights.add(new ModelRendererTurbo(lights, 417, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-62, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		lights.add(new ModelRendererTurbo(lights, 433, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-46, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		lights.add(new ModelRendererTurbo(lights, 449, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-30, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		lights.add(new ModelRendererTurbo(lights, 465, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-14, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		lights.add(new ModelRendererTurbo(lights, 481, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(2, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		lights.add(new ModelRendererTurbo(lights, 497, 25, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(14, -73.5f, 25.2f).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		lights.add(new ModelRendererTurbo(lights, 361, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-234, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		lights.add(new ModelRendererTurbo(lights, 377, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-222, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		lights.add(new ModelRendererTurbo(lights, 393, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-206, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		lights.add(new ModelRendererTurbo(lights, 417, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-190, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		lights.add(new ModelRendererTurbo(lights, 433, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-174, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		lights.add(new ModelRendererTurbo(lights, 449, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-158, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		lights.add(new ModelRendererTurbo(lights, 465, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-142, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		lights.add(new ModelRendererTurbo(lights, 481, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-126, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		lights.add(new ModelRendererTurbo(lights, 497, 33, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-110, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		lights.add(new ModelRendererTurbo(lights, 361, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-94, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		lights.add(new ModelRendererTurbo(lights, 377, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-78, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		lights.add(new ModelRendererTurbo(lights, 393, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-62, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		lights.add(new ModelRendererTurbo(lights, 417, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-46, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		lights.add(new ModelRendererTurbo(lights, 433, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-30, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		lights.add(new ModelRendererTurbo(lights, 449, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(-14, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		lights.add(new ModelRendererTurbo(lights, 465, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(2, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		lights.add(new ModelRendererTurbo(lights, 481, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(14, -73.5f, -26.2f).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		lights.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(lights);
		//
		lights_door_left = new TurboList("lights_door_left");
		lights_door_left.add(new ModelRendererTurbo(lights_door_left, 473, 1, textureX, textureY).addBox(-0.7f, 1, -9, 1, 1, 8)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		lights_door_left.add(new ModelRendererTurbo(lights_door_left, 433, 9, textureX, textureY).addBox(-0.7f, 6, -2, 1, 3, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		lights_door_left.add(new ModelRendererTurbo(lights_door_left, 441, 9, textureX, textureY).addBox(-0.7f, 16, -2, 1, 3, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		lights_door_left.add(new ModelRendererTurbo(lights_door_left, 449, 9, textureX, textureY).addBox(-0.7f, 26, -2, 1, 3, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		lights_door_left.add(new ModelRendererTurbo(lights_door_left, 457, 9, textureX, textureY).addBox(-0.7f, 36, -2, 1, 3, 1)
			.setRotationPoint(-235.5f, -72, 25).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		lights_door_left.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(lights_door_left);
		//
		lights_door_right = new TurboList("lights_door_right");
		lights_door_right.add(new ModelRendererTurbo(lights_door_right, 417, 9, textureX, textureY).addBox(-0.7f, 1, 1, 1, 1, 8)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		lights_door_right.add(new ModelRendererTurbo(lights_door_right, 489, 1, textureX, textureY).addBox(-0.7f, 6, 1, 1, 3, 1)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		lights_door_right.add(new ModelRendererTurbo(lights_door_right, 497, 1, textureX, textureY).addBox(-0.7f, 16, 1, 1, 3, 1)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		lights_door_right.add(new ModelRendererTurbo(lights_door_right, 505, 1, textureX, textureY).addBox(-0.7f, 26, 1, 1, 3, 1)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		lights_door_right.add(new ModelRendererTurbo(lights_door_right, 417, 9, textureX, textureY).addBox(-0.7f, 36, 1, 1, 3, 1)
			.setRotationPoint(-235.5f, -72, -25).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		lights_door_right.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(lights_door_right);
	}
    
    @Override
    public void render(VehicleData data, String us){
    	for(TurboList list : groups.values()){ list.render(data, us); }
    }

    @Override
    public void render(VehicleData data, String us, VehicleEntity ent, int meta){
    	chassis_body.render(ent, data);
    	float doortoggle = RenderCache.getData(ent, "tr1_type1_door", 0) + (data.doorsOpen() ? 1 : -1);
    	RenderCache.updateData(ent, "tr1_type1_door", doortoggle = doortoggle > 100 ? 100 : doortoggle < 0 ? 0 : doortoggle);
    	door_left.rotate(0, Static.rad1 * -doortoggle, 0);
    	door_left.render(ent, data);
    	door_left.rotate(0, Static.rad1 * doortoggle, 0);
    	door_right.rotate(0, Static.rad1 * doortoggle, 0);
    	door_right.render(ent, data);
    	door_right.rotate(0, Static.rad1 * -doortoggle, 0);
    	//
        lights.render(ent, data);
    	lights_door_left.rotate(0, Static.rad1 * doortoggle, 0);
    	lights_door_left.render(ent, data);
    	lights_door_left.rotate(0, Static.rad1 * -doortoggle, 0);
    	lights_door_right.rotate(0, Static.rad1 * -doortoggle, 0);
    	lights_door_right.render(ent, data);
    	lights_door_right.rotate(0, Static.rad1 * doortoggle, 0);
    }

}
