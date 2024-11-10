package net.fexcraft.mod.fvtm.data.vehicle;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.FvtmPlayerData;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.MessageSender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class EntitySystem {
	
	public static HashMap<String, EntitySystem> REGISTRY = new HashMap<>();
	
	public EntitySystem(){}
	
	public abstract String getId();
	
	public abstract String getName();
	
	public abstract void spawn(MessageSender placer, V3D pos, VehicleData data, StackWrapper stack);
	
	public abstract boolean canSpawn(MessageSender placer, V3D pos, VehicleData data, StackWrapper stack);
	
	public abstract boolean validFor(VehicleType type);
	
	public static final void spawnVehicle(MessageSender placer, V3D pos, VehicleData data, StackWrapper stack){
		String pref = null;
		FvtmPlayerData pd = null;
		if(placer instanceof EntityW){
			pd = UniEntity.get(((EntityW)placer).local()).getApp(FvtmPlayerData.class);
			if(pd != null) pref = pd.getFavoriteSpawnSystemFor(data.getType().getVehicleType());
		}
		EntitySystem sel = REGISTRY.get(pref);
		if(sel != null && sel.canSpawn(placer, pos, data, stack)){
			sel.spawn(placer, pos, data, stack);
			return;
		}
		ArrayList<String> valid = getValidFor(data.getType().getVehicleType());
		if(valid.isEmpty()){
			placer.send("&cNo Spawn systems for this type available.");
			placer.send("&bType: " + data.getType().getVehicleType() + "/" + data.getName());
			return;
		}
		if(valid.size() == 1){
			sel = REGISTRY.get(valid.get(0));
			if(sel.canSpawn(placer, pos, data, stack)){
				sel.spawn(placer, pos, data, stack);
			}
			return;
		}
		else{
			if(pd != null){
				pd.setActiveSpawnPoint(pos);
				pd.getPlayer().openUI(UIKeys.ENTITY_SYSTEM_CHOOSE, data.getType().getVehicleType().ordinal(), 0, 0);
			}
			else{
				placer.send("&cThere are multiple spawn systems to choose from.");
				placer.send("&cPlease try spawning as player or choose a system beforehand.");
			}
		}
	}

	public static ArrayList<String> getValidFor(VehicleType type){
		ArrayList<String> found = new ArrayList<>();
		for(Entry<String, EntitySystem> sys : EntitySystem.REGISTRY.entrySet()){
			if(sys.getValue().validFor(type)){
				found.add(sys.getKey());
			}
		}
		return found;
	}
	
	public static void add(EntitySystem sys){
		REGISTRY.put(sys.getId(), sys);
	}

}
