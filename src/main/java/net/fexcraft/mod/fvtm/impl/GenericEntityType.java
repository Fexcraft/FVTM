package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.EntityType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.blocks.DisplayBlock;
import net.fexcraft.mod.fvtm.blocks.rail.JunctionBlock;
import net.fexcraft.mod.fvtm.compatibility.GenericTrigger;
import net.fexcraft.mod.fvtm.entities.land.GenericTrailerEntity;
import net.fexcraft.mod.fvtm.entities.land.GenericVehicleEntity;
import net.fexcraft.mod.fvtm.entities.land.WaterVehicleEntity;
import net.fexcraft.mod.fvtm.entities.rail.GenericLocomotiveEntity;
import net.fexcraft.mod.fvtm.entities.rail.GenericWagonEntity;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailData;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailDataSerializer;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GenericEntityType extends EntityType {

	public GenericEntityType(){
		super(new ResourceLocation("fvtm:internal"), "FVTM", VehicleType.LAND, VehicleType.WATER, VehicleType.RAIL);
	}
	
	private EntityPlayer player;//last player;

	@Override
	public boolean spawnEntity(World world, EntityPlayer player, ItemStack stack, VehicleData data, VehicleType type){
        float cosYaw = MathHelper.cos(-player.rotationYaw * 0.01745329F - 3.141593F);
        float sinYaw = MathHelper.sin(-player.rotationYaw * 0.01745329F - 3.141593F);
        float cosPitch = -MathHelper.cos(-player.rotationPitch * 0.01745329F);
        float sinPitch = MathHelper.sin(-player.rotationPitch * 0.01745329F);
        double length = 5D;
        Vec3d posVec = new Vec3d(player.posX, player.posY + 1.62D - player.getYOffset(), player.posZ);
        Vec3d lookVec = posVec.addVector(sinYaw * cosPitch * length, sinPitch * length, cosYaw * cosPitch * length);
        RayTraceResult movingobjectposition = world.rayTraceBlocks(posVec, lookVec, true);
        if(movingobjectposition == null){
        	if(player.isSneaking()){
    	        if(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty()){
    	            player.setItemStackToSlot(EntityEquipmentSlot.HEAD, stack.copy()); stack.setCount(0);
    	        }
        	} return true;
        }
        if(movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK){
            BlockPos pos = movingobjectposition.getBlockPos();
            if(data == null){
                Print.chat(player, "No Vehicle Data found."); return false;
            }
            if(!data.readyToSpawn()){
                Print.chat(player, "Vehicle can not be spawned, missing parts!"); return false;
            }
            if(world.getBlockState(pos).getBlock() instanceof DisplayBlock){ return true; }
            this.player = player; this.spawnEntity(world, pos, data);
            if(!player.capabilities.isCreativeMode){
            	stack.shrink(1);
            }
            return true;
        }
        return false;		
	}

	@Override
	public boolean spawnEntity(World world, BlockPos pos, VehicleData data){
		if(pos == null) return false;
        float sho = data.getVehicle().getFMAttribute("spawnheight");//spawnheightoffset
        switch(data.getVehicle().getType()){
            case LAND: {
                if(world.getBlockState(pos).getBlock() instanceof BlockLiquid){
                    Print.chat(player, "Vehicle not placeable on water!");
                }
                if(!world.isRemote){
                	if(data.getVehicle().isTrailerOrWagon()){
                		world.spawnEntity(new GenericTrailerEntity(world, pos.getX() + 0.5F, pos.getY() + sho + 0.5F, pos.getZ() + 0.5F, player, data));
                	}
                	else{
                		world.spawnEntity(new GenericVehicleEntity(world, pos.getX() + 0.5F, pos.getY() + sho + 0.5F, pos.getZ() + 0.5F, player, data));
                	}
                }
                break;
            }
            case WATER: {
                if(world.getBlockState(pos).getBlock() instanceof BlockLiquid == false){
                    Print.chat(player, "Vehicle not placeable on land!");
                }
                if(!world.isRemote){
                    world.spawnEntity(new WaterVehicleEntity(world, pos.getX() + 0.5F, pos.getY() + sho + 0.5F, pos.getZ() + 0.5F, player, data));
                }
                break;
            }
            case AIR: {
                Print.chat(player, "Unavailable yet."); return false;
            }
            case RAIL: {
            	if(world.getBlockState(pos).getBlock().getRegistryName().getResourceDomain().equals("trainsmod") && GenericTrigger.AM_TRAINS){
            		GenericTrigger.AM_TRAINS_ET.spawnEntity(world, pos, data); return true;
            	}
                if(world.getBlockState(pos).getBlock() != JunctionBlock.INSTANCE){
                    Print.chat(player, "Only placeable directly on rail connectors.");
                }
                if(!world.isRemote){
                	WorldRailData worldcap = world.getCapability(WorldRailDataSerializer.CAPABILITY, null);
                	if(worldcap == null){
                		Print.chat(player, "No WorldRailData found.");
                		return false;
                	}
                	Junction junk = worldcap.getJunction(pos);
                	if(junk == null || junk.tracks.size() == 0){
                		Print.chat(player, "Track has no Connection Data.");
                		return false;
                	}
                	if(junk.tracks.get(0).getGauge().width() != data.getVehicle().getFMAttribute("railgauge_width")){
                		Print.chat(player, "Vehicle's Gauge is not compatible with Track's Gauge");
                		return false;
                	}
                	if(data.getVehicle().isTrailerOrWagon()){
                		world.spawnEntity(new GenericWagonEntity(world, pos, player, data));
                	}
                	else{
                		world.spawnEntity(new GenericLocomotiveEntity(world, pos, player, data));
                	}
                }
                break;
            }
            default:
            case NULL: {
                Print.chat(player, "Invalid Vehicle Type."); break;
            }
        }
		return true;
	}
	
}