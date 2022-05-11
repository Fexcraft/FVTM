package net.fexcraft.mod.fvtm.gui.road;

import java.io.IOException;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class RoadPlacerCustomFill extends GenericGui<RoadPlacerCustomFillContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/road_gen_custom.png");
	
	public RoadPlacerCustomFill(EntityPlayer player, int x, int y, int z){
		super(texture, new RoadPlacerCustomFillContainer(player, x, y, z), player);
		//if(!Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 176;
		this.ySize = 128;
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
		int left = guiLeft + 88 - container.off;
		this.drawTexturedModalRect(left - 7, guiTop, 188, 0, 25, 32);
		if(container.size[0] == 1){
			this.drawTexturedModalRect(left + 18, guiTop, 249, 0, 7, 32);
		}
		else{
			for(int i = 1; i < container.size[0] - 1; i++){
				this.drawTexturedModalRect(left + i * 18, guiTop, 213, 0, 18, 32);
			}
			this.drawTexturedModalRect(left + (container.size[0] - 1) * 18, guiTop, 231, 0, 25, 32);
		}
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		return false;
	}

	@Override
    public void keyTyped(char typedChar, int keyCode) throws IOException{
        if(keyCode == 1){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "save");
			container.send(Side.SERVER, compound);
            return;
        }
        else super.keyTyped(typedChar, keyCode);
    }
	
	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

