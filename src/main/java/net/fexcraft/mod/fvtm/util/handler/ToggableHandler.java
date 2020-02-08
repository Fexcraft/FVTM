package net.fexcraft.mod.fvtm.util.handler;

import java.util.Collection;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.gui.ServerReceiver;
import net.fexcraft.mod.fvtm.sys.legacy.KeyPress;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.util.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ToggableHandler {
	
	public static boolean handleClick(KeyPress press, VehicleEntity entity, SeatEntity seat, EntityPlayer player){//TODO support for other attribute types, e.g. numbers
    	Collection<Attribute<?>> attributes = entity.getVehicleData().getAttributes().values()
    		.stream().filter(pr -> pr.hasAABBs() && (pr.type().isTristate() || pr.type().isNumber())
    			&& (seat == null ? pr.external() : (seat.seatdata.driver || pr.seat().equals(seat.seatdata.name)))
    		).collect(Collectors.toList());
    	if(attributes.size() == 0){ /*Print.chat(player, "none found");*/ return false; }
    	Attribute<?> attr = getCollided(seat == null, entity, player, attributes);
    	if(attr == null){ /*Print.chat(player, "none hit");*/ return false; }
		NBTTagCompound packet = new NBTTagCompound();
		packet.setString("target_listener", "fvtm:gui"); packet.setString("task", "attr_toggle");
		packet.setString("attr", attr.id()); packet.setInteger("entity", entity.getEntity().getEntityId());
    	switch(press){
        	case MOUSE_MAIN:{
        		if(attr.type().isTristate()){
            		packet.setBoolean("bool", !attr.type().isBoolean() ? false : true);
            		Print.bar(player, "&7Toggled: &6" + attr.id() + " &a> " + packet.getBoolean("bool")); 
        		}
        		else if(attr.type().isFloat()){
        			float flaot = attr.getFloatValue() + attr.getAABB(attr.getStringValue())[4];
        			packet.setFloat("value", flaot); attr.setValue(flaot);
        		}
        		else if(attr.type().isInteger()){
        			int ent = attr.getIntegerValue() + (int)attr.getAABB(attr.getStringValue())[4];
        			packet.setFloat("value", ent); attr.setValue(ent);
        		}
        		break;
        	}
        	case MOUSE_RIGHT:{
        		if(attr.type().isTristate()){
            		packet.setBoolean("bool", !attr.type().isBoolean() ? true : false);
            		Print.bar(player, "&7Toggled: &6" + attr.id() + " &a> " + packet.getBoolean("bool")); 
        		}
        		else if(attr.type().isFloat()){
        			float flaot = attr.getFloatValue() - attr.getAABB(attr.getStringValue())[5];
        			packet.setFloat("value", flaot); attr.setValue(flaot);
        		}
        		else if(attr.type().isInteger()){
        			int ent = attr.getIntegerValue() - (int)attr.getAABB(attr.getStringValue())[5];
        			packet.setFloat("value", ent); attr.setValue(ent);
        		}
        		break;
        	}
        	case RESET:{
        		if(attr.type().isTristate()){
            		packet.setBoolean("bool", false);
            		packet.setBoolean("reset", true);
            		Print.bar(player, "&7Reset: &6" + attr.id()); 
        		}
        		else if(attr.type().isFloat()){
        			float flaot = attr.getAABB(attr.getStringValue())[6];
        			packet.setFloat("value", flaot); attr.setValue(flaot);
        		}
        		else if(attr.type().isInteger()){
        			int ent = (int)attr.getAABB(attr.getStringValue())[6];
        			packet.setFloat("value", ent); attr.setValue(ent);
        		}
        		break;
        	}
        	default: return false;
    	}
    	if(player.world.isRemote){
    		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
    	}
    	else{
    		ServerReceiver.INSTANCE.process(packet, player);
    	}
		return true;
	}

    @SideOnly(Side.CLIENT) //Eventually checks about which is closest?
	private static Attribute<?> getCollided(boolean external, VehicleEntity vehicle, EntityPlayer player, Collection<Attribute<?>> attributes){
		Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
		if(entity == null || entity.world == null) return null;
        Vec3d vec = entity.getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
        Vec3d temp = entity.getLook(Minecraft.getMinecraft().getRenderPartialTicks());
        Vec3d vecto = vec.addVector(temp.x * 2, temp.y * 2, temp.z * 2);
        Vec3f vec0 = new Vec3f(vec.x, vec.y, vec.z), vec1 = new Vec3f(vecto.x, vecto.y, vecto.z);
        TreeMap<String, AxisAlignedBB> aabbs = new TreeMap<>();
        for(Attribute<?> attr : attributes){
        	float[] arr = attr.getAABB((external ? "external-" : "") + attr.getStringValue());
        	temp = vehicle.getAxes().getRelativeVector(arr[0] * Static.sixteenth, -arr[1] * Static.sixteenth, -arr[2] * Static.sixteenth);
        	temp = temp.add(vehicle.getEntity().getPositionVector()); float te = arr[3] * Static.sixteenth;
            if(Command.DEBUG) vehicle.getEntity().world.spawnParticle(EnumParticleTypes.FLAME, temp.x, temp.y, temp.z, 0, 0, 0);
        	aabbs.put(attr.id(), new AxisAlignedBB(temp.x - te, temp.y - te, temp.z - te, temp.x + te, temp.y + te, temp.z + te));
        }
        for(float f = 0; f < (external ? 3 : 2); f += Static.sixteenth / 2){
        	Vec3f dis = vec0.distance(vec1, f);vec = new Vec3d(dis.xCoord, dis.yCoord, dis.zCoord);
            if(Command.DEBUG) vehicle.getEntity().world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, dis.xCoord, dis.yCoord, dis.zCoord, 0, 0, 0);
            for(Attribute<?> attr : attributes) if(aabbs.get(attr.id()).contains(vec)) return attr;
        } return null;
	}

	public static boolean handleClick(KeyPress press){
		for(Entity entity : Minecraft.getMinecraft().world.loadedEntityList){
			if(entity instanceof VehicleEntity == false) continue;
			if(((VehicleEntity)entity).getVehicleData().getAttribute("collision_range").getFloatValue() + 1 < entity.getDistance(Minecraft.getMinecraft().player)){
				Print.debug("veh dis: " + ((VehicleEntity)entity).getVehicleData().getAttribute("collision_range").getFloatValue());
				Print.debug("ply dis: " + entity.getDistance(Minecraft.getMinecraft().player));
				continue;
			}
			if(handleClick(press, (VehicleEntity)entity, null, Minecraft.getMinecraft().player)) return true;
		}
		return false;
	}

}
