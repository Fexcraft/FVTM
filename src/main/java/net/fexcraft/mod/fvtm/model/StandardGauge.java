package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

@fModel(registryname = "fvtm:models/gauges/standard")
public class StandardGauge extends RailGaugeModel {
	
	public StandardGauge(){
		super(); textureX = 128; textureY = 64;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		ties_distance = 0.5f;
		rails = new Vec3f[][]{
			{ new Vec3f(-1.0625, 0.375, 0), new Vec3f(-0.9375, 0.375, 0) },
			{ new Vec3f( 0.9375, 0.375, 0), new Vec3f( 1.0625, 0.375, 0) },
			//
			{ new Vec3f(-1.0625, 0.25, 0), new Vec3f(-1.0625, 0.375, 0) },
			{ new Vec3f(-0.9375, 0.375, 0), new Vec3f(-0.9375, 0.25, 0) },
			//
			{ new Vec3f(0.9375, 0.25, 0), new Vec3f(0.9375, 0.375, 0) },
			{ new Vec3f(1.0625, 0.375, 0), new Vec3f(1.0625, 0.25, 0) },
			//
			{ new Vec3f(-1.0625, 0.25, 0), new Vec3f(-0.9375, 0.25, 0) },
			{ new Vec3f(0.9375, 0.25, 0), new Vec3f(1.0625, 0.25, 0) }
		};
		TurboList ties = new TurboList("ties"); this.groups.add(ties);
		ties.add(new ModelRendererTurbo(ties, 0, 0, textureX, textureY).addBox(-2, 0, -20, 4, 2, 40)
			.setRotationPoint(0, -4, 0).setRotationAngle(0, 0, -0).setName("center_ties"));
	}
	
}