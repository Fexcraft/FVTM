package net.fexcraft.mod.fvtm.compatibility.trainsmod;

import alemax.trainsmod.entities.EntityRailcar;
import alemax.trainsmod.util.Seat;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.compatibility.FMSeat;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** alemax.trainsmod.TrainsMod || ID:trainsmod */
public class TrainsModEntityConverter extends EntityRailcar implements IPacketReceiver<PacketEntityUpdate> {
	
	public VehicleData data;

	public TrainsModEntityConverter(World world){
		super(world); this.setup(); Print.debug(this, world.isRemote);
	}


	public TrainsModEntityConverter(World world, BlockPos pos, VehicleData data){
		super(world, pos); this.data = data; this.setup(); Print.debug(this, world.isRemote);
	}

	@Override
	public void setup(){
		setBoundBox(new AxisAlignedBB(-1.5625005960464478, 0.0, -8.53125, 1.5625003576278687, 3.125000238418579, 1.46875));
		if(data == null) return;
		this.maxSpeed = data.getVehicle().getFMAttribute("max_positive_throttle") * 50;
		this.maxPassengersCount = data.getSeats().size();
		this.seats = new Seat[maxPassengersCount];
		if(this.maxPassengersCount > 0){
			for(int i = 0; i < data.getSeats().size(); i++){
				FMSeat seat = data.getSeats().get(i);
				this.seats[0] = new Seat(seat.getPos().to16FloatX(), seat.getPos().to16FloatY(), seat.getPos().to16FloatZ(), 0, seat.isDriver());
			}
		}
		this.axleDistance = 7.125;
		if(!data.getVehicle().isTrailerOrWagon()){
			this.maxAcceleration = data.getVehicle().getFMAttribute("max_positive_throttle");
			this.maxDecceleration = data.getVehicle().getFMAttribute("max_negative_throttle");//yes, I know it's the wrong value
		}
	}
	
	@Override
	public void processClientPacket(PacketEntityUpdate pkt){
		Print.console(pkt.nbt); this.readFromNBT(pkt.nbt);
	}
	
	@Override
	public void processServerPacket(PacketEntityUpdate pkt){
		if(pkt.nbt.hasKey("sync") && pkt.nbt.getBoolean("sync")){
			PacketHandler.getInstance().sendToAll(new PacketEntityUpdate(this, this.writeToNBT(new NBTTagCompound())));
		}
	}
	
	@Override
	public void onUpdate(){
		if(data == null){
			if(!world.isRemote) return;
			NBTTagCompound nbt = new NBTTagCompound(); nbt.setBoolean("sync", true);
			PacketHandler.getInstance().sendToServer(new PacketEntityUpdate(this, nbt));
			return;
		}
		super.onUpdate();
	}
	
	@Override public void setDead(){ super.setDead(); }

    /*if(entity.getContainerData() != null){
    	GL11.glRotated(180, 1, 0, 0); GL11.glRotated(90, 0, 1, 0);
    	this.bindTexture(entity.getContainerData().getTexture()); GL11.glTranslatef(0, -1, 0);
    	entity.getContainerData().getContainer().getModel().render(entity.getContainerData(), null);
    }*/
	
	/*@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeEntityToNBT(compound); if(data != null) data.writeToNBT(compound); return compound;
	}
		
	@Override
	public void readFromNBT(NBTTagCompound compound){
		data = Resources.getVehicleData(compound);
		super.readEntityFromNBT(compound);
	}*/
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		Print.console("WRITING   ----");
		super.writeEntityToNBT(compound); if(data != null) data.writeToNBT(compound);
		Print.console("WRITING   ->>-");
	}
		
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		Print.console("READING   ----");
		super.readEntityFromNBT(compound); data = Resources.getVehicleData(compound); setup();
		Print.console(data);
		Print.console("READING   -<<-");
	}
	
}
