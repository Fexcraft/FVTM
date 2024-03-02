package net.fexcraft.mod.fvtm.data.block;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.google.gson.JsonObject;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.util.script.FSBlockScript;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MultiBlockData {

	private MultiBlock0 type;
	private LinkedHashMap<String, InvHandler> inventories = new LinkedHashMap<>();
	private BlockScript script;
	
	public MultiBlockData(MultiBlock0 type){
		this.type = type;
		for(Entry<String, InvHandler> entry : type.getDefaultInventories().entrySet()){
			inventories.put(entry.getKey(), entry.getValue().gen(6));
		}
		try{
			script = type.hasScript() ? type.getScript().getConstructor(JsonObject.class).newInstance(type.getScriptData()) : null;
			if(script instanceof FSBlockScript){
				((FSBlockScript)script).init(this);
			}
		}
		catch(InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e){
			e.printStackTrace();
			Static.stop();
		}
	}
	
	public MultiBlockData(MultiBlock0 type, NBTTagCompound compound){
		this(type);
		this.read(compound);
	}
	
	public MultiBlockData read(NBTTagCompound compound){
		for(Entry<String, InvHandler> entry : inventories.entrySet()){
			String pre = entry.getValue().getBlkSavePrefix();
			if(!compound.hasKey(pre + entry.getKey())) continue;
			entry.getValue().load(new TagCWI(compound), pre + entry.getKey());
		}
		if(script != null){
			script.read(this, compound);
		}
		return this;
	}

	public MultiBlock0 getType(){
		return type;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(Entry<String, InvHandler> entry : inventories.entrySet()){
			String pre = entry.getValue().getBlkSavePrefix();
			entry.getValue().save(new TagCWI(compound), pre + entry.getKey());
		}
		if(script != null){
			script.write(this, compound);
		}
		compound.setString("type", type.getRegistryName().toString());
		return compound;
	}
	
	public BlockScript getScript(){
		return script;
	}

	public InvHandler getInventory(String inventory){
		return inventories.get(inventory);
	}

	public LinkedHashMap<String, InvHandler> getInventories(){
		return inventories;
	}

	public ItemStack newItemStack(){
		ItemStack stack = this.type.newItemStack();
		stack.setTagCompound(this.write(new NBTTagCompound()));
		return stack;
	}

}
