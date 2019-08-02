//FMT-Marker FVTM-1.1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.RoadSignModel;

/** This file was exported via the FVTM Exporter V1.2 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.9 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvtm:models/roadsign/octagon")
public class RS_Octagon extends RoadSignModel {

	public static final RS_Octagon INSTANCE = new RS_Octagon();
	
	public RS_Octagon(){
		super(); textureX = 32; textureY = 16;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList border = new TurboList("border");
		border.add(new ModelRendererTurbo(border, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(-4, -1, -3).setRotationAngle(0, 0, 0)
		);
		border.add(new ModelRendererTurbo(border, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(-7, -12, -3).setRotationAngle(0, 0, 90)
		);
		border.add(new ModelRendererTurbo(border, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -12, -3).setRotationAngle(0, 0, 90)
		);
		border.add(new ModelRendererTurbo(border, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -11, -3).setRotationAngle(0, 0, -45)
		);
		border.add(new ModelRendererTurbo(border, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -16, -3).setRotationAngle(0, 0, 45)
		);
		border.add(new ModelRendererTurbo(border, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -5, -3).setRotationAngle(0, 0, 135)
		);
		border.add(new ModelRendererTurbo(border, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-3, 0, -3).setRotationAngle(0, 0, -135)
		);
		border.add(new ModelRendererTurbo(border, 0, 30, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -16, -3).setRotationAngle(0, 0, 0)
		);
		this.groups.add(border);
		//
		TurboList group0 = new TurboList("group0");
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, 0, 0, 14, 4, 0.125f, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 10.0f, 0.0f, 4.0f, 0.0f, 0.0f, 4.0f, 14.0f, 4.0f }, new float[]{ 24.0f, 0.0f, 18.0f, 0.0f, 14.0f, 4.0f, 28.0f, 4.0f } })
			.setRotationPoint(-7, -15, -2.375f).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, 0, 0, 14, 6, 0.125f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 14.0f, 4.0f, 0.0f, 4.0f, 0.0f, 10.0f, 14.0f, 10.0f }, new float[]{ 28.0f, 4.0f, 14.0f, 4.0f, 14.0f, 10.0f, 28.0f, 10.0f } })
			.setRotationPoint(-7, -11, -2.375f).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, 0, 0, textureX, textureY)
			.addTexRect(0, -1, 0, 14, 4, 0.125f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0,
			new float[][]{ new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f }, new float[]{ 14.0f, 10.0f, 0.0f, 10.0f, 4.0f, 14.0f, 10.0f, 14.0f }, new float[]{ 28.0f, 10.0f, 14.0f, 10.0f, 18.0f, 14.0f, 24.0f, 14.0f } })
			.setRotationPoint(-7, -4, -2.375f).setRotationAngle(0, 0, 0)
		);
		this.groups.add(group0);
	}

}
