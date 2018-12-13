//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.vehicle;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/vehicle/containerwagon1")
public class ContainerWagon1 extends VehicleModel {

	public ContainerWagon1(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis = new TurboList("chassis");
		chassis.add(new ModelRendererTurbo(chassis, 0, 8, textureX, textureY).addBox(0, 0, 0, 196, 4, 48)
			.setRotationPoint(-98, -16, -24).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 196, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-98, -16, -27).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 103, textureX, textureY)
			.addShapeBox(0, 0, 0, 196, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-98, -16, 24).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 82, textureX, textureY).addBox(0, 0, 0, 196, 18, 2)
			.setRotationPoint(-98, -34, -27).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 61, textureX, textureY).addBox(0, 0, 0, 196, 18, 2)
			.setRotationPoint(-98, -34, 25).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 205, 129, textureX, textureY).addBox(0, 0, 0, 54, 4, 48)
			.setRotationPoint(-155, -30, -24).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 129, textureX, textureY).addBox(0, 0, 0, 54, 4, 48)
			.setRotationPoint(101, -30, -24).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 363, 111, textureX, textureY).addBox(0, 0, 0, 57, 14, 3)
			.setRotationPoint(-155, -34, -27).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 242, 111, textureX, textureY).addBox(0, 0, 0, 57, 14, 3)
			.setRotationPoint(-155, -34, 24).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 121, 111, textureX, textureY).addBox(0, 0, 0, 57, 14, 3)
			.setRotationPoint(98, -34, -27).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 0, 111, textureX, textureY).addBox(0, 0, 0, 57, 14, 3)
			.setRotationPoint(98, -34, 24).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 397, 80, textureX, textureY).addBox(0, 0, 0, 30, 6, 12)
			.setRotationPoint(-143, -26, -6).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 397, 61, textureX, textureY).addBox(0, 0, 0, 30, 6, 12)
			.setRotationPoint(113, -26, -6).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 326, 200, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 1, -4, 0, 1, -4, 0, -3, 0, 0)
			.setRotationPoint(-101, -26, -25).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 273, 182, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 48, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-101, -30, -24).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 166, 182, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -4, 0, -3, 0, 0, -3, 0, 0, 1, -4, 0)
			.setRotationPoint(98, -26, -25).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 63, 182, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 4, 48, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(98, -30, -24).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 63, 235, textureX, textureY).addBox(0, 0, 0, 2, 14, 54)
			.setRotationPoint(-157, -34, -27).setRotationAngle(0, 0, 0)
		);
		chassis.add(new ModelRendererTurbo(chassis, 379, 211, textureX, textureY).addBox(0, 0, 0, 2, 14, 54)
			.setRotationPoint(155, -34, -27).setRotationAngle(0, 0, 0)
		);
		chassis.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis);
		//
		TurboList front_conn = new TurboList("front_conn");
		front_conn.add(new ModelRendererTurbo(front_conn, 356, 129, textureX, textureY).addBox(0, 0, 0, 4, 16, 54)
			.setRotationPoint(157, -34, -27).setRotationAngle(0, 0, 0)
		);
		front_conn.add(new ModelRendererTurbo(front_conn, 13, 8, textureX, textureY).addBox(0, -2, 0, 2, 4, 4)
			.setRotationPoint(161, -28, -19.5f).setRotationAngle(0, 0, 0)
		);
		front_conn.add(new ModelRendererTurbo(front_conn, 0, 8, textureX, textureY).addBox(0, -2, 0, 2, 4, 4)
			.setRotationPoint(161, -28, 15.5f).setRotationAngle(0, 0, 0)
		);
		front_conn.add(new ModelRendererTurbo(front_conn, 458, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 2, 16, 1, 1, 2)
			.setRotationPoint(163, -28, -17.5f).setRotationAngle(0, 0, 0)
		);
		front_conn.add(new ModelRendererTurbo(front_conn, 441, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 2, 16, 1, 1, 2)
			.setRotationPoint(163, -28, 17.5f).setRotationAngle(0, 0, 0)
		);
		front_conn.add(new ModelRendererTurbo(front_conn, 455, 11, textureX, textureY).addBox(0, 0, 0, 1, 5, 10)
			.setRotationPoint(161, -24.5f, -5).setRotationAngle(0, 0, 0)
		);
		front_conn.add(new ModelRendererTurbo(front_conn, 454, 11, textureX, textureY).addBox(0, 0, 0, 1, 4, 4)
			.setRotationPoint(162, -24, -2).setRotationAngle(0, 0, 0)
		);
		this.groups.add(front_conn);
		TurboList rear_conn = new TurboList("rear_conn");
		rear_conn.add(new ModelRendererTurbo(rear_conn, 0, 182, textureX, textureY).addBox(0, 0, 0, 4, 16, 54)
			.setRotationPoint(-161, -34, -27).setRotationAngle(0, 0, 0)
		);
		rear_conn.add(new ModelRendererTurbo(rear_conn, 441, 11, textureX, textureY).addBox(0, -2, 0, 2, 4, 4)
			.setRotationPoint(-163, -28, -19.5f).setRotationAngle(0, 0, 0)
		);
		rear_conn.add(new ModelRendererTurbo(rear_conn, 26, 8, textureX, textureY).addBox(0, -2, 0, 2, 4, 4)
			.setRotationPoint(-163, -28, 15.5f).setRotationAngle(0, 0, 0)
		);
		rear_conn.add(new ModelRendererTurbo(rear_conn, 492, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 2, 16, 1, 1, 3)
			.setRotationPoint(-165, -28, -17.5f).setRotationAngle(0, 0, 0)
		);
		rear_conn.add(new ModelRendererTurbo(rear_conn, 475, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 2, 16, 1, 1, 3)
			.setRotationPoint(-165, -28, 17.5f).setRotationAngle(0, 0, 0)
		);
		rear_conn.add(new ModelRendererTurbo(rear_conn, 478, 11, textureX, textureY).addBox(0, 0, 0, 1, 5, 10)
			.setRotationPoint(-162, -24.5f, -5).setRotationAngle(0, 0, 0)
		);
		rear_conn.add(new ModelRendererTurbo(rear_conn, 468, 11, textureX, textureY).addBox(0, 0, 0, 1, 4, 4)
			.setRotationPoint(-163, -24, -2).setRotationAngle(0, 0, 0)
		);
		this.groups.add(rear_conn);
		this.translate(0, 8, 0);
		//
		this.gui_scale_x /= 1.5f; this.gui_scale_y /= 1.5f; this.gui_scale_z /= 1.5f;
	}

}
