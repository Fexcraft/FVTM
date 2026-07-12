package net.fexcraft.mod.fvtm.sys.deco;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.sys.uni.DetachedSystem;
import net.fexcraft.mod.fvtm.sys.uni.RegionKey;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemRegion;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.world.ChunkW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldType;
import net.fexcraft.mod.uni.world.WorldW;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

import static net.fexcraft.mod.fvtm.Config.DECO_SAVE_INTERVAL;

/**
 * "Decoration System"
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoSystem extends DetachedSystem<DecoSystem, DecoInstance> {

	public DecoSystem(WorldW sw, WorldType type, File file){
		super(sw, type, file);
	}

	@Override
	public SystemManager.Systems getType(){
		return SystemManager.Systems.DECO;
	}

	@Override
	public void onServerTick(){
		//
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
		return DECO_SAVE_INTERVAL;
	}

	@Override
	public void addTimerTask(long time){
		timer.schedule(new TimedTask(this), new Date(time), DECO_SAVE_INTERVAL);
	}

	@Override
	public String getRegFolderName(){
		return "decoregions";
	}

	public void addNewDeco(EntityW ent, StackWrapper stack, QV3D vec){
		DecoInstance inst = get(vec.pos);
		if(inst == null){
			inst = add(vec.pos);
			inst.vec = vec;
			if(stack != null && stack.isItemOf(ContentType.DECORATION.item_type)){
				insertDeco(inst, ent, stack, vec);
			}
			inst.updateClient();
		}
		else if(stack != null && stack.isItemOf(ContentType.DECORATION.item_type)){
			insertDeco(inst, ent, stack, vec);
			inst.updateClient();
		}
	}

	private void insertDeco(DecoInstance inst, EntityW ent, StackWrapper stack, QV3D vec){
		DecorationData data = new DecorationData(stack.getContent(ContentType.DECORATION.item_type)).read(stack.directTag());
		data.roty = -ent.getYaw();
		data.offset = vec.vec.sub(inst.vec.vec);
		inst.decorations.add(data);
		if(!ent.isCreative()) stack.decr(1);
	}

	public static class TimedTask extends TimerTask {

		private DecoSystem decosys;

		public TimedTask(DecoSystem ssys){
			this.decosys = ssys;
		}

		@Override
		public void run(){
			ArrayList<SystemRegion> regs = new ArrayList<>();
			for(SystemRegion region : decosys.regions.values()){
				region.save();
				if(region.chucks.isEmpty() && region.lastaccess < Time.getDate() - 60000) regs.add(region);
			}
			for(SystemRegion region : regs){
				decosys.regions.remove(region.key);
			}
		}

	}

	@Override
	public void onClientTick(){
		//
	}

	@Override
	public DecoInstance create(SystemRegion<DecoSystem, DecoInstance> region, V3I pos){
		return new DecoInstance(region, pos);
	}

	@Override
	public void writeRegion(SystemRegion<DecoSystem, DecoInstance> region, TagCW com){
		if(region.getObjects().isEmpty()) return;
		TagLW list = TagLW.create();
		for(DecoInstance sign : region.getObjects().values()){
			try{
				list.add(sign.write());
			}
			catch(Exception e){
				FvtmLogger.log(e, "saving deco " + sign.vec + "  in region " + region.key.toString());
			}
		}
		com.set("Decorations", list);
	}

	@Override
	public void readRegion(SystemRegion<DecoSystem, DecoInstance> region, TagCW com){
		if(!com.has("Decorations")) return;
		region.getObjects().clear();
		TagLW list = com.getList("Decorations");
		for(TagCW tag : list){
			try{
				DecoInstance sign = new DecoInstance(region);
				sign.read(tag);
				region.getObjects().put(sign.vec.pos, sign);
			}
			catch(Exception e){
				FvtmLogger.log(e, "loading deco " + tag.direct() + "in region " + region.key.toString());
			}
		}
	}

}
