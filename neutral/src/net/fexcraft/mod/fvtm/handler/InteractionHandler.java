package net.fexcraft.mod.fvtm.handler;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.attribute.AttrBox;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler.DPIHData;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class InteractionHandler {

	private static FvtmWorld world;
	private static String last = "";
	private static long cooldown = 0;
	private static float seatbbs = .375f;
	private static float seatbbsh = .1875f;
	private static float th32 = .0625f * .5f;
	private static AABB aabb;

	/** Vehicle Interaction */
	public static boolean handle(KeyPress key, VehicleData vehdata, InteractRef ref, SeatInstance seat, Passenger pass, StackWrapper stack){
		if(key.mouse_right() && ref.isVehicle() && mountSeat(ref.vehicle(), seat, pass, stack)) return true;
		if(Time.getDate() < cooldown) return false;
		if(!stack.empty()){
			if(stack.isItemOf(ItemType.PART)){
				PartData data = stack.getContent(ContentType.PART);
				if(data.getType().getInstallHandlerData() instanceof DPIHData && tryInstall(vehdata, ref, data, seat, pass)) return true;
				if(data.getType().getInstallHandlerData() instanceof TireData && tryWTInstall(vehdata, ref, data, seat, pass)) return true;
				if(data.getType().getInstallHandlerData() instanceof WheelData && tryWTInstall(vehdata, ref, data, seat, pass)) return true;
				return false;
			}
			if(stack.isItemOf(ItemType.MATERIAL)){
				Material mat = stack.getContent(ContentType.MATERIAL);
				if(mat.getImpactLevel() > -1 && tryWheelRemoval(vehdata, ref, stack, mat, pass)) return true;
			}
			if(stack.isItemOf(ItemType.FVTM_TOOLBOX)){
				boolean prt = EnvInfo.is112() ? stack.damage() == 0 : stack.getID().endsWith("_0");
				boolean tex = EnvInfo.is112() ? stack.damage() == 1 : stack.getID().endsWith("_1");
				if(prt && tryRemTex(vehdata, ref, seat, pass, false)) return true;
				if(tex && tryRemTex(vehdata, ref, seat, pass, true)) return true;
			}
			return false;
		}
		List<Attribute<?>> attributes = vehdata.getAttributes().values().stream().filter(attr -> attr.hasBoxes() && (attr.valuetype.isTristate() || attr.valuetype.isNumber()) && (seat == null ? attr.external : (seat.seat.driver || attr.access.contains(seat.seat.name)))).collect(Collectors.toList());
		if(attributes.size() == 0) return false;
		ArrayList<AttrInteractive> list = new ArrayList<>();
		attributes.forEach(attr -> list.add(new AttrInteractive(attr)));
		AttrInteractive inter = getInteracted(seat == null, vehdata, ref, pass, list);
		if(inter == null) return false;
		Attribute<?> attr = inter.attribute;
		if(attr.id.equals(last) && Time.getDate() < cooldown) return true;
		return toggle(attr, vehdata, ref, key, null, pass);
	}

	private static boolean tryInstall(VehicleData vehdata, InteractRef ref, PartData data, SeatInstance seat, Passenger pass){
		ArrayList<Interactive> list = new ArrayList<>();
		SwivelPoint point = null;
		for(Entry<String, PartSlots> entry : vehdata.getPartSlotProviders().entrySet()){
			point = vehdata.getRotationPointOfPart(entry.getKey());
			for(Entry<String, PartSlot> sentry : entry.getValue().entrySet()){
				String type = sentry.getValue().type;
				if(vehdata.hasPart(type)){
					Part part = vehdata.getPart(type).getType();
					if(!(part.getInstallHandlerData() instanceof DPIHData) || !((DPIHData)part.getInstallHandlerData()).swappable) continue;
				}
				for(String sub : data.getType().getCategories()){
					if(!sub.equals(type)) continue;
					list.add(new PartSlotInteractive(point, entry.getKey(), entry.getValue(), sentry.getKey()));
				}
			}
		}
		PartSlotInteractive res = getInteracted(seat == null, vehdata, ref, pass, list);
		if(res == null) return false;
		if(res.id().equals(last) && Time.getDate() < cooldown) return true;
		TagCW com = TagCW.create();
		com.set("source", res.source);
		com.set("category", res.category);
		ref.setPacket(com);
		Packets.send(Packet_TagListener.class, "install_part", com);
		last = res.id();
		cooldown = Time.getDate() + 20;
		return true;
	}

	private static boolean tryWTInstall(VehicleData vehdata, InteractRef ref, PartData data, SeatInstance seat, Passenger pass){
		ArrayList<Interactive> list = new ArrayList<>();
		boolean tire = data.getType().getInstallHandlerData() instanceof TireData;
		if(tire){
			for(Entry<String, WheelSlot> entry : vehdata.getWheelSlots().entrySet()){
				if(vehdata.hasPart(entry.getKey() + ":tire")) continue;
				if(!vehdata.hasPart(entry.getKey())) continue;
				PartData part = vehdata.getPart(entry.getKey());
				WheelData wd = part.getType().getInstallHandlerData();
				if(wd.hasTire()) continue;
				list.add(new WheelInteractive(entry.getKey(), entry.getValue()));
			}
		}
		else{
			for(Entry<String, WheelSlot> entry : vehdata.getWheelSlots().entrySet()){
				if(vehdata.hasPart(entry.getKey())) continue;
				list.add(new WheelInteractive(entry.getKey(), entry.getValue()));
			}
		}
		WheelInteractive res = getInteracted(seat == null, vehdata, ref, pass, list);
		if(res == null) return false;
		if(res.id().equals(last) && Time.getDate() < cooldown) return true;
		TagCW com = TagCW.create();
		com.set("category", res.category);
		ref.setPacket(com);
		Packets.send(Packet_TagListener.class, "install_wheel", com);
		last = res.id();
		cooldown = Time.getDate() + 20;
		return true;
	}

	private static boolean tryWheelRemoval(VehicleData data, InteractRef ref, StackWrapper stack, Material mat, Passenger pass){
		if(data.getType().getImpactWrenchLevel() > mat.getImpactLevel()) return false;
		ArrayList<Interactive> list = new ArrayList<>();
		for(Entry<String, WheelSlot> entry : data.getWheelSlots().entrySet()){
			if(data.hasPart(entry.getKey())){
				list.add(new WheelInteractive(entry.getKey(), entry.getValue()));
			}
		}
		WheelInteractive res = getInteracted(true, data, ref, pass, list);
		if(res == null) return false;
		if(res.id().equals(last) && Time.getDate() < cooldown) return true;
		TagCW com = TagCW.create();
		com.set("category", res.category);
		ref.setPacket(com);
		Packets.send(Packet_TagListener.class, "remove_wheel", com);
		last = res.id();
		cooldown = Time.getDate() + 20;
		return true;
	}

	private static boolean tryRemTex(VehicleData vehdata, InteractRef ref, SeatInstance seat, Passenger pass, boolean tex){
		ArrayList<Interactive> list = new ArrayList<>();
		SwivelPoint point;
		for(Entry<String, PartData> entry : vehdata.getParts().entrySet()){
			point = vehdata.getRotationPointOfPart(entry.getKey());
			if(!tex){
				if(!(entry.getValue().getType().getInstallHandlerData() instanceof DPIHData)) continue;
				if(!((DPIHData)entry.getValue().getType().getInstallHandlerData()).removable) continue;
			}
			list.add(new InstPartInteractive(point, entry));
		}
		InstPartInteractive res = getInteracted(seat == null, vehdata, ref, pass, list);
		if(res == null) return false;
		if(res.id().equals(last) && Time.getDate() < cooldown) return true;
		TagCW com = TagCW.create();
		com.set("category", res.category);
		ref.setPacket(com);
		Packets.send(Packet_TagListener.class, tex ? "texture_part" : "remove_part", com);
		last = res.id();
		cooldown = Time.getDate() + 20;
		return true;
	}

	public static boolean toggle(Attribute<?> attr, VehicleData data, InteractRef ref, KeyPress press, Float val, Passenger pass){
		TagCW packet = TagCW.create();
		packet.set("attr", attr.id);
		ref.setPacket(packet);
		switch(press){
			case MOUSE_MAIN:{
				if(attr.valuetype.isTristate()){
					packet.set("bool", !attr.valuetype.isBoolean() ? false : !attr.asBoolean());
					pass.bar("interact.fvtm.attribute.toggle_bool", attr.id, packet.getBoolean("bool"));
				}
				else if(attr.valuetype.isFloat()){
					float flaot = attr.asFloat() + (val != null ? val : attr.getBox(attr.asString()).increase);
					packet.set("value", flaot);
					attr.set(flaot);
					pass.bar("interact.fvtm.attribute.increase_number", attr.id, packet.getFloat("value"));
				}
				else if(attr.valuetype.isInteger()){
					int ent = attr.asInteger() + (int)(val != null ? val : attr.getBox(attr.asString()).increase);
					packet.set("value", ent);
					attr.set(ent);
					pass.bar("interact.fvtm.attribute.increase_number", attr.id, packet.getInteger("value"));
				}
				break;
			}
			case MOUSE_RIGHT:{
				if(attr.valuetype.isTristate()){
					packet.set("bool", !attr.valuetype.isBoolean() ? true : !attr.asBoolean());
					pass.bar("interact.fvtm.attribute.toggle_bool", attr.id, packet.getBoolean("bool"));
				}
				else if(attr.valuetype.isFloat()){
					float flaot = attr.asFloat() - (val != null ? -val : attr.getBox(attr.asString()).decrease);
					packet.set("value", flaot);
					attr.set(flaot);
					pass.bar("interact.fvtm.attribute.decrease_number", attr.id, packet.getFloat("value"));
				}
				else if(attr.valuetype.isInteger()){
					int ent = attr.asInteger() - (int)(val != null ? -val : attr.getBox(attr.asString()).decrease);
					packet.set("value", ent);
					attr.set(ent);
					pass.bar("interact.fvtm.attribute.decrease_number", attr.id, packet.getInteger("value"));
				}
				break;
			}
			case RESET:{
				if(attr.valuetype.isTristate()){
					packet.set("bool", false);
					packet.set("reset", true);
					pass.bar("interact.fvtm.attribute.reset_bool", attr.id);
				}
				else if(attr.valuetype.isFloat()){
					float flaot = val != null ? val : attr.getBox(attr.asString()).reset;
					packet.set("value", flaot);
					attr.set(flaot);
					pass.bar("interact.fvtm.attribute.reset_number", attr.id, packet.getFloat("value"));
				}
				else if(attr.valuetype.isInteger()){
					int ent = (int)(val != null ? val : attr.getBox(attr.asString()).reset);
					packet.set("value", ent);
					attr.set(ent);
					pass.bar("interact.fvtm.attribute.reset_number", attr.id, packet.getInteger("value"));
				}
				break;
			}
			default:
				return false;
		}
		if(pass.isOnClient()){
			Packets.send(Packet_TagListener.class, "attr_toggle", packet);
			last = attr.id;
			cooldown = Time.getDate() + 20;
		}
		else{
			FvtmLogger.marker("ERROR:INTERACT-ON-SERVER " + packet.toString());
		}
		return true;
	}

	public static boolean handle(KeyPress key, StackWrapper stack){
		if(!stack.empty() && !stack.isItemOfAny(ItemType.PART, ItemType.MATERIAL, ItemType.FVTM_TOOLBOX, ItemType.LEAD)) return false;
		world = WrapperHolder.getClientWorld();
		Passenger pass = world.getClientPassenger();
		Map<VehicleData, InteractRef> vehs = world.getVehicleDatas(pass.getPos());
		for(Entry<VehicleData, InteractRef> veh : vehs.entrySet()){
			if(handle(key, veh.getKey(), veh.getValue(), pass.getSeatOn(), pass, stack)) return true;
		}
		return false;
	}

	private static boolean mountSeat(VehicleInstance vehicle, SeatInstance seat, Passenger pass, StackWrapper stack){
		if(vehicle == null) return false;
		if(last.equals("seat") && Time.getDate() < cooldown) return false;
		if(!stack.empty() && stack.isItemOfAny(ItemType.LEAD, ItemType.FVTM_TOOLBOX)) return false;
		if(seat == null) seat = pass.getSeatOn();
		V3D evec = pass.getEyeVec();
		V3D lvec = evec.add(pass.getLookVec().multiply(3));
		V3D vec0;
		for(int i = 0; i < vehicle.data.getSeats().size(); i++){
			if(seat != null && seat.index == i) continue;
			SeatInstance nseat = vehicle.seats.get(i);
			if(nseat.passenger_direct() != null) continue;
			SwivelPoint point = nseat.point;
			vec0 = point.getRelativeVector(nseat.seat.pos).add(vehicle.entity.getPos());
			aabb = AABB.create(-seatbbsh, -.0125, -seatbbsh, seatbbsh, seatbbs - .0125, seatbbsh).offset(vec0);
			for(float f = 0; f < 3.125f; f += th32){
				vec0 = evec.distance(lvec, f);
				if(aabb.contains(vec0)){
					TagCW com = TagCW.create();
					com.set("entity", vehicle.entity.getId());
					com.set("seat", i);
					Packets.send(Packet_TagListener.class, "mount_seat", com);
					cooldown = Time.getDate() + 20;
					last = "seat";
					return true;
				}
			}
		}
		return false;
	}

	private static <I extends Interactive> I getInteracted(boolean external, VehicleData data, InteractRef ref, Passenger pass, ArrayList<? extends Interactive> list){
		if(pass.getFvtmWorld().noViewEntity()) return null;
		V3D evec = pass.getEyeVec();
		V3D lvec = evec.add(pass.getLookVec().multiply(external ? 3 : 2));
		V3D vec0;
		LinkedHashMap<String, AABB> map = new LinkedHashMap<>();
		for(Interactive inter : list){
			inter.collect(external, data, ref, pass, map);
		}
		for(float f = 0; f < (external ? 3.125f : 2.125f); f += th32){
			vec0 = evec.distance(lvec, f);
			for(Interactive inter : list){
				if(map.containsKey(inter.id()) && map.get(inter.id()).contains(vec0)) return (I)inter;
			}
		}
		return null;
	}

	private static interface Interactive {

		public String id();

		public void collect(boolean external, VehicleData data, InteractRef ref, Passenger player, Map<String, AABB> aabbs);

	}

	public static class AttrInteractive implements Interactive {

		protected Attribute<?> attribute;
		private SwivelPoint point;
		private WheelSlot wheel;
		private PartSlots slots;
		private String source;
		private String category;

		public AttrInteractive(Attribute attr){
			attribute = attr;
		}

		@Override
		public String id(){
			return attribute.id;
		}

		@Override
		public void collect(boolean external, VehicleData data, InteractRef ref, Passenger player, Map<String, AABB> aabbs){
			String val = attribute.asString();
			if(external) val = "external-" + val;
			AttrBox ab = attribute.getBox(val);
			PartData part = data.getAttributeOrigin(attribute);
			if(ab == null) return;
			point = data.getRotationPoint(ab.swivel_point);
			V3D pos = point.getRelativeVector(ab.pos.add(part == null ? V3D.NULL : part.getInstalledPos())).add(ref.pos);
			double hs = ab.size * .5;
			aabbs.put(attribute.id, AABB.create(pos.x - hs, pos.y - hs, pos.z - hs, pos.x + hs, pos.y + hs, pos.z + hs));
		}

	}

	public static class PartSlotInteractive implements Interactive {

		private SwivelPoint point;
		private PartSlots slots;
		private String source;
		private String category;

		public PartSlotInteractive(SwivelPoint spoint, String src, PartSlots pslots, String cat){
			point = spoint;
			source = src;
			slots = pslots;
			category = cat;
		}

		@Override
		public String id(){
			return source + ":" + category;
		}

		@Override
		public void collect(boolean external, VehicleData data, InteractRef ref, Passenger player, Map<String, AABB> aabbs){
			V3D pos = slots.get(category).pos.copy();
			if(!source.equals("vehicle")){
				pos = pos.add(data.getPart(source).getInstalledPos());
			}
			pos = point.getRelativeVector(pos).add(ref.pos);
			double hs = slots.get(category).radius * .5;
			aabbs.put(id(), AABB.create(pos.x - hs, pos.y - hs, pos.z - hs, pos.x + hs, pos.y + hs, pos.z + hs));
		}

	}

	public static class InstPartInteractive implements Interactive {

		private SwivelPoint point;
		private PartData part;
		private String category;

		public InstPartInteractive(SwivelPoint spoint, Entry<String, PartData> entry){
			point = spoint;
			part = entry.getValue();
			category = entry.getKey();
		}

		@Override
		public String id(){
			return category;
		}

		@Override
		public void collect(boolean external, VehicleData data, InteractRef ref, Passenger player, Map<String, AABB> aabbs){
			V3D pos = point.getRelativeVector(part.getInstalledPos()).add(ref.pos);
			aabbs.put(id(), AABB.create(pos.x - .25, pos.y - .25, pos.z - .25, pos.x + .25, pos.y + .25, pos.z + .25));
		}

	}

	public static class WheelInteractive implements Interactive {

		private WheelSlot wheel;
		private String category;

		public WheelInteractive(String key, WheelSlot slot){
			category = key;
			wheel = slot;
		}

		@Override
		public String id(){
			return category;
		}

		@Override
		public void collect(boolean external, VehicleData data, InteractRef ref, Passenger player, Map<String, AABB> aabbs){
			V3D pos = data.getRotationPoint(SwivelPoint.DEFAULT).getRelativeVector(wheel.position).add(ref.pos);
			double hs = wheel.max_radius * .5;
			aabbs.put(id(), AABB.create(pos.x - hs, pos.y - hs, pos.z - hs, pos.x + hs, pos.y + hs, pos.z + hs));
		}

	}

	public static class InteractRef {

		protected VehicleInstance inst;
		protected InteractRefHolder holder;
		protected V3I blkpos;
		protected long lpos;
		protected V3D pos;

		public InteractRef(InteractRefHolder irholder){
			holder = irholder;
		}

		public InteractRef(VehicleInstance vehinst){
			inst = vehinst;
			update();
		}

		public boolean isVehicle(){
			return inst != null;
		}

		public VehicleInstance vehicle(){
			return inst;
		}

		public void update(){
			pos = inst.entity.getPos();
		}

		public void setPacket(TagCW com){
			if(inst != null){
				com.set("entity", inst.entity.getId());
			}
			else{
				com.set("lift", blkpos.toIntegerArray());
			}
		}

		public InteractRef set(V3I vec, long gpos, V3D vpos){
			blkpos = vec;
			lpos = gpos;
			pos = vpos;
			return this;
		}

		public long longpos(){
			return lpos;
		}

		public InteractRefHolder holder(){
			return holder;
		}
	}

	public static interface InteractRefHolder {

		public void markChanged();
	}

}
