package net.fexcraft.mod.fvtm.sys.uni;

import java.io.File;
import java.util.Timer;

import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public abstract class DetachedSystem {
	
	protected World world;
	protected int dimension;
	protected Timer timer;
	
	public DetachedSystem(World world){
		this.world = world;
		dimension = world.provider.getDimension();
	}
	
	public World getWorld(){
		return world;
	}
	
	public int getDimension(){
		return dimension;
	}
	
	public void setupTimer(long time){
		if(!hasTimer()) return;
		timer = new Timer();
		addTimerTask(time);
	}
	
	public void stopTimer(){
		if(timer != null) timer.cancel();
	}
	
	public abstract boolean hasTimer();
	
	public abstract void addTimerTask(long time);
	
	public File getSaveRoot(){
		if(dimension != 0){ return new File(world.getSaveHandler().getWorldDirectory(), world.provider.getSaveFolder() + "/fvtm"); }
		return new File(world.getSaveHandler().getWorldDirectory(), "/fvtm");
	}
	
	public void unload(){
		stopTimer();
	}
	
	public abstract void onChunkLoad(Chunk chunk);
	
	public abstract void onChunkUnload(Chunk chunk);

	public abstract void onServerTick();
	
	public void onTimerTick(){
		//
	}

}
