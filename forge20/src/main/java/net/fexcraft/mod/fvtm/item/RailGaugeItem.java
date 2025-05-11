package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.sys.rail.*;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailGaugeItem extends Item implements ContentItem<RailGauge>, JunctionGridItem {

	private RailGauge gauge;

	public RailGaugeItem(RailGauge railgauge){
		super(new Properties());
		gauge = railgauge;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		for(String desc : gauge.getDescription()) tooltip.add(Component.translatable(desc));
		tooltip.add(Component.translatable("item.fvtm.railgauge.width", gauge.getWidth()));
		if(gauge.getCompatible().size() > 0){
			tooltip.add(Component.translatable("item.fvtm.railgauge.compatible"));
			for(String str : gauge.getCompatible()){
				tooltip.add(GenericUtils.format("- " + str));
			}
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide || DISABLE_RAILS) return InteractionResult.PASS;
		WorldW world = WrapperHolder.getWorld(context.getLevel());
		RailSystem railsys = SystemManager.get(Systems.RAIL, world);
		if(railsys == null){
			context.getPlayer().sendSystemMessage(GenericUtils.format("RailSystem not found on this Level."));
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
