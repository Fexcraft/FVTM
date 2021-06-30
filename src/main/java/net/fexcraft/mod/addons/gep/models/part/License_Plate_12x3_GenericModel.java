//FMT-Marker FVTM-1.5
package net.fexcraft.mod.addons.gep.models.part;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter v1.5 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.6.5 &copy; 2021 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "gep:models/part/lp_12x3_generic")
public class License_Plate_12x3_GenericModel extends PartModel {

	public License_Plate_12x3_GenericModel(){
		super(); textureX = 8; textureY = 8;
		this.addToCreators("Ferdinand");
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(0.05f, 3, 4)
			.setPolygonUV(1, new float[]{ 4.0f, 3.0f, 8.0f, 6.0f })
			.setPolygonUV(3, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f, 4.0f, 3.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(2, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f }).build()
			.setRotationPoint(0, -1.5f, -6).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(0.05f, 3, 4)
			.setPolygonUV(1, new float[]{ 4.0f, 3.0f, 8.0f, 6.0f })
			.setPolygonUV(3, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(0, new float[]{ 4.0f, 0.0f, 8.0f, 3.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(2, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f }).build()
			.setRotationPoint(0, -1.5f, -2).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(0.05f, 3, 4)
			.setPolygonUV(1, new float[]{ 4.0f, 3.0f, 8.0f, 6.0f })
			.setPolygonUV(3, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(0, new float[]{ 0.0f, 3.0f, 4.0f, 6.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f })
			.setPolygonUV(2, new float[]{ 0.0f, 6.0f, 4.0f, 7.0f }).build()
			.setRotationPoint(0, -1.5f, 2).setRotationAngle(0, 0, 0)
		);
		group0.addProgram(new DefaultPrograms.AttributeTextRenderer("license_plate", -0.1f, -0.75f, 0, 0, 0, 0, 3.5f, true));
		this.groups.add(group0);
	}

}
