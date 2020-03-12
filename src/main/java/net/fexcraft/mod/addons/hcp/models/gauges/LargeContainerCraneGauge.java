//FMT-Marker FVTM-1.3
package net.fexcraft.mod.addons.hcp.models.gauges;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.entity.JunctionSwitchEntity;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.sys.rail.Junction;

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
		this.rails = new Vec3f[][]{
			{ new Vec3f(-174.5, 2, 0), new Vec3f(-173.5, 2, 0) },
			{ new Vec3f(-182.5, 2, 0), new Vec3f(-181.5, 2, 0) },
			{ new Vec3f(173.5, 2, 0), new Vec3f(174.5, 2, 0) },
			{ new Vec3f(181.5, 2, 0), new Vec3f(182.5, 2, 0) },
			//
			{ new Vec3f(-175, 0, 0), new Vec3f(-174.5, 2, 0) },
			{ new Vec3f(-173.5, 2, 0), new Vec3f(-173, 0, 0) },
			{ new Vec3f(-183, 0, 0), new Vec3f(-182.5, 2, 0) },
			{ new Vec3f(-181.5, 2, 0), new Vec3f(-181, 0, 0) },
			{ new Vec3f(173, 0, 0), new Vec3f(173.5, 2, 0) },
			{ new Vec3f(174.5, 2, 0), new Vec3f(175, 0, 0) },
			{ new Vec3f(181, 0, 0), new Vec3f(181.5, 2, 0) },
			{ new Vec3f(182.5, 2, 0), new Vec3f(183, 0, 0) },
			//
			{ new Vec3f(-175, 0, 0), new Vec3f(-173, 0, 0) },
			{ new Vec3f(-183, 0, 0), new Vec3f(-181, 0, 0) },
			{ new Vec3f(173, 0, 0), new Vec3f(175, 0, 0) },
			{ new Vec3f(181, 0, 0), new Vec3f(183, 0, 0) },
		};
		rail_tempcull = true;
		for(int i = 0; i < rails.length; i++){
			for(int j = 0; j < rails[i].length; j++){
				rails[i][j].xCoord /*= (179 - rails[i][j].xCoord) **/*= Static.sixteenth;
				rails[i][j].yCoord *= Static.sixteenth;
			}
		}
		this.groups.add(new TurboList("ties"));
	}
	
	@Override
	public void renderSwitch(JunctionSwitchEntity entity, Junction junction){
		return;
	}

}
