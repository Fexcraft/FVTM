//FMT-Marker FVTM-1.4
package net.fexcraft.mod.addons.hcp.models.parts;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter V1.4 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.0.5 &copy; 2020 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/part/lcc_engine")
public class LCCEngine extends PartModel {

	public LCCEngine(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList engine = new TurboList("engine");
		engine.add(new ModelRendererTurbo(engine, 588, 120, textureX, textureY).addBox(0.5f, 0, 0, 37, 16, 13)
			.setRotationPoint(-51, -17, 171.5f).setRotationAngle(0, 0, 0)
		);
		engine.add(new ModelRendererTurbo(engine, 453, 75, textureX, textureY).addBox(0.5f, 0, 0, 37, 16, 13)
			.setRotationPoint(13, -17, 171.5f).setRotationAngle(0, 0, 0)
		);
		engine.add(new ModelRendererTurbo(engine, 635, 30, textureX, textureY).addBox(0.5f, 0, 0, 4, 4, 1)
			.setRotationPoint(-18.5f, -15, 184).setRotationAngle(0, 0, 0)
		);
		engine.add(new ModelRendererTurbo(engine, 512, 30, textureX, textureY).addBox(0.5f, 0, 0, 4, 4, 1)
			.setRotationPoint(45.5f, -15, 184).setRotationAngle(0, 0, 0)
		);
		engine.add(new ModelRendererTurbo(engine, 270, 181, textureX, textureY).addBox(-20.5f, 0, 0, 14, 8, 1)
			.setRotationPoint(-28, -11, 183.75f).setRotationAngle(0, 0, 0)
		);
		engine.add(new ModelRendererTurbo(engine, 526, 105, textureX, textureY).addBox(-20.5f, 0, 0, 14, 8, 1)
			.setRotationPoint(36, -11, 183.75f).setRotationAngle(0, 0, 0)
		);
		engine.add(new ModelRendererTurbo(engine, 635, 24, textureX, textureY).addCylinder(0, 0, 0, 2, 1, 16, 0.625f, 0.875f, 1, new net.fexcraft.lib.common.math.Vec3f(0.0, 0.0, 0.75))
			.setRotationPoint(-16, -13, 184.25f).setRotationAngle(0, 0, 0)
		);
		engine.add(new ModelRendererTurbo(engine, 512, 24, textureX, textureY).addCylinder(0, 0, 0, 2, 1, 16, 0.625f, 0.875f, 1, new net.fexcraft.lib.common.math.Vec3f(0.0, 0.0, 0.75))
			.setRotationPoint(48, -13, 184.25f).setRotationAngle(0, 0, 0)
		);
		this.groups.add(engine);
		//
		translate(0, -10, 0);
	}

}
