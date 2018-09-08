package net.fexcraft.mod.fvtm.gui;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public abstract class GenericGui extends GuiContainer {

	protected ResourceLocation texloc = null;
    protected TreeMap<String, BasicButton> buttons = new TreeMap<>();
    protected TreeMap<String, BasicText> texts = new TreeMap<>();
    protected TreeMap<String, GuiTextField> fields = new TreeMap<>();
    protected GenericGuiContainer container;
    protected boolean deftexrect = true;
    protected boolean defbackground = true;
    protected EntityPlayer player;
    
    public GenericGui(ResourceLocation texture, @Nullable GenericGuiContainer container, EntityPlayer player){
    	super(container == null ? new GenericGuiContainer.DefImpl() : container);
    	this.texloc = texture == null ? Resources.NULL_TEXTURE : texture;
    	this.container = (GenericGuiContainer)this.inventorySlots;
    	this.container.setPlayer(this.player = player);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui(){
        super.initGui(); buttons.clear(); texts.clear(); fields.clear(); init();
    }

	@Override
    protected void drawGuiContainerBackgroundLayer(float pticks, int mouseX, int mouseY){
		if(defbackground) super.drawDefaultBackground();
    	predraw(pticks, mouseX, mouseY); this.mc.getTextureManager().bindTexture(texloc);
        if(deftexrect) this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    	drawbackground(pticks, mouseX, mouseY);
    	//
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    	buttons.forEach((key, button) -> {
    		button.hovered(mouseX, mouseY); button.draw(this, pticks, mouseX, mouseY);
    	});
    	texts.forEach((key, text) -> {
            mc.fontRenderer.drawString(text.string, text.x, text.y, text.color);
    	});
    	fields.forEach((key, elm) -> elm.drawTextBox());
    }
    
    protected void openGui(int gui, int[] xyz){
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString("target_listener", "fvtm");
        compound.setString("task", "open_gui");
        compound.setInteger("gui", gui);
        if(xyz != null) compound.setIntArray("args", xyz);
        PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
    }
    
    protected abstract void init();

	protected abstract void predraw(float pticks, int mouseX, int mouseY);
    
    protected abstract void drawbackground(float pticks, int mouseX, int mouseY);

	protected abstract void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button);
    
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if(mouseButton == 0){
        	for(java.util.Map.Entry<String, BasicButton> entry : buttons.entrySet()){
        		if(entry.getValue().mousePressed(this.mc, mouseX, mouseY)){
        			//can't add the forge event as it needs a _GuiButton_, this isn't one.
        			Print.debug("[GG] Button Pressed: " + entry.getKey());
        			buttonClicked(mouseX, mouseY, mouseButton, entry.getKey(), entry.getValue());
        		}
        	}
        }
        if(!fields.isEmpty()) fields.values().forEach(elm -> elm.mouseClicked(mouseX, mouseY, mouseButton));
    }

	public static class BasicButton {
    	
		public int x, y, tx, ty, sizex, sizey;
		public boolean enabled, visible = true, hovered;
    	public String name; private RGB rgb;
    	public RGB rgb_disabled = new RGB(119, 119, 119, 0.5f);
    	public RGB rgb_none = new RGB(255, 255, 255, 0.5f);
    	public RGB rgb_hover = new RGB(244, 215,  66, 0.5f);
    	
    	public BasicButton(String name, int x, int y, int tx, int ty, int sizex, int sizey, boolean enabled){
    		this.name = name; this.x = x; this.y = y; this.sizex = sizex; this.sizey = sizey;
    		this.enabled = enabled; this.tx = tx; this.ty = ty;
    	}

		public boolean mousePressed(Minecraft mc, int mouseX, int mouseY){
			return enabled && visible && mouseX >= x && mouseY >= y && mouseX < x + sizex && mouseY < y + sizey;
		}

		public boolean hovered(int mouseX, int mouseY){
			return hovered = mouseX >= x && mouseY >= y && mouseX < x + sizex && mouseY < y + sizey;
		}

		public void draw(GenericGui gui, float pticks, int mouseX, int mouseY){
			if(!visible) return; rgb = hovered ? enabled ? rgb_hover : rgb_disabled : rgb_none; RGB.glColorReset();
            rgb.glColorApply(); gui.drawTexturedModalRect(x, y, tx, ty, sizex, sizey); RGB.glColorReset();
		}
    	
    }
	
	public static class BasicText {
		
		private static final RGB defcolor = new RGB(128, 128, 128);
		public int x, y, width, color;
		public String string;
		public boolean visible = true;
		
		public BasicText(int x, int y, int width, @Nullable Integer color, String string){
			this.x = x; this.y = y; this.width = width;
			this.string = string; this.color = color == null ? defcolor.packed : color;
		}
	}
	
	//---///----////----///---//
	
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException{
        if(!fields.isEmpty() && !(this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))){
        	boolean bool = false;
        	for(Entry<String, GuiTextField> entry : fields.entrySet()){
        		if(entry.getValue().textboxKeyTyped(typedChar, keyCode)) bool = true;
        	}
            if(bool) super.keyTyped(typedChar, keyCode);
        }
        if(keyCode == 1) player.closeScreen();
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
    }

}
