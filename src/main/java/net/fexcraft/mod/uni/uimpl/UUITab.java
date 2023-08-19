package net.fexcraft.mod.uni.uimpl;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.uni.ui.UITab;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UUITab extends UITab {

	protected static RGB rgb;
	public String name;

	public UUITab(UserInterface ui, JsonMap map) throws Exception {
		super(ui, map);
	}

}
