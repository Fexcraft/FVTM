package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.pro.NRailVehicle;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fItem(modid = "fvtm", name = "train_adjuster")
public class TrainAdjuster extends Item implements JunctionGridItem {

	public static TrainAdjuster INSTANCE;

	public TrainAdjuster(){
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		INSTANCE = this;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
		tooltip.add(Formatter.format("&9Rightclick on a &6disconnected &brail vehicle &9to flip direction/facing."));
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		if(entity instanceof NRailVehicle == false) return false;
		RailEntity ent = ((NRailVehicle)entity).vehicle.railent;
		if(!ent.getCompound().isSingular()){
			Print.chatnn(player, "Rail vehicle must be disconnected from other rail vehicles.");
			return false;
		}
		ent.flip();
		return true;
	}

}
