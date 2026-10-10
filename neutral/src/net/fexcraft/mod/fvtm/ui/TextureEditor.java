package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import static net.fexcraft.mod.fvtm.data.SignData.f;
import static net.fexcraft.mod.fvtm.ui.DecoEditor.axes;
import static net.fexcraft.mod.fvtm.ui.EditorData.RATE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TextureEditor extends UserInterface {

	protected TextureContainer con;
	protected static V3D cam_pos = new V3D(0, 0, -256);
	protected static V3D cam_rot = new V3D(0, -90, 0);
	protected static V3D cam_scl = new V3D(1, 1, 1);
	protected static boolean wheels = true;
	protected static boolean selonly;
	protected static boolean camset = true;

	public TextureEditor(JsonMap map, ContainerInterface container) throws Exception{
		super(map, container);
		con = (TextureContainer)container;
	}

	@Override
	public void init(){
		select(-1);
		ToolboxPainter.setupSpectrum(buttons.get("pal_hor"));
		ToolboxPainter.setupShadePalette(RGB.WHITE, buttons.get("pal_sha"));
		ColorPaletteUtil.load(buttons.get("pal_sav"));
		EditorData.load();
		fields.get("rate").text(RATE);
		EditorData.updateRates(this);
		//
		buttons.get("wheel_on").enabled(!wheels);
		buttons.get("wheel_off").enabled(wheels);
		buttons.get("so_on").enabled(!selonly);
		buttons.get("so_off").enabled(selonly);
		buttons.get("cam_on").enabled(!camset);
		buttons.get("cam_off").enabled(camset);
		for(int i = 0; i < 3; i++){
			fields.get("pos_" + axes[i]).text((i == 0 ? cam_pos.x : i == 1 ? cam_pos.y : cam_pos.z) + "");
			fields.get("rot_" + axes[i]).text((i == 0 ? cam_rot.x : i == 1 ? cam_rot.y : cam_rot.z) + "");
			fields.get("scl_" + axes[i]).text((i == 0 ? cam_scl.x : i == 1 ? cam_scl.y : cam_scl.z) + "");
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		if(EditorData.isRateButton(this, id)) return true;
		switch(id){
			case "wheel_on":
			case "wheel_off":{
				wheels = id.endsWith("_on");
				buttons.get("wheel_on").enabled(!wheels);
				buttons.get("wheel_off").enabled(wheels);
				break;
			}
			case "so_on":
			case "so_off":{
				selonly = id.endsWith("_on");
				buttons.get("so_on").enabled(!selonly);
				buttons.get("so_off").enabled(selonly);
				break;
			}
			case "cam_on":
			case "cam_off":{
				camset = id.endsWith("_on");
				buttons.get("cam_on").enabled(!camset);
				buttons.get("cam_off").enabled(camset);
				break;
			}
		}
		if(camset){
			switch(id){
				case "pos_x": cam_pos.x = f(fields.get(id).number()); break;
				case "pos_y": cam_pos.y = f(fields.get(id).number()); break;
				case "pos_z": cam_pos.z = f(fields.get(id).number()); break;
				case "rot_x": cam_rot.x = f(fields.get(id).number()); break;
				case "rot_y": cam_rot.y = f(fields.get(id).number()); break;
				case "rot_z": cam_rot.z = f(fields.get(id).number()); break;
				case "scl_x": cam_scl.x = f(fields.get(id).number()); break;
				case "scl_y": cam_scl.y = f(fields.get(id).number()); break;
				case "scl_z": cam_scl.z = f(fields.get(id).number()); break;
			}
		}
		return true;
	}

	@Override
	public boolean onScroll(UIButton button, String id, int mx, int my, int am) {
		if(id.startsWith("pos") || id.startsWith("rot") || id.startsWith("scl")){
			float val = f(fields.get(id).number());
			val += am > 0 ? -RATE : RATE;
			fields.get(id).text(val + "");
			onAction(button, id, mx, my, 0);
			return true;
		}
		return false;
	}

	protected void select(int idx){

	}

}
