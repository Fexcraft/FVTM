package net.fexcraft.mod.uni.uimpl;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UUIButton extends UIButton {

	protected static RGB rgb;
	public String name;

	public UUIButton(UserInterface ui, JsonMap map) throws Exception {
		super(ui, map);
	}

	@Override
	public void draw(Object ui, float ticks, int mx, int my){
		if(!visible) return;
		rgb = enabled ? hovered ? hcolor : ecolor : dcolor;
		RGB.glColorReset();
		rgb.glColorApply();
		((UniUI)ui).drawTexturedModalRect(x, y, tx, ty, width, height);
		RGB.glColorReset();
	}

}
