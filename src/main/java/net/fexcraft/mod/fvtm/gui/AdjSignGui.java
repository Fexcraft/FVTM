package net.fexcraft.mod.fvtm.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.blocks.AdjustableSignEntity;
import net.fexcraft.mod.fvtm.blocks.CylinderSignEntity;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AdjSignGui {

	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/adj_sign.png");
	
	public static class Client extends GuiContainer {
		
		private EntityPlayer player;
		private GuiButton[] buttons = new GuiButton[6];
		private AdjustableSignEntity adjsign;
		private CylinderSignEntity cylsign;
		
		@SuppressWarnings("unused")
		private static Server server;

		public Client(EntityPlayer player, World world, int x, int y, int z){
			super(server = new Server(player, world, x, y, z));
			TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
			if(tile instanceof AdjustableSignEntity){ this.adjsign = (AdjustableSignEntity)tile; }
			if(tile instanceof CylinderSignEntity){ this.cylsign = (CylinderSignEntity)tile; }
			this.xSize = 254; this.ySize = 56;
			this.player = player;
		}
		
		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	        this.drawDefaultBackground();
	        super.drawScreen(mouseX, mouseY, partialTicks);
	        this.renderHoveredToolTip(mouseX, mouseY);
	    }

		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
			int i = this.guiLeft, j = this.guiTop;
			this.mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
			//
			GL11.glScalef(0.5f, 0.5f, 0.5f);
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(adjsign == null ? cylsign.getTexture().toString().replace("fcl:remote/:", "") : adjsign.getTexture().toString().replace("fcl:remote/", ""), 238 * 2, false), (i + 8) * 2, (j + 8) * 2, MapColor.SNOW.colorValue);
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(adjsign == null ? cylsign.getTexture().toString().replace("fcl:remote/:", "") : adjsign.getTexture().toString().replace("fcl:remote/", ""), 238 * 2, true), (i + 8) * 2, (j + 19) * 2, MapColor.SNOW.colorValue);
			GL11.glScalef(  2f,   2f,   2f);
			//
			if(adjsign == null){
				mc.fontRenderer.drawString("Scale: " + cylsign.getScale(), i + 7, j + 32, MapColor.SNOW.colorValue);
				mc.fontRenderer.drawString("Segments: " + cylsign.getSegments(), i + 131, j + 32, MapColor.SNOW.colorValue);
			}
			else{
				mc.fontRenderer.drawString("Width: " + adjsign.getWidth(), i + 7, j + 32, MapColor.SNOW.colorValue);
				mc.fontRenderer.drawString("Height: " + adjsign.getHeight(), i + 131, j + 32, MapColor.SNOW.colorValue);
			}
		}
		
		@Override
		public void initGui(){
			super.initGui();
			this.buttonList.clear();
			this.buttonList.add(buttons[0] = new  CopyButton(0, guiLeft +   6, guiTop + 43, true ));
			this.buttonList.add(buttons[1] = new  CopyButton(1, guiLeft +  46, guiTop + 43, false));
			this.buttonList.add(buttons[2] = new ArrowButton(2, guiLeft + 103, guiTop + 30, true ));
			this.buttonList.add(buttons[3] = new ArrowButton(3, guiLeft + 115, guiTop + 30, false));
			this.buttonList.add(buttons[4] = new ArrowButton(4, guiLeft + 227, guiTop + 30, true ));
			this.buttonList.add(buttons[5] = new ArrowButton(5, guiLeft + 239, guiTop + 30, false));
		}
		
		@Override
		public void actionPerformed(GuiButton button){
			if(button.id < 2){
				if(button.id == 0){
					Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
					if(!cb.isDataFlavorAvailable(DataFlavor.stringFlavor)){
						Print.chat(player, "Invalid Clipboard Content.");
						return;
					}
					try{
						if(adjsign == null){
							cylsign.setTexture((String)cb.getData(DataFlavor.stringFlavor), player);
						}
						else{
							adjsign.setTexture((String)cb.getData(DataFlavor.stringFlavor), player);
						}
					}
					catch(UnsupportedFlavorException | IOException e){
						e.printStackTrace();
						Print.chat(player, "Error: " + e.getMessage());
					}
				}
				else if(button.id == 1){
					String tex = adjsign == null ? cylsign.getTexture().toString().replace("fcl:remote/:", "") : adjsign.getTexture().toString().replace("fcl:remote/:", "");
					StringSelection sel = new StringSelection(tex);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, sel);
				}
				return;
			}
			if(adjsign == null){
				switch(button.id){
					case 2:{ cylsign.rescale(cylsign.getScale() - 1); break; }
					case 3:{ cylsign.rescale(cylsign.getScale() + 1); break; }
					case 4:{ cylsign.segments(cylsign.getSegments() - 1); break; }
					case 5:{ cylsign.segments(cylsign.getSegments() + 1); break; }
				}
			}
			else{
				switch(button.id){
					case 2:{ adjsign.resize(EnumFacing.Plane.HORIZONTAL, adjsign.getWidth() - 1); break; }
					case 3:{ adjsign.resize(EnumFacing.Plane.HORIZONTAL, adjsign.getWidth() + 1); break; }
					case 4:{ adjsign.resize(EnumFacing.Plane.VERTICAL, adjsign.getWidth() - 1); break; }
					case 5:{ adjsign.resize(EnumFacing.Plane.VERTICAL, adjsign.getWidth() + 1); break; }
				}
			}
		}
		
	}
	
	private static class CopyButton extends GuiButton {
		
		private boolean left;

		public CopyButton(int buttonId, int x, int y, boolean left){
			super(buttonId, x, y, 38, 8, "");
			this.left = left;
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
			if(!visible){ return; }
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			mc.getTextureManager().bindTexture(texture);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            //
            if(this.enabled){
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, left ? 0 : 38, 240, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, left ? 0 : 38, 232, this.width, this.height);
    			}
    		}
    		else{
				this.drawTexturedModalRect(this.x, this.y, left ? 0 : 38, 248, this.width, this.height);
    		}
	    }
		
	}
	
	private static class ArrowButton extends GuiButton {
		
		private boolean left;

		public ArrowButton(int buttonId, int x, int y, boolean left){
			super(buttonId, x, y, 10, 10, "");
			this.left = left;
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
			if(!visible){ return; }
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			mc.getTextureManager().bindTexture(texture);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            //
            if(this.enabled){
    			if(this.hovered){
    				this.drawTexturedModalRect(this.x, this.y, left ? 236 : 246, 236, this.width, this.height);
    			}
    			else{
    				this.drawTexturedModalRect(this.x, this.y, left ? 236 : 246, 226, this.width, this.height);
    			}
    		}
    		else{
				this.drawTexturedModalRect(this.x, this.y, left ? 236 : 246, 246, this.width, this.height);
    		}
	    }
		
	}
	
	public static class Server extends Container {
		
		//private AdjustableSignEntity adjsign;
		//private CylinderSignEntity cylsign;
		
		public Server(EntityPlayer player, World world, int x, int y, int z){
			/*TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
			if(tile instanceof AdjustableSignEntity){ this.adjsign = (AdjustableSignEntity)tile; }
			if(tile instanceof CylinderSignEntity){ this.cylsign = (CylinderSignEntity)tile; }*/
		}
		
		@Override
		public boolean canInteractWith(EntityPlayer player){
			return player != null && !player.isDead;
		}
		
	}
	
}