package net.fexcraft.mod.fvtm.packet;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.handler.AttrReqHandler;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRef;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler.TireData;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.item.ItemType;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.UIKey;
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
			AttrReqHandler.processToggleRequest(player, com);
		});
		LIS_SERVER.put("attr_update", (com, player) -> {
			AttrReqHandler.processUpdateRequest(player, com);
		});
		LIS_SERVER.put("open_ui", (com, player) -> {
			player.openUI(UIKey.byId(com.getInteger("ui")), new V3I(com.getIntArray("pos"), 0));
		});
		LIS_SERVER.put("vehicle", (com, player) -> {
			VehicleInstance inst = player.getFvtmWorld().getVehicle(com.getInteger("entity"));
			if(inst != null) inst.packet(com, player);
		});
		LIS_SERVER.put("vehicle_packet", (com, player) -> {
			VehicleInstance inst = player.getFvtmWorld().getVehicle(com.getInteger("entity"));
			if(inst != null) inst.packet(com, player);
		});
		LIS_SERVER.put("blockentity", (com, player) -> {
			player.getFvtmWorld().handleBlockEntityPacket(com, player);
		});
		LIS_SERVER.put("install_part", (com, player) -> {
			StackWrapper wrapper = player.getHeldItem(true);
			PartData data = wrapper.getContent(ContentType.PART);
			Map.Entry<VehicleData, InteractRef> ref = player.getFvtmWorld().getInteractRef(com);
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
			PartData data = wrapper.getContent(ContentType.PART);
			Map.Entry<VehicleData, InteractRef> ref = player.getFvtmWorld().getInteractRef(com);
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
			Material mat = wrapper.getContent(ContentType.MATERIAL);
			Map.Entry<VehicleData, InteractRef> ref = player.getFvtmWorld().getInteractRef(com);
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
			if(!wrapper.isItemOf(ItemType.FVTM_TOOLBOX)) return;
			Map.Entry<VehicleData, InteractRef> ref = player.getFvtmWorld().getInteractRef(com);
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
			if(!wrapper.isItemOf(ItemType.FVTM_TOOLBOX)) return;
			Map.Entry<VehicleData, InteractRef> ref = player.getFvtmWorld().getInteractRef(com);
			if(ref == null || !ref.getValue().isVehicle()) return;
			String category = com.getString("category");
			PartData part = ref.getKey().getPart(category);
			if(part != null){
				player.openUI(UIKeys.TOOLBOX_TEXTURE, new V3I(ref.getValue().vehicle().entity.getId(), ref.getKey().getPartIndex(part), 1));
			}
		});
		if(EnvInfo.CLIENT){
			LIS_CLIENT.put("attr_toggle", (tag, player) -> {
				AttrReqHandler.processToggleResponse(player, tag);
			});
			LIS_CLIENT.put("attr_update", (tag, player) -> {
				AttrReqHandler.processUpdateResponse(player, tag);
			});
			LIS_CLIENT.put("vehicle", (tag, player) -> {
				VehicleInstance inst = player.getFvtmWorld().getVehicle(tag.getInteger("entity"));
				if(inst != null) inst.packet(tag, player);
			});
			LIS_CLIENT.put("vehicle_packet", (tag, player) -> {
				VehicleInstance inst = player.getFvtmWorld().getVehicle(tag.getInteger("entity"));
				if(inst != null) inst.packet(tag, player);
			});
			LIS_CLIENT.put("vehicle_color", (tag, player) -> {
				VehicleInstance inst = player.getFvtmWorld().getVehicle(tag.getInteger("vehicle"));
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
				road.remove(player, new QV3D(tag, "vector"));
			});
			LIS_CLIENT.put("road_tool_reset", (tag, player) -> {
				UUID uuid = new UUID(tag.getLong("uuid_m"), tag.getLong("uuid_l"));
				if(RoadPlacingUtil.CL_CURRENT.id.equals(uuid)) RoadPlacingUtil.CL_CURRENT = null;
				RoadPlacingUtil.QUEUE.remove(uuid);
			});
			LIS_CLIENT.put("blockentity", (tag, player) -> {
				player.getFvtmWorld().handleBlockEntityPacket(tag, player);
			});
			LIS_CLIENT.put("rail_upd_unit_section", (tag, player) -> {

			});
		}
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
	public static void sendInRange(Class<? extends PacketBase> packet, Passenger pass, Object... data){
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
