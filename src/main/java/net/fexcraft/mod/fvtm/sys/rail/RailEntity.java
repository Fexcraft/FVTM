package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute.EngineAttributeData;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.entities.rail.GenericLocomotiveEntity;
import net.fexcraft.mod.fvtm.entities.rail.GenericWagonEntity;
import net.fexcraft.mod.fvtm.entities.rail.RailboundVehicleEntity;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailImpl;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;

/** @author Ferdinand Calo' (FEX___96) **/
public class RailEntity {
	
	public double ppx, ppy, ppz;
	public double px, py, pz, passed;
	public Track last, current;
	private RailRegion region;
	private boolean active;
	public boolean reverse;
	private double throttle;
	//
	public VehicleData vehdata;
	private PointOnTrack[] points;
	//private LineSection section_on;
	private RailboundVehicleEntity entity;
	
	public RailEntity(Track curr, Track last, RailRegion region, VehicleData data){
		current = curr; this.last = last; this.region = region; this.vehdata = data;
		this.ppx = px = curr.getFirstVector().xCoord;
		this.ppy = py = curr.getFirstVector().yCoord;
		this.ppz = pz = curr.getFirstVector().zCoord;
		points = new PointOnTrack[4];
		points[0] = new PointOnTrack(this, PointOnTrack.Type.COUPLER_FRONT);
		points[1] = new PointOnTrack(this, PointOnTrack.Type.COUPLER_REAR);
		points[2] = new PointOnTrack(this, PointOnTrack.Type.BOGIE_FRONT);
		points[3] = new PointOnTrack(this, PointOnTrack.Type.BOGIE_REAR);
		this.region.addEntity(this);
		Print.debug("created"); //this.active = true;
	}
	
	public RailEntity(NBTTagCompound compound){
		this.read(compound);
	}

	public void read(NBTTagCompound compound){
		// TODO Auto-generated method stub
		
	}
	
	public void update(){
		if(this.isInRangeOfPlayers()){
			if(this.shouldSpawnEntity()){ this.spawnEntity(); }
		}
		else{
			if(this.shouldRemoveEntity()){ this.removeEntity(); }
		}
		//
		if(!this.isWagon()){
	        boolean borderless = !Config.VEHICLE_NEEDS_FUEL || (entity != null && entity.isDriverInCreativeMode());
	        boolean consumed = false; Part.PartData enginepart = vehdata.getPart("engine");
	        active = enginepart.getAttributeData(EngineAttributeData.class).isOn();
	        if(!borderless && enginepart != null && active && vehdata.getFuelTankContent() > enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle){
	            double d = (enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() * throttle) / 80;//20, set lower to prevent too fast compsumption.
	            consumed = vehdata.consumeFuel(d > 0 ? d : (enginepart.getPart().getAttribute(EngineAttribute.class).getFuelCompsumption() / 320));
	        }
	        double amount = 0d;
	        if(enginepart != null && (borderless || consumed)){//TODO multi-engine support
	        	amount = /*0.2f **/ throttle * (throttle > 0 ? vehdata.getVehicle().getFMAttribute("max_positive_throttle") : vehdata.getVehicle().getFMAttribute("max_negative_throttle"));
	        	amount *= enginepart.getPart().getAttribute(EngineAttribute.class).getEngineSpeed();
	        }
	        this.requestMove(amount, false, null); //Print.debug("amount:move: " + amount);
		}
		//TODO move & stuff
		//
		if(this.active) region.updateAccess(null);
		this.updateSection();
	}

	private void requestMove(double amount, boolean call, Boolean conn){
        if((amount > 0.001 || amount < -0.001)){
        	amount = MoveUtil.moveEntity(this, amount);
        }
        if(!call){
        	//TODO connected
        }
	}

	private void updateSection(){
		for(PointOnTrack track : points){
			track.updateSection();
		}
	}

	private boolean isInRangeOfPlayers(){
		Vec3d vector = new Vec3d(px, py, pz);
		for(EntityPlayer player : Static.getServer().getPlayerList().getPlayers()){
			if(vector.distanceTo(player.getPositionVector()) < 128/*256*/) return true;
		} return false;
	}

	public void write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		
	}
	
	public boolean shouldSpawnEntity(){
		if(entity != null && !entity.isDead) return false; //Print.debug("Question call!");
		/*//TODO*/ return entity == null;
	}
	
	public boolean shouldRemoveEntity(){
		if(entity != null && entity.isDead) return false;
		/*//TODO*/ return entity != null;
	}
	
	public void spawnEntity(){
		region.getUtil().getWorld().spawnEntity(entity = vehdata.getVehicle().isTrailerOrWagon()
			? new GenericWagonEntity(region.getUtil().getWorld(), this)
			: new GenericLocomotiveEntity(region.getUtil().getWorld(), this));
	}
	
	public void removeEntity(){
		if(this.entity != null) entity.setDead();
		this.entity.railent = null; this.entity = null;
	}

	public void align(RailboundVehicleEntity entity){
		entity.posX = px; entity.posY = py; entity.posZ = pz;
		entity.prevPosX = ppx; entity.prevPosY = ppy; entity.prevPosZ = ppz;
	}
	
	public boolean isWagon(){
		return this.vehdata.getVehicle().isTrailerOrWagon();
	}

	public void modifyThrottle(double by, boolean totalitarian){
		if(totalitarian) this.throttle = by; else this.throttle += by;
		if(throttle < -1f) throttle = -1f; if(throttle > 1f) throttle = 1f;
	}

	public void breakThrottle(){
        throttle *= 0.8F; if(throttle > -0.0001 && throttle < 0.0001) throttle = 0;
	}

	public double getThrottle(){
		return throttle;
	}

	public RailRegion getRegion(){
		return region;
	}

	public void updateRailRegion(){
		int[] id = WorldRailImpl.getRegion(current.start.getX() >> 4, current.start.getZ() >> 4);
		if(region.getX() != id[0] || region.getZ() != id[1]){
			RailRegion oldregion = region; oldregion.removeEntity(this);
			region = oldregion.getUtil().getRegionMap().getRegion(WorldRailImpl.getRegion(current.start));
			region.addEntity(this);
			Print.debug("Switched RailRegion! " + oldregion.getX() + ", " + oldregion.getZ() + " >>> " + region.getX() + ", " + region.getZ() + ";");
		}
	}

	public void removeSelf(){
		this.throttle = 0; this.region.removeEntity(this);
		Print.debug("Removing RAILENT: " + vehdata.getVehicle().getName() + " || AT: " + px + ", " + py + ", " + pz + ";");
	}
	
}