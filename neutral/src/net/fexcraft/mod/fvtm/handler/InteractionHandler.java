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
import net.fexcraft.mod.fvtm.data.inv.FvtmInv;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler.DPIHData;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignRegion;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.sys.wire.*;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toList;
import static net.fexcraft.mod.fvtm.data.ToolboxType.*;
import static net.fexcraft.mod.fvtm.item.ToolboxItem.getToolboxType;

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
	private static boolean is_toolbox;

	/** Vehicle Interaction */
	public static boolean handle(KeyPress key, VehicleData vehdata, InteractRef ref, SeatInstance seat, Passenger pass, StackWrapper stack){
		if(key.mouse_right() && ref.isVehicle() && mountSeat(ref.vehicle(), seat, pass, stack)) return true;
		if(Time.getDate() < cooldown) return false;
		if(!stack.empty()){
			if(stack.isItemOf(ContentType.PART.item_type)){
				PartData data = stack.getContent(ContentType.PART.item_type);
				if(data.getType().getInstallHandlerData() instanceof DPIHData && tryInstall(vehdata, ref, data, seat, pass)) return true;
				if(data.getType().getInstallHandlerData() instanceof TireData && tryWTInstall(vehdata, ref, data, seat, pass)) return true;
				if(data.getType().getInstallHandlerData() instanceof WheelData && tryWTInstall(vehdata, ref, data, seat, pass)) return true;
				return false;
			}
			if(stack.isItemOf(ContentType.MATERIAL.item_type)){
				Material mat = stack.getContent(ContentType.MATERIAL.item_type);
				if(mat.getImpactLevel() > -1 && tryWheelRemoval(vehdata, ref, stack, mat, pass)) return true;
			}
			if(stack.isItemOf(ContentType.TOOLBOX.item_type)){
				boolean prt = getToolboxType(stack) == 0;
				boolean tex = getToolboxType(stack) == 1;
				if(prt && tryRemTex(vehdata, ref, seat, pass, false)) return true;
				if(tex && tryRemTex(vehdata, ref, seat, pass, true)) return true;
			}
			return false;
		}
		List<Attribute<?>> attributes = vehdata.getAttributes().values().stream().filter(attr -> attr.hasBoxes() && (attr.valuetype.isTristate() || attr.valuetype.isNumber()) && (seat == null ? attr.external : (seat.seat.driver || attr.access.contains(seat.seat.name)))).collect(toList());
		if(attributes.size() > 0){
			ArrayList<AttrInteractive> list = new ArrayList<>();
			attributes.forEach(attr -> list.add(new AttrInteractive(attr)));
			AttrInteractive inter = getInteracted(seat == null, vehdata, ref, pass, list);
			if(inter != null){
				Attribute<?> attr = inter.attribute;
				if(attr.id.equals(last) && Time.getDate() < cooldown) return true;
				return toggle(attr, vehdata, ref, key, null, pass);
			}
		}
		if(!ref.isVehicle()) return false;
		if(vehdata.getVehInventories().size() == 0 && vehdata.getInventories().size() == 0) return false;
		ArrayList<InvInteractive> invs = new ArrayList<>();
		FvtmInv inv;
		for(int i = 0; i < vehdata.getVehInvKeys().size(); i++){
			inv = vehdata.getVehInventories().get(i);
			if(!inv.pos.isNull() && seat == null ? inv.external : (seat.seat.driver || inv.access.contains(seat.seat.name))){
				invs.add(new InvInteractive(vehdata.getVehInvKeys().get(i), inv, null, i));
			}
		}
		for(int i = 0; i < vehdata.getInventories().size(); i++){
			PartData part = vehdata.getPart(vehdata.getInventories().get(i));
			if(part == null) continue;
			InventoryFunction func = part.getFunction("fvtm:inventory");
			if(func == null) continue;
			inv = func.inventory();
			if(seat == null ? inv.external : (seat.seat.driver || inv.access.contains(seat.seat.name))){
				invs.add(new InvInteractive(vehdata.getInventories().get(i), inv, part, vehdata.getVehInvKeys().size() + i));
			}
		}
		InvInteractive inter = getInteracted(seat == null, vehdata, ref, pass, invs);
		if(inter != null){
			if(inter.key.equals(last) && Time.getDate() < cooldown) return true;
			last = inter.key;
			cooldown = Time.getDate() + 20;
			TagCW com = TagCW.create();
			com.set("inventory", inter.index);
			com.set("type", ContentType.VEHICLE.name());
			ref.setPacket(com);
			Packets.send(Packet_TagListener.class, "open_inv", com);
			return true;
		}
		return false;
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

	private static String[] NON_EMPTY_VALID = new String[]{ ContentType.PART.item_type, ContentType.MATERIAL.item_type, ContentType.TOOLBOX.item_type, StackWrapper.IT_LEAD, ContentType.WIRE.item_type, ContentType.SIGN.item_type };

	public static boolean handle(KeyPress key, StackWrapper stack){
		if(!stack.empty() && !stack.isItemOfAny(NON_EMPTY_VALID)) return false;
		world = WrapperHolder.getClientWorld();
		Passenger pass = world.getClientPassenger();
		is_toolbox = stack.isItemOf(ContentType.TOOLBOX.item_type);
		if((stack.isItemOf(ContentType.WIRE.item_type) || (is_toolbox && eq(getToolboxType(stack), WIRE_REMOVAL, WIRE_SLACK)))) return handleWire(world, pass, key, stack);
		if(stack.isItemOf(ContentType.SIGN.item_type) || (is_toolbox && eq(getToolboxType(stack), SIGN_ADJREM))) return handleSign(world, pass, key, stack);
		Map<VehicleData, InteractRef> vehs = world.getVehicleDatas(pass.getPos());
		for(Entry<VehicleData, InteractRef> veh : vehs.entrySet()){
			if(handle(key, veh.getKey(), veh.getValue(), pass.getSeatOn(), pass, stack)) return true;
		}
		return false;
	}

	private static boolean handleSign(FvtmWorld world, Passenger pass, KeyPress key, StackWrapper stack){
		if(last.equals("sign") && Time.getDate() < cooldown) return false;
		if(key.mouse_main()) return false;
		boolean si = stack.isItemOf(ContentType.SIGN.item_type);
		SignSystem system = SystemManager.get(SystemManager.Systems.SIGN, (WorldW)world);
		V3D evec = pass.getEyeVec();
		V3D lvec = evec.add(pass.getLookVec().multiply(5));
		float size = 0.25f;
		for(SignRegion reg : system.getRegions().values()){
			for(SignInstance sign : reg.getSigns().values()){
				aabb = AABB.create(sign.vec.vec.x - size, sign.vec.vec.y - size, sign.vec.vec.z - size, sign.vec.vec.x + size, sign.vec.vec.y + size, sign.vec.vec.z + size);
				if(contains(evec, lvec, aabb)){
					TagCW com = TagCW.create();
					sign.vec.write(com, "pos");
					if(pass.isShiftDown()) com.set("remove", true);
					if(si) com.set("item", true);
					Packets.send(Packet_TagListener.class, "sign_interact", com);
					cooldown = Time.getDate() + 20;
					last = "sign";
					return true;
				}
			}
		}
		return false;
	}

	private static boolean handleWire(FvtmWorld world, Passenger pass, KeyPress key, StackWrapper stack){
		if(last.equals("wire") && Time.getDate() < cooldown) return false;
		boolean wire = stack.isItemOf(ContentType.WIRE.item_type);
		boolean slack = !wire && WIRE_SLACK.eq(getToolboxType(stack));
		if(key.mouse_main() && (wire || !slack)) return false;
		WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, (WorldW)world);
		V3D evec = pass.getEyeVec();
		V3D lvec = evec.add(pass.getLookVec().multiply(3));
		float size;
		for(WireRegion reg : system.getRegions().values()){
			for(RelayHolder holder : reg.getHolders().values()){
				for(WireRelay relay : holder.relays.values()){
					size = holder.hasRef() ? holder.ref().getSize(relay.getKey()) : 0.0125f;
					if(slack){
						for(Wire wr : relay.wires){
							if(wr.copy) continue;
							V3D cen = wr.getVectorPosition(wr.length * 0.5, false);
							aabb = AABB.create(cen.x - size, cen.y - size, cen.z - size, cen.x + size, cen.y + size, cen.z + size);
							if(contains(evec, lvec, aabb)){
								TagCW com = TagCW.create();
								com.set("holder", holder.pos, false);
								com.set("relay", relay.getKey());
								wr.key.save(com);
								com.set("up", key.mouse_right());
								Packets.send(Packet_TagListener.class, "relay_wire_slack", com);
								cooldown = Time.getDate() + 20;
								last = "wire";
								return true;
							}
						}
					}
					else{
						aabb = AABB.create(relay.pos.x - size, relay.pos.y - size, relay.pos.z - size, relay.pos.x + size, relay.pos.y + size, relay.pos.z + size);
						if(contains(evec, lvec, aabb)){
							TagCW com = TagCW.create();
							com.set("holder", holder.pos, false);
							com.set("relay", relay.getKey());
							Packets.send(Packet_TagListener.class, wire ? "relay_interact" : "relay_remove", com);
							cooldown = Time.getDate() + 20;
							last = "wire";
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean contains(V3D evec, V3D lvec, AABB aabb){
		V3D vec0;
		for(float f = 0; f < 3.125f; f += th32){
			vec0 = evec.distance(lvec, f);
			if(aabb.contains(vec0)) return true;
		}
		return false;
	}

	private static boolean mountSeat(VehicleInstance vehicle, SeatInstance seat, Passenger pass, StackWrapper stack){
		if(vehicle == null) return false;
		if(last.equals("seat") && Time.getDate() < cooldown) return false;
		if(!stack.empty() && stack.isItemOf(ContentType.TOOLBOX.item_type)) return false;
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

	public static class InvInteractive implements Interactive {

		private String key;
		private FvtmInv inv;
		private PartData part;
		private int index;

		public InvInteractive(String id, FvtmInv finv, PartData data, int idx){
			key = id;
			inv = finv;
			part = data;
			index = idx;
		}

		@Override
		public String id(){
			return (part == null ? "part-" : "") + key;
		}

		@Override
		public void collect(boolean external, VehicleData data, InteractRef ref, Passenger player, Map<String, AABB> aabbs){
			V3D pos;
			if(part != null){
				pos = data.getRotationPoint(part.getSwivelPointInstalledOn())
					.getRelativeVector(part.getInstalledPos().add(inv.pos)).add(ref.pos);
			}
			else{
				pos = data.getRotationPoint(SwivelPoint.DEFAULT)
					.getRelativeVector(inv.pos).add(ref.pos);
			}
			double hs = inv.scale * .5;
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
			pos = inst.entity == null ? inst.railent == null ? null : inst.railent.pos : inst.entity.getPos();
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
