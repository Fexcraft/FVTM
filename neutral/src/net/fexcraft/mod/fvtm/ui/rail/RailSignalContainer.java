package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.SignalType;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailSignalContainer extends ContainerInterface {

	protected RailSystem sys;
	protected Junction junc;

	public RailSignalContainer(JsonMap map, UniEntity player, V3I vec){
		super(map, player, vec);
		sys = SystemManager.get(SystemManager.Systems.RAIL, player.entity.getWorld());
		if(sys == null) player.entity.closeUI();
		junc = sys.getJunction(vec);
		if(junc == null){
			player.entity.send("junction.not.found");
			player.entity.closeUI();
		}
	}

	@Override
	public Object get(String key, Object... objs){
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(client) return;
		String task = com.getString("task");
		switch(task){
			case "status0":{
				if(junc.sigtype0.auto()) return;
				junc.signal0 = !junc.signal0;
				junc.sendSigState();
				break;
			}
			case "status1":{
				if(junc.sigtype1.auto()) return;
				junc.signal1 = !junc.signal1;
				junc.sendSigState();
				break;
			}
			case "auto0":{
				junc.setSignal(SignalType.AUTOMATIC, false);
				break;
			}
			case "auto1":{
				junc.setSignal(SignalType.AUTOMATIC, true);
				break;
			}
			case "con0":{
				junc.setSignal(SignalType.CONTROLLED, false);
				break;
			}
			case "con1":{
				junc.setSignal(SignalType.CONTROLLED, true);
				break;
			}
			case "remove0":{
				junc.setSignal(SignalType.NONE, false);
				break;
			}
			case "remove1":{
				junc.setSignal(SignalType.NONE, true);
				break;
			}
		}
		//SEND_TO_CLIENT.accept(com, player);
	}

}
