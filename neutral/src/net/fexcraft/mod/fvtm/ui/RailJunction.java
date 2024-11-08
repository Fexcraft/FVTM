package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailJunction extends UserInterface {

	public static final RGB BLU = new RGB(0x0094FF);
	public static final RGB RED = new RGB(0xCC1A29);
	public static final RGB GRE = new RGB(0x00FF21);
	public static final RGB ORA = new RGB(0xFF6A00);
	public static final float[][] TRACK_COLOR = { BLU.toFloatArray(), RED.toFloatArray(), GRE.toFloatArray(), ORA.toFloatArray() };
	private RailJunctionContainer menu;

	public RailJunction(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		menu = (RailJunctionContainer)con;
	}

	@Override
	public void init(){
		texts.get("title").value(menu.junc.posString());
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		if(menu.junc == null) return;
		switch(menu.junc.type){
			case STRAIGHT: {
				texts.get("switch0").value("inactive");
				texts.get("switch1").value("inactive");
				//
				buttons.get("switch00").ecolor = BLU;
				buttons.get("switch01").ecolor = RED;
				buttons.get("switch10").ecolor = RGB.WHITE;
				buttons.get("switch11").ecolor = RGB.WHITE;
				break;
			}
			case FORK_2: {
				texts.get("switch0").value("Switch0: " + menu.junc.switch0);
				texts.get("switch1").value("inactive");
				//
				buttons.get("switch00").ecolor = BLU;
				buttons.get("switch01").ecolor = menu.junc.switch0 ? RED : GRE;
				buttons.get("switch10").ecolor = RGB.WHITE;
				buttons.get("switch11").ecolor = RGB.WHITE;
				break;
			}
			case FORK_3: {
				texts.get("switch0").value("Switch0+1: " + menu.junc.switch0 + " / " + menu.junc.switch1);
				texts.get("switch1").value("inactive");
				//
				buttons.get("switch00").ecolor = BLU;
				buttons.get("switch01").ecolor = menu.junc.switch0 ? RED : menu.junc.switch1 ? ORA : GRE;
				buttons.get("switch10").ecolor = RGB.WHITE;
				buttons.get("switch11").ecolor = RGB.WHITE;
				break;
			}
			case DOUBLE: {
				texts.get("switch0").value("Switch0: " + menu.junc.switch0);
				texts.get("switch1").value("Switch1: " + menu.junc.switch1);
				//
				buttons.get("switch00").ecolor = menu.junc.switch1 ? BLU : ORA;
				buttons.get("switch01").ecolor = menu.junc.switch0 ? RED : GRE;
				buttons.get("switch10").ecolor = menu.junc.switch0 ? RED : GRE;
				buttons.get("switch11").ecolor = menu.junc.switch1 ? BLU : ORA;
				break;
			}
			case CROSSING: {
				texts.get("switch0").value("inactive");
				texts.get("switch1").value("inactive");
				//
				buttons.get("switch00").ecolor = BLU;
				buttons.get("switch01").ecolor = RED;
				buttons.get("switch10").ecolor = GRE;
				buttons.get("switch11").ecolor = ORA;
				break;
			}
		}
		for(int i = 0; i < 4; i++){
			texts.get("track" + i).value(i >= menu.junc.size() ? "" : menu.junc.tracks.get(i).id.toPosString());
		}
	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		if(menu.junc == null) return;
		drawer.bindTabTex(this, "main");
		drawer.draw(gLeft + 73 + menu.junc.type.ordinal() * 18, gTop + 21, 0, 238, 18, 18);
		//
		for(int i = 0; i < menu.junc.size(); i++){
			drawTrack(menu.junc.tracks.get(i), TRACK_COLOR[i], menu.junc.getPos().pos);
		}
	}

	private void drawTrack(Track track, float[] color, V3I pos){
		V3D vec0, vec1;
		if(track.vecpath.length == 2){
			vec0 = track.vecpath[0];
			vec1 = vec0.distance(track.vecpath[1], 15);
			drawer.drawLine(
				(vec0.x - pos.x + 16) * 2 + gLeft + 7, (vec0.z - pos.z + 16) * 2 + gTop + 21,
				(vec1.x - pos.x + 16) * 2 + gLeft + 7, (vec1.z - pos.z + 16) * 2 + gTop + 21,
				color);
			return;
		}
		double x0, x1, z0, z1;
		for(int j = 0; j < track.vecpath.length - 1; j++){
			vec0 = track.vecpath[j];
			vec1 = track.vecpath[j + 1];
			x0 = vec0.x - pos.x;
			z0 = vec0.z - pos.z;
			if(x0 < -16 || z0 < -16 || x0 > 16 || z0 > 16) continue;
			x1 = vec1.x - pos.x;
			z1 = vec1.z - pos.z;
			if(x1 < -16 || z1 < -16 || x1 > 16 || z1 > 16) continue;
			drawer.drawLine(
				(x0 + 16) * 2 + gLeft + 7, (z0 + 16) * 2 + gTop + 21,
				(x1 + 16) * 2 + gLeft + 7, (z1 + 16) * 2 + gTop + 21,
				color);
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		switch(id){
			case "switch0":
			case "switch1":
			case "type_2":
			case "type_3":
			case "type_4":
			case "down0":
			case "down1":
			case "down2":
			case "up1":
			case "up2":
			case "up3":
			case "rem0":
			case "rem1":
			case "rem2":
			case "rem3":{
				TagCW com = TagCW.create();
				com.set("task", id);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			default:{
				break;
			}
		}
		return false;
	}

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		if(buttons.get("section").hovered()){
			long last = -1;
			for(int i = 0; i < menu.junc.tracks.size(); i++){
				Track track = menu.junc.tracks.get(i);
				if(last == track.getUnit().section().getUID()) continue;
				last = track.getUnit().section().getUID();
				list.add(menu.TRANSFORMAT.apply("ui.fvtm.rail_junction.section", new Object[]{ i, track.getUnit().section().getUID() }));
			}
		}
		if(buttons.get("signal").hovered()){
			list.add(menu.TRANSFORMAT.apply("ui.fvtm.rail_junction.signal", new Object[]{ menu.junc.signal == null ? "none" : menu.junc.signal }));
		}
	}

}
