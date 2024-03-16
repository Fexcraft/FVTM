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
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler.DPIHData;
import net.fexcraft.mod.uni.impl.SWI;
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

	public static boolean handleClick(KeyPress press, ItemStack stack){
		if(!stack.isEmpty() && !(stack.getItem() instanceof PartItem || stack.getItem() instanceof ItemLead)) return false;
		RootVehicle rentity;
		for(Entity entity : Minecraft.getMinecraft().world.loadedEntityList){
			if(entity instanceof RootVehicle == false) continue;
			rentity = (RootVehicle)entity;
			if(rentity.vehicle.data.getAttribute("collision_range").asFloat() + 1 < entity.getDistance(Minecraft.getMinecraft().player)){
				continue;
			}
			Passenger pass = Minecraft.getMinecraft().player.getCapability(Capabilities.PASSENGER, null).asWrapper();
			if(InteractionHandler.handle(press, rentity.vehicle, null, pass, new SWI(stack))) return true;
		}
		return false;
	}

}
