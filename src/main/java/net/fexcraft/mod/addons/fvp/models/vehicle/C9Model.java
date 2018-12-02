//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/vehicle/c9")
public class C9Model extends VehicleModel {

	public C9Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY).addBox(0, 0, 0, 48, 2, 37)
			.setRotationPoint(-24.5f, 10, -18.5f).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 14, 1, 0, 0, -0.5f, 0, 0, -3, -1, 0, -3, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(23.5f, -4, -12).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 22, 14, 1, 0, 0, -0.5f, 0, 0, -3, 1, 0, -3, -1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(23.5f, -4, 11).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 37, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(41, 8.5f, -18.5f).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 2, 27, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -0.5f, 1, 0, -0.5f, 1, 0, 0, 0, 0)
			.setRotationPoint(-41, 9, -13.5f).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 1, 1, 0, 0, -0.2f, -0.4f, 0, -0.2f, -0.5f, 0, -0.2f, -0.4f, 0, -0.2f, -0.5f, -0.2f, 0, -0.4f, -0.2f, 0, -0.5f, -0.2f, 0, -0.4f, -0.2f, 0, -0.5f)
			.setRotationPoint(-24.5f, 12, -19.5f).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 1, 1, 0, 0, -0.2f, -0.5f, 0, -0.2f, -0.4f, 0, -0.2f, -0.5f, 0, -0.2f, -0.4f, -0.2f, 0, -0.5f, -0.2f, 0, -0.4f, -0.2f, 0, -0.5f, -0.2f, 0, -0.4f)
			.setRotationPoint(-24.5f, 12, 18.5f).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 1, 1, 0, 0, -0.7f, -0.9f, 0, -0.7f, -0.9f, 0, -1, 0, 0, -1, 0, 0, 0.2f, -0.4f, 0, 0.2f, -0.5f, 0, 0.2f, -0.4f, 0, 0.2f, -0.5f)
			.setRotationPoint(-24.5f, 11, -19.5f).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, -0.7f, -0.9f, 0, -0.7f, -0.9f, 0, 0.2f, -0.5f, 0, 0.2f, -0.4f, 0, 0.2f, -0.5f, 0, 0.2f, -0.4f)
			.setRotationPoint(-24.5f, 11, 18.5f).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 249, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 1, 6, 0, 0, 0, 0, 0, -2.5f, 0, 0, -2.5f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 2, 1, 0, 2, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(17.5f, -4, 11).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 28, 1, 6, 0, 0, 0, -0.5f, 0, -2.5f, -0.5f, 0, -2.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0, 2, -0.5f, 0, 2, 1, 0, 0, 0)
			.setRotationPoint(17.5f, -4, -17).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 14, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17.5f, -4, -16.5f).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 49, textureX, textureY)
			.addShapeBox(-0.5f, 0, -0.5f, 1, 3, 1, 0, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, 1, 0, 1, -1, 0, 0.8f, -0.8f, 0, -0.8f, 0.8f, 0, -1)
			.setRotationPoint(49, 0, 0).setRotationAngle(0, 0.7853982f, 0).setName("Box 114")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 49, textureX, textureY)
			.addShapeBox(-0.5f, 0, -0.5f, 1, 3, 1, 0, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, 1, 0, 1, -1, 0, 0.8f, -0.8f, 0, -0.8f, 0.8f, 0, -1)
			.setRotationPoint(48.8f, 0, 1.6f).setRotationAngle(0, 0.7853982f, 0).setName("Box 115")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 505, 49, textureX, textureY)
			.addShapeBox(-0.5f, 0, -0.5f, 1, 3, 1, 0, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, 1, 0, 1, -1, 0, 0.8f, -0.8f, 0, -0.8f, 0.8f, 0, -1)
			.setRotationPoint(48.8f, 0, -1.6f).setRotationAngle(0, 0.7853982f, 0).setName("Box 116")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 57, textureX, textureY)
			.addShapeBox(-0.5f, 0, -0.5f, 1, 3, 1, 0, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, 1, 0, 1, -1, 0, 0.8f, -0.8f, 0, -0.8f, 0.8f, 0, -1)
			.setRotationPoint(48.6f, 0, 3.2f).setRotationAngle(0, 0.7853982f, 0).setName("Box 117")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 377, 57, textureX, textureY)
			.addShapeBox(-0.5f, 0, -0.5f, 1, 3, 1, 0, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, 1, 0, 1, -1, 0, 0.8f, -0.8f, 0, -0.8f, 0.8f, 0, -1)
			.setRotationPoint(48.6f, 0, -3.2f).setRotationAngle(0, 0.7853982f, 0).setName("Box 118")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 401, 57, textureX, textureY)
			.addShapeBox(-0.5f, 0, -0.5f, 1, 3, 1, 0, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, 1, 0, 1, -1, 0, 0.8f, -0.8f, 0, -0.8f, 0.8f, 0, -1)
			.setRotationPoint(48.4f, 0, 4.7f).setRotationAngle(0, 0.7853982f, 0).setName("Box 119")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 65, textureX, textureY)
			.addShapeBox(-0.5f, 0, -0.5f, 1, 3, 1, 0, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, -0.1f, 0, -0.1f, 1, 0, 1, -1, 0, 0.8f, -0.8f, 0, -0.8f, 0.8f, 0, -1)
			.setRotationPoint(48.4f, 0, -4.7f).setRotationAngle(0, 0.7853982f, 0).setName("Box 120")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 49, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 6, 0, 0, 0, 0, 0, 0, 0, -0.6f, 0, -0.4f, 0.6f, 0, -0.4f, 0.2f, -0.4f, 0, -3.2f, -0.4f, 0, -3.8f, -0.4f, -0.4f, 0.8f, -0.4f, -0.4f)
			.setRotationPoint(45, -0.4f, 0).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 6, 0, 0.6f, 0, -0.4f, -0.6f, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0.8f, -0.4f, -0.4f, -3.8f, -0.4f, -0.4f, -3.2f, -0.4f, 0, 0.2f, -0.4f, 0)
			.setRotationPoint(45, -0.4f, -6).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.2f, 0, 0, -2, 0, 0, -2, 0, -1.2f, 1.2f, 0, -1.2f)
			.setRotationPoint(25, 5, 11.5f).setRotationAngle(0, 0, 0).setName("Box 175")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(26, 1, 11.5f).setRotationAngle(0, 0, 0).setName("Box 176")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 8, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, 0)
			.setRotationPoint(28, 0, 11.5f).setRotationAngle(0, 0, 0).setName("Box 177")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 8, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0.2f, 0, -0.9f, -0.2f, 0, 0, 0)
			.setRotationPoint(28, 1, 11.5f).setRotationAngle(0, 0, 0).setName("Box 178")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 8, 0, 0, 0, 0.3f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.3f, 0, -0.9f, 0.3f, 0, 0, 0.5f, 0, 0, -0.5f, 0, -0.9f, -0.3f)
			.setRotationPoint(34, 1, 11.5f).setRotationAngle(0, 0, 0).setName("Box 179")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 481, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 8, 0, 0, 0, 0, 0, -0.1f, 0.2f, 0, -0.1f, -0.2f, 0, 0, 0, 0, -3, 0, 0, 0, 0.1f, 0, 0, -0.1f, 0, -3, 0)
			.setRotationPoint(38, 1, 11).setRotationAngle(0, 0, 0).setName("Box 180")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 8, 0, 0, 0, 0.2f, 0, 0, 0.3f, 0, 0, -0.3f, 0, 0, -0.2f, 0, -0.9f, 0.2f, 0, -0.9f, 0.3f, 0, -0.9f, -0.3f, 0, -0.9f, -0.2f)
			.setRotationPoint(32, 1, 11.5f).setRotationAngle(0, 0, 0).setName("Box 181")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(40, 5, 10.5f).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 89, textureX, textureY).addBox(0, 0, 0, 1, 2, 8)
			.setRotationPoint(41, 7, 10.5f).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.2f, 0, -1.2f, -2, 0, -1.2f, -2, 0, 0, 1.2f, 0, 0)
			.setRotationPoint(25, 5, -19.5f).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 313, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(26, 1, -19.5f).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 8, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.9f, -0.2f, 0, -0.9f, 0.2f, 0, 0, 0)
			.setRotationPoint(28, 1, -19.5f).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 17, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 8, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0)
			.setRotationPoint(28, 0, -19.5f).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 8, 0, 0, 0, -0.2f, 0, 0, -0.3f, 0, 0, 0.3f, 0, 0, 0.2f, 0, -0.9f, -0.2f, 0, -0.9f, -0.3f, 0, -0.9f, 0.3f, 0, -0.9f, 0.2f)
			.setRotationPoint(32, 1, -19.5f).setRotationAngle(0, 0, 0).setName("Box 188")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 8, 0, 0, 0, -0.3f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0.3f, 0, -0.9f, -0.3f, 0, 0, -0.5f, 0, 0, 0.5f, 0, -0.9f, 0.3f)
			.setRotationPoint(34, 1, -19.5f).setRotationAngle(0, 0, 0).setName("Box 189")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 89, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 8, 0, 0, 0, 0, 0, -0.1f, -0.2f, 0, -0.1f, 0.2f, 0, 0, 0, 0, -3, 0, 0, 0, -0.1f, 0, 0, 0.1f, 0, -3, 0)
			.setRotationPoint(38, 1, -19).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(40, 5, -18.5f).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 97, textureX, textureY).addBox(0, 0, 0, 1, 2, 8)
			.setRotationPoint(41, 7, -18.5f).setRotationAngle(0, 0, 0).setName("Box 192")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 38, 0, 0.9f, 1.2f, -1, 0, 0, -0.2f, 0, 0, -0.2f, 0.9f, 1.2f, -1, -2.8f, -0.7f, -4.1f, 0, -0.7f, -0.2f, 0, -0.7f, -0.2f, -2.8f, -0.7f, -4.1f)
			.setRotationPoint(-53, 11, -19).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 145, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1, -0.5f, 0)
			.setRotationPoint(-55, 9.8f, -7).setRotationAngle(0, 0, 0).setName("Box 233")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 473, 113, textureX, textureY)
			.addShapeBox(0, 0, 2, 4, 1, 11, 0, -0.7f, 0, -0.2f, -2.9f, 0, 0, 0, 0, 0, 0, 0, 0, -1.7f, -0.5f, -1, -1.6f, -0.5f, -1, 0, 0, 0, -1, -0.5f, 0)
			.setRotationPoint(-55, 9.8f, -20).setRotationAngle(0, 0, 0).setName("Box 234")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 121, textureX, textureY)
			.addShapeBox(0, 0, 2, 4, 1, 11, 0, 0, 0, 0, 0, 0, 0, -2.9f, 0, 0, -0.7f, 0, -0.2f, -1, -0.5f, 0, 0, 0, 0, -1.6f, -0.5f, -1, -1.7f, -0.5f, -1)
			.setRotationPoint(-55, 9.8f, 5).setRotationAngle(0, 0, 0).setName("Box 235")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0.2f, 0, -0.1f, 0.2f, 0, -0.1f, 0.2f, 0, 0.1f, 0.2f, 0)
			.setRotationPoint(-53.1f, -1, -16.5f).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 145, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 3, 0, 0, 0, 0, 3, 0, -2.5f, 0, 0, 0, -1.5f, -0.5f, 1, 0, 0, 0, 3, 0, -2.5f, 0, 0, 0, -1.5f, 0, 1)
			.setRotationPoint(12.2f, -4, 17).setRotationAngle(0, 0.7853982f, 0).setName("Box 370")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 3, 0, 0, 0, 0, 1, -0.5f, -1.5f, 0, 0, 0, -2.5f, 0, 3, 0, 0, 0, 1, 0, -1.5f, 0, 0, 0, -2.5f, 0, 3)
			.setRotationPoint(12.2f, -4, -17).setRotationAngle(0, 0.7853982f, 0).setName("Box 371")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 169, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 31, 0, 0, 0, 0, 0, 0.7f, 0, 0, 0.7f, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(9.3f, -3.9f, -15.5f).setRotationAngle(0, 0, 0).setName("Box 372")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, -3, 0.6f, 0.6f, 0, 0.3f, 1, 0, 0.7f, 0, 0, 0, 0, -3, 0.6f, 0.6f, 0, 2, 1, 0, 2, 0, 0, 0, 0)
			.setRotationPoint(9.3f, -3.9f, -16.5f).setRotationAngle(0, 0, 0).setName("Box 373")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, 0, 0.7f, 0, 0, 0.3f, 1, -3, 0.6f, 0.6f, 0, 0, 0, 0, 2, 0, 0, 2, 1, -3, 0.6f, 0.6f)
			.setRotationPoint(9.3f, -3.9f, 15.5f).setRotationAngle(0, 0, 0).setName("Box 375")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 9, 1, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-41.5f, 1, 13).setRotationAngle(0, 0, 0).setName("Box 408")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 361, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 9, 1, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-41.5f, 1, -14).setRotationAngle(0, 0, 0).setName("Box 409")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 433, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 1.2f, 0, 0, -2, 0, 0, -2, 0, 0, 1.2f, 0, 0)
			.setRotationPoint(-40, 4, 14).setRotationAngle(0, 0, 0).setName("Box 410")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 4, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0, 0, 0, 1.2f, 0, 0, -2, 0, 0, -2, 0, 0, 1.2f, 0, 0)
			.setRotationPoint(-40, 4, -18).setRotationAngle(0, 0, 0).setName("Box 411")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 329, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 4, 0, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0.4f, -0.6f, 0, 0.4f, 0, 0, 0, -1, 0, 0, -1, 0, 0.2f, 0, 0, 0.2f)
			.setRotationPoint(-40, 1, 14).setRotationAngle(0, 0, 0).setName("Box 412")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 4, 0, -0.6f, 0, 0.4f, 0, 0, 0.4f, 0, 0, 0, -0.6f, 0, 0, 0, 0, 0.2f, -1, 0, 0.2f, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-40, 1, -18).setRotationAngle(0, 0, 0).setName("Box 413")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 497, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 4, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0.4f, 0, 0, 0.4f, -1.8f, 0, 0, 0.8f, 0, 0, 0.8f, 0, 0.2f, -1.8f, 0, 0.2f)
			.setRotationPoint(-28, 1, 14).setRotationAngle(0, 0, 0).setName("Box 414")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 129, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.2f, 0, 0, 1.2f, 0, 0, 1.2f, 0, -0.7f, -1.2f, 0, -0.7f)
			.setRotationPoint(-26.2f, 5, 14).setRotationAngle(0, 0, 0).setName("Box 415")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.2f, 0, -0.7f, 1.2f, 0, -0.7f, 1.2f, 0, 0, -1.2f, 0, 0)
			.setRotationPoint(-26.2f, 5, -18).setRotationAngle(0, 0, 0).setName("Box 416")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 361, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 4, 0, 0, 0, 0.4f, -0.6f, 0, 0.4f, -0.6f, 0, 0, 0, 0, 0, -1.8f, 0, 0.2f, 0.8f, 0, 0.2f, 0.8f, 0, 0, -1.8f, 0, 0)
			.setRotationPoint(-28, 1, -18).setRotationAngle(0, 0, 0).setName("Box 417")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 5, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39.5f, 0, 13).setRotationAngle(0, 0, 0).setName("Box 418")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 217, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 5, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39.5f, 0, -18).setRotationAngle(0, 0, 0).setName("Box 419")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 10, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(32, 7, -14).setRotationAngle(0, 0, 0).setName("Box 552")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 241, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 10, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32, 7, 4).setRotationAngle(0, 0, 0).setName("Box 553")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 241, textureX, textureY).addBox(0, 0, 0, 2, 2, 32)
			.setRotationPoint(-34, 7, -16).setRotationAngle(0, 0, 0).setName("Box 554")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 289, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 3, 37, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1)
			.setRotationPoint(-53, 8, -18.5f).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 2, 1, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, -0.3f, -0.9f, 0, -0.3f, -0.9f, 0, -0.3f, 0, 0, -0.3f, 0)
			.setRotationPoint(-24.5f, 10, -19.5f).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, -0.3f, 0, 0, -0.3f, 0, 0, -0.3f, -0.9f, 0, -0.3f, -0.9f)
			.setRotationPoint(-24.5f, 10, 18.5f).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 39, 0, 0, 0, -0.2f, -0.5f, 0, -0.2f, -0.5f, 0, -0.2f, 0, 0, -0.2f, 0, -0.3f, -0.9f, -0.8f, -0.3f, -0.9f, -0.8f, -0.3f, -0.9f, 0, -0.3f, -0.9f)
			.setRotationPoint(23.5f, 10, -19.5f).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -1, 19.5f).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.2f, 0, 1.2f, -2, 0, 1.2f, -2, 0, -1.2f, 1.2f, 0, -1.2f)
			.setRotationPoint(17, 5, 19.5f).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 2, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -3, 19.5f).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 1, 0, 0, 0, 1, 0, -0.2f, 1, 0, -0.2f, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -4, 18.5f).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 1, textureX, textureY)
			.addShapeBox(0, -0.5f, -0.5f, 9, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, 4.5f, 20.2f).setRotationAngle(-0.7853982f, 0, 0).setName("Box 19")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 2, 0, 0, -0.8f, 0, 0, -1, 0, 0, -1, -1, 0, -0.8f, -1, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0)
			.setRotationPoint(17, -5, 16.5f).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(26, -1, 19.5f).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 1, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, 0)
			.setRotationPoint(28, -1, 19.5f).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0.2f, 0, -0.9f, -0.2f, 0, 0, 0)
			.setRotationPoint(28, 1, 19.5f).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0.3f, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, -0.3f, 0, -0.9f, 0.3f, 0, 0, 0.5f, 0, 0, -0.5f, 0, -0.9f, -0.3f)
			.setRotationPoint(34, 1, 19.5f).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0.2f, 0, 0, 0.3f, 0, 0, -0.3f, 0, 0, -0.2f, 0, -0.9f, 0.2f, 0, -0.9f, 0.3f, 0, -0.9f, -0.3f, 0, -0.9f, -0.2f)
			.setRotationPoint(32, 1, 19.5f).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 1, 0, 0, 0, 1, 0, -0.5f, 1.5f, 0, -0.5f, -1.5f, 0, 0, -1, 0, 0, 0, 0, 0, 0.5f, 0, 0, -0.5f, 0, 0, 0)
			.setRotationPoint(28, -3, 19.5f).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 1, 0, 0, -0.2f, 1, 0, -0.9f, 1.5f, 0, -0.9f, -1.5f, 0, -0.2f, -1, 0, 0, 0, 0, 0.5f, 0.5f, 0, 0.5f, -0.5f, 0, 0, 0)
			.setRotationPoint(28, -4, 18.5f).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 2, 0, 0, -1, 0, 0, -1.7f, 0, 0, -1.7f, -1.5f, 0, -1, -1, 0, 0.2f, 0, 0, 0.9f, 0, 0, 0.9f, -0.5f, 0, 0.2f, 0)
			.setRotationPoint(28, -5, 16.5f).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.2f, 0, -1.2f, -2, 0, -1.2f, -2, 0, 1.2f, 1.2f, 0, 1.2f)
			.setRotationPoint(17, 5, -20.5f).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -1, -20.5f).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 2, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -3, -20.5f).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 1, 0, 0, 0, -1, 0, -0.2f, -1, 0, -0.2f, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -4, -19.5f).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 1, 2, 0, 0, -0.8f, -1, 0, -1, -1, 0, -1, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0)
			.setRotationPoint(17, -5, -18.5f).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 17, textureX, textureY)
			.addShapeBox(0, -0.5f, -0.5f, 9, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.2f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, 4.5f, -20.2f).setRotationAngle(-0.7853982f, 0, 0).setName("Box 34")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0)
			.setRotationPoint(26, -1, -20.5f).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 1, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0)
			.setRotationPoint(28, -1, -20.5f).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 1, 0, 0, 0, -1, 0, -0.5f, -1.5f, 0, -0.5f, 1.5f, 0, 0, 1, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0)
			.setRotationPoint(28, -3, -20.5f).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 1, 0, 0, -0.2f, -1, 0, -0.9f, -1.5f, 0, -0.9f, 1.5f, 0, -0.2f, 1, 0, 0, 0, 0, 0.5f, -0.5f, 0, 0.5f, 0.5f, 0, 0, 0)
			.setRotationPoint(28, -4, -19.5f).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 2, 0, 0, -1, -1, 0, -1.7f, -1.5f, 0, -1.7f, 0, 0, -1, 0, 0, 0.2f, 0, 0, 0.9f, -0.5f, 0, 0.9f, 0, 0, 0.2f, 0)
			.setRotationPoint(28, -5, -18.5f).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.9f, -0.2f, 0, -0.9f, 0.2f, 0, 0, 0)
			.setRotationPoint(28, 1, -20.5f).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 1, 0, 0, 0, -0.3f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0.3f, 0, -0.9f, -0.3f, 0, 0, -0.5f, 0, 0, 0.5f, 0, -0.9f, 0.3f)
			.setRotationPoint(34, 1, -20.5f).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, -0.2f, 0, 0, -0.3f, 0, 0, 0.3f, 0, 0, 0.2f, 0, -0.9f, -0.2f, 0, -0.9f, -0.3f, 0, -0.9f, 0.3f, 0, -0.9f, 0.2f)
			.setRotationPoint(32, 1, -20.5f).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, 0, 0, 0, 0, -0.1f, 0.2f, 0, -0.1f, -0.2f, 0, 0, 0, 0, -3, 0, 0, 0, 0.1f, 0, 0, -0.1f, 0, -3, 0)
			.setRotationPoint(38, -1, 19).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 1, 0, 0, -0.1f, 0.2f, -0.4f, -0.2f, 0.5f, -0.4f, -0.2f, -0.5f, 0, -0.1f, -0.2f, 0, 0, 0.1f, -0.4f, 0, 0.5f, -0.4f, 0, -0.5f, 0, 0, -0.1f)
			.setRotationPoint(40, -1, 19).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 1, 0, 0, -0.2f, 0, 0, -0.3f, 0.2f, 0, -0.3f, -0.2f, 0, -0.2f, 0, 0, 0, 0, -1.4f, 0, 0.1f, -1.4f, 0, -0.1f, 0, 0, 0)
			.setRotationPoint(42.6f, -1, 18.5f).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 1, 0, 0, -0.5f, 1, -0.4f, -1.3f, 1.5f, -0.4f, -1.3f, -1.5f, 0, -0.5f, -1, 0, 0, 0, -0.4f, 0.3f, 0.7f, -0.4f, 0.3f, -0.7f, 0, 0, 0)
			.setRotationPoint(38, -3, 19).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, -0.4f, 1, -0.4f, -1.3f, 1.1f, -0.4f, -1.4f, -1.6f, 0, -0.4f, -1, 0, 0, 0, -0.4f, 0.8f, 0.5f, -0.4f, 0.8f, -0.5f, 0, 0, 0)
			.setRotationPoint(38, -3.5f, 18).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 2, 0, 0, -1.2f, 0, -0.4f, -2.2f, 0, -0.4f, -2.2f, -1.9f, 0, -1.2f, -1.5f, 0, 0.4f, 0, -0.4f, 1.3f, 0, -0.4f, 1.4f, -1.1f, 0, 0.4f, -0.5f)
			.setRotationPoint(38, -4.5f, 16.5f).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 1, 0, 0, 0, 0, 0, -0.1f, -0.2f, 0, -0.1f, 0.2f, 0, 0, 0, 0, -3, 0, 0, 0, -0.1f, 0, 0, 0.1f, 0, -3, 0)
			.setRotationPoint(38, -1, -20).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 1, 0, 0, -0.5f, -1, -0.4f, -1.3f, -1.5f, -0.4f, -1.3f, 1.5f, 0, -0.5f, 1, 0, 0, 0, -0.4f, 0.3f, -0.7f, -0.4f, 0.3f, 0.7f, 0, 0, 0)
			.setRotationPoint(38, -3, -20).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, -0.4f, -1, -0.4f, -1.4f, -1.6f, -0.4f, -1.3f, 1.1f, 0, -0.4f, 1, 0, 0, 0, -0.4f, 0.8f, -0.5f, -0.4f, 0.8f, 0.5f, 0, 0, 0)
			.setRotationPoint(38, -3.5f, -19).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 2, 0, 0, -1.2f, -1.5f, -0.4f, -2.2f, -1.9f, -0.4f, -2.2f, 0, 0, -1.2f, 0, 0, 0.4f, -0.5f, -0.4f, 1.4f, -1.1f, -0.4f, 1.3f, 0, 0, 0.4f, 0)
			.setRotationPoint(38, -4.5f, -18.5f).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 1, 0, 0, -0.2f, 0, 0, -0.3f, -0.2f, 0, -0.3f, 0.2f, 0, -0.2f, 0, 0, 0, 0, -1.4f, 0, -0.1f, -1.4f, 0, 0.1f, 0, 0, 0)
			.setRotationPoint(42.6f, -1, -19.5f).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 1, 0, 0, -0.1f, -0.2f, -0.4f, -0.2f, -0.5f, -0.4f, -0.2f, 0.5f, 0, -0.1f, 0.2f, 0, 0, -0.1f, -0.4f, 0, -0.5f, -0.4f, 0, 0.5f, 0, 0, 0.1f)
			.setRotationPoint(40, -1, -20).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 10, 0, 0.9f, 0, 0, -0.9f, 0, 0, -2.7f, 0, -0.4f, 2.7f, 0, -0.4f, 1.1f, 0, 0, -1.1f, 0, 0, -2.9f, 0, -0.4f, 2.9f, 0, -0.4f)
			.setRotationPoint(44.8f, -1, 7).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 2, 0, 0.1f, 0, 0, -0.1f, 0, 0, -0.7f, 0, -0.3f, 0.7f, 0, -0.3f, 0.3f, 0, 0, -0.3f, 0, 0, -1, 0, -0.3f, 1, 0, -0.3f)
			.setRotationPoint(42.2f, -1, 16.6f).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0.4f, 0, 0, 0.5f, 0, 0, -0.6f, -0.2f, -0.3f, 0.4f, -0.3f, 0, 0.6f, 0, 0, 0.2f, 0, 0, -0.8f, 0, -0.2f, 0.6f, 0, 0)
			.setRotationPoint(45, -1, 18.3f).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 17, textureX, textureY)
			.addShapeBox(2, 0, 0, 1, 1, 1, 0, -0.5f, -0.5f, -0.1f, 0, -0.6f, 0, -0.5f, -0.8f, -0.5f, 0.4f, -0.8f, -0.4f, -0.8f, 0, 0, 0.5f, 0, 0, -0.6f, 0.2f, -0.3f, 0.4f, 0.3f, 0)
			.setRotationPoint(43, -2, 18.3f).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 17, textureX, textureY)
			.addShapeBox(2, 0, 0, 1, 1, 1, 0, 0, 0.3f, 0, 0.9f, -0.3f, 0, 0.9f, -0.3f, -0.9f, 0, 0.3f, -0.9f, 0, -1, 0, 0, -0.7f, 0, 0.5f, -0.6f, -0.2f, 0, -1.1f, -0.1f)
			.setRotationPoint(42.6f, -2, 16.5f).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 25, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 2, 0, -0.3f, -0.3f, 0, -0.3f, -0.6f, 0, -1.2f, -0.6f, -0.3f, 0.7f, -0.5f, -0.2f, 0, 0, 0, -0.1f, 0, 0, -0.7f, 0, -0.3f, 0.7f, 0, -0.3f)
			.setRotationPoint(46.2f, -1, 16.6f).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 25, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, -0.3f, -0.3f, -0.9f, -0.3f, -0.6f, -0.9f, -0.3f, -0.6f, 0, -0.3f, -0.3f, 0, 0, 0, -0.9f, -0.05f, 0, -0.9f, -0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(46.2f, -1, 15.6f).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 25, textureX, textureY)
			.addShapeBox(2, 0, 0, 1, 1, 1, 0, 0, 0.1f, 0.1f, 0.5f, -0.4f, 0.2f, -0.1f, -0.5f, -0.1f, 0, -0.3f, 0, 0, -0.8f, 0, 0.5f, -0.4f, 0.2f, -0.1f, -0.3f, -0.1f, 0, -0.5f, 0)
			.setRotationPoint(42.6f, -2, 17.5f).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 25, textureX, textureY)
			.addShapeBox(2, 0, 0, 1, 1, 1, 0, 0, -0.3f, 0, -0.1f, -0.5f, 0.1f, -0.1f, -0.5f, -1.09f, 0, -0.8f, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -0.6f)
			.setRotationPoint(42.6f, -2, 18.5f).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 10, 0, 2.7f, 0, -0.4f, -2.7f, 0, -0.4f, -0.9f, 0, 0, 0.9f, 0, 0, 2.9f, 0, -0.4f, -2.9f, 0, -0.4f, -1.1f, 0, 0, 1.1f, 0, 0)
			.setRotationPoint(44.8f, -1, -17).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 2, 0, 0.7f, 0, -0.3f, -0.7f, 0, -0.3f, -0.1f, 0, 0, 0.1f, 0, 0, 1, 0, -0.3f, -1, 0, -0.3f, -0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(42.2f, -1, -18.6f).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0.4f, -0.3f, 0, -0.6f, -0.2f, -0.3f, 0.5f, 0, 0, 0.4f, 0, 0, 0.6f, 0, 0, -0.8f, 0, -0.2f, 0.2f, 0, 0, 0.6f, 0, 0)
			.setRotationPoint(45, -1, -19.3f).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 33, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 1, 0, -0.3f, -0.3f, 0, -0.3f, -0.6f, 0, -0.3f, -0.6f, -0.9f, -0.3f, -0.3f, -0.9f, 0, 0, 0, -0.1f, 0, 0, -0.05f, 0, -0.9f, 0, 0, -0.9f)
			.setRotationPoint(46.2f, -1, -16.6f).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 33, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 2, 0, 0.7f, -0.5f, -0.2f, -1.2f, -0.6f, -0.3f, -0.3f, -0.6f, 0, -0.3f, -0.3f, 0, 0.7f, 0, -0.3f, -0.7f, 0, -0.3f, -0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(46.2f, -1, -18.6f).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 33, textureX, textureY)
			.addShapeBox(2, 0, 0, 1, 1, 1, 0, 0.4f, -0.8f, -0.4f, -0.5f, -0.8f, -0.5f, 0, -0.6f, 0, -0.5f, -0.5f, -0.1f, 0.4f, 0.3f, 0, -0.6f, 0.2f, -0.3f, 0.5f, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(43, -2, -19.3f).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 33, textureX, textureY)
			.addShapeBox(2, 0, 0, 1, 1, 1, 0, 0, 0.3f, -0.9f, 0.9f, -0.3f, -0.9f, 0.9f, -0.3f, 0, 0, 0.3f, 0, 0, -1.1f, -0.1f, 0.5f, -0.6f, -0.2f, 0, -0.7f, 0, 0, -1, 0)
			.setRotationPoint(42.6f, -2, -17.5f).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 33, textureX, textureY)
			.addShapeBox(2, 0, 0, 1, 1, 1, 0, 0, -0.3f, 0, -0.1f, -0.5f, -0.1f, 0.5f, -0.4f, 0.2f, 0, 0.1f, 0.1f, 0, -0.5f, 0, -0.1f, -0.3f, -0.1f, 0.5f, -0.4f, 0.2f, 0, -0.8f, 0)
			.setRotationPoint(42.6f, -2, -18.5f).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 33, textureX, textureY)
			.addShapeBox(2, 0, 0, 1, 1, 1, 0, 0, -0.8f, -0.6f, -0.1f, -0.5f, -1.09f, -0.1f, -0.5f, 0.1f, 0, -0.3f, 0, 0, 0, -0.6f, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42.6f, -2, -19.5f).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, -0.2f, 0, 0, -0.2f, -0.1f, 0, 0, 0.1f, 0, 0, 0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(44, -1, 6).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0.1f, 0, 0, -0.1f, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0.3f, 0, 0, -0.3f, 0, 0, -0.2f, 0, -0.2f, 0.2f, 0, -0.2f)
			.setRotationPoint(44, -1, -7).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.3f, 0, 0, 0.3f, 0, 0, 1.2f, 0, -0.2f, -1.2f, 0, -0.2f, -1.4f, 0, 0, 1.4f, 0, 0)
			.setRotationPoint(48, 0, 6).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0.3f, 0, 0, -0.3f, 0, 0, -0.2f, 0, -0.2f, 0.2f, 0, -0.2f, 1.4f, 0, 0, -1.4f, 0, 0, -1.4f, 0, -0.2f, 1.4f, 0, -0.2f)
			.setRotationPoint(48, 0, -7).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 10, 0, 0, 0, 0, 0, 0, 0, -1.5f, 0, -0.4f, 1.5f, 0, -0.4f, 0, 0, 0, 0, 0, 0, -1.5f, 0, -0.4f, 1.5f, 0, -0.4f)
			.setRotationPoint(42.6f, 3, 7).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 2, 0, -0.1f, 0, 0, 0.1f, 0, 0, -0.5f, 0, -0.3f, 0.5f, 0, -0.3f, -0.1f, 0, 0, 0.1f, 0, 0, -0.5f, 0, -0.3f, 0.5f, 0, -0.3f)
			.setRotationPoint(41, 3, 16.6f).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 105, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, -0.1f, 0, 0, 0, -1, 0, 0, 0, 0, 0.1f, 0.3f, 0, -0.1f, 0, 0, 0, -1, 0, 0, 0.3f, 0, 0.1f)
			.setRotationPoint(43.5f, 3, 18.3f).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 10, 0, 1.5f, 0, -0.4f, -1.5f, 0, -0.4f, 0, 0, 0, 0, 0, 0, 1.5f, 0, -0.4f, -1.5f, 0, -0.4f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42.6f, 3, -17).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 169, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 2, 0, 0.5f, 0, -0.3f, -0.5f, 0, -0.3f, 0.1f, 0, 0, -0.1f, 0, 0, 0.5f, 0, -0.3f, -0.5f, 0, -0.3f, 0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(41, 3, -18.6f).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0.1f, -1, 0, 0, 0, 0, 0, 0, 0, -0.1f, 0.3f, 0, 0.1f, -1, 0, 0, 0, 0, 0, 0.3f, 0, -0.1f)
			.setRotationPoint(43.5f, 3, -19.3f).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, -0.5f, 0, -0.4f, 0.5f, 0, -0.4f, -0.1f, 0, 0, 0.1f, 0, 0, -0.3f, 0, -0.4f, 0.2f, 0, -0.4f, -0.3f, 0, 0, 0.3f, 0, 0)
			.setRotationPoint(44.1f, -1, 5.2f).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, -0.3f, 0, -0.4f, 0.2f, 0, -0.4f, -0.3f, 0, 0, 0.3f, 0, 0, 0.7f, 0, -0.4f, -0.7f, 0, -0.4f, -1.3f, 0, 0, 1.3f, 0, 0)
			.setRotationPoint(48.1f, 0, 5.2f).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 6, 0, 0, 0, 0, 0, 0, 0, -0.6f, 0, -0.4f, 0.6f, 0, -0.4f, 0.2f, -0.4f, 0, -0.2f, -0.4f, 0, -0.8f, -0.4f, -0.4f, 0.8f, -0.4f, -0.4f)
			.setRotationPoint(45.2f, -1, 0).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 377, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 6, 0, 0.6f, 0, -0.4f, -0.6f, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0.8f, -0.4f, -0.4f, -0.8f, -0.4f, -0.4f, -0.2f, -0.4f, 0, 0.2f, -0.4f, 0)
			.setRotationPoint(45.2f, -1, -6).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0.1f, 0, 0, -0.1f, 0, 0, 0.5f, 0, -0.4f, -0.5f, 0, -0.4f, 0.3f, 0, 0, -0.3f, 0, 0, 0.2f, 0, -0.4f, -0.3f, 0, -0.4f)
			.setRotationPoint(44.1f, -1, -6.2f).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0.3f, 0, 0, -0.3f, 0, 0, 0.2f, 0, -0.4f, -0.3f, 0, -0.4f, 1.3f, 0, 0, -1.3f, 0, 0, -0.7f, 0, -0.4f, 0.7f, 0, -0.4f)
			.setRotationPoint(48.1f, 0, -6.2f).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, -0.2f, 0, -0.2f, 0.2f, 0, -0.2f, 0, 0, 0, 0, 0, 0, -0.2f, 0, -0.2f, 0.2f, 0, -0.2f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42.6f, 3, 6).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, -0.6f, 0, -0.4f, 0.6f, 0, -0.4f, 0, 0, 0, 0, 0, 0, -0.6f, 0, -0.4f, 0.6f, 0, -0.4f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42.8f, 3, 5.2f).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, -0.2f, -0.2f, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(42.6f, 3, -7).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0.6f, 0, -0.4f, -0.6f, 0, -0.4f, 0, 0, 0, 0, 0, 0, 0.6f, 0, -0.4f, -0.6f, 0, -0.4f)
			.setRotationPoint(42.8f, 3, -6.2f).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 6, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0, 0, -0.4f, 0, 0, -0.4f, -0.5f, 0, 0, 0.5f, 0, 0, 0, 0, -0.4f, 0, 0, -0.4f)
			.setRotationPoint(43.4f, 3, 0).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 6, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0.5f, 0, 0, -0.5f, 0, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0.5f, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(43.4f, 3, -6).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(46.7f, 4, -7).setRotationAngle(0, 0, 0).setName("Box 142")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 11, 0, 0, 0, 0, 0, 0, 0, -1.8f, 0, 0, 1.8f, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0, -1.8f, -0.6f, 0, 1.8f, -0.6f, 0)
			.setRotationPoint(46.7f, 4, 7).setRotationAngle(0, 0, 0).setName("Box 143")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 11, 0, 1.8f, 0, 0, -1.8f, 0, 0, 0, 0, 0, 0, 0, 0, 1.8f, -0.6f, 0, -1.8f, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(46.7f, 4, -18).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, -0.1f, 0, 0, -0.5f, 0, -0.2f, 0, 0, 0, 0, -0.6f, 0, -0.1f, -0.6f, 0, -0.5f, -0.6f, -0.2f, 0, -0.6f, 0)
			.setRotationPoint(41, 4, 18).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 4, 1, 0, 0, 0, 0, 0.5f, 0, 0.2f, -0.4f, 0, -0.6f, 0, 0, 0, 0, -0.6f, 0, 0.5f, -0.6f, 0.2f, -0.4f, -0.6f, -0.6f, 0, -0.6f, 0)
			.setRotationPoint(41, 4, 19).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(40, 4, 18).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.7f, 0, 0, 0, 0, 0, 0, 0, 0, -0.7f, 0, 0)
			.setRotationPoint(40, 5.4f, 18).setRotationAngle(0, 0, 0).setName("Box 148")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 4, 1, 0, 0, 0, 0, -0.5f, 0, -0.2f, -0.1f, 0, 0, 0, 0, 0, 0, -0.6f, 0, -0.5f, -0.6f, -0.2f, -0.1f, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(41, 4, -19).setRotationAngle(0, 0, 0).setName("Box 149")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 4, 1, 0, 0, 0, 0, -0.4f, 0, -0.6f, 0.5f, 0, 0.2f, 0, 0, 0, 0, -0.6f, 0, -0.4f, -0.6f, -0.6f, 0.5f, -0.6f, 0.2f, 0, -0.6f, 0)
			.setRotationPoint(41, 4, -20).setRotationAngle(0, 0, 0).setName("Box 150")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0.5f, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(40, 4, -20).setRotationAngle(0, 0, 0).setName("Box 151")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.7f, 0, 0, 0, 0, 0, 0, 0, 0, -0.7f, 0, 0)
			.setRotationPoint(40, 5.4f, -20).setRotationAngle(0, 0, 0).setName("Box 152")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 14, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46.7f, 3, -7).setRotationAngle(0, 0, 0).setName("Box 153")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 11, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -2.2f, -0.5f, 0, 1.8f, -0.5f, 0, 0, 0, 0, 0, 0, 0, -1.8f, 0, 0, 1.8f, 0, 0)
			.setRotationPoint(46.7f, 3, 7).setRotationAngle(0, 0, 0).setName("Box 154")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -1, -0.5f, -0.2f, 0, -0.5f, 0, 0, 0, 0, -0.1f, 0, 0, -0.5f, 0, -0.2f, 0, 0, 0)
			.setRotationPoint(41, 3, 18).setRotationAngle(0, 0, 0).setName("Box 155")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, -0.5f, 0, 0, -0.5f, 0.2f, -0.9f, -0.5f, -0.8f, 0, -0.5f, -0.2f, 0, 0, 0, 0.5f, 0, 0.2f, -0.4f, 0, -0.6f, 0, 0, 0)
			.setRotationPoint(41, 3, 19).setRotationAngle(0, 0, 0).setName("Box 156")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, -0.2f, -0.5f, -0.5f, -0.1f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(39, 3, 18).setRotationAngle(0, 0, 0).setName("Box 157")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 11, 0, 1.8f, -0.5f, 0, -2.2f, -0.5f, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0, 1.8f, 0, 0, -1.8f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46.7f, 3, -18).setRotationAngle(0, 0, 0).setName("Box 158")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, 0, -0.5f, 0, -1, -0.5f, -0.2f, -0.5f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, -0.5f, 0, -0.2f, -0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(41, 3, -19).setRotationAngle(0, 0, 0).setName("Box 159")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, -0.5f, -0.2f, -0.9f, -0.5f, -0.8f, 0, -0.5f, 0.2f, 0, -0.5f, 0, 0, 0, 0, -0.4f, 0, -0.6f, 0.5f, 0, 0.2f, 0, 0, 0)
			.setRotationPoint(41, 3, -20).setRotationAngle(0, 0, 0).setName("Box 160")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -0.5f, -0.5f, -0.1f, 0, -0.5f, -0.2f, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(39, 3, -20).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.9f, 0, 0, -1.9f, 0, 0, -1.9f, 0, 0, 1.9f, 0, 0)
			.setRotationPoint(46.7f, 7.4f, -7).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 11, 0, 0, 0, 0, 0, 0, 0, -1.8f, 0, 0, 0, 0, 0, 1.9f, 0, 0, -1.9f, 0, 0, -4.2f, 0, -0.4f, 2.7f, 0, -0.4f)
			.setRotationPoint(46.7f, 7.4f, 7).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 11, 0, 0, 0, 0, -1.8f, 0, 0, 0, 0, 0, 0, 0, 0, 2.7f, 0, -0.4f, -4.2f, 0, -0.4f, -1.9f, 0, 0, 1.9f, 0, 0)
			.setRotationPoint(46.7f, 7.4f, -18).setRotationAngle(0, 0, 0).setName("Box 165")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 3, 1, 0, 0.3f, 0, 0, -0.1f, 0, 0, -0.5f, 0, -0.2f, 0.3f, 0, 0, 0.3f, 0, 0.5f, -2.5f, 0, 0.4f, -2.6f, 0, -1.3f, 0.3f, 0, -0.5f)
			.setRotationPoint(41, 7.4f, 18).setRotationAngle(0, 0, 0).setName("Box 166")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0.3f, 0, 0, 0.5f, 0, 0.2f, -0.4f, 0, -0.6f, 0.3f, 0, 0, 0.3f, 0, 0.5f, -1.6f, 0, 1.3f, -1.9f, 0, -2.1f, 0.3f, 0, -1.2f)
			.setRotationPoint(41, 7.4f, 19).setRotationAngle(0, 0, 0).setName("Box 167")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 81, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 3, 1, 0, 0.3f, 0, 0, -0.5f, 0, -0.2f, -0.1f, 0, 0, 0.3f, 0, 0, 0.3f, 0, -0.5f, -2.6f, 0, -1.3f, -2.5f, 0, 0.4f, 0.3f, 0, 0.5f)
			.setRotationPoint(41, 7.4f, -19).setRotationAngle(0, 0, 0).setName("Box 168")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 105, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0.3f, 0, 0, -0.4f, 0, -0.6f, 0.5f, 0, 0.2f, 0.3f, 0, 0, 0.3f, 0, -1.2f, -1.9f, 0, -2.1f, -1.6f, 0, 1.3f, 0.3f, 0, 0.5f)
			.setRotationPoint(41, 7.4f, -20).setRotationAngle(0, 0, 0).setName("Box 169")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 113, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2.6f, 0, 0, -2.6f, 0, 0, -2.6f, 0, 0, 2.6f, 0, 0)
			.setRotationPoint(47.8f, 10.4f, -7).setRotationAngle(0, 0, 0).setName("Box 170")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 89, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 11, 0, 0, 0, 0, 0, 0, 0, -2.3f, 0, -0.4f, 2.3f, 0, -0.4f, 2.6f, 0, 0, -2.6f, 0, 0, -4.3f, 0, -1.4f, 4.3f, 0, -1.4f)
			.setRotationPoint(47.8f, 10.4f, 7).setRotationAngle(0, 0, 0).setName("Box 171")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 11, 0, 2.3f, 0, -0.4f, -2.3f, 0, -0.4f, 0, 0, 0, 0, 0, 0, 4.3f, 0, -1.4f, -4.3f, 0, -1.4f, -2.6f, 0, 0, 2.6f, 0, 0)
			.setRotationPoint(47.8f, 10.4f, -18).setRotationAngle(0, 0, 0).setName("Box 172")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 1, 0, 0.3f, 0, 0, 1.5f, 0, -0.1f, 1.1f, 0, -0.6f, 0.3f, 0, 0.3f, 0.3f, 0, 0.8f, -0.5f, 0, 0.9f, -0.7f, 0, -1.8f, 0.3f, 0, -0.8f)
			.setRotationPoint(41, 10.4f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 173")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 1, 0, 0.3f, 0, 0.3f, 1.1f, 0, -0.6f, 1.5f, 0, -0.1f, 0.3f, 0, 0, 0.3f, 0, -0.8f, -0.7f, 0, -1.8f, -0.5f, 0, 0.9f, 0.3f, 0, 0.8f)
			.setRotationPoint(41, 10.4f, -18.5f).setRotationAngle(0, 0, 0).setName("Box 174")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 73, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0, 0, 0.6f, -0.3f, 0.2f, 0.7f, -0.3f, -1.1f, 0, 0, -0.9f, 0, -0.3f, 0, 0, -0.2f, 0.1f, 0.2f, 0.1f, -0.3f, 0, -0.1f, -0.2f)
			.setRotationPoint(32.8f, -1.6f, 20.2f).setRotationAngle(0, 0, 0).setName("Box 193")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 73, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0.3f, 0, 0.1f, -0.5f, 0.1f, 0.1f, -0.5f, -1, 0, 0.3f, -0.9f, 0.7f, -0.8f, -0.1f, -0.3f, 0.2f, 0, -0.3f, 0.2f, -0.3f, 0.5f, -0.5f, -0.1f)
			.setRotationPoint(35.5f, -1, 20).setRotationAngle(0, 0, 0).setName("Box 194")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 73, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.4f, 0.3f, 0.1f, -0.5f, -1.8f, 0.2f, -0.5f, -1.8f, -1.1f, 0.4f, 0.5f, -1, 0.8f, -0.8f, 0, -0.5f, 1, 0.1f, -0.5f, 1, -1, 0.8f, -0.8f, -0.3f)
			.setRotationPoint(38, 0, 20).setRotationAngle(0, 0, 0).setName("Box 195")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 73, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.6f, -0.3f, 0.2f, 0, 0, 0, 0, 0, -0.9f, 0.7f, -0.3f, -1.1f, 0, -0.2f, 0.1f, 0, -0.3f, 0, 0, -0.1f, -0.2f, 0.2f, 0.1f, -0.3f)
			.setRotationPoint(30.8f, -1.6f, 20.2f).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 73, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.1f, -0.5f, 0.1f, 0, 0.3f, 0, 0, 0.3f, -0.9f, 0.1f, -0.5f, -1, -0.2f, 0.1f, 0, 0.7f, -0.8f, -0.1f, 0.5f, -0.5f, -0.1f, -0.2f, 0.1f, -0.2f)
			.setRotationPoint(28.1f, -1, 20).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 73, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, -1.7f, -0.3f, 0, 0.5f, 0.1f, 0, 0.5f, -1, 0, -1.7f, -0.6f, 0, 1.2f, 0.2f, 0.3f, -0.9f, 0, 0.3f, -0.9f, -0.2f, 0, 1.2f, -0.6f)
			.setRotationPoint(26, 0, 20).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 81, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0, -0.9f, 0.7f, -0.3f, -1.1f, 0.6f, -0.3f, 0.2f, 0, 0, 0, 0, -0.1f, -0.2f, 0.2f, 0.1f, -0.3f, 0, -0.2f, 0.1f, 0, -0.3f, 0)
			.setRotationPoint(32.8f, -1.6f, -21.2f).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 81, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0.3f, -0.9f, 0.1f, -0.5f, -1, 0.1f, -0.5f, 0.1f, 0, 0.3f, 0, 0.5f, -0.5f, -0.1f, -0.3f, 0.2f, -0.3f, -0.3f, 0.2f, 0, 0.7f, -0.8f, -0.1f)
			.setRotationPoint(35.5f, -1, -21).setRotationAngle(0, 0, 0).setName("Box 199")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 81, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.4f, 0.5f, -1, -0.5f, -1.8f, -1.1f, -0.5f, -1.8f, 0.2f, 0.4f, 0.3f, 0.1f, 0.8f, -0.8f, -0.3f, -0.5f, 1, -1, -0.5f, 1, 0.1f, 0.8f, -0.8f, 0)
			.setRotationPoint(38, 0, -21).setRotationAngle(0, 0, 0).setName("Box 200")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 81, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.7f, -0.3f, -1.1f, 0, 0, -0.9f, 0, 0, 0, 0.6f, -0.3f, 0.2f, 0.2f, 0.1f, -0.3f, 0, -0.1f, -0.2f, 0, -0.3f, 0, 0, -0.2f, 0.1f)
			.setRotationPoint(30.8f, -1.6f, -21.2f).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 81, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, -1.7f, -0.6f, 0, 0.5f, -1, 0, 0.5f, 0.1f, 0, -1.7f, -0.3f, 0, 1.2f, -0.6f, 0.3f, -0.9f, -0.2f, 0.3f, -0.9f, 0, 0, 1.2f, 0.2f)
			.setRotationPoint(26, 0, -21).setRotationAngle(0, 0, 0).setName("Box 202")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 169, 81, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.1f, -0.5f, -1, 0, 0.3f, -0.9f, 0, 0.3f, 0, 0.1f, -0.5f, 0.1f, -0.2f, 0.1f, -0.2f, 0.5f, -0.5f, -0.1f, 0.7f, -0.8f, -0.1f, -0.2f, 0.1f, 0)
			.setRotationPoint(28.1f, -1, -21).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 2, 0, 0.2f, 0, 0.5f, -0.5f, 0, 0.4f, -0.5f, 0, -0.4f, 0.2f, 0, -0.5f, -1, 0, 1.2f, 1, 0, 1.2f, 1, 0, -1.2f, -1, 0, -1.2f)
			.setRotationPoint(-26, 5, 18.5f).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 39, 0, -0.5f, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, -0.5f, 0, -0.2f, -0.8f, -0.3f, -0.9f, 0, -0.3f, -0.9f, 0, -0.3f, -0.9f, -0.8f, -0.3f, -0.9f)
			.setRotationPoint(-25.5f, 10, -19.5f).setRotationAngle(0, 0, 0).setName("Box 209")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(-56.9f, 4, -7).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 433, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.8f, 0, -0.2f, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, -0.2f, -0.8f, -0.6f, -0.2f)
			.setRotationPoint(-56.9f, 4, 7).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 11, 0, -0.8f, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, -0.8f, -0.6f, -0.2f, 0, -0.6f, -0.2f, 0, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(-56.9f, 4, -18).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.9f, -0.6f, 0, 1.9f, -0.6f, 0, 1.9f, -0.6f, 0, -1.9f, -0.6f, 0)
			.setRotationPoint(-56.9f, 7.4f, -7).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 11, 0, -0.8f, 0, -0.2f, 0.8f, 0, -0.2f, 0, 0, 0, 0, 0, 0, -2.6f, -0.6f, -0.2f, 2.6f, -0.6f, -0.2f, 1.9f, -0.6f, 0, -1.9f, -0.6f, 0)
			.setRotationPoint(-56.9f, 7.4f, -18).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 11, 0, 0, 0, 0, 0, 0, 0, 0.8f, 0, -0.2f, -0.8f, 0, -0.2f, -1.9f, -0.6f, 0, 1.9f, -0.6f, 0, 2.6f, -0.6f, -0.2f, -2.6f, -0.6f, -0.2f)
			.setRotationPoint(-56.9f, 7.4f, 7).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, -0.6f, 0, -0.6f, 0, 0, -0.1f, 0, 0, 0, 0.2f, 0, 0, -0.6f, -0.6f, -0.6f, 0, -0.6f, -0.1f, 0, -0.6f, 0, 0.2f, -0.6f, 0)
			.setRotationPoint(-55.9f, 4, -19.8f).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.1f, -0.6f, 0, -0.6f, 0.2f, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, -0.1f, -0.6f, -0.6f, -0.6f)
			.setRotationPoint(-55.9f, 4, 17.8f).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, -0.6f, 0, -0.6f, 0, 0, -0.1f, 0, 0, 0, 0.2f, 0, 0, -1.7f, -0.6f, -1.8f, 0, -0.6f, -1.8f, 0, -0.6f, 0, -1.6f, -0.6f, 0)
			.setRotationPoint(-55.9f, 7.4f, -19.8f).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 2, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.1f, -0.6f, 0, -0.6f, -1.6f, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, -1.8f, -1.7f, -0.6f, -1.8f)
			.setRotationPoint(-55.9f, 7.4f, 17.8f).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 14, 0, -0.7f, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0, -0.7f, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56.9f, 3, -7).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 11, 0, -1.5f, -0.6f, -0.2f, 0, -0.6f, -0.2f, 0, -0.6f, 0, -0.7f, -0.6f, 0, -0.8f, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-56.9f, 3, -18).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 329, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 11, 0, -0.7f, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, -0.2f, -1.5f, -0.6f, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, -0.8f, 0, -0.2f)
			.setRotationPoint(-56.9f, 3, 7).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -1.2f, -0.6f, -0.9f, 0, -0.6f, -0.5f, 0, -0.6f, 0, -0.5f, -0.6f, 0, -0.6f, 0, -0.6f, 0, 0, -0.1f, 0, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(-55.9f, 3, -19.8f).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -0.5f, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, -0.5f, -1.2f, -0.6f, -0.9f, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.1f, -0.6f, 0, -0.6f)
			.setRotationPoint(-55.9f, 3, 17.8f).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 4, 2, 0, 0, 0, 0, 0, 0, 0.4f, 0, 0, -0.4f, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0.4f, 0, -0.6f, -0.4f, 0, -0.6f, 0)
			.setRotationPoint(-53.9f, 4, -19.7f).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 2, 0, 0, -0.6f, -0.4f, 0, -0.6f, 0.2f, 0, -0.6f, -0.4f, 0, -0.6f, 0, 0, 0, 0, 0, 0, 0.4f, 0, 0, -0.4f, 0, 0, 0)
			.setRotationPoint(-53.9f, 3, -19.7f).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 4, 2, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, 0.4f, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f, -0.4f, 0, -0.6f, 0.4f, 0, -0.6f, 0)
			.setRotationPoint(-53.9f, 4, 17.7f).setRotationAngle(0, 0, 0).setName("Box 228")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 1, 2, 0, 0, -0.6f, 0, 0, -0.6f, -0.4f, 0, -0.6f, 0.2f, 0, -0.6f, -0.4f, 0, 0, 0, 0, 0, -0.4f, 0, 0, 0.4f, 0, 0, 0)
			.setRotationPoint(-53.9f, 3, 17.7f).setRotationAngle(0, 0, 0).setName("Box 229")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 3, 2, 0, 0, 0, 0, 0, 0, 0.4f, 0, 0, -0.4f, 0, 0, 0, 0, -0.6f, -1.7f, 0, 0.6f, -0.9f, 0, 0.6f, 0.9f, 0, -0.6f, 0)
			.setRotationPoint(-53.9f, 7.4f, -19.7f).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 13, 3, 2, 0, 0, 0, 0, 0, 0, -0.4f, 0, 0, 0.4f, 0, 0, 0, 0, -0.6f, 0, 0, 0.6f, 0.9f, 0, 0.6f, -0.9f, 0, -0.6f, -1.7f)
			.setRotationPoint(-53.9f, 7.4f, 17.7f).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 329, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, -0.6f, 0, -1.5f, -0.6f, 0, -1.5f, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(-40.9f, 4, 18.1f).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 2, 0, 0.2f, 0, -0.5f, -0.5f, 0, -0.4f, -0.5f, 0, 0.4f, 0.2f, 0, 0.5f, -1, 0, -1.2f, 1, 0, -1.2f, 1, 0, 1.2f, -1, 0, 1.2f)
			.setRotationPoint(-26, 5, -20.5f).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, 0.9f, -1, -0.5f, 0.9f, -1, -0.5f, -0.9f, 0, -0.5f, -0.9f)
			.setRotationPoint(-40.9f, 7.4f, 18.1f).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 81, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 2, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, -0.6f, 0, -1.5f, -0.6f, 0, -1.5f, -0.6f, 0, 0, -0.6f, 0)
			.setRotationPoint(-40.9f, 4, -20.1f).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -0.5f, -0.9f, -1, -0.5f, -0.9f, -1, -0.5f, 0.9f, 0, -0.5f, 0.9f)
			.setRotationPoint(-40.9f, 7.4f, -20.1f).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 105, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 3.1f, 0, -0.3f, 3.1f, 0, 0.3f, 0, 0, 0.05f, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(-40.9f, 2, 18.1f).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 0, -0.6f, -0.2f, 0.5f, -0.6f, 0, 0.5f, -0.6f, 0, 0, -0.6f, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(-40.9f, 3, -20.1f).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 14, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, -0.6f, 0.6f, -0.6f, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0.6f, 0, -0.3f)
			.setRotationPoint(-54.2f, 2.6f, -16.6f).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 14, 0, 0.6f, -0.6f, -0.6f, 0, -0.6f, -0.6f, 0, -0.6f, 0, 0, -0.6f, 0, 0.6f, 0, -0.3f, 0, 0, -0.3f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-54.2f, 2.6f, 2.6f).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 89, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 4, 1, 0, -0.3f, 0, 0, 0.4f, 0, 0, 0.4f, 0, -0.8f, -0.3f, 0, -0.8f, 0, 0.2f, 0, 0.4f, 0.2f, 0, 0.4f, 0.2f, -0.8f, 0, 0.2f, -0.8f)
			.setRotationPoint(-54.8f, -3, 3.2f).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 89, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 4, 1, 0, -0.3f, 0, 0, 0.4f, 0, 0, 0.4f, 0, -0.8f, -0.3f, 0, -0.8f, 0, 0.2f, 0, 0.4f, 0.2f, 0, 0.4f, 0.2f, -0.8f, 0, 0.2f, -0.8f)
			.setRotationPoint(-54.8f, -3, -3.4f).setRotationAngle(0, 0, 0).setName("Box 246")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -0.3f, -0.6f, 0, 0.3f, -0.6f, 0, 0, -0.6f, -0.6f, 0, -0.6f, -0.6f, -0.3f, 0, 0, 0.3f, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f)
			.setRotationPoint(-54.2f, 2.6f, -18).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, -1.1f, 0, 0, 1.1f, 0, 0, 0.8f, 0, -0.6f, -0.8f, 0, -0.6f, -0.3f, 0, 0, 0.3f, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f)
			.setRotationPoint(-54, -3, -18).setRotationAngle(0, 0, 0).setName("Box 249")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, -1, -0.6f, -0.4f, 0.2f, -0.6f, 0, 0.2f, -0.6f, 0, -0.3f, -0.6f, 0, -1, 0, -0.4f, 0.2f, 0, 0, 0.2f, 0, 0, -0.3f, 0, 0)
			.setRotationPoint(-54.2f, 2.6f, -19).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, -1.6f, 0, -0.6f, -0.3f, 0, -0.6f, -0.4f, 0, 0, -1.1f, 0, 0, -1, 0, -0.4f, 0, 0, 0, 0, 0, 0, -0.3f, 0, 0)
			.setRotationPoint(-54, -3, -19).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 457, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 5, 1, 0, 0, 0, 0, 0, 0, 0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.6f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-52, -1, -19).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 1, 0, 0.3f, 0, -0.6f, 0, 0.2f, 0, 0, 0.2f, 0, 0.4f, 0, 0, 0, 0, 0, 0, 0, 0.9f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-52, -3, -19).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 0, -0.6f, -0.6f, 0, -0.6f, -0.6f, 0.3f, -0.6f, 0, -0.3f, -0.6f, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0.3f, 0, 0, -0.3f, 0, 0)
			.setRotationPoint(-54.2f, 2.6f, 16).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, -0.3f, -0.6f, 0, 0.2f, -0.6f, 0, 0.2f, -0.6f, 0, -1, -0.6f, -0.4f, -0.3f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, -1, 0, -0.4f)
			.setRotationPoint(-54.2f, 2.6f, 18).setRotationAngle(0, 0, 0).setName("Box 255")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.6f, 0, 0, 0)
			.setRotationPoint(-52, -1, 18).setRotationAngle(0, 0, 0).setName("Box 256")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 1, 0, 0.4f, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0.3f, 0, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0, 0.9f, 0, 0, 0)
			.setRotationPoint(-52, -3, 18).setRotationAngle(0, 0, 0).setName("Box 257")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, -1.1f, 0, 0, -0.4f, 0, 0, -0.3f, 0, -0.6f, -1.6f, 0, -0.6f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -0.4f)
			.setRotationPoint(-54, -3, 18).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, -0.8f, 0, -0.6f, 0.8f, 0, -0.6f, 1.1f, 0, 0, -1.1f, 0, 0, 0, 0, -0.6f, 0, 0, -0.6f, 0.3f, 0, 0, -0.3f, 0, 0)
			.setRotationPoint(-54, -3, 16).setRotationAngle(0, 0, 0).setName("Box 259")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, -0.3f, -0.7f, -0.1f, -0.1f, -0.5f, -0.1f, -0.4f, -0.5f, -0.5f, 0, -0.7f, -0.5f, -0.1f, 0, 0, 0.1f, 0, 0, -0.2f, 0, -0.5f, 0.2f, 0, -0.5f)
			.setRotationPoint(-53, -4, -18).setRotationAngle(0, 0, 0).setName("Box 266")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0, -0.6f, -0.9f, 0, 0.3f, -0.9f, 0, 0.3f, 0, 0.1f, -0.5f, 0.1f, 0.3f, 0, -0.6f, 0, -0.2f, 0, 0, 0, 0, 0.1f, 0, 0.1f)
			.setRotationPoint(-52, -4, -19).setRotationAngle(0, 0, 0).setName("Box 267")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 65, textureX, textureY)
			.addShapeBox(0, 2, 0, 1, 1, 1, 0, -1.1f, -0.8f, -0.8f, 0.5f, -0.6f, -0.9f, 0.4f, -0.5f, 0.1f, -0.8f, -0.7f, 0.1f, -1.1f, 0, -0.6f, 0.2f, 0, -0.6f, 0.2f, 0, 0, -0.6f, 0, 0)
			.setRotationPoint(-53.5f, -6, -19).setRotationAngle(0, 0, 0).setName("Box 268")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 81, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 1, 0, 0.1f, -0.5f, 0.1f, 0, 0.3f, 0, 0, 0.3f, -0.9f, 0, -0.6f, -0.9f, 0.1f, 0, 0.1f, 0, 0, 0, 0, -0.2f, 0, 0.3f, 0, -0.6f)
			.setRotationPoint(-52, -4, 18).setRotationAngle(0, 0, 0).setName("Box 269")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 2, 0, 0, -0.7f, -0.5f, -0.4f, -0.5f, -0.5f, -0.1f, -0.5f, -0.1f, -0.3f, -0.7f, -0.1f, 0.2f, 0, -0.5f, -0.2f, 0, -0.5f, 0.1f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-53, -4, 16).setRotationAngle(0, 0, 0).setName("Box 270")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 49, 65, textureX, textureY)
			.addShapeBox(0, 2, 0, 1, 1, 1, 0, -0.8f, -0.7f, 0.1f, 0.4f, -0.5f, 0.1f, 0.5f, -0.6f, -0.9f, -1.1f, -0.8f, -0.8f, -0.6f, 0, 0, 0.2f, 0, 0, 0.2f, 0, -0.6f, -1.1f, 0, -0.6f)
			.setRotationPoint(-53.5f, -6, 18).setRotationAngle(0, 0, 0).setName("Box 271")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 2, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0.2f, 0, 0, -0.1f, 0, 0, 0, 0.1f, 0, -0.1f, 0.1f, 0, 0.1f, 0, 0, -0.4f)
			.setRotationPoint(-45, -1, 18).setRotationAngle(0, 0, 0).setName("Box 272")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 2, 0, -0.1f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0.2f, -0.1f, 0, 0.2f, -0.1f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0.4f, -0.1f, 0, 0.15f)
			.setRotationPoint(-41, -1, 18).setRotationAngle(0, 0, 0).setName("Box 279")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0, -0.3f, 0, 0, -0.3f, 0.3f, 0, 0, 0.4f)
			.setRotationPoint(-35.8f, -1, 18).setRotationAngle(0, 0, 0).setName("Box 280")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 329, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0.4f, 0, -0.3f, 0.3f)
			.setRotationPoint(-32.8f, -1, 18).setRotationAngle(0, 0, 0).setName("Box 281")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 2, 0, 0, 0, 0, -3.1f, 0, 0, -3.1f, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, -0.3f, 0, 0, -0.3f, 0, 0.3f, 0, 0, 0.4f)
			.setRotationPoint(-29.8f, -1, 18).setRotationAngle(0, 0, 0).setName("Box 282")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 2, 0, 0, 0, 0, -2.3f, 0, 0, -2.3f, 0, 0.3f, 0, 0, 0.4f, -3.6f, 0, 0, 0.3f, 0, -0.1f, 0.3f, 0, 0.1f, -3.6f, 0, 0)
			.setRotationPoint(-29.8f, 2, 18).setRotationAngle(0, 0, 0).setName("Box 283")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 89, textureX, textureY)
			.addShapeBox(0, -0.5f, -0.5f, 4, 1, 1, 0, 1.1f, 0, 0, -1.1f, 0, 0, -0.3f, 0, 0, 0.2f, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-26.5f, 4.5f, 19.8f).setRotationAngle(-0.7853982f, 0, 0).setName("Box 284")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 2, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, -0.2f, -0.7f, 0, -0.2f, -0.8f, 0, 0, 0, 0.9f, 0, 0, 0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(-32.8f, -3, 18.2f).setRotationAngle(0, 0, 0).setName("Box 285")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 2, 0, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.8f, 0, -0.2f, -0.9f, -0.1f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-41, -3, 18.2f).setRotationAngle(0, 0, 0).setName("Box 286")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 2, 0, 0, 0.2f, 0, 0, -0.2f, 0, 0, -0.2f, -0.7f, 0, 0.2f, -1, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0.2f, 0, 0, -0.1f)
			.setRotationPoint(-45, -3, 18).setRotationAngle(0, 0, 0).setName("Box 287")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 329, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 2, 0, 0, 0, 0.4f, -2.3f, 0, 0.3f, -2.3f, 0, 0, 0, 0, 0, -3.6f, 0, 0, 0.3f, 0, 0.1f, 0.3f, 0, -0.1f, -3.6f, 0, 0)
			.setRotationPoint(-29.8f, 2, -20).setRotationAngle(0, 0, 0).setName("Box 288")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 105, 89, textureX, textureY)
			.addShapeBox(0, -0.5f, -0.5f, 4, 1, 1, 0, 1.1f, 0, 0, -1, 0, 0, -0.3f, 0, 0, 0.2f, 0, 0, 0, 0, 0, -0.5f, 0, 0, 0.2f, 0, 0, -0.5f, 0, 0)
			.setRotationPoint(-26.5f, 4.5f, -19.8f).setRotationAngle(-0.7853982f, 0, 0).setName("Box 289")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 2, 0, 0, 0, -0.1f, 0.1f, 0, 0.2f, 0.1f, 0, 0, 0, 0, 0, 0, 0, -0.4f, 0.1f, 0, 0.1f, 0.1f, 0, -0.1f, 0, 0, 0)
			.setRotationPoint(-45, -1, -20).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 2, 0, 0, 0.2f, -1, 0, -0.2f, -0.7f, 0, -0.2f, 0, 0, 0.2f, 0, 0, 0, -0.1f, 0.1f, 0, 0.2f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -3, -20).setRotationAngle(0, 0, 0).setName("Box 291")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0.05f, 3.1f, 0, 0.3f, 3.1f, 0, -0.3f, 0, 0, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(-40.9f, 2, -20.1f).setRotationAngle(0, 0, 0).setName("Box 292")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 169, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 2, 0, -0.1f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0.15f, 0.2f, 0, 0.4f, 0.2f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-41, -1, -20).setRotationAngle(0, 0, 0).setName("Box 293")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 2, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0.4f, 0, -0.3f, 0.3f, 0, -0.3f, 0, 0, 0, 0)
			.setRotationPoint(-35.8f, -1, -20).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 2, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0.3f, 0, 0, 0.4f, 0, 0, 0, 0, -0.3f, 0)
			.setRotationPoint(-32.8f, -1, -20).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 2, 0, 0, 0, 0.2f, -3.1f, 0, 0.2f, -3.1f, 0, 0, 0, 0, 0, 0, 0, 0.4f, -0.3f, 0, 0.3f, -0.3f, 0, 0, 0, 0, 0)
			.setRotationPoint(-29.8f, -1, -20).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 2, 0, 0, -0.2f, -0.9f, 0.2f, -0.2f, -0.8f, 0.2f, -0.2f, 0, 0, -0.2f, 0, -0.1f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, -0.1f, 0, 0)
			.setRotationPoint(-41, -3, -20.2f).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 2, 0, 0, -0.2f, -0.8f, 0, -0.2f, -0.7f, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0.9f, 0, 0, 0.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(-32.8f, -3, -20.2f).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 89, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0, 0, 0.6f, -0.3f, 0.2f, 0.7f, -0.3f, -1.1f, 0, 0, -0.9f, 0, -0.3f, 0, 0, -0.2f, 0.1f, 0.2f, 0.1f, -0.3f, 0, -0.1f, -0.2f)
			.setRotationPoint(-32.8f, -1, 20.2f).setRotationAngle(0, 0, 0).setName("Box 299")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 89, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0.3f, 0, 0.1f, -0.5f, 0.1f, 0.1f, -0.5f, -1, 0, 0.3f, -0.9f, 0.7f, -0.8f, -0.1f, -0.7f, 0.2f, 0, -0.7f, 0.2f, -0.3f, 0.5f, -0.5f, -0.1f)
			.setRotationPoint(-30.1f, -0.4f, 20).setRotationAngle(0, 0, 0).setName("Box 300")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 89, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.6f, -0.3f, 0.2f, 0, 0, 0, 0, 0, -0.9f, 0.7f, -0.3f, -1.1f, 0, -0.2f, 0.1f, 0, -0.3f, 0, 0, -0.1f, -0.2f, 0.2f, 0.1f, -0.3f)
			.setRotationPoint(-34.8f, -1, 20.2f).setRotationAngle(0, 0, 0).setName("Box 301")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.1f, -0.5f, 0.1f, 0, 0.3f, 0, 0, 0.3f, -0.9f, 0.1f, -0.5f, -1, -0.2f, 0.1f, 0, 0.7f, -0.8f, -0.1f, 0.5f, -0.5f, -0.1f, -0.2f, 0.1f, -0.2f)
			.setRotationPoint(-37.5f, -0.4f, 20).setRotationAngle(0, 0, 0).setName("Box 302")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, -1.7f, 0, 0, 0.5f, 0.1f, 0, 0.5f, -1, 0, -1.7f, -1, 0, 1.2f, 0.2f, 0.3f, -0.9f, 0, 0.3f, -0.9f, -0.2f, 0, 1.2f, -0.9f)
			.setRotationPoint(-39.6f, 0.6f, 20).setRotationAngle(0, 0, 0).setName("Box 303")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.4f, 0.3f, 0.1f, -0.5f, -1.8f, 0.2f, -0.5f, -1.8f, -1.1f, 0, 0.5f, -1, 0.8f, -0.8f, 0, -0.5f, 1, 0.1f, -0.5f, 1, -1, 0.8f, -0.8f, -0.3f)
			.setRotationPoint(-28, 0.6f, 20).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0, -0.9f, 0.7f, -0.3f, -1.1f, 0.6f, -0.3f, 0.2f, 0, 0, 0, 0, -0.1f, -0.2f, 0.2f, 0.1f, -0.3f, 0, -0.2f, 0.1f, 0, -0.3f, 0)
			.setRotationPoint(-32.8f, -1, -21.2f).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.7f, -0.3f, -1.1f, 0, 0, -0.9f, 0, 0, 0, 0.6f, -0.3f, 0.2f, 0.2f, 0.1f, -0.3f, 0, -0.1f, -0.2f, 0, -0.3f, 0, 0, -0.2f, 0.1f)
			.setRotationPoint(-34.8f, -1, -21.2f).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0.1f, -0.5f, -1, 0, 0.3f, -0.9f, 0, 0.3f, 0, 0.1f, -0.5f, 0.1f, -0.2f, 0.1f, -0.2f, 0.5f, -0.5f, -0.1f, 0.7f, -0.8f, -0.1f, -0.2f, 0.1f, 0)
			.setRotationPoint(-37.5f, -0.4f, -21).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 425, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, -1.7f, -1, 0, 0.5f, -1, 0, 0.5f, 0.1f, 0, -1.7f, 0, 0, 1.2f, -0.9f, 0.3f, -0.9f, -0.2f, 0.3f, -0.9f, 0, 0, 1.2f, 0.2f)
			.setRotationPoint(-39.6f, 0.6f, -21).setRotationAngle(0, 0, 0).setName("Box 308")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 433, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0.3f, -0.9f, 0.1f, -0.5f, -1, 0.1f, -0.5f, 0.1f, 0, 0.3f, 0, 0.5f, -0.5f, -0.1f, -0.7f, 0.2f, -0.3f, -0.7f, 0.2f, 0, 0.7f, -0.8f, -0.1f)
			.setRotationPoint(-30.1f, -0.4f, -21).setRotationAngle(0, 0, 0).setName("Box 309")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 457, 105, textureX, textureY)
			.addShapeBox(0, 2, 0, 2, 1, 1, 0, 0, 0.5f, -1, -0.5f, -1.8f, -1.1f, -0.5f, -1.8f, 0.2f, 0.4f, 0.3f, 0.1f, 0.8f, -0.8f, -0.3f, -0.5f, 1, -1, -0.5f, 1, 0.1f, 0.8f, -0.8f, 0)
			.setRotationPoint(-28, 0.6f, -21).setRotationAngle(0, 0, 0).setName("Box 310")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 2, 0, -0.6f, -1, -0.6f, 0, 0.1f, -0.6f, 0, -0.2f, 0, -0.9f, -1, -0.1f, -0.6f, 0.5f, -0.5f, 0, 0, -0.6f, 0, 0, 0, -0.9f, 1, -0.1f)
			.setRotationPoint(-53, -4.5f, 16).setRotationAngle(0, 0, 0).setName("Box 311")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 2, 0, -0.9f, -1, -0.1f, 0, -0.2f, 0, 0, 0.1f, -0.6f, -0.6f, -1, -0.6f, -0.9f, 1, -0.1f, 0, 0, 0, 0, 0, -0.6f, -0.6f, 0.5f, -0.5f)
			.setRotationPoint(-53, -4.5f, -18).setRotationAngle(0, 0, 0).setName("Box 312")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 89, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 1, 0, 0, -0.7f, 0, 0, 0, 0.2f, 0, 0, -1.1f, 0, -0.7f, -0.9f, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0.1f, 0, -0.2f, 0)
			.setRotationPoint(-45, -5, 18).setRotationAngle(0, 0, 0).setName("Box 313")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 2, 0, 0, -0.7f, 0, 0, 0, -0.2f, -1.8f, 0.4f, -0.6f, 0, -0.4f, -0.6f, 0, 0.7f, 0, 0, 0, 0, 0, 0, -0.6f, 0, 0.4f, -0.6f)
			.setRotationPoint(-45, -5, -18).setRotationAngle(0, 0, 0).setName("Box 314")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 1, 2, 0, 0, -0.4f, -0.6f, -1.8f, 0.4f, -0.6f, 0, 0, -0.2f, 0, -0.7f, 0, 0, 0.4f, -0.6f, 0, 0, -0.6f, 0, 0, 0, 0, 0.7f, 0)
			.setRotationPoint(-45, -5, 16).setRotationAngle(0, 0, 0).setName("Box 315")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 113, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 2, 1, 0, 0, -0.7f, -0.9f, 0, 0, -1.1f, 0, 0, 0.2f, 0, -0.7f, 0, 0, -0.2f, 0, 0, -0.3f, 0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -5, -19).setRotationAngle(0, 0, 0).setName("Box 316")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 1, 0, 0, 0, 0.5f, -0.5f, 0, 0.1f, -0.6f, 0, -0.7f, 0, 0, -1.1f, 0, 0, -0.1f, 0.1f, 0, 0, -0.1f, -0.3f, 0.2f, 0, -0.3f, 0.1f)
			.setRotationPoint(-35, -5, 18).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 113, textureX, textureY)
			.addShapeBox(0, 2, 0, 6, 1, 1, 0, 0, -0.2f, 0.4f, -0.1f, -0.2f, 0.3f, -0.1f, -0.2f, -0.3f, 0, -0.2f, -0.4f, 0, -0.3f, 0.1f, 0.2f, -0.3f, 0, 0.2f, -0.3f, 0, 0, -0.3f, -0.1f)
			.setRotationPoint(-35, -5.5f, 18.5f).setRotationAngle(0, 0, 0).setName("Box 318")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 305, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 1, 0, 0, 0, -1.1f, -0.6f, 0, -0.7f, -0.5f, 0, 0.1f, 0, 0, 0.5f, 0, -0.3f, 0.1f, -0.1f, -0.3f, 0.2f, 0.1f, 0, 0, 0, 0, -0.1f)
			.setRotationPoint(-35, -5, -19).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 121, textureX, textureY)
			.addShapeBox(0, 2, 0, 6, 1, 1, 0, 0, -0.2f, -0.4f, -0.1f, -0.2f, -0.3f, -0.1f, -0.2f, 0.3f, 0, -0.2f, 0.4f, 0, -0.3f, -0.1f, 0.2f, -0.3f, 0, 0.2f, -0.3f, 0, 0, -0.3f, 0.1f)
			.setRotationPoint(-35, -5.5f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 320")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 129, textureX, textureY)
			.addShapeBox(0, 2, 0, 10, 1, 1, 0, 0, -0.3f, 0.5f, 0, -0.2f, 0.4f, 0, -0.2f, -0.4f, 0, -0.3f, -0.5f, -3.9f, -0.3f, 0.2f, 0, -0.3f, 0.1f, 0, -0.3f, -0.1f, -3.9f, -0.3f, -0.2f)
			.setRotationPoint(-45, -5.5f, 18.5f).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 129, textureX, textureY)
			.addShapeBox(0, 2, 0, 10, 1, 1, 0, 0, -0.3f, -0.5f, 0, -0.2f, -0.4f, 0, -0.2f, 0.4f, 0, -0.3f, 0.5f, -3.9f, -0.3f, -0.2f, 0, -0.3f, -0.1f, 0, -0.3f, 0.1f, -3.9f, -0.3f, 0.2f)
			.setRotationPoint(-45, -5.5f, -19.5f).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 7, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53.2f, 2.6f, -3.5f).setRotationAngle(0, 0, 0).setName("Box 330")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 10, 0, 0, 0, 0, -0.5f, -0.2f, 0, -0.5f, -0.2f, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0.2f, 0, -0.5f, 0.2f, 0, 0, 0, 0)
			.setRotationPoint(-8, -14.6f, -5).setRotationAngle(0, 0, 0).setName("Box 330")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 8, 0, 0, -0.5f, -0.5f, -1.1f, -0.6f, -0.5f, -0.5f, -0.2f, 0, 0, 0, 0, 0, 0.5f, -0.5f, -1.1f, 0.6f, -0.5f, -0.5f, 0.2f, 0, 0, 0, 0)
			.setRotationPoint(-8, -14.6f, -13).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 8, 0, 0, 0, 0, -0.5f, -0.2f, 0, -1.1f, -0.6f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, -0.5f, 0.2f, 0, -1.1f, 0.6f, -0.5f, 0, 0.5f, -0.5f)
			.setRotationPoint(-8, -14.6f, 5).setRotationAngle(0, 0, 0).setName("Box 332")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 10, 0, 0, -0.2f, 0, -0.5f, -0.6f, 0, -0.5f, -0.6f, 0, 0, -0.2f, 0, 0, 0.2f, 0, -0.5f, 0.6f, 0, -0.5f, 0.6f, 0, 0, 0.2f, 0)
			.setRotationPoint(-1.5f, -14.6f, -5).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 8, 0, 0, -0.2f, 0, -0.5f, -0.6f, 0, -1.8f, -0.9f, -0.5f, 0.6f, -0.6f, -0.5f, 0, 0.2f, 0, -0.5f, 0.6f, 0, -1.8f, 0.9f, -0.5f, 0.6f, 0.6f, -0.5f)
			.setRotationPoint(-1.5f, -14.6f, 5).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 8, 0, 0.6f, -0.6f, -0.5f, -1.8f, -0.9f, -0.5f, -0.5f, -0.6f, 0, 0, -0.2f, 0, 0.6f, 0.6f, -0.5f, -1.8f, 0.9f, -0.5f, -0.5f, 0.6f, 0, 0, 0.2f, 0)
			.setRotationPoint(-1.5f, -14.6f, -13).setRotationAngle(0, 0, 0).setName("Box 335")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 10, 0, 0, -0.2f, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, -0.2f, 0, 0, 0.2f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0.2f, 0)
			.setRotationPoint(-20, -14.5f, -5).setRotationAngle(0, 0, 0).setName("Box 336")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 8, 0, 0, -0.2f, 0, 0, 0.1f, 0, 0, -0.4f, -0.5f, 0, -0.7f, -0.5f, 0, 0.2f, 0, 0, -0.1f, 0, 0, 0.4f, -0.5f, 0, 0.7f, -0.5f)
			.setRotationPoint(-20, -14.5f, 5).setRotationAngle(0, 0, 0).setName("Box 337")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 8, 0, 0, -0.7f, -0.5f, 0, -0.4f, -0.5f, 0, 0.1f, 0, 0, -0.2f, 0, 0, 0.7f, -0.5f, 0, 0.4f, -0.5f, 0, -0.1f, 0, 0, 0.2f, 0)
			.setRotationPoint(-20, -14.5f, -13).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 481, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 10, 0, -1, -0.6f, 0, 0, -0.2f, 0, 0, -0.2f, 0, -1, -0.6f, 0, -0.1f, -0.1f, 0, 0, 0.2f, 0, 0, 0.2f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-23, -14.5f, -5).setRotationAngle(0, 0, 0).setName("Box 343")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 8, 0, -1.2f, -1.1f, -0.6f, 0, -0.7f, -0.5f, 0, -0.2f, 0, -1, -0.6f, 0, -0.5f, 0.5f, -0.4f, 0, 0.7f, -0.5f, 0, 0.2f, 0, -0.1f, -0.1f, 0)
			.setRotationPoint(-23, -14.5f, -13).setRotationAngle(0, 0, 0).setName("Box 344")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 457, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 8, 0, -1, -0.6f, 0, 0, -0.2f, 0, 0, -0.7f, -0.5f, -1.2f, -1.1f, -0.6f, -0.1f, -0.1f, 0, 0, 0.2f, 0, 0, 0.7f, -0.5f, -0.5f, 0.5f, -0.4f)
			.setRotationPoint(-23, -14.5f, 5).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 2, 0, 0, 0, 0, 0.1f, 4, 1.7f, 2.3f, 4, -2.8f, -1.8f, -0.4f, -0.8f, 0, 0, 0, -0.2f, -4.1f, 1.7f, 3.1f, -4.9f, -3, -1.8f, 0.4f, -0.8f)
			.setRotationPoint(-36.8f, -5.4f, 16.6f).setRotationAngle(0, 0, 0).setName("Box 353")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 2, 0, 0.9f, -1, -0.3f, 0, 3, 1.8f, 1.7f, 2.8f, -3.2f, -1.3f, -1, -0.8f, 1.2f, 0.9f, -0.3f, 0, -3, 1.8f, 1.8f, -3.5f, -3.2f, -3, 0, -0.7f)
			.setRotationPoint(-28.8f, -10.4f, 14.6f).setRotationAngle(0, 0, 0).setName("Box 354")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 1, 0, 0, -1.5f, 0, 1.5f, 2.4f, 1, 0, -0.2f, -0.4f, 0, -2, 0, 0, 0, 0, 0.2f, -1.5f, -0.2f, -0.6f, 0, 0.5f, 0, 0, 0)
			.setRotationPoint(-35, -7, 16.8f).setRotationAngle(0, 0, 0).setName("Box 355")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0.1f, -0.3f, 0, 0, -0.3f, 0, -0.9f, 0, 0, -1, 0, -1.7f, 0, -0.9f, -2.2f, 0.3f, -2.2f, -0.4f, 0, 1.5f, 0.6f, 0.6f)
			.setRotationPoint(-27.5f, -9.4f, 15.8f).setRotationAngle(0, 0, 0).setName("Box 357")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, 0, 0, 0.1f, 0, 0, -0.7f, 0, 0.1f, -0.8f, -0.1f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, -0.1f)
			.setRotationPoint(-20, -14, 12.5f).setRotationAngle(0, 0, 0).setName("Box 358")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0.1f, -0.8f, -0.1f, 0, -0.7f, 0, 0, 0.1f, 0, 0, -0.2f, 0, 0, 0.1f, -0.1f, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-20, -14, -13.5f).setRotationAngle(0, 0, 0).setName("Box 359")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 2, 0, -1.3f, -1, -0.8f, 1.7f, 2.8f, -3.2f, 0, 3, 1.8f, 0.9f, -1, -0.3f, -3, 0, -0.7f, 1.8f, -3.5f, -3.2f, 0, -3, 1.8f, 1.2f, 0.9f, -0.3f)
			.setRotationPoint(-28.8f, -10.4f, -16.6f).setRotationAngle(0, 0, 0).setName("Box 360")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 1, 2, 0, -1.8f, -0.4f, -0.8f, 2.3f, 4, -2.8f, 0.1f, 4, 1.7f, 0, 0, 0, -1.8f, 0.4f, -0.8f, 3.7f, -5, -2.8f, -0.2f, -4.1f, 1.7f, 0, 0, 0)
			.setRotationPoint(-36.8f, -5.4f, -18.6f).setRotationAngle(0, 0, 0).setName("Box 361")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 105, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 1, 0, 0, -2, 0, 0, -0.2f, -0.4f, 1.5f, 2.4f, 1, 0, -1.5f, 0, 0, 0, 0, -0.6f, 0, 0.5f, 0.2f, -1.2f, -0.2f, 0, 0, 0)
			.setRotationPoint(-35, -7, -17.8f).setRotationAngle(0, 0, 0).setName("Box 362")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, -1, -0.3f, 0, -0.9f, -0.3f, 0, 0, 0, 0, 0.1f, 1.5f, 0.6f, 0.6f, -2.2f, -0.3f, 0, -0.9f, -2.2f, 0.3f, 0, -1.5f, 0)
			.setRotationPoint(-27.5f, -9.4f, -16.8f).setRotationAngle(0, 0, 0).setName("Box 363")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 465, 105, textureX, textureY)
			.addShapeBox(0, 1, 0, 2, 1, 1, 0, -0.2f, -0.6f, 0.1f, 0, -0.2f, 0, -0.1f, -0.8f, -0.1f, -0.2f, -0.6f, -0.7f, 0, 0.1f, -0.1f, 0, 0, 0, 0, 0.1f, -0.1f, -0.2f, 0.7f, -0.7f)
			.setRotationPoint(-22, -15, 12.5f).setRotationAngle(0, 0, 0).setName("Box 364")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 105, textureX, textureY)
			.addShapeBox(0, 1, 0, 2, 1, 1, 0, -0.2f, -0.6f, -0.7f, -0.1f, -0.8f, -0.1f, 0, -0.2f, 0, -0.2f, -0.6f, 0.1f, -0.3f, 0.6f, -0.7f, 0, 0.1f, -0.1f, 0, 0, 0, -0.2f, 0, 0.1f)
			.setRotationPoint(-22, -15, -13.5f).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, 0.1f, 0, -0.1f, 0, 0, -0.1f, -0.7f, 0, 0, -0.7f, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -14, 12.5f).setRotationAngle(0, 0, 0).setName("Box 366")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, -0.7f, 0, -0.1f, -0.7f, 0, -0.1f, 0, 0, 0, 0.1f, 0, 0, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -14, -13.5f).setRotationAngle(0, 0, 0).setName("Box 367")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 257, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, 0, 0, -0.2f, -0.3f, 0, -0.2f, -0.9f, -0.1f, 0, -0.7f, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0.1f, -0.1f, 0, 0, 0)
			.setRotationPoint(-2.1f, -14, 12.5f).setRotationAngle(0, 0, 0).setName("Box 368")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 497, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 1, 1, 0, 0, -0.7f, 0, -0.2f, -0.9f, -0.1f, -0.2f, -0.3f, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0.1f, -0.1f, -0.2f, 0, 0, 0, 0, 0)
			.setRotationPoint(-2.1f, -14, -13.5f).setRotationAngle(0, 0, 0).setName("Box 369")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 10, 0, 0, 0, 0, -0.5f, -0.7f, 0, -0.5f, -0.7f, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0.4f, 0, 0.1f, 0.4f, 0, 0, 0, 0)
			.setRotationPoint(5, -14, -5).setRotationAngle(0, 0, 0).setName("Box 376")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 273, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 8, 0, 0, 0, 0, -0.5f, -0.7f, 0, -1.8f, -1.2f, 0.1f, 1.3f, -0.3f, -0.5f, 0, 0, 0, 0.1f, 0.4f, 0, -1.2f, 0.9f, -0.1f, 1.3f, 0.3f, -0.5f)
			.setRotationPoint(5, -14, 5).setRotationAngle(0, 0, 0).setName("Box 377")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 8, 0, 1.3f, -0.3f, -0.5f, -1.8f, -1.2f, 0.1f, -0.5f, -0.7f, 0, 0, 0, 0, 1.3f, 0.3f, -0.5f, -1.2f, 0.9f, -0.1f, 0.1f, 0.4f, 0, 0, 0, 0)
			.setRotationPoint(5, -14, -13).setRotationAngle(0, 0, 0).setName("Box 378")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, -0.1f, -0.5f, 2.9f, -0.1f, -0.2f, 2.7f, 0.1f, -0.1f, -2.1f, 0, 0.5f, -4.4f, -1, -2.1f, 8.7f, -0.7f, -2.1f, 8.6f, -0.7f, 1.9f, -7.7f, -0.6f, 2.5f)
			.setRotationPoint(8, -8.4f, 15).setRotationAngle(0, 0, 0).setName("Box 382")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, -0.2f, 0.5f, 1.1f, -0.8f, 0.1f, 0.5f, -0.1f, -0.9f, 0, 0, -0.6f, -4.3f, -0.4f, -2.5f, 7.2f, -0.4f, -2.2f, 7, -0.6f, 1.9f, -6.4f, -0.5f, 2.5f)
			.setRotationPoint(3.7f, -12.9f, 13).setRotationAngle(0, 0, 0).setName("Box 384")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, -2.1f, 0, 0.5f, 2.7f, 0.1f, -0.1f, 2.9f, -0.1f, -0.2f, 0, -0.1f, -0.5f, -7.7f, -0.6f, 2.5f, 8.6f, -0.7f, 1.9f, 8.7f, -0.7f, -2.1f, -4.4f, -1, -2.1f)
			.setRotationPoint(8, -8.4f, -16).setRotationAngle(0, 0, 0).setName("Box 385")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, -0.6f, 0.5f, -0.1f, -0.9f, 1.1f, -0.8f, 0.1f, 0, -0.2f, 0.5f, -6.4f, -0.5f, 2.5f, 7, -0.6f, 1.9f, 7.2f, -0.4f, -2.2f, -4.3f, -0.4f, -2.5f)
			.setRotationPoint(3.7f, -12.9f, -14).setRotationAngle(0, 0, 0).setName("Box 386")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 73, textureX, textureY)
			.addShapeBox(0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0.5f, -0.9f, -0.6f, 0.5f, -0.9f, -0.4f, 0, -0.6f, -0.1f, 0, 0, 0, 0, 0, 0, 0, 0.5f, -0.1f, 0, 0, -0.1f)
			.setRotationPoint(3.7f, -14.7f, 12.5f).setRotationAngle(0, 0, 0).setName("Box 387")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 449, 81, textureX, textureY)
			.addShapeBox(0, 1, 0, 1, 1, 1, 0, 0, -0.6f, -0.1f, 0.5f, -0.9f, -0.4f, 0.5f, -0.9f, -0.6f, 0, 0, 0, 0, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3.7f, -14.7f, -13.5f).setRotationAngle(0, 0, 0).setName("Box 388")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -4, 0, 6.9f, 0, -2.1f, 6.9f, 0, 1.5f, 0, -4, -0.4f, 0.3f, 0.9f, 0, 6.9f, -3, -2.1f, 6.9f, -3, 1.5f, 0.3f, 0.9f, -0.5f)
			.setRotationPoint(-29.7f, -13.4f, -14.9f).setRotationAngle(0, 0, 0).setName("Box 389")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 377, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -4, -0.4f, 6.9f, 0, 1.5f, 6.9f, 0, -2.1f, 0, -4, 0, 0.3f, 0.9f, -0.5f, 6.9f, -3, 1.5f, 6.9f, -3, -2.1f, 0.3f, 0.9f, 0)
			.setRotationPoint(-29.7f, -13.4f, 13.9f).setRotationAngle(0, 0, 0).setName("Box 390")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, -7.1f, 0, -1.7f, 5.8f, -0.9f, -1.7f, 5.8f, -0.9f, 1.2f, -7.1f, 0, 1.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-36.8f, -9.4f, -16.6f).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, -7.1f, 0, 1.3f, 5.8f, -0.9f, 1.2f, 5.8f, -0.9f, -1.7f, -7.1f, 0, -1.7f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-36.8f, -9.4f, 15.6f).setRotationAngle(0, 0, 0).setName("Box 392")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 129, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, 0, -0.3f, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, -0.3f, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-37.5f, -6.5f, -6).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, -0.7f, -1.1f, -0.4f, 0.3f, -0.8f, -0.6f, -0.5f, 0, 0, 0, -0.3f, 0, -0.7f, 0.5f, -0.4f, 0.3f, 0.5f, -0.4f, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-37.5f, -6.5f, -17).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, 0, -0.3f, 0, -0.5f, 0, 0, 0.3f, -0.8f, -0.6f, -0.7f, -1.1f, -0.4f, 0, 0, 0, -0.5f, 0, 0, 0.3f, 0.5f, -0.4f, -0.7f, 0.5f, -0.4f)
			.setRotationPoint(-37.5f, -6.5f, 6).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 313, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 12, 0, 0, -0.5f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.5f, 0, 0, 0.5f, 0, 0, 0.6f, 0, 0, 0.6f, 0, 0, 0.5f, 0)
			.setRotationPoint(19, -5.5f, -6).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 11, 0, 2.2f, -1.3f, 0, -2.2f, -1.4f, 0, 0, -0.6f, 0, 0, -0.5f, 0, 2.2f, 1, 0, -2.2f, 1.1f, 0, 0, 0.6f, 0, 0, 0.5f, 0)
			.setRotationPoint(19, -5.5f, -17).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 377, 169, textureX, textureY)
			.addShapeBox(0, 0, -11, 1, 1, 11, 0, 0, -0.5f, 0, 0, -0.6f, 0, -2.2f, -1.4f, 0, 2.2f, -1.3f, 0, 0, 0.5f, 0, 0, 0.6f, 0, -2.2f, 1.1f, 0, 2.2f, 1, 0)
			.setRotationPoint(19, -5.5f, 17).setRotationAngle(0, 0, 0).setName("Box 399")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 409, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 12, 0, 0, 0, 0, -0.3f, 0.4f, 0, -0.3f, 0.4f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17.3f, -4.6f, -6).setRotationAngle(0, 0, 0).setName("Box 400")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 8, 0, 0, -0.1f, 0, -1.9f, -0.2f, 0, -0.3f, 0.4f, 0, 0, 0, 0, 0, 0, 0, -1.9f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17.3f, -4.6f, -14).setRotationAngle(0, 0, 0).setName("Box 401")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 329, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 8, 0, 0, 0, 0, -0.3f, 0.4f, 0, -1.9f, -0.2f, 0, 0, -0.1f, 0, 0, 0, 0, 0, 0, 0, -1.9f, 0, 0, 0, 0, 0)
			.setRotationPoint(17.3f, -4.6f, 6).setRotationAngle(0, 0, 0).setName("Box 402")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 15, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(-37.5f, -5.5f, -6).setRotationAngle(0, 0, 0).setName("Box 420")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 433, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 15, 7, 0, -0.6f, -0.3f, 0, 0.6f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(-37.5f, -5.5f, -13).setRotationAngle(0, 0, 0).setName("Box 421")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 15, 7, 0, 0, 0, 0, 0, 0, 0, 0.6f, -0.3f, 0, -0.6f, -0.3f, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(-37.5f, -5.5f, 6).setRotationAngle(0, 0, 0).setName("Box 422")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 4, 0, -0.9f, -0.3f, 0, 0.9f, -0.3f, 0, 0.6f, -0.3f, 0, -0.6f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-37.5f, -5.5f, -17).setRotationAngle(0, 0, 0).setName("Box 423")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 377, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 4, 0, -0.6f, -0.3f, 0, 0.6f, -0.3f, 0, 0.9f, -0.3f, 0, -0.9f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-37.5f, -5.5f, 13).setRotationAngle(0, 0, 0).setName("Box 424")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, -0.9f, -0.3f, 0, 0.9f, -0.3f, 0, 0.8f, -0.3f, 0, -0.8f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-37.5f, -4.5f, -18).setRotationAngle(0, 0, 0).setName("Box 425")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 33, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, -0.8f, -0.3f, 0, 0.8f, -0.3f, 0, 0.9f, -0.3f, 0, -0.9f, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-37.5f, -4.5f, 17).setRotationAngle(0, 0, 0).setName("Box 426")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 15, 1, 0, 0, 0, 0, -0.5f, 0, 0, -1, 0, 0, -0.9f, 0, 0, 0, 0, 0, -0.5f, 0, 0, -1, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(-7.5f, -4.5f, 17.3f).setRotationAngle(0, 0, 0).setName("Box 436")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0.5f, 0, 1.5f, -1.2f, 0, 1.5f, -1.8f, 0, -1.5f, -0.1f, 0, -1.5f, 0, 0, 0, -0.5f, 0, 0, -1, 0, 0, -0.9f, 0, 0)
			.setRotationPoint(-7.5f, -8.5f, 17.3f).setRotationAngle(0, 0, 0).setName("Box 437")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 1, 0, 0.5f, -0.5f, 1.8f, -1.2f, -0.5f, 1.8f, -1.8f, -0.5f, -1.8f, -0.1f, -0.5f, -1.8f, -0.5f, 0, -1.5f, -0.2f, 0, -1.5f, -0.8f, 0, 1.5f, -1.1f, 0, 1.5f)
			.setRotationPoint(-8.5f, -13.5f, 14.3f).setRotationAngle(0, 0, 0).setName("Box 438")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 9, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 15, 1, 0, -0.9f, 0, 0, -1, 0, 0, -0.5f, 0, 0, 0, 0, 0, -0.9f, 0, 0, -1, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-7.5f, -4.5f, -18.3f).setRotationAngle(0, 0, 0).setName("Box 439")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, -0.1f, 0, -1.5f, -1.8f, 0, -1.5f, -1.2f, 0, 1.5f, 0.5f, 0, 1.5f, -0.9f, 0, 0, -1, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(-7.5f, -8.5f, -18.3f).setRotationAngle(0, 0, 0).setName("Box 440")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 1, 0, -0.1f, -0.5f, -1.8f, -1.8f, -0.5f, -1.8f, -1.2f, -0.5f, 1.8f, 0.5f, -0.5f, 1.8f, -1.1f, 0, 1.5f, -0.8f, 0, 1.5f, -0.2f, 0, -1.5f, -0.5f, 0, -1.5f)
			.setRotationPoint(-8.5f, -13.5f, -15.3f).setRotationAngle(0, 0, 0).setName("Box 441")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.8f, 0, 0.5f, -0.8f, 0, 0.5f, -0.8f, -0.8f, 0, -0.8f, -0.2f, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(15.5f, -5, 17.5f).setRotationAngle(0, 0, 0).setName("Box 463")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.8f, -0.2f, 0.5f, -0.8f, -0.8f, 0.5f, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(15.5f, -5, -18.5f).setRotationAngle(0, 0, 0).setName("Box 464")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 193, textureX, textureY)
			.addShapeBox(0, -1, 0, 5, 4, 1, 0, 0, -0.5f, -0.8f, -1.2f, 0.5f, -0.9f, -1.2f, 0.5f, 0, 0, -0.5f, 0, 4, -0.4f, 1, -4.4f, -0.4f, 1, -4.4f, -0.4f, -1.5f, 4, -0.4f, -1.5f)
			.setRotationPoint(-29.8f, -8.4f, -16.1f).setRotationAngle(0, 0, 0).setName("Box 506")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 81, 193, textureX, textureY)
			.addShapeBox(0, -1, 0, 5, 4, 1, 0, 0, -0.5f, 0, -1.2f, 0.5f, 0, -1.2f, 0.5f, -0.9f, 0, -0.5f, -0.8f, 4, -0.4f, -1.5f, -4.4f, -0.4f, -1.5f, -4.4f, -0.4f, 1, 4, -0.4f, 1)
			.setRotationPoint(-29.8f, -8.4f, 14.9f).setRotationAngle(0, 0, 0).setName("Box 508")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
	}

}