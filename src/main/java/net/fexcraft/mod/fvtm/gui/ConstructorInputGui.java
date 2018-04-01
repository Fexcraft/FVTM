package net.fexcraft.mod.fvtm.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

@SuppressWarnings("unused")
public class ConstructorInputGui extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructorinputgui.png");
	private String window;
	private EntityPlayer player;
	private BlockPos pos;
	//
	private Button exit, conf;
	private GuiTextField field;

	public ConstructorInputGui(EntityPlayer player, BlockPos pos){
		super(new GenericPlaceholderContainer());
		window = "null";//((ConstructorControllerEntity)player.world.getTileEntity(pos)).window;
		this.xSize = 256;
		this.ySize = 32;
		this.player = player;
		this.pos = pos;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		this.mc.getTextureManager().bindTexture(texture);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	public void initGui(){
        Keyboard.enableRepeatEvents(true);
		super.initGui();
		this.buttonList.clear();
		int i = this.guiLeft;
		int j = this.guiTop;
		this.buttonList.add(exit = new Button(0,  5 + i, 19 + j, true));
		this.buttonList.add(conf = new Button(1, 15 + i, 19 + j, false));
		//
		field = new GuiTextField(2, this.fontRenderer, i + 7, j + 7, 228, 8);
		field.setText("");
		field.setTextColor(-1);
        field.setDisabledTextColour(-1);
        field.setEnableBackgroundDrawing(false);
        field.setMaxStringLength(256);
	}
	
	@Override
	public void onGuiClosed(){
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }
	
	@Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(field.textboxKeyTyped(typedChar, keyCode)){
        	super.keyTyped(typedChar, keyCode);
        }
    }
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException{
        super.mouseClicked(mouseX, mouseY, mouseButton);
        field.mouseClicked(mouseX, mouseY, mouseButton);
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        field.drawTextBox();
    }
	
	@Override
	public void handleMouseInput() throws IOException {
		super.handleMouseInput();
	}
	
	@Override
	protected void actionPerformed(GuiButton button){
		switch(button.id){
			case 0:{
				Minecraft.getMinecraft().displayGuiScreen(null);
				break;
			}
			case 1:{
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("target_listener", "fvtm");
				compound.setString("task", "constructor_input");
				compound.setLong("pos", pos.toLong());
				//compound.setString("uuid", player.getGameProfile().getId().toString());
				compound.setString("input", field.getText());
				PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
				Minecraft.getMinecraft().displayGuiScreen(null);
				break;
			}
		}
	}
	
	public static class Button extends GuiButton {
		
		private boolean ex;
		
		public Button(int id, int x, int y, boolean b){
			super(id, x, y, 8, 8, "");
			this.ex = b;
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float f){
			super.drawButton(mc, mouseX, mouseY, f);
			mc.getTextureManager().bindTexture(texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.x, this.y, ex ?  8 : 32, ex ? 40 : 40, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, ex ? 24 : 16, ex ? 32 : 32, this.width, this.height);
				}
			}
			else{
				if(this.hovered){
					this.drawTexturedModalRect(this.x, this.y,  8, 32, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, 32, 32, this.width, this.height);
				}
			}
		}
		
	}
	
}