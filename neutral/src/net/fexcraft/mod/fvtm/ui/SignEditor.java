package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.SignData;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.uni.ui.ContainerInterface.SEND_TO_SERVER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SignEditor extends UserInterface {

	private SignContainer scon;
	private static ArrayList<String> colors = new ArrayList<>();
	protected int col_sel;
	protected int com_sel;
	protected SignData sign;

	public SignEditor(JsonMap map, ContainerInterface con) throws Exception {
		super(map, con);
		scon = (SignContainer)con;
	}

	@Override
	public void init(){
		select(0, 0);
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		boolean found = true;
		switch(id){
			case "com_prev":{
				select(-1);
				break;
			}
			case "com_next":{
				select(1);
				break;
			}
			case "com_rem":{
				TagCW com = TagCW.create();
				com.set("task", "rem");
				com.set("idx", com_sel);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "tex_prev":{
				if(com_sel < 0 || com_sel >= scon.signs.size()) return true;
				TagCW com = TagCW.create();
				com.set("task", "tex");
				com.set("idx", com_sel);
				com.set("sel", sign.getTexture().getSelected() - 1 < 0 ? sign.getType().getDefaultTextures().size() - 1 : sign.getTexture().getSelected() - 1);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "tex_next":{
				if(com_sel < 0 || com_sel >= scon.signs.size()) return true;
				TagCW com = TagCW.create();
				com.set("task", "tex");
				com.set("idx", com_sel);
				com.set("sel", sign.getTexture().getSelected() + 1 < sign.getType().getDefaultTextures().size() ? sign.getTexture().getSelected() + 1 : 0);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "ch_prev":{
				if(colors.isEmpty()) return true;
				col_sel--;
				if(col_sel < 0) col_sel = colors.size() - 1;
				select(com_sel, col_sel);
				break;
			}
			case "ch_next":{
				if(colors.isEmpty()) return true;
				col_sel++;
				if(col_sel >= colors.size()) col_sel = 0;
				select(com_sel, col_sel);
				break;
			}
			case "rgb":{
				if(com_sel < 0 || com_sel >= scon.signs.size() || colors.isEmpty()) return true;
				TagCW com = TagCW.create();
				com.set("task", "color");
				com.set("idx", com_sel);
				com.set("channel", colors.get(col_sel));
				RGB rgb = RGB.WHITE;
				try{
					String[] arr = fields.get("rgb").text().split("\\,");
					int r = Integer.parseInt(arr[0].trim());
					int g = Integer.parseInt(arr[1].trim());
					int b = Integer.parseInt(arr[2].trim());
					rgb = new RGB(r, g, b);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				com.set("rgb", rgb.packed);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "hex":{
				if(com_sel < 0 || com_sel >= scon.signs.size() || colors.isEmpty()) return true;
				TagCW com = TagCW.create();
				com.set("task", "color");
				com.set("idx", com_sel);
				com.set("channel", colors.get(col_sel));
				RGB rgb = RGB.WHITE;
				try{
					rgb = new RGB(fields.get("hex").text());
				}
				catch(Exception e){
					e.printStackTrace();
				}
				com.set("rgb", rgb.packed);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "colorpicker":{
				if(com_sel < 0 || com_sel >= scon.signs.size() || colors.isEmpty()) return true;
				try{
					new Thread(){
						@Override
						public void run(){
							Color color = JColorChooser.showDialog(null, "select color", new Color(sign.getColorChannel(colors.get(col_sel)).packed));
							RGB rgb = new RGB(color.getRGB());
							byte[] ar = rgb.toByteArray();
							fields.get("rgb").text((ar[0] + 128) + ", " + (ar[1] + 128) + ", " + (ar[2] + 128));
							fields.get("hex").text("#" + Integer.toHexString(rgb.packed).substring(2));
						}
					}.start();
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case "text_set":{
				if(!sign.getType().isText()) return true;
				TagCW com = TagCW.create();
				com.set("task", "text");
				com.set("idx", com_sel);
				com.set("text", fields.get("text").text());
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "sign_top":{
				if(!sign.getType().isBase()) return true;
				TagCW com = TagCW.create();
				com.set("task", "side");
				com.set("idx", com_sel);
				com.set("side", 0);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "sign_left":{
				if(!sign.getType().isBase()) return true;
				TagCW com = TagCW.create();
				com.set("task", "side");
				com.set("idx", com_sel);
				com.set("side", 1);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "sign_right":{
				if(!sign.getType().isBase()) return true;
				TagCW com = TagCW.create();
				com.set("task", "side");
				com.set("idx", com_sel);
				com.set("side", 2);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "sign_bot":{
				if(!sign.getType().isBase()) return true;
				TagCW com = TagCW.create();
				com.set("task", "side");
				com.set("idx", com_sel);
				com.set("side", 3);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "sign_scale_x":{
				if(!sign.getType().isBase()) return true;
				TagCW com = TagCW.create();
				com.set("task", "width");
				com.set("idx", com_sel);
				com.set("val", fields.get("scale_x").number());
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "sign_scale_y":{
				if(!sign.getType().isBase()) return true;
				TagCW com = TagCW.create();
				com.set("task", "height");
				com.set("idx", com_sel);
				com.set("val", fields.get("scale_y").number());
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "remove":{
				TagCW com = TagCW.create();
				com.set("task", "rem_all");
				com.set("idx", com_sel);
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "import":{
				TagCW com = TagCW.create();
				com.set("task", "import");
				SEND_TO_SERVER.accept(com);
				break;
			}
			case "export":{
				TagCW com = TagCW.create();
				com.set("task", "export");
				SEND_TO_SERVER.accept(com);
				break;
			}
			default:{
				found = false;
				break;
			}
		}
		if(!found){
			if(id.startsWith("pos")){
				int ax = Integer.parseInt(id.substring(3));
				TagCW com = TagCW.create();
				com.set("task", "pos");
				com.set("axis", ax);
				com.set("idx", com_sel);
				com.set("value", fields.get(id).number());
				SEND_TO_SERVER.accept(com);
				return true;
			}
			else if(id.startsWith("rot")){
				int ax = Integer.parseInt(id.substring(3));
				TagCW com = TagCW.create();
				com.set("task", "rot");
				com.set("axis", ax);
				com.set("idx", com_sel);
				com.set("value", fields.get(id).number());
				SEND_TO_SERVER.accept(com);
				return true;
			}
			else if(id.startsWith("scl")){
				int ax = Integer.parseInt(id.substring(3));
				TagCW com = TagCW.create();
				com.set("task", "scale");
				com.set("axis", ax);
				com.set("idx", com_sel);
				com.set("value", fields.get(id).number());
				SEND_TO_SERVER.accept(com);
				return true;
			}
		}
		return found;
	}

	@Override
	public boolean onScroll(UIButton button, String id, int mx, int my, int am) {
		if(id.startsWith("pos")){
			int ax = Integer.parseInt(id.substring(3));
			float val = fields.get(id).number();
			val += am > 0 ? -sixteenth : sixteenth;
			fields.get("pos" + ax).text(val + "");
			onAction(button, id, mx, my, 0);
			return true;
		}
		else if(id.startsWith("rot")){
			int ax = Integer.parseInt(id.substring(3));
			float val = fields.get(id).number();
			val += am > 0 ? -1 : 1;
			fields.get("rot" + ax).text(val + "");
			onAction(button, id, mx, my, 0);
			return true;
		}
		else if(id.startsWith("scl")){
			int ax = Integer.parseInt(id.substring(3));
			float val = fields.get(id).number();
			val += am > 0 ? -sixteenth : sixteenth;
			fields.get("scl" + ax).text(val + "");
			onAction(button, id, mx, my, 0);
			return true;
		}
		else if(id.equals("sign_scale_x")){
			float val = fields.get("scale_x").number();
			val += am > 0 ? -sixteenth : sixteenth;
			fields.get("scale_x").text(val + "");
			onAction(button, id, mx, my, 0);
		}
		else if(id.equals("sign_scale_y")){
			float val = fields.get("scale_y").number();
			val += am > 0 ? -sixteenth : sixteenth;
			fields.get("scale_y").text(val + "");
			onAction(button, id, mx, my, 0);
		}
		return false;
	}

	public void select(int i){
		select(com_sel += i, col_sel);
	}

	public void select(int idx, int colidx){
		com_sel = idx;
		if(com_sel < 0) com_sel = scon.signs.size() - 1;
		if(com_sel >= scon.signs.size()) com_sel = 0;
		colors.clear();
		sign = scon.signs.get(com_sel);
		boolean miss = sign == null;
		for(int i = 0; i < 3; i++){
			fields.get("pos" + i).text(miss ? "0" : (i == 0 ? sign.offset.x : i == 1 ? sign.offset.y : sign.offset.z) + "");
			fields.get("rot" + i).text(miss ? "0" : (i == 0 ? sign.rotx : i == 1 ? sign.roty : sign.rotz) + "");
			fields.get("scl" + i).text(miss ? "0" : (i == 0 ? sign.sclx : i == 1 ? sign.scly : sign.sclz) + "");
		}
		texts.get("texc").value(miss ? "" : sign.getCurrentTexture().name());
		col_sel = colidx;
		if(!miss) colors.addAll(sign.getColorChannels().keySet());
		if(col_sel >= colors.size() || col_sel < 0) col_sel = 0;
		texts.get("channel").value(miss ? "" : colors.isEmpty() ? "gui.fvtm.decoration_editor.no_color_channels" : colors.get(col_sel));
		texts.get("channel").translate();
		RGB color = miss || colors.isEmpty() ? RGB.WHITE : sign.getColorChannel(colors.get(col_sel));
		byte[] ar = color.toByteArray();
		fields.get("rgb").text((ar[0] + 128) + ", " + (ar[1] + 128) + ", " + (ar[2] + 128));
		fields.get("hex").text("#" + Integer.toHexString(color.packed));
		//
		texts.get("com_sel").value("ui.fvtm.sign_editor.com_sel");
		texts.get("com_sel").translate(com_sel + 1, scon.signs.size());
		texts.get("com_name").value(sign == null ? "null" : sign.getType().getName());
		texts.get("text_sel").value("...");
		texts.get("sign_sides").value("...");
		buttons.get("sign_top").ecolor.packed = RGB.WHITE.packed;
		buttons.get("sign_bot").ecolor.packed = RGB.WHITE.packed;
		buttons.get("sign_left").ecolor.packed = RGB.WHITE.packed;
		buttons.get("sign_right").ecolor.packed = RGB.WHITE.packed;
		fields.get("text").text("");
		fields.get("scale_x").text("0");
		fields.get("scale_y").text("0");
		if(sign != null){
			if(sign.getType().isText()){
				texts.get("text_sel").transval("ui.fvtm.sign_editor.text_sel");
				fields.get("text").text(sign.form);
			}
			else{
				texts.get("text_sel").transval("ui.fvtm.sign_editor.text_none");
			}
			if(sign.getType().isBase()){
				texts.get("sign_sides").transval("ui.fvtm.sign_editor.sign_sides");
				buttons.get("sign_top").ecolor.packed = sign.sides[0] ? RGB.WHITE.packed : RGB.GREEN.packed;
				buttons.get("sign_left").ecolor.packed = sign.sides[1] ? RGB.WHITE.packed : RGB.GREEN.packed;
				buttons.get("sign_right").ecolor.packed = sign.sides[2] ? RGB.WHITE.packed : RGB.GREEN.packed;
				buttons.get("sign_bot").ecolor.packed = sign.sides[3] ? RGB.WHITE.packed : RGB.GREEN.packed;
				fields.get("scale_x").text(sign.width + "");
				fields.get("scale_y").text(sign.height + "");
			}
			else{
				texts.get("sign_sides").transval("ui.fvtm.sign_editor.sign_nosides");
			}
		}
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		//
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
