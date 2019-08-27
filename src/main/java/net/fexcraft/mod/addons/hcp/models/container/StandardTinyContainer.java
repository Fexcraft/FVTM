//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.container;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.6-test &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/container/tiny")
public class StandardTinyContainer extends ContainerModel {

	public StandardTinyContainer(){
		super(); textureX = 512; textureY = 256;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList metal = new TurboList("metal");
		metal.add(new ModelRendererTurbo(metal, 433, 8, textureX, textureY)
			.addShapeBox(-2, -1.5f, -18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		metal.add(new ModelRendererTurbo(metal, 428, 8, textureX, textureY)
			.addShapeBox(-2, -1.5f, -8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		metal.add(new ModelRendererTurbo(metal, 423, 8, textureX, textureY)
			.addShapeBox(-2, 43.5f, -18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		metal.add(new ModelRendererTurbo(metal, 413, 8, textureX, textureY)
			.addShapeBox(-2, 43.5f, -8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		metal.add(new ModelRendererTurbo(metal, 408, 8, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		metal.add(new ModelRendererTurbo(metal, 403, 8, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		metal.add(new ModelRendererTurbo(metal, 398, 8, textureX, textureY)
			.addShapeBox(-1.5f, 43.5f, 18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		metal.add(new ModelRendererTurbo(metal, 204, 8, textureX, textureY)
			.addShapeBox(-1.5f, 43.5f, 8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		metal.add(new ModelRendererTurbo(metal, 192, 8, textureX, textureY)
			.addShapeBox(-1.5f, 26.5f, 5, 1, 1, 1, 0, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		metal.add(new ModelRendererTurbo(metal, 187, 8, textureX, textureY)
			.addShapeBox(-1.5f, 1.5f, 18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		metal.add(new ModelRendererTurbo(metal, 177, 8, textureX, textureY)
			.addShapeBox(-2, 1.5f, -8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		metal.add(new ModelRendererTurbo(metal, 491, 7, textureX, textureY)
			.addShapeBox(-2, 1.5f, -18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		metal.add(new ModelRendererTurbo(metal, 479, 7, textureX, textureY)
			.addShapeBox(-1.5f, 40.5f, 8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		metal.add(new ModelRendererTurbo(metal, 474, 7, textureX, textureY)
			.addShapeBox(-1.5f, 40.5f, 18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		metal.add(new ModelRendererTurbo(metal, 464, 7, textureX, textureY)
			.addShapeBox(-2, 40.5f, -8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		metal.add(new ModelRendererTurbo(metal, 212, 7, textureX, textureY)
			.addShapeBox(-2, 40.5f, -18, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		metal.add(new ModelRendererTurbo(metal, 493, 95, textureX, textureY)
			.addShapeBox(-1.5f, 0, 8, 1, 46, 1, 0, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f)
			.setRotationPoint(-15.5f, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		metal.add(new ModelRendererTurbo(metal, 503, 94, textureX, textureY)
			.addShapeBox(-1.5f, 0, 18, 1, 46, 1, 0, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f)
			.setRotationPoint(-15.5f, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		metal.add(new ModelRendererTurbo(metal, 221, 91, textureX, textureY)
			.addShapeBox(-2, 0, -8, 1, 46, 1, 0, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f)
			.setRotationPoint(-15, -47.5f, 21).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		metal.add(new ModelRendererTurbo(metal, 10, 90, textureX, textureY)
			.addShapeBox(-2, 0, -18, 1, 46, 1, 0, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f)
			.setRotationPoint(-15, -47.5f, 21).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		metal.add(new ModelRendererTurbo(metal, 194, 8, textureX, textureY)
			.addShapeBox(-1.5f, 10, -9, 1, 1, 7, 0, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f)
			.setRotationPoint(-15.5f, -29.5f, 22).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		metal.add(new ModelRendererTurbo(metal, 177, 8, textureX, textureY)
			.addShapeBox(-1.5f, 12, -19, 1, 1, 7, 0, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f)
			.setRotationPoint(-15.5f, -29.5f, 22).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		metal.add(new ModelRendererTurbo(metal, 481, 7, textureX, textureY)
			.addShapeBox(-1.5f, 12, 12, 1, 1, 7, 0, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f)
			.setRotationPoint(-15.5f, -29.5f, -22).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		metal.add(new ModelRendererTurbo(metal, 464, 7, textureX, textureY)
			.addShapeBox(-1.5f, 10, 2, 1, 1, 7, 0, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f)
			.setRotationPoint(-15.5f, -29.5f, -22).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		metal.add(new ModelRendererTurbo(metal, 494, 4, textureX, textureY)
			.addShapeBox(-1.5f, 26.5f, 8, 1, 1, 1, 0, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		metal.add(new ModelRendererTurbo(metal, 489, 4, textureX, textureY)
			.addShapeBox(-1.5f, 28.5f, 18, 1, 1, 1, 0, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		metal.add(new ModelRendererTurbo(metal, 484, 4, textureX, textureY)
			.addShapeBox(-1.5f, 28.5f, -18, 1, 1, 1, 0, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f)
			.setRotationPoint(-15.5f, -46, 21).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		metal.add(new ModelRendererTurbo(metal, 479, 4, textureX, textureY)
			.addShapeBox(-1.5f, 26.5f, -8, 1, 1, 1, 0, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f)
			.setRotationPoint(-15.5f, -46, 21).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		metal.add(new ModelRendererTurbo(metal, 474, 4, textureX, textureY)
			.addShapeBox(-1.5f, 1.5f, 8, 1, 1, 1, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		metal.add(new ModelRendererTurbo(metal, 469, 4, textureX, textureY)
			.addShapeBox(-1.5f, 28.5f, 15, 1, 1, 1, 0, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f)
			.setRotationPoint(-15.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		metal.add(new ModelRendererTurbo(metal, 464, 4, textureX, textureY)
			.addShapeBox(-1.5f, 28.5f, -15, 1, 1, 1, 0, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f)
			.setRotationPoint(-15.5f, -46, 21).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		metal.add(new ModelRendererTurbo(metal, 213, 4, textureX, textureY)
			.addShapeBox(-1.5f, 26.5f, -5, 1, 1, 1, 0, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f)
			.setRotationPoint(-15.5f, -46, 21).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		this.groups.add(metal);
		
		TurboList primary = new TurboList("primary");
		primary.add(new ModelRendererTurbo(primary, 387, 53, textureX, textureY).addBox(0, 0, 0, 2, 3, 48)
			.setRotationPoint(-16, -3, -24).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		primary.add(new ModelRendererTurbo(primary, 280, 5, textureX, textureY).addBox(0, 0, 0, 28, 1, 2)
			.setRotationPoint(-14, -1, -24).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		primary.add(new ModelRendererTurbo(primary, 334, 49, textureX, textureY).addBox(0, 0, 0, 2, 3, 48)
			.setRotationPoint(14, -3, -24).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		primary.add(new ModelRendererTurbo(primary, 59, 5, textureX, textureY).addBox(0, 0, 0, 28, 1, 2)
			.setRotationPoint(-14, -1, 22).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		primary.add(new ModelRendererTurbo(primary, 398, 4, textureX, textureY).addBox(0, 0, 0, 28, 1, 2)
			.setRotationPoint(-14, -3, -24).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		primary.add(new ModelRendererTurbo(primary, 398, 0, textureX, textureY).addBox(0, 0, 0, 28, 1, 2)
			.setRotationPoint(-14, -3, 22).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		primary.add(new ModelRendererTurbo(primary, 204, 4, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(-14, -2, 22).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		primary.add(new ModelRendererTurbo(primary, 195, 4, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(12, -2, 22).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		primary.add(new ModelRendererTurbo(primary, 459, 0, textureX, textureY).addBox(0, 0, 0, 18, 1, 2)
			.setRotationPoint(-9, -2, 22).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		primary.add(new ModelRendererTurbo(primary, 186, 4, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(-14, -2, -24).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		primary.add(new ModelRendererTurbo(primary, 177, 4, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(12, -2, -24).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		primary.add(new ModelRendererTurbo(primary, 177, 0, textureX, textureY).addBox(0, 0, 0, 18, 1, 2)
			.setRotationPoint(-9, -2, -24).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		primary.add(new ModelRendererTurbo(primary, 297, 0, textureX, textureY).addBox(0, 0, 0, 28, 1, 44)
			.setRotationPoint(-14, -3, -22).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		primary.add(new ModelRendererTurbo(primary, 334, 46, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(-16, -46, -24).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		primary.add(new ModelRendererTurbo(primary, 166, 46, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(-16, -46, 22).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		primary.add(new ModelRendererTurbo(primary, 157, 46, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(14, -46, 22).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		primary.add(new ModelRendererTurbo(primary, 148, 46, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(14, -46, -24).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		primary.add(new ModelRendererTurbo(primary, 281, 46, textureX, textureY).addBox(0, 0, 0, 2, 2, 48)
			.setRotationPoint(14, -48, -24).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		primary.add(new ModelRendererTurbo(primary, 95, 46, textureX, textureY).addBox(0, 0, 0, 2, 2, 48)
			.setRotationPoint(-16, -48, -24).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		primary.add(new ModelRendererTurbo(primary, 280, 0, textureX, textureY).addBox(0, 0, 0, 28, 2, 2)
			.setRotationPoint(-14, -48, 22).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		primary.add(new ModelRendererTurbo(primary, 221, 0, textureX, textureY).addBox(0, 0, 0, 28, 43, 1)
			.setRotationPoint(-14, -46, 22.5f).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		primary.add(new ModelRendererTurbo(primary, 76, 0, textureX, textureY).addBox(0, 0, 0, 28, 1, 44)
			.setRotationPoint(-14, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		primary.add(new ModelRendererTurbo(primary, 276, 97, textureX, textureY).addBox(0, 0, 0, 1, 43, 44)
			.setRotationPoint(14.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		primary.add(new ModelRendererTurbo(primary, 108, 97, textureX, textureY).addBox(0, 0, 0, 1, 44, 22)
			.setRotationPoint(-15.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		primary.add(new ModelRendererTurbo(primary, 174, 91, textureX, textureY).addBox(0, 0, 22, 1, 44, 22)
			.setRotationPoint(-15.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		primary.add(new ModelRendererTurbo(primary, 5, 90, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-14, -46, -24).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		primary.add(new ModelRendererTurbo(primary, 136, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-10, -46, -24).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		primary.add(new ModelRendererTurbo(primary, 129, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-4, -46, -24).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		primary.add(new ModelRendererTurbo(primary, 122, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(8, -46, -24).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		primary.add(new ModelRendererTurbo(primary, 0, 90, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(13, -46, -24).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		primary.add(new ModelRendererTurbo(primary, 499, 50, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -46, 23).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		primary.add(new ModelRendererTurbo(primary, 115, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-10, -46, 23).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		primary.add(new ModelRendererTurbo(primary, 108, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -46, 23).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		primary.add(new ModelRendererTurbo(primary, 7, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -46, 23).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		primary.add(new ModelRendererTurbo(primary, 0, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -46, 23).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		primary.add(new ModelRendererTurbo(primary, 494, 50, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(13, -46, 23).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		primary.add(new ModelRendererTurbo(primary, 507, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(15, -46, -22).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		primary.add(new ModelRendererTurbo(primary, 507, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(15, -46, 21).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		primary.add(new ModelRendererTurbo(primary, 487, 50, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(15, -46, 15).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		primary.add(new ModelRendererTurbo(primary, 371, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(15, -46, -17).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		primary.add(new ModelRendererTurbo(primary, 364, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(15, -46, -11).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		primary.add(new ModelRendererTurbo(primary, 357, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(15, -46, 9).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		primary.add(new ModelRendererTurbo(primary, 350, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(15, -46, 2).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		primary.add(new ModelRendererTurbo(primary, 343, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 2, 0, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1, -0.5f, 0, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 1)
			.setRotationPoint(15, -46, -5).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		primary.add(new ModelRendererTurbo(primary, 17, 84, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-14, -48, -22).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		primary.add(new ModelRendererTurbo(primary, 177, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-10, -48, -22).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		primary.add(new ModelRendererTurbo(primary, 236, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-4, -48, -22).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		primary.add(new ModelRendererTurbo(primary, 15, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(2, -48, -22).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		primary.add(new ModelRendererTurbo(primary, 415, 4, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(8, -48, -22).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		primary.add(new ModelRendererTurbo(primary, 229, 55, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(13, -48, -22).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		primary.add(new ModelRendererTurbo(primary, 226, 55, textureX, textureY)
			.addShapeBox(-1, 0, 0, 1, 5, 22, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-15.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		primary.add(new ModelRendererTurbo(primary, 61, 55, textureX, textureY)
			.addShapeBox(-1, 37, 0, 1, 6, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-15.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		primary.add(new ModelRendererTurbo(primary, 14, 55, textureX, textureY)
			.addShapeBox(-1, 9, 0, 1, 10, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-15.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		primary.add(new ModelRendererTurbo(primary, 440, 50, textureX, textureY)
			.addShapeBox(-1, 23, 0, 1, 10, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-15.5f, -46, 0).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		primary.add(new ModelRendererTurbo(primary, 387, 46, textureX, textureY)
			.addShapeBox(-1, 0, 22, 1, 5, 22, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-15.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		primary.add(new ModelRendererTurbo(primary, 285, 9, textureX, textureY)
			.addShapeBox(-1, 37, 22, 1, 6, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-15.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		primary.add(new ModelRendererTurbo(primary, 64, 9, textureX, textureY)
			.addShapeBox(-1, 9, 22, 1, 10, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-15.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		primary.add(new ModelRendererTurbo(primary, 398, 8, textureX, textureY)
			.addShapeBox(-1, 23, 22, 1, 10, 22, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0)
			.setRotationPoint(-15.5f, -46, -44).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		primary.add(new ModelRendererTurbo(primary, 59, 0, textureX, textureY).addBox(0, 0, 0, 28, 2, 2)
			.setRotationPoint(-14, -48, -24).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		primary.add(new ModelRendererTurbo(primary, 0, 0, textureX, textureY).addBox(0, 0, 0, 28, 43, 1)
			.setRotationPoint(-14, -46, -23.5f).setRotationAngle(0, 0, 0).setName("Box 23cp")
		);
		primary.add(new ModelRendererTurbo(primary, 500, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(2, -46, -24).setRotationAngle(0, 0, 0).setName("Box 32cp")
		);
		primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(primary);
	}

}
