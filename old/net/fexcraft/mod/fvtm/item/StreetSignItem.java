package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.StreetPost;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.entity.StreetSign;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockWall;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fItem(modid = FVTM.MODID, name = "streetsign")
public class StreetSignItem extends Item {
	
	public static Item INSTANCE;
	
	public StreetSignItem(){
		super(); INSTANCE = this;
	}
    
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
    	if(world.isRemote || side.getAxis().isVertical()) return EnumActionResult.PASS;
    	if(tryPlace(player, world, pos, side, player.getHeldItem(hand), 0)) return EnumActionResult.SUCCESS;
    	return EnumActionResult.PASS;
    }

	public static boolean tryPlace(EntityPlayer player, World world, BlockPos pos, EnumFacing side, ItemStack stack, int enttype){
		IBlockState state = world.getBlockState(pos);
		if(enttype != 1 && !(state.getBlock() instanceof StreetPost || state.getBlock() instanceof BlockFence || state.getBlock() instanceof BlockWall)){
    		Print.bar(player, "invalid position for sign");
    		return false;
		}
		AxisAlignedBB aabb = new AxisAlignedBB(pos);
		boolean found = false;
		for(Entity e : world.loadedEntityList){
			if((e instanceof StreetSign || e instanceof TrafficSignEntity) && e.getEntityBoundingBox().intersects(aabb)){
				found = true;
				break;
			}
		}
    	if(!found){
    		Entity entity = null;
    		switch(enttype){
				case 0: entity = new StreetSign(world, side); break;
				case 1:{
					aabb = state.getBoundingBox(world, pos);
					float off = (float)(side.getAxis() == Axis.X ? aabb.maxX - aabb.minX : aabb.maxZ - aabb.minZ);
					boolean full = off >= 1f;
					if(full){
						//Print.bar(player, "cannot be placed on full width blocks");
						//return false;
						pos = pos.add(side.getDirectionVec());
						off = -1;
					}
					entity = new TrafficSignEntity(world);
					TrafficSigns signs = world.getChunk(pos).getCapability(Capabilities.TRAFFIC_SIGNS, null);
					float rot = 0;
					if(player.isSneaking() && !full){
						rot = player.rotationYaw;
						if(rot < 0) rot += 180;
						else rot -= 180;
					}
					else rot = side.getHorizontalAngle();
					signs.addSignAt(pos, rot, off * 0.5f, world.isRemote);
					break;
				}
				default: Print.bar(player, "ERROR, Invalid Entity Type in ITEM."); return false;
			}
    		entity.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
    		world.spawnEntity(entity);
    		Print.bar(player, "Sign spawned at " + entity.getPositionVector());
    		return true;
    	}
    	else{
    		Print.bar(player, "entity/sign at position"); return false;
    	}
	}
	
}
