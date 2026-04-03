package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.entity.RailMarker;
import net.fexcraft.mod.fvtm.entity.RoadMarker;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmRenderState extends EntityRenderState {

	public RootVehicle entity;
	public RoadMarker road_marker;
	public RailMarker rail_marker;
	public DecorationEntity decoration;
	public VehicleInstance vehicle;
	public float f;

}
