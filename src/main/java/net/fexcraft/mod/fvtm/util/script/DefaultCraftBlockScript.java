package net.fexcraft.mod.fvtm.util.script;

import java.util.Collections;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TickableTE;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;

/**
 * Basic implementation of CraftBlockScript, enough on itself or to be used to extend.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultCraftBlockScript extends CraftBlockScript {
	
	protected boolean auto_recipe_chooser, instant, update_client;
	protected int cooldown, process_speed, cooldown_speed, process_time;
	
	public DefaultCraftBlockScript(JsonObject obj){
		auto_recipe_chooser = JsonUtil.getIfExists(obj, "auto_recipe_chooser", false);
		instant = JsonUtil.getIfExists(obj, "instant", false);
		cooldown = JsonUtil.getIfExists(obj, "cooldown", 0).intValue();
		process_speed = JsonUtil.getIfExists(obj, "process_speed", 1).intValue();
		cooldown_speed = JsonUtil.getIfExists(obj, "cooldown_speed", 1).intValue();
		update_client = JsonUtil.getIfExists(obj, "update_client", false);
		process_time = JsonUtil.getIfExists(obj, "process_time", 100).intValue();
	}

	@Override
	public boolean autoRecipeChooser(){
		return auto_recipe_chooser;
	}

	@Override
	public int cooldown(){
		return cooldown;
	}

	@Override
	public boolean instant(){
		return instant;
	}

	@Override
	public boolean ready(TickableTE tile){
		return true;
	}

	@Override
	public int process_speed(){
		return process_speed;
	}

	@Override
	public int cooldown_speed(){
		return cooldown_speed;
	}

	@Override
	public boolean update_client(){
		return false;
	}

	@Override
	public void prepare(TickableTE tile){
		//
	}

	@Override
	public void running(TickableTE tile){
		//
	}

	@Override
	public boolean consume(String id, int amount, boolean simulate){
		return true;
	}

	@Override
	public int process_time(){
		return process_time;
	}

	@Override
	public int getConsumable(String id){
		return 0;
	}

	@Override
	public String[] getConsumables(){
		return new String[0];
	}

	@Override
	public void setConsumable(String id, int value){
		//
	}

	@Override
	public List<Object[]> getGuiElements(){
		return Collections.emptyList();
	}

}
