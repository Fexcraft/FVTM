package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.Collection;

import net.fexcraft.lib.common.math.Vec3f;
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
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

/** @author Ferdinand Calo' (FEX___96) **/
public class RailEntity {
	
	public double ppx, ppy, ppz, accumulator;
	public double px, py, pz, passed;
	public Track last, current;
	private RailRegion region;
	private boolean active;
	public boolean reverse;
	private double throttle;
	//
	public long uniqueid, front_id, rear_id;
	public VehicleData vehdata;
	private PointOnTrack[] points;
	//private LineSection section_on;
	public RailEntity front, rear;
	private RailboundVehicleEntity entity;
	
	public RailEntity(Track curr, Track last, RailRegion region, VehicleData data){
		current = curr; this.last = last; this.region = region; this.vehdata = data;
		this.ppx = px = curr.getFirstVector().xCoord;
		this.ppy = py = curr.getFirstVector().yCoord;
		this.ppz = pz = curr.getFirstVector().zCoord;
		this.region.addEntity(this); this.initPoints();
		this.uniqueid = region.getUtil().grabNewRailEntityId();
		Print.debug("created"); //this.active = true;
	}
	
	private void initPoints(){
		points = new PointOnTrack[4];
		points[0] = new PointOnTrack(this, PointOnTrack.Type.COUPLER_FRONT);
		points[1] = new PointOnTrack(this, PointOnTrack.Type.COUPLER_REAR);
		points[2] = new PointOnTrack(this, PointOnTrack.Type.BOGIE_FRONT);
		points[3] = new PointOnTrack(this, PointOnTrack.Type.BOGIE_REAR);
	}

	public RailEntity(NBTTagCompound compound, RailRegion region){
		this.read(compound); (this.region = region).addEntity(this); this.initPoints();
	}

