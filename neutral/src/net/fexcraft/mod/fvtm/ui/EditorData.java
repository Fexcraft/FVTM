package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.io.File;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.data.SignData.f;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EditorData {

	private static File editor_file;
	public static float[] RATES = new float[]{ sixteenth, 0.25f, 0.5f, 1f, 0.01f, 16f };
	public static float RATE = sixteenth;

	public static void load(){
		editor_file = new File(FvtmRegistry.CONFIG_DIR, "/fvtm/editor_data.fvtm");
		if(!editor_file.exists()) editor_file.getParentFile().mkdirs();
		try{
			if(!editor_file.exists()) return;
			JsonMap map = JsonHandler.parse(editor_file);
			RATE = map.getFloat("current_rate", sixteenth);
			if(map.has("rates")){
				JsonArray arr = map.getArray("rates");
				for(int i = 0; i < RATES.length; i++){
					if(i >= arr.size()) break;
					RATES[i] = arr.get(i).float_value();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void save(){
		try{
			JsonMap map = new JsonMap();
			map.add("current_rate", sixteenth);
			JsonArray arr = new JsonArray();
			for(int i = 0; i < RATES.length; i++){
				arr.add(RATES[i]);
			}
			map.add("rates", arr);
			JsonHandler.print(editor_file, map);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void updateRates(UserInterface ui){
		for(int i = 0; i < RATES.length; i++){
			ui.texts.get("rate_" + i).value(RATES[i] + "");
		}
	}

	public static boolean isRateButton(UserInterface ui, String id){
		switch(id){
			case "rate_set":{
				RATE = f(ui.fields.get("rate").number());
				return true;
			}
			case "rate_save":{
				for(int i = RATES.length - 1; i > 0; i--){
					RATES[i] = RATES[i - 1];
				}
				RATES[0] = f(ui.fields.get("rate").number());
				updateRates(ui);
				save();
				return true;
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
				ui.fields.get("rate").text(RATE);
				return true;
			}
			case "rate_0":
			case "rate_1":
			case "rate_2":
			case "rate_3":
			case "rate_4":
			case "rate_5":{
				RATE = RATES[Integer.parseInt(id.substring(5))];
				ui.fields.get("rate").text(RATE);
				return true;
			}
		}
		return false;
	}

}
