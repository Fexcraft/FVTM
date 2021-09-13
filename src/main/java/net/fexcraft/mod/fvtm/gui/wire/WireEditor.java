package net.fexcraft.mod.fvtm.gui.wire;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Formatter;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
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
		buttons.put("help", new BasicButton("help", 105, 2, 105, 2, 12, 12, true));
		buttons.put("copy", new BasicButton("copy", 118, 2, 118, 2, 12, 12, true));
		buttons.put("up", new BasicButton("up", 131, 40, 131, 40, 7, 12, true));
		buttons.put("dw", new BasicButton("dw", 131, 152, 131, 152, 7, 12, true));
		buttons.put("reset", new BasicButton("reset", 123, 21, 123, 21, 7, 12, true));
		buttons.put("change", new BasicButton("change", 131, 21, 131, 21, 7, 12, true));
		for(int i = 0; i < b.length; i++){
			buttons.put("b" + i, b[i] = new BasicButton("b" + i, 2, 40 + (i * 14), 2, 40, 128, 12, true));
			texts.put("t" + i, t[i] = new BasicText(4, 42 + (i * 14), 124, MapColor.SNOW.colorValue, "..."));
		}
		texts.put("current", new BasicText(4, 23, 116, MapColor.SNOW.colorValue, "..."));
		texts.put("slack", new BasicText(4, 168, 54, MapColor.SNOW.colorValue, "Slack"));
		fields.put("slack", new TextField(0, fontRenderer, 60, 167, 60, 10));
		fields.get("slack").setText(container.wire.slack + "");
		buttons.put("slack", new BasicButton("slack", 122, 167, 122, 167, 7, 10, true));
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
		if(buttons.get("reset").hovered(mouseX, mouseY)) tooltip.add(Formatter.format("&eRemove current Wire-Deco."));
		if(buttons.get("change").hovered(mouseX, mouseY)){
			tooltip.add(Formatter.format("&eChange Deco Type"));
			tooltip.add(Formatter.format("&7Current deco type: &6" + container.CURRDECO));
		}
		if(buttons.get("up").hovered(mouseX, mouseY)) tooltip.add(Formatter.format("&7Scroll up."));
		if(buttons.get("dw").hovered(mouseX, mouseY)) tooltip.add(Formatter.format("&7Scroll down."));
		for(int i = 0; i < b.length; i++){
			if(b[i].hovered(mouseX, mouseY)) tooltip.add(Formatter.format("&eClick to apply."));
		}
		if(tooltip.size() > 0) drawHoveringText(tooltip, mouseX, mouseY);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("copy")){
			texts.get("title").string = "Position Copied to clipboard!";
			StringSelection selection = new StringSelection(container.wire.getId().toString());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
			return true;
		}
		else if(button.name.equals("help")){
			GuiScreen parent = this;
			this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, "https://fexcraft.net/wiki/mod/fvtm/wire", 31102009, true){
                @Override
                public void drawScreen(int mouseX, int mouseY, float partialTicks){
                    parent.drawScreen(-1, -1, partialTicks);
                    super.drawScreen(mouseX, mouseY, partialTicks);
                }
            });
			return true;
		}
		else if(button.name.equals("up")){
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

