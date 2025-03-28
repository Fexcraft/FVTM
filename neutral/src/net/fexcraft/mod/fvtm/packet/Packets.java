package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.data.inv.FvtmInv;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.handler.AttrReqHandler;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRef;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.sys.rail.*;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignRegion;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.sys.wire.RelayHolder;
import net.fexcraft.mod.fvtm.sys.wire.WireRegion;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.sys.wire.WireUnit;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.packet.PacketBase;
import net.fexcraft.mod.uni.packet.PacketListener;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.ui.UIKey;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Packets {

	public static HashMap<String, PacketListener> LIS_CLIENT = new HashMap<>();
	public static HashMap<String, PacketListener> LIS_SERVER = new HashMap<>();
	public static int RANGE = 256;
	public static Packets INSTANCE = null;
	//
	public static Class<? extends PacketBase> PKT_TAG = Packet_TagListener.class;

	public void init(){
		LIS_SERVER.put("attr_toggle", (com, player) -> {
			AttrReqHandler.processToggleRequest((Passenger)player, com);
		});
		LIS_SERVER.put("attr_update", (com, player) -> {
			AttrReqHandler.processUpdateRequest((Passenger)player, com);
		});
		LIS_SERVER.put("open_ui", (com, player) -> {
			player.openUI(UIKey.byId(com.getInteger("ui")), new V3I(com.getIntArray("pos"), 0));
		});
		LIS_SERVER.put("vehicle", (com, player) -> {
			VehicleInstance inst = ((Passenger)player).getFvtmWorld().getVehicle(com.getInteger("entity"));
			if(inst != null) inst.packet(com, (Passenger)player);
		});
		LIS_SERVER.put("vehicle_packet", (com, player) -> {
			VehicleInstance inst = ((Passenger)player).getFvtmWorld().getVehicle(com.getInteger("entity"));
			if(inst != null) inst.packet(com, (Passenger)player);
		});
		LIS_SERVER.put("blockentity", (com, player) -> {
			((Passenger)player).getFvtmWorld().handleBlockEntityPacket(com, (Passenger)player);
		});
		LIS_SERVER.put("install_part", (com, player) -> {
			StackWrapper wrapper = player.getHeldItem(true);
			PartData data = wrapper.getContent(ContentType.PART.item_type);
			Map.Entry<VehicleData, InteractRef> ref = ((Passenger)player).getFvtmWorld().getInteractRef(com);
			String category = com.getString("category");
			if(ref.getKey().getPart(category) != null){
				PartData oldpart = ref.getKey().getPart(category);
				boolean valid = oldpart.getType().getInstallHandlerData() instanceof DefaultPartInstallHandler.DPIHData && ((DefaultPartInstallHandler.DPIHData)oldpart.getType().getInstallHandlerData()).swappable;
				if(valid && ref.getKey().deinstallPart(player, category, true)){
					player.drop(oldpart.getNewStack(), 0);
				}
				else return;
			}
			data = ref.getKey().installPart(player, data, com.getString("source") + ":" + category, true);
			if(data == null){
				wrapper.count(wrapper.count() - 1);
				if(ref.getValue().isVehicle()){
					ref.getValue().vehicle().sendUpdate(VehicleInstance.PKT_UPD_VEHICLEDATA);
				}
				else{
					ref.getValue().holder().markChanged();
					TagCW pkt = TagCW.create();
					pkt.set("task", "update");
					pkt.set("data", ref.getKey().write(null));
					pkt.set("pos", ref.getValue().longpos());
					Packets.sendToAll(Packet_TagListener.class, "blockentity", pkt);
				}
			}
		});
		LIS_SERVER.put("install_wheel", (com, player) -> {
			StackWrapper wrapper = player.getHeldItem(true);
			PartData data = wrapper.getContent(ContentType.PART.item_type);
			Map.Entry<VehicleData, InteractRef> ref = ((Passenger)player).getFvtmWorld().getInteractRef(com);
			if(ref.getValue().isVehicle()){
				player.send("interact.fvtm.vehicle.wheel_install");
				return;
			}
			String category = com.getString("category");
			boolean tire = data.getType().getInstallHandlerData() instanceof TireData;
			data = ref.getKey().installPart(player, data, tire ? category + ":tire" : category, true);
			if(data == null) wrapper.count(wrapper.count() - 1);
			if(ref.getValue().isVehicle()){
				ref.getValue().vehicle().sendUpdate(VehicleInstance.PKT_UPD_VEHICLEDATA);
			}
			else{
				ref.getValue().holder().markChanged();
				TagCW pkt = TagCW.create();
				pkt.set("task", "update");
				pkt.set("data", ref.getKey().write(null));
				pkt.set("pos", ref.getValue().longpos());
				Packets.sendToAll(Packet_TagListener.class, "blockentity", pkt);
			}
		});
		LIS_SERVER.put("remove_wheel", (com, player) -> {
			StackWrapper wrapper = player.getHeldItem(true);
			Material mat = wrapper.getContent(ContentType.MATERIAL.item_type);
			Map.Entry<VehicleData, InteractRef> ref = ((Passenger)player).getFvtmWorld().getInteractRef(com);
			if(ref.getValue().isVehicle()){
				player.send("interact.fvtm.vehicle.wheel_remove");
				return;
			}
			if(ref == null || mat.getImpactLevel() < ref.getKey().getType().getImpactWrenchLevel()) return;
			String category = com.getString("category");
			PartData tire = ref.getKey().getPart(category + ":tire");
			if(tire != null){
				if(ref.getKey().deinstallPart(player, category + ":tire", false)){
					player.drop(tire.getNewStack(), 0);
				}
				else return;
			}
			PartData wheel = ref.getKey().getPart(category);
			if(wheel != null && ref.getKey().deinstallPart(player, category, false)){
				player.drop(wheel.getNewStack(), 0);
			}
			if(ref.getValue().isVehicle()){
				ref.getValue().vehicle().sendUpdate(VehicleInstance.PKT_UPD_VEHICLEDATA);
			}
			else{
				ref.getValue().holder().markChanged();
				TagCW pkt = TagCW.create();
				pkt.set("task", "update");
				pkt.set("data", ref.getKey().write(null));
				pkt.set("pos", ref.getValue().longpos());
				Packets.sendToAll(Packet_TagListener.class, "blockentity", pkt);
			}
		});
		LIS_SERVER.put("remove_part", (com, player) -> {
			StackWrapper wrapper = player.getHeldItem(true);
			if(!wrapper.isItemOf(ContentType.TOOLBOX.item_type)) return;
			Map.Entry<VehicleData, InteractRef> ref = ((Passenger)player).getFvtmWorld().getInteractRef(com);
			if(ref == null) return;
			String category = com.getString("category");
			PartData part = ref.getKey().getPart(category);
			if(part != null && ref.getKey().deinstallPart(player, category, false)){
				player.drop(part.getNewStack(), 0);
			}
			if(ref.getValue().isVehicle()){
				ref.getValue().vehicle().sendUpdate(VehicleInstance.PKT_UPD_VEHICLEDATA);
			}
			else{
				ref.getValue().holder().markChanged();
				TagCW pkt = TagCW.create();
				pkt.set("task", "update");
				pkt.set("data", ref.getKey().write(null));
				pkt.set("pos", ref.getValue().longpos());
				Packets.sendToAll(Packet_TagListener.class, "blockentity", pkt);
			}
		});
		LIS_SERVER.put("texture_part", (com, player) -> {
			StackWrapper wrapper = player.getHeldItem(true);
			if(!wrapper.isItemOf(ContentType.TOOLBOX.item_type)) return;
			Map.Entry<VehicleData, InteractRef> ref = ((Passenger)player).getFvtmWorld().getInteractRef(com);
			if(ref == null || !ref.getValue().isVehicle()) return;
			String category = com.getString("category");
			PartData part = ref.getKey().getPart(category);
			if(part != null){
				player.openUI(UIKeys.TOOLBOX_TEXTURE, new V3I(ref.getValue().vehicle().entity.getId(), ref.getKey().getPartIndex(part), 1));
			}
		});
		LIS_SERVER.put("rail_upd_region", (com, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			system.updateRegion(com, player);
		});
		LIS_SERVER.put("wire_upd_region", (com, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			system.updateRegion(com, (Passenger)player);
		});
		LIS_SERVER.put("relay_interact", (com, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			system.onRelayInteract(com, (Passenger)player);
		});
		LIS_SERVER.put("relay_remove", (com, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			system.onRelayRemove(com, (Passenger)player);
		});
		LIS_SERVER.put("relay_wire_slack", (com, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			system.onRelayWireSlack(com, (Passenger)player);
		});
		LIS_SERVER.put("open_inv", (com, player) -> {
			Map.Entry<VehicleData, InteractRef> ref = ((Passenger)player).getFvtmWorld().getInteractRef(com);
			FvtmInv inv = ref.getKey().getInvByIdx(com.getInteger("inventory"));
			player.openUI(inv.getUIKey(ContentType.valueOf(com.getString("type"))), ref.getValue().vehicle().entity.getId(), com.getInteger("inventory"), 0);
		});
		LIS_SERVER.put("sign_interact", (com, player) -> {
			SignSystem system = SystemManager.get(SystemManager.Systems.SIGN, player.getWorld());
			QV3D pos = new QV3D(com, "pos");
			if(com.getBoolean("remove")){
				system.delSign(pos);
			}
			else{
				player.openUI(UIKeys.SIGN_EDITOR, pos.pos);
			}
		});
		if(EnvInfo.CLIENT) initClient();
	}

	public void initClient(){
		LIS_CLIENT.put("attr_toggle", (tag, player) -> {
			AttrReqHandler.processToggleResponse((Passenger)player, tag);
		});
		LIS_CLIENT.put("attr_update", (tag, player) -> {
			AttrReqHandler.processUpdateResponse((Passenger)player, tag);
		});
		LIS_CLIENT.put("vehicle", (tag, player) -> {
			VehicleInstance inst = ((Passenger)player).getFvtmWorld().getVehicle(tag.getInteger("entity"));
			if(inst != null) inst.packet(tag, (Passenger) player);
		});
		LIS_CLIENT.put("vehicle_packet", (tag, player) -> {
			VehicleInstance inst = ((Passenger)player).getFvtmWorld().getVehicle(tag.getInteger("entity"));
			if(inst != null) inst.packet(tag, (Passenger)player);
		});
		LIS_CLIENT.put("vehicle_color", (tag, player) -> {
			VehicleInstance inst = ((Passenger)player).getFvtmWorld().getVehicle(tag.getInteger("vehicle"));
			if(inst != null){
				inst.data.getColorChannel(tag.getString("channel")).packed = tag.getInteger("color");
			}
		});
		LIS_CLIENT.put("road_tool_new", (tag, player) -> {
			UUID uuid = new UUID(tag.getLong("uuid_m"), tag.getLong("uuid_l"));
			RoadPlacingUtil.CL_CURRENT = new RoadPlacingUtil.NewRoad(uuid, new QV3D(tag, "vector"), tag.getInteger("width"));
			RoadPlacingUtil.QUEUE.put(uuid, RoadPlacingUtil.CL_CURRENT);
		});
		LIS_CLIENT.put("road_tool_add", (tag, player) -> {
			UUID uuid = new UUID(tag.getLong("uuid_m"), tag.getLong("uuid_l"));
			RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(uuid);
			if(road == null) return;
			road.add(new QV3D(tag, "vector"), tag.getInteger("width"));
		});
		LIS_CLIENT.put("road_tool_selected", (tag, player) -> {
			UUID uuid = new UUID(tag.getLong("uuid_m"), tag.getLong("uuid_l"));
			RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(uuid);
			if(road == null) return;
			road.selected = tag.getInteger("selected");
		});
		LIS_CLIENT.put("road_tool_remove", (tag, player) -> {
			UUID uuid = new UUID(tag.getLong("uuid_m"), tag.getLong("uuid_l"));
			RoadPlacingUtil.NewRoad road = RoadPlacingUtil.QUEUE.get(uuid);
			if(road == null) return;
			road.remove((Passenger)player, new QV3D(tag, "vector"));
		});
		LIS_CLIENT.put("road_tool_reset", (tag, player) -> {
			UUID uuid = new UUID(tag.getLong("uuid_m"), tag.getLong("uuid_l"));
			if(RoadPlacingUtil.CL_CURRENT.id.equals(uuid)) RoadPlacingUtil.CL_CURRENT = null;
			RoadPlacingUtil.QUEUE.remove(uuid);
		});
		LIS_CLIENT.put("blockentity", (tag, player) -> {
			((Passenger)player).getFvtmWorld().handleBlockEntityPacket(tag, (Passenger)player);
		});
		LIS_CLIENT.put("rail_upd_unit_section", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			TrackUnit unit = system.getTrackUnits().get(tag.getString("unit"));
			if(unit != null) unit.setSection(system.getSection(tag.getLong("section")), false);
		});
		LIS_CLIENT.put("rail_upd_sections", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			TagLW list = tag.getList("units");
			TrackUnit unit;
			for(TagCW com : list){
				unit = system.getTrackUnits().get(com.getString("unit"));
				if(unit != null){
					unit.setSection(system.getSection(com.getLong("section")), false);
				}
			}
			FvtmLogger.debug(tag);
		});
		LIS_CLIENT.put("rail_upd_region", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			system.updateRegion(tag, null);
		});
		LIS_CLIENT.put("rail_spawn_ent", (tag, player) -> {
			FvtmLogger.debug("Receiving entity spawn request.");
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			Region region = system.getRegions().get(tag.getIntArray("XZ"), true);
			if(region != null && region.loaded){
				//TODO region.spawnEntity(new RailEntity(region, tag.getLong("uid")).read(tag));
			}
			else Region.clientqueue.put(tag.getLong("uid"), tag.copy());
		});
		LIS_CLIENT.put("rail_rem_ent", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			//TODO RailEntity ent = system.getEntity(packet.nbt.getLong("uid"), false);
			//TODO if(ent != null) ent.remove();
		});
		LIS_CLIENT.put("rail_upd_junc", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			V3I vec = new V3I(tag.getList("pos"));
			Junction junction = system.getJunction(vec);
			if(junction != null) junction.read(tag);
			else{
				Region region = system.getRegions().get(vec, false);
				if(region != null){
					region.getJunctions().put(vec, new Junction(region).read(tag));
				}
			}
		});
		LIS_CLIENT.put("rail_rem_junc", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			system.delJunction(new V3I(tag.getList("pos")));
		});
		LIS_CLIENT.put("rail_upd_junc_state", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			Junction junction = system.getJunction(new V3I(tag.getList("pos")));
			if(junction != null){
				junction.switch0 = tag.getBoolean("switch0");
				junction.switch1 = tag.getBoolean("switch1");
			}
		});
		LIS_CLIENT.put("rail_upd_junc_signal", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			Junction junction = system.getJunction(new V3I(tag.getList("pos")));
			if(junction != null){
				if(tag.has("nosignal") && tag.getBoolean("nosignal")){
					junction.signal = null;
					junction.signal_dir = EntryDirection.FORWARD;
				}
				else{
					junction.signal = null;//TODOSignalType.values()[tag.getInteger("signal")];
					junction.signal_dir = EntryDirection.values()[tag.getInteger("signal_dir")];
				}
				junction.signalpos0 = junction.signalpos1 = null;
			}
		});
		LIS_CLIENT.put("rail_upd_junc_signal_state", (tag, player) -> {
			RailSystem system = SystemManager.get(SystemManager.Systems.RAIL, player.getWorld());
			Junction junction = system.getJunction(new V3I(tag.getList("pos")));
			if(junction != null){
				junction.signal0 = tag.getBoolean("signal0");
				junction.signal1 = tag.getBoolean("signal1");
			}
		});
		LIS_CLIENT.put("rail_place_util", (tag, player) -> {
			UUID uuid = new UUID(tag.getLong("uuid_m"), tag.getLong("uuid_l"));
			switch(tag.getString("subtask")){
				case "new":{
					RailPlacingUtil.CL_CURRENT = new RailPlacingUtil.NewTrack(uuid, new QV3D(tag, "vector"), FvtmRegistry.RAILGAUGES.get(tag.getString("gauge")));
					RailPlacingUtil.QUEUE.put(uuid, RailPlacingUtil.CL_CURRENT);
					break;
				}
				case "reset":{
					if(RailPlacingUtil.CL_CURRENT.id.equals(uuid)) RailPlacingUtil.CL_CURRENT = null;
					RailPlacingUtil.QUEUE.remove(uuid);
					break;
				}
				case "add":{
					RailPlacingUtil.NewTrack track = RailPlacingUtil.QUEUE.get(uuid);
					if(track == null) return;
					track.add(new QV3D(tag, "vector"));
					break;
				}
				case "remove":{
					RailPlacingUtil.NewTrack track = RailPlacingUtil.QUEUE.get(uuid);
					if(track == null) return;
					track.remove(player, new QV3D(tag, "vector"));
					break;
				}
				case "selected":{
					RailPlacingUtil.NewTrack track = RailPlacingUtil.QUEUE.get(uuid);
					if(track == null) return;
					track.selected = tag.getInteger("selected");
				}
			}
		});
		LIS_CLIENT.put("wire_upd_region", (tag, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			system.updateRegion(tag, (Passenger)player);
		});
		LIS_CLIENT.put("wire_upd_relay", (tag, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			RelayHolder holder = system.getHolder(tag.getV3I("pos"));
			String key = tag.getString("Key");
			if(holder != null && holder.contains(key)){
				holder.get(key).read(tag);
			}
		});
		LIS_CLIENT.put("wire_rem_relay", (tag, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			RelayHolder holder = system.getHolder(tag.getV3I("pos"));
			holder.remove(tag.getString("key"));
		});
		LIS_CLIENT.put("wire_upd_holder", (tag, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			V3I pos = tag.getV3I("pos");
			RelayHolder holder = system.getHolder(pos);
			if(holder != null) holder.read(tag);
			else{
				WireRegion region = system.getRegions().get(pos, false);
				if(region != null) holder = region.addHolder(pos).read(tag);
			}
			if(holder.getTile() == null){
				Object tile = system.getWorld().getBlockEntity(pos);
				if(tile instanceof FvtmBlockEntity) holder.setTile(tile);
			}
		});
		LIS_CLIENT.put("wire_rem_holder", (tag, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			system.delHolder(tag.getV3I("pos"));
		});
		LIS_CLIENT.put("wire_udp_sections", (tag, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			TagLW list = tag.getList("units");
			WireUnit unit;
			for(TagCW com : list){
				unit = system.getWireUnits().get(com.getString("unit"));
				if(unit != null) unit.setSection(system.getSection(com.getLong("section")));
			}
		});
		LIS_CLIENT.put("wire_udp_unit", (tag, player) -> {
			WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, player.getWorld());
			WireUnit unit = system.getWireUnits().get(tag.getString("unit"));
			if(unit != null) unit.setSection(system.getSection(tag.getLong("section")));
		});
		LIS_CLIENT.put("sign_reg", (tag, player) -> {
			SignSystem system = SystemManager.get(SystemManager.Systems.SIGN, player.getWorld());
			system.updateRegion(tag, (Passenger)player);
		});
		LIS_CLIENT.put("sign_upd", (tag, player) -> {
			SignSystem system = SystemManager.get(SystemManager.Systems.SIGN, player.getWorld());
			QV3D pos = new QV3D(tag, "pos");
			SignRegion region = system.getRegions().get(pos, false);
			if(region != null) region.addSign(pos).read(tag.getCompound("sign"));
		});
		LIS_CLIENT.put("sign_rem", (tag, player) -> {
			SignSystem system = SystemManager.get(SystemManager.Systems.SIGN, player.getWorld());
			system.delSign(new QV3D(tag, "pos"));
		});
	}

	public abstract void writeTag(ByteBuf buffer, TagCW tag);

	public abstract TagCW readTag(ByteBuf buffer);

	@Deprecated
	/** Send BlockData Update Packet to all around. */
	public abstract void send(BlockData blockdata, V3I pos, int dim);

	@Deprecated
	/** Send BlockData Update Packet to all around. */
	public abstract void send(WorldW world, V3I pos);

	/** Send generic compound packet to a vehicle, works for both server and client. */
	public abstract void send(VehicleInstance vehicle, TagCW com);

	/** Sends a Packet to the Server. */
	public abstract void send0(Class<? extends PacketBase> packet, Object... data);

	/** Sends a Packet to the Server. */
	public static void send(Class<? extends PacketBase> packet, Object... data){
		INSTANCE.send0(packet, data);
	}

	/** Sends a Packet to all in range. */
	public abstract void sendInRange0(Class<? extends PacketBase> packet, WorldW world, V3D pos, int range, Object... data);

	/** Sends a Packet to all in range. */
	public static void sendInRange(Class<? extends PacketBase> packet, WorldW world, V3D pos, Object... data){
		INSTANCE.sendInRange0(packet, world, pos, RANGE, data);
	}

	/** Sends a Packet to all in range. */
	public static void sendInRange(Class<? extends PacketBase> packet, WorldW world, V3I pos, Object... data){
		INSTANCE.sendInRange0(packet, world, new V3D(pos), RANGE, data);
	}

	/** Sends a Packet to all in range. */
	public static void sendInRange(Class<? extends PacketBase> packet, EntityW pass, Object... data){
		sendInRange(packet, pass.getWorld(), pass.getPos(), data);
	}

	/** Sends a Packet to all. */
	public abstract void sendToAll0(Class<? extends PacketBase> packet, Object... data);

	/** Sends a Packet to all. */
	public static void sendToAll(Class<? extends PacketBase> packet, Object... data){
		INSTANCE.sendToAll0(packet, data);
	}

	/** Sends a Packet to the Server. */
	public abstract void sendTo0(Class<? extends PacketBase> packet, Passenger to, Object... data);

	/** Sends a Packet to the Server. */
	public static void sendTo(Class<? extends PacketBase> packet, Passenger to, Object... data){
		INSTANCE.sendTo0(packet, to, data);
	}

}
