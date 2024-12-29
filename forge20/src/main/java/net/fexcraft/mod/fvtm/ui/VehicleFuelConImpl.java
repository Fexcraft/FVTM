package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleFuelCon;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleFuelConImpl extends VehicleFuelCon {

	private SimpleContainer container;
	private StackWrapper wrapper = StackWrapper.wrap(ItemStack.EMPTY);

	public VehicleFuelConImpl(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		container = new SimpleContainer(1);
	}

	@Override
	public Object getInventory(){
		return container;
	}

	@Override
	public void setInventoryContent(int index, TagCW com){
		container.setItem(index, ItemStack.of(com.local()));
	}

	@Override
	public StackWrapper getInventoryContent(int index){
		wrapper.set(container.getItem(index));
		return wrapper;
	}

	@Override
	public boolean isInventoryEmpty(int at){
		return container.getItem(at).isEmpty();
	}

	@Override
	protected boolean isFuelItem(){
		return container.getItem(0).getItem() instanceof Fuel.FuelItem;
	}

	@Override
	protected Fuel.FuelItem getFuelItem(){
		return (Fuel.FuelItem)container.getItem(0).getItem();
	}

	@Override
	public void onClosed(){
		if(player.entity.isOnClient()) return;
		if(container.getItem(0).isEmpty()) return;
		ServerPlayer player = this.player.entity.local();
		if(player.isAlive() && !player.hasDisconnected()){
			player.getInventory().placeItemBackInInventory(container.getItem(0));
		}
		else player.drop(container.getItem(0), false);
	}

}
