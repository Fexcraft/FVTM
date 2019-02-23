//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.c4;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.7-test &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/c4_wheel")
public class C4R1Wheel extends PartModel {

	public C4R1Wheel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList wheel = new TurboList("wheel");
		wheel.add(new ModelRendererTurbo(wheel, 282, 12, textureX, textureY).addHollowCylinder(0, 0, 1, 9, 6, 3, 16, 0, 1, 1, 1));
		wheel.add(new ModelRendererTurbo(wheel, 35, 38, textureX, textureY)
			.addShapeBox(2.5f, -1.5f, 1.5f, 4, 3, 1, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0)
		);
		wheel.add(new ModelRendererTurbo(wheel, 266, 20, textureX, textureY).addCylinder(0, 0, 0, 3, 3, 16, 1, 1, 1));
		wheel.add(new ModelRendererTurbo(wheel, 468, 4, textureX, textureY).addHollowCylinder(0, 0, 4, 9, 6, 1, 16, 0, 0.9375f, 1, 1));
		wheel.add(new ModelRendererTurbo(wheel, 0, 0, textureX, textureY).addHollowCylinder(0, 0, 0, 9, 6, 1, 16, 0, 0.9375f, 1, 0));
		wheel.add(new ModelRendererTurbo(wheel, 266, 30, textureX, textureY)
			.addShapeBox(-5.5f, -1.5f, 1.5f, 4, 3, 1, 0, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(-0.5f, 0, 0).setRotationAngle(0, 0, 0)
		);
		wheel.add(new ModelRendererTurbo(wheel, 37, 6, textureX, textureY)
			.addShapeBox(-1.5f, 2.5f, 1.5f, 3, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f)
		);
		wheel.add(new ModelRendererTurbo(wheel, 37, 0, textureX, textureY)
			.addShapeBox(-1.5f, -6.5f, 1.5f, 3, 4, 1, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
		);
		wheel.addPrograms(DefaultPrograms.ADJUSTABLE_WHEEL, DefaultPrograms.DEF_WHEEL_ROTATE);//, DefaultPrograms.NO_CULLFACE);
		for(ModelRendererTurbo turbo : wheel) turbo.mirror = true;
		this.groups.add(wheel);
	}

}
