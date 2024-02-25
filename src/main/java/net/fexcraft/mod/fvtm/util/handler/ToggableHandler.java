package net.fexcraft.mod.fvtm.util.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.TreeMap;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.AttrBox;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.gui.ServerReceiver;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler.DPIHData;
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

import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToggableHandler {
	
	private static String last;
	private static long tilltime = 0;
	private static final float SBBS = .375f;
	public static final AxisAlignedBB NULBB = new AxisAlignedBB(0, 0, 0, 0, 0, 0);

	public static boolean handleClick(KeyPress press, RootVehicle entity, SeatInstance seat, EntityPlayer player, ItemStack stack){
		if(press == KeyPress.MOUSE_RIGHT && foundSeat(entity, seat, player, stack)) return true;
		if(!stack.isEmpty() && stack.getItem() instanceof PartItem){
			PartData data = stack.getCapability(Capabilities.VAPDATA, null).getPartData();
			if(data.getType().getInstallHandlerData() instanceof DPIHData == false) return false;
			//DPIHData idata = data.getType().getInstallHandlerData();
			//if(!idata.swappable) return false;
			ArrayList<Collidable> colls = new ArrayList<>();
			SwivelPoint point = null;
			for(Entry<String, PartSlots> entry : entity.vehicle.data.getPartSlotProviders().entrySet()){
				point = entity.vehicle.data.getRotationPointOfPart(entry.getKey());
				for(Entry<String, PartSlot> sentry : entry.getValue().entrySet()){
					String type = sentry.getValue().type;
					if(entity.vehicle.data.hasPart(type)){
						Part part = entity.vehicle.data.getPart(type).getType();
						if(!(part.getInstallHandlerData() instanceof DPIHData) || !((DPIHData)part.getInstallHandlerData()).swappable) continue;
					}
					for(String str : data.getType().getCategories()){
						if(str.equals(type)){
							colls.add(new Collidable(point, entry.getKey(), entry.getValue(), sentry.getKey()));
						}
					}
					Collidable coll = getCollided(seat == null, entity, player, colls);
					if(coll != null){
						if(coll.id().equals(last) && Time.getDate() < tilltime) return true;
						NBTTagCompound packet = new NBTTagCompound();
						packet.setString("target_listener", UTIL_LISTENER);
						packet.setString("task", "install");
						packet.setString("source", coll.source);
						packet.setString("category", coll.category);
						packet.setInteger("entity", entity.getEntityId());
						PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
						last = coll.id();
						tilltime = Time.getDate() + 20;
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean sendToggle(Attribute<?> attr, RootVehicle entity, KeyPress press, Float val, EntityPlayer player){
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", "fvtm:gui");
		packet.setString("task", "attr_toggle");
		packet.setString("attr", attr.id);
		packet.setInteger("entity", entity.getEntityId());
		Object old = attr.value();
		switch(press){
			case MOUSE_MAIN:{
				if(attr.valuetype.isTristate()){
					packet.setBoolean("bool", !attr.valuetype.isBoolean() ? false : !attr.asBoolean());
					Print.bar(player, "&7Toggling: &6" + attr.id + " &a> " + packet.getBoolean("bool"));
				}
				else if(attr.valuetype.isFloat()){
					float flaot = attr.asFloat() + (val != null ? val : attr.getBox(attr.asString()).increase);
					packet.setFloat("value", flaot);
					attr.set(flaot);
					Print.bar(player, "&7Increasing: &6" + attr.id + " &a> " + packet.getFloat("value"));
				}
				else if(attr.valuetype.isInteger()){
					int ent = attr.asInteger() + (int)(val != null ? val : attr.getBox(attr.asString()).increase);
					packet.setFloat("value", ent);
					attr.set(ent);
					Print.bar(player, "&7Increasing: &6" + attr.id + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			case MOUSE_RIGHT:{
				if(attr.valuetype.isTristate()){
					packet.setBoolean("bool", !attr.valuetype.isBoolean() ? true : !attr.asBoolean());
					Print.bar(player, "&7Toggling: &6" + attr.id + " &a> " + packet.getBoolean("bool"));
				}
				else if(attr.valuetype.isFloat()){
					float flaot = attr.asFloat() - (val != null ? -val : attr.getBox(attr.asString()).decrease);
					packet.setFloat("value", flaot);
					attr.set(flaot);
					Print.bar(player, "&7Decreasing: &6" + attr.id + " &a> " + packet.getFloat("value"));
				}
				else if(attr.valuetype.isInteger()){
					int ent = attr.asInteger() - (int)(val != null ? -val : attr.getBox(attr.asString()).decrease);
					packet.setFloat("value", ent);
					attr.set(ent);
					Print.bar(player, "&7Decreasing: &6" + attr.id + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			case RESET:{
				if(attr.valuetype.isTristate()){
					packet.setBoolean("bool", false);
					packet.setBoolean("reset", true);
					Print.bar(player, "&7Resetting: &6" + attr.id);
				}
				else if(attr.valuetype.isFloat()){
					float flaot = val != null ? val : attr.getBox(attr.asString()).reset;
					packet.setFloat("value", flaot);
					attr.set(flaot);
					Print.bar(player, "&7Resetting: &6" + attr.id + " &a> " + packet.getFloat("value"));
				}
				else if(attr.valuetype.isInteger()){
					int ent = (int)(val != null ? val : attr.getBox(attr.asString()).reset);
					packet.setFloat("value", ent);
					attr.set(ent);
					Print.bar(player, "&7Resetting: &6" + attr.id + " &a> " + packet.getFloat("value"));
				}
				break;
			}
			default: return false;
		}
		/*entity.vehicle.data.getScripts().forEach(script -> {
			script.onAttributeToggle(entity, attr, old, player);
		});*///TODO
		if(player.world.isRemote){
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
			last = attr.id;
			tilltime = Time.getDate() + 20;
		}
		else{
			ServerReceiver.INSTANCE.process(packet, player);
			Static.stop();
		}
		return true;
	}

	private static boolean foundSeat(RootVehicle entity, SeatInstance seatfrom, EntityPlayer player, ItemStack stack){
		if("seat".equals(last) && Time.getDate() < tilltime) return false;
		if(!stack.isEmpty() && !(stack.getItem() instanceof ItemLead)) return false;
		if(seatfrom == null && player.getRidingEntity() instanceof GenericVehicle){
			seatfrom = ((RootVehicle)player.getRidingEntity()).vehicle.getSeatOf(player);
		}
		Entity renent = Minecraft.getMinecraft().getRenderViewEntity();
		Vec3d vec = renent.getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
		Vec3d temp0 = renent.getLook(Minecraft.getMinecraft().getRenderPartialTicks());
		temp0 = vec.add(temp0.x * 3, temp0.y * 3, temp0.z * 3);
		V3D vecto = new V3D(temp0.x, temp0.y, temp0.z);
		V3D temp1;
		Vec3f vec0 = new Vec3f(vec.x, vec.y, vec.z), vec1 = new Vec3f(vecto.x, vecto.y, vecto.z);
		for(int i = 0; i < entity.vehicle.data.getSeats().size(); i++){
			if(seatfrom != null && seatfrom.index == i) continue;
			Seat seat = entity.vehicle.data.getSeat(i);
			SeatInstance ent = entity.vehicle.seats.get(i);
			if(ent == null || ent.passenger() == null){
				SwivelPoint point = entity.vehicle.data.getRotationPoint(seat.swivel_point);
				temp1 = point.getRelativeVector(seat.pos);
				temp1 = temp1.add(entity.posX, entity.posY, entity.posZ);
				AxisAlignedBB aabb = NULBB.offset(temp1.x, temp1.y, temp1.z).grow(SBBS * seat.scale());
				for(float f = 0; f < 4; f += Static.sixteenth / 2){
					Vec3f dis = vec0.distance(vec1, f);
					vec = new Vec3d(dis.x, dis.y, dis.z);
					if(aabb.contains(vec)){
						NBTTagCompound packet = new NBTTagCompound();
						packet.setString("target_listener", "fvtm:gui");
						packet.setString("task", "toggle_seat");
						packet.setInteger("entity", entity.getEntityId());
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
	private static Collidable getCollided(boolean external, RootVehicle vehicle, EntityPlayer player, Collection<Collidable> collidables){
		Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
		if(entity == null || entity.world == null) return null;
		Vec3d vec = entity.getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
		Vec3d temp0 = entity.getLook(Minecraft.getMinecraft().getRenderPartialTicks());
		temp0 = vec.add(temp0.x * 2, temp0.y * 2, temp0.z * 2);
		V3D vecto = new V3D(temp0.x, temp0.y, temp0.z);
		Vec3f vec0 = new Vec3f(vec.x, vec.y, vec.z), vec1 = new Vec3f(vecto.x, vecto.y, vecto.z);
		TreeMap<String, AxisAlignedBB> aabbs = new TreeMap<>();
		for(Collidable coll : collidables){
			coll.collectAABBs(external, vehicle, player, aabbs, new V3D(temp0.x, temp0.y, temp0.z));
		}
		for(float f = 0; f < (external ? 3 : 2); f += Static.sixteenth / 2){
			Vec3f dis = vec0.distance(vec1, f);
			vec = new Vec3d(dis.x, dis.y, dis.z);
			if(Command.TOGGABLE) vehicle.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, dis.x, dis.y, dis.z, 0, 0, 0);
			for(Collidable coll : collidables)
				if(aabbs.containsKey(coll.id()) && aabbs.get(coll.id()).contains(vec)) return coll;
		}
		return null;
	}

	public static boolean handleClick(KeyPress press, ItemStack stack){
		if(!stack.isEmpty() && !(stack.getItem() instanceof PartItem || stack.getItem() instanceof ItemLead)) return false;
		RootVehicle rentity = null;
		for(Entity entity : Minecraft.getMinecraft().world.loadedEntityList){
			if(entity instanceof RootVehicle == false) continue;
			rentity = (RootVehicle)entity;
			if(rentity.vehicle.data.getAttribute("collision_range").asFloat() + 1 < entity.getDistance(Minecraft.getMinecraft().player)){
				continue;
			}
			if(handleClick(press, rentity, null, Minecraft.getMinecraft().player, stack)) return true;
		}
		return false;
	}
	
	public static class Collidable {
		
		protected Attribute<?> attr;
		private SwivelPoint point;
		private PartSlots slots;
		private String source;
		private String category;
		
		public Collidable(Attribute<?> attr){
			this.attr = attr;
		}

		public Collidable(SwivelPoint point, String source, PartSlots slots, String cat){
			this.point = point;
			this.source = source;
			this.slots = slots;
			category = cat;
		}

		public String id(){
			return attr == null ? source + ":" + category : attr.id;
		}

		public void collectAABBs(boolean external, RootVehicle entity, EntityPlayer player, TreeMap<String, AxisAlignedBB> aabbs, V3D temp){
			if(attr != null){
				String attrid = (external ? "external-" : "") + attr.asString();
				AttrBox abb = attr.getBox(attrid);
				if(abb == null) return;
				SwivelPoint point = entity.vehicle.data.getRotationPoint(abb.swivel_point);
				temp = point.getRelativeVector(abb.pos.x, abb.pos.y, abb.pos.z);
				temp = temp.add(entity.posX, entity.posY, entity.posZ);
				float te = abb.size;
				aabbs.put(attr.id, new AxisAlignedBB(temp.x - te, temp.y - te, temp.z - te, temp.x + te, temp.y + te, temp.z + te));
			}
			else{
				V3D pos = new V3D(slots.get(category).pos);
				if(!source.equals("vehicle")) pos = pos.add(entity.vehicle.data.getPart(source).getInstalledPos());
				temp = point.getRelativeVector(pos.x, pos.y, pos.z);
				temp = temp.add(entity.posX, entity.posY, entity.posZ);
				float te = slots.get(category).radius / 2;
				aabbs.put(id(), new AxisAlignedBB(temp.x - te, temp.y - te, temp.z - te, temp.x + te, temp.y + te, temp.z + te));
			}
		}
		
	}

}
