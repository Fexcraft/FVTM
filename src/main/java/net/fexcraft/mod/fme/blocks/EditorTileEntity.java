package net.fexcraft.mod.fme.blocks;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class EditorTileEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {

	public VehicleData vehicledata;
	
	
	@Override
	public void processClientPacket(PacketTileEntityUpdate pkt){
		if(pkt.nbt.hasKey("novehicle") && pkt.nbt.getBoolean("novehicle")){
			this.vehicledata = null;
		}
		if(pkt.nbt.hasKey("vehicledata")){
			this.vehicledata = Resources.getVehicleData(pkt.nbt.getCompoundTag("vehicledata"), world.isRemote);
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
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
    }

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		if(vehicledata != null){
			compound = vehicledata.writeToNBT(compound);
		}
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		vehicledata = Resources.getVehicleData(compound, world.isRemote);
	}
	
}
