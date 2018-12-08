package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.EntityType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PrototypeEntityType extends EntityType {

	public PrototypeEntityType(){
		super(new ResourceLocation("fvtm:prototype"), "FVTM Protype", VehicleType.LAND, VehicleType.WATER, VehicleType.RAIL);
	}

	@Override
	public boolean spawnEntity(World world, EntityPlayer player, ItemStack stack, VehicleData data, VehicleType type){
		Print.console("\"//TODO\"");
        return false;		
	}

	@Override
	public boolean spawnEntity(World world, BlockPos pos, VehicleData data){
		Print.console("\"//TODO\"");
		return false;
	}
	
}