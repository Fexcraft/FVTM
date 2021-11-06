package net.fexcraft.mod.fvtm.sys.uni;

import java.util.ArrayList;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.fexcraft.mod.fvtm.sys.particle.ParticleEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.function.ParticleEmitterFunction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EntitySystem extends DetachedSystem {
	
	public Thread thread;
	public static final int TARGET_TICKS = 20;
	public static final float RATE = 1f / (TARGET_TICKS + 1);
	private ArrayList<Emitter> emitters = new ArrayList<>();
	private TTimer timer = new TTimer();
	private boolean run = true;
	private float accumulator, delta;
	//
	public ArrayList<ParticleEntity> particles = new ArrayList<>();
	public ArrayList<ParticleEntity> expired = new ArrayList<>();

	public EntitySystem(World world){
		super(world);
	}

	@Override
	public boolean hasTimer(){
		return false;
	}

	@Override
	public void setupTimer(long time){
		thread = new Thread(() -> {
			System.out.println("Starting Entity Logic Thread.");
			timer.init();
			while(run){
				accumulator += (delta = timer.getDelta());
				while(accumulator >= RATE){
					try{
						update();
					}
					catch(Throwable thr){
						thr.printStackTrace();
					}
					timer.updateUPS();
					accumulator -= RATE;
				}
				timer.update();
			}
		});
		thread.setName("FVTM-EL-DIM" + dimension);
		thread.start();
	}

	private void update(){
		for(ParticleEntity part : particles){
			part.update();
		}
		particles.removeIf(part -> {
			if(part.expired()){
				if(part.particle.next != null) expired.add(part);
				return true;
			}
			return false;
		});
		if(expired.size() > 0){
			for(ParticleEntity part : expired){
				Particle particle = Resources.PARTICLES.get(part.particle.next);
				if(particle != null) particles.add(new ParticleEntity(particle, new Vec3f(part.pos)));
			}
			expired.clear();
		}
		emitters.removeIf(emi -> emi.invalid(particles));
	}

	@Override
	public void stopTimer(){
		System.out.println("Stopping Entity Logic Thread.");
		run = false;
	}

	@Override
	public void unload(){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChunkLoad(Chunk chunk){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChunkUnload(Chunk chunk){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerTick(){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClientTick(){
		//
	}

	public void add(GenericVehicle vehicle){
		for(Entry<String, PartData> entry : vehicle.getVehicleData().getParts().entrySet()){
			if(!entry.getValue().hasFunction("fvtm:particle_emitter")) continue;
			ParticleEmitterFunction func = entry.getValue().getFunction("fvtm:particle_emitter");
			emitters.add(new Emitter(vehicle, entry.getKey(), entry.getValue(), func));
		}
	}
	
	public static class Emitter {
		
		private GenericVehicle vehicle;
		private ParticleEmitterFunction func;
		private PartData data;
		private String part;
		//
		private Vec3d off;
		private Vec3f dir;
		private int freq, cool;
		private float speed;

		public Emitter(GenericVehicle vehicle, String key, PartData data, ParticleEmitterFunction func){
			this.vehicle = vehicle;
			this.part = key;
			this.data = data;
			this.func = func;
			off = data.getInstalledPos().add(func.getOffset()).to16Double();
			freq = func.getFrequency() == 0 ? func.getParticle().frequency : func.getFrequency();
			dir = func.getDirection() == null ? func.getParticle().dir : func.getDirection();
			speed = func.getSpeed() == null ? func.getParticle().speed : func.getSpeed();
		}

		public boolean invalid(ArrayList<ParticleEntity> particles){
			if(func.getConditional() == null || func.getConditional().isMet(vehicle, null, vehicle.getVehicleData(), null, null, data, part, null, null)){
				cool++;
				if(cool >= freq){
					SwivelPoint point = vehicle.getVehicleData().getRotationPoint(data.getSwivelPointInstalledOn());
					Vec3d pos = point.getRelativeVector(off).add(vehicle.getPositionVector());
					particles.add(new ParticleEntity(func.getParticle(), new Vec3f(pos.x, pos.y, pos.z)));
					cool = 0;
				}
			}
			return vehicle.isDead;
		}
		
	}

}
