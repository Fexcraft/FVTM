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
@fModel(registryname = "zmp:models/part/dd28_engine")
public class DD28Engine extends PartModel {

	public DD28Engine(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("zackyboy18");
		//
		TurboList engine = new TurboList("engine");
		engine.add(new ModelRendererTurbo(engine, 41, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(70, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 299")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 300")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(78, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 301")
		);
		engine.add(new ModelRendererTurbo(engine, 505, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 302")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(66, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 182")
		);
		engine.add(new ModelRendererTurbo(engine, 433, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(62, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		engine.add(new ModelRendererTurbo(engine, 425, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 2, 4, 0, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60, -54, 0).setRotationAngle(0, 0, 0).setName("Box 200")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 2, 4, 0, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60, -54, -4).setRotationAngle(0, 0, 0).setName("Box 201")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 383")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 384")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(35, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 385")
		);
		engine.add(new ModelRendererTurbo(engine, 505, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 386")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 415")
		);
		engine.add(new ModelRendererTurbo(engine, 433, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(19, -54, -0.5f).setRotationAngle(0, 0, 0).setName("Box 416")
		);
		engine.add(new ModelRendererTurbo(engine, 425, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 2, 4, 0, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -54, 0).setRotationAngle(0, 0, 0).setName("Box 432")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 2, 4, 0, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -54, -4).setRotationAngle(0, 0, 0).setName("Box 433")
		);
		engine.add(new ModelRendererTurbo(engine, 313, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 5, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(48, -47, -3).setRotationAngle(0, 0, 0).setName("Box 370")
		);
		engine.add(new ModelRendererTurbo(engine, 513, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 54, 2, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(16, -41.5f, -9).setRotationAngle(0, 0, 0).setName("Box 160")
		);
		engine.add(new ModelRendererTurbo(engine, 249, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 7, 10, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -46, -5).setRotationAngle(0, 0, 0).setName("Box 379")
		);
		engine.add(new ModelRendererTurbo(engine, 929, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 6, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(17, -52, -4).setRotationAngle(0, 0, 0).setName("Box 380")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -42, -8).setRotationAngle(0, 0, 0).setName("Box 387")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(42.5f, -48, 2).setRotationAngle(0, 0, 0).setName("Box 392")
		);
		engine.add(new ModelRendererTurbo(engine, 521, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -46.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 396")
		);
		engine.add(new ModelRendererTurbo(engine, 577, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -46.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 397")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(46, -46.5f, 1.5f).setRotationAngle(0, 0, 0).setName("Box 398")
		);
		engine.add(new ModelRendererTurbo(engine, 953, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -43.5f, 5.5f).setRotationAngle(0, 0, 0).setName("Box 399")
		);
		engine.add(new ModelRendererTurbo(engine, 993, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -43.5f, 6.5f).setRotationAngle(0, 0, 0).setName("Box 400")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(46, -43.5f, 7.5f).setRotationAngle(0, 0, 0).setName("Box 401")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -52, 5).setRotationAngle(0, 0, 0).setName("Box 407")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -52, 5).setRotationAngle(0, 0, 0).setName("Box 408")
		);
		engine.add(new ModelRendererTurbo(engine, 1009, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 6, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6)
			.setRotationPoint(46, -46, -6).setRotationAngle(0, 0, 0).setName("Box 411")
		);
		engine.add(new ModelRendererTurbo(engine, 569, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -45.5f, 2.5f).setRotationAngle(0, 0, 0).setName("Box 412")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -52, 5).setRotationAngle(0, 0, 0).setName("Box 417")
		);
		engine.add(new ModelRendererTurbo(engine, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -53, 3).setRotationAngle(0, 0, 0).setName("Box 419")
		);
		engine.add(new ModelRendererTurbo(engine, 921, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 21, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -52.5f, 7).setRotationAngle(0, 0, 0).setName("Box 421")
		);
		engine.add(new ModelRendererTurbo(engine, 1001, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 6, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -47, -3).setRotationAngle(0, 0, 0).setName("Box 430")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2)
			.setRotationPoint(43, -52, -4).setRotationAngle(0, 0, 0).setName("Box 431")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -53, 1).setRotationAngle(0, 0, 0).setName("Box 434")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -53, -4).setRotationAngle(0, 0, 0).setName("Box 435")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(43, -47, -1).setRotationAngle(0, 0, 0).setName("Box 439")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -43, -7).setRotationAngle(0, 0, 0).setName("Box 446")
		);
		engine.add(new ModelRendererTurbo(engine, 953, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -43, -8).setRotationAngle(0, 0, 0).setName("Box 447")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -43, -6).setRotationAngle(0, 0, 0).setName("Box 450")
		);
		engine.add(new ModelRendererTurbo(engine, 17, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37.5f, -53.5f, -5).setRotationAngle(0, 0, 0).setName("Box 451")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37.5f, -53.5f, -6).setRotationAngle(0, 0, 0).setName("Box 452")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39.5f, -53.5f, -6).setRotationAngle(0, 0, 0).setName("Box 453")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(41.5f, -53.5f, -6).setRotationAngle(0, 0, 0).setName("Box 454")
		);
		engine.add(new ModelRendererTurbo(engine, 465, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(41.5f, -51.5f, -6).setRotationAngle(0, 0, 0).setName("Box 455")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39.5f, -51.5f, -6).setRotationAngle(0, 0, 0).setName("Box 456")
		);
		engine.add(new ModelRendererTurbo(engine, 521, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37.5f, -51.5f, -6).setRotationAngle(0, 0, 0).setName("Box 457")
		);
		engine.add(new ModelRendererTurbo(engine, 33, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39, -50, -5).setRotationAngle(0, 0, 0).setName("Box 465")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(37, -50, -7).setRotationAngle(0, 0, 0).setName("Box 466")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(37, -51, -7).setRotationAngle(0, 0, 0).setName("Box 467")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 19, 2, 1, 0, -2, -1, 0, -2, -1, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -48, -8).setRotationAngle(0, 0, 0).setName("Box 472")
		);
		engine.add(new ModelRendererTurbo(engine, 713, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 21, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -52, 5).setRotationAngle(0, 0, 0).setName("Box 487")
		);
		engine.add(new ModelRendererTurbo(engine, 1009, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39.5f, -43, -8).setRotationAngle(0, 0, 0).setName("Box 488")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39.5f, -43, -7).setRotationAngle(0, 0, 0).setName("Box 489")
		);
		engine.add(new ModelRendererTurbo(engine, 1009, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1)
			.setRotationPoint(39.5f, -43, -6).setRotationAngle(0, 0, 0).setName("Box 490")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40, -44, 5.5f).setRotationAngle(0, 0, 0).setName("Box 492")
		);
		engine.add(new ModelRendererTurbo(engine, 937, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40, -44, 4.5f).setRotationAngle(0, 0, 0).setName("Box 493")
		);
		engine.add(new ModelRendererTurbo(engine, 249, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 7, 10, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60, -46, -5).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		engine.add(new ModelRendererTurbo(engine, 929, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 6, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(60, -52, -4).setRotationAngle(0, 0, 0).setName("Box 295")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -52, 5).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(64, -50, 5).setRotationAngle(0, 0, 0).setName("Box 185")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(63, -50, 3).setRotationAngle(0, 0, 0).setName("Box 187")
		);
		engine.add(new ModelRendererTurbo(engine, 921, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 21, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(63, -52.5f, 7).setRotationAngle(0, 0, 0).setName("Box 188")
		);
		engine.add(new ModelRendererTurbo(engine, 17, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(83.5f, -39, 4).setRotationAngle(0, 0, 0).setName("Box 204")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(70, -41, -9).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		engine.add(new ModelRendererTurbo(engine, 881, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -45, -6).setRotationAngle(0, 0, 0).setName("Box 362")
		);
		engine.add(new ModelRendererTurbo(engine, 569, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(48, -42, -4).setRotationAngle(0, 0, 0).setName("Box 367")
		);
		engine.add(new ModelRendererTurbo(engine, 513, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(47, -44, -2).setRotationAngle(0, 0, 0).setName("Box 368")
		);
		engine.add(new ModelRendererTurbo(engine, 641, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 10, 0, 0, -1, -3, 0, 0, -2, 0, 0, -1, 0, -1, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(52, -46, -6).setRotationAngle(0, 0, 0).setName("Box 372")
		);
		engine.add(new ModelRendererTurbo(engine, 697, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 7, 0, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -48, -4).setRotationAngle(0, 0, 0).setName("Box 374")
		);
		engine.add(new ModelRendererTurbo(engine, 713, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 21, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(63, -52, 5).setRotationAngle(0, 0, 0).setName("Box 375")
		);
		engine.add(new ModelRendererTurbo(engine, 881, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(83, -44, 8.5f).setRotationAngle(0, 0, 0).setName("Box 324")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(83, -44, 5.5f).setRotationAngle(0, 0, 0).setName("Box 325")
		);
		engine.add(new ModelRendererTurbo(engine, 937, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(83, -44, 4.5f).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		engine.add(new ModelRendererTurbo(engine, 633, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(81.5f, -37, 7).setRotationAngle(0, 0, 0).setName("Box 327")
		);
		engine.add(new ModelRendererTurbo(engine, 665, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(81.5f, -37, 6).setRotationAngle(0, 0, 0).setName("Box 328")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(81.5f, -37, 5).setRotationAngle(0, 0, 0).setName("Box 329")
		);
		engine.add(new ModelRendererTurbo(engine, 961, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 1, 0, 0, -1, 0, 0, -1, 0, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(70, -41, -9).setRotationAngle(0, 0, 89).setName("Box 165")
		);
		engine.add(new ModelRendererTurbo(engine, 985, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(70, -41, -8).setRotationAngle(0, 0, 89).setName("Box 166")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, -1, -2, 0, -1, 0, 0, -1)
			.setRotationPoint(33, -36, -4).setRotationAngle(0, 0, 0).setName("Box 382")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(46, -43, 1).setRotationAngle(0, 0, 0).setName("Box 393")
		);
		engine.add(new ModelRendererTurbo(engine, 457, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -43, -3).setRotationAngle(0, 0, 0).setName("Box 394")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -43, -2).setRotationAngle(0, 0, 0).setName("Box 395")
		);
		engine.add(new ModelRendererTurbo(engine, 521, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -52.5f, 9).setRotationAngle(0, 0, 0).setName("Box 422")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(18, -52.5f, 7).setRotationAngle(0, 0, 0).setName("Box 423")
		);
		engine.add(new ModelRendererTurbo(engine, 993, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -50.5f, 7).setRotationAngle(0, 0, 0).setName("Box 424")
		);
		engine.add(new ModelRendererTurbo(engine, 465, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(18, -50.5f, 9).setRotationAngle(0, 0, 0).setName("Box 425")
		);
		engine.add(new ModelRendererTurbo(engine, 9, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -52.5f, 8).setRotationAngle(0, 0, 0).setName("Box 426")
		);
		engine.add(new ModelRendererTurbo(engine, 425, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -49.5f, 8).setRotationAngle(0, 0, 0).setName("Box 427")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -51.5f, 10).setRotationAngle(0, 0, 0).setName("Box 428")
		);
		engine.add(new ModelRendererTurbo(engine, 577, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -51.5f, 7).setRotationAngle(0, 0, 0).setName("Box 429")
		);
		engine.add(new ModelRendererTurbo(engine, 17, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40.5f, -39, 4).setRotationAngle(0, 0, 0).setName("Box 436")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40.5f, -40, -6).setRotationAngle(0, 0, 0).setName("Box 437")
		);
		engine.add(new ModelRendererTurbo(engine, 577, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(46, -43, -6).setRotationAngle(0, 0, 0).setName("Box 445")
		);
		engine.add(new ModelRendererTurbo(engine, 993, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -42, -7).setRotationAngle(0, 0, 0).setName("Box 448")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -43, -5.5f).setRotationAngle(0, 0, 0).setName("Box 475")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 7, 0, 0, -1, -2, 0, 0, -1, 0, 0, -2, 0, -1, -2, 0, 0, -1, 0, -1, 0, 0, -1, 0, 0, 0, -1)
			.setRotationPoint(9, -48, -4).setRotationAngle(0, 0, 0).setName("Box 483")
		);
		engine.add(new ModelRendererTurbo(engine, 633, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(38.5f, -37, 7).setRotationAngle(0, 0, 0).setName("Box 494")
		);
		engine.add(new ModelRendererTurbo(engine, 665, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38.5f, -37, 6).setRotationAngle(0, 0, 0).setName("Box 495")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(38.5f, -37, 5).setRotationAngle(0, 0, 0).setName("Box 496")
		);
		engine.add(new ModelRendererTurbo(engine, 433, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 9, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(34, -37.5f, -5).setRotationAngle(0, 0, 0).setName("Box 497")
		);
		engine.add(new ModelRendererTurbo(engine, 985, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(27, -41, -8).setRotationAngle(0, 0, 89).setName("Box 502")
		);
		engine.add(new ModelRendererTurbo(engine, 57, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, -1, 0, 0, -1, 0, 0, -1, -2, 0, -1)
			.setRotationPoint(17, -36, -4).setRotationAngle(0, 0, 0).setName("Box 503")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 7, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(48, -45, -4).setRotationAngle(0, 0, 0).setName("Box 369")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 7, 0, 0, -1, -2, 0, 0, -1, 0, 0, -2, 0, -1, -2, 0, 0, -1, 0, -1, 0, 0, -1, 0, 0, 0, -1)
			.setRotationPoint(52, -48, -4).setRotationAngle(0, 0, 0).setName("Box 371")
		);
		engine.add(new ModelRendererTurbo(engine, 913, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 54, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(16, -41.5f, -8).setRotationAngle(0, 0, 0).setName("Box 161")
		);
		engine.add(new ModelRendererTurbo(engine, 313, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(17, -39, -5).setRotationAngle(0, 0, 0).setName("Box 381")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -42, -9).setRotationAngle(0, 0, 0).setName("Box 388")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -41, -9).setRotationAngle(0, 0, 0).setName("Box 389")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(31, -41, -7).setRotationAngle(0, 0, 0).setName("Box 390")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -41, -8).setRotationAngle(0, 0, 0).setName("Box 391")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(28, -50, 3).setRotationAngle(0, 0, 0).setName("Box 402")
		);
		engine.add(new ModelRendererTurbo(engine, 17, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -50, 3).setRotationAngle(0, 0, 0).setName("Box 403")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(39, -50, 3).setRotationAngle(0, 0, 0).setName("Box 404")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(36, -50, 3).setRotationAngle(0, 0, 0).setName("Box 405")
		);
		engine.add(new ModelRendererTurbo(engine, 441, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(37, -50, 5).setRotationAngle(0, 0, 0).setName("Box 406")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(29, -50, 5).setRotationAngle(0, 0, 0).setName("Box 409")
		);
		engine.add(new ModelRendererTurbo(engine, 17, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2)
			.setRotationPoint(40.5f, -43, 4).setRotationAngle(0, 0, 0).setName("Box 410")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -42.5f, 6.5f).setRotationAngle(0, 0, 0).setName("Box 414")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(21, -50, 5).setRotationAngle(0, 0, 0).setName("Box 418")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(20, -50, 3).setRotationAngle(0, 0, 0).setName("Box 420")
		);
		engine.add(new ModelRendererTurbo(engine, 521, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(44, -44, -1).setRotationAngle(0, 0, 0).setName("Box 438")
		);
		engine.add(new ModelRendererTurbo(engine, 953, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -45.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 440")
		);
		engine.add(new ModelRendererTurbo(engine, 473, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 4, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -46, -7).setRotationAngle(0, 0, 0).setName("Box 458")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(17, -39, -7).setRotationAngle(0, 0, 0).setName("Box 459")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(28, -50, -5).setRotationAngle(0, 0, 0).setName("Box 460")
		);
		engine.add(new ModelRendererTurbo(engine, 441, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(23, -50, -5).setRotationAngle(0, 0, 0).setName("Box 461")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(20, -50, -5).setRotationAngle(0, 0, 0).setName("Box 462")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(31, -50, -5).setRotationAngle(0, 0, 0).setName("Box 463")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(36, -50, -5).setRotationAngle(0, 0, 0).setName("Box 464")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(29, -50, -7).setRotationAngle(0, 0, 0).setName("Box 468")
		);
		engine.add(new ModelRendererTurbo(engine, 441, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(29, -48, -7).setRotationAngle(0, 0, 0).setName("Box 469")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -50, -7).setRotationAngle(0, 0, 0).setName("Box 470")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(21, -48, -7).setRotationAngle(0, 0, 0).setName("Box 471")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -41, -9).setRotationAngle(0, 0, 0).setName("Box 473")
		);
		engine.add(new ModelRendererTurbo(engine, 881, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -45, -6).setRotationAngle(0, 0, 0).setName("Box 474")
		);
		engine.add(new ModelRendererTurbo(engine, 545, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(13, -42, -6).setRotationAngle(0, 0, 0).setName("Box 477")
		);
		engine.add(new ModelRendererTurbo(engine, 673, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 10, 0, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(13, -46, -6).setRotationAngle(0, 0, 0).setName("Box 485")
		);
		engine.add(new ModelRendererTurbo(engine, 697, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 7, 0, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(13, -48, -4).setRotationAngle(0, 0, 0).setName("Box 486")
		);
		engine.add(new ModelRendererTurbo(engine, 881, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(40, -44, 8.5f).setRotationAngle(0, 0, 0).setName("Box 491")
		);
		engine.add(new ModelRendererTurbo(engine, 513, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 2, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-1, -41.5f, -9).setRotationAngle(0, 0, 0).setName("Box 499")
		);
		engine.add(new ModelRendererTurbo(engine, 961, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 2, 1, 0, 0, -1, 0, 0, -1, 0, 1, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 1, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -41, -9).setRotationAngle(0, 0, 89).setName("Box 501")
		);
		engine.add(new ModelRendererTurbo(engine, 513, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 10, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -2, 0, 0, -2, 0, 0, -1, 0, -1, -1)
			.setRotationPoint(9, -42, -6).setRotationAngle(0, 0, 0).setName("Box 476")
		);
		engine.add(new ModelRendererTurbo(engine, 313, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 5, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -47, -3).setRotationAngle(0, 0, 0).setName("Box 482")
		);
		engine.add(new ModelRendererTurbo(engine, 641, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 10, 0, 0, -1, -3, 0, 0, -2, 0, 0, -1, 0, -1, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.setRotationPoint(9, -46, -6).setRotationAngle(0, 0, 0).setName("Box 484")
		);
		engine.add(new ModelRendererTurbo(engine, 713, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(19, -35.5f, -5).setRotationAngle(0, 0, 0).setName("Box 498")
		);
		engine.add(new ModelRendererTurbo(engine, 913, 137, textureX, textureY)
			.addShapeBox(0, 0, 0, 17, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-1, -41.5f, -8).setRotationAngle(0, 0, 0).setName("Box 500")
		);
		engine.add(new ModelRendererTurbo(engine, 489, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -40, -3.5f).setRotationAngle(0, 0, 0).setName("Box 478")
		);
		engine.add(new ModelRendererTurbo(engine, 569, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 2, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -42, -4).setRotationAngle(0, 0, 0).setName("Box 479")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 7, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -45, -4).setRotationAngle(0, 0, 0).setName("Box 481")
		);
		engine.add(new ModelRendererTurbo(engine, 513, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(4, -44, -2).setRotationAngle(0, 0, 0).setName("Box 480")
		);
		engine.add(new ModelRendererTurbo(engine, 521, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(87, -44, -1).setRotationAngle(0, 0, 0).setName("Box 208")
		);
		engine.add(new ModelRendererTurbo(engine, 953, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -43, -8).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		engine.add(new ModelRendererTurbo(engine, 993, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(88, -42, -7).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60, -39, -7).setRotationAngle(0, 0, 0).setName("Box 229")
		);
		engine.add(new ModelRendererTurbo(engine, 713, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(62, -35.5f, -5).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -2, 0, -1, -2, 0, -1, 0, 0, -1)
			.setRotationPoint(76, -36, -4).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -3, 0, 0, -3, 0, 0, -3, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(85.5f, -48, 2).setRotationAngle(0, 0, 0).setName("Box 317")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(89, -43, 1).setRotationAngle(0, 0, 0).setName("Box 326")
		);
		engine.add(new ModelRendererTurbo(engine, 457, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -43, -3).setRotationAngle(0, 0, 0).setName("Box 330")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -43, -2).setRotationAngle(0, 0, 0).setName("Box 331")
		);
		engine.add(new ModelRendererTurbo(engine, 521, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -46.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 333")
		);
		engine.add(new ModelRendererTurbo(engine, 577, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -46.5f, -0.5f).setRotationAngle(0, 0, 0).setName("Box 334")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(89, -46.5f, 1.5f).setRotationAngle(0, 0, 0).setName("Box 335")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -50, 3).setRotationAngle(0, 0, 0).setName("Box 345")
		);
		engine.add(new ModelRendererTurbo(engine, 441, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(80, -50, 5).setRotationAngle(0, 0, 0).setName("Box 348")
		);
		engine.add(new ModelRendererTurbo(engine, 1009, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 6, 0, 0, 0, -6, 0, 0, -6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6, 0, 0, -6)
			.setRotationPoint(89, -46, -6).setRotationAngle(0, 0, 0).setName("Box 131")
		);
		engine.add(new ModelRendererTurbo(engine, 569, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -45.5f, 2.5f).setRotationAngle(0, 0, 0).setName("Box 132")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -41, 8).setRotationAngle(0, 0, 0).setName("Box 133")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(86, -53, 1).setRotationAngle(0, 0, 0).setName("Box 202")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 3, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(86, -53, -4).setRotationAngle(0, 0, 0).setName("Box 203")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(83.5f, -40, -6).setRotationAngle(0, 0, 0).setName("Box 206")
		);
		engine.add(new ModelRendererTurbo(engine, 953, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(88, -45.5f, 0.5f).setRotationAngle(0, 0, 0).setName("Box 210")
		);
		engine.add(new ModelRendererTurbo(engine, 577, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(89, -43, -6).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -43, -7).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		engine.add(new ModelRendererTurbo(engine, 993, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -41, 1).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -43, -6).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(80.5f, -53.5f, -6).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82.5f, -53.5f, -6).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(84.5f, -53.5f, -6).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		engine.add(new ModelRendererTurbo(engine, 465, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(84.5f, -51.5f, -6).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82.5f, -51.5f, -6).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		engine.add(new ModelRendererTurbo(engine, 521, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(80.5f, -51.5f, -6).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		engine.add(new ModelRendererTurbo(engine, 473, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 7, 4, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(60, -46, -7).setRotationAngle(0, 0, 0).setName("Box 228")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(80, -50, -7).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(80, -51, -7).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		engine.add(new ModelRendererTurbo(engine, 441, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(72, -48, -7).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -50, -7).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(64, -48, -7).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 19, 2, 1, 0, -2, -1, 0, -2, -1, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(64, -48, -8).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -43, -5.5f).setRotationAngle(0, 0, 0).setName("Box 363")
		);
		engine.add(new ModelRendererTurbo(engine, 545, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(56, -42, -6).setRotationAngle(0, 0, 0).setName("Box 365")
		);
		engine.add(new ModelRendererTurbo(engine, 1009, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82.5f, -43, -8).setRotationAngle(0, 0, 0).setName("Box 321")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82.5f, -43, -7).setRotationAngle(0, 0, 0).setName("Box 322")
		);
		engine.add(new ModelRendererTurbo(engine, 1009, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 6, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1)
			.setRotationPoint(82.5f, -43, -6).setRotationAngle(0, 0, 0).setName("Box 323")
		);
		engine.add(new ModelRendererTurbo(engine, 433, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 1, 9, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(77, -37.5f, -5).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		engine.add(new ModelRendererTurbo(engine, 57, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, -1, 0, 0, -1, 0, 0, -1, -2, 0, -1)
			.setRotationPoint(60, -36, -4).setRotationAngle(0, 0, 0).setName("Box 183")
		);
		engine.add(new ModelRendererTurbo(engine, 313, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 26, 3, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1)
			.setRotationPoint(60, -39, -5).setRotationAngle(0, 0, 0).setName("Box 297")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -42, -8).setRotationAngle(0, 0, 0).setName("Box 303")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -42, -9).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -41, -9).setRotationAngle(0, 0, 0).setName("Box 305")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0)
			.setRotationPoint(74, -41, -7).setRotationAngle(0, 0, 0).setName("Box 306")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -41, -8).setRotationAngle(0, 0, 0).setName("Box 307")
		);
		engine.add(new ModelRendererTurbo(engine, 953, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -43.5f, 5.5f).setRotationAngle(0, 0, 0).setName("Box 336")
		);
		engine.add(new ModelRendererTurbo(engine, 993, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -43.5f, 6.5f).setRotationAngle(0, 0, 0).setName("Box 337")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(89, -43.5f, 7.5f).setRotationAngle(0, 0, 0).setName("Box 338")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(71, -50, 3).setRotationAngle(0, 0, 0).setName("Box 341")
		);
		engine.add(new ModelRendererTurbo(engine, 17, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -50, 3).setRotationAngle(0, 0, 0).setName("Box 342")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(79, -50, 3).setRotationAngle(0, 0, 0).setName("Box 346")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(80, -52, 5).setRotationAngle(0, 0, 0).setName("Box 349")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(72, -52, 5).setRotationAngle(0, 0, 0).setName("Box 350")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0)
			.setRotationPoint(72, -50, 5).setRotationAngle(0, 0, 0).setName("Box 351")
		);
		engine.add(new ModelRendererTurbo(engine, 17, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2)
			.setRotationPoint(83.5f, -43, 4).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(88, -42.5f, 6.5f).setRotationAngle(0, 0, 0).setName("Box 184")
		);
		engine.add(new ModelRendererTurbo(engine, 441, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0)
			.setRotationPoint(66, -53, 3).setRotationAngle(0, 0, 0).setName("Box 186")
		);
		engine.add(new ModelRendererTurbo(engine, 521, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -52.5f, 9).setRotationAngle(0, 0, 0).setName("Box 189")
		);
		engine.add(new ModelRendererTurbo(engine, 617, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(61, -52.5f, 7).setRotationAngle(0, 0, 0).setName("Box 190")
		);
		engine.add(new ModelRendererTurbo(engine, 993, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -50.5f, 7).setRotationAngle(0, 0, 0).setName("Box 191")
		);
		engine.add(new ModelRendererTurbo(engine, 465, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(61, -50.5f, 9).setRotationAngle(0, 0, 0).setName("Box 192")
		);
		engine.add(new ModelRendererTurbo(engine, 9, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -52.5f, 8).setRotationAngle(0, 0, 0).setName("Box 193")
		);
		engine.add(new ModelRendererTurbo(engine, 425, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -49.5f, 8).setRotationAngle(0, 0, 0).setName("Box 194")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -51.5f, 10).setRotationAngle(0, 0, 0).setName("Box 195")
		);
		engine.add(new ModelRendererTurbo(engine, 577, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(61, -51.5f, 7).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		engine.add(new ModelRendererTurbo(engine, 1001, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 6, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(86, -47, -3).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2)
			.setRotationPoint(86, -52, -4).setRotationAngle(0, 0, 0).setName("Box 199")
		);
		engine.add(new ModelRendererTurbo(engine, 393, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(86, -47, -1).setRotationAngle(0, 0, 0).setName("Box 209")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(89, -37, 7).setRotationAngle(0, 0, 0).setName("Box 211")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -37, 6).setRotationAngle(0, 0, 0).setName("Box 212")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(89, -37, 5).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(88, -36, 6).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		engine.add(new ModelRendererTurbo(engine, 17, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 5, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(80.5f, -53.5f, -5).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		engine.add(new ModelRendererTurbo(engine, 417, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(71, -50, -5).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		engine.add(new ModelRendererTurbo(engine, 441, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(66, -50, -5).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		engine.add(new ModelRendererTurbo(engine, 497, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(63, -50, -5).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		engine.add(new ModelRendererTurbo(engine, 593, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(74, -50, -5).setRotationAngle(0, 0, 0).setName("Box 233")
		);
		engine.add(new ModelRendererTurbo(engine, 969, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(79, -50, -5).setRotationAngle(0, 0, 0).setName("Box 234")
		);
		engine.add(new ModelRendererTurbo(engine, 33, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 2, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -50, -5).setRotationAngle(0, 0, 0).setName("Box 235")
		);
		engine.add(new ModelRendererTurbo(engine, 409, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 2, 2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(72, -50, -7).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		engine.add(new ModelRendererTurbo(engine, 513, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 3, 10, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, -2, 0, 0, -2, 0, 0, -1, 0, -1, -1)
			.setRotationPoint(52, -42, -6).setRotationAngle(0, 0, 0).setName("Box 364")
		);
		engine.add(new ModelRendererTurbo(engine, 489, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(48, -40, -3.5f).setRotationAngle(0, 0, 0).setName("Box 366")
		);
		engine.add(new ModelRendererTurbo(engine, 673, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 10, 0, 0, 0, -2, 0, 0, -2, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(56, -46, -6).setRotationAngle(0, 0, 0).setName("Box 373")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -41, 8).setRotationAngle(0, 0, 0).setName("Box 413")
		);
		engine.add(new ModelRendererTurbo(engine, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(46, -37, 7).setRotationAngle(0, 0, 0).setName("Box 441")
		);
		engine.add(new ModelRendererTurbo(engine, 41, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -37, 6).setRotationAngle(0, 0, 0).setName("Box 442")
		);
		engine.add(new ModelRendererTurbo(engine, 377, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -37, 5).setRotationAngle(0, 0, 0).setName("Box 443")
		);
		engine.add(new ModelRendererTurbo(engine, 481, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -36, 6).setRotationAngle(0, 0, 0).setName("Box 444")
		);
		engine.add(new ModelRendererTurbo(engine, 993, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(46, -41, 1).setRotationAngle(0, 0, 0).setName("Box 449")
		);
		this.groups.add(engine);
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
