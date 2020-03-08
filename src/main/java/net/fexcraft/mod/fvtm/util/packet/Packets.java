package net.fexcraft.mod.fvtm.util.packet;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Packets {
	
	private static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("fvtm");
	
	public static final void init(){
		Print.log("[FVTM] Starting Packet Handler initialization.");
		//
		instance.registerMessage(PKTH_SeatUpdate.Client.class, PKT_SeatUpdate.class, 0, Side.CLIENT);
		instance.registerMessage(PKTH_SeatUpdate.Server.class, PKT_SeatUpdate.class, 1, Side.SERVER);
		instance.registerMessage(PKTH_SeatDismount.Client.class, PKT_SeatDismount.class, 2, Side.CLIENT);
		instance.registerMessage(PKTH_VehKeyPress.class, PKT_VehKeyPress.class, 3, Side.SERVER);
		instance.registerMessage(PKTH_VehControl.Client.class, PKT_VehControl.class, 4, Side.CLIENT);
		instance.registerMessage(PKTH_VehControl.Server.class, PKT_VehControl.class, 5, Side.SERVER);
		instance.registerMessage(PKTH_SPUpdate.Client.class, PKT_SPUpdate.class, 6, Side.CLIENT);
		instance.registerMessage(PKTH_SPUpdate.Server.class, PKT_SPUpdate.class, 7, Side.SERVER);
		//
		Print.log("[FVTM] Done initialising Packet Handler.");
	}
	
	public static final void sendToServer(IMessage packet){
		instance.sendToServer(packet);
	}

	public static final void sendToAllAround(IMessage packet, TargetPoint point){
		instance.sendToAllAround(packet, point);
	}

	public static final void sendToAllAround(IMessage packet, Entity ent){
		instance.sendToAllAround(packet, Resources.getTargetPoint(ent));
	}

	public static final void sendTo(IMessage packet, EntityPlayerMP player){
		instance.sendTo(packet, player);
	}
	
}