package net.fexcraft.mod.fvtm.data;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.Appendable;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmPlayer implements Appendable<UniEntity> {

	public ArrayList<V3I> longdis = new ArrayList<>();
	public int segmentation = 16;
	public EntityW entity;

	public FvtmPlayer(EntityW ent){
		entity = ent;
	}

	@Override
	public Appendable<UniEntity> create(UniEntity type){
		if(!type.entity.isPlayer()) return null;
		return new FvtmPlayer(type.entity);
	}

	@Override
	public String id(){
		return "fvtm:player";
	}

	public RailSystem getRailSystem(){
		return SystemManager.get(SystemManager.Systems.RAIL, entity.getWorld());
	}

}
