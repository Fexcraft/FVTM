package net.fexcraft.mod.fvtm.util.script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.sys.script.ScrAction;
import net.fexcraft.mod.fvtm.sys.script.Script;
import net.fexcraft.mod.fvtm.sys.script.elm.BoolElm;
import net.fexcraft.mod.fvtm.sys.script.elm.Elm;
import net.fexcraft.mod.fvtm.sys.script.elm.IntElm;
import net.fexcraft.mod.fvtm.sys.script.wrappers.BlockScriptContext;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Basic implementation of CraftBlockScript, enough on itself or to be used to extend.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultCraftBlockFS extends CraftBlockScript {
	
	protected FSBlockScript scriptwrapper;
	protected BlockScriptContext context;
	protected Script script;
	protected boolean hasPrepare, hasRunning, hasConsume, hasReady;
	protected ScrAction prepare, running, consume, ready;
	private boolean auto_recipe_chooser, instant;
	private Elm process_speed, cooldown_speed, process_time;
	private HashMap<String, Elm> consumables = new HashMap<>();
	private ArrayList<Object[]> uielms = new ArrayList<>();
	
	public DefaultCraftBlockFS(JsonObject obj){
		scriptwrapper = new FSBlockScript(obj);
	}

	@Override
	public void read(MultiBlockData data, NBTTagCompound tag){
		if(script == null){
			scriptwrapper.init(data.getData());
			script = scriptwrapper.script();
			context = scriptwrapper.context();
			//
			hasPrepare = (prepare = (ScrAction)script.blocks.get("prepare")) != null;
			hasRunning = (running = (ScrAction)script.blocks.get("running")) != null;
			hasConsume = (consume = (ScrAction)script.blocks.get("consume")) != null;
			hasReady = (ready = (ScrAction)script.blocks.get("ready")) != null;
			auto_recipe_chooser = script.getLocalScriptElm("auto_recipe_chooser", () -> new BoolElm(true)).bool_val();
			instant = script.getLocalScriptElm("instant", () -> new BoolElm(true)).bool_val();
			process_speed = script.getLocalScriptElm("process_speed", () -> new IntElm(1));
			cooldown_speed = script.getLocalScriptElm("cooldown_speed", () -> new IntElm(1));
			process_time = script.getLocalScriptElm("process_time", () -> new IntElm(100));
			context.exes.put("register", (block, args) -> {
				if(args.isEmpty()) return Elm.FALSE;
				Elm elm = script.getElm(args.get(0).string_val(), null);
				if(!elm.type().integer()) return Elm.FALSE;
				consumables.put(args.get(0).string_val(), elm);
				return Elm.TRUE;
			});
			context.exes.put("registerConsumable", context.exes.get("register"));
			context.exes.put("addGuiElement", (block, args) -> {
				String typestr = args.get(0).string_val();
				switch(typestr){
					case "text":{
						uielms.add(new Object[]{ GuiElement.TEXT, args.get(1).string_val()});
						break;
					}
					case "value":{
						uielms.add(new Object[]{ GuiElement.TEXT_VALUE, args.get(1).string_val(), args.get(2).string_val()});
						break;
					}
					case "progress":
					case "progressbar":{
						if(args.size() > 4){
							uielms.add(new Object[]{ GuiElement.PROGRESS_BAR, args.get(1).string_val(), args.get(2).string_val(), args.get(3).integer_val(), new RGB(args.get(4).string_val()) });
						}
						else{
							uielms.add(new Object[]{ GuiElement.PROGRESS_BAR, args.get(1).string_val(), args.get(2).string_val(), args.get(3).integer_val() });
						}
						break;
					}
					case "buttons":{
						//TODO
						break;
					}
				}
				return Elm.TRUE;
			});
			context.exes.put("sync", (block, args) -> {
				if(context.entity() == null || context.entity().getWorld().isRemote) return Elm.FALSE;
				NBTTagCompound compound = new NBTTagCompound();
				compound.setInteger("elm_sync", consumables.get(args.get(0).string_val()).integer_val());
				super.sendPacket(context.entity(), compound);
				return Elm.TRUE;
			});
			if(script.blocks.containsKey("init")){
				((ScrAction)script.blocks.get("init")).process(context);
			}
			Print.debug(script);
		}
		super.read(data, tag);
		for(Entry<String, Elm> entry : consumables.entrySet()){
			if(tag.hasKey("elm_" + entry.getKey())){
				entry.getValue().set(tag.getInteger("elm_" + entry.getKey()));
			}
		}
	}

	@Override
	public NBTTagCompound write(MultiBlockData data, NBTTagCompound compound){
		super.write(data, compound);
		for(Entry<String, Elm> entry : consumables.entrySet()){
			compound.setInteger("elm_" + entry.getKey(), entry.getValue().integer_val());
		}
		return compound;
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
		if(hasReady) return ready.process(context.update(tile)).bool_val();
		return true;
	}

	@Override
	public int process_speed(){
		return process_speed.integer_val();
	}

	@Override
	public int cooldown_speed(){
		return cooldown_speed.integer_val();
	}

	@Override
	public boolean update_client(){
		return false;
	}

	@Override
	public void prepare(MultiblockTickableTE tile){
		if(hasPrepare){
			prepare.process(scriptwrapper.context().update(tile));
		}
	}

	@Override
	public void running(MultiblockTickableTE tile){
		if(hasRunning){
			running.process(scriptwrapper.context().update(tile));
		}
	}

	@Override
	public boolean consume(String id, int amount, boolean simulate){
		if(!consumables.containsKey(id)) return false;
		if(hasConsume){
			return consume.process(scriptwrapper.context(), consumables.get(id), Elm.wrap(amount), Elm.wrap(simulate)).bool_val();
		}
		else{
			if(simulate) return consumables.get(id).integer_val() >= amount;
			else{
				Elm elm = consumables.get(id);
				elm.set(elm.integer_val() - amount);
				return true;
			}
		}
	}

	@Override
	public int process_time(){
		return process_time.integer_val();
	}

	@Override
	public int getConsumable(String id){
		return consumables.get(id).integer_val();
	}

	@Override
	public String[] getConsumables(){
		return consumables.keySet().toArray(new String[0]);
	}

	@Override
	public void setConsumable(String id, int value){
		Elm elm = consumables.get(id);
		elm.set(value);
	}

	@Override
	public List<Object[]> getGuiElements(){
		return uielms;
	}

	@Override
	public void onUpdatePacket(TileEntity tile, NBTTagCompound compound){
		if(tile.getWorld().isRemote){
			if(!compound.hasKey("elm_sync")) return;
			Elm elm = consumables.get("elm_sync");
			elm.set(compound.getInteger("value"));
		}
	}

}
