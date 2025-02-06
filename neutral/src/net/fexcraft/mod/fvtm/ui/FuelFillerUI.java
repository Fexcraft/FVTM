package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.FuelFiller;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import static net.fexcraft.mod.uni.ui.ContainerInterface.SEND_TO_SERVER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FuelFillerUI extends UserInterface {

	private FuelFillerCon con;
	private int fuelidx;

	public FuelFillerUI(JsonMap map, ContainerInterface container) throws Exception{
		super(map, container);
		con = (FuelFillerCon)container;
	}

	@Override
	public void init(){
		fuelidx = FvtmRegistry.FUELS.indexOf(con.filler.selected);
		updateSelectedText(true);
	}

	@Override
	public void predraw(float t, int x, int y){
		texts.get("stored").value("ui.fvtm.fuel_filler.stored");
		texts.get("stored").translate(con.filler.tank.amount());
		texts.get("converted").value("ui.fvtm.fuel_filler.converted");
		texts.get("converted").translate(con.filler.converted);
	}

	@Override
	public void drawbackground(float t, int x, int y){
		int a = (int)((float)con.filler.tank.amount() / FuelFiller.tanksize * 100);
		if(a > 0){
			drawer.draw(gLeft + 10, gTop + 49, 0, 219, a, 18);
		}
		a = (int)(con.filler.converted / FuelFiller.tanksize * 100);
		if(a > 0){
			drawer.draw(gLeft + 10, gTop + 83, 0, 238, a, 18);
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		switch(id){
			case "prev":{
				if(--fuelidx < 0) fuelidx = FvtmRegistry.FUELS.size() - 1;
				updateSelectedText(false);
				return true;
			}
			case "next":{
				if(++fuelidx >= FvtmRegistry.FUELS.size()) fuelidx = 0;
				updateSelectedText(false);
				return true;
			}
			case "confirm":{
				TagCW com = TagCW.create();
				com.set("sel", FvtmRegistry.FUELS.get(fuelidx).getIDS());
				SEND_TO_SERVER.accept(com);
				return true;
			}
		}
		return false;
	}

	protected void updateSelectedText(boolean packet){
		texts.get("selected").value(FvtmRegistry.FUELS.get(fuelidx).getName());
		if(packet){
			texts.get("info").value("ui.fvtm.fuel_filler.warning");
			texts.get("info").translate();
		}
		else{
			texts.get("info").value("ui.fvtm.fuel_filler.current");
			texts.get("info").translate(con.filler.selected.getName());
		}
	}

}
