package net.fexcraft.mod.fvtm.item;

import java.util.List;
import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.entity.RailTestEntity;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.client.util.ITooltipFlag;
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

//@fItem(modid = "fvtm", name = "railtestent")
public class RailItemTest extends Item {

    public static final RailItemTest INSTANCE = new RailItemTest();

    public RailItemTest(){}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&8&oItem used to spawn test entities."));
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote || player.isSneaking()){ return EnumActionResult.PASS; }
        RailSystem syscap = world.getCapability(Capabilities.RAILSYSTEM, null);
        if(syscap == null){
			Print.chat(player, "&cWorld Capability not found.");
	        return EnumActionResult.FAIL;
        }
        Vec316f vector = new Vec316f(new Vec3d(pos).addVector(hitX, hitY, hitZ));
		Junction junk = syscap.getJunction(vector, true);
		if(junk == null){
			Print.bar(player, "&c&oNo Junction found at this position.");
		}
		else if(junk.tracks.isEmpty()){
			Print.bar(player, "&c&oJunction has no tracks attached.");
		}
		else{
			if(hand == EnumHand.MAIN_HAND){
				RailTestEntity ent = new RailTestEntity(world, junk.tracks.get(0));
				world.spawnEntity(ent); Print.bar(player, "&a&oEntity Spawned!");
			}
			else{
				syscap.registerEntity(new RailEntity((RailData)syscap, junk.tracks.get(0)));
			}
		}
		return EnumActionResult.SUCCESS;
    }

}
