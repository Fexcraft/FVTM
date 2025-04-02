package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.data.ToolboxType;
import net.fexcraft.mod.fvtm.sys.sign.SignInstance;
import net.fexcraft.mod.fvtm.sys.sign.SignSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxItem extends Item {

	public final int var;

	public ToolboxItem(Properties prop, int var){
		super(prop.stacksTo(1));
		this.var = var;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext ctx, List<Component> tooltip, TooltipFlag flag){
		switch(var){
			case 0:{
				tooltip.add(Component.literal("Part Removal and Maintenance Toolbox"));
				break;
			}
			case 1:{
				tooltip.add(Component.literal("Livery/Texture Management Toolbox"));
				break;
			}
			case 2:{
				tooltip.add(Component.literal("Color Channel Painting Toolbox"));
				break;
			}
			case 3:{
				tooltip.add(Component.literal("Wire removal Toolbox"));
				break;
			}
			case 4:{
				tooltip.add(Component.literal("Wire Slack Adjustment Toolbox"));
				break;
			}
			case 5:{
				tooltip.add(Component.literal("Sign Adjustment and Removal Toolbox"));
				break;
			}
		}
	}

	public static int getToolboxType(ItemStack stack){
		return ((ToolboxItem)stack.getItem()).var;
	}

	public static int getToolboxType(StackWrapper stack){
		return ((ToolboxItem)stack.getItem().local()).var;
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide) return InteractionResult.PASS;
		ItemStack stack = context.getItemInHand();
		var type = ((ToolboxItem)stack.getItem()).var;
		if(type != ToolboxType.SIGN_ADJREM.idx || context.getPlayer().isShiftKeyDown()) return InteractionResult.PASS;
		EntityW ply = UniEntity.getEntity(context.getPlayer());
		QV3D vec = new QV3D(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z);
		SignSystem system = SystemManager.get(SystemManager.Systems.SIGN, ply.getWorld());
		if(system == null){
			ply.send("sign system not found");
			return InteractionResult.FAIL;
		}
		SignInstance inst = system.get(vec.pos);
		if(inst == null){
			inst = system.add(vec.pos);
			inst.vec = vec;
			inst.yaw = -context.getHorizontalDirection().toYRot() + 90;
			inst.yaw *= Static.rad1;
			inst.updateClient();
		}
		return InteractionResult.SUCCESS;
	}

}
