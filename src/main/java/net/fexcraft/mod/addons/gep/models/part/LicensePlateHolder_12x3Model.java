//FMT-Marker FVTM-1.5
package net.fexcraft.mod.addons.gep.models.part;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter v1.5 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.6.5 &copy; 2021 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "gep:models/part/lph_12x3")
public class LicensePlateHolder_12x3Model extends PartModel {

	public LicensePlateHolder_12x3Model(){
		super(); textureX = 16; textureY = 16;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, -1, -1, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(0.05f, 3, 12)
			.removePolygons(2, 3, 4, 5)
			.setPolygonUV(1, new float[]{ 0.0f, 13.0f, 12.0f, 16.0f })
			.setPolygonUV(0, new float[]{ 0.0f, 10.0f, 12.0f, 13.0f })
			.setDetachedUV(1, 0).build()
			.setRotationPoint(-0.05f, -1.5f, -6).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, -1, -1, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(0.1f, 0.1f, 12)
			.setPolygonUV(1, new float[]{ 8.0f, 0.0f, 12.0f, 4.0f })
			.setPolygonUV(3, new float[]{ 8.0f, 0.0f, 12.0f, 4.0f })
			.setPolygonUV(0, new float[]{ 8.0f, 0.0f, 12.0f, 4.0f })
			.setPolygonUV(5, new float[]{ 8.0f, 0.0f, 12.0f, 4.0f })
			.setPolygonUV(4, new float[]{ 8.0f, 0.0f, 12.0f, 4.0f })
			.setPolygonUV(2, new float[]{ 8.0f, 0.0f, 12.0f, 4.0f })
			.setDetachedUV(1, 3, 0, 5, 4, 2).build()
			.setRotationPoint(-0.05f, -1.6f, -6).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, -1, -1, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(0.1f, 3.6f, 0.1f)
			.setCorners(0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, 0)
			.setPolygonUV(1, new float[]{ 0.0f, 0.0f, 4.0f, 4.0f })
			.setPolygonUV(3, new float[]{ 0.0f, 0.0f, 4.0f, 4.0f })
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f, 4.0f, 4.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f, 4.0f, 4.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f, 4.0f, 4.0f })
			.setPolygonUV(2, new float[]{ 0.0f, 0.0f, 4.0f, 4.0f })
			.setDetachedUV(1, 3, 0, 5, 4, 2).build()
			.setRotationPoint(-0.05f, -1.6f, -6.1f).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, -1, -1, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(0.1f, 3.6f, 0.1f)
			.setCorners(0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0)
			.setPolygonUV(1, new float[]{ 4.0f, 0.0f, 8.0f, 4.0f })
			.setPolygonUV(3, new float[]{ 4.0f, 0.0f, 8.0f, 4.0f })
			.setPolygonUV(0, new float[]{ 4.0f, 0.0f, 8.0f, 4.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f, 8.0f, 4.0f })
			.setPolygonUV(4, new float[]{ 4.0f, 0.0f, 8.0f, 4.0f })
			.setPolygonUV(2, new float[]{ 4.0f, 0.0f, 8.0f, 4.0f })
			.setDetachedUV(1, 3, 0, 5, 4, 2).build()
			.setRotationPoint(-0.05f, -1.6f, 6).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, -1, -1, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(0.1f, 0.5f, 12)
			.removePolygons(4, 5)
			.setPolygonUV(1, new float[]{ 12.0f, 0.0f, 16.0f, 4.0f })
			.setPolygonUV(3, new float[]{ 12.0f, 0.0f, 16.0f, 4.0f })
			.setPolygonUV(0, new float[]{ 0.0f, 5.0f, 16.0f, 7.0f })
			.setPolygonUV(2, new float[]{ 12.0f, 0.0f, 16.0f, 4.0f })
			.setDetachedUV(1, 3, 0, 2).build()
			.setRotationPoint(-0.05f, 1.5f, -6).setRotationAngle(0, 0, 0)
		);
		this.groups.add(group0);
		//
	}

}
