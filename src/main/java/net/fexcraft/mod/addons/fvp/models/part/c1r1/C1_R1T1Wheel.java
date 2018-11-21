//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c1r1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c1_r1_t1_wheel")
public class C1_R1T1Wheel extends PartModel {

	public C1_R1T1Wheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel_back_left = new TurboList("wheel_back_left");
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 177, 1, textureX, textureY).addBox(-1.5f, -1.5f, -3, 3, 3, 3)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 353, 57, textureX, textureY)
			.addShapeBox(-1, -1, 0, 2, 2, 1, 0, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 278")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 417, 57, textureX, textureY)
			.addShapeBox(-2.5f, -0.5f, -3, 1, 1, 3, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 279")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 433, 57, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -3, 1, 1, 3, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 280")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 449, 57, textureX, textureY)
			.addShapeBox(-0.5f, -2.5f, -3, 1, 1, 3, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 281")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 465, 57, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -3, 1, 1, 3, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 282")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 473, 57, textureX, textureY).addBox(-1.5f, -9.5f, -4.5f, 3, 2, 5)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 283")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 65, textureX, textureY).addBox(-1.5f, 7.5f, -4.5f, 3, 2, 5)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 284")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 497, 57, textureX, textureY).addBox(7.5f, -1.5f, -4.5f, 2, 3, 5)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 285")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 25, 65, textureX, textureY).addBox(-9.5f, -1.5f, -4.5f, 2, 3, 5)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 286")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 41, 65, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, -4.5f, 3, 2, 5, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -2, 1, 0, 1, -1, 0, 1, -1, 0, -2, 1, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 287")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 65, 65, textureX, textureY)
			.addShapeBox(5.2f, -7.2f, -4.5f, 3, 2, 5, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 288")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 89, 65, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, -4.5f, 3, 2, 5, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 289")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 113, 65, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, -4.5f, 3, 2, 5, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 137, 65, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, -4.5f, 3, 2, 5, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 291")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 161, 65, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, -4.5f, 3, 2, 5, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.2f, -1.8f, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 292")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 185, 65, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, -4.5f, 3, 2, 5, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.3f, 1.3f, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 293")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 209, 65, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, -4.5f, 3, 2, 5, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 233, 65, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, -4.5f, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 249, 65, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, -4.5f, 2, 3, 5, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 265, 65, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, -4.5f, 2, 3, 5, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 281, 65, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, -4.5f, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 489, 57, textureX, textureY)
			.addShapeBox(-1.5f, -9.5f, 0.5f, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 299")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 17, 65, textureX, textureY)
			.addShapeBox(-1.5f, 7.5f, 0.5f, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 300")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 57, 65, textureX, textureY)
			.addShapeBox(7.5f, -1.5f, 0.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 301")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 81, 65, textureX, textureY)
			.addShapeBox(-9.5f, -1.5f, 0.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 302")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 105, 65, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, 0.5f, 3, 2, 1, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -2, 1, 0, 1, -1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 303")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 129, 65, textureX, textureY)
			.addShapeBox(3.7f, -6.7f, 0.5f, 3, 2, 1, 0, -2, 1, 0, 1, -1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 153, 65, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, 0.5f, 3, 2, 1, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, 1, -1, 0, -2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 177, 65, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, 0.5f, 3, 2, 1, 0, 1, -1, 0, -2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 201, 65, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, 0.5f, 3, 2, 1, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 225, 65, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, 0.5f, 3, 2, 1, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 308")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 297, 65, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, 0.5f, 3, 2, 1, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 309")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 313, 65, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, 0.5f, 3, 2, 1, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 310")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 329, 65, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, 0.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 311")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 337, 65, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, 0.5f, 2, 3, 1, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 312")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 345, 65, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, 0.5f, 2, 3, 1, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 313")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 353, 65, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, 0.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 314")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 361, 65, textureX, textureY).addBox(-0.5f, 1.5f, -2.5f, 1, 6, 2)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 315")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 369, 65, textureX, textureY).addBox(-0.5f, -7.5f, -2.5f, 1, 6, 2)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 316")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 377, 65, textureX, textureY).addBox(1.5f, -0.5f, -2.5f, 6, 1, 2)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 401, 65, textureX, textureY).addBox(-7.5f, -0.5f, -2.5f, 6, 1, 2)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 318")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 425, 65, textureX, textureY)
			.addShapeBox(-1.5f, -9.5f, -5.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 441, 65, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, -5.5f, 3, 2, 1, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 457, 65, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, -5.5f, 3, 2, 1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -2, 1, 0, 1, -1, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 473, 65, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, -5.5f, 2, 3, 1, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 481, 65, textureX, textureY)
			.addShapeBox(-9.5f, -1.5f, -5.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 489, 65, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, -5.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 1, 73, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, -5.5f, 3, 2, 1, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 17, 73, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, -5.5f, 3, 2, 1, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 41, 73, textureX, textureY)
			.addShapeBox(-1.5f, 7.5f, -5.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 57, 73, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, -5.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 73, 73, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, -5.5f, 3, 2, 1, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, 1, -1, 0, -2, 1, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 329")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 89, 73, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, -5.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 330")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 97, 73, textureX, textureY)
			.addShapeBox(7.5f, -1.5f, -5.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 105, 73, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, -5.5f, 2, 3, 1, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 332")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 113, 73, textureX, textureY)
			.addShapeBox(3.7f, -6.7f, -5.5f, 3, 2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, 1, -1, 0, -2, 1, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 129, 73, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, -5.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 145, 73, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -2.5f, 1, 6, 2, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 335")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 153, 73, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -2.5f, 1, 6, 2, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 336")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 161, 73, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -2.5f, 1, 6, 2, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 337")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 169, 73, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -2.5f, 1, 6, 2, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 177, 73, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -2.5f, 6, 1, 2, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 339")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 201, 73, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -2.5f, 6, 1, 2, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 340")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 297, 73, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -2.5f, 6, 1, 2, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 341")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 321, 73, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -2.5f, 6, 1, 2, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 342")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 225, 73, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 343")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 345, 73, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 344")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 377, 73, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 393, 73, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 346")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 353, 73, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.35f, 0.15f, -0.5f, -1.35f, 0.15f, -0.5f, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.3f, -1, -0.5f, -4.25f, -1.1f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 347")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 409, 73, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -1.35f, 0.15f, -0.5f, 0.35f, 0.15f, -0.5f, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -4.25f, -1.1f, -0.5f, 3.3f, -1, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 348")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 417, 73, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -4.25f, -1.1f, -0.5f, 3.3f, -1, -0.5f, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -1.35f, 0.15f, -0.5f, 0.35f, 0.15f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 349")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 425, 73, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.3f, -1, -0.5f, -4.25f, -1.1f, -0.5f, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.35f, 0.15f, -0.5f, -1.35f, 0.15f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 350")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 433, 73, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.85f, -4.25f, -0.5f, 0.15f, -1.25f, -0.5f, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.05f, 3.15f, -0.5f, 0.3f, 0.15f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 351")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 449, 73, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.05f, 3.15f, -0.5f, 0.3f, 0.15f, -0.5f, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.85f, -4.25f, -0.5f, 0.15f, -1.25f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 352")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 465, 73, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.3f, 0.15f, -0.5f, -1.05f, 3.15f, -0.5f, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.15f, -1.25f, -0.5f, -0.85f, -4.25f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 353")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 481, 73, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.15f, -1.25f, -0.5f, -0.85f, -4.25f, -0.5f, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.3f, 0.15f, -0.5f, -1.05f, 3.15f, -0.5f)
			.setRotationPoint(-43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 354")
		);
		wheel_back_left.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_back_left);
		//
		TurboList wheel_back_right = new TurboList("wheel_back_right");
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 217, 1, textureX, textureY).addBox(-1.5f, -1.5f, 0, 3, 3, 3)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 497, 73, textureX, textureY)
			.addShapeBox(-1, -1, -1, 2, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 355")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 81, textureX, textureY).addBox(-1.5f, 7.5f, -0.5f, 3, 2, 5)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 356")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 25, 81, textureX, textureY).addBox(-1.5f, -9.5f, -0.5f, 3, 2, 5)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 357")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 49, 81, textureX, textureY).addBox(-9.5f, -1.5f, -0.5f, 2, 3, 5)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 358")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 65, 81, textureX, textureY).addBox(7.5f, -1.5f, -0.5f, 2, 3, 5)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 359")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 81, 81, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, -0.5f, 3, 2, 5, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 360")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 105, 81, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, -0.5f, 3, 2, 5, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -2, 1, 0, 1, -1, 0, 1, -1, 0, -2, 1, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 361")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 129, 81, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, -0.5f, 3, 2, 5, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 362")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 177, 81, textureX, textureY)
			.addShapeBox(5.2f, -7.2f, -0.5f, 3, 2, 5, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 363")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 201, 81, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, -0.5f, 3, 2, 5, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 364")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 225, 81, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, -0.5f, 3, 2, 5, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.2f, -1.8f, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 249, 81, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, -0.5f, 3, 2, 5, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.3f, 1.3f, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 366")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 273, 81, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, -0.5f, 3, 2, 5, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 367")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 297, 81, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, -0.5f, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 368")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 313, 81, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, -0.5f, 2, 3, 5, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 369")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 329, 81, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, -0.5f, 2, 3, 5, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 370")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 345, 81, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, -0.5f, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 371")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 17, 81, textureX, textureY)
			.addShapeBox(-1.5f, -9.5f, -1.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 372")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 41, 81, textureX, textureY)
			.addShapeBox(-1.5f, 7.5f, -1.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 373")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 505, 73, textureX, textureY)
			.addShapeBox(-9.5f, -1.5f, -1.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 374")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 97, 81, textureX, textureY)
			.addShapeBox(7.5f, -1.5f, -1.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 375")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 121, 81, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, -1.5f, 3, 2, 1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -2, 1, 0, 1, -1, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 376")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 193, 81, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, -1.5f, 3, 2, 1, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 377")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 217, 81, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, -1.5f, 3, 2, 1, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, 1, -1, 0, -2, 1, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 378")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 241, 81, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, -1.5f, 3, 2, 1, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 379")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 265, 81, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, -1.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 380")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 289, 81, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, -1.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 381")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 361, 81, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, -1.5f, 3, 2, 1, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 382")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 377, 81, textureX, textureY)
			.addShapeBox(3.7f, -6.7f, -1.5f, 3, 2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, 1, -1, 0, -2, 1, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 383")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 393, 81, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, -1.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 384")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 401, 81, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, -1.5f, 2, 3, 1, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 385")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 409, 81, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, -1.5f, 2, 3, 1, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 386")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 417, 81, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, -1.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 387")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 425, 81, textureX, textureY)
			.addShapeBox(-1.5f, -9.5f, 4.5f, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 388")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 441, 81, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, 4.5f, 3, 2, 1, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 389")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 457, 81, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, 4.5f, 3, 2, 1, 0, 1, -1, 0, -2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 390")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 473, 81, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, 4.5f, 2, 3, 1, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 481, 81, textureX, textureY)
			.addShapeBox(-9.5f, -1.5f, 4.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 392")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 489, 81, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, 4.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 497, 81, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, 4.5f, 3, 2, 1, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, 1, -1, 0, -2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 394")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 89, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, 4.5f, 3, 2, 1, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 17, 89, textureX, textureY)
			.addShapeBox(-1.5f, 7.5f, 4.5f, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 33, 89, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, 4.5f, 3, 2, 1, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 397")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 81, 89, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, 4.5f, 3, 2, 1, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -2, 1, 0, 1, -1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 398")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 97, 89, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, 4.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 399")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 105, 89, textureX, textureY)
			.addShapeBox(7.5f, -1.5f, 4.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 400")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 113, 89, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, 4.5f, 2, 3, 1, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 401")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 121, 89, textureX, textureY)
			.addShapeBox(3.7f, -6.7f, 4.5f, 3, 2, 1, 0, -2, 1, 0, 1, -1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 402")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 137, 89, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, 4.5f, 3, 2, 1, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 403")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 153, 89, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, 0, 1, 1, 3, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 404")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 169, 89, textureX, textureY)
			.addShapeBox(-2.5f, -0.5f, 0, 1, 1, 3, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 405")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 185, 89, textureX, textureY)
			.addShapeBox(-0.5f, -2.5f, 0, 1, 1, 3, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 406")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 201, 89, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, 0, 1, 1, 3, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 407")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 217, 89, textureX, textureY).addBox(-0.5f, 1.5f, 0.5f, 1, 6, 2)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 408")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 225, 89, textureX, textureY).addBox(-0.5f, -7.5f, 0.5f, 1, 6, 2)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 409")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 233, 89, textureX, textureY).addBox(1.5f, -0.5f, 0.5f, 6, 1, 2)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 410")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 257, 89, textureX, textureY).addBox(-7.5f, -0.5f, 0.5f, 6, 1, 2)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 411")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 281, 89, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, 0.5f, 1, 6, 2, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 412")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 289, 89, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, 0.5f, 1, 6, 2, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 413")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 361, 89, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, 0.5f, 1, 6, 2, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 414")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 369, 89, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, 0.5f, 1, 6, 2, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 415")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 377, 89, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, 0.5f, 6, 1, 2, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 416")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 401, 89, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, 0.5f, 6, 1, 2, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 417")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 425, 89, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, 0.5f, 6, 1, 2, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 418")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 449, 89, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, 0.5f, 6, 1, 2, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 419")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 473, 89, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 420")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 481, 89, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 421")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 489, 89, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 422")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 1, 97, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 423")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 505, 89, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, 0.35f, 0.15f, -0.5f, -1.35f, 0.15f, -0.5f, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 3.3f, -1, -0.5f, -4.25f, -1.1f, -0.5f, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 424")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 17, 97, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, -1.35f, 0.15f, -0.5f, 0.35f, 0.15f, -0.5f, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -4.25f, -1.1f, -0.5f, 3.3f, -1, -0.5f, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 425")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 25, 97, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, -4.25f, -1.1f, -0.5f, 3.3f, -1, -0.5f, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -1.35f, 0.15f, -0.5f, 0.35f, 0.15f, -0.5f, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 426")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 33, 97, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, 3.3f, -1, -0.5f, -4.25f, -1.1f, -0.5f, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 0.35f, 0.15f, -0.5f, -1.35f, 0.15f, -0.5f, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 427")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 41, 97, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, -0.85f, -4.25f, -0.5f, 0.15f, -1.25f, -0.5f, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -1.05f, 3.15f, -0.5f, 0.3f, 0.15f, -0.5f, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 428")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 57, 97, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, -1.05f, 3.15f, -0.5f, 0.3f, 0.15f, -0.5f, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -0.85f, -4.25f, -0.5f, 0.15f, -1.25f, -0.5f, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 429")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 73, 97, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0.3f, 0.15f, -0.5f, -1.05f, 3.15f, -0.5f, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.15f, -1.25f, -0.5f, -0.85f, -4.25f, -0.5f, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 430")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 89, 97, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0.15f, -1.25f, -0.5f, -0.85f, -4.25f, -0.5f, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.3f, 0.15f, -0.5f, -1.05f, 3.15f, -0.5f, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0)
			.setRotationPoint(-43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 431")
		);
		wheel_back_right.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_back_right);
		//
		TurboList wheel_front_left = new TurboList("wheel_front_left");
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 1, textureX, textureY).addBox(-1.5f, -1.5f, -3, 3, 3, 3)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 265, 1, textureX, textureY).addBox(-1.5f, 7.5f, -4.5f, 3, 2, 5)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 305, 1, textureX, textureY).addBox(-1.5f, -9.5f, -4.5f, 3, 2, 5)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 345, 1, textureX, textureY).addBox(7.5f, -1.5f, -4.5f, 2, 3, 5)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 385, 1, textureX, textureY).addBox(-9.5f, -1.5f, -4.5f, 2, 3, 5)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 441, 1, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, -4.5f, 3, 2, 5, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -2, 1, 0, 1, -1, 0, 1, -1, 0, -2, 1, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 1, textureX, textureY)
			.addShapeBox(5.2f, -7.2f, -4.5f, 3, 2, 5, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 1, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, -4.5f, 3, 2, 5, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 9, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, -4.5f, 3, 2, 5, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 25, 9, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, -4.5f, 3, 2, 5, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.2f, -1.8f, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 177, 9, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, -4.5f, 3, 2, 5, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 217, 9, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, -4.5f, 3, 2, 5, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 265, 9, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, -4.5f, 3, 2, 5, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.3f, 1.3f, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 305, 9, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, -4.5f, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 441, 9, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, -4.5f, 2, 3, 5, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 457, 9, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, -4.5f, 2, 3, 5, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 473, 9, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, -4.5f, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 33, 1, textureX, textureY)
			.addShapeBox(-1.5f, 7.5f, 0.5f, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 281, 1, textureX, textureY)
			.addShapeBox(-1.5f, -9.5f, 0.5f, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 361, 1, textureX, textureY)
			.addShapeBox(7.5f, -1.5f, 0.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 401, 1, textureX, textureY)
			.addShapeBox(-9.5f, -1.5f, 0.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 457, 1, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, 0.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 481, 1, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, 0.5f, 3, 2, 1, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -2, 1, 0, 1, -1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 9, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, 0.5f, 3, 2, 1, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 505, 1, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, 0.5f, 2, 3, 1, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 281, 9, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, 0.5f, 2, 3, 1, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 361, 9, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, 0.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 401, 9, textureX, textureY)
			.addShapeBox(3.7f, -6.7f, 0.5f, 3, 2, 1, 0, -2, 1, 0, 1, -1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 9, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, 0.5f, 3, 2, 1, 0, 1, -1, 0, -2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 17, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, 0.5f, 3, 2, 1, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, 1, -1, 0, -2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 17, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, 0.5f, 3, 2, 1, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 33, 17, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, 0.5f, 3, 2, 1, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 265, 17, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, 0.5f, 3, 2, 1, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 281, 17, textureX, textureY)
			.addShapeBox(-1.5f, -9.5f, -5.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 385, 17, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, -5.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 401, 17, textureX, textureY)
			.addShapeBox(3.7f, -6.7f, -5.5f, 3, 2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, 1, -1, 0, -2, 1, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 505, 9, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, -5.5f, 2, 3, 1, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 17, textureX, textureY)
			.addShapeBox(7.5f, -1.5f, -5.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 497, 17, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, -5.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 25, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, -5.5f, 3, 2, 1, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, 1, -1, 0, -2, 1, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 25, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, -5.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 33, 25, textureX, textureY)
			.addShapeBox(-1.5f, 7.5f, -5.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 177, 25, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, -5.5f, 3, 2, 1, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 193, 25, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, -5.5f, 3, 2, 1, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 505, 17, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, -5.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 305, 25, textureX, textureY)
			.addShapeBox(-9.5f, -1.5f, -5.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 313, 25, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, -5.5f, 2, 3, 1, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 209, 25, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, -5.5f, 3, 2, 1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -2, 1, 0, 1, -1, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 225, 25, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, -5.5f, 3, 2, 1, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 321, 25, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -3, 1, 1, 3, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 337, 25, textureX, textureY)
			.addShapeBox(-2.5f, -0.5f, -3, 1, 1, 3, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 353, 25, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -3, 1, 1, 3, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 25, textureX, textureY)
			.addShapeBox(-0.5f, -2.5f, -3, 1, 1, 3, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 481, 25, textureX, textureY).addBox(-0.5f, 1.5f, -2.5f, 1, 6, 2)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 489, 25, textureX, textureY).addBox(-0.5f, -7.5f, -2.5f, 1, 6, 2)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 265, 25, textureX, textureY).addBox(1.5f, -0.5f, -2.5f, 6, 1, 2)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 385, 25, textureX, textureY).addBox(-7.5f, -0.5f, -2.5f, 6, 1, 2)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 441, 25, textureX, textureY)
			.addShapeBox(-1, -1, 0, 2, 2, 1, 0, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 497, 25, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -2.5f, 1, 6, 2, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 505, 25, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -2.5f, 1, 6, 2, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 33, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -2.5f, 1, 6, 2, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 9, 33, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -2.5f, 1, 6, 2, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 17, 33, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -2.5f, 6, 1, 2, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 177, 33, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -2.5f, 6, 1, 2, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 201, 33, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -2.5f, 6, 1, 2, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 225, 33, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -2.5f, 6, 1, 2, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 449, 25, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 417, 33, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 249, 33, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 433, 33, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 441, 33, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.35f, 0.15f, -0.5f, -1.35f, 0.15f, -0.5f, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.3f, -1, -0.5f, -4.25f, -1.1f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 449, 33, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -1.35f, 0.15f, -0.5f, 0.35f, 0.15f, -0.5f, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -4.25f, -1.1f, -0.5f, 3.3f, -1, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 457, 33, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -4.25f, -1.1f, -0.5f, 3.3f, -1, -0.5f, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -1.35f, 0.15f, -0.5f, 0.35f, 0.15f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 465, 33, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.3f, -1, -0.5f, -4.25f, -1.1f, -0.5f, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.35f, 0.15f, -0.5f, -1.35f, 0.15f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 217, 41, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.85f, -4.25f, -0.5f, 0.15f, -1.25f, -0.5f, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.05f, 3.15f, -0.5f, 0.3f, 0.15f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 233, 41, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.05f, 3.15f, -0.5f, 0.3f, 0.15f, -0.5f, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.85f, -4.25f, -0.5f, 0.15f, -1.25f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 249, 41, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.3f, 0.15f, -0.5f, -1.05f, 3.15f, -0.5f, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.15f, -1.25f, -0.5f, -0.85f, -4.25f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 265, 41, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.15f, -1.25f, -0.5f, -0.85f, -4.25f, -0.5f, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.3f, 0.15f, -0.5f, -1.05f, 3.15f, -0.5f)
			.setRotationPoint(43.5f, 0.5f, 20).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		wheel_front_left.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_front_left);
		//
		TurboList wheel_front_right = new TurboList("wheel_front_right");
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 1, textureX, textureY).addBox(-1.5f, -1.5f, 0, 3, 3, 3)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 281, 41, textureX, textureY).addBox(-1.5f, 7.5f, -0.5f, 3, 2, 5)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 305, 41, textureX, textureY).addBox(-1.5f, -9.5f, -0.5f, 3, 2, 5)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 473, 33, textureX, textureY)
			.addShapeBox(-1, -1, -1, 2, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 329, 41, textureX, textureY).addBox(7.5f, -1.5f, -0.5f, 2, 3, 5)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 345, 41, textureX, textureY).addBox(-9.5f, -1.5f, -0.5f, 2, 3, 5)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 361, 41, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, -0.5f, 3, 2, 5, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -2, 1, 0, 1, -1, 0, 1, -1, 0, -2, 1, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 385, 41, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, -0.5f, 3, 2, 5, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 409, 41, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, -0.5f, 2, 3, 5, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 425, 41, textureX, textureY)
			.addShapeBox(5.2f, -7.2f, -0.5f, 3, 2, 5, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 449, 41, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, -0.5f, 3, 2, 5, 0, 1, -1, 0, -2, 1, 0, -2, 1, 0, 1, -1, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 473, 41, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, -0.5f, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 489, 41, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, -0.5f, 2, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 49, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, -0.5f, 2, 3, 5, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 17, 49, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, -0.5f, 3, 2, 5, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.2f, -1.8f, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 41, 49, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, -0.5f, 3, 2, 5, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 65, 49, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, -0.5f, 3, 2, 5, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, 1.2f, -1.8f, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 89, 49, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, -0.5f, 3, 2, 5, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.3f, 1.3f, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 297, 41, textureX, textureY)
			.addShapeBox(-1.5f, 7.5f, -1.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 321, 41, textureX, textureY)
			.addShapeBox(-1.5f, -9.5f, -1.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 377, 41, textureX, textureY)
			.addShapeBox(7.5f, -1.5f, -1.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 401, 41, textureX, textureY)
			.addShapeBox(-9.5f, -1.5f, -1.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 441, 41, textureX, textureY)
			.addShapeBox(3.7f, -6.7f, -1.5f, 3, 2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, 1, -1, 0, -2, 1, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 465, 41, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, -1.5f, 3, 2, 1, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, 1, -1, 0, -2, 1, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 33, 49, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, -1.5f, 3, 2, 1, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -2, 1, 0, 1, -1, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 57, 49, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, -1.5f, 3, 2, 1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -2, 1, 0, 1, -1, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 81, 49, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, -1.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 105, 49, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, -1.5f, 3, 2, 1, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 121, 49, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, -1.5f, 3, 2, 1, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 137, 49, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, -1.5f, 3, 2, 1, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 505, 41, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, -1.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 153, 49, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, -1.5f, 2, 3, 1, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 49, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, -1.5f, 2, 3, 1, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 169, 49, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, -1.5f, 2, 3, 1, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 177, 49, textureX, textureY).addBox(-0.5f, -7.5f, 0.5f, 1, 6, 2)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 185, 49, textureX, textureY).addBox(-0.5f, 1.5f, 0.5f, 1, 6, 2)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 193, 49, textureX, textureY).addBox(-7.5f, -0.5f, 0.5f, 6, 1, 2)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 217, 49, textureX, textureY).addBox(1.5f, -0.5f, 0.5f, 6, 1, 2)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 241, 49, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, 0, 1, 1, 3, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 257, 49, textureX, textureY)
			.addShapeBox(-2.5f, -0.5f, 0, 1, 1, 3, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0, -0.4f, -0.5f, 0, 0, 0.1f, 0, 0, 0.1f, 0, -0.4f, -0.5f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 273, 49, textureX, textureY)
			.addShapeBox(-0.5f, -2.5f, 0, 1, 1, 3, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 289, 49, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, 0, 1, 1, 3, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0, -0.5f, -0.4f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 305, 49, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, 0.5f, 1, 6, 2, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 313, 49, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, 0.5f, 1, 6, 2, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 321, 49, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, 0.5f, 1, 6, 2, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 361, 49, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, 0.5f, 1, 6, 2, 0, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 369, 49, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, 0.5f, 6, 1, 2, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 393, 49, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, 0.5f, 6, 1, 2, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 425, 49, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, 0.5f, 6, 1, 2, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 449, 49, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, 0.5f, 6, 1, 2, 0, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 17, 57, textureX, textureY)
			.addShapeBox(-1.5f, -9.5f, 4.5f, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 33, 57, textureX, textureY)
			.addShapeBox(1.5f, -9.5f, 4.5f, 3, 2, 1, 0, 0, 0, 0, 1.2f, -1.8f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, -0.3f, 1.3f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 49, 57, textureX, textureY)
			.addShapeBox(3.7f, -6.7f, 4.5f, 3, 2, 1, 0, -2, 1, 0, 1, -1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 505, 49, textureX, textureY)
			.addShapeBox(7.5f, -4.5f, 4.5f, 2, 3, 1, 0, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 65, 57, textureX, textureY)
			.addShapeBox(7.5f, -1.5f, 4.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 73, 57, textureX, textureY)
			.addShapeBox(7.5f, 1.5f, 4.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 1.3f, -0.3f, 0, -1.8f, 1.2f, 0, -2, 1.2f, -0.7f, 1.2f, -0.1f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 255")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 81, 57, textureX, textureY)
			.addShapeBox(3.7f, 4.7f, 4.5f, 3, 2, 1, 0, -0.5f, -1.5f, 0, -0.5f, 0.5f, 0, -0.4f, 0.3f, -0.7f, -0.7f, -1.6f, -0.7f, -2, 1, 0, 1, -1, 0, 0.8f, -1, -0.7f, -1.9f, 0.8f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 256")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 97, 57, textureX, textureY)
			.addShapeBox(1.5f, 7.5f, 4.5f, 3, 2, 1, 0, 0, 0, 0, -0.3f, 1.3f, 0, -0.1f, 1.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 1.2f, -1.8f, 0, 1.1f, -2, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 257")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 113, 57, textureX, textureY)
			.addShapeBox(-1.5f, 7.5f, 4.5f, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 129, 57, textureX, textureY)
			.addShapeBox(-4.5f, 7.5f, 4.5f, 3, 2, 1, 0, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 259")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 145, 57, textureX, textureY)
			.addShapeBox(-6.7f, 4.7f, 4.5f, 3, 2, 1, 0, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f, 1, -1, 0, -2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 260")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 161, 57, textureX, textureY)
			.addShapeBox(-9.5f, 1.5f, 4.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 261")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 169, 57, textureX, textureY)
			.addShapeBox(-9.5f, -1.5f, 4.5f, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 262")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 193, 57, textureX, textureY)
			.addShapeBox(-9.5f, -4.5f, 4.5f, 2, 3, 1, 0, -1.8f, 1.2f, 0, 1.3f, -0.3f, 0, 1.2f, -0.1f, -0.7f, -2, 1.2f, -0.7f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.7f, -0.2f, 0, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 263")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 201, 57, textureX, textureY)
			.addShapeBox(-6.7f, -6.7f, 4.5f, 3, 2, 1, 0, 1, -1, 0, -2, 1, 0, -1.9f, 0.8f, -0.7f, 0.8f, -1, -0.7f, -0.5f, 0.5f, 0, -0.5f, -1.5f, 0, -0.7f, -1.6f, -0.7f, -0.4f, 0.3f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 264")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 217, 57, textureX, textureY)
			.addShapeBox(-4.5f, -9.5f, 4.5f, 3, 2, 1, 0, 1.2f, -1.8f, 0, 0, 0, 0, 0, -0.2f, -0.7f, 1.1f, -2, -0.7f, -0.3f, 1.3f, 0, 0, 0, 0, 0, -0.2f, -0.7f, -0.1f, 1.2f, -0.7f)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 265")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 233, 57, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 266")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 249, 57, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 267")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 265, 57, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 268")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 273, 57, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 269")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 281, 57, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, -1.35f, 0.15f, -0.5f, 0.35f, 0.15f, -0.5f, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0, -4.25f, -1.1f, -0.5f, 3.3f, -1, -0.5f, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 270")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 289, 57, textureX, textureY)
			.addShapeBox(-0.5f, 1.5f, -0.5f, 1, 6, 1, 0, 0.35f, 0.15f, -0.5f, -1.35f, 0.15f, -0.5f, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0, 3.3f, -1, -0.5f, -4.25f, -1.1f, -0.5f, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 271")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 297, 57, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, 3.3f, -1, -0.5f, -4.25f, -1.1f, -0.5f, -3.8f, -0.75f, 0, 3.7f, -1.25f, 0, 0.35f, 0.15f, -0.5f, -1.35f, 0.15f, -0.5f, -0.85f, -0.05f, 0, 0.7f, 0.45f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 272")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 329, 57, textureX, textureY)
			.addShapeBox(-0.5f, -7.5f, -0.5f, 1, 6, 1, 0, -4.25f, -1.1f, -0.5f, 3.3f, -1, -0.5f, 3.7f, -1.25f, 0, -3.8f, -0.75f, 0, -1.35f, 0.15f, -0.5f, 0.35f, 0.15f, -0.5f, 0.7f, 0.45f, 0, -0.85f, -0.05f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 273")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 337, 57, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0.3f, 0.15f, -0.5f, -1.05f, 3.15f, -0.5f, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0, 0.15f, -1.25f, -0.5f, -0.85f, -4.25f, -0.5f, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 274")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 369, 57, textureX, textureY)
			.addShapeBox(1.5f, -0.5f, -0.5f, 6, 1, 1, 0, 0.15f, -1.25f, -0.5f, -0.85f, -4.25f, -0.5f, -0.75f, -3.8f, 0, -0.05f, -0.8f, 0, 0.3f, 0.15f, -0.5f, -1.05f, 3.15f, -0.5f, -1.25f, 3.7f, 0, 0.45f, 0.7f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 275")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 385, 57, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, -0.85f, -4.25f, -0.5f, 0.15f, -1.25f, -0.5f, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0, -1.05f, 3.15f, -0.5f, 0.3f, 0.15f, -0.5f, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 276")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 401, 57, textureX, textureY)
			.addShapeBox(-7.5f, -0.5f, -0.5f, 6, 1, 1, 0, -1.05f, 3.15f, -0.5f, 0.3f, 0.15f, -0.5f, 0.45f, 0.7f, 0, -1.25f, 3.7f, 0, -0.85f, -4.25f, -0.5f, 0.15f, -1.25f, -0.5f, -0.05f, -0.8f, 0, -0.75f, -3.8f, 0)
			.setRotationPoint(43.5f, 0.5f, -20).setRotationAngle(0, 0, 0).setName("Box 277")
		);
		wheel_front_right.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_front_right);
		//
	}

}