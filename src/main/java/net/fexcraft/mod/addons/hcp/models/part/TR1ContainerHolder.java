//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/part/tr1_container_holder")
public class TR1ContainerHolder extends PartModel {

	public TR1ContainerHolder(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList container_holder = new TurboList("container_holder");
		container_holder.add(new ModelRendererTurbo(container_holder, 409, 185, textureX, textureY).addBox(0, 0, 0, 4, 4, 8)
			.setRotationPoint(-16, -28, -25).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 449, 185, textureX, textureY).addBox(0, 0, 0, 4, 4, 8)
			.setRotationPoint(-16, -28, 17).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 145, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 8, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-12, -28, -25).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 185, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 8, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-12, -28, 17).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 401, 209, textureX, textureY).addBox(0, 0, 0, 4, 4, 8)
			.setRotationPoint(-212, -28, -25).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 441, 209, textureX, textureY).addBox(0, 0, 0, 4, 4, 8)
			.setRotationPoint(-212, -28, 17).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 225, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 8, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-220, -28, -25).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 265, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 8, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-220, -28, 17).setRotationAngle(0, 0, 0).setName("Box 138")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 401, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -28, -25).setRotationAngle(0, 0, 0).setName("Box 139")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 145, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -28, 24).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 169, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-208, -28, 24).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 257, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-208, -28, -25).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 369, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-110, -28, -25).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 497, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-114, -28, -25).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 489, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-122, -28, -25).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 497, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-114, -28, 24).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 489, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-110, -28, 24).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 25, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-122, -28, 24).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 1, 241, textureX, textureY).addBox(0, 0, 0, 20, 4, 50)
			.setRotationPoint(-2, -28, -25).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 249, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 2, 50, 0, -2, 0, -2, -2, 0, -2, -2, 0, -2, -2, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2, -30, -25).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		container_holder.add(new ModelRendererTurbo(container_holder, 345, 289, textureX, textureY).addBox(0, 0, 0, 18, 1, 48)
			.setRotationPoint(-1, -31, -24).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		this.groups.add(container_holder);
	}

}
