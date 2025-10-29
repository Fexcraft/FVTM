package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ZHydSwivelPointMover implements SwivelPointMover {

	private SwivelPoint opoint;
	private SwivelPoint point;
	private String opoint_id;
	private V3D loff;
	private V3D toff;
	private V3D here;
	private V3D ther;
	private float ang;

	public ZHydSwivelPointMover(JsonMap map){
		opoint_id = map.getString("towards_point", null);
		loff = map.has("local_offset") ? ContentConfigUtil.getVector(map.getArray("local_offset")) : new V3D();
		toff = map.has("towards_offset") ? ContentConfigUtil.getVector(map.getArray("towards_offset")) : new V3D();
		ang = Static.toRadians(map.getFloat("add_angle", 0));
	}

	public ZHydSwivelPointMover(String point, V3D lo, V3D to, float an){
		opoint_id = point;
		loff = lo;
		toff = to;
		ang = an;
	}

	@Override
	public void update(VehicleInstance vehicle, SwivelPoint point){
		this.point = point;
		if(opoint_id == null) return;
		opoint = vehicle.data.getRotationPoint(opoint_id);
		if(opoint == null || opoint == point) return;
		here = point.getRelativeVector(loff);
		ther = opoint.getRelativeVector(toff).sub(here);
		point.getPivot().set_rot(-Math.atan2(ther.x, ther.z),
			Math.atan2(-Math.sqrt(ther.x * ther.x + ther.z * ther.z), ther.y) + ang,
			0, false);
	}

	@Override
	public SwivelPointMover clone(){
		return new ZHydSwivelPointMover(opoint_id, loff, toff, ang);
	}

	@Override
	public boolean shouldUpdate(){
		return point.getPrevPivot().yaw() != point.getPivot().yaw()
			|| point.getPrevPivot().pitch() != point.getPivot().pitch();
	}
}
