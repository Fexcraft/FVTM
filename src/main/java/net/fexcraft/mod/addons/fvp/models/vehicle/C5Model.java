//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.vehicle;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/vehicle/c5")
public class C5Model extends VehicleModel {

	public C5Model(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList chassis_core = new TurboList("chassis_core");
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 1, textureX, textureY).addBox(0, 0, 0, 22, 9, 30)
			.setRotationPoint(35, -3, -15).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(56, 2, -23).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 233, 17, textureX, textureY).addBox(0, 0, 0, 2, 2, 42)
			.setRotationPoint(45, 1, -21).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 33, textureX, textureY).addBox(0, 0, 0, 16, 4, 30)
			.setRotationPoint(38, -7, -15).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 48, 0, 0, 0, 0, -0.5f, 0, -1, -0.5f, 0, -1, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, 0, 0, 0)
			.setRotationPoint(59, 2, -24).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60.8f, -4.15f, -17).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60.8f, -5.65f, -17).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 73, 177, textureX, textureY).addBox(0, 0, 0, 22, 9, 34)
			.setRotationPoint(-37, -3, -17).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-38, 2, -23).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 249, textureX, textureY).addBox(0, 0, 0, 16, 4, 34)
			.setRotationPoint(-34, -7, -17).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 337, 137, textureX, textureY).addBox(0, 0, 0, 2, 2, 42)
			.setRotationPoint(-27, 1, -21).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 281, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 48, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, -1, 0, -1)
			.setRotationPoint(-42, 2, -24).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 321, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 44, 0, -8, 0, -2, 8, 0, -2, 8, 0, -2, -8, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -23, -22).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 14, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -23, 22.5f).setRotationAngle(0, 0, 0).setName("Box 254")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 14, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -23, -22.5f).setRotationAngle(0, 0, 0).setName("Box 255")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 11, 2, 2, 0, 0, 0, 0, 0, 0, -4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 4, 0, 0, 0)
			.setRotationPoint(-40, 5, -17).setRotationAngle(0, 0, 0).setName("Box 260")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 297, 1, textureX, textureY).addBox(0, 0, 0, 2, 2, 2)
			.setRotationPoint(-42, 5, -17).setRotationAngle(0, 0, 0).setName("Box 261")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-29, 5.5f, -14.5f).setRotationAngle(0, 0, 0).setName("Box 262")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 65, textureX, textureY).addBox(0, 0, 0, 7, 2, 2)
			.setRotationPoint(-21, 5, -13).setRotationAngle(0, 0, 0).setName("Box 263")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(56, 2, -24).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 185, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(56, 2, 23).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 4, 0, 0, -2, 0, 0)
			.setRotationPoint(54, -3, -24).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 4, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(54, -3, 23).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 273, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(52, -5, -24).setRotationAngle(0, 0, 0).setName("Box 308")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 289, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0)
			.setRotationPoint(49, -7, -24).setRotationAngle(0, 0, 0).setName("Box 309")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42, -8, -24).setRotationAngle(0, 0, 0).setName("Box 310")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 353, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(42, -7, -24).setRotationAngle(0, 0, 0).setName("Box 311")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(39, -5, -24).setRotationAngle(0, 0, 0).setName("Box 312")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 393, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(52, -5, 23).setRotationAngle(0, 0, 0).setName("Box 313")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 417, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0)
			.setRotationPoint(49, -7, 23).setRotationAngle(0, 0, 0).setName("Box 314")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 81, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42, -8, 23).setRotationAngle(0, 0, 0).setName("Box 315")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 465, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(42, -7, 23).setRotationAngle(0, 0, 0).setName("Box 316")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 489, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(39, -5, 23).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 369, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 3, 0, 0)
			.setRotationPoint(37, -3, -24).setRotationAngle(0, 0, 0).setName("Box 318")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 505, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(34, 5, -24).setRotationAngle(0, 0, 0).setName("Box 319")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 425, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(37, -3, 23).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 409, 193, textureX, textureY).addBox(0, 0, 0, 48, 2, 1)
			.setRotationPoint(-14, 5, -24).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 401, 257, textureX, textureY).addBox(0, 0, 0, 48, 2, 1)
			.setRotationPoint(-14, 5, 23).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 193, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32, 2, -24).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(32, 2, 23).setRotationAngle(0, 0, 0).setName("Box 329")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 153, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(34, 5, 23).setRotationAngle(0, 0, 0).setName("Box 330")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 385, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-16, 5, -24).setRotationAngle(0, 0, 0).setName("Box 335")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 401, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-16, 5, 23).setRotationAngle(0, 0, 0).setName("Box 336")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 137, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, 0, 0, -3, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-16, 2, -24).setRotationAngle(0, 0, 0).setName("Box 337")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 9, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, 0, 0, -2, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-16, 2, 23).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 97, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 3, 0, 0, -2, 0, 0)
			.setRotationPoint(-18, -3, -24).setRotationAngle(0, 0, 0).setName("Box 339")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 3, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-18, -3, 23).setRotationAngle(0, 0, 0).setName("Box 340")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-20, -5, -24).setRotationAngle(0, 0, 0).setName("Box 341")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 177, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0)
			.setRotationPoint(-23, -7, -24).setRotationAngle(0, 0, 0).setName("Box 342")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 481, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0)
			.setRotationPoint(-20, -5, 23).setRotationAngle(0, 0, 0).setName("Box 343")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 9, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 3, 0, 0, 3, 0, 0, -3, 0, 0)
			.setRotationPoint(-23, -7, 23).setRotationAngle(0, 0, 0).setName("Box 344")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 145, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-30, -8, -24).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 145, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 1, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, 0, -1, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-30, -8, 23).setRotationAngle(0, 0, 0).setName("Box 346")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 25, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(-30, -7, -24).setRotationAngle(0, 0, 0).setName("Box 347")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 105, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-33, -5, -24).setRotationAngle(0, 0, 0).setName("Box 348")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0)
			.setRotationPoint(-30, -7, 23).setRotationAngle(0, 0, 0).setName("Box 349")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 321, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-33, -5, 23).setRotationAngle(0, 0, 0).setName("Box 350")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 201, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-38, 2, -24).setRotationAngle(0, 0, 0).setName("Box 351")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-38, 2, 23).setRotationAngle(0, 0, 0).setName("Box 352")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 161, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 3, 0, 0)
			.setRotationPoint(-35, -3, -24).setRotationAngle(0, 0, 0).setName("Box 353")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 265, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-35, -3, 23).setRotationAngle(0, 0, 0).setName("Box 354")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 57, 169, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(61.7f, 2.5f, -6).setRotationAngle(0, 0, 0.12217305f).setName("license plate front")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 177, textureX, textureY).addBox(0, 0, 0, 1, 3, 12)
			.setRotationPoint(-41.2f, -2.5f, -6).setRotationAngle(0, 0, 0).setName("license plate rear")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 449, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -2, 0, 0, -0.5f, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -0.5f, 0, 0, 0, 0, 0, 2)
			.setRotationPoint(32, -11, 21.5f).setRotationAngle(0, 0, 0).setName("Box 462")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 121, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 4, 0, -0.5f, -0.2f, 0, 0, -0.5f, 0, 0, -0.5f, -0.3f, -0.5f, -0.2f, 0, -0.5f, -0.2f, 0, 0, -0.5f, 0, 0, -0.5f, -0.3f, -0.5f, -0.2f, 0)
			.setRotationPoint(31.5f, -12, 23).setRotationAngle(0, -0.2617994f, 0).setName("Box 463")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 505, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, -0.5f, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, -0.5f, 0, 0, -2)
			.setRotationPoint(32, -11, -22.5f).setRotationAngle(0, 0, 0).setName("Box 464")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 1, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 4, 0, -0.5f, -0.2f, 0, 0, -0.5f, -0.3f, 0, -0.5f, 0, -0.5f, -0.2f, 0, -0.5f, -0.2f, 0, 0, -0.5f, -0.3f, 0, -0.5f, 0, -0.5f, -0.2f, 0)
			.setRotationPoint(30.5f, -12, -27).setRotationAngle(0, 0.2617994f, 0).setName("Box 465")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 465, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, -0.3f, 0, -0.3f, -0.3f, 0, -0.3f, -0.3f, 0, -0.3f, -0.3f, 0, -0.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -8.5f, -1).setRotationAngle(0, 0, 1.0471976f).setName("Box 466")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 465, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.3f, 0, -0.3f, -0.3f, 0, -0.3f, -0.3f, 0, -0.3f, -0.3f, 0, -0.3f)
			.setRotationPoint(-40.3f, -8, -1).setRotationAngle(0, 0, 1.5707964f).setName("Box 467")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 241, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 14, 0, 0, -0.5f, -1, 0, 0, 0, 0, 0, 0, 0, -0.5f, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-41.5f, -3.5f, -7).setRotationAngle(0, 0, 0).setName("Box 468")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60.8f, -4.9f, -17).setRotationAngle(0, 0, 0).setName("Box 469")
		);
		chassis_core.add(new ModelRendererTurbo(chassis_core, 305, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 34, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60.8f, -6.4f, -17).setRotationAngle(0, 0, 0).setName("Box 470")
		);
		this.groups.add(chassis_core);
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(34, 2, -23).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(34, -3, -23).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(54, -3, -23).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -5, -23).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(52, -5, -23).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -7, -23).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(49, -7, -23).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 81, textureX, textureY).addBox(0, 0, 0, 16, 2, 46)
			.setRotationPoint(38, -9, -23).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -3, -22).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 113, textureX, textureY).addBox(0, 0, 0, 6, 3, 46)
			.setRotationPoint(54, -6, -23).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(59.9f, -6, -16.9f).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 4, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(59.9f, -6, 12.9f).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 297, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 5, 0, 0, 0, 0, -2, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -8, -22).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 337, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -3, -23).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 377, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(58, -3, 22).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 1, 0, 3, 0, 0, -3, 0, 0, -2, 0, 0, 3, 0, 0, 3, 0, 0, -1, 0, 0, 0, 0, 0, 3, 0, 0)
			.setRotationPoint(57, -8, -23).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 34, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -8, -17).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 5, 0, 0, 0, 0, -1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -8, 17).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 169, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 1, 0, 3, 0, 0, -2, 0, 0, -3, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0, -1, 0, 0, 3, 0, 0)
			.setRotationPoint(57, -8, 22).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 129, 137, textureX, textureY).addBox(0, 0, 0, 18, 1, 34)
			.setRotationPoint(36, -10, -17).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 5, 0, 0, -1, 0, -5, -1, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -10, -22).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, -3, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -9, -23).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 5, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -10, -22).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 2, 34, 0, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -10, -17).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 177, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 2, 5, 0, 0, 0, 0, -5, 0, 0, -5, -1, 0, 0, -1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -10, 17).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, 0, 0, 0, -2, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 2, 0, 0, 0, 0, 0)
			.setRotationPoint(54, -9, 22).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 233, 33, textureX, textureY).addBox(0, 0, 0, 16, 2, 1)
			.setRotationPoint(-34, -9, -23).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38, -10, 17).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 193, 137, textureX, textureY).addBox(0, 0, 0, 48, 2, 46)
			.setRotationPoint(-14, 5, -23).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 5, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-16, 2, -23).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-18, -3, -23).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-38, -3, -23).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-20, -5, -23).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(-36, -5, -23).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0)
			.setRotationPoint(-34, -7, -23).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 65, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0)
			.setRotationPoint(-23, -7, -23).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 44, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-34, -8, -22).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 65, textureX, textureY).addBox(0, 0, 0, 16, 2, 1)
			.setRotationPoint(-34, -9, 22).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 257, textureX, textureY).addBox(0, 0, 0, 2, 4, 46)
			.setRotationPoint(36, -9, -23).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 145, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -10, 17).setRotationAngle(0, 0, 0).setName("Box 126")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 5, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -10, -22).setRotationAngle(0, 0, 0).setName("Box 127")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 1, 0, 16, 0, -2, -16, 0, -2, -16, 0, 2, 16, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -23, -23).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 1, 0, 16, 0, 2, -16, 0, 2, -16, 0, -2, 16, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -23, 22).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 265, textureX, textureY).addBox(0, 0, 0, 2, 6, 44)
			.setRotationPoint(34, -9, -22).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 57, 297, textureX, textureY)
			.addShapeBox(0, 0, 0, 53, 1, 42, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-31, -24, -21).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 137, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 14, 2, 0, -8, 0, 2, 8, 0, 0, 8, 0, -2, -8, 0, -2, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-39, -23, 21).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 401, 265, textureX, textureY).addBox(0, 0, 0, 3, 5, 44)
			.setRotationPoint(-41, -3, -22).setRotationAngle(0, 0, 0).setName("Box 134")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-41, -3, 22).setRotationAngle(0, 0, 0).setName("Box 135")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 5, 1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-41, -3, -23).setRotationAngle(0, 0, 0).setName("Box 136")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 241, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 14, 2, 0, -8, 0, -2, 8, 0, -2, 8, 0, 0, -8, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(-39, -23, -23).setRotationAngle(0, 0, 0).setName("Box 137")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 297, textureX, textureY).addBox(0, 0, 0, 3, 2, 46)
			.setRotationPoint(-39, -5, -23).setRotationAngle(0, 0, 0).setName("Box 140")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 193, textureX, textureY).addBox(0, 0, 0, 2, 3, 34)
			.setRotationPoint(-41, -6, -17).setRotationAngle(0, 0, 0).setName("Box 141")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 305, textureX, textureY).addBox(0, 0, 0, 5, 4, 46)
			.setRotationPoint(-39, -9, -23).setRotationAngle(0, 0, 0).setName("Box 144")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-41, -9, -23).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 281, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-41, -9, 22).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 329, 313, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 44, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-41, -9, -22).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 73, textureX, textureY).addBox(0, 0, 0, 2, 6, 1)
			.setRotationPoint(-16, -9, -23).setRotationAngle(0, 0, 0).setName("Box 247")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 73, 345, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 5, 44, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-18, -8, -22).setRotationAngle(0, 0, 0).setName("Box 248")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 41, textureX, textureY).addBox(0, 0, 0, 2, 4, 1)
			.setRotationPoint(-18, -9, -23).setRotationAngle(0, 0, 0).setName("Box 249")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 81, textureX, textureY).addBox(0, 0, 0, 2, 6, 1)
			.setRotationPoint(-16, -9, 22).setRotationAngle(0, 0, 0).setName("Box 250")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 353, 57, textureX, textureY).addBox(0, 0, 0, 2, 4, 1)
			.setRotationPoint(-18, -9, 22).setRotationAngle(0, 0, 0).setName("Box 251")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 505, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 14, 1, 0, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-16, -23, -23).setRotationAngle(0, 0, 0).setName("Box 252")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 14, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-16, -23, 22).setRotationAngle(0, 0, 0).setName("Box 253")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 345, 97, textureX, textureY).addBox(0, 0, 0, 3, 14, 1)
			.setRotationPoint(7, -9, 21).setRotationAngle(0, 0, 0).setName("Box 256")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 377, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -23, 21).setRotationAngle(0, 0, 0).setName("Box 257")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 201, 137, textureX, textureY).addBox(0, 0, 0, 3, 14, 1)
			.setRotationPoint(7, -9, -22).setRotationAngle(0, 0, 0).setName("Box 258")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 225, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 14, 1, 0, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -23, -22).setRotationAngle(0, 0, 0).setName("Box 259")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 337, 137, textureX, textureY).addBox(0, 0, 0, 4, 14, 1)
			.setRotationPoint(30, -9, -23).setRotationAngle(0, 0, 0).setName("Box 265")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 81, textureX, textureY).addBox(0, 0, 0, 2, 6, 1)
			.setRotationPoint(34, -9, -23).setRotationAngle(0, 0, 0).setName("Box 266")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 417, 81, textureX, textureY).addBox(0, 0, 0, 2, 6, 1)
			.setRotationPoint(34, -9, 22).setRotationAngle(0, 0, 0).setName("Box 267")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 361, 137, textureX, textureY).addBox(0, 0, 0, 4, 14, 1)
			.setRotationPoint(30, -9, 22).setRotationAngle(0, 0, 0).setName("Box 268")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 473, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 5, 1, 0, 0, 0, 0.7f, -4, 0, 0.7f, -4, 0, -0.7f, 0, 0, -0.7f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(30, -14, 22).setRotationAngle(0, 0, 0).setName("Box 269")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 5, 1, 0, 0, 0, -0.7f, -4, 0, -0.7f, -4, 0, 0.7f, 0, 0, 0.7f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(30, -14, -23).setRotationAngle(0, 0, 0).setName("Box 272")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 217, 25, textureX, textureY).addBox(0, 0, 0, 1, 14, 1)
			.setRotationPoint(8, -9, 22).setRotationAngle(0, 0, 0).setName("Box 287")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 425, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -23, 22).setRotationAngle(0, 0, 0).setName("Box 288")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 65, textureX, textureY).addBox(0, 0, 0, 1, 14, 1)
			.setRotationPoint(8, -9, -23).setRotationAngle(0, 0, 0).setName("Box 289")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 161, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -23, -23).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 81, textureX, textureY).addBox(0, 0, 0, 7, 4, 1)
			.setRotationPoint(-14, 1, -23).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 121, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -2, -23).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 489, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 1, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -5, -23).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 9, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -6, -23).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 321, 97, textureX, textureY).addBox(0, 0, 0, 7, 4, 1)
			.setRotationPoint(-14, 1, 22).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 25, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -2, 22).setRotationAngle(0, 0, 0).setName("Box 332")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 17, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 1, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -5, 22).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -6, 22).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 185, 353, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 40, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 1, -0.8f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 1, -0.8f, 0)
			.setRotationPoint(20, -23, -20).setRotationAngle(0, 0, 0).setName("Box 423")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 369, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 14, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(30, -9, -22).setRotationAngle(0, 0, 0).setName("Box 445")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 385, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 14, 1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(30, -9, 21).setRotationAngle(0, 0, 0).setName("Box 446")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary);
		//
		TurboList door_close = new TurboList("door_close");
		door_close.add(new ModelRendererTurbo(door_close, 241, 193, textureX, textureY).addBox(0, 0, 0, 21, 14, 1)
			.setRotationPoint(9, -9, 22).setRotationAngle(0, 0, 0).setName("Box 388")
		);
		door_close.add(new ModelRendererTurbo(door_close, 97, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -23, 22).setRotationAngle(0, 0, 0).setName("Box 389")
		);
		door_close.add(new ModelRendererTurbo(door_close, 185, 121, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(9, -23, 20).setRotationAngle(0.13962634f, 0, 0).setName("Box 390")
		);
		door_close.add(new ModelRendererTurbo(door_close, 161, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0.7f, 0, 0, 0.7f, 0, 0, -0.7f, 0, 0, -0.7f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -14, 22).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		door_close.add(new ModelRendererTurbo(door_close, 97, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -11, 1, 0.1f, 10, 0, 0.1f, 10, 0, -0.2f, -11, 1, -0.2f)
			.setRotationPoint(18, -23, 20).setRotationAngle(0.15707964f, 0, 0).setName("Box 392")
		);
		door_close.add(new ModelRendererTurbo(door_close, 425, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -23, 22).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		door_close.add(new ModelRendererTurbo(door_close, 441, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -23, 22).setRotationAngle(0, 0, 0).setName("Box 394")
		);
		door_close.add(new ModelRendererTurbo(door_close, 209, 121, textureX, textureY).addBox(0, 0, 0, 20, 1, 1)
			.setRotationPoint(-13, -23, 20).setRotationAngle(0.13962634f, 0, 0).setName("Box 395")
		);
		door_close.add(new ModelRendererTurbo(door_close, 305, 121, textureX, textureY).addBox(0, 0, 0, 15, 4, 1)
			.setRotationPoint(-7, 1, 22).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		door_close.add(new ModelRendererTurbo(door_close, 57, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 3, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -2, 22).setRotationAngle(0, 0, 0).setName("Box 397")
		);
		door_close.add(new ModelRendererTurbo(door_close, 121, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 3, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-9, -5, 22).setRotationAngle(0, 0, 0).setName("Box 398")
		);
		door_close.add(new ModelRendererTurbo(door_close, 1, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 1, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-12, -6, 22).setRotationAngle(0, 0, 0).setName("Box 399")
		);
		door_close.add(new ModelRendererTurbo(door_close, 73, 169, textureX, textureY).addBox(0, 0, 0, 22, 3, 1)
			.setRotationPoint(-14, -9, 22).setRotationAngle(0, 0, 0).setName("Box 400")
		);
		door_close.add(new ModelRendererTurbo(door_close, 369, 17, textureX, textureY)
			.addShapeBox(0, -1, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(12, -6, 22.5f).setRotationAngle(0, 0, 0).setName("Box 401")
		);
		door_close.add(new ModelRendererTurbo(door_close, 457, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(22, -7, 21.5f).setRotationAngle(0, 0, 0).setName("Box 402")
		);
		door_close.add(new ModelRendererTurbo(door_close, 385, 17, textureX, textureY)
			.addShapeBox(0, -1, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(-11, -6, 22.5f).setRotationAngle(0, 0, 0).setName("Box 403")
		);
		door_close.add(new ModelRendererTurbo(door_close, 489, 17, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(1, -7, 21.5f).setRotationAngle(0, 0, 0).setName("Box 405")
		);
		door_close.add(new ModelRendererTurbo(door_close, 441, 169, textureX, textureY).addBox(0, 0, 0, 15, 4, 1)
			.setRotationPoint(-7, 1, -23).setRotationAngle(0, 0, 0).setName("Box 406")
		);
		door_close.add(new ModelRendererTurbo(door_close, 153, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 3, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -2, -23).setRotationAngle(0, 0, 0).setName("Box 407")
		);
		door_close.add(new ModelRendererTurbo(door_close, 193, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 3, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-9, -5, -23).setRotationAngle(0, 0, 0).setName("Box 408")
		);
		door_close.add(new ModelRendererTurbo(door_close, 441, 177, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 1, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-12, -6, -23).setRotationAngle(0, 0, 0).setName("Box 409")
		);
		door_close.add(new ModelRendererTurbo(door_close, 57, 185, textureX, textureY).addBox(0, 0, 0, 22, 3, 1)
			.setRotationPoint(-14, -9, -23).setRotationAngle(0, 0, 0).setName("Box 410")
		);
		door_close.add(new ModelRendererTurbo(door_close, 137, 25, textureX, textureY)
			.addShapeBox(0, -1, 0, 3, 1, 1, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(-11, -6, -23.5f).setRotationAngle(0, 0, 0).setName("Box 411")
		);
		door_close.add(new ModelRendererTurbo(door_close, 345, 41, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(1, -7, -22.5f).setRotationAngle(0, 0, 0).setName("Box 412")
		);
		door_close.add(new ModelRendererTurbo(door_close, 505, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -23, -23).setRotationAngle(0, 0, 0).setName("Box 413")
		);
		door_close.add(new ModelRendererTurbo(door_close, 33, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -23, -23).setRotationAngle(0, 0, 0).setName("Box 414")
		);
		door_close.add(new ModelRendererTurbo(door_close, 1, 193, textureX, textureY).addBox(0, 0, 0, 20, 1, 1)
			.setRotationPoint(-13, -23, -21).setRotationAngle(-0.13962634f, 0, 0).setName("Box 415")
		);
		door_close.add(new ModelRendererTurbo(door_close, 409, 201, textureX, textureY).addBox(0, 0, 0, 21, 14, 1)
			.setRotationPoint(9, -9, -23).setRotationAngle(0, 0, 0).setName("Box 416")
		);
		door_close.add(new ModelRendererTurbo(door_close, 9, 49, textureX, textureY).addBox(0, 0, 0, 4, 1, 1)
			.setRotationPoint(23, -7, -22.5f).setRotationAngle(0, 0, 0).setName("Box 417")
		);
		door_close.add(new ModelRendererTurbo(door_close, 457, 33, textureX, textureY)
			.addShapeBox(0, -1, 0, 3, 1, 1, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0)
			.setRotationPoint(12, -6, -23.5f).setRotationAngle(0, 0, 0).setName("Box 418")
		);
		door_close.add(new ModelRendererTurbo(door_close, 41, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -23, -23).setRotationAngle(0, 0, 0).setName("Box 419")
		);
		door_close.add(new ModelRendererTurbo(door_close, 57, 137, textureX, textureY).addBox(0, 0, 0, 10, 1, 1)
			.setRotationPoint(9, -23, -21).setRotationAngle(-0.13962634f, 0, 0).setName("Box 420")
		);
		door_close.add(new ModelRendererTurbo(door_close, 449, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -11, 1, -0.1f, 10, 0, -0.1f, 10, 0, 0.1f, -11, 1, 0.1f)
			.setRotationPoint(18, -23, -21).setRotationAngle(-0.15707964f, 0, 0).setName("Box 421")
		);
		door_close.add(new ModelRendererTurbo(door_close, 457, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, -0.7f, 0, 0, -0.7f, 0, 0, 0.7f, 0, 0, 0.7f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -14, -23).setRotationAngle(0, 0, 0).setName("Box 422")
		);
		door_close.addPrograms(DefaultPrograms.RGB_PRIMARY, DefaultPrograms.DOOR_CLOSE);
		this.groups.add(door_close);
		//
		TurboList door_open = new TurboList("door_open");
		door_open.add(new ModelRendererTurbo(door_open, 465, 201, textureX, textureY).addBox(0, 0, 0, 1, 14, 21)
			.setRotationPoint(29, -9, 22).setRotationAngle(0, 0, 0).setName("Box 426")
		);
		door_open.add(new ModelRendererTurbo(door_open, 417, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0.7f, -1, 0, -0.7f, -1, 0, -0.7f, 0, 0, 0.7f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -14, 22).setRotationAngle(0, 0, 0).setName("Box 427")
		);
		door_open.add(new ModelRendererTurbo(door_open, 505, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -23, 42).setRotationAngle(0, 0, 0).setName("Box 428")
		);
		door_open.add(new ModelRendererTurbo(door_open, 489, 161, textureX, textureY).addBox(0, 0, 0, 1, 1, 10)
			.setRotationPoint(27, -23, 33).setRotationAngle(0, 0, -0.13962634f).setName("Box 429")
		);
		door_open.add(new ModelRendererTurbo(door_open, 409, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 10, -0.2f, 0, 10, -0.2f, 1, -11, 0.1f, 1, -11)
			.setRotationPoint(27, -23, 33).setRotationAngle(0, 0, -0.15707964f).setName("Box 430")
		);
		door_open.add(new ModelRendererTurbo(door_open, 65, 65, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 3, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f)
			.setRotationPoint(29.5f, -6, 37).setRotationAngle(0, 0, 0).setName("Box 431")
		);
		door_open.add(new ModelRendererTurbo(door_open, 57, 81, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(28.5f, -7, 25).setRotationAngle(0, 0, 0).setName("Box 432")
		);
		door_open.add(new ModelRendererTurbo(door_open, 153, 185, textureX, textureY).addBox(0, 0, 0, 1, 4, 15)
			.setRotationPoint(7, 1, 22).setRotationAngle(0, 0, 0).setName("Box 434")
		);
		door_open.add(new ModelRendererTurbo(door_open, 201, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -2, 22).setRotationAngle(0, 0, 0).setName("Box 435")
		);
		door_open.add(new ModelRendererTurbo(door_open, 345, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -5, 22).setRotationAngle(0, 0, 0).setName("Box 436")
		);
		door_open.add(new ModelRendererTurbo(door_open, 465, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -6, 22).setRotationAngle(0, 0, 0).setName("Box 437")
		);
		door_open.add(new ModelRendererTurbo(door_open, 281, 249, textureX, textureY).addBox(0, 0, 0, 1, 3, 22)
			.setRotationPoint(7, -9, 22).setRotationAngle(0, 0, 0).setName("Box 438")
		);
		door_open.add(new ModelRendererTurbo(door_open, 25, 73, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 3, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f)
			.setRotationPoint(7.5f, -6, 38).setRotationAngle(0, 0, 0).setName("Box 439")
		);
		door_open.add(new ModelRendererTurbo(door_open, 417, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -23, 22).setRotationAngle(0, 0, 0).setName("Box 440")
		);
		door_open.add(new ModelRendererTurbo(door_open, 425, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -23, 43).setRotationAngle(0, 0, 0).setName("Box 441")
		);
		door_open.add(new ModelRendererTurbo(door_open, 1, 209, textureX, textureY).addBox(0, 0, 0, 1, 1, 20)
			.setRotationPoint(5, -23, 23).setRotationAngle(0, 0, -0.13962634f).setName("Box 442")
		);
		door_open.add(new ModelRendererTurbo(door_open, 1, 105, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(6.5f, -7, 25).setRotationAngle(0, 0, 0).setName("Box 443")
		);
		door_open.add(new ModelRendererTurbo(door_open, 33, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -23, -23).setRotationAngle(0, 0, 0).setName("Box 444")
		);
		door_open.add(new ModelRendererTurbo(door_open, 409, 217, textureX, textureY).addBox(0, 0, 0, 1, 1, 20)
			.setRotationPoint(5, -23, -43).setRotationAngle(0, 0, -0.13962634f).setName("Box 447")
		);
		door_open.add(new ModelRendererTurbo(door_open, 41, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -23, -44).setRotationAngle(0, 0, 0).setName("Box 448")
		);
		door_open.add(new ModelRendererTurbo(door_open, 457, 265, textureX, textureY).addBox(0, 0, 0, 1, 3, 22)
			.setRotationPoint(7, -9, -44).setRotationAngle(0, 0, 0).setName("Box 449")
		);
		door_open.add(new ModelRendererTurbo(door_open, 65, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 20, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -6, -42).setRotationAngle(0, 0, 0).setName("Box 450")
		);
		door_open.add(new ModelRendererTurbo(door_open, 257, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 17, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -5, -39).setRotationAngle(0, 0, 0).setName("Box 451")
		);
		door_open.add(new ModelRendererTurbo(door_open, 1, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 15, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -2, -37).setRotationAngle(0, 0, 0).setName("Box 452")
		);
		door_open.add(new ModelRendererTurbo(door_open, 129, 249, textureX, textureY).addBox(0, 0, 0, 1, 4, 15)
			.setRotationPoint(7, 1, -37).setRotationAngle(0, 0, 0).setName("Box 453")
		);
		door_open.add(new ModelRendererTurbo(door_open, 73, 73, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 3, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f)
			.setRotationPoint(7.5f, -6, -41).setRotationAngle(0, 0, 0).setName("Box 454")
		);
		door_open.add(new ModelRendererTurbo(door_open, 249, 121, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(6.5f, -7, -29).setRotationAngle(0, 0, 0).setName("Box 455")
		);
		door_open.add(new ModelRendererTurbo(door_open, 345, 249, textureX, textureY).addBox(0, 0, 0, 1, 14, 21)
			.setRotationPoint(29, -9, -43).setRotationAngle(0, 0, 0).setName("Box 456")
		);
		door_open.add(new ModelRendererTurbo(door_open, 1, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0.7f, 0, 0, -0.7f, 0, 0, -0.7f, -1, 0, 0.7f, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -14, -23).setRotationAngle(0, 0, 0).setName("Box 457")
		);
		door_open.add(new ModelRendererTurbo(door_open, 57, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 1, -11, -0.2f, 1, -11, -0.2f, 0, 10, 0.1f, 0, 10)
			.setRotationPoint(27, -23, -34).setRotationAngle(0, 0, -0.15707964f).setName("Box 457")
		);
		door_open.add(new ModelRendererTurbo(door_open, 289, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 14, 1, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -23, -43).setRotationAngle(0, 0, 0).setName("Box 458")
		);
		door_open.add(new ModelRendererTurbo(door_open, 17, 177, textureX, textureY).addBox(0, 0, 0, 1, 1, 10)
			.setRotationPoint(27, -23, -43).setRotationAngle(0, 0, -0.13962634f).setName("Box 459")
		);
		door_open.add(new ModelRendererTurbo(door_open, 137, 73, textureX, textureY)
			.addShapeBox(0, -1, 0, 1, 1, 3, 0, 0, 0, 0, -0.2f, 0, 0, -0.2f, 0, 0, 0, 0, 0, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f, 0, 0, 0.2f)
			.setRotationPoint(29.5f, -6, -40).setRotationAngle(0, 0, 0).setName("Box 460")
		);
		door_open.add(new ModelRendererTurbo(door_open, 497, 129, textureX, textureY).addBox(0, 0, 0, 1, 1, 4)
			.setRotationPoint(28.5f, -7, -29).setRotationAngle(0, 0, 0).setName("Box 461")
		);
		door_open.addPrograms(DefaultPrograms.RGB_PRIMARY, DefaultPrograms.DOOR_OPEN);
		this.groups.add(door_open);
	}

}