package net.fexcraft.mod.fvtm.item;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.gui.GuiCommandSender;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
		super(); INSTANCE = this;
		if(Static.side().isServer()) return;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&aRoad Placing Toolbox"));
        tooltip.add(Formatter.format("&9Current Width: &7" + stack.getCount() + " blocks"));
        if(stack.getTagCompound() == null){
            tooltip.add(Formatter.format("&6Road Fill: &bSOLID ASPHALT &7x" + stack.getCount()));
        	tooltip.add("No Compound Data.");
        }
        else{
        	ItemStack stack0 = null;
        	if(stack.getTagCompound().hasKey("BottomFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("BottomFill"));
                tooltip.add(Formatter.format("&9Ground Fill: &7" + stack0.getDisplayName()));
        	}
        	if(stack.getTagCompound().hasKey("TopFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("TopFill"));
                tooltip.add(Formatter.format("&9Roof Fill: &7" + stack0.getDisplayName()));
        	}
        	if(stack.getTagCompound().hasKey("SideRFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideRFill"));
                tooltip.add(Formatter.format("&9R Border Fill: &7" + stack0.getDisplayName() + " x" + stack0.getCount()));
        	}
        	if(stack.getTagCompound().hasKey("SideLFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideLFill"));
                tooltip.add(Formatter.format("&9L Border Fill: &7" + stack0.getDisplayName() + " x" + stack0.getCount()));
        	}
        	if(stack.getTagCompound().hasKey("RoadFill")){
        		NBTTagList fill = (NBTTagList)stack.getTagCompound().getTag("RoadFill");
        		NBTTagList half = (NBTTagList)stack.getTagCompound().getTag("RoadFillHalf");
                tooltip.add(Formatter.format("&6Road Fill:")); NBTTagCompound com; String str;
                for(int i = 0; i < fill.tagCount(); i++){
                	com = (NBTTagCompound)fill.get(i);
                	stack0 = com.hasKey("Empty") ? ItemStack.EMPTY : new ItemStack(com);
                    str = Formatter.format("&2-> &7" + stack0.getDisplayName());
                	com = (NBTTagCompound)half.get(i);
                	stack0 = com.hasKey("Empty") ? ItemStack.EMPTY : new ItemStack(com);
                	str += stack0.isEmpty() ? "" : Formatter.format(" &2/ &7" + stack0.getDisplayName());
                	tooltip.add(str);
                }
        	}
        	else{
                tooltip.add(Formatter.format("&6Road Fill: &bSOLID ASPHALT &7x" + stack.getCount()));
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
	
	@SuppressWarnings("deprecation")
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote){ return EnumActionResult.PASS; }
        ItemStack stack = player.getHeldItem(hand);
        if(player.isSneaking() && hand != EnumHand.OFF_HAND){
        	player.openGui(FVTM.getInstance(), GuiHandler.ROADTOOL, world, player.inventory.getSlotFor(stack), 0, 0);
        	return EnumActionResult.SUCCESS;
        }
        if(!player.capabilities.isCreativeMode){
        	Print.chat(player, "&9This is a &6CREATIVE &9mode tool."); return EnumActionResult.FAIL;
        }
        if(!Static.getServer().isSinglePlayer() && !Static.isOp(player)){
        	Print.chat(player, "&cYou need to be OPERATOR to use this item."); return EnumActionResult.FAIL;
        }
        Vec316f vector = new Vec316f(world, new Vec3d(pos.down()).add(hitX, hitY, hitZ), Config.ROAD_PLACING_GRID);
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
			IBlockState top = null, bot = null, righ = null, left = null;
			ArrayList<Vec316f> border_r = null, border_l = null, roof = null, ground = null;
        	ItemStack stack0 = null; int borderheight_l = 0, borderheight_r = 0, topheight = 0;
        	ArrayList<ArrayList<Vec316f>> fill = null;
        	if(stack.getTagCompound().hasKey("BottomFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("BottomFill"));
                bot = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
                ground = new ArrayList<>();
        	}
        	if(stack.getTagCompound().hasKey("TopFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("TopFill"));
                top = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
                roof = new ArrayList<>();
        	}
        	if(stack.getTagCompound().hasKey("SideRFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideRFill"));
                righ = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
                borderheight_r = stack0.getCount(); border_r = new ArrayList<>();
        	}
        	if(stack.getTagCompound().hasKey("SideLFill")){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideLFill"));
                left = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
                borderheight_l = stack0.getCount(); border_l = new ArrayList<>();
        	}
        	topheight = borderheight_l > borderheight_r ? borderheight_l : borderheight_r;
        	ArrayList<IBlockState> blockfill = null, blockhalf = null;
        	if(stack.getTagCompound().hasKey("RoadFill")){
        		fill = new ArrayList<>(); blockfill = new ArrayList<>(); blockhalf = new ArrayList<>();
        		NBTTagList filllist = (NBTTagList)stack.getTagCompound().getTag("RoadFill");
        		NBTTagList halflist = (NBTTagList)stack.getTagCompound().getTag("RoadFillHalf");
        		for(int i = 0; i < filllist.tagCount(); i++){
        			fill.add(new ArrayList<>());
        			stack0 = new ItemStack(filllist.getCompoundTagAt(i));
        			blockfill.add(((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata()));
        			stack0 = new ItemStack(halflist.getCompoundTagAt(i));
        			blockhalf.add(((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata()));
        		}
        	}
			//
			int width = stack.getCount(), height; float angle, passed = 0, half = (width * 0.5f) - 0.5f; Vec3f last, vec;
			ArrayList<Vec316f> path = fill == null ? new ArrayList<>() : null; IBlockState state; BlockPos blk;
			vec = track.getVectorPosition0(0.001f, false); passed = 0;
			angle = (float)Math.atan2(track.vecpath[0].zCoord - vec.zCoord, track.vecpath[0].xCoord - vec.xCoord);
			angle += Static.rad90;
			for(float fl = -half; fl <= half; fl += 0.25f){
				if(path != null) path.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(fl, 0, 0)))));
				if(ground != null) ground.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(fl, -1, 0)))));
				if(roof != null) roof.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(fl, topheight, 0)))));
			}
			if(fill != null){
				for(int i = 0; i < fill.size(); i++){
					fill.get(i).add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(-half + 0.25 + (i * 1), 0, 0)))));
				}
			}
			if(border_l != null) border_l.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(-half - 1, 0, 0)))));
			if(border_r != null) border_r.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(half + 1, 0, 0)))));
			while(passed < track.length){ passed += 0.125f;
				last = vec; vec = track.getVectorPosition0(passed, false);
				angle = (float)Math.atan2(last.zCoord - vec.zCoord, last.xCoord - vec.xCoord);
				angle += Static.rad90;
				for(float fl = -half; fl <= half; fl += 0.25f){
					if(path != null) path.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl, 0, 0)))));
					if(ground != null) ground.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl, -1, 0)))));
					if(roof != null) roof.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl, topheight, 0)))));
				}
				if(fill != null){
					for(int i = 0; i < fill.size(); i++){
						fill.get(i).add(new Vec316f(vec.add(grv(angle, new Vec3f(-half + 0.25 + (i * 1), 0, 0)))));
					}
				}
				if(border_l != null) border_l.add(new Vec316f(vec.add(grv(angle, new Vec3f(-half - 1, 0, 0)))));
				if(border_r != null) border_r.add(new Vec316f(vec.add(grv(angle, new Vec3f(half + 1, 0, 0)))));
			}
			if(path != null){
				for(Vec316f v : path){
					height = v.y; state = world.getBlockState(blk = height != 0 ? v.pos.up() : v.pos);
					if(state.getBlock() != Asphalt.INSTANCE || state.getValue(Asphalt.HEIGHT) < height){
						if(world.getBlockState(blk.up()).getBlock() instanceof Asphalt) height = 0;
						world.setBlockState(blk, Asphalt.INSTANCE.getDefaultState().withProperty(Asphalt.HEIGHT, height));
					}
					if((height < 9 && height != 0) || world.getBlockState(blk.down()).getBlock() instanceof Asphalt){
						world.setBlockState(blk.down(), Asphalt.INSTANCE.getDefaultState().withProperty(Asphalt.HEIGHT, 0));
					}
					int checkheight = topheight == 0 ? 4 : topheight;
					for(int i = 1; i < checkheight; i++){
						if(world.getBlockState(blk.up(i)).isOpaqueCube()){
							world.setBlockState(blk.up(i), Blocks.AIR.getDefaultState());
						}
					}
				}
			}
			if(fill != null){
				IBlockState block = null;
				for(int i = 0; i < fill.size(); i++){
					for(Vec316f v : fill.get(i)){
						height = v.y; state = world.getBlockState(blk = height != 0 ? v.pos.up() : v.pos);
						block = height <= 8 && blockhalf.get(i).getBlock() != Blocks.AIR ? blockhalf.get(i) : blockfill.get(i);
						//
						if(state != block){
							world.setBlockState(blk, block);
						}
						if((height < 9 && height != 0) || world.getBlockState(blk.down()) != blockfill.get(i)){
							world.setBlockState(blk.down(), blockfill.get(i));
						}
						int checkheight = topheight == 0 ? 4 : topheight;
						for(int j = 1; j < checkheight; j++){
							if(world.getBlockState(blk.up(i)).isOpaqueCube()){
								world.setBlockState(blk.up(i), Blocks.AIR.getDefaultState());
							}
						}
					}
				}
			}
			if(border_l != null){
				for(Vec316f v : border_l){
					height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
					for(int i = -1/*1*/; i < borderheight_l + 1; i++){
						//if(i == 1 && height > 8) continue;
						//if(world.getBlockState(blk.up(i)).isOpaqueCube()){
							world.setBlockState(blk.up(i), left);
						//}
					}
				}
			}
			if(border_r != null){
				for(Vec316f v : border_r){
					height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
					for(int i = -1/*1*/; i < borderheight_r + 1; i++){
						//if(i == 1 && height > 8) continue;
						//if(world.getBlockState(blk.up(i)).isOpaqueCube()){
							world.setBlockState(blk.up(i), righ);
						//}
					}
				}
			}
			if(ground != null){
				for(Vec316f v : ground){
					height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
					if(world.getBlockState(blk).getBlock() != Asphalt.INSTANCE){
						world.setBlockState(blk, bot);
					}
				}
			}
			if(roof != null){
				for(Vec316f v : roof){
					height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
					//if(world.getBlockState(blk).isOpaqueCube()){
						world.setBlockState(blk, top);
					//}
				}
			}
			//
			Print.bar(player, "&bRoad placed!");
			stack.getTagCompound().removeTag("fvtm:roadpoints");
			return EnumActionResult.SUCCESS;
		}
    }

	public void placeRoad(EntityPlayer player, World world, ItemStack stack, Vec316f vec, GuiCommandSender sender, boolean boolean1){
		//TODO
	}
	
	public static final Vec3f grv(float rad, Vec3f vec){
        double co = Math.cos(rad), si = Math.sin(rad); return new Vec3f(co * vec.xCoord - si * vec.zCoord, vec.yCoord, si * vec.xCoord + co * vec.zCoord);
	}

	private boolean lastEquals(NBTTagList list, Vec316f vector){
		if(list.isEmpty() || list.tagCount() < 2) return false; return getLastVector(list).equals(vector);
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
