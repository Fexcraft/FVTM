//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c7;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c7_i4_engine")
public class C7I4E extends PartModel {

	public C7I4E(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("zackyboy18/19");
		//
		TurboList group1 = new TurboList("group1");
		group1.add(new ModelRendererTurbo(group1, 33, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 3, 17, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -9, -9).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		group1.add(new ModelRendererTurbo(group1, 185, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -12, -9).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		group1.add(new ModelRendererTurbo(group1, 265, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 17, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -14, -9).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		group1.add(new ModelRendererTurbo(group1, 425, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 3, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(29, -6, -9).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		group1.add(new ModelRendererTurbo(group1, 273, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(30, -3, 2).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		group1.add(new ModelRendererTurbo(group1, 249, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -10, -7).setRotationAngle(0, 0, -0.73303837f).setName("Box 299")
		);
		group1.add(new ModelRendererTurbo(group1, 273, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -10, 5).setRotationAngle(0, 0, -0.73303837f).setName("Box 300")
		);
		group1.add(new ModelRendererTurbo(group1, 465, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -10, 1).setRotationAngle(0, 0, -0.73303837f).setName("Box 301")
		);
		group1.add(new ModelRendererTurbo(group1, 169, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -10, -3).setRotationAngle(0, 0, -0.73303837f).setName("Box 302")
		);
		group1.add(new ModelRendererTurbo(group1, 233, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -7, -4).setRotationAngle(0, 0, 0).setName("Box 303")
		);
		group1.add(new ModelRendererTurbo(group1, 73, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(42, -7, -4).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		group1.add(new ModelRendererTurbo(group1, 145, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 3, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(42, -6, -4).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		group1.add(new ModelRendererTurbo(group1, 161, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(40, -6, -4).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		group1.add(new ModelRendererTurbo(group1, 353, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(41, -6, -4).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		group1.add(new ModelRendererTurbo(group1, 225, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -6, 0).setRotationAngle(0, 0, -0.87266463f).setName("Box 308")
		);
		group1.add(new ModelRendererTurbo(group1, 377, 129, textureX, textureY)
			.addShapeBox(5, -1, -1, 1, 3, 3, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1)
			.setRotationPoint(36, -5, 0).setRotationAngle(0, 0, -0.87266463f).setName("Box 309")
		);
		group1.add(new ModelRendererTurbo(group1, 457, 129, textureX, textureY)
			.addShapeBox(6, -1, -1, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -5, 0).setRotationAngle(0, 0, -0.87266463f).setName("Box 310")
		);
		group1.add(new ModelRendererTurbo(group1, 113, 73, textureX, textureY)
			.addShapeBox(8, -1, -1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -4, 0).setRotationAngle(0, 0, -0.87266463f).setName("Box 311")
		);
		group1.add(new ModelRendererTurbo(group1, 145, 73, textureX, textureY)
			.addShapeBox(8, 1, -1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -4, 0).setRotationAngle(0, 0, -0.87266463f).setName("Box 312")
		);
		group1.add(new ModelRendererTurbo(group1, 161, 73, textureX, textureY)
			.addShapeBox(8, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -4, 0).setRotationAngle(0, 0, -0.87266463f).setName("Box 313")
		);
		group1.add(new ModelRendererTurbo(group1, 177, 73, textureX, textureY)
			.addShapeBox(8, -1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -4, 0).setRotationAngle(0, 0, -0.87266463f).setName("Box 314")
		);
		group1.add(new ModelRendererTurbo(group1, 193, 97, textureX, textureY)
			.addShapeBox(8, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -4, 0).setRotationAngle(0, 0, -0.87266463f).setName("Box 315")
		);
		group1.add(new ModelRendererTurbo(group1, 473, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -9, 5.5f).setRotationAngle(0, 0, 0).setName("Box 316")
		);
		group1.add(new ModelRendererTurbo(group1, 473, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -13, 9.5f).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		group1.add(new ModelRendererTurbo(group1, 401, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -1, 0, -3, -1, 0, 0, 0, 0)
			.setRotationPoint(38, -8, 7).setRotationAngle(0, 0, 0).setName("Box 318")
		);
		group1.add(new ModelRendererTurbo(group1, 161, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 3, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -10, 7).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		group1.add(new ModelRendererTurbo(group1, 33, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0)
			.setRotationPoint(34, -6, 8).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		group1.add(new ModelRendererTurbo(group1, 449, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(34, -10, 8).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		group1.add(new ModelRendererTurbo(group1, 185, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 6, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(37, -9, 2).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		group1.add(new ModelRendererTurbo(group1, 161, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, -1, 0, -2, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, -2, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(37, -9, 4).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		group1.add(new ModelRendererTurbo(group1, 233, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(31, -8, 8).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		group1.add(new ModelRendererTurbo(group1, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 7, 2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(32, -9, 8).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		group1.add(new ModelRendererTurbo(group1, 129, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(32, -8, 10).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		group1.add(new ModelRendererTurbo(group1, 289, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(31, -11, 8).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		group1.add(new ModelRendererTurbo(group1, 177, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(34, -12, 8).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		group1.add(new ModelRendererTurbo(group1, 193, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(32, -12, 8).setRotationAngle(0, 0, 0).setName("Box 329")
		);
		group1.add(new ModelRendererTurbo(group1, 249, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(36, -8, 10).setRotationAngle(0, 0, 0).setName("Box 330")
		);
		group1.add(new ModelRendererTurbo(group1, 385, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(33, -8, 10).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		group1.add(new ModelRendererTurbo(group1, 305, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32.5f, -11.5f, 10).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		group1.add(new ModelRendererTurbo(group1, 337, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(33.5f, -11.5f, 10).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		group1.add(new ModelRendererTurbo(group1, 441, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(31.5f, -11.5f, 10).setRotationAngle(0, 0, 0).setName("Box 335")
		);
		group1.add(new ModelRendererTurbo(group1, 457, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(27.5f, -8.5f, 10).setRotationAngle(0, 0, 0).setName("Box 336")
		);
		group1.add(new ModelRendererTurbo(group1, 137, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(26.5f, -8.5f, 10).setRotationAngle(0, 0, 0).setName("Box 337")
		);
		group1.add(new ModelRendererTurbo(group1, 265, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(25.5f, -8.5f, 10).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		group1.add(new ModelRendererTurbo(group1, 505, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10.5f, -8).setRotationAngle(0, 0, 0).setName("Box 340")
		);
		group1.add(new ModelRendererTurbo(group1, 145, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10, -6).setRotationAngle(0, 0, 0).setName("Box 341")
		);
		group1.add(new ModelRendererTurbo(group1, 113, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(29, -10, -3).setRotationAngle(0, 0, 0).setName("Box 342")
		);
		group1.add(new ModelRendererTurbo(group1, 225, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 343")
		);
		group1.add(new ModelRendererTurbo(group1, 313, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10.5f, 0.6f).setRotationAngle(0, 0, 0).setName("Box 344")
		);
		group1.add(new ModelRendererTurbo(group1, 457, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(29, -10, 5).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		group1.add(new ModelRendererTurbo(group1, 489, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -10, 2).setRotationAngle(0, 0, 0).setName("Box 346")
		);
		group1.add(new ModelRendererTurbo(group1, 505, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -11.5f, 8).setRotationAngle(0, 0, 0).setName("Box 347")
		);
		group1.add(new ModelRendererTurbo(group1, 1, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(27, -10, 3).setRotationAngle(0, 0, 0).setName("Box 348")
		);
		group1.add(new ModelRendererTurbo(group1, 273, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 3, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -12, 3).setRotationAngle(0, 0, 0).setName("Box 349")
		);
		group1.add(new ModelRendererTurbo(group1, 417, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 3, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -12, -5).setRotationAngle(0, 0, 0).setName("Box 350")
		);
		group1.add(new ModelRendererTurbo(group1, 73, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0)
			.setRotationPoint(27, -10, -5).setRotationAngle(0, 0, 0).setName("Box 351")
		);
		group1.add(new ModelRendererTurbo(group1, 89, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -12, -5).setRotationAngle(0, 0, 0).setName("Box 352")
		);
		group1.add(new ModelRendererTurbo(group1, 217, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -12, 3).setRotationAngle(0, 0, 0).setName("Box 353")
		);
		group1.add(new ModelRendererTurbo(group1, 297, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -13, -5).setRotationAngle(0, 0, 0).setName("Box 354")
		);
		group1.add(new ModelRendererTurbo(group1, 313, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 3, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(24, -13, -5).setRotationAngle(0, 0, 0).setName("Box 355")
		);
		group1.add(new ModelRendererTurbo(group1, 329, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(22, -13, -5).setRotationAngle(0, 0, 0).setName("Box 356")
		);
		group1.add(new ModelRendererTurbo(group1, 209, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -14, -4).setRotationAngle(0, 0, 0).setName("Box 357")
		);
		group1.add(new ModelRendererTurbo(group1, 505, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -14, 4).setRotationAngle(0, 0, 0).setName("Box 358")
		);
		group1.add(new ModelRendererTurbo(group1, 345, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(22, -13, 3).setRotationAngle(0, 0, 0).setName("Box 359")
		);
		group1.add(new ModelRendererTurbo(group1, 361, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -13, 3).setRotationAngle(0, 0, 0).setName("Box 360")
		);
		group1.add(new ModelRendererTurbo(group1, 417, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 3, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(24, -13, 3).setRotationAngle(0, 0, 0).setName("Box 361")
		);
		group1.add(new ModelRendererTurbo(group1, 465, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19, -12.5f, 3).setRotationAngle(0, 0, 0).setName("Box 362")
		);
		group1.add(new ModelRendererTurbo(group1, 481, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 3, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19, -13.5f, 3).setRotationAngle(0, 0, 0).setName("Box 363")
		);
		group1.add(new ModelRendererTurbo(group1, 497, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(19, -9.5f, 3).setRotationAngle(0, 0, 0).setName("Box 364")
		);
		group1.add(new ModelRendererTurbo(group1, 169, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19, -12.5f, 2).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		group1.add(new ModelRendererTurbo(group1, 417, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(19, -12.5f, 6).setRotationAngle(0, 0, 0).setName("Box 367")
		);
		group1.add(new ModelRendererTurbo(group1, 73, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19, -12.5f, -5).setRotationAngle(0, 0, 0).setName("Box 378")
		);
		group1.add(new ModelRendererTurbo(group1, 89, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 3, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19, -13.5f, -5).setRotationAngle(0, 0, 0).setName("Box 379")
		);
		group1.add(new ModelRendererTurbo(group1, 505, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19, -12.5f, -6).setRotationAngle(0, 0, 0).setName("Box 380")
		);
		group1.add(new ModelRendererTurbo(group1, 105, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(19, -9.5f, -5).setRotationAngle(0, 0, 0).setName("Box 381")
		);
		group1.add(new ModelRendererTurbo(group1, 97, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(19, -12.5f, -2).setRotationAngle(0, 0, 0).setName("Box 382")
		);
		group1.add(new ModelRendererTurbo(group1, 433, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(23, -9, -5).setRotationAngle(0, 0, 0).setName("Box 383")
		);
		group1.add(new ModelRendererTurbo(group1, 121, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, -1, -1, 0, 0, -1)
			.setRotationPoint(24, -9, -5).setRotationAngle(0, 0, 0).setName("Box 384")
		);
		group1.add(new ModelRendererTurbo(group1, 137, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1)
			.setRotationPoint(22, -9, -5).setRotationAngle(0, 0, 0).setName("Box 385")
		);
		group1.add(new ModelRendererTurbo(group1, 153, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(23, -9, 3).setRotationAngle(0, 0, 0).setName("Box 389")
		);
		group1.add(new ModelRendererTurbo(group1, 185, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1)
			.setRotationPoint(22, -9, 3).setRotationAngle(0, 0, 0).setName("Box 390")
		);
		group1.add(new ModelRendererTurbo(group1, 217, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, -1, -1, 0, 0, -1)
			.setRotationPoint(24, -9, 3).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		group1.add(new ModelRendererTurbo(group1, 233, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -12, 5).setRotationAngle(0, 0, -0.4712389f).setName("Box 392")
		);
		group1.add(new ModelRendererTurbo(group1, 41, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -13, 5).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		group1.add(new ModelRendererTurbo(group1, 129, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -14, -3).setRotationAngle(0, 0, 0).setName("Box 394")
		);
		group1.add(new ModelRendererTurbo(group1, 241, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(25, -13, -2).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		group1.add(new ModelRendererTurbo(group1, 249, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 3, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(25, -13, 2).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		group1.add(new ModelRendererTurbo(group1, 297, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27.5f, -11.5f, -5.5f).setRotationAngle(0, 0, 0).setName("Box 397")
		);
		group1.add(new ModelRendererTurbo(group1, 385, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -10.5f, -8).setRotationAngle(0, 0, 0).setName("Box 398")
		);
		group1.add(new ModelRendererTurbo(group1, 473, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -10.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 399")
		);
		group1.add(new ModelRendererTurbo(group1, 9, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -11.5f, 8).setRotationAngle(0, 0, 0).setName("Box 400")
		);
		group1.add(new ModelRendererTurbo(group1, 185, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -10.5f, 0.6f).setRotationAngle(0, 0, 0).setName("Box 401")
		);
		group1.add(new ModelRendererTurbo(group1, 201, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -9.5f, 0.6f).setRotationAngle(0, 0, 0).setName("Box 402")
		);
		group1.add(new ModelRendererTurbo(group1, 505, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -9.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 403")
		);
		group1.add(new ModelRendererTurbo(group1, 1, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -9.5f, -8).setRotationAngle(0, 0, 0).setName("Box 404")
		);
		group1.add(new ModelRendererTurbo(group1, 169, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -10.5f, 9).setRotationAngle(0, 0, 0).setName("Box 405")
		);
		group1.add(new ModelRendererTurbo(group1, 313, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -7.5f, -7).setRotationAngle(0, 0, 0).setName("Box 407")
		);
		group1.add(new ModelRendererTurbo(group1, 281, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -7.5f, -8).setRotationAngle(0, 0, 0).setName("Box 408")
		);
		group1.add(new ModelRendererTurbo(group1, 265, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2)
			.setRotationPoint(28, -8.5f, 9).setRotationAngle(0, 0, 0).setName("Box 409")
		);
		group1.add(new ModelRendererTurbo(group1, 425, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -6.5f, -6).setRotationAngle(0, 0, 0).setName("Box 410")
		);
		group1.add(new ModelRendererTurbo(group1, 273, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(26, -5.5f, -6).setRotationAngle(0, 0, 0).setName("Box 411")
		);
		group1.add(new ModelRendererTurbo(group1, 465, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32.5f, -14.5f, 4).setRotationAngle(0, 0, 0).setName("Box 413")
		);
		group1.add(new ModelRendererTurbo(group1, 81, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(33.5f, -14.5f, 3.5f).setRotationAngle(0, 0, 0).setName("Box 415")
		);
		group1.add(new ModelRendererTurbo(group1, 233, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(33.5f, -14.5f, 6.5f).setRotationAngle(0, 0, 0).setName("Box 416")
		);
		group1.add(new ModelRendererTurbo(group1, 321, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -7, -7).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		group1.add(new ModelRendererTurbo(group1, 337, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39, -8.5f, -7.5f).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		group1.add(new ModelRendererTurbo(group1, 481, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(28, -5, 8.5f).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		group1.add(new ModelRendererTurbo(group1, 345, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32, -14.2f, -8).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		group1.add(new ModelRendererTurbo(group1, 121, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(33, -14.2f, -8).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		group1.add(new ModelRendererTurbo(group1, 233, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(34, -14.2f, -8).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		group1.add(new ModelRendererTurbo(group1, 481, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -14.2f, -8).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		group1.add(new ModelRendererTurbo(group1, 1, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(34.5f, -14.2f, -8).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		group1.add(new ModelRendererTurbo(group1, 81, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(33.5f, -14.2f, -8).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		group1.add(new ModelRendererTurbo(group1, 105, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 10, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32.5f, -14.2f, -8).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		group1.add(new ModelRendererTurbo(group1, 25, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 4, 1, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -9, -10).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		group1.add(new ModelRendererTurbo(group1, 145, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0)
			.setRotationPoint(29, -5, -10).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		group1.add(new ModelRendererTurbo(group1, 41, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0)
			.setRotationPoint(30, -3, -9).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		group1.add(new ModelRendererTurbo(group1, 97, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 1, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(30.5f, -8, -12).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		group1.add(new ModelRendererTurbo(group1, 129, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0)
			.setRotationPoint(30.5f, -3, -11).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		group1.add(new ModelRendererTurbo(group1, 153, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(30.5f, -6, -11).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		group1.add(new ModelRendererTurbo(group1, 497, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32.5f, -6, -12).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		group1.add(new ModelRendererTurbo(group1, 177, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 1, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, -1, -2, 0, -1, -2, 0, 0, -2, 0, 0)
			.setRotationPoint(30.5f, -3, -12).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		group1.add(new ModelRendererTurbo(group1, 201, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 1, 0, -2, 0, -1, -2, 0, -1, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(30.5f, -8, -12).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		group1.add(new ModelRendererTurbo(group1, 1, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35.5f, -6, -12).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		group1.add(new ModelRendererTurbo(group1, 17, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(30.5f, -6, -12).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		group1.add(new ModelRendererTurbo(group1, 217, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -3, -2).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		group1.add(new ModelRendererTurbo(group1, 337, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20.5f, -2.5f, 3).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		group1.add(new ModelRendererTurbo(group1, 425, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20.5f, -2.5f, -3).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		group1.add(new ModelRendererTurbo(group1, 473, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(26, -3.5f, -6).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		group1.add(new ModelRendererTurbo(group1, 297, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(26, -2.5f, -6.5f).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		this.groups.add(group1);
	}

}