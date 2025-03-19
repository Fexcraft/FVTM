package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;

import java.util.List;

import static net.fexcraft.mod.fvtm.Config.DISABLE_WIRES;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireItem extends Item implements ContentItem<WireType> {

	private WireType wire;
	private StackWrapper wrapper = StackWrapper.EMPTY;

	public WireItem(Properties prop, WireType wire){
		super(prop.stacksTo(1));
		this.wire = wire;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag){
		/*tooltip.add(GenericUtils.format("&9Name: &7" + wire.getName()));
		for(String s : wire.getDescription())
			tooltip.add(GenericUtils.format(I18n.get(s)));
		tooltip.add(GenericUtils.format("&9Def. Slack: &7" + wire.getDefaultSlack()));
		tooltip.add(GenericUtils.format("&9Customisable: &7" + wire.isCustomisable()));
		tooltip.add(GenericUtils.format("&9- &6- &9- - - - &6-"));
		if(stack.hasTag() && stack.getTag().contains("fvtm:wirepoint")){
			tooltip.add(GenericUtils.format("&9Block: &7" + stack.getTag().getIntArray("fvtm:wirepoint")));
			tooltip.add(GenericUtils.format("&9Relay: &7" + stack.getTag().getString("fvtm:wirepoint_key")));
		}
		else{
			tooltip.add(Component.literal("No Connection data."));
		}
		tooltip.add(GenericUtils.format("&9- &6- &9- - - - &6-"));
		tooltip.add(GenericUtils.format("&6Usage:"));
		tooltip.add(GenericUtils.format("&b- Rightclick on a relay to select."));
		tooltip.add(GenericUtils.format("&b- Rightclick 2 relays in sequence to create a wire. "));
		tooltip.add(GenericUtils.format("&b- Rightclick + Sneak to reset point cache (sequence)."));*/
	}

	@Override
	public WireType getContent(){
		return wire;
	}

	@Override
	public ContentType getType(){
		return ContentType.WIRE;
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide || DISABLE_WIRES || context.getHand() != InteractionHand.MAIN_HAND) return InteractionResult.PASS;
		WireSystem system = SystemManager.get(SystemManager.Systems.WIRE, WrapperHolder.getWorld(context.getLevel()));
		EntityW player = UniEntity.getEntity(context.getPlayer());
		if(system == null){
			player.send("&cWire System not found. Is it enabled?");
			return InteractionResult.FAIL;
		}
		ItemStack stack = context.getPlayer().getMainHandItem();
		/*if(player.isShiftDown()){
			if(stack.getTag() != null && stack.getTag().contains("fvtm:wirepoint")){
				stack.getTag().remove("fvtm:wirepoint");
				stack.getTag().remove("fvtm:wirepoint_key");
				UniEntity.getEntity(player).send("interact.fvtm.relay.cache_reset");
			}
			return InteractionResult.SUCCESS;
		}*/
		return InteractionResult.SUCCESS;
	}

}