package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireType extends Content<WireType> implements WithItem, ItemTextureable {

	protected String type;
	protected float def_slack;
	protected boolean customisable;
	protected IDL texture;
	protected IDL itemtexloc;
	protected Model model;
	protected ModelData modeldata;
	protected String modelid;
	protected String ctab;

	public WireType(){}

	@Override
	public WireType parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Wire");
		description = ContentConfigUtil.getStringList(map, "Description");
		type = map.getString("Type", "universal");
		def_slack = map.getFloat("Slack", Static.sixteenth);
		customisable = map.getBoolean("Customisable", true);
		texture = ContentConfigUtil.getTextures(map).get(0);
		if(EnvInfo.CLIENT){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
		itemtexloc = ContentConfigUtil.getItemTexture(id, ContentType.WIRE, map);
		ctab = map.getString("CreativeTab", "default");
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.WIRE;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	@Override
	public IDL getItemTexture(){
		return itemtexloc;
	}

	@Override
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	@Override
	public void loadModel(){
		model = FvtmResources.getModel(modelid, modeldata, WireModel.class);
	}

	@Override
	public WireModel getModel(){
		return (WireModel)model;
	}

	public float getDefaultSlack(){
		return def_slack;
	}

	public boolean isCustomisable(){
		return customisable;
	}

	public String getType(){
		return type;
	}

	public IDL getTexture(){
		return texture;
	}

}
