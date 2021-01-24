package net.fexcraft.mod.fvtm.gui.road;

import static net.fexcraft.lib.mc.utils.Formatter.PARAGRAPH_SIGN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.ROADTOOL;

import java.io.IOException;
import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.util.Perms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class RoadPlacerFill extends GenericGui<RoadPlacerFillContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/road_gen_sel.png");
	//
	private ArrayList<String> ttip = new ArrayList<String>();
	
	public RoadPlacerFill(EntityPlayer player, int x, int y, int z){
		super(texture, new RoadPlacerFillContainer(player, x, y, z), player);
		if(!Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 182;
		this.ySize = 192;
	}

	@Override
	protected void init(){
		this.buttons.put("road", new BasicButton("road", guiLeft + 168, guiTop + 12, 168, 12, 8, 8, true));
		this.buttons.put("roof", new BasicButton("roof", guiLeft + 168, guiTop + 92, 168, 92, 8, 8, true));
		for(int i = 0; i < 5; i++){
			int j = i * 20;
			this.buttons.put("a" + i, new BasicButton("a" + i, guiLeft + 27, guiTop + 7 + j, 27, 7 + j, 8, 8, true));
			this.buttons.put("s" + i, new BasicButton("s" + i, guiLeft + 27, guiTop + 17 + j, 27, 17 + j, 8, 8, true));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		ttip.clear();
		if(container.roadinv.getStackInSlot(0).isEmpty() && mouseX >= guiLeft + 7 && mouseX < guiLeft + 25 && mouseY >= guiTop + 7 && mouseY < guiTop + 25){
			ttip.add(PARAGRAPH_SIGN + "6Valid block are: ");
			ttip.add(PARAGRAPH_SIGN + "b- FVTM");
			ttip.add(PARAGRAPH_SIGN + "7-> Asphalt Blocks");
			ttip.add(PARAGRAPH_SIGN + "7-> Addon Blocks of the ROAD type.");
			ttip.add(PARAGRAPH_SIGN + "b- Fureniku's Roads");
			ttip.add(PARAGRAPH_SIGN + "7-> road and sidewalk blocks with varying height (1-16mb)");
		}
		if(mouseX >= guiLeft + 168 && mouseX < guiLeft + 176){
			if(mouseY >= guiTop + 12 && mouseY < guiTop + 20){
				ttip.add(PARAGRAPH_SIGN + "7Edit/Create Custom Road Layer");
			}
			else if(mouseY >= guiTop + 92 && mouseY < guiTop + 100){
				ttip.add(PARAGRAPH_SIGN + "7Edit/Create Custom Top Layer");
			}
		}
		if(ttip.size() > 0) this.drawHoveringText(ttip, mouseX, mouseY, mc.fontRenderer);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("road")){
			openGui(ROADTOOL, new int[]{ 0, 0, 0 }, LISTENERID);
			return true;
		}
		else if(button.name.equals("roof")){
			openGui(ROADTOOL, new int[]{ 4, 0, 0 }, LISTENERID);
			return true;
		}
		return false;
	}
	
	@Override
    public void keyTyped(char typedChar, int keyCode) throws IOException{
        if(keyCode == 1){
			openGui(ROADTOOL, null, LISTENERID);
            return;
        }
        super.keyTyped(typedChar, keyCode);
    }
	
	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

