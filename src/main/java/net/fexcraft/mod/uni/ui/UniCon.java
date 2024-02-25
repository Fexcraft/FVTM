package net.fexcraft.mod.uni.ui;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.packet.PacketsImpl;
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
			Packets.sendTo(Packet_TagListener.class, player.getCapability(Capabilities.PASSENGER, null).asWrapper(), "ui", com);
		};
		con.SEND_TO_SERVER = com -> {
			Packets.send(Packet_TagListener.class, "ui", com);
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

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
		con.onClosed();
	}

}
