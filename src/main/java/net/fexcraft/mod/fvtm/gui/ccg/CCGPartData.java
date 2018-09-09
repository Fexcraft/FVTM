package net.fexcraft.mod.fvtm.gui.ccg;

import java.io.IOException;
import java.util.List;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class CCGPartData extends GenericGui<CCGPartData.Container> {
	
	private int[] pos;
	private ConstructorControllerEntity tile;
	private int scroll = 0;

	public CCGPartData(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/ccg_part_data.png"), new Container(), player);
		this.xSize = 200; this.ySize = 160; this.pos = new int[]{ x, y, z };
		tile = (ConstructorControllerEntity)world.getTileEntity(new BlockPos(x, y, z));
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(guiLeft + 13, guiTop + 4, 182, null, "0"));
		//this.texts.put("offset", new BasicText(guiLeft + 13, guiTop + 20, 64, null, "Offset:"));
		this.texts.put("subtitle", new BasicText(guiLeft + 13, guiTop + 38, 182, null, "Compatible with:"));
		//
		this.buttons.put("+", new BasicButton("+", guiLeft + 3, guiTop + 135, 3, 135, 8, 10, false));
		this.buttons.put("-", new BasicButton("-", guiLeft + 3, guiTop +  51, 3,  51, 8, 10, false));
		//
		for(int i = 0; i < 8; i++){
			this.texts.put("row" + i, new BasicText(guiLeft + 13, guiTop + 52 + (i * 12), 181, null, i + ""));
		}
		buttons.put("eject", new BasicButton("", guiLeft + 2, guiTop + 152, 2, 152, 196, 6, true));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(tile.getPartData() == null){
			texts.get("title").string = "no part selected";
			buttons.get("+").enabled = false; buttons.get("-").enabled = false;
		}
		else{
			texts.get("title").string = tile.getPartData().getPart().getName();
			List<ResourceLocation> list = tile.getPartData().getPart().getCompatibleVehicles();
			if(check(list)){
				texts.get("subtitle").string =
					Formatter.PARAGRAPH_SIGN + "8Compatible with " + Formatter.PARAGRAPH_SIGN + "9Any " + Formatter.PARAGRAPH_SIGN  + "8Vehicle";
			}
			else{
				texts.get("subtitle").string = "Compatible with: (" + scroll + "/" + list.size() + ")";
			}
			buttons.get("+").enabled = scroll < list.size();
			buttons.get("-").enabled = scroll > 0;
			//
			for(int j = 0; j < 8; j ++){
				int k = scroll + j; texts.get("row" + j).string = k >= list.size() ? "" : list.get(k).toString();
			}
		}
	}

	private boolean check(List<ResourceLocation> list){ if(list.size() == 0) return true;
		return list.get(0).getResourcePath().equals("all") || list.get(0).getResourcePath().equals("any") || list.get(0).getResourcePath().equals("*");
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		switch(key){
			case "+": scroll = ++scroll > (tile.getPartData() == null ? 0 : tile.getPartData().getPart().getCompatibleVehicles().size()) ? --scroll : scroll; break;
			case "-": scroll = --scroll < 0 ? 0 : scroll; break;
			case "eject":{
				//TODO
				break;
			}
		}
	}
	
	public static class Container extends GenericGuiContainer {

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			//
		}
		
	}
	
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(keyCode == 1) this.openGui(GuiHandler.CCG_Main, pos);
        super.keyTyped(typedChar, keyCode);
    }
	
}