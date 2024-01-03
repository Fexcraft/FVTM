package net.fexcraft.mod.fvtm.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxItem extends Item {

    public static ToolboxItem INSTANCE;

    public ToolboxItem(){
        super();
        INSTANCE = this;
        setMaxStackSize(1);
        setRegistryName("fvtm:toolbox");
        setTranslationKey("fvtm:toolbox");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        //
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

}
