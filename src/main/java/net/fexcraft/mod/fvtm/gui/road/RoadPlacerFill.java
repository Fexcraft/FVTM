package net.fexcraft.mod.fvtm.gui.road;

import static net.fexcraft.lib.common.utils.Formatter.PARAGRAPH_SIGN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import java.io.IOException;
import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.ui.UIKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class RoadPlacerFill extends GenericGui<RoadPlacerFillContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/road_gen_sel.png");
	//private static int minheight = 3;
	//
	private ArrayList<String> ttip = new ArrayList<String>();
	private int[] size = new int[]{ 1, 0, 0, 0, 0, 0 };
	
	public RoadPlacerFill(EntityPlayer player, int x, int y, int z){
		super(texture, new RoadPlacerFillContainer(player, x, y, z), player);
		//if(!Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
		if(!container.stack.getTagCompound().hasKey("RoadLayers")){
			container.stack.getTagCompound().setIntArray("RoadLayers", size);
		}
		else size = container.stack.getTagCompound().getIntArray("RoadLayers");
		if(size.length < 6) size = new int[]{ size[0], size[1], size[2], size[3], size[4], 0 };
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		this.xSize = 182;
		this.ySize = 212;
	}

	@Override
	protected void init(){
		this.buttons.put("road", new BasicButton("road", guiLeft + 168, guiTop + 12, 168, 12, 8, 8, true));
		this.buttons.put("roof", new BasicButton("roof", guiLeft + 168, guiTop + 92, 168, 92, 8, 8, true));
		this.buttons.put("line", new BasicButton("line", guiLeft + 168, guiTop + 112, 168, 112, 8, 8, true));
		for(int i = 0; i < 6; i++){
			int j = i * 20;
			this.buttons.put("a" + i, new BasicButton("a" + i, guiLeft + 27, guiTop + 7 + j, 27, 7 + j, 8, 8, true));
			this.buttons.put("s" + i, new BasicButton("s" + i, guiLeft + 27, guiTop + 17 + j, 27, 17 + j, 8, 8, true));
			this.texts.put("tu" + i, new BasicText(guiLeft + 39, guiTop + 8 + j, 128, 0x6a6a6a, null));
			this.texts.put("td" + i, new BasicText(guiLeft + 39, guiTop + 16 + j, 128, 0x6a6a6a, null));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("tu0").string = container.cr ? "Custom Road Fill" : container.roadinv.getStackInSlot(0).isEmpty() ? "No Fill Block" : container.roadinv.getStackInSlot(0).getDisplayName();
		texts.get("td0").string = (size[0] + " block width");
		//
		texts.get("tu1").string = container.roadinv.getStackInSlot(1).isEmpty() ? "No Fill Block" : container.roadinv.getStackInSlot(1).getDisplayName();
		texts.get("td1").string = "ground fill " + (size[1] > 0 ? "enabled" : "disabled");
		//
		texts.get("tu2").string = container.roadinv.getStackInSlot(2).isEmpty() ? "No Fill Block" : container.roadinv.getStackInSlot(2).getDisplayName();
		texts.get("td2").string = "L side " + (size[2] > 0 ? size[2] + " blocks high" : "disabled");
		//
		texts.get("tu3").string = container.roadinv.getStackInSlot(3).isEmpty() ? "No Fill Block" : container.roadinv.getStackInSlot(3).getDisplayName();
		texts.get("td3").string = "R side " + (size[3] > 0 ? size[3] + " blocks high" : "disabled");
		//
		texts.get("tu4").string = container.ct ? "Custom Top Fill" : container.roadinv.getStackInSlot(4).isEmpty() ? "No Fill Block" : container.roadinv.getStackInSlot(4).getDisplayName();
		texts.get("td4").string = "top fill " + (size[4] > 0 ? "enabled" : "disabled");
		//
		texts.get("tu5").string = container.cl ? "Custom Lines Fill" : container.roadinv.getStackInSlot(5).isEmpty() ? "No Fill Block" : container.roadinv.getStackInSlot(5).getDisplayName();
		texts.get("td5").string = "lines fill " + (size[5] > 0 ? "enabled" : "disabled");
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
			openGui(UIKey.ID12_ROAD_TOOL_CUSTOM, new int[]{ 0, 0, 0 }, LISTENERID);
			return true;
		}
		else if(button.name.equals("roof")){
			openGui(UIKey.ID12_ROAD_TOOL_CUSTOM, new int[]{ 4, 0, 0 }, LISTENERID);
			return true;
		}
		else if(button.name.equals("line")){
			openGui(UIKey.ID12_ROAD_TOOL_CUSTOM, new int[]{ 5, 0, 0 }, LISTENERID);
			return true;
		}
		else if(button.name.startsWith("a")){
			int idx = Integer.parseInt(button.name.substring(1));
			size(idx, 1);
		}
		else if(button.name.startsWith("s")){
			int idx = Integer.parseInt(button.name.substring(1));
			size(idx, -1);
		}
		return false;
	}
	
	private void size(int idx, int am){
		switch(idx){
			case 0: if(size[idx] + am >= 0 && size[idx] + am <= 64) size[idx] += am; break;
			case 1: if(size[idx] + am >= 0 && size[idx] + am < 2) size[idx] += am; break;
			case 2: if(size[idx] + am >= 0 && size[idx] + am <= 64) size[idx] += am; break;
			case 3: if(size[idx] + am >= 0 && size[idx] + am <= 64) size[idx] += am; break;
			case 4: if(size[idx] + am >= 0 && size[idx] + am < 2) size[idx] += am; break;
			case 5: if(size[idx] + am >= 0 && size[idx] + am < 2) size[idx] += am; break;
		}
		save(false);
	}

	private void save(boolean close){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setIntArray("sizes", size);
		compound.setString("cargo", "save");
		compound.setBoolean("close", close);
		container.send(Side.SERVER, compound);
	}

	@Override
    public void keyTyped(char typedChar, int keyCode) throws IOException{
        if(keyCode == 1){
        	save(true);
            return;
        }
        else super.keyTyped(typedChar, keyCode);
    }
	
	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

