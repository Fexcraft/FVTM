package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.attribute.AttributeBB;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.gui.ServerReceiver;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler.DPIHData;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ToggableHandler {
	
	private static String last;
	private static long tilltime = 0;
	private static final float SBBS = .375f;
	public static final AxisAlignedBB NULBB = new AxisAlignedBB(0, 0, 0, 0, 0, 0);

	public static boolean handleClick(KeyPress press, VehicleEntity entity, SeatCache seat, EntityPlayer player, ItemStack stack){
		if(press == KeyPress.MOUSE_RIGHT && foundSeat(entity, seat, player, stack)) return true;
		if(!stack.isEmpty()){
			//Print.debug("item");
			if(stack.getItem() instanceof PartItem){
				PartData part = stack.getCapability(Capabilities.VAPDATA, null).getPartData();
				if(part.getType().getInstallationHandlerData() instanceof DPIHData == false) return false;
        		DPIHData idata = part.getType().getInstallationHandlerData();
        		if(idata.hotswap){
        			ArrayList<Collidable> colls = new ArrayList<>();
        			for(Entry<String, PartSlots> data : entity.getVehicleData().getPartSlotProviders().entrySet()){
        				for(int i = 0; i < data.getValue().size(); i++){
        					String type = data.getValue().get(i).type;
        					for(String str : part.getType().getCategories()){
        						if(str.equals(type)){
        							SwivelPoint point = entity.getVehicleData().getRotationPointOfPart(data.getKey());
        							colls.add(new Collidable(point, data.getKey(), data.getValue(), i));
        						}
        					}
        				}
        				Collidable coll = getCollided(seat == null, entity, player, colls);
        				if(coll != null){
        					if(coll.id().equals(last) && Time.getDate() < tilltime){
        						return true;
        					}
        					NBTTagCompound packet = new NBTTagCompound();
        					packet.setString("target_listener", Resources.UTIL_LISTENER);
        					packet.setString("task", "hot_install");
        					packet.setString("source", coll.source);
        					packet.setInteger("index", coll.index);
        					packet.setInteger("entity", entity.getEntity().getEntityId());
        					PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
        					last = coll.id(); tilltime = Time.getDate() + 20;
        					return true;
        				}
        			}
        			
        		}
	        }
			return false;
		}
		Collection<Attribute<?>> attributes = entity.getVehicleData().getAttributes().values().stream().filter(pr -> pr.hasBBs() && (pr.valuetype().isTristate() || pr.valuetype().isNumber()) && (seat == null ? pr.external() : (seat.seatdata.driver || pr.seats().contains(seat.seatdata.name)))).collect(Collectors.toList());
		if(attributes.size() == 0){
			/*Print.debug(player, "none found");*/ return false;
		}
		ArrayList<Collidable> colls = new ArrayList<>();
		attributes.forEach(attr -> colls.add(new Collidable(attr)));
		Collidable coll = getCollided(seat == null, entity, player, colls);
		if(coll == null){
			/*Print.debug(player, "none hit");*/ return false;
		}
		Attribute<?> attr = coll.attr;
		if(attr.id().equals(last) && Time.getDate() < tilltime){
			/*Print.debug(player, "skipping till cooldown");*/ return true;
		}
		return sendToggle(attr, entity, press, null, player);
	}

	public static boolean sendToggle(Attribute<?> attr, VehicleEntity entity, KeyPress press, Float val, EntityPlayer player){
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", "fvtm:gui");
		packet.setString("task", "attr_toggle");
		packet.setString("attr", attr.id());
		packet.setInteger("entity", entity.getEntity().getEntityId());
		Object old = attr.value();
		switch(press){
			case MOUSE_MAIN:{
				if(attr.valuetype().isTristate()){
					packet.setBoolean("bool", !attr.valuetype().isBoolean() ? false : !attr.boolean_value());
					Print.bar(player, "&7Toggling: &6" + attr.id() + " &a> " + packet.getBoolean("bool"));
				}
				else if(attr.valuetype().isFloat()){
					float flaot = attr.float_value() + (val != null ? val : attr.getBB(attr.string_value()).increase);
					packet.setFloat("value", flaot);
					attr.value(flaot);
					Print.bar(player, "&7Increasing: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				else if(attr.valuetype().isInteger()){
					int ent = attr.integer_value() + (int)(val != null ? val : attr.getBB(attr.string_value()).increase);
					packet.setFloat("value", ent);
					attr.value(ent);
					Print.bar(player, "&7Increasing: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			case MOUSE_RIGHT:{
				if(attr.valuetype().isTristate()){
					packet.setBoolean("bool", !attr.valuetype().isBoolean() ? true : !attr.boolean_value());
					Print.bar(player, "&7Toggling: &6" + attr.id() + " &a> " + packet.getBoolean("bool"));
				}
				else if(attr.valuetype().isFloat()){
					float flaot = attr.float_value() - (val != null ? -val : attr.getBB(attr.string_value()).decrease);
					packet.setFloat("value", flaot);
					attr.value(flaot);
					Print.bar(player, "&7Decreasing: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				else if(attr.valuetype().isInteger()){
					int ent = attr.integer_value() - (int)(val != null ? -val : attr.getBB(attr.string_value()).decrease);
					packet.setFloat("value", ent);
					attr.value(ent);
					Print.bar(player, "&7Decreasing: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			case RESET:{
				if(attr.valuetype().isTristate()){
					packet.setBoolean("bool", false);
					packet.setBoolean("reset", true);
					Print.bar(player, "&7Resetting: &6" + attr.id());
				}
				else if(attr.valuetype().isFloat()){
					float flaot = val != null ? val : attr.getBB(attr.string_value()).reset;
					packet.setFloat("value", flaot);
					attr.value(flaot);
					Print.bar(player, "&7Resetting: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				else if(attr.valuetype().isInteger()){
					int ent = (int)(val != null ? val : attr.getBB(attr.string_value()).reset);
					packet.setFloat("value", ent);
					attr.value(ent);
					Print.bar(player, "&7Resetting: &6" + attr.id() + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			default: return false;
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

	private static boolean foundSeat(VehicleEntity entity, SeatCache seatfrom, EntityPlayer player, ItemStack stack){
		if("seat".equals(last) && Time.getDate() < tilltime) return false;
		if(!stack.isEmpty() && !(stack.getItem() instanceof ItemLead)) return false;
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
			if(ent == null || ent.passenger() == null){
				SwivelPoint point = entity.getVehicleData().getRotationPoint(seat.swivel_point);
				temp = point.getRelativeVector(seat.x, seat.y, seat.z);
				temp = temp.add(entity.getEntity().getPositionVector());
				AxisAlignedBB aabb = NULBB.offset(temp).grow(SBBS * seat.scale());
				for(float f = 0; f < 4; f += Static.sixteenth / 2){
					Vec3f dis = vec0.distance(vec1, f);
					vec = new Vec3d(dis.x, dis.y, dis.z);
					if(aabb.contains(vec)){
						NBTTagCompound packet = new NBTTagCompound();
						packet.setString("target_listener", "fvtm:gui");
						packet.setString("task", "toggle_seat");
						packet.setInteger("entity", entity.getEntity().getEntityId());
						packet.setInteger("seat", i);
						packet.setBoolean("main", true);//stack == EnumHand.MAIN_HAND);
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
	private static Collidable getCollided(boolean external, VehicleEntity vehicle, EntityPlayer player, Collection<Collidable> collidables){
		Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
		if(entity == null || entity.world == null) return null;
		Vec3d vec = entity.getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
		Vec3d temp = entity.getLook(Minecraft.getMinecraft().getRenderPartialTicks());
		Vec3d vecto = vec.add(temp.x * 2, temp.y * 2, temp.z * 2);
		Vec3f vec0 = new Vec3f(vec.x, vec.y, vec.z), vec1 = new Vec3f(vecto.x, vecto.y, vecto.z);
		TreeMap<String, AxisAlignedBB> aabbs = new TreeMap<>();
		for(Collidable coll : collidables){
			coll.collectAABBs(external, vehicle, player, aabbs, temp);
		}
		for(float f = 0; f < (external ? 3 : 2); f += Static.sixteenth / 2){
			Vec3f dis = vec0.distance(vec1, f);
			vec = new Vec3d(dis.x, dis.y, dis.z);
			if(Command.TOGGABLE) vehicle.getEntity().world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, dis.x, dis.y, dis.z, 0, 0, 0);
			for(Collidable coll : collidables)
				if(aabbs.containsKey(coll.id()) && aabbs.get(coll.id()).contains(vec)) return coll;
		}
		return null;
	}

	public static boolean handleClick(KeyPress press, ItemStack stack){
		if(!stack.isEmpty() && !(stack.getItem() instanceof PartItem || stack.getItem() instanceof ItemLead)) return false;
		for(Entity entity : Minecraft.getMinecraft().world.loadedEntityList){
			if(entity instanceof VehicleEntity == false) continue;
			//Print.debug("test");
			if(((VehicleEntity)entity).getVehicleData().getAttribute("collision_range").float_value() + 1 < entity.getDistance(Minecraft.getMinecraft().player)){
				//Print.debug("veh dis: " + ((VehicleEntity)entity).getVehicleData().getAttribute("collision_range").float_value() + " " + entity.getName());
				//Print.debug("ply dis: " + entity.getDistance(Minecraft.getMinecraft().player));
				continue;
			}
			if(handleClick(press, (VehicleEntity)entity, null, Minecraft.getMinecraft().player, stack)) return true;
		}
		return false;
	}
	
	public static class Collidable {
		
		protected Attribute<?> attr;
		private SwivelPoint point;
		private PartSlots slots;
		//private DPIHData data;
		private String source;
		private int index;
		
		public Collidable(Attribute<?> attr){
			this.attr = attr;
		}

		public Collidable(SwivelPoint point, String source, PartSlots slots, int index){
			this.point = point;
			this.source = source;
			this.slots = slots;
			this.index = index;
		}

		public String id(){
			return attr == null ? source + ":" + index : attr.id();
		}

		public void collectAABBs(boolean external, VehicleEntity vehicle, EntityPlayer player, TreeMap<String, AxisAlignedBB> aabbs, Vec3d temp){
			if(attr != null){
				String attrid = (external ? "external-" : "") + attr.string_value();
				AttributeBB abb = attr.getBB(attrid);
				if(abb == null) return;
				SwivelPoint point = vehicle.getVehicleData().getRotationPoint(abb.swivel_point);
				temp = point.getRelativeVector(abb.pos.x16, -abb.pos.y16, -abb.pos.z16);
				temp = temp.add(vehicle.getEntity().getPositionVector());
				float te = abb.size;
				aabbs.put(attr.id(), new AxisAlignedBB(temp.x - te, temp.y - te, temp.z - te, temp.x + te, temp.y + te, temp.z + te));
			}
			else{
				Pos pos = slots.get(index).pos;
				if(!source.equals(PartSlots.VEHPARTSLOTS)) pos = pos.add(vehicle.getVehicleData().getPart(source).getInstalledPos());
				temp = point.getRelativeVector(pos.x16, point.isVehicle() ? -pos.y16 : pos.y16, -pos.z16);
				temp = temp.add(vehicle.getEntity().getPositionVector());
				float te = slots.get(index).radius / 2;
				aabbs.put(id(), new AxisAlignedBB(temp.x - te, temp.y - te, temp.z - te, temp.x + te, temp.y + te, temp.z + te));
			}
			//if(Command.TOGGABLE) vehicle.getEntity().world.spawnParticle(EnumParticleTypes.FLAME, temp.x, temp.y, temp.z, 0, 0, 0);
		}
		
	}

}
