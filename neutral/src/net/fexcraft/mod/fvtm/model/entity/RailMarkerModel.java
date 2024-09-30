//FMT-Marker FVTM-1.6
package net.fexcraft.mod.fvtm.model.entity;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelGroup;

/** This file was exported via the FVTM Exporter v1.6 of<br>
 *  FMT (Fex's Modelling Toolbox) v.3.24274.2048 &copy; 2024 - fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
public class RailMarkerModel extends DefaultModel {

	public static RailMarkerModel INST = new RailMarkerModel();
	public ModelGroup base;
	public ModelGroup glow;
	public ModelGroup arrow;

	public RailMarkerModel(){
		super();
		textureX = 32;
		textureY = 32;
		//
		glow = new ModelGroup("glow");
		glow.add(new ModelRendererTurbo(glow, 13, 0, textureX, textureY).addBox(0, 0, 0, 3.2f, 0.2f, 3.2f)
			.setRotationPoint(-1.6f, 14.2f, -1.6f).setRotationAngle(0, 0, 0)
		);
		glow.add(new ModelRendererTurbo(glow, 0, 0, textureX, textureY).addBox(0, 0, 0, 3.2f, 0.2f, 3.2f)
			.setRotationPoint(-1.6f, 14.6f, -1.6f).setRotationAngle(0, 0, 0)
		);
		groups.add(glow);
		//
		base = new ModelGroup("base");
		base.add(new ModelRendererTurbo(base, 10, 14, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 4, 0, 4, -4, 0, 4, -4, 0, -4, 4, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, 0, -1).setRotationAngle(0, 0, 0)
		);
		base.add(new ModelRendererTurbo(base, 13, 5, textureX, textureY).addCylinder(0, 0, 0, 3, 2, 16, 1, 1, 4, null)
			.setRotationPoint(0, 12, 0).setRotationAngle(0, 0, 0)
		);
		base.add(new ModelRendererTurbo(base, 0, 5, textureX, textureY).addBox(0, 0, 0, 3, 1, 3)
			.setRotationPoint(-1.5f, 14, -1.5f).setRotationAngle(0, 0, 0)
		);
		base.add(new ModelRendererTurbo(base, 15, 17, textureX, textureY).addBox(0, 0, 0, 0.4f, 0.4f, 4)
			.setRotationPoint(-0.2f, 0, -2).setRotationAngle(0, 0, 0)
		);
		base.add(new ModelRendererTurbo(base, 5, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, 4, 0, -4, -4, 0, -4, -4, 0, 4, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, 0, 0).setRotationAngle(0, 0, 0)
		);
		base.add(new ModelRendererTurbo(base, 0, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, -4, 0, -4, 4, 0, -4, 4, 0, 4, -4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
		);
		base.add(new ModelRendererTurbo(base, 26, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 12, 1, 0, -4, 0, 4, 4, 0, 4, 4, 0, -4, -4, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, 0, -1).setRotationAngle(0, 0, 0)
		);
		base.add(new ModelRendererTurbo(base, 15, 14, textureX, textureY).addBox(0, 0, 0, 4, 0.4f, 0.4f)
			.setRotationPoint(-2, 0, -0.2f).setRotationAngle(0, 0, 0)
		);
		groups.add(base);
		//
		arrow = new ModelGroup("arrow");
		arrow.add(new ModelRendererTurbo(arrow, 1, 24, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 8, 1, 0, 5, null)
			.setRotationPoint(0, 16, 0).setRotationAngle(0, 0, 0)
		);
		arrow.add(new ModelRendererTurbo(arrow, 26, 14, textureX, textureY).addCylinder(0, 0, 0, 0.5f, 8, 8, 1, 1, 4, null)
			.setRotationPoint(0, 19, 0).setRotationAngle(0, 0, 0)
		);
		groups.add(arrow);
	}

}
