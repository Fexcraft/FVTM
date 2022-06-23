package net.fexcraft.mod.fvtm.gui.construct;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ConstMain extends ConstGui {

	public ConstMain(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
	}
	
	@Override
	public void init(){
		super.init();
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.SAVE);
		addTopButton(ConstGuiElement.SPAWN);
		finish_init();
	}

}
