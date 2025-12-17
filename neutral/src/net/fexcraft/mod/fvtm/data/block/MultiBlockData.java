package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.data.ContentData;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.uni.tag.TagCW;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MultiBlockData extends ContentData<MultiBlock, MultiBlockData> {

	private LinkedHashMap<String, InvHandler> inventories = new LinkedHashMap<>();

	public MultiBlockData(MultiBlock mblock){
		super(mblock);
		for(Map.Entry<String, InvHandler> entry : type.getDefInventories().entrySet()){
			inventories.put(entry.getKey(), entry.getValue().gen(6));
		}
	}

	@Override
	public TagCW write(TagCW compound){
		if(compound == null) compound = TagCW.create();
		for(Map.Entry<String, InvHandler> entry : inventories.entrySet()){
			String pre = entry.getValue().getSavePrefix();
			entry.getValue().save(compound, pre + entry.getKey());
		}
		compound.set("type", type.getIDS());
		return compound;
	}

	@Override
	public MultiBlockData read(TagCW compound){
		for(Map.Entry<String, InvHandler> entry : inventories.entrySet()){
			String pre = entry.getValue().getSavePrefix();
			if(!compound.has(pre + entry.getKey())) continue;
			entry.getValue().load(compound, pre + entry.getKey());
		}
		return this;
	}

	@Override
	public MultiBlockData parse(JsonMap obj){
		return null;
	}

	@Override
	public JsonMap toJson(){
		return null;
	}

	public LinkedHashMap<String, InvHandler> getInventories(){
		return inventories;
	}

	public InvHandler getInventory(String invid){
		return inventories.get(invid);
	}

}
