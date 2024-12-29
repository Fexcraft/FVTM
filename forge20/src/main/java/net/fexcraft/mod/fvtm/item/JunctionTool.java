package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;
import static net.fexcraft.mod.uni.ui.ContainerInterface.translate;
import static net.minecraft.network.chat.Component.literal;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JunctionTool extends Item {

	public JunctionTool(){
		super(new Properties().stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		tooltip.add(literal(translate("&9Junction Editing Toolbox")));
		tooltip.add(literal(translate("&9- - - - - - &7-")));
		if(stack.getTag() != null && stack.getTag().contains("fvtm:junction")){
			tooltip.add(literal(translate("&9Junction Selected: &7" + new QV3D(TagCW.wrap(stack.getTag()), "fvtm:junction"))));
		}
		else{
			tooltip.add(literal("No Junction Position Cached."));
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide || DISABLE_RAILS) return InteractionResult.PASS;
		WorldW world = WrapperHolder.getWorld(context.getLevel());
		RailSystem railsys = SystemManager.get(SystemManager.Systems.RAIL, world);
		if(railsys == null){
			context.getPlayer().sendSystemMessage(GenericUtils.format("RailSystem not found on this Level."));
			return InteractionResult.FAIL;
		}
		QV3D vector = new QV3D(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z), cached;
		Player player = context.getPlayer();
		Passenger pass = (Passenger)UniEntity.getEntity(player);
		ItemStack stack = player.getItemInHand(context.getHand());
		if(player.isCrouching()){
			Junction junc = railsys.getJunction(vector.pos);
			if(junc == null){
				pass.bar("&cNo junction at position.");
			}
			else if(junc.size() > 0){
				pass.bar("&cDisconnect all tracks before removing a Junction.");
			}
			else{
				railsys.delJunction(vector.pos);
				pass.bar("&c&oRemoving Junction...");
			}
			return InteractionResult.SUCCESS;
		}
		if(stack.getTag() == null) stack.setTag(new CompoundTag());
		Junction junk = railsys.getJunction(vector.pos, true);
		if(junk == null){
			pass.bar("&cNo Junction at this Position.");
			return InteractionResult.SUCCESS;
		}
		else{
			if(stack.getTag().contains("fvtm:junction")){
				cached = new QV3D(TagCW.wrap(stack.getTag()), "fvtm:junction");
				if(cached.equals(vector)){
					pass.openUI(UIKeys.RAIL_JUNCTION, cached.pos.x, cached.pos.y, cached.pos.z);
					return InteractionResult.SUCCESS;
				}
				if(junk.tracks.size() <= 2){
					stack.getTag().remove("fvtm:junction");
					pass.bar("&7&oResetting previous Cached Position.");
				}
			}
			if(junk.tracks.size() < 2){
				pass.openUI(UIKeys.RAIL_JUNCTION, vector.pos.x, vector.pos.y, vector.pos.z);
			}
			else{
				vector.write(TagCW.wrap(stack.getTag()), "fvtm:junction");
				pass.bar("&a&lJunction Position Cached.");
			}
			return InteractionResult.SUCCESS;
		}
	}

}
