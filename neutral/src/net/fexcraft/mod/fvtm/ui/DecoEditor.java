package net.fexcraft.mod.fvtm.ui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DecoEditor extends UserInterface {

	private static final int rows = 12;
	private static ArrayList<String> colors = new ArrayList<>();
	private int scroll;
	public int selected = -1;
	public int selcol;

	public DecoEditor(JsonMap map, ContainerInterface con) throws Exception {
		super(map, con);
	}

	@Override
	public void init(){
		updateEntries();
		select(-1, -1);
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		boolean found = true;
		switch(id){
			case "list_up":{
				scroll--;
				if(scroll < 0) scroll = 0;
				updateEntries();
				break;
			}
			case "list_down":{
				scroll++;
				updateEntries();
				break;
			}
			case "tex_prev":{
				if(selected < 0 || selected >= (int)container.get("decos.size")) return true;
				TagCW com = TagCW.create();
				com.set("task", "tex");
				com.set("idx", selected);
				DecorationData data = (DecorationData)container.get("decos.at", selected);
				com.set("sel", data.getTexture().getSelected() - 1 < 0 ? data.getType().getDefaultTextures().size() - 1 : data.getTexture().getSelected() - 1);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "tex_next":{
				if(selected < 0 || selected >= (int)container.get("decos.size")) return true;
				TagCW com = TagCW.create();
				com.set("task", "tex");
				com.set("idx", selected);
				DecorationData data = (DecorationData)container.get("decos.at", selected);
				com.set("sel", data.getTexture().getSelected() + 1 < data.getType().getDefaultTextures().size() ? data.getTexture().getSelected() + 1 : 0);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "ch_prev":{
				if(colors.isEmpty()) return true;
				selcol--;
				if(selcol < 0) selcol = colors.size() - 1;
				select(selected, selcol);
				break;
			}
			case "ch_next":{
				if(colors.isEmpty()) return true;
				selcol++;
				if(selcol >= colors.size()) selcol = 0;
				select(selected, selcol);
				break;
			}
			case "rgb":{
				if(selected < 0 || selected >= (int)container.get("decos.size") || colors.isEmpty()) return true;
				TagCW com = TagCW.create();
				com.set("task", "color");
				com.set("idx", selected);
				com.set("channel", colors.get(selcol));
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
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "hex":{
				if(selected < 0 || selected >= (int)container.get("decos.size") || colors.isEmpty()) return true;
				TagCW com = TagCW.create();
				com.set("task", "color");
				com.set("idx", selected);
				com.set("channel", colors.get(selcol));
				RGB rgb = RGB.WHITE;
				try{
					rgb = new RGB(fields.get("hex").text());
				}
				catch(Exception e){
					e.printStackTrace();
				}
				com.set("rgb", rgb.packed);
				container.SEND_TO_SERVER.accept(com);
				break;
			}
			case "colorpicker":{
				if(selected < 0 || selected >= (int)container.get("decos.size") || colors.isEmpty()) return true;
				try{
					new Thread(){
						@Override
						public void run(){
							Color color = JColorChooser.showDialog(null, "select color", new Color(((DecorationData)container.get("decos.at", selected)).getColorChannel(colors.get(selcol)).packed));
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
			default:{
				found = false;
				break;
			}
		}
		if(!found){
			if(id.startsWith("entry_")){
				int idx = Integer.parseInt(id.substring(6));
				select(selected = scroll + idx, selcol);
				updateEntries();
				return true;
			}
			else if(id.startsWith("rem_")){
				int idx = Integer.parseInt(id.substring(4));
				TagCW com = TagCW.create();
				com.set("task", "rem");
				com.set("idx", scroll + idx);
				container.SEND_TO_SERVER.accept(com);
				return true;
			}
			else if(id.startsWith("pos")){
				int ax = Integer.parseInt(id.substring(3));
				TagCW com = TagCW.create();
				com.set("task", "pos");
				com.set("axis", ax);
				com.set("idx", selected);
				com.set("value", fields.get(id).number());
				container.SEND_TO_SERVER.accept(com);
				return true;
			}
			else if(id.startsWith("rot")){
				int ax = Integer.parseInt(id.substring(3));
				TagCW com = TagCW.create();
				com.set("task", "rot");
				com.set("axis", ax);
				com.set("idx", selected);
				com.set("value", fields.get(id).number());
				container.SEND_TO_SERVER.accept(com);
				return true;
			}
			else if(id.startsWith("scl")){
				int ax = Integer.parseInt(id.substring(3));
				TagCW com = TagCW.create();
				com.set("task", "scale");
				com.set("axis", ax);
				com.set("idx", selected);
				com.set("value", fields.get(id).number());
				container.SEND_TO_SERVER.accept(com);
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
			val += am > 0 ? -1 : 1;
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
			val += am > 0 ? -1 : 1;
			fields.get("scl" + ax).text(val + "");
			onAction(button, id, mx, my, 0);
			return true;
		}
		return false;
	}

	public void select(int idx, int colidx){
		selected = idx;
		colors.clear();
		int decos = (int)container.get("decos.size");
		DecorationData data = idx < 0 || idx >= decos ? null : (DecorationData)container.get("decos.at", idx);
		boolean miss = data == null;
		for(int i = 0; i < 3; i++){
			fields.get("pos" + i).text(miss ? "0" : (i == 0 ? data.offset.x : i == 1 ? data.offset.y : data.offset.z) + "");
			fields.get("rot" + i).text(miss ? "0" : (i == 0 ? data.rotx : i == 1 ? data.roty : data.rotz) + "");
			fields.get("scl" + i).text(miss ? "0" : (i == 0 ? data.sclx : i == 1 ? data.scly : data.sclz) + "");
		}
		texts.get("texc").value(miss ? "" : data.getCurrentTexture().name());
		selcol = colidx;
		if(!miss) colors.addAll(data.getColorChannels().keySet());
		if(selcol >= colors.size() || selcol < 0) selcol = 0;
		texts.get("channel").value(miss ? "" : colors.isEmpty() ? "gui.fvtm.decoration_editor.no_color_channels" : colors.get(selcol));
		texts.get("channel").translate();
		RGB color = miss || colors.isEmpty() ? RGB.WHITE : data.getColorChannel(colors.get(selcol));
		byte[] ar = color.toByteArray();
		fields.get("rgb").text((ar[0] + 128) + ", " + (ar[1] + 128) + ", " + (ar[2] + 128));
		fields.get("hex").text("#" + Integer.toHexString(color.packed));
	}

	public void updateEntries(){
		int j = 0;
		boolean over;
		for(int i = 0; i < rows; i++){
			j = scroll + i;
			over = j >= (int)container.get("decos.size");
			buttons.get("entry_" + i).text.value(over ? "" : "fvtm.decoration." + (String)container.get("decos.key", j));
			buttons.get("entry_" + i).text.translate();
			buttons.get("rem_" + i).visible(true);
			buttons.get("entry_" + i).enabled(selected != j);
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
		if(x > 1 && x < 139 && y > 20 && y < 188){
			scroll += a > 0 ? 1 : -1;
			if(scroll < 0) scroll = 0;
			updateEntries();
		}
	}

}
