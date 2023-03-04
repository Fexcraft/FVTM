package net.fexcraft.mod.fvtm.util.script;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.gui.block.GBCElm;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Basic implementation of CraftBlockScript, enough on itself or to be used to extend.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultCraftBlockScript extends CraftBlockScript {
	
	protected boolean auto_recipe_chooser, instant;//, update_client;
	protected int cooldown, process_speed, cooldown_speed, process_time;
	protected boolean add_def_ui, add_def_itemview, add_def_choose;
	
	public DefaultCraftBlockScript(JsonObject obj){
		auto_recipe_chooser = JsonUtil.getIfExists(obj, "auto_recipe_chooser", false);
		instant = JsonUtil.getIfExists(obj, "instant", false);
		cooldown = JsonUtil.getIfExists(obj, "cooldown", 0).intValue();
		process_speed = JsonUtil.getIfExists(obj, "process_speed", 1).intValue();
		cooldown_speed = JsonUtil.getIfExists(obj, "cooldown_speed", 1).intValue();
		//update_client = JsonUtil.getIfExists(obj, "update_client", false);//unused
		process_time = JsonUtil.getIfExists(obj, "process_time", 100).intValue();
		add_def_ui = JsonUtil.getIfExists(obj, "def_ui_elements", true);
		add_def_itemview = JsonUtil.getIfExists(obj, "def_ui_itemview", true);
		add_def_choose = JsonUtil.getIfExists(obj, "def_ui_choose", true);
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
	public boolean ready(MultiblockTickableTE tile){
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
	public void prepare(MultiblockTickableTE tile){
		//
	}

	@Override
	public void running(MultiblockTickableTE tile){
		//
	}

	@Override
	public boolean consume(MultiBlockData data, String id, int amount, boolean simulate){
		return true;
	}

	@Override
	public int process_time(){
		return process_time;
	}

	@Override
	public List<Object[]> getUIElements(BlockData bdata, MultiBlockData mdata){
		ArrayList list = new ArrayList();
		if(add_def_ui){
			if(bdata.getType().isTickable()){
				list.add(new Object[]{ GBCElm.ELM_LEFT_TEXT, "#status#" });
				list.add(new Object[]{ GBCElm.ELM_RIGHT_PROGRESS, "#progress#" });
			}
			list.add(new Object[]{ GBCElm.ELM_LEFT_TEXT, "gui.fvtm.block_craft.recipe" });
			list.add(new Object[]{ GBCElm.ELM_RIGHT_TEXT, "#recipe#" });
			if(add_def_itemview){
				list.add(new Object[]{ GBCElm.ITEMVIEW });
			}
			if(add_def_choose){
				addChooseElements(list);
			}
		}
		return list;
	}

	public static void addChooseElements(List list){
		list.add(new Object[]{ GBCElm.ELM_LEFT_BUTTON, "gui.fvtm.block_craft.choose", "#choose#" });
		list.add(new Object[]{ GBCElm.ELM_RIGHT_BUTTON, "gui.fvtm.block_craft.reset", "#reset#" });
	}

	@Override
	public void onUpdatePacket(TileEntity tile, NBTTagCompound compound){
		//
	}

}
