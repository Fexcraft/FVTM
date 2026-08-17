package net.fexcraft.mod.fvtm.ui.rail;

import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.UUID;

import static net.fexcraft.mod.uni.ui.ContainerInterface.SEND_TO_SERVER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RailPresetEditor extends UserInterface {

	private RailPresetEditorCon menu;
	private int selected = -1;

	public RailPresetEditor(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		menu = (RailPresetEditorCon)con;
	}

	@Override
	public void init(){
		selected = -1;
		if(menu.stack.directTag().has("fvtm:rail_preset")){
			RailGauge.Preset set = RailGauge.getPreset(menu.stack.directTag().getString("fvtm:rail_preset"));
			selected = RailGauge.PRESETS.indexOf(set);
		}
		select(selected);
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		switch(id){
			case "add":{
				RailPlacingUtil.createPreset(menu);
				select(RailGauge.PRESETS.size() - 1);
				return true;
			}
			case "import":{
				try{
					JsonMap map = JsonHandler.parse(root.getClipboard(), true).asMap();
					RailGauge.PRESETS.add(new RailGauge.Preset().load(map.getString("name", UUID.randomUUID().toString()), map));
					selected = RailGauge.PRESETS.size() - 1;
				}
				catch(Exception e){
					menu.player.entity.send("errors during preset import");
					e.printStackTrace();
				}
				return true;
			}
			case "export":{
				if(nosel()) return true;
				root.setClipboard(RailGauge.PRESETS.get(selected).save(true).toString());
				return true;
			}
			case "prev":{
				if(nosets()) return true;
				if(nosel()) select(0);
				else{
					if(selected - 1 < 0) select(RailGauge.PRESETS.size() - 1);
					else select(selected - 1);
				}
				return true;
			}
			case "next":{
				if(nosets()) return true;
				if(nosel()) select(0);
				else{
					if(selected + 1 >= RailGauge.PRESETS.size()) select(0);
					else select(selected + 1);
				}
				return true;
			}
			case "rem":{
				if(nosets() || nosel()) return true;
				RailGauge.PRESETS.remove(selected);
				if(RailGauge.PRESETS.isEmpty()){
					select(-1);
				}
				else{
					select(selected - 1 < 0 ? 0 : selected - 1);
				}
				return true;
			}
			case "on":{
				if(nosel()) return true;
				TagCW com = TagCW.create();
				com.set("task", "on");
				com.set("sel", RailGauge.PRESETS.get(selected).name);
				SEND_TO_SERVER.accept(com);
				return true;
			}
			case "off":{
				TagCW com = TagCW.create();
				com.set("task", "off");
				SEND_TO_SERVER.accept(com);
				return true;
			}
			case "save":{
				if(nosel()) return true;
				RailGauge.Preset set = RailGauge.PRESETS.get(selected);
				set.name = fields.get("name").text();
				RailGauge.savePresets();
				select(selected);
				return true;
			}
			case "s4":{
				if(nosel()) return true;
				RailGauge.Preset set = RailGauge.PRESETS.get(selected);
				set.rot = 4;
				texts.get("status").transval("ui.fvtm.rail_preset_editor.selected", set.name, selected, set.rot + "*");
				return true;
			}
			case "s8":{
				if(nosel()) return true;
				RailGauge.Preset set = RailGauge.PRESETS.get(selected);
				set.rot = 8;
				texts.get("status").transval("ui.fvtm.rail_preset_editor.selected", set.name, selected, set.rot + "*");
				return true;
			}
			case "16":{
				if(nosel()) return true;
				RailGauge.Preset set = RailGauge.PRESETS.get(selected);
				set.rot = 16;
				texts.get("status").transval("ui.fvtm.rail_preset_editor.selected", set.name, selected, set.rot + "*");
				return true;
			}
		}
		return false;
	}

	private boolean nosets(){
		if(RailGauge.PRESETS.isEmpty()){
			menu.player.entity.send("ui.fvtm.rail_preset_editor.no_presets");
			return true;
		}
		return false;
	}

	private boolean nosel(){
		if(selected < 0){
			menu.player.entity.send("ui.fvtm.rail_preset_editor.none_sel");
			return true;
		}
		return false;
	}

	private void select(int i){
		selected = i;
		TagCW com = TagCW.create();
		com.set("task", "sel");
		if(selected < 0 || selected > RailGauge.PRESETS.size()){
			texts.get("gauge").transval("ui.fvtm.rail_preset_editor.gauge", "none");
			texts.get("status").transval("ui.fvtm.rail_preset_editor.selected", "none", selected, 0);
			fields.get("name").text("");
			com.set("nosel", true);
		}
		else{
			RailGauge.Preset set = RailGauge.PRESETS.get(selected);
			texts.get("gauge").transval("ui.fvtm.rail_preset_editor.gauge", set.gauge.getName());
			texts.get("status").transval("ui.fvtm.rail_preset_editor.selected", set.name, selected, set.rot);
			fields.get("name").text(set.name);
			com.set("sel", set.name);
		}
		SEND_TO_SERVER.accept(com);
	}

}
