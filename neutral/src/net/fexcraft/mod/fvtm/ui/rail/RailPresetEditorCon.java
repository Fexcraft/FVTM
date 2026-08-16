package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailPresetEditorCon extends ContainerInterface {

	protected RailSystem sys;

	public RailPresetEditorCon(JsonMap map, UniEntity player, V3I vec){
		super(map, player, vec);
		sys = SystemManager.get(SystemManager.Systems.RAIL, player.entity.getWorld());
		if(sys == null) player.entity.closeUI();

	}

	@Override
	public Object get(String key, Object... objs){
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){

	}

}
