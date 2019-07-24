package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleMain extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_main.png");

	public VehicleMain(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.width = 169; this.height = 125;
	}

	@Override
	protected void init(){
		this.texts.put("row0", new BasicText(20,  10, 160, MapColor.SNOW.colorValue, "Status/Info"));
		this.texts.put("row1", new BasicText(20,  24, 160, MapColor.SNOW.colorValue, "Settings"));
		this.texts.put("row2", new BasicText(20,  38, 160, MapColor.SNOW.colorValue, "Fuel"));
		this.texts.put("row3", new BasicText(20,  52, 160, MapColor.SNOW.colorValue, "Attributes"));
		this.texts.put("row4", new BasicText(20,  66, 160, MapColor.SNOW.colorValue, "Inventories"));
		this.texts.put("row5", new BasicText(20,  80, 160, MapColor.SNOW.colorValue, "Containers"));
		this.texts.put("row6", new BasicText(20,  94, 160, MapColor.SNOW.colorValue, "Script Data"));
		this.texts.put("row7", new BasicText(20, 108, 160, MapColor.SNOW.colorValue, "Exit"));
		for(int i = 0; i < 8; i++){
			this.buttons.put("row" + i, new BasicButton("row" + i, 7, 7 + (i * 14), 7, 7 + (i * 14), 155, 12, true));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 8; i++){
			texts.get("row" + i).x = guiLeft + 20;
			texts.get("row" + i).y = guiTop + 10 + (i * 14);
			buttons.get("row" + i).x = guiLeft + 7;
			buttons.get("row" + i).y = guiTop + 7 + (i * 14);
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("row7")){ player.closeScreen(); return true; }
		if(button.name.equals("row3")){ openGui("fvtm", 934, new int[]{ 0, 0, 0 }); return true; }
		if(button.name.equals("row4")){ openGui("fvtm", 935, new int[]{ 0, 0, 0 }); return true; }
		//
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

