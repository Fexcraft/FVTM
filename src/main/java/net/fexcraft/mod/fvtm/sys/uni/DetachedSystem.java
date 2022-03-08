package net.fexcraft.mod.fvtm.sys.uni;

import java.io.File;
import java.util.Timer;

import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public abstract class DetachedSystem {
	
	protected World world;
	protected int dimension;
	protected Timer timer;
	protected File root;
	
	public DetachedSystem(World world){
		this.world = world;
		dimension = world.provider.getDimension();
		root = new File(world.getSaveHandler().getWorldDirectory(), (dimension == 0 ? "" : world.provider.getSaveFolder()) + "/fvtm");
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
	
	public void addTimerTask(long time){}
	
	public File getSaveRoot(){
		return root;
	}
	
	public abstract void unload();
	
	public abstract void onChunkLoad(Chunk chunk);
	
	public abstract void onChunkUnload(Chunk chunk);

	public abstract void onServerTick(World world);

	public abstract void onClientTick(World world);
	
	public void onTimerTick(){
		//
	}

}
