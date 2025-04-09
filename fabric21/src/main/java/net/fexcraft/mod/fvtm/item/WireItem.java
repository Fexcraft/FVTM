package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.ContentItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;

import java.util.List;
import java.util.function.Consumer;

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
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay disp, Consumer<Component> cons, TooltipFlag flag){
		cons.accept(GenericUtils.format("&9Name: &7" + wire.getName()));
		for(String s : wire.getDescription())
			cons.accept(GenericUtils.format(I18n.get(s)));
		cons.accept(GenericUtils.format("&9Def. Slack: &7" + wire.getDefaultSlack()));
		cons.accept(GenericUtils.format("&9Customisable: &7" + wire.isCustomisable()));
		cons.accept(GenericUtils.format("&9- &6- &9- - - - &6-"));
		TagCW com = UniStack.getStack(stack).directTag();
		if(com.has("fvtm:wirepoint")){
			cons.accept(GenericUtils.format("&9Block: &7" + com.getIntArray("fvtm:wirepoint")));
			cons.accept(GenericUtils.format("&9Relay: &7" + com.getString("fvtm:wirepoint_key")));
		}
		else{
			cons.accept(Component.literal("No Connection data."));
		}
		cons.accept(GenericUtils.format("&9- &6- &9- - - - &6-"));
		cons.accept(GenericUtils.format("&6Usage:"));
		cons.accept(GenericUtils.format("&b- Rightclick on a relay to select."));
		cons.accept(GenericUtils.format("&b- Rightclick 2 relays in sequence to create a wire. "));
		cons.accept(GenericUtils.format("&b- Rightclick + Sneak to reset point cache (sequence)."));
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
		if(player.isShiftDown()){
			StackWrapper sw = UniStack.getStack(stack);
			if(sw.directTag().has("fvtm:wirepoint")){
				sw.updateTag(com -> {
					com.rem("fvtm:wirepoint");
					com.rem("fvtm:wirepoint_key");
				});
				UniEntity.getEntity(player).send("interact.fvtm.relay.cache_reset");
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.SUCCESS;
	}

}