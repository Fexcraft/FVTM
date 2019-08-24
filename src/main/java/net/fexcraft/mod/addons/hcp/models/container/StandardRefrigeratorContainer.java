//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.container;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.vehicle.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/container/medium_refrigerator")
public class StandardRefrigeratorContainer extends ContainerModel {

	public StandardRefrigeratorContainer(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList fan = new TurboList("fan");
		fan.add(new ModelRendererTurbo(fan, 113, 33, textureX, textureY).addBox(0, -1.5f, -0.5f, 7, 3, 1)
			.setRotationPoint(-44, -27.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		fan.add(new ModelRendererTurbo(fan, 97, 41, textureX, textureY)
			.addShapeBox(0, -1.5f, 0.5f, 7, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-44, -27.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		fan.add(new ModelRendererTurbo(fan, 121, 41, textureX, textureY)
			.addShapeBox(0, -1.5f, -1.5f, 7, 3, 1, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-44, -27.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		fan.add(new ModelRendererTurbo(fan, 145, 33, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		fan.add(new ModelRendererTurbo(fan, 145, 41, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-0.17453294f, 0, 0).setName("Box 15")
		);
		fan.add(new ModelRendererTurbo(fan, 233, 49, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-0.34906587f, 0, 0).setName("Box 16")
		);
		fan.add(new ModelRendererTurbo(fan, 249, 49, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-0.5235988f, 0, 0).setName("Box 17")
		);
		fan.add(new ModelRendererTurbo(fan, 265, 49, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-0.69813174f, 0, 0).setName("Box 18")
		);
		fan.add(new ModelRendererTurbo(fan, 281, 49, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-0.87266463f, 0, 0).setName("Box 19")
		);
		fan.add(new ModelRendererTurbo(fan, 297, 49, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-1.0471976f, 0, 0).setName("Box 20")
		);
		fan.add(new ModelRendererTurbo(fan, 329, 57, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-1.2217305f, 0, 0).setName("Box 21")
		);
		fan.add(new ModelRendererTurbo(fan, 345, 57, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-1.3962635f, 0, 0).setName("Box 22")
		);
		fan.add(new ModelRendererTurbo(fan, 1, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-1.5707964f, 0, 0).setName("Box 23")
		);
		fan.add(new ModelRendererTurbo(fan, 33, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-1.7453293f, 0, 0).setName("Box 24")
		);
		fan.add(new ModelRendererTurbo(fan, 57, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-1.9198622f, 0, 0).setName("Box 25")
		);
		fan.add(new ModelRendererTurbo(fan, 81, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-2.0943952f, 0, 0).setName("Box 26")
		);
		fan.add(new ModelRendererTurbo(fan, 329, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-2.268928f, 0, 0).setName("Box 27")
		);
		fan.add(new ModelRendererTurbo(fan, 345, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-2.443461f, 0, 0).setName("Box 28")
		);
		fan.add(new ModelRendererTurbo(fan, 425, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-2.6179938f, 0, 0).setName("Box 29")
		);
		fan.add(new ModelRendererTurbo(fan, 457, 65, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-2.792527f, 0, 0).setName("Box 30")
		);
		fan.add(new ModelRendererTurbo(fan, 1, 73, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(-2.9670596f, 0, 0).setName("Box 31")
		);
		fan.add(new ModelRendererTurbo(fan, 33, 73, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(0.17453294f, 0, 0).setName("Box 32")
		);
		fan.add(new ModelRendererTurbo(fan, 57, 73, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(0.34906587f, 0, 0).setName("Box 33")
		);
		fan.add(new ModelRendererTurbo(fan, 81, 73, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(0.5235988f, 0, 0).setName("Box 34")
		);
		fan.add(new ModelRendererTurbo(fan, 345, 73, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(0.69813174f, 0, 0).setName("Box 35")
		);
		fan.add(new ModelRendererTurbo(fan, 425, 73, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(0.87266463f, 0, 0).setName("Box 36")
		);
		fan.add(new ModelRendererTurbo(fan, 457, 73, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(1.0471976f, 0, 0).setName("Box 37")
		);
		fan.add(new ModelRendererTurbo(fan, 345, 81, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(1.2217305f, 0, 0).setName("Box 38")
		);
		fan.add(new ModelRendererTurbo(fan, 393, 89, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(1.3962635f, 0, 0).setName("Box 39")
		);
		fan.add(new ModelRendererTurbo(fan, 1, 97, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(1.5707964f, 0, 0).setName("Box 40")
		);
		fan.add(new ModelRendererTurbo(fan, 17, 97, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(1.7453293f, 0, 0).setName("Box 41")
		);
		fan.add(new ModelRendererTurbo(fan, 33, 97, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(1.9198622f, 0, 0).setName("Box 42")
		);
		fan.add(new ModelRendererTurbo(fan, 393, 97, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(2.0943952f, 0, 0).setName("Box 43")
		);
		fan.add(new ModelRendererTurbo(fan, 161, 105, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(2.268928f, 0, 0).setName("Box 44")
		);
		fan.add(new ModelRendererTurbo(fan, 177, 105, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(2.443461f, 0, 0).setName("Box 45")
		);
		fan.add(new ModelRendererTurbo(fan, 193, 105, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(2.6179938f, 0, 0).setName("Box 46")
		);
		fan.add(new ModelRendererTurbo(fan, 209, 105, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(2.792527f, 0, 0).setName("Box 47")
		);
		fan.add(new ModelRendererTurbo(fan, 225, 105, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(2.9670596f, 0, 0).setName("Box 48")
		);
		fan.add(new ModelRendererTurbo(fan, 241, 105, textureX, textureY)
			.addShapeBox(0, 1.5f, -0.5f, 5, 6, 1, 0, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 1, 0, -1.2f, -1, 0, -0.4f, -1, 0, -0.4f, 1, 0, 0.4f)
			.setRotationPoint(-43.5f, -27.5f, -1.5f).setRotationAngle(3.1415927f, 0, 0).setName("Box 49")
		);
		fan.addProgram(new TurboList.Program(){
			@Override
			public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
	            list.rotate(Static.rad1, 0, 0, false);
			}
			@Override
			public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
				//list.rotate(-Static.rad1, 0, 0, false);
			}
			@Override public String getId(){ return "hcp:refrigerator_container_fan"; }
		});
		this.groups.add(fan);
		//
		TurboList fan_cover = new TurboList("fan_cover");
		fan_cover.add(new ModelRendererTurbo(fan_cover, 33, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 16, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-47, -34.5f, -9.5f).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		fan_cover.add(new ModelRendererTurbo(fan_cover, 105, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 16, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-47, -31.5f, -9.5f).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		fan_cover.add(new ModelRendererTurbo(fan_cover, 249, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 16, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-47, -28.5f, -9.5f).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		fan_cover.add(new ModelRendererTurbo(fan_cover, 305, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 16, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-47, -25.5f, -9.5f).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		fan_cover.add(new ModelRendererTurbo(fan_cover, 361, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 16, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(-47, -22.5f, -9.5f).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		fan_cover.addProgram(new TurboList.Program(){
		    private RGB color = new RGB(128, 128, 128, 0.67f);
			@Override public String getId(){ return "hcp:refrigerator_container_fan_cover"; }
			@Override
			public void preRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
	            GlStateManager.pushMatrix();
	            GL11.glEnable(GL11.GL_BLEND);
	            GL11.glDepthMask(false);
	            GL11.glEnable(GL11.GL_ALPHA_TEST);
	            this.color.glColorApply();
			}
			@Override
			public void postRender(TurboList list, Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
	            RGB.glColorReset();
	            GL11.glDisable(GL11.GL_ALPHA_TEST);
	            GL11.glDepthMask(true);
	            GL11.glDisable(GL11.GL_BLEND);
	            GlStateManager.popMatrix();
			}
		});
		this.groups.add(fan_cover);
		//
		TurboList lights = new TurboList("lights");
		lights.add(new ModelRendererTurbo(lights, 1, 81, textureX, textureY).addBox(0, 0, 0, 1, 1, 3)
			.setRotationPoint(-44, -15.2f, 17).setRotationAngle(0, 0, 0.7853982f).setName("Box 55")
		);
		lights.add(new ModelRendererTurbo(lights, 81, 81, textureX, textureY).addBox(0, 0, 0, 1, 1, 3)
			.setRotationPoint(-44, -20.2f, 17).setRotationAngle(0, 0, 0.7853982f).setName("Box 56")
		);
		lights.addProgram(DefaultPrograms.ALWAYS_GLOW);
		this.groups.add(lights);
		//
		TurboList metal = new TurboList("metal");
		metal.add(new ModelRendererTurbo(metal, 137, 1, textureX, textureY)
			.addShapeBox(1.5f, -1.5f, 8, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 92")
		);
		metal.add(new ModelRendererTurbo(metal, 145, 1, textureX, textureY)
			.addShapeBox(1.5f, -1.5f, 18, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 93")
		);
		metal.add(new ModelRendererTurbo(metal, 153, 1, textureX, textureY)
			.addShapeBox(1.5f, 43.5f, 8, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 94")
		);
		metal.add(new ModelRendererTurbo(metal, 385, 17, textureX, textureY)
			.addShapeBox(1.5f, 43.5f, 18, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 95")
		);
		metal.add(new ModelRendererTurbo(metal, 393, 17, textureX, textureY)
			.addShapeBox(1.5f, -1.5f, -18, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 97")
		);
		metal.add(new ModelRendererTurbo(metal, 401, 17, textureX, textureY)
			.addShapeBox(1.5f, -1.5f, -8, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 98")
		);
		metal.add(new ModelRendererTurbo(metal, 417, 17, textureX, textureY)
			.addShapeBox(1.5f, 43.5f, -18, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 99")
		);
		metal.add(new ModelRendererTurbo(metal, 425, 17, textureX, textureY)
			.addShapeBox(1.5f, 43.5f, -8, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 100")
		);
		metal.add(new ModelRendererTurbo(metal, 433, 17, textureX, textureY)
			.addShapeBox(1.5f, 26.5f, -5, 1, 1, 1, 0, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 101")
		);
		metal.add(new ModelRendererTurbo(metal, 81, 25, textureX, textureY)
			.addShapeBox(1.5f, 1.5f, -18, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 102")
		);
		metal.add(new ModelRendererTurbo(metal, 89, 25, textureX, textureY)
			.addShapeBox(1.5f, 1.5f, 18, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 103")
		);
		metal.add(new ModelRendererTurbo(metal, 97, 25, textureX, textureY)
			.addShapeBox(1.5f, 1.5f, 8, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 104")
		);
		metal.add(new ModelRendererTurbo(metal, 105, 25, textureX, textureY)
			.addShapeBox(1.5f, 40.5f, -8, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 105")
		);
		metal.add(new ModelRendererTurbo(metal, 113, 25, textureX, textureY)
			.addShapeBox(1.5f, 40.5f, -18, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 106")
		);
		metal.add(new ModelRendererTurbo(metal, 121, 25, textureX, textureY)
			.addShapeBox(1.5f, 40.5f, 18, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 107")
		);
		metal.add(new ModelRendererTurbo(metal, 129, 25, textureX, textureY)
			.addShapeBox(1.5f, 40.5f, 8, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 108")
		);
		metal.add(new ModelRendererTurbo(metal, 25, 153, textureX, textureY)
			.addShapeBox(1.5f, 0, -8, 1, 46, 1, 0, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f)
			.setRotationPoint(46.5f, -47.5f, 22).setRotationAngle(0, 0, 0).setName("Box 109")
		);
		metal.add(new ModelRendererTurbo(metal, 33, 153, textureX, textureY)
			.addShapeBox(1.5f, 0, -18, 1, 46, 1, 0, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f)
			.setRotationPoint(46.5f, -47.5f, 22).setRotationAngle(0, 0, 0).setName("Box 110")
		);
		metal.add(new ModelRendererTurbo(metal, 441, 153, textureX, textureY)
			.addShapeBox(1.5f, 0, 18, 1, 46, 1, 0, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f)
			.setRotationPoint(46.5f, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 111")
		);
		metal.add(new ModelRendererTurbo(metal, 497, 193, textureX, textureY)
			.addShapeBox(1.5f, 0, 8, 1, 46, 1, 0, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f, 0, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, -0.6f, 0.4f, -0.2f, 0, 0.4f, -0.2f)
			.setRotationPoint(46.5f, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 112")
		);
		metal.add(new ModelRendererTurbo(metal, 129, 25, textureX, textureY)
			.addShapeBox(1.5f, 10, 2, 1, 1, 7, 0, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(46.5f, -29.5f, -22).setRotationAngle(0, 0, 0).setName("Box 113")
		);
		metal.add(new ModelRendererTurbo(metal, 385, 25, textureX, textureY)
			.addShapeBox(1.5f, 12, 12, 1, 1, 7, 0, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(46.5f, -29.5f, -22).setRotationAngle(0, 0, 0).setName("Box 114")
		);
		metal.add(new ModelRendererTurbo(metal, 417, 25, textureX, textureY)
			.addShapeBox(1.5f, 12, -18, 1, 1, 7, 0, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(46.5f, -29.5f, 22).setRotationAngle(0, 0, 0).setName("Box 115")
		);
		metal.add(new ModelRendererTurbo(metal, 81, 33, textureX, textureY)
			.addShapeBox(1.5f, 10, -8, 1, 1, 7, 0, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, -0.6f, -0.2f, -0.2f, 0, -0.2f, -0.2f)
			.setRotationPoint(46.5f, -29.5f, 22).setRotationAngle(0, 0, 0).setName("Box 116")
		);
		metal.add(new ModelRendererTurbo(metal, 145, 25, textureX, textureY)
			.addShapeBox(1.5f, 26.5f, -8, 1, 1, 1, 0, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 117")
		);
		metal.add(new ModelRendererTurbo(metal, 153, 25, textureX, textureY)
			.addShapeBox(1.5f, 28.5f, -18, 1, 1, 1, 0, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 118")
		);
		metal.add(new ModelRendererTurbo(metal, 385, 25, textureX, textureY)
			.addShapeBox(1.5f, 28.5f, 18, 1, 1, 1, 0, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 119")
		);
		metal.add(new ModelRendererTurbo(metal, 401, 25, textureX, textureY)
			.addShapeBox(1.5f, 26.5f, 8, 1, 1, 1, 0, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f, 0, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, -0.4f, 0.2f, 0.2f, 0, 0.2f, 0.2f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 120")
		);
		metal.add(new ModelRendererTurbo(metal, 433, 25, textureX, textureY)
			.addShapeBox(1.5f, 1.5f, -8, 1, 1, 1, 0, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f, 0, 0, 0.5f, -0.4f, 0, 0, -0.4f, 0, 0, 0, 0, 0.5f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 122")
		);
		metal.add(new ModelRendererTurbo(metal, 81, 33, textureX, textureY)
			.addShapeBox(1.5f, 28.5f, -15, 1, 1, 1, 0, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 123")
		);
		metal.add(new ModelRendererTurbo(metal, 97, 33, textureX, textureY)
			.addShapeBox(1.5f, 28.5f, 15, 1, 1, 1, 0, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 124")
		);
		metal.add(new ModelRendererTurbo(metal, 105, 33, textureX, textureY)
			.addShapeBox(1.5f, 26.5f, 5, 1, 1, 1, 0, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 125")
		);
		metal.add(new ModelRendererTurbo(metal, 57, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 10, 5, 16, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-47.5f, -19.5f, -9.5f).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		metal.add(new ModelRendererTurbo(metal, 385, 153, textureX, textureY).addBox(0, 0, 0, 4, 2, 8)
			.setRotationPoint(-43, -18, 11).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		metal.add(new ModelRendererTurbo(metal, 385, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 8, 0, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-43, -19, 11).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		metal.add(new ModelRendererTurbo(metal, 305, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, -1, 0, -1, -1, 0, -1)
			.setRotationPoint(-43, -16, 11).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		metal.add(new ModelRendererTurbo(metal, 321, 113, textureX, textureY).addBox(0, 0, 0, 4, 6, 2)
			.setRotationPoint(-43, -20, 9).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		metal.add(new ModelRendererTurbo(metal, 1, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 16, 12, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-45.5f, -35.5f, 8.5f).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		metal.add(new ModelRendererTurbo(metal, 329, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -12, -23.8f).setRotationAngle(0, 0, 0).setName("Box 67")
		);
		metal.add(new ModelRendererTurbo(metal, 385, 185, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -11.5f, -23.8f).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		metal.add(new ModelRendererTurbo(metal, 209, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -11, -23.8f).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		metal.add(new ModelRendererTurbo(metal, 337, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -10.5f, -23.8f).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		metal.add(new ModelRendererTurbo(metal, 385, 193, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -10, -23.8f).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		metal.add(new ModelRendererTurbo(metal, 1, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -9.5f, -23.8f).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		metal.add(new ModelRendererTurbo(metal, 209, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -9, -23.8f).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		metal.add(new ModelRendererTurbo(metal, 305, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -8.5f, -23.8f).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		metal.add(new ModelRendererTurbo(metal, 361, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -8, -23.8f).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		metal.add(new ModelRendererTurbo(metal, 393, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -7.5f, -23.8f).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		metal.add(new ModelRendererTurbo(metal, 89, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -7, -23.8f).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		metal.add(new ModelRendererTurbo(metal, 193, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -6.5f, -23.8f).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		metal.add(new ModelRendererTurbo(metal, 249, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -6, -23.8f).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		metal.add(new ModelRendererTurbo(metal, 281, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -5.5f, -23.8f).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		metal.add(new ModelRendererTurbo(metal, 313, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -5, -23.8f).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		metal.add(new ModelRendererTurbo(metal, 361, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -4.5f, -23.8f).setRotationAngle(0, 0, 0).setName("Box 82")
		);
		metal.add(new ModelRendererTurbo(metal, 417, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0, 0, -0.4f, 0)
			.setRotationPoint(-46, -4, -23.8f).setRotationAngle(0, 0, 0).setName("Box 83")
		);
		this.groups.add(metal);
		//
		TurboList primary = new TurboList("primary");
		primary.add(new ModelRendererTurbo(primary, 1, 1, textureX, textureY).addBox(0, 0, 0, 14, 12, 47)
			.setRotationPoint(-47.5f, -14.5f, -23.5f).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		primary.add(new ModelRendererTurbo(primary, 129, 1, textureX, textureY).addBox(0, 0, 0, 2, 3, 48)
			.setRotationPoint(46, -3, -24).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		primary.add(new ModelRendererTurbo(primary, 185, 1, textureX, textureY).addBox(0, 0, 0, 92, 1, 2)
			.setRotationPoint(-46, -1, 22).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		primary.add(new ModelRendererTurbo(primary, 329, 1, textureX, textureY).addBox(0, 0, 0, 2, 3, 48)
			.setRotationPoint(-48, -3, -24).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		primary.add(new ModelRendererTurbo(primary, 185, 9, textureX, textureY).addBox(0, 0, 0, 92, 1, 2)
			.setRotationPoint(-46, -1, -24).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		primary.add(new ModelRendererTurbo(primary, 185, 17, textureX, textureY).addBox(0, 0, 0, 92, 1, 2)
			.setRotationPoint(-46, -3, 22).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		primary.add(new ModelRendererTurbo(primary, 185, 25, textureX, textureY).addBox(0, 0, 0, 92, 1, 2)
			.setRotationPoint(-46, -3, -24).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		primary.add(new ModelRendererTurbo(primary, 81, 1, textureX, textureY).addBox(0, 0, 0, 24, 1, 2)
			.setRotationPoint(22, -2, -24).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 1, textureX, textureY).addBox(0, 0, 0, 24, 1, 2)
			.setRotationPoint(-46, -2, -24).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		primary.add(new ModelRendererTurbo(primary, 81, 9, textureX, textureY).addBox(0, 0, 0, 36, 1, 2)
			.setRotationPoint(-18, -2, -24).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		primary.add(new ModelRendererTurbo(primary, 441, 1, textureX, textureY).addBox(0, 0, 0, 24, 1, 2)
			.setRotationPoint(22, -2, 22).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 9, textureX, textureY).addBox(0, 0, 0, 24, 1, 2)
			.setRotationPoint(-46, -2, 22).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		primary.add(new ModelRendererTurbo(primary, 81, 17, textureX, textureY).addBox(0, 0, 0, 36, 1, 2)
			.setRotationPoint(-18, -2, 22).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		primary.add(new ModelRendererTurbo(primary, 81, 57, textureX, textureY).addBox(0, 0, 0, 92, 1, 44)
			.setRotationPoint(-46, -3, -22).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 1, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(46, -46, 22).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		primary.add(new ModelRendererTurbo(primary, 17, 1, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(46, -46, -24).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		primary.add(new ModelRendererTurbo(primary, 33, 1, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(-48, -46, -24).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		primary.add(new ModelRendererTurbo(primary, 161, 1, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(-48, -46, 22).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		primary.add(new ModelRendererTurbo(primary, 393, 9, textureX, textureY).addBox(0, 0, 0, 2, 2, 48)
			.setRotationPoint(-48, -48, -24).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		primary.add(new ModelRendererTurbo(primary, 313, 57, textureX, textureY).addBox(0, 0, 0, 2, 2, 48)
			.setRotationPoint(46, -48, -24).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		primary.add(new ModelRendererTurbo(primary, 185, 33, textureX, textureY).addBox(0, 0, 0, 92, 2, 2)
			.setRotationPoint(-46, -48, 22).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		primary.add(new ModelRendererTurbo(primary, 185, 41, textureX, textureY).addBox(0, 0, 0, 92, 2, 2)
			.setRotationPoint(-46, -48, -24).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 105, textureX, textureY).addBox(0, 0, 0, 78, 43, 1)
			.setRotationPoint(-32, -46, 22.5f).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		primary.add(new ModelRendererTurbo(primary, 161, 113, textureX, textureY).addBox(0, 0, 0, 78, 43, 1)
			.setRotationPoint(-32, -46, -23.5f).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 161, textureX, textureY).addBox(0, 0, 0, 78, 1, 44)
			.setRotationPoint(-32, -47.5f, -22).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		primary.add(new ModelRendererTurbo(primary, 377, 65, textureX, textureY).addBox(0, 0, 0, 1, 43, 44)
			.setRotationPoint(-33.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		primary.add(new ModelRendererTurbo(primary, 321, 113, textureX, textureY).addBox(0, 0, 0, 1, 44, 22)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		primary.add(new ModelRendererTurbo(primary, 449, 137, textureX, textureY).addBox(0, 0, -22, 1, 44, 22)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		primary.add(new ModelRendererTurbo(primary, 497, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(45, -46, 23).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		primary.add(new ModelRendererTurbo(primary, 505, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(39, -46, 23).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		primary.add(new ModelRendererTurbo(primary, 449, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(33, -46, 23).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		primary.add(new ModelRendererTurbo(primary, 457, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(27, -46, 23).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		primary.add(new ModelRendererTurbo(primary, 465, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(21, -46, 23).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		primary.add(new ModelRendererTurbo(primary, 473, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(15, -46, 23).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		primary.add(new ModelRendererTurbo(primary, 481, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -46, 23).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		primary.add(new ModelRendererTurbo(primary, 489, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -46, 23).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		primary.add(new ModelRendererTurbo(primary, 313, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-3, -46, 23).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		primary.add(new ModelRendererTurbo(primary, 321, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-9, -46, 23).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		primary.add(new ModelRendererTurbo(primary, 497, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-15, -46, 23).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		primary.add(new ModelRendererTurbo(primary, 505, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-21, -46, 23).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		primary.add(new ModelRendererTurbo(primary, 369, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-27, -46, 23).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		primary.add(new ModelRendererTurbo(primary, 377, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-32, -46, 23).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(45, -46, -24).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		primary.add(new ModelRendererTurbo(primary, 473, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(39, -46, -24).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		primary.add(new ModelRendererTurbo(primary, 481, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(33, -46, -24).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		primary.add(new ModelRendererTurbo(primary, 489, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(27, -46, -24).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		primary.add(new ModelRendererTurbo(primary, 497, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(21, -46, -24).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		primary.add(new ModelRendererTurbo(primary, 505, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(15, -46, -24).setRotationAngle(0, 0, 0).setName("Box 49")
		);
		primary.add(new ModelRendererTurbo(primary, 369, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(9, -46, -24).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		primary.add(new ModelRendererTurbo(primary, 481, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-3, -46, -24).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		primary.add(new ModelRendererTurbo(primary, 489, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-9, -46, -24).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		primary.add(new ModelRendererTurbo(primary, 497, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-15, -46, -24).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		primary.add(new ModelRendererTurbo(primary, 505, 145, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-21, -46, -24).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-27, -46, -24).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		primary.add(new ModelRendererTurbo(primary, 9, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(-32, -46, -24).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		primary.add(new ModelRendererTurbo(primary, 337, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(45, -48, -22).setRotationAngle(0, 0, 0).setName("Box 68")
		);
		primary.add(new ModelRendererTurbo(primary, 249, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(39, -48, -22).setRotationAngle(0, 0, 0).setName("Box 69")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(33, -48, -22).setRotationAngle(0, 0, 0).setName("Box 70")
		);
		primary.add(new ModelRendererTurbo(primary, 305, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(27, -48, -22).setRotationAngle(0, 0, 0).setName("Box 71")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(21, -48, -22).setRotationAngle(0, 0, 0).setName("Box 72")
		);
		primary.add(new ModelRendererTurbo(primary, 97, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(15, -48, -22).setRotationAngle(0, 0, 0).setName("Box 73")
		);
		primary.add(new ModelRendererTurbo(primary, 193, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(9, -48, -22).setRotationAngle(0, 0, 0).setName("Box 74")
		);
		primary.add(new ModelRendererTurbo(primary, 361, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(3, -48, -22).setRotationAngle(0, 0, 0).setName("Box 75")
		);
		primary.add(new ModelRendererTurbo(primary, 249, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-3, -48, -22).setRotationAngle(0, 0, 0).setName("Box 76")
		);
		primary.add(new ModelRendererTurbo(primary, 417, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-9, -48, -22).setRotationAngle(0, 0, 0).setName("Box 77")
		);
		primary.add(new ModelRendererTurbo(primary, 305, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-15, -48, -22).setRotationAngle(0, 0, 0).setName("Box 78")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-21, -48, -22).setRotationAngle(0, 0, 0).setName("Box 79")
		);
		primary.add(new ModelRendererTurbo(primary, 97, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-27, -48, -22).setRotationAngle(0, 0, 0).setName("Box 80")
		);
		primary.add(new ModelRendererTurbo(primary, 193, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 1, 44, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 0, -0.1f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-35, -48, -22).setRotationAngle(0, 0, 0).setName("Box 81")
		);
		primary.add(new ModelRendererTurbo(primary, 385, 17, textureX, textureY)
			.addShapeBox(1, 0, 0, 1, 5, 22, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 65, textureX, textureY)
			.addShapeBox(1, 37, 0, 1, 6, 22, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		primary.add(new ModelRendererTurbo(primary, 49, 65, textureX, textureY)
			.addShapeBox(1, 9, 0, 1, 10, 22, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		primary.add(new ModelRendererTurbo(primary, 425, 65, textureX, textureY)
			.addShapeBox(1, 23, 0, 1, 10, 22, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0)
			.setRotationPoint(46.5f, -46, -22).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		primary.add(new ModelRendererTurbo(primary, 313, 73, textureX, textureY)
			.addShapeBox(1, 0, -22, 1, 5, 22, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		primary.add(new ModelRendererTurbo(primary, 209, 161, textureX, textureY)
			.addShapeBox(1, 37, -22, 1, 6, 22, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		primary.add(new ModelRendererTurbo(primary, 241, 169, textureX, textureY)
			.addShapeBox(1, 9, -22, 1, 10, 22, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 209, textureX, textureY)
			.addShapeBox(1, 23, -22, 1, 10, 22, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0, 0, 1, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 1, 0)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 91")
		);
		primary.add(new ModelRendererTurbo(primary, 17, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 43, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, 0, -0.5f, 1, 0, -0.5f)
			.setRotationPoint(3, -46, -24).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		primary.add(new ModelRendererTurbo(primary, 417, 25, textureX, textureY)
			.addShapeBox(1.5f, 26.5f, -5, 1, 1, 1, 0, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f, 0, 0.5f, -0.1f, -0.4f, 0, -0.1f, -0.4f, 0, -0.1f, 0, 0.5f, -0.1f)
			.setRotationPoint(46.5f, -46, 22).setRotationAngle(0, 0, 0).setName("Box 121")
		);
		primary.add(new ModelRendererTurbo(primary, 473, 209, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(-34, -46, 22).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		primary.add(new ModelRendererTurbo(primary, 361, 257, textureX, textureY).addBox(0, 0, 0, 2, 2, 44)
			.setRotationPoint(-34, -48, -22).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		primary.add(new ModelRendererTurbo(primary, 457, 265, textureX, textureY).addBox(0, 0, 0, 2, 43, 2)
			.setRotationPoint(-34, -46, -24).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		primary.add(new ModelRendererTurbo(primary, 249, 297, textureX, textureY).addBox(0, 0, 0, 14, 12, 47)
			.setRotationPoint(-47.5f, -47.5f, -23.5f).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		primary.add(new ModelRendererTurbo(primary, 1, 305, textureX, textureY).addBox(0, 0, 0, 4, 21, 47)
			.setRotationPoint(-37.5f, -35.5f, -23.5f).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		primary.add(new ModelRendererTurbo(primary, 153, 209, textureX, textureY).addBox(0, 0, 0, 10, 21, 14)
			.setRotationPoint(-47.5f, -35.5f, -23.5f).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		primary.add(new ModelRendererTurbo(primary, 97, 65, textureX, textureY).addBox(0, 0, 0, 10, 21, 3)
			.setRotationPoint(-47.5f, -35.5f, 20.5f).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		primary.add(new ModelRendererTurbo(primary, 393, 65, textureX, textureY).addBox(0, 0, 0, 10, 21, 2)
			.setRotationPoint(-47.5f, -35.5f, 6.5f).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		primary.add(new ModelRendererTurbo(primary, 57, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-46, -48, -22).setRotationAngle(0, 0, 0).setName("Box 57")
		);
		primary.add(new ModelRendererTurbo(primary, 153, 305, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 1, 44, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0, 1, -0.5f, 0)
			.setRotationPoint(-41, -48, -22).setRotationAngle(0, 0, 0).setName("Box 58")
		);
		primary.add(new ModelRendererTurbo(primary, 97, 97, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-46, -7, 23).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		primary.add(new ModelRendererTurbo(primary, 257, 105, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-46, -13, 23).setRotationAngle(0, 0, 0).setName("Box 60")
		);
		primary.add(new ModelRendererTurbo(primary, 425, 105, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-46, -19, 23).setRotationAngle(0, 0, 0).setName("Box 61")
		);
		primary.add(new ModelRendererTurbo(primary, 41, 153, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-46, -25, 23).setRotationAngle(0, 0, 0).setName("Box 62")
		);
		primary.add(new ModelRendererTurbo(primary, 73, 153, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-46, -31, 23).setRotationAngle(0, 0, 0).setName("Box 63")
		);
		primary.add(new ModelRendererTurbo(primary, 105, 153, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-46, -37, 23).setRotationAngle(0, 0, 0).setName("Box 64")
		);
		primary.add(new ModelRendererTurbo(primary, 409, 153, textureX, textureY).addBox(0, 0, 0, 12, 1, 1)
			.setRotationPoint(-46, -43, 23).setRotationAngle(0, 0, 0).setName("Box 65")
		);
		primary.add(new ModelRendererTurbo(primary, 241, 161, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-46, -13, -24).setRotationAngle(0, 0, 0).setName("Box 66")
		);
		primary.add(new ModelRendererTurbo(primary, 89, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0)
			.setRotationPoint(-46, -23, -24).setRotationAngle(0, 0, 0).setName("Box 84")
		);
		primary.add(new ModelRendererTurbo(primary, 193, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0)
			.setRotationPoint(-46, -18, -24).setRotationAngle(0, 0, 0).setName("Box 85")
		);
		primary.add(new ModelRendererTurbo(primary, 249, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0)
			.setRotationPoint(-46, -28, -24).setRotationAngle(0, 0, 0).setName("Box 86")
		);
		primary.add(new ModelRendererTurbo(primary, 305, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0)
			.setRotationPoint(-46, -33, -24).setRotationAngle(0, 0, 0).setName("Box 87")
		);
		primary.add(new ModelRendererTurbo(primary, 361, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0)
			.setRotationPoint(-46, -46, -24).setRotationAngle(0, 0, 0).setName("Box 88")
		);
		primary.add(new ModelRendererTurbo(primary, 417, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0)
			.setRotationPoint(-46, -38, -24).setRotationAngle(0, 0, 0).setName("Box 89")
		);
		primary.add(new ModelRendererTurbo(primary, 89, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0)
			.setRotationPoint(-46, -42, -24).setRotationAngle(0, 0, 0).setName("Box 90")
		);
		primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(primary);
	}

}
