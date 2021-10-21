package net.fexcraft.mod.fvtm.sys.uni;

import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EntitySystem extends DetachedSystem {
	
	public Thread thread;
	public static final int TARGET_TICKS = 20;
	public static final float RATE = 1f / (TARGET_TICKS + 1);
	private TTimer timer = new TTimer();
	private boolean run = true;
	private float accumulator, delta;

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
			timer.init();
			while(run){
				accumulator += (delta = timer.getDelta());
				while(accumulator >= RATE){
					update();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopTimer(){
		run = false;
	}

	@Override
	public void unload(){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChunkLoad(Chunk chunk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChunkUnload(Chunk chunk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerTick(){
		// TODO Auto-generated method stub
		
	}

}
