package net.fexcraft.mod.fvtm.util.handler;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.SwivelPointMover;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.attribute.Attribute.Type;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;

public class SPM_DI implements SwivelPointMover {
	
	private Attribute<?> attr;
	private String attribute;
	private float last, speed = 1, min, max, def;
	private int axe;
	private boolean pos, bool, loop;//, ret;
	public boolean moved;
	
	public SPM_DI(JsonObject obj){
		this(obj.get("attribute").getAsString(), obj.get("var").getAsString());
		speed = JsonUtil.getIfExists(obj, "speed", 1).floatValue();
		bool = JsonUtil.getIfExists(obj, "bool_based", false);
		min = JsonUtil.getIfExists(obj, "min", Integer.MIN_VALUE).floatValue();
		max = JsonUtil.getIfExists(obj, "max", Integer.MAX_VALUE).floatValue();
		def = JsonUtil.getIfExists(obj, "def", 0).floatValue();
		loop = JsonUtil.getIfExists(obj, "loop", false);
		//ret = JsonUtil.getIfExists(obj, "return", false);
	}
	
	public SPM_DI(String key, String value){
		attribute = key;
		switch(value){
			case "x":{
				axe = 0; pos = true;
				break;
			}
			case "y":{
				axe = 1; pos = true;
				break;
			}
			case "z":{
				axe = 2; pos = true;
				break;
			}
			case "yaw":{
				axe = 0; pos = false;
				break;
			}
			case "pitch":{
				axe = 1; pos = false;
				break;
			}
			case "roll":{
				axe = 2; pos = false;
				break;
			}
		}
	}

	public SPM_DI(String attr, String var, float speed){
		this(attr, var); this.speed = speed;
	}

	@Override
	public void update(VehicleEntity entity, SwivelPoint point){
		if(attr == null){
			attr = entity.getVehicleData().getAttribute(attribute);
			last = bool ? attr.getFloatValue() : def;
			move(point, axe, pos, last);
			//Print.bar(Minecraft.getMinecraft().player, get(point) + "=" + last);
		}
		if(bool){
			if(attr.type() == Type.TRISTATE){
				last += attr.getTriStateValue() == null ? 0 : attr.getBooleanValue() ? speed : -speed;
			}
			else{
				if(attr.getBooleanValue()) last += speed;
			}
			if(last > max){
				if(loop) last = min + (last - max);
				else last = max;
			}
			if(last < min){
				if(loop) last = max - (min - last);
				else last = min;
			}
			if(last == get(point)) return;
			move(point, axe, pos, last);
			return;
		}
		if(last != attr.getFloatValue()){
			//Print.bar(Minecraft.getMinecraft().player, last + "/" + attr.getFloatValue());
			float diff = attr.getFloatValue() - last;
			if(diff < 0.001 && diff > -0.001) return;
			if(Math.abs(diff) <= speed){
				move(point, axe, pos, last = attr.getFloatValue());
			}
			else{
				last += diff > 0 ? speed : -speed;
				move(point, axe, pos, last);
			}
			//point.updateClient(entity.getEntity());
		}
	}

	private void move(SwivelPoint point, int axe, boolean pos, float last){
		moved = true;
		if(pos){
			switch(axe){
				case 0:{//x
					point.setPos(last, point.getPos().y, point.getPos().z);
					return;
				}
				case 1:{//y
					point.setPos(point.getPos().x, last, point.getPos().z);
					return;
				}
				case 2:{//z
					point.setPos(point.getPos().x, point.getPos().y, last);
					return;
				}
			}
		}
		else{
			switch(axe){
				case 0:{//yaw
					point.getAxes().setAngles(last, point.getAxes().getPitch(), point.getAxes().getRoll());
					return;
				}
				case 1:{//pitch
					point.getAxes().setAngles(point.getAxes().getYaw(), last, point.getAxes().getRoll());
					return;
				}
				case 2:{//roll
					point.getAxes().setAngles(point.getAxes().getYaw(), point.getAxes().getPitch(), last);
					return;
				}
			}
		}
	}

	public double get(SwivelPoint point){//, int axe, boolean pos){
		if(pos){
			switch(axe){
				case 0: return point.getPos().x;
				case 1: return point.getPos().y;
				case 2: return point.getPos().z;
			}
		}
		else{
			switch(axe){
				case 0: return point.getAxes().getYaw();
				case 1: return point.getAxes().getPitch();
				case 2: return point.getAxes().getRoll();
			}
		}
		return 0;
	}

	@Override
	public SwivelPointMover clone(){
		return new SPM_DI(attribute, varString(), speed);
	}

	private String varString(){
		if(pos){
			switch(axe){
				case 0: return "x";
				case 1: return "y";
				case 2: return "z";
			}
		}
		else{
			switch(axe){
				case 0: return "yaw";
				case 1: return "pitch";
				case 2: return "roll";
			}
		}
		return "null";
	}

	@Override
	public boolean shouldSendPacket(){
		if(moved){
			moved = false;
			return true;
		}
		return false;
	}
}
