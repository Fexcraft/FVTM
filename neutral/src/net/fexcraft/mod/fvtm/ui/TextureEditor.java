package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import static net.fexcraft.mod.fvtm.data.SignData.f;
import static net.fexcraft.mod.fvtm.ui.EditorData.RATE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TextureEditor extends UserInterface {

	protected TextureContainer con;

	public TextureEditor(JsonMap map, ContainerInterface container) throws Exception{
		super(map, container);
		con = (TextureContainer)container;
	}

	@Override
	public void init(){
		//
		ToolboxPainter.setupSpectrum(buttons.get("pal_hor"));
		ToolboxPainter.setupShadePalette(RGB.WHITE, buttons.get("pal_sha"));
		ColorPaletteUtil.load(buttons.get("pal_sav"));
		EditorData.load();
		fields.get("rate").text(RATE);
		EditorData.updateRates(this);
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
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

}
