package net.fexcraft.mod.fvtm.gui.constructor;

import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ConstructorMain extends ConstructorGui {

	public ConstructorMain(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		this.buttontext = new String[]{
			"Const. Status", "Vehicle Info", "",
			"Part Cache", "Part Manager", "Part Installer",
			"", "Texture Manager", "Spraying Tool", "", "Exit"};
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(texts.get(button.name).string.equals("")) return;
		if(button.name.equals("button10")){ player.closeScreen(); return; }
		this.openGui(modid, Integer.parseInt(button.name.replace("button", "") + 901), xyz); return;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}

}
