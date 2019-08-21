//FMT-Marker FVTM-1.1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;

/** This file was exported via the FVTM Exporter V1.2 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.9 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 *  
 *  @author Ferdinand Calo' (FEX___96)
 */
@fModel(registryname = "fvtm:models/block/pizza_oven")
public class PizzaOven extends BlockModel {

	public PizzaOven(){
		super(); textureX = 256; textureY = 128;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList body = new TurboList("body");
		body.add(new ModelRendererTurbo(body, 1, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(6, -1, -6).setRotationAngle(0, 0, -0).setName("Box 0")
		);
		body.add(new ModelRendererTurbo(body, 9, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-7, -1, -6).setRotationAngle(0, 0, -0).setName("Box 1")
		);
		body.add(new ModelRendererTurbo(body, 17, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-7, -1, 6).setRotationAngle(0, 0, -0).setName("Box 2")
		);
		body.add(new ModelRendererTurbo(body, 25, 1, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(6, -1, 6).setRotationAngle(0, 0, -0).setName("Box 3")
		);
		body.add(new ModelRendererTurbo(body, 17, 1, textureX, textureY).addBox(0, 0, 0, 16, 1, 15)
			.setRotationPoint(-8, -2, -7).setRotationAngle(0, 0, -0).setName("Box 4")
		);
		body.add(new ModelRendererTurbo(body, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0)
			.setRotationPoint(-7.5f, -8.5f, -7).setRotationAngle(0, 0, -0).setName("Box 8")
		);
		body.add(new ModelRendererTurbo(body, 225, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 14, 0, 0, -0.5f, 0, -0.5f, -1, 0, -0.5f, -1, 0, 0, -0.5f, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-7.5f, -9, -7).setRotationAngle(0, 0, -0).setName("Box 9")
		);
		body.add(new ModelRendererTurbo(body, 57, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 14, 0, -0.5f, -1, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(4.5f, -9, -7).setRotationAngle(0, 0, -0).setName("Box 10")
		);
		body.add(new ModelRendererTurbo(body, 121, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-7.5f, -8, 7).setRotationAngle(0, 0, -0).setName("Box 12")
		);
		body.add(new ModelRendererTurbo(body, 65, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 8, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -9, -8).setRotationAngle(0, 0, -0).setName("Box 13")
		);
		body.add(new ModelRendererTurbo(body, 81, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 8, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -9, -8).setRotationAngle(0, 0, -0).setName("Box 14")
		);
		body.add(new ModelRendererTurbo(body, 129, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -9, -8).setRotationAngle(0, 0, -0).setName("Box 15")
		);
		body.add(new ModelRendererTurbo(body, 169, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -2, -8).setRotationAngle(0, 0, -0).setName("Box 16")
		);
		body.add(new ModelRendererTurbo(body, 73, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, -0.5f, -0.8f, -0.8f, -0.8f, 0, -0.8f, -0.8f, 0, 0, -0.5f, -0.8f)
			.setRotationPoint(-7, -3.5f, -6).setRotationAngle(0, 0, -0).setName("Box 26")
		);
		body.add(new ModelRendererTurbo(body, 225, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, -0.5f, -0.8f, -0.8f, -0.8f, 0, -0.8f, -0.8f, 0, 0, -0.5f, -0.8f)
			.setRotationPoint(-7, -3.5f, 3).setRotationAngle(0, 0, -0).setName("Box 27")
		);
		body.add(new ModelRendererTurbo(body, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, -0.8f, 0, 0, -0.5f, -0.8f, 0, -0.5f, -0.8f, -0.8f, -0.8f, 0)
			.setRotationPoint(4, -3.5f, 3).setRotationAngle(0, 0, -0).setName("Box 28")
		);
		body.add(new ModelRendererTurbo(body, 49, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, -0.8f, 0, 0, -0.5f, -0.8f, 0, -0.5f, -0.8f, -0.8f, -0.8f, 0)
			.setRotationPoint(4, -3.5f, -6).setRotationAngle(0, 0, -0).setName("Box 29")
		);
		body.add(new ModelRendererTurbo(body, 209, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 13, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.8f, 0, -0.5f, -0.8f, 0, -0.5f, -0.8f, 0, 0, -0.8f, 0)
			.setRotationPoint(-7, -3.7f, -6.5f).setRotationAngle(0, 0, -0).setName("Box 30")
		);
		body.add(new ModelRendererTurbo(body, 105, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 13, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, 0, -0.5f, -0.8f, 0)
			.setRotationPoint(4, -3.7f, -6.5f).setRotationAngle(0, 0, -0).setName("Box 31")
		);
		body.add(new ModelRendererTurbo(body, 193, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.8f, 0, 0, -0.8f, 0, 0, -0.8f, -0.5f, 0, -0.8f, -0.5f)
			.setRotationPoint(-6.5f, -3.7f, -6.5f).setRotationAngle(0, 0, -0).setName("Box 32")
		);
		body.add(new ModelRendererTurbo(body, 225, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.8f, -0.5f, 0, -0.8f, -0.5f, 0, -0.8f, 0, 0, -0.8f, 0)
			.setRotationPoint(-6.5f, -3.7f, 5.5f).setRotationAngle(0, 0, -0).setName("Box 33")
		);
		body.add(new ModelRendererTurbo(body, 145, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-6.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 34")
		);
		body.add(new ModelRendererTurbo(body, 177, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-6, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 35")
		);
		body.add(new ModelRendererTurbo(body, 129, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-5.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 36")
		);
		body.add(new ModelRendererTurbo(body, 161, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-5, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 37")
		);
		body.add(new ModelRendererTurbo(body, 193, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-4.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 38")
		);
		body.add(new ModelRendererTurbo(body, 225, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-4, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 39")
		);
		body.add(new ModelRendererTurbo(body, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-3.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 40")
		);
		body.add(new ModelRendererTurbo(body, 33, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-3, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 41")
		);
		body.add(new ModelRendererTurbo(body, 81, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-2.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 42")
		);
		body.add(new ModelRendererTurbo(body, 113, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-2, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 43")
		);
		body.add(new ModelRendererTurbo(body, 145, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-1.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 44")
		);
		body.add(new ModelRendererTurbo(body, 177, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-1, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 45")
		);
		body.add(new ModelRendererTurbo(body, 209, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(-0.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 46")
		);
		body.add(new ModelRendererTurbo(body, 17, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(0, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 47")
		);
		body.add(new ModelRendererTurbo(body, 49, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(0.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 48")
		);
		body.add(new ModelRendererTurbo(body, 97, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(1, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 49")
		);
		body.add(new ModelRendererTurbo(body, 129, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(1.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 50")
		);
		body.add(new ModelRendererTurbo(body, 161, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(2, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 51")
		);
		body.add(new ModelRendererTurbo(body, 193, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(2.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 52")
		);
		body.add(new ModelRendererTurbo(body, 225, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(3, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 53")
		);
		body.add(new ModelRendererTurbo(body, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0, -0.4f, -0.8f, 0)
			.setRotationPoint(3.5f, -3.7f, -6).setRotationAngle(0, 0, -0).setName("Box 54")
		);
		body.add(new ModelRendererTurbo(body, 249, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5.5f, -8.5f, -7.6f).setRotationAngle(0, 0, -0).setName("Box 56")
		);
		body.add(new ModelRendererTurbo(body, 57, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0)
			.setRotationPoint(5.5f, -6.5f, -7.6f).setRotationAngle(0, 0, -0).setName("Box 57")
		);
		body.add(new ModelRendererTurbo(body, 1, 33, textureX, textureY).addBox(0, 0, 0, 2, 1, 1)
			.setRotationPoint(5.5f, -7.5f, -7.6f).setRotationAngle(0, 0, -0).setName("Box 58")
		);
		body.add(new ModelRendererTurbo(body, 49, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0)
			.setRotationPoint(5.5f, -3.5f, -7.6f).setRotationAngle(0, 0, -0).setName("Box 59")
		);
		body.add(new ModelRendererTurbo(body, 57, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5.5f, -5.5f, -7.6f).setRotationAngle(0, 0, -0).setName("Box 60")
		);
		body.add(new ModelRendererTurbo(body, 121, 33, textureX, textureY).addBox(0, 0, 0, 2, 1, 1)
			.setRotationPoint(5.5f, -4.5f, -7.6f).setRotationAngle(0, 0, -0).setName("Box 61")
		);
		this.groups.add(body);
		//
		TurboList door = new TurboList("door");
		door.add(new ModelRendererTurbo(door, 161, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 6, 1, 0, 0, 0, -0.7f, 0, 0, -0.7f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.7f, 0, 0, -0.7f, 0, 0, -0.1f, 0, 0, -0.1f)
			.setRotationPoint(-7, -8, -8).setRotationAngle(0, 0, -0).setName("Box 21")
		);
		door.add(new ModelRendererTurbo(door, 89, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0)
			.setRotationPoint(0.5f, -7.5f, -8.2f).setRotationAngle(0, 0, -0).setName("Box 22")
		);
		door.add(new ModelRendererTurbo(door, 249, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0)
			.setRotationPoint(-3.5f, -7.5f, -8.2f).setRotationAngle(0, 0, -0).setName("Box 23")
		);
		door.add(new ModelRendererTurbo(door, 209, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, -0.2f, -0.6f, 0, -0.2f, -0.6f, 0, -0.2f, -0.6f, -0.4f, -0.2f, -0.6f, -0.4f, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(-4, -8, -8.5f).setRotationAngle(0, 0, -0).setName("Box 24")
		);
		door.add(new ModelRendererTurbo(door, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, -0.4f, -0.2f, -0.6f, 0, -0.2f, -0.6f, 0, -0.2f, -0.6f, -0.4f, -0.2f, -0.6f, -0.4f)
			.setRotationPoint(-4, -7, -8.5f).setRotationAngle(0, 0, -0).setName("Box 25")
		);
		this.groups.add(door);
		//
		TurboList light = new TurboList("light");
		light.add(new ModelRendererTurbo(light, 89, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, -0.2f, -0.6f, 0, -0.2f, -0.6f, 0, 0.8f, -0.6f, 0, 0.8f, -0.6f, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0.8f, 0, 0, 0.8f, 0, 0)
			.setRotationPoint(6, -2.5f, -7.7f).setRotationAngle(0, 0, -0).setName("Box 55")
		);
		this.groups.add(light);
		//
		TurboList primary = new TurboList("primary");
		primary.add(new ModelRendererTurbo(primary, 81, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0)
			.setRotationPoint(-8, -9, -7).setRotationAngle(0, 0, -0).setName("Box 5")
		);
		primary.add(new ModelRendererTurbo(primary, 145, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 15, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -9, -7).setRotationAngle(0, 0, -0).setName("Box 6")
		);
		primary.add(new ModelRendererTurbo(primary, 185, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 15, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(7, -9, -7).setRotationAngle(0, 0, -0).setName("Box 7")
		);
		primary.add(new ModelRendererTurbo(primary, 81, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 7, 1, 0, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7.5f, -9, 7).setRotationAngle(0, 0, -0).setName("Box 11")
		);
		primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(primary);
		//
		TurboList regulator_lower = new TurboList("regulator_lower");
		regulator_lower.add(new ModelRendererTurbo(regulator_lower, 9, 25, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0.4f, -0.6f, -0.3f, 0.4f, -0.6f, -0.3f, 0.4f, 0, -0.3f, 0.4f, 0, -0.3f, 0.4f, -0.6f, -0.3f, 0.4f, -0.6f)
			.setRotationPoint(6.5f, -4, -8).setRotationAngle(0, 0, -49).setName("Box 63")
		);
		this.groups.add(regulator_lower);
		//
		TurboList regulator_upper = new TurboList("regulator_upper");
		regulator_upper.add(new ModelRendererTurbo(regulator_upper, 233, 9, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 1, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, 0.4f, -0.6f, -0.3f, 0.4f, -0.6f, -0.3f, 0.4f, 0, -0.3f, 0.4f, 0, -0.3f, 0.4f, -0.6f, -0.3f, 0.4f, -0.6f)
			.setRotationPoint(6.5f, -7, -8).setRotationAngle(0, 0, 44).setName("Box 62")
		);
		this.groups.add(regulator_upper);
	}

}
