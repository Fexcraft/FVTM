package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.JackEntity;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.handler.InteractionHandler;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.uni.packet.PacketTagListener;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static net.fexcraft.mod.fvtm.util.BlockTypeImpl.getRot;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JACK_BE extends BaseBlockEntity implements JackEntity, PacketTagListener, InteractionHandler.InteractRefHolder {

	protected InteractionHandler.InteractRef ref = new InteractionHandler.InteractRef(this);
	protected ArrayList<V3D> coords = new ArrayList<>();
	protected VehicleData vehicle;
	protected double height;
	protected double offset;

	public JACK_BE(BlockPos pos, BlockState state){
		super(Resources21.JACK_ENTITY, pos, state);
		PlainBase base = (PlainBase)state.getBlock();
		height = base.type.getCustomStates().get("height").asArray().get(1).float_value();
	}

	@Override
	public void loadAdditional(ValueInput in){
		super.loadAdditional(in);
		Optional<CompoundTag> com = in.read("VehicleData", CompoundTag.CODEC);
		if(com.isPresent()){
			vehicle = FvtmResources.getVehicleData(com.get());
			vehicle.getRotationPoint(SwivelPoint.DEFAULT).getPivot().set_yaw(-(float)getRot(getBlockState()), true);
			offset = fillCoords(vehicle, coords);
		}
    }

	@Override
	public void saveAdditional(ValueOutput out){
		super.saveAdditional(out);
		if(vehicle != null) out.store("VehicleData", CompoundTag.CODEC, vehicle.write(null).local());
    }

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider prov){
		CompoundTag tag = super.getUpdateTag(prov);
		if(vehicle != null) tag.put("VehicleData", vehicle.write(null).local());
		return tag;
	}

	public void dropVehicle(boolean upd){
		if(vehicle == null) return;
		level.addFreshEntity(new ItemEntity(level, worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5, vehicle.newItemStack().local()));
		vehicle = null;
		if(upd) sendVehUpdate();
	}

	public VehicleData getVehicle(){
		return vehicle;
	}

	public InteractionHandler.InteractRef iref(){
		return ref.set(getV3I(), worldPosition.asLong(), getVehiclePos());
	}

	@Override
	public List<V3D> getCoords(){
		return coords;
	}

	public V3D getVehiclePos(){
		return new V3D(worldPosition.getX() + 0.5, worldPosition.getY() + height + offset, worldPosition.getZ() + 0.5);
	}

	@Override
	public void markChanged(){
		setChanged();
	}

	public void sendVehUpdate(){
		TagCW com = TagCW.create();
		com.set("pos", worldPosition.asLong());
		if(vehicle != null) com.set("data", vehicle.write(TagCW.create()));
		com.set("task", "update");
		Packets.sendToAll(Packet_TagListener.class, "blockentity", com);
	}

	@Override
	public void handle(TagCW packet, EntityW player){
		if(level.isClientSide){
			switch(packet.getString("task")){
				case "update":{
					if(packet.has("data")){
						vehicle = FvtmResources.getVehicleData(packet.getCompound("data"));
						vehicle.getRotationPoint(SwivelPoint.DEFAULT).getPivot().set_yaw(-(float)getRot(getBlockState()), true);
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
