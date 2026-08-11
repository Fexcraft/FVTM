package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JuncToolItem {

	public static boolean onUse(WorldW world, EntityW player, StackWrapper stack, QV3D vec){
		RailSystem sys = SystemManager.get(SystemManager.Systems.RAIL, world);
		if(sys == null){
			player.bar("item.fvtm.junction_tool.nosys");
			return false;
		}
		if(player.isShiftDown()){
			Junction junc = sys.getJunction(vec.pos);
			if(junc == null){
				player.bar("item.fvtm.junction_tool.nojunc");
			}
			else if(junc.size() > 0){
				junc.remove(junc.size() - 1, true);
				player.bar("item.fvtm.junction_tool.remtrack");
			}
			else{
				sys.delJunction(vec.pos);
				player.bar("item.fvtm.junction_tool.remjunc");
			}
			return true;
		}
		Junction junc = sys.getJunction(vec.pos, true);
		if(junc == null){
			player.bar("item.fvtm.junction_tool.nojunc");
			return true;
		}
		else{
			player.openUI(UIKeys.RAIL_JUNCTION, vec.pos);
			return true;
		}
	}

}
