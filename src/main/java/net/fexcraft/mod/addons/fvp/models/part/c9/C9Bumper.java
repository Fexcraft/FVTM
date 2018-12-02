//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c9;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c9_bumper")
public class C9Bumper extends PartModel {

	public C9Bumper(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList bumper_front = new TurboList("bumper_front");
		bumper_front.add(new ModelRendererTurbo(bumper_front, 169, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 14, 0, 0, 0, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0, 0, 0, -0.6f, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, -0.6f, 0)
			.setRotationPoint(50.7f, 4, -7).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 204")
		);
		bumper_front.add(new ModelRendererTurbo(bumper_front, 249, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 11, 0, 0, 0, 0, 0, -0.3f, 0, -1.8f, -0.3f, 0, 1.8f, 0, 0, 0, -0.6f, 0, 0, -0.9f, 0, -1.8f, -0.9f, 0, 1.8f, -0.6f, 0)
			.setRotationPoint(50.7f, 4, 7).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 205")
		);
		bumper_front.add(new ModelRendererTurbo(bumper_front, 201, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 11, 0, 1.8f, 0, 0, -1.8f, -0.3f, 0, 0, -0.3f, 0, 0, 0, 0, 1.8f, -0.6f, 0, -1.8f, -0.9f, 0, 0, -0.9f, 0, 0, -0.6f, 0)
			.setRotationPoint(50.7f, 4, -18).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 206")
		);
		bumper_front.add(new ModelRendererTurbo(bumper_front, 353, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 10, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(50.800007f, 5, -5).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 207")
		);
		bumper_front.add(new ModelRendererTurbo(bumper_front, 73, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, -0.3f, 0, -0.4f, -0.3f, -0.2f, 0.4f, 0, -0.2f, 0, -0.6f, 0, 0, -0.9f, 0, -0.4f, -0.9f, -0.2f, 0.4f, -0.6f, -0.2f)
			.setRotationPoint(48.900005f, 4, 18).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 339")
		);
		bumper_front.add(new ModelRendererTurbo(bumper_front, 121, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0.4f, 0, -0.2f, -0.4f, -0.3f, -0.2f, 0, -0.3f, 0, 0, 0, 0, 0.4f, -0.6f, -0.2f, -0.4f, -0.9f, -0.2f, 0, -0.9f, 0, 0, -0.6f, 0)
			.setRotationPoint(48.900005f, 4, -19).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 340")
		);
		bumper_front.add(new ModelRendererTurbo(bumper_front, 177, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, -0.3f, 0, -0.8f, -0.3f, -0.5f, 0.9f, 0, -0.45f, 0, -0.6f, 0, 0, -0.9f, 0, -0.8f, -0.9f, -0.5f, 0.9f, -0.6f, -0.45f)
			.setRotationPoint(48.500004f, 4, 18.8f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 341")
		);
		bumper_front.add(new ModelRendererTurbo(bumper_front, 225, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0.9f, 0, -0.45f, -0.8f, -0.3f, -0.5f, 0, -0.3f, 0, 0, 0, 0, 0.9f, -0.6f, -0.45f, -0.8f, -0.9f, -0.5f, 0, -0.9f, 0, 0, -0.6f, 0)
			.setRotationPoint(48.500004f, 4, -19.8f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 342")
		);
		bumper_front.addProgram(new DefaultPrograms.IDSpecific("front_bumper"));
		this.groups.add(bumper_front);
		//
		TurboList bumper_rear = new TurboList("bumper_rear");
		bumper_rear.add(new ModelRendererTurbo(bumper_rear, 345, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 6, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-54.1f, 0, -3).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 329")
		);
		bumper_rear.add(new ModelRendererTurbo(bumper_rear, 473, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 14, 0, 0.1f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0.1f, -0.3f, 0, 0.1f, -0.8f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0.1f, -0.8f, 0)
			.setRotationPoint(-57.800003f, 4, -7).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 346")
		);
		bumper_rear.add(new ModelRendererTurbo(bumper_rear, 385, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 11, 0, -0.7f, -0.3f, -0.2f, 0.7f, 0, -0.2f, 0, 0, 0, 0.1f, -0.3f, 0, -0.7f, -0.8f, -0.2f, 0.7f, -0.5f, -0.2f, 0, -0.5f, 0, 0.1f, -0.8f, 0)
			.setRotationPoint(-57.800003f, 4, -18).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 347")
		);
		bumper_rear.add(new ModelRendererTurbo(bumper_rear, 89, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 11, 0, 0.1f, -0.3f, 0, 0, 0, 0, 0.7f, 0, -0.2f, -0.7f, -0.3f, -0.2f, 0.1f, -0.8f, 0, 0, -0.5f, 0, 0.7f, -0.5f, -0.2f, -0.7f, -0.8f, -0.2f)
			.setRotationPoint(-57.800003f, 4, 7).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 348")
		);
		bumper_rear.add(new ModelRendererTurbo(bumper_rear, 81, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 2, 0, 0.1f, -0.3f, 0, -0.1f, 0, 0, 0.7f, 0, -0.6f, -1, -0.3f, -0.3f, 0.1f, -0.8f, 0, -0.1f, -0.5f, 0, 0.7f, -0.6f, -0.6f, -1, -0.9f, -0.3f)
			.setRotationPoint(-57, 4, 17.8f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 349")
		);
		bumper_rear.add(new ModelRendererTurbo(bumper_rear, 225, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 2, 0, -1, -0.3f, -0.3f, 0.7f, 0, -0.6f, -0.1f, 0, 0, 0.1f, -0.3f, 0, -1, -0.9f, -0.3f, 0.7f, -0.6f, -0.6f, -0.1f, -0.5f, 0, 0.1f, -0.8f, 0)
			.setRotationPoint(-57, 4, -19.8f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 350")
		);
		bumper_rear.add(new ModelRendererTurbo(bumper_rear, 249, 65, textureX, textureY)
			.addShapeBox(0, 1, 0, 1, 4, 1, 0, 0, 0, 0, 0.4f, 0, -0.5f, -0.6f, -0.3f, -0.5f, 0.7f, -0.3f, -0.7f, 0, -0.6f, 0, 0.4f, -0.6f, -0.5f, -0.6f, -0.8f, -0.5f, 0.7f, -0.9f, -0.7f)
			.setRotationPoint(-55.300003f, 3, 19.2f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 351")
		);
		bumper_rear.add(new ModelRendererTurbo(bumper_rear, 473, 65, textureX, textureY)
			.addShapeBox(0, 1, 0, 1, 4, 1, 0, 0.7f, -0.3f, -0.7f, -0.6f, -0.3f, -0.5f, 0.4f, 0, -0.5f, 0, 0, 0, 0.7f, -0.9f, -0.7f, -0.6f, -0.8f, -0.5f, 0.4f, -0.6f, -0.5f, 0, -0.6f, 0)
			.setRotationPoint(-55.300003f, 3, -20.2f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 352")
		);
		bumper_rear.addProgram(new DefaultPrograms.IDSpecific("rear_bumper"));
		this.groups.add(bumper_rear);
	}

}