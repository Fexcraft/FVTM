package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.Track;
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

@fItem(modid = "fvtm", name = "railitem")
public class RailItemTemp extends Item {

    public static RailItemTemp INSTANCE;

    public RailItemTemp(){ INSTANCE = this; }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:railpoints")){
        	NBTTagList list = (NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints");
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
        RailSystem syscap = world.getCapability(Capabilities.RAILSYSTEM, null);
        if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        Vec316f vector = new Vec316f(new Vec3d(pos).addVector(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID);
        if(player.isSneaking()){
			if(syscap.delJunction(vector)) Print.chat(player, "&c&oResetting Junction...");
			else{
				Print.chat(player, "&9&oNo Junction found here.");
				stack.getTagCompound().removeTag("fvtm:railpoints");
				Print.chat(player, "&bResetting Item Point(s) Cache.");
			} return EnumActionResult.SUCCESS;
		}
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		Junction junk = syscap.getJunction(vector, true);
		NBTTagList list = stack.getTagCompound().hasKey("fvtm:railpoints") ? (NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints") : new NBTTagList();
		if(junk == null || list.hasNoTags()){
			if(list.hasNoTags() || !createdJunction(syscap, player, list, vector)){
				list.appendTag(vector.write()); stack.getTagCompound().setTag("fvtm:railpoints", list);
				Print.bar(player, list.tagCount() + (getSuffix(list.tagCount())) +" Point Added!");
				return EnumActionResult.SUCCESS;
			}
			else{ stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.SUCCESS; }
		}
		else{
			if(junk.tracks.size() >= 4){
				Print.chat(player, "&9Junction reached track limit (4)\n&c&oPoint cache reset.");
				stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.FAIL;
			}
			Track track = new Track(junk, getVectors(list), vector, null);
			Junction second = syscap.getJunction(track.start);
			if(second != null){
				second.addnew(track); junk.addnew(track.createOppositeCopy());
				Print.chat(player, "&aTrack Created!");stack.getTagCompound().removeTag("fvtm:railpoints");
			} else{ Print.chat(player, "&cNo Junction at starting point found!"); }
			return EnumActionResult.SUCCESS;
		}
    }

	private boolean createdJunction(RailSystem syscap, EntityPlayer player, NBTTagList list, Vec316f vector){
		if(list.tagCount() != 1) return false; Vec316f vec = getFirstVector(list); if(!vec.equals(vector)) return false;
		syscap.addJunction(vector); Print.chat(player, "Junction Created!"); return true;
	}

	private String getSuffix(int tagCount){
		if(tagCount < 4) return tagCount == 1 ? "st" : tagCount == 2 ? "nd" : "rd"; else return "th";
	}

	public Vec316f[] getVectors(ItemStack stack){
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("fvtm:railpoints")) return new Vec316f[0];
		return getVectors((NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints"));
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

}
