//FMT-Marker FVTM-1
package net.fexcraft.mod.addon.hcp.models.container;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/container/medium_fluid")
public class StandardFluidContainer extends ContainerModel {

	public StandardFluidContainer(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis = new TurboList("chassis");
		chassis.add(new ModelRendererTurbo(chassis, 1, 57, textureX, textureY).addBox(0, 0, 0, 1, 42, 1)
			.setRotationPoint(-47.8f, -45, -20).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		chassis.add(new ModelRendererTurbo(chassis, 9, 57, textureX, textureY).addBox(0, 0, 0, 1, 42, 1)
			.setRotationPoint(-47.8f, -45, -12).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		chassis.add(new ModelRendererTurbo(chassis, 97, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-47.8f, -42, -19).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		chassis.add(new ModelRendererTurbo(chassis, 129, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-47.8f, -37, -19).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		chassis.add(new ModelRendererTurbo(chassis, 385, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-47.8f, -32, -19).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		chassis.add(new ModelRendererTurbo(chassis, 441, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-47.8f, -27, -19).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		chassis.add(new ModelRendererTurbo(chassis, 481, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-47.8f, -22, -19).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		chassis.add(new ModelRendererTurbo(chassis, 441, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-47.8f, -17, -19).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		chassis.add(new ModelRendererTurbo(chassis, 481, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-47.8f, -12, -19).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		chassis.add(new ModelRendererTurbo(chassis, 97, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-47.8f, -7, -19).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		chassis.add(new ModelRendererTurbo(chassis, 233, 57, textureX, textureY).addBox(0, 0, 0, 1, 10, 17)
			.setRotationPoint(-47.8f, -13, 5).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		chassis.add(new ModelRendererTurbo(chassis, 417, 169, textureX, textureY).addBox(0, 0, 0, 1, 10, 17)
			.setRotationPoint(46.8f, -13, -22).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		chassis.add(new ModelRendererTurbo(chassis, 321, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -47.8f, -11).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		chassis.add(new ModelRendererTurbo(chassis, 73, 313, textureX, textureY).addBox(0, 0, -1, 90, 1, 1)
			.setRotationPoint(-45, -47.8f, 11).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		chassis.add(new ModelRendererTurbo(chassis, 321, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-43.5f, -47.5f, -21).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		chassis.add(new ModelRendererTurbo(chassis, 401, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-14, -47.5f, -21).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 313, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(15.5f, -47.5f, -21).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis.add(new ModelRendererTurbo(chassis, 73, 321, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-43.5f, -47.5f, 11).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		chassis.add(new ModelRendererTurbo(chassis, 153, 321, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-14, -47.5f, 11).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		chassis.add(new ModelRendererTurbo(chassis, 321, 321, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(15.5f, -47.5f, 11).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		chassis.add(new ModelRendererTurbo(chassis, 193, 321, textureX, textureY).addBox(0, 0, 0, 6, 1, 42)
			.setRotationPoint(-43, -2, -21).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		chassis.add(new ModelRendererTurbo(chassis, 361, 321, textureX, textureY).addBox(0, 0, 0, 6, 1, 42)
			.setRotationPoint(37, -2, -21).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 329, textureX, textureY).addBox(0, 0, 0, 6, 1, 42)
			.setRotationPoint(27, -2, -21).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis.add(new ModelRendererTurbo(chassis, 33, 337, textureX, textureY).addBox(0, 0, 0, 6, 1, 42)
			.setRotationPoint(-33, -2, -21).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis.add(new ModelRendererTurbo(chassis, 137, 337, textureX, textureY).addBox(0, 0, 0, 6, 1, 42)
			.setRotationPoint(-23, -2, -21).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		chassis.add(new ModelRendererTurbo(chassis, 305, 337, textureX, textureY).addBox(0, 0, 0, 6, 1, 42)
			.setRotationPoint(17, -2, -21).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 33, textureX, textureY).addBox(0, 0, 0, 16, 16, 1)
			.setRotationPoint(28, -45, 22.5f).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		chassis.add(new ModelRendererTurbo(chassis, 385, 25, textureX, textureY).addBox(0, 0, 0, 8, 8, 1)
			.setRotationPoint(28, -11, 22.5f).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis.add(new ModelRendererTurbo(chassis, 17, 57, textureX, textureY).addBox(0, 0, 0, 1, 42, 1)
			.setRotationPoint(29, -45, 22).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis.add(new ModelRendererTurbo(chassis, 129, 33, textureX, textureY).addBox(0, 0, 0, 8, 8, 1)
			.setRotationPoint(36, -11, 22.5f).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		chassis.add(new ModelRendererTurbo(chassis, 25, 57, textureX, textureY).addBox(0, 0, 0, 1, 42, 1)
			.setRotationPoint(42, -45, 22).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		chassis.add(new ModelRendererTurbo(chassis, 473, 97, textureX, textureY).addBox(0, 0, 0, 16, 16, 1)
			.setRotationPoint(-44, -45, -23.5f).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		chassis.add(new ModelRendererTurbo(chassis, 153, 33, textureX, textureY).addBox(0, 0, 0, 8, 8, 1)
			.setRotationPoint(-44, -11, -23.5f).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis.add(new ModelRendererTurbo(chassis, 185, 33, textureX, textureY).addBox(0, 0, 0, 8, 8, 1)
			.setRotationPoint(-36, -11, -23.5f).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		chassis.add(new ModelRendererTurbo(chassis, 33, 57, textureX, textureY).addBox(0, 0, 0, 1, 42, 1)
			.setRotationPoint(-30, -45, -23).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 185, textureX, textureY).addBox(0, 0, 0, 1, 42, 1)
			.setRotationPoint(-43, -45, -23).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		this.groups.add(chassis);
		//
		TurboList in_out = new TurboList("in_out");
		in_out.add(new ModelRendererTurbo(in_out, 1, 1, textureX, textureY).addBox(-2, 0, -2, 4, 48, 4)
			.setRotationPoint(0, -48, 0).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		in_out.add(new ModelRendererTurbo(in_out, 129, 289, textureX, textureY).addBox(0, 0, 0, 32, 4, 16)
			.setRotationPoint(-16, -47.5f, -8).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		in_out.add(new ModelRendererTurbo(in_out, 233, 289, textureX, textureY).addBox(0, 0, 0, 32, 4, 16)
			.setRotationPoint(-16, -4.5f, -8).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		in_out.add(new ModelRendererTurbo(in_out, 489, 41, textureX, textureY).addBox(-2, 0, -2, 4, 48, 4)
			.setRotationPoint(8, -48, 0).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		in_out.add(new ModelRendererTurbo(in_out, 489, 129, textureX, textureY).addBox(-2, 0, -2, 4, 48, 4)
			.setRotationPoint(-8, -48, 0).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		this.groups.add(in_out);
		//
		TurboList primary = new TurboList("primary");
		primary.add(new ModelRendererTurbo(primary, 1, 57, textureX, textureY).addBox(0, 0, 0, 90, 4, 44)
			.setRotationPoint(-45, -26, -22).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		primary.add(new ModelRendererTurbo(primary, 273, 65, textureX, textureY).addBox(0, 0, 0, 90, 44, 4)
			.setRotationPoint(-45, -46, -2).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 20, 10, 0, 0, 0, 0, 0, 0, 0, 0, -2, -2, 0, -2, -2, 0, 0, 0, 0, 0, 0, 0, -14, 4, 0, -14, 4)
			.setRotationPoint(-45, -46, 2).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		primary.add(new ModelRendererTurbo(primary, 209, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 10, 20, 0, 0, 4, -14, 0, 4, -14, 0, -2, -2, 0, -2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -36, 2).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 20, 10, 0, 0, -2, -2, 0, -2, -2, 0, 0, 0, 0, 0, 0, 0, -14, 4, 0, -14, 4, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -46, -12).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		primary.add(new ModelRendererTurbo(primary, 209, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 10, 20, 0, 0, -2, -2, 0, -2, -2, 0, 4, -14, 0, 4, -14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -36, -22).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 20, 10, 0, 0, 0, 0, 0, 0, 0, 0, -14, 4, 0, -14, 4, 0, 0, 0, 0, 0, 0, 0, -2, -2, 0, -2, -2)
			.setRotationPoint(-45, -22, 2).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		primary.add(new ModelRendererTurbo(primary, 209, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 10, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, -14, 0, 4, -14, 0, -2, -2, 0, -2, -2)
			.setRotationPoint(-45, -22, 2).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 20, 10, 0, 0, -14, 4, 0, -14, 4, 0, 0, 0, 0, 0, 0, 0, -2, -2, 0, -2, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -22, -12).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		primary.add(new ModelRendererTurbo(primary, 209, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 90, 10, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, -2, 0, -2, -2, 0, 4, -14, 0, 4, -14)
			.setRotationPoint(-45, -22, -22).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		primary.add(new ModelRendererTurbo(primary, 97, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0.5f, -1, -8, 0, 0, -8, 0, 0, -8, 0.5f, -1, -8, 0.5f, 0.5f, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0.5f, -1)
			.setRotationPoint(-47, -46, -10).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		primary.add(new ModelRendererTurbo(primary, 441, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 32, 0, 0.5f, -0.5f, -7, 0, 0, -6, 0, 0, -6, 0.5f, -0.5f, -7, 0.5f, 0, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0, -1)
			.setRotationPoint(-47, -44, -16).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		primary.add(new ModelRendererTurbo(primary, 433, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 32, 0, 0.5f, 0, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0, -1, 0.5f, -0.5f, -7, 0, 0, -6, 0, 0, -6, 0.5f, -0.5f, -7)
			.setRotationPoint(-47, -8, -16).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0.5f, 0.5f, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0.5f, -1, 0.5f, -1, -8, 0, 0, -8, 0, 0, -8, 0.5f, -1, -8)
			.setRotationPoint(-47, -4, -10).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		primary.add(new ModelRendererTurbo(primary, 417, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 32, 0, 0.5f, 0, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0, -1, 0.5f, -0.5f, -7, 0, 0, -6, 0, 0, -6, 0.5f, -0.5f, -7)
			.setRotationPoint(-47, -40, -16).setRotationAngle(-90f, 0, 0).setName("Box 28")
		);
		primary.add(new ModelRendererTurbo(primary, 433, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 32, 0, 0.5f, -0.5f, -7, 0, 0, -6, 0, 0, -6, 0.5f, -0.5f, -7, 0.5f, 0, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0, -1)
			.setRotationPoint(-47, -40, 20).setRotationAngle(-90f, 0, 0).setName("Box 29")
		);
		primary.add(new ModelRendererTurbo(primary, 129, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0.5f, -1, -8, 0, 0, -8, 0, 0, -8, 0.5f, -1, -8, 0.5f, 0.5f, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0.5f, -1)
			.setRotationPoint(-47, -14, -22).setRotationAngle(90f, 0, 0).setName("Box 30")
		);
		primary.add(new ModelRendererTurbo(primary, 97, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0.5f, 0.5f, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0.5f, -1, 0.5f, -1, -8, 0, 0, -8, 0, 0, -8, 0.5f, -1, -8)
			.setRotationPoint(-47, -14, 20).setRotationAngle(90f, 0, 0).setName("Box 31")
		);
		primary.add(new ModelRendererTurbo(primary, 433, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 32, 0, 0.5f, 0, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0, -1, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0)
			.setRotationPoint(-47, -40, -16).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 32, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0, -1)
			.setRotationPoint(-47, -9, -16).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		primary.add(new ModelRendererTurbo(primary, 73, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 30, 32, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0)
			.setRotationPoint(-47, -39, -16).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0, 0, -8, 0.5f, -1, -8, 0.5f, -1, -8, 0, 0, -8, 0, 0, 0, 0.5f, 0.5f, -1, 0.5f, 0.5f, -1, 0, 0, 0)
			.setRotationPoint(45, -46, -10).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		primary.add(new ModelRendererTurbo(primary, 145, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 32, 0, 0, 0, -6, 0.5f, -0.5f, -7, 0.5f, -0.5f, -7, 0, 0, -6, 0, 0, 0, 0.5f, 0, -1, 0.5f, 0, -1, 0, 0, 0)
			.setRotationPoint(45, -44, -16).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		primary.add(new ModelRendererTurbo(primary, 217, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0, 0, 0, 0.5f, 0.5f, -1, 0.5f, 0.5f, -1, 0, 0, 0, 0, 0, -8, 0.5f, -1, -8, 0.5f, -1, -8, 0, 0, -8)
			.setRotationPoint(45, -4, -10).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		primary.add(new ModelRendererTurbo(primary, 185, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 32, 0, 0, 0, 0, 0.5f, 0, -1, 0.5f, 0, -1, 0, 0, 0, 0, 0, -6, 0.5f, -0.5f, -7, 0.5f, -0.5f, -7, 0, 0, -6)
			.setRotationPoint(45, -8, -16).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		primary.add(new ModelRendererTurbo(primary, 265, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0, 0, -8, 0.5f, -1, -8, 0.5f, -1, -8, 0, 0, -8, 0, 0, 0, 0.5f, 0.5f, -1, 0.5f, 0.5f, -1, 0, 0, 0)
			.setRotationPoint(45, -14, -22).setRotationAngle(90f, 0, 0).setName("Box 39")
		);
		primary.add(new ModelRendererTurbo(primary, 257, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 32, 0, 0, 0, 0, 0.5f, 0, -1, 0.5f, 0, -1, 0, 0, 0, 0, 0, -6, 0.5f, -0.5f, -7, 0.5f, -0.5f, -7, 0, 0, -6)
			.setRotationPoint(45, -40, -16).setRotationAngle(-90f, 0, 0).setName("Box 40")
		);
		primary.add(new ModelRendererTurbo(primary, 297, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 20, 0, 0, 0, 0, 0.5f, 0.5f, -1, 0.5f, 0.5f, -1, 0, 0, 0, 0, 0, -8, 0.5f, -1, -8, 0.5f, -1, -8, 0, 0, -8)
			.setRotationPoint(45, -14, 20).setRotationAngle(90f, 0, 0).setName("Box 41")
		);
		primary.add(new ModelRendererTurbo(primary, 329, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 32, 0, 0, 0, -6, 0.5f, -0.5f, -7, 0.5f, -0.5f, -7, 0, 0, -6, 0, 0, 0, 0.5f, 0, -1, 0.5f, 0, -1, 0, 0, 0)
			.setRotationPoint(45, -40, 20).setRotationAngle(-90f, 0, 0).setName("Box 42")
		);
		primary.add(new ModelRendererTurbo(primary, 401, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 32, 0, 0, 0, 0, 0.5f, 0, -1, 0.5f, 0, -1, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -40, -16).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		primary.add(new ModelRendererTurbo(primary, 441, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 32, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, -1, 0.5f, 0, -1, 0, 0, 0)
			.setRotationPoint(45, -9, -16).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 281, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 30, 32, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -39, -16).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(primary);
		//
		TurboList secondary = new TurboList("secondary");
		secondary.add(new ModelRendererTurbo(secondary, 25, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 48)
			.setRotationPoint(-48, -3, -24).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		secondary.add(new ModelRendererTurbo(secondary, 129, 1, textureX, textureY).addBox(-3, 0, 0, 3, 3, 48)
			.setRotationPoint(48, -3, -24).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		secondary.add(new ModelRendererTurbo(secondary, 185, 1, textureX, textureY).addBox(0, 0, 0, 90, 3, 3)
			.setRotationPoint(-45, -3, 21).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		secondary.add(new ModelRendererTurbo(secondary, 185, 9, textureX, textureY).addBox(0, 0, 0, 90, 3, 3)
			.setRotationPoint(-45, -3, -24).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		secondary.add(new ModelRendererTurbo(secondary, 329, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 48)
			.setRotationPoint(-48, -48, -24).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		secondary.add(new ModelRendererTurbo(secondary, 385, 9, textureX, textureY).addBox(-3, 0, 0, 3, 3, 48)
			.setRotationPoint(48, -48, -24).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		secondary.add(new ModelRendererTurbo(secondary, 185, 17, textureX, textureY).addBox(0, 0, 0, 90, 3, 3)
			.setRotationPoint(-45, -48, 21).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		secondary.add(new ModelRendererTurbo(secondary, 185, 25, textureX, textureY).addBox(0, 0, 0, 90, 3, 3)
			.setRotationPoint(-45, -48, -24).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		secondary.add(new ModelRendererTurbo(secondary, 25, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 42, 3, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-48, -45, 21).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		secondary.add(new ModelRendererTurbo(secondary, 41, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 42, 3, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0)
			.setRotationPoint(-48, -45, -24).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		secondary.add(new ModelRendererTurbo(secondary, 57, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 42, 3, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -45, 21).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		secondary.add(new ModelRendererTurbo(secondary, 81, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 42, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1)
			.setRotationPoint(45, -45, -24).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		secondary.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(secondary);
	}

}