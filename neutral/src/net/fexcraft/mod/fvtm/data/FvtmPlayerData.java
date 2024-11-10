package net.fexcraft.mod.fvtm.data;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.Appendable;
import net.fexcraft.mod.uni.world.EntityW;

import java.util.HashMap;
import java.util.Map;

/** @author Ferdinand Calo' (FEX___96) **/
public class FvtmPlayerData implements Appendable<UniEntity> {

	private HashMap<VehicleType, String> favtypes = new HashMap<>();
	private V3D position;
	private UniEntity ent;

	public FvtmPlayerData(UniEntity ent){
		this.ent = ent;
	}
	
	public String getFavoriteSpawnSystemFor(VehicleType type){
		return favtypes.get(type);
	}
	
	public boolean setFavoriteSpawnSystemFor(VehicleType type, String systemid){
		return favtypes.put(type, systemid) == null;
	}
	
	public void setActiveSpawnPoint(V3D vector){
		position = vector;
	}
	
	public V3D getActiveSpawnPoint(){
		return position;
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
		favtypes.putAll(((FvtmPlayerData)app).favtypes);
	}

	@Override
	public FvtmPlayerData create(UniEntity unient){
		if(!unient.entity.isPlayer()) return null;
		return new FvtmPlayerData(unient);
	}

	@Override
	public String id(){
		return "fvtm:player";
	}

	public EntityW getPlayer(){
		return ent.entity;
	}

}