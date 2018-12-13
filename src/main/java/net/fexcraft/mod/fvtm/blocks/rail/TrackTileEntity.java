package net.fexcraft.mod.fvtm.blocks.rail;

import net.fexcraft.lib.common.utils.Print;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM.InternalAddon;
import net.fexcraft.mod.fvtm.api.Gauge;
import net.fexcraft.mod.fvtm.api.StaticValues;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trackapi.lib.ITrack;

/** @author Ferdinand Calo' (FEX___96) **/
@Optional.Interface(iface = "trackapi.lib.ITrack", modid = "trackapi")
public class TrackTileEntity extends TileEntity implements ITrack, IPacketReceiver<PacketTileEntityUpdate> {
	
	public Connection[] connections = new Connection[0];
	public Gauge gauge;

	public TrackTileEntity(World world){
		if(this.world == null) this.world = world;
	}
	
	public TrackTileEntity(){}

	@Override @Optional.Method(modid = "trackapi")
	public double getTrackGauge(){
		return gauge == null ? StaticValues.GAUGE_S125 : gauge.width() * Static.sixteenth;
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
    	compound.setString(Gauge.GaugeItem.NBTKEY, (gauge == null ? InternalAddon.STANDARD_GAUGE : gauge.getRegistryName()).toString());
    	Print.console("writ " + compound);
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
        gauge = Resources.GAUGES.getValue(compound.hasKey(Gauge.GaugeItem.NBTKEY) ? new ResourceLocation(compound.getString(Gauge.GaugeItem.NBTKEY)) : InternalAddon.STANDARD_GAUGE);
        Print.console("read " + compound);
        if(world == null || !world.isRemote) RailUtil.attach(this);
    }

	public void reset(){
		for(Connection conn : connections) delConnection(conn, false);
		this.sendUpdate();
	}
	
	public void sendUpdate(){
		if(world == null || world.isRemote) return;
		ApiUtil.sendTileEntityUpdatePacket(world, pos, this.writeToNBT(new NBTTagCompound()));
	}

	public void addConnection(Connection connection, boolean copy){
		Connection[] conns = new Connection[connections.length + 1];
		for(int i = 0; i < connections.length; i++) conns[i] = connections[i];
		conns[connections.length] = connection; connections = conns;
		//
		if(copy) return;
		TrackTileEntity tile = (TrackTileEntity)world.getTileEntity(connection.getDestination());
		if(tile != null) tile.addConnection(connection.opposite(), true);
		this.sendUpdate(); RailUtil.update(this, true);
	}
	
	public void delConnection(Connection conn, boolean copy){
		int i = -1; for(int j = 0; j < connections.length; j++){
			if(connections[j].getDestination().equals(conn.getDestination())){ i = j; break; }
		} if(i >= 0) remConnection(i); //else throw/log error
		if(copy) return;
		TrackTileEntity tile = (TrackTileEntity)world.getTileEntity(conn.getDestination());
		if(tile != null) tile.delConnection(conn.opposite(), true);
	}

	private void remConnection(int i){
		int j = 0; Connection[] conns = new Connection[connections.length - 1];
		for(int k = 0; k < connections.length; k++){
			if(k != i){ conns[j] = connections[k]; j++; }
		} connections = conns; this.sendUpdate();
		RailUtil.update(this, false);
	}
	
	@Override
	public void invalidate(){
		RailUtil.detach(this);
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
    
    /*
	 * IF2/4: 1-2 / 3-4
	 * IF3: 2-3 depending on redstone, or 1 (opposite/reverse)
	 */
	public BlockPos getNext(BlockPos current, BlockPos previous){
		if(current == null){
			return connections.length == 0 ? pos : connections[0].getDestination();
		}
		switch(connections.length){
			case 0: { return pos; }
			case 1: {
				return connections[0].equalsDestOrFirst(previous) ? pos : connections[0].getFirstTowardsDest();
			}
			case 2: {
				return connections[0].equalsDestOrFirst(previous) ? connections[1].getFirstTowardsDest() : connections[0].getFirstTowardsDest();
			}
			case 3: {
				if(connections[0].equalsDestOrFirst(previous)){
					return world.isBlockPowered(pos) ? connections[2].getFirstTowardsDest() : connections[1].getFirstTowardsDest();
				}
				else{
					return connections[0].getFirstTowardsDest();
				}
			}
			case 4: {
				if(connections[1].equalsDestOrFirst(previous)){
					return connections[0].getFirstTowardsDest();
				}
				if(connections[0].equalsDestOrFirst(previous)){
					return connections[1].getFirstTowardsDest();
				}
				if(connections[3].equalsDestOrFirst(previous)){
					return connections[2].getFirstTowardsDest();
				}
				if(connections[2].equalsDestOrFirst(previous)){
					return connections[3].getFirstTowardsDest();
				}
				break;
			}
			default: return pos;
		}
		return pos;
	}

	
}