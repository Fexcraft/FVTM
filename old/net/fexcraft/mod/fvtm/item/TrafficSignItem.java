package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fItem(modid = FVTM.MODID, name = "trafficsign")
public class TrafficSignItem extends Item {
	
	public static TrafficSignItem INSTANCE;

    public TrafficSignItem(){
		super(); INSTANCE = this;
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
	}
    
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
    	if(world.isRemote || side.getAxis().isVertical()) return EnumActionResult.PASS;
    	if(StreetSignItem.tryPlace(player, world, pos, side, player.getHeldItem(hand), 1)) return EnumActionResult.SUCCESS;
    	return EnumActionResult.PASS;
    }

}
