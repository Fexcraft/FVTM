package net.fexcraft.mod.fvtm.blocks;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.mod.fvtm.util.rail.RailMap;
import net.fexcraft.mod.fvtm.util.rail.RailMapCapability;
import net.fexcraft.mod.fvtm.util.rail.RailPiece;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RailTileEntity extends TileEntity implements ITickable {
	
	private ArrayList<RailPiece> railpieces;
	
	public RailTileEntity(){
		railpieces = new ArrayList<RailPiece>();
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
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
    }

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		NBTTagList list = new NBTTagList();
		for(RailPiece rail : railpieces){
			list.appendTag(rail.writeToNBT());
		}
		compound.setTag("railpieces", list);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		railpieces.clear();
		if(compound.hasKey("railpieces")){
			NBTTagList list = (NBTTagList)compound.getTag("railpieces");
			for(NBTBase base : list){
				railpieces.add(new RailPiece((NBTTagCompound)base));
			}
		}
	}
	
	@SideOnly(Side.CLIENT) @Override
    public double getMaxRenderDistanceSquared(){
        return super.getMaxRenderDistanceSquared() * 8;
    }
	
	@SideOnly(Side.CLIENT) @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return INFINITE_EXTENT_AABB;
    }
	
	public List<RailPiece> getRailPositions(){
		return railpieces;
	}
	
	/** TEMPORARY */
	@Override
	public void update(){
		if(this.railpieces.isEmpty()){
			Vec3d next = null, prev = null;
			for(int x = -1; x < 2; x++){
				for(int z = -1; z < 2; z++){
					if(x == 0 && z == 0){
						continue;
					}
					if(next != null && prev != null){
						break;
					}
					boolean is = world.getTileEntity(new BlockPos(this.pos.getX() + x, this.pos.getY(), this.pos.getZ() + z)) instanceof RailTileEntity;
					if(is){
						if(next == null){
							next = new Vec3d(this.pos.getX() + x, this.pos.getY(), this.pos.getZ() + z);
						}
						if(next != null && prev == null){
							prev = new Vec3d(this.pos.getX() + x, this.pos.getY(), this.pos.getZ() + z);
						}
					}
				}
			}
			if(next != null && prev != null){
				this.railpieces.add(new RailPiece(prev, asVec3d(), pos, next));
				this.updateRailMap();
				Print.debugChat("CONNECTED");
			}
		}
	}

	private void updateRailMap(){
		RailMapCapability railmap = world.getCapability(RailMap.CAPABILITY, null);
		if(railmap == null){
			return;//TODO throw error
		}
		railmap.updateRailPositions(this);
	}
	
	public Vec3d asVec3d(){
		return new Vec3d(pos.getX(), pos.getY(), pos.getZ());
	}

}
