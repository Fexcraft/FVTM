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
	public void draw(Object gui, float ticks, int gl, int gt, int mx, int my){
		if(!visible) return;
		if(texture != null) ui.bindTexture(texture);
		rgb = enabled ? hovered ? hcolor : ecolor : dcolor;
		RGB.glColorReset();
		int u = enabled ? hovered ? htx : tx : dtx;
		int v = enabled ? hovered ? hty : ty : dty;
		rgb.glColorApply();
		if(absolute){
			UniUI uui = (UniUI)gui;
			uui.drawTexturedModalRect(x < 0 ? uui.width + x : x, y < 0 ? uui.height + y : y, u, v, width, height);
		}
		else{
			((UniUI)gui).drawTexturedModalRect(gl + x, gt + y, u, v, width, height);
		}
		RGB.glColorReset();
	}

}
