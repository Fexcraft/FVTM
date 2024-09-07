package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorMain extends UserInterface {

	//

	public ConstructorMain(JsonMap map, ContainerInterface con) throws Exception {
		super(map, con);
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		switch(id) {
			case "lift_up": {
				TagCW com = TagCW.create();
				com.set("task", "lift");
				com.set("lift", 1);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "lift_down": {
				TagCW com = TagCW.create();
				com.set("task", "lift");
				com.set("lift", -1);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "vehicle_parts": {
				TagCW com = TagCW.create();
				com.set("task", "veh_parts");
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "vehicle_attrs": {
				TagCW com = TagCW.create();
				com.set("task", "veh_attrs");
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "appearance_texture": {
				TagCW com = TagCW.create();
				com.set("task", "appear_tex");
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "appearance_color": {
				TagCW com = TagCW.create();
				com.set("task", "appear_color");
				container.SEND_TO_SERVER.accept(com);
				break;
			}
		}
		return true;
	}

	@Override
	public boolean onScroll(UIButton button, String id, int mx, int my, int am) {
		//
		return false;
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		texts.get("title").translate(container.player.entity.getName());
	}

	@Override
	public void postdraw(float ticks, int mx, int my){
		//
	}

	@Override
	public void scrollwheel(int a, int x, int y){
		//
	}

}
