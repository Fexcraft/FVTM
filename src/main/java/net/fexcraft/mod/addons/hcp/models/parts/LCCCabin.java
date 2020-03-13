//FMT-Marker FVTM-1.4
package net.fexcraft.mod.addons.hcp.models.parts;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.entity.Entity;

/** This file was exported via the FVTM Exporter V1.4 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.0.5 &copy; 2020 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/part/lcc_cabin")
public class LCCCabin extends PartModel {

	public LCCCabin(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList cart_wheels = new TurboList("cart_wheels");
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 355, 100, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(82, -159.8f, -21).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 355, 92, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(82, -159.8f, -15).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 839, 91, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(82, -159.8f, 15).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 809, 87, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(82, -159.8f, 21).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 692, 85, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(43, -159.8f, -21).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 839, 83, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(43, -159.8f, -15).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 197, 78, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(43, -159.8f, 15).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 692, 77, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(43, -159.8f, 21).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 692, 69, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(-46, -159.8f, -21).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 512, 52, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(-46, -159.8f, -15).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 668, 39, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(-46, -159.8f, 15).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 635, 38, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(-46, -159.8f, 21).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 512, 38, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(-85, -159.8f, -21).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 668, 31, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(-85, -159.8f, -15).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 282, 27, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(-85, -159.8f, 15).setRotationAngle(0, 0, 0)
		);
		cart_wheels.add(new ModelRendererTurbo(cart_wheels, 159, 27, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 12, 1, 1, 3, null)
			.setRotationPoint(-85, -159.8f, 21).setRotationAngle(0, 0, 0)
		);
		cart_wheels.addProgram("//TODO");
		this.groups.add(cart_wheels);
		//
		TurboList cart_chassis = new TurboList("cart_chassis");
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 627, 163, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(41, -161, -22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 478, 163, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(41, -161, -16).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 975, 162, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(41, -161, 14).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 478, 158, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(41, -161, 20).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 796, 157, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(84, -161, -22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 1014, 150, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(84, -161, -16).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 661, 150, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(84, -161, 14).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 710, 147, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(84, -161, 20).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 1014, 145, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(-87, -161, -22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 710, 142, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(-87, -161, -16).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 304, 135, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(-87, -161, 14).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 295, 135, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(-87, -161, 20).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 168, 131, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(-44, -161, -22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 487, 118, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(-44, -161, -16).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 478, 118, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(-44, -161, 14).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 503, 115, textureX, textureY).addBox(0.5f, 0, 0, 2, 2, 2)
			.setRotationPoint(-44, -161, 20).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 275, 242, textureX, textureY).addBox(0.5f, 0, 0, 2, 14, 9)
			.setRotationPoint(86, -167, -22.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 252, 242, textureX, textureY).addBox(0.5f, 0, 0, 2, 14, 9)
			.setRotationPoint(86, -167, 13.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 708, 281, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(88, -167, -22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 697, 281, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(88, -167, 14).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 686, 281, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(88, -167, -18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 675, 281, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(88, -167, 18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 135, 237, textureX, textureY).addBox(0.5f, 0, 0, 2, 14, 9)
			.setRotationPoint(-42, -167, -22.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 23, 237, textureX, textureY).addBox(0.5f, 0, 0, 2, 14, 9)
			.setRotationPoint(-42, -167, 13.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 569, 279, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-40, -167, -22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 558, 279, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-40, -167, 14).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 547, 279, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-40, -167, -18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 536, 279, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(-40, -167, 18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 0, 237, textureX, textureY).addBox(0.5f, 0, 0, 2, 14, 9)
			.setRotationPoint(-89, -167, -22.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 410, 234, textureX, textureY).addBox(0.5f, 0, 0, 2, 14, 9)
			.setRotationPoint(-89, -167, 13.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 998, 265, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-90, -167, -22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 33, 261, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-90, -167, 14).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 22, 261, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-90, -167, -18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 11, 261, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-90, -167, 18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 387, 234, textureX, textureY).addBox(0.5f, 0, 0, 2, 14, 9)
			.setRotationPoint(39, -167, -22.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 810, 225, textureX, textureY).addBox(0.5f, 0, 0, 2, 14, 9)
			.setRotationPoint(39, -167, 13.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 0, 261, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(38, -167, -22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 387, 258, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(38, -167, 14).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 429, 255, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(38, -167, -18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 675, 221, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 14, 4, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(38, -167, 18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 512, 69, textureX, textureY).addBox(0.5f, 0, 0, 55, 2, 48)
			.setRotationPoint(35, -169, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 512, 52, textureX, textureY).addBox(0.5f, 0, 0, 55, 1, 12)
			.setRotationPoint(35, -153, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 512, 38, textureX, textureY).addBox(0.5f, 0, 0, 55, 1, 12)
			.setRotationPoint(35, -153, 12).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 159, 41, textureX, textureY).addBox(0.5f, 0, 0, 55, 2, 48)
			.setRotationPoint(-91, -169, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 159, 27, textureX, textureY).addBox(0.5f, 0, 0, 55, 1, 12)
			.setRotationPoint(-91, -153, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 512, 24, textureX, textureY).addBox(0.5f, 0, 0, 55, 1, 12)
			.setRotationPoint(-91, -153, 12).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 0, 27, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 55, 2, 48, 0, 0, 0, -1, -1, 0, -1, -1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -171, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 816, 21, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 55, 2, 48, 0, -1, 0, -1, 0, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-91, -171, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 534, 21, textureX, textureY).addBox(0.5f, 0, 0, 71, 1, 1)
			.setRotationPoint(-36, -153, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 389, 21, textureX, textureY).addBox(0.5f, 0, 0, 71, 1, 1)
			.setRotationPoint(-36, -153, 23).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 49, 628, textureX, textureY).addBox(0.5f, 0, 0, 1, 1, 46)
			.setRotationPoint(-36, -153, -23).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 0, 626, textureX, textureY).addBox(0.5f, 0, 0, 1, 1, 46)
			.setRotationPoint(34, -153, -23).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 164, 597, textureX, textureY).addBox(0.5f, 0, 0, 2, 18, 48)
			.setRotationPoint(33, -171, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 778, 592, textureX, textureY).addBox(0.5f, 0, 0, 2, 18, 48)
			.setRotationPoint(-36, -171, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 345, 24, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 59, 2, 48, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-30, -181, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 762, 193, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 2, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 6, 0, 0, 6, 0, 0, -6, 0, 0)
			.setRotationPoint(27, -179, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 879, 162, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 2, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 6, 0, 0, 6, 0, 0, -6, 0, 0)
			.setRotationPoint(27, -179, 22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 1014, 134, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 2, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, -6, 0, 0, 6, 0, 0)
			.setRotationPoint(-30, -179, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 710, 131, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 2, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, -6, 0, 0, 6, 0, 0)
			.setRotationPoint(-30, -179, 22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 135, 214, textureX, textureY).addBox(0, 0, 0, 10, 2, 10)
			.setRotationPoint(-5, -158, -5).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 460, 579, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 4, 46, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -169, -23).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 635, 578, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 10, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -8, 0, 0, 0, 0, 0, 0, 0, 0, -8, 0)
			.setRotationPoint(17, -165, -23).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 21, 575, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 4, 46, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-34, -169, -23).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 291, 574, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 10, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -8, 0, 0, -8, 0, 0, 0, 0)
			.setRotationPoint(-34, -165, -23).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 865, 215, textureX, textureY).addBox(0, 0, 0, 6, 3, 6)
			.setRotationPoint(-3, -156, -3).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 801, 225, textureX, textureY).addBox(0.5f, 0, 0, 2, 26, 2)
			.setRotationPoint(12, -179, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 792, 225, textureX, textureY).addBox(0.5f, 0, 0, 2, 26, 2)
			.setRotationPoint(-15, -179, -24).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 625, 173, textureX, textureY).addBox(0.5f, 0, 0, 2, 26, 2)
			.setRotationPoint(12, -179, 22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 492, 139, textureX, textureY).addBox(0.5f, 0, 0, 2, 26, 2)
			.setRotationPoint(-15, -179, 22).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 339, 68, textureX, textureY).addBox(0.5f, 0, 0, 19, 2, 1)
			.setRotationPoint(-34, -171, 22.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 512, 66, textureX, textureY).addBox(0.5f, 0, 0, 19, 2, 1)
			.setRotationPoint(-34, -171, -23.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 975, 64, textureX, textureY).addBox(0.5f, 0, 0, 19, 2, 1)
			.setRotationPoint(14, -171, 22.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 975, 60, textureX, textureY).addBox(0.5f, 0, 0, 19, 2, 1)
			.setRotationPoint(14, -171, -23.5f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 486, 128, textureX, textureY).addBox(-1, -4, 0, 1, 4, 1)
			.setRotationPoint(20, -167, -18).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 405, 128, textureX, textureY).addBox(-1, -4, -1, 1, 4, 1)
			.setRotationPoint(20, -167, -19).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 177, 114, textureX, textureY).addBox(-1, -4, 0, 1, 4, 1)
			.setRotationPoint(20, -167, -16).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 270, 216, textureX, textureY).addBox(0, 0, 0, 1, 2, 8)
			.setRotationPoint(22, -171, -4).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 982, 165, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -171, -6).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 629, 155, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(22, -171, 4).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 668, 24, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 1, 1, 4, null)
			.setRotationPoint(18.5f, -167.25f, 0).setRotationAngle(0, 0, -57)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 991, 0, textureX, textureY).addCylinder(0, 0, 0, 1, 1, 16, 0.9f, 0.9f, 3, null)
			.setRotationPoint(21.85f, -170, 0).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 911, 0, textureX, textureY).addCylinder(0, 0, 0, 1, 1, 16, 0.9f, 0.9f, 3, null)
			.setRotationPoint(21.85f, -170, 2.75f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.add(new ModelRendererTurbo(cart_chassis, 906, 0, textureX, textureY).addCylinder(0, 0, 0, 1, 1, 16, 0.9f, 0.9f, 3, null)
			.setRotationPoint(21.85f, -170, -2.75f).setRotationAngle(0, 0, 0)
		);
		cart_chassis.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(cart_chassis);
		//
		TurboList cart_windows = new TurboList("cart_windows");
		cart_windows.add(new ModelRendererTurbo(cart_windows, 633, 21, textureX, textureY).addBox(0.5f, 0, 0, 69, 1, 46)
			.setRotationPoint(-35, -153, -23).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 221, 620, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 8, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 6, 0, 0, 6, 0, 0, -6, 0, 0)
			.setRotationPoint(27.5f, -179, -22).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 835, 618, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 8, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, -6, 0, 0, -6, 0, 0, 6, 0, 0)
			.setRotationPoint(-29.5f, -179, -22).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 270, 198, textureX, textureY).addBox(0.5f, 0, 0, 19, 16, 1)
			.setRotationPoint(-34, -169, 22.5f).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 0, 184, textureX, textureY).addBox(0.5f, 0, 0, 19, 16, 1)
			.setRotationPoint(-34, -169, -23.5f).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 405, 181, textureX, textureY).addBox(0.5f, 0, 0, 19, 16, 1)
			.setRotationPoint(14, -169, 22.5f).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 723, 177, textureX, textureY).addBox(0.5f, 0, 0, 19, 16, 1)
			.setRotationPoint(14, -169, -23.5f).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 588, 155, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 19, 8, 1, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(14, -179, 22.5f).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 671, 104, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 19, 8, 1, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(14, -179, -23.5f).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 156, 78, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 19, 8, 1, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-34, -179, 22.5f).setRotationAngle(0, 0, 0)
		);
		cart_windows.add(new ModelRendererTurbo(cart_windows, 635, 54, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 19, 8, 1, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-34, -179, -23.5f).setRotationAngle(0, 0, 0)
		);
		cart_windows.addProgram(new DefaultPrograms.Window(0xbbeded));
		this.groups.add(cart_windows);
		//
		TurboList inner_controls = new TurboList("inner_controls");
		inner_controls.add(new ModelRendererTurbo(inner_controls, 554, 97, textureX, textureY).addBox(-1, -4, 0, 1, 4, 1)
			.setRotationPoint(20, -167, 4).setRotationAngle(0, 0, 0)
		);
		inner_controls.add(new ModelRendererTurbo(inner_controls, 935, 72, textureX, textureY).addBox(-1, -4, -1, 1, 4, 1)
			.setRotationPoint(20, -167, -4).setRotationAngle(0, 0, 0)
		);
		inner_controls.add(new ModelRendererTurbo(inner_controls, 175, 134, textureX, textureY).addBox(0, 0, 0, 1, 2, 2)
			.setRotationPoint(19, -168, 19).setRotationAngle(0, 0, 37)
		);
		inner_controls.add(new ModelRendererTurbo(inner_controls, 1016, 72, textureX, textureY).addBox(0, 0, 0, 1, 2, 2)
			.setRotationPoint(19, -168, 15).setRotationAngle(0, 0, 37)
		);
		inner_controls.addProgram(new TurboList.Program(){

			@Override
			public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
				if(ent == null) return;
				list.get(0).rotationAngleZ = -27 + (data.getAttribute("lcc_h").getIntegerValue() * 4.5f);
				list.get(1).rotationAngleZ = -35 + (data.getAttribute("lcc_v").getIntegerValue() * -7);
			}

			@Override
			public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
				//
			}
			
		});
		this.groups.add(inner_controls);
		//
		translate(0, -10 + 112, 0);
	}

}
