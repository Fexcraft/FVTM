package net.fexcraft.mod.fvtm.data;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.Appendable;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmPlayer implements Appendable<UniEntity> {

	protected HashMap<VehicleType, String> favtypes = new HashMap<>();
	protected V3D vehspawnpoint;
	//
	public ArrayList<V3I> longdis = new ArrayList<>();
	public int segmentation = 16;
	public final EntityW entity;

	public FvtmPlayer(UniEntity ent){
		entity = ent == null ? null : ent.entity;
	}
	
	public String getFavoriteSpawnSystemFor(VehicleType type){
		return favtypes.get(type);
	}
	
	public boolean setFavoriteSpawnSystemFor(VehicleType type, String systemid){
		return favtypes.put(type, systemid) == null;
	}

	public void setActiveSpawnPoint(V3D vector){
		vehspawnpoint = vector;
	}

	public V3D getActiveSpawnPoint(){
		return vehspawnpoint;
	}

	@Override
	public void save(UniEntity player, TagCW com){
		if(favtypes.isEmpty()) return;
		TagCW types = TagCW.create();
		for(Map.Entry<VehicleType, String> entry : favtypes.entrySet()){
			if(entry.getValue() == null) continue;
			types.set(entry.getKey().name(), entry.getValue());
		}
		com.set("favtypes", types);
	}

	@Override
	public void load(UniEntity player, TagCW com){
		if(com.has("favtypes")){
			favtypes.clear();
			TagCW types = com.getCompound("favtypes");
			for(String key : types.keys()){
				try{
					VehicleType type = VehicleType.valueOf(key);
					favtypes.put(type, types.getString(key));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void copy(UniEntity old, Appendable<UniEntity> app){
		favtypes.putAll(((FvtmPlayer)app).favtypes);
		segmentation = ((FvtmPlayer)app).segmentation;
		longdis = ((FvtmPlayer)app).longdis;
	}

	@Override
	public FvtmPlayer create(UniEntity unient){
		if(!unient.entity.isPlayer()) return null;
		return new FvtmPlayer(unient);
	}

	@Override
	public String id(){
		return "fvtm:player";
	}

	public RailSystem getRailSystem(){
		return SystemManager.get(SystemManager.Systems.RAIL, entity.getWorld());
	}

}