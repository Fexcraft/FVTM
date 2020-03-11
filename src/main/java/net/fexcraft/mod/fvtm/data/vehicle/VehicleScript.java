package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.sys.legacy.KeyPress;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;

/** @author Ferdinand Calo' (FEX___96) */
public abstract class VehicleScript {

	/** The Unique ID of the Script. */
	public abstract String getId();
	
	/** The Name of the Script. */
	public abstract String getName();
	
	/** Called on the Entity's `onUpdate` call. */
	public abstract void onUpdate(Entity entity, VehicleData data);
	
	/** Called when the VehicleData is loaded/read. */
	public abstract VehicleScript read(VehicleData data, NBTTagCompound compound);
	
	/** Called when the VehicleData is saved/written. */
	public abstract NBTTagCompound write(VehicleData data, NBTTagCompound compound);
	
	/** Called soon after the Entity is spawned. */
	public abstract void onSpawn(Entity entity, VehicleData data);
	
	/** Called on the Entity's `setDead` method. */
	public abstract void onRemove(Entity entity, VehicleData data);
	
	/** Return true to skip/override default entity methods. */
	public abstract boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player);
	
	public void onAttributeToggle(Attribute<?> attr, String value, EntityPlayer player){};

	/** On player interaction with the Entity */
	public abstract boolean onInteract(Entity entity, VehicleData data, EntityPlayer player, EnumHand hand);

	/** Receiver method to receive Script Packets. */
	public abstract void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side);
	
	/** Method to send packets to scripts. */
	public void sendPacket(Entity entity, NBTTagCompound compound, Side destination){
		if(!compound.hasKey("ScriptId")) compound.setString("ScriptId", getId());
		if(destination.isClient()){
			PacketHandler.getInstance().sendToAllAround(new PacketEntityUpdate(entity, compound), Resources.getTargetPoint(entity));
		}
		else{
			PacketHandler.getInstance().sendToServer(new PacketEntityUpdate(entity, compound));
		}
	}

}
