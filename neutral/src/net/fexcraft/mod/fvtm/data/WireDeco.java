package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireDeco extends Content<WireDeco> {

	protected String type;
	protected IDL texture;
	protected Model model;
	protected ModelData modeldata;
	protected String modelid;
	protected List<String> accepts;

	public WireDeco(){}

	@Override
	public WireDeco parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Wire Decoration");
		description = ContentConfigUtil.getStringList(map, "Description");
		type = map.getString("Type", "relay");
		texture = ContentConfigUtil.getTextures(map).get(0);
		accepts = ContentConfigUtil.getStringList(map, "Accepts");
		if(EnvInfo.CLIENT || EnvInfo.is121()){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.WIREDECO;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	@Override
	public void loadModel(){
		model = FvtmResources.getModel(modelid, modeldata, WireModel.class);
	}

	@Override
	public WireModel getModel(){
		return (WireModel)model;
	}

	public String getType(){
		return type;
	}

	public IDL getTexture(){
		return texture;
	}

	public boolean accepts(String wiretype){
		return accepts.contains(wiretype);
	}

}
