package net.fexcraft.mod.fvtm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class GenericPlaceholderContainer extends Container {
	
	@Override
	public boolean canInteractWith(EntityPlayer player){
		return !(player == null);
	}
		
}