package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleType;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public class LegacySpawnSystem extends EntitySystem {

	@Override
	public String getId(){
		return "legacy";
	}

	@Override
	public String getName(){
		return "Basic/Legacy Entities";
	}

	@Override
	public boolean validFor(SpawnMode mode, VehicleType type){
		//
		return true;
	}

	@Override
	public void spawnEntity(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data, SpawnMode mode){
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canSpawn(ICommandSender placer, Vec3d pos, ItemStack stack, VehicleData data, SpawnMode mode){
		return false;
	}

}
