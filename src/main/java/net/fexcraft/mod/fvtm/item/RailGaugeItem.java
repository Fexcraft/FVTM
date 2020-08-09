package net.fexcraft.mod.fvtm.item;

import static net.fexcraft.mod.fvtm.block.RailBlock.HEIGHT;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.RailBlock;
import net.fexcraft.mod.fvtm.block.RailEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
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

public class RailGaugeItem extends TypeCoreItem<RailGauge> implements JunctionGridItem {

    public RailGaugeItem(RailGauge core){
		super(core); this.setHasSubtypes(true); this.setMaxStackSize(1);
        this.type.getAddon().getFCLRegisterer().addItem(
        	type.getRegistryName().getPath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(type.getAddon().getCreativeTab());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s, new Object[0])));
        }
        tooltip.add(Formatter.format("&9Width: &7" + type.width() + "mb"));
        if(type.getCompatible().size() > 0){
            tooltip.add(Formatter.format("&9Compatible with:"));
            for(String str : type.getCompatible()){
                tooltip.add(Formatter.format("&7 - " + str));
            }
        }
        tooltip.add(Formatter.format("&9- - - - - - &7-"));
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
        RailSys syscap = world.getCapability(Capabilities.RAILSYSTEM, null).get();
        if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        Vec316f vector = new Vec316f(new Vec3d(pos).add(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID);
        if(player.isSneaking()){
			stack.getTagCompound().removeTag("fvtm:railpoints");
			Print.chat(player, "&bItem Point(s) Cache reset.");
			return EnumActionResult.SUCCESS;
		}
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		Junction junk = syscap.getJunction(vector, true);
		NBTTagList list = stack.getTagCompound().hasKey("fvtm:railpoints") ? (NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints") : new NBTTagList();
		if(junk == null || list.isEmpty()){
			if(list.isEmpty() || !createdJunction(syscap, player, list, vector)){
				list.appendTag(vector.write()); stack.getTagCompound().setTag("fvtm:railpoints", list);
				Print.bar(player, list.tagCount() + (getSuffix(list.tagCount())) +" Point Added!");
				return EnumActionResult.SUCCESS;
			}
			else{ stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.SUCCESS; }
		}
		else{
			if(!junk.tracks.isEmpty() && junk.tracks.size() < 2 && !junk.tracks.get(0).isCompatibleGauge(type)){
				Print.chat(player, "&9Item Gauge not compatible with the &7Junction's Gauge&9.");
				return EnumActionResult.FAIL;
			}
			if(junk.signal != null){
				Print.chat(player, "&9Please remove the signal first.");
				stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.FAIL;
			}
			if(junk.tracks.size() >= 4){
				Print.chat(player, "&9Junction reached track limit (4)\n&c&oPoint cache reset.");
				stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.FAIL;
			}
			Track track = new Track(junk, getVectors(list), vector, type);
			if(track.length > Config.MAX_RAIL_TRACK_LENGTH){
				Print.chat(player, "&cTrack length exceeds the configured max length.");
				return EnumActionResult.FAIL;
			}
			Junction second = syscap.getJunction(track.start);
			if(second != null){
				if(!validate(player, world, track, junk, second)) return EnumActionResult.SUCCESS;
				second.addnew(track); junk.addnew(track.createOppositeCopy());
				second.checkTrackSectionConsistency();
				Print.chat(player, "&aTrack Created!");
				stack.getTagCompound().removeTag("fvtm:railpoints");
				if(!player.capabilities.isCreativeMode){
					stack.shrink(1);
				}
			}
			else Print.chat(player, "&cNo Junction at starting point found!");
			return EnumActionResult.SUCCESS;
		}
    }

	private boolean validate(EntityPlayer player, World world, Track track, Junction junk, Junction second){
		float width = type.getBlockWidth(), angle, half = (width * 0.5f) - 0.25f;
		Vec3f last, vec;
		ArrayList<Vec316f> path = new ArrayList<>();
		IBlockState state;
		BlockPos blk;
		vec = track.getVectorPosition0(0.001f, false);
		angle = (float)Math.atan2(track.vecpath[0].zCoord - vec.zCoord, track.vecpath[0].xCoord - vec.xCoord);
		angle += Static.rad90;
		/*for(float fl = -half; fl <= half; fl += 0.25f){
			path.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(fl, type.height16(), 0)))));
		}*/
		float passed = 0.125f;
		while(passed < track.length){
			last = vec; vec = track.getVectorPosition0(passed, false);
			angle = (float)Math.atan2(last.zCoord - vec.zCoord, last.xCoord - vec.xCoord);
			angle += Static.rad90;
			for(float fl = -half; fl <= half; fl += 0.25f){
				path.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl, type.height16(), 0)))));
			}
			passed += 0.125f;
		}
		int height;
		for(Vec316f v : path){
			height = v.y;
			state = world.getBlockState(blk = height == 0 ? v.pos.down() : v.pos);
			if(state.getBlock() != RailBlock.INSTANCE && !state.getBlock().isReplaceable(world, blk)){
	            Print.bar(player, String.format("Obstacle at position: %sx, %sy, %sz!", blk.getX(), blk.getY(), blk.getZ()));
	            return false;
			}
		}
		for(Vec316f v : path){
			height = v.y;
			state = world.getBlockState(blk = height == 0 ? v.pos.down() : v.pos);
			if(state.getBlock() != RailBlock.INSTANCE || state.getValue(HEIGHT) < height){
				//if(world.getBlockState(blk.up()).getBlock() instanceof RailBlock) height = 0;
				world.setBlockState(blk, RailBlock.INSTANCE.getDefaultState().withProperty(HEIGHT, height));
			}
			RailEntity tile = (RailEntity)world.getTileEntity(blk);
			tile.addTrack(track);
			state = world.getBlockState(blk.down());
			if(state.getBlock() instanceof RailBlock && state.getValue(HEIGHT) > 0){
				world.setBlockState(blk.down(), RailBlock.INSTANCE.getDefaultState().withProperty(HEIGHT, 0));
			}
			/*int checkheight = 1;
			for(int i = 1; i < checkheight; i++){
				if(world.getBlockState(blk.up(i)).isOpaqueCube()){
					world.setBlockState(blk.up(i), Blocks.AIR.getDefaultState());
				}
			}*/
		}
		return true;
	}
	
	public static final Vec3f grv(float rad, Vec3f vec){
        double co = Math.cos(rad), si = Math.sin(rad);
        return new Vec3f(co * vec.xCoord - si * vec.zCoord, vec.yCoord, si * vec.xCoord + co * vec.zCoord);
	}

	private boolean createdJunction(RailSys syscap, EntityPlayer player, NBTTagList list, Vec316f vector){
		if(list.tagCount() != 1) return false; Vec316f vec = getFirstVector(list); if(!vec.equals(vector)) return false;
		syscap.addJunction(vector); Print.chat(player, "Junction Created!"); return true;
	}

	private String getSuffix(int tagCount){
		if(tagCount < 4) return tagCount == 1 ? "st" : tagCount == 2 ? "nd" : "rd"; else return "th";
	}
	
	@Override
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

	@Override
	public boolean hasVectors(){
		return true;
	}

}
