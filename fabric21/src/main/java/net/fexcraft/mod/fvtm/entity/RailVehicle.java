package net.fexcraft.mod.fvtm.entity;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailVehicle extends RootVehicle {

	public Track current;
	public Track last;
	public double passed;
	public RailSystem sys;
	private double frbogiedis;
	private double rrbogiedis;
	private byte remtimer;

	public RailVehicle(EntityType<?> type, Level world){
		super(type, world);
		sys = SystemManager.get(SystemManager.Systems.RAIL, WrapperHolder.getWorld(world));
	}

	public RailVehicle assign(RailEntity ent){
		setPos(ent.pos.x, ent.pos.y, ent.pos.z);
		ent.vehicle.entity = vehicle.entity;
		vehicle = ent.vehicle;
		vehicle.iref().update();
		ent.alignEntity(true);
		initVD(vehicle.data);
		return this;
	}

	@Override
	protected void init(TagCW com){
		super.init(com);
	}

	@Override
	public void writeSpawnData(TagCW com){
		if(vehicle.railent == null) return;
		com.set("fr_bogie", vehicle.railent.frbogiedis);
		com.set("rr_bogie", vehicle.railent.rrbogiedis);
		com.set("Track", vehicle.railent.current.write(null));
		com.set("RID", vehicle.railent.uid);
	}

	@Override
	public void readSpawnData(TagCW com){
		//railent = sys.getEntity(com.getLong("RID"), true);
		current = new Track(null).read(com.getCompound("Track"));
		frbogiedis = com.getDouble("fr_bogie");
		rrbogiedis = com.getDouble("rr_bogie");
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound){
		super.addAdditionalSaveData(compound);
		if(vehicle.railent != null) compound.putLong("RailEntity", vehicle.railent.uid);
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound){
		super.readAdditionalSaveData(compound);
		remtimer = 40;
	}

	public V3D moveOnly(double passed){
		RailEntity.TRO tro = getTrack(current, passed);
		return tro.track == null ? null : tro.track.getVectorPosition(tro.passed, false);
	}

	private RailEntity.TRO getTrack(Track track, double passed){
		if(track == null) return new RailEntity.TRO(track, passed);
		while(passed > track.length){
			Junction junc = sys.getJunction(track.end.pos);
			if(junc == null) return new RailEntity.TRO(track, track.length);
			Track newtrack = junc.getNext(null, track.getOppositeId(), false);
			if(newtrack != null){
				passed -= track.length;
				track = newtrack;
			}
			else return new RailEntity.TRO(track, track.length);
		}
		while(passed < 0){
			Junction junc = sys.getJunction(track.start.pos);
			if(junc == null) return new RailEntity.TRO(track, 0);
			Track newtrack = junc.getNext(null, track.getId(), false);
			if(newtrack != null){
				passed += newtrack.length;
				track = newtrack.createOppositeCopy();
			}
			else return new RailEntity.TRO(track, 0);

		}
		return new RailEntity.TRO(track, passed);
	}

	@Override
	public void tick(){
		if(remtimer > 0){
			if(remtimer == 1) kill((ServerLevel)level());
			remtimer--;
		}
		if(!level().isClientSide && vehicle.railent == null){
			if(remtimer == 0) remtimer = 40;
			return;
		}
		super.tick();
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
