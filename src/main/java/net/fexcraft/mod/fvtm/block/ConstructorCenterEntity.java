package net.fexcraft.mod.fvtm.block;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConstructorCenterEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private ConstructorEntity tile;
	private BlockPos conpos;
	
	public ConstructorCenterEntity(){}
	
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
		return conpos == null ? null : tile == null ? tryLink() : tile.getVehicleData();
	}
	
	@SideOnly(Side.CLIENT)
	private long lasttry;

	@SideOnly(Side.CLIENT)
	public VehicleData tryLink(){
		if(conpos == null || world == null){ return null; }
		if(lasttry + 1000 < Time.getSecond()) return null;
		TileEntity ent = world.getTileEntity(conpos);
		if(ent == null || !(ent instanceof ConstructorEntity)) return null;
		this.tile = (ConstructorEntity)ent; lasttry = Time.getDate();
		return tile.getVehicleData();
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

	public float getLength(){
		if(tile == null || tile.getVehicleData() == null) return 3;
		return tile.getVehicleData().getAttribute("constructor_length").getFloatValue();
	}

	public float getRenderLength(){
		return this.getLength() * 2 + 1;
	}

	public int getLiftState(){
		return 0;//TODO implement lift mechanism
	}

	public float getWheelOffset(){
		if(tile == null || tile.getVehicleData() == null) return 1.5f;
		return tile.getVehicleData().getAttribute("constructor_wheel_offset").getFloatValue() * Static.sixteenth;
	}

}
