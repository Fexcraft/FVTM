package net.fexcraft.mod.fvtm.sys.sign;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.mod.fvtm.sys.uni.DetachedSystem;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import static net.fexcraft.mod.fvtm.Config.UNLOAD_INTERVAL;

/**
 * "Sign System"
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignSystem extends DetachedSystem {

	private RegionMap regions = new RegionMap(this);
	private long gc_trafficsigns;

	public SignSystem(WorldW world){
		super(world);
		if(!world.isClient()) load();
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
		//
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
	
	public static class TimedTask extends TimerTask {

		private SignSystem signsys;

		public TimedTask(SignSystem ssys){
			this.signsys = ssys;
		}

		@Override
		public void run(){
			ArrayList<SignRegion> regs = new ArrayList<>();
			for(SignRegion region : signsys.regions.values()){
				if(region.chucks.isEmpty() && region.lastaccess < Time.getDate() - 60000) regs.add(region);
			}
			for(SignRegion region : regs){
				region.save();
				signsys.regions.remove(region.getKey());
			}
		}

	}

	public SignInstance getSign(QV3D pos){
		SignRegion region = regions.get(pos, false);
		return region == null ? null : region.getSign(pos);
	}

	public SignInstance getSign(QV3D pos, boolean load){
		SignRegion region = regions.get(pos, load);
		return region.getSign(pos);
	}

	private SignInstance addSign(QV3D pos){
		SignRegion region = regions.get(pos, true);
		return region.addSign(pos);
	}

	public void delSign(QV3D pos){
		SignRegion region = regions.get(pos, true);
		if(region != null) region.delSign(pos);
	}

	@Override
	public void onClientTick(){
		//unused
	}

	public static class RegionMap extends ConcurrentHashMap<RegionKey, SignRegion> {

		private SignSystem root;

		public RegionMap(SignSystem data){
			root = data;
		}

		public SignRegion get(int x, int z){
			for(RegionKey key : keySet()){
				if(x == key.x && z == key.z) return get(key);
			}
			return null;
		}

		public SignRegion get(int[] xz){
			for(RegionKey key : keySet()){
				if(xz[0] == key.x && xz[1] == key.z) return get(key);
			}
			return null;
		}

		public SignRegion get(QV3D pos, boolean load){
			SignRegion region = get(RegionKey.getRegionXZ(pos));
			if(region != null || !load) return region;
			put(new RegionKey(RegionKey.getRegionXZ(pos)), region = new SignRegion(pos.pos, root, false));
			region.load().updateClient(pos);
			return region;
		}

		public SignRegion get(int[] xz, boolean load){
			SignRegion region = get(xz);
			if(region != null || !load) return region;
			put(new RegionKey(xz), region = new SignRegion(xz[0], xz[1], root, false));
			region.load();
			return region;
		}

		public SignRegion get(RegionKey xz, boolean load){
			SignRegion region = get(xz);
			if(region != null || !load) return region;
			put(new RegionKey(xz.x, xz.z), region = new SignRegion(xz.x, xz.z, root, false));
			region.load();
			return region;
		}

	}

	public RegionMap getRegions(){
		return regions;
	}

}
