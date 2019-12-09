package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RailPresetItem extends TypeCoreItem<RailGauge> implements JunctionGridItem {
	
	private Vec316f[] path;
	private String title;
	private int rotations;

    public RailPresetItem(RailGauge core, String name, Vec316f[] vecs){
		super(core); this.setHasSubtypes(true); this.setMaxStackSize(1);
        this.type.getAddon().getFCLRegisterer().addItem(
        	type.getRegistryName().getResourcePath() + "." + (title = name), this, 0, null);
        path = vecs; if(Static.side().isServer()) return;
        this.setCreativeTab(type.getAddon().getCreativeTab());
    }
    
    public RailPresetItem setSegmentation(int segments){
    	rotations = segments; return this;
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
        tooltip.add(Formatter.format("&9Preset: &7" + title));
        tooltip.add(Formatter.format("&6Segmentation: &a" + (360f / rotations) + "\u00B0 &7/ &e" + rotations + "seg."));
        tooltip.add(Formatter.format("&b&oThis tool creates junctions where missing and places tracks, use with caution."));
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || player.isSneaking()){ return EnumActionResult.PASS; }
        RailSystem syscap = world.getCapability(Capabilities.RAILSYSTEM, null);
        if(syscap == null){ Print.chat(player, "&cWorld Capability not found."); return EnumActionResult.FAIL; }
        //ItemStack stack = player.getHeldItem(hand);
        //Vec316f vector = new Vec316f(new Vec3d(pos).addVector(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID);
        //TODO
		return EnumActionResult.SUCCESS;
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
