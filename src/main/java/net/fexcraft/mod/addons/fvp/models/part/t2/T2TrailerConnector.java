//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.t2;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/t2_trailer_connector")
public class T2TrailerConnector extends PartModel {

	public T2TrailerConnector(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList trailer_connector = new TurboList("trailer_connector");
		trailer_connector.add(new ModelRendererTurbo(trailer_connector, 129, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 3, 20, 0, 0, 0, -2, -3, 0, -2, -3, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-28, -17, -10).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		trailer_connector.add(new ModelRendererTurbo(trailer_connector, 465, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 3, 8, 0, -2, -1, -2, 0, 0, -2, 0, 0, 0, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43, -17, -10).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		trailer_connector.add(new ModelRendererTurbo(trailer_connector, 465, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 3, 8, 0, -2, -1, 0, 0, 0, 0, 0, 0, -2, -2, -1, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43, -17, 2).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		this.groups.add(trailer_connector);
	}

}