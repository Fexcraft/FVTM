package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CameraEntity extends EntityLivingBase {
	
	public VehicleEntity vehicle;
	
	public CameraEntity(World world){
		super(world);
		setSize(0F, 0F);
	}
	
	public CameraEntity(World world, VehicleEntity veh){
		this(world);
		vehicle = veh;
		setPosition(veh.getEntity().posX, veh.getEntity().posY, veh.getEntity().posZ);
	}
	
	@Override
	public void onUpdate(){
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
		
		Vec3d camerapos = new Vec3d(0, 0, 0);
		camerapos = vehicle.getAxes().getRelativeVector(camerapos);
		double dX = vehicle.getEntity().posX + camerapos.x - posX;
		double dY = vehicle.getEntity().posY + camerapos.y - posY;
		double dZ = vehicle.getEntity().posZ + camerapos.z - posZ;
		float la = 0.1F;
		setPosition(posX + dX * la, posY + dY * la, posZ + dZ * la);
		
		rotationYaw = vehicle.getAxes().getYaw() - 90F;
		rotationPitch = vehicle.getAxes().getPitch();
		
		for(; rotationYaw - prevRotationYaw >= 180F; rotationYaw -= 360F){;}
		for(; rotationYaw - prevRotationYaw < -180F; rotationYaw += 360F){;}
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		return null;
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
		return null;
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
		
	}

	@Override
	public EnumHandSide getPrimaryHand(){
		return EnumHandSide.RIGHT;
	}

}
