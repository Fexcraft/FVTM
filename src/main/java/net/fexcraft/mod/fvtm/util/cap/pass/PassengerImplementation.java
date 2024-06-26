package net.fexcraft.mod.fvtm.util.cap.pass;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.PassCap;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.util.I19U;
import net.fexcraft.mod.uni.world.EntityWIE;
import net.fexcraft.mod.uni.world.MessageSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.getTargetPoint;

public class PassengerImplementation implements PassCap {

	private Entity entity;
	private int vehicle = -1, seatindex = -1;
	private byte check;
	private boolean notified;
	private Passenger wrapper;

	@Override
	public void set(int veh, int seatid){
		if(entity.world.isRemote && entity.isRiding() && seatid > -1) {
			RootVehicle geve = (RootVehicle)entity.getRidingEntity();
			for(SeatInstance seat : geve.vehicle.seats){
				if(seat.passenger_direct() == entity) seat.passenger(null);
			}
		}
		vehicle = veh;
		seatindex = seatid;
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
		wrapper = new EntityWIE(entity);
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
		packet.setString("target_listener", UTIL_LISTENER);
		packet.setString("task", "update_passenger");
		packet.setInteger("entity", entity.getEntityId());
		packet.setInteger("vehicle", vehicle);
		packet.setInteger("seat", seatindex);
		PacketHandler.getInstance().sendToAllAround(new PacketNBTTagCompound(packet), getTargetPoint(entity));
	}

	@Override
	public void reconn(boolean skipcheck) {
		if (!skipcheck && check > 0) {
			check--;
			return;
		}
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", UTIL_LISTENER);
		packet.setString("task", "upg");
		packet.setInteger("entity", entity.getEntityId());
		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
		check = 20;
	}

	@Override
	public MessageSender asSender(){
		return wrapper;
	}

	@Override
	public Passenger asWrapper(){
		return wrapper;
	}

}
