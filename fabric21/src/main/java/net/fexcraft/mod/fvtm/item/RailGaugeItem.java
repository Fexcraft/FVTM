package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagLW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;

import java.util.List;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGaugeItem extends Item implements ContentItem<RailGauge>, JunctionGridItem {

	private RailGauge gauge;

	public RailGaugeItem(Properties prop, RailGauge railgauge){
		super(prop);
		gauge = railgauge;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag){
		tooltip.add(GenericUtils.format("&9Name: &7" + gauge.getName()));
		for(String s : gauge.getDescription()){
			tooltip.add(GenericUtils.format(ContainerInterface.translate(s)));
		}
		tooltip.add(GenericUtils.format("&9Width: &7" + gauge.getWidth()));
		if(gauge.getCompatible().size() > 0){
			tooltip.add(GenericUtils.format("&9Compatible with:"));
			for(String str : gauge.getCompatible()){
				tooltip.add(GenericUtils.format("&7 - " + str));
			}
		}
		tooltip.add(GenericUtils.format("&9- - - - - - &7-"));
		if(flag.isAdvanced()){
			tooltip.add(GenericUtils.format("&6Usage:"));
			tooltip.add(GenericUtils.format("&b- Rightclick twice in the same position to create a Junction."));
			tooltip.add(GenericUtils.format("&b- Rightclick in sequence between 2 Junctions to create a track."));
			tooltip.add(GenericUtils.format("&b- Rightclick + Sneak to reset point cache (sequence)."));
		}
		else{
			tooltip.add(GenericUtils.format("&6Enable advanced tooltips for item usage info."));
		}
		tooltip.add(GenericUtils.format("&9- - - - - - &7-"));
		StackWrapper us = UniStack.getStack(stack);
		if(us.directTag().has("fvtm:railpoints")){
			TagLW list = us.directTag().getList("fvtm:railpoints");
			for(int i = 0; i < list.size(); i++){
				tooltip.add(GenericUtils.format("&9PT" + i + " POS:" + new QV3D(list.getCompound(i), null)));
			}
		}
		else{
			tooltip.add(GenericUtils.format("No Connection data."));
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide || DISABLE_RAILS) return InteractionResult.PASS;
		WorldW world = WrapperHolder.getWorld(context.getLevel());
		RailSystem railsys = SystemManager.get(Systems.RAIL, world);
		if(railsys == null){
			UniEntity.getEntity(context.getPlayer()).send("RailSystem not found on this Level.");
			return InteractionResult.FAIL;
		}
		QV3D vector = new QV3D(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z);
		RailPlacingUtil.place(railsys, UniEntity.getEntity(context.getPlayer()), gauge, vector);
		return InteractionResult.SUCCESS;
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
