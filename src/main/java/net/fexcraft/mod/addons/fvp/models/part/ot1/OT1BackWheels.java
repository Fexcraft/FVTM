//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.ot1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/ot1_back_wheels")
public class OT1BackWheels extends PartModel {

	public OT1BackWheels(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel_back_left = new TurboList("wheel_back_left");
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 305, 73, textureX, textureY).addBox(-2, -8, 0, 4, 16, 1)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 305, 33, textureX, textureY).addBox(2, -2, 0, 6, 4, 1)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 165")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 321, 33, textureX, textureY).addBox(-8, -2, 0, 6, 4, 1)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 166")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 89, 57, textureX, textureY).addBox(-2, -10, 0, 4, 2, 4)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 170")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 385, 57, textureX, textureY).addBox(-2, 8, 0, 4, 2, 4)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 175")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 217, 81, textureX, textureY).addBox(-10, -2, 0, 2, 4, 4)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 176")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 345, 81, textureX, textureY).addBox(8, -2, 0, 2, 4, 4)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 177")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 25, 25, textureX, textureY).addBox(2, -5, 0, 3, 3, 1)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 178")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 113, 33, textureX, textureY).addBox(-5, -5, 0, 3, 3, 1)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 179")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 41, textureX, textureY).addBox(-5, 2, 0, 3, 3, 1)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 180")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 113, 41, textureX, textureY).addBox(2, 2, 0, 3, 3, 1)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 181")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 393, 41, textureX, textureY)
			.addShapeBox(-5, 5, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 481, 41, textureX, textureY)
			.addShapeBox(-5, -8, 0, 3, 3, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 169, 49, textureX, textureY)
			.addShapeBox(2, -8, 0, 3, 3, 1, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 209, 49, textureX, textureY)
			.addShapeBox(2, 5, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 233, 49, textureX, textureY)
			.addShapeBox(-8, -5, 0, 3, 3, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 257, 49, textureX, textureY)
			.addShapeBox(-8, 2, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 281, 49, textureX, textureY)
			.addShapeBox(5, 2, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 188")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 17, 57, textureX, textureY)
			.addShapeBox(5, -5, 0, 3, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 189")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 49, 25, textureX, textureY)
			.addShapeBox(-6, 5, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 65, 25, textureX, textureY)
			.addShapeBox(-6, -6, 0, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 105, 25, textureX, textureY)
			.addShapeBox(5, -6, 0, 1, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 192")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 137, 25, textureX, textureY)
			.addShapeBox(5, 5, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 18).setRotationAngle(0, 0, 0).setName("Box 193")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 361, 57, textureX, textureY)
			.addShapeBox(-10, 2, 0, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 2, 0, 0, 2, 0, 0, -1.5f, 0, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 194")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 105, 73, textureX, textureY)
			.addShapeBox(-10, -5, 0, 2, 3, 4, 0, -1.5f, 0, 0, 2, 0, 0, 2, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 195")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 145, 73, textureX, textureY)
			.addShapeBox(8, -5, 0, 2, 3, 4, 0, 2, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 241, 81, textureX, textureY)
			.addShapeBox(8, 2, 0, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 2, 0, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 89, textureX, textureY)
			.addShapeBox(-8, 5, 0, 3, 3, 4, 0, -2, 0, 0, 0, -1, 0, 0, -1, 0, -2, 0, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0.5f, -3, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 17, 89, textureX, textureY)
			.addShapeBox(-8, -8, 0, 3, 3, 4, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0.5f, -3, 0, -2, 0, 0, 0, -1, 0, 0, -1, 0, -2, 0, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 199")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 313, 89, textureX, textureY)
			.addShapeBox(5, -8, 0, 3, 3, 4, 0, 0, 0.5f, 0, 0.5f, -3, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, -1, 0, -2, 0, 0, -2, 0, 0, 0, -1, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 200")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 361, 89, textureX, textureY)
			.addShapeBox(5, 5, 0, 3, 3, 4, 0, 0, -1, 0, -2, 0, 0, -2, 0, 0, 0, -1, 0, 0, 0.5f, 0, 0.5f, -3, 0, 0.5f, -3, 0, 0, 0.5f, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 65, 57, textureX, textureY)
			.addShapeBox(-5, 8, 0, 3, 2, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 202")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 257, 57, textureX, textureY)
			.addShapeBox(-5, -10, 0, 3, 2, 4, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 281, 57, textureX, textureY)
			.addShapeBox(2, -10, 0, 3, 2, 4, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 305, 57, textureX, textureY)
			.addShapeBox(2, 8, 0, 3, 2, 4, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 17).setRotationAngle(0, 0, 0).setName("Box 205")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 137, 185, textureX, textureY).addBox(-2, -3, 0, 4, 6, 1)
			.setRotationPoint(-53, 0, 19).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 345, 57, textureX, textureY)
			.addShapeBox(2, -3, 0, 1, 6, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, 19).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 65, textureX, textureY)
			.addShapeBox(-3, -3, 0, 1, 6, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-53, 0, 19).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 81, 49, textureX, textureY).addBox(1, -2, 0.2f, 1, 1, 1)
			.setRotationPoint(-53, 0, 19).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 393, 49, textureX, textureY).addBox(-2, -2, 0.2f, 1, 1, 1)
			.setRotationPoint(-53, 0, 19).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 57, textureX, textureY).addBox(-2, 1, 0.2f, 1, 1, 1)
			.setRotationPoint(-53, 0, 19).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 49, 57, textureX, textureY).addBox(1, 1, 0.2f, 1, 1, 1)
			.setRotationPoint(-53, 0, 19).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		wheel_back_left.addProgram(DefaultPrograms.IMPORTED_WHEEL);
		this.groups.add(wheel_back_left);
		//
		TurboList wheel_back_right = new TurboList("wheel_back_right");
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 169, 113, textureX, textureY).addBox(-2, -8, -1, 4, 16, 1)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 377, 89, textureX, textureY).addBox(-8, -2, -1, 6, 4, 1)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 273, 113, textureX, textureY).addBox(2, -2, -1, 6, 4, 1)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 329, 57, textureX, textureY).addBox(2, 2, -1, 3, 3, 1)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 228")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 209, 65, textureX, textureY).addBox(-5, 2, -1, 3, 3, 1)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 229")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 393, 65, textureX, textureY).addBox(-5, -5, -1, 3, 3, 1)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 33, 73, textureX, textureY).addBox(2, -5, -1, 3, 3, 1)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 169, 73, textureX, textureY)
			.addShapeBox(2, 5, -1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 33, 89, textureX, textureY)
			.addShapeBox(2, -8, -1, 3, 3, 1, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 233")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 329, 89, textureX, textureY)
			.addShapeBox(-5, -8, -1, 3, 3, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 234")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 353, 105, textureX, textureY)
			.addShapeBox(-5, 5, -1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 235")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 369, 113, textureX, textureY)
			.addShapeBox(5, 2, -1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 369, 121, textureX, textureY)
			.addShapeBox(5, -5, -1, 3, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 297, 129, textureX, textureY)
			.addShapeBox(-8, -5, -1, 3, 3, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 497, 129, textureX, textureY)
			.addShapeBox(-8, 2, -1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 153, 25, textureX, textureY)
			.addShapeBox(-6, 5, -1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 169, 25, textureX, textureY)
			.addShapeBox(-6, -6, -1, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 249, 25, textureX, textureY)
			.addShapeBox(5, -6, -1, 1, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 273, 25, textureX, textureY)
			.addShapeBox(5, 5, -1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -18).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 65, 137, textureX, textureY).addBox(-2, 8, -4, 4, 2, 4)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 169, 137, textureX, textureY).addBox(-2, -10, -4, 4, 2, 4)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 249, 137, textureX, textureY).addBox(-10, -2, -4, 2, 4, 4)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 473, 137, textureX, textureY).addBox(8, -2, -4, 2, 4, 4)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 497, 121, textureX, textureY)
			.addShapeBox(5, 5, -4, 3, 3, 4, 0, 0, -1, 0, -2, 0, 0, -2, 0, 0, 0, -1, 0, 0, 0.5f, 0, 0.5f, -3, 0, 0.5f, -3, 0, 0, 0.5f, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 281, 137, textureX, textureY)
			.addShapeBox(5, -8, -4, 3, 3, 4, 0, 0, 0.5f, 0, 0.5f, -3, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, -1, 0, -2, 0, 0, -2, 0, 0, 0, -1, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 249")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 297, 137, textureX, textureY)
			.addShapeBox(-8, -8, -4, 3, 3, 4, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0.5f, -3, 0, -2, 0, 0, 0, -1, 0, 0, -1, 0, -2, 0, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 313, 137, textureX, textureY)
			.addShapeBox(-8, 5, -4, 3, 3, 4, 0, -2, 0, 0, 0, -1, 0, 0, -1, 0, -2, 0, 0, 0.5f, -3, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0.5f, -3, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 329, 137, textureX, textureY)
			.addShapeBox(-5, 8, -4, 3, 2, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 345, 137, textureX, textureY)
			.addShapeBox(-5, -10, -4, 3, 2, 4, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 417, 137, textureX, textureY)
			.addShapeBox(2, -10, -4, 3, 2, 4, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 433, 137, textureX, textureY)
			.addShapeBox(2, 8, -4, 3, 2, 4, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 255")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 449, 137, textureX, textureY)
			.addShapeBox(-10, 2, -4, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0, 2, 0, 0, 2, 0, 0, -1.5f, 0, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 256")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 489, 137, textureX, textureY)
			.addShapeBox(-10, -5, -4, 2, 3, 4, 0, -1.5f, 0, 0, 2, 0, 0, 2, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 257")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 65, 145, textureX, textureY)
			.addShapeBox(8, -5, -4, 2, 3, 4, 0, 2, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 161, 145, textureX, textureY)
			.addShapeBox(8, 2, -4, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 2, 0, 0)
			.setRotationPoint(-53, 0, -17).setRotationAngle(0, 0, 0).setName("Box 259")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 153, 185, textureX, textureY).addBox(-2, -3, -1, 4, 6, 1)
			.setRotationPoint(-53, 0, -19).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 129, 73, textureX, textureY)
			.addShapeBox(-3, -3, -1, 1, 6, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-53, 0, -19).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 505, 81, textureX, textureY)
			.addShapeBox(2, -3, -1, 1, 6, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-53, 0, -19).setRotationAngle(0, 0, 0).setName("Box 329")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 137, 57, textureX, textureY).addBox(-2, -2, -1.2f, 1, 1, 1)
			.setRotationPoint(-53, 0, -19).setRotationAngle(0, 0, 0).setName("Box 330")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 17, 65, textureX, textureY).addBox(1, -2, -1.2f, 1, 1, 1)
			.setRotationPoint(-53, 0, -19).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 97, 65, textureX, textureY).addBox(1, 1, -1.2f, 1, 1, 1)
			.setRotationPoint(-53, 0, -19).setRotationAngle(0, 0, 0).setName("Box 332")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 105, 65, textureX, textureY).addBox(-2, 1, -1.2f, 1, 1, 1)
			.setRotationPoint(-53, 0, -19).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		wheel_back_right.addProgram(DefaultPrograms.IMPORTED_WHEEL);
		this.groups.add(wheel_back_right);
	}

}