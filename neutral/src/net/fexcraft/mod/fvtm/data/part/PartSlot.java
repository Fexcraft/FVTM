package net.fexcraft.mod.fvtm.data.part;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.fvtm.util.Rot;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartSlot {

	public static final float DEF_RADIUS = 0.25f;
	public final String type;
	public final V3D pos;
	public final float radius;
	public final Rot rotation;
	public final String swivel;

	public PartSlot(String key, JsonValue<?> value){
		if(value.isArray() && value.asArray().not_empty()){
			JsonArray array = value.asArray();
			pos = ContentConfigUtil.getVector(array);
			type = array.size() > 3 ? array.get(3).string_value() : key;
			radius = array.size() > 4 ? array.get(4).float_value() : DEF_RADIUS;
			rotation = array.size() > 5 ? new Rot(array.getArray(5)) : Rot.NULL;
			swivel = array.size() > 6 ? array.get(6).string_value() : SwivelPoint.DEFAULT;
		}
		else if(value.isMap()){
			JsonMap map = value.asMap();
			type = map.getString("type", key);
			pos = map.has("pos") ? ContentConfigUtil.getVector(map.getArray("pos")) : V3D.NULL;
			radius = map.getFloat("radius", DEF_RADIUS);
			rotation = map.has("rot") ? new Rot(map.getArray("rot")) : Rot.NULL;
			swivel = map.getString("point", SwivelPoint.DEFAULT);
		}
		else{
			type = value.isArray() ? key : value.string_value();
			pos = V3D.NULL;
			radius = DEF_RADIUS;
			rotation = Rot.NULL;
			swivel = SwivelPoint.DEFAULT;
		}
	}

}
