package net.fexcraft.mod.fvtm.gui.ccg;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class CCGPartInstaller extends GenericGui<CCGPartInstaller.Container> {
	
	//private int[] pos;
	private ConstructorControllerEntity tile;
	private int scroll = 0;

	public CCGPartInstaller(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/ccg_installer.png"), new Container(), player);
		this.xSize = 142; this.ySize = 128; //this.pos = new int[]{ x, y, z };
		tile = (ConstructorControllerEntity)world.getTileEntity(new BlockPos(x, y, z));
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(guiLeft + 13, guiTop +  4, 124, null, "Install: x...xx...x"));
		//
		this.buttons.put("+", new BasicButton("+", guiLeft + 3, guiTop + 103, 3, 103, 8, 10, false));
		this.buttons.put("-", new BasicButton("-", guiLeft + 3, guiTop +  19, 3,  19, 8, 10, false));
		//
		for(int i = 0; i < 8; i++){
			this.texts.put("row" + i, new BasicText(guiLeft + 13, guiTop + 20 + (i * 12), 124, null, i + ""));
			this.buttons.put("row" + i, new BasicButton("row" + i, guiLeft + 11, guiTop + 19 + (i * 12), 11, 19, 128, 10, false));
		}
		//
		this.texts.put("custom", new BasicText(guiLeft + 13, guiTop + 116, 48, null, "Custom: "));
		this.buttons.put("custom", new BasicButton("custom", guiLeft + 11, guiTop + 115, 11, 115, 52, 10, false));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		boolean nell = tile.getPartData() == null;
		texts.get("title").string = nell ? "no part in constructor" : "Install: " + tile.getPartData().getPart().getName();
		for(int i = 0; i < 8; i++){
			int j = i + scroll;
			if(nell){
				buttons.get("-").enabled = buttons.get("+").enabled = false;
				buttons.get("row" + i).enabled = false; texts.get("row" + i).string = "";
			}
			else{
				buttons.get("-").enabled = scroll > 0; buttons.get("+").enabled = scroll < tile.getPartData().getPart().getCategories().size();
				buttons.get("row" + i).enabled = !(j >= tile.getPartData().getPart().getCategories().size());
				texts.get("row" + i).string = j >= tile.getPartData().getPart().getCategories().size() ? "" : tile.getPartData().getPart().getCategories().get(j);
			}
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		switch(key){
		case "+": scroll = ++scroll > (tile.getPartData() == null ? 0 : tile.getPartData().getPart().getCategories().size()) ? --scroll : scroll; break;
		case "-": scroll = --scroll < 0 ? 0 : scroll; break;
		//
	}
	}
	
	public static class Container extends GenericGuiContainer {

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			//
		}
		
	}
	
}