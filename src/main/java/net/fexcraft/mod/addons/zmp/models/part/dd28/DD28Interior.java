//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.zmp.models.part.dd28;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "zmp:models/part/dd28_interior")
public class DD28Interior extends PartModel {

	public DD28Interior(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("zackyboy18");
		//
		TurboList interior = new TurboList("interior");
		interior.add(new ModelRendererTurbo(interior, 663, 101, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 8, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-33, -62, -15).setRotationAngle(0, 0, 0).setName("Box 1422")
		);
		interior.add(new ModelRendererTurbo(interior, 393, 90, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-33, -53, -15).setRotationAngle(0, 0, 0).setName("Box 1423")
		);
		interior.add(new ModelRendererTurbo(interior, 989, 61, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 2, 0, -3, 0, 0, 3, 0, 0, 2, 0, 0, -2, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-36, -53, -7).setRotationAngle(0, 0, 0).setName("Box 1429")
		);
		interior.add(new ModelRendererTurbo(interior, 331, 30, textureX, textureY).addBox(0, 0, 0, 9, 1, 8)
			.setRotationPoint(-44, -46, -15).setRotationAngle(0, 0, 0).setName("Box 1431")
		);
		interior.add(new ModelRendererTurbo(interior, 434, 22, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-44, -46, -7).setRotationAngle(0, 0, 0).setName("Box 1433")
		);
		interior.add(new ModelRendererTurbo(interior, 185, 54, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 8, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(-45, -46, -15).setRotationAngle(0, 0, 0).setName("Box 1434")
		);
		interior.add(new ModelRendererTurbo(interior, 507, 35, textureX, textureY).addBox(0, 0, 0, 8, 2, 8)
			.setRotationPoint(-43, -45, -15).setRotationAngle(0, 0, 0).setName("Box 1435")
		);
		interior.add(new ModelRendererTurbo(interior, 410, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 1, 0, 3, 0, 0, -3, 0, 0, -3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-42, -53, -5).setRotationAngle(0, 0, 0).setName("Box 1455")
		);
		interior.add(new ModelRendererTurbo(interior, 453, 12, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45, -55, -5).setRotationAngle(0, 0, 0).setName("Box 1456")
		);
		interior.add(new ModelRendererTurbo(interior, 251, 0, textureX, textureY).addBox(0, 0, 0, 1, 0, 2)
			.setRotationPoint(-45.5f, -54, -5).setRotationAngle(0, 0, 0).setName("Box 1457")
		);
		interior.add(new ModelRendererTurbo(interior, 38, 0, textureX, textureY).addBox(0, 0, 0, 1, 0, 2)
			.setRotationPoint(-47.5f, -54, -18).setRotationAngle(0, 0, 0).setName("Box 1458")
		);
		interior.add(new ModelRendererTurbo(interior, 283, 45, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 10, 1, 0, 5, 0, 0, -5, 0, 0, -5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-42, -53, -18).setRotationAngle(0, 0, 0).setName("Box 1459")
		);
		interior.add(new ModelRendererTurbo(interior, 501, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 1, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-47, -55, -18).setRotationAngle(0, 0, 0).setName("Box 1460")
		);
		interior.add(new ModelRendererTurbo(interior, 704, 101, textureX, textureY).addBox(0, 0, 0, 4, 9, 10)
			.setRotationPoint(-53, -52, -19).setRotationAngle(0, 0, 0).setName("Box 1461")
		);
		interior.add(new ModelRendererTurbo(interior, 554, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 9, 6, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, -52, -9).setRotationAngle(0, 0, 0).setName("Box 1462")
		);
		interior.add(new ModelRendererTurbo(interior, 203, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 6, 0, 0, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, -54, -9).setRotationAngle(0, 0, 0).setName("Box 1463")
		);
		interior.add(new ModelRendererTurbo(interior, 413, 59, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 6, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -1, 0, 0, 1, 0, 0, 3, 0, 0, -3, 0, 0)
			.setRotationPoint(-52.5f, -58.5f, -9).setRotationAngle(0, 0, 0).setName("Box 1464")
		);
		interior.add(new ModelRendererTurbo(interior, 77, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 6, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, -54.5f, -10).setRotationAngle(0, 0, 0).setName("Box 1465")
		);
		interior.add(new ModelRendererTurbo(interior, 183, 27, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 10, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-53, -54, -19).setRotationAngle(0, 0, 0).setName("Box 1466")
		);
		interior.add(new ModelRendererTurbo(interior, 974, 34, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 3, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(-52.5f, -58.5f, -12).setRotationAngle(0, 0, 0).setName("Box 1467")
		);
		interior.add(new ModelRendererTurbo(interior, 621, 0, textureX, textureY).addBox(0, 0, 0, 1, 5, 0)
			.setRotationPoint(-52.5f, -58.5f, -12).setRotationAngle(0, 0, 0).setName("Box 1468")
		);
		interior.add(new ModelRendererTurbo(interior, 431, 68, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 2, 0, -2, -1, 0, 2, -1, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(-34, -62, -17).setRotationAngle(0, 0, 0).setName("Box 1425")
		);
		interior.add(new ModelRendererTurbo(interior, 572, 62, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 2, 0, -3, 0, 0, 3, 0, 0, 2, -1, 0, -2, -1, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-34, -62, -7).setRotationAngle(0, 0, 0).setName("Box 1426")
		);
		interior.add(new ModelRendererTurbo(interior, 211, 62, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 2, 0, -2, 0, 0, 2, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(-36, -53, -17).setRotationAngle(0, 0, 0).setName("Box 1428")
		);
		interior.add(new ModelRendererTurbo(interior, 456, 22, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 1, 2, 0, -2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -46, -17).setRotationAngle(0, 0, 0).setName("Box 1432")
		);
		interior.add(new ModelRendererTurbo(interior, 361, 29, textureX, textureY).addBox(0, 0, 0, 9, 1, 8)
			.setRotationPoint(-44, -46, 8).setRotationAngle(0, 0, 0).setName("Box 1445")
		);
		interior.add(new ModelRendererTurbo(interior, 7, 38, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 8, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2)
			.setRotationPoint(-45, -46, 8).setRotationAngle(0, 0, 0).setName("Box 1446")
		);
		interior.add(new ModelRendererTurbo(interior, 577, 21, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 1, 2, 0, -2, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -46, 6).setRotationAngle(0, 0, 0).setName("Box 1447")
		);
		interior.add(new ModelRendererTurbo(interior, 989, 51, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 2, 0, -2, 0, 0, 2, 0, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(-36, -53, 6).setRotationAngle(0, 0, 0).setName("Box 1448")
		);
		interior.add(new ModelRendererTurbo(interior, 1004, 77, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, -2, 0, 0, -2, 0, 0, 2, 0, 0)
			.setRotationPoint(-33, -53, 8).setRotationAngle(0, 0, 0).setName("Box 1449")
		);
		interior.add(new ModelRendererTurbo(interior, 952, 76, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 8, 0, -2, 0, 0, 2, 0, 0, 2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-33, -62, 8).setRotationAngle(0, 0, 0).setName("Box 1452")
		);
		interior.add(new ModelRendererTurbo(interior, 1003, 58, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 2, 0, -2, -1, 0, 2, -1, 0, 3, 0, 0, -3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -1, 0, 0)
			.setRotationPoint(-34, -62, 6).setRotationAngle(0, 0, 0).setName("Box 1453")
		);
		interior.add(new ModelRendererTurbo(interior, 393, 30, textureX, textureY).addBox(0, 0, 0, 8, 2, 8)
			.setRotationPoint(-44, -45, 8).setRotationAngle(0, 0, 0).setName("Box 1454")
		);
		interior.add(new ModelRendererTurbo(interior, 109, 22, textureX, textureY)
			.addShapeBox(0, 0, 0, 9, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0)
			.setRotationPoint(-44, -46, 16).setRotationAngle(0, 0, 0).setName("Box 1444")
		);
		interior.add(new ModelRendererTurbo(interior, 235, 39, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 2, 0, -3, 0, 0, 3, 0, 0, 2, 0, 0, -2, 0, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-36, -53, 16).setRotationAngle(0, 0, 0).setName("Box 1450")
		);
		interior.add(new ModelRendererTurbo(interior, 427, 59, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 9, 2, 0, -3, 0, 0, 3, 0, 0, 2, -1, 0, -2, -1, 0, -1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-34, -62, 16).setRotationAngle(0, 0, 0).setName("Box 1451")
		);
		this.groups.add(interior);
		this.translate(0, 8, 0);
	}
	
	@Override
	public void render(VehicleData data, String key){
		GL11.glRotatef(180f, 0, 1, 0);
		super.render(data, key);
		GL11.glRotatef(-180f, 0, 1, 0);
	}

	@Override
	public void render(VehicleData data, String key, VehicleEntity ent, int meta){
		GL11.glRotatef(180f, 0, 1, 0);
		super.render(data, key, ent, meta);
		GL11.glRotatef(-180f, 0, 1, 0);
	}

}
