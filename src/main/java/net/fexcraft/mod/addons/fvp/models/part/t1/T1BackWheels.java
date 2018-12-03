//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t1_back_wheels")
public class T1BackWheels extends PartModel {

	public T1BackWheels(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel_back_left = new TurboList("wheel_back_left");
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 249, 145, textureX, textureY).addBox(-8, -3, 0, 16, 6, 2)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 209, 121, textureX, textureY).addBox(-3, 3, 0, 6, 5, 2)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 161, 129, textureX, textureY).addBox(-3, -8, 0, 6, 5, 2)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 233")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 473, 81, textureX, textureY).addBox(-6, 3, 0, 3, 3, 2)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 234")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 89, textureX, textureY).addBox(3, 3, 0, 3, 3, 2)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 235")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 25, 89, textureX, textureY).addBox(-6, -6, 0, 3, 3, 2)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 337, 97, textureX, textureY).addBox(3, -6, 0, 3, 3, 2)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 449, 97, textureX, textureY)
			.addShapeBox(3, 6, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 25, 113, textureX, textureY)
			.addShapeBox(-6, 6, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 465, 25, textureX, textureY)
			.addShapeBox(-8, 3, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 73, 57, textureX, textureY)
			.addShapeBox(6, 3, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 161, 57, textureX, textureY)
			.addShapeBox(-8, -6, 0, 2, 3, 2, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 249, 113, textureX, textureY)
			.addShapeBox(-6, -8, 0, 3, 2, 2, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 361, 57, textureX, textureY)
			.addShapeBox(6, -6, 0, 2, 3, 2, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 281, 113, textureX, textureY)
			.addShapeBox(3, -8, 0, 3, 2, 2, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 209, 97, textureX, textureY)
			.addShapeBox(-10, 3, 0, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 369, 129, textureX, textureY)
			.addShapeBox(-8, 6, 0, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 137, 145, textureX, textureY)
			.addShapeBox(-6, 8, 0, 3, 2, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 153, 137, textureX, textureY).addBox(-10, -3, 0, 2, 6, 6)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 249")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 177, 145, textureX, textureY)
			.addShapeBox(-10, -6, 0, 2, 3, 6, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 345, 145, textureX, textureY)
			.addShapeBox(-8, -8, 0, 2, 2, 6, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 393, 145, textureX, textureY)
			.addShapeBox(-6, -10, 0, 3, 2, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 433, 145, textureX, textureY).addBox(-3, -10, 0, 6, 2, 6)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 41, 153, textureX, textureY)
			.addShapeBox(3, -10, 0, 3, 2, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 369, 145, textureX, textureY)
			.addShapeBox(8, -6, 0, 2, 3, 6, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 255")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 81, 153, textureX, textureY)
			.addShapeBox(6, -8, 0, 2, 2, 6, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 256")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 193, 153, textureX, textureY).addBox(8, -3, 0, 2, 6, 6)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 257")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 105, 153, textureX, textureY).addBox(-3, 8, 0, 6, 2, 6)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 153, 153, textureX, textureY)
			.addShapeBox(8, 3, 0, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 259")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 473, 153, textureX, textureY)
			.addShapeBox(3, 8, 0, 3, 2, 6, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 260")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 409, 153, textureX, textureY)
			.addShapeBox(6, 6, 0, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 16.5f).setRotationAngle(0, 0, 0).setName("Box 261")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 129, 241, textureX, textureY).addBox(7, -3, 1, 1, 6, 4)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 542")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 441, 281, textureX, textureY).addBox(-8, -3, 1, 1, 6, 4)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 543")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 425, 233, textureX, textureY).addBox(-3, -8, 1, 6, 1, 4)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 544")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 473, 257, textureX, textureY).addBox(-3, 7, 1, 6, 1, 4)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 545")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 449, 233, textureX, textureY)
			.addShapeBox(3, 7, 1, 3, 1, 4, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 550")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 105, 241, textureX, textureY)
			.addShapeBox(3, -8, 1, 3, 1, 4, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 551")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 105, 249, textureX, textureY)
			.addShapeBox(-6, -8, 1, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 552")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 225, 273, textureX, textureY)
			.addShapeBox(-6, 7, 1, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 553")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 241, 161, textureX, textureY)
			.addShapeBox(7, 3, 1, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 554")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 385, 217, textureX, textureY)
			.addShapeBox(7, -6, 1, 1, 3, 4, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 555")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 137, 225, textureX, textureY)
			.addShapeBox(-8, -6, 1, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 556")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 33, 233, textureX, textureY)
			.addShapeBox(-8, 3, 1, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 557")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 337, textureX, textureY).addBox(-2, -2, 1, 4, 4, 3)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 566")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 433, 161, textureX, textureY)
			.addShapeBox(-3, -2, 1, 1, 4, 3, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 567")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 41, 169, textureX, textureY)
			.addShapeBox(2, -2, 1, 1, 4, 3, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 568")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 385, 321, textureX, textureY)
			.addShapeBox(-2, -3, 1, 4, 1, 3, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 569")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 401, 321, textureX, textureY)
			.addShapeBox(-2, 2, 1, 4, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 570")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 417, 313, textureX, textureY)
			.addShapeBox(-2, -2, 4, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 577")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 249, 121, textureX, textureY)
			.addShapeBox(-2, -3, 4, 4, 1, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 578")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 465, 121, textureX, textureY)
			.addShapeBox(-2, 2, 4, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1, 0, -1)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 581")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 177, 145, textureX, textureY)
			.addShapeBox(-3, -2, 4, 1, 4, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, -0.5f, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, -0.5f, 0, -1, -1)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 583")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 345, 145, textureX, textureY)
			.addShapeBox(2, -2, 4, 1, 4, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, -1, 0, 0, -0.5f, 0, 0, 0, 0, -1, 0, 0, -1, -1, 0, 0, -0.5f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 584")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 505, 153, textureX, textureY)
			.addShapeBox(-1, -1, 4.5f, 2, 2, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 585")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 497, 105, textureX, textureY)
			.addShapeBox(5, -2, 2, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 593")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 281, 121, textureX, textureY)
			.addShapeBox(5, 1, 2, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 594")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 497, 121, textureX, textureY)
			.addShapeBox(-6, 1, 2, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 595")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 41, 153, textureX, textureY)
			.addShapeBox(-6, -2, 2, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 596")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 81, 153, textureX, textureY)
			.addShapeBox(1, -6, 2, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 597")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 289, 153, textureX, textureY)
			.addShapeBox(-2, -6, 2, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 598")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 473, 153, textureX, textureY)
			.addShapeBox(1, 5, 2, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 599")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 497, 153, textureX, textureY)
			.addShapeBox(-2, 5, 2, 1, 1, 1, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f)
			.setRotationPoint(-71, 0, 17).setRotationAngle(0, 0, 0).setName("Box 600")
		);
		wheel_back_left.addProgram(DefaultPrograms.IMPORTED_WHEEL);
		this.groups.add(wheel_back_left);
		//
		TurboList wheel_back_right = new TurboList("wheel_back_right");
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 473, 169, textureX, textureY).addBox(-8, -3, -2, 16, 6, 2)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 273")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 489, 129, textureX, textureY).addBox(-3, 3, -2, 6, 5, 2)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 274")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 281, 169, textureX, textureY).addBox(-3, -8, -2, 6, 5, 2)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 275")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 465, 113, textureX, textureY).addBox(-6, 3, -2, 3, 3, 2)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 276")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 497, 113, textureX, textureY).addBox(-6, -6, -2, 3, 3, 2)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 277")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 129, textureX, textureY).addBox(3, 3, -2, 3, 3, 2)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 278")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 465, 129, textureX, textureY).addBox(3, -6, -2, 3, 3, 2)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 279")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 193, 145, textureX, textureY)
			.addShapeBox(-6, -8, -2, 3, 2, 2, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 280")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 177, 89, textureX, textureY)
			.addShapeBox(-8, -6, -2, 2, 3, 2, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 281")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 217, 145, textureX, textureY)
			.addShapeBox(3, -8, -2, 3, 2, 2, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 282")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 249, 89, textureX, textureY)
			.addShapeBox(6, -6, -2, 2, 3, 2, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 283")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 49, 97, textureX, textureY)
			.addShapeBox(-8, 3, -2, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 284")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 361, 145, textureX, textureY)
			.addShapeBox(-6, 6, -2, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 285")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 409, 145, textureX, textureY)
			.addShapeBox(3, 6, -2, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 286")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 89, 97, textureX, textureY)
			.addShapeBox(6, 3, -2, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 287")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 321, 169, textureX, textureY).addBox(-3, -10, 0, 6, 2, 6)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 289")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 177, 161, textureX, textureY)
			.addShapeBox(-6, -10, 0, 3, 2, 6, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 121, 169, textureX, textureY)
			.addShapeBox(-8, -8, 0, 2, 2, 6, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 291")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 393, 169, textureX, textureY)
			.addShapeBox(-10, -6, 0, 2, 3, 6, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 292")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 137, 177, textureX, textureY).addBox(-10, -3, 0, 2, 6, 6)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 293")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 177, textureX, textureY)
			.addShapeBox(-10, 3, 0, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 161, 177, textureX, textureY)
			.addShapeBox(-8, 6, 0, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 81, 185, textureX, textureY)
			.addShapeBox(-6, 8, 0, 3, 2, 6, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 201, 185, textureX, textureY).addBox(-3, 8, 0, 6, 2, 6)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 121, 185, textureX, textureY)
			.addShapeBox(3, -10, 0, 3, 2, 6, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 177, 185, textureX, textureY)
			.addShapeBox(6, -8, 0, 2, 2, 6, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 299")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 233, 185, textureX, textureY)
			.addShapeBox(8, -6, 0, 2, 3, 6, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 300")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 257, 185, textureX, textureY).addBox(8, -3, 0, 2, 6, 6)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 301")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 297, 185, textureX, textureY)
			.addShapeBox(8, 3, 0, 2, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 302")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 321, 185, textureX, textureY)
			.addShapeBox(6, 6, 0, 2, 2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 303")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 353, 185, textureX, textureY)
			.addShapeBox(3, 8, 0, 3, 2, 6, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -22.5f).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 353, 313, textureX, textureY).addBox(7, -3, -5, 1, 6, 4)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 546")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 377, 313, textureX, textureY).addBox(-8, -3, -5, 1, 6, 4)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 547")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 393, 313, textureX, textureY).addBox(-3, -8, -5, 6, 1, 4)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 548")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 489, 329, textureX, textureY).addBox(-3, 7, -5, 6, 1, 4)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 549")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 65, 241, textureX, textureY)
			.addShapeBox(7, 3, -5, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 558")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 289, 241, textureX, textureY)
			.addShapeBox(7, -6, -5, 1, 3, 4, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 559")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 137, 249, textureX, textureY)
			.addShapeBox(-8, -6, -5, 1, 3, 4, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 560")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 57, 257, textureX, textureY)
			.addShapeBox(-8, 3, -5, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 561")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 337, 313, textureX, textureY)
			.addShapeBox(3, 7, -5, 3, 1, 4, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 562")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 297, 329, textureX, textureY)
			.addShapeBox(3, -8, -5, 3, 1, 4, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 563")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 321, 329, textureX, textureY)
			.addShapeBox(-6, -8, -5, 3, 1, 4, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 564")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 353, 329, textureX, textureY)
			.addShapeBox(-6, 7, -5, 3, 1, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 565")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 25, 337, textureX, textureY).addBox(-2, -2, -4, 4, 4, 3)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 572")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 441, 321, textureX, textureY)
			.addShapeBox(-2, -3, -4, 4, 1, 3, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 573")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 457, 321, textureX, textureY)
			.addShapeBox(-2, 2, -4, 4, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 574")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 81, 169, textureX, textureY)
			.addShapeBox(-3, -2, -4, 1, 4, 3, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 575")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 105, 169, textureX, textureY)
			.addShapeBox(2, -2, -4, 1, 4, 3, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 576")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 137, textureX, textureY)
			.addShapeBox(-2, -3, -5, 4, 1, 1, 0, -1, 0, -1, -1, 0, -1, -1, 0, 0, -1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 586")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 217, 153, textureX, textureY)
			.addShapeBox(-2, 2, -5, 4, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, -1, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 587")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 297, 337, textureX, textureY)
			.addShapeBox(-2, -2, -5, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 588")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 393, 145, textureX, textureY)
			.addShapeBox(-3, -2, -5, 1, 4, 1, 0, 0, -1, -1, 0, 0, -0.5f, 0, 0, 0, 0, -1, 0, 0, -1, -1, 0, 0, -0.5f, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 589")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 257, 169, textureX, textureY)
			.addShapeBox(-1, -1, -5.5f, 2, 2, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 590")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 433, 145, textureX, textureY)
			.addShapeBox(2, -2, -5, 1, 4, 1, 0, 0, 0, -0.5f, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, -0.5f, 0, -1, -1, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 591")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 177, 161, textureX, textureY)
			.addShapeBox(5, -2, -3, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 601")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 121, 169, textureX, textureY)
			.addShapeBox(5, 1, -3, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 602")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 321, 169, textureX, textureY)
			.addShapeBox(-6, 1, -3, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 603")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 353, 169, textureX, textureY)
			.addShapeBox(-6, -2, -3, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 604")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 377, 169, textureX, textureY)
			.addShapeBox(-2, -6, -3, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 605")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 393, 169, textureX, textureY)
			.addShapeBox(1, -6, -3, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 606")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 177, textureX, textureY)
			.addShapeBox(1, 5, -3, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 607")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 137, 177, textureX, textureY)
			.addShapeBox(-2, 5, -3, 1, 1, 1, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.3f, -0.3f, -0.6f, -0.3f, -0.3f, -0.6f, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-71, 0, -17).setRotationAngle(0, 0, 0).setName("Box 608")
		);
		wheel_back_right.addProgram(DefaultPrograms.IMPORTED_WHEEL);
		this.groups.add(wheel_back_right);
	}

}