	public RailEntity read(NBTTagCompound compound){
		this.vehdata = Resources.getVehicleData(compound);
		this.ppx = compound.getDouble("PrevPosX");
		this.ppy = compound.getDouble("PrevPosY");
		this.ppz = compound.getDouble("PrevPosZ");
		this.px = compound.getDouble("PosX");
		this.py = compound.getDouble("PosY");
		this.pz = compound.getDouble("PosZ");
		this.active = compound.getBoolean("Active");
		this.reverse = compound.getBoolean("Reverse");
		this.throttle = compound.getDouble("Throttle");
		//
		this.uniqueid = compound.getLong("UniqueID");
		this.last = new Track().read(compound.getCompoundTag("LastTrack"));
		this.current = new Track().read(compound.getCompoundTag("CurrentTrack"));
		return this;
	}

	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		vehdata.writeToNBT(compound);
		compound.setLong("UniqueID", uniqueid);
		compound.setDouble("PrevPosX", ppx);
		compound.setDouble("PrevPosY", ppy);
		compound.setDouble("PrevPosZ", ppz);
		compound.setDouble("PosX", px);
		compound.setDouble("PosY", py);
		compound.setDouble("PosZ", pz);
		compound.setBoolean("Active", active);
		compound.setBoolean("Reverse", reverse);
		compound.setDouble("Throttle", throttle);
		compound.setTag("LastTrack", last.write(null));
		compound.setTag("CurrentTrack", current.write(null));
		return compound;
	}
	
	public void update(){
		if(this.isInRangeOfPlayers()){
			if(this.shouldSpawnEntity()){
				Print.debug("Entity in View, spawning."); this.spawnEntity();
			}
		}
		else{
			if(this.shouldRemoveEntity()){
				Print.debug("Entity out of View, de-spawning.");  this.removeEntity();
			}
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
		//
		for(PointOnTrack point : points){ point.update(); }
		//
		if(this.active) region.updateAccess(null);
		this.updateSection();
	}

	private void requestMove(double amount, boolean call, Boolean conn){
        if((amount > 0.001 || amount < -0.001)){
        	MoveUtil.ObjCon<Double, Boolean, Object> con = MoveUtil.moveEntity(this, amount, reverse);
        	if(entity != null){ accumulator += con.fir; } reverse = con.sec;
        } if(!call) return;
        //TODO connected
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
		/*this.entity.railent = null;*/ this.entity = null;
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
		if(throttle < 0) throttle = 0; if(throttle > 1f) throttle = 1f;
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
			region.addEntity(this); region.updateAccess(null);
			Print.debug("Switched RailRegion! " + oldregion.getX() + ", " + oldregion.getZ() + " >>> " + region.getX() + ", " + region.getZ() + ";");
		}
	}

	public void removeSelf(){
		this.throttle = 0; this.region.removeEntity(this);
		Print.debug("Removing RAILENT: " + vehdata.getVehicle().getName() + " || AT: " + px + ", " + py + ", " + pz + ";");
	}

	public RailboundVehicleEntity getEntity(){
		return entity;
	}

	public void tryAttach(ICommandSender sender, boolean frontcall){
		AxisAlignedBB aabb = this.getAABB(frontcall);
		Print.debug(points[frontcall ? 0 : 1].position);
		Collection<PointOnTrack> paints = getFreeCouplersInRange(this, 4);
		for(PointOnTrack point : paints){
			if(point.entity == this) continue;
			Print.debug(point, point.position, point.getAABB().intersects(aabb));
			if(point.getAABB().intersects(aabb)){
				Print.debug(point.getAABB());
				boolean front = !point.pointtype.opposite;
				if(front ? point.entity.front != null : point.entity.rear != null){
					Print.chat(sender, "Found Coupler but occupied, continuing search.");
				}
				else{
					this.applyCoupling(sender, frontcall, point.entity, front);
					Print.chat(sender, "Coupling Complete."); return;
				}
			} else continue;
		}
		Print.chat(sender, "No (free) Coupler in Range found.");
	}

	private void applyCoupling(ICommandSender sender, boolean front0, RailEntity entity, boolean front1){
		if(front0){ front = entity; front_id = entity.uniqueid; } else{ rear = entity; rear_id = entity.uniqueid; }
		if(front1){ entity.front = this; entity.front_id = uniqueid; } else{ entity.rear = this; entity.rear_id = uniqueid; }
	}

	private static Collection<PointOnTrack> getFreeCouplersInRange(RailEntity railent, int range){
		ArrayList<PointOnTrack> array = new ArrayList<PointOnTrack>();
		if(range > 256) range =  256; if(range < 1) range = 1; double x = railent.px, y = railent.py, z = railent.pz;
		RailRegion[] regs = railent.region.getBorderingIncluding(railent.px, railent.pz);
		for(RailRegion region : regs){
			for(RailEntity ent : region.getEntities()){
				for(PointOnTrack point : ent.points){
					if(!point.pointtype.isCoupler()) continue;
					boolean xx = point.position.xCoord >= (x - range) && point.position.xCoord <= (x + range);
					boolean yy = point.position.yCoord >= (y - range) && point.position.yCoord <= (y + range);
					boolean zz = point.position.zCoord >= (z - range) && point.position.zCoord <= (z + range);
					Print.debug("search", point.position, point.pointtype, xx + ", " + yy + ", " + zz);
					if(xx && yy && zz) array.add(point);
				}
			}
		} return array;
	}

	public void tryDetach(ICommandSender sender, boolean frontcall){
		if(frontcall && front != null){
			if(front.rear != null && front.rear.uniqueid == this.uniqueid){
				front.rear = null; front = null;
			}
			if(front.front != null && front.front.uniqueid == this.uniqueid){
				front.front = null; front = null;
			}
			front = null; front_id = -1;
		}
		else{
			if(rear.rear != null && rear.rear.uniqueid == this.uniqueid){
				rear.rear = null; rear = null;
			}
			if(rear.front != null && rear.front.uniqueid == this.uniqueid){
				rear.front = null; rear = null;
			}
			rear = null; rear_id = -1;
		}
	}
	
	public AxisAlignedBB getAABB(boolean front){
		return points[front ? 0 : 1].getAABB();
	}

	public Vec3f getPointPosition(int i){
		return points[i].position;
	}
	
}