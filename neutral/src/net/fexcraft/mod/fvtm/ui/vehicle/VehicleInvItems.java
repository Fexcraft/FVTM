package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.inv.FvtmInv;
import net.fexcraft.mod.fvtm.data.inv.FvtmInvItems;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleInvItems extends UserInterface {

	private FvtmInvItems inv;
	private int cols;
	private int rows;
	private int col0;

	public VehicleInvItems(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		inv = ((VehicleInvItemsCon)con).inv;
		cols = inv.cols * 18;
		rows = inv.rows * 18;
		col0 = 9 * 18 - cols;
	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		drawer.draw(gLeft, gTop + 133, 0, 133, 7, 7);//bottom left
		drawer.draw(gLeft + 7, gTop + 133, 169 - cols, 133, 7 + cols, 7);//bottom
		drawer.draw(gLeft + 7, gTop + 133 - rows - 7, 169 - cols, 0, 7 + cols, 7);//top
		drawer.draw(gLeft, gTop + 126 - rows, 0, 0, 7, 7);//top left
		drawer.draw(gLeft, gTop + 133 - rows, 0, 7, 7, rows);//side left
		drawer.draw(gLeft + 169 - col0, gTop + 133 - rows, 169, 7, 7, rows);//side right
		drawer.draw(gLeft + 7, gTop + 133 - rows, 7, 7, cols, rows);//inner
	}

}
