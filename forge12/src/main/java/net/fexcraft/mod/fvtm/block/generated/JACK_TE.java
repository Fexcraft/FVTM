package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.block.JackEntity;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.uni.packet.PacketTagListener;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JACK_TE extends BlockTileEntity implements JackEntity, PacketTagListener, InteractionHandler.InteractRefHolder {

	protected InteractionHandler.InteractRef ref = new InteractionHandler.InteractRef(this);
	protected ArrayList<V3D> coords = new ArrayList<>();
	protected VehicleData vehicle;
	protected double height;
	protected double offset;

	public JACK_TE(BlockBase type){
		super(type);
		height = type.type.getCustomStates().get("height").asArray().get(1).float_value();
	}

	public JACK_TE(){}
    
    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("VehicleData")){
			vehicle = FvtmResources.getVehicleData(compound.getCompoundTag("VehicleData"));
			vehicle.getRotationPoint(SwivelPoint.DEFAULT).getPivot().set_yaw(-(float)BlockType.GENERIC_4ROT.getRotationFor(meta), true);
			offset = fillCoords(vehicle, coords);
		}
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
		if(vehicle != null) compound.setTag("VehicleData", vehicle.write(null).local());
        return compound;
    }

	public void dropVehicle(boolean upd){
		if(vehicle == null) return;
		EntityItem item = new EntityItem(world);
		item.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
		item.setItem(vehicle.newItemStack().local());
		world.spawnEntity(item);
		vehicle = null;
		if(upd) sendVehUpdate();
	}

	public VehicleData getVehicle(){
		return vehicle;
	}

	public InteractionHandler.InteractRef iref(){
		return ref.set(getV3I(), pos.toLong(), getVehiclePos());
	}

	@Override
	public List<V3D> getCoords(){
		return coords;
	}

	public V3D getVehiclePos(){
		return new V3D(pos.getX() + 0.5, pos.getY() + height + offset, pos.getZ() + 0.5);
	}

	@Override
	public void markChanged(){
		markDirty();
	}

	public void sendVehUpdate(){
		TagCW com = TagCW.create();
		com.set("pos", pos.toLong());
		if(vehicle != null) com.set("data", vehicle.write(TagCW.create()));
		com.set("task", "update");
		Packets.sendToAll(Packet_TagListener.class, "blockentity", com);
	}

	@Override
	public void handle(TagCW packet, EntityW player){
		if(world.isRemote){
			switch(packet.getString("task")){
				case "update":{
					if(packet.has("data")){
						vehicle = FvtmResources.getVehicleData(packet.getCompound("data"));
						vehicle.getRotationPoint(SwivelPoint.DEFAULT).getPivot().set_yaw(-(float)BlockType.GENERIC_4ROT.getRotationFor(getBlockMetadata()), true);
					}
					else{
						vehicle = null;
					}
					offset = fillCoords(vehicle, coords);
					return;
				}
			}
		}
		else{

		}
	}

}
