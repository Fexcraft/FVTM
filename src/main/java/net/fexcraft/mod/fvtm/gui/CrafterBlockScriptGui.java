package net.fexcraft.mod.fvtm.gui;

import java.util.List;

import net.fexcraft.mod.fvtm.blocks.UniversalTileEntity;
import net.fexcraft.mod.fvtm.impl.CrafterBlockScriptBase;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrafterBlockScriptGui extends GuiContainer {

	private static final ResourceLocation invtex = new ResourceLocation("fvtm:textures/guis/crafter_block_stats.png");

	private UniversalTileEntity tile;
    private CrafterBlockScriptBase script;

    public CrafterBlockScriptGui(EntityPlayer player, World world, int x, int y, int z){
        super(new GenericGuiContainer.DefImpl());
        this.tile = (UniversalTileEntity)world.getTileEntity(new BlockPos(x, y, z));
        this.xSize = 256;
        this.ySize = 40;
        script = (CrafterBlockScriptBase)tile.getBlockData().getScript();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
        int i = this.guiLeft, j = this.guiTop;
        this.mc.getTextureManager().bindTexture(invtex);
        List<String> list = script.getStatus(tile.getBlockData());
        if(list == null || list.isEmpty()){
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
            this.fontRenderer.drawString(tile.getBlockData().getBlock().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
            this.fontRenderer.drawString("No Data.", i + 7, j + 21, MapColor.SNOW.colorValue);
        }
        else{
        	j = this.guiTop = (this.height - (40 + (list.size() * 14))) / 2;
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, 19);
        	int l = 19;
            for(int k = 0; k < list.size(); k++){
            	l = 19 + (k * 14);
                this.drawTexturedModalRect(i, j + l, 0, 19, this.xSize, 14);
            }
            l = l == 19 ? l : l + 14;
            this.drawTexturedModalRect(i, j + l, 0, 33, this.xSize, 7);
            this.drawTexturedModalRect(i + 6, j + l, 0, 252, getProgress(), 2);
            //
            for(int k = 0; k < list.size(); k++){
                this.fontRenderer.drawString(list.get(k), i + 7, (j + 21) + (k * 14), MapColor.GRAY.colorValue);
            }
        }
    }
    
    private int getProgress(){
    	return (int)((244f / 100f) * script.getProgressPercentage());
    }

}
