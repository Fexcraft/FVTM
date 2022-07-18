//FMT-Marker FVTM-1.5
package net.fexcraft.mod.fvtm.model.entity;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.PartModel;

/** This file was exported via the FVTM Exporter v1.5 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.7.3 &copy; 2022 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
public class RailMarkerModel extends PartModel {
	
	public ModelGroup arrow, marker;

	public RailMarkerModel(){
		super();
		textureX = 16;
		textureY = 32;
		//
		arrow = new ModelGroup("arrow");
		arrow.add(new ModelRendererTurbo(arrow, 8, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 3, 8, 1, 0, 4, null)
			.setRotationPoint(0, -20, 0).setRotationAngle(0, 0, 0)
		);
		arrow.add(new ModelRendererTurbo(arrow, 8, 7, textureX, textureY).addCylinder(0, 0, 0, 0.5f, 8, 8, 1, 1, 4, null)
			.setRotationPoint(0, -28, 0).setRotationAngle(0, 0, 0)
		);
		groups.add(arrow);
		//
		marker = new ModelGroup("marker");
		marker.add(new ModelRendererTurbo(marker, 0, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 15, 8, 1, 1, 4, null)
			.setRotationPoint(0, -15, 0).setRotationAngle(0, 0, 0)
		);
		marker.add(new ModelRendererTurbo(marker, 0, 19, textureX, textureY).addCylinder(0, 0, 0, 2.5f, 1, 8, 1, 1, 4, null)
			.setRotationPoint(0, -16, 0).setRotationAngle(0, 0, 0)
		);
		groups.add(marker);
	}

}
