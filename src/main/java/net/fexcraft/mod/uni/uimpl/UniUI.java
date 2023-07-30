package net.fexcraft.mod.uni.uimpl;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UIField;
import net.fexcraft.mod.uni.ui.UITab;
import net.fexcraft.mod.uni.ui.UIText;
import net.fexcraft.mod.uni.ui.UserInterface;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniUI extends GuiContainer {

	//protected LinkedHashMap<String, UIButton> buttons = new LinkedHashMap<>();
	//protected LinkedHashMap<String, UIText> texts = new LinkedHashMap<>();
	//protected LinkedHashMap<String, UIField> fields = new LinkedHashMap<>();
	protected LinkedHashMap<String, UITab> tabs = new LinkedHashMap<>();
	//
	protected UniCon container;
	protected UserInterface ui;

	public UniUI(UserInterface ui, UniCon con, EntityPlayer player){
		super(con == null ? con = new UniCon(ui.container, player) : con);
		this.ui = ui;
		(container = con).setup(this);
		xSize = ui.width;
		ySize = ui.height;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	public void initGui(){
		super.initGui();
		ui.screen_width = width;
		ui.screen_height = height;
		/*buttons.clear();
		texts.clear();
		fields.clear();
		buttons.putAll(ui.buttons);
		texts.putAll(ui.texts);
		fields.putAll(ui.fields);*/
		tabs.clear();
		tabs.putAll(ui.tabs);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float ticks, int mx, int my){
		if(ui.background) super.drawDefaultBackground();
		predraw(ticks, mx, my);
		drawbackground(ticks, mx, my);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		for(UITab tab : tabs.values()){
			if(!tab.visible()) continue;
			tab.buttons.forEach((key, button) -> {
				button.hovered(guiLeft, guiTop, mx, my);
				button.draw(this, null, ticks, guiLeft, guiTop, mx, my);
			});
			tab.buttons.forEach((key, button) -> {
				if(button.text != null) button.text.draw(this, button, ticks, guiLeft, guiTop, mx, my);
			});
			tab.texts.forEach((key, text) -> {
				text.draw(this, null, ticks, guiLeft, guiTop, mx, my);
			});
			tab.fields.forEach((key, field) -> {
				field.draw(this, null, ticks, guiLeft, guiTop, mx, my);
			});
		}
		postdraw(ticks, mx, my);
	}

	protected void predraw(float ticks, int mx, int my){
		ui.predraw(ticks, mx, my);
	}

	public void drawbackground(float ticks, int mx, int my){
		for(UITab tab : ui.tabs.values()){
			if(!tab.visible()) continue;
			int tx = tab.enabled() ? tab.hovered() ? tab.htx : tab.tx : tab.dtx;
			int ty = tab.enabled() ? tab.hovered() ? tab.hty : tab.ty : tab.dty;
			bindTexture(tab.texture);
			if(tab.absolute){
				drawTexturedModalRect(tab.x < 0 ? width + tab.x : tab.x, tab.y < 0 ? height + tab.y : tab.y, tx, ty, tab.width, tab.height);
			}
			else{
				drawTexturedModalRect(guiLeft + tab.x, guiTop + tab.y, tx, ty, tab.width, tab.height);
			}
		}
	}

	protected void postdraw(float ticks, int mx, int my){
		ui.postdraw(ticks, mx, my);
	}


	@Override
	protected void mouseClicked(int mx, int my, int mb) throws IOException {
		if(ui.onClick(guiLeft, guiTop, mx, my, mb)) return;
		super.mouseClicked(mx, my, mb);
	}

	@Override
	protected void keyTyped(char c, int code) throws IOException {
		boolean invbutton = this.mc.gameSettings.keyBindInventory.isActiveAndMatches(code);
		boolean keytyped = false;
		for(UITab tab : tabs.values()){
			if(!tab.visible() || tab.fields.isEmpty()) continue;
			boolean bool = false;
			for(UIField field : tab.fields.values()){
				if(bool) break;
				if(field.visible() && field.keytyped(c, code)){
					bool = true;
					//break;
				}
			}
			if(!bool){
				super.keyTyped(c, code);
			}
			else keytyped = true;
		}
		if(code == 1 || (invbutton && !keytyped)) mc.player.closeScreen();
	}

	@Override
	public void handleMouseInput() throws IOException {
		super.handleMouseInput();
		int e = Mouse.getEventDWheel();
		if(e == 0) return;
		int am = e > 0 ? -1 : 1;
		int x = Mouse.getEventX() * width / mc.displayWidth;
		int y = this.height - Mouse.getEventY() * height / mc.displayHeight - 1;
		boolean exit = false;
		for(UITab tab : tabs.values()){
			if(!tab.visible()) continue;
			for(Entry<String, UIButton> entry : tab.buttons.entrySet()){
				if(exit) break;
				if(entry.getValue().hovered(guiLeft, guiTop, x, y)){
					exit = entry.getValue().onscroll(guiLeft, guiTop, x, y, am) || ui.onScroll(entry.getValue(), entry.getKey(), guiLeft, guiTop, x, y, am);
				}
			}
			for(UIText text : tab.texts.values()){
				if(exit) break;
				if(text.hovered(guiLeft, guiTop, x, y)) exit = text.onscroll(guiLeft, guiTop, x, y, am);
			}
		}
		if(!exit) scrollwheel(am, x, y);
	}

	public void scrollwheel(int am, int x, int y){
		ui.scrollwheel(am, x, y);
	}

	public void bindTexture(IDL texture){
		mc.renderEngine.bindTexture((ResourceLocation)texture);
	}

}
