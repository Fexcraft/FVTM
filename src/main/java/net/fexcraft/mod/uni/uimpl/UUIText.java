package net.fexcraft.mod.uni.uimpl;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.ui.UIText;
import net.fexcraft.mod.uni.ui.UserInterface;
import net.minecraft.client.resources.I18n;
import org.lwjgl.opengl.GL11;

public class UUIText extends UIText {

	public UUIText(UserInterface ui, JsonMap map) throws Exception {
		super(ui, map);
	}

	public boolean hovered(int mx, int my){
		return hovered = mx >= x && mx <= x + width && my >= y && my <= y + height;
	}

	public boolean scrollwheel(int am, int x, int y){
		return false;
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
	public void draw(Object ui, float ticks, int gl, int gt, int mx, int my){
		if(!visible) return;
		hovered(mx, my);
		if(scale == 0 || (scale < 0 && ((UniUI)ui).mc.fontRenderer.getStringWidth(value) < width)){
			((UniUI)ui).mc.fontRenderer.drawString(value, x, y, hovered ? hover.packed : color.packed, shadow);
		}
		else{
			float scale = this.scale < 0 ? (float)width / ((UniUI)ui).mc.fontRenderer.getStringWidth(value) : this.scale;
			GL11.glPushMatrix();
			GL11.glTranslatef(x, y, 0);
			GL11.glScalef(scale, scale, scale);
			((UniUI)ui).mc.fontRenderer.drawString(value, 0, 0, hovered ? hover.packed : color.packed, shadow);
			GL11.glPopMatrix();
		}
	}

}
