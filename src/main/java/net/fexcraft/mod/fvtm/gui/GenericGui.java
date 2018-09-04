package net.fexcraft.mod.fvtm.gui;

import java.io.IOException;
import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public abstract class GenericGui extends GuiContainer {

	protected ResourceLocation texloc = null;
    protected TreeMap<String, BasicButton> buttons = new TreeMap<>();
    protected TreeMap<String, BasicText> texts = new TreeMap<>();
    protected GenericGuiContainer container;
    
    public GenericGui(ResourceLocation texture, @Nullable GenericGuiContainer container){
    	super(container == null ? new GenericGuiContainer.DefImpl() : container);
    	this.texloc = texture == null ? Resources.NULL_TEXTURE : texture;
    	this.container = (GenericGuiContainer)this.inventorySlots;
    	container.setPlayer(Minecraft.getMinecraft().player);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
    public void initGui(){
        super.initGui(); buttons.clear(); texts.clear(); init();
    }

	@Override
    protected void drawGuiContainerBackgroundLayer(float pticks, int mouseX, int mouseY){
    	predraw(pticks, mouseX, mouseY); this.mc.getTextureManager().bindTexture(texloc);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    	buttons.forEach((key, button) -> {
    		button.hovered(mouseX, mouseY); button.draw(this, pticks, mouseX, mouseY);
    	});
    	texts.forEach((key, button) -> {
            mc.fontRenderer.drawString(button.string, guiLeft + button.x, guiTop + button.y, button.color);
    	});
    	drawbackground(pticks, mouseX, mouseY);
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
        			buttonClicked(mouseX, mouseY, mouseButton, entry.getKey(), entry.getValue());
        		}
        	}
        }
    }

	public static class BasicButton {
    	
		protected int x, y, sizex, sizey;
    	protected boolean enabled, visible = true, hovered;
    	protected String name; private RGB rgb;
    	protected RGB gray = new RGB(119, 119, 119);
    	protected RGB yellow = new RGB(244, 215, 66);
    	
    	public BasicButton(String name, int x, int y, int sizex, int sizey, boolean enabled){
    		this.name = name; this.x = x; this.y = y; this.sizex = sizex; this.sizey = sizey;
    		this.enabled = enabled;
    	}

		public boolean mousePressed(Minecraft mc, int mouseX, int mouseY){
			return enabled && visible && mouseX >= x && mouseY >= y && mouseX < x + sizex && mouseY < y + sizey;
		}

		public boolean hovered(int mouseX, int mouseY){
			return hovered = mouseX >= x && mouseY >= y && mouseX < x + sizex && mouseY < y + sizey;
		}

		public void draw(GenericGui gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
            rgb = hovered ? enabled ? rgb = gray : yellow : null; RGB.glColorReset();
            rgb.glColorApply(); gui.drawTexturedModalRect(this.x, this.y,0, 0, sizex, sizey); RGB.glColorReset();
		}
    	
    }
	
	public static class BasicText {
		
		protected int x, y, width, color;
		public String string;
		public boolean visible = true;
		
		public BasicText(int x, int y, int width, @Nullable Integer color, String string){
			this.x = x; this.y = y; this.width = width;
			this.string = string; this.color = color == null ? MapColor.SNOW.colorValue : color;
		}
	}

}
