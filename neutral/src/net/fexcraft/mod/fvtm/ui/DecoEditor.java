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
	private static ArrayList<DecorationData> results = new ArrayList<>();
	private static ArrayList<String> colors = new ArrayList<>();
	private static boolean listmode = true, search;
	private int scroll0, scroll1;
	public int selected = -1;
	public int selcol;
	private int category = 0;
	private String searchstr = "";

	public DecoEditor(JsonMap map, ContainerInterface con) throws Exception {
		super(map, con);
	}

	@Override
	public void init(){
		updateCategorySearch();
		select(-1, -1);
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		boolean found = true;
		switch(id){
			case "cat_prev":{
				category--;
				if(category < 0) category = 0;//DECORATION_CATEGORIES.size() - 1;
				updateCategorySearch();
				break;
			}
			case "cat_next":{
				category++;
				if(category >= /*DECORATION_CATEGORIES.size()*/0) category = 0;
				updateCategorySearch();
				break;
			}
			case "search":{
				search = !search;
				updateCategorySearch();
				break;
			}
			case "mode_add":{
				listmode = false;
				updateResults();
				break;
			}
			case "mode_list":{
				listmode = true;
				updateEntries();
				break;
			}
			case "list_up":{
				if(listmode) scroll0--;
				else scroll1--;
				if(scroll0 < 0) scroll0 = 0;
				if(scroll1 < 1) scroll1 = 0;
				updateEntries();
				break;
			}
			case "list_down":{
				if(listmode) scroll0++;
				else scroll1++;
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
				if(fields.get("search").visible()) return true;
				int idx = Integer.parseInt(id.substring(6));
				select(selected = scroll0 + idx, selcol);
				updateEntries();
				return true;
			}
			else if(id.startsWith("add_")){
				/*int idx = Integer.parseInt(id.substring(4));
				TagCW com = TagCW.create();
				com.set("task", "add");
				com.set("key", results.get(scroll1 + idx).key());
				container.SEND_TO_SERVER.accept(com);*///TODO
				return true;
			}
			else if(id.startsWith("rem_")){
				int idx = Integer.parseInt(id.substring(4));
				TagCW com = TagCW.create();
				com.set("task", "rem");
				com.set("idx", scroll1 + idx);
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

	protected void updateCategorySearch(){
		texts.get("cat").value("category");
		texts.get("cat").visible(!search);
		fields.get("search").visible(search);
		updateResults();
	}

	protected void updateResults(){
		results.clear();
		/*if(search){
			for(DecorationData deco : DECORATIONS.values()){
				if(deco.key().contains(searchstr) || ("fvtm.decoration." + deco.key()).contains(searchstr)) results.add(deco);
			}
		}
		else{
			String cat = DECORATION_CATEGORIES.get(category);
			for(DecorationData deco : DECORATIONS.values()){
				if(deco.category().equals(cat)) results.add(deco);
			}
		}*///TODO
		updateEntries();
	}

	public void updateEntries(){
		int j = 0;
		boolean over;
		if(listmode){
			for(int i = 0; i < rows; i++){
				j = scroll0 + i;
				over = j >= (int)container.get("decos.size");
				buttons.get("entry_" + i).text.value(over ? "" : "fvtm.decoration." + (String)container.get("decos.key", j));
				buttons.get("entry_" + i).text.translate();
				buttons.get("rem_" + i).visible(true);
				buttons.get("add_" + i).visible(false);
				buttons.get("entry_" + i).enabled(selected != j);
			}
		}
		else{
			for(int i = 0; i < rows; i++){
				j = scroll1 + i;
				over = j >= results.size();
				buttons.get("entry_" + i).text.value(over ? "" : "fvtm.decoration." + results.get(j).getType().getIDS());
				buttons.get("entry_" + i).text.translate();
				buttons.get("rem_" + i).visible(false);
				buttons.get("add_" + i).visible(true);
				buttons.get("entry_" + i).enabled(true);
			}
		}
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		if(!fields.get("search").visible()) return;
		if(!fields.get("search").text().equals(searchstr)){
			searchstr = fields.get("search").text();
			updateResults();
		}
	}

	@Override
	public void postdraw(float ticks, int mx, int my){
		//
	}

	@Override
	public void scrollwheel(int a, int x, int y){
		if(x > 1 && x < 139 && y > 20 && y < 188){
			if(listmode){
				scroll0 += a > 0 ? 1 : -1;
				if(scroll0 < 0) scroll0 = 0;
			}
			else{
				scroll1 += a > 0 ? 1 : -1;
				if(scroll1 < 0) scroll1 = 0;
			}
			updateEntries();
		}
	}

}
