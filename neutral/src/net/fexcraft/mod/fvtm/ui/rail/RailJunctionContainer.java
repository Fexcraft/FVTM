package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.rail.JuncType;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.SignalType;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

import java.util.Collections;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailJunctionContainer extends ContainerInterface {

	protected RailSystem sys;
	protected Junction junc;

	public RailJunctionContainer(JsonMap map, UniEntity player, V3I vec){
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
		switch(key){
			case "":{
				//
				return null;
			}
		}
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(client){
			((RailJunction)ui).updateGrid();
			return;
		}
		String task = com.getString("task");
		switch(task){
			case "switch0":{
				if(junc.type.isFork3()){
					if(junc.switch0){
						junc.switch0 = false;
						junc.switch1 = true;
					}
					else if(junc.switch1){
						junc.switch0 = false;
						junc.switch1 = false;
					}
					else{
						junc.switch0 = true;
						junc.switch1 = false;
					}
				}
				else{
					junc.switch0 = !junc.switch0;
				}
				junc.updateClient();
				break;
			}
			case "switch1":{
				junc.switch1 = !junc.switch1;
				junc.updateClient();
				break;
			}
			case "type_2":{
				if(junc.size() < 4) break;
				junc.type = JuncType.FORK_3;
				junc.updateClient();
				break;
			}
			case "type_3":{
				if(junc.size() < 4) break;
				junc.type = JuncType.DOUBLE;
				junc.updateClient();
				break;
			}
			case "type_4":{
				if(junc.size() < 4) break;
				junc.type = JuncType.CROSSING;
				junc.updateClient();
				break;
			}
			case "down0":{
				move(0, 1);
				break;
			}
			case "down1":{
				move(1, 1);
				break;
			}
			case "down2":{
				move(2, 1);
				break;
			}
			case "up1":{
				move(1, -1);
				break;
			}
			case "up2":{
				move(2, -1);
				break;
			}
			case "up3":{
				move(3, -1);
				break;
			}
			case "rem0":{
				remove(0);
				break;
			}
			case "rem1":{
				remove(1);
				break;
			}
			case "rem2":{
				remove(2);
				break;
			}
			case "rem3":{
				remove(3);
				break;
			}
			case "signal_edit":{
				//
				break;
			}
			case "signal_remove":{
				junc.setSignal(SignalType.NONE, null);
				break;
			}
		}
		SEND_TO_CLIENT.accept(com, player);
	}

	private void move(int idx, int dir){
		if(idx < 0 || idx >= junc.size()) return;
		Collections.swap(junc.tracks, idx, idx + dir);
		junc.updateClient();
	}

	private void remove(int idx){
		if(idx >= junc.size()) return;
		junc.remove(idx, true);
	}

}
