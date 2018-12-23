//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.zmp.models.vehicle;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.5-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "zmp:models/vehicle/flatbedwagon")
public class FlatbedwagonModel extends VehicleModel {

	public FlatbedwagonModel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("zackyboy19");
		//
		TurboList wagon = new TurboList("wagon");
		wagon.add(new ModelRendererTurbo(wagon, 350, 157, textureX, textureY).addBox(0, 0, 0, 1, 6, 6)
			.setRotationPoint(114.5f, -24, -3).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		wagon.add(new ModelRendererTurbo(wagon, 242, 157, textureX, textureY).addBox(0, 0, 0, 1, 3, 3)
			.setRotationPoint(115.5f, -22.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		wagon.add(new ModelRendererTurbo(wagon, 463, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(115.5f, -22.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		wagon.add(new ModelRendererTurbo(wagon, 411, 39, textureX, textureY).addBox(0, 0, 0, 4, 3, 1)
			.setRotationPoint(115.5f, -22.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		wagon.add(new ModelRendererTurbo(wagon, 400, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(115.5f, -22.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		wagon.add(new ModelRendererTurbo(wagon, 42, 98, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(115.5f, -23.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		wagon.add(new ModelRendererTurbo(wagon, 444, 94, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(115.5f, -19.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		wagon.add(new ModelRendererTurbo(wagon, 427, 84, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(114.5f, -21.5f, -2.5f).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		wagon.add(new ModelRendererTurbo(wagon, 420, 84, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.setRotationPoint(115.5f, -21.5f, 1.5f).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		wagon.add(new ModelRendererTurbo(wagon, 93, 157, textureX, textureY).addBox(0, 0, 0, 1, 2, 2)
			.setRotationPoint(119.5f, -22, -1).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		wagon.add(new ModelRendererTurbo(wagon, 68, 151, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0)
			.setRotationPoint(120.5f, -22, -2).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		wagon.add(new ModelRendererTurbo(wagon, 207, 166, textureX, textureY).addBox(0, 0, 0, 1, 6, 8)
			.setRotationPoint(122.5f, -24, -4).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		wagon.add(new ModelRendererTurbo(wagon, 341, 157, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 3, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, 1, -2, 0)
			.setRotationPoint(122.5f, -24, 4).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		wagon.add(new ModelRendererTurbo(wagon, 332, 157, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 3, 0, 1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, -1, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(122.5f, -24, -7).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		wagon.add(new ModelRendererTurbo(wagon, 42, 84, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(120.5f, -23, -1.5f).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		wagon.add(new ModelRendererTurbo(wagon, 474, 83, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(120.5f, -23, 0.5f).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		wagon.add(new ModelRendererTurbo(wagon, 43, 76, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(120.5f, -20, -1.5f).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		wagon.add(new ModelRendererTurbo(wagon, 43, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(120.5f, -20, 0.5f).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		wagon.add(new ModelRendererTurbo(wagon, 413, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(123, -22, -1).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		wagon.add(new ModelRendererTurbo(wagon, 408, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(123, -22, 0).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		wagon.add(new ModelRendererTurbo(wagon, 0, 60, textureX, textureY).addBox(0, 0, 0, 115, 3, 50)
			.setRotationPoint(-115, -29, -25).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		wagon.add(new ModelRendererTurbo(wagon, 329, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4)
			.setRotationPoint(113, -26, -25).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 93, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 8, 2, 0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(0, -24, -24.5f).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 82, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 8, 2, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1)
			.setRotationPoint(-58, -24, -24.5f).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		wagon.add(new ModelRendererTurbo(wagon, 235, 211, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 8, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4)
			.setRotationPoint(-115, -26, -25).setRotationAngle(0, 0, 0).setName("Box 202")
		);
		wagon.add(new ModelRendererTurbo(wagon, 188, 166, textureX, textureY).addBox(0, 0, 0, 1, 6, 8)
			.setRotationPoint(-123.5f, -24, -4).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		wagon.add(new ModelRendererTurbo(wagon, 201, 154, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 3, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, -1, -1, 0, 0, 0, 0, 0, 0, 0, 1, -2, 0, -1, -2, 0)
			.setRotationPoint(-123.5f, -24, 4).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		wagon.add(new ModelRendererTurbo(wagon, 168, 154, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 3, 0, -1, -1, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, 1, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-123.5f, -24, -7).setRotationAngle(0, 0, 0).setName("Box 205")
		);
		wagon.add(new ModelRendererTurbo(wagon, 375, 114, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-124, -22, 0).setRotationAngle(0, 0, 0).setName("Box 206")
		);
		wagon.add(new ModelRendererTurbo(wagon, 370, 114, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-124, -22, -1).setRotationAngle(0, 0, 0).setName("Box 207")
		);
		wagon.add(new ModelRendererTurbo(wagon, 459, 66, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-122.5f, -23, -1.5f).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		wagon.add(new ModelRendererTurbo(wagon, 459, 63, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-122.5f, -23, 0.5f).setRotationAngle(0, 0, 0).setName("Box 209")
		);
		wagon.add(new ModelRendererTurbo(wagon, 68, 144, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 4, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1)
			.setRotationPoint(-122.5f, -22, -2).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		wagon.add(new ModelRendererTurbo(wagon, 501, 139, textureX, textureY).addBox(0, 0, 0, 1, 2, 2)
			.setRotationPoint(-120.5f, -22, -1).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		wagon.add(new ModelRendererTurbo(wagon, 456, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-122.5f, -20, -1.5f).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		wagon.add(new ModelRendererTurbo(wagon, 42, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-122.5f, -20, 0.5f).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		wagon.add(new ModelRendererTurbo(wagon, 415, 34, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-119.5f, -22.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		wagon.add(new ModelRendererTurbo(wagon, 404, 34, textureX, textureY).addBox(0, 0, 0, 4, 3, 1)
			.setRotationPoint(-119.5f, -22.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		wagon.add(new ModelRendererTurbo(wagon, 493, 20, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-119.5f, -22.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		wagon.add(new ModelRendererTurbo(wagon, 143, 154, textureX, textureY).addBox(0, 0, 0, 1, 3, 3)
			.setRotationPoint(-116.5f, -22.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		wagon.add(new ModelRendererTurbo(wagon, 503, 53, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-117.5f, -21.5f, -2.5f).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		wagon.add(new ModelRendererTurbo(wagon, 456, 51, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-117.5f, -23.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		wagon.add(new ModelRendererTurbo(wagon, 449, 51, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-117.5f, -19.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		wagon.add(new ModelRendererTurbo(wagon, 389, 155, textureX, textureY).addBox(0, 0, 0, 1, 6, 6)
			.setRotationPoint(-115.5f, -24, -3).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		wagon.add(new ModelRendererTurbo(wagon, 26, 47, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(-116.5f, -21.5f, 1.5f).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 15, textureX, textureY)
			.addShapeBox(0, 0, 0, 63, 2, 2, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-63, -26, -24.5f).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 63, 2, 2, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -26, -24.5f).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 71, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 8, 2, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(-58, -24, 22.5f).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 5, textureX, textureY)
			.addShapeBox(0, 0, 0, 63, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-63, -26, 22.5f).setRotationAngle(0, 0, 0).setName("Box 228")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 63, 2, 2, 0, 2, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, -26, 22.5f).setRotationAngle(0, 0, 0).setName("Box 229")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 58, 8, 2, 0, 0, 0, 0, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(0, -24, 22.5f).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		wagon.add(new ModelRendererTurbo(wagon, 132, 216, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4)
			.setRotationPoint(113, -18, -21).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		wagon.add(new ModelRendererTurbo(wagon, 239, 166, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, -4, 0, 0, -4)
			.setRotationPoint(-115, -18, -21).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		wagon.add(new ModelRendererTurbo(wagon, 218, 114, textureX, textureY).addBox(0, 0, 0, 4, 1, 50)
			.setRotationPoint(111, -30, -25).setRotationAngle(0, 0, 0).setName("Box 413")
		);
		wagon.add(new ModelRendererTurbo(wagon, 109, 114, textureX, textureY).addBox(0, 0, 0, 4, 1, 50)
			.setRotationPoint(-115, -30, -25).setRotationAngle(0, 0, 0).setName("Box 414")
		);
		wagon.add(new ModelRendererTurbo(wagon, 426, 76, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(84, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		wagon.add(new ModelRendererTurbo(wagon, 499, 75, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(84, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		wagon.add(new ModelRendererTurbo(wagon, 134, 154, textureX, textureY).addBox(0, 0, 0, 1, 6, 3)
			.setRotationPoint(83, -27, -1.5f).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		wagon.add(new ModelRendererTurbo(wagon, 129, 154, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(83, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		wagon.add(new ModelRendererTurbo(wagon, 389, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(83, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		wagon.add(new ModelRendererTurbo(wagon, 277, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(87, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		wagon.add(new ModelRendererTurbo(wagon, 240, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(87, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		wagon.add(new ModelRendererTurbo(wagon, 231, 152, textureX, textureY).addBox(0, 0, 0, 1, 6, 3)
			.setRotationPoint(87, -27, -1.5f).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 28, textureX, textureY).addBox(0, 0, 0, 60, 6, 1)
			.setRotationPoint(53, -27, 6.5f).setRotationAngle(0, 0, 0).setName("Box 1461")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 20, textureX, textureY).addBox(0, 0, 0, 60, 6, 1)
			.setRotationPoint(53, -27, -8.5f).setRotationAngle(0, 0, 0).setName("Box 1462")
		);
		wagon.add(new ModelRendererTurbo(wagon, 471, 75, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(-87, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 425")
		);
		wagon.add(new ModelRendererTurbo(wagon, 0, 65, textureX, textureY).addBox(0, 0, 0, 3, 6, 1)
			.setRotationPoint(-87, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 426")
		);
		wagon.add(new ModelRendererTurbo(wagon, 192, 152, textureX, textureY).addBox(0, 0, 0, 1, 6, 3)
			.setRotationPoint(-88, -27, -1.5f).setRotationAngle(0, 0, 0).setName("Box 427")
		);
		wagon.add(new ModelRendererTurbo(wagon, 187, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(-88, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 428")
		);
		wagon.add(new ModelRendererTurbo(wagon, 182, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-88, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 429")
		);
		wagon.add(new ModelRendererTurbo(wagon, 177, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -27, 1.5f).setRotationAngle(0, 0, 0).setName("Box 430")
		);
		wagon.add(new ModelRendererTurbo(wagon, 434, 148, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 6, 1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-84, -27, -2.5f).setRotationAngle(0, 0, 0).setName("Box 431")
		);
		wagon.add(new ModelRendererTurbo(wagon, 120, 152, textureX, textureY).addBox(0, 0, 0, 1, 6, 3)
			.setRotationPoint(-84, -27, -1.5f).setRotationAngle(0, 0, 0).setName("Box 432")
		);
		wagon.add(new ModelRendererTurbo(wagon, 331, 44, textureX, textureY).addBox(0, 0, 0, 58, 6, 1)
			.setRotationPoint(-113, -27, 6.5f).setRotationAngle(0, 0, 0).setName("Box 433")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 36, textureX, textureY).addBox(0, 0, 0, 58, 6, 1)
			.setRotationPoint(-113, -27, -8.5f).setRotationAngle(0, 0, 0).setName("Box 434")
		);
		wagon.add(new ModelRendererTurbo(wagon, 375, 202, textureX, textureY).addBox(0, 0, 0, 2, 8, 46)
			.setRotationPoint(-55, -27, -22.5f).setRotationAngle(0, 0, 0).setName("Box 435")
		);
		wagon.add(new ModelRendererTurbo(wagon, 324, 174, textureX, textureY).addBox(0, 0, 0, 2, 8, 46)
			.setRotationPoint(51, -27, -22.5f).setRotationAngle(0, 0, 0).setName("Box 436")
		);
		wagon.add(new ModelRendererTurbo(wagon, 233, 57, textureX, textureY).addBox(0, 0, 0, 115, 1, 1)
			.setRotationPoint(-115, -30, -25).setRotationAngle(0, 0, 0).setName("Box 437")
		);
		wagon.add(new ModelRendererTurbo(wagon, 0, 57, textureX, textureY).addBox(0, 0, 0, 115, 1, 1)
			.setRotationPoint(0, -30, -25).setRotationAngle(0, 0, 0).setName("Box 438")
		);
		wagon.add(new ModelRendererTurbo(wagon, 233, 54, textureX, textureY).addBox(0, 0, 0, 115, 1, 1)
			.setRotationPoint(-115, -30, 24).setRotationAngle(0, 0, 0).setName("Box 439")
		);
		wagon.add(new ModelRendererTurbo(wagon, 0, 54, textureX, textureY).addBox(0, 0, 0, 115, 1, 1)
			.setRotationPoint(0, -30, 24).setRotationAngle(0, 0, 0).setName("Box 440")
		);
		wagon.add(new ModelRendererTurbo(wagon, 377, 148, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(116.5f, -24, 11.5f).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		wagon.add(new ModelRendererTurbo(wagon, 39, 46, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(115.5f, -25, 11.5f).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		wagon.add(new ModelRendererTurbo(wagon, 365, 114, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(114.5f, -25, 11.5f).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		wagon.add(new ModelRendererTurbo(wagon, 326, 114, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(114.5f, -19, 11.5f).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		wagon.add(new ModelRendererTurbo(wagon, 321, 114, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(116.5f, -20, 11.5f).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		wagon.add(new ModelRendererTurbo(wagon, 322, 148, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(116.5f, -24, -12.5f).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		wagon.add(new ModelRendererTurbo(wagon, 505, 40, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(115.5f, -25, -12.5f).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		wagon.add(new ModelRendererTurbo(wagon, 43, 107, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(114.5f, -25, -12.5f).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		wagon.add(new ModelRendererTurbo(wagon, 38, 107, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(114.5f, -19, -12.5f).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		wagon.add(new ModelRendererTurbo(wagon, 0, 107, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(116.5f, -20, -12.5f).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		wagon.add(new ModelRendererTurbo(wagon, 360, 114, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(115.5f, -20, -12.5f).setRotationAngle(0, 0, 0).setName("Box 1139")
		);
		wagon.add(new ModelRendererTurbo(wagon, 397, 108, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(115.5f, -20, 11.5f).setRotationAngle(0, 0, 0).setName("Box 1140")
		);
		wagon.add(new ModelRendererTurbo(wagon, 398, 140, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(-117.5f, -24, -12.5f).setRotationAngle(0, 0, 0).setName("Box 451")
		);
		wagon.add(new ModelRendererTurbo(wagon, 504, 23, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-117.5f, -25, -12.5f).setRotationAngle(0, 0, 0).setName("Box 452")
		);
		wagon.add(new ModelRendererTurbo(wagon, 45, 93, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-115.5f, -25, -12.5f).setRotationAngle(0, 0, 0).setName("Box 453")
		);
		wagon.add(new ModelRendererTurbo(wagon, 36, 89, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-115.5f, -19, -12.5f).setRotationAngle(0, 0, 0).setName("Box 454")
		);
		wagon.add(new ModelRendererTurbo(wagon, 434, 83, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-117.5f, -20, -12.5f).setRotationAngle(0, 0, 0).setName("Box 455")
		);
		wagon.add(new ModelRendererTurbo(wagon, 377, 140, textureX, textureY).addBox(0, 0, 0, 1, 4, 1)
			.setRotationPoint(-117.5f, -24, 11.5f).setRotationAngle(0, 0, 0).setName("Box 456")
		);
		wagon.add(new ModelRendererTurbo(wagon, 504, 20, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-117.5f, -25, 11.5f).setRotationAngle(0, 0, 0).setName("Box 457")
		);
		wagon.add(new ModelRendererTurbo(wagon, 441, 60, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-115.5f, -25, 11.5f).setRotationAngle(0, 0, 0).setName("Box 458")
		);
		wagon.add(new ModelRendererTurbo(wagon, 33, 47, textureX, textureY).addBox(0, 0, 0, 1, 1, 1)
			.setRotationPoint(-115.5f, -19, 11.5f).setRotationAngle(0, 0, 0).setName("Box 459")
		);
		wagon.add(new ModelRendererTurbo(wagon, 459, 20, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-117.5f, -20, 11.5f).setRotationAngle(0, 0, 0).setName("Box 460")
		);
		wagon.add(new ModelRendererTurbo(wagon, 45, 63, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-116.5f, -20, 11.5f).setRotationAngle(0, 0, 0).setName("Box 461")
		);
		wagon.add(new ModelRendererTurbo(wagon, 426, 34, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-116.5f, -20, -12.5f).setRotationAngle(0, 0, 0).setName("Box 462")
		);
		wagon.add(new ModelRendererTurbo(wagon, 402, 60, textureX, textureY).addBox(0, 0, 0, 3, 3, 1)
			.setRotationPoint(114.5f, -29, -17).setRotationAngle(0, 0, 0).setName("Box 1127")
		);
		wagon.add(new ModelRendererTurbo(wagon, 0, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(114.5f, -29, -18).setRotationAngle(0, 0, 0).setName("Box 1128")
		);
		wagon.add(new ModelRendererTurbo(wagon, 503, 48, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(114.5f, -29, -16).setRotationAngle(0, 0, 0).setName("Box 1129")
		);
		wagon.add(new ModelRendererTurbo(wagon, 372, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(117.5f, -29.5f, -18.5f).setRotationAngle(0, 0, 0).setName("Box 1136")
		);
		wagon.add(new ModelRendererTurbo(wagon, 113, 152, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(117.5f, -29.5f, -17.5f).setRotationAngle(0, 0, 0).setName("Box 1137")
		);
		wagon.add(new ModelRendererTurbo(wagon, 367, 140, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(117.5f, -29.5f, -15.5f).setRotationAngle(0, 0, 0).setName("Box 1138")
		);
		wagon.add(new ModelRendererTurbo(wagon, 447, 130, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(117.5f, -29.5f, 14.5f).setRotationAngle(0, 0, 0).setName("Box 469")
		);
		wagon.add(new ModelRendererTurbo(wagon, 106, 152, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(117.5f, -29.5f, 15.5f).setRotationAngle(0, 0, 0).setName("Box 470")
		);
		wagon.add(new ModelRendererTurbo(wagon, 377, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(117.5f, -29.5f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 471")
		);
		wagon.add(new ModelRendererTurbo(wagon, 463, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(114.5f, -29, 15).setRotationAngle(0, 0, 0).setName("Box 472")
		);
		wagon.add(new ModelRendererTurbo(wagon, 317, 44, textureX, textureY).addBox(0, 0, 0, 3, 3, 1)
			.setRotationPoint(114.5f, -29, 16).setRotationAngle(0, 0, 0).setName("Box 473")
		);
		wagon.add(new ModelRendererTurbo(wagon, 308, 44, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(114.5f, -29, 17).setRotationAngle(0, 0, 0).setName("Box 474")
		);
		wagon.add(new ModelRendererTurbo(wagon, 299, 44, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-117.5f, -29, -16).setRotationAngle(0, 0, 0).setName("Box 475")
		);
		wagon.add(new ModelRendererTurbo(wagon, 99, 152, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(-118.5f, -29.5f, -17.5f).setRotationAngle(0, 0, 0).setName("Box 476")
		);
		wagon.add(new ModelRendererTurbo(wagon, 263, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-118.5f, -29.5f, -15.5f).setRotationAngle(0, 0, 0).setName("Box 477")
		);
		wagon.add(new ModelRendererTurbo(wagon, 326, 104, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-118.5f, -29.5f, -18.5f).setRotationAngle(0, 0, 0).setName("Box 478")
		);
		wagon.add(new ModelRendererTurbo(wagon, 290, 44, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-117.5f, -29, -18).setRotationAngle(0, 0, 0).setName("Box 479")
		);
		wagon.add(new ModelRendererTurbo(wagon, 281, 44, textureX, textureY).addBox(0, 0, 0, 3, 3, 1)
			.setRotationPoint(-117.5f, -29, -17).setRotationAngle(0, 0, 0).setName("Box 480")
		);
		wagon.add(new ModelRendererTurbo(wagon, 420, 87, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-118.5f, -29.5f, 14.5f).setRotationAngle(0, 0, 0).setName("Box 481")
		);
		wagon.add(new ModelRendererTurbo(wagon, 40, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-117.5f, -29, 15).setRotationAngle(0, 0, 0).setName("Box 482")
		);
		wagon.add(new ModelRendererTurbo(wagon, 422, 39, textureX, textureY).addBox(0, 0, 0, 3, 3, 1)
			.setRotationPoint(-117.5f, -29, 16).setRotationAngle(0, 0, 0).setName("Box 483")
		);
		wagon.add(new ModelRendererTurbo(wagon, 40, 36, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-117.5f, -29, 17).setRotationAngle(0, 0, 0).setName("Box 484")
		);
		wagon.add(new ModelRendererTurbo(wagon, 326, 44, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-118.5f, -29.5f, 17.5f).setRotationAngle(0, 0, 0).setName("Box 485")
		);
		wagon.add(new ModelRendererTurbo(wagon, 324, 132, textureX, textureY).addBox(0, 0, 0, 1, 4, 2)
			.setRotationPoint(-118.5f, -29.5f, 15.5f).setRotationAngle(0, 0, 0).setName("Box 486")
		);
		wagon.add(new ModelRendererTurbo(wagon, 0, 0, textureX, textureY).addBox(0, 0, 0, 115, 3, 50)
			.setRotationPoint(0, -29, -25).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		this.groups.add(wagon);
		this.translate(0, 8, 0);
	}

}
