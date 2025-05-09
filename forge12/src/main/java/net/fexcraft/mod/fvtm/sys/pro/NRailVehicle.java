package net.fexcraft.mod.fvtm.sys.pro;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity.TRO;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class NRailVehicle extends RootVehicle {

	public Track current;
	public Track last;
	public double passed;
	public RailSystem sys;
	private double frbogiedis;
	private double rrbogiedis;

	public NRailVehicle(World world){
		super(world);
		sys = SystemManager.get(SystemManager.Systems.RAIL, WrapperHolder.getWorld(world));
		preventEntitySpawning = true;
		ignoreFrustumCheck = true;
		setSize(0.5f, 0.5f);
		if(world.isRemote){
			setRenderDistanceWeight(1D);
		}
	}

	public NRailVehicle(World world, RailEntity ent){
		this(world);
		setPosition(ent.pos.x, ent.pos.y, ent.pos.z);
		ent.vehicle.entity = vehicle.entity;
		vehicle = ent.vehicle;
		vehicle.iref().update();
		ent.alignEntity(true);
		init(null);
	}

	@Override
	protected void init(TagCW com){
		super.init(com);
	}

	@Override
	public void writeSpawnData(TagCW com){
		com.set("fr_bogie", vehicle.railent.frbogiedis);
		com.set("rr_bogie", vehicle.railent.rrbogiedis);
		com.set("Track", vehicle.railent.current.write(null));
		com.set("RID", vehicle.railent.uid);
	}

	@Override
	public void readSpawnData(TagCW com){
		if(com.has("RID")){
			sys.getEntity(com.getLong("RID"), true).setveh(vehicle);
			current = new Track(null).read(com.getCompound("Track"));
			frbogiedis = com.getDouble("fr_bogie");
			rrbogiedis = com.getDouble("rr_bogie");
		}
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		super.writeEntityToNBT(compound);
		compound.setLong("RailEntity", vehicle.railent.uid);
		super.writeEntityToNBT(compound);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		super.readEntityFromNBT(compound);
		setDead();
	}

	public V3D moveOnly(double passed){
		TRO tro = getTrack(current, passed);
		return tro.track == null ? null : tro.track.getVectorPosition(tro.passed, false);
	}

	private TRO getTrack(Track track, double passed){
		if(track == null) return new TRO(track, passed);
		while(passed > track.length){
			Junction junc = sys.getJunction(track.end.pos);
			if(junc == null) return new TRO(track, track.length);
			Track newtrack = junc.getNext(null, track.getOppositeId(), false);
			if(newtrack != null){
				passed -= track.length;
				track = newtrack;
			}
			else return new TRO(track, track.length);
		}
		while(passed < 0){
			Junction junc = sys.getJunction(track.start.pos);
			if(junc == null) return new TRO(track, 0);
			Track newtrack = junc.getNext(null, track.getId(), false);
			if(newtrack != null){
				passed += newtrack.length;
				track = newtrack.createOppositeCopy();
			}
			else return new TRO(track, 0);
		}
		return new TRO(track, passed);
	}

	@Override
	public void onUpdate(){
		super.onUpdate();
	}

	public void updBogieRot(){
		if(current == null) return;
		V3D bf0 = moveOnly(passed + 0.1f), bf1 = moveOnly(passed - 0.1f);
		V3D br0 = moveOnly(passed - frbogiedis - rrbogiedis + 0.1f);
		V3D br1 = moveOnly(passed - frbogiedis - rrbogiedis - 0.1f);
		if(bf0 != null && br0 != null && bf1 != null && br1 != null){
			float front = (float)(Math.toDegrees(Math.atan2(bf0.z - bf1.z, bf0.x - bf1.x)) - vehicle.point.getPivot().deg_yaw());
			float rear  = (float)(Math.toDegrees(Math.atan2(br0.z - br1.z, br0.x - br1.x)) - vehicle.point.getPivot().deg_yaw());
			vehicle.data.getAttribute("bogie_front_angle").set(front);
			vehicle.data.getAttribute("bogie_rear_angle").set(rear);
		}
	}

	@Override
	public void onPacket(EntityW player, TagCW packet){
		if(!packet.has("sub")) return;
		switch(packet.getString("sub")){
			case "passed":{
				passed = packet.getDouble("passed");
				break;
			}
			case "track":{
				current = new Track(null).read(packet);
				break;
			}
		}
	}

}
