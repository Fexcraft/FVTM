package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.uni.inv.UniInventory;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmInventory {

	public final InvType type;
	public Object inventory;
	public Object invinfo;
	public String point;
	public V3D pos;

	public FvtmInventory(InvType type){
		this.type = type;
	}

	public FvtmInventory init(JsonMap map){
		switch(type){
			case ITEM:{
				UniInvInfo info = new UniInvInfo();
				info.rows = map.getInteger("rows", 3);
				info.cols = map.getInteger("cols", 9);
				UniInventory inv = UniInventory.create(info.rows * info.cols);
				if(map.has("filter")){
					//TODO
				}
				inventory = inv;
				invinfo = info;
				break;
			}
		}
		return this;
	}

	public UniInventory getItems(){
		return (UniInventory)inventory;
	}

	public static class UniInvInfo {

		public int rows;
		public int cols;

	}

}
