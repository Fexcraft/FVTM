package net.fexcraft.mod.uni.uimpl;

import net.fexcraft.mod.fvtm.util.packet.PKT_UT;
import net.fexcraft.mod.fvtm.util.packet.Packets;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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

	public UniCon(ContainerInterface con, EntityPlayer player){
		this.con = con;
		this.player = player;
		con.SEND_TO_CLIENT = com -> {
			com.set("to", "ui");
			Packets.sendTo(new PKT_UT(com), (EntityPlayerMP)player);
		};
		con.SEND_TO_SERVER = com -> {
			com.set("to", "ui");
			Packets.sendToServer(new PKT_UT(com));
		};
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return player != null;
	}

	public void setup(UniUI ui){
		uni = ui;
	}

	public ContainerInterface container(){
		return con;
	}

}
