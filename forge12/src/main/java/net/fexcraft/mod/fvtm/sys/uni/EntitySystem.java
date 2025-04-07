package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.entity.ParticleEntity;
import net.fexcraft.mod.fvtm.function.part.ParticleEmitterFunction;
import net.fexcraft.mod.fvtm.function.part.ParticleEmitterFunction.EmitterData;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.client.Minecraft;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;

import static net.fexcraft.mod.fvtm.Config.DISABLE_PARTICLES;

public class EntitySystem extends DetachedSystem {
	
	public Thread thread;
	public static final int TARGET_TICKS = 20;
	public static final float RATE = 1f / (TARGET_TICKS + 1);
	private ConcurrentLinkedQueue<Emitter> emitters = new ConcurrentLinkedQueue<>();
	//private TTimer timer = new TTimer();
	//private boolean run = true;
	//private float accumulator, delta;
	//
	public ConcurrentLinkedQueue<ParticleEntity> particles = new ConcurrentLinkedQueue<>();
	public ConcurrentLinkedQueue<ParticleEntity> expired = new ConcurrentLinkedQueue<>();

	public EntitySystem(WorldW world){
		super(world);
	}

	@Override
	public SystemManager.Systems getType(){
		return SystemManager.Systems.ENTITY;
	}

	@Override
	public boolean hasTimer(){
		return false;
	}

	@Override
	public String getRegFolderName(){
		return "entities";
	}

	@Override
	public void setupTimer(long time){
		/*if(Config.DISABLE_PARTICLES) return;
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
		thread.start();*/
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
				Particle particle = FvtmRegistry.PARTICLES.get(part.particle.next);
				if(particle != null) particles.add(new ParticleEntity(particle, new V3D(part.pos), null, null));
			}
			expired.clear();
		}
		int mul = Minecraft.getMinecraft().gameSettings.particleSetting == 0 ? 1 : Minecraft.getMinecraft().gameSettings.particleSetting == 1 ? 2 : 4;
		emitters.removeIf(emi -> emi.invalid(particles, mul));
	}

	@Override
	public void stopTimer(){
		//System.out.println("Stopping Entity Logic Thread.");
		//run = false;
	}

	@Override
	public void unload(){
		emitters.clear();
		particles.clear();
	}

	@Override
	public void onChunkLoad(ChunkW chunk){
		//
	}

	@Override
	public void onChunkUnload(ChunkW chunk){
		//
	}

	@Override
	public void onServerTick(){
		//
	}

	@Override
	public void onClientTick(){
		update();
	}

	@Override
	public SysObj create(SystemRegion region, V3I pos){
		return null;
	}

	public void add(RootVehicle vehicle){
		if(DISABLE_PARTICLES) return;
		for(Entry<String, PartData> entry : vehicle.vehicle.data.getParts().entrySet()){
			if(!entry.getValue().hasFunction("fvtm:particle_emitter")) continue;
			ParticleEmitterFunction func = entry.getValue().getFunction("fvtm:particle_emitter");
			for(EmitterData data : func.emitters){
				emitters.add(new Emitter(vehicle, entry.getKey(), entry.getValue(), data));
			}
		}
	}
	
	public static class Emitter {
		
		private RootVehicle vehicle;
		private EmitterData edata;
		private PartData data;
		private String part;
		//
		private V3D off;
		private V3D dir;
		private int freq, cool;
		private double speed;

		public Emitter(RootVehicle vehicle, String key, PartData data, EmitterData edata){
			this.vehicle = vehicle;
			this.part = key;
			this.data = data;
			this.edata = edata;
			//TODO off = data.getInstalledPos().add(edata.pos).toV3D();
			freq = edata.frequency == 0 ? edata.particle.frequency : edata.frequency;
			dir = edata.dir == null ? edata.particle.dir : edata.dir;
			speed = edata.speed == null ? edata.particle.speed : edata.speed;
		}

		public boolean invalid(Collection<ParticleEntity> particles, int mul){
			if(edata.getConditional() == null || edata.getConditional().isMet(DefaultModel.RENDERDATA.set(vehicle.vehicle, data, part, 0))){
				cool++;
				if(cool >= freq * mul){
					SwivelPoint point = vehicle.vehicle.data.getRotationPoint(data.getSwivelPointInstalledOn());
					V3D pos = point.getRelativeVector(off).add(vehicle.posX, vehicle.posY, vehicle.posZ);
					V3D vdr = point.getRelativeVector(dir.x, dir.y, dir.z);
					particles.add(new ParticleEntity(edata.particle, new V3D(pos.x, pos.y, pos.z), new V3D(vdr.x, vdr.y, vdr.z), speed));
					cool = 0;
				}
			}
			return vehicle.isDead;
		}
		
	}

}
