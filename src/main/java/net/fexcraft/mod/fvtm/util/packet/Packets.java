package net.fexcraft.mod.fvtm.util.packet;

import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.ui.UniCon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Packets {
	
	private static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("fvtm");
	
	public static final void init(){
		FvtmLogger.LOGGER.log("Starting Packet Handler initialization.");
		//
		instance.registerMessage(PKTH_SeatUpdate.Client.class, PKT_SeatUpdate.class, 0, Side.CLIENT);
		instance.registerMessage(PKTH_SeatUpdate.Server.class, PKT_SeatUpdate.class, 1, Side.SERVER);
		instance.registerMessage(PKTH_VehKeyPress.class, PKT_VehKeyPress.class, 2, Side.SERVER);
		instance.registerMessage(PKTH_VehControl.Client.class, PKT_VehControl.class, 3, Side.CLIENT);
		instance.registerMessage(PKTH_VehControl.Server.class, PKT_VehControl.class, 4, Side.SERVER);
		instance.registerMessage(PKTH_SPUpdate.Client.class, PKT_SPUpdate.class, 5, Side.CLIENT);
		instance.registerMessage(PKTH_SPUpdate.Server.class, PKT_SPUpdate.class, 6, Side.SERVER);
		instance.registerMessage(PKTH_VehKeyPressState.Client.class, PKT_VehKeyPressState.class, 7, Side.CLIENT);
		instance.registerMessage(PKTH_VehKeyPressState.Server.class, PKT_VehKeyPressState.class, 8, Side.SERVER);
		//
		instance.registerMessage(PKTH_UT.Client.class, PKT_UT.class, 10, Side.CLIENT);
		instance.registerMessage(PKTH_UT.Server.class, PKT_UT.class, 10, Side.SERVER);
		//
		FvtmLogger.LOGGER.log("Done initialising Packet Handler.");
		FvtmLogger.LOGGER.log("Starting Packet Listener registration.");
		PKTH_UT.LIS_SERVER.put("ui", (com, player) -> {
			((UniCon)player.openContainer).container().packet(new TagCWI(com), false);
		});
		PKTH_UT.LIS_SERVER.put("vehicle", (com, player) -> {

		});
		if(EnvInfo.CLIENT){
			PKTH_UT.LIS_CLIENT.put("ui", (com, player) -> {
				((UniCon)player.openContainer).container().packet(new TagCWI(com), true);
			});
		}
		FvtmLogger.LOGGER.log("Completed Packet Listener registration.");
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

	public static final void sendToAllAround(IMessage packet, Object ent){
		instance.sendToAllAround(packet, Resources.getTargetPoint((Entity)ent));
	}

	public static final void sendTo(IMessage packet, EntityPlayerMP player){
		instance.sendTo(packet, player);
	}
	
}