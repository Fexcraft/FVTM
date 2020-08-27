package net.fexcraft.mod.fvtm.util.handler;

import java.util.Collection;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.gui.ServerReceiver;
import net.fexcraft.mod.fvtm.sys.legacy.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.KeyPress;
import net.fexcraft.mod.fvtm.sys.legacy.SeatCache;
import net.fexcraft.mod.fvtm.util.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ToggableHandler {
	
	private static String last;
	private static long tilltime = 0;
	public static final AxisAlignedBB SEATBB = new AxisAlignedBB(-.25, 0, -.25, 0.25, 0.5, 0.25);

	public static boolean handleClick(KeyPress press, VehicleEntity entity, SeatCache seat, EntityPlayer player, EnumHand hand){
		if(press == KeyPress.MOUSE_RIGHT && foundSeat(entity, seat, player, hand)) return true;
		Collection<Attribute<?>> attributes = entity.getVehicleData().getAttributes().values().stream().filter(pr -> pr.hasAABBs() && (pr.type().isTristate() || pr.type().isNumber()) && (seat == null ? pr.external() : (seat.seatdata.driver || pr.seat().equals(seat.seatdata.name)))).collect(Collectors.toList());
		if(attributes.size() == 0){
			/*Print.debug(player, "none found");*/ return false;
		}
		Attribute<?> attr = getCollided(seat == null, entity, player, attributes);
		if(attr == null){
			/*Print.debug(player, "none hit");*/ return false;
		}
		if(attr.id().equals(last) && Time.getDate() < tilltime){
			/*Print.debug(player, "skipping till cooldown");*/ return true;
		}
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", "fvtm:gui");
		packet.setString("task", "attr_toggle");
		packet.setString("attr", attr.id());
		packet.setInteger("entity", entity.getEntity().getEntityId());
		Object old = attr.getValue();
		switch(press){
			case MOUSE_MAIN:{
				if(attr.type().isTristate()){
					packet.setBoolean("bool", !attr.type().isBoolean() ? false : !attr.getBooleanValue());
					Print.bar(player, "&7Toggling: &6" + attr.id() + " &a> " + packet.getBoolean("bool"));
				}
				else if(attr.type().isFloat()){
					float flaot = attr.getFloatValue() + attr.getAABB(attr.getStringValue())[4];
					packet.setFloat("value", flaot);
					attr.setValue(flaot);
					Print.bar(player, "&7Increasing: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				else if(attr.type().isInteger()){
					int ent = attr.getIntegerValue() + (int)attr.getAABB(attr.getStringValue())[4];
					packet.setFloat("value", ent);
					attr.setValue(ent);
					Print.bar(player, "&7Increasing: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			case MOUSE_RIGHT:{
				if(attr.type().isTristate()){
					packet.setBoolean("bool", !attr.type().isBoolean() ? true : !attr.getBooleanValue());
					Print.bar(player, "&7Toggling: &6" + attr.id() + " &a> " + packet.getBoolean("bool"));
				}
				else if(attr.type().isFloat()){
					float flaot = attr.getFloatValue() - attr.getAABB(attr.getStringValue())[5];
					packet.setFloat("value", flaot);
					attr.setValue(flaot);
					Print.bar(player, "&7Decreasing: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				else if(attr.type().isInteger()){
					int ent = attr.getIntegerValue() - (int)attr.getAABB(attr.getStringValue())[5];
					packet.setFloat("value", ent);
					attr.setValue(ent);
					Print.bar(player, "&7Decreasing: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			case RESET:{
				if(attr.type().isTristate()){
					packet.setBoolean("bool", false);
					packet.setBoolean("reset", true);
					Print.bar(player, "&7Resetting: &6" + attr.id());
				}
				else if(attr.type().isFloat()){
					float flaot = attr.getAABB(attr.getStringValue())[6];
					packet.setFloat("value", flaot);
					attr.setValue(flaot);
					Print.bar(player, "&7Resetting: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				else if(attr.type().isInteger()){
					int ent = (int)attr.getAABB(attr.getStringValue())[6];
					packet.setFloat("value", ent);
					attr.setValue(ent);
					Print.bar(player, "&7Resetting: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			default:
				return false;
		}
		entity.getVehicleData().getScripts().forEach(script -> {
			script.onAttributeToggle(entity.getEntity(), attr, old, player);
		});
		if(player.world.isRemote){
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
			last = attr.id(); tilltime = Time.getDate() + 20;
		}
		else{
			ServerReceiver.INSTANCE.process(packet, player);
			Static.stop();
		}
		return true;
	}

	private static boolean foundSeat(VehicleEntity entity, SeatCache seatfrom, EntityPlayer player, EnumHand hand){
		if("seat".equals(last) && Time.getDate() < tilltime) return false;
		if(seatfrom == null && player.getRidingEntity() instanceof GenericVehicle){
			seatfrom = ((GenericVehicle)player.getRidingEntity()).getSeatOf(player);
		}
		Entity renent = Minecraft.getMinecraft().getRenderViewEntity();
		Vec3d vec = renent.getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
		Vec3d temp = renent.getLook(Minecraft.getMinecraft().getRenderPartialTicks());
		Vec3d vecto = vec.add(temp.x * 3, temp.y * 3, temp.z * 3);
		Vec3f vec0 = new Vec3f(vec.x, vec.y, vec.z), vec1 = new Vec3f(vecto.x, vecto.y, vecto.z);
		for(int i = 0; i < entity.getVehicleData().getSeats().size(); i++){
			if(seatfrom != null && seatfrom.seatindex == i) continue;
			Seat seat = entity.getVehicleData().getSeat(i);
			SeatCache ent = ((GenericVehicle)entity).seats[i];
			if(ent == null || ent.passenger == null){
				SwivelPoint point = entity.getVehicleData().getRotationPoint(seat.swivel_point);
				temp = point.getRelativeVector(seat.x, seat.y, seat.z);
				temp = temp.add(entity.getEntity().getPositionVector());
				AxisAlignedBB aabb = SEATBB.offset(temp);
				for(float f = 0; f < 4; f += Static.sixteenth / 2){
					Vec3f dis = vec0.distance(vec1, f);
					vec = new Vec3d(dis.xCoord, dis.yCoord, dis.zCoord);
					//if(Command.DEBUG) entity.getEntity().world.spawnParticle(EnumParticleTypes.SNOWBALL, dis.xCoord, dis.yCoord, dis.zCoord, 0, 0, 0);
					if(aabb.contains(vec)){
						NBTTagCompound packet = new NBTTagCompound();
						packet.setString("target_listener", "fvtm:gui");
						packet.setString("task", "toggle_seat");
						packet.setInteger("entity", entity.getEntity().getEntityId());
						packet.setInteger("seat", i);
						packet.setBoolean("main", hand == EnumHand.MAIN_HAND);
						if(player.world.isRemote){
							PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
							tilltime = Time.getDate() + 20;
							last = "seat";
						}
						else{
							ServerReceiver.INSTANCE.process(packet, player);
							Static.stop();
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	@SideOnly(Side.CLIENT) // Eventually checks about which is closest?
	private static Attribute<?> getCollided(boolean external, VehicleEntity vehicle, EntityPlayer player, Collection<Attribute<?>> attributes){
		Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
		if(entity == null || entity.world == null) return null;
		Vec3d vec = entity.getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
		Vec3d temp = entity.getLook(Minecraft.getMinecraft().getRenderPartialTicks());
		Vec3d vecto = vec.add(temp.x * 2, temp.y * 2, temp.z * 2);
		Vec3f vec0 = new Vec3f(vec.x, vec.y, vec.z), vec1 = new Vec3f(vecto.x, vecto.y, vecto.z);
		TreeMap<String, AxisAlignedBB> aabbs = new TreeMap<>();
		for(Attribute<?> attr : attributes){
			String attrid = (external ? "external-" : "") + attr.getStringValue();
			float[] arr = attr.getAABB(attrid);
			SwivelPoint point = vehicle.getVehicleData().getRotationPoint(attr.getAABBSP(attrid));
			temp = point.getRelativeVector(arr[0] * Static.sixteenth, -arr[1] * Static.sixteenth, -arr[2] * Static.sixteenth);
			temp = temp.add(vehicle.getEntity().getPositionVector());
			float te = arr[3] * Static.sixteenth;
			if(Command.DEBUG) vehicle.getEntity().world.spawnParticle(EnumParticleTypes.FLAME, temp.x, temp.y, temp.z, 0, 0, 0);
			aabbs.put(attr.id(), new AxisAlignedBB(temp.x - te, temp.y - te, temp.z - te, temp.x + te, temp.y + te, temp.z + te));
		}
		for(float f = 0; f < (external ? 3 : 2); f += Static.sixteenth / 2){
			Vec3f dis = vec0.distance(vec1, f);
			vec = new Vec3d(dis.xCoord, dis.yCoord, dis.zCoord);
			if(Command.DEBUG) vehicle.getEntity().world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, dis.xCoord, dis.yCoord, dis.zCoord, 0, 0, 0);
			for(Attribute<?> attr : attributes)
				if(aabbs.get(attr.id()).contains(vec)) return attr;
		}
		return null;
	}

	public static boolean handleClick(KeyPress press, EnumHand hand){
		for(Entity entity : Minecraft.getMinecraft().world.loadedEntityList){
			if(entity instanceof VehicleEntity == false) continue;
			if(((VehicleEntity)entity).getVehicleData().getAttribute("collision_range").getFloatValue() + 1 < entity.getDistance(Minecraft.getMinecraft().player)){
				Print.debug("veh dis: " + ((VehicleEntity)entity).getVehicleData().getAttribute("collision_range").getFloatValue() + " " + entity.getName());
				Print.debug("ply dis: " + entity.getDistance(Minecraft.getMinecraft().player));
				continue;
			}
			if(handleClick(press, (VehicleEntity)entity, null, Minecraft.getMinecraft().player, hand)) return true;
		}
		return false;
	}

}
