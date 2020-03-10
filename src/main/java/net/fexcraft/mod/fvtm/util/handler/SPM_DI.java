package net.fexcraft.mod.fvtm.util.handler;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.SwivelPointMover;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;

public class SPM_DI implements SwivelPointMover {
	
	private Attribute<Float> attr;
	private String attribute;
	private float last;
	private int axe;
	private boolean pos;
	public boolean moved;
	
	public SPM_DI(JsonObject obj){
		this(obj.get("attribute").getAsString(), obj.get("var").getAsString());
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

	@SuppressWarnings("unchecked")
	@Override
	public void update(VehicleEntity entity, SwivelPoint point){
		if(attr == null){
			attr = (Attribute<Float>)entity.getVehicleData().getAttribute(attribute);
			last = attr.getValue();
			move(point, axe, pos, last);
			//Print.bar(Minecraft.getMinecraft().player, get(point) + "=" + last);
		}
		if(last != attr.getFloatValue()){
			//Print.bar(Minecraft.getMinecraft().player, last + "/" + attr.getFloatValue());
			move(point, axe, pos, last = attr.getFloatValue());
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
		return new SPM_DI(attribute, varString());
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
			return !(moved = false);
		}
		return false;
	}
}
