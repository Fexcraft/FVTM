//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.hcp.scripts.CrusherScript;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockTileEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.fvtm.util.RenderCache;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/block/crusher")
public class CrusherModel extends BlockModel {
	
	private TurboList body, primary, rot, state;

	public CrusherModel(){
		super(); textureX = 512; textureY = 256;
		//
		TurboList chassis_body = new TurboList("chassis_body");
		chassis_body.add(new ModelRendererTurbo(chassis_body, 345, 1, textureX, textureY).addBox(0, 0, 0, 4, 48, 4)
			.setRotationPoint(-22, -48, -22).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 369, 1, textureX, textureY).addBox(0, 0, 0, 4, 48, 4)
			.setRotationPoint(-22, -48, 18).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 393, 1, textureX, textureY).addBox(0, 0, 0, 4, 48, 4)
			.setRotationPoint(18, -48, 18).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 417, 1, textureX, textureY).addBox(0, 0, 0, 4, 48, 4)
			.setRotationPoint(18, -48, -22).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 1, textureX, textureY).addBox(0, 0, 0, 2, 20, 2)
			.setRotationPoint(-8, -20, -8).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 17, 1, textureX, textureY).addBox(0, 0, 0, 2, 20, 2)
			.setRotationPoint(6, -20, -8).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 33, 1, textureX, textureY).addBox(0, 0, 0, 2, 20, 2)
			.setRotationPoint(6, -20, 6).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 57, 1, textureX, textureY).addBox(0, 0, 0, 2, 20, 2)
			.setRotationPoint(-8, -20, 6).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 73, 1, textureX, textureY).addBox(0, 0, 0, 15, 3, 3)
			.setRotationPoint(-9, -23, -9).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 97, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 15)
			.setRotationPoint(-9, -23, -6).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 449, 1, textureX, textureY).addBox(0, 0, 0, 3, 3, 15)
			.setRotationPoint(6, -23, -9).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 473, 1, textureX, textureY).addBox(0, 0, 0, 15, 3, 3)
			.setRotationPoint(-6, -23, 6).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 73, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -13, 0, 0, 13, 0, 0, 13, 0, 0, -13, 0, 0)
			.setRotationPoint(-22, -40, -7).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 473, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, -13, 0, 0, -13, 0, 0, 13, 0, 0)
			.setRotationPoint(20, -40, -7).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -13, 0, 0, -13, 0, 0, 13, 0, 0, 13)
			.setRotationPoint(-7, -40, -22).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 265, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 14, 4, 2, 0, 0, 0, -13, 0, 0, -13, 0, 0, 13, 0, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -40, 7).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 305, 25, textureX, textureY).addBox(0, 0, 0, 15, 3, 3)
			.setRotationPoint(-6, -36, 6).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 97, 25, textureX, textureY).addBox(0, 0, 0, 3, 3, 15)
			.setRotationPoint(6, -36, -9).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 33, textureX, textureY).addBox(0, 0, 0, 15, 3, 3)
			.setRotationPoint(-9, -36, -9).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 449, 25, textureX, textureY).addBox(0, 0, 0, 3, 3, 15)
			.setRotationPoint(-9, -36, -6).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 121, 1, textureX, textureY).addBox(0, 0, 0, 3, 10, 3)
			.setRotationPoint(-9, -33, -9).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 441, 1, textureX, textureY).addBox(0, 0, 0, 3, 10, 3)
			.setRotationPoint(6, -33, -9).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 73, 9, textureX, textureY).addBox(0, 0, 0, 3, 10, 3)
			.setRotationPoint(-9, -33, 6).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 497, 9, textureX, textureY).addBox(0, 0, 0, 3, 10, 3)
			.setRotationPoint(6, -33, 6).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -32.5f, -9).setRotationAngle(0, 0, 0).setName("Box 213")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 57, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -31.5f, -9).setRotationAngle(0, 0, 0).setName("Box 214")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 153, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -30.5f, -9).setRotationAngle(0, 0, 0).setName("Box 215")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 377, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -29.5f, -9).setRotationAngle(0, 0, 0).setName("Box 216")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 409, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -28.5f, -9).setRotationAngle(0, 0, 0).setName("Box 217")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 449, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -27.5f, -9).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 409, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -26.5f, -9).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 441, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -25.5f, -9).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 481, 105, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -24.5f, -9).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -32.5f, 8).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 113, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -31.5f, 8).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 145, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -30.5f, 8).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 177, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -29.5f, 8).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 209, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -28.5f, 8).setRotationAngle(0, 0, 0).setName("Box 226")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 361, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -27.5f, 8).setRotationAngle(0, 0, 0).setName("Box 227")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 393, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -26.5f, 8).setRotationAngle(0, 0, 0).setName("Box 228")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 425, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -25.5f, 8).setRotationAngle(0, 0, 0).setName("Box 229")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(-6, -24.5f, 8).setRotationAngle(0, 0, 0).setName("Box 230")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 57, 105, textureX, textureY).addBox(0, 0, 0, 0, 10, 12)
			.setRotationPoint(8, -33, -6).setRotationAngle(0, 0, 0).setName("Box 231")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 97, 105, textureX, textureY).addBox(0, 0, 0, 0, 10, 12)
			.setRotationPoint(-8, -33, -6).setRotationAngle(0, 0, 0).setName("Box 232")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 289, 105, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(0, -24, -9).setRotationAngle(0, 0, 0).setName("Box 233")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 225, 113, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(4, -24, -9).setRotationAngle(0, 0, 0).setName("Box 234")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 17, 121, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(-4, -24, -9).setRotationAngle(0, 0, 0).setName("Box 235")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 65, 121, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(-4, -28, -9).setRotationAngle(0, 0, 0).setName("Box 236")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 105, 121, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(0, -28, -9).setRotationAngle(0, 0, 0).setName("Box 237")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 145, 121, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(4, -28, -9).setRotationAngle(0, 0, 0).setName("Box 238")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 185, 121, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(4, -32, -9).setRotationAngle(0, 0, 0).setName("Box 239")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 249, 121, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(0, -32, -9).setRotationAngle(0, 0, 0).setName("Box 240")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 313, 121, textureX, textureY)
			.addShapeBox(-0.5f, -0.5f, 0, 1, 1, 18, 0, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f)
			.setRotationPoint(-4, -32, -9).setRotationAngle(0, 0, 0).setName("Box 241")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 337, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 1, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0)
			.setRotationPoint(7, -41, -22).setRotationAngle(0, 0, 0).setName("Box 242")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 401, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 1, 15, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0)
			.setRotationPoint(-22, -41, -22).setRotationAngle(0, 0, 0).setName("Box 243")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 449, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 1, 15, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-22, -41, 7).setRotationAngle(0, 0, 0).setName("Box 244")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 1, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 15, 1, 15, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(7, -41, 7).setRotationAngle(0, 0, 0).setName("Box 245")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 257, 145, textureX, textureY).addBox(0, 0, 0, 44, 2, 1)
			.setRotationPoint(-22, -18, 22).setRotationAngle(0, 0, 0).setName("Box 221")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 257, 145, textureX, textureY).addBox(0, 0, 0, 44, 2, 1)
			.setRotationPoint(-22, -18, -23).setRotationAngle(0, 0, 0).setName("Box 222")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 305, 145, textureX, textureY).addBox(0, 0, 0, 1, 2, 44)
			.setRotationPoint(-23, -18, -22).setRotationAngle(0, 0, 0).setName("Box 223")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 305, 145, textureX, textureY).addBox(0, 0, 0, 1, 2, 44)
			.setRotationPoint(22, -18, -22).setRotationAngle(0, 0, 0).setName("Box 224")
		);
		chassis_body.add(new ModelRendererTurbo(chassis_body, 305, 145, textureX, textureY).addBox(0, 0, 0, 1, 2, 44)
			.setRotationPoint(22, -18, -22).setRotationAngle(0, 0, 0).setName("Box 225")
		);
		this.groups.add(chassis_body); this.body = this.groups.get("chassis_body");
		//
		TurboList chassis_primary = new TurboList("chassis_primary");
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 1, 1, textureX, textureY).addBox(0, 0, 0, 2, 16, 44)
			.setRotationPoint(-24, -16, -22).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 97, 1, textureX, textureY).addBox(0, 0, 0, 2, 16, 44)
			.setRotationPoint(22, -16, -22).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 1, textureX, textureY).addBox(0, 0, 0, 44, 16, 2)
			.setRotationPoint(-22, -16, -24).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 249, 1, textureX, textureY).addBox(0, 0, 0, 44, 16, 2)
			.setRotationPoint(-22, -16, 22).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 393, 17, textureX, textureY).addBox(0, 0, 0, 2, 8, 44)
			.setRotationPoint(22, -48, -22).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 153, 25, textureX, textureY).addBox(0, 0, 0, 44, 8, 2)
			.setRotationPoint(-22, -48, -24).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 209, 25, textureX, textureY).addBox(0, 0, 0, 2, 8, 44)
			.setRotationPoint(-24, -48, -22).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis_primary.add(new ModelRendererTurbo(chassis_primary, 265, 57, textureX, textureY).addBox(0, 0, 0, 44, 8, 2)
			.setRotationPoint(-22, -48, 22).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis_primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(chassis_primary); this.primary = this.get("chassis_primary");
		//
		TurboList rotable_gears = new TurboList("rotable_gears");
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 265, 33, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(0, -24, -8).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 305, 33, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(0, -24, -8).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 473, 33, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(0, -24, -8).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 97, 9, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(0, -24, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 53")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 473, 9, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 55")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 57, 25, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(0, -24, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 65")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 121, 25, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(0, -24, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 66")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 449, 25, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 67")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 57, 33, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 68")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 73, 33, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 69")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 89, 33, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 70")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 121, 33, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 71")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 265, 33, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 72")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 289, 33, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 73")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 305, 33, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 74")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 329, 33, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 75")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 449, 33, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(0, -24, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 76")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 193, 41, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-4, -24, -8).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 217, 49, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(-4, -24, -8).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 345, 57, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-4, -24, -8).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 473, 33, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(-4, -24, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 80")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 497, 33, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 81")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 193, 41, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(-4, -24, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 82")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 217, 41, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(-4, -24, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 83")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 233, 41, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 84")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 265, 41, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 85")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 289, 41, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 86")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 305, 41, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 87")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 329, 41, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 88")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 497, 41, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 89")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 193, 49, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 90")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 217, 49, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 91")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 241, 49, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 92")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 449, 49, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(-4, -24, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 93")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 473, 57, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(4, -24, -8).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 1, 65, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(4, -24, -8).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 41, 65, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(4, -24, -8).setRotationAngle(0, 0, 0).setName("Box 96")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 241, 57, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(4, -24, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 97")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 369, 57, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 98")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 497, 57, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(4, -24, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 99")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 1, 65, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(4, -24, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 100")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 25, 65, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 101")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 41, 65, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 102")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 65, 65, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 103")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 81, 65, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 104")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 97, 65, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 105")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 113, 65, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 106")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 129, 65, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 107")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 145, 65, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 108")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 161, 65, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 109")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 177, 65, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(4, -24, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 110")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 177, 65, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(0, -28, -8).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 369, 65, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(0, -28, -8).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 65, 73, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(0, -28, -8).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 369, 65, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(0, -28, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 114")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 497, 65, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 115")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 1, 73, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(0, -28, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 116")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 25, 73, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(0, -28, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 117")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 41, 73, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 118")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 65, 73, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 119")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 89, 73, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 120")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 105, 73, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 121")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 121, 73, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 122")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 137, 73, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 123")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 153, 73, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 124")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 169, 73, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 125")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 305, 73, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 126")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 321, 73, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(0, -28, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 127")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 321, 73, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-4, -28, -8).setRotationAngle(0, 0, 0).setName("Box 128")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 393, 73, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(-4, -28, -8).setRotationAngle(0, 0, 0).setName("Box 129")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 433, 73, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-4, -28, -8).setRotationAngle(0, 0, 0).setName("Box 130")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 393, 73, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(-4, -28, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 131")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 417, 73, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 132")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 433, 73, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(-4, -28, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 133")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 457, 73, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(-4, -28, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 134")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 89, 81, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 135")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 105, 81, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 136")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 121, 81, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 137")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 137, 81, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 138")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 153, 81, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 139")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 217, 81, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 140")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 233, 81, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 141")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 249, 81, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 142")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 265, 81, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 143")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 281, 81, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(-4, -28, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 144")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 153, 81, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(4, -28, -8).setRotationAngle(0, 0, 0).setName("Box 145")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 281, 81, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(4, -28, -8).setRotationAngle(0, 0, 0).setName("Box 146")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 345, 81, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(4, -28, -8).setRotationAngle(0, 0, 0).setName("Box 147")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 305, 81, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(4, -28, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 148")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 321, 81, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 149")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 345, 81, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(4, -28, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 150")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 417, 81, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(4, -28, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 151")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 433, 81, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 152")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 457, 81, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 153")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 473, 81, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 154")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 489, 81, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 155")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 1, 89, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 156")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 17, 89, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 157")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 33, 89, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 158")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 49, 89, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 159")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 105, 89, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 160")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 121, 89, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(4, -28, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 161")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 121, 89, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(0, -32, -8).setRotationAngle(0, 0, 0).setName("Box 162")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 177, 89, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(0, -32, -8).setRotationAngle(0, 0, 0).setName("Box 163")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 217, 89, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(0, -32, -8).setRotationAngle(0, 0, 0).setName("Box 164")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 145, 89, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(0, -32, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 165")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 177, 89, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 166")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 201, 89, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(0, -32, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 167")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 217, 89, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(0, -32, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 168")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 241, 89, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 169")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 257, 89, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 170")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 273, 89, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 171")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 305, 89, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 172")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 369, 89, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 173")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 473, 89, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 174")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 489, 89, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 175")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 1, 97, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 176")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 17, 97, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 177")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 33, 97, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(0, -32, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 178")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 369, 89, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(-4, -32, -8).setRotationAngle(0, 0, 0).setName("Box 179")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 33, 97, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(-4, -32, -8).setRotationAngle(0, 0, 0).setName("Box 180")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 73, 97, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(-4, -32, -8).setRotationAngle(0, 0, 0).setName("Box 181")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 57, 97, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(-4, -32, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 182")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 73, 97, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 183")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 97, 97, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(-4, -32, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 184")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 113, 97, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(-4, -32, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 185")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 201, 97, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 186")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 217, 97, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 187")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 241, 97, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 188")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 257, 97, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 189")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 321, 97, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 190")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 393, 97, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 191")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 409, 97, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 192")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 425, 97, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 193")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 441, 97, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 194")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 457, 97, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(-4, -32, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 195")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 257, 97, textureX, textureY)
			.addShapeBox(0.5f, -1.5f, 0, 1, 3, 16, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0)
			.setRotationPoint(4, -32, -8).setRotationAngle(0, 0, 0).setName("Box 196")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 321, 97, textureX, textureY).addBox(-0.5f, -1.5f, 0, 1, 3, 16)
			.setRotationPoint(4, -32, -8).setRotationAngle(0, 0, 0).setName("Box 197")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 457, 97, textureX, textureY)
			.addShapeBox(-1.5f, -1.5f, 0, 1, 3, 16, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0)
			.setRotationPoint(4, -32, -8).setRotationAngle(0, 0, 0).setName("Box 198")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 481, 97, textureX, textureY).addBox(-0.5f, -1.8f, 1, 1, 1, 3)
			.setRotationPoint(4, -32, -8).setRotationAngle(0, 0, -0.7853982f).setName("Box 199")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 497, 97, textureX, textureY).addBox(-0.5f, -1.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 200")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 1, 105, textureX, textureY).addBox(-0.5f, -1.8f, 3, 1, 1, 3)
			.setRotationPoint(4, -32, -8).setRotationAngle(0, 0, -0.2617994f).setName("Box 201")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 17, 105, textureX, textureY).addBox(-0.5f, -1.8f, 5, 1, 1, 3)
			.setRotationPoint(4, -32, -8).setRotationAngle(0, 0, 0.2617994f).setName("Box 202")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 33, 105, textureX, textureY).addBox(-0.5f, -1.8f, 7, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 203")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 57, 105, textureX, textureY).addBox(-0.5f, -1.8f, 9, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 204")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 73, 105, textureX, textureY).addBox(-0.5f, -1.8f, 11, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 205")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 97, 105, textureX, textureY).addBox(-0.5f, 0.8f, 11, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 2.3561945f).setName("Box 206")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 161, 105, textureX, textureY).addBox(-0.5f, 0.8f, 9, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 1.8325957f).setName("Box 207")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 257, 105, textureX, textureY).addBox(-0.5f, 0.8f, 7, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 1.3089969f).setName("Box 208")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 281, 105, textureX, textureY).addBox(-0.5f, 0.8f, 5.5f, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 0.7853982f).setName("Box 209")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 297, 105, textureX, textureY).addBox(-0.5f, 0.8f, 4, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, 0.2617994f).setName("Box 210")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 313, 105, textureX, textureY).addBox(-0.5f, 0.8f, 2, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, -0.2617994f).setName("Box 211")
		);
		rotable_gears.add(new ModelRendererTurbo(rotable_gears, 345, 105, textureX, textureY).addBox(-0.5f, 0.8f, 0, 1, 1, 3)
			.setRotationPoint(4, -32, -7).setRotationAngle(0, 0, -0.7853982f).setName("Box 212")
		);
		this.groups.add(rotable_gears); this.rot = this.get("rotable_gears");
		//
		TurboList state = new TurboList("state");
		state.add(new ModelRendererTurbo(state, 25, 145, textureX, textureY).addBox(0, -0.5f, 0, 44, 1, 44)
			.setRotationPoint(-22, 0, -22).setRotationAngle(0, 0, 0).setName("Box 218")
		);
		state.add(new ModelRendererTurbo(state, 161, 145, textureX, textureY)
			.addShapeBox(0, -0.5f, 0, 12, 4, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0)
			.setRotationPoint(-6, -4, -6).setRotationAngle(0, 0, 0).setName("Box 219")
		);
		state.add(new ModelRendererTurbo(state, 217, 145, textureX, textureY)
			.addShapeBox(0, -0.5f, 0, 12, 4, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 0, 0, 4, 0, 0, 4)
			.setRotationPoint(-6, -4, -6).setRotationAngle(0, 0, 0).setName("Box 220")
		);
		this.groups.add(state); this.state = this.get("state");
	}
	
	@Override
	public void render(BlockData data, BlockTileEntity tile, VehicleEntity ent, int meta){
		body.render(null, null, null);
		primary.render(null, null, data, null);
		if(tile == null){
			rot.render(null, null, null);
		}
		else{
	    	float rotation = RenderCache.getData(tile.getLongPos(), "rot_state", 0) + 1;
	    	RenderCache.updateData(tile.getLongPos(), "rot_state", rotation > 360 ? 0 : rotation);
	    	for(ModelRendererTurbo turbo : rot){
	    		turbo.rotateAngleZ += net.fexcraft.lib.common.Static.rad1 * rotation;
	    		turbo.render();
	    		turbo.rotateAngleZ -= net.fexcraft.lib.common.Static.rad1 * rotation;
	    	}
		}
		//
		if(data.getScript() != null){
			GL11.glTranslated(0, data.getScript(CrusherScript.class).state * -0.065, 0);
		}
		state.render(null, null, null);
	}

}