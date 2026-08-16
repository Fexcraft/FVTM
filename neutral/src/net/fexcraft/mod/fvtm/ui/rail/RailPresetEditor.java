package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailPresetEditor extends UserInterface {

	private RailPresetEditorCon menu;

	public RailPresetEditor(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		menu = (RailPresetEditorCon)con;
	}

	@Override
	public void init(){
		//
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		//
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
		//
		return false;
	}

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		//
	}

}
