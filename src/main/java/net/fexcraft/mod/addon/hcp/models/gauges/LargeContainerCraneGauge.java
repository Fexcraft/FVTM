//FMT-Marker FVTM-1.3
package net.fexcraft.mod.addon.hcp.models.gauges;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.model.TurboList;

/** This file was exported via the FVTM Exporter V1.3 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.9 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/gauges/container_crane")
public class LargeContainerCraneGauge extends RailGaugeModel {

	public LargeContainerCraneGauge(){
		super(); textureX = 64; textureY = 32;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		this.ties_distance = 0.5f;
		this.buffer_length = 0.2f;
		Vec3f tr = new Vec3f(-0.5f, 0, 0), tl = new Vec3f(0.5f, 0, 0);
		Vec3f br = new Vec3f(0, -0.1f, 0), bl = new Vec3f(0, -0.1f, 0);
		this.addRailRectShape(Static.sixteenth, -183, 2, 2, 2, tr, tl, bl, br, true);
		this.addRailRectShape(Static.sixteenth, -175, 2, 2, 2, tr, tl, bl, br, true);
		this.groups.add(new TurboList("ties"));
	}

}
