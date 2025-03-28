package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.vehicle.CatalogPreset;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleCatalogCon extends ContainerInterface {

	public VehicleCatalogCon(JsonMap map, UniEntity ply, V3I pos){
		super(map, ply, pos);
	}

	@Override
	public void packet(TagCW com, boolean client){
		if(client) return;
		try{
			Vehicle veh = FvtmRegistry.VEHICLES.get(com.getString("veh"));
			CatalogPreset preset = veh.getCatalogEntry(com.getString("rec"));
			if(player.entity.isCreative() || canCraft(parseStacks(preset))){
				if(!player.entity.isCreative()) doCraft(parseStacks(preset));
				player.entity.addStack(preset.getVehicleData().newItemStack());
				player.entity.send("ui.fvtm.vehicle_catalog.craft_success");
				player.entity.closeUI();
			}
		}
		catch(Exception e){
			player.entity.send("error, see log for details");
			e.printStackTrace();
		}
	}

	public static ArrayList parseStacks(CatalogPreset preset){
		ArrayList<StackWrapper> stacks = new ArrayList();
		for(Map.Entry<String, Integer> entry : preset.recipe.entrySet()){
			StackWrapper stack = FvtmResources.newStack(FvtmRegistry.getItem(entry.getKey()));
			stack.count(entry.getValue());
			stacks.add(stack);
		}
		return stacks;
	}

	private boolean canCraft(ArrayList<StackWrapper> stacks){
		for(StackWrapper stack : stacks){
			if(stack.empty()){
				player.entity.send("ui.fvtm.vehicle_catalog.craft_invalid");
				return false;
			}
		}
		ArrayList<StackWrapper> copy = new ArrayList<>();
		for(int idx = 0; idx < player.entity.getInventorySize(); idx++){
			StackWrapper wrp = player.entity.getStackAt(idx);
			if(!wrp.empty()) copy.add(wrp.copy());
		}
		for(StackWrapper stack : stacks){
			int am = stack.count();
			if(consume(copy, stack, am) < am){
				player.entity.send("ui.fvtm.vehicle_catalog.craft_not_enough", stack.getName());
				return false;
			}
		}
		stacks.removeIf(StackWrapper::empty);
		return true;
	}

	private int consume(ArrayList<StackWrapper> copy, StackWrapper stack, int am){
		int cons = 0;
		for(StackWrapper wrp : copy){
			if(wrp.equals(stack)){
				cons += wrp.count();
				wrp.count(wrp.count() - am);
				if(cons >= am) break;
			}
		}
		copy.removeIf(StackWrapper::empty);
		return cons;
	}

	private void doCraft(ArrayList<StackWrapper> stacks){
		ArrayList<StackWrapper> copy = new ArrayList<>();
		for(int idx = 0; idx < player.entity.getInventorySize(); idx++){
			StackWrapper wrp = player.entity.getStackAt(idx);
			if(!wrp.empty()) copy.add(wrp);
		}
		for(StackWrapper stack : stacks){
			if(stack.empty()) continue;
			consume(copy, stack, stack.count());
		}
	}

}
