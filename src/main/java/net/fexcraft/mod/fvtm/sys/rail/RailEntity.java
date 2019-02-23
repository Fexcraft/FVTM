package net.fexcraft.mod.fvtm.sys.rail;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.entities.rail.GenericLocomotiveEntity;
import net.fexcraft.mod.fvtm.entities.rail.GenericWagonEntity;
import net.fexcraft.mod.fvtm.entities.rail.RailboundVehicleEntity;
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
		Print.debug("created"); this.active = true;
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
		//TODO move & stuff
		//
		if(this.active) region.updateAccess(null);
		this.updateSection();
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
	
}