package net.fexcraft.mod.fvtm.item;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.fvtm.Config.MAX_RAIL_TRACK_LENGTH;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.rail.TrackPlacer;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.ICommandSender;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RailGaugeItem extends Item implements ContentItem<RailGauge>, JunctionGridItem{;//}, ItemTex<RailGauge> {

	private RailGauge gauge;

    public RailGaugeItem(RailGauge type){
		super();
		gauge = type;
		setHasSubtypes(true);
		setRegistryName(gauge.getID().colon());
		setTranslationKey(gauge.getID().colon());
        if(!EnvInfo.CLIENT) return;
        setCreativeTab((CreativeTabs)FvtmResources.INSTANCE.getCreativeTab(gauge));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + gauge.getName()));
        for(String s : gauge.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s)));
        }
        tooltip.add(Formatter.format("&9Width: &7" + gauge.getWidth()));
        if(gauge.getCompatible().size() > 0){
            tooltip.add(Formatter.format("&9Compatible with:"));
            for(String str : gauge.getCompatible()){
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
            	tooltip.add(Formatter.format("&9PT" + k + " POS:" + new QV3D(TagCW.wrap(list.getCompoundTagAt(k)), null).toString()));
    		}
        }
        else{
        	tooltip.add("No Connection data.");
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || DISABLE_RAILS){ return EnumActionResult.PASS; }
        RailSystem syscap = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(world));
        if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        QV3D vector = new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0);
		RailPlacingUtil.place(world, player, stack, gauge, syscap, vector);
		return EnumActionResult.SUCCESS;
    }
	
	public EnumActionResult placeTrack(EntityPlayer player, World world, ItemStack stack, RailSystem syscap, QV3D vector, ICommandSender sender, boolean noblocks){
		Junction junk = syscap.getJunction(vector.pos, true);
		NBTTagList list = stack.getTagCompound().hasKey("fvtm:railpoints") ? (NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints") : new NBTTagList();
		if(junk == null || list.isEmpty()){
			if(list.isEmpty() || !createdJunction(sender, syscap, player, list, vector)){
				list.appendTag(vector.write(null, null).local());
				stack.getTagCompound().setTag("fvtm:railpoints", list);
				Print.chatbar(sender, list.tagCount() + (getSuffix(list.tagCount())) + " Point Added!");
				return EnumActionResult.SUCCESS;
			}
			else{ stack.getTagCompound().removeTag("fvtm:railpoints"); return EnumActionResult.SUCCESS; }
		}
		else{
			if(!junk.tracks.isEmpty() && junk.tracks.size() < 2 && !junk.tracks.get(0).isCompatibleGauge(gauge)){
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
			Track track = new Track(junk, getVectors(list), vector, gauge);
			if(track.length > MAX_RAIL_TRACK_LENGTH){
				Print.chat(sender, "&cTrack length exceeds the configured max length.");
				return EnumActionResult.FAIL;
			}
			Junction second = syscap.getJunction(track.start.pos);
			//track.blockless = noblocks;
			if(second != null){
				if(!TrackPlacer.set(sender, player, world, null, track).place()/*.blocks(!noblocks)*/.consume().result()) return EnumActionResult.SUCCESS;
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

	private boolean createdJunction(ICommandSender sender, RailSystem syscap, EntityPlayer player, NBTTagList list, QV3D vector){
		if(list.tagCount() != 1) return false; QV3D vec = getFirstVector(list); if(!vec.equals(vector)) return false;
		syscap.addJunction(vector); Print.chat(sender, "Junction Created!"); return true;
	}

	private String getSuffix(int tagCount){
		if(tagCount < 4) return tagCount == 1 ? "st" : tagCount == 2 ? "nd" : "rd"; else return "th";
	}
	
	@Override
	public QV3D[] getVectors(ItemStack stack){
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("fvtm:railpoints")) return new QV3D[0];
		return getVectors((NBTTagList)stack.getTagCompound().getTag("fvtm:railpoints"));
	}

	public QV3D[] getVectors(NBTTagList list){
		QV3D[] arr = new QV3D[list.tagCount()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = new QV3D(TagCW.wrap(list.getCompoundTagAt(i)), null);
		} return arr;
	}

	private QV3D getFirstVector(NBTTagList list){
		return new QV3D(TagCW.wrap(list.getCompoundTagAt(0)), null);
	}

	@Override
	public boolean hasVectors(){
		return true;
	}

	@Override
	public RailGauge getContent(){
		return gauge;
	}

	@Override
	public ContentType getType(){
		return ContentType.RAILGAUGE;
	}

}
