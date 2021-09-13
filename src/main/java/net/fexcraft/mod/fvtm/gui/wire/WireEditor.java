package net.fexcraft.mod.fvtm.gui.wire;

import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class WireEditor extends GenericGui<WireRelayContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/wire_editor.png");
	private static BasicButton[] b = new BasicButton[9];
	private static BasicText[] t = new BasicText[9];
	private ArrayList<String> tooltip = new ArrayList<>();
	private static int scroll;

	public WireEditor(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new WireRelayContainer(player, world, x, y, z), player);
		this.container.gui = this;
		this.defbackground = false;
		this.deftexrect = false;
		this.xSize = 144;
		this.ySize = 189;
	}

	@Override
	protected void init(){
		texts.put("title", new BasicText(4, 4, 95, MapColor.SNOW.colorValue, "Wire Editor"));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		drawTexturedModalRect(0, 0, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		tooltip.clear();
		//
		if(tooltip.size() > 0) drawHoveringText(tooltip, mouseX, mouseY);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("up")){
			scroll--;
			if(scroll < 0 ) scroll = 0;
		}
		else if(button.name.equals("dw")){
			scroll++;
		}
		//
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		scroll += am > 0 ? 1 : -1;
		if(scroll < 0) scroll = 0;
	}
	
}

