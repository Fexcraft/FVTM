package net.fexcraft.mod.fvtm.item;

import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;
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
import static net.minecraft.network.chat.Component.translatable;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class JunctionTool extends Item implements JunctionGridItem {

	public JunctionTool(){
		super(new Properties().stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
		StackWrapper wrap = UniStack.getStack(stack);
		if(wrap.hasTag() && wrap.directTag().has("fvtm:junction")){
			tooltip.add(translatable("item.fvtm.junction_tool.selected", new QV3D(wrap.directTag(), "fvtm:junction")));
		}
		else{
			tooltip.add(translatable("item.fvtm.junction_tool.none"));
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide || DISABLE_RAILS) return InteractionResult.PASS;
		WorldW world = WrapperHolder.getWorld(context.getLevel());
		RailSystem railsys = SystemManager.get(SystemManager.Systems.RAIL, world);
		Player player = context.getPlayer();
		Passenger pass = (Passenger)UniEntity.getEntity(player);
		if(railsys == null){
			pass.bar("item.fvtm.junction_tool.nosys");
			return InteractionResult.FAIL;
		}
		QV3D vector = new QV3D(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z), cached;
		StackWrapper stack = UniStack.getStack(player.getItemInHand(context.getHand()));
		if(player.isCrouching()){
			Junction junc = railsys.getJunction(vector.pos);
			if(junc == null){
				pass.bar("item.fvtm.junction_tool.nojunc");
			}
			else if(junc.size() > 0){
				pass.bar("item.fvtm.junction_tool.fulljunc");
			}
			else{
				railsys.delJunction(vector.pos);
				pass.bar("item.fvtm.junction_tool.remjunc");
			}
			return InteractionResult.SUCCESS;
		}
		Junction junk = railsys.getJunction(vector.pos, true);
		if(junk == null){
			pass.bar("item.fvtm.junction_tool.nojunc");
			return InteractionResult.SUCCESS;
		}
		else{
			if(stack.directTag().has("fvtm:junction")){
				cached = new QV3D(stack.directTag(), "fvtm:junction");
				if(cached.equals(vector)){
					pass.openUI(UIKeys.RAIL_JUNCTION, cached.pos.x, cached.pos.y, cached.pos.z);
					return InteractionResult.SUCCESS;
				}
				if(junk.tracks.size() <= 2){
					stack.updateTag(tag -> tag.rem("fvtm:junction"));
					pass.bar("item.fvtm.junction_tool.reset");
				}
			}
			if(junk.tracks.size() < 2){
				pass.openUI(UIKeys.RAIL_JUNCTION, vector.pos.x, vector.pos.y, vector.pos.z);
			}
			else{
				stack.updateTag(tag -> vector.write(tag, "fvtm:junction"));
				pass.bar("item.fvtm.junction_tool.cached");
			}
			return InteractionResult.SUCCESS;
		}
	}

}
