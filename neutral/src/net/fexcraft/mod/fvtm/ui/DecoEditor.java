package net.fexcraft.mod.fvtm.ui;

import java.awt.*;
import java.util.ArrayList;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import javax.swing.*;

import static net.fexcraft.mod.fvtm.ui.EditorData.RATE;
import static net.fexcraft.mod.fvtm.ui.EditorData.RATES;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoEditor extends UserInterface {

	private ArrayList<String> colors = new ArrayList<>();
	public static String[] axes = new String[]{ "x", "y", "z" };
	protected DecorationData sel;
	protected DecoContainer con;
	public int sel_idx;
	public int sel_tex;
	public int sel_col;
	public int sel_uv;

	public DecoEditor(JsonMap map, ContainerInterface con) throws Exception {
		super(map, con);
		this.con = (DecoContainer)con;
	}

	@Override
	public void init(){
		select(-1);
		ToolboxPainter.setupSpectrum(buttons.get("pal_hor"));
		ToolboxPainter.setupShadePalette(RGB.WHITE, buttons.get("pal_sha"));
		ColorPaletteUtil.load(buttons.get("pal_save"));
		EditorData.load();
		fields.get("rate").text(RATE);
		updateRates();
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		if(sel == null) return true;
		TagCW com = TagCW.create();
		switch(id){
			case "sel_rem":{
				com.set("task", "rem");
				break;
			}
			case "sel_copy":{
				com.set("task", "copy");
				break;
			}
			case "sel_prev":
			case "sel_next":{
				int idx = sel_idx;
				idx += id.endsWith("next") ? 1 : -1;
				if(idx < 0) idx = con.decos.size() - 1;
				else if(idx >= con.decos.size()) idx = 0;
				select(idx);
				break;
			}
			case "tex_pro_prev":
			case "tex_pro_next":{
				int idx = sel.getTexture().getSelected();
				if(idx < 0) idx = 0;
				if(id.endsWith("next")){
					if(++idx >= sel.getTexHolder().getDefaultTextures().size()) idx = 0;
				}
				else{
					if(--idx < 0) idx = sel.getTexHolder().getDefaultTextures().size() - 1;
				}
				com.set("task", "tex");
				com.set("sel", idx);
				break;
			}
			case "tex_cus_int":{
				com.set("task", "tex_ext");
				com.set("ext", false);
				break;
			}
			case "tex_cus_ext":{
				com.set("task", "tex_ext");
				com.set("ext", true);
				break;
			}
			case "tex_cus_set":{
				com.set("task", "tex_cus");
				com.set("custom", fields.get("texture").text());
				break;
			}
			case "col_picker":{
				try{
					new Thread(null, () -> {
						updateColor(new RGB(JColorChooser.showDialog(null, "select color", new Color(sel.getColorChannel(colors.get(sel_col)).packed)).getRGB()), false);
					}, "FVTM Decoration Editor Color Chooser Thread").start();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case "col_prev":
			case "col_next":{
				if(colors.isEmpty()) return true;
				sel_col += id.endsWith("next") ? 1 : -1;
				if(sel_col < 0) sel_col = colors.size() - 1;
				if(sel_col >= colors.size()) sel_col = 0;
				updateColor(sel.getColorChannel(colors.get(sel_col)), true);
				break;
			}
			case "col_parse":{
				int r = Integer.parseInt(fields.get("col_r").text().trim());
				int g = Integer.parseInt(fields.get("col_g").text().trim());
				int b = Integer.parseInt(fields.get("col_b").text().trim());
				RGB rgb = new RGB(r, g, b);
				String str = fields.get("col_hex").text().trim().replace("#", "").replace("0x", "");
				if(str.length() > 6) str = str.substring(0, 6);
				RGB hex = new RGB(Integer.parseInt(str, 16));
				updateColor(rgb.packed == current_color().packed ? hex : rgb, false);
				break;
			}
			case "col_save":{
				ColorPaletteUtil.save(buttons.get("pal_save"), current_color());
				break;
			}
			case "col_set":{
				com.set("task", "color");
				com.set("channel", colors.get(sel_col));
				com.set("rgb", current_color().packed);
				break;
			}
			case "pal_hor":
			case "pal_save": {
				int idx = (x - button.x) / button.palsize[0];
				if(idx < 0) idx = 0;
				if(idx >= button.palette[0].length) idx = button.palette[0].length - 1;
				RGB rgb = button.palette[0][idx];
				current_color().packed = rgb.packed;
				updateColor(rgb, false);
				break;
			}
			case "pal_sha":{
				int ix = (x - button.x) / button.palsize[0];
				int iy = (y - button.y) / button.palsize[1];
				if(ix < 0) ix = 0;
				if(ix >= button.palette[0].length) ix = button.palette[0].length - 1;
				if(iy < 0) iy = 0;
				if(iy >= button.palette.length) iy = button.palette.length - 1;
				RGB rgb = button.palette[iy][ix];
				current_color().packed = rgb.packed;
				updateColor(rgb, false);
				break;
			}
			case "pos_x":
			case "pos_y":
			case "pos_z":
			case "rot_x":
			case "rot_y":
			case "rot_z":
			case "scl_x":
			case "scl_y":
			case "scl_z":{
				com.set("task", id.substring(0, 3));
				com.set("axe", id.substring(4));
				com.set("val", fields.get(id).number());
				break;
			}
			case "rate_set":{
				RATE = fields.get("rate").number();
				break;
			}
			case "rate_save":{
				for(int i = RATES.length - 1; i > 0; i--){
					RATES[i] = RATES[i - 1];
				}
				RATES[0] = fields.get("rate").number();
				updateRates();
				EditorData.save();
				break;
			}
			case "rate_prev":
			case "rate_next":{
				int idx = 0;
				for(int i = 0; i < RATES.length; i++){
					if(RATE == RATES[i]){
						idx = i;
						break;
					}
				}
				idx += id.endsWith("next") ? 1 : -1;
				if(idx < 0) idx = RATES.length - 1;
				if(idx >= RATES.length) idx = 0;
				RATE = RATES[idx];
				fields.get("rate").text(RATE);
				break;
			}
			case "rate_0":
			case "rate_1":
			case "rate_2":
			case "rate_3":
			case "rate_4":
			case "rate_5":{
				RATE = RATES[Integer.parseInt(id.substring(5))];
				fields.get("rate").text(RATE);
				break;
			}
			case "reset_val":{
				com.set("task", "reset");
				break;
			}
			case "import_val":{
				com.set("task", "import_val");
				com.set("cb", root.getClipboard());
				break;
			}
			case "export_val":{
				root.setClipboard(sel.writeTransformJson().toString());
				break;
			}
		}
		if(com.empty()) return true;
		com.set("deco", sel_idx);
		ContainerInterface.SEND_TO_SERVER.accept(com);
		return true;
	}

	@Override
	public boolean onScroll(UIButton button, String id, int mx, int my, int am) {
		if(id.startsWith("pos") || id.startsWith("rot") || id.startsWith("scl")){
			float val = fields.get(id).number();
			val += am > 0 ? -RATE : RATE;
			fields.get(id).text(val + "");
			onAction(button, id, mx, my, 0);
			return true;
		}
		return false;
	}

	public void select(int idx){
		colors.clear();
		if(idx < 0 && con.decos.size() > 0) idx = 0;
		sel_idx = idx;
		sel = idx < 0 ? null : con.decos.get(sel_idx);
		boolean miss = sel == null;
		if(miss){
			sel_tex = 0;
			texts.get("deco_count").transval("...");
			texts.get("deco_current").transval("ui.fvtm.decoration_editor.no_decorations");
			texts.get("texture_selected").transval("");
			fields.get("texture").text("");
			for(int i = 0; i < 3; i++){
				fields.get("pos" + axes[i]).text("0");
				fields.get("rot" + axes[i]).text("0");
				fields.get("scl" + axes[i]).text("0");
			}
		}
		else{
			sel_tex = sel.getTexture().getSelected();
			texts.get("deco_count").transval("ui.fvtm.decoration_editor.decoration_count", sel_idx + 1, con.decos.size());
			texts.get("deco_current").transval(sel.getType().getName());
			updateTexture();
			for(int i = 0; i < 3; i++){
				fields.get("pos_" + axes[i]).text((i == 0 ? sel.offset.x : i == 1 ? sel.offset.y : sel.offset.z) + "");
				fields.get("rot_" + axes[i]).text((i == 0 ? sel.rotx : i == 1 ? sel.roty : sel.rotz) + "");
				fields.get("scl_" + axes[i]).text((i == 0 ? sel.sclx : i == 1 ? sel.scly : sel.sclz) + "");
			}
		}
		if(!miss) colors.addAll(sel.getColorChannels().keySet());
		sel_col = 0;
		sel_uv = 0;
		updateColor(miss || colors.isEmpty() ? RGB.WHITE : sel.getColorChannel(colors.get(sel_col)), true);
	}

	protected void updateTexture(){
		texts.get("texture_selected").transval(sel.getTexture().getSelected() < 0 ? "" : sel.getTexture().getTexture().name());
		fields.get("texture").text(sel.getTexture().getCustom());
	}

	protected void updateColor(RGB nv, boolean cc){
		texts.get("color_channel").transval(colors.isEmpty() ? "ui.fvtm.decoration_editor.no_color_channels" : colors.get(sel_col));
		byte[] ar = nv.toByteArray();
		fields.get("col_r").text((ar[0] + 128));
		fields.get("col_g").text((ar[1] + 128));
		fields.get("col_b").text((ar[2] + 128));
		fields.get("col_hex").text("#" + Integer.toHexString(nv.packed));
		if(!cc){
			current_color().packed = nv.packed;
			ToolboxPainter.setupShadePalette(nv, buttons.get("pal_sha"));
		}
		else buttons.get("col_val").palette[0][0].packed = nv.packed;
	}

	public RGB current_color(){
		return buttons.get("col_cur").palette[0][0];
	}

	public void updateRates(){
		for(int i = 0; i < RATES.length; i++){
			texts.get("rate_" + i).value(RATES[i] + "");
		}
	}

}
