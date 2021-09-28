package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.rail.TrackPlacer;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RailPresetItem extends TypeCoreItem<RailGauge> implements JunctionGridItem {
	
	private Vec316f[] path;
	private String title;
	private int rotations;

    public RailPresetItem(RailGauge core, String name, Vec316f... vecs){
		super(core);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.type.getAddon().getFCLRegisterer().addItem(type.getRegistryName().getPath() + "." + (title = name), this, 0, null);
		path = vecs; if(Static.side().isServer()) return;
        this.setCreativeTab(Resources.getCreativeTab(type));
    }
    
    public RailPresetItem setSegmentation(int segments){
    	rotations = segments; return this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
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
        tooltip.add(Formatter.format("&9Preset: &7" + title));
        tooltip.add(Formatter.format("&6Segmentation: &a" + (360f / rotations) + "\u00B0 &7/ &e" + rotations + "seg."));
        tooltip.add(Formatter.format("&b&oThis tool creates junctions where missing and places tracks, use with caution."));
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || player.isSneaking() || Config.DISABLE_RAILS){ return EnumActionResult.PASS; }
        RailSystem syscap =SystemManager.get(Systems.RAIL, world);
        if(syscap == null){ Print.chat(player, "&cWorld Capability not found."); return EnumActionResult.FAIL; }
        ItemStack stack = player.getHeldItem(hand);
        Vec316f vector = new Vec316f(world, new Vec3d(pos).add(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID);
        Junction start = syscap.getJunction(vector);
        if(start != null && start.tracks.size() >= 4){
        	Print.chat(player, "&7Junction at Start point has reached max allowed connections.");
            return EnumActionResult.FAIL;
        }
        Vec316f[] vecs = copyAndRotate(vector, path, player.rotationYaw);
        Junction end = syscap.getJunction(vecs[vecs.length - 1]);
        if(end != null && end.tracks.size() >= 4){
        	Print.chat(player, "&7Junction at End point has reached max allowed connections.");
            return EnumActionResult.FAIL;
        }
        if(start == null){
        	syscap.addJunction(vector.copy());
        	start = syscap.getJunction(vector);
        }
        Track track = new Track(start, vecs, type).withPreset(type.getRegistryName() + "." + title);
		if(!TrackPlacer.set(player, player, world, null, track).place().result()) return EnumActionResult.SUCCESS;
        if(end == null){
        	syscap.addJunction(vecs[vecs.length - 1]);
        	end = syscap.getJunction(vecs[vecs.length - 1]);
        }
        start.addnew(track);
        end.addnew(track.createOppositeCopy());
        start.checkTrackSectionConsistency();
        end.checkTrackSectionConsistency();
        Print.bar(player, "&7Track of type &e'" + title + "' &7placed!");
        if(!player.capabilities.isCreativeMode) stack.shrink(1);
		return EnumActionResult.SUCCESS;
    }
	
	public Vec316f[] copyAndRotate(Vec316f pos, Vec316f[] path, float yaw){
		Vec316f[] vecs = new Vec316f[path.length];
		for(int i = 0; i < vecs.length; i++) vecs[i] = path[i];
		float seg = 360f / rotations;
		int con = (int)((((int)yaw + 90f) * rotations) / 360f);
		if(con % seg > seg / 2) con++;
		for(int i = 0; i < vecs.length; i++){
			if(i != 0 && i != vecs.length - 1) vecs[i] = new Vec316f(VecUtil.rotByRad(seg * con * Static.rad1, vecs[i].vector).add(pos.vector));
			else vecs[i] = new Vec316f(VecUtil.rotByRad(seg * con * Static.rad1, vecs[i].vector).add(pos.vector), Config.RAIL_PLACING_GRID);
		} return vecs;
	}

	@Override
	public Vec316f[] getVectors(ItemStack stack){
		return path;
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

}
