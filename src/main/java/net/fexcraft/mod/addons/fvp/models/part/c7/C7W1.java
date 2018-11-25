//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c7;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c7_wheel1")
public class C7W1 extends PartModel {

	public C7W1(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel_back_left = new TurboList("wheel_back_left");
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 137, 105, textureX, textureY).addBox(-4, -4, 0, 8, 8, 2)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 192")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 489, 97, textureX, textureY).addBox(-2, -6, -1, 4, 2, 4)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 193")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 265, 105, textureX, textureY)
			.addShapeBox(4, -6, -1, 2, 4, 4, 0, 2, -2, 0, -4, 0, 0, -4, 0, 0, 2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 194")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 401, 105, textureX, textureY).addBox(4, -2, -1, 2, 4, 4)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 195")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 417, 105, textureX, textureY)
			.addShapeBox(4, 2, -1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 0, -4, 0, 0, -4, 0, 0, 2, -2, 0)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 281, 105, textureX, textureY).addBox(-2, 4, -1, 4, 2, 4)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 433, 105, textureX, textureY)
			.addShapeBox(-6, 2, -1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 2, -2, 0, 2, -2, 0, -4, 0, 0)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 385, 113, textureX, textureY).addBox(-6, -2, -1, 2, 4, 4)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 199")
		);
		wheel_back_left.add(new ModelRendererTurbo(wheel_back_left, 449, 113, textureX, textureY)
			.addShapeBox(-6, -6, -1, 2, 4, 4, 0, -4, 0, 0, 2, -2, 0, 2, -2, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 200")
		);
		wheel_back_left.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_back_left);
		//
		TurboList wheel_back_right = new TurboList("wheel_back_right");
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 465, 113, textureX, textureY).addBox(-2, -6, -1, 4, 2, 4)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 489, 113, textureX, textureY)
			.addShapeBox(4, 2, -1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 0, -4, 0, 0, -4, 0, 0, 2, -2, 0)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 202")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 161, 121, textureX, textureY)
			.addShapeBox(4, -6, -1, 2, 4, 4, 0, 2, -2, 0, -4, 0, 0, -4, 0, 0, 2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 177, 121, textureX, textureY).addBox(-4, -4, 0, 8, 8, 2)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 201, 121, textureX, textureY)
			.addShapeBox(-6, 2, -1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 2, -2, 0, 2, -2, 0, -4, 0, 0)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 205")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 289, 121, textureX, textureY).addBox(4, -2, -1, 2, 4, 4)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 206")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 217, 121, textureX, textureY).addBox(-2, 4, -1, 4, 2, 4)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 207")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 305, 121, textureX, textureY)
			.addShapeBox(-6, -6, -1, 2, 4, 4, 0, -4, 0, 0, 2, -2, 0, 2, -2, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		wheel_back_right.add(new ModelRendererTurbo(wheel_back_right, 321, 121, textureX, textureY).addBox(-6, -2, -1, 2, 4, 4)
			.setRotationPoint(-31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 209")
		);
		wheel_back_right.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_back_right);
		//
		TurboList wheel_front_left = new TurboList("wheel_front_left");
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 209, 41, textureX, textureY).addBox(-2, -6, -1, 4, 2, 4)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 1, 57, textureX, textureY).addBox(-2, 4, -1, 4, 2, 4)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 497, 41, textureX, textureY).addBox(4, -2, -1, 2, 4, 4)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 105, 57, textureX, textureY).addBox(-6, -2, -1, 2, 4, 4)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 145, 57, textureX, textureY)
			.addShapeBox(-6, -6, -1, 2, 4, 4, 0, -4, 0, 0, 2, -2, 0, 2, -2, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 177, 57, textureX, textureY)
			.addShapeBox(-6, 2, -1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 2, -2, 0, 2, -2, 0, -4, 0, 0)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 193, 57, textureX, textureY)
			.addShapeBox(4, 2, -1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 0, -4, 0, 0, -4, 0, 0, 2, -2, 0)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 209, 57, textureX, textureY)
			.addShapeBox(4, -6, -1, 2, 4, 4, 0, 2, -2, 0, -4, 0, 0, -4, 0, 0, 2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		wheel_front_left.add(new ModelRendererTurbo(wheel_front_left, 481, 57, textureX, textureY).addBox(-4, -4, 0, 8, 8, 2)
			.setRotationPoint(31.5f, -3.5f, 14).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		wheel_front_left.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_front_left);
		//
		TurboList wheel_front_right = new TurboList("wheel_front_right");
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 89, textureX, textureY).addBox(-2, 4, -1, 4, 2, 4)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 97, textureX, textureY).addBox(-2, -6, -1, 4, 2, 4)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 177, 97, textureX, textureY)
			.addShapeBox(-6, 2, -1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 2, -2, 0, 2, -2, 0, -4, 0, 0)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 209, 97, textureX, textureY)
			.addShapeBox(4, 2, -1, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, -2, 0, -4, 0, 0, -4, 0, 0, 2, -2, 0)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 225, 97, textureX, textureY).addBox(-6, -2, -1, 2, 4, 4)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 337, 97, textureX, textureY).addBox(4, -2, -1, 2, 4, 4)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 188")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 353, 97, textureX, textureY)
			.addShapeBox(4, -6, -1, 2, 4, 4, 0, 2, -2, 0, -4, 0, 0, -4, 0, 0, 2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 189")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 385, 97, textureX, textureY)
			.addShapeBox(-6, -6, -1, 2, 4, 4, 0, -4, 0, 0, 2, -2, 0, 2, -2, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		wheel_front_right.add(new ModelRendererTurbo(wheel_front_right, 1, 105, textureX, textureY).addBox(-4, -4, 0, 8, 8, 2)
			.setRotationPoint(31.5f, -3.5f, -16).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		wheel_front_right.addPrograms(DefaultPrograms.IMPORTED_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);
		this.groups.add(wheel_front_right);
		//
	}

}