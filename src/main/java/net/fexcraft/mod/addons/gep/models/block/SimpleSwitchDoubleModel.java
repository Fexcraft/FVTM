//FMT-Marker FVTM-1.5
package net.fexcraft.mod.addons.gep.models.block;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.lib.tmt.RotationOrder;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.ConditionalPrograms;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter v1.5 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.6.5 &copy; 2021 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "gep:models/block/simple_switch_double")
public class SimpleSwitchDoubleModel extends BlockModel {

	public SimpleSwitchDoubleModel(){
		super(); textureX = 32; textureY = 32;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList base = new TurboList("base");
		base.add(new ModelRendererTurbo(base, 0, 6, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 1, 1, 1, null)
			.setRotationPoint(0, -1, 1).setRotationAngle(0, 0, -90)
		);
		base.add(new ModelRendererTurbo(base, 0, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 4, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -1, 0).setRotationAngle(0, 0, 0)
		);
		base.add(new ModelRendererTurbo(base, 0, 22, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 1, 1, 1, null)
			.setRotationPoint(0, -1, -3).setRotationAngle(0, 0, -90)
		);
		base.add(new ModelRendererTurbo(base, 0, 16, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 4, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -1, -4).setRotationAngle(0, 0, 0)
		);
		this.groups.add(base);
		//
		TurboList lever0 = new TurboList("lever0");
		lever0.add(new ModelRendererTurbo(lever0, 9, 6, textureX, textureY).addBox(-0.25f, -8, -0.25f, 0.5f, 8, 0.5f)
			.setRotationPoint(0, -1, 2).setRotationAngle(0, 0, 16)
		);
		lever0.addProgram(new ConditionalPrograms.SwitchDoubleStateSide(false, true)
			.add(new DefaultPrograms.RotationSetter(2, 20, 0, true))
			.addElse(new DefaultPrograms.RotationSetter(2, -20, 0, true)));
		this.groups.add(lever0);
		//
		TurboList sign0 = new TurboList("sign0");
		sign0.add(new ModelRendererTurbo(sign0, 14, 6, textureX, textureY).addBox(-0.2f, -11, -1.5f, 0.4f, 3, 3)
			.setRotationPoint(0, -1, 2).setRotationAngle(0, 0, 16).setRotationOrder(RotationOrder.ZYX)
		);
		sign0.add(new ModelRendererTurbo(sign0, 23, 6, textureX, textureY).addBox(-1.5f, -11, -0.2f, 3, 3, 0.4f)
			.setRotationPoint(0, -1, 2).setRotationAngle(0, 0, 16).setRotationOrder(RotationOrder.ZYX)
		);
		sign0.addPrograms(new ConditionalPrograms.SwitchDoubleStateSide(false, true)
			.add(new DefaultPrograms.RotationSetter(2, 20, 0, true))
			.add(new DefaultPrograms.RotationSetter(1, 90, 0, true))
			.addElse(new DefaultPrograms.RotationSetter(2, -20, 0, true)));
		this.groups.add(sign0);
		//
		TurboList lever1 = new TurboList("lever1");
		lever1.add(new ModelRendererTurbo(lever1, 9, 22, textureX, textureY).addBox(-0.25f, -8, -0.25f, 0.5f, 8, 0.5f)
			.setRotationPoint(0, -1, -2).setRotationAngle(0, 0, -16)
		);
		lever1.addProgram(new ConditionalPrograms.SwitchDoubleStateSide(true, true)
			.add(new DefaultPrograms.RotationSetter(2, 20, 0, true))
			.addElse(new DefaultPrograms.RotationSetter(2, -20, 0, true)));
		this.groups.add(lever1);
		//
		TurboList sign1 = new TurboList("sign1");
		sign1.add(new ModelRendererTurbo(sign1, 14, 22, textureX, textureY).addBox(-0.2f, -11, -1.5f, 0.4f, 3, 3)
			.setRotationPoint(0, -1, -2).setRotationAngle(0, 0, -16).setRotationOrder(RotationOrder.ZYX)
		);
		sign1.add(new ModelRendererTurbo(sign1, 23, 22, textureX, textureY).addBox(-1.5f, -11, -0.2f, 3, 3, 0.4f)
			.setRotationPoint(0, -1, -2).setRotationAngle(0, 0, -16).setRotationOrder(RotationOrder.ZYX)
		);
		sign1.addPrograms(new ConditionalPrograms.SwitchDoubleStateSide(true, true)
			.add(new DefaultPrograms.RotationSetter(2, 20, 0, true))
			.add(new DefaultPrograms.RotationSetter(1, 90, 0, true))
			.addElse(new DefaultPrograms.RotationSetter(2, -20, 0, true)));
		this.groups.add(sign1);
		//
	}

}
