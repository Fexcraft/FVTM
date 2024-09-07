package net.fexcraft.mod.fvtm.data.vehicle;

import com.google.gson.JsonElement;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.sys.uni.KeyPress;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;

import static net.fexcraft.mod.fvtm.util.PacketsImpl.getTargetPoint;

/** @author Ferdinand Calo' (FEX___96) */
public abstract class VehicleScript {
	
	/** Optional init Data */
	@Deprecated
	public VehicleScript init(JsonElement elm) { return this; }
	
	/** Optional init Data */
	public VehicleScript init(VehicleData data, JsonElement elm) { return init(elm); }

	/** The Unique ID of the Script. */
	public abstract String getId();
	
	/** The Name of the Script. */
	public abstract String getName();
	
	/** Called on the Entity's `onUpdate` call. */
	public void onUpdate(Entity entity, VehicleData data){}
	
	/** Called when the VehicleData is loaded/read. */
	public VehicleScript load(VehicleData data, TagCW compound){ return this; }
	
	/** Called when the VehicleData is saved/written. */
	public TagCW save(VehicleData data, TagCW compound){ return null; }
	
	/** Called soon after the Entity is spawned. */
	public void onSpawn(Entity entity, VehicleData data){}
	
	/** Called on the Entity's `setDead` method. */
	public void onRemove(Entity entity, VehicleData data){}
	
	/** Return true to skip/override default entity methods. */
	public boolean onKeyPress(KeyPress key, Seat seat, EntityPlayer player){ return false; }
	
	public void onAttributeToggle(Entity entity, Attribute<?> attr, Object oldvalue, EntityPlayer player){};

	/** On player interaction with the Entity */
	public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player, EnumHand hand){ return false; }

	/** Receiver method to receive Script Packets. */
	public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side){}
	
	/** Method to send packets to scripts. */
	public void sendPacket(Entity entity, NBTTagCompound compound, Side destination){
		if(!compound.hasKey("ScriptId")) compound.setString("ScriptId", getId());
		if(destination.isClient()){
			PacketHandler.getInstance().sendToAllAround(new PacketEntityUpdate(entity, compound), getTargetPoint(entity));
		}
		else{
			PacketHandler.getInstance().sendToServer(new PacketEntityUpdate(entity, compound));
		}
	}

}
