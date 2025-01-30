package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleInventories extends UserInterface {

	private ArrayList<InventoryFunction> inventories = new ArrayList<>();
	private ArrayList<String> inv_names = new ArrayList<>();
	private RGB[] colors = new RGB[8];
	private VehicleInstance vehicle;
	private int page;

	public VehicleInventories(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		vehicle = (VehicleInstance)container.get("vehicle");
		SeatInstance seat = vehicle.getSeatOf(con.player.entity.direct());
		for(Map.Entry<String, PartData> entry : vehicle.data.getParts().entrySet()){
			InventoryFunction inv = entry.getValue().getFunction("fvtm:inventory");
			if(inv == null || inv.inventory().type.isContainer()) continue;
			if(seat == null ? inv.getSeats().contains(vehicle.data.getLock().isLocked() ? "external-locked" : "external") : (seat.seat.driver || (inv.getSeats().contains(seat.seat.name)))){
				inventories.add(inv);
				inv_names.add(entry.getKey());
			}
		}
		for(int i = 0; i < 8; i++) colors[i] = RGB.WHITE;
		updatePage(0);
	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		for(int i = 0; i < 8; i++){
			drawer.apply(colors[i]);
			drawer.draw(gLeft + 175, gTop + 17 + (14 * i), 175, 17 + (14 * i), 12, 12);
			drawer.applyWhite();
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		if(id.equals("next")) updatePage(1);
		else if(id.equals("prev")) updatePage(-1);
		else if(id.startsWith("inv_")){
			int idx = Integer.parseInt(id.substring(4));
			if(idx < 0 || (idx + (page * 8)) >= inventories.size()) return true;
			TagCW com = TagCW.create();
			com.set("open", inv_names.get(idx + (page * 8)));
			container.SEND_TO_SERVER.accept(com);
		}
		return true;
	}

	@Override
	public void scrollwheel(int am, int x, int y){
		updatePage(am > 0 ? -1 : 1);
	}

	private void updatePage(int i){
		page += i;
		if(page < 0) page = 0;
		for(int j = 0; j < 8; j++){
			int k = j + (page * 8);
			boolean bool = k >= inventories.size();
			texts.get("inv_" + j).value(bool ? "" : inv_names.get(k));
			buttons.get("inv_" + j).enabled(!bool);
			if(!bool){
				colors[j] = inventories.get(k).inventory().type.color;
			}
			else{
				colors[j] = RGB.WHITE;
			}
		}
	}

}
