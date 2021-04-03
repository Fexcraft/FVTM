//FMT-Marker FVTM-1.4
package net.fexcraft.mod.addons.hcp.models.vehicle;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.VehicleModel;
import net.minecraft.entity.Entity;

/** This file was exported via the FVTM Exporter V1.4 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.0.5 &copy; 2020 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/vehicle/large_container_crane")
public class LargeContainerCrane extends VehicleModel {

	public LargeContainerCrane(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		item_scale.setAll(.03125f);
		//
		TurboList chassis_right = new TurboList("chassis_right");
		chassis_right.add(new ModelRendererTurbo(chassis_right, 945, 324, textureX, textureY).addBox(0.5f, 0, 0, 29, 6, 6)
			.setRotationPoint(17, -1, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 945, 311, textureX, textureY).addBox(0.5f, 0, 0, 29, 6, 6)
			.setRotationPoint(-47, -1, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 0, 398, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 33, 1, 16, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-81, -2, -186).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 333, 385, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 33, 1, 16, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17, -2, -186).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 911, 380, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 33, 1, 16, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(47, -2, -186).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 0, 575, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(-78, -18, -185).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 270, 574, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(-14, -18, -185).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 203, 574, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(50, -18, -185).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 136, 573, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(-78, -18, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 815, 569, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(-14, -18, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 439, 567, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(50, -18, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 372, 567, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-78, -26, -185).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 748, 563, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -26, -185).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 681, 563, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -26, -185).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 748, 548, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-78, -26, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 681, 548, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -26, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 881, 446, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -26, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 913, 545, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-78, -58, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 610, 543, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-14, -58, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 539, 538, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(50, -58, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 71, 534, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-78, -90, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 0, 534, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-14, -90, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 301, 533, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(50, -90, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 230, 533, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-78, -122, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 159, 532, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-14, -122, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 540, 245, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 5)
			.setRotationPoint(13, -18, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 927, 232, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 5)
			.setRotationPoint(-51, -18, -177).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 540, 187, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 5)
			.setRotationPoint(-51, -18, -184).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 540, 173, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 5)
			.setRotationPoint(13, -18, -184).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 842, 528, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(50, -122, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 468, 526, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-78, -154, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 309, 453, textureX, textureY).addBox(0.5f, 0, 0, 27, 10, 8)
			.setRotationPoint(-14, -132, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 397, 526, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(50, -154, -182).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 405, 143, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 6)
			.setRotationPoint(13, -130, -181).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 405, 128, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 6)
			.setRotationPoint(-51, -130, -181).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 945, 298, textureX, textureY).addBox(0.5f, 0, 0, 29, 6, 6)
			.setRotationPoint(-47, -1, -185).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 945, 285, textureX, textureY).addBox(0.5f, 0, 0, 29, 6, 6)
			.setRotationPoint(17, -1, -185).setRotationAngle(0, 0, 0)
		);
		chassis_right.add(new ModelRendererTurbo(chassis_right, 135, 131, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 12, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -5, -184).setRotationAngle(0, 0, 0)
		);
		chassis_right.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_right);
		//
		TurboList chassis_left = new TurboList("chassis_left");
		chassis_left.add(new ModelRendererTurbo(chassis_left, 675, 268, textureX, textureY).addBox(0.5f, 0, 0, 29, 6, 6)
			.setRotationPoint(17, -1, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 927, 259, textureX, textureY).addBox(0.5f, 0, 0, 29, 6, 6)
			.setRotationPoint(-47, -1, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 0, 380, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 33, 1, 16, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-81, -2, 170).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 919, 362, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 33, 1, 16, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17, -2, 170).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 905, 343, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 33, 1, 16, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(47, -2, 170).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 775, 525, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(-78, -18, 171).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 708, 525, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(-14, -18, 171).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 956, 522, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(50, -18, 171).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 641, 520, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(-78, -18, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 895, 505, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(-14, -18, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 641, 497, textureX, textureY).addBox(0.5f, 0, 0, 27, 16, 6)
			.setRotationPoint(50, -18, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 309, 438, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-78, -26, 171).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 881, 431, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -26, 171).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 762, 410, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -26, 171).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 333, 403, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-78, -26, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 911, 398, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -26, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 113, 345, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 27, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(50, -26, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 570, 497, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-78, -58, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 167, 491, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-14, -58, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 499, 485, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(50, -58, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 428, 485, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-78, -90, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 824, 484, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-14, -90, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 753, 484, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(50, -90, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 357, 480, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-78, -122, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 929, 464, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-14, -122, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 270, 106, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 5)
			.setRotationPoint(13, -18, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 270, 92, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 5)
			.setRotationPoint(-51, -18, 179).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 935, 87, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 5)
			.setRotationPoint(-51, -18, 172).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 294, 27, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 5)
			.setRotationPoint(13, -18, 172).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 690, 444, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(50, -122, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 238, 438, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(-78, -154, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 762, 391, textureX, textureY).addBox(0.5f, 0, 0, 27, 10, 8)
			.setRotationPoint(-14, -132, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 951, 423, textureX, textureY).addBox(0.5f, 0, 0, 27, 32, 8)
			.setRotationPoint(50, -154, 174).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 935, 72, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 6)
			.setRotationPoint(13, -130, 175).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 910, 0, textureX, textureY).addBox(0.5f, 0, 0, 37, 8, 6)
			.setRotationPoint(-51, -130, 175).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 927, 246, textureX, textureY).addBox(0.5f, 0, 0, 29, 6, 6)
			.setRotationPoint(-47, -1, 171).setRotationAngle(0, 0, 0)
		);
		chassis_left.add(new ModelRendererTurbo(chassis_left, 625, 245, textureX, textureY).addBox(0.5f, 0, 0, 29, 6, 6)
			.setRotationPoint(17, -1, 171).setRotationAngle(0, 0, 0)
		);
		chassis_left.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_left);
		//
		TurboList top_front = new TurboList("top_front");
		top_front.add(new ModelRendererTurbo(top_front, 270, 287, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 30)
			.setRotationPoint(42, -158, -198).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 135, 242, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 30)
			.setRotationPoint(42, -166, -198).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 0, 345, textureX, textureY).addBox(0.5f, 0, 0, 41, 4, 30)
			.setRotationPoint(43, -162, -198).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 657, 338, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -158, -168).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 270, 332, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -166, -168).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 0, 481, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(46, -162, -168).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 522, 321, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -158, -120).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 0, 292, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -166, -120).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 238, 480, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(46, -162, -120).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 810, 290, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -158, -72).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 135, 287, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -166, -72).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 571, 444, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(46, -162, -72).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 675, 285, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -158, -24).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 387, 279, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -166, -24).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 119, 438, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(46, -162, -24).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 540, 268, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -158, 24).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 0, 237, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -166, 24).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 452, 432, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(46, -162, 24).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 252, 234, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -158, 72).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 792, 232, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -166, 72).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 762, 431, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(46, -162, 72).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 405, 226, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -158, 120).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 657, 215, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(42, -166, 120).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 0, 428, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(46, -162, 120).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 558, 210, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 30)
			.setRotationPoint(42, -158, 168).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 153, 207, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 30)
			.setRotationPoint(42, -166, 168).setRotationAngle(0, 0, 0)
		);
		top_front.add(new ModelRendererTurbo(top_front, 792, 343, textureX, textureY).addBox(0.5f, 0, 0, 41, 4, 30)
			.setRotationPoint(43, -162, 168).setRotationAngle(0, 0, 0)
		);
		top_front.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(top_front);
		//
		TurboList top_rear = new TurboList("top_rear");
		top_rear.add(new ModelRendererTurbo(top_rear, 876, 197, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 30)
			.setRotationPoint(-86, -158, -198).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 858, 162, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 30)
			.setRotationPoint(-86, -166, -198).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 153, 340, textureX, textureY).addBox(0.5f, 0, 0, 41, 4, 30)
			.setRotationPoint(-85, -162, -198).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 0, 184, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -158, -168).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 270, 181, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -166, -168).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 333, 427, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(-82, -162, -168).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 405, 173, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -158, -120).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 723, 162, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -166, -120).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 643, 391, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(-82, -162, -120).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 588, 157, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -158, -72).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 135, 145, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -166, -72).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 214, 385, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(-82, -162, -72).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 0, 131, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -158, -24).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 270, 128, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -166, -24).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 524, 379, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(-82, -162, -24).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 453, 120, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -158, 24).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 806, 109, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -166, 24).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 792, 378, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(-82, -162, 24).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 671, 104, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -158, 72).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 135, 92, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -166, 72).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 95, 375, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(-82, -162, 72).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 0, 78, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -158, 120).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 318, 75, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 48)
			.setRotationPoint(-86, -166, 120).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 405, 374, textureX, textureY).addBox(0.5f, 0, 0, 35, 4, 48)
			.setRotationPoint(-82, -162, 120).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 818, 72, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 30)
			.setRotationPoint(-86, -158, 168).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 671, 69, textureX, textureY).addBox(0.5f, 0, 0, 43, 4, 30)
			.setRotationPoint(-86, -166, 168).setRotationAngle(0, 0, 0)
		);
		top_rear.add(new ModelRendererTurbo(top_rear, 405, 332, textureX, textureY).addBox(0.5f, 0, 0, 41, 4, 30)
			.setRotationPoint(-85, -162, 168).setRotationAngle(0, 0, 0)
		);
		top_rear.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(top_rear);
		//
		TurboList ladder = new TurboList("ladder");
		ladder.add(new ModelRendererTurbo(ladder, 688, 210, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 2, 18, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, -6, 0, 0, -6)
			.setRotationPoint(-8, -150, -172).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 35, 209, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 2, 18, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 6, 0, 0, -6, 0, 0, -6)
			.setRotationPoint(5, -150, -172).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 0, 213, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 4)
			.setRotationPoint(-6, -150, -172).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 540, 212, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 4)
			.setRotationPoint(-6, -147, -173).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 239, 198, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 4)
			.setRotationPoint(-6, -144, -174).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 208, 198, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 4)
			.setRotationPoint(-6, -141, -175).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 723, 195, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 4)
			.setRotationPoint(-6, -138, -176).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 135, 184, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 4)
			.setRotationPoint(-6, -135, -177).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 405, 168, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -130, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 588, 165, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -124, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 270, 135, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -118, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 0, 123, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -112, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 155, 122, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -106, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 337, 120, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -100, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 312, 120, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -94, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 453, 118, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -88, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 478, 115, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -82, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 453, 115, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -76, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 671, 114, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -70, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 990, 104, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -64, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 965, 104, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -58, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 990, 101, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -52, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 965, 101, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -46, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 318, 86, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -40, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 0, 72, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -34, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 159, 71, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -28, -183).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 603, 66, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -23, -184).setRotationAngle(-13, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 578, 66, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -16, -186).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 553, 66, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -10, -186).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 647, 64, textureX, textureY).addBox(0.5f, 0, 0, 11, 1, 1)
			.setRotationPoint(-6, -4, -186).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 529, 279, textureX, textureY).addBox(0.5f, 0, 0, 1, 32, 2)
			.setRotationPoint(-7, -122, -184).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 522, 279, textureX, textureY).addBox(0.5f, 0, 0, 1, 32, 2)
			.setRotationPoint(5, -122, -184).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 1015, 253, textureX, textureY).addBox(0.5f, 0, 0, 1, 32, 2)
			.setRotationPoint(-7, -90, -184).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 444, 234, textureX, textureY).addBox(0.5f, 0, 0, 1, 32, 2)
			.setRotationPoint(5, -90, -184).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 833, 225, textureX, textureY).addBox(0.5f, 0, 0, 1, 32, 2)
			.setRotationPoint(-7, -58, -184).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 446, 181, textureX, textureY).addBox(0.5f, 0, 0, 1, 32, 2)
			.setRotationPoint(5, -58, -184).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 998, 246, textureX, textureY).addBox(0.5f, 0, 0, 1, 11, 7)
			.setRotationPoint(-7, -133, -184).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 540, 226, textureX, textureY).addBox(0.5f, 0, 0, 1, 11, 7)
			.setRotationPoint(5, -133, -184).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 433, 234, textureX, textureY).addBox(0.5f, 0, 0, 1, 16, 4)
			.setRotationPoint(-7, -18, -186).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 1012, 232, textureX, textureY).addBox(0.5f, 0, 0, 1, 16, 4)
			.setRotationPoint(5, -18, -186).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 170, 210, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 8, 4, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -26, -186).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 575, 208, textureX, textureY)
			.addShapeBox(0.5f, 0, 0, 1, 8, 4, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -26, -186).setRotationAngle(0, 0, 0)
		);
		this.groups.add(ladder);
		//
		TurboList wheel_chassis_left = new TurboList("wheel_chassis_left");
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 416, 387, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(-47.5f, -1, 170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 135, 198, textureX, textureY).addBox(0, 0, 0, 35, 3, 1)
			.setRotationPoint(-81.5f, 4, 186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 99, 380, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(-81.5f, -1, 170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 214, 375, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(80.5f, -1, 170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 723, 157, textureX, textureY).addBox(0, 0, 0, 35, 3, 1)
			.setRotationPoint(46.5f, 4, 186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 524, 374, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(46.5f, -1, 170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 266, 340, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(16.5f, -1, 170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 588, 150, textureX, textureY).addBox(0, 0, 0, 35, 3, 1)
			.setRotationPoint(-17.5f, 4, 186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 657, 338, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(-17.5f, -1, 170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 792, 215, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 8, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-81.5f, -1, 169).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 405, 158, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 8, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46.5f, -1, 169).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 941, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 8, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17.5f, -1, 169).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 941, 139, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-81.5f, -1, 186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 941, 133, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46.5f, -1, 186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.add(new ModelRendererTurbo(wheel_chassis_left, 941, 127, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17.5f, -1, 186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_left.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(wheel_chassis_left);
		//
		TurboList wheel_chassis_right = new TurboList("wheel_chassis_right");
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 518, 332, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(-47.5f, -1, -186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 941, 122, textureX, textureY).addBox(0, 0, 0, 35, 3, 1)
			.setRotationPoint(-81.5f, 4, -187).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 0, 315, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(-81.5f, -1, -186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 135, 290, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(80.5f, -1, -186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 941, 117, textureX, textureY).addBox(0, 0, 0, 35, 3, 1)
			.setRotationPoint(46.5f, 4, -187).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 0, 290, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(46.5f, -1, -186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 387, 287, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(16.5f, -1, -186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 318, 63, textureX, textureY).addBox(0, 0, 0, 35, 3, 1)
			.setRotationPoint(-17.5f, 4, -187).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 810, 285, textureX, textureY).addBox(0, 0, 0, 1, 8, 16)
			.setRotationPoint(-17.5f, -1, -186).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 941, 107, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-81.5f, -1, -170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 453, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46.5f, -1, -170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 318, 53, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17.5f, -1, -170).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 318, 47, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-81.5f, -1, -187).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 318, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46.5f, -1, -187).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.add(new ModelRendererTurbo(wheel_chassis_right, 910, 15, textureX, textureY)
			.addShapeBox(0, 0, 0, 35, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-17.5f, -1, -187).setRotationAngle(0, 0, 0)
		);
		wheel_chassis_right.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(wheel_chassis_right);
		TurboList wheels_right = new TurboList("wheels_right");
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
		TurboList wheels_left = new TurboList("wheels_left");
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
		TurboList outer_controls = new TurboList("outer_controls");
		outer_controls.add(new ModelRendererTurbo(outer_controls, 379, 38, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-44, -4.5f, -184.25f).setRotationAngle(0, 0, 0)
		);
		outer_controls.add(new ModelRendererTurbo(outer_controls, 374, 27, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-44, -2.75f, -184.25f).setRotationAngle(0, 0, 0)
		);
		outer_controls.add(new ModelRendererTurbo(outer_controls, 291, 27, textureX, textureY).addBox(0, -3, 0, 1, 3, 1)
			.setRotationPoint(-40.5f, -1.5f, -184.25f).setRotationAngle(0, 0, 0)
		);
		outer_controls.add(new ModelRendererTurbo(outer_controls, 975, 24, textureX, textureY).addBox(0, -3, 0, 1, 3, 1)
			.setRotationPoint(-37.5f, -1.5f, -184.25f).setRotationAngle(0, 0, 0)
		);
		outer_controls.add(new ModelRendererTurbo(outer_controls, 975, 21, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-34, -4.5f, -184.25f).setRotationAngle(0, 0, 0)
		);
		outer_controls.add(new ModelRendererTurbo(outer_controls, 516, 14, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-34, -2.75f, -184.25f).setRotationAngle(0, 0, 0)
		);
		outer_controls.addProgram(new TurboList.Program(){

			@Override
			public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
				if(ent == null) return;
				list.get(2).rotationAngleX = (data.getAttribute("lcc_h").integer_value() + 9) * 2.25f;
				list.get(3).rotationAngleX = data.getAttribute("lcc_v").integer_value() * -6;
			}

			@Override
			public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
				//
			}
			
		});
		this.groups.add(outer_controls);
		//
		translate(0, -10, 0);
	}

}
