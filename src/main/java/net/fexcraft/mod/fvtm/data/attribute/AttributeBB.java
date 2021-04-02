package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.data.SwivelPoint;

/**
 * Attribute Boundingbox
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class AttributeBB {

	public final String id;
	public String swivel_point;
	public Pos pos;
	public float size, increase, decrease, reset;

	public AttributeBB(String id, float[] data, String point){
		this.swivel_point = point == null ? SwivelPoint.DEFAULT : point;
		this.id = id;
		pos = new Pos(data[0], data[1], data[2]);
		size = data[3] * Static.sixteenth;
		if(data.length > 4){
			increase = data[4];
			decrease = data[5];
			reset = data[6];
		}
	}

	public AttributeBB(String id, Pos pos, float size, float increase, float decrease, float reset, String swivel_point){
		this.swivel_point = swivel_point;
		this.id = id;
		this.pos = pos.copy();
		this.size = size;
		this.increase = increase;
		this.decrease = decrease;
		this.reset = reset;
	}

	public void copy(AttributeBB from){
		swivel_point = from.swivel_point;
		pos = from.pos.copy();
		size = from.size;
		increase = from.increase;
		decrease = from.decrease;
		reset = from.reset;
	}

	public AttributeBB copy(){
		return new AttributeBB(id, pos, size, increase, decrease, reset, swivel_point);
	}

}
