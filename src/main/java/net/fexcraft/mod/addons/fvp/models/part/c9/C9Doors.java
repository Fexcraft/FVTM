//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.models.GeneralPrograms;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c9_doors")
public class C9Doors extends PartModel {

	public C9Doors(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList door_front_left = new TurboList("door_front_left");
		door_front_left.add(new ModelRendererTurbo(door_front_left, 65, 209, textureX, textureY)
			.addShapeBox(-23.5f, 0, 0, 23, 5, 3, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.7f, 0, 0, -0.7f, 0, -1.2f, 0, 0, -1.2f)
			.setRotationPoint(17, 5, 17.5f).setRotationAngle(0, 0, 0).setName("Box 458")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 409, 209, textureX, textureY)
			.addShapeBox(-23.5f, 0, 0, 23, 6, 3, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -1, 17.5f).setRotationAngle(0, 0, 0).setName("Box 459")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 217, 201, textureX, textureY)
			.addShapeBox(-23.5f, 0, 0, 23, 2, 3, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, -1, 0, 0, -1, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -3, 17.5f).setRotationAngle(0, 0, 0).setName("Box 460")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 121, 217, textureX, textureY)
			.addShapeBox(-23.5f, 0, 0, 23, 1, 2, 0, 0, 0, 0.2f, 0.5f, 0, 0.2f, 0.5f, 0, -1, 0, 0, -1, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -4, 17.5f).setRotationAngle(0, 0, 0).setName("Box 461")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 465, 209, textureX, textureY)
			.addShapeBox(-23.5f, 0, 0, 22, 1, 1, 0, -0.5f, -0.5f, 0.2f, 0, -0.8f, 0.4f, 0, -0.8f, -0.2f, 0, -0.5f, -0.2f, -0.5f, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -5, 17.5f).setRotationAngle(0, 0, 0).setName("Box 462")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 353, 217, textureX, textureY)
			.addShapeBox(-23.5f, -2, 1.8f, 23, 1, 1, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, 3.9f, 17.5f).setRotationAngle(-0.8028515f, 0, 0).setName("Box 465")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 441, 145, textureX, textureY)
			.addShapeBox(-23.7f, -1, -1.7f, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, -0.6f, 0, 0, 0.6f, 0, 0, -0.7f, 0, -1.5f, 0.7f, 0, -1.5f, 0.2f, 0, 1.5f, -0.2f, 0, 1.5f)
			.setRotationPoint(17, -7.5f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 466")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 33, 153, textureX, textureY)
			.addShapeBox(-23.7f, -1, -1.7f, 1, 5, 1, 0, 1, -0.5f, 3.3f, -1, -0.5f, 3.3f, -1.6f, -0.5f, -3.3f, 1.6f, -0.5f, -3.3f, 0, 0, 0, 0, 0, 0, -0.6f, 0, 0, 0.6f, 0, 0)
			.setRotationPoint(17, -12.5f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 467")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 89, 153, textureX, textureY)
			.addShapeBox(-10, -1, -2, 1, 4, 1, 0, -0.7f, 0, 0, 0, 0, 0, 2.1f, 0.1f, 0, -2.1f, 0, 0, -5.3f, 0.3f, -2, 5.3f, 0.3f, -2, 7.7f, 0.3f, 2, -7.7f, 0.3f, 2)
			.setRotationPoint(17, -7.3f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 468")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 177, 153, textureX, textureY)
			.addShapeBox(-14.3f, -1, -5, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, -5, -0.4f, -3, 4.4f, -0.4f, -3, 6.4f, -0.5f, 3, -6.4f, -0.4f, 3)
			.setRotationPoint(17, -11.9f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 469")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 473, 153, textureX, textureY)
			.addShapeBox(-24.5f, -2, -5, 5, 1, 1, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0.5f, 0, -0.8f, 0.5f, 0, 0.7f, 0, 0, 0.7f)
			.setRotationPoint(17, -11, 17.5f).setRotationAngle(0, 0, 0).setName("Box 470")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 105, 161, textureX, textureY)
			.addShapeBox(-19, -2, -5, 5, 1, 1, 0, 0, 0, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.1f, 0, 0, 0, 0, 0, -0.8f, 1.1f, 0, -0.6f, 1.1f, 0, 0.5f, 0, 0, 0.7f)
			.setRotationPoint(17, -11, 17.5f).setRotationAngle(0, 0, 0).setName("Box 471")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 105, 153, textureX, textureY)
			.addShapeBox(-20.5f, -2, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0.4f, 0, 0.2f, 0.4f, 0, 0.2f)
			.setRotationPoint(17, 0, 19.5f).setRotationAngle(0, 0, 0).setName("Box 472")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 289, 161, textureX, textureY)
			.addShapeBox(-12.5f, -2, 0, 3, 1, 1, 0, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, 0, 17).setRotationAngle(0, 0, 0).setName("Box 473")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 401, 217, textureX, textureY)
			.addShapeBox(-4.8f, 0, 3.5f, 1, 2, 3, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0)
			.setRotationPoint(17, -6.5f, 17.5f).setRotationAngle(0, -0.17453294f, 0).setName("Box 555")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 193, 209, textureX, textureY)
			.addShapeBox(-4.9f, 0, 6.5f, 1, 2, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.3f, -0.5f, -0.5f, -0.3f, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, -0.3f, -0.5f, -0.5f, -0.3f, -0.5f)
			.setRotationPoint(17, -6.5f, 17.5f).setRotationAngle(0, -0.17453294f, 0).setName("Box 556")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 217, 209, textureX, textureY)
			.addShapeBox(-4.9f, 0, 2.5f, 1, 2, 1, 0, -0.5f, -0.3f, -0.5f, 0, -0.3f, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, -0.3f, -0.5f, 0, -0.3f, -0.5f, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(17, -6.5f, 17.5f).setRotationAngle(0, -0.17453294f, 0).setName("Box 557")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 225, 209, textureX, textureY)
			.addShapeBox(-3.8f, -5, -1.5f, 1, 5, 1, 0, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f)
			.setRotationPoint(17, -5.5f, 17.5f).setRotationAngle(-1.0471976f, 0, -0.7853982f).setName("Box 558")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 169, 225, textureX, textureY)
			.addShapeBox(-3.8f, 0, 3.5f, 1, 2, 3, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0)
			.setRotationPoint(17, -6.5f, 17.5f).setRotationAngle(0, -0.17453294f, 0).setName("Box 559")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 241, 209, textureX, textureY)
			.addShapeBox(-3.9f, 0, 6.5f, 1, 2, 1, 0, 0, 0, 0, -0.9f, 0, 0, -0.4f, -0.5f, -1, 0, -0.3f, -0.5f, 0, 0, 0, -0.9f, 0, 0, -0.4f, -0.5f, -1, 0, -0.3f, -0.5f)
			.setRotationPoint(17, -6.5f, 17.5f).setRotationAngle(0, -0.17453294f, 0).setName("Box 560")
		);
		door_front_left.add(new ModelRendererTurbo(door_front_left, 345, 209, textureX, textureY)
			.addShapeBox(-3.9f, 0, 2.5f, 1, 2, 1, 0, 0, -0.3f, -0.5f, -0.4f, -0.5f, -1, -0.9f, 0, 0, 0, 0, 0, 0, -0.3f, -0.5f, -0.4f, -0.5f, -1, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -6.5f, 17.5f).setRotationAngle(0, -0.17453294f, 0).setName("Box 561")
		);
		door_front_left.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorFrontLeft(58, 1, true));
		this.groups.add(door_front_left);
		//
		TurboList door_front_right = new TurboList("door_front_right");
		door_front_right.add(new ModelRendererTurbo(door_front_right, 65, 169, textureX, textureY)
			.addShapeBox(-12.5f, -2, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f)
			.setRotationPoint(17, 0, -18).setRotationAngle(0, 0, 0).setName("Box 474")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 1, 225, textureX, textureY)
			.addShapeBox(-23.5f, 0, -1, 23, 6, 3, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -1, -19.5f).setRotationAngle(0, 0, 0).setName("Box 475")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 57, 225, textureX, textureY)
			.addShapeBox(-23.5f, 0, -1, 23, 5, 3, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, -1.2f, -0.7f, 0, -1.2f, -0.7f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, 5, -19.5f).setRotationAngle(0, 0, 0).setName("Box 476")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 113, 225, textureX, textureY)
			.addShapeBox(-23.5f, 0, -1, 23, 2, 3, 0, 0, 0, -1, 0.5f, 0, -1, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -3, -19.5f).setRotationAngle(0, 0, 0).setName("Box 477")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 225, 225, textureX, textureY)
			.addShapeBox(-23.5f, 0, 0, 23, 1, 2, 0, 0, 0, -1, 0.5f, 0, -1, 0.5f, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -4, -19.5f).setRotationAngle(0, 0, 0).setName("Box 478")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 465, 217, textureX, textureY)
			.addShapeBox(-23.5f, 0, 1, 22, 1, 1, 0, 0, -0.5f, -0.2f, 0, -0.8f, -0.2f, 0, -0.8f, 0.4f, -0.5f, -0.5f, 0.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, -0.5f, 0, 0.2f)
			.setRotationPoint(17, -5, -19.5f).setRotationAngle(0, 0, 0).setName("Box 479")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 249, 169, textureX, textureY)
			.addShapeBox(-19.5f, -2, 0, 3, 1, 1, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0.4f, 0, 0.2f, 0.4f, 0, 0.2f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, 0, -20.5f).setRotationAngle(0, 0, 0).setName("Box 480")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 353, 225, textureX, textureY)
			.addShapeBox(-23.5f, 0.4f, -0.55f, 23, 1, 1, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, 3.9f, -19.5f).setRotationAngle(-0.7853982f, 0, 0).setName("Box 481")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 361, 153, textureX, textureY)
			.addShapeBox(-10, -1, 3, 1, 4, 1, 0, -2.1f, 0, 0, 2.1f, 0.1f, 0, 0, 0, 0, -0.7f, 0, 0, -7.7f, 0.3f, 2, 7.7f, 0.3f, 2, 5.3f, 0.3f, -2, -5.3f, 0.3f, -2)
			.setRotationPoint(17, -7.3f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 482")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 409, 153, textureX, textureY)
			.addShapeBox(-14.3f, -1, 6, 1, 5, 1, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, -6.4f, -0.4f, 3, 6.4f, -0.5f, 3, 4.4f, -0.4f, -3, -5, -0.4f, -3)
			.setRotationPoint(17, -11.9f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 483")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 169, 185, textureX, textureY)
			.addShapeBox(-19, -2, 6, 5, 1, 1, 0, 0, 0, 0, 0.5f, -0.1f, -0.1f, 0.5f, -0.1f, 0, 0, 0, 0, 0, 0, 0.7f, 1.1f, 0, 0.5f, 1.1f, 0, -0.6f, 0, 0, -0.8f)
			.setRotationPoint(17, -11, -19.5f).setRotationAngle(0, 0, 0).setName("Box 484")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 185, 185, textureX, textureY)
			.addShapeBox(-24.5f, -2, 6, 5, 1, 1, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0.7f, 0.5f, 0, 0.7f, 0.5f, 0, -0.8f, 0, 0, -0.8f)
			.setRotationPoint(17, -11, -19.5f).setRotationAngle(0, 0, 0).setName("Box 485")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 457, 153, textureX, textureY)
			.addShapeBox(-23.7f, -1, 2.7f, 1, 5, 1, 0, 1.6f, -0.5f, -3.3f, -1.6f, -0.5f, -3.3f, -1, -0.5f, 3.3f, 1, -0.5f, 3.3f, 0.6f, 0, 0, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -12.5f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 486")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 273, 161, textureX, textureY)
			.addShapeBox(-23.7f, -1, 2.7f, 1, 4, 1, 0, 0.6f, 0, 0, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 1.5f, 0.2f, 0, 1.5f, 0.7f, 0, -1.5f, -0.7f, 0, -1.5f)
			.setRotationPoint(17, -7.5f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 487")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 353, 209, textureX, textureY)
			.addShapeBox(-4.4f, 0, -1.5f, 1, 2, 1, 0, 0, 0, 0, -0.9f, 0, 0, -0.4f, -0.5f, -1, 0, -0.3f, -0.5f, 0, 0, 0, -0.9f, 0, 0, -0.4f, -0.5f, -1, 0, -0.3f, -0.5f)
			.setRotationPoint(17, -6.5f, -19.5f).setRotationAngle(0, 0.17453294f, 0).setName("Box 562")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 393, 209, textureX, textureY)
			.addShapeBox(-5.4f, 0, -1.5f, 1, 2, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.3f, -0.5f, -0.5f, -0.3f, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, -0.3f, -0.5f, -0.5f, -0.3f, -0.5f)
			.setRotationPoint(17, -6.5f, -19.5f).setRotationAngle(0, 0.17453294f, 0).setName("Box 563")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 121, 241, textureX, textureY)
			.addShapeBox(-5.3f, 0, -4.5f, 1, 2, 3, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0)
			.setRotationPoint(17, -6.5f, -19.5f).setRotationAngle(0, 0.17453294f, 0).setName("Box 564")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 145, 241, textureX, textureY)
			.addShapeBox(-4.3f, 0, -4.5f, 1, 2, 3, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0)
			.setRotationPoint(17, -6.5f, -19.5f).setRotationAngle(0, 0.17453294f, 0).setName("Box 565")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 401, 209, textureX, textureY)
			.addShapeBox(-5.4f, 0, -5.5f, 1, 2, 1, 0, -0.5f, -0.3f, -0.5f, 0, -0.3f, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, -0.3f, -0.5f, 0, -0.3f, -0.5f, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(17, -6.5f, -19.5f).setRotationAngle(0, 0.17453294f, 0).setName("Box 566")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 49, 217, textureX, textureY)
			.addShapeBox(-4.4f, 0, -5.5f, 1, 2, 1, 0, 0, -0.3f, -0.5f, -0.4f, -0.5f, -1, -0.9f, 0, 0, 0, 0, 0, 0, -0.3f, -0.5f, -0.4f, -0.5f, -1, -0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -6.5f, -19.5f).setRotationAngle(0, 0.17453294f, 0).setName("Box 567")
		);
		door_front_right.add(new ModelRendererTurbo(door_front_right, 185, 225, textureX, textureY)
			.addShapeBox(-3.8f, -3.25f, 1.5f, 1, 5, 1, 0, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f)
			.setRotationPoint(17, -5.5f, -19.5f).setRotationAngle(1.0471976f, 0, -0.7853982f).setName("Box 568")
		);
		door_front_right.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorFrontRight(-58, 1, true));
		this.groups.add(door_front_right);
		//
		TurboList door_rear_left = new TurboList("door_rear_left");
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 281, 225, textureX, textureY)
			.addShapeBox(-14.5f, 0, 0, 16, 5, 3, 0, 0, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, -0.4f, -1.5f, 0, 0, -0.8f, 0, 0, 0, 0, -1.2f, -1.5f, 0, -1.2f)
			.setRotationPoint(-8, 5, 17.5f).setRotationAngle(0, 0, 0).setName("Box 489")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 401, 225, textureX, textureY)
			.addShapeBox(-17.5f, 0, 0, 19, 3, 3, 0, -0.4f, 0, 0, -0.8f, 0, 0, 0, 0, 0, -0.4f, 0, -0.2f, -3, 0, 0, -0.8f, 0, 0, 0, 0, 0, -3, 0, -0.4f)
			.setRotationPoint(-8, 2, 17.5f).setRotationAngle(0, 0, 0).setName("Box 490")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 449, 225, textureX, textureY)
			.addShapeBox(-20.5f, 0, 0, 22, 3, 3, 0, -0.6f, 0, 0, -0.8f, 0, 0, 0, 0, 0, -0.6f, 0, -0.3f, -3.4f, 0, 0, -0.8f, 0, 0, 0, 0, 0, -3.4f, 0, -0.2f)
			.setRotationPoint(-8, -1, 17.5f).setRotationAngle(0, 0, 0).setName("Box 491")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 113, 233, textureX, textureY)
			.addShapeBox(-20.5f, 0, 0, 22, 2, 3, 0, 0.3f, 0, 0, -0.8f, 0, 0, 0, 0, -1, 0.3f, -0.2f, -1, -0.6f, 0, 0, -0.8f, 0, 0, 0, 0, 0, -0.6f, 0, -0.3f)
			.setRotationPoint(-8, -3, 17.5f).setRotationAngle(0, 0, 0).setName("Box 492")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 169, 233, textureX, textureY)
			.addShapeBox(-21.5f, 0, 0, 23, 1, 2, 0, -0.4f, -0.7f, 0, -1, 0, 0.2f, 0, 0, -1, -0.4f, -0.7f, -0.3f, -0.7f, 0.2f, 0, -0.8f, 0, 0, 0, 0, 0, -0.7f, 0.2f, 0)
			.setRotationPoint(-8, -4, 17.5f).setRotationAngle(0, 0, 0).setName("Box 493")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 225, 233, textureX, textureY)
			.addShapeBox(-21.5f, 0, 0, 23, 1, 1, 0, 0.1f, 0, 0.2f, -1, -0.5f, 0.2f, 0, -0.5f, -0.2f, 0.1f, 0, -0.2f, -0.4f, 0.7f, 0, -1, 0, 0.2f, 0, 0, 0, -0.4f, 0.7f, 0.7f)
			.setRotationPoint(-8, -5, 17.5f).setRotationAngle(0, 0, 0).setName("Box 494")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 313, 161, textureX, textureY)
			.addShapeBox(-1, -1, -1.7f, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0.6f, 0, 0, -0.6f, 0, 0, -0.5f, 0, -1.5f, 0.5f, 0, -1.5f, 1.4f, 0, 1.5f, -1.4f, 0, 1.5f)
			.setRotationPoint(-8, -7.5f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 495")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 177, 169, textureX, textureY)
			.addShapeBox(-2, -1, -5, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0.6f, 0, 0, -0.6f, 0, 0, -1, -0.5f, -3.3f, 1, -0.5f, -3.3f, 1.6f, -0.5f, 3.3f, -1.6f, -0.5f, 3.3f)
			.setRotationPoint(-8, -12, 17.5f).setRotationAngle(0, 0, 0).setName("Box 496")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 345, 169, textureX, textureY)
			.addShapeBox(-16, -2, 1.9f, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0.4f, 0, 0.2f, 0.4f, 0, 0.2f)
			.setRotationPoint(-8, 0, 17.5f).setRotationAngle(0, 0, 0).setName("Box 497")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 401, 185, textureX, textureY)
			.addShapeBox(-12, -2, -5, 11, 1, 1, 0, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0.7f, 0, 0, 0.6f)
			.setRotationPoint(-8, -11, 17.5f).setRotationAngle(0, 0, 0).setName("Box 498")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 433, 169, textureX, textureY)
			.addShapeBox(-5.5f, -2, -0.5f, 3, 1, 1, 0, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, 0, 17.5f).setRotationAngle(0, 0, 0).setName("Box 499")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 233, 169, textureX, textureY)
			.addShapeBox(-12, -1, -5, 1, 5, 1, 0, 0.4f, 0, 0, 0.4f, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0.4f, -0.5f, -3.3f, 0.4f, -0.5f, -3.3f, 0, -0.5f, 3.3f, 0, -0.5f, 3.3f)
			.setRotationPoint(-8, -12, 17.5f).setRotationAngle(0, 0, 0).setName("Box 500")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 481, 161, textureX, textureY)
			.addShapeBox(-12, -1, -1.7f, 1, 4, 1, 0, 0.4f, 0, 0, 0.4f, 0, 0, 0, 0, 0, 0, 0, 0, 0.4f, -0.25f, -1.5f, 0.4f, -0.25f, -1.5f, 0, -0.25f, 1.5f, 0, -0.25f, 1.5f)
			.setRotationPoint(-8, -7.5f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 501")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 441, 129, textureX, textureY)
			.addShapeBox(-21, -1, -0.2f, 1, 2, 1, 0, 0, 0, 0.9f, 0, 0, 0.9f, 0, 0, -0.9f, 0, 0, -0.9f, 0.6f, -0.2f, 0, 0.6f, -0.2f, 0, 0.5f, -0.2f, 0, 0.6f, -0.2f, 0)
			.setRotationPoint(-8, -5.8f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 502")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 1, 169, textureX, textureY)
			.addShapeBox(-17.8f, -1, -2.6f, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3.2f, -0.4f, -1.5f, -3.2f, -0.4f, -1.5f, -3.2f, -0.4f, 1.5f, 3.2f, -0.4f, 1.5f)
			.setRotationPoint(-8, -8.4f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 503")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 329, 169, textureX, textureY)
			.addShapeBox(-13, -1, -5.1f, 1, 4, 1, 0, -1, 0, -0.1f, 1, 0, -1, 1, 0, 0, -1, 0, 0, 4.8f, -0.4f, -2.5f, -4.8f, -0.4f, -2.5f, -4.8f, -0.4f, 2.5f, 4.8f, -0.4f, 2.5f)
			.setRotationPoint(-8, -12, 17.5f).setRotationAngle(0, 0, 0).setName("Box 504")
		);
		door_rear_left.add(new ModelRendererTurbo(door_rear_left, 289, 201, textureX, textureY)
			.addShapeBox(-15, -1.9f, 1.9f, 16, 1, 1, 0, 0.4f, -0.3f, 0.3f, 0.5f, 0, 0, 0.5f, 0, 0, -0.2f, -0.3f, -0.3f, -0.2f, 0.3f, 0.3f, 0.5f, 0, 0, 0.5f, 0, 0, -0.6f, 0.3f, -0.3f)
			.setRotationPoint(-8, 3.8f, 17.5f).setRotationAngle(-0.7853982f, 0, 0).setName("Box 509")
		);
		door_rear_left.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorBackLeft(58, 1, true));
		this.groups.add(door_rear_left);
		//
		TurboList door_rear_right = new TurboList("door_rear_right");
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 321, 233, textureX, textureY)
			.addShapeBox(-14.5f, 0, -1, 16, 5, 3, 0, 0, 0, -0.4f, 0, 0, 0, -0.8f, 0, 0, 0, 0, 0, -1.5f, 0, -1.2f, 0, 0, -1.2f, -0.8f, 0, 0, -1.5f, 0, 0)
			.setRotationPoint(-8, 5, -19.5f).setRotationAngle(0, 0, 0).setName("Box 510")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 361, 233, textureX, textureY)
			.addShapeBox(-17.5f, 0, -1, 19, 3, 3, 0, -0.4f, 0, -0.2f, 0, 0, 0, -0.8f, 0, 0, -0.4f, 0, 0, -3, 0, -0.4f, 0, 0, 0, -0.8f, 0, 0, -3, 0, 0)
			.setRotationPoint(-8, 2, -19.5f).setRotationAngle(0, 0, 0).setName("Box 511")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 409, 233, textureX, textureY)
			.addShapeBox(-20.5f, 0, -1, 22, 3, 3, 0, -0.6f, 0, -0.3f, 0, 0, 0, -0.8f, 0, 0, -0.6f, 0, 0, -3.4f, 0, -0.2f, 0, 0, 0, -0.8f, 0, 0, -3.4f, 0, 0)
			.setRotationPoint(-8, -1, -19.5f).setRotationAngle(0, 0, 0).setName("Box 512")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 1, 241, textureX, textureY)
			.addShapeBox(-20.5f, 0, -1, 22, 2, 3, 0, 0.3f, -0.2f, -1, 0, 0, -1, -0.8f, 0, 0, 0.3f, 0, 0, -0.6f, 0, -0.3f, 0, 0, 0, -0.8f, 0, 0, -0.6f, 0, 0)
			.setRotationPoint(-8, -3, -19.5f).setRotationAngle(0, 0, 0).setName("Box 513")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 57, 241, textureX, textureY)
			.addShapeBox(-21.5f, 0, 0, 23, 1, 2, 0, -0.4f, -0.7f, -0.3f, 0, 0, -1, -1, 0, 0.2f, -0.4f, -0.7f, 0, -0.7f, 0.2f, 0, 0, 0, 0, -0.8f, 0, 0, -0.7f, 0.2f, 0)
			.setRotationPoint(-8, -4, -19.5f).setRotationAngle(0, 0, 0).setName("Box 514")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 457, 233, textureX, textureY)
			.addShapeBox(-21.5f, 0, 1, 23, 1, 1, 0, 0.1f, 0, -0.2f, 0, -0.5f, -0.2f, -1, -0.5f, 0.2f, 0.1f, 0, 0.2f, -0.4f, 0.7f, 0.7f, 0, 0, 0, -1, 0, 0.2f, -0.4f, 0.7f, 0)
			.setRotationPoint(-8, -5, -19.5f).setRotationAngle(0, 0, 0).setName("Box 515")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 465, 169, textureX, textureY)
			.addShapeBox(-1, -1, 2.7f, 1, 4, 1, 0, -0.6f, 0, 0, 0.6f, 0, 0, 0, 0, 0, 0, 0, 0, -1.4f, 0, 1.5f, 1.4f, 0, 1.5f, 0.5f, 0, -1.5f, -0.5f, 0, -1.5f)
			.setRotationPoint(-8, -7.5f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 516")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 505, 169, textureX, textureY)
			.addShapeBox(-2, -1, 6, 1, 5, 1, 0, -0.6f, 0, 0, 0.6f, 0, 0, 0, 0, 0, 0, 0, 0, -1.6f, -0.5f, 3.3f, 1.6f, -0.5f, 3.3f, 1, -0.5f, -3.3f, -1, -0.5f, -3.3f)
			.setRotationPoint(-8, -12, -19.5f).setRotationAngle(0, 0, 0).setName("Box 517")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 33, 177, textureX, textureY)
			.addShapeBox(-16, -2, -0.9f, 3, 1, 1, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0.4f, 0, 0.2f, 0.4f, 0, 0.2f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, 0, -19.5f).setRotationAngle(0, 0, 0).setName("Box 518")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 249, 193, textureX, textureY)
			.addShapeBox(-12, -2, 6, 11, 1, 1, 0, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.6f, 0, 0, 0.7f, 0, 0, -0.8f, 0, 0, -0.8f)
			.setRotationPoint(-8, -11, -19.5f).setRotationAngle(0, 0, 0).setName("Box 519")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 65, 177, textureX, textureY)
			.addShapeBox(-12, -1, 6, 1, 5, 1, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0.4f, 0, 0, 0.4f, 0, 0, 0, -0.5f, 3.3f, 0, -0.5f, 3.3f, 0.4f, -0.5f, -3.3f, 0.4f, -0.5f, -3.3f)
			.setRotationPoint(-8, -12, -19.5f).setRotationAngle(0, 0, 0).setName("Box 520")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 489, 177, textureX, textureY)
			.addShapeBox(-12, -1, 2.7f, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0.4f, 0, 0, 0.4f, 0, 0, 0, -0.25f, 1.5f, 0, -0.25f, 1.5f, 0.4f, -0.25f, -1.5f, 0.4f, -0.25f, -1.5f)
			.setRotationPoint(-8, -7.5f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 521")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 9, 137, textureX, textureY)
			.addShapeBox(-21, -1, 1.2f, 1, 2, 1, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0.9f, 0, 0, 0.9f, 0.6f, -0.2f, 0, 0.5f, -0.2f, 0, 0.6f, -0.2f, 0, 0.6f, -0.2f, 0)
			.setRotationPoint(-8, -5.8f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 522")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 505, 177, textureX, textureY)
			.addShapeBox(-17.8f, -1, 3.6f, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3.2f, -0.4f, 1.5f, -3.2f, -0.4f, 1.5f, -3.2f, -0.4f, -1.5f, 3.2f, -0.4f, -1.5f)
			.setRotationPoint(-8, -8.4f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 523")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 457, 185, textureX, textureY)
			.addShapeBox(-13, -1, 6.1f, 1, 4, 1, 0, -1, 0, 0, 1, 0, 0, 1, 0, -1, -1, 0, -0.1f, 4.8f, -0.4f, 2.5f, -4.8f, -0.4f, 2.5f, -4.8f, -0.4f, -2.5f, 4.8f, -0.4f, -2.5f)
			.setRotationPoint(-8, -12, -19.5f).setRotationAngle(0, 0, 0).setName("Box 524")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 121, 209, textureX, textureY)
			.addShapeBox(-15, 0.5f, -0.5f, 16, 1, 1, 0, 0.5f, 0.3f, -0.3f, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0.3f, 0.3f, 0, -0.3f, -0.3f, 0.5f, 0, 0, 0.5f, 0, 0, -0.7f, -0.3f, 0.3f)
			.setRotationPoint(-8, 3.8f, -19.5f).setRotationAngle(-0.7853982f, 0, 0).setName("Box 525")
		);
		door_rear_right.add(new ModelRendererTurbo(door_rear_right, 313, 177, textureX, textureY)
			.addShapeBox(-5.5f, -2, 1.5f, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f)
			.setRotationPoint(-8, 0, -19.5f).setRotationAngle(0, 0, 0).setName("Box 527")
		);
		door_rear_right.addPrograms(DefaultPrograms.RGB_PRIMARY, new GeneralPrograms.CustomMultiDoorBackRight(-58, 1, true));
		this.groups.add(door_rear_right);
	}

}