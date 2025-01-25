package net.fexcraft.mod.fvtm.data;

import java.util.List;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.inv.ItemWrapper;
import net.fexcraft.mod.uni.inv.StackWrapper;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class Content<SELF> {

	protected IDL id;
	protected ItemWrapper item;
	protected List<String> description;
	protected String name;
	protected Addon pack;

	public abstract SELF parse(JsonMap map);

	public abstract ContentType getContentType();

	public abstract Class<?> getDataClass();

	public IDL getID(){
		return id;
	}

	public String getIDS(){
		return id.colon();
	}

	public String getName(){
		return name;
	}

	public Addon getAddon(){
		return pack;
	}

	public List<String> getDescription(){
		return description;
	}

	public void loadModel(){}

	public Model getModel(){
		return DefaultModel.EMPTY;
	}

	public void setItemWrapper(ItemWrapper item){
		this.item = item;
	}

	public ItemWrapper getItemWrapper(){
		return item;
	}

	public StackWrapper getNewStack(){
		return FvtmResources.INSTANCE.newStack(item);
	}

}
