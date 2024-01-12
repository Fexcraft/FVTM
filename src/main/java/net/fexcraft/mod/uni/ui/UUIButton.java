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
		int u = enabled ? hovered ? htx : tx : dtx;
		int v = enabled ? hovered ? hty : ty : dty;
		RGB.glColorReset();
		if(palette != null){
			for(int row = 0; row < palette.length; row++){
				for(int col = 0; col < palette[row].length; col++){
					int a = col * palsize[0];
					int b = row * palsize[1];
					int c = absolute ? x < 0 ? uui.width + x : x : gl + x;
					int d = absolute ? y < 0 ? uui.height + y : y : gt + y;
					palette[row][col].glColorApply();
					uui.drawTexturedModalRect(c + a, d + b, u, v, palsize[0], palsize[1]);
				}
			}
			RGB.glColorReset();
			return;
		}
		rgb = enabled ? hovered ? hcolor : ecolor : dcolor;
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
