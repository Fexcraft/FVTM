package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerUI extends UserInterface {

	private FuelFillerCon con;

	public FuelFillerUI(JsonMap map, ContainerInterface container) throws Exception{
		super(map, container);
		con = (FuelFillerCon)container;
	}

	@Override
	public void init(){
		texts.get("selected").value(con.filler.selected.getName());
		texts.get("info").value("ui.fvtm.fuel_filler.warning");
		texts.get("info").translate();
	}

	@Override
	public void predraw(float t, int x, int y){
		texts.get("stored").value("ui.fvtm.fuel_filler.stored");
		texts.get("stored").translate(con.filler.stored);
		texts.get("converted").value("ui.fvtm.fuel_filler.converted");
		texts.get("converted").translate(con.filler.converted);
	}

}
