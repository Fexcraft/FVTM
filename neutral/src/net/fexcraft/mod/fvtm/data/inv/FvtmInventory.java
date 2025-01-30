package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.uni.inv.UniInventory;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmInventory {

	public final InvType type;
	public UniInventory inv_items;
	public Object inv_info;
	public String point;
	public V3D pos;

	public FvtmInventory(InvType type){
		this.type = type;
	}

	public FvtmInventory init(JsonMap map){
		switch(type){
			case VARIABLE:
			case ITEM:{
				UniInvInfo info = new UniInvInfo();
				info.rows = map.getInteger("rows", 1);
				info.cols = map.getInteger("cols", 1);
				inv_items = UniInventory.create(info.rows * info.cols);
				if(map.has("filter")){
					//TODO
				}
				inv_info = info;
				break;
			}
		}
		return this;
	}

	public UniInventory getItems(){
		return inv_items;
	}

	public static class UniInvInfo {

		public int rows;
		public int cols;

	}

}
