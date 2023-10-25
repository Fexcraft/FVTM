package net.fexcraft.mod.fvtm.util.cap.pass;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.util.I19U;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.uni.world.MessageSender;
import net.fexcraft.mod.uni.world.MessageSenderI;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class PassengerImplementation implements Passenger {

	private Entity entity;
	private int vehicle = -1, seatindex = -1;
	private byte check;
	private boolean notified;
	private MessageSender sender;

	@Override
	public void set(int veh, int seat){
		if (entity.world.isRemote && entity.isRiding() && seat > -1) {
			GenericVehicle geve = (GenericVehicle) entity.getRidingEntity();
			for (SeatCache cache : geve.seats) {
				if (cache.passenger() == entity) cache.passenger(null);
			}
		}
		vehicle = veh;
		seatindex = seat;
		if (!entity.world.isRemote) {
			update_packet();
			if (entity instanceof EntityPlayer && !notified) {
				try {
					Print.link(entity, I19U.trss("fvtm.seat.controls_info"), "https://fexcraft.net/wiki/mod/fvtm/controls");
					notified = true;
				}
				catch (Exception e) {
					//
				}
			}
		}
	}

	public void set(Entity entity) {
		this.entity = entity;
		if (entity.world.isRemote) {
			/*NBTTagCompound packet = new NBTTagCompound();
			packet.setString("target_listener", Resources.UTIL_LISTENER);
			packet.setString("task", "upg");
			packet.setInteger("entity", entity.getEntityId());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));*/
		}
		sender = new MessageSenderI(entity);
	}

	@Override
	public int vehicle() {
		return vehicle;
	}

	@Override
	public int seat() {
		return seatindex;
	}

	@Override
	public Entity entity() {
		return entity;
	}

	@Override
	public void update_packet() {
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", Resources.UTIL_LISTENER);
		packet.setString("task", "update_passenger");
		packet.setInteger("entity", entity.getEntityId());
		packet.setInteger("vehicle", vehicle);
		packet.setInteger("seat", seatindex);
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), Resources.getTargetPoint(entity));
	}

	@Override
	public void reconn(boolean skipcheck) {
		if (!skipcheck && check > 0) {
			check--;
			return;
		}
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", Resources.UTIL_LISTENER);
		packet.setString("task", "upg");
		packet.setInteger("entity", entity.getEntityId());
		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		check = 20;
	}

	@Override
	public MessageSender asSender(){
		return sender;
	}

}
