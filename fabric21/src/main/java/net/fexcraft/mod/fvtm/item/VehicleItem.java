package net.fexcraft.mod.fvtm.item;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.ContentItem.ContentDataItem;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable.TextureableItem;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.function.part.TransmissionFunction;
import net.fexcraft.mod.fvtm.util.GenericUtils;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleItem extends Item implements ContentDataItem<Vehicle, VehicleData>, TextureableItem<Vehicle>, JunctionGridItem {

	private Vehicle vehicle;

	public VehicleItem(Properties prop, Vehicle content){
		super(prop.stacksTo(1));
		vehicle = content;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay disp, Consumer<Component> cons, TooltipFlag flag){
		cons.accept(GenericUtils.format("&9Name: &7" + vehicle.getName()));
		for(String s : vehicle.getDescription()){
			cons.accept(GenericUtils.format(I18n.get(s)));
		}
		StackWrapper wrapper = UniStack.getStack(stack);
		if(wrapper == null) return;
		VehicleData data = wrapper.getContent(ContentType.VEHICLE.item_type);
		if(data == null) return;
		cons.accept(GenericUtils.format("&9Texture: &7" + getTexTitle(data)));
		if(data.hasPart("engine")){
			cons.accept(GenericUtils.format("&9Engine: &7" + data.getPart("engine").getType().getName()));
			cons.accept(GenericUtils.format("&9Fuel Group: &7" + data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").getFuelGroup()[0]));
			cons.accept(GenericUtils.format("&9Fuel Stored: &7" + data.getAttribute("fuel_stored").asInteger() + "mB"));
		}
		if(data.hasPart("transmission")){
			TransmissionFunction func = data.getFunctionInPart("transmission", "fvtm:transmission");
			cons.accept(GenericUtils.format("&9Transmission: &7" + (func == null ? "disfunctional" : func.isAutomatic() ? "automatic" : "manual")));
		}
		cons.accept(GenericUtils.format("&9Weight: &7" + data.getAttribute("weight").asFloat() + "kg"));
		cons.accept(GenericUtils.format("&9Seats: &7" + data.getSeats().size()));
		cons.accept(GenericUtils.format("&9LockCode: &7" + data.getLock().getCode()));
		if(vehicle.getModel() != null && vehicle.getModel().getCreators().size() > 0){
			cons.accept(GenericUtils.format("&9Model by:"));
			for(String str : vehicle.getModel().getCreators()){
				cons.accept(GenericUtils.format("&7- " + str));
			}
		}
		//TODO other data
	}

	protected static String getTexTitle(Textureable.TextureUser data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getTexHolder().getDefaultTextures().get(data.getSelectedTexture()).name();
		}
		else return data.isTextureExternal() ? "external" : "internal";
	}

	@Override
	public VehicleData getData(StackWrapper stack){
		return getData(stack.directTag());
	}

	@Override
	public VehicleData getData(TagCW compound){
		return new VehicleData(vehicle).read(compound);
	}

	@Override
	public InteractionResult useOn(UseOnContext context){
		if(context.getLevel().isClientSide) return InteractionResult.PASS;
		StackWrapper stack = UniStack.getStack(context.getItemInHand());
		VehicleData data = stack.getContent(ContentType.VEHICLE.item_type);
		if(data.getType().isTrailer() && !data.getType().getVehicleType().isRailVehicle() && !context.getPlayer().isCrouching()) return InteractionResult.PASS;
		EntityW ent = UniEntity.getEntity(context.getPlayer());
		EntitySystem.spawnVehicle(ent, ent.getWorld(), new V3D(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z), data, UniStack.getStack(stack));
		return InteractionResult.SUCCESS;
	}

	@Override
	public Vehicle getContent(){
		return vehicle;
	}

	@Override
	public ContentType getType(){
		return ContentType.VEHICLE;
	}

	@Override
	public boolean showJunctionGrid(){
		return vehicle.getVehicleType().isRailVehicle();
	}

}
