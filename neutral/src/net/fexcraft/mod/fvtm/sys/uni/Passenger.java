package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;

import static net.fexcraft.mod.fvtm.packet.Packets.PKT_TAG;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface Passenger extends EntityW {

	public SeatInstance getSeatOn();

	public default FvtmWorld getFvtmWorld(){
		return (FvtmWorld)getWorld();
	}

	public void set(int veh, int seatid);

	public int vehicle();

	public int seat();

	public V3D getEyeVec();

	public V3D getLookVec();

	public boolean isShiftDown();

	public default void sendPassUpdate(int ent, int veh, int seat){
		TagCW com = TagCW.create();
		com.set("ent", ent);
		com.set("veh", veh);
		com.set("seat", seat);
		Packets.sendToAllTrackingEnt(PKT_TAG, this, "upd_pass", com);
	}

	public default void reqPassUpdate(){
		TagCW com = TagCW.create();
		com.set("ent", getId());
		Packets.sendTo(PKT_TAG, this, "upd_pass", com);
	}

}
