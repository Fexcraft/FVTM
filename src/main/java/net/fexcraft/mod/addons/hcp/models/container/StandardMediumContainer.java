//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.container;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/container/medium")
public class StandardMediumContainer extends ContainerModel {

	public StandardMediumContainer(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList metal = new TurboList("metal");
		metal.add(new ModelRendererTurbo(metal, 257, 25, textureX, textureY)
			.addShapeBox(-2, -1.5f, -18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		metal.add(new ModelRendererTurbo(metal, 265, 25, textureX, textureY)
			.addShapeBox(-2, -1.5f, -8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		metal.add(new ModelRendererTurbo(metal, 273, 25, textureX, textureY)
			.addShapeBox(-2, 43.5f, -18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		metal.add(new ModelRendererTurbo(metal, 281, 25, textureX, textureY)
			.addShapeBox(-2, 43.5f, -8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		metal.add(new ModelRendererTurbo(metal, 289, 25, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		metal.add(new ModelRendererTurbo(metal, 297, 25, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		metal.add(new ModelRendererTurbo(metal, 305, 25, textureX, textureY)
			.addShapeBox(-1.5f, 43.5f, 18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		metal.add(new ModelRendererTurbo(metal, 313, 25, textureX, textureY)
			.addShapeBox(-1.5f, 43.5f, 8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		metal.add(new ModelRendererTurbo(metal, 321, 25, textureX, textureY)
			.addShapeBox(-1.5f, 26.5f, 5, 1, 1, 1, 0, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		metal.add(new ModelRendererTurbo(metal, 329, 25, textureX, textureY)
			.addShapeBox(-1.5f, 1.5f, 18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		metal.add(new ModelRendererTurbo(metal, 257, 33, textureX, textureY)
			.addShapeBox(-2, 1.5f, -8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		metal.add(new ModelRendererTurbo(metal, 265, 33, textureX, textureY)
			.addShapeBox(-2, 1.5f, -18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		metal.add(new ModelRendererTurbo(metal, 273, 33, textureX, textureY)
			.addShapeBox(-1.5f, 40.5f, 8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		metal.add(new ModelRendererTurbo(metal, 281, 33, textureX, textureY)
			.addShapeBox(-1.5f, 40.5f, 18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		metal.add(new ModelRendererTurbo(metal, 289, 33, textureX, textureY)
			.addShapeBox(-2, 40.5f, -8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		metal.add(new ModelRendererTurbo(metal, 297, 33, textureX, textureY)
			.addShapeBox(-2, 40.5f, -18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		metal.add(new ModelRendererTurbo(metal, 329, 169, textureX, textureY)
			.addShapeBox(-1.5f, 0, 8, 1, 46, 1, 0, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f)
			.setRotationPoint(-47.5f, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		metal.add(new ModelRendererTurbo(metal, 337, 169, textureX, textureY)
			.addShapeBox(-1.5f, 0, 18, 1, 46, 1, 0, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f)
			.setRotationPoint(-47.5f, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		metal.add(new ModelRendererTurbo(metal, 345, 169, textureX, textureY)
			.addShapeBox(-2, 0, -8, 1, 46, 1, 0, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f)
			.setRotationPoint(-47, -47.5f, 21).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		metal.add(new ModelRendererTurbo(metal, 353, 169, textureX, textureY)
			.addShapeBox(-2, 0, -18, 1, 46, 1, 0, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f)
			.setRotationPoint(-47, -47.5f, 21).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		metal.add(new ModelRendererTurbo(metal, 313, 33, textureX, textureY)
			.addShapeBox(-1.5f, 10, -9, 1, 1, 7, 0, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f)
			.setRotationPoint(-47.5f, -29.5f, 22).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		metal.add(new ModelRendererTurbo(metal, 105, 41, textureX, textureY)
			.addShapeBox(-1.5f, 12, -19, 1, 1, 7, 0, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f)
			.setRotationPoint(-47.5f, -29.5f, 22).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		metal.add(new ModelRendererTurbo(metal, 129, 41, textureX, textureY)
			.addShapeBox(-1.5f, 12, 12, 1, 1, 7, 0, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f)
			.setRotationPoint(-47.5f, -29.5f, -22).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		metal.add(new ModelRendererTurbo(metal, 153, 41, textureX, textureY)
			.addShapeBox(-1.5f, 10, 2, 1, 1, 7, 0, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f)
			.setRotationPoint(-47.5f, -29.5f, -22).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		metal.add(new ModelRendererTurbo(metal, 313, 33, textureX, textureY)
			.addShapeBox(-1.5f, 26.5f, 8, 1, 1, 1, 0, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		metal.add(new ModelRendererTurbo(metal, 329, 33, textureX, textureY)
			.addShapeBox(-1.5f, 28.5f, 18, 1, 1, 1, 0, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		metal.add(new ModelRendererTurbo(metal, 57, 41, textureX, textureY)
			.addShapeBox(-1.5f, 28.5f, -18, 1, 1, 1, 0, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f)
			.setRotationPoint(-47.5f, -46, 21).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		metal.add(new ModelRendererTurbo(metal, 65, 41, textureX, textureY)
			.addShapeBox(-1.5f, 26.5f, -8, 1, 1, 1, 0, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f)
			.setRotationPoint(-47.5f, -46, 21).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		metal.add(new ModelRendererTurbo(metal, 81, 41, textureX, textureY)
			.addShapeBox(-1.5f, 1.5f, 8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		metal.add(new ModelRendererTurbo(metal, 89, 41, textureX, textureY)
			.addShapeBox(-1.5f, 28.5f, 15, 1, 1, 1, 0, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f)
			.setRotationPoint(-47.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		metal.add(new ModelRendererTurbo(metal, 97, 41, textureX, textureY)
			.addShapeBox(-1.5f, 28.5f, -15, 1, 1, 1, 0, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f)
			.setRotationPoint(-47.5f, -46, 21).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		metal.add(new ModelRendererTurbo(metal, 105, 41, textureX, textureY)
			.addShapeBox(-1.5f, 26.5f, -5, 1, 1, 1, 0, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f)
			.setRotationPoint(-47.5f, -46, 21).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		this.groups.add(metal);
		//
		TurboList primary = new TurboList("primary");
		primary.add(new ModelRendererTurbo(primary, 1, 1, textureX, textureY).addBox(0, 0, 0, 2, 3, 48)
			.setRotationPoint(-48, -3, -24).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 1, textureX, textureY).addBox(0, 0, 0, 92, 1, 2)
			.setRotationPoint(-46, -1, -24).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		primary.add(new ModelRendererTurbo(primary, 201, 1, textureX, textureY).addBox(0, 0, 0, 2, 3, 48)
			.setRotationPoint(46, -3, -24).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		primary.add(new ModelRendererTurbo(primary, 257, 1, textureX, textureY).addBox(0, 0, 0, 92, 1, 2)
			.setRotationPoint(-46, -1, 22).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 9, textureX, textureY).addBox(0, 0, 0, 92, 1, 2)
			.setRotationPoint(-46, -3, -24).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		primary.add(new ModelRendererTurbo(primary, 257, 9, textureX, textureY).addBox(0, 0, 0, 92, 1, 2)
			.setRotationPoint(-46, -3, 22).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		primary.add(new ModelRendererTurbo(primary, 449, 1, textureX, textureY).addBox(0, 0, 0, 24, 1, 2)
			.setRotationPoint(-46, -2, 22).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		primary.add(new ModelRendererTurbo(primary, 449, 9, textureX, textureY).addBox(0, 0, 0, 24, 1, 2)
			.setRotationPoint(22, -2, 22).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 17, textureX, textureY).addBox(0, 0, 0, 36, 1, 2)
			.setRotationPoint(-18, -2, 22).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		primary.add(new ModelRendererTurbo(primary, 137, 17, textureX, textureY).addBox(0, 0, 0, 24, 1, 2)
			.setRotationPoint(-46, -2, -24).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		primary.add(new ModelRendererTurbo(primary, 193, 17, textureX, textureY).addBox(0, 0, 0, 24, 1, 2)
			.setRotationPoint(22, -2, -24).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		primary.add(new ModelRendererTurbo(primary, 257, 17, textureX, textureY).addBox(0, 0, 0, 36, 1, 2)
			.setRotationPoint(-18, -2, -24).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 57, textureX, textureY).addBox(0, 0, 0, 92, 1, 44)
			.setRotationPoint(-46, -3, -22).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 1, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(-48, -46, -24).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		primary.add(new ModelRendererTurbo(primary, 17, 1, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(-48, -46, 22).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		primary.add(new ModelRendererTurbo(primary, 33, 1, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(46, -46, 22).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		primary.add(new ModelRendererTurbo(primary, 337, 17, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(46, -46, -24).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		primary.add(new ModelRendererTurbo(primary, 305, 17, textureX, textureY).addBox(0, 0, 0, 2, 2, 48)
			.setRotationPoint(46, -48, -24).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		primary.add(new ModelRendererTurbo(primary, 409, 17, textureX, textureY).addBox(0, 0, 0, 2, 2, 48)
			.setRotationPoint(-48, -48, -24).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 25, textureX, textureY).addBox(0, 0, 0, 92, 2, 2)
			.setRotationPoint(-46, -48, -24).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 33, textureX, textureY).addBox(0, 0, 0, 92, 2, 2)
			.setRotationPoint(-46, -48, 22).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		primary.add(new ModelRendererTurbo(primary, 281, 73, textureX, textureY).addBox(0, 0, 0, 94, 43, 1)
			.setRotationPoint(-46, -46, -23.5f).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 105, textureX, textureY).addBox(0, 0, 0, 94, 43, 1)
			.setRotationPoint(-46, -46, 22.5f).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		primary.add(new ModelRendererTurbo(primary, 153, 121, textureX, textureY).addBox(0, 0, 0, 92, 1, 44)
			.setRotationPoint(-46, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 129, textureX, textureY).addBox(0, 0, 0, 1, 43, 44)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		primary.add(new ModelRendererTurbo(primary, 457, 97, textureX, textureY).addBox(0, 0, 0, 1, 44, 22)
			.setRotationPoint(-47.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 153, textureX, textureY).addBox(0, 0, 22, 1, 44, 22)
			.setRotationPoint(-47.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		primary.add(new ModelRendererTurbo(primary, 505, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-46, -46, -24).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		primary.add(new ModelRendererTurbo(primary, 361, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-41, -46, -24).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		primary.add(new ModelRendererTurbo(primary, 369, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-35, -46, -24).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		primary.add(new ModelRendererTurbo(primary, 377, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-29, -46, -24).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-23, -46, -24).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		primary.add(new ModelRendererTurbo(primary, 393, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-17, -46, -24).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		primary.add(new ModelRendererTurbo(primary, 401, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-11, -46, -24).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		primary.add(new ModelRendererTurbo(primary, 409, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-5, -46, -24).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		primary.add(new ModelRendererTurbo(primary, 417, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(3, -46, -24).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		primary.add(new ModelRendererTurbo(primary, 425, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(9, -46, -24).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		primary.add(new ModelRendererTurbo(primary, 433, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(15, -46, -24).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		primary.add(new ModelRendererTurbo(primary, 441, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(21, -46, -24).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		primary.add(new ModelRendererTurbo(primary, 449, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(27, -46, -24).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		primary.add(new ModelRendererTurbo(primary, 465, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(33, -46, -24).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		primary.add(new ModelRendererTurbo(primary, 473, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(39, -46, -24).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		primary.add(new ModelRendererTurbo(primary, 481, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(45, -46, -24).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		primary.add(new ModelRendererTurbo(primary, 489, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-46, -46, 23).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		primary.add(new ModelRendererTurbo(primary, 497, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-41, -46, 23).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		primary.add(new ModelRendererTurbo(primary, 489, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-35, -46, 23).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		primary.add(new ModelRendererTurbo(primary, 497, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-29, -46, 23).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		primary.add(new ModelRendererTurbo(primary, 505, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-23, -46, 23).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		primary.add(new ModelRendererTurbo(primary, 433, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17, -46, 23).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		primary.add(new ModelRendererTurbo(primary, 441, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-11, -46, 23).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		primary.add(new ModelRendererTurbo(primary, 449, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -46, 23).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		primary.add(new ModelRendererTurbo(primary, 505, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -46, 23).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		primary.add(new ModelRendererTurbo(primary, 49, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -46, 23).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -46, 23).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		primary.add(new ModelRendererTurbo(primary, 65, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -46, 23).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		primary.add(new ModelRendererTurbo(primary, 73, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(33, -46, 23).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		primary.add(new ModelRendererTurbo(primary, 81, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39, -46, 23).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		primary.add(new ModelRendererTurbo(primary, 473, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -46, 23).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		primary.add(new ModelRendererTurbo(primary, 89, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(47, -46, -22).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		primary.add(new ModelRendererTurbo(primary, 97, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(47, -46, 21).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		primary.add(new ModelRendererTurbo(primary, 105, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(47, -46, 15).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		primary.add(new ModelRendererTurbo(primary, 113, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(47, -46, -17).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		primary.add(new ModelRendererTurbo(primary, 121, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(47, -46, -11).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		primary.add(new ModelRendererTurbo(primary, 129, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(47, -46, 9).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		primary.add(new ModelRendererTurbo(primary, 137, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(47, -46, 2).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		primary.add(new ModelRendererTurbo(primary, 145, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(47, -46, -5).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		primary.add(new ModelRendererTurbo(primary, 113, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-46, -48, -22).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		primary.add(new ModelRendererTurbo(primary, 209, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-41, -48, -22).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		primary.add(new ModelRendererTurbo(primary, 265, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-35, -48, -22).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		primary.add(new ModelRendererTurbo(primary, 321, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-29, -48, -22).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		primary.add(new ModelRendererTurbo(primary, 9, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-23, -48, -22).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		primary.add(new ModelRendererTurbo(primary, 65, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-17, -48, -22).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		primary.add(new ModelRendererTurbo(primary, 161, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-11, -48, -22).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		primary.add(new ModelRendererTurbo(primary, 377, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-5, -48, -22).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		primary.add(new ModelRendererTurbo(primary, 217, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(3, -48, -22).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		primary.add(new ModelRendererTurbo(primary, 273, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(9, -48, -22).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(15, -48, -22).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(21, -48, -22).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		primary.add(new ModelRendererTurbo(primary, 153, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(27, -48, -22).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		primary.add(new ModelRendererTurbo(primary, 329, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(33, -48, -22).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		primary.add(new ModelRendererTurbo(primary, 209, 273, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(39, -48, -22).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 273, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(45, -48, -22).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		primary.add(new ModelRendererTurbo(primary, 281, 33, textureX, textureY)
			.addShapeBox(-1, 0, 0, 1, 5, 22, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-47.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		primary.add(new ModelRendererTurbo(primary, 233, 57, textureX, textureY)
			.addShapeBox(-1, 37, 0, 1, 6, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-47.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		primary.add(new ModelRendererTurbo(primary, 161, 169, textureX, textureY)
			.addShapeBox(-1, 9, 0, 1, 10, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-47.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		primary.add(new ModelRendererTurbo(primary, 457, 201, textureX, textureY)
			.addShapeBox(-1, 23, 0, 1, 10, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-47.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		primary.add(new ModelRendererTurbo(primary, 193, 185, textureX, textureY)
			.addShapeBox(-1, 0, 22, 1, 5, 22, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-47.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		primary.add(new ModelRendererTurbo(primary, 121, 217, textureX, textureY)
			.addShapeBox(-1, 37, 22, 1, 6, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-47.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		primary.add(new ModelRendererTurbo(primary, 153, 225, textureX, textureY)
			.addShapeBox(-1, 9, 22, 1, 10, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-47.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		primary.add(new ModelRendererTurbo(primary, 449, 241, textureX, textureY)
			.addShapeBox(-1, 23, 22, 1, 10, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-47.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		primary.add(new ModelRendererTurbo(primary, 321, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-5, -46, 23).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(primary);
	}

}