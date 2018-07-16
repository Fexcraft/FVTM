package net.fexcraft.mod.fvtm.blocks;

import java.util.TreeMap;

import net.fexcraft.mod.fvtm.api.rail.IRailProvider;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RailConnTile extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, IRailProvider {
	
	public BlockPos[] connections = new BlockPos[0];
	
    public RailConnTile(World world){
		if(this.world == null){
			this.world = world;
		}
	}
    
    public RailConnTile(){}

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
        if(connections.length > 0){
        	NBTTagList nbtlinks = new NBTTagList();
        	for(BlockPos pos : connections){
        		nbtlinks.appendTag(new NBTTagLong(pos.toLong()));
        	}
        	compound.setTag("connections", nbtlinks);
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("connections")){
        	NBTTagList list = (NBTTagList)compound.getTag("connections");
        	connections = new BlockPos[list.tagCount()];
        	for(int i = 0; i < connections.length; i++){
        		connections[i] = BlockPos.fromLong(((NBTTagLong)list.get(i)).getLong());
        	}
        }
    }

    @Override
    public void processServerPacket(PacketTileEntityUpdate packet){
        //
    }

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
    	this.readFromNBT(packet.nbt);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public double getMaxRenderDistanceSquared(){
        return super.getMaxRenderDistanceSquared() * 8;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return INFINITE_EXTENT_AABB;
    }

	public void addLink(BlockPos newlink){
		BlockPos[] links = new BlockPos[connections.length + 1];
		for(int i = 0; i < connections.length; i++){
			links[i] = connections[i];
		}
		links[connections.length] = newlink; connections = links;
		//
		if(!world.isRemote){
			ApiUtil.sendTileEntityUpdatePacket(world, pos, Print.debugR(this.writeToNBT(new NBTTagCompound())));
		}
	}

	public void delLink(BlockPos pos){
		int id = -1;
		for(int i = 0; i < connections.length; i++){
			if(connections[i].equals(pos)){
				id = i; break;
			}
		}
		if(id >= 0){
			if(connections.length == 1){
				connections = new BlockPos[0];
			}
			else{
				BlockPos[] arr = new BlockPos[connections.length - 1];
				int i = 0; for(BlockPos conn : connections){
					if(id != i){
						arr[i] = conn;
					} i++;
				}
				connections = arr;
			}
			if(!world.isRemote){
				ApiUtil.sendTileEntityUpdatePacket(world, pos, Print.debugR(this.writeToNBT(new NBTTagCompound())));
			}
		}
	}
	
	private static final TreeMap<BlockPos, Vec3d> vecs = new TreeMap<>();
	
	public static final Vec3d newVector(BlockPos pos){
		if(vecs.containsKey(pos)){
			return vecs.get(pos);
		}
		Vec3d vec = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
		vecs.put(pos, vec); return vec;
	}
	
	/*
	 * IF2/4: 1-2 / 3-4
	 * IF3: 2-3 depending on redstone, or 1 (opposite/reverse)
	 */
	public BlockPos getNext(BlockPos current, BlockPos previous){
		if(current == null){
			return connections.length == 0 ? pos : connections[0];
		}
		for(int i = 0; i < connections.length; i++){
			if(!connections[i].equals(current)){
				switch(connections.length){
					case 1:{
						return connections[i];
					}
					case 2:{
						return connections[i];
					}
					case 3:{
						if(i == 0 || (connections[1].equals(previous) && !connections[2].equals(previous))){
							return connections[0];
						}
						else{
							return world.isBlockPowered(pos) ? connections[2] : connections[1];
						}
					}
					case 4:{
						if(i == 0 && connections[1].equals(previous)){
							return connections[0];
						}
						if(i == 1 && connections[0].equals(previous)){
							return connections[1];
						}
						if(i == 2 && connections[3].equals(previous)){
							return connections[2];
						}
						if(i == 3 && connections[2].equals(previous)){
							return connections[3];
						}
						continue;
					}
				}
			}
		}
		return pos;
	}

}
