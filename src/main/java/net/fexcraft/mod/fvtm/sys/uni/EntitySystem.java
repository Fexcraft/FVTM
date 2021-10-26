package net.fexcraft.mod.fvtm.sys.uni;

import java.util.ArrayList;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.sys.particle.Particle;
import net.fexcraft.mod.fvtm.sys.particle.ParticleEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EntitySystem extends DetachedSystem {
	
	public Thread thread;
	public static final int TARGET_TICKS = 20;
	public static final float RATE = 1f / (TARGET_TICKS + 1);
	private ArrayList<Entity> entities = new ArrayList<>();
	private TTimer timer = new TTimer();
	private boolean run = true;
	private float accumulator, delta;
	//
	public ArrayList<ParticleEntity> particles = new ArrayList<>();

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
	
	private int cooldown;

	private void update(){
		for(ParticleEntity part : particles){
			part.update();
		}
		if(cooldown < 1){
			cooldown++;
			return;
		}
		cooldown = 0;
		entities.addAll(world.loadedEntityList);
		particles.removeIf(part -> part.expired());
		for(Entity entity : entities){
			if(entity instanceof GenericVehicle == false || ((GenericVehicle)entity).getVehicleData().getType().isTrailerOrWagon()) continue;
			float x = Static.random.nextFloat() * 0.1f - 0.05f, z = Static.random.nextFloat() * 0.1f - 0.05f;
			Vec3d pos = entity.getPositionVector();
			ParticleEntity ent = new ParticleEntity(Particle.TEST[Static.random.nextInt(4)], new Vec3f(pos.x + x, pos.y + 1, pos.z + z));
			//ent.color = RGB.random();
			particles.add(ent);
		}
		entities.clear();
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

}
