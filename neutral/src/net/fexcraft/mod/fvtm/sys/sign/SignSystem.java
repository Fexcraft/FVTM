package net.fexcraft.mod.fvtm.sys.sign;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

import static net.fexcraft.mod.fvtm.Config.UNLOAD_INTERVAL;

/**
 * "Sign System"
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignSystem extends DetachedSystem<SignSystem, SignInstance> {

	private long gc_trafficsigns;

	public SignSystem(WorldW world){
		super(world);
		if(!world.isClient()) load();
	}

	@Override
	public SystemManager.Systems getType(){
		return SystemManager.Systems.SIGN;
	}

	public void load(){
		try{
			File file = new File(getSaveRoot(), "/traffic_signs.dat");
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			TagCW compound = WrapperHolder.read(file);
			if(compound == null || compound.empty()) return;
			gc_trafficsigns = compound.getLong("GlobalCounterSigns");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void save(){
		TagCW compound = TagCW.create();
		compound.set("GlobalCounterSigns", gc_trafficsigns);
		try{
			File file = new File(getSaveRoot(), "/traffic_signs.dat");
			if(!file.getParentFile().exists()) file.getParentFile().mkdirs();
			WrapperHolder.write(compound, file);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onServerTick(){
		for(SystemRegion reg : regions.values()){
			//TODO
		}
	}

	@Override
	public void unload(){
		if(!world.isClient()){
			regions.values().forEach(reg -> reg.save());
			save();
		}
		regions.clear();
	}

	@Override
	public void onChunkLoad(ChunkW chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x(), chunk.z()), true).chucks.put(new RegionKey(chunk.x(), chunk.z()), chunk);
	}

	@Override
	public void onChunkUnload(ChunkW chunk){
		regions.get(RegionKey.getRegionXZ(chunk.x(), chunk.z()), true).chucks.values().removeIf(pre -> pre.x() == chunk.x() && pre.z() == chunk.z());
	}

	public long getNewSignId(){
		return gc_trafficsigns++;
	}
	
	//

	@Override
	public boolean hasTimer(){
		return true;
	}

	@Override
	public void addTimerTask(long time){
		timer.schedule(new TimedTask(this), new Date(time), UNLOAD_INTERVAL);
	}

	@Override
	public String getRegFolderName(){
		return "signregions";
	}

	public static class TimedTask extends TimerTask {

		private SignSystem signsys;

		public TimedTask(SignSystem ssys){
			this.signsys = ssys;
		}

		@Override
		public void run(){
			ArrayList<SystemRegion> regs = new ArrayList<>();
			for(SystemRegion region : signsys.regions.values()){
				if(region.chucks.isEmpty() && region.lastaccess < Time.getDate() - 60000) regs.add(region);
			}
			for(SystemRegion region : regs){
				region.save();
				signsys.regions.remove(region.key);
			}
		}

	}

	@Override
	public void onClientTick(){
		//unused
	}

	@Override
	public SignInstance create(SystemRegion<SignSystem, SignInstance> region, V3I pos){
		return new SignInstance(region, pos);
	}

	@Override
	public void writeRegion(SystemRegion<SignSystem, SignInstance> region, TagCW com){
		if(!region.getObjects().isEmpty()){
			TagLW list = TagLW.create();
			for(SignInstance sign : region.getObjects().values()){
				list.add(sign.write());
			}
			com.set("Signs", list);
		}
	}

	@Override
	public void readRegion(SystemRegion<SignSystem, SignInstance> region, TagCW com){
		if(!com.has("Signs")) return;;
		region.getObjects().clear();
		TagLW list = com.getList("Signs");
		for(TagCW tag : list){
			SignInstance sign = new SignInstance(region);
			sign.read(tag);
			region.getObjects().put(sign.vec.pos, sign);
		}
	}

}
