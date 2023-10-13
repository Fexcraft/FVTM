package net.fexcraft.mod.uni.ui;

import net.fexcraft.app.json.JsonMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UUIField extends UIField {

	protected GuiTextField field;

	public UUIField(UserInterface ui, JsonMap map) throws Exception {
		super(ui, map);
		field = new GuiTextField(ui._fields++, Minecraft.getMinecraft().fontRenderer, 0, 0, width, height){
			@Override
			public void writeText(String text){
				if(regex != null) text = text.replaceAll(regex, "");
				super.writeText(text);
			}
		};
		field.setEnableBackgroundDrawing(background);
		field.setTextColor(color);
		field.setText(value);
		field.setEnabled(enabled);
		field.setVisible(visible);
	}

	@Override
	public void draw(Object gui, UIElement root, float ticks, int gl, int gt, int mx, int my){
		if(!visible()) return;
		field.x = absolute ? x < 0 ? ui.screen_width + x : x : gl + x;
		field.y = absolute ? y < 0 ? ui.screen_height + y : y : gt + y;
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
	public void enabled(boolean bool){
		field.setEnabled(enabled = bool);
	}

	@Override
	public boolean onclick(int mx, int my, int mb){
		boolean bool = field.mouseClicked(mx, my, mb);
		if(field.isFocused()){
			for(UIField uif : ui.fields.values()){
				UUIField uuif = (UUIField) uif;
				if(uuif.field.isFocused() && uuif.field != field){
					uuif.field.setFocused(false);
				}
			}
		}
		return bool;
	}

	@Override
	public boolean keytyped(char c, int code){
		return field.textboxKeyTyped(c, code);
	}

	@Override
	public void text(String text){
		field.setText(text);
	}

	public String text(){
		return field.getText();
	}

}
