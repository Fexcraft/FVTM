//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t2;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t2_interior")
public class T2Interior extends PartModel {

	public T2Interior(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList interior = new TurboList("interior");
		interior.add(new ModelRendererTurbo(interior, 25, 361, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 14, 48, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(58, -33, -24).setRotationAngle(0, 0, 0).setName("Box 176")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 6, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(57, -34, 6).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		interior.add(new ModelRendererTurbo(interior, 201, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 6, 8, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(51, -34, -1).setRotationAngle(0, 0.7853982f, 0).setName("Box 241")
		);
		interior.add(new ModelRendererTurbo(interior, 185, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 6, 5, 0, 0.375f, 0, -3.625f, -2.125f, -1, 0.625f, 0, -1, 0, 0, 0, 0, 0.375f, 0, -3.625f, -2.125f, 0, 0.625f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(57, -34, 1).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		interior.add(new ModelRendererTurbo(interior, 89, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 9, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(57, -28, 6).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		interior.add(new ModelRendererTurbo(interior, 377, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(51, -28, -1).setRotationAngle(0, 0.7853982f, 0).setName("Box 244")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 9, 5, 0, 0.375f, 0, -3.625f, -2.125f, 0, 0.625f, 0, 0, 0, 0, 0, 0, -1.125f, 0, -2.125f, -2.125f, 0, 0.625f, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(57, -28, 1).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 6, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(57, -34, -22).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		interior.add(new ModelRendererTurbo(interior, 337, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 6, 7, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5)
			.setRotationPoint(57, -34, -6).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		interior.add(new ModelRendererTurbo(interior, 201, 297, textureX, textureY).addBox(0, 0, 0, 12, 3, 14)
			.setRotationPoint(40, -26, 5).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		interior.add(new ModelRendererTurbo(interior, 273, 297, textureX, textureY).addBox(0, 0, 0, 12, 3, 14)
			.setRotationPoint(40, -26, -19).setRotationAngle(0, 0, 0).setName("Box 249")
		);
		interior.add(new ModelRendererTurbo(interior, 145, 361, textureX, textureY).addBox(0, 0, 0, 16, 8, 48)
			.setRotationPoint(20, -27, -24).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		interior.add(new ModelRendererTurbo(interior, 1, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 14, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(38, -40, -19).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		interior.add(new ModelRendererTurbo(interior, 465, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 14, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(38, -40, 5).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		interior.add(new ModelRendererTurbo(interior, 473, 321, textureX, textureY).addBox(0, 0, 0, 1, 32, 18)
			.setRotationPoint(36, -51, -24).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		interior.add(new ModelRendererTurbo(interior, 113, 345, textureX, textureY).addBox(0, 0, 0, 1, 32, 18)
			.setRotationPoint(36, -51, 6).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		interior.add(new ModelRendererTurbo(interior, 233, 377, textureX, textureY).addBox(0, 0, 0, 1, 3, 48)
			.setRotationPoint(36, -54, -24).setRotationAngle(0, 0, 0).setName("Box 255")
		);
		interior.add(new ModelRendererTurbo(interior, 281, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 12, 2, 0, 0, -1, 0, 0, 0, 1, 0, 0, 1, 0, -1, 0, -3, 0, 0, 3, 0, 2, 3, 0, 2, -3, 0, 0)
			.setRotationPoint(55, -31, 11).setRotationAngle(0, 0, 0).setName("Box 262")
		);
		interior.add(new ModelRendererTurbo(interior, 401, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -34, 6).setRotationAngle(0, 0, 0).setName("Box 276")
		);
		interior.add(new ModelRendererTurbo(interior, 505, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -33, 6).setRotationAngle(0, 0, 0).setName("Box 277")
		);
		interior.add(new ModelRendererTurbo(interior, 505, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -32, 6).setRotationAngle(0, 0, 0).setName("Box 278")
		);
		interior.add(new ModelRendererTurbo(interior, 313, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -31, 6).setRotationAngle(0, 0, 0).setName("Box 279")
		);
		interior.add(new ModelRendererTurbo(interior, 385, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -34, 17).setRotationAngle(0, 0, 0).setName("Box 280")
		);
		interior.add(new ModelRendererTurbo(interior, 497, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -33, 17).setRotationAngle(0, 0, 0).setName("Box 281")
		);
		interior.add(new ModelRendererTurbo(interior, 193, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -32, 17).setRotationAngle(0, 0, 0).setName("Box 282")
		);
		interior.add(new ModelRendererTurbo(interior, 497, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -31, 17).setRotationAngle(0, 0, 0).setName("Box 283")
		);
		interior.add(new ModelRendererTurbo(interior, 193, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -30, 17).setRotationAngle(0, 0, 0).setName("Box 284")
		);
		interior.add(new ModelRendererTurbo(interior, 257, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -30, 18).setRotationAngle(0, 0, 0).setName("Box 285")
		);
		interior.add(new ModelRendererTurbo(interior, 265, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -31, 18).setRotationAngle(0, 0, 0).setName("Box 286")
		);
		interior.add(new ModelRendererTurbo(interior, 273, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -32, 18).setRotationAngle(0, 0, 0).setName("Box 287")
		);
		interior.add(new ModelRendererTurbo(interior, 313, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -33, 18).setRotationAngle(0, 0, 0).setName("Box 288")
		);
		interior.add(new ModelRendererTurbo(interior, 321, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -34, 18).setRotationAngle(0, 0, 0).setName("Box 289")
		);
		interior.add(new ModelRendererTurbo(interior, 409, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -34, 20).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		interior.add(new ModelRendererTurbo(interior, 417, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -34, 21).setRotationAngle(0, 0, 0).setName("Box 291")
		);
		interior.add(new ModelRendererTurbo(interior, 425, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -33, 21).setRotationAngle(0, 0, 0).setName("Box 292")
		);
		interior.add(new ModelRendererTurbo(interior, 449, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -32, 21).setRotationAngle(0, 0, 0).setName("Box 293")
		);
		interior.add(new ModelRendererTurbo(interior, 457, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -33, 20).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		interior.add(new ModelRendererTurbo(interior, 465, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -32, 20).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		interior.add(new ModelRendererTurbo(interior, 473, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -31, 20).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		interior.add(new ModelRendererTurbo(interior, 481, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.8f, -30, 20).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		interior.add(new ModelRendererTurbo(interior, 489, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.6f, -34, 5).setRotationAngle(0, 0.2617994f, 0).setName("Box 298")
		);
		interior.add(new ModelRendererTurbo(interior, 497, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.6f, -33, 5).setRotationAngle(0, 0.2617994f, 0).setName("Box 299")
		);
		interior.add(new ModelRendererTurbo(interior, 505, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.6f, -32, 5).setRotationAngle(0, 0.2617994f, 0).setName("Box 300")
		);
		interior.add(new ModelRendererTurbo(interior, 369, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(56.6f, -31, 5).setRotationAngle(0, 0.2617994f, 0).setName("Box 301")
		);
		interior.add(new ModelRendererTurbo(interior, 377, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 302")
		);
		interior.add(new ModelRendererTurbo(interior, 89, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -30, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 303")
		);
		interior.add(new ModelRendererTurbo(interior, 121, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -32, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 304")
		);
		interior.add(new ModelRendererTurbo(interior, 505, 65, textureX, textureY)
			.addShapeBox(0, 0, 1, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 305")
		);
		interior.add(new ModelRendererTurbo(interior, 113, 73, textureX, textureY)
			.addShapeBox(0, 0, 2, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 306")
		);
		interior.add(new ModelRendererTurbo(interior, 129, 73, textureX, textureY)
			.addShapeBox(0, 0, 3, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 307")
		);
		interior.add(new ModelRendererTurbo(interior, 137, 73, textureX, textureY)
			.addShapeBox(0, 0, 5, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 308")
		);
		interior.add(new ModelRendererTurbo(interior, 153, 73, textureX, textureY)
			.addShapeBox(0, 0, 6, 1, 2, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 309")
		);
		interior.add(new ModelRendererTurbo(interior, 385, 73, textureX, textureY)
			.addShapeBox(0, 1, 1, 1, 3, 5, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 310")
		);
		interior.add(new ModelRendererTurbo(interior, 169, 73, textureX, textureY)
			.addShapeBox(0, 2, 6, 1, 2, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 311")
		);
		interior.add(new ModelRendererTurbo(interior, 185, 73, textureX, textureY)
			.addShapeBox(0, 4, 6, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 312")
		);
		interior.add(new ModelRendererTurbo(interior, 209, 73, textureX, textureY)
			.addShapeBox(0, 5, 6, 1, 1, 1, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 313")
		);
		interior.add(new ModelRendererTurbo(interior, 273, 73, textureX, textureY)
			.addShapeBox(0, 5, 4, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 314")
		);
		interior.add(new ModelRendererTurbo(interior, 409, 73, textureX, textureY)
			.addShapeBox(0, 4, 4, 1, 1, 2, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 315")
		);
		interior.add(new ModelRendererTurbo(interior, 465, 73, textureX, textureY)
			.addShapeBox(0, 4, 1, 1, 1, 3, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 316")
		);
		interior.add(new ModelRendererTurbo(interior, 25, 81, textureX, textureY)
			.addShapeBox(0, 5, 1, 1, 1, 3, 0, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, -0.8f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(51, -34, -0.8f).setRotationAngle(0, 0.7853982f, 0).setName("Box 317")
		);
		interior.add(new ModelRendererTurbo(interior, 481, 257, textureX, textureY).addBox(0, 0, 0, 1, 4, 14)
			.setRotationPoint(56.7f, -33, -20).setRotationAngle(0, 0, 0).setName("Box 318")
		);
		interior.add(new ModelRendererTurbo(interior, 41, 81, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(56.5f, -32, -15).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		interior.add(new ModelRendererTurbo(interior, 369, 385, textureX, textureY).addBox(0, 0, 0, 4, 1, 44)
			.setRotationPoint(56, -51, -22).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		interior.add(new ModelRendererTurbo(interior, 289, 409, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 44, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(60, -51, -22).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		interior.add(new ModelRendererTurbo(interior, 233, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -4, -1, 0, -4, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -52, -23).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		interior.add(new ModelRendererTurbo(interior, 25, 105, textureX, textureY).addBox(0, 0, 0, 8, 2, 1)
			.setRotationPoint(56, -54, -23).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		interior.add(new ModelRendererTurbo(interior, 97, 113, textureX, textureY).addBox(0, 0, 0, 8, 2, 1)
			.setRotationPoint(56, -54, 22).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		interior.add(new ModelRendererTurbo(interior, 417, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, -1, 0, 0, -1, 0)
			.setRotationPoint(56, -52, 22).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		interior.add(new ModelRendererTurbo(interior, 177, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 4, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -23, 6).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		interior.add(new ModelRendererTurbo(interior, 249, 329, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 4, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -23, -18).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		this.groups.add(interior);
	}

}