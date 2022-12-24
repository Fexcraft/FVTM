package net.fexcraft.mod.fvtm.item;

import static net.fexcraft.mod.fvtm.util.I19U.trsc;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.mod.fvtm.data.DirectPipe;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fItem(modid = "fvtm", name = "dirpipe")
public class PipeItem extends Item {
	
	public static PipeItem INSTANCE;

    public PipeItem(){
		super();
		INSTANCE = this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(stack.getTagCompound() == null){
        	tooltip.add(trsc("fvtm.pipe.no_data"));
        	return;
        }
    	NBTTagCompound com = stack.getTagCompound();
    	DirectPipe pipe = Resources.DIRPIPES.get(com.getString("Type"));
    	if(pipe == null){
    		tooltip.add("invalid_pipe : " + com.getString("Type"));
    		return;
    	}
        tooltip.add(trsc("fvtm.pipe.pipe", pipe.id));
        tooltip.add(trsc("fvtm.pipe.category", pipe.fluidcategory));
        tooltip.add(trsc("fvtm.pipe.transfer", pipe.transferspeed));
        if(com.hasKey("fvtm:start_point")){
        	BlockPos pos = BlockPos.fromLong(com.getLong("fvtm:start:point"));
        	tooltip.add(trsc("fvtm.pipe.start_point", pos.toString()));
        	NBTTagList poss = (NBTTagList)com.getTag("fvtm:pipepoints");
        	if(poss != null){
        		
        	}
        }
        else{
        	tooltip.add(trsc("fvtm.pipe.no_points"));
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		//
        return EnumActionResult.PASS;
    }

}
