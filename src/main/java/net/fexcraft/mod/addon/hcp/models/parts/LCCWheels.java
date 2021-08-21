//FMT-Marker FVTM-1.4
package net.fexcraft.mod.addon.hcp.models.parts;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.entity.Entity;

/** This file was exported via the FVTM Exporter V1.4 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.0.5 &copy; 2020 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/part/lcc_wheels")
public class LCCWheels extends PartModel {
	
	private TurboList wheels_right, wheels_left;

	public LCCWheels(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		wheels_right = new TurboList("wheels_right");
		wheels_right.add(new ModelRendererTurbo(wheels_right, 996, 170, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-64, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 975, 170, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-64, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 675, 210, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-64, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 858, 162, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-53, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 744, 162, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-53, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 431, 210, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-53, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 723, 162, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-75, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 21, 161, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-75, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 418, 210, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-75, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 848, 129, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-64, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 492, 128, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-53, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 1019, 123, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-75, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 0, 161, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(64, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 291, 160, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(64, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 405, 210, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(64, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 270, 160, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(75, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 156, 160, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(75, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 1006, 207, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(75, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 135, 160, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(53, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 989, 155, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(53, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 993, 207, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(53, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 1014, 123, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(64, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 312, 123, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(75, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 710, 120, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(53, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 21, 146, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(0, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 0, 146, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(0, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 161, 203, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(0, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 291, 145, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(11, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 270, 145, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(11, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 148, 203, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(11, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 156, 145, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-11, 5, -173).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 135, 145, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-11, 5, -175).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 135, 203, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-11, 5, -174).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 848, 118, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(0, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 1019, 112, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(11, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 1014, 112, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-11, 5, -178).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 827, 137, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-64, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 806, 137, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-64, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 26, 202, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-64, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 689, 135, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-53, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 21, 131, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-53, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 13, 202, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-53, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 0, 131, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-75, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 827, 122, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-75, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 0, 202, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-75, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 42, 111, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-64, 5, -186).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 360, 108, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-53, 5, -186).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 355, 108, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-75, 5, -186).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 806, 122, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(64, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 689, 120, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(64, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 566, 201, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(64, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 291, 120, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(75, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 270, 120, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(75, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 553, 201, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(75, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 135, 108, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(53, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 21, 108, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(53, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 540, 201, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(53, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 848, 107, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(64, 5, -186).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 712, 104, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(75, 5, -186).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 177, 103, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(53, 5, -186).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 0, 108, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(0, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 827, 107, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(0, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 431, 199, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(0, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 806, 107, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(11, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 156, 107, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(11, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 418, 199, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(11, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 135, 93, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-11, 5, -181).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 21, 93, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-11, 5, -183).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 405, 199, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-11, 5, -182).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 1015, 101, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(0, 5, -186).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 42, 100, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(11, 5, -186).setRotationAngle(0, 0, 0)
		);
		wheels_right.add(new ModelRendererTurbo(wheels_right, 177, 92, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-11, 5, -186).setRotationAngle(0, 0, 0)
		);
		this.groups.add(wheels_right);
		//
		wheels_left = new TurboList("wheels_left");
		wheels_left.add(new ModelRendererTurbo(wheels_left, 0, 93, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-64, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 156, 92, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-64, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 884, 197, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-64, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 818, 87, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-53, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 788, 84, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-53, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 871, 197, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-53, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 671, 84, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-75, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 135, 78, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-75, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 858, 197, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-75, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 42, 89, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-64, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 554, 86, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-53, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 42, 78, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-75, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 21, 78, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(64, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 0, 78, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(64, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1005, 196, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(64, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 809, 72, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(75, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 788, 69, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(75, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1005, 185, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(75, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 671, 69, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(53, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 318, 68, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(53, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 301, 181, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(53, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 554, 75, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(64, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 843, 72, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(75, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 201, 63, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(53, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 21, 57, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(0, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 0, 57, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(0, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 871, 177, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(0, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 180, 56, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(11, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 159, 56, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(11, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 858, 177, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(11, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 839, 51, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-11, 5, 183).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 818, 51, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-11, 5, 181).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1010, 155, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-11, 5, 182).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 42, 60, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(0, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1017, 55, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(11, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 201, 52, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-11, 5, 178).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 996, 45, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-64, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 975, 45, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-64, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 676, 120, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-64, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 21, 42, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-53, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 0, 42, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-53, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 588, 120, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-53, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 180, 41, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-75, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 159, 41, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-75, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 541, 75, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-75, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 42, 49, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-64, 5, 170).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1017, 44, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-53, 5, 170).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 201, 41, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-75, 5, 170).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 647, 39, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(64, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 839, 36, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(64, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 453, 75, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(64, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 818, 36, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(75, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 996, 30, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(75, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 352, 75, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(75, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 975, 30, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(53, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 21, 27, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(53, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 339, 75, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(53, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 42, 38, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(64, 5, 170).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1017, 33, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(75, 5, 170).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 42, 27, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(53, 5, 170).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 0, 27, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(0, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 647, 24, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(0, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 830, 72, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(0, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 839, 21, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(11, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 818, 21, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(11, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 379, 27, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(11, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 983, 15, textureX, textureY).addHollowCylinder(0, 0, 0, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-11, 5, 175).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 997, 0, textureX, textureY).addHollowCylinder(0, 0, -2, 5, 3, 2, 16, 0, 1, 1, 1, null)
			.setRotationPoint(-11, 5, 173).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1004, 15, textureX, textureY).addCylinder(0, 0, -2, 3, 4, 16, 1, 1, 1, null)
			.setRotationPoint(-11, 5, 174).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1017, 22, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(0, 5, 170).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1018, 11, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(11, 5, 170).setRotationAngle(0, 0, 0)
		);
		wheels_left.add(new ModelRendererTurbo(wheels_left, 1018, 0, textureX, textureY).addCylinder(0, 0, 0, 1, 8, 8, 1, 1, 1, null)
			.setRotationPoint(-11, 5, 170).setRotationAngle(0, 0, 0)
		);
		this.groups.add(wheels_left);
		//
		translate(0, -10, 0);
	}
	
    @Override
    public void render(VehicleData data, String us){
        switch(us){
            case "bogie_front":{ wheels_left.render(null, data, data, us, null); return; }
            case "bogie_rear":{ wheels_right.render(null, data, data, us, null); return; }
        }
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle, RenderCache cache){
        super.render(data, us);
    }

}
