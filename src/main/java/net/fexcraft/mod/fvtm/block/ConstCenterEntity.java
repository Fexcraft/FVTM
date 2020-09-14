package net.fexcraft.mod.fvtm.block;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.mod.fvtm.data.WheelSlot;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.block.ConstructorLiftModel;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
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
	
	public BlockPos getLinkPos(){
		return conpos;
	}
	
	public int[] getLinkArray(){
		return conpos == null ? new int[]{ 0, 0, 0 } : new int[]{ conpos.getX(), conpos.getY(), conpos.getZ() };
	}
	
	/** This for the renderer, better not use elsewhere. */
	@SideOnly(Side.CLIENT)
	public VehicleData getVehicleData(){
		return conpos == null ? null : tile == null ? tryLinkV() : tile.getVehicleData();
	}

	/** This for the renderer, */
	public ContainerData getContainerData(){
		return conpos == null ? null : tile == null ? tryLinkC() : tile.getContainerData();
	}

	/** This for the renderer, */
	public BlockData getBlockData(){
		return conpos == null ? null : tile == null ? tryLinkB() : tile.getBlockData();
	}
	
	@SideOnly(Side.CLIENT)
	private long lasttry;

	@SideOnly(Side.CLIENT)
	public void tryLink(){
		if(conpos == null || world == null){ return; }
		if(lasttry + 1000 < Time.getSecond()) return;
		TileEntity ent = world.getTileEntity(conpos);
		if(ent == null || !(ent instanceof ConstructorEntity)) return;
		this.tile = (ConstructorEntity)ent; lasttry = Time.getDate();
	}
	
	@SideOnly(Side.CLIENT)
	public VehicleData tryLinkV(){
		tryLink(); return tile == null ? null : tile.getVehicleData();
	}
	
	@SideOnly(Side.CLIENT)
	public ContainerData tryLinkC(){
		tryLink(); return tile == null ? null : tile.getContainerData();
	}
	
	@SideOnly(Side.CLIENT)
	public BlockData tryLinkB(){
		tryLink(); return tile == null ? null : tile.getBlockData();
	}

	public void setLinkPos(BlockPos pos, boolean update){
		this.conpos = pos; if(update) link();
	}

	private void link(){
		if(world == null) return;
		if(conpos == null){
			this.tile = null; if(world.isRemote) return;
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("conpos_reset", true);
			ApiUtil.sendTileEntityUpdatePacket(world, pos, compound);
		}
		else{
			TileEntity ent = world.getTileEntity(conpos);
			if(ent == null || !(ent instanceof ConstructorEntity)) return;
			this.tile = (ConstructorEntity)ent;
			if(!world.isRemote && tile != null){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setLong("conpos", conpos.toLong());
				ApiUtil.sendTileEntityUpdatePacket(world, pos, compound);
			} else return;
		}
	}
	
	//

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
        if(packet.nbt.hasKey("conpos")){
        	this.conpos = BlockPos.fromLong(packet.nbt.getLong("conpos"));
        	this.tryLink();
        }
        if(packet.nbt.hasKey("conpos_reset") && packet.nbt.getBoolean("conpos_reset")){
        	this.conpos = null; this.tile = null;
        }
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket(){
        return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag(){
        return this.writeToNBT(new NBTTagCompound());
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
    
    private float liftstate, lowest, upmost, slot, wheeloff;
    private boolean onwheels;
    private static final float adj = 0.25f;

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
			if(upmost > point.pos.y16) upmost = point.pos.y16;
			if(lowest < point.pos.y16) lowest = point.pos.y16;
		}
		/*if(data.getWheelSlots().size() < 4){
			liftstate = input < -1.5f ? input : -1.5f;
			return;
		}*/
		for(WheelSlot ws : data.getWheelSlots().values()){
			if(slot < ws.pos().y16) slot = ws.pos().y16;
		}
		wheeloff = -16;
		if(!data.getWheelPositions().isEmpty()){
			for(Vec3d vec : data.getWheelPositions().values()){
				if(wheeloff < -vec.y) wheeloff = (float)-vec.y;
			}
		}
		onwheels = data.getWheelPositions().size() >= 4;
		liftstate = /*Command.getValI("lift", 0) +*/ (input > -1.25f && !onwheels ? -1.25f : input);
		//if(liftstate + upmost - adj < -4) liftstate = -4 - upmost;
		float low = getAddition();
		if(liftstate + low - adj > 0) liftstate = -(low + getLiftState());
	}

	public float getLiftState(){
		return liftstate + (lowest > 0 ? -lowest : lowest) - adj;
	}
	
	private float getAddition(){
		float low = slot > lowest ? slot : lowest;
		return (!onwheels || wheeloff > low ? wheeloff : low);
	}

	public float getRawLiftState(){
		return liftstate;
	}
	
	public float getLowestLiftPoint(){
		return lowest;
	}

}
