//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c2;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c2r2t1_wheel")
public class C2R2T1Wheel extends PartModel {

	public C2R2T1Wheel(){
		super(); textureX = 128; textureY = 64;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel = new TurboList("wheel");
		wheel.add(new ModelRendererTurbo(wheel, 1, 1, textureX, textureY).addBox(-1.5f, -1.5f, -1, 3, 3, 2).setName("Import Box18"));
		wheel.add(new ModelRendererTurbo(wheel, 17, 1, textureX, textureY).addBox(-1, -1, -2, 2, 2, 1).setName("Import Box19"));
		wheel.add(new ModelRendererTurbo(wheel, 25, 1, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 1, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, -0.75f, -0.75f, -0.5f, -0.75f, -0.75f, -0.5f, 0, 0, 0, 0, 0, 0, -0.75f, -0.75f, -0.5f, -0.75f, -0.75f, -0.5f).setName("Import Box20")
		);
		wheel.add(new ModelRendererTurbo(wheel, 41, 1, textureX, textureY)
			.addShapeBox(0, 6, -2.5f, 3, 2, 4, 0, 0, 0, 0, -0.7f, 0.45f, 0, -0.7f, 0.45f, 0, 0, 0, 0, 0, 0, 0, 0.06f, -0.6f, 0, 0.06f, -0.6f, 0, 0, 0, 0).setName("Import Box47")
		);
		wheel.add(new ModelRendererTurbo(wheel, 57, 1, textureX, textureY)
			.addShapeBox(-3, 6, -2.5f, 3, 2, 4, 0, -0.7f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.7f, 0.45f, 0, 0.06f, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0.06f, -0.6f, 0).setName("Import Box48")
		);
		wheel.add(new ModelRendererTurbo(wheel, 73, 1, textureX, textureY)
			.addShapeBox(0, -8, -2.5f, 3, 2, 4, 0, 0, 0, 0, 0.06f, -0.6f, 0, 0.06f, -0.6f, 0, 0, 0, 0, 0, 0, 0, -0.7f, 0.45f, 0, -0.7f, 0.45f, 0, 0, 0, 0).setName("Import Box49")
		);
		wheel.add(new ModelRendererTurbo(wheel, 89, 1, textureX, textureY)
			.addShapeBox(-3, -8, -2.5f, 3, 2, 4, 0, 0.06f, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0.06f, -0.6f, 0, -0.7f, 0.45f, 0, 0, 0, 0, 0, 0, 0, -0.7f, 0.45f, 0).setName("Import Box50")
		);
		wheel.add(new ModelRendererTurbo(wheel, 105, 1, textureX, textureY)
			.addShapeBox(6, 0, -2.5f, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.45f, -0.7f, 0, -0.6f, 0.06f, 0, -0.6f, 0.06f, 0, 0.45f, -0.7f, 0).setName("Import Box51")
		);
		wheel.add(new ModelRendererTurbo(wheel, 1, 9, textureX, textureY)
			.addShapeBox(6, -3, -2.5f, 2, 3, 4, 0, 0.45f, -0.7f, 0, -0.6f, 0.06f, 0, -0.6f, 0.06f, 0, 0.45f, -0.7f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).setName("Import Box65")
		);
		wheel.add(new ModelRendererTurbo(wheel, 17, 9, textureX, textureY)
			.addShapeBox(-8, -3, -2.5f, 2, 3, 4, 0, -0.6f, 0.06f, 0, 0.45f, -0.7f, 0, 0.45f, -0.7f, 0, -0.6f, 0.06f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).setName("Import Box66")
		);
		wheel.add(new ModelRendererTurbo(wheel, 33, 9, textureX, textureY)
			.addShapeBox(-8, 0, -2.5f, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.6f, 0.06f, 0, 0.45f, -0.7f, 0, 0.45f, -0.7f, 0, -0.6f, 0.06f, 0).setName("Import Box67")
		);
		wheel.add(new ModelRendererTurbo(wheel, 49, 9, textureX, textureY)
			.addShapeBox(3, 5, -2.5f, 3, 2, 4, 0, 0.7f, -0.55f, 0, -1.8f, 0.8f, 0, -1.8f, 0.8f, 0, 0.7f, -0.55f, 0, -0.05f, 0.4f, 0, -0.35f, -1.35f, 0, -0.35f, -1.35f, 0, -0.05f, 0.4f, 0).setName("Import Box71")
		);
		wheel.add(new ModelRendererTurbo(wheel, 65, 9, textureX, textureY)
			.addShapeBox(5, 3, -2.5f, 2, 3, 4, 0, -0.55f, 0.7f, 0, 0.4f, -0.05f, 0, 0.4f, -0.05f, 0, -0.55f, 0.7f, 0, 0.8f, -1.8f, 0, -1.35f, -0.35f, 0, -1.35f, -0.35f, 0, 0.8f, -1.8f, 0).setName("Import Box73")
		);
		wheel.add(new ModelRendererTurbo(wheel, 81, 9, textureX, textureY)
			.addShapeBox(3, -7, -2.5f, 3, 2, 4, 0, -0.05f, 0.4f, 0, -0.35f, -1.35f, 0, -0.35f, -1.35f, 0, -0.05f, 0.4f, 0, 0.7f, -0.55f, 0, -1.8f, 0.8f, 0, -1.8f, 0.8f, 0, 0.7f, -0.55f, 0).setName("Import Box74")
		);
		wheel.add(new ModelRendererTurbo(wheel, 97, 9, textureX, textureY)
			.addShapeBox(-6, -7, -2.5f, 3, 2, 4, 0, -0.35f, -1.35f, 0, -0.05f, 0.4f, 0, -0.05f, 0.4f, 0, -0.35f, -1.35f, 0, -1.8f, 0.8f, 0, 0.7f, -0.55f, 0, 0.7f, -0.55f, 0, -1.8f, 0.8f, 0).setName("Import Box75")
		);
		wheel.add(new ModelRendererTurbo(wheel, 113, 9, textureX, textureY)
			.addShapeBox(-6, 5, -2.5f, 3, 2, 4, 0, -1.8f, 0.8f, 0, 0.7f, -0.55f, 0, 0.7f, -0.55f, 0, -1.8f, 0.8f, 0, -0.35f, -1.35f, 0, -0.05f, 0.4f, 0, -0.05f, 0.4f, 0, -0.35f, -1.35f, 0).setName("Import Box76")
		);
		wheel.add(new ModelRendererTurbo(wheel, 1, 17, textureX, textureY)
			.addShapeBox(-7, 3, -2.5f, 2, 3, 4, 0, 0.4f, -0.05f, 0, -0.55f, 0.7f, 0, -0.55f, 0.7f, 0, 0.4f, -0.05f, 0, -1.35f, -0.35f, 0, 0.8f, -1.8f, 0, 0.8f, -1.8f, 0, -1.35f, -0.35f, 0).setName("Import Box77")
		);
		wheel.add(new ModelRendererTurbo(wheel, 17, 17, textureX, textureY)
			.addShapeBox(-7, -6, -2.5f, 2, 3, 4, 0, -1.35f, -0.35f, 0, 0.8f, -1.8f, 0, 0.8f, -1.8f, 0, -1.35f, -0.35f, 0, 0.4f, -0.05f, 0, -0.55f, 0.7f, 0, -0.55f, 0.7f, 0, 0.4f, -0.05f, 0).setName("Import Box78")
		);
		wheel.add(new ModelRendererTurbo(wheel, 33, 17, textureX, textureY)
			.addShapeBox(5, -6, -2.5f, 2, 3, 4, 0, 0.8f, -1.8f, 0, -1.35f, -0.35f, 0, -1.35f, -0.35f, 0, 0.8f, -1.8f, 0, -0.55f, 0.7f, 0, 0.4f, -0.05f, 0, 0.4f, -0.05f, 0, -0.55f, 0.7f, 0).setName("Import Box79")
		);
		wheel.add(new ModelRendererTurbo(wheel, 49, 17, textureX, textureY)
			.addShapeBox(0, 5, -2.5f, 3, 1, 4, 0, 0, 0, -0.2f, -0.7f, 0.45f, -0.2f, -0.7f, 0.45f, -0.2f, 0, 0, -0.2f, 0, 0, -0.1f, 0.06f, -0.6f, -0.1f, 0.06f, -0.6f, -0.1f, 0, 0, -0.1f).setName("Import Box81")
		);
		wheel.add(new ModelRendererTurbo(wheel, 65, 17, textureX, textureY)
			.addShapeBox(-3, 5, -2.5f, 3, 1, 4, 0, -0.7f, 0.45f, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, -0.7f, 0.45f, -0.2f, 0.06f, -0.6f, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0.06f, -0.6f, -0.1f).setName("Import Box82")
		);
		wheel.add(new ModelRendererTurbo(wheel, 81, 17, textureX, textureY)
			.addShapeBox(-3, -6, -2.5f, 3, 1, 4, 0, 0.06f, -0.6f, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0.06f, -0.6f, -0.1f, -0.7f, 0.45f, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, -0.7f, 0.45f, -0.2f).setName("Import Box83")
		);
		wheel.add(new ModelRendererTurbo(wheel, 97, 17, textureX, textureY)
			.addShapeBox(0, -6, -2.5f, 3, 1, 4, 0, 0, 0, -0.1f, 0.06f, -0.6f, -0.1f, 0.06f, -0.6f, -0.1f, 0, 0, -0.1f, 0, 0, -0.2f, -0.7f, 0.45f, -0.2f, -0.7f, 0.45f, -0.2f, 0, 0, -0.2f).setName("Import Box84")
		);
		wheel.add(new ModelRendererTurbo(wheel, 113, 17, textureX, textureY)
			.addShapeBox(5, -3, -2.5f, 1, 3, 4, 0, 0.45f, -0.7f, -0.2f, -0.6f, 0.06f, -0.1f, -0.6f, 0.06f, -0.1f, 0.45f, -0.7f, -0.2f, 0, 0, -0.2f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.2f).setName("Import Box85")
		);
		wheel.add(new ModelRendererTurbo(wheel, 1, 25, textureX, textureY)
			.addShapeBox(5, 0, -2.5f, 1, 3, 4, 0, 0, 0, -0.2f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.2f, 0.45f, -0.7f, -0.2f, -0.6f, 0.06f, -0.1f, -0.6f, 0.06f, -0.1f, 0.45f, -0.7f, -0.2f).setName("Import Box86")
		);
		wheel.add(new ModelRendererTurbo(wheel, 17, 25, textureX, textureY)
			.addShapeBox(-6, -3, -2.5f, 1, 3, 4, 0, -0.6f, 0.06f, -0.1f, 0.45f, -0.7f, -0.2f, 0.45f, -0.7f, -0.2f, -0.6f, 0.06f, -0.1f, 0, 0, -0.1f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.1f).setName("Import Box87")
		);
		wheel.add(new ModelRendererTurbo(wheel, 33, 25, textureX, textureY)
			.addShapeBox(-6, 0, -2.5f, 1, 3, 4, 0, 0, 0, -0.1f, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.1f, -0.6f, 0.06f, -0.1f, 0.45f, -0.7f, -0.2f, 0.45f, -0.7f, -0.2f, -0.6f, 0.06f, -0.1f).setName("Import Box88")
		);
		wheel.add(new ModelRendererTurbo(wheel, 49, 25, textureX, textureY)
			.addShapeBox(2, 4, -2.5f, 3, 1, 4, 0, -0.2f, -0.6f, -0.2f, -0.45f, 1.7f, -0.2f, -0.45f, 1.7f, -0.2f, -0.2f, -0.6f, -0.2f, -1, 0.3f, -0.1f, 0.4f, -2, -0.1f, 0.4f, -2, -0.1f, -1, 0.3f, -0.1f).setName("Import Box89")
		);
		wheel.add(new ModelRendererTurbo(wheel, 49, 25, textureX, textureY)
			.addShapeBox(2, -5, -2.5f, 3, 1, 4, 0, -1, 0.3f, -0.1f, 0.4f, -2, -0.1f, 0.4f, -2, -0.1f, -1, 0.3f, -0.1f, -0.2f, -0.6f, -0.2f, -0.45f, 1.7f, -0.2f, -0.45f, 1.7f, -0.2f, -0.2f, -0.6f, -0.2f).setName("Import Box90")
		);
		wheel.add(new ModelRendererTurbo(wheel, 49, 25, textureX, textureY)
			.addShapeBox(2, -5, -2.5f, 3, 1, 4, 0, -1, 0.3f, -0.1f, 0.4f, -2, -0.1f, 0.4f, -2, -0.1f, -1, 0.3f, -0.1f, -0.2f, -0.6f, -0.2f, -0.5f, 1.7f, -0.2f, -0.5f, 1.7f, -0.2f, -0.2f, -0.6f, -0.2f).setName("Import Box91")
		);
		wheel.add(new ModelRendererTurbo(wheel, 49, 25, textureX, textureY)
			.addShapeBox(-5.6f, -3.6f, -2.5f, 3, 1, 4, 0, -0.2f, -0.6f, -0.1f, -0.5f, 1.7f, -0.1f, -0.5f, 1.7f, -0.1f, -0.2f, -0.6f, -0.1f, -1.05f, 0.3f, -0.2f, 0.4f, -2, -0.2f, 0.4f, -2, -0.2f, -1.05f, 0.3f, -0.2f).setName("Import Box92")
		);
		wheel.add(new ModelRendererTurbo(wheel, 49, 25, textureX, textureY)
			.addShapeBox(-5.6f, 2.6f, -2.5f, 3, 1, 4, 0, -1.05f, 0.3f, -0.2f, 0.4f, -2, -0.2f, 0.4f, -2, -0.2f, -1.05f, 0.3f, -0.2f, -0.2f, -0.6f, -0.1f, -0.5f, 1.7f, -0.1f, -0.5f, 1.7f, -0.1f, -0.2f, -0.6f, -0.1f).setName("Import Box94")
		);
		wheel.add(new ModelRendererTurbo(wheel, 9, 25, textureX, textureY)
			.addShapeBox(-1.5f, 2.5f, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box96")
		);
		wheel.add(new ModelRendererTurbo(wheel, 25, 25, textureX, textureY)
			.addShapeBox(-1.5f, 4.5f, -1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box97")
		);
		wheel.add(new ModelRendererTurbo(wheel, 41, 25, textureX, textureY)
			.addShapeBox(-1.5f, 1.5f, -0.5f, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0).setName("Import Box98")
		);
		wheel.add(new ModelRendererTurbo(wheel, 65, 25, textureX, textureY)
			.addShapeBox(-1.5f, 3.5f, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 1, 0, 0, 1, 0, 0, -1.5f, 0, 0, -1.5f).setName("Import Box99")
		);
		wheel.add(new ModelRendererTurbo(wheel, 81, 25, textureX, textureY)
			.addShapeBox(-1.5f, -2.5f, -0.5f, 3, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box100")
		);
		wheel.add(new ModelRendererTurbo(wheel, 97, 25, textureX, textureY)
			.addShapeBox(-1.5f, -3.5f, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box101")
		);
		wheel.add(new ModelRendererTurbo(wheel, 113, 25, textureX, textureY)
			.addShapeBox(-1.5f, -4.5f, 0, 3, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1.5f, 0, 0, -1.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box102")
		);
		wheel.add(new ModelRendererTurbo(wheel, 1, 33, textureX, textureY)
			.addShapeBox(-1.5f, -5.5f, -1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box103")
		);
		wheel.add(new ModelRendererTurbo(wheel, 121, 1, textureX, textureY)
			.addShapeBox(2.5f, -1.5f, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box104")
		);
		wheel.add(new ModelRendererTurbo(wheel, 17, 33, textureX, textureY)
			.addShapeBox(1.5f, -1.5f, -0.5f, 1, 3, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, -0.5f).setName("Import Box105")
		);
		wheel.add(new ModelRendererTurbo(wheel, 25, 33, textureX, textureY)
			.addShapeBox(4.5f, -1.5f, -1, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box106")
		);
		wheel.add(new ModelRendererTurbo(wheel, 33, 33, textureX, textureY)
			.addShapeBox(3.5f, -1.5f, -1, 1, 3, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, -1, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.5f).setName("Import Box107")
		);
		wheel.add(new ModelRendererTurbo(wheel, 41, 33, textureX, textureY)
			.addShapeBox(-2.5f, -1.5f, -0.5f, 1, 3, 1, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0).setName("Import Box108")
		);
		wheel.add(new ModelRendererTurbo(wheel, 49, 33, textureX, textureY)
			.addShapeBox(-3.5f, -1.5f, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box109")
		);
		wheel.add(new ModelRendererTurbo(wheel, 57, 33, textureX, textureY)
			.addShapeBox(-4.5f, -1.5f, -1, 1, 3, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, -1, 0, 0, 0.5f, 0, 0, -0.5f).setName("Import Box111")
		);
		wheel.add(new ModelRendererTurbo(wheel, 65, 33, textureX, textureY)
			.addShapeBox(-5.5f, -1.5f, -1, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f).setName("Import Box112")
		);
		wheel.addProgram(DefaultPrograms.ADJUSTABLE_WHEEL);
		this.groups.add(wheel);
	}

}