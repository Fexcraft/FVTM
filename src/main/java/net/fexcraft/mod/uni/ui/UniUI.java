package net.fexcraft.mod.uni.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
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
	protected ArrayList<String> tooltip = new ArrayList<>();
	//
	protected UniCon container;
	protected UserInterface ui;

	public UniUI(UserInterface ui, UniCon con, EntityPlayer player){
		super(con == null ? con = new UniCon(ui.container, player) : con);
		this.ui = ui;
		ui.root = this;
		(container = con).setup(this);
		xSize = ui.width;
		ySize = ui.height;
		ui.drawer = new UserInterface.Drawer() {
			@Override
			public void draw(int x, int y, int u, int v, int w, int h){
				drawTexturedModalRect(x, y, u, v, w, h);
			}

			@Override
			public void draw(int x, int y, StackWrapper stack){
				RenderHelper.enableGUIStandardItemLighting();
				itemRender.renderItemIntoGUI(stack.local(), x, y);
			}

			@Override
			public void bind(IDL texture){
				TexUtil.bindTexture(texture);
			}

			@Override
			public void apply(RGB color){
				color.glColorApply();
			}
		};
	}

	public UniUI(UserInterface ui, EntityPlayer player){
		this(ui, null, player);
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
		ui.gLeft = guiLeft;
		ui.gTop = guiTop;
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
			bindTexture(tab.texture);
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
		ui.drawbackground(ticks, mx, my);
	}

	protected void postdraw(float ticks, int mx, int my){
		tooltip.clear();
		ui.getTooltip(mx, my, tooltip);
		for(UITab tab : tabs.values()){
			if(!tab.visible()) continue;
			for(UIButton button : tab.buttons.values()){
				if(!button.visible()) continue;
				if(button.tooltip != null && button.hovered()) tooltip.add(I18n.format(button.tooltip));
			}
		}
		if(tooltip.size() > 0) drawHoveringText(tooltip, mx, my);
		ui.postdraw(ticks, mx, my);
	}


	@Override
	protected void mouseClicked(int mx, int my, int mb) throws IOException {
		if(ui.onClick(mx, my, mb)) return;
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
					exit = entry.getValue().onscroll(guiLeft, guiTop, x, y, am) || ui.onScroll(entry.getValue(), entry.getKey(), x, y, am);
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
