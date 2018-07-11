package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.entities.RailLink;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RailConnTile extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	public RailLink[] links;
	
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
        if(links != null && links.length > 0){
        	NBTTagList nbtlinks = new NBTTagList();
        	for(RailLink link : links){
        		nbtlinks.appendTag(link.write());
        	}
        	compound.setTag("raillinks", nbtlinks);
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("raillinks")){
        	NBTTagList list = (NBTTagList)compound.getTag("raillinks");
        	links = new RailLink[list.tagCount()];
        	for(int i = 0; i < links.length; i++){
        		links[i] = new RailLink(list.getCompoundTagAt(i));
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

	public void addLink(RailLink newlink){
		if(links == null){
			links = new RailLink[]{ newlink };
		}
		else{
			RailLink[] arr = new RailLink[links.length + 1];
			for(int i = 0; i < links.length; i++){
				arr[i] = links[i];
			}
			arr[links.length] = newlink; links = arr;
		}
		if(!world.isRemote){
			ApiUtil.sendTileEntityUpdatePacket(world, pos, Print.debugR(this.writeToNBT(new NBTTagCompound())));
		}
	}

}
