package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailPresetEditorCon extends ContainerInterface {

	protected RailSystem sys;
	protected StackWrapper stack;

	public RailPresetEditorCon(JsonMap map, UniEntity player, V3I vec){
		super(map, player, vec);
		sys = SystemManager.get(SystemManager.Systems.RAIL, player.entity.getWorld());
		if(sys == null) player.entity.closeUI();
		stack = player.entity.getHeldItem(true);
	}

	@Override
	public Object get(String key, Object... objs){
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(client){
			return;
		}
		switch(com.getString("task")){
			case "on":{
				stack.updateTag(tag -> {
					tag.set("fvtm:preset_mode", true);
					tag.set("fvtm:rail_preset", com.getInteger("sel"));
				});
				return;
			}
			case "off":{
				stack.updateTag(tag -> {
					tag.set("fvtm:preset_mode", false);
					//tag.rem("fvtm:rail_preset");
				});
				return;
			}
			case "sel":{
				int sel = com.getInteger("sel");
				stack.updateTag(tag -> {
					if(sel >= 0){
						tag.set("fvtm:preset_mode", true);
						tag.set("fvtm:rail_preset", sel);
					}
					else{
						tag.set("fvtm:preset_mode", false);
						//tag.rem("fvtm:rail_preset");
					}
				});
				return;
			}
		}
	}

}
