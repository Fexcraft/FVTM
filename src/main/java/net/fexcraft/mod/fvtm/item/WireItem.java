package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.generated.BlockBase;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WireItem extends TypeCoreItem<WireType> implements JunctionGridItem {

    public WireItem(WireType core){
		super(core);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.type.getAddon().getFCLRegisterer().addItem(type.getRegistryName().getPath(), this, 0, null);
		if(Static.side().isServer()) return;
        this.setCreativeTab(Resources.getCreativeTab(type));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){
            tooltip.add(Formatter.format(I18n.format(s, new Object[0])));
        }
        tooltip.add(Formatter.format("&9Def. Slack: &7" + type.default_slack()));
        tooltip.add(Formatter.format("&9Customisable: &7" + type.customisable()));
        tooltip.add(Formatter.format("&9- - - - - - &7-"));
        tooltip.add(Formatter.format("&6Usage:"));
        tooltip.add(Formatter.format("&b- Rightclick on a wire supplying block to select connection slot."));
        tooltip.add(Formatter.format("&b- Rightclick 2 blocks in sequence to create a wire. "));
        tooltip.add(Formatter.format("&b- Rightclick + Sneak to reset point cache (sequence)."));
        tooltip.add(Formatter.format("&9- - - - - - &7-"));
        if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:wirepoint")){
        	tooltip.add(Formatter.format("&9Block: &7" + BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:wirepoint"))));
        	tooltip.add(Formatter.format("&9Slot: &7" + BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:wirepoint_slot"))));
        }
        else{
        	tooltip.add("No Connection data.");
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || Config.DISABLE_WIRES) return EnumActionResult.PASS;
        WireSystem system = SystemManager.get(Systems.WIRE, world);
        if(system == null){
			Print.chat(player, "&cWire System not found. Is it enabled?");
	        return EnumActionResult.FAIL;
        }
        ItemStack stack = player.getHeldItem(hand);
        if(player.isSneaking()){
        	if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("fvtm:wirepoint")){
    			stack.getTagCompound().removeTag("fvtm:wirepoint");
    			stack.getTagCompound().removeTag("fvtm:wirepoint_slot");
    			stack.getTagCompound().removeTag("fvtm:wirepoint_vec");
    			Print.chat(player, "&bItem Cache reset.");
        	}
			return EnumActionResult.SUCCESS;
		}
        if(world.getBlockState(pos).getBlock() instanceof BlockBase){
        	BlockTileEntity tile = (BlockTileEntity) world.getTileEntity(pos);
        	if(tile != null && tile.getBlockData().getType().canBeWired()){
        		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
        		player.openGui(FVTM.getInstance(), GuiHandler.WIRE_MAIN, world, pos.getX(), pos.getY(), pos.getZ());
        	}
        	else{
    			Print.chat(player, "&7This block can not be wired.");
        	}
        }
        return EnumActionResult.SUCCESS;
    }
	
	@Override
	public Vec316f[] getVectors(ItemStack stack){
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("fvtm:wirepoints")) return new Vec316f[0];
		return new Vec316f[]{ new Vec316f(stack.getTagCompound().getCompoundTag("fvtm:wirepoint_vec"))};
	}

	@Override
	public boolean hasVectors(){
		return true;
	}

}
