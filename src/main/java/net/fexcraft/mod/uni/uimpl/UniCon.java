package net.fexcraft.mod.uni.uimpl;

import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniCon extends Container {

	protected EntityPlayer player;
	protected ContainerInterface con;
	@SideOnly(Side.CLIENT)
	protected UniUI uni;

	public UniCon(ContainerInterface con){
		this.con = con;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return player != null;
	}

	public void setup(UniUI ui, EntityPlayer player){
		this.player = player;
		uni = ui;
	}

}
