package net.fexcraft.mod.uni.uimpl;

import java.util.TreeMap;

import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UIField;
import net.fexcraft.mod.uni.ui.UITab;
import net.fexcraft.mod.uni.ui.UIText;
import net.fexcraft.mod.uni.ui.UserInterface;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniUI<CON extends UniCon> extends GuiContainer {

	protected TreeMap<String, UIButton> buttons = new TreeMap<>();
	protected TreeMap<String, UIText> texts = new TreeMap<>();
	protected TreeMap<String, UIField> fields = new TreeMap<>();
	//
	protected CON container;
	protected UserInterface ui;

	public UniUI(UserInterface ui, CON container, EntityPlayer player){
		super(container);
		this.ui = ui;
		this.container = container;
		container.setPlayer(player);
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
		buttons.clear();
		texts.clear();
		fields.clear();
		//
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
		buttons.forEach((key, button) -> {
			button.hovered(mx, my);
			//button.draw(this, ticks, mx, my);
		});
		texts.forEach((key, text) -> {
			//text.draw(this, ticks, mx, my);
		});
		//fields.forEach((key, elm) -> elm.drawTextBox());
		postdraw(ticks, mx, my);
	}

	protected void predraw(float ticks, int mx, int my){}

	public void drawbackground(float ticks, int mx, int my){
		for(UITab tab : ui.tabs.values()){
			if(!tab.visible) continue;
			int tx = tab.enabled ? tab.hovered ? tab.htx : tab.tx : tab.dtx;
			int ty = tab.enabled ? tab.hovered ? tab.hty : tab.ty : tab.dty;
			if(tab.absolute){
				drawTexturedModalRect(tab.x, tab.y, 0, 0, tx, ty);
			}
			else{
				drawTexturedModalRect(guiLeft + tab.x, guiTop + tab.y, 0, 0, tx, ty);
			}
		}
	}

	protected void postdraw(float ticks, int mx, int my){}

}
