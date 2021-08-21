package net.fexcraft.mod.addon.gep.models.block;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;

/** Based on the Signal30 but lowered to ground.
 * 
 * @author Ferdinand (FEX___96)
 */
@fModel(registryname = "gep:models/block/signal_30_low")
public class Signal30Low extends BlockModel {

	public Signal30Low(){
		super(); textureX = 128; textureY = 64;
		this.addToCreators("Ferdinand (FEX___96)");
	    gui_scale_x = gui_scale_y = gui_scale_z = 0.5f;
		//
	    TurboList simple_signal_base = new TurboList("simple_signal_base");
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 101, 0, textureX, textureY).addBox(0, 0, 0, 6, 12, 5)
			.setRotationPoint(-3, -62, -2.5f).setRotationAngle(0, 0, 0)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 82, 0, textureX, textureY).addHollowCylinder(0, 0, 0, 2.125f, 2, 2, 16, 8, 1, 1, 1, null)
			.setRotationPoint(0, -53, -4).setRotationAngle(0, 0, -90)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 72, 0, textureX, textureY).addHollowCylinder(0, 0, 0, 2.125f, 2, 2, 16, 8, 1, 1, 1, null)
			.setRotationPoint(0, -59, -4).setRotationAngle(0, 0, -90)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 54, 15, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 0.9375f, 0.9375f, 1, null)
			.setRotationPoint(0, -59, -2.75f).setRotationAngle(0, 0, 0)
		);
		simple_signal_base.add(new ModelRendererTurbo(simple_signal_base, 63, 15, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 0.9375f, 0.9375f, 1, null)
			.setRotationPoint(0, -53, -2.75f).setRotationAngle(0, 0, 0)
		);
		this.groups.add(simple_signal_base);
		//
		TurboList simple_signal_stop = new TurboList("simple_signal_stop");
		simple_signal_stop.add(new ModelRendererTurbo(simple_signal_stop, 54, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 1, 1, 1, null)
			.setRotationPoint(0, -59, -3).setRotationAngle(0, 0, 0)
		);
		simple_signal_stop.addProgram(DefaultPrograms.BASIC_SIGNAL_STOP);
		this.groups.add(simple_signal_stop);
		//
		TurboList simple_signal_clear = new TurboList("simple_signal_clear");
		simple_signal_clear.add(new ModelRendererTurbo(simple_signal_clear, 63, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 1, 1, 1, null)
			.setRotationPoint(0, -53, -3).setRotationAngle(0, 0, 0)
		);
		simple_signal_clear.addProgram(DefaultPrograms.BASIC_SIGNAL_CLEAR);
		this.groups.add(simple_signal_clear);
		this.translate(0, 50, 0);
	}

}