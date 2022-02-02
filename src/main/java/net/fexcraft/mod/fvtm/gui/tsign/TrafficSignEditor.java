package net.fexcraft.mod.fvtm.gui.tsign;

import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class TrafficSignEditor extends GenericGui<TrafficSignEditorContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/traffic_sign_editor.png");
	//
	private ArrayList<String> ttip = new ArrayList<String>();
	
	public TrafficSignEditor(EntityPlayer player, int x, int y, int z){
		super(texture, new TrafficSignEditorContainer(player, x, y, z), player);
		this.deftexrect = false;
		this.xSize = 256;
		this.ySize = 206;
	}
	
	@Override
	protected void init(){
		//
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		drawRect(guiLeft, guiTop, 128, 0, xSize, ySize);
		drawRect(guiLeft - 112, guiTop + 14, 16, 14, 112, 192);
		drawRect(guiLeft + 256, guiTop + 14, 384, 14, 112, 192);
		drawRect(guiLeft + 11, guiTop + 206, 139, 206, 150, 16);
		drawRect(guiLeft + 173, guiTop + 206, 301, 206, 72, 16);
		drawRect(guiLeft - 99, guiTop + 206, 29, 206, 28, 8);
		drawRect(guiLeft + 327, guiTop + 206, 455, 206, 28, 8);
	}
	
	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		//
	    if(ttip.size() > 0) this.drawHoveringText(ttip, mouseX, mouseY, mc.fontRenderer);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		//
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
	public void drawRect(int x, int y, int tx, int ty, int w, int h){
        float gw = 0.001953125f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(x, y + h, zLevel).tex(tx * gw, (ty + h) * gw).endVertex();
        bufferbuilder.pos(x + w, y + h, zLevel).tex((tx + w) * gw, (ty + h) * gw).endVertex();
        bufferbuilder.pos(x + w, y, zLevel).tex((tx + w) * gw, ty * gw).endVertex();
        bufferbuilder.pos(x, y, zLevel).tex(tx * gw, ty * gw).endVertex();
        tessellator.draw();
	}
	
}

