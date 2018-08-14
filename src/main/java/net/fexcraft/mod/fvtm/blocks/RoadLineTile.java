package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Vec3f;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RoadLineTile extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	public BlockPos[][] connections = new BlockPos[0][];
	public Vec3f coords[][];
	public int segments;
	
    public RoadLineTile(World world){
		if(this.world == null){
			this.world = world;
		}
	}
    
    public RoadLineTile(){}

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
        if(connections != null){
        	NBTTagList nbtlinks = new NBTTagList();
        	for(int i = 0; i < connections.length; i++){
        		if(connections[i] == null || connections[i].length < 3) continue;
        		NBTTagCompound nbt = new NBTTagCompound();
        		for(int j = 0; j < connections[i].length; j++){
        			if(connections[i][j] == null) continue;
        			nbt.setLong("pos" + j, connections[i][j].toLong());
        		}
        		nbtlinks.appendTag(nbt);
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
        	connections = new BlockPos[list.tagCount()][];
        	for(int i = 0; i < connections.length; i++){
        		NBTTagCompound comp = list.getCompoundTagAt(i);
        		connections[i] = new BlockPos[4];
        		connections[i][0] = BlockPos.fromLong(comp.getLong("pos0"));
        		connections[i][1] = BlockPos.fromLong(comp.getLong("pos1"));
        		connections[i][2] = BlockPos.fromLong(comp.getLong("pos2"));
        		//connections[i][3] = BlockPos.fromLong(comp.getLong("pos3"));
        	}
        }
    	coords = null;
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

    /** array of 4 values expected, value at index 0 being equal to the position of this */
	public void addLink(BlockPos[] arr){
		if(!arr[0].equals(this.pos)) return;
		BlockPos[][] links = new BlockPos[connections.length + 1][];
		for(int i = 0; i < connections.length; i++) links[i] = connections[i];
		links[connections.length] = new BlockPos[]{ arr[1], arr[2], arr[3] };
		connections = links; this.update();
	}

	public void delLink(BlockPos endpos){
		int id = -1;
		for(int i = 0; i < connections.length; i++){
			if(connections[i][2].equals(pos)){
				id = i; break;
			}
		}
		if(id >= 0){
			if(connections.length == 1){
				connections = new BlockPos[0][];
			}
			else{
				BlockPos[][] arr = new BlockPos[connections.length - 1][];
				int i = 0; for(BlockPos[] conn : connections){
					if(id != i) arr[i] = conn; i++;
				}
				connections = arr;
			}
			this.update();
		}
	}

	public void reset(){
		RoadLineTile tile = null;
		for(BlockPos[] pos : connections){
			if((tile = (RoadLineTile)world.getTileEntity(pos[2])) != null){
				tile.delLink(this.pos);
				tile.update();
			}
		}
		connections = new BlockPos[0][];
		this.update();
	}

	private void update(){
		if(world != null && !world.isRemote){
			ApiUtil.sendTileEntityUpdatePacket(world, pos, Print.debugR(this.writeToNBT(new NBTTagCompound())));
		}
	}
	
	private Vec3f vecpos;

	public Vec3f getVec3f(){
		return vecpos == null ? this.pos == null ? new Vec3f(0.5f, 0.5f, 0.5f) : (vecpos = new Vec3f(this.pos, true)) : vecpos;
	}

}
