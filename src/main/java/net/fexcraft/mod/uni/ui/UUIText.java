package net.fexcraft.mod.uni.ui;

import net.fexcraft.app.json.JsonMap;
import net.minecraft.client.resources.I18n;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UUIText extends UIText {

	public UUIText(UserInterface ui, JsonMap map) throws Exception {
		super(ui, map);
	}

	@Override
	public void translate(){
		value = I18n.format(value);
	}

	@Override
	public void translate(Object... objects){
		value = I18n.format(value, objects);
	}

	@Override
	public void draw(Object gui, UIElement root, float ticks, int gl, int gt, int mx, int my){
		if(!visible) return;
		UniUI uui = (UniUI)gui;
		int xx = 0, yy = 0, textwidth = uui.mc.fontRenderer.getStringWidth(value);
		if(root != null){
			if(centered){
				xx = root.x + (root.width / 2) + x - (textwidth / 2);
				yy = root.y + (root.height / 2) + y - (height / 2);
			}
			else{
				xx = x < 0 ? root.x + root.width + x - textwidth : root.x + x;
				yy = y < 0 ? root.y + root.height + y - height : root.y + y;
			}
			if(!root.absolute){
				xx += gl;
				yy += gt;
			}
			hovered = root.hovered();
		}
		else{
			hovered(gl, gt, mx, my);
			xx = absolute ? x < 0 ? uui.width + x : x : gl + x;
			yy = absolute ? y < 0 ? uui.height + y : y : gt + y;
			if(centered) xx += (width / 2) - (textwidth / 2);
		}
		if(scale == 0 || (scale < 0 && textwidth < width)){
			uui.mc.fontRenderer.drawString(value, xx, yy, hovered ? hover.packed : color.packed, shadow);
		}
		else{
			float scale = this.scale < 0 ? (float)width / uui.mc.fontRenderer.getStringWidth(value) : this.scale;
			GL11.glPushMatrix();
			GL11.glTranslatef(xx, yy, 0);
			GL11.glScalef(scale, scale, scale);
			uui.mc.fontRenderer.drawString(value, 0, 0, hovered ? hover.packed : color.packed, shadow);
			GL11.glPopMatrix();
		}
	}

}
