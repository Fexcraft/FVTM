package net.fexcraft.mod.fvtm.sys.uni;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.fexcraft.mod.fvtm.sys.particle.ParticleEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.ParticleEmitterFunction;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EntitySystem extends DetachedSystem {
	
	public Thread thread;
	public static final int TARGET_TICKS = 20;
	public static final float RATE = 1f / (TARGET_TICKS + 1);
	private ConcurrentLinkedQueue<Emitter> emitters = new ConcurrentLinkedQueue<>();
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
		if(Config.DISABLE_PARTICLES) return;
		thread = new Thread(() -> {
			System.out.println("Starting Entity Logic Thread.");
			timer.init();
			while(run){
				accumulator += (delta = timer.getDelta());
				while(accumulator >= RATE){
					try{
						if(!Minecraft.getMinecraft().isGamePaused()){
							update();
						}
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
				if(particle != null) particles.add(new ParticleEntity(particle, new Vec3f(part.pos), null, null));
			}
			expired.clear();
		}
		int mul = Minecraft.getMinecraft().gameSettings.particleSetting == 0 ? 1 : Minecraft.getMinecraft().gameSettings.particleSetting == 1 ? 2 : 4;
		emitters.removeIf(emi -> emi.invalid(particles, mul));
	}

	@Override
	public void stopTimer(){
		System.out.println("Stopping Entity Logic Thread.");
		run = false;
	}

	@Override
	public void unload(){
		emitters.clear();
		particles.clear();
	}

	@Override
	public void onChunkLoad(Chunk chunk){
		//
	}

	@Override
	public void onChunkUnload(Chunk chunk){
		//
	}

	@Override
	public void onServerTick(){
		//
	}

	@Override
	public void onClientTick(){
		//
	}

	public void add(GenericVehicle vehicle){
		if(Config.DISABLE_PARTICLES) return;
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

		public boolean invalid(ArrayList<ParticleEntity> particles, int mul){
			if(func.getConditional() == null || func.getConditional().isMet(vehicle, null, vehicle.getVehicleData(), null, null, data, part, null, null)){
				cool++;
				if(cool >= freq * mul){
					SwivelPoint point = vehicle.getVehicleData().getRotationPoint(data.getSwivelPointInstalledOn());
					Vec3d pos = point.getRelativeVector(off).add(vehicle.getPositionVector());
					Vec3d vdr = point.getRelativeVector(dir.x, dir.y, dir.z);
					particles.add(new ParticleEntity(func.getParticle(), new Vec3f(pos.x, pos.y, pos.z), new Vec3f(vdr.x, vdr.y, vdr.z), speed));
					cool = 0;
				}
			}
			return vehicle.isDead;
		}
		
	}

}
