package net.fexcraft.mod.fvtm.item;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RailPresetItem extends Item implements ContentItem<RailGauge>, JunctionGridItem {

	private RailGauge gauge;
	private RailGauge.Preset preset;
	private int rotations;

    public RailPresetItem(RailGauge type, RailGauge.Preset set){
		super();
		gauge = type;
		preset = set;
		setHasSubtypes(true);
		setRegistryName(gauge.getID().colon());
		setTranslationKey(gauge.getID().colon());
        if(!EnvInfo.CLIENT) return;
        setCreativeTab((CreativeTabs)FvtmResources.INSTANCE.getCreativeTab(gauge));
    }
    
    public RailPresetItem setSegmentation(int segments){
    	rotations = segments; return this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
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
        tooltip.add(Formatter.format("&9Preset: &7" + preset.name));
        tooltip.add(Formatter.format("&6Segmentation: &a" + (360f / rotations) + "\u00B0 &7/ &e" + rotations + "seg."));
        tooltip.add(Formatter.format("&b&oThis tool creates junctions where missing and places tracks, use with caution."));
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || player.isSneaking() || DISABLE_RAILS){ return EnumActionResult.PASS; }
        RailSystem syscap =SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(world));
        if(syscap == null){ Print.chat(player, "&cWorld Capability not found."); return EnumActionResult.FAIL; }
        ItemStack stack = player.getHeldItem(hand);
        QV3D vector = new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 0);
        Junction start = syscap.getJunction(vector.pos);
        if(start != null && start.tracks.size() >= 4){
        	Print.chat(player, "&7Junction at Start point has reached max allowed connections.");
            return EnumActionResult.FAIL;
        }
        QV3D[] vecs = copyAndRotate(vector, preset.path, player.rotationYaw);
        Junction end = syscap.getJunction(vecs[vecs.length - 1].pos);
        if(end != null && end.tracks.size() >= 4){
        	Print.chat(player, "&7Junction at End point has reached max allowed connections.");
            return EnumActionResult.FAIL;
        }
        if(start == null){
        	syscap.addJunction(vector.copy());
        	start = syscap.getJunction(vector.pos);
        }
        Track track = new Track(start, vecs, gauge).withPreset(gauge.getIDS() + "." + preset.name);
		//if(!TrackPlacer.set(player, player, world, null, track).place().result()) return EnumActionResult.SUCCESS;
        if(end == null){
        	syscap.addJunction(vecs[vecs.length - 1]);
        	end = syscap.getJunction(vecs[vecs.length - 1].pos);
        }
        start.addnew(track);
        end.addnew(track.createOppositeCopy());
        start.checkTrackSectionConsistency();
        end.checkTrackSectionConsistency();
        Print.bar(player, "&7Track of type &e'" + preset.name + "' &7placed!");
        if(!player.capabilities.isCreativeMode) stack.shrink(1);
		return EnumActionResult.SUCCESS;
    }
	
	public QV3D[] copyAndRotate(QV3D pos, QV3D[] path, float yaw){
		QV3D[] vecs = new QV3D[path.length];
		for(int i = 0; i < vecs.length; i++) vecs[i] = path[i];
		float seg = 360f / rotations;
		int con = (int)((((int)yaw + 90f) * rotations) / 360f);
		if(con % seg > seg / 2) con++;
		for(int i = 0; i < vecs.length; i++){
			if(i != 0 && i != vecs.length - 1) vecs[i] = new QV3D(VecUtil.rotByRad(seg * con * Static.rad1, vecs[i].vec).add(pos.vec), 0);
			else vecs[i] = new QV3D(VecUtil.rotByRad(seg * con * Static.rad1, vecs[i].vec).add(pos.vec), 0);
		}
		return vecs;
	}

	@Override
	public QV3D[] getVectors(StackWrapper stack){
		return preset.path;
	}

	@Override
	public boolean hasVectors(){
		return true;
	}

	@Override
	public boolean offsetVectors(){
		return true;
	}

	@Override
	public int getSegments(){
		return rotations;
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
