package net.fexcraft.mod.fvtm.data.attribute;

import net.fexcraft.lib.common.math.V3D;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrBox {

	public final String id;
	public V3D pos;
	public String swivel_point;
	public float size, increase = 1, decrease = -1, reset = 0;

	public AttrBox(String id, String point, float[] data){
		this.swivel_point = point == null ? "vehicle" : point;
		this.id = id;
		pos = new V3D(data[0], data[1], data[2]);
		size = data[3] * 0.5f;
		if(data.length > 4){
			increase = data[4];
			decrease = data[5];
			reset = data[6];
		}
	}

	public AttrBox(String id, V3D pos, float size, float increase, float decrease, float reset, String swivel_point){
		this.swivel_point = swivel_point;
		this.id = id;
		this.pos = pos.copy();
		this.size = size;
		this.increase = increase;
		this.decrease = decrease;
		this.reset = reset;
	}

	public void copy(AttrBox from){
		swivel_point = from.swivel_point;
		pos = from.pos.copy();
		size = from.size;
		increase = from.increase;
		decrease = from.decrease;
		reset = from.reset;
	}

	public AttrBox copy(){
		return new AttrBox(id, pos, size, increase, decrease, reset, swivel_point);
	}
	
	@Override
	public String toString(){
		return String.format("ABx{%s, %s, %s, %s, %s, %s, %s}", id, pos, size, increase, decrease, reset, swivel_point);
	}

}
