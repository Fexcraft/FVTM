package net.fexcraft.mod.fvtm.block;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.model.block.ConstructorLiftModel;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConstCenterEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private ConstructorEntity tile;
	private BlockPos conpos;
	
	@SideOnly(Side.CLIENT)
	public Track track;
	@SideOnly(Side.CLIENT)
	public ArrayList<ConstructorLiftModel> models;
	
	public ConstCenterEntity(){}
	
	public ConstructorEntity getConstructor(){
		return tile;
	}
	
	public BlockPos getConstPos(){
		return conpos;
	}

	public TileEntity getConstTile(){
		return world.getTileEntity(conpos);
	}

	public void setConst(ConstructorEntity contile){
		conpos = contile.getPos();
		tile = contile;
		if(world.isRemote){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setLong("conpos", conpos.toLong());
			ApiUtil.sendTileEntityUpdatePacket(world, pos, compound);
		}
	}
	
	/** This is for the renderer. */
	@SideOnly(Side.CLIENT)
	public VehicleData getVehicleData(){
		return conpos == null ? null : tile == null ? tryLinkV() : tile.getVehicleData();
	}

	/** This is for the renderer, */
	public ContainerData getContainerData(){
		return conpos == null ? null : tile == null ? tryLinkC() : tile.getContainerData();
	}

	/** This is for the renderer, */
	public BlockData getBlockData(){
		return conpos == null ? null : tile == null ? tryLinkB() : tile.getBlockData();
	}
	
	@SideOnly(Side.CLIENT)
	private long lasttry;

	@SideOnly(Side.CLIENT)
	public void tryLink(){
		if(conpos == null || world == null) return;
		if(lasttry + 1000 > Time.getDate()) return;
		lasttry = Time.getDate();
		TileEntity ent = world.getTileEntity(conpos);
		if(ent == null || !(ent instanceof ConstructorEntity)){
			return;
		}
		tile = (ConstructorEntity)ent;
	}
	
	@SideOnly(Side.CLIENT)
	public VehicleData tryLinkV(){
		tryLink();
		return tile == null ? null : tile.getVehicleData();
	}
	
	@SideOnly(Side.CLIENT)
	public ContainerData tryLinkC(){
		tryLink();
		return tile == null ? null : tile.getContainerData();
	}
	
	@SideOnly(Side.CLIENT)
	public BlockData tryLinkB(){
		tryLink();
		return tile == null ? null : tile.getBlockData();
	}
	
	//

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
        if(packet.nbt.hasKey("conpos")){
        	conpos = BlockPos.fromLong(packet.nbt.getLong("conpos"));
        	tryLink();
        }
        if(packet.nbt.hasKey("conpos_reset") && packet.nbt.getBoolean("conpos_reset")){
        	conpos = null;
			tile = null;
        }
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
        if(conpos != null){
            compound.setLong("Constructor", conpos.toLong());
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("Constructor")){
            this.conpos = BlockPos.fromLong(compound.getLong("Constructor"));
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public double getMaxRenderDistanceSquared(){
        return super.getMaxRenderDistanceSquared() * 8;
    }
    
    public static final AxisAlignedBB FINITE_EXTENT_AABB = new AxisAlignedBB(-16, -16, -16, 16, 16, 16);

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return /*IN*/FINITE_EXTENT_AABB.offset(pos);
    }
    
    private double liftstate, lowest, upmost, slot, wheeloff;
    private boolean onwheels;

	public void updateLiftState(){
		VehicleData data = this.getVehicleData();
		if(data == null){
			liftstate = 0;
			return;
		}
		float input = tile.liftstate;
		lowest = slot = -16;
		upmost = 16;
		for(LiftingPoint point : data.getType().getLiftingPoints().values()){
			if(upmost > point.pos.y) upmost = point.pos.y;
			if(lowest < point.pos.y) lowest = point.pos.y;
		}
		for(WheelSlot ws : data.getWheelSlots().values()){
			if(slot < ws.position.y) slot = (float)ws.position.y;
		}
		wheeloff = -16;
		if(data.getWheelPositions().size() > 0){
			if(!data.getWheelPositions().isEmpty()){
				for(V3D vec : data.getWheelPositions().values()){
					if(wheeloff < -vec.y) wheeloff = (float)-vec.y;
				}
			}
		}
		else wheeloff = slot;
		onwheels = data.getWheelPositions().size() >= 4;
		liftstate = (input > -1.25f && !onwheels ? -1.25f : input);
		double low = getAddition();
		liftstate += lowest - low;
		while(liftstate + -lowest < -3) liftstate += 0.5f;
	}

	public double getLiftState(){
		return liftstate + -lowest;
	}
	
	private double getAddition(){
		double low = slot < lowest ? lowest : slot;
		return (!onwheels || wheeloff < low ? low : wheeloff);
	}

	public double getRawLiftState(){
		return liftstate;
	}
	
	public double getLowestLiftPoint(){
		return lowest;
	}

}
