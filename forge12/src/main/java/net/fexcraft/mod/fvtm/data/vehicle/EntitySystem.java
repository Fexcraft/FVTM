package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public abstract class EntitySystem {
	
	public static HashMap<String, EntitySystem> REGISTRY = new HashMap<>();
	
	public EntitySystem(){}
	
	public abstract String getId();
	
	public abstract String getName();
	
	public abstract void spawnEntity(ICommandSender placer, Vec3d pos, @Nullable ItemStack stack, VehicleData data);
	
	public abstract boolean canSpawn(ICommandSender placer, Vec3d pos, @Nullable ItemStack stack, VehicleData data);
	
	public abstract boolean validFor(VehicleType type);
	
	public static final void spawnVehicle(ICommandSender placer, Vec3d pos, @Nullable ItemStack stack, VehicleData data){
		String favorite = placer == null || placer.getCommandSenderEntity().getCapability(Capabilities.PLAYERDATA, null) == null ? null
			: placer.getCommandSenderEntity().getCapability(Capabilities.PLAYERDATA, null).getFavoriteSpawnSystemFor(data.getType().getVehicleType());
		EntitySystem sel = REGISTRY.get(favorite);
		if(sel != null && sel.canSpawn(placer, pos, stack, data)){
			sel.spawnEntity(placer, pos, stack, data);
			return;
		}
		ArrayList<String> valid = getValidFor(data.getType().getVehicleType());
		if(valid.isEmpty()){
			Print.chat(placer, "&cNo Spawn systems for this type available.");
			Print.chat(placer, "&bType: " + data.getType().getVehicleType() + "/" + data.getName());
			return;
		}
		if(valid.size() == 1){
			sel = REGISTRY.get(valid.get(0));
			if(sel.canSpawn(placer, pos, stack, data)){
				sel.spawnEntity(placer, pos, stack, data);
			}
			return;
		}
		else{
			if(placer.getCommandSenderEntity() instanceof EntityPlayer){
				placer.getCommandSenderEntity().getCapability(Capabilities.PLAYERDATA, null).setActiveSpawnPoint(pos);
				((EntityPlayer)placer.getCommandSenderEntity()).openGui(FVTM.getInstance(), GuiHandler.SPAWNSYS, placer.getEntityWorld(), data.getType().getVehicleType().ordinal(), 0, 0);
			}
			else{
				Print.chat(placer, "&cThere are multiple spawn systems to choose from.");
				Print.chat(placer, "&cPlease try spawning as player or choose a system beforehand.");
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
