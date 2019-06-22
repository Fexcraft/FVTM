package net.fexcraft.mod.fvtm.data.vehicle;

import java.util.HashMap;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class EntitySystem {
	
	public static HashMap<String, EntitySystem> REGISTRY = new HashMap<>();
	
	public EntitySystem(){}
	
	public abstract String getId();
	
	public abstract void spawnVehicle(World world, Vec3d pos, @Nullable EntityPlayer placer, @Nullable ItemStack stack, VehicleData data, SpawnMode mode);
	
	public abstract boolean canSpawn(World world, Vec3d pos, @Nullable EntityPlayer placer, @Nullable ItemStack stack, VehicleData data, SpawnMode mode);
	
	public static enum SpawnMode {
		PLAYER, CONSTRUCTOR, CODE, OTHER
	}

}
