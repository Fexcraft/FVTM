package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UniUI;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailSignal extends UserInterface {

	private RailSignalContainer menu;

	public RailSignal(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		menu = (RailSignalContainer)con;
	}

	@Override
	public void init(){
		texts.get("title").value(menu.junc.posString());
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		if(menu.junc == null) return;
		texts.get("signal0").value(menu.junc.sigtype0.name() + " / " + menu.junc.sigstate0);
		texts.get("signal1").value(menu.junc.sigtype1.name() + " / " + menu.junc.sigstate1);
		buttons.get("status0").ecolor = menu.junc.sigstate0 ? RGB.GREEN : RGB.RED;
		buttons.get("status1").ecolor = menu.junc.sigstate1 ? RGB.GREEN : RGB.RED;
	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		//
	}

	@Override
	public void postdraw(float ticks, int mx, int my){
		//
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		switch(id){
			case "status0":
			case "status1":
			case "auto0":
			case "auto1":
			case "con0":
			case "con1":
			case "remove0":
			case "remove1":{
				TagCW com = TagCW.create();
				com.set("task", id);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "copy":{
				root.setClipboard(menu.junc.posString());
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
		//
	}

}
