package net.fexcraft.mod.uni.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;

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
	public void draw(Object gui, UIElement root, float ticks, int gl, int gt, int mx, int my){
		if(!visible) return;
		UniUI uui = (UniUI)gui;
		if(texture != null) uui.bindTexture(texture);
		rgb = enabled ? hovered ? hcolor : ecolor : dcolor;
		RGB.glColorReset();
		int u = enabled ? hovered ? htx : tx : dtx;
		int v = enabled ? hovered ? hty : ty : dty;
		rgb.glColorApply();
		if(absolute){
			uui.drawTexturedModalRect(x < 0 ? uui.width + x : x, y < 0 ? uui.height + y : y, u, v, width, height);
		}
		else{
			uui.drawTexturedModalRect(gl + x, gt + y, u, v, width, height);
		}
		RGB.glColorReset();

	}

}
