package net.fexcraft.mod.fvtm.sys.uni;

import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.io.File;
import java.util.Timer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class DetachedSystem {
	
	protected WorldW world;
	protected Timer timer;
	protected File root;
	
	public DetachedSystem(WorldW world){
		this.world = world;
		root = WrapperHolder.getWorldFolder(world, "fvtm");
	}
	
	public WorldW getWorld(){
		return world;
	}
	
	public int getDimension(){
		return world.dim();
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
	
	public abstract void onChunkLoad(ChunkW chunk);
	
	public abstract void onChunkUnload(ChunkW chunk);

	public abstract void onServerTick();

	public abstract void onClientTick();
	
	public void onTimerTick(){
		//
	}

}
