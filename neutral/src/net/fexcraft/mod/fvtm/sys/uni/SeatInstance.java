package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.util.Pivot;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SeatInstance {

	public final int index;
	public final VehicleInstance root;
	public final SwivelPoint point;
	public final Seat seat;
	private EntityW passenger;
	public boolean controlmode;
	//
	public Pivot slook;
	public Pivot pslook;
	public Pivot elook;
	public Pivot pelook;
	public float eyaw;
	public float epitch;
	public float peyaw;
	public float pepitch;
	public byte clicktimer;
	public byte interacttimer;
	private ConcurrentHashMap<KeyPress, byte[]> attrkeys = new ConcurrentHashMap<>();
	private Collection<Attribute> seatattrs;

	public SeatInstance(VehicleInstance veh, int idx){
		root = veh;
		index = idx;
		seat = veh.data.getSeat(index);
		point = veh.data.getRotationPoint(seat.swivel_point);
		seatattrs = root.data.getAttributes().values().stream().filter(pr -> (pr.valuetype.isTristate() || pr.valuetype.isNumber()) && pr.access.contains(seat.name)).collect(Collectors.toList());
		for(KeyPress key : KeyPress.values()){
			for(Attribute attr : seatattrs){
				if(attr.getKeyValue(key) != null){
					attrkeys.put(key, new byte[]{ 0 });
					break;
				}
			}
		}
		resetPivots();
	}

	private void resetPivots(){
		pslook = new Pivot();
		slook = new Pivot();
		pelook = new Pivot();
		elook = new Pivot();
		slook.set_rotation((seat.minyaw + seat.maxyaw) / 2, 0, 0, true);
		pslook.set_rotation((seat.minyaw + seat.maxyaw) / 2, 0, 0, true);
	}

	public EntityW passenger(){
		return passenger;
	}

	public Object passenger_direct(){
		return passenger == null ? null : passenger.direct();
	}

	public void passenger(EntityW pass){
		if(pass != null){
			SeatInstance old = root.getSeatOf(pass);
			if(old != null && old != this) old.passenger(null);
		}
		passenger = pass;
		resetPivots();
		eyaw = peyaw = seat.defyaw;
		epitch = pepitch = seat.defpitch;
		elook.set_rotation(eyaw, epitch, 0, true);
		pelook.set_rotation(peyaw, pepitch, 0, true);
		slook.set_rotation(eyaw, epitch, 0, true);
		pslook.set_rotation(peyaw, pepitch, 0, true);
	}

	public void update(){
		if(attrkeys.size() > 0){
			for(byte[] bt : attrkeys.values()) if(bt[0] > 0) bt[0]--;
		}
		if(clicktimer > 0) clicktimer--;
		if(interacttimer > 0) interacttimer--;
		if(passenger == null) return;
		peyaw = eyaw;
		pepitch = epitch;
		eyaw = elook.deg_yaw() + point.getPivot().deg_yaw();
		epitch = elook.pitch() + point.getPivot().deg_pitch();
		//passenger.setYawPitch(peyaw, pepitch, eyaw, epitch);
	}

	public V3D getCurrentLocalPosition(){
		return point.getRelativeVector(seat.pos);
	}

	public V3D getCurrentGlobalPosition(){
		return point.getRelativeVector(seat.pos).add(root.getV3D());
	}

	public boolean passengerIsPlayer(){
		return passenger != null && passenger.isPlayer();
	}

	public boolean onKeyPress(KeyPress key, EntityW player){
		return onKeyPress(key, player, false);
	}

	public boolean onKeyPress(KeyPress key, EntityW player, boolean state){
		if(key == null) return false;
		if(key.control() && seat.driver){
			if(clicktimer > 0) return false;
			controlmode = !controlmode;
			player.bar("fvtm.seat.control_mode." + (controlmode ? "on" : "off"));
			clicktimer += 10;
			return true;
		}
		else if(key.toggle_input && root.entity.isOnClient()){
			if(clicktimer > 0) return false;
			boolean bool = InteractionHandler.handle(key, root.data, root.iref(), this, player, StackWrapper.EMPTY);
			clicktimer += 10;
			return bool;
		}
		else if((controlmode || !seat.driver) && root.entity.isOnClient()){
			if(attrKeyPress(key, player)) return true;
			if(controlmode) return true;
		}
		else if(key.dismount() && root.entity.isOnClient() && passenger != null){
			passenger.dismount(root.data.getRotationPoint(seat.swivel_point).getRelativeVector(seat.dis).add(root.getV3D()));
			//return true;
		}
		return root.onKeyPress(key, seat, player, state, false);
	}

	private boolean attrKeyPress(KeyPress key, EntityW player){
		if(!attrkeys.containsKey(key)) return false;
		if(attrkeys.get(key)[0] > 0) return false;
		boolean bool = false;
		for(Attribute<?> attr : seatattrs){
			Float val = attr.getKeyValue(key);
			if(val != null){
				KeyPress mouse = val == 0 ? KeyPress.RESET : val > 0 ? KeyPress.MOUSE_MAIN : KeyPress.MOUSE_RIGHT;
				if(InteractionHandler.toggle(attr, root.data, root.iref(), mouse, val, player)) bool = true;
			}
		}
		attrkeys.get(key)[0] += 5;
		return bool;
	}

}
