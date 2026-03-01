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
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;

import java.util.function.Consumer;

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
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay disp, Consumer<Component> cons, TooltipFlag flag){
		for(String desc : gauge.getDescription()) cons.accept(Component.translatable(desc));
		cons.accept(Component.translatable("item.fvtm.railgauge.width", gauge.getWidth()));
		if(gauge.getCompatible().size() > 0){
			cons.accept(Component.translatable("item.fvtm.railgauge.compatible"));
			for(String str : gauge.getCompatible()){
				cons.accept(GenericUtils.format("- " + str));
			}
		}
		if(gauge.getMaterials().size() > 0){
			cons.accept(Component.translatable("item.fvtm.railgauge.materials"));
			for(RailGauge.UseMat mat : gauge.getMaterials()){
				cons.accept(GenericUtils.format("- " + (mat.tag ? "#" : "")+ mat.id + " x" + mat.amount));
			}
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide) return InteractionResult.PASS;
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
