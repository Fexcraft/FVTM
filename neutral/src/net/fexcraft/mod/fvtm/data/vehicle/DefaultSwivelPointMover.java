package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;

public class DefaultSwivelPointMover implements SwivelPointMover {
	
	private Attribute<?> attr;
	private String attribute;
	private float last, speed = 1, min, max, def;
	private int axe;
	private boolean pos, bool, loop;//, ret;
	public boolean moved;
	
	public DefaultSwivelPointMover(JsonMap map){
		this(map.get("attribute").string_value(), map.get("var").string_value());
		speed = map.getFloat("speed", 1);
		bool = map.getBoolean("bool_based", false);
		min = map.getFloat("min", Integer.MIN_VALUE);
		max = map.getFloat("max", Integer.MAX_VALUE);
		def = map.getFloat("def", 0);
		loop = map.getBoolean("loop", false);
		//ret = map.getBoolean("return", false);
	}
	
	public DefaultSwivelPointMover(String key, String value){
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

	public DefaultSwivelPointMover(String attr, String var, float speed, boolean bool, float min, float max, float def, boolean loop){
		this(attr, var);
		this.speed = speed;
		this.bool = bool;
		this.min = min;
		this.max = max;
		this.def = def;
		this.loop = loop;
	}

	@Override
	public void update(VehicleInstance vehicle, SwivelPoint point){
		if(attr == null){
			attr = vehicle.data.getAttribute(attribute);
			last = bool ? attr.asFloat() : def;
			move(point, axe, pos, last);
			//Print.bar(Minecraft.getMinecraft().player, get(point) + "=" + last);
		}
		if(bool){
			if(attr.valuetype.isTristate()){
				last += attr.tristate(0f, speed, -speed);
			}
			else{
				if(attr.asBoolean()) last += speed;
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
		if(last != attr.asFloat()){
			//Print.bar(Minecraft.getMinecraft().player, last + "/" + attr.getFloatValue());
			float diff = attr.asFloat() - last;
			if(diff < 0.001 && diff > -0.001) return;
			if(Math.abs(diff) <= speed){
				move(point, axe, pos, last = attr.asFloat());
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
					point.getPivot().set_rotation(last, point.getPivot().deg_pitch(), point.getPivot().deg_roll(), true);
					return;
				}
				case 1:{//pitch
					point.getPivot().set_rotation(point.getPivot().deg_yaw(), last, point.getPivot().deg_roll(), true);
					return;
				}
				case 2:{//roll
					point.getPivot().set_rotation(point.getPivot().deg_yaw(), point.getPivot().deg_pitch(), last, true);
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
				case 0: return point.getPivot().deg_yaw();
				case 1: return point.getPivot().deg_pitch();
				case 2: return point.getPivot().deg_roll();
			}
		}
		return 0;
	}

	@Override
	public SwivelPointMover clone(){
		return new DefaultSwivelPointMover(attribute, varString(), speed, bool, min, max, def, loop);
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
	public boolean shouldUpdate(){
		if(moved){
			moved = false;
			return true;
		}
		return false;
	}
}
