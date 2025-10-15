package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;

import static net.fexcraft.lib.common.Static.rad90;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PointingSwivelPointMover implements SwivelPointMover {

	private SwivelPoint opoint;
	private SwivelPoint point;
	private String opoint_id;
	private V3D loff;
	private V3D toff;
	private V3D here;
	private V3D ther;
	private V3D ang;

	public PointingSwivelPointMover(JsonMap map){
		opoint_id = map.getString("towards_point", null);
		loff = map.has("local_offset") ? ContentConfigUtil.getVector(map.getArray("local_offset")) : new V3D();
		toff = map.has("towards_offset") ? ContentConfigUtil.getVector(map.getArray("towards_offset")) : new V3D();
		ang = map.has("add_angle") ? ContentConfigUtil.getVector(map.getArray("add_angle")) : new V3D();
		ang.x = Static.toRadians(ang.x);
		ang.y = Static.toRadians(ang.y);
		ang.z = Static.toRadians(ang.z);
	}

	public PointingSwivelPointMover(String point, V3D lo, V3D to, V3D an){
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
		point.getPivot().set_yaw((float)(-Math.atan2(ther.z, ther.x) + ang.y) + vehicle.pivot().yaw() + rad90, false);
		point.getPivot().set_pitch((float)(Math.atan2(Math.sqrt(ther.x * ther.x + ther.z * ther.z), -ther.y) + ang.z) + vehicle.pivot().pitch(), false);
		point.getPivot().set_roll((float)ang.x, false);
	}

	@Override
	public SwivelPointMover clone(){
		return new PointingSwivelPointMover(opoint_id, loff, toff, ang);
	}

	@Override
	public boolean shouldUpdate(){
		return point.getPrevPivot().yaw() != point.getPivot().yaw()
			|| point.getPrevPivot().pitch() != point.getPivot().pitch()
			|| point.getPrevPivot().roll() != point.getPivot().roll();
	}
}
