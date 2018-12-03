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
@fModel(registryname = "fvp:models/part/ot1_type3")
public class OT1Type3 extends PartModel {

	public OT1Type3(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis = new TurboList("chassis");
		chassis.add(new ModelRendererTurbo(chassis, 33, 249, textureX, textureY).addBox(0, 0, 0, 93, 12, 2)
			.setRotationPoint(-75, -25, 23).setRotationAngle(0, 0, 0).setName("Box 373")
		);
		chassis.add(new ModelRendererTurbo(chassis, 225, 249, textureX, textureY).addBox(0, 0, 0, 93, 12, 2)
			.setRotationPoint(-75, -25, -25).setRotationAngle(0, 0, 0).setName("Box 374")
		);
		chassis.add(new ModelRendererTurbo(chassis, 369, 233, textureX, textureY).addBox(0, 0, 0, 1, 12, 50)
			.setRotationPoint(18, -25, -25).setRotationAngle(0, 0, 0).setName("Box 375")
		);
		chassis.add(new ModelRendererTurbo(chassis, 481, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-77.5f, -25.5f, 22.5f).setRotationAngle(0, 0, 0).setName("Box 376")
		);
		chassis.add(new ModelRendererTurbo(chassis, 497, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-77.5f, -25.5f, -25.5f).setRotationAngle(0, 0, 0).setName("Box 377")
		);
		chassis.add(new ModelRendererTurbo(chassis, 113, 265, textureX, textureY).addBox(0, 0, 0, 3, 2, 45)
			.setRotationPoint(-77.5f, -13.5f, -22.5f).setRotationAngle(0, 0, 0).setName("Box 379")
		);
		chassis.add(new ModelRendererTurbo(chassis, 217, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 46, 0, 0, -0.5f, 0, 0, -1, 0, 0, -1, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-74.5f, -14, -23).setRotationAngle(0, 0, 0).setName("Box 380")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 89, textureX, textureY).addBox(0, 0, 0, 1, 24, 1)
			.setRotationPoint(18, -49, 23.5f).setRotationAngle(0, 0, 0).setName("Box 384")
		);
		chassis.add(new ModelRendererTurbo(chassis, 457, 225, textureX, textureY).addBox(0, 0, 0, 1, 24, 1)
			.setRotationPoint(18, -49, -24.5f).setRotationAngle(0, 0, 0).setName("Box 385")
		);
		chassis.add(new ModelRendererTurbo(chassis, 457, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, -1, 0, 4, -1)
			.setRotationPoint(18, -53, 0.5f).setRotationAngle(0, 0, 0).setName("Box 386")
		);
		chassis.add(new ModelRendererTurbo(chassis, 65, 265, textureX, textureY)
			.addShapeBox(-2, 0, -23, 1, 1, 24, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, -1, 0, 4, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -53, -1.5f).setRotationAngle(0, 0, 0).setName("Box 387")
		);
		chassis.add(new ModelRendererTurbo(chassis, 113, 313, textureX, textureY).addBox(0, 0, 0, 96, 1, 1)
			.setRotationPoint(-77, -53, -0.5f).setRotationAngle(0, 0, 0).setName("Box 388")
		);
		chassis.add(new ModelRendererTurbo(chassis, 465, 225, textureX, textureY).addBox(0, 0, 0, 1, 24, 1)
			.setRotationPoint(-77, -49, 23.5f).setRotationAngle(0, 0, 0).setName("Box 389")
		);
		chassis.add(new ModelRendererTurbo(chassis, 473, 225, textureX, textureY).addBox(0, 0, 0, 1, 24, 1)
			.setRotationPoint(-77, -49, -24.5f).setRotationAngle(0, 0, 0).setName("Box 390")
		);
		chassis.add(new ModelRendererTurbo(chassis, 169, 265, textureX, textureY)
			.addShapeBox(-2, 0, -22, 1, 1, 24, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, -1, 0, 4, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-75, -53, -2.5f).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		chassis.add(new ModelRendererTurbo(chassis, 273, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, -1, 0, 4, -1)
			.setRotationPoint(-77, -53, 0.5f).setRotationAngle(0, 0, 0).setName("Box 392")
		);
		chassis.add(new ModelRendererTurbo(chassis, 113, 321, textureX, textureY).addBox(0, 0, 0, 94, 1, 1)
			.setRotationPoint(-76, -49, 23.5f).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 329, textureX, textureY).addBox(0, 0, 0, 94, 1, 1)
			.setRotationPoint(-76, -49, -24.5f).setRotationAngle(0, 0, 0).setName("Box 394")
		);
		chassis.add(new ModelRendererTurbo(chassis, 193, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 96, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-77, -13, -25).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 337, textureX, textureY)
			.addShapeBox(0, 0, 0, 96, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-77, -13, 21).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		chassis.add(new ModelRendererTurbo(chassis, 489, 225, textureX, textureY).addBox(0, 0, 0, 1, 27, 1)
			.setRotationPoint(18, -52, -0.5f).setRotationAngle(0, 0, 0).setName("Box 397")
		);
		chassis.add(new ModelRendererTurbo(chassis, 401, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 47, 23, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(-76, -48, 23.5f).setRotationAngle(0, 0, 0).setName("Box 398")
		);
		chassis.add(new ModelRendererTurbo(chassis, 465, 225, textureX, textureY).addBox(0, 0, 0, 1, 24, 1)
			.setRotationPoint(-29.5f, -49, 23.5f).setRotationAngle(0, 0, 0).setName("Box 399")
		);
		chassis.add(new ModelRendererTurbo(chassis, 465, 225, textureX, textureY).addBox(0, 0, 0, 1, 24, 1)
			.setRotationPoint(-29.5f, -49, -24.5f).setRotationAngle(0, 0, 0).setName("Box 400")
		);
		chassis.add(new ModelRendererTurbo(chassis, 273, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 24, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, -1, 0, 4, -1)
			.setRotationPoint(-29.5f, -53, 0.5f).setRotationAngle(0, 0, 0).setName("Box 401")
		);
		chassis.add(new ModelRendererTurbo(chassis, 169, 265, textureX, textureY)
			.addShapeBox(-2, 0, -22, 1, 1, 24, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, -1, 0, 4, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-27.5f, -53, -2.5f).setRotationAngle(0, 0, 0).setName("Box 402")
		);
		chassis.add(new ModelRendererTurbo(chassis, 209, 337, textureX, textureY)
			.addShapeBox(0, 0, 0, 47, 23, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(-29, -48, 23.5f).setRotationAngle(0, 0, 0).setName("Box 403")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 345, textureX, textureY)
			.addShapeBox(0, 0, 0, 47, 23, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(-76, -48, -24.5f).setRotationAngle(0, 0, 0).setName("Box 404")
		);
		chassis.add(new ModelRendererTurbo(chassis, 105, 345, textureX, textureY)
			.addShapeBox(0, 0, 0, 47, 23, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(-29, -48, -24.5f).setRotationAngle(0, 0, 0).setName("Box 405")
		);
		chassis.add(new ModelRendererTurbo(chassis, 289, 361, textureX, textureY)
			.addShapeBox(0, 0, 0, 46, 1, 24, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -4.1f, 0, 0, -4.1f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 3.5f, -1, 0, 3.5f, -1)
			.setRotationPoint(-76, -53, 0.5f).setRotationAngle(0, 0, 0).setName("Box 406")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 377, textureX, textureY)
			.addShapeBox(0, 0, 0, 46, 1, 24, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -4.1f, 0, 0, -4.1f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 3.5f, -1, 0, 3.5f, -1)
			.setRotationPoint(-28, -53, 0.5f).setRotationAngle(0, 0, 0).setName("Box 407")
		);
		chassis.add(new ModelRendererTurbo(chassis, 145, 377, textureX, textureY)
			.addShapeBox(-2, 0, -22, 47, 1, 24, 0, 0, -4.1f, 0, 0, -4.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 3.5f, -1, 0, 3.5f, -1, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-74, -53, -2.5f).setRotationAngle(0, 0, 0).setName("Box 408")
		);
		chassis.add(new ModelRendererTurbo(chassis, 265, 393, textureX, textureY)
			.addShapeBox(-2, 0, -22, 47, 1, 24, 0, 0, -4.1f, 0, 0, -4.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 3.5f, -1, 0, 3.5f, -1, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(-27, -53, -2.5f).setRotationAngle(0, 0, 0).setName("Box 409")
		);
		chassis.add(new ModelRendererTurbo(chassis, 449, 281, textureX, textureY)
			.addShapeBox(-2, 0, -23, 1, 23, 24, 0, -0.4f, -4, 0, -0.4f, -4, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 4, -1, -0.4f, 4, -1, -0.4f, 4, 0, -0.4f, 4, 0)
			.setRotationPoint(20, -52, -1.5f).setRotationAngle(0, 0, 0).setName("Box 410")
		);
		chassis.add(new ModelRendererTurbo(chassis, 433, 361, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 23, 24, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -4, 0, -0.4f, -4, 0, -0.4f, 4, 0, -0.4f, 4, 0, -0.4f, 4, -1, -0.4f, 4, -1)
			.setRotationPoint(18, -52, 0.5f).setRotationAngle(0, 0, 0).setName("Box 411")
		);
		chassis.add(new ModelRendererTurbo(chassis, 241, 209, textureX, textureY).addBox(0, 0, 0, 1, 5, 4)
			.setRotationPoint(11, -18, 16).setRotationAngle(0, 0, 0).setName("Box 421")
		);
		chassis.add(new ModelRendererTurbo(chassis, 257, 209, textureX, textureY).addBox(0, 0, 0, 1, 5, 4)
			.setRotationPoint(-67, -18, 16).setRotationAngle(0, 0, 0).setName("Box 422")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 217, textureX, textureY).addBox(0, 0, 0, 1, 5, 4)
			.setRotationPoint(11, -18, -20).setRotationAngle(0, 0, 0).setName("Box 423")
		);
		chassis.add(new ModelRendererTurbo(chassis, 17, 217, textureX, textureY).addBox(0, 0, 0, 1, 5, 4)
			.setRotationPoint(-67, -18, -20).setRotationAngle(0, 0, 0).setName("Box 424")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 409, textureX, textureY)
			.addShapeBox(0, 0, 0, 83, 1, 8, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-69, -19, 14).setRotationAngle(0, 0, 0).setName("Box 425")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 425, textureX, textureY)
			.addShapeBox(0, 0, 0, 83, 1, 8, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-69, -19, -22).setRotationAngle(0, 0, 0).setName("Box 426")
		);
		this.groups.add(chassis);
		//
		TurboList door_close = new TurboList("door_close");
		door_close.add(new ModelRendererTurbo(door_close, 17, 265, textureX, textureY).addBox(0, 0, 0, 1, 12, 45)
			.setRotationPoint(-77, -25, -22.5f).setRotationAngle(0, 0, 0).setName("Box 378")
		);
		door_close.add(new ModelRendererTurbo(door_close, 145, 1, textureX, textureY).addBox(0, 0, 0, 1, 2, 5)
			.setRotationPoint(-77.5f, -24, -2.5f).setRotationAngle(0, 0, 0).setName("Box 381")
		);
		door_close.add(new ModelRendererTurbo(door_close, 433, 361, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 23, 24, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -4, 0, -0.4f, -4, 0, -0.4f, 4, 0, -0.4f, 4, 0, -0.4f, 4, 0, -0.4f, 4, 0)
			.setRotationPoint(-77, -52, 0.5f).setRotationAngle(0, 0, 0).setName("Box 412")
		);
		door_close.add(new ModelRendererTurbo(door_close, 449, 281, textureX, textureY)
			.addShapeBox(-2, 0, -23, 1, 23, 24, 0, -0.4f, -4, 0, -0.4f, -4, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 4, 0, -0.4f, 4, 0, -0.4f, 4, 0, -0.4f, 4, 0)
			.setRotationPoint(-75, -52, -1.5f).setRotationAngle(0, 0, 0).setName("Box 413")
		);
		door_close.add(new ModelRendererTurbo(door_close, 209, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(-77, -50, -1).setRotationAngle(0, 0, 0).setName("Box 414")
		);
		door_close.add(new ModelRendererTurbo(door_close, 153, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(-77, -46, -1).setRotationAngle(0, 0, 0).setName("Box 415")
		);
		door_close.add(new ModelRendererTurbo(door_close, 225, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(-77, -42, -1).setRotationAngle(0, 0, 0).setName("Box 416")
		);
		door_close.add(new ModelRendererTurbo(door_close, 289, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(-77, -38, -1).setRotationAngle(0, 0, 0).setName("Box 417")
		);
		door_close.add(new ModelRendererTurbo(door_close, 225, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(-77, -34, -1).setRotationAngle(0, 0, 0).setName("Box 418")
		);
		door_close.add(new ModelRendererTurbo(door_close, 145, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(-77, -30, -1).setRotationAngle(0, 0, 0).setName("Box 419")
		);
		door_close.add(new ModelRendererTurbo(door_close, 145, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0)
			.setRotationPoint(-77, -26, -1).setRotationAngle(0, 0, 0).setName("Box 420")
		);
		door_close.addProgram(DefaultPrograms.DOOR_CLOSE);
		this.groups.add(door_close);
		//
		TurboList door_open = new TurboList("door_open");
		door_open.add(new ModelRendererTurbo(door_open, 321, 265, textureX, textureY).addBox(0, 0, 0, 1, 12, 45)
			.setRotationPoint(-89, -12.5f, -22.5f).setRotationAngle(0, 0, -1.5707964f).setName("Box 382")
		);
		door_open.add(new ModelRendererTurbo(door_open, 25, 209, textureX, textureY).addBox(0, 0, 0, 2, 1, 5)
			.setRotationPoint(-87.5f, -13, -2.5f).setRotationAngle(0, 0, 0).setName("Box 383")
		);
		door_open.addProgram(DefaultPrograms.DOOR_OPEN);
		this.groups.add(door_open);
	}

}