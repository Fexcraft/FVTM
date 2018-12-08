//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.bogie;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/bogiest1")
public class BogieST1Model extends PartModel {

	public BogieST1Model(){
		super(); textureX = 256; textureY = 256;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList axle0 = new TurboList("axle0");
		axle0.add(new ModelRendererTurbo(axle0, 233, 1, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		axle0.add(new ModelRendererTurbo(axle0, 233, 9, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 0.3926991f).setName("Box 1")
		);
		axle0.add(new ModelRendererTurbo(axle0, 97, 17, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 0.7853982f).setName("Box 2")
		);
		axle0.add(new ModelRendererTurbo(axle0, 113, 17, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 1.1780972f).setName("Box 3")
		);
		axle0.add(new ModelRendererTurbo(axle0, 153, 17, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 1.5707964f).setName("Box 4")
		);
		axle0.add(new ModelRendererTurbo(axle0, 169, 17, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 1.9634955f).setName("Box 5")
		);
		axle0.add(new ModelRendererTurbo(axle0, 185, 17, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 2.3561945f).setName("Box 6")
		);
		axle0.add(new ModelRendererTurbo(axle0, 201, 17, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 2.7488935f).setName("Box 7")
		);
		axle0.add(new ModelRendererTurbo(axle0, 217, 17, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 3.1415927f).setName("Box 8")
		);
		axle0.add(new ModelRendererTurbo(axle0, 233, 17, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 3.5342917f).setName("Box 9")
		);
		axle0.add(new ModelRendererTurbo(axle0, 1, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 3.926991f).setName("Box 10")
		);
		axle0.add(new ModelRendererTurbo(axle0, 17, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 4.3196898f).setName("Box 11")
		);
		axle0.add(new ModelRendererTurbo(axle0, 57, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 4.712389f).setName("Box 12")
		);
		axle0.add(new ModelRendererTurbo(axle0, 73, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 5.105088f).setName("Box 13")
		);
		axle0.add(new ModelRendererTurbo(axle0, 89, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 5.497787f).setName("Box 14")
		);
		axle0.add(new ModelRendererTurbo(axle0, 105, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 5.8904862f).setName("Box 15")
		);
		axle0.add(new ModelRendererTurbo(axle0, 153, 25, textureX, textureY).addBox(-6, -6, -0.1f, 12, 12, 1)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		axle0.add(new ModelRendererTurbo(axle0, 121, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		axle0.add(new ModelRendererTurbo(axle0, 185, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 0.3926991f).setName("Box 18")
		);
		axle0.add(new ModelRendererTurbo(axle0, 201, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 0.7853982f).setName("Box 19")
		);
		axle0.add(new ModelRendererTurbo(axle0, 217, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 1.1780972f).setName("Box 20")
		);
		axle0.add(new ModelRendererTurbo(axle0, 233, 25, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 1.5707964f).setName("Box 21")
		);
		axle0.add(new ModelRendererTurbo(axle0, 1, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 1.9634955f).setName("Box 22")
		);
		axle0.add(new ModelRendererTurbo(axle0, 17, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 2.3561945f).setName("Box 23")
		);
		axle0.add(new ModelRendererTurbo(axle0, 57, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 2.7488935f).setName("Box 24")
		);
		axle0.add(new ModelRendererTurbo(axle0, 73, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 3.1415927f).setName("Box 25")
		);
		axle0.add(new ModelRendererTurbo(axle0, 89, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 3.5342917f).setName("Box 26")
		);
		axle0.add(new ModelRendererTurbo(axle0, 105, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 3.926991f).setName("Box 27")
		);
		axle0.add(new ModelRendererTurbo(axle0, 121, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 4.3196898f).setName("Box 28")
		);
		axle0.add(new ModelRendererTurbo(axle0, 185, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 4.712389f).setName("Box 29")
		);
		axle0.add(new ModelRendererTurbo(axle0, 201, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 5.105088f).setName("Box 30")
		);
		axle0.add(new ModelRendererTurbo(axle0, 217, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 5.497787f).setName("Box 31")
		);
		axle0.add(new ModelRendererTurbo(axle0, 233, 33, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(16, -16, -16).setRotationAngle(0, 0, 5.8904862f).setName("Box 32")
		);
		axle0.add(new ModelRendererTurbo(axle0, 193, 41, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		axle0.add(new ModelRendererTurbo(axle0, 209, 41, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 0.3926991f).setName("Box 34")
		);
		axle0.add(new ModelRendererTurbo(axle0, 225, 41, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 0.7853982f).setName("Box 35")
		);
		axle0.add(new ModelRendererTurbo(axle0, 241, 41, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 1.1780972f).setName("Box 36")
		);
		axle0.add(new ModelRendererTurbo(axle0, 1, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 1.5707964f).setName("Box 37")
		);
		axle0.add(new ModelRendererTurbo(axle0, 17, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 1.9634955f).setName("Box 38")
		);
		axle0.add(new ModelRendererTurbo(axle0, 33, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 2.3561945f).setName("Box 39")
		);
		axle0.add(new ModelRendererTurbo(axle0, 89, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 2.7488935f).setName("Box 40")
		);
		axle0.add(new ModelRendererTurbo(axle0, 105, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 3.1415927f).setName("Box 41")
		);
		axle0.add(new ModelRendererTurbo(axle0, 121, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 3.5342917f).setName("Box 42")
		);
		axle0.add(new ModelRendererTurbo(axle0, 137, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 3.926991f).setName("Box 43")
		);
		axle0.add(new ModelRendererTurbo(axle0, 153, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 4.3196898f).setName("Box 44")
		);
		axle0.add(new ModelRendererTurbo(axle0, 169, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 4.712389f).setName("Box 45")
		);
		axle0.add(new ModelRendererTurbo(axle0, 185, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 5.105088f).setName("Box 46")
		);
		axle0.add(new ModelRendererTurbo(axle0, 201, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 5.497787f).setName("Box 47")
		);
		axle0.add(new ModelRendererTurbo(axle0, 217, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(16, -16, 16).setRotationAngle(0, 0, 5.8904862f).setName("Box 48")
		);
		axle0.add(new ModelRendererTurbo(axle0, 1, 57, textureX, textureY).addBox(-6, -6, -0.1f, 12, 12, 1)
			.setRotationPoint(16, -16, 15).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		axle0.add(new ModelRendererTurbo(axle0, 233, 49, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		axle0.add(new ModelRendererTurbo(axle0, 33, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 0.3926991f).setName("Box 51")
		);
		axle0.add(new ModelRendererTurbo(axle0, 89, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 0.7853982f).setName("Box 52")
		);
		axle0.add(new ModelRendererTurbo(axle0, 105, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 1.1780972f).setName("Box 53")
		);
		axle0.add(new ModelRendererTurbo(axle0, 121, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 1.5707964f).setName("Box 54")
		);
		axle0.add(new ModelRendererTurbo(axle0, 137, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 1.9634955f).setName("Box 55")
		);
		axle0.add(new ModelRendererTurbo(axle0, 153, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 2.3561945f).setName("Box 56")
		);
		axle0.add(new ModelRendererTurbo(axle0, 169, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 2.7488935f).setName("Box 57")
		);
		axle0.add(new ModelRendererTurbo(axle0, 185, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 3.1415927f).setName("Box 58")
		);
		axle0.add(new ModelRendererTurbo(axle0, 201, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 3.5342917f).setName("Box 59")
		);
		axle0.add(new ModelRendererTurbo(axle0, 217, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 3.926991f).setName("Box 60")
		);
		axle0.add(new ModelRendererTurbo(axle0, 233, 57, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 4.3196898f).setName("Box 61")
		);
		axle0.add(new ModelRendererTurbo(axle0, 33, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 4.712389f).setName("Box 62")
		);
		axle0.add(new ModelRendererTurbo(axle0, 89, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 5.105088f).setName("Box 63")
		);
		axle0.add(new ModelRendererTurbo(axle0, 105, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 5.497787f).setName("Box 64")
		);
		axle0.add(new ModelRendererTurbo(axle0, 121, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(16, -16, 13).setRotationAngle(0, 0, 5.8904862f).setName("Box 65")
		);
		axle0.add(new ModelRendererTurbo(axle0, 97, 57, textureX, textureY).addBox(-1, -1, -17, 2, 2, 34)
			.setRotationPoint(16, -16, 0).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		axle0.addPrograms(DefaultPrograms.ROTATED_WHEEL_ROTATE, DefaultPrograms.ADJUSTABLE_BOGIE);
		this.groups.add(axle0);
		//
		TurboList axle1 = new TurboList("axle1");
		axle1.add(new ModelRendererTurbo(axle1, 137, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		axle1.add(new ModelRendererTurbo(axle1, 153, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 0.3926991f).setName("Box 68")
		);
		axle1.add(new ModelRendererTurbo(axle1, 169, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 0.7853982f).setName("Box 69")
		);
		axle1.add(new ModelRendererTurbo(axle1, 185, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 1.1780972f).setName("Box 70")
		);
		axle1.add(new ModelRendererTurbo(axle1, 201, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 1.5707964f).setName("Box 71")
		);
		axle1.add(new ModelRendererTurbo(axle1, 217, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 1.9634955f).setName("Box 72")
		);
		axle1.add(new ModelRendererTurbo(axle1, 233, 65, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 2.3561945f).setName("Box 73")
		);
		axle1.add(new ModelRendererTurbo(axle1, 1, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 2.7488935f).setName("Box 74")
		);
		axle1.add(new ModelRendererTurbo(axle1, 17, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 3.1415927f).setName("Box 75")
		);
		axle1.add(new ModelRendererTurbo(axle1, 33, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 3.5342917f).setName("Box 76")
		);
		axle1.add(new ModelRendererTurbo(axle1, 89, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 3.926991f).setName("Box 77")
		);
		axle1.add(new ModelRendererTurbo(axle1, 105, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 4.3196898f).setName("Box 78")
		);
		axle1.add(new ModelRendererTurbo(axle1, 137, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 4.712389f).setName("Box 79")
		);
		axle1.add(new ModelRendererTurbo(axle1, 153, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 5.105088f).setName("Box 80")
		);
		axle1.add(new ModelRendererTurbo(axle1, 169, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 5.497787f).setName("Box 81")
		);
		axle1.add(new ModelRendererTurbo(axle1, 185, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 5.8904862f).setName("Box 82")
		);
		axle1.add(new ModelRendererTurbo(axle1, 201, 73, textureX, textureY).addBox(-6, -6, -0.1f, 12, 12, 1)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		axle1.add(new ModelRendererTurbo(axle1, 121, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		axle1.add(new ModelRendererTurbo(axle1, 233, 73, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 0.3926991f).setName("Box 85")
		);
		axle1.add(new ModelRendererTurbo(axle1, 1, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 0.7853982f).setName("Box 86")
		);
		axle1.add(new ModelRendererTurbo(axle1, 17, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 1.1780972f).setName("Box 87")
		);
		axle1.add(new ModelRendererTurbo(axle1, 33, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 1.5707964f).setName("Box 88")
		);
		axle1.add(new ModelRendererTurbo(axle1, 89, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 1.9634955f).setName("Box 89")
		);
		axle1.add(new ModelRendererTurbo(axle1, 105, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 2.3561945f).setName("Box 90")
		);
		axle1.add(new ModelRendererTurbo(axle1, 121, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 2.7488935f).setName("Box 91")
		);
		axle1.add(new ModelRendererTurbo(axle1, 137, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 3.1415927f).setName("Box 92")
		);
		axle1.add(new ModelRendererTurbo(axle1, 153, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 3.5342917f).setName("Box 93")
		);
		axle1.add(new ModelRendererTurbo(axle1, 169, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 3.926991f).setName("Box 94")
		);
		axle1.add(new ModelRendererTurbo(axle1, 185, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 4.3196898f).setName("Box 95")
		);
		axle1.add(new ModelRendererTurbo(axle1, 233, 81, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 4.712389f).setName("Box 96")
		);
		axle1.add(new ModelRendererTurbo(axle1, 1, 89, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 5.105088f).setName("Box 97")
		);
		axle1.add(new ModelRendererTurbo(axle1, 17, 89, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 5.497787f).setName("Box 98")
		);
		axle1.add(new ModelRendererTurbo(axle1, 33, 89, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f)
			.setRotationPoint(-16, -16, -16).setRotationAngle(0, 0, 5.8904862f).setName("Box 99")
		);
		axle1.add(new ModelRendererTurbo(axle1, 177, 89, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		axle1.add(new ModelRendererTurbo(axle1, 193, 89, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 0.3926991f).setName("Box 101")
		);
		axle1.add(new ModelRendererTurbo(axle1, 209, 89, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 0.7853982f).setName("Box 102")
		);
		axle1.add(new ModelRendererTurbo(axle1, 225, 89, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 1.1780972f).setName("Box 103")
		);
		axle1.add(new ModelRendererTurbo(axle1, 241, 89, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 1.5707964f).setName("Box 104")
		);
		axle1.add(new ModelRendererTurbo(axle1, 137, 97, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 1.9634955f).setName("Box 105")
		);
		axle1.add(new ModelRendererTurbo(axle1, 153, 97, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 2.3561945f).setName("Box 106")
		);
		axle1.add(new ModelRendererTurbo(axle1, 169, 97, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 2.7488935f).setName("Box 107")
		);
		axle1.add(new ModelRendererTurbo(axle1, 185, 97, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 3.1415927f).setName("Box 108")
		);
		axle1.add(new ModelRendererTurbo(axle1, 201, 97, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 3.5342917f).setName("Box 109")
		);
		axle1.add(new ModelRendererTurbo(axle1, 217, 97, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 3.926991f).setName("Box 110")
		);
		axle1.add(new ModelRendererTurbo(axle1, 233, 97, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 4.3196898f).setName("Box 111")
		);
		axle1.add(new ModelRendererTurbo(axle1, 1, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 4.712389f).setName("Box 112")
		);
		axle1.add(new ModelRendererTurbo(axle1, 17, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 5.105088f).setName("Box 113")
		);
		axle1.add(new ModelRendererTurbo(axle1, 33, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 5.497787f).setName("Box 114")
		);
		axle1.add(new ModelRendererTurbo(axle1, 49, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, -1, 3, 2, 2, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0)
			.setRotationPoint(-16, -16, 16).setRotationAngle(0, 0, 5.8904862f).setName("Box 115")
		);
		axle1.add(new ModelRendererTurbo(axle1, 65, 105, textureX, textureY).addBox(-6, -6, -0.1f, 12, 12, 1)
			.setRotationPoint(-16, -16, 15).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		axle1.add(new ModelRendererTurbo(axle1, 97, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		axle1.add(new ModelRendererTurbo(axle1, 113, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 0.3926991f).setName("Box 118")
		);
		axle1.add(new ModelRendererTurbo(axle1, 129, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 0.7853982f).setName("Box 119")
		);
		axle1.add(new ModelRendererTurbo(axle1, 145, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 1.1780972f).setName("Box 120")
		);
		axle1.add(new ModelRendererTurbo(axle1, 161, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 1.5707964f).setName("Box 121")
		);
		axle1.add(new ModelRendererTurbo(axle1, 177, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 1.9634955f).setName("Box 122")
		);
		axle1.add(new ModelRendererTurbo(axle1, 193, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 2.3561945f).setName("Box 123")
		);
		axle1.add(new ModelRendererTurbo(axle1, 209, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 2.7488935f).setName("Box 124")
		);
		axle1.add(new ModelRendererTurbo(axle1, 225, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 3.1415927f).setName("Box 125")
		);
		axle1.add(new ModelRendererTurbo(axle1, 241, 105, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 3.5342917f).setName("Box 126")
		);
		axle1.add(new ModelRendererTurbo(axle1, 1, 113, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 3.926991f).setName("Box 127")
		);
		axle1.add(new ModelRendererTurbo(axle1, 17, 113, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 4.3196898f).setName("Box 128")
		);
		axle1.add(new ModelRendererTurbo(axle1, 33, 113, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 4.712389f).setName("Box 129")
		);
		axle1.add(new ModelRendererTurbo(axle1, 49, 113, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 5.105088f).setName("Box 130")
		);
		axle1.add(new ModelRendererTurbo(axle1, 97, 113, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 5.497787f).setName("Box 131")
		);
		axle1.add(new ModelRendererTurbo(axle1, 113, 113, textureX, textureY)
			.addShapeBox(-1.5f, 6, 1, 3, 3, 1, 0, -0.3f, 0, -0.5f, -0.3f, 0, -0.5f, -0.3f, 0, 0, -0.3f, 0, 0, 0.3f, 0, -0.5f, 0.3f, 0, -0.5f, 0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(-16, -16, 13).setRotationAngle(0, 0, 5.8904862f).setName("Box 132")
		);
		axle1.add(new ModelRendererTurbo(axle1, 73, 105, textureX, textureY).addBox(-1, -1, -17, 2, 2, 34)
			.setRotationPoint(-16, -16, 0).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		axle1.addPrograms(DefaultPrograms.ROTATED_WHEEL_ROTATE, DefaultPrograms.ADJUSTABLE_BOGIE);
		this.groups.add(axle1);
		//
		TurboList chassis = new TurboList("chassis");
		chassis.add(new ModelRendererTurbo(chassis, 113, 113, textureX, textureY)
			.addShapeBox(-4, 0, 0, 8, 5, 13, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0)
			.setRotationPoint(0, -20, 5).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		chassis.add(new ModelRendererTurbo(chassis, 145, 113, textureX, textureY).addBox(0, 0, 0, 32, 2, 2)
			.setRotationPoint(-16, -20, 17.2f).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		chassis.add(new ModelRendererTurbo(chassis, 217, 113, textureX, textureY).addBox(0, 0, 0, 2, 6, 2)
			.setRotationPoint(-5, -18, 17.2f).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		chassis.add(new ModelRendererTurbo(chassis, 233, 113, textureX, textureY).addBox(0, 0, 0, 2, 6, 2)
			.setRotationPoint(3, -18, 17.2f).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 2, 3, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-6, -12, 16.4f).setRotationAngle(0, 0, 0).setName("Box 153")
		);
		chassis.add(new ModelRendererTurbo(chassis, 25, 121, textureX, textureY)
			.addShapeBox(-4, 0, -13, 8, 5, 13, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -20, -5).setRotationAngle(0, 0, 0).setName("Box 154")
		);
		chassis.add(new ModelRendererTurbo(chassis, 161, 121, textureX, textureY).addBox(-4, 0, -10, 8, 5, 10)
			.setRotationPoint(0, -20, 5).setRotationAngle(0, 0, 0).setName("Box 155")
		);
		chassis.add(new ModelRendererTurbo(chassis, 57, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, -6, -2, 0, 5, -4, 0, 5, -4, 0, -6, -2, 0)
			.setRotationPoint(-12, -18, 17.2f).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		chassis.add(new ModelRendererTurbo(chassis, 73, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 1, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 1, 0, -0.1f, 5, -4, -0.1f, -6, -2, -0.1f, -6, -2, -0.1f, 5, -4, -0.1f)
			.setRotationPoint(10, -18, 17.2f).setRotationAngle(0, 0, 0).setName("Box 157")
		);
		chassis.add(new ModelRendererTurbo(chassis, 89, 121, textureX, textureY).addBox(0, 0, 0, 4, 4, 3)
			.setRotationPoint(-18, -18, 16.5f).setRotationAngle(0, 0, 0).setName("Box 158")
		);
		chassis.add(new ModelRendererTurbo(chassis, 193, 121, textureX, textureY).addBox(0, 0, 0, 4, 4, 3)
			.setRotationPoint(14, -18, 16.5f).setRotationAngle(0, 0, 0).setName("Box 159")
		);
		chassis.add(new ModelRendererTurbo(chassis, 113, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-19, -20, 17.2f).setRotationAngle(0, 0, 0).setName("Box 160")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-19, -18, 17.2f).setRotationAngle(0, 0, 0).setName("Box 161")
		);
		chassis.add(new ModelRendererTurbo(chassis, 145, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16, -20, 17.2f).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -18, 17.2f).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		chassis.add(new ModelRendererTurbo(chassis, 161, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(0.5f, -18, 17.65f).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		chassis.add(new ModelRendererTurbo(chassis, 209, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-2.5f, -18, 17.65f).setRotationAngle(0, 0, 0).setName("Box 165")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 2, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-4, -18.8f, 17.75f).setRotationAngle(0, 0, 0).setName("Box 166")
		);
		chassis.add(new ModelRendererTurbo(chassis, 217, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 2, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-4, -12.2f, 17.75f).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 2, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -18.8f, -19.75f).setRotationAngle(0, 0, 0).setName("Box 168")
		);
		chassis.add(new ModelRendererTurbo(chassis, 241, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.5f, -18, -19.65f).setRotationAngle(0, 0, 0).setName("Box 169")
		);
		chassis.add(new ModelRendererTurbo(chassis, 89, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0.5f, -18, -19.65f).setRotationAngle(0, 0, 0).setName("Box 170")
		);
		chassis.add(new ModelRendererTurbo(chassis, 201, 129, textureX, textureY).addBox(0, 0, 0, 2, 6, 2)
			.setRotationPoint(3, -18, -19.2f).setRotationAngle(0, 0, 0).setName("Box 171")
		);
		chassis.add(new ModelRendererTurbo(chassis, 153, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 2, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -12.2f, -19.75f).setRotationAngle(0, 0, 0).setName("Box 172")
		);
		chassis.add(new ModelRendererTurbo(chassis, 177, 137, textureX, textureY).addBox(0, 0, 0, 2, 6, 2)
			.setRotationPoint(-5, -18, -19.2f).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		chassis.add(new ModelRendererTurbo(chassis, 209, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 2, 3, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-6, -12, -19.4f).setRotationAngle(0, 0, 0).setName("Box 174")
		);
		chassis.add(new ModelRendererTurbo(chassis, 193, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, -6, -2, 0, 5, -4, 0, 5, -4, 0, -6, -2, 0)
			.setRotationPoint(-12, -18, -19.2f).setRotationAngle(0, 0, 0).setName("Box 175")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 145, textureX, textureY).addBox(0, 0, 0, 32, 2, 2)
			.setRotationPoint(-16, -20, -19.2f).setRotationAngle(0, 0, 0).setName("Box 176")
		);
		chassis.add(new ModelRendererTurbo(chassis, 241, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 10, 2, 0, 1, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 1, 0, -0.1f, 5, -4, -0.1f, -6, -2, -0.1f, -6, -2, -0.1f, 5, -4, -0.1f)
			.setRotationPoint(10, -18, -19.2f).setRotationAngle(0, 0, 0).setName("Box 177")
		);
		chassis.add(new ModelRendererTurbo(chassis, 25, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16, -20, -19.2f).setRotationAngle(0, 0, 0).setName("Box 178")
		);
		chassis.add(new ModelRendererTurbo(chassis, 129, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -18, -19.2f).setRotationAngle(0, 0, 0).setName("Box 179")
		);
		chassis.add(new ModelRendererTurbo(chassis, 73, 145, textureX, textureY).addBox(0, 0, 0, 4, 4, 3)
			.setRotationPoint(14, -18, -19.5f).setRotationAngle(0, 0, 0).setName("Box 180")
		);
		chassis.add(new ModelRendererTurbo(chassis, 89, 145, textureX, textureY).addBox(0, 0, 0, 4, 4, 3)
			.setRotationPoint(-18, -18, -19.5f).setRotationAngle(0, 0, 0).setName("Box 181")
		);
		chassis.add(new ModelRendererTurbo(chassis, 105, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-19, -20, -19.2f).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-19, -18, -19.2f).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		chassis.add(new ModelRendererTurbo(chassis, 89, 41, textureX, textureY)
			.addShapeBox(2, 0, -1.5f, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.8f, 0, 0, 0.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -20.5f, 0).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		chassis.add(new ModelRendererTurbo(chassis, 225, 121, textureX, textureY)
			.addShapeBox(-3, 0, -1.5f, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0.8f, 0, 0)
			.setRotationPoint(0, -20.5f, 0).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		chassis.add(new ModelRendererTurbo(chassis, 121, 145, textureX, textureY)
			.addShapeBox(-1.5f, 0, -3, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.8f, 0, 0, 0.8f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -20.5f, 0).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		chassis.add(new ModelRendererTurbo(chassis, 137, 145, textureX, textureY)
			.addShapeBox(-1.5f, 0, 2, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.8f, 0, 0, 0.8f)
			.setRotationPoint(0, -20.5f, 0).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		chassis.add(new ModelRendererTurbo(chassis, 33, 25, textureX, textureY)
			.addShapeBox(-3, 0, -2.5f, 1, 1, 1, 0, -1.5f, 0, 0.5f, 0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0.5f, 0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -20.5f, 0).setRotationAngle(0, 0, 0).setName("Box 188")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 25, textureX, textureY)
			.addShapeBox(2, 0, -2.5f, 1, 1, 1, 0, 0.5f, 0, -0.5f, -1.5f, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0.5f, 0, -0.5f, -1.5f, 0, 0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -20.5f, 0).setRotationAngle(0, 0, 0).setName("Box 189")
		);
		chassis.add(new ModelRendererTurbo(chassis, 33, 33, textureX, textureY)
			.addShapeBox(2, 0, 1.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0.5f, 0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1.5f, 0, 0.5f, 0.5f, 0, -0.5f)
			.setRotationPoint(0, -20.5f, 0).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		chassis.add(new ModelRendererTurbo(chassis, 249, 33, textureX, textureY)
			.addShapeBox(-3, 0, 1.5f, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, -0.5f, -1.5f, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0.5f, 0, -0.5f, -1.5f, 0, 0.5f)
			.setRotationPoint(0, -20.5f, 0).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		chassis.addProgram(DefaultPrograms.ADJUSTABLE_BOGIE);
		this.groups.add(chassis);
	}

}