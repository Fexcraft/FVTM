package net.fexcraft.mod.fvtm.entities.rail;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.rail.RailUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GenericWagonEntity extends RailboundVehicleEntity {

	public GenericWagonEntity(World world){
		super(world);
	}

	public GenericWagonEntity(World world, BlockPos pos, EntityPlayer player, VehicleData data){
		super(world, pos, player, data);
	}
	
	private boolean fr;

	@Override
	public void onUpdateMovement(double amount, boolean call, Boolean frontdir){
        if((amount > 0.001 || amount < -0.001)){
        	/*amount = Math.abs(amount);*/ move(amount, false, null);
        }
        /*if(call){
        	if(vehicledata.getVehicle().isTrailerOrWagon()){
        		if(frontdir && rear != null && rear.getVehicleData().getVehicle().isTrailerOrWagon()){
        			fr = rear.front != null && rear.front.equals(this);
        			double dob = Math.abs(vehicledata.getRearConnectorPos().to16FloatX()) + Math.abs(fr ? rear.vehicledata.getFrontConnectorPos().to16FloatX() : rear.vehicledata.getRearConnectorPos().to16FloatX());
        			((GenericWagonEntity)rear).setPos(locreverse, new double[]{ posX, posY, posZ }, locreverse ? lastpos : currentpos, locreverse ? currentpos : lastpos, locreverse ? dob : -dob, true, fr);
        		}
        		else if(!frontdir && front != null && rear.getVehicleData().getVehicle().isTrailerOrWagon()){
        			fr = front.front != null && front.front.equals(this);
        			double dob = Math.abs(vehicledata.getFrontConnectorPos().to16FloatX()) + Math.abs(fr ? front.vehicledata.getFrontConnectorPos().to16FloatX() : front.vehicledata.getRearConnectorPos().to16FloatX());
        			((GenericWagonEntity)front).setPos(reverse, new double[]{ posX, posY, posZ }, reverse ? lastpos : currentpos, reverse ? currentpos : lastpos, reverse ? -dob : dob, true, fr);
        		}
        		else return;
        	}
        	else{
        		if(rear != null && rear.getVehicleData().getVehicle().isTrailerOrWagon()){
        			fr = rear.front != null && rear.front.equals(this);
        			double dob = Math.abs(vehicledata.getRearConnectorPos().to16FloatX()) + Math.abs(fr ? rear.vehicledata.getFrontConnectorPos().to16FloatX() : rear.vehicledata.getRearConnectorPos().to16FloatX());
        			((GenericWagonEntity)rear).setPos(reverse, new double[]{ posX, posY, posZ }, reverse ? lastpos : currentpos, reverse ? currentpos : lastpos, reverse ? dob : -dob, true, fr);
        		}
        		else if(front != null && front.getVehicleData().getVehicle().isTrailerOrWagon()){
        			fr = front.front != null && front.front.equals(this);
        			double dob = Math.abs(vehicledata.getFrontConnectorPos().to16FloatX()) + Math.abs(fr ? front.vehicledata.getFrontConnectorPos().to16FloatX() : front.vehicledata.getRearConnectorPos().to16FloatX());
        			((GenericWagonEntity)front).setPos(reverse, new double[]{ posX, posY, posZ }, reverse ? lastpos : currentpos, reverse ? currentpos : lastpos, reverse ? -dob : dob, true, fr);
        		}
        		else return;
        	}
        }*/
        if(!call) return;
        Vec3d own, oth;
        if(this.vehicledata.getVehicle().isTrailerOrWagon()){
        	
        }
        else{
        	if(rear != null /*&& rear.getVehicleData().getVehicle().isTrailerOrWagon()*/){
        		fr = rear.front != null && rear.front.equals(this);
        		own = axes.getRelativeVector(vehicledata.getRearConnectorPos().to16Double());
        		oth = rear.getAxes().getRelativeVector((fr ? rear.getVehicleData().getFrontConnectorPos() : rear.getVehicleData().getRearConnectorPos()).to16Double());
        		double dob = this.getPositionVector().add(own).distanceTo(rear.getPositionVector().add(oth));
        		if(dob < this.getPositionVector().distanceTo(own)) return;
        		((GenericWagonEntity)rear).move(dob, true, fr);
        	}
        	if(front != null /*&& front.getVehicleData().getVehicle().isTrailerOrWagon()*/){
        		fr = front.front != null && front.front.equals(this);
        		own = axes.getRelativeVector(vehicledata.getFrontConnectorPos().to16Double());
        		oth = front.getAxes().getRelativeVector((fr ? front.getVehicleData().getFrontConnectorPos() : front.getVehicleData().getRearConnectorPos()).to16Double());
        		double dob = this.getPositionVector().add(own).distanceTo(rear.getPositionVector().add(oth));
        		if(dob < this.getPositionVector().distanceTo(own)) return;
        		((GenericWagonEntity)front).move(dob, true, fr);
        	}
        }
	}
	
	protected void move(double amount, boolean up, Boolean bool){
		if(amount < 0.001 && amount > -0.001) return;
		RailUtil.Return ret = RailUtil.getExpectedPosition(world, new double[]{ posX, posY, posZ }, reverse ? lastpos : currentpos, reverse ? currentpos : lastpos, amount);
		//if(this.vehicledata.getVehicle().isTrailerOrWagon()) Print.debug(amount + " =|= " + this, posX + " =?= " + ret.dest[0], posY + " =?= " + ret.dest[1], posZ + " =?= " + ret.dest[2]);
    	this.posX = ret.dest[0]; this.posY = ret.dest[1]; this.posZ = ret.dest[2];
    	this.prevPosX = this.posX; this.prevPosY = this.posY; this.prevPosZ = this.posZ;
    	this.currentpos = reverse ? ret.last : ret.curr; this.lastpos = reverse ? ret.curr : ret.last;
    	if(up && bool != null) this.onUpdateMovement(0f, true, bool);
	}
	
}