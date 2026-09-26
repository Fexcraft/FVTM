package net.fexcraft.mod.fvtm.ui;

import java.util.ArrayList;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import static net.fexcraft.lib.common.Static.sixteenth;

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
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		boolean found = true;
		switch(id){
			/*case "tex_prev":{
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
			}*/
			default:{
				found = false;
				break;
			}
		}
		if(!found){
			/*if(id.startsWith("entry_")){
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
			}*/
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
			texts.get("texture_selected").transval(sel.getTexture().isExternal() ? "" : sel.getTexture().getTexture().name());
			for(int i = 0; i < 3; i++){
				fields.get("pos_" + axes[i]).text((i == 0 ? sel.offset.x : i == 1 ? sel.offset.y : sel.offset.z) + "");
				fields.get("rot_" + axes[i]).text((i == 0 ? sel.rotx : i == 1 ? sel.roty : sel.rotz) + "");
				fields.get("scl_" + axes[i]).text((i == 0 ? sel.sclx : i == 1 ? sel.scly : sel.sclz) + "");
			}
		}
		if(!miss) colors.addAll(sel.getColorChannels().keySet());
		sel_col = 0;
		sel_uv = 0;
		texts.get("color_channel").transval(miss ? "" : colors.isEmpty() ? "gui.fvtm.decoration_editor.no_color_channels" : colors.get(sel_col));
		RGB color = miss || colors.isEmpty() ? RGB.WHITE : sel.getColorChannel(colors.get(sel_col));
		byte[] ar = color.toByteArray();
		fields.get("col_r").text((ar[0] + 128));
		fields.get("col_g").text((ar[1] + 128));
		fields.get("col_b").text((ar[2] + 128));
		fields.get("col_hex").text("#" + Integer.toHexString(color.packed));
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
		/*if(x > 1 && x < 139 && y > 20 && y < 188){
			scroll += a > 0 ? 1 : -1;
			if(scroll < 0) scroll = 0;
			updateEntries();
		}*/
	}

}
