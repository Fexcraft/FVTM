package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.cmds.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.signals.SignalType;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fItem(modid = "fvtm", name = "simple_signal")
public class SignalItem0 extends Item implements JunctionGridItem {

    public static SignalItem0 INSTANCE;
    private static float[][] gridcolour;
    static {
    	RGB cyan = new RGB(java.awt.Color.CYAN.getRGB()); gridcolour = new float[][]{ cyan.toFloatArray(), cyan.toFloatArray() };
    }

	public SignalItem0(){
		this.setHasSubtypes(true); this.setMaxStackSize(1); INSTANCE = this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&9Rightclick on a Junction to apply."));
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
		if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
		Junction junction = syscap.getJunction(vector, true);
		if(junction == null){ return EnumActionResult.PASS; }
        if(player.isSneaking()){
        	junction.setSignal(null, null); Print.chat(player, "&bJunction Signal &creset&b.");
			return EnumActionResult.SUCCESS;
		}
        if(junction.signal != null){
        	if(junction.signal.type == SignalType.Kind.BLOCK){ byte b = 0;
        		if(junction.signal.oneway && junction.signal_dir == EntryDirection.FORWARD){
        			junction.setSignal(SignalType.ONE_WAY_BLOCK, EntryDirection.BACKWARD); b = 0;
        		}
        		else if(junction.signal.oneway && junction.signal_dir == EntryDirection.BACKWARD){
        			junction.setSignal(SignalType.TWO_WAY_BLOCK, EntryDirection.BOTH); b = -1;
        		}
        		else if(!junction.signal.oneway){
        			junction.setSignal(SignalType.ONE_WAY_BLOCK, EntryDirection.FORWARD); b = 1;
        		}
        		else{
        			Print.chat(player, "A strange error happened, see location in log.");
        			Static.exception(null, false);
        		}
        		Print.chat(player, "&bJunction Signal &aupdated&b. [" + b + "]");
    	        return EnumActionResult.SUCCESS;
        	}
        	else{
            	Print.chat(player, "&cThis Junction has already a Signal.");
    			return EnumActionResult.FAIL;
        	}
        }
        if(junction.size() != 2){
        	Print.chat(player, "&cOnly Junctions with 2 Tracks can have Signals.");
			return EnumActionResult.FAIL;
        }
		junction.setSignal(SignalType.TWO_WAY_BLOCK, EntryDirection.BOTH); Print.chat(player, "&bJunction Signal &7set&b.");
        return EnumActionResult.SUCCESS;
    }
	
	@Override
	public float[][] getGridColours(){
		return gridcolour;
	}

}
