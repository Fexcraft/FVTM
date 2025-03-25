package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.inv.ItemWrapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Sign extends Content<Sign> implements WithItem, Textureable.TextureHolder, Colorable.ColorHolder {

	protected ItemWrapper item;
	protected String ctab;
	protected String modelid;
	protected Model model;
	protected ModelData modeldata = new ModelData();
	protected List<IDL> textures;
	protected Map<String, RGB> channels = new LinkedHashMap<>();

	public Sign(){}

	@Override
	public Sign parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null)return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Sign");
		description = ContentConfigUtil.getStringList(map, "Description");
		//
		textures = ContentConfigUtil.getTextures(map);
		if(map.has("ColorChannels")){
			for(Map.Entry<String, JsonValue<?>> entry : map.get("ColorChannels").asMap().entries()){
				channels.put(entry.getKey(), new RGB(entry.getValue().string_value()));
			}
		}
		if(channels.isEmpty()) channels.put("primary", RGB.WHITE.copy());
		//
        ctab = map.getString("CreativeTab", "default");
		if(EnvInfo.CLIENT || EnvInfo.is121()){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.SIGN;
	}

	@Override
	public Class<?> getDataClass(){
		return DecorationData.class;
	}

	@Override
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	public Model getModel(){
		return model;
	}

	@Override
	public void loadModel(){
		model = FvtmResources.getModel(modelid, modeldata, DefaultModel.class);
	}

	@Override
	public RGB getDefaultColorChannel(String channel){
		return channels.get(channel);
	}

	@Override
	public Map<String, RGB> getDefaultColorChannels(){
		return channels;
	}

	@Override
	public List<IDL> getDefaultTextures(){
		return textures;
	}

}
