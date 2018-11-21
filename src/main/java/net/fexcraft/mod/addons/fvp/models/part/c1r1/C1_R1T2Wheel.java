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
@fModel(registryname = "fvp:models/part/c1_r1_t2_wheel")
public class C1_R1T2Wheel extends PartModel {

	public C1_R1T2Wheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel_type2 = new TurboList("wheel_type2");
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 217, 209, textureX, textureY).addBox(-2, -2, 0, 4, 4, 3).setName("Box 632"));
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 241, 209, textureX, textureY)
			.addShapeBox(-2, -3, 0, 4, 1, 3, 0, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).setName("Box 633")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 217, 217, textureX, textureY)
			.addShapeBox(-2, 2, 0, 4, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1, 0, -1).setName("Box 634")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 209, 41, textureX, textureY)
			.addShapeBox(2, -2, 0, 1, 4, 3, 0, 0, 0, 0, 0, -1, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, -1, 0, 0, 0).setName("Box 635")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 241, 217, textureX, textureY)
			.addShapeBox(-3, -2, 0, 1, 4, 3, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1).setName("Box 636")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 217, 129, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, 0).setName("Box 637")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 425, 129, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, -0.69813174f).setName("Box 638")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 241, 137, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, -1.3962635f).setName("Box 639")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 329, 137, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, -2.0943952f).setName("Box 640")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 481, 145, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, -2.792527f).setName("Box 641")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 497, 145, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, -3.4906585f).setName("Box 642")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 361, 153, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, -4.1887903f).setName("Box 643")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 25, 161, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, -4.886922f).setName("Box 644")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 161, textureX, textureY).addBox(-1, 1, -2, 2, 6, 1)
			.setRotationPoint(0, 0, 3).setRotationAngle(0.06981317f, 0, -5.585054f).setName("Box 645")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 441, 25, textureX, textureY)
			.addShapeBox(-1, -1, 0, 2, 2, 1, 0, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0.5f, 0.5f, 0, 0.5f, 0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(0, 0, 3).setRotationAngle(0, 0, 0).setName("Box 646")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0).setName("Box 647")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -0.3926991f).setName("Box 649")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -0.7853982f).setName("Box 650")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.1780972f).setName("Box 651")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.5707964f).setName("Box 653")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.9634955f).setName("Box 654")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -2.3561945f).setName("Box 655")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -2.7488935f).setName("Box 656")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.1415927f).setName("Box 657")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.5342917f).setName("Box 658")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.926991f).setName("Box 659")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -4.3196898f).setName("Box 660")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -4.712389f).setName("Box 661")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.105088f).setName("Box 662")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.497787f).setName("Box 663")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 41, 225, textureX, textureY)
			.addShapeBox(0, 6.5f, -0.5f, 4, 3, 5, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.5f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.35f, -0.75f, 0, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.8904862f).setName("Box 664")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f).setName("Box 665")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -0.3926991f).setName("Box 666")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -0.7853982f).setName("Box 667")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.1780972f).setName("Box 668")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.5707964f).setName("Box 669")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.9634955f).setName("Box 670")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -2.3561945f).setName("Box 671")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -2.7488935f).setName("Box 672")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.1415927f).setName("Box 673")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.5342917f).setName("Box 674")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.926991f).setName("Box 675")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -4.3196898f).setName("Box 676")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -4.712389f).setName("Box 677")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.105088f).setName("Box 678")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.497787f).setName("Box 679")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, 4.5f, 4, 3, 1, 0, 0, 0, 0, -1.5f, 0.45f, 0, -1.3f, -0.05f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.35f, -0.75f, 0, -0.6f, -1.25f, -0.5f, 0, -0.5f, -0.5f)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.8904862f).setName("Box 680")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0).setName("Box 681")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -0.3926991f).setName("Box 682")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -0.7853982f).setName("Box 683")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.1780972f).setName("Box 684")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.5707964f).setName("Box 685")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -1.9634955f).setName("Box 686")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -2.3561945f).setName("Box 687")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -2.7488935f).setName("Box 688")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.1415927f).setName("Box 689")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.5342917f).setName("Box 690")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -3.926991f).setName("Box 691")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -4.3196898f).setName("Box 692")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -4.712389f).setName("Box 693")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.105088f).setName("Box 694")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.497787f).setName("Box 695")
		);
		wheel_type2.add(new ModelRendererTurbo(wheel_type2, 201, 209, textureX, textureY)
			.addShapeBox(0, 6.5f, -1.5f, 4, 3, 1, 0, 0, -0.5f, -0.5f, -1.3f, -0.05f, -0.5f, -1.5f, 0.45f, 0, 0, 0, 0, 0, -0.5f, -0.5f, -0.6f, -1.25f, -0.5f, -0.35f, -0.75f, 0, 0, 0, 0)
			.setRotationPoint(0, 0, 0).setRotationAngle(0, 0, -5.8904862f).setName("Box 696")
		);
		wheel_type2.addPrograms(DefaultPrograms.ADJUSTABLE_WHEEL, DefaultPrograms.ROTATED_WHEEL_ROTATE);
		this.groups.add(wheel_type2);
		//
	}

}