package net.fexcraft.mod.uni.uimpl;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.ui.UIElement;
import net.fexcraft.mod.uni.ui.UIField;
import net.fexcraft.mod.uni.ui.UserInterface;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UUIField extends UIField {

	protected GuiTextField field;

	public UUIField(UserInterface ui, JsonMap map) throws Exception {
		super(ui, map);
		field = new GuiTextField(0, Minecraft.getMinecraft().fontRenderer, 0, 0, width, height){
			@Override
			public void writeText(String text){
				if(regex != null) text = text.replaceAll(regex, "");
				super.writeText(text);
			}
		};
		field.setEnableBackgroundDrawing(background);
		field.setTextColor(color);
		field.setText(value);
	}

	@Override
	public void draw(Object gui, UIElement root, float ticks, int gl, int gt, int mx, int my){
		if(!visible()) return;
		UniUI uui = (UniUI)gui;
		field.x = absolute ? x < 0 ? uui.width + x : x : gl + x;
		field.y = absolute ? y < 0 ? uui.height + y : y : gt + y;
		field.drawTextBox();
	}

	@Override
	public boolean visible(){
		return field.getVisible();
	}

	@Override
	public void visible(boolean bool){
		field.setVisible(visible = bool);
	}

	@Override
	public boolean onclick(int mx, int my, int mb){
		return field.mouseClicked(mx, my, mb);
	}

	@Override
	public boolean keytyped(char c, int code){
		return field.textboxKeyTyped(c, code);
	}

	@Override
	public void text(String text){
		field.setText(text);
	}

}
