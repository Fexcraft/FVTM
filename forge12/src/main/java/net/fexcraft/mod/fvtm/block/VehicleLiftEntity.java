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
import net.fexcraft.mod.uni.packet.PacketListener;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleLiftEntity extends TileEntity implements PacketListener, InteractRefHolder {

	public static final AxisAlignedBB RENDER_AABB = new AxisAlignedBB(-16, -16, -16, 16, 16, 16);
	private InteractRef ref = new InteractRef(this);
	private VehicleData data;
	public double liftstate;
	private double lowest;
	private double highest;
	private double lslot;
	private double lwheel;
	private boolean onwheels;

	public VehicleLiftEntity(){}

	public VehicleData getVehicleData(){
		return data;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		return new SPacketUpdateTileEntity(getPos(), getBlockMetadata(), getUpdateTag());
	}

	@Override
	public NBTTagCompound getUpdateTag(){
		return writeToNBT(new NBTTagCompound());
	}

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
        super.readFromNBT(pkt.getNbtCompound());
        this.readFromNBT(pkt.getNbtCompound());
    }

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		if(data != null) compound.setTag("VehicleData", data.write(TagCW.create()).local());
		compound.setDouble("LiftState", liftstate);
		compound.setFloat("Meta", getBlockMetadata());
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		int meta = compound.getInteger("Meta");
		if(compound.hasKey("VehicleData")){
			data = FvtmResources.getVehicleData(compound.getCompoundTag("VehicleData"));
			data.getRotationPoint(SwivelPoint.DEFAULT).getPivot().set_yaw(-(float)BlockType.GENERIC_4ROT.getRotationFor(meta), true);
		}
		liftstate = compound.getDouble("LiftState");
		updateState();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public double getMaxRenderDistanceSquared(){
		return super.getMaxRenderDistanceSquared() * 8;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getRenderBoundingBox(){
		return RENDER_AABB.offset(pos);
	}

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
			EntityItem item = new EntityItem(world);
			item.setItem(data.newItemStack().local());
			item.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
			world.spawnEntity(item);
			data = null;
		}
		if(stack.getItem() instanceof VehicleItem){
			data = ((VehicleItem)stack.getItem()).getData(TagCW.wrap(stack.getTagCompound()));
		}
		sendUpdate();
	}

	private void sendUpdate(){
		TagCW com = TagCW.create();
		com.set("pos", pos.toLong());
		if(data != null) com.set("data", data.write(TagCW.create()));
		com.set("task", "update");
		FvtmLogger.marker(com);
		Packets.sendToAll(Packet_TagListener.class, "blockentity", com);
	}

	@Override
	public void handle(TagCW packet, EntityW player){
		if(world.isRemote){
			switch(packet.getString("task")){
				case "update":{
					if(packet.has("data")){
						data = FvtmResources.getVehicleData(packet.getCompound("data"));
						data.getRotationPoint(SwivelPoint.DEFAULT).getPivot().set_yaw(-(float)BlockType.GENERIC_4ROT.getRotationFor(getBlockMetadata()), true);
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
		return new V3D(pos.getX() + 0.5, pos.getY() + liftstate + 0.3125, pos.getZ() + 0.5);
	}

	public V3I getV3I(){
		return new V3I(pos.getX(), pos.getY(), pos.getZ());
	}

	public InteractRef iref(){
		return ref.set(getV3I(), pos.toLong(), getVehicleDataPos());
	}

	@Override
	public void markChanged(){
		markDirty();
	}

}
