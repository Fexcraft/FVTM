package net.fexcraft.mod.fvtm.sys.sign;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.WorldType;
import net.fexcraft.mod.uni.world.WorldW;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

import static net.fexcraft.mod.fvtm.Config.SIGN_SAVE_INTERVAL;

/**
 * "Sign System"
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignSystem extends DetachedSystem<SignSystem, SignInstance> {

	public SignSystem(WorldW sw, WorldType type, File file){
		super(sw, type, file);
	}

	@Override
	public SystemManager.Systems getType(){
		return SystemManager.Systems.SIGN;
	}

	@Override
	public void onServerTick(){
		for(SystemRegion reg : regions.values()){
			//TODO
		}
	}

	@Override
	public void unload(){
		if(!wtype.client()){
			regions.values().forEach(reg -> reg.save());
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
	
	//

	@Override
	public boolean hasTimer(){
		return true;
	}

	@Override
	public long getTimerInterval(){
		return SIGN_SAVE_INTERVAL;
	}

	@Override
	public void addTimerTask(long time){
		timer.schedule(new TimedTask(this), new Date(time), SIGN_SAVE_INTERVAL);
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
				region.save();
				if(region.chucks.isEmpty() && region.lastaccess < Time.getDate() - 60000) regs.add(region);
			}
			for(SystemRegion region : regs){
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
		if(region.getObjects().isEmpty()) return;
		TagLW list = TagLW.create();
		for(SignInstance sign : region.getObjects().values()){
			try{
				list.add(sign.write());
			}
			catch(Exception e){
				FvtmLogger.log(e, "saving sign " + sign.vec + "  in region " + region.key.toString());
			}
		}
		com.set("Signs", list);
	}

	@Override
	public void readRegion(SystemRegion<SignSystem, SignInstance> region, TagCW com){
		if(!com.has("Signs")) return;;
		region.getObjects().clear();
		TagLW list = com.getList("Signs");
		for(TagCW tag : list){
			try{
				SignInstance sign = new SignInstance(region);
				sign.read(tag);
				region.getObjects().put(sign.vec.pos, sign);
			}
			catch(Exception e){
				FvtmLogger.log(e, "loading sign " + tag.direct() + "in region " + region.key.toString());
			}
		}
	}

}
