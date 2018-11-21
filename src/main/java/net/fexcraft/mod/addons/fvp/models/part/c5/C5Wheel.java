//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c5;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c5_wheel")
public class C5Wheel extends PartModel {

	public C5Wheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel_back_left = new TurboList("wheel_back_left");
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 97, 17, textureX, textureY).addBox(-8, -2, 0, 1, 4, 5)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 481, 25, textureX, textureY).addBox(-2, -8, 0, 4, 1, 5)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 297, 33, textureX, textureY).addBox(-1, -1, 0, 2, 2, 5)
			.setRotationPoint(-26, 2, 18.5f).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 337, 33, textureX, textureY).addBox(-2, 7, 0, 4, 1, 5)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 353, 25, textureX, textureY)
			.addShapeBox(5, 2, 0, 1, 3, 5, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 401, 33, textureX, textureY)
			.addShapeBox(2, -6, 0, 3, 1, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 265, 9, textureX, textureY)
			.addShapeBox(5, -6, 0, 1, 1, 5, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 441, 33, textureX, textureY)
			.addShapeBox(-5, -8, 0, 3, 1, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 313, 33, textureX, textureY)
			.addShapeBox(-8, -5, 0, 1, 3, 5, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 281, 9, textureX, textureY)
			.addShapeBox(-6, -6, 0, 1, 1, 5, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 481, 33, textureX, textureY)
			.addShapeBox(7, -5, 0, 1, 3, 5, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 177, 41, textureX, textureY)
			.addShapeBox(2, 5, 0, 3, 1, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 185, 17, textureX, textureY)
			.addShapeBox(5, 5, 0, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 201, 41, textureX, textureY)
			.addShapeBox(-5, 7, 0, 3, 1, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 497, 33, textureX, textureY)
			.addShapeBox(-8, 2, 0, 1, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 233, 41, textureX, textureY)
			.addShapeBox(-6, 5, 0, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 249, 41, textureX, textureY).addBox(7, -2, 0, 1, 4, 5)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 465, 25, textureX, textureY).addBox(-1, -7, 2, 2, 6, 2)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 81, 25, textureX, textureY).addBox(-7, -1, 2, 6, 2, 2)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 265, 41, textureX, textureY).addBox(-1, 1, 2, 2, 6, 2)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 57, 41, textureX, textureY).addBox(1, -1, 2, 6, 2, 2)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 281, 41, textureX, textureY)
			.addShapeBox(-1, -5, 2, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 289, 41, textureX, textureY).addBox(-1.5f, -1.5f, 0, 3, 3, 3)
			.setRotationPoint(-26, 2, 20).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 81, 41, textureX, textureY).addBox(-2, 6, 0, 4, 1, 4)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 121, 41, textureX, textureY)
			.addShapeBox(2, 4, 0, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 305, 41, textureX, textureY)
			.addShapeBox(4, 2, 0, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 337, 41, textureX, textureY).addBox(6, -2, 0, 1, 4, 4)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 353, 41, textureX, textureY)
			.addShapeBox(6, -5, 0, 1, 3, 4, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 137, 41, textureX, textureY)
			.addShapeBox(2, -5, 0, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 401, 41, textureX, textureY).addBox(-2, -7, 0, 4, 1, 4)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 441, 41, textureX, textureY)
			.addShapeBox(-5, -7, 0, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 457, 41, textureX, textureY)
			.addShapeBox(-7, -5, 0, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 49, textureX, textureY).addBox(-7, -2, 0, 1, 4, 4)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 17, 49, textureX, textureY)
			.addShapeBox(-7, 2, 0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 177, 49, textureX, textureY)
			.addShapeBox(-5, 6, 0, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 497, 121, textureX, textureY)
			.addShapeBox(0, -5, 2, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 370")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 505, 121, textureX, textureY)
			.addShapeBox(-1, 0, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 371")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 372")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 9, 129, textureX, textureY)
			.addShapeBox(4, 0, 2, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 373")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 17, 129, textureX, textureY)
			.addShapeBox(5, 0, 2, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 374")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 25, 129, textureX, textureY)
			.addShapeBox(5, -5, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 375")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 33, 129, textureX, textureY)
			.addShapeBox(4, -5, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0)
			.setRotationPoint(-26, 2, 19).setRotationAngle(0, 0, 0).setName("Box 376")
		);
		wheel_back_left.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_back_left);
		//
		TurboList wheel_back_right = new TurboList("wheel_back_right");
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 233, 49, textureX, textureY).addBox(-1, -1, -5, 2, 2, 5)
			.setRotationPoint(-26, 2, -18.5f).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 33, 49, textureX, textureY).addBox(-1.5f, -1.5f, -3, 3, 3, 3)
			.setRotationPoint(-26, 2, -20).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 281, 49, textureX, textureY).addBox(-1, -7, -4, 2, 6, 2)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 57, 49, textureX, textureY)
			.addShapeBox(0, -5, -4, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 193, 49, textureX, textureY).addBox(-7, -1, -4, 6, 2, 2)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 297, 49, textureX, textureY).addBox(-1, 1, -4, 2, 6, 2)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 401, 49, textureX, textureY).addBox(1, -1, -4, 6, 2, 2)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 345, 49, textureX, textureY).addBox(-2, 6, -4, 4, 1, 4)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 441, 49, textureX, textureY)
			.addShapeBox(2, 4, -4, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 313, 49, textureX, textureY)
			.addShapeBox(4, 2, -4, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 457, 49, textureX, textureY).addBox(6, -2, -4, 1, 4, 4)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 481, 49, textureX, textureY)
			.addShapeBox(6, -5, -4, 1, 3, 4, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 497, 49, textureX, textureY)
			.addShapeBox(2, -5, -4, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 9, 57, textureX, textureY).addBox(-2, -7, -4, 4, 1, 4)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 57, 57, textureX, textureY)
			.addShapeBox(-5, -7, -4, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 33, 57, textureX, textureY)
			.addShapeBox(-7, -5, -4, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 73, 57, textureX, textureY).addBox(-7, -2, -4, 1, 4, 4)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 89, 57, textureX, textureY)
			.addShapeBox(-7, 2, -4, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 337, 57, textureX, textureY)
			.addShapeBox(-5, 6, -4, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 65, textureX, textureY).addBox(-2, 7, -5, 4, 1, 5)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 25, 65, textureX, textureY)
			.addShapeBox(2, 5, -5, 3, 1, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 489, 41, textureX, textureY)
			.addShapeBox(5, 5, -5, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 257, 49, textureX, textureY)
			.addShapeBox(5, 2, -5, 1, 3, 5, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 417, 49, textureX, textureY).addBox(7, -2, -5, 1, 4, 5)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 57, 65, textureX, textureY)
			.addShapeBox(7, -5, -5, 1, 3, 5, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 81, 65, textureX, textureY)
			.addShapeBox(5, -6, -5, 1, 1, 5, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 121, 65, textureX, textureY)
			.addShapeBox(2, -6, -5, 3, 1, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 145, 65, textureX, textureY).addBox(-2, -8, -5, 4, 1, 5)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 489, 65, textureX, textureY)
			.addShapeBox(-5, -8, -5, 3, 1, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 73, textureX, textureY)
			.addShapeBox(-6, -6, -5, 1, 1, 5, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 17, 73, textureX, textureY)
			.addShapeBox(-8, -5, -5, 1, 3, 5, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 33, 73, textureX, textureY).addBox(-8, -2, -5, 1, 4, 5)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 65, 73, textureX, textureY)
			.addShapeBox(-8, 2, -5, 1, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 81, 73, textureX, textureY)
			.addShapeBox(-6, 5, -5, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 121, 73, textureX, textureY)
			.addShapeBox(-5, 7, -5, 3, 1, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 57, 129, textureX, textureY)
			.addShapeBox(-1, -5, -4, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 378")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 65, 129, textureX, textureY)
			.addShapeBox(-6, 0, -4, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 379")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 73, 129, textureX, textureY)
			.addShapeBox(-5, 0, -4, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 380")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 81, 129, textureX, textureY)
			.addShapeBox(0, 0, -4, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 381")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 89, 129, textureX, textureY)
			.addShapeBox(-1, 0, -4, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 382")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 385, 137, textureX, textureY)
			.addShapeBox(-6, -5, -4, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 383")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 409, 137, textureX, textureY)
			.addShapeBox(-5, -5, -4, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0)
			.setRotationPoint(-26, 2, -19).setRotationAngle(0, 0, 0).setName("Box 384")
		);
		wheel_back_right.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_back_right);
		//
		TurboList wheel_front_left = new TurboList("wheel_front_left");
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 1, textureX, textureY).addBox(-1, -1, 0, 2, 2, 5)
			.setRotationPoint(46, 2, 18.5f).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 1, textureX, textureY)
			.addShapeBox(5, 2, 0, 1, 3, 5, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 329, 1, textureX, textureY)
			.addShapeBox(2, -6, 0, 3, 1, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 353, 1, textureX, textureY)
			.addShapeBox(5, -6, 0, 1, 1, 5, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 369, 1, textureX, textureY)
			.addShapeBox(-5, -8, 0, 3, 1, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 393, 1, textureX, textureY)
			.addShapeBox(-5, 7, 0, 3, 1, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 417, 1, textureX, textureY).addBox(-8, -2, 0, 1, 4, 5)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 433, 1, textureX, textureY)
			.addShapeBox(-6, -6, 0, 1, 1, 5, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 449, 1, textureX, textureY)
			.addShapeBox(7, -5, 0, 1, 3, 5, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 1, textureX, textureY)
			.addShapeBox(2, 5, 0, 3, 1, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 1, textureX, textureY).addBox(-2, -8, 0, 4, 1, 5)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 9, textureX, textureY)
			.addShapeBox(5, 5, 0, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 89, 9, textureX, textureY)
			.addShapeBox(-6, -5, 0, 1, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 129, 9, textureX, textureY)
			.addShapeBox(-8, 2, 0, 1, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 145, 9, textureX, textureY)
			.addShapeBox(-6, 5, 0, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 177, 9, textureX, textureY).addBox(7, -2, 0, 1, 4, 5)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 193, 9, textureX, textureY).addBox(-1, -7, 2, 2, 6, 2)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 209, 9, textureX, textureY).addBox(-7, -1, 2, 6, 2, 2)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 233, 9, textureX, textureY).addBox(-1, 1, 2, 2, 6, 2)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 289, 9, textureX, textureY).addBox(1, -1, 2, 6, 2, 2)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 313, 9, textureX, textureY)
			.addShapeBox(-1, -5, 2, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 321, 9, textureX, textureY).addBox(-1.5f, -1.5f, 0, 3, 3, 3)
			.setRotationPoint(46, 2, 20).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 337, 9, textureX, textureY).addBox(-2, 6, 0, 4, 1, 4)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 361, 9, textureX, textureY)
			.addShapeBox(2, 4, 0, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 377, 9, textureX, textureY)
			.addShapeBox(4, 2, 0, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 393, 9, textureX, textureY).addBox(6, -2, 0, 1, 4, 4)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 409, 9, textureX, textureY)
			.addShapeBox(6, -5, 0, 1, 3, 4, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 433, 9, textureX, textureY)
			.addShapeBox(2, -5, 0, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 9, textureX, textureY).addBox(-2, -7, 0, 4, 1, 4)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 9, textureX, textureY)
			.addShapeBox(-5, -7, 0, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 17, textureX, textureY)
			.addShapeBox(-7, -5, 0, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 17, textureX, textureY).addBox(-7, -2, 0, 1, 4, 4)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 81, 17, textureX, textureY)
			.addShapeBox(-7, 2, 0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 145, 17, textureX, textureY)
			.addShapeBox(-5, 6, 0, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 417, 17, textureX, textureY).addBox(-2, 7, 0, 4, 1, 5)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 473, 97, textureX, textureY)
			.addShapeBox(0, -5, 2, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 356")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 497, 105, textureX, textureY)
			.addShapeBox(-5, -5, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 357")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 505, 105, textureX, textureY)
			.addShapeBox(-1, -5, 2, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 358")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 393, 113, textureX, textureY)
			.addShapeBox(-1, 0, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 359")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 505, 113, textureX, textureY)
			.addShapeBox(0, 0, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 360")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 353, 121, textureX, textureY)
			.addShapeBox(0, 0, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 361")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 361, 121, textureX, textureY)
			.addShapeBox(-1, 0, 2, 1, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0)
			.setRotationPoint(46, 2, 19).setRotationAngle(0, 0, 0).setName("Box 362")
		);
		wheel_front_left.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_front_left);
		//
		TurboList wheel_front_right = new TurboList("wheel_front_right");
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 81, 1, textureX, textureY)
			.addShapeBox(5, 2, -5, 1, 3, 5, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 97, 1, textureX, textureY).addBox(7, -2, -5, 1, 4, 5)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 121, 1, textureX, textureY)
			.addShapeBox(7, -5, -5, 1, 3, 5, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 137, 1, textureX, textureY)
			.addShapeBox(5, -6, -5, 1, 1, 5, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 153, 1, textureX, textureY)
			.addShapeBox(2, -6, -5, 3, 1, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 177, 1, textureX, textureY).addBox(-2, -8, -5, 4, 1, 5)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 201, 1, textureX, textureY)
			.addShapeBox(-5, -8, -5, 3, 1, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 225, 1, textureX, textureY)
			.addShapeBox(-6, -6, -5, 1, 1, 5, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 241, 1, textureX, textureY)
			.addShapeBox(-8, -5, -5, 1, 3, 5, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 257, 1, textureX, textureY).addBox(-8, -2, -5, 1, 4, 5)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 273, 1, textureX, textureY)
			.addShapeBox(-8, 2, -5, 1, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 289, 1, textureX, textureY)
			.addShapeBox(-6, 5, -5, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 305, 1, textureX, textureY)
			.addShapeBox(-5, 7, -5, 3, 1, 5, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 201, 17, textureX, textureY).addBox(-1, -1, -5, 2, 2, 5)
			.setRotationPoint(46, 2, -18.5f).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 217, 17, textureX, textureY).addBox(-1.5f, -1.5f, -3, 3, 3, 3)
			.setRotationPoint(46, 2, -20).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 121, 17, textureX, textureY).addBox(-1, -7, -4, 2, 6, 2)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 241, 17, textureX, textureY).addBox(-7, -1, -4, 6, 2, 2)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 265, 17, textureX, textureY).addBox(-1, 1, -4, 2, 6, 2)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 281, 17, textureX, textureY).addBox(1, -1, -4, 6, 2, 2)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 505, 9, textureX, textureY)
			.addShapeBox(-1, -5, -4, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 305, 17, textureX, textureY).addBox(-2, 6, -4, 4, 1, 4)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 329, 17, textureX, textureY)
			.addShapeBox(2, 6, -4, 3, 1, 4, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 345, 17, textureX, textureY)
			.addShapeBox(4, 2, -4, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 361, 17, textureX, textureY).addBox(6, -2, -4, 1, 4, 4)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 377, 17, textureX, textureY)
			.addShapeBox(6, -5, -4, 1, 3, 4, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 401, 17, textureX, textureY)
			.addShapeBox(2, -5, -4, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 441, 17, textureX, textureY).addBox(-2, -7, -4, 4, 1, 4)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 465, 17, textureX, textureY)
			.addShapeBox(-5, -7, -4, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 481, 17, textureX, textureY)
			.addShapeBox(-7, -5, -4, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 497, 17, textureX, textureY).addBox(-7, -2, -4, 1, 4, 4)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 129, 25, textureX, textureY)
			.addShapeBox(-7, 2, -4, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 25, textureX, textureY)
			.addShapeBox(-5, 6, -4, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 145, 25, textureX, textureY).addBox(-2, 7, -5, 4, 1, 5)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 177, 25, textureX, textureY)
			.addShapeBox(2, 5, -5, 3, 1, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 249, 9, textureX, textureY)
			.addShapeBox(5, 5, -5, 1, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 369, 121, textureX, textureY)
			.addShapeBox(0, -5, -4, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 363")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 393, 121, textureX, textureY)
			.addShapeBox(5, 0, -4, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 364")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 417, 121, textureX, textureY)
			.addShapeBox(4, 0, -4, 1, 5, 2, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 425, 121, textureX, textureY)
			.addShapeBox(-1, -5, -4, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 366")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 433, 121, textureX, textureY)
			.addShapeBox(0, -5, -4, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 367")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 441, 121, textureX, textureY)
			.addShapeBox(-6, 0, -4, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 368")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 449, 121, textureX, textureY)
			.addShapeBox(-5, 0, -4, 1, 5, 2, 0, -5, 0, 0, 5, 0, 0, 5, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, 2, -19).setRotationAngle(0, 0, 0).setName("Box 369")
		);
		wheel_front_right.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_front_right);
		//
	}

}