package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRef;
import net.fexcraft.mod.fvtm.packet.Packet_VehMove;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface FvtmWorld {

	public SeatInstance getSeat(int entid, int seatid);

	public SwivelPoint getSwivelPoint(int entid, String pointid);

	public Passenger getPassenger(int source);

	public VehicleInstance getVehicle(int entid);

	public Map.Entry<VehicleData, InteractRef> getInteractRef(TagCW packet);

	public boolean noViewEntity();

	public ArrayList<VehicleInstance> getVehicles(V3D pos);

	public Map<VehicleData, InteractRef> getVehicleDatas(V3D pos);

	public Passenger getClientPassenger();

	public boolean isFvtmRoad(StateWrapper state);

	public default boolean isFvtmRoad(Object state){
		return isFvtmRoad(StateWrapper.of(state));
	}

	public int getRoadHeight(StateWrapper state);

	public StateWrapper getRoadWithHeight(StateWrapper block, int height);

	public void handleBlockEntityPacket(TagCW com, Passenger player);

	public void spawnRailEntity(RailEntity ent);

	public void spawnLandEntity(VehicleData data, V3D pos, EntityW placer);

}
