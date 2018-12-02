//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c8;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c8_interior")
public class C8Interior extends PartModel {

	public C8Interior(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList interior = new TurboList("interior");
		interior.add(new ModelRendererTurbo(interior, 115, 101, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 42, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(21, -9, -21).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 144")
		);
		interior.add(new ModelRendererTurbo(interior, 474, 51, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 6, 12, 0, -1, 2, 0, 1, 0, 0, 1, 0, 0, -1, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(19, -10, 5).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 159")
		);
		interior.add(new ModelRendererTurbo(interior, 449, 63, textureX, textureY)
			.addShapeBox(0, -2, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 16).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 183")
		);
		interior.add(new ModelRendererTurbo(interior, 270, 62, textureX, textureY)
			.addShapeBox(0, 2, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 16).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 184")
		);
		interior.add(new ModelRendererTurbo(interior, 411, 61, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 16).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 185")
		);
		interior.add(new ModelRendererTurbo(interior, 396, 60, textureX, textureY)
			.addShapeBox(0, 2, -1, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 16).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 188")
		);
		interior.add(new ModelRendererTurbo(interior, 369, 60, textureX, textureY)
			.addShapeBox(0, -2, -1, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 16).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 189")
		);
		interior.add(new ModelRendererTurbo(interior, 354, 60, textureX, textureY)
			.addShapeBox(0, -2, -1, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 6).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 190")
		);
		interior.add(new ModelRendererTurbo(interior, 270, 58, textureX, textureY)
			.addShapeBox(0, -2, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 6).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 191")
		);
		interior.add(new ModelRendererTurbo(interior, 270, 54, textureX, textureY)
			.addShapeBox(0, 2, 0, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 6).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 192")
		);
		interior.add(new ModelRendererTurbo(interior, 446, 51, textureX, textureY)
			.addShapeBox(0, 2, -1, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 6).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 193")
		);
		interior.add(new ModelRendererTurbo(interior, 108, 48, textureX, textureY)
			.addShapeBox(0, 0, -1, 1, 2, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 6).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 194")
		);
		interior.add(new ModelRendererTurbo(interior, 404, 51, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20.8f, -8.5f, 17.25f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 198")
		);
		interior.add(new ModelRendererTurbo(interior, 506, 42, textureX, textureY)
			.addShapeBox(0, 0, 1, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20.8f, -8.5f, 17.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 199")
		);
		interior.add(new ModelRendererTurbo(interior, 487, 42, textureX, textureY)
			.addShapeBox(0, 0, 1, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20.8f, -8.5f, 18.75f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 200")
		);
		interior.add(new ModelRendererTurbo(interior, 142, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 8, 5, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0)
			.setRotationPoint(21.5f, -5, -2.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 218")
		);
		interior.add(new ModelRendererTurbo(interior, 404, 51, textureX, textureY)
			.addShapeBox(0, 0, 0, 18, 4, 5, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1)
			.setRotationPoint(3.5f, -1, -2.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 219")
		);
		interior.add(new ModelRendererTurbo(interior, 492, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5.5f, 0.6f, -1.5f).setRotationAngle(0, 0, -0.10471976f)
			.setTextured(true).setLines(false).setName("Box 220")
		);
		interior.add(new ModelRendererTurbo(interior, 498, 5, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(6, 0.3f, -0.5f).setRotationAngle(0, 0, -0.2617994f)
			.setTextured(true).setLines(false).setName("Box 221")
		);
		interior.add(new ModelRendererTurbo(interior, 245, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17.5f, -1, -1.5f).setRotationAngle(0, 0, -0.17453294f)
			.setTextured(true).setLines(false).setName("Box 222")
		);
		interior.add(new ModelRendererTurbo(interior, 0, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(18.5f, -3, -0.5f).setRotationAngle(0, 0, -0.05235988f)
			.setTextured(true).setLines(false).setName("Box 223")
		);
		interior.add(new ModelRendererTurbo(interior, 25, 35, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(18.5f, -4, -0.5f).setRotationAngle(0, 0, -0.05235988f)
			.setTextured(true).setLines(false).setName("Box 224")
		);
		interior.add(new ModelRendererTurbo(interior, 493, 80, textureX, textureY).addBox(0, 0, 0, 1, 3, 5)
			.setRotationPoint(20.9f, -8.5f, -2.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 225")
		);
		interior.add(new ModelRendererTurbo(interior, 492, 34, textureX, textureY)
			.addShapeBox(0, -0.5f, -0.5f, 1, 1, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f)
			.setRotationPoint(20.8f, -7.8f, 2).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 227")
		);
		interior.add(new ModelRendererTurbo(interior, 473, 34, textureX, textureY)
			.addShapeBox(0, -0.5f, -0.5f, 1, 1, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f)
			.setRotationPoint(20.8f, -7.8f, 2).setRotationAngle(0.7853982f, 0, 0)
			.setTextured(true).setLines(false).setName("Box 228")
		);
		interior.add(new ModelRendererTurbo(interior, 0, 33, textureX, textureY)
			.addShapeBox(0, -0.5f, -0.5f, 1, 1, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f)
			.setRotationPoint(20.8f, -7.8f, -2).setRotationAngle(0.7853982f, 0, 0)
			.setTextured(true).setLines(false).setName("Box 229")
		);
		interior.add(new ModelRendererTurbo(interior, 492, 31, textureX, textureY)
			.addShapeBox(0, -0.5f, -0.5f, 1, 1, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f)
			.setRotationPoint(20.8f, -7.8f, -2).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 230")
		);
		interior.add(new ModelRendererTurbo(interior, 124, 80, textureX, textureY)
			.addShapeBox(0, 0.2f, 1, 1, 1, 3, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(20.8f, -7.5f, -2.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 231")
		);
		interior.add(new ModelRendererTurbo(interior, 473, 31, textureX, textureY)
			.addShapeBox(0, 0.2f, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(20.8f, -6.5f, 0.3f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 232")
		);
		interior.add(new ModelRendererTurbo(interior, 396, 31, textureX, textureY)
			.addShapeBox(0, 0.2f, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(20.8f, -6.5f, -3.3f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 233")
		);
		interior.add(new ModelRendererTurbo(interior, 0, 30, textureX, textureY)
			.addShapeBox(0, 0.2f, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(20.8f, -6.5f, -0.9f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 234")
		);
		interior.add(new ModelRendererTurbo(interior, 396, 28, textureX, textureY)
			.addShapeBox(0, 0.2f, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0)
			.setRotationPoint(20.8f, -6.5f, -2.1f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 235")
		);
		interior.add(new ModelRendererTurbo(interior, 172, 13, textureX, textureY)
			.addShapeBox(0, 0, 1, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21.8f, -9.5f, 16.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 236")
		);
		interior.add(new ModelRendererTurbo(interior, 23, 11, textureX, textureY)
			.addShapeBox(0, 0, 1, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21.8f, -9.5f, -21.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 237")
		);
		interior.add(new ModelRendererTurbo(interior, 220, 71, textureX, textureY)
			.addShapeBox(0, 0, 1, 2, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21.8f, -9.5f, -3).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 238")
		);
		interior.add(new ModelRendererTurbo(interior, 113, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 10, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(21, -8.5f, -16).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 239")
		);
		interior.add(new ModelRendererTurbo(interior, 15, 64, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0.2f, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0.2f, 0, -0.2f, 0, 0, -0.2f, 0, 0.2f, -0.2f, 0.2f)
			.setRotationPoint(21, -6.5f, -12).setRotationAngle(0, 0, 0.13962634f)
			.setTextured(true).setLines(false).setName("Box 240")
		);
		interior.add(new ModelRendererTurbo(interior, 132, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 3, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(13, -22.5f, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 260")
		);
		interior.add(new ModelRendererTurbo(interior, 462, 80, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, -0.3f, -0.3f, 0, -0.3f, -0.3f, 0, 0, 0, 0, 0, 0, 0, -0.3f, -0.3f, 0, -0.3f, -0.3f, 0, 0, 0)
			.setRotationPoint(12.5f, -21, 0).setRotationAngle(0, 0.5235988f, -0.20943952f)
			.setTextured(true).setLines(false).setName("Box 261")
		);
		interior.add(new ModelRendererTurbo(interior, 149, 26, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(13.5f, -21.5f, 1).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 262")
		);
		this.groups.add(interior);
		//
		TurboList interior_glow = new TurboList("interior_glow");
		interior_glow.add(new ModelRendererTurbo(interior_glow, 27, 26, textureX, textureY)
			.addShapeBox(0, 0, -1, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 16).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 186")
		);
		interior_glow.add(new ModelRendererTurbo(interior_glow, 423, 24, textureX, textureY)
			.addShapeBox(0, 1, -1, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 16).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 187")
		);
		interior_glow.add(new ModelRendererTurbo(interior_glow, 149, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 6).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 195")
		);
		interior_glow.add(new ModelRendererTurbo(interior_glow, 421, 16, textureX, textureY)
			.addShapeBox(0, 1, 0, 1, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 6).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 196")
		);
		interior_glow.add(new ModelRendererTurbo(interior_glow, 301, 78, textureX, textureY)
			.addShapeBox(0, -2, -3, 1, 2, 6, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(19.6f, -10, 11).setRotationAngle(0, 0, 0.17453294f)
			.setTextured(true).setLines(false).setName("Box 197")
		);
		interior_glow.add(new ModelRendererTurbo(interior_glow, 13, 80, textureX, textureY).addBox(0, 0.2f, 1, 1, 1, 3)
			.setRotationPoint(20.8f, -8.5f, -2.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false).setName("Box 226")
		);
		interior_glow.addProgram(DefaultPrograms.LIGHTS);
		this.groups.add(interior_glow);
	}

}