//FMT-Marker FVTM-1.5
package net.fexcraft.mod.fvtm.model.entity;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelGroup;

/**
 * This file was exported via the FVTM Exporter v1.5 of<br>
 * FMT (Fex's Modelling Toolbox) v.2.7.3 &copy; 2022 - Fexcraft.net<br>
 * All rights reserved.
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadMarkerModel extends DefaultModel {
	
	public static RoadMarkerModel INST = new RoadMarkerModel();
	public ModelGroup arrow;
	public ModelGroup marker;

	public RoadMarkerModel(){
		super();
		tex_width = 32;
		tex_height = 16;
		//
		arrow = new ModelGroup("arrow");
		arrow.add(new ModelRendererTurbo(arrow, 13, 6, tex_width, tex_height).addCylinder(0, 0, 0, 2, 3, 8, 1, 0, 4, null)
			.setRotationPoint(0, -16, 0).setRotationAngle(0, 0, 0)
		);
		arrow.add(new ModelRendererTurbo(arrow, 23, 3, tex_width, tex_height).addCylinder(0, 0, 0, 0.5f, 8, 8, 1, 1, 4, null)
			.setRotationPoint(0, -24, 0).setRotationAngle(0, 0, 0)
		);
		groups.add(arrow);
		//
		marker = new ModelGroup("main");
		marker.add(new ModelRendererTurbo(marker, 19, 0, tex_width, tex_height).addBox(0, 0, 0, 4.5f, 1, 1.5f)
			.setRotationPoint(-3, -1, -3).setRotationAngle(0, 0, 0)
		);
		marker.add(new ModelRendererTurbo(marker, 0, 0, tex_width, tex_height).newCylinderBuilder()
			.setPosition(0, 0, 0).setRadius(3, 2).setLength(7).setSegments(8, 0, 22.5f).setScale(0.2f, 0.8f).setDirection(4)
			.setTopOffset(null).setTopRotation(new net.fexcraft.lib.common.math.Vec3f(0.0, 0.0, 0.0)).build()
			.setRotationPoint(0, -8, 0).setRotationAngle(0, 0, 0)
		);
		marker.add(new ModelRendererTurbo(marker, 19, 0, tex_width, tex_height).addBox(0, 0, 0, 4.5f, 1, 1.5f)
			.setRotationPoint(-1.5f, -1, 1.5f).setRotationAngle(0, 0, 0)
		);
		marker.add(new ModelRendererTurbo(marker, 12, 0, tex_width, tex_height).addBox(0, 0, 0, 1.5f, 1, 4.5f)
			.setRotationPoint(-3, -1, -1.5f).setRotationAngle(0, 0, 0)
		);
		marker.add(new ModelRendererTurbo(marker, 12, 0, tex_width, tex_height).addBox(0, 0, 0, 1.5f, 1, 4.5f)
			.setRotationPoint(1.5f, -1, -3).setRotationAngle(0, 0, 0)
		);
		groups.add(marker);
	}

}
