package net.fexcraft.mod.fvtm.data.block;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.util.script.FSBlockScript;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MultiBlockData {
	
	private MultiBlock type;
	private LinkedHashMap<String, InvHandler> inventories = new LinkedHashMap<>();
	private BlockScript script;
	private BlockData data;
	
	public MultiBlockData(BlockData data, MultiBlock block){
		this.type = block;
		this.data = data;
		for(Entry<String, InvHandler> entry : block.getInventories().entrySet()){
			inventories.put(entry.getKey(), entry.getValue().gen());
		}
		try{
			script = block.hasScript() ? block.getScript().getConstructor(JsonObject.class).newInstance(block.getScriptData()) : null;
			if(script instanceof FSBlockScript){
				((FSBlockScript)script).init(data);
			}
		}
		catch(InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e){
			e.printStackTrace();
			Static.stop();
		}
	}
	
	public MultiBlockData(BlockData data, NBTTagCompound compound){
		this(data, data.getType().getMultiBlock());
		this.read(compound);
	}
	
	public void read(NBTTagCompound compound){
		
		for(Entry<String, InvHandler> entry : inventories.entrySet()){
			String pre = entry.getValue().getBlkSavePrefix();
			if(!compound.hasKey(pre + entry.getKey())) continue;
			entry.getValue().load(compound, pre + entry.getKey());
		}
		if(script != null){
			script.read(this, compound);
		}
	}

	public MultiBlock getType(){
		return type;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(Entry<String, InvHandler> entry : inventories.entrySet()){
			String pre = entry.getValue().getBlkSavePrefix();
			entry.getValue().save(compound, pre + entry.getKey());
		}
		if(script != null){
			script.write(this, compound);
		}
		return compound;
	}
	
	public BlockScript getScript(){
		return script;
	}
	
	public BlockData getData(){
		return data;
	}

	public InvHandler getInventory(String inventory){
		return inventories.get(inventory);
	}

	public LinkedHashMap<String, InvHandler> getInventories(){
		return inventories;
	}

}
