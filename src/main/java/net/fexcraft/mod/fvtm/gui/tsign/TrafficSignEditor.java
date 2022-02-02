package net.fexcraft.mod.fvtm.gui.tsign;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class TrafficSignEditor extends GenericGui<TrafficSignEditorContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/traffic_sign_editor.png");
	private static float scale = 32f;
	private static TrafficSignEditor ris;
	//
	private TSEButton prev, next, search;
	private TSEButton lup, ldw, rup, rdw;
	private BasicText title;
	private TabMode tabmode = TabMode.LIST;
	private ComponentMode commode = ComponentMode.BASE;
	//
	private ArrayList<String> ttip = new ArrayList<String>();
	
	public TrafficSignEditor(EntityPlayer player, int x, int y, int z){
		super(texture, new TrafficSignEditorContainer(player, x, y, z), player);
		this.deftexrect = false;
		this.xSize = 256;
		this.ySize = 206;
		ris = this;
	}
	
	@Override
	protected void init(){
		int black = MapColor.BLACK.colorIndex;
		buttons.put("prev", prev = new TSEButton("prev", guiLeft + 7, guiTop + 7, 135, 7, 12, 12, true));
		buttons.put("next", next = new TSEButton("next", guiLeft + 237, guiTop + 7, 365, 7, 12, 12, true));
		buttons.put("search", search = new TSEButton("search", guiLeft + 21, guiTop + 7, 149, 7, 12, 12, true));
		fields.put("search", new TextField(0, fontRenderer, guiLeft + 33, guiTop + 7, 202, 12, false));
		texts.put("title", title = new BasicText(guiLeft + 35, guiTop + 9, 198, black, "< selected title here >").autoscale());
		//
		buttons.put("lup", lup = new TSEButton("lup", guiLeft - 96, guiTop + 201, 32, 201, 10, 10, true));
		buttons.put("ldw", ldw = new TSEButton("ldw", guiLeft - 84, guiTop + 201, 44, 201, 10, 10, true));
		buttons.put("rup", lup = new TSEButton("rup", guiLeft + 330, guiTop + 201, 458, 201, 10, 10, true));
		buttons.put("rdw", ldw = new TSEButton("rdw", guiLeft + 342, guiTop + 201, 470, 201, 10, 10, true));
		
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		EntityLivingBase ent = mc.player;
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(guiLeft + 128, guiTop + 103, 50.0F);
        GlStateManager.scale(-scale, scale, scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        ent.renderYawOffset = 0;
        ent.rotationYaw = 0;
        ent.rotationPitch = 0;
        ent.rotationYawHead = 0;
        ent.prevRotationYawHead = 0;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
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
	    ttip.clear();
		if(prev.hovered(mouseX, mouseY)) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.prev") + " //TODO");
		if(next.hovered(mouseX, mouseY)) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.next") + " //TODO");
		if(search.hovered(mouseX, mouseY)) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.search_" + (title.visible ? "off" : "on")));
		if(title.hovered(mouseX, mouseY)) ttip.add(title.string);
	    if(ttip.size() > 0) this.drawHoveringText(ttip, mouseX, mouseY, mc.fontRenderer);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button == search){
			TextField field = fields.get("search");
			if(field.getVisible()){
				field.setText("");
				field.setVisible(false);
				title.visible = true;
			}
			else{
				field.setVisible(true);
				title.visible = false;
			}
		}
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
	
	private static enum TabMode {
		
		LIST, COLOR, EDIT
		
	}
	
	private static enum ComponentMode {
		
		BASE, COMPONENT, FONT, PRESET
		
	}
	
	private static class TSEButton extends BasicButton {

		public TSEButton(String name, int x, int y, int tx, int ty, int sizex, int sizey, boolean enabled) {
			super(name, x, y, tx, ty, sizex, sizey, enabled);
		}
		
		@Override
		public void draw(GenericGui<?> g, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			rgb = hovered ? enabled ? rgb_hover : rgb_disabled : rgb_none;
			RGB.glColorReset();
            rgb.glColorApply();
            ris.drawRect(x, y, tx, ty, sizex, sizey);
            RGB.glColorReset();
		}
		
	}
	
}

