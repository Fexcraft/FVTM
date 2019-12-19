package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.road.Road;
import net.fexcraft.mod.fvtm.sys.road.RoadJunc;
import net.fexcraft.mod.fvtm.sys.road.RoadSys;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fItem(modid = "fvtm", name = "roadsystem_tool")
public class RoadSysItem extends Item implements JunctionGridItem {

    public static RoadSysItem INSTANCE;
    
    public RoadSysItem(){
		super(); this.setHasSubtypes(true); this.setMaxStackSize(1); INSTANCE = this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&6Tool to manage FVTM Roads."));
        tooltip.add(Formatter.format("&9- - - - - - &7-"));
        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:roadpoints")){
        	NBTTagList list = (NBTTagList)stack.getTagCompound().getTag("fvtm:roadpoints");
    		for(int k = 0; k < list.tagCount(); k++){
            	tooltip.add(Formatter.format("&9PT" + k + " POS:" + new Vec316f(list.getCompoundTagAt(k)).toString()));
    		}
        }
        else{
        	tooltip.add("No Connection data.");
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote){ return EnumActionResult.PASS; }
        RoadSys syscap = world.getCapability(Capabilities.ROADSYSTEM, null).get();
        if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        Vec316f vector = new Vec316f(new Vec3d(pos).addVector(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID);
        if(player.isSneaking()){
			stack.getTagCompound().removeTag("fvtm:roadpoints");
			Print.chat(player, "&bItem Point(s) Cache reset.");
			return EnumActionResult.SUCCESS;
		}
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		RoadJunc point = syscap.getRoadPoint(vector, true);
		NBTTagList list = stack.getTagCompound().hasKey("fvtm:roadpoints") ? (NBTTagList)stack.getTagCompound().getTag("fvtm:roadpoints") : new NBTTagList();
		if(point == null || list.hasNoTags()){
			if(list.hasNoTags() || !createdRoadPoint(syscap, player, list, vector)){
				list.appendTag(vector.write()); stack.getTagCompound().setTag("fvtm:roadpoints", list);
				Print.bar(player, list.tagCount() + (getSuffix(list.tagCount())) +" Point Added!");
				return EnumActionResult.SUCCESS;
			}
			else{ stack.getTagCompound().removeTag("fvtm:roadpoints"); return EnumActionResult.SUCCESS; }
		}
		else{
			/*if(point.signalbox != null){
				Print.chat(player, "&9Please remove the signal first.");
				stack.getTagCompound().removeTag("fvtm:roadpoints"); return EnumActionResult.FAIL;
			}*/
			if(point.roads.size() >= 4){
				Print.chat(player, "&9RoadPoint reached connected road/path limit (4)\n&c&oPoint cache reset.");
				stack.getTagCompound().removeTag("fvtm:roadpoints"); return EnumActionResult.FAIL;
			}
			Road road = new Road(point, getVectors(list), vector);
			if(road.length > Config.MAX_ROAD_LENGTH){
				Print.chat(player, "&cRoad length exceeds the configured max length.");
				return EnumActionResult.FAIL;
			}
			RoadJunc second = syscap.getRoadPoint(road.start);
			if(second != null){
				second.addnew(road); point.addnew(road.createOppositeCopy());
				second.checkRoadSectionConsistency();
				Print.chat(player, "&aRoad/Path Created!"); stack.getTagCompound().removeTag("fvtm:roadpoints");
				if(!player.capabilities.isCreativeMode) stack.shrink(1);
			} else{ Print.chat(player, "&cNo RoadPoint at starting point found!"); }
			return EnumActionResult.SUCCESS;
		}
    }

	private boolean createdRoadPoint(RoadSys syscap, EntityPlayer player, NBTTagList list, Vec316f vector){
		if(list.tagCount() != 1) return false; Vec316f vec = getFirstVector(list); if(!vec.equals(vector)) return false;
		syscap.addRoadPoint(vector); Print.chat(player, "RoadPoint Created!"); return true;
	}

	private String getSuffix(int tagCount){
		if(tagCount < 4) return tagCount == 1 ? "st" : tagCount == 2 ? "nd" : "rd"; else return "th";
	}
	
	@Override
	public Vec316f[] getVectors(ItemStack stack){
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("fvtm:roadpoints")) return new Vec316f[0];
		return getVectors((NBTTagList)stack.getTagCompound().getTag("fvtm:roadpoints"));
	}

	public Vec316f[] getVectors(NBTTagList list){
		Vec316f[] arr = new Vec316f[list.tagCount()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = new Vec316f(list.getCompoundTagAt(i));
		} return arr;
	}

	private Vec316f getFirstVector(NBTTagList list){
		return new Vec316f(list.getCompoundTagAt(0));
	}

	@Override
	public boolean hasVectors(){
		return true;
	}

}
