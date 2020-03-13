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
@fModel(registryname = "hcp:models/part/lcc_holder")
public class LCCHolder extends PartModel {

	public LCCHolder(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList holder = new TurboList("holder");
		holder.add(new ModelRendererTurbo(holder, 0, 20, textureX, textureY).addBox(0.5f, 0, 0, 192, 2, 4)
			.setRotationPoint(-96, -152, -24).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 517, 14, textureX, textureY).addBox(0.5f, 0, 0, 192, 2, 4)
			.setRotationPoint(-96, -152, 20).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 517, 7, textureX, textureY).addBox(0.5f, 0, 0, 192, 2, 4)
			.setRotationPoint(-96, -152, 12).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 517, 0, textureX, textureY).addBox(0.5f, 0, 0, 192, 2, 4)
			.setRotationPoint(-96, -152, -16).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 101, 596, textureX, textureY).addBox(0.5f, 0, 0, 8, 1, 47)
			.setRotationPoint(-95.5f, -151.5f, -23.5f).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 715, 588, textureX, textureY).addBox(0.5f, 0, 0, 8, 1, 47)
			.setRotationPoint(87.5f, -151.5f, -23.5f).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 540, 588, textureX, textureY).addBox(0.5f, 0, 0, 8, 1, 47)
			.setRotationPoint(39, -151.5f, -23.5f).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 899, 586, textureX, textureY).addBox(0.5f, 0, 0, 8, 1, 47)
			.setRotationPoint(-48, -151.5f, -23.5f).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 371, 584, textureX, textureY).addBox(0.5f, 0, 0, 8, 1, 47)
			.setRotationPoint(7, -151.5f, -23.5f).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 835, 569, textureX, textureY).addBox(0.5f, 0, 0, 8, 1, 47)
			.setRotationPoint(-16, -151.5f, -23.5f).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 692, 93, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(-95, -150, -23).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 1015, 87, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(-95, -150, 21).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 830, 83, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(-47, -150, -23).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 184, 71, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(-47, -150, 21).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 380, 68, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(-15, -150, -23).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 512, 60, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(-15, -150, 21).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 668, 47, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(12, -150, -23).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 635, 46, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(12, -150, 21).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 512, 46, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(44, -150, -23).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 282, 35, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(44, -150, 21).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 159, 35, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(93, -150, -23).setRotationAngle(0, 0, 0)
		);
		holder.add(new ModelRendererTurbo(holder, 1004, 26, textureX, textureY).addBox(0.5f, 0, 0, 2, 1, 2)
			.setRotationPoint(93, -150, 21).setRotationAngle(0, 0, 0)
		);
		holder.addProgram("//TODO");
		this.groups.add(holder);
		//
		translate(0, -10 + 112.0625f, 0);
	}

}
