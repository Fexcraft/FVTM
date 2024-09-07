package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.vehicle.CatalogPreset;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleCatalog extends UserInterface {

	protected ArrayList<Addon> vehpacks = new ArrayList<>();
	protected HashMap<Addon, ArrayList<Vehicle>> vehicles = new LinkedHashMap<>();
	protected ArrayList<StackWrapper> stacks = new ArrayList<>();
	protected CatalogPreset preset;
	protected VehicleData data;
	protected Vehicle veh;
	protected int pack;
	protected int vehicle;
	protected int recipe;

	public VehicleCatalog(JsonMap map, ContainerInterface container) throws Exception{
		super(map, container);
		for(Vehicle veh : FvtmRegistry.VEHICLES){
			if(veh.getCatalog().isEmpty()) continue;
			if(!vehpacks.contains(veh.getAddon())){
				vehpacks.add(veh.getAddon());
				vehicles.put(veh.getAddon(), new ArrayList<>());
			}
			vehicles.get(veh.getAddon()).add(veh);
		}
		switchPack(0);
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		switch(id){
			case "pack_prev":{
				switchPack(-1);
				return true;
			}
			case "pack_next":{
				switchPack(1);
				return true;
			}
			case "veh_prev":{
				switchVehicle(-1);
				return true;
			}
			case "veh_next":{
				switchVehicle(1);
				return true;
			}
			case "var_prev":{
				switchRecipe(-1);
				return true;
			}
			case "var_next":{
				switchRecipe(1);
				return true;
			}
		}
		return false;
	}

	private void switchPack(int i){
		pack += i;
		if(pack >= vehpacks.size()) pack = 0;
		if(pack < 0) pack = vehpacks.size() - 1;
		texts.get("pack").value(vehpacks.get(pack).getName());
		switchVehicle(0);
	}

	private void switchVehicle(int i){
		vehicle += i;
		ArrayList<Vehicle> vehs = vehicles.get(vehpacks.get(pack));
		if(vehicle >= vehs.size()) vehicle = 0;
		if(vehicle < 0) vehicle = vehs.size() - 1;
		veh = vehs.get(vehicle);
		texts.get("vehicle").value(veh.getName());
		switchRecipe(0);
	}

	private void switchRecipe(int i){
		recipe += i;
		if(recipe >= veh.getCatalog().size()) recipe = 0;
		if(recipe < 0) recipe = veh.getCatalog().size() - 1;
		preset = veh.getCatalog().get(recipe);
		data = preset.getVehicleData();
		texts.get("desc0").value(preset.name);
		texts.get("desc1").value(preset.getDesc(0));
		texts.get("desc2").value(preset.getDesc(1));
		if(preset.desc.isEmpty()) texts.get("desc1").translate();
		texts.get("variant").value("ui.fvtm.vehicle_catalog.variant");
		texts.get("variant").translate(recipe + 1, veh.getCatalog().size());
		stacks.clear();
		for(String str : preset.recipe){
			stacks.add(FvtmResources.newStack(FvtmRegistry.getItem(str)));
		}
	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		if(stacks.size() == 0) return;
		for(int x = 0; x < 5; x++){
			for(int y = 0; y < 4; y++){
				int z = x + (y * 5);
				if(z >= stacks.size()) break;
				drawer.draw(gLeft + 146 + (x * 18), gTop + 25 + (y * 18) , stacks.get(z));
			}
		}
	}

}
