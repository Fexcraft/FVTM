package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.ItemTex;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.rail.TrackPlacer;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.Perms;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.GridV3D;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.ICommandSender;
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

public class RailGaugeItem extends TypeCoreItem<RailGauge> implements JunctionGridItem, ItemTex<RailGauge> {

    public RailGaugeItem(RailGauge core){
		super(core);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.type.getAddon().getFCLRegisterer().addItem(type.getRegistryName().getPath(), this, 0, null);
		if(Static.side().isServer()) return;
        this.setCreativeTab(Resources.getCreativeTab(type));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
        tooltip.add(Formatter.format("&9Width: &7" + type.width() + "mb"));
        if(type.getCompatible().size() > 0){
            tooltip.add(Formatter.format("&9Compatible with:"));
            for(String str : type.getCompatible()){
                tooltip.add(Formatter.format("&7 - " + str));
            }
        }
        tooltip.add(Formatter.format("&9- - - - - - &7-"));
        if(flag.isAdvanced()){
            tooltip.add(Formatter.format("&6Usage:"));
            tooltip.add(Formatter.format("&b- Rightclick twice in the same position to create a Junction."));
            tooltip.add(Formatter.format("&b- Rightclick in sequence between 2 Junctions to create a track."));
            tooltip.add(Formatter.format("&b- Rightclick + Sneak to reset point cache (sequence)."));
            tooltip.add(Formatter.format("&b- Rightclick + Sneak (on empty cache) to open GUI."));
            tooltip.add(Formatter.format("&o&bNote that without zoom (in GUI) only &o&7corner or centered &o&bJunction positions are available."));
        }
        else{
            tooltip.add(Formatter.format("&6Enable advanced tooltips for item usage info."));
        }
        tooltip.add(Formatter.format("&9- - - - - - &7-"));
        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:railpoints")){
        	NBTTagList list = (NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints");
    		for(int k = 0; k < list.tagCount(); k++){
            	tooltip.add(Formatter.format("&9PT" + k + " POS:" + new GridV3D(list.getCompoundTagAt(k)).toString()));
    		}
        }
        else{
        	tooltip.add("No Connection data.");
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || Config.DISABLE_RAILS){ return EnumActionResult.PASS; }
        RailSystem syscap = SystemManager.get(Systems.RAIL, world);
        if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        GridV3D vector = new GridV3D(world, new Vec3d(pos).add(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID);
        if(Config.USE_RAIL_MARKERS){
        	RailPlacingUtil.place(world, player, stack, getType(), syscap, vector);
			return EnumActionResult.SUCCESS;
        }
        if(player.isSneaking()){
        	if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:railpoints")){
    			stack.getTagCompound().removeTag("fvtm:railpoints");
    			Print.chat(player, "&bItem Point(s) Cache reset.");
        	}
        	else{
        		if(Perms.RAIL_PLACER_GUI.has(player)){
        			player.openGui(FVTM.getInstance(), GuiHandler.RAILPLACER, world, getSlotOf(player, stack), 0, 0);
        		}
        	}
			return EnumActionResult.SUCCESS;
		}
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
        return placeTrack(player, world, stack, syscap, vector, player, false);
    }
	
	public EnumActionResult placeTrack(EntityPlayer player, World world, ItemStack stack, RailSystem syscap, GridV3D vector, ICommandSender sender, boolean noblocks){
		Junction junk = syscap.getJunction(vector, true);
		NBTTagList list = stack.getTagCompound().hasKey("fvtm:railpoints") ? (NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints") : new NBTTagList();
		if(junk == null || list.isEmpty()){
			if(list.isEmpty() || !createdJunction(sender, syscap, player, list, vector)){
				list.appendTag(vector.write()); stack.getTagCompound().setTag("fvtm:railpoints", list);
				Print.chatbar(sender, list.tagCount() + (getSuffix(list.tagCount())) + " Point Added!");
				return EnumActionResult.SUCCESS;
			}
			else{ stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.SUCCESS; }
		}
		else{
			if(!junk.tracks.isEmpty() && junk.tracks.size() < 2 && !junk.tracks.get(0).isCompatibleGauge(type)){
				Print.chat(sender, "&9Item Gauge not compatible with the &7Junction's Gauge&9.");
				return EnumActionResult.FAIL;
			}
			if(junk.signal != null){
				Print.chat(sender, "&9Please remove the signal first.");
				stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.FAIL;
			}
			if(junk.tracks.size() >= 4){
				Print.chat(sender, "&9Junction reached track limit (4)\n&c&oPoint cache reset.");
				stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.FAIL;
			}
			Track track = new Track(junk, getVectors(list), vector, type);
			if(track.length > Config.MAX_RAIL_TRACK_LENGTH){
				Print.chat(sender, "&cTrack length exceeds the configured max length.");
				return EnumActionResult.FAIL;
			}
			Junction second = syscap.getJunction(track.start);
			track.blockless = Config.DISABLE_RAIL_BLOCKS || noblocks;
			if(second != null){
				if(!TrackPlacer.set(sender, player, world, null, track).place().blocks(!noblocks).consume().result()) return EnumActionResult.SUCCESS;
				second.addnew(track);
				junk.addnew(track.createOppositeCopy());
				second.checkTrackSectionConsistency();
				Print.chat(sender, "&aTrack Created!");
				stack.getTagCompound().removeTag("fvtm:railpoints");
				/*if(!player.capabilities.isCreativeMode){
					stack.shrink(1);
				}*/
			}
			else Print.chat(sender, "&cNo Junction at starting point found!");
			return EnumActionResult.SUCCESS;
		}
	}

	private boolean createdJunction(ICommandSender sender, RailSystem syscap, EntityPlayer player, NBTTagList list, GridV3D vector){
		if(list.tagCount() != 1) return false; GridV3D vec = getFirstVector(list); if(!vec.equals(vector)) return false;
		syscap.addJunction(vector); Print.chat(sender, "Junction Created!"); return true;
	}

	private String getSuffix(int tagCount){
		if(tagCount < 4) return tagCount == 1 ? "st" : tagCount == 2 ? "nd" : "rd"; else return "th";
	}
	
	@Override
	public GridV3D[] getVectors(ItemStack stack){
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("fvtm:railpoints")) return new GridV3D[0];
		return getVectors((NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints"));
	}

	public GridV3D[] getVectors(NBTTagList list){
		GridV3D[] arr = new GridV3D[list.tagCount()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = new GridV3D(list.getCompoundTagAt(i));
		} return arr;
	}

	private GridV3D getFirstVector(NBTTagList list){
		return new GridV3D(list.getCompoundTagAt(0));
	}

	@Override
	public boolean hasVectors(){
		return true;
	}

	@Override
	public TypeCore<RailGauge> getDataType(){
		return type;
	}

}
