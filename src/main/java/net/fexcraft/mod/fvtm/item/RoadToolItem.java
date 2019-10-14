package net.fexcraft.mod.fvtm.item;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

@fItem(modid = "fvtm", name = "road_tool")
public class RoadToolItem extends Item implements JunctionGridItem {
	
	public static RoadToolItem INSTANCE;

    public RoadToolItem(){
		super(); INSTANCE = this; if(Static.side().isServer()) return;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&9Road Placing Toolbox"));
        tooltip.add(Formatter.format("&9Current Width: &7" + stack.getCount() + " blocks"));
        if(stack.getTagCompound() == null){
        	tooltip.add("No Compound Data.");
        }
        else{
        	ItemStack stack0 = null;
        	if(stack.getTagCompound().hasKey("BottomFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("BottomFill"));
                tooltip.add(Formatter.format("&9Ground Fill: &7" + stack0.toString()));
        	}
        	if(stack.getTagCompound().hasKey("TopFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("TopFill"));
                tooltip.add(Formatter.format("&9Roof Fill: &7" + stack0.toString()));
        	}
        	if(stack.getTagCompound().hasKey("SideRFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideRFill"));
                tooltip.add(Formatter.format("&9R Border Fill: &7" + stack0.toString()));
        	}
        	if(stack.getTagCompound().hasKey("SideLFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideLFill"));
                tooltip.add(Formatter.format("&9L Border Fill: &7" + stack0.toString()));
        	}
            tooltip.add(Formatter.format("&9- - - - - - &7-"));
            if(stack.getTagCompound().hasKey("fvtm:roadpoints")){
            	NBTTagList list = (NBTTagList)stack.getTagCompound().getTag("fvtm:roadpoints");
        		for(int k = 0; k < list.tagCount(); k++){
                	tooltip.add(Formatter.format("&9PT" + k + " POS:" + new Vec316f(list.getCompoundTagAt(k)).toString()));
        		}
            }
            else{
            	tooltip.add("No points cached.");
            }
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote){ return EnumActionResult.PASS; }
        if(hand == EnumHand.OFF_HAND){
        	GenericContainer.openGui("fvtm", 702, new int[]{ 0, 0, 0 }, player); return EnumActionResult.SUCCESS;
        }
        if(!player.capabilities.isCreativeMode){
        	Print.chat(player, "&9This is a &6CREATIVE &9mode tool."); return EnumActionResult.FAIL;
        }
        if(!Static.getServer().isSinglePlayer() && !Static.isOp(player)){
        	Print.chat(player, "&cYou need to be OPERATOR to use this item."); return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        Vec316f vector = new Vec316f(new Vec3d(pos.down()).addVector(hitX, hitY, hitZ), Config.ROAD_PLACING_GRID);
        if(player.isSneaking()){
			stack.getTagCompound().removeTag("fvtm:roadpoints");
			Print.chat(player, "&bResetting Item Point(s) Cache.");
			return EnumActionResult.SUCCESS;
		}
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		NBTTagList list = stack.getTagCompound().hasKey("fvtm:roadpoints") ? (NBTTagList)stack.getTagCompound().getTag("fvtm:roadpoints") : new NBTTagList();
		if(!lastEquals(list, vector)){
			list.appendTag(vector.write()); stack.getTagCompound().setTag("fvtm:roadpoints", list);
			Print.bar(player, list.tagCount() + (getSuffix(list.tagCount())) +" Point Added!");
			return EnumActionResult.SUCCESS;
		}
		else{
			Track track = new Track(null, getVectors(list), vector, null);
			if(track.length > Config.MAX_ROAD_LENGTH){
				Print.chat(player, "&cRoad vector length exceeds the configured max length.");
				return EnumActionResult.FAIL;
			}
			int width = stack.getCount(), height; float angle, passed = 0, half = (width * 0.5f) - 0.5f; Vec3f last, vec;
			ArrayList<Vec316f> path = new ArrayList<>(), border = new ArrayList<>(); IBlockState state; BlockPos blk;
			vec = track.getVectorPosition0(0.001f, false); passed = 0;
			angle = (float)Math.atan2(track.vecpath[0].zCoord - vec.zCoord, track.vecpath[0].xCoord - vec.xCoord);
			angle += Static.rad90;
			for(float fl = -half; fl <= half; fl += 0.25f){
				path.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(fl, 0, 0)))));
			}
			border.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(-half - 1, 0, 0)))));
			border.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(half + 1, 0, 0)))));
			//Print.log(passed + "/" + track.length + " " + path.get(path.size() - 1) + " START");
			while(passed < track.length){ passed += 0.125f;
				last = vec; vec = track.getVectorPosition0(passed, false);
				angle = (float)Math.atan2(last.zCoord - vec.zCoord, last.xCoord - vec.xCoord);
				angle += Static.rad90;
				for(float fl = -half; fl <= half; fl += 0.25f){
					path.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl, 0, 0)))));
				}
				border.add(new Vec316f(vec.add(grv(angle, new Vec3f(-half - 1, 0, 0)))));
				border.add(new Vec316f(vec.add(grv(angle, new Vec3f(half + 1, 0, 0)))));
				//Print.log(passed + " " + path.get(path.size() - 1));
			}
			for(Vec316f v : path){
				height = v.y; state = world.getBlockState(blk = height != 0 ? v.pos.up() : v.pos);
				if(state.getBlock() != Asphalt.INSTANCE || state.getValue(Asphalt.HEIGHT) < height){
					if(world.getBlockState(blk.up()).getBlock() instanceof Asphalt) height = 0;
					world.setBlockState(blk, Asphalt.INSTANCE.getDefaultState().withProperty(Asphalt.HEIGHT, height), 2);
				}
				if((height < 9 && height != 0) || world.getBlockState(blk.down()).getBlock() instanceof Asphalt){
					world.setBlockState(blk.down(), Asphalt.INSTANCE.getDefaultState().withProperty(Asphalt.HEIGHT, 0), 2);
				}
				for(int i = 1; i < 4; i++){
					if(world.getBlockState(blk.up(i)).isOpaqueCube()){
						world.setBlockState(blk.up(i), Blocks.AIR.getDefaultState());
					}
				}
			}
			for(Vec316f v : border){
				height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
				for(int i = 1; i < 4; i++){
					if(i == 1 && height > 8) continue;
					if(world.getBlockState(blk.up(i)).isOpaqueCube()){
						world.setBlockState(blk.up(i), Blocks.AIR.getDefaultState());
					}
				}
			}
			//
			Print.bar(player, "&bRoad placed!");
			stack.getTagCompound().removeTag("fvtm:roadpoints");
			return EnumActionResult.SUCCESS;
		}
    }
	
	public static final Vec3f grv(float rad, Vec3f vec){
        double co = Math.cos(rad), si = Math.sin(rad); return new Vec3f(co * vec.xCoord - si * vec.zCoord, vec.yCoord, si * vec.xCoord + co * vec.zCoord);
	}

	private boolean lastEquals(NBTTagList list, Vec316f vector){
		if(list.hasNoTags() || list.tagCount() < 2) return false; return getLastVector(list).equals(vector);
	}

	private String getSuffix(int tagCount){
		if(tagCount < 4) return tagCount == 1 ? "st" : tagCount == 2 ? "nd" : "rd"; else return "th";
	}
	
	public Vec316f getLastVector(NBTTagList list){
		return new Vec316f(list.getCompoundTagAt(list.tagCount() - 1));
	}
	
	@Override
	public Vec316f[] getVectors(ItemStack stack){
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("fvtm:roadpoints")) return new Vec316f[0];
		return getVectors((NBTTagList)stack.getTagCompound().getTag("fvtm:roadpoints"));
	}

	public Vec316f[] getVectors(NBTTagList list){
		Vec316f[] arr = new Vec316f[list.tagCount() - 1];
		for(int i = 0; i < arr.length; i++){
			arr[i] = new Vec316f(list.getCompoundTagAt(i));
		} return arr;
	}

	@Override
	public boolean hasVectors(){
		return true;
	}

}
