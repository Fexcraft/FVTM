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
public class VehicleConstructor extends UserInterface {

	public VehicleConstructor(JsonMap map, ContainerInterface container) throws Exception {
		super(map, container);
		//
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		switch(id){
			//
		}
		return false;
	}

}
