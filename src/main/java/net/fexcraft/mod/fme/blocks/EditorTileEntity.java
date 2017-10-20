package net.fexcraft.mod.fme.blocks;

import java.io.File;

import net.fexcraft.mod.fme.util.TempModel;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.lang.ArrayList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class EditorTileEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {

	public VehicleData vehicledata;
	public TempModel model;
	
	public EditorTileEntity(){
		model = new TempModel(new File(new File("."), "/models/unnamed.fme"));
		//temp
		model.groups.put("body", new ArrayList<ModelRendererTurbo>(new ModelRendererTurbo[]{ new ModelRendererTurbo(model)}));
	}
	
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
		vehicledata = Resources.getVehicleData(compound, world == null ? true : world.isRemote);
	}

	public TempModel getModel(){
		return model;
	}
	
}
