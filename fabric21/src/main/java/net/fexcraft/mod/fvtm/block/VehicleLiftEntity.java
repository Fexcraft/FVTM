package net.fexcraft.mod.fvtm.block;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRef;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRefHolder;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.packet.PacketTagListener;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleLiftEntity extends BlockEntity implements PacketTagListener, InteractRefHolder {

	private InteractRef ref = new InteractRef(this);
	private VehicleData data;
	public double liftstate;
	private double lowest;
	private double highest;
	private double lslot;
	private double lwheel;
	private boolean onwheels;
	public int rot;

	public VehicleLiftEntity(BlockPos pPos, BlockState pBlockState){
		super(Resources21.LIFT_ENTITY, pPos, pBlockState);
	}

	public VehicleData getVehicleData(){
		return data;
	}

	@Override
	public void saveAdditional(CompoundTag com, HolderLookup.Provider prov){
		super.saveAdditional(com, prov);
		if(data != null) com.put("VehicleData", data.write(TagCW.create()).local());
		com.putDouble("LiftState", liftstate);
		com.putFloat("Rot", rot);
	}

	@Override
	public void loadAdditional(CompoundTag com, HolderLookup.Provider prov){
		super.loadAdditional(com, prov);
		rot = com.getIntOr("Rot", 0);
		if(com.contains("VehicleData")){
			data = FvtmResources.getVehicleData(com.getCompound("VehicleData"));
			data.getRotationPoint(SwivelPoint.DEFAULT).getPivot().set_yaw(-(float)BlockType.GENERIC_4ROT.getRotationFor(rot), true);
		}
		liftstate = com.getDoubleOr("LiftState", 0);
		updateState();
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider prov){
		CompoundTag tag = new CompoundTag();
		saveAdditional(tag, prov);
		return tag;
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket(){
		return ClientboundBlockEntityDataPacket.create(this);
	}

	/*@Override
	public void handleUpdateTag(CompoundTag tag){
		load(tag);
	}*/

	public void updateState(){
		if(data == null){
			liftstate = 0;
			return;
		}
		double ls = liftstate;
		lowest = lslot = lwheel = 16;
		highest = -16;
		for(LiftingPoint point : data.getType().getLiftingPoints().values()){
			if(highest < point.pos.y) highest = point.pos.y;
			if(lowest > point.pos.y) lowest = point.pos.y;
		}
		if(data.getType().getLiftingPoints().isEmpty()){
			highest = lowest = 0;
		}
		for(WheelSlot slot : data.getWheelSlots().values()){
			if(lslot > slot.position.y) lslot = slot.position.y;
		}
		if(data.getWheelSlots().isEmpty()) lslot = 0;
		if(data.getWheelSlots().size() > 0 && data.getWheelPositions().size() > 0){
			for(V3D vec : data.getWheelPositions().values()){
				if(lwheel > vec.y) lwheel = vec.y;
			}
		}
		else lwheel = lslot;
		onwheels = data.getWheelPositions().size() >= data.getType().getVehicleType().minWheels();
		liftstate = (ls < 1.125 && !onwheels ? 1.25 : ls);
		double low = lslot > lowest ? lowest : lslot;
		if(onwheels || lwheel < low) low = lwheel;
		liftstate -= low;
		while((liftstate - low > 3)) liftstate -= 0.5;
	}

	public double getState(){
		return liftstate + -lowest;
	}

	public void setVehicle(ItemStack stack){
		if(data != null){
			level.addFreshEntity(new ItemEntity(level, worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5, data.newItemStack().local()));
			data = null;
		}
		if(stack.getItem() instanceof VehicleItem){
			data = ((VehicleItem)stack.getItem()).getData(UniStack.getStack(stack));
		}
		setChanged();
		sendUpdate();
	}

	private void sendUpdate(){
		TagCW com = TagCW.create();
		com.set("pos", worldPosition.asLong());
		if(data != null) com.set("data", data.write(TagCW.create()));
		com.set("task", "update");
		FvtmLogger.marker(com);
		Packets.sendToAll(Packet_TagListener.class, "blockentity", com);
	}

	@Override
	public void handle(TagCW packet, EntityW player){
		if(level.isClientSide){
			switch(packet.getString("task")){
				case "update":{
					if(packet.has("data")){
						data = FvtmResources.getVehicleData(packet.getCompound("data"));
						data.getRotationPoint(SwivelPoint.DEFAULT).getPivot().set_yaw(-(float)BlockType.GENERIC_4ROT.getRotationFor(rot), true);
					}
					else{
						data = null;
						liftstate = 0;
					}
					updateState();
					return;
				}
			}
		}
		else{

		}
	}

	public V3D getVehicleDataPos(){
		return new V3D(worldPosition.getX() + 0.5, worldPosition.getY() + liftstate + 0.3125, worldPosition.getZ() + 0.5);
	}

	public V3I getV3I(){
		return new V3I(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ());
	}

	public InteractRef iref(){
		return ref.set(getV3I(), worldPosition.asLong(), getVehicleDataPos());
	}

	/*@Override
	public AABB getRenderBoundingBox(){
        return WorldWIE.aabb.move(getBlockPos());
    }*/

	@Override
	public void markChanged(){
		setChanged();
	}

}
