package net.fexcraft.mod.fvtm.block;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleLiftEntity extends TileEntity {

	public static final AxisAlignedBB RENDER_AABB = new AxisAlignedBB(-16, -16, -16, 16, 16, 16);
	private VehicleData data;
	private double liftstate;
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
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		if(data != null) compound.setTag("VehicleData", data.write(TagCW.create()).local());
		compound.setDouble("LiftState", liftstate);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		if(compound.hasKey("VehicleData")){
			data = FvtmResources.getVehicleData(compound.getCompoundTag("VehicleData"));
		}
		liftstate = compound.getDouble("LiftState");
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
		lowest = lslot = lwheel = -16;
		highest = 16;
		for(LiftingPoint point : data.getType().getLiftingPoints().values()){
			if(highest < point.pos.y) highest = point.pos.y;
			if(lowest > point.pos.y) lowest = point.pos.y;
		}
		for(WheelSlot slot : data.getWheelSlots().values()){
			if(lslot > slot.position.y) lslot = slot.position.y;
		}
		if(data.getWheelSlots().size() > 0 && data.getWheelPositions().size() > 0){
			for(V3D vec : data.getWheelPositions().values()){
				if(lwheel > vec.y) lwheel = vec.y;
			}
		}
		else lwheel = lslot;
		onwheels = data.getWheelPositions().size() >= data.getType().getVehicleType().minWheels();
		liftstate = (ls > -1.125 && !onwheels ? -1.25 : ls);
		double low = lslot < lowest ? lowest : lslot;
		if(onwheels || lwheel > low) low = lwheel;
		liftstate += lowest - low;
		while((liftstate + -lowest < -3)) liftstate += 0.5;
	}

	public double getState(){
		return liftstate + -lowest;
	}

}
