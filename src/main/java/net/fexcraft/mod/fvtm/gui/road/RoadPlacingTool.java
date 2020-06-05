package net.fexcraft.mod.fvtm.gui.road;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.ROADTOOLFILL;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class RoadPlacingTool extends GenericGui<RoadContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/road_placing_tool.png");

	public RoadPlacingTool(EntityPlayer player, int x){
		super(texture, new RoadContainer(player, x), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 176; this.ySize = 152;
	}

	@Override
	protected void init(){
		buttons.put("layer_edit", new BasicButton("layer_edit", guiLeft + 25, guiTop + 27, 25, 27, 54, 18, true));
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
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("layer_edit")){
			openGui(ROADTOOLFILL, new int[]{ 1, 0, 0 }, LISTENERID);
			return true;
		}
		else return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

