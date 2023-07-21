package net.fexcraft.mod.uni.uimpl;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniCon extends Container {

	protected EntityPlayer player;

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return player != null;
	}

	public void setPlayer(EntityPlayer player){
		this.player = player;
	}

}
