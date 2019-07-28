package net.fexcraft.mod.fvtm.util.handler;

import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LegacySpawnSystem extends EntitySystem {

	@Override
	public String getId(){
		return "legacy";
	}

	@Override
	public void spawnVehicle(World world, Vec3d pos, EntityPlayer placer, ItemStack stack, VehicleData data, SpawnMode mode){
		//
	}

	@Override
	public boolean canSpawn(World world, Vec3d pos, EntityPlayer placer, ItemStack stack, VehicleData data, SpawnMode mode){
		//
		return false;
	}

}
