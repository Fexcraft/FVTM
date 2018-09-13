package net.fexcraft.mod.fvtm.blocks.rail;

import net.fexcraft.mod.fvtm.api.StaticValues;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import trackapi.lib.ITrack;

@Optional.Interface(iface = "trackapi.lib.ITrack", modid = "trackapi")
public class TrackTileEntity extends TileEntity implements ITrack, IPacketReceiver<PacketTileEntityUpdate> {
	
	public Connection[] connections = new Connection[0];

	public TrackTileEntity(World world){
		if(this.world == null) this.world = world;
		
	}
	
	public TrackTileEntity(){}

	@Override @Optional.Method(modid = "trackapi")
	public double getTrackGauge(){
		return StaticValues.GAUGE_S125;
	}

	@Override @Optional.Method(modid = "trackapi")
	public Vec3d getNextPosition(Vec3d currpos, Vec3d motion){
		return currpos;
	}

    @Override
    public void processServerPacket(PacketTileEntityUpdate packet){
        //
    }

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
    	this.readFromNBT(packet.nbt);
    }	@Override
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
        	for(Connection conn : connections){ nbtlinks.appendTag(conn.write(new NBTTagCompound())); }
        	compound.setTag("connections", nbtlinks);
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("connections")){
        	NBTTagList list = (NBTTagList)compound.getTag("connections");
        	connections = new Connection[list.tagCount()];
        	for(int i = 0; i < connections.length; i++){
        		connections[i] = new Connection().read(list.getCompoundTagAt(i));
        	}
        }
    }

	public void reset(){
		this.connections = new Connection[0];
		this.sendUpdate();
	}
	
	public void sendUpdate(){
		if(world == null || world.isRemote) return;
		ApiUtil.sendTileEntityUpdatePacket(world, pos, this.writeToNBT(new NBTTagCompound()));
	}

	public void addConnection(Connection connection){
		Connection[] conns = new Connection[connections.length + 1];
		for(int i = 0; i < connections.length; i++) conns[i] = connections[i];
		conns[connections.length] = connection; connections = conns;
		//
		if(connection.opposite) return; ((TrackTileEntity)world.getTileEntity(connection.getDestination())).addConnection(connection.opposite(pos));
		this.sendUpdate();
	}
	
	public void delConnection(Connection conn){
		int i = -1; for(int j = 0; j < connections.length; j++){
			if(connections[j].getDestination().equals(conn.getDestination())){ i = j; break; }
		} if(i >= 0) remConnection(i); //else throw/log error
		if(conn.opposite) return;
		((TrackTileEntity)world.getTileEntity(conn.getDestination())).delConnection(conn.opposite(pos));
	}

	private void remConnection(int i){
		int j = 0; Connection[] conns = new Connection[connections.length - 1];
		for(int k = 0; k < connections.length; k++){
			if(k != i){ conns[j] = connections[k]; j++; }
		} connections = conns; this.sendUpdate();
	}
	
}